package com.bytedance.ai.bridge.method.calendar.remote;

import com.bytedance.ai.utils.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p3.f;
import p3.h;
import p3.j;
import p3.k;
import p3.l;
import p3.m;
import p3.n;
import p3.o;
import p3.q;
import p3.r;
import p3.s;
import p3.t;
import p3.u;
import p3.v;
import p3.w;
import p3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;
    public static final Map<Property.NodeInfo, e> b = null;

    public d() {
    }

    static {
        a = new d();
        b = new LinkedHashMap();
        g.a.i("CalDavClient", "init PropertyFactory");
        Property.NodeInfo r1 = p3.b.c;
        Property.NodeInfo r10 = p3.d.c;
        Property.NodeInfo r11 = f.c;
        Property.NodeInfo r12 = h.c;
        Property.NodeInfo r13 = m.c;
        Property.NodeInfo r14 = k.c;
        Property.NodeInfo r15 = o.c;
        Property.NodeInfo r16 = r.c;
        Property.NodeInfo r17 = v.c;
        Property.NodeInfo r18 = x.c;
        Property.NodeInfo r19 = t.c;
        List r0 = CollectionsKt.listOf(new e[]{new p3.a(), new p3.c(), new p3.e(), new p3.g(), new l(), new j(), new n(), new q(), new u(), new w(), new s()});
        Intrinsics.checkNotNullParameter(r0, "factories");
        Iterator r20 = r0.iterator();
    L4:
        if (r20.hasNext() == false) goto L6;
        e r21 = (e) r20.next();
        a.getClass();
        Intrinsics.checkNotNullParameter(r21, "parser");
        g.a.i("CalDavClient", "Registering " + r21.getClass().getName() + " for " + r21.getNode());
        b.put(r21.getNode(), r21);
        goto L4
    }
}
