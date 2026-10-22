package com.larus.voicecall.impl.component.content;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import c4a.f;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.BaseRealtimeContentComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.view.SceneModeButton;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.view.ZoomableTextureView;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.CallInstructionModel;
import com.larus.im.bean.bot.SceneModel;
import com.larus.image.loader.b0;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.databinding.LarusLayoutRealtimeCallContentBinding;
import com.larus.voicecall.impl.l;
import com.larus.voicecall.impl.scene.m;
import com.larus.voicecall.impl.scene.o;
import com.larus.voicecall.impl.subtitle.RealtimeCallScreenShareLayout;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.subtitle.SubtitleInterpretLayout;
import com.larus.voicecall.impl.subtitle.j;
import com.larus.voicecall.impl.ui.VoiceCallBgLayout;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.ui.VoiceCallVideoView;
import com.larus.voicecall.impl.ui.a0;
import com.larus.voicecall.impl.ui.c0;
import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.t0;
import com.obric.aivoice.core.data.NameKeys;
import g3a.c;
import g3a.d;
import g3a.e;
import g3a.g;
import g3a.i;
import g3a.k;
import g3a.n;
import g3a.p;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import ouc.v;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000207H\u0016J\u0010\u00109\u001a\u0002072\u0006\u0010:\u001a\u000200H\u0016J\b\u0010;\u001a\u000207H\u0002J\b\u0010<\u001a\u000207H\u0002J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u000207H\u0002J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\n\u0010C\u001a\u0004\u0018\u000100H\u0016J\u0012\u0010D\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\n\u0010G\u001a\u0004\u0018\u00010HH\u0016J\n\u0010I\u001a\u0004\u0018\u000100H\u0016J\n\u0010J\u001a\u0004\u0018\u00010KH\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\n\u0010N\u001a\u0004\u0018\u000100H\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\n\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010U\u001a\u0002072\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J(\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020Z2\u0006\u0010^\u001a\u00020\\H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b3\u00104¨\u0006`"}, d2 = {"Lcom/larus/voicecall/impl/component/content/RealtimeContentComponent;", "Lcom/larus/av_call/component/BaseRealtimeContentComponent;", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "viewBinding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "<init>", "(Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;)V", "getViewBinding", "()Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "interviewAbility", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "getInterviewAbility", "()Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "interviewAbility$delegate", "voiceCallContentLayout", "Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout;", "contentContainer", "Landroid/view/View;", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "onViewCreated", "view", "registerPageHeightChange", "registerEventListener", "onUpdatePermission", "hasPermission", NameKeys.UnloadStrategy_No_Strategy, "updateContentContainerBottomMargin", "takePhotoAni", "Lcom/facebook/drawee/view/SimpleDraweeView;", "takePhotoAniBg", "updateSubtitleInstructionArea", "selectedSceneItem", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "realtimeCallSubtitleLayout", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout;", "realtimeCallCover", "realtimeCallScreenShareLayout", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallScreenShareLayout;", "callBgLayout", "Lcom/larus/voicecall/impl/ui/VoiceCallBgLayout;", "smallViewPortPH", "realtimeCallNetworkHotArea", "Lcom/larus/common_ui/view/ZoomableTextureView;", "focusView", "Landroidx/appcompat/widget/AppCompatImageView;", "floatSubtitleContainer", "Landroid/widget/FrameLayout;", "switchAvatar", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", NameKeys.UnloadStrategy_No_Strategy, "newMajorState", "newState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeContentComponent extends BaseRealtimeContentComponent implements g3a.a {
    public static final /* synthetic */ int D = 0;
    public VoiceCallContentLayout A;
    public ConstraintLayout B;
    public final Lazy C;
    public final LarusFragmentInstantCallBaseBinding s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements j {
        public final /* synthetic */ RealtimeContentComponent a;

        @Override // com.larus.voicecall.impl.subtitle.j
        public final void a() {
            RealtimeCallUtil.a.getClass();
            o r0 = RealtimeCallUtil.l;
            if (r0 == null) goto L10;
            SceneModel r2 = r0.a;
            if (r2 == null) goto L11;
            RealtimeContentComponent r1 = this.a;
            m r7 = new m(r2, 0, null, false, false);
            int r3 = RealtimeContentComponent.D;
            com.larus.voicecall.impl.component.scene.a r4 = (com.larus.voicecall.impl.component.scene.a) r1.y.getValue();
            if (r4 == null) goto L12;
            r4.R3(r7, Random.Default.nextInt(1, Integer.MAX_VALUE));
            return;
        L12:
            return;
        L11:
            return;
        }

        public b(RealtimeContentComponent r1) {
            this.a = r1;
        }
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.t.getValue();
    }

    @Override // g3a.a
    public final RealtimeCallScreenShareLayout Df() {
        return (RealtimeCallScreenShareLayout) this.s.a.findViewById(2131392666);
    }

    @Override // g3a.a
    public final FrameLayout In() {
        return (FrameLayout) this.s.a.findViewById(2131372915);
    }

    @Override // g3a.a
    public final AppCompatImageView Km() {
        return this.s.a.findViewById(2131373052);
    }

    @Override // g3a.a
    public final VoiceCallBgLayout Nl() {
        return (VoiceCallBgLayout) this.s.a.findViewById(2131383797);
    }

    @Override // g3a.a
    public final View Tt() {
        return this.s.a.findViewById(2131376658);
    }

    @Override // g3a.a
    public final ZoomableTextureView iB() {
        return this.s.a.findViewById(2131383814);
    }

    @Override // g3a.a
    public final View iZ() {
        return this.s.a.findViewById(2131386942);
    }

    @Override // g3a.a
    public final SimpleDraweeView kj() {
        return this.s.a.findViewById(2131376657);
    }

    public final e3a.a m3() {
        return (e3a.a) this.u.getValue();
    }

    @Override // g3a.a
    public final View nj() {
        return this.s.a.findViewById(2131383803);
    }

    @Override // g3a.a
    public final RealtimeCallSubtitleLayout ol() {
        return (RealtimeCallSubtitleLayout) this.s.a.findViewById(2131392673);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, g3a.a.class);
    }

    public final void A0() {
        getActivity();
        m3();
        e3a.b r0 = (e3a.b) this.v.getValue();
        RealtimeCallService r1 = (RealtimeCallService) this.x.getValue();
    }

    public final void p3() {
        int r0 = getActivity().getResources().getDimensionPixelSize(2131167682);
        int r1 = getActivity().getResources().getDimensionPixelSize(2131167684);
        Pair<Boolean, Boolean> r2 = l.i;
        if (l.a.b(getActivity()) == false) goto L5;
        int r3 = getActivity().getResources().getDimensionPixelSize(2131167681);
    L6:
        int r4 = ((r0 * 2) + r1) + r3;
        int r5 = r4 + getActivity().getResources().getDimensionPixelSize(2131167687);
        ConstraintLayout r6 = this.B;
        if (r6 == null) goto L17;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L16;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r8.topMargin = i5.k0();
        if (z2.a.realtimeCallUseTwoLineStyle() == true) goto L14;
        r5 = i5.D();
    L14:
        r8.bottomMargin = r5;
        r6.setLayoutParams(r8);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // g3a.a
    public final VoiceCallContentLayout dg() {
        return this.A;
    }

    public RealtimeContentComponent(LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.s = r2;
        this.t = LazyKt.lazy(new g3a.j(this));
        this.u = LazyKt.lazy(new k(this));
        this.v = LazyKt.lazy(new g3a.l(this));
        this.w = LazyKt.lazy(new g3a.m(this));
        this.x = LazyKt.lazy(new n(this));
        this.y = LazyKt.lazy(new c(this));
        this.z = LazyKt.lazy(new d(this));
        this.C = LazyKt.lazy(new e(this));
    }

    public static final /* synthetic */ FragmentActivity h3(RealtimeContentComponent r0) {
        return r0.getActivity();
    }

    @Override // g3a.a
    public final void No(m r5) {
        if (r5 == null) goto L27;
        ConstraintLayout r2 = (SubtitleInterpretLayout) this.s.a.findViewById(2131392663);
        if (r2 == null) goto L34;
        r2.setVisibility(0);
    L34:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        v r4 = xt7.d.b;     // Catch: Throwable -> L15
        juc.c r6 = l0.Companion.serializer();     // Catch: Throwable -> L15
        CallInstructionModel r7 = r5.a.getCallInstructionModel();     // Catch: Throwable -> L15
        if (r7 == null) goto L10;
        String r8 = r7.getTemplate();     // Catch: Throwable -> L15
    L11:
        if (r8 != null) goto L13;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        Object r9 = Result.constructor-impl((l0) r4.c(r6, r8));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r9) == false) goto L20;
        r9 = null;
    L20:
        l0 r10 = (l0) r9;
        if (r10 == null) goto L25;
        SubtitleInterpretLayout r11 = (SubtitleInterpretLayout) this.s.a.findViewById(2131392663);
        if (r11 == null) goto L25;
        r11.U5(r10);
        b r12 = new b(this);
        Intrinsics.checkNotNullParameter(r12, "callback");
        r11.l = r12;
    L26:
        if (r11 == null) goto L27;
        return;
    L25:
        r11 = null;
        goto L26
    L10:
        r8 = null;
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        ConstraintLayout r14 = (SubtitleInterpretLayout) this.s.a.findViewById(2131392663);
        if (r14 == null) goto L30;
        r14.setVisibility(8);
    L30:
        SubtitleInterpretLayout r15 = (SubtitleInterpretLayout) this.s.a.findViewById(2131392663);
        if (r15 == null) goto L37;
        r15.U5(null);
        Unit r16 = Unit.INSTANCE;
        return;
    }

    @Override // g3a.a
    public final void O1(boolean r10) {
        p3();
        VoiceCallContentLayout r0 = this.A;
        if (r0 == null) goto L32;
        ConstraintLayout.LayoutParams r1 = r0.a.e.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r2 = r1;
    L8:
        if (r2 != null) goto L11;
    L15:
        LarusLayoutRealtimeCallContentBinding r3 = r0.a;
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L28;
        e1.o(r3.e);
        if (r10 == false) goto L23;
        e1.o(r3.c);
        e1.x(r3.k);
        VoiceCallContentLayout.b r11 = r0.j;
        if (r11 == null) goto L36;
        LarusLayoutRealtimeCallContentBinding r4 = r0.a;
        r4.i.setVisibility(r11.a);
        r4.m.setVisibility(r11.b);
        r4.l.setVisibility(r11.c);
        r4.o.setVisibility(r11.d);
        r4.n.setVisibility(r11.e);
        r4.w.setVisibility(r11.f);
        r0.j = null;
        return;
    L36:
        return;
    L23:
        e1.x(r3.c);
        e1.o(r3.k);
        if (r0.j != null) goto L27;
        LarusLayoutRealtimeCallContentBinding r12 = r0.a;
        r0.j = new VoiceCallContentLayout.b(r12.i.getVisibility(), r12.m.getVisibility(), r12.l.getVisibility(), r12.o.getVisibility(), r12.n.getVisibility(), r12.w.getVisibility());
    L27:
        e1.q(r0.a.i);
        e1.q(r0.a.m);
        e1.q(r0.a.l);
        e1.q(r0.a.o);
        e1.q(r0.a.n);
        e1.q(r0.a.w);
        return;
    L28:
        if (r10 == false) goto L30;
        e1.o(r3.c);
        e1.o(r3.e);
        e1.x(r3.k);
        return;
    L30:
        e1.o(r3.c);
        e1.x(r3.e);
        e1.o(r3.k);
        return;
    L11:
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L13;
        r2.topToTop = -1;
        r2.topToBottom = -1;
        r2.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = i5.E();
    L14:
        r0.a.e.setLayoutParams(r2);
        goto L15
    L13:
        r2.topToTop = -1;
        r2.topToBottom = 2131383792;
        r2.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = 0;
        goto L14
    L7:
        r2 = null;
        goto L8
    }

    @Override // g3a.a
    public final void dD(BotModel r2) {
        VoiceCallContentLayout r0 = this.A;
        if (r0 == null) goto L6;
        r0.i6(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [android.view.ViewGroup, com.larus.voicecall.impl.ui.VoiceCallContentLayout, java.lang.Object] */
    public final void onViewCreated(View r22) {
        Intrinsics.checkNotNullParameter(r22, "view");
        this.s.c.setLayoutResource(2131562429);
        ConstraintLayout r0 = this.s.c.inflate();
        int r2 = 2131364481;
        if (ViewBindings.findChildViewById(r0, 2131364481) == null) goto L160;
        r2 = 2131367812;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r0, 2131367812);
        if (r3 == null) goto L160;
        r2 = 2131372915;
        if (((FrameLayout) ViewBindings.findChildViewById(r0, 2131372915)) == null) goto L160;
        r2 = 2131373052;
        if (ViewBindings.findChildViewById(r0, 2131373052) == null) goto L160;
        r2 = 2131376657;
        if (ViewBindings.findChildViewById(r0, 2131376657) == null) goto L160;
        r2 = 2131376658;
        if (ViewBindings.findChildViewById(r0, 2131376658) == null) goto L160;
        r2 = 2131383797;
        if (((VoiceCallBgLayout) ViewBindings.findChildViewById(r0, 2131383797)) == null) goto L160;
        r2 = 2131383803;
        if (ViewBindings.findChildViewById(r0, 2131383803) == null) goto L160;
        r2 = 2131383805;
        if (ViewBindings.findChildViewById(r0, 2131383805) == null) goto L160;
        if (ViewBindings.findChildViewById(r0, 2131383814) != null) goto L23;
        r2 = 2131383814;
        goto L160
    L23:
        if (ViewBindings.findChildViewById(r0, 2131386942) != null) goto L25;
        r2 = 2131386942;
        goto L160
    L25:
        if (ViewBindings.findChildViewById(r0, 2131389181) == null) goto L156;
        VoiceCallContentLayout r4 = (VoiceCallContentLayout) ViewBindings.findChildViewById(r0, 2131392660);
        if (r4 != null) goto L29;
        r2 = 2131392660;
        goto L160
    L29:
        if (((SubtitleInterpretLayout) ViewBindings.findChildViewById(r0, 2131392663)) != null) goto L31;
        r2 = 2131392663;
        goto L160
    L31:
        if (((RealtimeCallScreenShareLayout) ViewBindings.findChildViewById(r0, 2131392666)) != null) goto L33;
        r2 = 2131392666;
        goto L160
    L33:
        if (((RealtimeCallSubtitleLayout) ViewBindings.findChildViewById(r0, 2131392673)) == null) goto L152;
        w3a.k r1 = (w3a.k) this.C.getValue();
        if (r1 == null) goto L37;
        r1.c(new g3a.o(this));
    L37:
        w3a.k r5 = (w3a.k) this.C.getValue();
        if (r5 == null) goto L40;
        r5.c(new p(this));
    L40:
        this.A = r4;
        this.B = r3;
        p3();
        e3a.b r6 = (e3a.b) this.v.getValue();
        ?? r7 = this.A;
        if (r7 == 0) goto L82;
        e3a.b r8 = (e3a.b) this.v.getValue();
        Intrinsics.checkNotNullParameter(r8, "runtimeData");
        r7.b = r8;
        ThemeType r9 = ((h88.b) r8).i;
        r7.c = r9;
        boolean r10 = ((h88.b) r8).p;
        r7.getClass();
        r7.f = ((h88.b) r8).q;
        Application r11 = f.a;
        LarusLayoutRealtimeCallContentBinding r12 = r7.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r9, "themeType");
        if (i88.e.o(r9) == false) goto L45;
        r12.g.setTextColor(f.a(2131103298));
        r12.d.setBackgroundResource(2131239455);
        r12.h.setImageResource(2131241885);
        r12.f.setTextColor(f.a(2131103298));
    L47:
        if (z2.a.realtimeTalkbackOptEnable() == true) goto L49;
    L62:
        LarusLayoutRealtimeCallContentBinding r13 = r7.a;
        CustomBarCountAudioVisualizer r14 = r13.p;
        r14.setMaxSampleData(0.8d);
        r14.setColor(ColorProtector.parseColor("#00B2FF"));
        RealtimeCallUtil.a.getClass();
        Lazy r15 = RealtimeCallUtil.h0;
        if (((Number) r15.getValue()).intValue() <= 0) goto L65;
        r14.setFps(((Number) r15.getValue()).intValue());
    L65:
        r13.t.setAnimation(2131820620);
        r13.r.setAnimation(2131820619);
        if (((h88.b) r8).h == false) goto L69;
        SceneModeButton r16 = r13.v;
        ThemeType r17 = r7.c;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "themeType");
        r16.b = r17;
        r16.a(false);
    L69:
        if (r7.h == false) goto L72;
        e1.o(r13.u);
    L72:
        if (z2.a.realtimeTalkbackOptEnable() == true) goto L163;
    L81:
        r7.U5();
        goto L82
    L163:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L75
        r7.a.m.setImportantForAccessibility(2);     // Catch: Throwable -> L75
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L77:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L81;
        FLogger.a.e("VoiceCallContentLayout", "setImportantForAccessibility failed", r20);
    L75:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L49:
        if (AppHost.a.isOversea() == true) goto L62;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L56
        Context r24 = r7.getContext();     // Catch: Throwable -> L56
        if (r24 == null) goto L53;
        r7.getRealtimeCallAvatar().setContentDescription(r24.getString(2131898773));     // Catch: Throwable -> L56
        r7.a.i.setContentDescription(r24.getString(2131898772));     // Catch: Throwable -> L56
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L56
    L54:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L56
    L58:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L62;
        FLogger.a.e("VoiceCallContentLayout", "onViewCreated realtimeTalkbackOptEnable error", r27);
        goto L62
    L53:
        r25 = null;
    L56:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L45:
        r12.g.setTextColor(f.a(2131103292));
        r12.d.setBackgroundResource(2131239454);
        r12.h.setImageResource(2131241886);
        r12.f.setTextColor(f.a(2131103292));
    L82:
        e3a.a r29 = m3();
        final VoiceCallContentLayout r30 = this.A;
        if (r30 == null) goto L130;
        int r110 = ((h88.a) r29).b;
        String r111 = ((h88.a) r29).e;
        final BotModel r112 = r29.H0;
        Boolean r31 = Boolean.valueOf(((h88.a) m3()).T);
        String r113 = ((h88.a) m3()).U;
        Intrinsics.checkNotNullParameter(r111, "botAvatar");
        boolean r114 = true;
        if (r30.c != ThemeType.MAIN_BOT) goto L91;
        LarusLayoutRealtimeCallContentBinding r32 = r30.a;
        Iterator r33 = CollectionsKt.listOf(new View[]{r32.l, r32.m, r32.i, r32.o}).iterator();
    L88:
        if (r33.hasNext() == false) goto L91;
        e1.d((View) r33.next(), new a0(r30, r112));
    L91:
        if (Intrinsics.areEqual(r31, Boolean.TRUE) == false) goto L99;
        if (TextUtils.isEmpty(r113) == false) goto L95;
    L97:
        r30.Z5(r110, r111, r112);
        goto L130
    L95:
        if (z2a.f.a(r113) == false) goto L97;
        r30.getRealtimeCallAvatar().setVisibility(0);
        r30.getRealtimeCallAvatarVideo().setVisibility(8);
        r30.getRealtimeCallAvatar().getHierarchy().setPlaceholderImage(null);
        FLogger.a.i("VoiceCallContentLayout", "showAvatar from force url :" + r113);
        CircleSimpleDraweeView.f(r30.getRealtimeCallAvatar(), b0.a(r113, "realtime_call_bot_avatar_new", false, false, 6), null, new c0(r30, r113, r110, r111, r112), 0, 0, 58);
        goto L130
    L99:
        if (r30.c == ThemeType.MAIN_BOT) goto L101;
    L111:
        ThemeType r34 = r30.c;
        if (r34 != ThemeType.IMMERS_BOT) goto L115;
        r30.V5();
        r30.R5();
        goto L130
    L115:
        if (r34 == ThemeType.UGC_BOT) goto L117;
    L121:
        e3a.b r35 = r30.b;
        if (r35 != null) goto L124;
    L126:
        r114 = false;
    L127:
        if (r114 == false) goto L129;
        r30.S5();
    L129:
        r30.Z5(r110, r111, r112);
        goto L130
    L124:
        if (((h88.b) r35).h != true) goto L126;
    L117:
        if (r30.f == false) goto L121;
        boolean r36 = h.a;
        if (h.a(null) == true) goto L121;
        r30.a.m.setBackgroundResource(2131239453);
        goto L121
    L101:
        if (NewThemeSwitchAvatar.a() == false) goto L111;
        t0.a.getClass();
        t0.b r37 = t0.d();
        if (r37 != null) goto L105;
    L107:
        boolean r38 = false;
    L108:
        if (r38 == false) goto L110;
        r30.b6(r37);
        goto L130
    L110:
        FLogger.a.e("VoiceCallContentLayout", "load ball video failed, use bot avatar");
        goto L111
    L105:
        if (r37.a() != true) goto L107;
        r38 = true;
    L130:
        int r39 = u.c(getActivity());
        int r40 = u.b(getActivity());
        ConstraintLayout r41 = this.s.a.findViewById(2131383805);
        if (r41 == null) goto L133;
        r41.setPadding(0, r39, 0, r40);
    L133:
        View r42 = this.s.a.findViewById(2131386942);
        if (r42 == null) goto L140;
        ViewGroup.LayoutParams r43 = r42.getLayoutParams();
        if (r43 == null) goto L139;
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        r44.topMargin = i5.k0();
        r42.setLayoutParams(r44);
        goto L140
    L139:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L140:
        VoiceCallContentLayout r45 = this.A;
        if (r45 == null) goto L145;
        CircleSimpleDraweeView r46 = r45.getRealtimeCallAvatar();
        if (r46 == null) goto L145;
        r46.setOnLongClickListener(new g3a.b(this));
    L145:
        VoiceCallContentLayout r47 = this.A;
        if (r47 == null) goto L148;
        r47.setClickSwitchAvatarInterceptor(new g3a.f(this));
    L148:
        VoiceCallBgLayout r48 = Nl();
        if (r48 == null) goto L166;
        r48.setRuntimeParam(new g(this));
        r48.setArgumentParam(new g3a.h(this));
        r48.setTranslateScene(new i(this));
        return;
    L166:
        return;
    L152:
        r2 = 2131392673;
        goto L160
    L156:
        r2 = 2131389181;
    L160:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    }

    public final void o1(MajorState r18, int r19, MajorState r20, int r21) {
        Intrinsics.checkNotNullParameter(r18, "currentMajorState");
        Intrinsics.checkNotNullParameter(r20, "newMajorState");
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[CALL] onUpdateUIState current state : ");
        r3.append(r19);
        r3.append(',');
        InstanceCallState.Companion.getClass();
        r3.append(InstanceCallState.a.a(r19));
        r3.append(" --> new state: ");
        r3.append(r21);
        r3.append(',');
        r3.append(InstanceCallState.a.a(r21));
        r2.d("RealtimeContentComponent", r3.toString());
        MajorState.d r4 = ((RealtimeCallService) this.x.getValue()).h();
        boolean r6 = true;
        if ((r4 instanceof MajorState.d) == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L24;
        VoiceCallContentLayout r7 = this.A;
        if (r7 == null) goto L25;
        Intrinsics.checkNotNullParameter(r4, "state");
        LarusLayoutRealtimeCallContentBinding r8 = r7.a;
        VoiceCallVideoView r9 = r8.i;
        View r10 = r8.m;
        ThemeType r11 = r7.c;
        int r12 = VoiceCallContentLayout.c.a[r11.ordinal()];
        if (r12 == 1) goto L21;
        if (r12 != 2) goto L25;
        if ((r4 instanceof MajorState.h) == false) goto L19;
        c4a.g.b(r10, true);
        goto L25
    L19:
        c4a.g.c(r10);
        goto L25
    L21:
        if ((r4 instanceof MajorState.h) == false) goto L23;
        c4a.g.b(r9, false);
        c4a.g.b(r10, true);
        goto L25
    L23:
        c4a.g.c(r9);
        c4a.g.c(r10);
    L25:
        VoiceCallContentLayout r13 = this.A;
        if (r13 == null) goto L31;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == true) goto L31;
        r13.a.t.cancelAnimation();
    L31:
        if (r21 != 1) goto L33;
        VoiceCallContentLayout r1 = this.A;
        if (r1 == null) goto L107;
        r1.U5();
    L107:
        VoiceCallContentLayout r14 = this.A;
        if (r14 == null) goto L129;
        r14.c6(false, true);
        return;
    L129:
        return;
    L33:
        if (r21 == 12) goto L101;
        switch(r21) {
            case 3: goto L98;
            case 4: goto L70;
            case 5: goto L45;
            case 6: goto L42;
            case 7: goto L39;
            case 8: goto L36;
            case 9: goto L70;
            default: goto L130;
        };
    L36:
        VoiceCallContentLayout r15 = this.A;
        if (r15 == null) goto L111;
        int r16 = VoiceCallContentLayout.l;
        r15.c6(false, false);
        return;
    L111:
        return;
    L39:
        VoiceCallContentLayout r17 = this.A;
        if (r17 == null) goto L113;
        r17.c6(true, false);
        r17.U5();
        return;
    L113:
        return;
    L42:
        VoiceCallContentLayout r22 = this.A;
        if (r22 == null) goto L115;
        r22.U5();
        return;
    L115:
        return;
    L45:
        VoiceCallContentLayout r23 = this.A;
        if (r23 == null) goto L117;
        r23.d = false;
        if (r23.c != ThemeType.DEFAULT) goto L50;
        boolean r24 = true;
    L51:
        r23.e = r24;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L55;
        return;
    L55:
        if (r23.e == false) goto L68;
        LarusLayoutRealtimeCallContentBinding r25 = r23.a;
        FrameLayout r26 = r25.s;
        RelativeLayout r27 = r25.q;
        int r28 = com.larus.voicecall.impl.utils.c.a;
        Intrinsics.checkNotNullParameter(r26, "hideView");
        Intrinsics.checkNotNullParameter(r27, "showView");
        if (r26.getVisibility() != 0) goto L59;
        boolean r29 = true;
    L60:
        if (r29 == false) goto L63;
        ScaleAnimation r30 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.2f, 1, 0.8f);
        r30.setDuration(200);
        int r31 = com.larus.voicecall.impl.utils.c.a;
        r30.initialize(r31, r31, r31, r31);
        r30.setAnimationListener(new com.larus.voicecall.impl.utils.b(r26, r27));
        r26.startAnimation(r30);
        return;
    L63:
        if (r27.getVisibility() == 0) goto L66;
        r6 = false;
    L66:
        if (r6 == true) goto L119;
        com.larus.voicecall.impl.utils.c.b(r27);
        return;
    L119:
        return;
    L59:
        r29 = false;
        goto L60
    L68:
        e1.q(r23.a.s);
        e1.q(r23.a.q);
        return;
    L50:
        r24 = false;
        goto L51
    L117:
        return;
    L98:
        VoiceCallContentLayout r32 = this.A;
        if (r32 == null) goto L125;
        r32.U5();
        return;
    L125:
        return;
    L130:
        return;
    L70:
        if (r21 != 9) goto L74;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l != null) goto L74;
        return;
    L74:
        VoiceCallContentLayout r33 = this.A;
        if (r33 == null) goto L122;
        ThemeType r34 = r33.c;
        if (r34 != ThemeType.DEFAULT) goto L79;
    L91:
        r33.d = r6;
        r33.e = false;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L95;
        return;
    L95:
        if (r33.d == false) goto L97;
        r33.a.q.setVisibility(8);
        r33.a.t.playAnimation();
        r33.a.s.setVisibility(0);
        com.larus.voicecall.impl.utils.c.b(r33.a.s);
        return;
    L97:
        e1.q(r33.a.s);
        e1.q(r33.a.q);
        return;
    L79:
        if (r34 == ThemeType.UGC_BOT) goto L91;
        if (r34 == ThemeType.MAIN_BOT) goto L83;
    L90:
        r6 = false;
        goto L91
    L83:
        if (NewThemeSwitchAvatar.b == NewThemeSwitchAvatar.AvatarType.NORMAL_AVATAR) goto L85;
    L87:
        boolean r35 = false;
    L88:
        if (r35 == false) goto L90;
    L85:
        if (((Boolean) NewThemeSwitchAvatar.a.getValue()).booleanValue() == false) goto L87;
        r35 = true;
        goto L88
    L122:
        return;
    L101:
        VoiceCallContentLayout r36 = this.A;
        if (r36 == null) goto L127;
        r36.d = false;
        r36.e = false;
        e1.o(r36.a.w);
        r36.a.q.setVisibility(4);
        r36.a.s.setVisibility(4);
        return;
    L127:
        return;
    L24:
        r2.e("RealtimeContentComponent", "[CALL] onUpdateUIState is isMockListening, skip...");
        goto L25
    L5:
        if (r4.c != MajorState.From.TTS_ENDED) goto L7;
        r5 = true;
        goto L8
    }
}
