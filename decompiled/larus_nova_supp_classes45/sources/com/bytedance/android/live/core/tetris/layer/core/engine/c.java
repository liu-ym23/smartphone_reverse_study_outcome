package com.bytedance.android.live.core.tetris.layer.core.engine;

import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.delegate.XMLLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.utils.i0;
import com.larus.apm.impl.protector.RunnableProtector;
import e70.i;
import g70.e;
import j70.d;
import j70.h;
import j70.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final Lazy a;
    public boolean b;
    public final f70.a c;
    public final k70.c d;
    public final com.bytedance.android.live.core.tetris.componentx.component.b e;

    public static final class a implements Runnable {
        public final /* synthetic */ Element a;
        public final /* synthetic */ c b;
        public final /* synthetic */ i70.c c;

        public a(Element r1, c r2, i70.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.b;     // Catch: Throwable -> L10
            if (r0.b == true) goto L13;
            com.bytedance.android.live.core.tetris.componentx.component.b r1 = r0.e;     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r1.f(this.a);     // Catch: Throwable -> L10
        L8:
            i70.c r2 = this.c;     // Catch: Throwable -> L10
            Element<?> r3 = this.a;     // Catch: Throwable -> L10
            r2.getClass();     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r3, "element");     // Catch: Throwable -> L10
            r2.a.b(r3);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public c(f70.a r2, e r3, com.bytedance.android.live.core.tetris.componentx.component.b r4) {
        Intrinsics.checkNotNullParameter(r2, "layerFactory");
        Intrinsics.checkNotNullParameter(r3, "elementFactory");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = LazyKt.lazy(XMLLayerEngine$enableElementOpt$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Element<?> a(d<h70.b> r6, i70.c r7, h70.b r8) {
        if (r7.f2(r6.C(r8)) == null) goto L6;
        return null;
    L6:
        if ((r6 instanceof e70.a) == true) goto L8;
        Object r0 = null;
    L9:
        e70.a r1 = (e70.a) r0;
        if (r1 == null) goto L12;
        e70.d r2 = r1.N();
    L14:
        if ((r2 instanceof i) == true) goto L16;
        r2 = null;
    L16:
        i r3 = (i) r2;
        if (r3 != null) goto L19;
        ViewGroup r4 = null;
    L25:
        if (r4 != null) goto L27;
        return null;
    L27:
        Element<?> r5 = this.d.a(r6.C(r8), (j70.e) r6);
        com.bytedance.android.live.core.tetris.componentx.component.b r9 = this.e;
        if (r9 == null) goto L30;
        r9.a(r5);
    L30:
        r5.b = r4;
        if ((r6 instanceof h) == false) goto L36;
        Map<String, String> r11 = r5.g;
        if (r11 != null) goto L35;
        r11 = new LinkedHashMap();
    L35:
        HashMap<String, String> r12 = p.a;
        r11.put("widget_level", p.a(((h) r6).H(r8)));
        r5.setExtraInfo(r11);
    L36:
        Intrinsics.checkNotNullParameter(r5, "element");
        XMLLayerDelegate r13 = r7.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "element");
        r13.d.put(r5.d, r5);
        return r5;
    L19:
        Integer r14 = r3.w(r8);
        if (r14 == null) goto L22;
        r4 = (ViewGroup) this.c.a(r7.b).findViewById(r14.intValue());
    L23:
        if (r4 != null) goto L25;
        r4 = r3.q(r8);
        goto L25
    L22:
        r4 = null;
        goto L23
    L12:
        r2 = null;
        goto L14
    L8:
        r0 = r6;
        goto L9
    }

    public final void b(i70.c r4, h70.b r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "layer");
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        if (this.b == false) goto L5;
        return;
    L5:
        Set<d<h70.b>> r0 = r4.a.e;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Element<?> r3 = a((d) r2.next(), r4, r5);
        if (r3 == null) goto L7;
        r1.add(r3);
        goto L7
    L12:
        if ((!r1.isEmpty()) == false) goto L24;
        Iterator r7 = r1.iterator();
    L15:
        if (r7.hasNext() == false) goto L37;
        Element<?> r8 = (Element) r7.next();
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L20;
        if (r6 == false) goto L20;
        i0.e(c50.b.b(null), new a(r8, this, r4));
    L20:
        com.bytedance.android.live.core.tetris.componentx.component.b r9 = this.e;
        if (r9 == null) goto L23;
        r9.f(r8);
    L23:
        Intrinsics.checkNotNullParameter(r8, "element");
        r4.a.b(r8);
        goto L15
    L37:
        return;
    }
}
