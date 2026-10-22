package com.bytedance.awemeopen.infra.base.debug;

import android.util.Base64;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.util.f;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoDebug {
    public static final AoDebug a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static volatile int d;
    public static volatile boolean e;

    public AoDebug() {
    }

    static {
        a = new AoDebug();
        b = LazyKt.lazy(AoDebug$aoHostService$2.INSTANCE);
        c = LazyKt.lazy(AoDebug$aoLogService$2.INSTANCE);
        d = -1;
    }

    @JvmStatic
    public static final boolean b() {
        if (d != (-1)) goto L24;
        AoDebug r0 = a;
        r0.getClass();
        boolean r1 = ((AoHostService) b.getValue()).hostIsDebug();
        BdpManager.getInst().setDebugMode(r1);
        if (r1 == false) goto L8;
        d = 1;
        return true;
    L8:
        r0.getClass();
        if (e == true) goto L24;
        monitor-enter(AoDebug.class);
    L20:
        th = move-exception;
        throw th;
    L14:
        if (e == false) goto L17;
        monitor-exit(AoDebug.class);
        goto L24
    L17:
        e = true;     // Catch: Throwable -> L20
        AoPool.a(AoDebug$checkDebugFileExistAsync$1$1.INSTANCE);     // Catch: Throwable -> L20
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(AoDebug.class);
    L24:
        if (d == 1) goto L30;
        return false;
    L30:
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        if (b() == false) goto L5;
    L8:
        return true;
    L5:
        if (AoEnv.i() == true) goto L8;
        return false;
    }

    public static boolean a(String r7) {
        PKCS8EncodedKeySpec r4 = new PKCS8EncodedKeySpec(f.c(r7));     // Catch: Throwable -> L5
        PrivateKey r8 = KeyFactory.getInstance("RSA").generatePrivate(r4);     // Catch: Throwable -> L5
        Signature r5 = Signature.getInstance("MD5withRSA");     // Catch: Throwable -> L5
        r5.initSign(r8);     // Catch: Throwable -> L5
        Charset r9 = Charsets.UTF_8;     // Catch: Throwable -> L5
        r5.update("hello bdp debug".getBytes(r9));     // Catch: Throwable -> L5
        byte[] r6 = r5.sign();     // Catch: Throwable -> L5
        X509EncodedKeySpec r10 = new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKUjAAuFnt+qL1wJkAffJRTrBSAnCf/n4aoLPgpq4BjyWaWzxeXVUwhKadPFjNePa6P5v7jmvZVejvLTq77HlqkCAwEAAQ==", 0));     // Catch: Throwable -> L5
        PublicKey r2 = KeyFactory.getInstance("RSA").generatePublic(r10);     // Catch: Throwable -> L5
        Signature r1 = Signature.getInstance("MD5withRSA");     // Catch: Throwable -> L5
        r1.initVerify(r2);     // Catch: Throwable -> L5
        r1.update("hello bdp debug".getBytes(r9));     // Catch: Throwable -> L5
        return r1.verify(r6);
    L5:
        th = move-exception;
        ((AoLogService) c.getValue()).e("AoDebug", th.toString());
        return false;
    }
}
