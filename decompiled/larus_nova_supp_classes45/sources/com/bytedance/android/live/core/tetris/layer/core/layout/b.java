package com.bytedance.android.live.core.tetris.layer.core.layout;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.s1;
import j70.f;
import j70.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements com.bytedance.android.live.core.tetris.layer.core.layout.a, e {
    public final Map<ViewLayer, HashSet<Element<?>>> a;
    public final Map<f, Element<?>> b;
    public final Map<ViewLayer, Set<com.bytedance.android.live.core.tetris.layer.core.layout.a.C0160a>> c;
    public final Map<View, a> d;
    public final Map<f, HashSet<Element<?>>> e;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "WidgetInfo(left=" + this.a + ", right=" + this.b + ", top=" + this.c + ", bottom=" + this.d + ")";
        }

        public a(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public b() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final boolean a(ViewLayer r2) {
        Intrinsics.checkNotNullParameter(r2, "layer");
        HashSet r3 = (HashSet) ((LinkedHashMap) this.a).get(r2);
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.size());
    L6:
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.intValue() <= 0) goto L10;
        return true;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final boolean b(ViewLayer r2) {
        Intrinsics.checkNotNullParameter(r2, "layer");
        Set r3 = (Set) ((LinkedHashMap) this.c).get(r2);
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.size());
    L6:
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.intValue() <= 0) goto L10;
        return true;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.e
    public final void e(ViewLayer r8) {
        Intrinsics.checkNotNullParameter(r8, "layer");
        HashSet r0 = (HashSet) ((LinkedHashMap) this.a).get(r8);
        if (r0 == null) goto L43;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L56;
        Element r2 = (Element) r1.next();
        View r3 = r2.b;
        if (r3 == null) goto L6;
        IConstraintWidgetService r4 = (IConstraintWidgetService) k.f(IConstraintWidgetService.class);
        if (r4 == null) goto L12;
        a r5 = r4.getViewWidget(r8, r3);
    L13:
        if (r5 == null) goto L6;
        a r6 = (a) ((LinkedHashMap) this.d).get(r3);
        if (r6 != null) goto L18;
    L42:
        this.d.put(r3, r5);
        goto L6
    L18:
        if (r5.a == r6.a) goto L20;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == false) goto L42;
        Map<f, HashSet<Element<?>>> r9 = this.e;
        LinkedHashMap r11 = (LinkedHashMap) r9;
        HashSet r12 = (HashSet) r11.get(r2.d);
        if (r12 == null) goto L37;
        Iterator r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L37;
        View r14 = ((Element) r13.next()).b;
        if (r14 == null) goto L33;
        r14.requestLayout();
    L37:
        View r15 = r2.b;
        if (r15 == null) goto L42;
        ViewParent r16 = r15.getParent();
        if (r16 == null) goto L42;
        r16.requestLayout();
        goto L42
    L20:
        if (r5.b != r6.b) goto L27;
        if (r5.c != r6.c) goto L27;
        if (r5.d != r6.d) goto L27;
        r7 = false;
        goto L28
    L12:
        r5 = null;
        goto L13
    L56:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.e
    public final void f(ViewLayer r17) {
        b r0 = this;
        Intrinsics.checkNotNullParameter(r17, "layer");
        Set r2 = (Set) ((LinkedHashMap) r0.c).get(r17);
        if (r2 == null) goto L75;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L100;
        com.bytedance.android.live.core.tetris.layer.core.layout.a.C0160a r4 = (com.bytedance.android.live.core.tetris.layer.core.layout.a.C0160a) r3.next();
        View r5 = r4.a.b;
        if (r5 == null) goto L72;
        ConstraintLayout.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L74;
        ConstraintLayout.LayoutParams r7 = r6;
        int r8 = ((ViewGroup.MarginLayoutParams) r7).leftMargin;
        int r9 = ((ViewGroup.MarginLayoutParams) r7).rightMargin;
        int r11 = ((ViewGroup.MarginLayoutParams) r7).topMargin;
        int r12 = ((ViewGroup.MarginLayoutParams) r7).bottomMargin;
        Iterator<T> r13 = r4.b.iterator();
    L14:
        if (r13.hasNext() == false) goto L64;
        ElementConstraint.c r14 = (ElementConstraint.c) r13.next();
        f r15 = r14.b.c;
        if ((r15 instanceof g) == false) goto L62;
        Element r16 = (Element) ((LinkedHashMap) r0.b).get(r15);
        if (r16 == null) goto L62;
        View r18 = r16.b;
        if (r18 == null) goto L21;
        ConstraintLayout r19 = r18.getParent();
        if (r19 == null) goto L61;
        ConstraintLayout r110 = (ViewLayer) r19;
        IConstraintWidgetService r111 = (IConstraintWidgetService) k.f(IConstraintWidgetService.class);
        if (r111 == null) goto L27;
        a r112 = r111.getViewWidget(r110, r18);
    L28:
        if (r112 == null) goto L62;
        int r113 = (int) s1.e(r14.d);
        if (r113 >= 0) goto L33;
        r113 = 0;
    L33:
        int r114 = r14.a;
        if (r114 == 1) goto L55;
        if (r114 != 2) goto L37;
        int r115 = r14.c;
        if (r115 != 1) goto L53;
        int r1 = r110.getMeasuredWidth();
        int r21 = r112.b;
        ((ViewGroup.MarginLayoutParams) r7).rightMargin = ((r1 - r21) + (r21 - r112.a)) + r113;
        goto L62
    L53:
        if (r115 != 2) goto L62;
        ((ViewGroup.MarginLayoutParams) r7).rightMargin = (r110.getMeasuredWidth() - r112.b) + r113;
        goto L62
    L37:
        if (r114 == 3) goto L45;
        if (r114 != 4) goto L62;
        int r116 = r14.c;
        if (r116 != 3) goto L43;
        ((ViewGroup.MarginLayoutParams) r7).bottomMargin = ((r110.getMeasuredHeight() - r112.d) + r18.getHeight()) + r113;
        goto L62
    L43:
        if (r116 != 4) goto L62;
        ((ViewGroup.MarginLayoutParams) r7).bottomMargin = (r110.getMeasuredHeight() - r112.d) + r113;
        goto L62
    L45:
        int r117 = r14.c;
        if (r117 != 3) goto L48;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r112.c + r113;
        goto L62
    L48:
        if (r117 != 4) goto L62;
        int r22 = r112.c;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = (r22 + (r112.d - r22)) + r113;
        goto L62
    L55:
        int r118 = r14.c;
        if (r118 != 1) goto L58;
        ((ViewGroup.MarginLayoutParams) r7).leftMargin = r112.a + r113;
        goto L62
    L58:
        if (r118 != 2) goto L62;
        int r23 = r112.a;
        ((ViewGroup.MarginLayoutParams) r7).leftMargin = (r23 + (r112.b - r23)) + r113;
        goto L62
    L27:
        r112 = null;
        goto L28
    L61:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.ViewLayer");
    L21:
        return;
    L62:
        r0 = this;
        goto L14
    L64:
        if (((ViewGroup.MarginLayoutParams) r7).leftMargin == r8) goto L66;
    L71:
        r5.requestLayout();
        r17.requestLayout();
        goto L72
    L66:
        if (((ViewGroup.MarginLayoutParams) r7).rightMargin != r9) goto L71;
        if (((ViewGroup.MarginLayoutParams) r7).topMargin != r11) goto L71;
        if (((ViewGroup.MarginLayoutParams) r7).bottomMargin == r12) goto L72;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L72:
        r0 = this;
        goto L6
    L100:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final void c(ViewLayer r5, com.bytedance.android.live.core.tetris.layer.core.layout.a.C0160a r6) {
        Intrinsics.checkNotNullParameter(r5, "layer");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        if (this.c.containsKey(r5) == false) goto L5;
        Object r7 = ((LinkedHashMap) this.c).get(r5);
        Intrinsics.checkNotNull(r7);
        Set r8 = (Set) r7;
    L6:
        Iterator<T> r0 = r6.b.iterator();
    L8:
        if (r0.hasNext() == false) goto L19;
        f r1 = ((ElementConstraint.c) r0.next()).b.c;
        if ((r1 instanceof g) == false) goto L8;
        if (r1 == null) goto L18;
        g r2 = (g) r1;
        if (this.e.containsKey(r2) == false) goto L15;
        Object r3 = ((LinkedHashMap) this.e).get(r2);
        Intrinsics.checkNotNull(r3);
        HashSet<Element<?>> r4 = (HashSet) r3;
    L16:
        r4.add(r6.a);
        goto L8
    L15:
        HashSet<Element<?>> r9 = new HashSet();
        this.e.put(r2, r9);
        r4 = r9;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.GlobalElementType");
    L19:
        r8.remove(r6);
        r8.add(r6);
        return;
    L5:
        HashSet r11 = new HashSet();
        this.c.put(r5, r11);
        r8 = r11;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final void d(ViewLayer r3, Element<?> r4) {
        Intrinsics.checkNotNullParameter(r3, "layer");
        Intrinsics.checkNotNullParameter(r4, "element");
        f r0 = r4.d;
        if ((r0 instanceof g) == false) goto L10;
        this.b.put(r0, r4);
        if (this.a.containsKey(r3) == false) goto L7;
        Object r5 = ((LinkedHashMap) this.a).get(r3);
        Intrinsics.checkNotNull(r5);
        HashSet<Element<?>> r6 = (HashSet) r5;
    L8:
        r6.add(r4);
        return;
    L7:
        HashSet<Element<?>> r1 = new HashSet();
        this.a.put(r3, r1);
        r6 = r1;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final void g(Element<?> r3, ViewLayer r4) {
        Intrinsics.checkNotNullParameter(r3, "startElement");
        Intrinsics.checkNotNullParameter(r4, "layer");
        Set r0 = (Set) ((LinkedHashMap) this.c).get(r4);
        if (r0 == null) goto L11;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((com.bytedance.android.live.core.tetris.layer.core.layout.a.C0160a) r1.next()).a, r3) == false) goto L6;
        r1.remove();
    L11:
        if ((r3.d instanceof g) == false) goto L25;
        HashSet r5 = (HashSet) ((LinkedHashMap) this.a).get(r4);
        if (r5 == null) goto L15;
        r5.remove(r3);
    L15:
        this.b.remove(r3.d);
        View r6 = r3.b;
        if (r6 == null) goto L18;
        a r7 = this.d.remove(r6);
    L18:
        this.e.remove(r3.d);
        return;
    }
}
