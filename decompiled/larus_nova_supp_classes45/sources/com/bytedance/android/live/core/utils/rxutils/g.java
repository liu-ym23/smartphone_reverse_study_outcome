package com.bytedance.android.live.core.utils.rxutils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class g<K, V> {

    public static final class a<K, V> extends g<K, V> {
        public final K a;
        public final V b;

        public a(K r1, V r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<K, V> extends g<K, V> {
        public final K a;
        public final V b;
        public final V c;

        public b(K r1, V r2, V r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c<K, V> extends g<K, V> {
        public final K a;
        public final V b;

        public c(K r1, V r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public g() {
    }
}
