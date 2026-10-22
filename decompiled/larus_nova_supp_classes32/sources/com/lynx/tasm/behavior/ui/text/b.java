package com.lynx.tasm.behavior.ui.text;

import android.graphics.PointF;
import android.text.Layout;
import android.text.Spanned;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.service.ILynxTextService;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import z6a.h;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static void a(w r4, LynxBaseUI r5) {
        Set r6 = r4.d;
        Iterator<LynxBaseUI> r7 = r5.getChildren().iterator();
    L4:
        if (r7.hasNext() == false) goto L22;
        LynxBaseUI r0 = r7.next();
        if ((r0 instanceof LynxUI) == false) goto L4;
        LynxUI r1 = (LynxUI) r0;
        if (r6 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L18;
        if (r1.getVisibility() == false) goto L18;
        r1.setVisibilityForView(4);
    L18:
        if (r2 == true) goto L4;
        if (r1.getVisibility() == true) goto L4;
        r1.setVisibilityForView(0);
        goto L4
    L11:
        if (r6.contains(Integer.valueOf(r1.getSign())) == false) goto L13;
        r2 = true;
        goto L14
    }

    public static void b(Map<String, EventsListener> r0, int r1, int r2, String r3) {
        if ((r1 & r2) != 0) goto L5;
        return;
    L5:
        ((HashMap) r0).put(r3, null);
    }

    public static EventTarget d(LynxBaseUI r3, float r4, float r5, EventTarget r6, boolean r7) {
        if ((r6 instanceof NativeLayoutNodeRef.a) == false) goto L11;
        Iterator<LynxBaseUI> r8 = r3.getChildren().iterator();
    L6:
        if (r8.hasNext() == false) goto L11;
        LynxBaseUI r0 = r8.next();
        if (r0.getSign() != r6.getSign()) goto L6;
        return r0.hitTest(r4 - r0.getOriginLeft(), r5 - r0.getOriginTop(), r7);
    L11:
        return r6;
    }

    public static EventTarget c(LynxBaseUI r20, float r21, float r22, EventTarget r23, Layout r24, Spanned r25, PointF r26, ILynxTextService.a r27, boolean r28) {
        h[] r9 = null;
        int r10 = 0;
        if (r27 == null) goto L28;
        int[] r4 = r27.e(r21, r22);
        if (r4 == null) goto L27;
        if (r4.length < 3) goto L27;
        int r13 = r4[0];
        int r5 = r4[1];
        if (r4[2] == 0) goto L12;
        r10 = 1;
    L12:
        if (r10 == 0) goto L14;
    L16:
        if (r5 == 0) goto L20;
        HashMap r6 = new HashMap();
        b(r6, r5, 1, LynxTouchEvent.EVENT_TAP);
        b(r6, r5, 2, LynxTouchEvent.EVENT_CLICK);
        b(r6, r5, 4, LynxTouchEvent.EVENT_LONG_PRESS);
        b(r6, r5, 8, LynxTouchEvent.EVENT_TOUCH_START);
        b(r6, r5, 16, LynxTouchEvent.EVENT_TOUCH_MOVE);
        b(r6, r5, 32, LynxTouchEvent.EVENT_TOUCH_END);
        b(r6, r5, 64, LynxTouchEvent.EVENT_TOUCH_CANCEL);
        if (r6.isEmpty() == true) goto L20;
        HashMap r14 = r6;
    L22:
        if (r10 == 0) goto L24;
        EventTarget.EnableStatus r17 = EventTarget.EnableStatus.Undefined;
        h r7 = new NativeLayoutNodeRef.a(r13, r14, r17, true, r17, EventTarget.PointerEventsValue.Unset, new JavaOnlyMap());
    L25:
        r7.c = new WeakReference(r23);
        return d(r20, r21, r22, r7, r28);
    L24:
        EventTarget.EnableStatus r18 = EventTarget.EnableStatus.Undefined;
        r7 = new h(r13, r14, r18, true, r18, EventTarget.PointerEventsValue.Unset, new JavaOnlyMap());
    L20:
        r14 = null;
        goto L22
    L14:
        if (r13 != r23.getSign()) goto L16;
    L27:
        return r23;
    L28:
        if (r24 != null) goto L30;
    L68:
        return r23;
    L30:
        if (r21 > r24.getWidth()) goto L68;
        if (r22 > r24.getHeight()) goto L68;
        int r8 = r24.getLineForVertical((int) r22);
        int r12 = r24.getParagraphDirection(r8);
        float r15 = r21 - r26.x;
        float r11 = r22 - r26.y;
        if (r11 > r24.getLineBottom(r8)) goto L68;
        if (r11 < r24.getLineTop(r8)) goto L68;
        if (r15 < r24.getLineLeft(r8)) goto L68;
        if (r15 > r24.getLineRight(r8)) goto L68;
        int r16 = r24.getOffsetForHorizontal(r8, r15);
        float r19 = r24.getPrimaryHorizontal(r16);
        if (r12 != 1) goto L49;
        if (r15 < r19) goto L50;
    L51:
        if (r25 == null) goto L53;
        r9 = (h[]) r25.getSpans(r16, r16, h.class);
    L53:
        if (r9 == null) goto L68;
        if (r9.length == 0) goto L68;
        int r29 = r25.length();
        int r30 = r9.length;
        EventTarget r110 = r23;
        int r111 = 0;
    L58:
        if (r10 >= r30) goto L67;
        h r112 = r9[r10];
        r112.getClass();
        r112.c = new WeakReference(r23);
        int r113 = r25.getSpanStart(r112);
        int r114 = r25.getSpanEnd(r112);
        if (r16 < r113) goto L65;
        if (r16 > r114) goto L65;
        if (r113 < r111) goto L65;
        if (r114 > r29) goto L65;
        r112.c = new WeakReference(r23);
        r110 = r112;
    L65:
        r10 = r10 + 1;
        r111 = r113;
        r29 = r114;
        goto L58
    L67:
        return d(r20, r21, r22, r110, r28);
    L50:
        r16 = r16 - 1;
        goto L51
    L49:
        if (r15 < r19) goto L51;
        goto L50
    }
}
