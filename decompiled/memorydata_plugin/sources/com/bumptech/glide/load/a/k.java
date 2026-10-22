package com.bumptech.glide.load.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k implements i {
    private final Map<String, List<j>> c;
    private volatile Map<String, String> d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f611a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<String, List<j>> f612b = null;
        private boolean c;
        private Map<String, List<j>> d;
        private boolean e;

        static {
            String r0 = b();
            f611a = r0;
            HashMap r1 = new HashMap(2);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r1.put("User-Agent", Collections.singletonList(new b(r0)));
        L5:
            f612b = Collections.unmodifiableMap(r1);
        }

        public a() {
            this.c = true;
            this.d = f612b;
            this.e = true;
        }

        static String b() {
            String r0 = System.getProperty("http.agent");
            if (TextUtils.isEmpty(r0) == false) goto L5;
            return r0;
        L5:
            int r1 = r0.length();
            StringBuilder r2 = new StringBuilder(r0.length());
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L17;
            char r4 = r0.charAt(r3);
            if (r4 > 31) goto L12;
            if (r4 == '\t') goto L12;
        L14:
            r4 = '?';
        L15:
            r2.append(r4);
            r3 = r3 + 1;
        L12:
            if (r4 >= 127) goto L14;
        L17:
            return r2.toString();
        }

        public k a() {
            this.c = true;
            return new k(this.d);
        }
    }

    static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f613a;

        b(String r1) {
            this.f613a = r1;
        }

        @Override // com.bumptech.glide.load.a.j
        public String a() {
            return this.f613a;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L6;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            return this.f613a.equals(r4.f613a);
        L6:
            return false;
        }

        public int hashCode() {
            return this.f613a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f613a + "'}";
        }
    }

    k(Map<String, List<j>> r3) {
        this.c = Collections.unmodifiableMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private String a(List<j> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        String r3 = ((j) ZeusTransformUtils.preCheckCast(r5.get(r2), j.class, "com.obric.memorydata.plugin")).a();
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r7.append(r3);
        if (r2 == (r5.size() - 1)) goto L9;
        r7.append(',');
    L9:
        r2 = r2 + 1;
        goto L3
    L11:
        return r7.toString();
    }

    private Map<String, String> b() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, List<j>>> r1 = this.c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = a((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin"));
        if (TextUtils.isEmpty(r3) == true) goto L4;
        r0.put(r2.getKey(), r3);
        goto L4
    L8:
        return r0;
    }

    @Override // com.bumptech.glide.load.a.i
    public Map<String, String> a() {
        if (this.d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.d != null) goto L8;
        this.d = Collections.unmodifiableMap(b());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.d;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, k.class) == false) goto L6;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.memorydata.plugin");
        return this.c.equals(r4.c);
    L6:
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}
