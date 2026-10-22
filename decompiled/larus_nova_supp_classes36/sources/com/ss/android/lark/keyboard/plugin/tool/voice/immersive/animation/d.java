package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final ConstraintLayout a;
    public final HashMap<Integer, b> b;
    public final ConstraintSet c;

    public d() {
        throw null;
    }

    public d(ConstraintLayout r3) {
        HashMap<Integer, b> r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r0, "elementsStateMap");
        this.a = r3;
        this.b = r0;
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r3);
        this.c = r1;
    }

    public static void b(d r12) {
        Iterator<Map.Entry<Integer, b>> r0 = r12.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L89;
        Map.Entry<Integer, b> r1 = r0.next();
        int r2 = r1.getKey().intValue();
        b r3 = r1.getValue();
        Integer r4 = r3.c.get(0);
        if (r4 == null) goto L8;
        int r5 = r4.intValue();
        r12.c.connect(r2, 6, r5, 6);
    L8:
        Integer r6 = r3.c.get(1);
        if (r6 == null) goto L14;
        int r7 = r6.intValue();
        if (r7 != (-1)) goto L13;
        r12.c.clear(r2, 6);
        goto L14
    L13:
        r12.c.connect(r2, 6, r7, 7);
    L14:
        Integer r8 = r3.c.get(2);
        if (r8 == null) goto L20;
        int r9 = r8.intValue();
        if (r9 != (-1)) goto L19;
        r12.c.clear(r2, 7);
        goto L20
    L19:
        r12.c.connect(r2, 7, r9, 7);
    L20:
        Integer r10 = r3.c.get(3);
        if (r10 == null) goto L23;
        int r11 = r10.intValue();
        r12.c.connect(r2, 7, r11, 6);
    L23:
        Integer r13 = r3.c.get(4);
        if (r13 == null) goto L29;
        int r14 = r13.intValue();
        if (r14 != (-1)) goto L28;
        r12.c.clear(r2, 1);
        goto L29
    L28:
        r12.c.connect(r2, 1, r14, 1);
    L29:
        Integer r15 = r3.c.get(5);
        if (r15 == null) goto L32;
        int r16 = r15.intValue();
        r12.c.connect(r2, 1, r16, 2);
    L32:
        Integer r17 = r3.c.get(6);
        if (r17 == null) goto L38;
        int r18 = r17.intValue();
        if (r18 != (-1)) goto L37;
        r12.c.clear(r2, 2);
        goto L38
    L37:
        r12.c.connect(r2, 2, r18, 2);
    L38:
        Integer r19 = r3.c.get(7);
        if (r19 == null) goto L41;
        int r20 = r19.intValue();
        r12.c.connect(r2, 2, r20, 1);
    L41:
        Integer r21 = r3.c.get(8);
        if (r21 == null) goto L47;
        int r22 = r21.intValue();
        if (r22 != (-1)) goto L46;
        r12.c.clear(r2, 3);
        goto L47
    L46:
        r12.c.connect(r2, 3, r22, 3);
    L47:
        Integer r23 = r3.c.get(9);
        if (r23 == null) goto L50;
        int r24 = r23.intValue();
        r12.c.connect(r2, 3, r24, 4);
    L50:
        Integer r25 = r3.c.get(10);
        if (r25 == null) goto L56;
        int r26 = r25.intValue();
        if (r26 != (-1)) goto L55;
        r12.c.clear(r2, 4);
        goto L56
    L55:
        r12.c.connect(r2, 4, r26, 4);
    L56:
        Integer r27 = r3.c.get(11);
        if (r27 == null) goto L59;
        int r28 = r27.intValue();
        r12.c.connect(r2, 4, r28, 3);
    L59:
        Integer r29 = r3.c.get(12);
        if (r29 == null) goto L62;
        int r30 = r29.intValue();
        r12.c.setMargin(r2, 1, r30);
    L62:
        Integer r31 = r3.c.get(13);
        if (r31 == null) goto L65;
        int r32 = r31.intValue();
        r12.c.setMargin(r2, 2, r32);
    L65:
        Integer r33 = r3.c.get(14);
        if (r33 == null) goto L68;
        int r34 = r33.intValue();
        r12.c.setMargin(r2, 3, r34);
    L68:
        Integer r35 = r3.c.get(15);
        if (r35 == null) goto L71;
        int r36 = r35.intValue();
        r12.c.setMargin(r2, 4, r36);
    L71:
        Integer r37 = r3.c.get(16);
        if (r37 == null) goto L74;
        int r38 = r37.intValue();
        r12.c.setMargin(r2, 6, r38);
    L74:
        Integer r39 = r3.c.get(17);
        if (r39 == null) goto L77;
        int r40 = r39.intValue();
        r12.c.setMargin(r2, 7, r40);
    L77:
        Integer r41 = r3.c.get(30);
        if (r41 == null) goto L80;
        int r42 = r41.intValue();
        r12.c.constrainWidth(r2, r42);
    L80:
        Integer r43 = r3.c.get(31);
        if (r43 == null) goto L83;
        int r44 = r43.intValue();
        r12.c.constrainHeight(r2, r44);
    L83:
        r12.c.setVisibility(r2, r3.d);
        Integer r45 = r3.c.get(100);
        if (r45 == null) goto L86;
        r45.intValue();
        r12.c.setHorizontalBias(r2, r3.e);
    L86:
        Integer r46 = r3.c.get(101);
        if (r46 == null) goto L4;
        int r47 = r46.intValue();
        r12.c.setHorizontalChainStyle(r2, r47);
        goto L4
    }

    public final void a(b r3) {
        Intrinsics.checkNotNullParameter(r3, "motionConstraint");
        this.b.put(Integer.valueOf(r3.a), r3);
    }
}
