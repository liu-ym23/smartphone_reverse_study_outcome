package com.bytedance.badger.x;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class k {
    public final String a;
    public final int b;

    public k(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public abstract k a(String... r1);

    public abstract AlgorithmParameterSpec b();

    public abstract k c(String... r1);
}
