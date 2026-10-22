package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.runtime.session.ObricScreenshotRequester;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$6 extends FunctionReferenceImpl implements Function1<yaa.a, Unit> {
    public ObricListeningChildCoordinator$initialize$1$6(Object r8) {
        super(1, r8, ObricListeningChildCoordinator.class, "onGestureEvent", "onGestureEvent(Lcom/obric/assistant/activation/presentation/contract/gesture/ObricAiKeyGestureEvent;)V", 0);
    }

    public final void invoke(yaa.a r11) {
        Intrinsics.checkNotNullParameter(r11, "p0");
        ObricListeningChildCoordinator r0 = (ObricListeningChildCoordinator) ((CallableReference) this).receiver;
        ObricListeningChildCoordinator r1 = ObricListeningChildCoordinator.a;
        r0.getClass();
        ObricListeningChildCoordinator.RawOwner r2 = ObricListeningChildCoordinator.p;
        FLogger r3 = FLogger.a;
        r3.i("ObricListeningChildCoordinator", "gesture_event: action=" + r11.a + " rawOwner=" + r2);
        if (r11.a != ObricAiKeyGestureAction.DOWN) goto L9;
        long r4 = SystemClock.uptimeMillis();
        long r6 = ObricListeningChildCoordinator.r;
        if (r6 <= 0) goto L7;
        long r7 = RangesKt.coerceAtLeast(r4 - r6, 0);
    L8:
        ObricListeningChildCoordinator.s = r7;
        ObricListeningChildCoordinator.r = r4;
        goto L9
    L7:
        r7 = -1;
    L9:
        int r5 = ObricListeningChildCoordinator.c.c[r2.ordinal()];
        if (r5 == 1) goto L34;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L16;
        r3.i("ObricListeningChildCoordinator", "gesture_event_ignored: reason=no_raw_owner action=" + r11.a);
    L53:
        if (r2 == ObricListeningChildCoordinator.RawOwner.NONE) goto L62;
        ObricScreenshotRequester.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "event");
        int r8 = ObricScreenshotRequester.a.a[r11.a.ordinal()];
        if (r8 == 1) goto L59;
        if (r8 != 2) goto L62;
        String r9 = "ai_key_single_press";
    L60:
        ObricScreenshotRequester.b(r9, 20);
        goto L62
    L59:
        r9 = "ai_key_press_start";
    L62:
        if (r2 != ObricListeningChildCoordinator.RawOwner.CHILD) goto L69;
        ObricAiKeyGestureAction r12 = r11.a;
        if (r12 != ObricAiKeyGestureAction.CANCEL) goto L66;
    L67:
        ObricListeningChildCoordinator.d();
        return;
    L66:
        if (r12 == ObricAiKeyGestureAction.TIMEOUT) goto L67;
        return;
    L69:
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        switch(ObricListeningChildCoordinator.c.b[r11.a.ordinal()]) {
            case 1: goto L29;
            case 2: goto L29;
            case 3: goto L25;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L20;
            default: goto L31;
        };
    L20:
        ObricListeningChildCoordinator.q(ObricListeningChildCoordinator.RawOwner.NONE);
        goto L31
    L21:
        ObricListeningChildCoordinator.c();
        if (r11.a != ObricAiKeyGestureAction.LONG_PRESS_STOP) goto L24;
        ObricListeningChildCoordinator.q(ObricListeningChildCoordinator.RawOwner.NONE);
    L24:
        ObricListeningChildCoordinator.t(ActivationSource.AI_KEY, ObricListeningVisualMode.PRESS_TALK);
        goto L31
    L25:
        ObricListeningChildCoordinator.c();
        if (r11.a != ObricAiKeyGestureAction.SHORT_PRESS) goto L28;
        ObricListeningChildCoordinator.q(ObricListeningChildCoordinator.RawOwner.NONE);
    L28:
        ObricListeningChildCoordinator.t(ActivationSource.AI_KEY, ObricListeningVisualMode.CLICK_TALK);
        goto L31
    L29:
        ObricListeningChildCoordinator.q(ObricListeningChildCoordinator.RawOwner.NONE);
    L31:
        if (r11.a != ObricAiKeyGestureAction.PRESS_START) goto L53;
        ObricListeningChildCoordinator.g(ObricListeningChildCoordinator.RawOwner.CHILD);
        goto L53
    L34:
        if (r11.a != ObricAiKeyGestureAction.PRESS_START) goto L36;
        ObricListeningChildCoordinator.g(ObricListeningChildCoordinator.RawOwner.MAIN);
    L36:
        int r10 = ObricListeningChildCoordinator.c.b[r11.a.ordinal()];
        if (r10 == 1) goto L48;
        if (r10 == 2) goto L48;
        if (r10 == 4) goto L48;
        if (r10 == 6) goto L48;
        if (r10 == 7) goto L48;
        if (r10 == 8) goto L48;
        boolean r13 = false;
    L49:
        if (r13 == false) goto L51;
        ObricListeningChildCoordinator.q(ObricListeningChildCoordinator.RawOwner.NONE);
        r3.i("ObricListeningChildCoordinator", "main_raw_owner_released: reason=terminal_gesture action=" + r11.a);
    L51:
        r3.i("ObricListeningChildCoordinator", "gesture_event_ignored: reason=semantic_owned_by_main action=" + r11.a);
    L48:
        r13 = true;
        goto L49
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yaa.a) r1);
        return Unit.INSTANCE;
    }
}
