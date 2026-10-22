package com.larus.dora.o.impl.diary;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.o.impl.databinding.DoraOFragmentDiaryContentBinding;
import com.larus.dora.o.impl.diary.calendar.ODiaryMonthCalendarDialog;
import com.larus.dora.o.impl.diary.week.OWeekCalendarBar;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.button.OButtonLink;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0004\u001d 58\u0018\u0000 [2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J&\u0010$\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020,H\u0002J\b\u0010:\u001a\u00020,H\u0002J\n\u0010;\u001a\u0004\u0018\u00010#H\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020,H\u0002J\b\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u00020,H\u0002J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020,H\u0002J\b\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u00020,H\u0002J\b\u0010D\u001a\u00020\u001bH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020\u0017H\u0002J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u0017H\u0002J\b\u0010I\u001a\u00020\u0017H\u0002J\b\u0010J\u001a\u00020#H\u0002J\u000e\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020#J\u0012\u0010M\u001a\u00020,2\b\u0010L\u001a\u0004\u0018\u00010#H\u0002J\b\u0010N\u001a\u00020,H\u0002J\b\u0010O\u001a\u00020,H\u0002J\u0010\u0010P\u001a\u00020,2\u0006\u00101\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020,H\u0002J\u0010\u0010S\u001a\u00020#2\u0006\u0010T\u001a\u00020#H\u0002J\b\u0010U\u001a\u00020,H\u0002J\b\u0010V\u001a\u00020,H\u0002J\b\u0010W\u001a\u00020,H\u0002J\b\u0010X\u001a\u00020,H\u0002J\b\u0010Y\u001a\u00020,H\u0002J\b\u0010Z\u001a\u00020,H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109¨\u0006\\"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryContentFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentDiaryContentBinding;", "viewModel", "Lcom/larus/dora/o/impl/diary/ODiaryViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/diary/ODiaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "weekBar", "Lcom/larus/dora/o/impl/diary/week/OWeekCalendarBar;", "calendarDialog", "Lcom/larus/dora/o/impl/diary/calendar/ODiaryMonthCalendarDialog;", "detailContentView", "Lcom/larus/avlink/api/IDoraDiaryDetailContentView;", "moreActionView", "Landroid/view/View;", "moreMenuPopover", "Lcom/obric/oui/popover/v2/OPopover;", "betaTopInset", "", "betaController", "Lcom/larus/dora/o/impl/diary/ODiaryBetaH5Controller;", "isBetaH5Mode", "", "betaEventListener", "com/larus/dora/o/impl/diary/ODiaryContentFragment$betaEventListener$1", "Lcom/larus/dora/o/impl/diary/ODiaryContentFragment$betaEventListener$1;", "betaHostState", "com/larus/dora/o/impl/diary/ODiaryContentFragment$betaHostState$1", "Lcom/larus/dora/o/impl/diary/ODiaryContentFragment$betaHostState$1;", "resolveBetaH5Url", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "applyEmbeddedTopSpacing", "applyH5State", "state", "Lcom/larus/dora/o/impl/diary/ODiaryBetaH5Controller$H5DiaryState;", "setupEnvObserveWatch", "sceneStateListener", "com/larus/dora/o/impl/diary/ODiaryContentFragment$sceneStateListener$1", "Lcom/larus/dora/o/impl/diary/ODiaryContentFragment$sceneStateListener$1;", "envObserveListener", "com/larus/dora/o/impl/diary/ODiaryContentFragment$envObserveListener$1", "Lcom/larus/dora/o/impl/diary/ODiaryContentFragment$envObserveListener$1;", "setupPermissionTips", "resolveDeviceMac", "isPermissionTipsShowing", "updatePermissionTips", "syncBetaContainerSpacing", "applyBetaTopSpacing", "isDeviceHomeDiary", "setupTitleBar", "setupWeekBar", "setupDetailBlackBox", "setupDetailH5", "isStandalone", "bottomReserveDp", "dp", "value", "resolveBizId", "resolveFirstScreenDate", "selectDiaryDate", "date", "notifyH5DateChanged", "setupDetailNative", "observeViewModel", "renderDetailState", "Lcom/larus/dora/o/impl/diary/ODiaryViewModel$DetailState;", "updateStatusCaption", "appendLastUpdate", "caption", "updateDateTitle", "showMoreMenu", "openMonthView", "showMonthCalendar", "tryDeleteCurrent", "onDestroyView", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryContentFragment extends Fragment {
    public static final SimpleDateFormat q = null;
    public DoraOFragmentDiaryContentBinding d;
    public final Lazy e;
    public OWeekCalendarBar f;
    public ODiaryMonthCalendarDialog g;
    public w88.s h;
    public View i;
    public com.obric.oui.popover.v2.c j;
    public int k;
    public f l;
    public final b m;
    public final c n;
    public final e o;
    public final d p;

    public static final class a {
    }

    public static final class b implements f.c {
        public final /* synthetic */ ODiaryContentFragment a;

        public b(ODiaryContentFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.dora.o.impl.diary.f.c
        public final void b(f.b r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            ODiaryContentFragment r0 = this.a;
            SimpleDateFormat r1 = ODiaryContentFragment.q;
            r0.U90().applyH5Stats(r5.b, r5.e);
            r0.da0();
            if (Intrinsics.areEqual(r5.f, "stats") == false) goto L5;
        L15:
            String r6 = (String) r0.U90().getSelectedDate().getValue();
            if (r6 != null) goto L18;
            r6 = r0.U90().todayDate();
        L18:
            r0.Y90(r6);
            return;
        L5:
            if (Intrinsics.areEqual(r5.f, "load") == true) goto L15;
            r0.U90().selectDateFromH5(r5.a);
            FragmentManager r7 = r0.getParentFragmentManager();
            Fragment r2 = r7.findFragmentByTag("dora_o_diary_month_view");
            if (r2 == null) goto L12;
            boolean r3 = true;
            if (r2.isVisible() != true) goto L12;
        L13:
            if (r3 == false) goto L20;
            r7.popBackStack();
            return;
        L20:
            return;
        L12:
            r3 = false;
            goto L13
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.dora.o.impl.diary.d] */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.dora.o.impl.diary.e] */
        @Override // com.larus.dora.o.impl.diary.f.c
        public final void a(final String r17, int r18, final l0 r110) {
            Intrinsics.checkNotNullParameter(r17, "diaryId");
            Intrinsics.checkNotNullParameter(r110, "target");
            ODiaryContentFragment r2 = this.a;
            final f r4 = r2.l;
            if (r4 == null) goto L30;
            Bundle r3 = r2.getArguments();
            if (r3 == null) goto L7;
            int r5 = r3.getInt("dora_o_diary_biz_id");
        L8:
            if (r5 > 0) goto L11;
            FlowDoraSubBizType.Companion.getClass();
            r5 = FlowDoraSubBizType.a.a();
        L11:
            int r6 = r5;
            Intrinsics.checkNotNullParameter(r17, "diaryId");
            Intrinsics.checkNotNullParameter(r110, "target");
            if (r18 != 0) goto L17;
            Context r7 = r4.a.getContext();
            if (r7 == null) goto L32;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.a.getViewLifecycleOwner()), null, null, new ODiaryBetaH5Controller$cancelFeedback$1(r17, r6, r110, r4, r7, null), 3, null);
            return;
        L32:
            return;
        L17:
            final Context r1 = r4.a.getContext();
            if (r1 == null) goto L33;
            i0 r10 = new i0(r1, LifecycleOwnerKt.getLifecycleScope(r4.a.getViewLifecycleOwner()), r17, r18, r6, r110, new com.larus.dora.o.impl.diary.d(r4, r1), new com.larus.dora.o.impl.diary.e(r4, r17, r110));
            OSheet r0 = r10.i;
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L28;
            DialogLancet.handleBlockedDialogShow(r0);
        L25:
            BuildersKt.launch$default(r10.b, null, null, new ODiaryFeedbackSheet$loadReasons$1(r10, null), 3, null);
            return;
        L28:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L24:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L25
        L33:
            return;
        L7:
            r5 = 0;
            goto L8
        }
    }

    public static final class c implements f.d {
        public final /* synthetic */ ODiaryContentFragment a;

        @Override // com.larus.dora.o.impl.diary.f.d
        public final boolean a() {
            ODiaryContentFragment r0 = this.a;
            SimpleDateFormat r1 = ODiaryContentFragment.q;
            if (r0.W90() == false) goto L7;
            if (r0.aa0() != null) goto L7;
        L9:
            return false;
        L7:
            if (r0.U90().isEnvObserveEnabled() == true) goto L9;
            return true;
        }

        @Override // com.larus.dora.o.impl.diary.f.d
        public final boolean b() {
            ODiaryContentFragment r0 = this.a;
            SimpleDateFormat r1 = ODiaryContentFragment.q;
            return r0.U90().isObserveSceneRunning();
        }

        public c(ODiaryContentFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements u39.b {
        public final /* synthetic */ ODiaryContentFragment a;

        public d(ODiaryContentFragment r1) {
            this.a = r1;
        }

        public final void a(boolean r2, final EnvObserveChangeReason r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            View r5 = this.a.getView();
            if (r5 == null) goto L6;
            final ODiaryContentFragment r6 = this.a;
            r5.post(new z(r3, r6));
            return;
        }
    }

    public static final class e implements b98.d {
        public final /* synthetic */ ODiaryContentFragment a;

        public e(ODiaryContentFragment r1) {
            this.a = r1;
        }

        public final void a(int r3, int r4) {
            if (r3 == 2) goto L5;
            return;
        L5:
            FLogger.a.i("ODiaryContentFragment", "env observe scene state=" + r4 + ", refresh caption");
            View r5 = this.a.getView();
            if (r5 == null) goto L9;
            final ODiaryContentFragment r6 = this.a;
            r5.post(new a0(r6));
            return;
        }
    }

    static {
        q = new SimpleDateFormat("HH:mm", Locale.getDefault());
    }

    public final ODiaryViewModel U90() {
        return (ODiaryViewModel) this.e.getValue();
    }

    public final boolean V90() {
        if (this.l == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void ca0() {
        DoraOFragmentDiaryContentBinding r0 = this.d;
        if (r0 == null) goto L18;
        LinearLayout r1 = r0.f;
        if (r1 == null) goto L18;
        int r2 = 0;
        if (W90() == false) goto L11;
        if (aa0() != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L17;
        r2 = 8;
    L17:
        r1.setVisibility(r2);
    L11:
        if (U90().isEnvObserveEnabled() == true) goto L13;
        r3 = true;
    L18:
        ba0();
    }

    public final void da0() {
        DoraOFragmentDiaryContentBinding r0 = this.d;
        if (r0 == null) goto L69;
        OFloatingTitleBar r1 = r0.b;
        if (r1 == null) goto L70;
        Context r2 = getContext();
        if (r2 != null) goto L10;
        return;
    L10:
        boolean r3 = V90();
        Object r4 = null;
        boolean r5 = true;
        int r6 = 2131101369;
        if (U90().isSelectedToday() == false) goto L20;
        if (U90().isObserveSceneRunning() == false) goto L20;
        String r7 = getString(2131902406);
        if (r3 == true) goto L18;
        r6 = 2131101356;
    L18:
        Pair r8 = TuplesKt.to(r7, Integer.valueOf(ContextCompat.getColor(r2, r6)));
    L29:
        String r9 = (String) r8.component1();
        int r10 = ((Number) r8.component2()).intValue();
        if (r3 == false) goto L65;
        f r11 = this.l;
        if (r11 == null) goto L65;
        String r12 = r11.g;
        if (r12 == null) goto L65;
        Long r13 = StringsKt.toLongOrNull(r12);
        if (r13 == null) goto L65;
        if (r13.longValue() <= 0) goto L40;
        boolean r14 = true;
    L41:
        if (r14 == true) goto L44;
        r13 = null;
    L44:
        if (r13 == null) goto L65;
        long r15 = r13.longValue();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L48
        Object r17 = Result.constructor-impl(q.format(new Date(r15)));     // Catch: Throwable -> L48
    L51:
        if (Result.isFailure-impl(r17) == true) goto L54;
        r4 = r17;
    L54:
        String r18 = (String) r4;
        if (r18 == null) goto L65;
        String r20 = getString(2131896105, new Object[]{r18});
        if (r9.length() == 0) goto L61;
        r5 = false;
    L61:
        if (r5 == true) goto L64;
        r20 = r9 + " · " + r20;
    L64:
        r9 = r20;
    L48:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L40:
        r14 = false;
    L65:
        r1.setStartSubtitle(r9);
        r1.setStartSubTitleColor(r10);
        return;
    L20:
        if (U90().isSelectedToday() == false) goto L22;
        r8 = TuplesKt.to(getString(2131903413), Integer.valueOf(ContextCompat.getColor(r2, 2131101369)));
        goto L29
    L22:
        Integer r22 = (Integer) U90().getTotalRecordDays().getValue();
        if (r22 == null) goto L25;
        String r23 = getString(2131903414, new Object[]{Integer.valueOf(r22.intValue())});
    L26:
        if (r23 != null) goto L28;
        r23 = "";
    L28:
        r8 = TuplesKt.to(r23, Integer.valueOf(ContextCompat.getColor(r2, 2131101369)));
        goto L29
    L25:
        r23 = null;
        goto L26
    L70:
        return;
    }

    public final void onDestroyView() {
        f r0 = this.l;
        if (r0 == null) goto L9;
        Context r2 = r0.a.getContext();
        if (r0.f == false) goto L8;
        if (r2 == null) goto L8;
        LocalBroadcastManager r3 = LocalBroadcastManager.getInstance(r2);
        r3.unregisterReceiver(r0.h);
        r3.unregisterReceiver(r0.i);
    L8:
        r0.f = false;
        r0.e = null;
    L9:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L14;
        com.larus.dora.impl.serviceimpl.r r4 = r1.g1();
        if (r4 == null) goto L14;
        r4.d(this.p);
    L14:
        IDoraAVLinkService r5 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r5 == null) goto L17;
        r5.v0(this.o);
    L17:
        super.onDestroyView();
        com.obric.oui.popover.v2.c r6 = this.j;
        if (r6 == null) goto L20;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
    L20:
        this.j = null;
        this.i = null;
        this.g = null;
        this.f = null;
        this.h = null;
        this.l = null;
        this.d = null;
    }

    public ODiaryContentFragment() {
        final Function0<Fragment> r0 = new ODiaryContentFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ODiaryViewModel.class), new ODiaryContentFragment$special$$inlined$viewModels$default$2(r0), new ODiaryContentFragment$special$$inlined$viewModels$default$3(r0, this));
        this.m = new b(this);
        this.n = new c(this);
        this.o = new e(this);
        this.p = new d(this);
    }

    public final void T90() {
        if (V90() == true) goto L5;
        return;
    L5:
        DoraOFragmentDiaryContentBinding r0 = this.d;
        if (r0 == null) goto L34;
        LinearLayout r1 = r0.f;
        if (r1 == null) goto L36;
        if (r0 == null) goto L35;
        FrameLayout r2 = r0.c;
        if (r2 == null) goto L37;
        int r3 = 0;
        if (r1.getVisibility() != 0) goto L17;
        boolean r4 = true;
    L18:
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L22:
        if (r6 == null) goto L29;
        if (r4 == false) goto L25;
        int r7 = this.k;
    L27:
        if (r6.topMargin == r7) goto L29;
        r6.topMargin = r7;
        r1.setLayoutParams(r6);
        goto L29
    L25:
        r7 = 0;
    L29:
        if (r4 == true) goto L32;
        r3 = this.k;
    L32:
        r2.setPadding(r2.getPaddingLeft(), r3, r2.getPaddingRight(), r2.getPaddingBottom());
        return;
    L21:
        r6 = null;
        goto L22
    L17:
        r4 = false;
        goto L18
    L37:
        return;
    L35:
        return;
    L36:
        return;
    }

    public final boolean W90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("dora_o_device_home_diary") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean X90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("dora_o_diary_show_back") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String aa0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("mac");
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        return r1;
    L14:
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L27;
        DeviceService r4 = r3.device();
        if (r4 != null) goto L20;
        return null;
    L20:
        if (W90() == false) goto L22;
        String r5 = r4.k();
        if (r4.M() == true) goto L26;
        return null;
    L26:
        return r5;
    L22:
        return r4.k();
    L27:
        return null;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void ba0() {
        if (V90() == true) goto L5;
        return;
    L5:
        DoraOFragmentDiaryContentBinding r0 = this.d;
        if (r0 == null) goto L31;
        FrameLayout r1 = r0.c;
        if (r1 == null) goto L32;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        DoraOFragmentDiaryContentBinding r4 = this.d;
        int r5 = 0;
        if (r4 == null) goto L23;
        LinearLayout r6 = r4.f;
        if (r6 == null) goto L23;
        if (r6.getVisibility() != 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
        Resources r8 = getResources();
        r5 = (int) ((8 * WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density) + 0.5f);
    L27:
        if (r3.topMargin == r5) goto L29;
        r3.topMargin = r5;
        r1.setLayoutParams(r3);
    L29:
        T90();
        return;
    L23:
        r7 = false;
        goto L24
    L13:
        r3 = null;
        goto L14
    L32:
        return;
    }

    public final void onResume() {
        super.onResume();
        da0();
        ca0();
        Z90((ODiaryViewModel.b) U90().getDetailState().getValue());
        if (V90() == false) goto L8;
        String r0 = (String) U90().getSelectedDate().getValue();
        if (r0 != null) goto L7;
        r0 = U90().todayDate();
    L7:
        Y90(r0);
    L8:
        U90().refreshBriefKeepingSelection();
    }

    public static final void S90(ODiaryContentFragment r8) {
        String r0 = (String) r8.U90().getSelectedDate().getValue();
        if (r0 != null) goto L5;
        r0 = com.larus.dora.o.impl.diary.calendar.a.b.format(new Date());
    L5:
        List r1 = StringsKt.split$default(r0, new String[]{"-"}, false, 0, 6, null);
        if (r1.size() < 3) goto L13;
        DoraOFragmentDiaryContentBinding r2 = r8.d;
        if (r2 == null) goto L14;
        OFloatingTitleBar r3 = r2.b;
        if (r3 == null) goto L15;
        r3.setStartTitle(r8.getString(2131903387, new Object[]{ListProtector.get(r1, 0), StringsKt.trimStart((String) ListProtector.get(r1, 1), new char[]{'0'}), StringsKt.trimStart((String) ListProtector.get(r1, 2), new char[]{'0'})}));
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void Y90(String r12) {
        f r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L27;
        FLogger.a.i("ODiaryBetaH5", "notify h5 date=" + r12);
        String r4 = "1";
        if (r0.d.b() == false) goto L16;
        Object r5 = "1";
    L18:
        if (r0.d.a() == true) goto L21;
        r4 = "0";
    L21:
        AbsWebFragment r1 = r0.e;
        if (r1 == null) goto L24;
        JSONObject r9 = new JSONObject();
        r9.put("date", r12);
        r9.put("observing", r5);
        r9.put("permission_tip", r4);
        Unit r10 = Unit.INSTANCE;
        r1.T90("dora.diary.selectDate", r9);
    L24:
        IXBridgeApi.a.b("dora.diary.selectDate", MapsKt.mapOf(new Pair[]{TuplesKt.to("date", r12), TuplesKt.to("observing", r5), TuplesKt.to("permission_tip", r4)}), null);
        return;
    L16:
        r5 = "0";
        goto L18
    L27:
        return;
    L7:
        if (r12.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    public final void Z90(ODiaryViewModel.b r6) {
        DoraOFragmentDiaryContentBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 8;
        if (V90() == false) goto L10;
        r0.e.setVisibility(8);
        r0.d.setVisibility(8);
        return;
    L10:
        if ((r6 instanceof ODiaryViewModel.b.e) == false) goto L20;
        r0.e.setVisibility(0);
        r0.d.setVisibility(8);
        w88.s r7 = this.h;
        if (r7 == null) goto L14;
        r7.clear();
    L14:
        w88.s r8 = this.h;
        if (r8 == null) goto L66;
        RecyclerView r9 = r8.getView();
        if (r9 == null) goto L67;
        r9.setVisibility(4);
        return;
    L67:
        return;
    L66:
        return;
    L20:
        if ((r6 instanceof ODiaryViewModel.b.a) == false) goto L30;
        r0.e.setVisibility(8);
        r0.d.setVisibility(8);
        w88.s r1 = this.h;
        if (r1 == null) goto L24;
        r1.a(((ODiaryViewModel.b.a) r6).b);
    L24:
        w88.s r10 = this.h;
        if (r10 == null) goto L69;
        RecyclerView r11 = r10.getView();
        if (r11 == null) goto L70;
        r11.setVisibility(0);
        return;
    L70:
        return;
    L69:
        return;
    L30:
        if ((r6 instanceof ODiaryViewModel.b.C0092b) == false) goto L51;
        r0.e.setVisibility(8);
        TextView r12 = r0.d;
        if (r0.f.getVisibility() == 0) goto L35;
        r2 = 0;
    L35:
        r12.setVisibility(r2);
        TextView r13 = r0.d;
        if (U90().isSelectedToday() == true) goto L39;
        int r3 = 2131903858;
    L42:
        r13.setText(getString(r3));
        w88.s r14 = this.h;
        if (r14 == null) goto L45;
        r14.clear();
    L45:
        w88.s r15 = this.h;
        if (r15 == null) goto L72;
        RecyclerView r16 = r15.getView();
        if (r16 == null) goto L73;
        r16.setVisibility(4);
        return;
    L73:
        return;
    L72:
        return;
    L39:
        if (U90().isObserveSceneRunning() == false) goto L41;
        r3 = 2131903429;
        goto L42
    L41:
        r3 = 2131903431;
        goto L42
    L51:
        if ((r6 instanceof ODiaryViewModel.b.c) == false) goto L61;
        r0.e.setVisibility(8);
        r0.d.setVisibility(0);
        r0.d.setText(getString(2131903403));
        w88.s r17 = this.h;
        if (r17 == null) goto L55;
        r17.clear();
    L55:
        w88.s r18 = this.h;
        if (r18 == null) goto L75;
        RecyclerView r20 = r18.getView();
        if (r20 == null) goto L76;
        r20.setVisibility(4);
        return;
    L76:
        return;
    L75:
        return;
    L61:
        if ((r6 instanceof ODiaryViewModel.b.d) == false) goto L65;
        r0.e.setVisibility(8);
        r0.d.setVisibility(8);
        return;
    L65:
        throw new NoWhenBranchMatchedException();
    }

    public final void onViewCreated(View r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r24, "view");
        super.onViewCreated(r24, r25);
        ODiaryViewModel r0 = U90();
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getInt("dora_o_diary_biz_id"));
    L6:
        r0.setDiaryBizId(r3);
        ODiaryViewModel r1 = U90();
        Bundle r4 = getArguments();
        if (r4 == null) goto L9;
        String r5 = r4.getString("dora_o_diary_date");
    L10:
        r1.setFirstScreenDate(r5);
        e10 r6 = e10.a;
        String r7 = e10.K0();
        if (r7.length() <= 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L19;
        f r9 = new f(this, r7, this.m, this.n);
    L20:
        this.l = r9;
        U90().setDetailRenderedByH5(V90());
        FLogger r10 = FLogger.a;
        r10.i("ODiaryContentFragment", "diary beta mode=" + V90());
        DoraOFragmentDiaryContentBinding r11 = this.d;
        if (r11 == null) goto L36;
        OFloatingTitleBar r12 = r11.b;
        if (r12 == null) goto L36;
        Bundle r13 = getArguments();
        if (r13 != null) goto L27;
    L29:
        boolean r14 = false;
    L30:
        if (r14 == false) goto L32;
        OFloatingTitleBar.k(r12, new t(this), 2);
    L32:
        View.OnClickListener r15 = new u(this);
        Token.Bounce r16 = OFloatingTitleBar.H0;
        r12.h(2131246226, -1, r15);
        if (V90() == true) goto L36;
        this.i = r12.h(2131246369, -1, new v(this));
        goto L36
    L27:
        if (r13.getBoolean("dora_o_diary_show_back") != true) goto L29;
        r14 = true;
    L36:
        if (V90() == false) goto L42;
        DoraOFragmentDiaryContentBinding r17 = this.d;
        if (r17 == null) goto L49;
        OWeekCalendarBar r18 = r17.h;
        if (r18 == null) goto L49;
        r18.setVisibility(8);
    L49:
        Bundle r20 = getArguments();
        if (r20 != null) goto L52;
    L54:
        boolean r21 = false;
    L56:
        if (r21 == true) goto L69;
        DoraOFragmentDiaryContentBinding r22 = this.d;
        if (r22 == null) goto L69;
        OFloatingTitleBar r23 = r22.b;
        if (r23 == null) goto L69;
        r23.R(false);
        r23.setMaskBlurRadius(0.0f);
        r23.setMaskBackground(new ColorDrawable(0));
        DoraOFragmentDiaryContentBinding r26 = this.d;
        if (r26 == null) goto L69;
        ConstraintLayout r27 = r26.a;
        if (r27 == null) goto L69;
        Resources r110 = getResources();
        final int r111 = (int) ((68 * WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).density) + 0.5f);
        ViewCompat.setOnApplyWindowInsetsListener(r27, new q(this, r111));
        ViewCompat.requestApplyInsets(r27);
    L69:
        DoraOFragmentDiaryContentBinding r28 = this.d;
        if (r28 == null) goto L74;
        OButtonLink r30 = r28.g;
        if (r30 == null) goto L74;
        r30.setOnClickListener(new k(this));
    L74:
        ca0();
        IDoraService r31 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r31 == null) goto L79;
        com.larus.dora.impl.serviceimpl.r r32 = r31.g1();
        if (r32 == null) goto L79;
        r32.a(this.p);
    L79:
        IDoraAVLinkService r33 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r33 == null) goto L82;
        r33.S0(this.o);
    L82:
        f r34 = this.l;
        if (r34 == null) goto L92;
        Context r112 = r34.a.getContext();
        if (r112 == null) goto L92;
        if (r34.f == true) goto L92;
        LocalBroadcastManager r113 = LocalBroadcastManager.getInstance(r112);
        r113.registerReceiver(r34.h, new IntentFilter("com.larus.dora.diary.DATE_CHANGED"));
        r113.registerReceiver(r34.i, new IntentFilter("com.larus.dora.diary.FEEDBACK"));
        r34.f = true;
    L92:
        if (V90() == false) goto L169;
        f r35 = this.l;
        if (r35 == null) goto L166;
        DoraOFragmentDiaryContentBinding r114 = this.d;
        if (r114 == null) goto L166;
        FrameLayout r115 = r114.c;
        if (r115 == null) goto L166;
        if (X90() == true) goto L104;
    L106:
        r115.setPadding(r115.getPaddingLeft(), r115.getPaddingTop(), r115.getPaddingRight(), 0);
        ba0();
        Bundle r116 = getArguments();
        if (r116 == null) goto L109;
        int r36 = r116.getInt("dora_o_diary_biz_id");
    L110:
        if (r36 > 0) goto L113;
        FlowDoraSubBizType.Companion.getClass();
        r36 = FlowDoraSubBizType.a.a();
    L113:
        Bundle r117 = getArguments();
        if (r117 == null) goto L125;
        String r37 = r117.getString("dora_o_diary_date");
        if (r37 == null) goto L125;
        if (r37.length() <= 0) goto L120;
        boolean r118 = true;
    L121:
        if (r118 == true) goto L124;
        r37 = null;
    L124:
        if (r37 == null) goto L125;
    L126:
        int r119 = m0.a;
        if (X90() == false) goto L129;
        int r120 = 34;
    L130:
        Intrinsics.checkNotNullParameter(r115, "container");
        Intrinsics.checkNotNullParameter(r37, "firstScreenDate");
        Context r121 = r35.a.getContext();
        if (r121 == null) goto L157;
        AiChatHostWebService r122 = AiChatHostWebService.a;
        AbsWebFragment r38 = r122.a(null);
        if (r38 != null) goto L211;
        r10.e("ODiaryBetaH5", "host web fragment unavailable, fallback to native detail");
        goto L157
    L211:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L148
        Uri.Builder r41 = UriProtector.parse(r35.b).buildUpon().appendQueryParameter("date", r37).appendQueryParameter("biz_id", String.valueOf(r36)).appendQueryParameter("entry", "diary_page");     // Catch: Throwable -> L148
        String r42 = "1";
        if (r35.d.b() == false) goto L141;
        String r43 = "1";
    L142:
        Uri.Builder r44 = r41.appendQueryParameter("observing", r43);     // Catch: Throwable -> L148
        if (r35.d.a() == true) goto L146;
        r42 = "0";
    L146:
        Object r45 = Result.constructor-impl(r44.appendQueryParameter("permission_tip", r42).appendQueryParameter("bottom_reserve", String.valueOf(r120)).build().toString());     // Catch: Throwable -> L148
    L151:
        if (Result.exceptionOrNull-impl(r45) == null) goto L154;
        FLogger.a.w("ODiaryBetaH5", "build url failed, use raw url");
        r45 = r35.b;
    L154:
        Bundle r46 = r122.c(new zt8.b((String) r45, false, false, Integer.valueOf(ContextCompat.getColor(r121, 2131101351)), false, 100));
        if (r46 != null) goto L158;
        FLogger.a.e("ODiaryBetaH5", "web fragment arguments null, fallback to native detail");
        goto L157
    L158:
        r38.setArguments(r46);
        r35.e = r38;
        FragmentTransaction r47 = r35.a.getChildFragmentManager().beginTransaction();
        int r48 = r115.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r47, r38, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "dora_o_diary_beta_web", r48) == true) goto L162;
        r47.replace(r48, r38, "dora_o_diary_beta_web");
    L162:
        r47.commit();
        FLogger.a.i("ODiaryBetaH5", "h5 detail mounted");
        boolean r50 = true;
    L163:
        if (r50 == false) goto L166;
        DoraGResourceServiceDelegate.b.c();
        boolean r51 = true;
    L167:
        if (r51 == false) goto L169;
    L209:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiaryContentFragment$observeViewModel$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiaryContentFragment$observeViewModel$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiaryContentFragment$observeViewModel$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ODiaryContentFragment$observeViewModel$4(this, null), 3, null);
        U90().loadFirstPage();
        return;
    L141:
        r43 = "0";
    L148:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
    L157:
        r50 = false;
        goto L163
    L129:
        r120 = 100;
        goto L130
    L120:
        r118 = false;
    L125:
        r37 = U90().todayDate();
        goto L126
    L109:
        r36 = 0;
        goto L110
    L104:
        if (this.k != 0) goto L106;
        Resources r123 = getResources();
        this.k = (int) ((112 * WindowDisplayMetricsOverride.apply(r123, r123.getDisplayMetrics()).density) + 0.5f);
    L166:
        r51 = false;
    L169:
        IDoraAVLinkService r53 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r53 == null) goto L209;
        w88.s r54 = r53.s1(requireContext(), this);
        if (r54 == null) goto L209;
        this.h = r54;
        boolean r55 = X90();
        int r56 = m0.a;
        if (r55 == false) goto L176;
        int r124 = 34;
    L177:
        if (r55 == false) goto L179;
        int r125 = 34;
    L180:
        Resources r57 = getResources();
        float r58 = WindowDisplayMetricsOverride.apply(r57, r57.getDisplayMetrics()).density;
        ViewGroup r60 = r54.getView();
        if ((r60 instanceof ViewGroup) == true) goto L184;
        r60 = null;
    L184:
        if (r60 == null) goto L186;
        r60.setClipToPadding(false);
        r60.setPadding(r60.getPaddingLeft(), r60.getPaddingTop(), r60.getPaddingRight(), (int) ((r124 * r58) + 0.5f));
    L186:
        int r61 = (int) ((r125 * r58) + 0.5f);
        DoraOFragmentDiaryContentBinding r62 = this.d;
        if (r62 == null) goto L195;
        TextView r63 = r62.d;
        if (r63 == null) goto L195;
        ViewGroup.LayoutParams r64 = r63.getLayoutParams();
        if (r64 == null) goto L194;
        FrameLayout.LayoutParams r65 = (FrameLayout.LayoutParams) r64;
        r65.bottomMargin = r61;
        r63.setLayoutParams(r65);
        goto L195
    L194:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L195:
        DoraOFragmentDiaryContentBinding r66 = this.d;
        if (r66 == null) goto L204;
        ProgressBar r67 = r66.e;
        if (r67 == null) goto L204;
        ViewGroup.LayoutParams r68 = r67.getLayoutParams();
        if (r68 == null) goto L203;
        FrameLayout.LayoutParams r70 = (FrameLayout.LayoutParams) r68;
        r70.bottomMargin = r61;
        r67.setLayoutParams(r70);
        goto L204
    L203:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L204:
        DoraOFragmentDiaryContentBinding r71 = this.d;
        if (r71 == null) goto L209;
        FrameLayout r72 = r71.c;
        if (r72 == null) goto L209;
        r72.addView(r54.getView(), 0, new ViewGroup.LayoutParams(-1, -1));
        goto L209
    L179:
        r125 = 84;
        goto L180
    L176:
        r124 = 100;
        goto L177
    L52:
        if (r20.getBoolean("dora_o_diary_show_back") != true) goto L54;
        r21 = true;
        goto L56
    L42:
        DoraOFragmentDiaryContentBinding r73 = this.d;
        if (r73 == null) goto L47;
        OWeekCalendarBar r74 = r73.h;
        if (r74 == null) goto L47;
        r74.setOnDayClick(new r(this));
        r74.setOnReachHistoryEdge(new s(this));
    L48:
        this.f = r74;
    L47:
        r74 = null;
        goto L48
    L19:
        r9 = null;
        goto L20
    L13:
        r8 = false;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131560143, r11, false);
        int r14 = 2131367859;
        OFloatingTitleBar r2 = ViewBindings.findChildViewById(r13, 2131367859);
        if (r2 == null) goto L19;
        r14 = 2131368887;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131368887);
        if (r3 == null) goto L19;
        r14 = 2131368890;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131368890);
        if (r4 == null) goto L19;
        r14 = 2131368896;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r13, 2131368896);
        if (r5 == null) goto L19;
        r14 = 2131382171;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131382171);
        if (r6 == null) goto L19;
        r14 = 2131382172;
        OButtonLink r7 = ViewBindings.findChildViewById(r13, 2131382172);
        if (r7 == null) goto L19;
        r14 = 2131393147;
        OWeekCalendarBar r8 = (OWeekCalendarBar) ViewBindings.findChildViewById(r13, 2131393147);
        if (r8 == null) goto L19;
        ConstraintLayout r15 = r13;
        this.d = new DoraOFragmentDiaryContentBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
