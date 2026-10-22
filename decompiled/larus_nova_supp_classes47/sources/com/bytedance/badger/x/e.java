package com.bytedance.badger.x;

import android.security.keystore.KeyGenParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends k {
    public static final /* synthetic */ KProperty[] d = null;
    public final Lazy c;

    static {
        d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(e.class), "builder", "getBuilder()Landroid/security/keystore/KeyGenParameterSpec$Builder;"))};
    }

    public e(String r2, int r3) {
        super(r2, r3);
        this.c = LazyKt.lazy(new F(r2, r3));
    }

    @Override // com.bytedance.badger.x.k
    public final AlgorithmParameterSpec b() {
        Lazy r0 = this.c;
        KProperty r1 = d[0];
        return ((KeyGenParameterSpec.Builder) r0.getValue()).build();
    }

    @Override // com.bytedance.badger.x.k
    public final k a(String... r4) {
        Lazy r0 = this.c;
        KProperty r1 = d[0];
        ((KeyGenParameterSpec.Builder) r0.getValue()).setDigests((String[]) Arrays.copyOf(r4, r4.length));
        return this;
    }

    @Override // com.bytedance.badger.x.k
    public final k c(String... r4) {
        Lazy r0 = this.c;
        KProperty r1 = d[0];
        ((KeyGenParameterSpec.Builder) r0.getValue()).setSignaturePaddings((String[]) Arrays.copyOf(r4, r4.length));
        return this;
    }
}
