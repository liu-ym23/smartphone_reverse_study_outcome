package com.obric.assistant.activation.presentation.runtime.manager;

import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016¨\u0006\u0017"}, d2 = {"com/obric/assistant/activation/presentation/runtime/manager/ObricListeningMainProcessManager$callback$1", "Lcom/obric/assistant/activation/presentation/contract/ipc/IObricMainPresentationBridgeCallback$Stub;", "onFallbackStateChanged", NameKeys.UnloadStrategy_No_Strategy, "owned", NameKeys.UnloadStrategy_No_Strategy, "state", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningPresentationState;", "onChildSurfaceChanged", "generation", NameKeys.UnloadStrategy_No_Strategy, "displayId", "windowType", "surface", "Landroid/view/SurfaceControl;", "onChildFirstFrameReady", "startupAttemptId", NameKeys.UnloadStrategy_No_Strategy, "timestampElapsedRealtimeMs", NameKeys.UnloadStrategy_No_Strategy, "onChildSurfaceDestroyed", "onChildPresentationTimeout", "revision", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningMainProcessManager$callback$1 extends IObricMainPresentationBridgeCallback.Stub {
    public static /* synthetic */ Unit a(String r0, ObricListeningMainProcessManager$callback$1 r1, int r2, long r3) {
        return onChildFirstFrameReady$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(long r0) {
        return onChildPresentationTimeout$lambda$7(r0);
    }

    public static /* synthetic */ String e(int r0) {
        return onChildFirstFrameReady$lambda$5$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Unit f(boolean r0, ObricListeningPresentationState r1, ObricListeningMainProcessManager.c r2) {
        return onFallbackStateChanged$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit g(int r0) {
        return onChildSurfaceDestroyed$lambda$6(r0);
    }

    public static /* synthetic */ Unit h(SurfaceControl r0, int r1, int r2, int r3) {
        return onChildSurfaceChanged$lambda$1(r0, r1, r2, r3);
    }

    public ObricListeningMainProcessManager$callback$1() {
    }

    private static final String onChildFirstFrameReady$lambda$5$lambda$4$lambda$3(int r2) {
        return "ignore child first frame, reason=attempt_unavailable, generation=" + r2;
    }

    private static final Unit onChildPresentationTimeout$lambda$7(long r6) {
        ObricListeningMainProcessManager.a.getClass();
        if (ObricListeningMainProcessManager.f == true) goto L6;
        FLogger.a.i("ObricListeningMainPM", "ignore child presentation timeout without child owner, expectedRevision=" + r6);
    L20:
        return Unit.INSTANCE;
    L6:
        if (r6 <= ObricListeningMainProcessManager.g.a) goto L8;
        FLogger.a.i("ObricListeningMainPM", "ignore child presentation timeout with future revision, expectedRevision=" + r6 + " currentRevision=" + ObricListeningMainProcessManager.g.a);
        goto L20
    L8:
        Function0<Unit> r2 = ObricListeningMainProcessManager.i;
        if (r2 != null) goto L11;
        FLogger.a.w("ObricListeningMainPM", "child presentation timeout handler unavailable, expectedRevision=" + r6);
        goto L20
    L11:
        FLogger.a.w("ObricListeningMainPM", "cancel recording after child presentation timeout, expectedRevision=" + r6 + " currentRevision=" + ObricListeningMainProcessManager.g.a + " recordingConfirmed=" + ObricListeningMainProcessManager.h);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        Object r8 = Result.constructor-impl(r2.invoke());     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L20;
        FLogger.a.w("ObricListeningMainPM", "cancel recording after child timeout failed", r9);
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    private static final Unit onChildSurfaceDestroyed$lambda$6(int r4) {
        if (r4 == ObricListeningMainProcessManager.l) goto L6;
        FLogger.a.i("ObricListeningMainPM", "ignore stale Surface destroy, incomingGeneration=" + r4 + ", currentGeneration=" + ObricListeningMainProcessManager.l);
        return Unit.INSTANCE;
    L6:
        ObricListeningMainProcessManager.u = null;
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.e();
        FLogger.a.i("ObricListeningMainPM", "child Surface cleared, generation=" + r4);
        ObricListeningMainProcessManager.i();
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
    public void onChildPresentationTimeout(final long r4) {
        FLogger.a.w("ObricListeningMainPM", "onChildPresentationTimeout, revision=" + r4);
        ObricListeningMainProcessManager r0 = ObricListeningMainProcessManager.a;
        Function0 r1 = new r1(r4);
        r0.getClass();
        ObricListeningMainProcessManager.k(r1);
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
    public void onChildSurfaceDestroyed(final int r4) {
        FLogger.a.i("ObricListeningMainPM", "onChildSurfaceDestroyed, generation=" + r4);
        ObricListeningMainProcessManager r0 = ObricListeningMainProcessManager.a;
        Function0 r1 = new u1(r4);
        r0.getClass();
        ObricListeningMainProcessManager.k(r1);
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
    public void onFallbackStateChanged(final boolean r7, final ObricListeningPresentationState r8) {
        long r1 = ObricListeningMainProcessManager.s.incrementAndGet();
        if (r8 != null) goto L5;
        ObricListeningPresentationState r3 = ObricListeningPresentationState.g;
    L6:
        final ObricListeningMainProcessManager.c r0 = new ObricListeningMainProcessManager.c(r1, r7, r3);
        ObricListeningMainProcessManager.t.set(r0);
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onFallbackStateChanged, owned=");
        r4.append(r7);
        r4.append(", revision=");
        Boolean r5 = null;
        if (r8 == null) goto L9;
        Long r6 = Long.valueOf(r8.a);
    L10:
        r4.append(r6);
        r4.append(", mode=");
        if (r8 == null) goto L15;
        ObricListeningViewState r9 = r8.e;
        if (r9 == null) goto L15;
        ObricListeningVisualMode r10 = r9.a;
    L16:
        r4.append(r10);
        r4.append(", childFeedbackPlayed=");
        if (r8 == null) goto L19;
        r5 = Boolean.valueOf(r8.f);
    L19:
        r4.append(r5);
        r4.append(", pendingSequence=");
        r4.append(r0.a);
        r2.i("ObricListeningMainPM", r4.toString());
        ObricListeningMainProcessManager r11 = ObricListeningMainProcessManager.a;
        Function0 r12 = new s1(r7, r8, r0);
        r11.getClass();
        ObricListeningMainProcessManager.k(r12);
        return;
    L15:
        r10 = null;
        goto L16
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = r8;
        goto L6
    }

    private static final Unit onFallbackStateChanged$lambda$0(boolean r2, ObricListeningPresentationState r3, ObricListeningMainProcessManager.c r4) {
        ObricListeningMainProcessManager.b(ObricListeningMainProcessManager.a, r2, r3);     // Catch: Throwable -> L12
        AtomicReference<ObricListeningMainProcessManager.c> r5 = ObricListeningMainProcessManager.t;
    L6:
        if (r5.compareAndSet(r4, null) == true) goto L11;
        if (r5.get() == r4) goto L6;
    L11:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        AtomicReference<ObricListeningMainProcessManager.c> r6 = ObricListeningMainProcessManager.t;
    L15:
        if (r6.compareAndSet(r4, null) == true) goto L19;
        if (r6.get() == r4) goto L15;
    L19:
        throw th;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
    public void onChildFirstFrameReady(final int r9, final String r10, final long r11) {
        ObricListeningMainProcessManager r0 = ObricListeningMainProcessManager.a;
        Function0 r7 = new p1(r10, this, r9, r11);
        r0.getClass();
        ObricListeningMainProcessManager.k(r7);
    }

    private static final Unit onChildFirstFrameReady$lambda$5(String r1, ObricListeningMainProcessManager$callback$1 r2, final int r3, long r4) {
        if (r1 != null) goto L4;
    L11:
        FLogger.a.g("ObricListeningMainPM", new q1(r3));
        return Unit.INSTANCE;
    L4:
        if ((!StringsKt.isBlank(r1)) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L11;
        ObricListeningMainProcessManager r5 = ObricListeningMainProcessManager.a;
        ObricListeningMainProcessManager.b r0 = new ObricListeningMainProcessManager.b(r3, r1, r4);
        r5.getClass();
        ObricListeningMainProcessManager.a(r0, false);
        return Unit.INSTANCE;
    }

    private static final Unit onChildSurfaceChanged$lambda$1(SurfaceControl r3, int r4, int r5, int r6) {
        if (r3 == null) goto L17;
        boolean r1 = ObricListeningMainProcessManager.f;
        int r2 = ObricListeningMainProcessManager.l;
        if (r1 == false) goto L10;
        if (r4 <= 0) goto L10;
        if (r4 < r2) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L17;
        if (r4 == r2) goto L15;
        ObricListeningMainProcessManager.u = null;
    L15:
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.e();
        ObricListeningMainProcessManager.k = r3;
        ObricListeningMainProcessManager.l = r4;
        ObricListeningMainProcessManager.m = r5;
        ObricListeningMainProcessManager.n = r6;
        FLogger.a.i("ObricListeningMainPM", "child Surface accepted, generation=" + r4);
        ObricListeningMainProcessManager.i();
        return Unit.INSTANCE;
    L10:
        r7 = false;
    L17:
        FLogger.a.w("ObricListeningMainPM", "reject child Surface, incomingGeneration=" + r4 + ", currentSurfaceGeneration=" + ObricListeningMainProcessManager.l + ", owned=" + ObricListeningMainProcessManager.f);
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.l(r3);
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
    public void onChildSurfaceChanged(final int r4, final int r5, final int r6, final SurfaceControl r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onChildSurfaceChanged, generation=");
        r1.append(r4);
        r1.append(", displayId=");
        r1.append(r5);
        r1.append(", windowType=");
        r1.append(r6);
        r1.append(", hasSurface=");
        if (r7 == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("ObricListeningMainPM", r1.toString());
        ObricListeningMainProcessManager r3 = ObricListeningMainProcessManager.a;
        Function0 r8 = new t1(r7, r4, r5, r6);
        r3.getClass();
        ObricListeningMainProcessManager.k(r8);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
