package com.bytedance.badger.x;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import javax.security.auth.x500.X500Principal;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends k {
    public String[] c;
    public String[] d;

    public j(String r1, int r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.badger.x.k
    public final k a(String... r2) {
        this.c = (String[]) Arrays.copyOf(r2, r2.length);
        return this;
    }

    @Override // com.bytedance.badger.x.k
    public final k c(String... r2) {
        this.d = (String[]) Arrays.copyOf(r2, r2.length);
        return this;
    }

    @Override // com.bytedance.badger.x.k
    public final AlgorithmParameterSpec b() {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r2 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L39;
        Class<?> r1 = Class.forName("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L8
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L8
    L30:
        Class<?> r4 = Integer.TYPE;
        Class<?> r16 = Boolean.TYPE;
        Object r3 = r1.getConstructor(new Class[]{String.class, r4, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, r4, String[].class, String[].class, String[].class, String[].class, r16, r16, r4}).newInstance(new Object[]{this.a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, -1});
        if (r3 == null) goto L35;
        return (AlgorithmParameterSpec) r3;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type java.security.spec.AlgorithmParameterSpec");
    L8:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.security.keystore.KeyGenParameterSpec");
    L12:
        throw th;
    L39:
        r1 = Class.forName("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L17
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.security.keystore.KeyGenParameterSpec");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r1 = MiraPluginFix.forName("android.security.keystore.KeyGenParameterSpec");
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
