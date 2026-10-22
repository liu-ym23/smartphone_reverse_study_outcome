package com.bytedance.ai.debugscene;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r2 {
    public static final Object a = null;
    public static final IdentityHashMap<Object, a> b = null;
    public static final IdentityHashMap<q2, a> c = null;
    public static final HashMap<Integer, a> d = null;
    public static final HashMap<String, a> e = null;

    public static final class a {
        public final q2 a;
        public final Object b;
        public final String c;
        public Integer d;

        public a(q2 r10, Object r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "handle");
            Intrinsics.checkNotNullParameter(r11, "engineObject");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = null;
        }
    }

    static {
        a = new Object();
        b = new IdentityHashMap();
        c = new IdentityHashMap();
        d = new HashMap();
        e = new HashMap();
    }

    public static void a(a r10, List r11) {
        c.remove(r10.a);
        b.remove(r10.b);
        String r0 = r10.c;
        if (r0 == null) goto L7;
        HashMap<String, a> r1 = e;
        if (r1.get(r0) != r10) goto L7;
        r1.remove(r0);
    L7:
        Integer r12 = r10.d;
        if (r12 == null) goto L12;
        int r13 = r12.intValue();
        d.remove(Integer.valueOf(r13));
        if (r11 == null) goto L12;
        r11.add(Integer.valueOf(r13));
    L12:
        r10.d = null;
    }
}
