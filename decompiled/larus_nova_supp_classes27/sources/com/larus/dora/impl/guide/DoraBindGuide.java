package com.larus.dora.impl.guide;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraGuideBindDeviceDialogBinding;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.dora.impl.guide.strategy.BasicDoraDeviceCheckStrategy;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraBindGuide implements t39.l {
    public static final /* synthetic */ int p = 0;
    public final String a;
    public final boolean b;
    public final long c;
    public final List<String> d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public FineDoraDeviceStrategy j;
    public BindBottomSheetDialogFragment k;
    public int l;
    public t39.m m;
    public LifecycleCoroutineScope n;
    public Job o;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "guide", "Lcom/larus/dora/impl/guide/DoraBindGuide;", "getGuide", "()Lcom/larus/dora/impl/guide/DoraBindGuide;", "setGuide", "(Lcom/larus/dora/impl/guide/DoraBindGuide;)V", "value", "Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment$Phase;", "phase", "getPhase", "()Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment$Phase;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGuideBindDeviceDialogBinding;", "getTheme", "", "goBindFail", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "Companion", "Phase", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BindBottomSheetDialogFragment extends BottomSheetDialogFragment {
        public static final /* synthetic */ int g = 0;
        public DoraBindGuide d;
        public Phase e;
        public LarusDoraGuideBindDeviceDialogBinding f;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment$Phase;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BindGuide", "BindFail", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Phase extends Enum<Phase> {
            public static final Phase BindFail = null;
            public static final Phase BindGuide = null;
            public static final /* synthetic */ Phase[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final String value;

            public static EnumEntries<Phase> getEntries() {
                return b;
            }

            static {
                Phase r0 = new Phase("BindGuide", 0, "bind_guide");
                BindGuide = r0;
                Phase r1 = new Phase("BindFail", 1, "bind_fail");
                BindFail = r1;
                Phase[] r2 = {r0, r1};
                a = r2;
                b = EnumEntriesKt.enumEntries(r2);
            }

            public static Phase[] values() {
                return (Phase[]) a.clone();
            }

            public final String getValue() {
                return this.value;
            }

            public static Phase valueOf(String r1) {
                return (Phase) r27.a.a(Phase.class, r1);
            }

            public Phase(String r1, int r2, String r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a {
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Phase.values().length];
                r0[Phase.BindGuide.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Phase.BindFail.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        static {
        }

        public final int getTheme() {
            return 2131951935;
        }

        public BindBottomSheetDialogFragment() {
            this.e = Phase.BindGuide;
        }

        public final void onDestroyView() {
            super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
            this.f = null;
        }

        public final void onCancel(DialogInterface r2) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
            DoraBindGuide r3 = this.d;
            if (r3 == null) goto L6;
            DoraBindGuide.h(r3, this.e);
            return;
        }

        public final void onDismiss(DialogInterface r3) {
            Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L8
            super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L8
            DoraBindGuide r4 = this.d;     // Catch: Throwable -> L8
            if (r4 == null) goto L5;
            int r0 = DoraBindGuide.p;     // Catch: Throwable -> L8
            g49.d.d("DoraBindGuide", "onDialogClosed() from dialog");     // Catch: Throwable -> L8
            r4.i(3);     // Catch: Throwable -> L8
        L6:
            LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
            PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
            LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
            return;
        L5:
            g49.d.b("BindBottomSheetDialogFragment", "Guide reference is null on destroy view");     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
            PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
            LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
            throw th;
        }

        public final void onViewCreated(View r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
            LarusDoraGuideBindDeviceDialogBinding r4 = this.f;
            if (r4 == null) goto L7;
            FrameLayout r5 = r4.a;
            if (r5 == null) goto L7;
            r5.post(new o(this));
        L7:
            LarusDoraGuideBindDeviceDialogBinding r6 = this.f;
            if (r6 == null) goto L11;
            e1.d(r6.c, new p(this));
            e1.d(r6.d, new q(this));
            return;
        }

        public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r2, "inflater");
            super/*androidx.fragment.app.Fragment*/.onCreateView(r2, r3, r4);
            LarusDoraGuideBindDeviceDialogBinding r5 = LarusDoraGuideBindDeviceDialogBinding.a(r2, r3);
            this.f = r5;
            return r5.a;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BindBottomSheetDialogFragment.Phase.values().length];
            r0[BindBottomSheetDialogFragment.Phase.BindGuide.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BindBottomSheetDialogFragment.Phase.BindFail.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraBindGuide", "startGuide() called");
        if (l() == true) goto L5;
        m(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraBindGuide.getGuideId();
    }

    public final BasicDoraDeviceCheckStrategy j() {
        return (BasicDoraDeviceCheckStrategy) this.f.getValue();
    }

    public final boolean l() {
        IDoraGuideService r0 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        if (r1 == false) goto L8;
        g49.d.d("DoraBindGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public final String toString() {
        return "DoraBindGuide(state=" + this.l + ')';
    }

    public static final void g(DoraBindGuide r3) {
        BindBottomSheetDialogFragment r0 = r3.k;
        if (r0 != null) goto L6;
        g49.d.d("DoraBindGuide", "dismissDialogIfNeeded() no-op: dialog is null");
        return;
    L6:
        if (r0.isAdded() == false) goto L14;
        g49.d.d("DoraBindGuide", "Dismissing BindBottomSheetDialogFragment");
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        r3.k = null;
        Job r2 = r3.o;
        if (r2 == null) goto L17;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L17:
        r3.o = null;
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        g49.d.d("DoraBindGuide", "setStateListener() called with " + r3);
        this.m = r3;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r18) {
        if ((r18 instanceof DoraBindGuide$isGuideConditionMet$1) == false) goto L7;
        DoraBindGuide$isGuideConditionMet$1 r2 = (DoraBindGuide$isGuideConditionMet$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L25;
        if (r4 == 1) goto L24;
        if (r4 == 2) goto L23;
        if (r4 == 3) goto L22;
        if (r4 == 4) goto L21;
        if (r4 != 5) goto L20;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L17
        String r8 = "DoraBindGuide";
    L79:
        boolean r1 = ((Boolean) r0).booleanValue();     // Catch: Exception -> L81
    L83:
        if (r1 == true) goto L86;
        g49.d.d(r8, "Bind guide condition not met: no dora device found");
        return Boxing.boxBoolean(false);
    L86:
        g49.d.d(r8, "Bind guide condition met");
        return Boxing.boxBoolean(true);
    L81:
        Exception e = e;
    L82:
        g49.d.c(r8, "HasDoraDeviceStrategy check failed, error=" + e.getMessage(), e);
        r1 = false;
    L17:
        e = e;
        r8 = "DoraBindGuide";
        goto L82
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        ResultKt.throwOnFailure(r0);
        r8 = "DoraBindGuide";
    L73:
        if (((Boolean) r0).booleanValue() == true) goto L90;
        g49.d.d(r8, "Bind guide condition not met: channel and user strategy not met");
        return Boxing.boxBoolean(false);
    L90:
        BasicDoraDeviceCheckStrategy r5 = j();     // Catch: Exception -> L81
        r2.label = 5;     // Catch: Exception -> L81
        r0 = r5.b(r2);     // Catch: Exception -> L81
        if (r0 != r11) goto L79;
        return r11;
    L22:
        ResultKt.throwOnFailure(r0);
        r8 = "DoraBindGuide";
    L66:
        if (((Boolean) r0).booleanValue() == true) goto L69;
        g49.d.d(r8, "Bind guide condition not met: server strategy not met");
        return Boxing.boxBoolean(false);
    L69:
        r2.label = 4;
        r0 = k(r2);
        if (r0 != r11) goto L73;
        return r11;
    L23:
        ResultKt.throwOnFailure(r0);
        r8 = "DoraBindGuide";
        int r15 = 3;
    L48:
        if (((Boolean) r0).booleanValue() == true) goto L51;
        g49.d.d(r8, "Bind guide condition not met: bluetooth permission not granted");
        return Boxing.boxBoolean(false);
    L51:
        Object r6 = AppHost.a.getApplication().getSystemService("audio");
        if ((r6 instanceof AudioManager) == false) goto L54;
        AudioManager r7 = (AudioManager) r6;
    L55:
        if (r7 != null) goto L59;
        g49.d.b(r8, "AudioManager is null, cannot determine A2DP state");
        return Boxing.boxBoolean(false);
    L59:
        if (r7.isBluetoothA2dpOn() == true) goto L62;
        g49.d.d(r8, "Bind guide condition not met: A2DP is off");
        return Boxing.boxBoolean(false);
    L62:
        com.larus.dora.impl.guide.strategy.f r9 = new com.larus.dora.impl.guide.strategy.f();
        r2.label = r15;
        r0 = r9.a();
        if (r0 != r11) goto L66;
        return r11;
    L54:
        r7 = null;
        goto L55
    L24:
        ResultKt.throwOnFailure(r0);
        Object r10 = r0;
        int r12 = 2;
        r15 = 3;
    L41:
        if (Intrinsics.areEqual((Boolean) r10, Boxing.boxBoolean(true)) == true) goto L44;
        g49.d.d("DoraBindGuide", "H device is not enabled");
        return Boxing.boxBoolean(false);
    L44:
        com.larus.dora.impl.guide.strategy.a r13 = (com.larus.dora.impl.guide.strategy.a) this.e.getValue();
        r2.label = r12;
        r13.getClass();
        r0 = com.larus.dora.impl.guide.strategy.a.c();
        if (r0 != r11) goto L48;
        return r11;
    L25:
        ResultKt.throwOnFailure(r0);
        if (AccountService.a.isLogin().booleanValue() == true) goto L30;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L30:
        if (l() == false) goto L34;
        return Boxing.boxBoolean(false);
    L34:
        if (this.b == true) goto L37;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: main bot guide not enabled");
        return Boxing.boxBoolean(false);
    L37:
        DoraSetting r14 = DoraSetting.a;
        Function0 r16 = new n();
        r2.label = 1;
        r12 = 2;
        r15 = 3;
        r10 = r14.b(5000, 100, "DoraBindGuide-updateConnectDeviceShouldShowState-isHDeviceEnabled", r16, r2);
        if (r10 != r11) goto L41;
        return r11;
    L7:
        r2 = new DoraBindGuide$isGuideConditionMet$1(this, r18);
        goto L8
    }

    public final void i(int r4) {
        if (this.l == r4) goto L5;
    L9:
        m(r4);
    L10:
        g49.d.d("DoraBindGuide", "Notify ready to show next guide from state=" + r4);
        t39.m r5 = this.m;
        if (r5 == null) goto L14;
        r5.a(this);
        return;
    L14:
        return;
    L5:
        if (r4 != 3) goto L7;
    L8:
        g49.d.d("DoraBindGuide", "completeWithState(" + r4 + ") ignored: already in final state");
        goto L10
    L7:
        if (r4 != 404) goto L9;
        goto L8
    }

    public final Object k(Continuation<? super Boolean> r9) {
        if ((r9 instanceof DoraBindGuide$isChannelOrUserStrategyHit$1) == false) goto L7;
        DoraBindGuide$isChannelOrUserStrategyHit$1 r0 = (DoraBindGuide$isChannelOrUserStrategyHit$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L38
    L36:
        boolean r11 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L38
    L40:
        if (r11 == true) goto L43;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: user is new or same-day first enter main bot page");
        return Boxing.boxBoolean(false);
    L43:
        g49.d.d("DoraBindGuide", "Bind guide channel or user strategy met");
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
    L30:
        if (((Boolean) r10).booleanValue() == true) goto L33;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: frequency interval not reached");
        return Boxing.boxBoolean(false);
    L33:
        com.larus.dora.impl.guide.strategy.d r12 = (com.larus.dora.impl.guide.strategy.d) this.g.getValue();     // Catch: Exception -> L38
        r0.label = 3;     // Catch: Exception -> L38
        r12.getClass();     // Catch: Exception -> L38
        r10 = com.larus.dora.impl.guide.strategy.d.a();     // Catch: Exception -> L38
        if (r10 != r2) goto L36;
        return r2;
    L18:
        ResultKt.throwOnFailure(r10);
    L23:
        if (((Boolean) r10).booleanValue() == false) goto L26;
        g49.d.d("DoraBindGuide", "ChannelStrategy allows, short-circuit to true");
        return Boxing.boxBoolean(true);
    L26:
        g49.d.d("DoraBindGuide", "isGuideConditionMet(), checking user strategy");
        com.larus.dora.impl.guide.strategy.c r13 = (com.larus.dora.impl.guide.strategy.c) this.h.getValue();
        r0.label = 2;
        r10 = r13.a();
        if (r10 != r2) goto L30;
        return r2;
    L19:
        ResultKt.throwOnFailure(r10);
        g49.d.d("DoraBindGuide", "isGuideConditionMet(), checking channel strategy");
        com.larus.dora.impl.guide.strategy.b r14 = (com.larus.dora.impl.guide.strategy.b) this.i.getValue();
        r0.label = 1;
        r10 = r14.a();
        if (r10 != r2) goto L23;
        return r2;
    L38:
        e = move-exception;
        g49.d.c("DoraBindGuide", "NotNewUserStrategy check failed, error=" + e.getMessage(), e);
        r11 = false;
    L7:
        r0 = new DoraBindGuide$isChannelOrUserStrategyHit$1(this, r9);
        goto L8
    }

    public final void m(int r4) {
        int r0 = this.l;
        if (r0 != r4) goto L5;
        return;
    L5:
        this.l = r4;
        g49.d.d("DoraBindGuide", "Guide state changed: prev=" + r0 + ", new=" + r4);
        t39.m r1 = this.m;
        if (r1 == null) goto L9;
        r1.b(this, r4, r0);
        return;
    }

    public static final void h(DoraBindGuide r3, BindBottomSheetDialogFragment.Phase r4) {
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        boolean r5 = ((com.larus.dora.impl.guide.strategy.b) r3.i.getValue()).c;
        String r6 = r4.getValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "phase");
        g49.d.d(DoraBuryPointManager.b, "reportBindGuideDismiss");
        r0.L("dora_bind_guide_dismiss_by_user", MapsKt.mapOf(new Pair[]{TuplesKt.to("hit_target_user_strategy", Boolean.valueOf(r5)), TuplesKt.to("bind_guide_phase", r6), TuplesKt.to("has_smart_audio", Boolean.valueOf(com.larus.dora.impl.util.h0.a()))}));
    }

    @Override // t39.l
    public final Object d(Fragment r6, View r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof DoraBindGuide$dismissGuide$1) == false) goto L7;
        DoraBindGuide$dismissGuide$1 r0 = (DoraBindGuide$dismissGuide$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L19
    L23:
    L22:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        g49.d.d("DoraBindGuide", "dismissGuide() called, fragment=" + r6 + ", anchorView=" + r7);
        MainCoroutineDispatcher r10 = Dispatchers.getMain();     // Catch: Exception -> L19
        DoraBindGuide$dismissGuide$2 r11 = new DoraBindGuide$dismissGuide$2(this, null);     // Catch: Exception -> L19
        r0.label = 1;     // Catch: Exception -> L19
        if (BuildersKt.withContext(r10, r11, r0) != r2) goto L23;
        return r2;
    L19:
        e = move-exception;
        g49.d.c("DoraBindGuide", "dismissGuide() failed with exception: " + e.getMessage(), e);
        i(404);
    L7:
        r0 = new DoraBindGuide$dismissGuide$1(this, r8);
        goto L8
    }

    @Override // t39.l
    public final Object e(Fragment r9, View r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof DoraBindGuide$showGuide$1) == false) goto L7;
        DoraBindGuide$showGuide$1 r0 = (DoraBindGuide$showGuide$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L48
    L51:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r9 = (Fragment) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L48
    L45:
        MainCoroutineDispatcher r13 = Dispatchers.getMain();     // Catch: Exception -> L48
        DoraBindGuide$showGuide$2 r14 = new DoraBindGuide$showGuide$2(r9, this, null);     // Catch: Exception -> L48
        r0.L$0 = null;     // Catch: Exception -> L48
        r0.label = 2;     // Catch: Exception -> L48
        if (BuildersKt.withContext(r13, r14, r0) != r2) goto L51;
        return r2;
    L19:
        ResultKt.throwOnFailure(r12);
        g49.d.d("DoraBindGuide", "showGuide() called, fragment=" + r9 + ", anchorView=" + r10);
        if (l() == true) goto L22;
        if (r9 == null) goto L25;
        LifecycleCoroutineScope r15 = LifecycleOwnerKt.getLifecycleScope(r9);
    L26:
        this.n = r15;
        if (r9 != null) goto L29;
    L52:
        g49.d.c("DoraBindGuide", "showGuide() skipped: fragment is null or detached", new IllegalArgumentException("fragment is null or detached"));
        i(404);
        return Unit.INSTANCE;
    L29:
        if (r9.isDetached() == true) goto L52;
        if (this.l != 2) goto L42;
        BindBottomSheetDialogFragment r16 = this.k;
        if (r16 != null) goto L36;
    L38:
        boolean r17 = false;
    L39:
        if (r17 == false) goto L42;
        g49.d.d("DoraBindGuide", "showGuide() ignored: guide already showing");
        return Unit.INSTANCE;
    L36:
        if (r16.isAdded() != true) goto L38;
        r17 = true;
    L42:
        ((com.larus.dora.impl.guide.strategy.c) this.h.getValue()).b();     // Catch: Exception -> L48
        com.larus.dora.impl.guide.strategy.b r18 = (com.larus.dora.impl.guide.strategy.b) this.i.getValue();     // Catch: Exception -> L48
        r0.L$0 = r9;     // Catch: Exception -> L48
        r0.label = 1;     // Catch: Exception -> L48
        if (r18.b() != r2) goto L45;
        return r2;
    L25:
        r15 = null;
        goto L26
    L22:
        return Unit.INSTANCE;
    L48:
        e = move-exception;
        g49.d.c("DoraBindGuide", "showGuide() failed with exception: " + e.getMessage(), e);
        i(404);
    L7:
        r0 = new DoraBindGuide$showGuide$1(this, r11);
        goto L8
    }

    public DoraBindGuide(String r2, boolean r3, long r4, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "page");
        Intrinsics.checkNotNullParameter(r6, "targetChannels");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = LazyKt.lazy(new i());
        this.f = LazyKt.lazy(new j());
        this.g = LazyKt.lazy(new k());
        this.h = LazyKt.lazy(new l(this));
        this.i = LazyKt.lazy(new m(this));
    }
}
