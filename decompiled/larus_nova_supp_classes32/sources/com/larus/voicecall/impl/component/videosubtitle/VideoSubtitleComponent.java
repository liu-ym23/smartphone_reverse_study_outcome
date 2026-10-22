package com.larus.voicecall.impl.component.videosubtitle;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.subtitle.DisplayType;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.q0;
import com.larus.voicecall.impl.tracer.w;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020+H\u0002J\u0018\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020+H\u0016J(\u00107\u001a\u00020-2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020 H\u0016J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020-H\u0002J\b\u0010@\u001a\u00020-H\u0002J\b\u0010A\u001a\u00020-H\u0002J\b\u0010B\u001a\u00020-H\u0002J\b\u0010C\u001a\u00020-H\u0002J\b\u0010D\u001a\u00020-H\u0002J\u001a\u0010E\u001a\u00020-2\u0006\u00104\u001a\u0002052\b\b\u0002\u0010F\u001a\u00020+H\u0002J\b\u0010G\u001a\u00020+H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/voicecall/impl/component/videosubtitle/VideoSubtitleComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/videosubtitle/IVideoSubtitleAbility;", "<init>", "()V", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "viewModel", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleViewModel;", "getViewModel", "()Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleViewModel;", "viewModel$delegate", "interruptIndex", NameKeys.UnloadStrategy_No_Strategy, "videoViewContainer", "Landroid/widget/FrameLayout;", "getVideoViewContainer", "()Landroid/widget/FrameLayout;", "videoViewContainer$delegate", "subtitleView", "Lcom/larus/voicecall/impl/component/videosubtitle/VideoSubtitleView;", "subtitleEventCollectJob", "Lkotlinx/coroutines/Job;", "subtitleHideByStop", NameKeys.UnloadStrategy_No_Strategy, "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onDestroy", "onStart", "onStop", "isSubtitleVisible", "showSubtitle", "show", "reason", NameKeys.UnloadStrategy_No_Strategy, "shouldUseVideoSubtitle", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "showSubtitleView", "hideSubtitleView", "registerClickEvent", "unregisterClickEvent", "observeSubtitleData", "unObserveSubtitleData", "handleRealtimeCallInterrupt", "handleSubtitleClick", "updateSubtitleView", "justBreak", "justInterrupt", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSubtitleComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.videosubtitle.a {
    public static final /* synthetic */ int x = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public int s;
    public final Lazy t;
    public VideoSubtitleView u;
    public Job v;
    public boolean w;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        aX(false, "onDestroy");
    }

    @Override // com.larus.voicecall.impl.component.videosubtitle.a
    public final boolean Tr() {
        boolean r0 = z2.a.getRealtimeCallNewStyleConfig().a();
        com.larus.voicecall.impl.component.vlm.b r1 = (com.larus.voicecall.impl.component.vlm.b) this.n.getValue();
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r0 == false) goto L11;
        if (r3 == false) goto L11;
        boolean r4 = true;
    L12:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("shouldUseVideoSubtitle result=");
        r6.append(r4);
        r6.append(", shouldUseFloatSubtitle=");
        r6.append(r0);
        r6.append(", isFullPreviewMode=");
        r6.append(r3);
        r6.append(", vlmAbilityNull=");
        if (((com.larus.voicecall.impl.component.vlm.b) this.n.getValue()) != null) goto L15;
        r2 = true;
    L15:
        r6.append(r2);
        r5.i("VideoSubtitleComponent", r6.toString());
        return r4;
    L11:
        r4 = false;
        goto L12
    L5:
        if (r1.s6() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final boolean h3() {
        ConstraintLayout r0 = this.u;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public final void onStart() {
        if (this.w == false) goto L6;
        aX(true, "onStart");
        this.w = false;
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.videosubtitle.a.class);
    }

    public VideoSubtitleComponent() {
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = LazyKt.lazy(new g(this));
        this.s = -1;
        this.t = LazyKt.lazy(new h(this));
    }

    public final void onStop() {
        if (h3() == false) goto L6;
        aX(false, "onStop");
        this.w = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, com.larus.voicecall.impl.component.videosubtitle.VideoSubtitleView] */
    @Override // com.larus.voicecall.impl.component.videosubtitle.a
    public final void aX(boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        boolean r1 = true;
        if (((FrameLayout) this.t.getValue()) != null) goto L5;
    L44:
        FLogger r0 = FLogger.a;
        StringBuilder r5 = new StringBuilder("showSubtitle skip, show=");
        r5.append(r9);
        r5.append(", reason=");
        r5.append(r10);
        r5.append(", videoViewContainerNull=");
        if (((FrameLayout) this.t.getValue()) == null) goto L48;
        r1 = false;
    L48:
        r5.append(r1);
        r5.append(", isSubtitleVisible=");
        r5.append(h3());
        r0.i("VideoSubtitleComponent", r5.toString());
        return;
    L5:
        if (h3() == r9) goto L44;
        int r2 = c68.b.a;
        c68.b.d("VideoSubtitleComponent", "showSubtitle, show: " + r9 + ", reason: " + r10);
        FLogger r3 = FLogger.a;
        r3.i("VideoSubtitleComponent", "showSubtitle, show=" + r9 + ", reason=" + r10);
        Job r11 = null;
        if (r9 == false) goto L33;
        FrameLayout r12 = (FrameLayout) this.t.getValue();
        if (r12 != 0) goto L13;
    L19:
        ConstraintLayout r13 = this.u;
        if (r13 == null) goto L22;
        r13.setOnClickListener(new b(this));
    L22:
        Job r14 = this.v;
        if (r14 == null) goto L25;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L25:
        ConstraintLayout r15 = this.u;
        if (r15 == null) goto L32;
        LifecycleOwner r16 = ViewTreeLifecycleOwner.get(r15);
        if (r16 == null) goto L32;
        LifecycleCoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(r16);
        if (r4 == null) goto L32;
        r11 = BuildersKt.launch$default(r4, null, null, new VideoSubtitleComponent$observeSubtitleData$1(this, null), 3, null);
    L32:
        this.v = r11;
        w.c(true);
        return;
    L13:
        if (this.u != null) goto L15;
        r3.i("VideoSubtitleComponent", "showSubtitleView create subtitle view");
        ?? r6 = new VideoSubtitleView(r12.getContext(), null);
        r12.addView(r6, new FrameLayout.LayoutParams(-1, -2));
        this.u = r6;
    L15:
        ConstraintLayout r17 = this.u;
        if (r17 == null) goto L18;
        r17.setVisibility(0);
        r17.setAlpha(0.0f);
        r17.animate().alpha(1.0f).setDuration(300).start();
    L18:
        r3.i("VideoSubtitleComponent", "showSubtitleView visible");
        goto L19
    L33:
        ConstraintLayout r18 = this.u;
        if (r18 == null) goto L36;
        r18.setVisibility(8);
    L36:
        ConstraintLayout r19 = this.u;
        if (r19 == null) goto L39;
        r19.setOnClickListener(null);
    L39:
        Job r20 = this.v;
        if (r20 == null) goto L42;
        Job.DefaultImpls.cancel$default(r20, null, 1, null);
    L42:
        this.v = null;
    }

    public final void m3(String r6, boolean r7) {
        VideoSubtitleView r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        q0 r1 = (q0) this.r.getValue();
        if (r1 == null) goto L22;
        ArrayList<com.larus.voicecall.impl.subtitle.c> r2 = r1.o;
        if (r2 == null) goto L25;
        com.larus.voicecall.impl.subtitle.c r3 = (com.larus.voicecall.impl.subtitle.c) CollectionsKt.lastOrNull(r2);
        if (r3 != null) goto L13;
        return;
    L13:
        int r4 = CollectionsKt.getLastIndex(r2);
        if (r7 == false) goto L16;
        r0.c6(true);
        return;
    L16:
        DisplayType r8 = r3.c;
        if (r8 != DisplayType.REPLY_TXT) goto L19;
    L20:
        r0.i6(r3, r4, true, r6);
        return;
    L19:
        if (r8 == DisplayType.REPLY_BLOCK) goto L20;
        return;
    L25:
        return;
    }

    public final void o1(MajorState r4, int r5, MajorState r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "currentMajorState");
        Intrinsics.checkNotNullParameter(r6, "newMajorState");
        if (Intrinsics.areEqual(r6, MajorState.a.c) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r6, MajorState.c.c) == false) goto L7;
        return;
    L7:
        if ((r6 instanceof MajorState.f) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r6, MajorState.j.c) == true) goto L89;
        boolean r8 = true;
        if ((r6 instanceof MajorState.d) == false) goto L38;
        int r9 = c68.b.a;
        c68.b.d("VideoSubtitleComponent", "onUpdateUIState, " + r4 + " -> " + r6);
        if ((r4 instanceof MajorState.g) == false) goto L20;
        VideoSubtitleView r10 = this.u;
        if (r10 == null) goto L73;
        r10.Z5();
        return;
    L73:
        return;
    L20:
        if (h3() == true) goto L22;
        return;
    L22:
        VideoSubtitleView r11 = this.u;
        if (r11 == null) goto L26;
        r11.b6("move_to_listen");
    L26:
        if (Intrinsics.areEqual(r4, MajorState.h.c) == false) goto L77;
        MajorState.From r12 = ((MajorState.d) r6).c;
        if (r12 != MajorState.From.PLAY_COMPLETE) goto L30;
        return;
    L30:
        if (r12 == MajorState.From.TTS_ENDED) goto L79;
        q0 r13 = (q0) this.r.getValue();
        if (r13 == null) goto L80;
        ArrayList<com.larus.voicecall.impl.subtitle.c> r14 = r13.o;
        if (r14 == null) goto L90;
        this.s = CollectionsKt.getLastIndex(r14);
        c68.b.d("VideoSubtitleComponent", "interruptIndex: " + this.s);
        m3("break", true);
        return;
    L90:
        return;
    L80:
        return;
    L79:
        return;
    L77:
        return;
    L38:
        if ((r6 instanceof MajorState.i) == false) goto L58;
        int r15 = c68.b.a;
        c68.b.d("VideoSubtitleComponent", "onUpdateUIState, " + r4 + " -> " + r6);
        if (h3() == true) goto L42;
        return;
    L42:
        VideoSubtitleView r16 = this.u;
        if (r16 == null) goto L82;
        q0 r17 = (q0) this.r.getValue();
        if (r17 == null) goto L55;
        ArrayList<com.larus.voicecall.impl.subtitle.c> r18 = r17.o;
        if (r18 == null) goto L55;
        int r19 = CollectionsKt.getLastIndex(r18);
        if (r19 < 0) goto L55;
        int r20 = this.s;
        if (r20 < 0) goto L55;
        if (r19 > r20) goto L55;
    L56:
        r16.c6(r8);
        return;
    L55:
        r8 = false;
        goto L56
    L82:
        return;
    L58:
        if ((r6 instanceof MajorState.g) == false) goto L66;
        int r21 = c68.b.a;
        c68.b.d("VideoSubtitleComponent", "onUpdateUIState, " + r4 + " -> " + r6);
        VideoSubtitleView r22 = this.u;
        if (r22 == null) goto L84;
        r22.V5();
        r22.Y5();
        com.larus.voicecall.impl.subtitle.c r23 = r22.b;
        if (r23 == null) goto L64;
        r23.k.put("pause_start_time", Long.valueOf(System.currentTimeMillis()));
    L64:
        c68.b.d("VideoSubtitleView", "pauseSubtitle");
        return;
    L84:
        return;
    L66:
        if (Intrinsics.areEqual(r6, MajorState.h.c) == false) goto L86;
        int r24 = c68.b.a;
        c68.b.d("VideoSubtitleComponent", "onUpdateUIState, " + r4 + " -> " + r6);
        if ((r4 instanceof MajorState.g) == false) goto L87;
        VideoSubtitleView r25 = this.u;
        if (r25 == null) goto L88;
        r25.Z5();
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    }
}
