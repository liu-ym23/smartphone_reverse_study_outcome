package com.obric.assistant.omnidetailpage.localmedia;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w {
    public final LinkedHashSet<y> a;
    public final Map<y, Object> b;
    public final Set<y> c;
    public y d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        LinkedHashSet<y> r0 = this.a;
        Set<y> r1 = this.c;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (r1.contains((y) r4) == true) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L9:
        Pair r7 = null;
        if (r6.hasNext() == false) goto L35;
        y r8 = (y) r6.next();
        View r9 = r8.H0();
        boolean r10 = false;
        if (r9.isShown() == true) goto L14;
    L24:
        float r11 = 0.0f;
    L26:
        if (r11 < 0.5f) goto L28;
        r10 = true;
    L28:
        if (r10 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        r7 = TuplesKt.to(r8, Float.valueOf(r11));
    L33:
        if (r7 == null) goto L9;
        r5.add(r7);
        goto L9
    L14:
        if (r9.getWidth() <= 0) goto L24;
        if (r9.getHeight() <= 0) goto L24;
        Rect r12 = new Rect();
        if (r9.getGlobalVisibleRect(r12) == false) goto L24;
        int r13 = RangesKt.coerceAtLeast(r12.width(), 0) * RangesKt.coerceAtLeast(r12.height(), 0);
        int r14 = r9.getWidth() * r9.getHeight();
        if (r14 <= 0) goto L24;
        r11 = r13 / r14;
        goto L26
    L35:
        Iterator r15 = r5.iterator();
        if (r15.hasNext() == true) goto L38;
        Object r16 = null;
    L47:
        Pair r17 = (Pair) r16;
        if (r17 == null) goto L50;
        r7 = (y) r17.getFirst();
    L50:
        if (r7 != null) goto L54;
        b();
        return;
    L54:
        if (Intrinsics.areEqual(this.d, r7) == false) goto L56;
        return;
    L56:
        y r18 = this.d;
        if (r18 == null) goto L59;
        r18.R3();
    L59:
        this.d = r7;
        r7.r0();
        return;
    L38:
        r16 = r15.next();
        if (r15.hasNext() == false) goto L47;
        float r19 = ((Number) ((Pair) r16).getSecond()).floatValue();
    L42:
        Object r20 = r15.next();
        float r21 = ((Number) ((Pair) r20).getSecond()).floatValue();
        if (Float.compare(r19, r21) >= 0) goto L46;
        r16 = r20;
        r19 = r21;
    L46:
        if (r15.hasNext() == true) goto L42;
        goto L47
    }

    public final void b() {
        y r0 = this.d;
        if (r0 == null) goto L5;
        r0.R3();
    L5:
        this.d = null;
    }

    public w() {
        this.a = new LinkedHashSet();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashSet();
    }

    public final void c(y r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        boolean r0 = this.a.remove(r3);
        this.b.remove(r3);
        this.c.remove(r3);
        if (Intrinsics.areEqual(this.d, r3) == false) goto L5;
        this.d = null;
    L5:
        if (r0 == false) goto L8;
        r3.i3();
        return;
    }
}
