package com.bytedance.android.live.core.tetris.layer.core.engine;

import com.bytedance.android.live.core.tetris.layer.core.delegate.ServiceLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import j70.d;
import j70.h;
import j70.i;
import j70.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import k70.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ServiceLayerEngine {
    public final Lazy a;
    public final ElementBuilderMap b;
    public final h70.b c;
    public final com.bytedance.android.live.core.tetris.layer.view.a d;

    public ServiceLayerEngine(ElementBuilderMap r2, h70.b r3, com.bytedance.android.live.core.tetris.layer.view.a r4) {
        Intrinsics.checkNotNullParameter(r2, "elementBuilderMap");
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        Intrinsics.checkNotNullParameter(r4, "layerConfig");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(new ServiceLayerEngine$elementFactory$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(i70.b r4, d<h70.b> r5, h70.b r6) {
        Intrinsics.checkNotNullParameter(r4, "layer");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (r4.f2(r5.C(r6)) == null) goto L5;
        return false;
    L5:
        if ((r5 instanceof i) == false) goto L17;
        ServiceElement r0 = (ServiceElement) ((e) this.a.getValue()).a(r5.C(r6), (j70.e) r5);
        if ((r5 instanceof h) == false) goto L13;
        Map<String, String> r1 = r0.g;
        if (r1 != null) goto L12;
        r1 = new LinkedHashMap();
    L12:
        HashMap<String, String> r2 = p.a;
        r1.put("widget_level", p.a(((h) r5).H(r6)));
        r0.setExtraInfo(r1);
    L13:
        Intrinsics.checkNotNullParameter(r0, "element");
        ServiceLayerDelegate r7 = r4.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "element");
        r7.d.put(r0.d, r0);
        Intrinsics.checkNotNullParameter(r0, "element");
        r4.a.b(r0);
        return true;
    L17:
        return false;
    }

    public final /* bridge */ /* synthetic */ void b(i70.a r1, h70.b r2, boolean r3) {
        c((i70.b) r1, r2, r3);
    }

    public final void c(i70.b r3, h70.b r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "layer");
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        h70.c.a();
        System.currentTimeMillis();
        Iterator<T> r6 = r3.a.e.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        d<h70.b> r0 = (d) r6.next();
        System.currentTimeMillis();
        a(r3, r0, r4);
        int r1 = h70.c.a;
        Objects.toString(r0.C(r4));
        System.currentTimeMillis();
        h70.c.a();
        goto L4
    L6:
        int r7 = h70.c.a;
        System.currentTimeMillis();
        h70.c.a();
    }
}
