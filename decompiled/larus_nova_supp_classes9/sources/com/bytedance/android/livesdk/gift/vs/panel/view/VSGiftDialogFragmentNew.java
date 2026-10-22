package com.bytedance.android.livesdk.gift.vs.panel.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.matchroom.MatchLandFullShadowConstraintLayout;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.core.util.k;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.event.v;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftComboWidget;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.vs.panel.view.v2.LiveGiftBottomWidgetKt;
import com.bytedance.android.livesdk.gift.vs.panel.viewmodel.VSGiftDialogViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSGiftPannel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import zg1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/view/VSGiftDialogFragmentNew;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "La22/a;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftDialogFragmentNew extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b, a22.a {
    public static Disposable p;
    public Map<Integer, View> d;
    public boolean e;
    public VSGiftDialogViewModel f;
    public long g;
    public boolean h;
    public Context i;
    public DataCenter j;
    public GiftViewModelManager k;
    public LocateGiftInfo l;
    public final CompositeDisposable m;
    public final boolean n;
    public boolean o;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ VSGiftDialogFragmentNew a;

        public d(DataCenter r1, VSGiftDialogFragmentNew r2) {
            this.a = r2;
        }

        public final void accept(Object r4) {
            v r5 = (v) r4;
            DataCenter r0 = this.a.j;
            n01.a r1 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), n01.a.class);
            if (r1 == null) goto L5;
            boolean r2 = r1.p4();
        L6:
            if (r2 == true) goto L8;
            DataCenter r6 = this.a.j;
            return;
        L8:
            int r3 = d22.a.a;
            Intrinsics.checkNotNullParameter(r5, "rechargeSuccessEvent");
            HashMap r7 = new HashMap();
            r7.put("money", String.valueOf(r5.a));
            r7.put("given_scores", String.valueOf(r5.b));
            if (RechargeServices.a(RechargeServices.b()).h() != true) goto L11;
            String r8 = "1";
        L12:
            r7.put("is_first_recharge", r8);
            com.bytedance.android.live.revenue.core.a r9 = k.a();
            if (r9 == null) goto L19;
            n01.a r10 = com.bytedance.android.live.revenue.core.util.f.c(r9, n01.a.class);
            if (r10 == null) goto L20;
            r10.E0().sendLog("recharge_success", r7);
            return;
        L20:
            return;
        L19:
            return;
        L11:
            r8 = "0";
            goto L12
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VSGiftDialogFragmentNew a;

        public f(VSGiftDialogFragmentNew r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        }
    }

    public static final class h implements View.OnClickListener {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        }
    }

    static {
    }

    public final String getDegradeTag() {
        return com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL;
    }

    public final IVSGiftPanel V90() {
        IRoom r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).getRoom();
        if (r0 == null) goto L7;
        IEpisodeExtraInfo r1 = r0.getEpisodeExtra();
        if (r1 == null) goto L7;
        return r1.getVSGiftPanel();
    L7:
        return null;
    }

    public final boolean W90() {
        if (((d51) com.bytedance.android.livesdk.gift.platform.core.g.m.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[10])).n() == false) goto L5;
    L12:
        return true;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
    L11:
        return false;
    L7:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L11;
        if (e5.n() == false) goto L11;
        goto L11
    }

    public final int getActualContentWidth() {
        return i.b(375);
    }

    public final boolean onBackPressed() {
        DataCenter r0 = this.j;
        if (r0 == null) goto L5;
        r0.put("cmd_gift_dialog_switch", new f0((int) UIUtils.dip2Px(getContext(), 0.0f), false));
    L5:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return super.onBackPressed();
    }

    public VSGiftDialogFragmentNew() {
        this.d = new LinkedHashMap();
        setNoTitleAndCancelOutside(true);
        this.m = new CompositeDisposable();
        this.n = ((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.I.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[33])).booleanValue();
    }

    public final void dismiss() {
        if (W90() == false) goto L15;
        MatchRoomLandScapeAnimUtil.E.j("VSGiftDialogFragmentNew");
    L15:
        super.dismiss();     // Catch: Exception -> L7
    L11:
        DataCenter r0 = this.j;
        if (r0 == null) goto L17;
        r0.put("cmd_gift_dialog_switch", new f0((int) UIUtils.dip2Px(this.i, 0.0f), false));
        return;
    L17:
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    }

    public final void dismissAllowingStateLoss() {
        if (W90() == false) goto L15;
        MatchRoomLandScapeAnimUtil.E.j("VSGiftDialogFragmentNew");
    L15:
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        DataCenter r0 = this.j;
        if (r0 == null) goto L17;
        r0.put("cmd_gift_dialog_switch", new f0((int) UIUtils.dip2Px(this.i, 0.0f), false));
        return;
    L17:
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.o == false) goto L5;
        vh6.c.b(tq2.a.class).exitCleanScreen(6);
        jy0.b.a("VSGiftDialogFragmentNew", "Exit less half screen clean mode when views of dialog are destroyed");
    L5:
        com.bytedance.android.livesdk.gift.util.b.e(this);
        this.m.clear();
        ((LinkedHashMap) this.d).clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.k<Unit> r1 = r0.getHideDialog();
        if (r1 == null) goto L9;
        PublishSubject r2 = r1.onEvent();
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new f(this));
    L10:
        if (r3 == null) goto L13;
        this.m.add(r3);
        return;
    L13:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void U90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        super.onDismiss(r6);
        long r0 = this.g;
        DataCenter r7 = this.j;
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("stay_duration", String.valueOf((System.currentTimeMillis() - r0) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        w1 r1 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.g();
        if (r1 == null) goto L5;
        r3.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r1.getPageType()));
    L5:
        r3.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L11;
        m<String> r5 = r4.getGiftListResultLogId();
        if (r5 == null) goto L11;
        String r8 = (String) r5.getValue();
        if (r8 == null) goto L11;
    L12:
        r3.put("gift_dialog_request_id", r8);
        GiftContext r9 = com.bytedance.android.livesdk.gift.util.b.b();
        Integer r10 = null;
        if (r9 == null) goto L19;
        m<com.bytedance.android.livesdk.gift.platform.core.f0> r11 = r9.getRowLocation();
        if (r11 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.f0 r13 = (com.bytedance.android.livesdk.gift.platform.core.f0) r11.getValue();
        if (r13 == null) goto L19;
        Integer r14 = Integer.valueOf(r13.a);
    L20:
        r3.put("start_row_location", String.valueOf(r14));
        GiftContext r15 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r15 == null) goto L27;
        m<com.bytedance.android.livesdk.gift.platform.core.f0> r16 = r15.getRowLocation();
        if (r16 == null) goto L27;
        com.bytedance.android.livesdk.gift.platform.core.f0 r17 = (com.bytedance.android.livesdk.gift.platform.core.f0) r16.getValue();
        if (r17 == null) goto L27;
        r10 = Integer.valueOf(r17.b);
    L27:
        r3.put("end_row_location", String.valueOf(r10));
        r3.put("tab_leave_scene", com.bytedance.android.livesdk.gift.platform.core.utils.i.a(r7));
        n r18 = new n();
        Map r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r19.putAll(r3);
        mz0.m r20 = new mz0.m();
        r20.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r21 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r21, "pageSourceLog");
        ((ArrayList) r20.a).add(r21.a);
        ((ArrayList) r18.b).addAll(r20.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((f80.a) r24).w3("livesdk_tab_leave", r18.a, r18.b);
        return;
    L19:
        r14 = null;
    L11:
        r8 = BuildConfig.FLAVOR;
        goto L12
    }

    @Override // a22.a
    public final void X10(List<? extends w1> r3) {
        HSImageView r0 = S90(2131373766);
        if (r0 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r3).size() <= 1) goto L7;
        int r4 = 8;
    L8:
        r0.setVisibility(r4);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public final void onActivityCreated(Bundle r5) {
        ViewGroup.LayoutParams r0 = null;
        Dialog r1 = getDialog();     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();     // Catch: Exception -> L9
        if (r2 == null) goto L11;
        r2.setDimAmount(0.0f);     // Catch: Exception -> L9
    L11:
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L14;
        Window r7 = r6.getWindow();
    L15:
        boolean r3 = DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), isVertical(), this.h);
        if (r7 != null) goto L18;
    L63:
        setBottomSheetSlideProcessor(c.a);
        return;
    L18:
        if (isVertical() == true) goto L20;
    L24:
        r7.addFlags(1024);
    L26:
        if (isVertical() == false) goto L28;
        r7.setGravity(80);
    L29:
        r7.setSoftInputMode(48);
        if (PadConfigUtils.c() == false) goto L34;
        setBottomSheetSlideProcessor(b.a);
        PadConfigUtils.c();
        return;
    L34:
        if (this.e == false) goto L49;
        r7.setLayout(-1, -2);
        WindowManager.LayoutParams r4 = r7.getAttributes();
        r4.width = s1.y();
        r4.height = s1.w() - s1.A();
        r7.setAttributes(r4);
        View r8 = getView();
        if (r8 == null) goto L38;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L40:
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        View r10 = getView();
        if (r10 == null) goto L44;
        r0 = r10.getLayoutParams();
    L44:
        if (r0 == null) goto L46;
        r0.height = s1.w() - s1.A();
    L46:
        View r11 = getView();
        if (r11 == null) goto L63;
        r11.setLayoutParams(r0);
        goto L63
    L38:
        r9 = null;
        goto L40
    L49:
        r7.setLayout(-1, -1);
        View r13 = getView();
        if (r13 == null) goto L52;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L54:
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        View r15 = getView();
        if (r15 == null) goto L58;
        r0 = r15.getLayoutParams();
    L58:
        if (r0 == null) goto L60;
        r0.height = s1.s(getActivity());
    L60:
        View r16 = getView();
        if (r16 == null) goto L63;
        r16.setLayoutParams(r0);
        goto L63
    L52:
        r14 = null;
        goto L54
    L28:
        r7.setGravity(8388613);
        goto L29
    L20:
        if (this.h == true) goto L23;
        if (r3 == false) goto L24;
    L23:
        r7.clearFlags(1024);
        goto L26
    L14:
        r7 = null;
    L9:
        e = move-exception;
        jy0.b.c("VSGiftDialogFragmentNew", "request feature before set content, " + e.getMessage(), null, 4);
        goto L11
    }

    public final void onCreate(Bundle r14) {
        super.onCreate(r14);
        DataCenter r15 = this.j;
        if (r15 == null) goto L7;
        Boolean r16 = (Boolean) r15.get("data_is_portrait", Boolean.TRUE);
        if (r16 == null) goto L7;
        boolean r17 = r16.booleanValue();
    L9:
        if (r17 == true) goto L11;
    L13:
        boolean r18 = false;
    L14:
        setVertical(r18);
        if (isVertical() == true) goto L17;
    L21:
        boolean r19 = false;
    L22:
        this.e = r19;
        if (isVertical() == true) goto L25;
        setStyle(1, 2131954679);
    L30:
        FragmentActivity r110 = this.i;
        if ((r110 instanceof FragmentActivity) == true) goto L33;
        return;
    L33:
        if (r110 == null) goto L74;
        this.f = (VSGiftDialogViewModel) ViewModelProviders.of(r110).get(VSGiftDialogViewModel.class);
        DataCenter r111 = this.j;
        if (r111 == null) goto L76;
        n01.a r3 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), n01.a.class);
        long r4 = 0;
        if (r3 == null) goto L51;
        if (r3.X0() != true) goto L51;
        VSGiftDialogViewModel r7 = this.f;
        if (r7 == null) goto L63;
        Episode r0 = r3.jf();
        if (r0 == null) goto L45;
        long r8 = r0.getRoomIdExt();
    L46:
        Episode r1 = r3.jf();
        if (r1 == null) goto L49;
        r4 = r1.getIdExt();
    L49:
        r7.syncVSGuestList(r8, r4, 64);
        goto L63
    L45:
        r8 = 0;
    L63:
        Disposable r2 = p;
        if (r2 != null) goto L66;
    L68:
        Observable r5 = xs2.b.a().b(v.class);
        FragmentActivity r6 = this.i;
        if (r6 == null) goto L72;
        p = ((ObservableSubscribeProxy) r5.as(AutoDispose.bind(r6))).subscribe(new d(r111, this), e.a);
        return;
    L72:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L66:
        if (r2.isDisposed() == true) goto L68;
        r2.dispose();
    L51:
        if (x.c() == false) goto L54;
        int r11 = 32;
    L57:
        VSGiftDialogViewModel r9 = this.f;
        if (r9 == null) goto L63;
        IRoom r10 = x.a();
        if (r10 == null) goto L62;
        r4 = r10.getId();
    L62:
        r9.syncVSGuestList(r4, 0, r11);
        goto L63
    L54:
        if (x.d() == false) goto L56;
        r11 = 16;
        goto L57
    L56:
        r11 = 0;
        goto L57
    L76:
        return;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L25:
        if (this.e == false) goto L27;
        int r112 = 2131954681;
    L28:
        setStyle(1, r112);
        goto L30
    L27:
        r112 = 2131954677;
        goto L28
    L17:
        if (this.h == false) goto L19;
    L20:
        r19 = true;
        goto L22
    L19:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), isVertical(), this.h) == false) goto L21;
    L11:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L13;
        r18 = true;
    L7:
        r17 = true;
        goto L9
    }

    public final Dialog onCreateDialog(Bundle r9) {
        if (com.bytedance.android.livesdk.gift.util.a.b() == false) goto L9;
        Context r2 = getContext();
        if (r2 == null) goto L9;
        return new LiveStandardSheetDialog(r2, true, false, true, false, 16);
    L9:
        return super.onCreateDialog(r9);
    }

    public final void onDismiss(DialogInterface r2) {
        U90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void T90(VSGiftDialogFragmentNew r5, GiftStateMachineConfig.g r6) {
        DataCenter r0 = r5.j;
        Integer r1 = null;
        if (r0 == null) goto L12;
        IRoom r2 = gb2.a.e(r0);
        if (r2 == null) goto L12;
        if (r2.isVsLive() != true) goto L12;
        if (((Boolean) y12.b.e.getValue(null, y12.b.a[3])).booleanValue() == false) goto L12;
        return;
    L12:
        if ((r6 instanceof GiftStateMachineConfig.e.c) == false) goto L20;
        View r7 = r5.S90(2131373770);
        if (r7 == null) goto L16;
        r1 = Integer.valueOf(r7.getHeight());
    L16:
        int r8 = r1.intValue();
        DataCenter r9 = r5.j;
        if (r9 == null) goto L28;
        r9.put("cmd_gift_dialog_switch", new f0(r8, true));
        return;
    L28:
        return;
    L20:
        if ((r6 instanceof GiftStateMachineConfig.e.b) == false) goto L30;
        View r10 = r5.S90(2131373770);
        if (r10 == null) goto L24;
        r1 = Integer.valueOf(r10.getHeight());
    L24:
        int r11 = r1.intValue();
        DataCenter r13 = r5.j;
        if (r13 == null) goto L31;
        r13.put("cmd_gift_dialog_switch", new f0(r11, true));
        return;
    L31:
        return;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        if (W90() == false) goto L5;
        boolean r0 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y("VSGiftDialogFragmentNew", this, -1);
    L5:
        super.onViewCreated(r14, r15);
        if (this.k == null) goto L234;
        boolean r1 = true;
        if (isVertical() == false) goto L17;
    L31:
        Context r16 = this.i;
        LiveGiftComboWidget r4 = null;
        if ((r16 instanceof FragmentActivity) == true) goto L35;
        r16 = null;
    L35:
        if (((FragmentActivity) r16) == null) goto L232;
        View r17 = S90(2131387023);
        if (r17 == null) goto L39;
        r17.setVisibility(0);
    L39:
        View r18 = S90(2131367009);
        if (r18 == null) goto L42;
        r18.setOnClickListener(g.a);
    L42:
        MatchLandFullShadowConstraintLayout r19 = S90(2131373752);
        if (r19 == null) goto L46;
        r19.setOnClickListener(h.a);
    L46:
        if (PadConfigUtils.c() == true) goto L57;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L57;
        if (e5.n() == false) goto L57;
        ConstraintLayout r110 = S90(2131373747);
        if (r110 == null) goto L57;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L57;
        r111.width = (int) s1.e(375.0f);
    L57:
        if (isVertical() == false) goto L59;
    L64:
        boolean r112 = true;
    L66:
        if (r112 == false) goto L157;
        IVSGiftPanel r113 = V90();
        if (r113 == null) goto L71;
        py.k r114 = r113.getBackgroundBottom();
    L73:
        if (r114 != null) goto L75;
    L98:
        FrameLayout r115 = (FrameLayout) S90(2131373761);
        if (r115 == null) goto L101;
        r115.setVisibility(8);
    L101:
        com.bytedance.android.live.revenue.core.a r116 = k.a();
        if (r116 == null) goto L141;
        n01.a r117 = com.bytedance.android.live.revenue.core.util.f.c(r116, n01.a.class);
        if (r117 == null) goto L141;
        IEpisode r118 = r117.Xc();
        if (r118 == null) goto L141;
        VSGiftPannel r119 = r118.getGiftPanel();
        if (r119 == null) goto L141;
        List r120 = r119.colors;
        if (r120 == null) goto L141;
        if ((!r120.isEmpty()) == true) goto L115;
        r120 = null;
    L115:
        if (r120 == null) goto L141;
        if (r120.size() < 3) goto L119;
        int r3 = 3;
    L120:
        List r121 = r120.subList(0, r3);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r122 = r121.iterator();
    L122:
        if (r122.hasNext() == false) goto L127;
        r5.add(Integer.valueOf(Color.parseColor((String) r122.next())));
        goto L122
    L127:
        if (r5.isEmpty() == true) goto L157;
        if (r5.size() == 1) goto L157;
        GradientDrawable r123 = new GradientDrawable();
        r123.setColors(CollectionsKt.toIntArray(r5));
        if (PadConfigUtils.c() == false) goto L134;
    L137:
        float r11 = 8;
        float[] r6 = {i.a(r11), i.a(r11), i.a(r11), i.a(r11), i.a(r11), i.a(r11), i.a(r11), i.a(r11)};
    L138:
        r123.setCornerRadii(r6);
        r123.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        View r7 = S90(2131373770);
        if (r7 == null) goto L157;
        r7.setBackground(r123);
        goto L157
    L134:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L137;
        float r13 = 8;
        r6 = new float[]{i.a(r13), i.a(r13), i.a(r13), i.a(r13), 0.0f, 0.0f, 0.0f, 0.0f};
        goto L138
    L119:
        r3 = r120.size();
    L141:
        View r124 = S90(2131373770);
        if ((r124 instanceof HSImageView) == true) goto L144;
        r124 = null;
    L144:
        HSImageView r125 = (HSImageView) r124;
        if (r125 == null) goto L157;
        com.bytedance.android.live.revenue.core.a r8 = k.a();
        if (r8 == null) goto L155;
        n01.a r9 = com.bytedance.android.live.revenue.core.util.f.c(r8, n01.a.class);
        if (r9 == null) goto L155;
        IEpisode r10 = r9.Xc();
        if (r10 == null) goto L155;
        VSGiftPannel r20 = r10.getGiftPanel();
        if (r20 == null) goto L155;
        py.k r21 = r20.background;
    L156:
        X90(r125, r21, null);
        Unit r126 = Unit.INSTANCE;
    L155:
        r21 = null;
        goto L156
    L75:
        if (r114.isValid() != true) goto L98;
        IVSGiftPanel r127 = V90();
        if (r127 == null) goto L79;
        py.k r128 = r127.getBackgroundTop();
    L80:
        if (r128 == null) goto L98;
        if (r128.isValid() != true) goto L98;
        View r129 = S90(2131373770);
        if (r129 == null) goto L86;
        r129.setVisibility(8);
    L86:
        FrameLayout r130 = (FrameLayout) S90(2131373761);
        if (r130 == null) goto L89;
        r130.setVisibility(0);
    L89:
        HSImageView r131 = S90(2131373762);
        IVSGiftPanel r23 = V90();
        if (r23 == null) goto L92;
        py.k r24 = r23.getBackgroundBottom();
    L93:
        X90(r131, r24, null);
        HSImageView r132 = S90(2131373763);
        IVSGiftPanel r25 = V90();
        if (r25 == null) goto L96;
        py.k r26 = r25.getBackgroundTop();
    L97:
        X90(r132, r26, 0);
        goto L157
    L96:
        r26 = null;
        goto L97
    L92:
        r24 = null;
        goto L93
    L79:
        r128 = null;
        goto L80
    L71:
        r114 = null;
    L157:
        IVSGiftPanel r133 = V90();
        if (r133 == null) goto L160;
        py.k r134 = r133.getTopTitle();
    L161:
        if (r134 != null) goto L163;
    L173:
        com.bytedance.android.livesdk.gift.util.b.d("GiftListViewModel", this, new b22.a(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", this, new b22.b(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftTabViewModel", this, new b22.c(this), true);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.v(false, true, 3, false));
        WidgetManager r135 = WidgetManager.of(this, getView());
        r135.setDataCenter(this.j);
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L178;
        m<Boolean> r27 = r2.isVSPadUseVerticalStyle();
        if (r27 == null) goto L178;
        r27.setValue(Boolean.TRUE);
    L178:
        GiftViewModelManager r28 = this.k;
        if (r28 == null) goto L211;
        LiveGiftBottomWidgetKt r29 = new LiveGiftBottomWidgetKt(r28);
        r29.p = this;
        IVSGiftPanel r30 = V90();
        if (r30 == null) goto L183;
        py.k r31 = r30.getTopTitle();
    L184:
        if (r31 != null) goto L186;
    L188:
        boolean r33 = false;
    L189:
        r29.q = r33;
        r135.load(2131373668, r29);
        VSGiftListWidgetNew r34 = new VSGiftListWidgetNew(r28, this.f);
        IVSGiftPanel r35 = V90();
        if (r35 == null) goto L192;
        py.k r36 = r35.getBackgroundBottom();
    L193:
        if (r36 != null) goto L195;
    L204:
        boolean r37 = false;
    L205:
        r34.i = r37;
        Unit r38 = Unit.INSTANCE;
        r135.load(2131373738, r34);
        GiftContext r39 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r39 == null) goto L210;
        com.bytedance.live.datacontext.i<LiveGiftComboWidget> r40 = r39.getLiveGiftComboWidget();
        if (r40 == null) goto L210;
        r4 = (LiveGiftComboWidget) r40.getValue();
    L210:
        r135.load(2131373678, r4);
        goto L211
    L195:
        if (r36.isValid() != true) goto L204;
        IVSGiftPanel r41 = V90();
        if (r41 == null) goto L199;
        py.k r43 = r41.getBackgroundTop();
    L200:
        if (r43 == null) goto L204;
        if (r43.isValid() != true) goto L204;
        r37 = true;
        goto L205
    L199:
        r43 = null;
        goto L200
    L192:
        r36 = null;
        goto L193
    L186:
        if (r31.isValid() != true) goto L188;
        r33 = true;
        goto L189
    L183:
        r31 = null;
    L211:
        LocateGiftInfo r136 = this.l;
        if (r136 == null) goto L218;
        int r44 = r136.getTargetPageType();
        if (r136.getTargetPageType() == 0) goto L217;
        r1 = false;
    L217:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(r44, r1, 16));
    L218:
        LocateGiftInfo r137 = this.l;
        if (r137 == null) goto L221;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.j(r137));
    L221:
        LocateGiftInfo r138 = this.l;
        if (r138 == null) goto L241;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.LazyEvent(new GiftStateMachineConfig.Event.j(r138.setLocateSecond()), GiftStateMachineConfig.e.b.class));
        return;
    L241:
        return;
    L163:
        if (r134.isValid() != true) goto L173;
        HSImageView r45 = S90(2131373766);
        if (r45 == null) goto L168;
        r45.setVisibility(8);
    L168:
        HSImageView r139 = S90(2131373766);
        IVSGiftPanel r46 = V90();
        if (r46 == null) goto L171;
        py.k r47 = r46.getTopTitle();
    L172:
        X90(r139, r47, 0);
        goto L173
    L171:
        r47 = null;
        goto L172
    L160:
        r134 = null;
        goto L161
    L59:
        if (PadConfigUtils.c() == true) goto L64;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L64;
        r112 = false;
        goto L66
    L232:
        dismissAllowingStateLoss();     // Catch: Exception -> L226
        return;
    L226:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r140 = DialogFragmentLancet.sLastShowStack;
        if (r140 == null) goto L243;
        com.bytedance.crash.d.d(r140, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L243:
        return;
    L17:
        if (PadConfigUtils.c() == false) goto L20;
        PadConfigUtils.c();
        goto L31
    L20:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L31;
        n01.a r141 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), n01.a.class);
        if (r141 == null) goto L31;
        if (r141.X0() != true) goto L31;
        ConstraintLayout r142 = S90(2131373747);
        if (r142 == null) goto L28;
        ViewUtilsKt.d(r142, i.b(600));
    L28:
        ConstraintLayout r143 = S90(2131373747);
        if (r143 == null) goto L31;
        r143.setBackground(s1.m(2131250067));
        goto L31
    L234:
        dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r144 = DialogFragmentLancet.sLastShowStack;
        if (r144 == null) goto L239;
        com.bytedance.crash.d.d(r144, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == false) goto L18;
    L7:
        this.g = System.currentTimeMillis();
        if (this.n == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        this.o = r4;
        if (r4 == false) goto L20;
        vh6.c.b(tq2.a.class).enterCleanScreen(6);
        jy0.b.a("VSGiftDialogFragmentNew", "Enter less half screen clean mode when dialog is showed");
        return;
    L20:
        return;
    L10:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.d.class).Jc() == true) goto L12;
        r4 = true;
        goto L13
    L18:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L6:
        super.show(r2, r3);
        goto L7
    }

    public static void X90(HSImageView r9, py.k r10, Integer r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        int r1 = 2131250081;
        if (PadConfigUtils.c() == false) goto L7;
    L13:
        if (r11 == null) goto L15;
        r1 = r11.intValue();
    L15:
        ImageUtil.loadImageWithRadius(r9, r10, r1, 8);
        return;
    L7:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L13;
        if (r11 == null) goto L11;
        int r4 = r11.intValue();
    L12:
        ImageUtil.loadImageWithRadii(r9, r10, r4, 8.0f, 8.0f, 0.0f, 0.0f);
        return;
    L11:
        r4 = 2131250081;
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (PadConfigUtils.c() == true) goto L9;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L9;
        return r2.inflate(2131567965, r3, false);
    L9:
        return r2.inflate(2131567966, r3, false);
    }
}
