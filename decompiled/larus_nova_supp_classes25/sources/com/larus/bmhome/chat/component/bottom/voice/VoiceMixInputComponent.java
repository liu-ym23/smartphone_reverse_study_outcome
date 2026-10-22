package com.larus.bmhome.chat.component.bottom.voice;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.f6;
import com.larus.bmhome.chat.component.bottom.core.g6;
import com.larus.bmhome.chat.component.bottom.core.h6;
import com.larus.bmhome.chat.component.bottom.core.speaker.l$a;
import com.larus.bmhome.chat.component.bottom.core.y5;
import com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputManager;
import com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 r2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020:H\u0002J\u000e\u0010>\u001a\u00020:H\u0082@¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020:H\u0016J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u000208H\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u000208H\u0016J\b\u0010H\u001a\u000208H\u0016J\u0010\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020<H\u0016J\b\u0010K\u001a\u000208H\u0016J\u001e\u0010L\u001a\u00020M2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010P\u0012\u0004\u0012\u00020:0OH\u0016J\u001e\u0010Q\u001a\u00020M2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0004\u0012\u00020:0OH\u0016J\u001c\u0010S\u001a\u00020M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020:0OH\u0016J\u001e\u0010U\u001a\u00020M2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020:0OH\u0016J\u0018\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u0002082\u0006\u0010X\u001a\u000208H\u0016J\b\u0010Y\u001a\u00020:H\u0016J\b\u0010Z\u001a\u00020RH\u0016J\b\u0010[\u001a\u00020\\H\u0016J\u0016\u0010]\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0082@¢\u0006\u0002\u0010`J \u0010a\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020FH\u0002J$\u0010e\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020g0f2\u0006\u0010;\u001a\u00020<2\u0006\u0010b\u001a\u00020cH\u0002J\u001c\u0010h\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020g0f2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010i\u001a\u00020:H\u0016J\b\u0010j\u001a\u00020:H\u0016J\"\u0010k\u001a\u00020:2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020F2\u0006\u0010o\u001a\u00020_H\u0016J\u0012\u0010p\u001a\u00020:2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\n\u0010q\u001a\u0004\u0018\u00010!H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R#\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/voice/VoiceMixInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/voice/IVoiceMixInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "uiController", "Lcom/larus/bmhome/chat/component/bottom/voice/IVoiceMixInputUIController;", "service", "Lcom/larus/bmhome/chat/component/bottom/voice/service/VoiceMixInputService;", "getService", "()Lcom/larus/bmhome/chat/component/bottom/voice/service/VoiceMixInputService;", "service$delegate", "nonStreamDetailStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$NonStreamDetailStatus;", "getNonStreamDetailStatus", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "nonStreamDetailStatus$delegate", "loadingHelper", "Lcom/larus/asr/AsrLoadingHelper;", "getLoadingHelper", "()Lcom/larus/asr/AsrLoadingHelper;", "loadingHelper$delegate", "speakerPressLifecycle", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle;", "getSpeakerPressLifecycle", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle;", "speakerPressLifecycle$delegate", "disablePanel", "", "onViewCreated", "", "view", "Landroid/view/View;", "observeNonStreamAsrSession", "beforeStartNonStreamAsr", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "switchVoiceInputStatus", "data", "Lcom/larus/bmhome/chat/component/bottom/voice/SwitchVoiceInputData;", "hitExperiment", "getExperimentGroup", "", "isOnlyLongPressVoiceMixInput", "supportStreamVoiceMixInput", "showTips", "anchor", "inVoiceMixInput", "observeVoiceMixInputStatus", "Lkotlinx/coroutines/Job;", "callback", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$Status;", "observeTextStream", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$TextStream;", "observeAudioData", "", "observeNonStreamDetailStatus", "interruptVoiceMixInput", "flushTextStream", "showIme", "closeVoiceInputPanel", "currentTextStream", "buildNonStreamVoiceMixInputTouchListener", "Lcom/larus/common_ui/utils/CompoundTouchListener;", "afterEndAsrUi", "source", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNonStreamVoiceMixInputMoveOrEnd", "event", "Landroid/view/MotionEvent;", "action", "getGlobalActionXY", "Lkotlin/Pair;", "", "getDeltaXY", "onStop", "onDestroy", "showLoading", "anchorView", "Landroid/widget/EditText;", "loadingResId", "currentText", "dismissLoading", "getController", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VoiceMixInputComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.voice.a {
    public static final List<Integer> x = null;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public com.larus.bmhome.chat.component.bottom.voice.c r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public boolean w;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.voice.b {
        public final /* synthetic */ VoiceMixInputComponent a;

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public final de8.c f1() {
            VoiceMixInputComponent r0 = this.a;
            List<Integer> r1 = VoiceMixInputComponent.x;
            return (de8.c) r0.o.getValue();
        }

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public FragmentActivity getActivity() {
            return s1a.a.getActivity(this.a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public final va8.o w0() {
            VoiceMixInputComponent r0 = this.a;
            List<Integer> r1 = VoiceMixInputComponent.x;
            return (va8.o) r0.n.getValue();
        }

        public b(VoiceMixInputComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.e.b {
        public final /* synthetic */ VoiceMixInputComponent a;

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void A9() {
            VoiceMixInputComponent r0 = this.a;
            List<Integer> r1 = VoiceMixInputComponent.x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = r0.B3();
            if (r2 == null) goto L6;
            r2.A9();
            return;
        }

        public c(VoiceMixInputComponent r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.f r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            VoiceMixInputComponent r0 = this.a;
            List<Integer> r1 = VoiceMixInputComponent.x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = r0.B3();
            if (r2 == null) goto L6;
            r2.e8(r3);
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void C9(com.larus.bmhome.chat.component.bottom.core.speaker.f r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            VoiceMixInputComponent r0 = this.a;
            List<Integer> r1 = VoiceMixInputComponent.x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = r0.B3();
            if (r2 == null) goto L6;
            r2.B9(r3);
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void D9(Function1<? super String, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r3, "handle");
            VoiceMixInputComponent r0 = this.a;
            List<Integer> r1 = VoiceMixInputComponent.x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = r0.B3();
            if (r2 == null) goto L6;
            l$a.b(r2, r3);
            return;
        }
    }

    public final void onStop() {
        com.larus.bmhome.chat.component.bottom.voice.a.C0054a.a(this, 3);
    }

    static {
        x = CollectionsKt.listOf(new Integer[]{3, 4});
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l B3() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.q.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.e C3() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.e) this.v.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final boolean OL() {
        return x.contains(Integer.valueOf(Ef()));
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.chat.component.bottom.voice.n] */
    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final v19.e QZ() {
        return new v19.e(new j(this), new k(this), new l(this), new m(this), new n(this), 32);
    }

    public final com.larus.bmhome.chat.component.bottom.voice.c m3() {
        com.larus.bmhome.chat.component.bottom.voice.c r0 = this.r;
        if (r0 == null) goto L9;
        if (this.w == true) goto L9;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("uiController");
        goto L9
    L10:
        return r0;
    L9:
        return null;
    }

    public final z0<com.larus.bmhome.chat.component.bottom.voice.service.d> p3() {
        return (z0) this.t.getValue();
    }

    public final VoiceMixInputService z3() {
        return (VoiceMixInputService) this.s.getValue();
    }

    public VoiceMixInputComponent() {
        this.m = LazyKt.lazy(new t(this));
        this.n = LazyKt.lazy(new u(this));
        this.o = LazyKt.lazy(new v(this));
        this.p = LazyKt.lazy(new w(this));
        this.q = LazyKt.lazy(new x(this));
        this.s = LazyKt.lazy(new y(this));
        this.t = LazyKt.lazy(new z());
        this.u = LazyKt.lazy(new f());
        this.v = LazyKt.lazy(new g(this));
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final boolean DG() {
        return z3().g();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final int Ef() {
        z3().getClass();
        return VoiceMixInputService.d();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final com.larus.bmhome.chat.component.bottom.voice.service.h Hw() {
        return z3().b();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void lP() {
        com.larus.bmhome.chat.component.bottom.voice.c r0 = m3();
        if (r0 == null) goto L6;
        r0.a(0);
        return;
    }

    public final void onDestroy() {
        C3().d("on_destroy");
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final boolean q40() {
        z3().getClass();
        return z2.a.enableVoiceMixInput();
    }

    public final void y2() {
        if (q40() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.voice.a.class);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void Cd(final LottieAnimationView r5) {
        Intrinsics.checkNotNullParameter(r5, "anchor");
        VoiceMixInputService r1 = z3();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "anchor");
        VoiceMixInputManager r2 = (VoiceMixInputManager) r1.b.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "anchor");
        if (((Keva) r2.a.getValue()).getBoolean("key_show_tips", false) == true) goto L7;
        ((Keva) r2.a.getValue()).storeBoolean("key_show_tips", true);
        int r0 = d0.d;
        d0.a.a("show tips");
        Function0 r3 = new com.larus.bmhome.chat.component.bottom.voice.service.o(r5);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r5, new ViewExtKt.watchOnImeInsetsAnimationEndOnce.callback.1(r3, r5));
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job IL(f6 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return z3().k(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job S50(h6 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return z3().j(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void T70(EditText r2) {
        ((com.larus.asr.f) this.u.getValue()).a(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job a20(g6 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return z3().i(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job jI(y5 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(p3(), new VoiceMixInputComponent$observeNonStreamDetailStatus$1(r3)), new VoiceMixInputComponent$observeNonStreamDetailStatus$2(null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void onViewCreated(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        if (m3() == null) goto L5;
        return;
    L5:
        if (q40() == false) goto L18;
        b r0 = new b(this);
        z3().getClass();
        int r1 = VoiceMixInputService.d();
        if (r1 != 1) goto L9;
        final j0 r2 = new j0(new c0(r7.findViewById(2131365588), true), (ViewGroup) r7.findViewById(2131392727));
        r2.f(r0);
        z3().i(new e(r2, this));
        this.r = r2;
        return;
    L9:
        if (r1 != 2) goto L11;
        i0 r8 = new i0(new c0(r7.findViewById(2131365588), false));
        Function0<Unit> r3 = new p(this);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r8.f = r3;
        r8.e(r0);
        this.r = r8;
        return;
    L11:
        if (r1 != 4) goto L21;
        i0 r9 = new i0(new c0(r7.findViewById(2131365588), false));
        Function0<Unit> r4 = new s(this);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r9.f = r4;
        r9.e(r0);
        this.r = r9;
        int r10 = d0.d;
        d0.a.a("observeNonStreamAsrSession");
        C3().e(new i(this));
        return;
    L21:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void x30(final d r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        this.w = r11.b;
        VoiceMixInputService r1 = z3();
        com.larus.bmhome.chat.component.cvs.y r2 = (com.larus.bmhome.chat.component.cvs.y) this.p.getValue();
        Integer r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.Y1();
    L7:
        if (r4 != null) goto L9;
        String r5 = "";
    L10:
        de8.c r6 = (de8.c) this.o.getValue();
        if (r6 == null) goto L15;
        Bundle r7 = r6.b;
        if (r7 == null) goto L15;
        String r8 = r7.getString("item_id", "");
    L16:
        if (r8 != null) goto L18;
        String r9 = "";
    L19:
        com.larus.bmhome.chat.component.cvs.y r10 = (com.larus.bmhome.chat.component.cvs.y) this.p.getValue();
        if (r10 == null) goto L22;
        String r12 = r10.getBotId();
    L23:
        if (r12 != null) goto L25;
        String r13 = "";
    L26:
        de8.c r14 = (de8.c) this.o.getValue();
        if (r14 == null) goto L29;
        r3 = r14.m();
    L29:
        if (r3 == null) goto L31;
        boolean r15 = true;
    L32:
        r1.m(new com.larus.bmhome.chat.component.bottom.voice.service.f(r5, r9, r13, r15, r11.c), r11.a, s1a.a.getActivity(this), new o(this), new q(this), new r(this, r11), r11.e);
        return;
    L31:
        r15 = false;
        goto L32
    L25:
        r13 = r12;
        goto L26
    L22:
        r12 = null;
        goto L23
    L18:
        r9 = r8;
    L15:
        r8 = null;
        goto L16
    L9:
        r5 = r4;
        goto L10
    L5:
        r4 = null;
        goto L7
    }

    public static final Object h3(VoiceMixInputComponent r6, Continuation r7) {
        r6.getClass();
        if ((r7 instanceof VoiceMixInputComponent$beforeStartNonStreamAsr$1) == false) goto L7;
        VoiceMixInputComponent$beforeStartNonStreamAsr$1 r0 = (VoiceMixInputComponent$beforeStartNonStreamAsr$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
    L25:
        z0<com.larus.bmhome.chat.component.bottom.voice.service.d> r9 = r6.p3();
        com.larus.bmhome.chat.component.bottom.voice.service.d.e r10 = com.larus.bmhome.chat.component.bottom.voice.service.d.e.a;
        r0.label = 2;
        if (r9.emit(r10, r0) != r2) goto L29;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        r6.w = false;
        com.larus.bmhome.chat.component.bottom.voice.c r11 = r6.m3();
        if (r11 == null) goto L19;
        r11.d();
    L19:
        VoiceMixInputService r12 = r6.z3();
        com.larus.bmhome.chat.component.bottom.voice.service.g r4 = new com.larus.bmhome.chat.component.bottom.voice.service.g(true, r6.Ef());
        r0.label = 1;
        Object r13 = r12.c().emit(r4, r0);
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        r13 = Unit.INSTANCE;
    L23:
        if (r13 != r2) goto L25;
        return r2;
    L7:
        r0 = new VoiceMixInputComponent$beforeStartNonStreamAsr$1(r6, r7);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void ql(boolean r3, final boolean r4) {
        if (Ef() != 4) goto L5;
        C3().b();
        return;
    L5:
        z3().h(r3, new h(this, r4));
    }

    public static final Object Y2(VoiceMixInputComponent r2, String r3, Continuation r4) {
        r2.getClass();
        int r0 = d0.d;
        d0.a.a("afterEndAsrUi source=".concat(r3));
        com.larus.bmhome.chat.component.bottom.voice.c r5 = r2.m3();
        if (r5 == null) goto L5;
        r5.c();
    L5:
        r2.w = true;
        VoiceMixInputService r6 = r2.z3();
        com.larus.bmhome.chat.component.bottom.voice.service.g r1 = new com.larus.bmhome.chat.component.bottom.voice.service.g(false, r2.Ef());
        Object r7 = r6.c().emit(r1, r4);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        r7 = Unit.INSTANCE;
    L10:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r7;
    L13:
        return Unit.INSTANCE;
    }

    public final void D3(View r7, MotionEvent r8, int r9) {
        Rect r0 = new Rect();
        r7.getGlobalVisibleRect(r0);
        Pair r10 = new Pair(Float.valueOf(r0.left + r8.getX()), Float.valueOf(r0.top + r8.getY()));
        Object r1 = r7.getTag(2131365544);
        Float r3 = null;
        if ((r1 instanceof Pair) == false) goto L5;
        Pair r2 = (Pair) r1;
    L7:
        if (r2 != null) goto L9;
        Pair r11 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
    L21:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = B3();
        if (r4 == null) goto L25;
        r4.pv(r9, ((Number) r10.getFirst()).floatValue(), ((Number) r10.getSecond()).floatValue(), ((Number) r11.getFirst()).floatValue(), ((Number) r11.getSecond()).floatValue());
        return;
    L25:
        return;
    L9:
        r7.setTag(2131365544, null);
        Object r12 = r2.getFirst();
        if ((r12 instanceof Float) == false) goto L12;
        Float r13 = (Float) r12;
    L13:
        if (r13 == null) goto L20;
        float r14 = r13.floatValue();
        Object r5 = r2.getSecond();
        if ((r5 instanceof Float) == false) goto L17;
        r3 = (Float) r5;
    L17:
        if (r3 == null) goto L19;
        r11 = TuplesKt.to(Float.valueOf(r14), Float.valueOf(r3.floatValue()));
        goto L21
    L19:
        r11 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L21
    L20:
        r11 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L21
    L12:
        r13 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void jj(EditText r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "currentText");
        ((com.larus.asr.f) this.u.getValue()).b(r2, r3, r4);
    }
}
