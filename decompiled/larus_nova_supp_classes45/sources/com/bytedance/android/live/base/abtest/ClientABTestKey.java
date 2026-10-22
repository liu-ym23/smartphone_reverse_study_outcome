package com.bytedance.android.live.base.abtest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ClientABTestKey<T> {
    public final String a;
    public final Type b;
    public final T c;
    public final a d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ApiType {
    }

    public static class a {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClientABTestKey(String r1, Type r2, Object r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = new a(r4);
    }
}
