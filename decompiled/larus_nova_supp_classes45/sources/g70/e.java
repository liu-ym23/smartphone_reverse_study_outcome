package g70;

import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import j70.k;
import j70.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements k70.c {
    public final Map<Class<? extends j70.e>, k70.b<? extends j70.e>> a;
    public final h70.b b;
    public final p70.b c;
    public final LayerEventDispatcher d;
    public final b80.a e;
    public final com.bytedance.android.live.core.tetris.componentx.a f;

    public e(ComponentManagerFactory$config$1 r9) {
        Intrinsics.checkNotNullParameter(r9, "config");
        this.f = r9;
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        this.b = r9.b;
        p70.b r1 = r9.g.f();
        if (r1 != null) goto L5;
        r1 = new p70.b();
    L5:
        this.c = r1;
        com.bytedance.android.live.core.tetris.layer.view.a.C0161a r2 = r9.g.i();
        this.d = r9.g.d();
        b80.a r3 = r9.g.h();
        this.e = r3;
        com.bytedance.android.live.core.tetris.layer.core.element.tetris.a r5 = new com.bytedance.android.live.core.tetris.layer.core.element.tetris.a();
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r5.b = this;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r5.c = r2;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r5.d = r1;
        Unit r7 = Unit.INSTANCE;
        r0.put(k.class, r5);
        com.bytedance.android.live.core.tetris.layer.core.element.container.a r6 = new com.bytedance.android.live.core.tetris.layer.core.element.container.a();
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r6.b = this;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r6.c = r2;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r6.d = r1;
        r6.e = r3;
        r0.put(j70.b.class, r6);
        r0.put(m.class, new m70.a());
        ElementBuilderMap r11 = r9.g.b();
        if (r11 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        r0.putAll(r11);
    L14:
        Iterator r12 = r0.entrySet().iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        k70.b r8 = (k70.b) ((Map.Entry) r12.next()).getValue();
        h70.b r13 = this.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r8.a = r13;
        goto L16
    L18:
        return;
    L8:
        if (r11.isEmpty() == true) goto L11;
        r4 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Class<? extends j70.e> b(Class<?> r6) {
        if (j70.e.class.isAssignableFrom(r6) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r6, Object.class) == false) goto L8;
        return null;
    L8:
        Class<?>[] r0 = r6.getInterfaces();
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L14;
        Class<? extends j70.e> r3 = r0[r2];
        if (j70.e.class.isAssignableFrom(r3) == true) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return r3;
    L14:
        Class<? super Object> r7 = r6.getSuperclass();
        if (r7 == null) goto L19;
        return b(r7);
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    }

    @Override // k70.c
    public final Element<?> a(j70.f r6, j70.e r7) {
        Intrinsics.checkNotNullParameter(r6, "elementType");
        Intrinsics.checkNotNullParameter(r7, "elementAttribute");
        k70.b r1 = null;
        if ((r7 instanceof e70.a) == false) goto L12;
        e70.a r0 = (e70.a) r7;
        Intrinsics.checkNotNullParameter(r0, "$this$toDescriptor");
        e70.f r2 = r0.P();
        if ((r2 instanceof e70.h) == false) goto L8;
        j70.e r3 = new c(this, r2, false);
    L21:
        if (r3 == null) goto L36;
        Class<? extends j70.e> r8 = b(r3.getClass());
        if (r8 == null) goto L25;
        k70.b r4 = (k70.b) ((LinkedHashMap) this.a).get(r8);
    L27:
        if ((r4 instanceof k70.b) == false) goto L30;
        r1 = r4;
    L30:
        if (r1 == null) goto L34;
        Element<?> r9 = r1.a(r3);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r9.d = r6;
        LayerEventDispatcher r11 = this.d;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r9.h = r11;
        p70.b r12 = this.c;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r9.i = r12;
        return r9;
    L34:
        throw new IllegalArgumentException("There is no ElementBuilder for " + r8 + " .");
    L25:
        r4 = null;
        goto L27
    L36:
        throw new IllegalArgumentException("There is no ElementAttribute for " + r7 + " .");
    L8:
        if ((r2 instanceof e70.g) == false) goto L10;
        r3 = new d(r2, false);
    L10:
        r3 = null;
        goto L21
    L12:
        if ((r7 instanceof e70.b) == false) goto L19;
        e70.b r5 = (e70.b) r7;
        Intrinsics.checkNotNullParameter(r5, "$this$toDescriptor");
        e70.f r13 = r5.O();
        if ((r13 instanceof e70.h) == false) goto L17;
        r3 = new c(this, r13, true);
        goto L21
    L17:
        if ((r13 instanceof e70.g) == false) goto L10;
        r3 = new d(r13, true);
        goto L21
    L19:
        r3 = r7;
        goto L21
    }
}
