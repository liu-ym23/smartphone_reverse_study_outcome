package com.larus.voicecall.impl.component.top;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import c4a.l;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.BaseRealtimeTopComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.view.SceneModeButton;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.utils.e1;
import com.larus.utils.u;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.c;
import com.obric.aivoice.core.data.NameKeys;
import h88.b;
import i88.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m3a.d;
import m3a.f;
import m3a.g;
import m3a.h;
import m3a.i;
import m3a.j;
import w3a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020=H\u0016J(\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020BH\u0016J\b\u0010E\u001a\u000205H\u0016J\b\u0010F\u001a\u000205H\u0016J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010G\u001a\u00020HH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102¨\u0006J"}, d2 = {"Lcom/larus/voicecall/impl/component/top/RealtimeTopComponent;", "Lcom/larus/av_call/component/BaseRealtimeTopComponent;", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "viewBinding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "<init>", "(Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;)V", "getViewBinding", "()Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "voiceCallTopLayout", "Lcom/larus/av_call/view/VoiceCallTopLayout;", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "registerEventListener", "onUpdatePermission", "hasPermission", NameKeys.UnloadStrategy_No_Strategy, "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", NameKeys.UnloadStrategy_No_Strategy, "newMajorState", "newState", "onCloseSubtitle", "onOpenSubtitle", "getFlashlightIcon", "Landroid/widget/ImageView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeTopComponent extends BaseRealtimeTopComponent implements m3a.a {
    public static final /* synthetic */ int C = 0;
    public final Lazy A;
    public final Lazy B;
    public final LarusFragmentInstantCallBaseBinding s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public VoiceCallTopLayout z;

    public static final class a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.t.getValue();
    }

    @Override // m3a.a
    public final ImageView IF() {
        return (ImageView) this.s.a.findViewById(2131372908);
    }

    @Override // m3a.a
    public final void cu() {
        VoiceCallTopLayout r0 = this.z;
        if (r0 == null) goto L21;
        RealtimeCallUtil.a.getClass();
        boolean r1 = RealtimeCallUtil.k();
        boolean r6 = RealtimeCallUtil.M();
        l.a();
        if (r1 == false) goto L14;
        r0.h = false;
        Application r2 = e.a;
        CustomRoundImageView r3 = r0.a.e;
        ThemeType r4 = r0.b;
        boolean r5 = r0.c;
        b r7 = r0.l;
        if (r7 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        e.j(r3, r4, false, r5, r6, r8);
        goto L14
    L9:
        if (r7.r != true) goto L11;
        r8 = true;
    L14:
        if (r0.e == true) goto L16;
        return;
    L16:
        if (r0.b == ThemeType.MAIN_BOT) goto L23;
        c.c(r0.a.b, true, 300);
        c.c(r0.a.d, false, 300);
        View r9 = r0.f;
        if (r9 == null) goto L24;
        c.c(r9, true, 300);
        return;
    L24:
        return;
    L23:
        return;
    }

    public final e3a.a h3() {
        return (e3a.a) this.u.getValue();
    }

    @Override // m3a.a
    public final void kz() {
        VoiceCallTopLayout r0 = this.z;
        if (r0 == null) goto L21;
        RealtimeCallUtil.a.getClass();
        boolean r1 = RealtimeCallUtil.k();
        boolean r6 = RealtimeCallUtil.M();
        l.a();
        if (r1 == false) goto L14;
        r0.h = true;
        Application r2 = e.a;
        CustomRoundImageView r3 = r0.a.e;
        ThemeType r4 = r0.b;
        boolean r5 = r0.c;
        b r7 = r0.l;
        if (r7 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        e.j(r3, r4, true, r5, r6, r8);
        goto L14
    L9:
        if (r7.r != true) goto L11;
        r8 = true;
    L14:
        if (r0.e == true) goto L16;
        return;
    L16:
        if (r0.b == ThemeType.MAIN_BOT) goto L23;
        c.c(r0.a.b, false, 300);
        c.c(r0.a.d, true, 300);
        View r9 = r0.f;
        if (r9 == null) goto L24;
        c.c(r9, false, 300);
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, m3a.a.class);
    }

    public final void A0() {
        h3();
        e3a.b r0 = (e3a.b) this.v.getValue();
        RealtimeCallService r1 = (RealtimeCallService) this.w.getValue();
    }

    @Override // m3a.a
    public final VoiceCallTopLayout Fv() {
        return this.z;
    }

    public RealtimeTopComponent(LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.s = r2;
        this.t = LazyKt.lazy(new m3a.b(this));
        this.u = LazyKt.lazy(new m3a.c(this));
        this.v = LazyKt.lazy(new d(this));
        this.w = LazyKt.lazy(new m3a.e(this));
        this.x = LazyKt.lazy(new f(this));
        this.y = LazyKt.lazy(new g(this));
        this.A = LazyKt.lazy(new h(this));
        this.B = LazyKt.lazy(new i(this));
    }

    @Override // m3a.a
    public final void O1(boolean r5) {
        VoiceCallTopLayout r0 = this.z;
        if (r0 == null) goto L6;
        RealtimeCallUtil.a.getClass();
        r0.Z5(r5, RealtimeCallUtil.k(), RealtimeCallUtil.M(), l.a());
        return;
    }

    public final void onViewCreated(View r14) {
        Intrinsics.checkNotNullParameter(r14, "view");
        this.s.d.setLayoutResource(2131562430);
        ConstraintLayout r15 = this.s.d.inflate();
        VoiceCallTopLayout r2 = ViewBindings.findChildViewById(r15, 2131392674);
        if (r2 == null) goto L41;
        this.z = r2;
        ThemeType r3 = ((b) ((e3a.b) this.v.getValue())).i;
        String r4 = ((h88.a) h3()).c;
        if (((b) ((e3a.b) this.v.getValue())).h == true) goto L7;
    L9:
        boolean r5 = false;
    L10:
        g3a.a r16 = (g3a.a) this.x.getValue();
        if (r16 == null) goto L15;
        VoiceCallContentLayout r17 = r16.dg();
        if (r17 == null) goto L15;
        SceneModeButton r18 = r17.getRealtimeCallSceneButton();
    L16:
        SceneModeButton r6 = r18;
        Intrinsics.checkNotNull(r6);
        RealtimeCallUtil.a.getClass();
        boolean r7 = RealtimeCallUtil.k();
        Pair<Boolean, Boolean> r19 = com.larus.voicecall.impl.l.i;
        boolean r8 = com.larus.voicecall.impl.l.a.b(getContext());
        boolean r9 = RealtimeCallUtil.M();
        boolean r10 = l.a();
        e3a.b r11 = (e3a.b) this.v.getValue();
        com.larus.voicecall.impl.component.bottom.b r110 = (com.larus.voicecall.impl.component.bottom.b) this.y.getValue();
        if (r110 != null) goto L19;
    L21:
        boolean r12 = false;
    L22:
        r2.S5(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        int r111 = u.c(getActivity());
        ViewStub r0 = this.s.d;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L39;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r1;
        r13.topMargin = r111;
        r0.setLayoutParams(r13);
        if (((h88.a) h3()).k0 == false) goto L29;
        VoiceCallTopLayout r112 = this.z;
        if (r112 == null) goto L29;
        e1.o(r112);
    L29:
        k r113 = (k) this.B.getValue();
        if (r113 == null) goto L33;
        r113.c(new j(this));
    L33:
        if (((h88.a) h3()).k0 == false) goto L42;
        com.larus.voicecall.impl.component.scene.a r114 = (com.larus.voicecall.impl.component.scene.a) this.A.getValue();
        if (r114 == null) goto L43;
        r114.yM(new m3a.k(this));
        return;
    L43:
        return;
    L42:
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        if (r110.Z40() != true) goto L21;
        r12 = true;
    L15:
        r18 = null;
        goto L16
    L7:
        if (((h88.a) h3()).T == true) goto L9;
        r5 = true;
        goto L10
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(2131392674)));
    }

    public final void o1(MajorState r1, int r2, MajorState r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "currentMajorState");
        Intrinsics.checkNotNullParameter(r3, "newMajorState");
        MajorState.d r5 = ((RealtimeCallService) this.w.getValue()).h();
        if ((r5 instanceof MajorState.d) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L13;
        VoiceCallTopLayout r7 = this.z;
        if (r7 == null) goto L14;
        r7.T5(r5);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r5.c != MajorState.From.TTS_ENDED) goto L7;
        r6 = true;
        goto L8
    }
}
