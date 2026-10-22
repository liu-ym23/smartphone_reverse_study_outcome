package k70;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import j70.f;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements c {
    public final ElementBuilderMap a;
    public final LayerEventDispatcher b;
    public final p70.b c;

    /* JADX WARN: Multi-variable type inference failed */
    public final Class<j70.e> b(Class<?> r6) {
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
        Class<j70.e> r3 = r0[r2];
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
    public final Element<?> a(f r3, j70.e r4) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Intrinsics.checkNotNullParameter(r4, "elementAttribute");
        Class<j70.e> r0 = b(r4.getClass());
        Intrinsics.checkNotNull(r0);
        b<? extends j70.e> r1 = this.a.get(r0);
        if (r1 == null) goto L7;
        Element<?> r5 = r1.a(r4);
        LayerEventDispatcher r2 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r5.h = r2;
        p70.b r6 = this.c;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.i = r6;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r5.d = r3;
        return r5;
    L7:
        throw new IllegalArgumentException("There is no ElementBuilder for " + r0 + " .");
    }

    public e(ElementBuilderMap r2, h70.b r3, LayerEventDispatcher r4, p70.b r5) {
        Intrinsics.checkNotNullParameter(r2, "elementBuilderMap");
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        Intrinsics.checkNotNullParameter(r4, "layerEventDispatcher");
        Intrinsics.checkNotNullParameter(r5, "processChains");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        Iterator<Map.Entry<Class<? extends j70.e>, b<? extends j70.e>>> r6 = r2.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        b<? extends j70.e> r7 = r6.next().getValue();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r7.a = r3;
        goto L4
    }
}
