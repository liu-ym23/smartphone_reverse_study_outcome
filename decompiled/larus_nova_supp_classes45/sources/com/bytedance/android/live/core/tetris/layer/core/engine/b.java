package com.bytedance.android.live.core.tetris.layer.core.engine;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.RecyclableTetrisElement;
import com.bytedance.android.live.core.tetris.layer.core.layout.LayoutManager;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.v;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import d80.d;
import j70.e;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public boolean a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final f70.a e;
    public final LayoutManager f;
    public final k70.c g;
    public final com.bytedance.android.live.core.tetris.componentx.component.b h;
    public final com.bytedance.android.live.core.tetris.componentx.a i;

    public static final class a implements Runnable {
        public final /* synthetic */ Element a;
        public final /* synthetic */ b b;
        public final /* synthetic */ ViewLayer c;

        public a(Element r1, b r2, ViewLayer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.b;     // Catch: Throwable -> L10
            if (r0.a == true) goto L13;
            com.bytedance.android.live.core.tetris.componentx.component.b r1 = r0.h;     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r1.f(this.a);     // Catch: Throwable -> L10
        L8:
            this.c.S5(this.a);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static int b(ViewGroup r4, ViewLayer r5) {
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Object r2 = r4.getChildAt(r1);
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
        return r4.getChildCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Element<?> a(ViewLayer r4, h<h70.b> r5, h70.b r6) {
        Element<?> r0 = this.g.a(r5.C(r6), (e) r5);
        com.bytedance.android.live.core.tetris.componentx.component.b r1 = this.h;
        if (r1 == null) goto L5;
        r1.a(r0);
    L5:
        View r7 = r0.c(r4.getContext(), null);
        if (r7 != null) goto L8;
    L10:
        r0.b = r7;
        Map<String, String> r8 = r0.g;
        if (r8 != null) goto L13;
        r8 = new LinkedHashMap();
    L13:
        HashMap<String, String> r2 = p.a;
        r8.put("widget_level", p.a(r5.H(r6)));
        r0.setExtraInfo(r8);
        LocalTestManager.a(new Class[]{wy.a.class});
        return r0;
    L8:
        if (r7.getId() != (-1)) goto L10;
        r7.setId(ViewCompat.generateViewId());
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(ViewLayer r11, h70.b r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "layer");
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        if (this.a == false) goto L5;
        return;
    L5:
        System.currentTimeMillis();
        ViewGroup r0 = this.e.a(r11.getLayerTypeV2());
        if (r0.indexOfChild(r11) != (-1)) goto L8;
        r0.addView(r11, b(r0, r11), new FrameLayout.LayoutParams(-1, -1));
    L8:
        int r1 = h70.c.a;
        Objects.toString(r11.getLayerIndex());
        h70.c.a();
        LinkedHashSet r2 = new LinkedHashSet();
        if (v.a() == false) goto L23;
        Iterator<T> r3 = r11.getDescriptorSet().iterator();
    L12:
        if (r3.hasNext() == false) goto L23;
        h r4 = (h) r3.next();
        f r5 = r4.C(r12);
        Iterator<T> r6 = r11.getDescriptorSet().iterator();
    L15:
        if (r6.hasNext() == false) goto L12;
        h r7 = (h) r6.next();
        if ((!Intrinsics.areEqual(r4, r7)) == false) goto L15;
        if (Intrinsics.areEqual(r7.C(r12), r5) == false) goto L15;
        throw new RuntimeException("同一个 ElementType$" + r5 + " 被多个 descriptor 持有：" + r7 + " and " + r4 + '.');
    L23:
        Iterator<T> r8 = r11.getDescriptorSet().iterator();
    L25:
        if (r8.hasNext() == false) goto L30;
        h<h70.b> r9 = (h) r8.next();
        System.currentTimeMillis();
        if (r11.f2(r9.C(r12)) != null) goto L29;
        Element<?> r14 = a(r11, r9, r12);
        r2.add(r14);
        r11.R5(r14);
    L29:
        int r15 = h70.c.a;
        Objects.toString(r9.C(r12));
        System.currentTimeMillis();
        h70.c.a();
        goto L25
    L30:
        Iterator r16 = ((ArrayList) r11.U5(r12)).iterator();
    L31:
        ViewParent r17 = null;
        if (r16.hasNext() == false) goto L75;
        h r18 = (h) r16.next();
        Element<?> r19 = r11.f2(r18.C(r12));
        if (r19 == null) goto L31;
        View r21 = r19.b;
        if (r21 == null) goto L31;
        if (r21.getParent() == null) goto L40;
        if (d.a() == false) goto L31;
        if ((r19 instanceof RecyclableTetrisElement) == false) goto L31;
        View r22 = r19.b;
        if (r22 == null) goto L60;
        ViewParent r23 = r22.getParent();
    L62:
        if ((r23 instanceof ViewGroup) == false) goto L65;
        r17 = r23;
    L65:
        ViewGroup r24 = (ViewGroup) r17;
        if ((!Intrinsics.areEqual(r24, r11)) == false) goto L31;
        if (r24 == null) goto L69;
        r24.removeView(r19.b);
    L69:
        ConstraintLayout.LayoutParams r25 = new ConstraintLayout.LayoutParams(-2, -2);
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L71;
        if (r18.a > r11.getChildCount()) goto L31;
        r11.addView(r19.b, r18.a, r25);
        goto L31
    L71:
        r11.addView(r19.b, r25);
        goto L31
    L60:
        r23 = null;
        goto L62
    L40:
        ConstraintLayout.LayoutParams r26 = new ConstraintLayout.LayoutParams(-2, -2);
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L43;
        if (r18.a > r11.getChildCount()) goto L31;
        r11.addView(r19.b, r18.a, r26);
        goto L31
    L43:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L49;
        com.bytedance.android.live.core.tetris.layer.view.b r27 = r18.K(r12);
        if (r27 == null) goto L49;
        if (r27.c != true) goto L49;
        r11.addView(r19.b, 0, r26);
    L49:
        r11.addView(r19.b, r26);
        goto L31
    L75:
        this.f.c(r11, r12);
        Iterator r110 = r2.iterator();
    L77:
        if (r110.hasNext() == false) goto L93;
        Element<?> r28 = (Element) r110.next();
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L89;
        if (r13 == false) goto L89;
        a r29 = new a(r28, this, r11);
        if (LiveInfraSettingKeys.LIVE_COMPONENT_VIEW_OPT_FIX_ENABLE.getValue().booleanValue() == true) goto L83;
        i0.e(c50.b.b(null), r29);
        goto L77
    L83:
        com.bytedance.android.live.core.tetris.componentx.a r31 = this.i;
        if (r31 == null) goto L77;
        Function1<Runnable, Unit> r32 = r31.d();
        if (r32 == null) goto L77;
        Unit r33 = (Unit) r32.invoke(r29);
    L89:
        com.bytedance.android.live.core.tetris.componentx.component.b r34 = this.h;
        if (r34 == null) goto L92;
        r34.f(r28);
    L92:
        r11.S5(r28);
        goto L77
    L93:
        int r111 = h70.c.a;
        Objects.toString(r11.getLayerIndex());
        System.currentTimeMillis();
        h70.c.a();
    }

    public b(f70.a r2, LayoutManager r3, g70.e r4, com.bytedance.android.live.core.tetris.componentx.component.b r5, ComponentManagerFactory$config$1 r6) {
        Intrinsics.checkNotNullParameter(r2, "layerFactory");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        Intrinsics.checkNotNullParameter(r4, "elementFactory");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.b = LazyKt.lazy(ViewLayerEngineV2$enableElementOpt$2.INSTANCE);
        this.c = LazyKt.lazy(ViewLayerEngineV2$fixCrash$2.INSTANCE);
        this.d = LazyKt.lazy(ViewLayerEngineV2$enableZOrderFirst$2.INSTANCE);
    }
}
