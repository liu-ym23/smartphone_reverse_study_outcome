package com.bytedance.android.live.core.tetris.componentx.component;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.componentx.schedule.InnerComponentListener;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.f;
import j70.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ComponentCenter implements b {
    public final h70.b a;
    public final List<c> b;
    public final Map<String, WeakReference<h<h70.b>>> c;
    public final Map<String, WeakReference<d70.a<h70.b>>> d;
    public final Map<String, a<g70.h>> e;
    public final com.bytedance.android.live.core.tetris.componentx.component.a f;
    public final com.bytedance.android.live.core.tetris.componentx.a g;
    public final c h;

    public static final class a<T> extends WeakReference<T> {
        public int a;

        public a(g70.h r1) {
            super(r1);
        }
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void c(Element<?> r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "element");
        Intrinsics.checkNotNullParameter(r3, "originComponent");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void f(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
    }

    public final void h() {
        g(ComponentCenter$onDestroy$1.INSTANCE);
        Iterator r0 = ((LinkedHashMap) this.e).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        g70.h r1 = (g70.h) ((a) ((Map.Entry) r0.next()).getValue()).get();
        if (r1 == null) goto L4;
        r1.a(this.f);
        goto L4
    L8:
        ((LinkedHashMap) this.e).clear();
        Iterator r2 = ((LinkedHashMap) this.d).entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L16;
        d70.a r3 = (d70.a) ((WeakReference) ((Map.Entry) r2.next()).getValue()).get();
        if (r3 == null) goto L10;
        if (Intrinsics.areEqual(r3.getComponentContext(), this.a) == false) goto L10;
        r3.setComponentContext(null);
        r3.setElementType(null);
        goto L10
    L16:
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.d).clear();
        ((ArrayList) this.b).clear();
    }

    public final void i() {
        c r0 = this.h;
        if (r0 == null) goto L5;
        ((ArrayList) this.b).add(r0);
    L5:
        List r1 = this.g.a().a.n;
        if (r1 == null) goto L8;
        ArrayList r2 = (ArrayList) this.b;
        r2.addAll(r1);
    L8:
        g(new ComponentCenter$onInit$3(this));
    }

    public static d70.a l(Object r1) {
        if ((r1 instanceof d70.a) == true) goto L6;
        r1 = null;
    L6:
        return (d70.a) r1;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void a(final Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        r2.c = this;
        g(new ComponentCenter$onCreateElement$1(r2));
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void b(final Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        r2.c = null;
        g(new ComponentCenter$onRemoveElement$1(r2));
    }

    public final void g(Function1<? super c, Unit> r3) {
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke((c) r0.next());
        goto L4
    }

    public final void j(final LayerDescriptorList r6) {
        Intrinsics.checkNotNullParameter(r6, "descriptors");
        Iterator<h<? extends h70.b>> r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        h<? extends h70.b> r1 = r0.next();
        this.c.put(r1.toString(), new WeakReference(r1));
        goto L4
    L6:
        g(new ComponentCenter$onLoadDescriptor$2(this, r6));
    }

    public final void k(final f r5) {
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Intrinsics.checkNotNullParameter(r5, "elementType");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) r0.next();
        h r3 = (h) ((WeakReference) r1.getValue()).get();
        if (r3 == null) goto L9;
        r2 = r3.C(this.a);
    L9:
        if (Intrinsics.areEqual(r2, r5) == false) goto L3;
        r2 = (h) ((WeakReference) r1.getValue()).get();
    L11:
        if (r2 == null) goto L13;
        WeakReference<h<h70.b>> r4 = this.c.remove(r2.toString());
    L13:
        g(new ComponentCenter$onRemoveDescriptor$2(r5));
    }

    public ComponentCenter(ComponentManagerFactory$config$1 r2, InnerComponentListener r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.g = r2;
        this.h = r3;
        this.a = r2.b;
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new com.bytedance.android.live.core.tetris.componentx.component.a(this);
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void d(final Element<?> r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r6, "originComponent");
        final d70.a r7 = l(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        r7.setElementType(r5.d);
        r7.setComponentContext(this.a);
        Lifecycle r0 = r5.g();
        if ((r0 instanceof g70.h) == true) goto L8;
        r0 = null;
    L8:
        g70.h r1 = (g70.h) r0;
        if (r1 == null) goto L19;
        String r2 = r1.toString();
        if (this.e.containsKey(r2) == true) goto L16;
        r1.c(this.f);
        this.e.put(r2, new a(r1));
        a r3 = (a) ((LinkedHashMap) this.e).get(r2);
        if (r3 == null) goto L19;
        r3.a++;
        goto L19
    L16:
        a r4 = (a) ((LinkedHashMap) this.e).get(r2);
        if (r4 == null) goto L19;
        r4.a++;
    L19:
        this.d.put(r7.toString(), new WeakReference(r7));
        g(new ComponentCenter$onCreateComponent$1(r5, r7));
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void e(final Element<?> r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "element");
        Intrinsics.checkNotNullParameter(r4, "originComponent");
        final d70.a r5 = l(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        g(new ComponentCenter$onRemoveComponent$1(r3, r5));
        g70.h r1 = null;
        if (Intrinsics.areEqual(r5.getComponentContext(), this.a) == false) goto L8;
        r5.setComponentContext(null);
        r5.setElementType(null);
    L8:
        g70.h r6 = r3.g();
        if ((r6 instanceof g70.h) == false) goto L12;
        r1 = r6;
    L12:
        g70.h r2 = r1;
        if (r2 == null) goto L24;
        String r7 = r2.toString();
        a r0 = (a) ((LinkedHashMap) this.e).get(r7);
        if (r0 == null) goto L24;
        int r8 = r0.a - 1;
        r0.a = r8;
        if (r8 > 0) goto L24;
        a<g70.h> r9 = this.e.remove(r7);
        if (r9 == null) goto L24;
        g70.h r11 = r9.get();
        if (r11 == null) goto L24;
        r11.a(this.f);
    L24:
        this.d.remove(r5.toString());
    }
}
