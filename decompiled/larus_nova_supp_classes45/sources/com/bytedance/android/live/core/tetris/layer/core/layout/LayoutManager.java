package com.bytedance.android.live.core.tetris.layer.core.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import j70.f;
import j70.g;
import j70.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LayoutManager {
    public final Map<f70.b, Map<f, a>> a;
    public final Map<Integer, ElementConstraint> b;
    public final com.bytedance.android.live.core.tetris.layer.core.layout.a c;

    public static final class a {
        public final int a;
        public final LayerIndex b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            LayerIndex r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "IdAndLayerIndexPair(id=" + this.a + ", layerIndex=" + this.b + ")";
        }

        public a(int r2, LayerIndex r3) {
            Intrinsics.checkNotNullParameter(r3, "layerIndex");
            this.a = r2;
            this.b = r3;
        }
    }

    public LayoutManager(b r2) {
        Intrinsics.checkNotNullParameter(r2, "globalElementCenter");
        this.c = r2;
        this.a = new LinkedHashMap();
        new LinkedHashMap();
        new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final void c(ViewLayer r13, h70.b r14) {
        Intrinsics.checkNotNullParameter(r13, "layer");
        Intrinsics.checkNotNullParameter(r14, "layerContext");
        Iterator<T> r0 = r13.getDescriptorSet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        h r1 = (h) r0.next();
        f70.b r2 = r13.getLayerTypeV2();
        LinkedHashMap r3 = (LinkedHashMap) this.a;
        Object r4 = r3.get(r2);
        if (r4 != null) goto L8;
        r4 = new LinkedHashMap();
        r3.put(r2, r4);
    L8:
        ((Map) r4).put(r1.C(r14), new a(r13.T5(r1.C(r14)), r13.getLayerIndex()));
        goto L4
    L9:
        ConstraintSet r5 = new ConstraintSet();
        r5.clone(r13);
        Iterator<T> r6 = r13.getDescriptorSet().iterator();
    L11:
        if (r6.hasNext() == false) goto L23;
        h r7 = (h) r6.next();
        int r8 = r13.T5(r7.C(r14));
        if (r8 == (-1)) goto L11;
        if (this.b.containsKey(Integer.valueOf(r8)) == false) goto L17;
        Object r9 = ((LinkedHashMap) this.b).get(Integer.valueOf(r8));
        Intrinsics.checkNotNull(r9);
        ElementConstraint r11 = (ElementConstraint) r9;
    L18:
        a(r7.C(r14), r11, r13, r5, r14);
        goto L11
    L17:
        r11 = r7.J(r14);
        goto L18
    L23:
        r5.applyTo(r13);     // Catch: ClassCastException -> L21
        return;
    L21:
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public final void b(f r8, ElementConstraint r9, ViewLayer r11, h70.b r12) {
        Intrinsics.checkNotNullParameter(r8, "startType");
        Intrinsics.checkNotNullParameter(r9, "elementConstraint");
        Intrinsics.checkNotNullParameter(r11, "layer");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ConstraintSet r1 = new ConstraintSet();     // Catch: Throwable -> L5
        r1.clone(r11);     // Catch: Throwable -> L5
        a(r8, r9, r11, r1, r12);     // Catch: Throwable -> L5
        r1.applyTo(r11);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(f r26, ElementConstraint r27, ViewLayer r28, ConstraintSet r29, h70.b r31) {
        List<ElementConstraint.c> r4 = r27.j;
        f70.b r5 = r28.getLayerTypeV2();
        LinkedHashMap r6 = (LinkedHashMap) this.a;
        Object r7 = r6.get(r5);
        if (r7 != null) goto L5;
        r7 = new LinkedHashMap();
        r6.put(r5, r7);
    L5:
        Map r11 = (Map) r7;
        if (r11.containsKey(r26) == true) goto L8;
        r11.put(r26, new a(r28.T5(r26), r28.getLayerIndex()));
    L8:
        Lazy r12 = LazyKt.lazy(LayoutManager$applyWidgetConstraint$globalRuleList$2.INSTANCE);
        a r13 = (a) r11.get(r26);
        if (r13 == null) goto L100;
        int r15 = r13.a;
        this.b.put(Integer.valueOf(r15), r27);
        float r8 = r27.l;
        float r9 = 0;
        if (r8 >= r9) goto L14;
        r29.constrainWidth(r15, (int) r8);
    L17:
        float r14 = r27.m;
        if (r14 >= r9) goto L21;
        r29.constrainHeight(r15, (int) r14);
    L24:
        Iterator r16 = ((ArrayList) r4).iterator();
        boolean r17 = false;
    L26:
        if (r16.hasNext() == false) goto L79;
        ElementConstraint.c r18 = (ElementConstraint.c) r16.next();
        f r19 = r18.b.c;
        if ((r19 instanceof g) == false) goto L42;
        Intrinsics.checkNotNull(r19);
        if (r28.f2(r19) != null) goto L42;
        ((List) r12.getValue()).add(r18);
        int r21 = r18.a;
        if (r21 != 1) goto L34;
        ElementConstraint.c r22 = new ElementConstraint.c(r21, new ElementConstraint.a(f.d), 1, 0.0f, 0, 16);
    L41:
        boolean r110 = true;
    L43:
        ElementConstraint.a r23 = r22.b;
        z70.b r24 = r31.a;
        if (r24 == null) goto L50;
        ElementConstraint.a r25 = r24.b(r23);
        if (r25 == null) goto L50;
        r23 = r25;
    L50:
        if (r23.a == false) goto L56;
        float r32 = r22.d;
        if (r32 == 0.0f) goto L54;
        r29.connect(r15, r22.a, 0, r22.c, s1.f(r32));
    L78:
        r17 = r110;
        goto L26
    L54:
        r29.connect(r15, r22.a, 0, r22.c, r22.e);
        goto L78
    L56:
        if (r23.b == false) goto L58;
        r29.connect(r15, r18.a, -1, r18.c);
        goto L78
    L58:
        a r33 = (a) r11.get(r23.c);
        if (r33 == null) goto L61;
        Integer r34 = Integer.valueOf(r33.a);
    L62:
        r28.getContext();
        LocalTestManager.a(new Class[]{wy.a.class});
        a r35 = (a) r11.get(r23.c);
        if (r35 == null) goto L65;
        LayerIndex r36 = r35.b;
    L67:
        if (r36 == r13.b) goto L73;
        String r37 = r26 + " 和 " + r23.c + " 不在同一个 Layer（#" + r13.b + " vs. #" + r36 + "），或 " + r23.c + " 无法被加载";
        if (v.a() == true) goto L72;
        SafetyGuard.a(null, new RuntimeException(r37), "tetris_layer_exception");
        goto L73
    L72:
        throw new RuntimeException(r37);
    L73:
        if (r34 == null) goto L78;
        r34.intValue();
        if (r18.d == 0.0f) goto L77;
        r29.connect(r15, r18.a, r34.intValue(), r18.c, s1.f(r18.d));
        goto L78
    L77:
        r29.connect(r15, r18.a, r34.intValue(), r18.c, r18.e);
        goto L78
    L65:
        r36 = null;
        goto L67
    L61:
        r34 = null;
        goto L62
    L34:
        if (r21 != 2) goto L36;
        r22 = new ElementConstraint.c(r21, new ElementConstraint.a(f.d), 2, 0.0f, 0, 16);
        goto L41
    L36:
        if (r21 == 3) goto L38;
        r22 = new ElementConstraint.c(r21, new ElementConstraint.a(f.d), 4, 0.0f, 0, 16);
        goto L41
    L38:
        r22 = new ElementConstraint.c(r21, new ElementConstraint.a(f.d), 3, 0.0f, 0, 16);
    L42:
        r110 = r17;
        r22 = r18;
        goto L43
    L79:
        View r38 = r28.findViewById(r15);
        if (r38 == null) goto L99;
        int r39 = r27.i;
        if (r39 != (-1)) goto L84;
        r29.setVisibility(r15, r38.getVisibility());
    L85:
        r38.setPadding((int) r27.c, (int) r27.e, (int) r27.d, (int) r27.f);
        if ((r38 instanceof ViewGroup) == false) goto L88;
        ViewGroup r41 = (ViewGroup) r38;
        r41.setClipChildren(r27.g);
        r41.setClipToPadding(r27.h);
    L88:
        Integer r42 = 0;
        if (r42.intValue() == 0) goto L91;
        boolean r111 = true;
    L92:
        if (r111 == true) goto L95;
        r42 = null;
    L95:
        if (r42 == null) goto L97;
        r38.setBackgroundResource(r42.intValue());
    L97:
        boolean r112 = r17;
    L101:
        if (r112 == false) goto L114;
        Element<?> r1 = r28.f2(r26);
        if (r1 == null) goto L115;
        this.c.c(r28, new com.bytedance.android.live.core.tetris.layer.core.layout.a.C0160a(r1, (List) r12.getValue()));
        return;
    L115:
        return;
    L114:
        return;
    L91:
        r111 = false;
        goto L92
    L84:
        r29.setVisibility(r15, r39);
        r27.i = -1;
        goto L85
    L99:
        throw new NullPointerException(r26 + " 对应的容器没有找到, 请检查");
    L21:
        if (r14 <= r9) goto L23;
        r29.constrainHeight(r15, s1.f(r14));
        goto L24
    L23:
        r29.constrainHeight(r15, r27.b);
        goto L24
    L14:
        if (r8 <= r9) goto L16;
        r29.constrainWidth(r15, s1.f(r8));
        goto L17
    L16:
        r29.constrainWidth(r15, r27.a);
        goto L17
    L100:
        r112 = false;
        goto L101
    }
}
