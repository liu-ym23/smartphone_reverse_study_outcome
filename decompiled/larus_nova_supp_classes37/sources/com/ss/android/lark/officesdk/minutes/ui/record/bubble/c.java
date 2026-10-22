package com.ss.android.lark.officesdk.minutes.ui.record.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public c() {
    }

    public static final void c(Ref.BooleanRef r4, Ref.ObjectRef<View.OnAttachStateChangeListener> r5, View r6, String r7) {
        if (r4.element == false) goto L6;
        int r8 = bwb.b.a;
        bwb.b.b(MmUiLogScene.OVERLAY, "showBubble", "lifecycle listener already removed, reason=".concat(r7), null, 8);
        return;
    L6:
        r4.element = true;
        int r9 = bwb.b.a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "remove lifecycle listener reason=".concat(r7), null, 8);
        View.OnAttachStateChangeListener r10 = (View.OnAttachStateChangeListener) r5.element;
        if (r10 == null) goto L9;
        r6.removeOnAttachStateChangeListener(r10);
    L9:
        r5.element = null;
    }

    public static final void a(Ref.BooleanRef r6, Ref.BooleanRef r7, Ref.ObjectRef r8, Ref.BooleanRef r9, Ref.ObjectRef r10, View r11, String r12) {
        if (r6.element == false) goto L5;
        int r13 = bwb.b.a;
        bwb.b.b(MmUiLogScene.OVERLAY, "showBubble", "hide ignored, already hidden, reason=".concat(r12), null, 8);
        return;
    L5:
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "hide bubble reason=" + r12 + ", showStarted=" + r7.element, null, 8);
        r6.element = true;
        c(r9, r10, r11, r12);
        qub.a r14 = (qub.a) r8.element;
        if (r14 == null) goto L8;
        r14.hide();
    L8:
        r8.element = null;
    }

    public static final boolean d(Ref.BooleanRef r6, Ref.BooleanRef r7, Ref.ObjectRef<qub.a> r8, qub.b r9, Activity r10, rub.a r11, Ref.BooleanRef r12, Ref.ObjectRef<View.OnAttachStateChangeListener> r13, View r14) {
        if (r6.element == false) goto L5;
    L13:
        int r15 = bwb.b.a;
        MmUiLogScene r16 = MmUiLogScene.OVERLAY;
        StringBuilder r17 = new StringBuilder("skip show, hidden=");
        r17.append(r6.element);
        r17.append(", showStarted=");
        r17.append(r7.element);
        r17.append(", isShowing=");
        qub.a r18 = (qub.a) r8.element;
        if (r18 == null) goto L16;
        Boolean r19 = Boolean.valueOf(r18.isShowing());
    L17:
        r17.append(r19);
        bwb.b.b(r16, "showBubble", r17.toString(), null, 8);
        qub.a r20 = (qub.a) r8.element;
        if (r20 != null) goto L20;
        return false;
    L20:
        if (r20.isShowing() != true) goto L24;
        return true;
    L24:
        return false;
    L16:
        r19 = null;
        goto L17
    L5:
        if (r7.element == true) goto L13;
        r7.element = true;
        int r21 = bwb.b.a;
        MmUiLogScene r22 = MmUiLogScene.OVERLAY;
        bwb.b.g(r22, "showBubble", "start provider show, provider=".concat(r9.getClass().getName()), null, 8);
        qub.a r23 = r9.L(r10, r11);
        r8.element = r23;
        if (r23 != qub.a.C0180a.a) goto L11;
        bwb.b.d(r22, "showBubble", "provider returned empty handle", null);
        r8.element = null;
        c(r12, r13, r14, "empty");
        return false;
    L11:
        bwb.b.g(r22, "showBubble", "provider show success", null, 8);
        return true;
    }

    public static qub.a b(Context r27, final View r28, String r29, MmBubbleDirection r30, boolean r31, boolean r32, long r33, boolean r35, Integer r36, Integer r37, Point r38, Function0 r39, qub.b r40, MmRecordingUILaunchMode r41, Function0 r42, Integer r43, int r44) {
        if ((r44 & 16) == 0) goto L5;
        MmBubbleDirection r4 = MmBubbleDirection.TOP;
    L7:
        if ((r44 & 32) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r44 & 64) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r44 & 128) == 0) goto L17;
        long r7 = 6000;
    L19:
        if ((r44 & 256) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r44 & 512) == 0) goto L25;
        Integer r10 = null;
    L27:
        if ((r44 & 1024) == 0) goto L29;
        Integer r11 = null;
    L31:
        if ((r44 & 2048) == 0) goto L33;
        Point r16 = null;
    L35:
        if ((r44 & 4096) == 0) goto L37;
        Function0 r17 = null;
    L39:
        if ((r44 & 8192) == 0) goto L41;
        qub.b r18 = null;
    L43:
        if ((32768 & r44) == 0) goto L45;
        Function0 r1 = null;
    L47:
        if ((r44 & 65536) == 0) goto L49;
        Integer r19 = null;
    L50:
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "anchorView");
        Intrinsics.checkNotNullParameter(r4, "direction");
        Intrinsics.checkNotNullParameter(r41, "uiLaunchMode");
        int r0 = bwb.b.a;
        bwb.b.b(MmUiLogScene.OVERLAY, "showBubble", "title=" + r29 + ", detail=null, uiLaunchMode=" + r41 + ", anchorAttached=" + r28.isAttachedToWindow(), null, 8);
        Context r2 = r27;
    L52:
        if ((r2 instanceof ContextWrapper) == false) goto L57;
        if ((r2 instanceof Activity) == true) goto L55;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L52
    L55:
        Activity r21 = (Activity) r2;
    L58:
        if (r21 != null) goto L60;
        int r3 = bwb.b.a;
        bwb.b.d(MmUiLogScene.OVERLAY, "showBubble", "activity missing, context=".concat(r27.getClass().getName()), null);
        return qub.a.C0180a.a;
    L60:
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        final Ref.BooleanRef r20 = new Ref.BooleanRef();
        Ref.BooleanRef r22 = new Ref.BooleanRef();
        final Ref.ObjectRef r23 = new Ref.ObjectRef();
        final Function0 r34 = r1;
        rub.a r24 = new rub.a(r28, r29, null, r4, r5, r6, r7, r9, r10, r11, r19, r16, r17, new MmRecordingBubbleFactory$showBubble$config$1(r20, r23, r34, r12, r8, r28), r41);
        if (r18 != null) goto L63;
        e.a.getClass();
        qub.b r13 = e.b(r41).getBubble();
    L64:
        a r14 = new a(r20, r22, r23, r13, r21, r24, r12, r8, r28);
        r8.element = r14;
        if (r12.element == true) goto L67;
        r28.addOnAttachStateChangeListener(r14);
        int r15 = bwb.b.a;
        String r25 = "showBubble";
        int r26 = 8;
        String r45 = null;
        bwb.b.b(MmUiLogScene.OVERLAY, r25, "lifecycle listener added", null, 8);
    L69:
        if (r28.isAttachedToWindow() == true) goto L71;
        int r46 = bwb.b.a;
        bwb.b.g(MmUiLogScene.OVERLAY, r25, "anchor not attached, wait for attach", r45, r26);
    L75:
        return new b(r20, r22, r23, r12, r8, r28);
    L71:
        if (d(r20, r22, r23, r13, r21, r24, r12, r8, r28) == true) goto L75;
        return qub.a.C0180a.a;
    L67:
        r25 = "showBubble";
        r26 = 8;
        r45 = null;
        goto L69
    L63:
        r13 = r18;
        goto L64
    L57:
        r21 = null;
        goto L58
    L49:
        r19 = r43;
        goto L50
    L45:
        r1 = r42;
        goto L47
    L41:
        r18 = r40;
        goto L43
    L37:
        r17 = r39;
        goto L39
    L33:
        r16 = r38;
        goto L35
    L29:
        r11 = r37;
        goto L31
    L25:
        r10 = r36;
        goto L27
    L21:
        r9 = r35;
        goto L23
    L17:
        r7 = r33;
        goto L19
    L13:
        r6 = r32;
        goto L15
    L9:
        r5 = r31;
        goto L11
    L5:
        r4 = r30;
        goto L7
    }
}
