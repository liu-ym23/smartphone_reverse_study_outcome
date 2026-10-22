package com.bytedance.android.anya;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.anya.a$a, reason: collision with other inner class name */
    public static final class C0099a extends a {
        public final p a;

        public C0099a(p r1) {
            this.a = r1;
        }
    }

    public static final class b extends a {
        public final Object a;
        public final Map<Object, j<?>> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object r1, Map<Object, ? extends j<?>> r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public a() {
    }
}
