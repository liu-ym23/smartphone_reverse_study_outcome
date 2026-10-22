package com.bytedance.android.live.core.tetris.layer.core.engine;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.RecyclableTetrisElement;
import com.bytedance.android.live.core.tetris.layer.core.layout.LayoutManager;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import d80.d;
import j70.f;
import j70.h;
import j70.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import k70.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ViewLayerEngine {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public DataCenter e;
    public final LayoutManager f;
    public final ElementBuilderMap g;
    public final ViewGroup h;
    public final h70.b i;
    public final com.bytedance.android.live.core.tetris.layer.view.a j;

    public static final class a implements Runnable {
        public final /* synthetic */ Element a;
        public final /* synthetic */ ViewLayer b;

        public a(Element r1, ViewLayer r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.S5(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int b(ViewLayer r5) {
        int r0 = this.h.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Object r2 = this.h.getChildAt(r1);
        if ((r2 instanceof ViewLayer) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L12;
        if (((ViewLayer) r2).getLayerIndex().compareTo(r5.getLayerIndex()) <= 0) goto L12;
        return r1;
    L12:
        r1 = r1 + 1;
        goto L3
    L14:
        return this.h.getChildCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Element<?> a(ViewLayer r4, h<h70.b> r5, h70.b r6) {
        Intrinsics.checkNotNullParameter(r4, "layer");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        f r0 = r5.C(r6);
        Element<?> r1 = ((e) this.a.getValue()).a(r0, (j70.e) r5);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r1.d = r0;
        View r7 = r1.c(r4.getContext(), null);
        if (r7 != null) goto L5;
    L7:
        r1.b = r7;
        Map<String, String> r8 = r1.g;
        if (r8 != null) goto L10;
        r8 = new LinkedHashMap();
    L10:
        HashMap<String, String> r2 = p.a;
        r8.put("widget_level", p.a(r5.H(r6)));
        r1.setExtraInfo(r8);
        LocalTestManager.a(new Class[]{wy.a.class});
        return r1;
    L5:
        if (r7.getId() != (-1)) goto L7;
        r7.setId(ViewCompat.generateViewId());
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(ViewLayer r11, h70.b r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "layer");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        System.currentTimeMillis();
        if (this.h.indexOfChild(r11) != (-1)) goto L5;
        this.h.addView(r11, b(r11), new FrameLayout.LayoutParams(-1, -1));
    L5:
        int r0 = h70.c.a;
        Objects.toString(r11.getLayerIndex());
        h70.c.a();
        LinkedHashSet r1 = new LinkedHashSet();
        if (v.a() == false) goto L20;
        Iterator<T> r2 = r11.getDescriptorSet().iterator();
    L9:
        if (r2.hasNext() == false) goto L20;
        h r3 = (h) r2.next();
        f r4 = r3.C(r12);
        Iterator<T> r5 = r11.getDescriptorSet().iterator();
    L12:
        if (r5.hasNext() == false) goto L9;
        h r6 = (h) r5.next();
        if ((!Intrinsics.areEqual(r3, r6)) == false) goto L12;
        if (Intrinsics.areEqual(r6.C(r12), r4) == false) goto L12;
        throw new RuntimeException("同一个 ElementType$" + r4 + " 被多个 descriptor 持有：" + r6 + " and " + r3 + '.');
    L20:
        Iterator<T> r7 = r11.getDescriptorSet().iterator();
    L22:
        if (r7.hasNext() == false) goto L27;
        h<h70.b> r8 = (h) r7.next();
        System.currentTimeMillis();
        if (r11.f2(r8.C(r12)) != null) goto L26;
        Element<?> r9 = a(r11, r8, r12);
        r1.add(r9);
        r11.R5(r9);
    L26:
        int r14 = h70.c.a;
        Objects.toString(r8.C(r12));
        System.currentTimeMillis();
        h70.c.a();
        goto L22
    L27:
        Iterator r15 = ((ArrayList) r11.U5(r12)).iterator();
    L29:
        if (r15.hasNext() == false) goto L72;
        h r16 = (h) r15.next();
        Element<?> r17 = r11.f2(r16.C(r12));
        if (r17 == null) goto L29;
        View r18 = r17.b;
        if (r18 == null) goto L29;
        if (r18.getParent() == null) goto L37;
        if (d.a() == false) goto L29;
        if ((r17 instanceof RecyclableTetrisElement) == false) goto L29;
        View r19 = r17.b;
        ViewParent r21 = null;
        if (r19 == null) goto L57;
        ViewParent r22 = r19.getParent();
    L59:
        if ((r22 instanceof ViewGroup) == false) goto L62;
        r21 = r22;
    L62:
        ViewGroup r23 = (ViewGroup) r21;
        if ((!Intrinsics.areEqual(r23, r11)) == false) goto L29;
        if (r23 == null) goto L66;
        r23.removeView(r17.b);
    L66:
        ConstraintLayout.LayoutParams r24 = new ConstraintLayout.LayoutParams(-2, -2);
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L68;
        if (r16.a > r11.getChildCount()) goto L29;
        r11.addView(r17.b, r16.a, r24);
        goto L29
    L68:
        r11.addView(r17.b, r24);
        goto L29
    L57:
        r22 = null;
        goto L59
    L37:
        ConstraintLayout.LayoutParams r25 = new ConstraintLayout.LayoutParams(-2, -2);
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L40;
        if (r16.a > r11.getChildCount()) goto L29;
        r11.addView(r17.b, r16.a, r25);
        goto L29
    L40:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L46;
        com.bytedance.android.live.core.tetris.layer.view.b r26 = r16.K(r12);
        if (r26 == null) goto L46;
        if (r26.c != true) goto L46;
        r11.addView(r17.b, 0, r25);
    L46:
        r11.addView(r17.b, r25);
        goto L29
    L72:
        this.f.c(r11, this.j.a());
        Iterator r110 = r1.iterator();
    L74:
        if (r110.hasNext() == false) goto L80;
        Element r27 = (Element) r110.next();
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L79;
        if (r13 == false) goto L79;
        i0.e(c50.b.b(this.e), new a(r27, r11));
    L79:
        r11.S5(r27);
        goto L74
    L80:
        int r111 = h70.c.a;
        Objects.toString(r11.getLayerIndex());
        System.currentTimeMillis();
        h70.c.a();
    }

    public final /* bridge */ /* synthetic */ void d(i70.a r1, h70.b r2, boolean r3) {
        c((ViewLayer) r1, r2, r3);
    }

    public ViewLayerEngine(LayoutManager r2, ElementBuilderMap r3, ViewGroup r4, h70.b r5, com.bytedance.android.live.core.tetris.layer.view.a r6) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        Intrinsics.checkNotNullParameter(r3, "elementBuilderMap");
        Intrinsics.checkNotNullParameter(r4, "layerMasterView");
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        Intrinsics.checkNotNullParameter(r6, "layerConfig");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.a = LazyKt.lazy(new ViewLayerEngine$elementFactory$2(this));
        this.b = LazyKt.lazy(ViewLayerEngine$enableElementOpt$2.INSTANCE);
        this.c = LazyKt.lazy(ViewLayerEngine$fixCrash$2.INSTANCE);
        this.d = LazyKt.lazy(ViewLayerEngine$enableZOrderFirst$2.INSTANCE);
    }
}
