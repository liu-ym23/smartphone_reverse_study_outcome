package com.larus.bmhome.tipoff;

import android.R;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.view.FlowTagLayout;
import com.larus.bmhome.databinding.LarusDialogfragTipOffBinding;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.feedback.FeedbackServiceDelegate;
import com.obric.assistant.spi.feedback.ObricFeedbackPanelServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import po8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002JKB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000105H\u0016J$\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u0002072\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010>\u001a\u00020\u0006H\u0016J\b\u0010?\u001a\u00020\u0006H\u0002J\b\u0010@\u001a\u00020\u0006H\u0002J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0016\u0010B\u001a\u00020\u00062\f\u0010C\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\b\u0010D\u001a\u00020\u0006H\u0002J\b\u0010E\u001a\u00020\u0006H\u0002J\b\u0010F\u001a\u00020\u0006H\u0002J\u0010\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/bmhome/tipoff/TipOffDialogFragment;", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "showNow", "binding", "Lcom/larus/bmhome/databinding/LarusDialogfragTipOffBinding;", "model", "Lcom/larus/bmhome/tipoff/TipOffDialogViewModel;", "getModel", "()Lcom/larus/bmhome/tipoff/TipOffDialogViewModel;", "model$delegate", "Lkotlin/Lazy;", "launchInfo", "Landroidx/lifecycle/LiveData;", "Lcom/larus/bmhome/chat/api/LaunchInfoWithStatus;", "reportType", "entityId", "botId", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "previousPage", "conversationId", "serverIndex", "reportSource", "isImmersiveBackground", "commonMobParam", "successReportToastString", "overrideReportReason", "", "Lcom/larus/bmhome/auth/ReportReason;", "batchIds", "extraParams", "", "callback", "Lcom/larus/bmhome/tipoff/ITipOffDialogCallback;", "experiencePlanProvider", "Lcom/obric/assistant/spi/feedback/IObricExperiencePlanFeedbackProvider;", "setCallback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "initReasonList", "loadOnlineReasonList", "getLaunchReasonList", "renderReasonList", "metaList", "setupViewModel", "initView", "submit", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TipOffDialogFragment extends BaseTipOffDialog implements by7.e {
    public static final /* synthetic */ int w = 0;
    public LarusDialogfragTipOffBinding d;
    public final Lazy e;
    public final LiveData<e0> f;
    public int g;
    public String h;
    public String i;
    public RecommendFrom j;
    public SearchMobParam k;
    public String l;
    public String m;
    public int n;
    public String o;
    public String p;
    public String q;
    public List<com.larus.bmhome.auth.ReportReason> r;
    public List<String> s;
    public Map<String, String> t;
    public com.larus.bmhome.tipoff.a u;
    public nga.a v;

    public static final class a {
        public TipOffDialogParams a;

        public a() {
        }

        public final TipOffDialogFragment a() {
            TipOffDialogFragment r0 = new TipOffDialogFragment();
            r0.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("tip_off_params", this.a)}));
            return r0;
        }
    }

    public static final class b {
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(f r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final List<com.larus.bmhome.auth.ReportReason> U90() {
        int r0 = this.g;
        List<com.larus.bmhome.auth.ReportReason> r2 = null;
        if (r0 != 1) goto L5;
        e0 r1 = (e0) this.f.getValue();
        if (r1 == null) goto L34;
        LaunchInfo r3 = r1.a;
        if (r3 == null) goto L34;
        r2 = r3.k();
    L34:
        if (r2 == null) goto L36;
        return r2;
    L36:
        return CollectionsKt.emptyList();
    L5:
        if (r0 != 2) goto L7;
    L24:
        e0 r4 = (e0) this.f.getValue();
        if (r4 == null) goto L34;
        LaunchInfo r5 = r4.a;
        if (r5 == null) goto L34;
        r2 = r5.O0();
        goto L34
    L7:
        if (r0 == 18) goto L24;
        if (r0 != 25) goto L11;
    L19:
        e0 r6 = (e0) this.f.getValue();
        if (r6 == null) goto L34;
        LaunchInfo r7 = r6.a;
        if (r7 == null) goto L34;
        r2 = r7.O0();
        goto L34
    L11:
        if (r0 == 28) goto L24;
        switch(r0) {
            case 6: goto L14;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L34;
        };
    L14:
        e0 r8 = (e0) this.f.getValue();
        if (r8 == null) goto L34;
        LaunchInfo r9 = r8.a;
        if (r9 == null) goto L34;
        r2 = r9.k();
        goto L34
    }

    public TipOffDialogFragment() {
        final Function0<Fragment> r0 = new TipOffDialogFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TipOffDialogViewModel.class), new TipOffDialogFragment$special$$inlined$viewModels$default$2(r0), new TipOffDialogFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = AuthModelDelegate.b.e();
        this.h = "";
        this.i = "";
        this.l = "";
        this.m = "";
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.v = null;
        this.d = null;
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public static void T90(TipOffDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.bmhome.tipoff.BaseTipOffDialog
    public final void S90(com.larus.bmhome.tipoff.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.u = r2;
    }

    public final void V90(List<com.larus.bmhome.auth.ReportReason> r7) {
        List<com.larus.bmhome.auth.ReportReason> r0 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        com.larus.bmhome.auth.ReportReason r3 = (com.larus.bmhome.auth.ReportReason) r2.next();
        String r4 = r3.a();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1.add(new FlowTagLayout.a(r4, r3.b(), null));
        goto L4
    L9:
        LarusDialogfragTipOffBinding r5 = this.d;
        if (r5 == null) goto L17;
        final FlowTagLayout r6 = r5.f;
        if (r6 == null) goto L17;
        final MutableLiveData<Boolean> r8 = ((TipOffDialogViewModel) this.e.getValue()).getSubmitEnable();
        Intrinsics.checkNotNullParameter(r1, "tags");
        Intrinsics.checkNotNullParameter(r8, "isSelected");
        ((ArrayList) r6.p).clear();
        ((ArrayList) r6.p).addAll(r1);
        r6.removeAllViews();
        Iterator r9 = ((ArrayList) r6.p).iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        final FlowTagLayout.a r10 = (FlowTagLayout.a) r9.next();
        TextView r11 = r6.b(r10.a);
        r11.setTag(r10);
        r11.setOnClickListener(new m(r6, r10, r8));
        r6.addView(r11, new FrameLayout.LayoutParams(-2, -2));
    L17:
        FeedbackServiceDelegate.b.c(r7);
    }

    public final void fillTrackParams(TrackParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        SearchMobParam r0 = this.k;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L6:
        r4.putIfNull("query", r2);
        SearchMobParam r3 = this.k;
        if (r3 == null) goto L9;
        String r5 = r3.b;
    L10:
        r4.putIfNull("query_id", r5);
        SearchMobParam r6 = this.k;
        if (r6 == null) goto L13;
        String r7 = r6.c;
    L14:
        r4.putIfNull("search_id", r7);
        SearchMobParam r8 = this.k;
        if (r8 == null) goto L17;
        String r9 = r8.d;
    L18:
        r4.putIfNull("search_request_id", r9);
        SearchMobParam r10 = this.k;
        if (r10 == null) goto L21;
        String r11 = r10.e;
    L22:
        r4.putIfNull("search_result_id", r11);
        SearchMobParam r12 = this.k;
        if (r12 == null) goto L25;
        r1 = r12.f;
    L25:
        r4.putIfNull("rank", r1);
        return;
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        TipOffDialogParams r4 = (TipOffDialogParams) r3.getParcelable("tip_off_params");
        if (r4 == null) goto L10;
        this.g = r4.a;
        this.h = r4.b;
        this.j = r4.c;
        this.l = r4.e;
        this.m = r4.f;
        this.n = r4.g;
        this.k = r4.h;
        this.o = r4.i;
        String r0 = r4.j;
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        this.i = r0;
        this.p = r4.k;
        this.q = r4.l;
        this.r = r4.n;
        this.s = r4.m;
        this.t = r4.o;
    L10:
        setStyle(2, 2131953744);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.tipoff.f] */
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        ((TipOffDialogViewModel) this.e.getValue()).getSubmitEnable().observe(getViewLifecycleOwner(), new c(new f(this)));
        Dialog r9 = getDialog();
        if (r9 == null) goto L5;
        r9.setCanceledOnTouchOutside(true);
    L5:
        LarusDialogfragTipOffBinding r10 = this.d;
        if (r10 == null) goto L10;
        r10.c.setOnClickListener(new com.larus.bmhome.tipoff.c());
        r10.a.setOnClickListener(new d(this));
        r10.g.setOnClickListener(new e(this));
        r10.d.setHint(getString(2131905655));
        String r11 = FeedbackServiceDelegate.b.d();
        if (r11 == null) goto L10;
        r10.b.setText(r11);
    L10:
        List<com.larus.bmhome.auth.ReportReason> r12 = this.r;
        if (r12 == null) goto L14;
        V90(r12);
    L17:
        nga.a r13 = ObricFeedbackPanelServiceDelegate.b.b();
        this.v = r13;
        LarusDialogfragTipOffBinding r14 = this.d;
        if (r14 == null) goto L24;
        FrameLayout r15 = r14.e;
        if (r15 == null) goto L25;
        if (r13 == null) goto L26;
        r13.a(r15, getViewLifecycleOwner());
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L14:
        if (this.g != 8) goto L16;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TipOffDialogFragment$loadOnlineReasonList$1(this, null), 3, null);
        goto L17
    L16:
        V90(U90());
        goto L17
    }

    public final int show(FragmentTransaction r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "transaction");
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r5, r1);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, this, r1) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        return super.show(r4, r5);
    L17:
        return -1;
    L9:
        e = move-exception;
        FLogger.a.e("TipOffDialogFragment", "show error: " + e.getMessage(), e);
        return -1;
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        super.showNow(r3, r4);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.a.e("TipOffDialogFragment", "showNow error: " + e.getMessage(), e);
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        super.show(r3, r4);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.a.e("TipOffDialogFragment", "show error: " + e.getMessage(), e);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562112, r10, false);
        int r13 = 2131364848;
        RoundTextView r2 = ViewBindings.findChildViewById(r12, 2131364848);
        if (r2 == null) goto L26;
        r13 = 2131367771;
        RoundLinearLayout r3 = ViewBindings.findChildViewById(r12, 2131367771);
        if (r3 == null) goto L26;
        r13 = 2131368982;
        if (ViewBindings.findChildViewById(r12, 2131368982) == null) goto L26;
        r13 = 2131371800;
        NestedScrollEditText r4 = ViewBindings.findChildViewById(r12, 2131371800);
        if (r4 == null) goto L26;
        r13 = 2131371916;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131371916);
        if (r5 == null) goto L26;
        r13 = 2131373037;
        FlowTagLayout r6 = (FlowTagLayout) ViewBindings.findChildViewById(r12, 2131373037);
        if (r6 == null) goto L26;
        r13 = 2131375355;
        if (ViewBindings.findChildViewById(r12, 2131375355) == null) goto L26;
        r13 = 2131376107;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r12, 2131376107);
        if (r7 == null) goto L26;
        FrameLayout r14 = (FrameLayout) r12;
        LarusDialogfragTipOffBinding r15 = new LarusDialogfragTipOffBinding(r14, r2, r3, r4, r5, r6, r7);
        Dialog r16 = getDialog();
        if (r16 == null) goto L23;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L23;
        r17.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
    L23:
        this.d = r15;
        return r14;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
