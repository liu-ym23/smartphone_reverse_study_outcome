package com.bytedance.badger.x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.security.keystore.KeyGenParameterSpec;
import com.bm.badgervi.b;
import com.bytedance.badger.BadgerCore;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public static volatile D a;
    public static o b;
    public static volatile boolean c;
    public static final n d = null;
    public static boolean e;
    public static String f;

    static {
        d = new n();
    }

    public static boolean e(String r3) {
        KeyStore r1 = KeyStore.getInstance(f);     // Catch: Exception -> L7
        r1.load(null);     // Catch: Exception -> L7
        if (r1.getCertificate(r3) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        com.bytedance.badger.e.e("DeviceFp1", "hasAskProvider exception: " + e.getMessage());
        return false;
    }

    public static String f() {
        BadgerCore.Companion.getClass();
        if (e(com.bytedance.badger.j.b(1765516356418565358L)) == true) goto L5;
        KeyPairGenerator r2 = KeyPairGenerator.getInstance(com.bytedance.badger.j.b(7079072508190704276L), f);
        r2.initialize(new KeyGenParameterSpec.Builder(com.bytedance.badger.j.b(6610488371976417976L), 16).setDigests(new String[]{"SHA-256"}).setSignaturePaddings(new String[]{"PSS"}).build());
        r2.generateKeyPair();
    L5:
        KeyStore r3 = KeyStore.getInstance(f);
        r3.load(null);
        return JSONObjectProtectorUtils.getString(new JSONObject(new String(b.h((X509Certificate) r3.getCertificate(com.bytedance.badger.j.b(1765516356418565358L))))), com.bytedance.badger.j.b(3852863012899441828L));
    }

    public static String g() {
        if (h() == false) goto L28;
        boolean r2 = true;
        if (f.split("\\.").length > 1) goto L8;
        r2 = false;
    L8:
        BadgerCore.Companion.getClass();
        String r0 = com.bytedance.badger.j.b(6652161667115517076L);
        KeyStore r3 = KeyStore.getInstance(f);
        r3.load(null);
        if (e(r0) == true) goto L15;
        String r5 = com.bytedance.badger.j.b(5819945665527921280L);
        if (r2 == false) goto L13;
        r5 = f;
        int r6 = 16;
    L14:
        KeyPairGenerator r7 = KeyPairGenerator.getInstance("RSA", r5);
        r7.initialize(new KeyGenParameterSpec.Builder(r0 + com.bytedance.badger.j.b(9130210732707849621L), r6).setDigests(new String[]{"SHA-256"}).setSignaturePaddings(new String[]{"PSS"}).build());
        r7.generateKeyPair();
        goto L15
    L13:
        r6 = 4;
    L15:
        if (r2 == false) goto L22;
        Certificate[] r1 = r3.getCertificateChain(r0);
        if (r1 != null) goto L19;
    L26:
        return null;
    L19:
        if (r1.length <= 0) goto L26;
        return JSONObjectProtectorUtils.getString(b.e((X509Certificate) r1[0]), com.bytedance.badger.j.b(3852863012899441828L));
    L22:
        Key r4 = r3.getKey(r0, com.bytedance.badger.j.b(7897631484142453971L).toCharArray());
        if (r4 == null) goto L26;
        return c(r4.getEncoded());
    L28:
        throw new Exception(" provider not found");
    }

    public static boolean h() {
        if (e == true) goto L5;
        i();
    L5:
        Provider[] r0 = Security.getProviders();
        if (r0 != null) goto L9;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: no provider supported");
        return false;
    L9:
        int r3 = r0.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L18;
        String r5 = r0[r4].getName();
        if (r5 == null) goto L17;
        BadgerCore.Companion.getClass();
        if (r5.startsWith(com.bytedance.badger.j.b(5819945665527921280L)) == false) goto L17;
        com.bytedance.badger.e.f("DeviceFp1", "dfp1: found provider:".concat(r5));
        f = r5;
        return true;
    L17:
        r4 = r4 + 1;
        goto L10
    L18:
        com.bytedance.badger.e.f("DeviceFp1", "dfp1: provider not found");
        return false;
    }

    public static void i() {
        BadgerCore.Companion.getClass();     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        Class r3 = a(com.bytedance.badger.j.b(7391467690378216735L));     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        com.bytedance.badger.e.f("DeviceFp1", "dfp1 provider: " + r3);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        Method r1 = r3.getMethod(com.bytedance.badger.j.b(2478331542442269988L), new Class[0]);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        r1.setAccessible(true);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        r1.invoke(null, new Object[0]);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
    L12:
        e = true;
        return;
    L5:
        th = move-exception;
        e = true;
        throw th;
    L10:
        String r2 = "dfp1: no DeviceFp1Provider found";
    L11:
        com.bytedance.badger.e.f("DeviceFp1", r2);     // Catch: Throwable -> L5
    L8:
        r2 = "dfp1: cannot access";
    L9:
        r2 = "dfp1: function not found";
    L7:
        r2 = "dfp1: InvocationTargetException";
        goto L11
    }

    public static String b() {
        if (a.c(0) == true) goto L5;
        a.b(0);
    L5:
        A r0 = a.d(0);
        if (r0 != null) goto L8;
    L28:
        return "";
    L8:
        if (r0.a != 0) goto L28;
        byte[] r1 = r0.b;
        byte[] r4 = new byte[4];
        System.arraycopy(r1, 0, r4, 0, 4);
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r5 >= 4) goto L13;
        r6 = r6 + ((r4[r5] & 255) << (r5 * 8));
        r5 = r5 + 1;
        goto L11
    L13:
        byte[] r7 = new byte[r6];
        if (r1.length >= (r6 + 4)) goto L16;
        return "";
    L16:
        System.arraycopy(r1, 4, r7, 0, r6);
        JSONObject r2 = new JSONObject(new String(r7));
        BadgerCore.Companion.getClass();
        if (r2.has(com.bytedance.badger.j.b(1859995745272754240L)) == true) goto L27;
        if (r2.has(com.bytedance.badger.j.b(5910110494103413445L)) == false) goto L22;
        String r3 = JSONArrayProtectorUtils.getString(JSONObjectProtectorUtils.getJSONArray(r2, com.bytedance.badger.j.b(5910110494103413445L)), 0);
    L23:
        if (r3 != null) goto L25;
        return "";
    L25:
        r2 = new JSONObject(new String(b.h((X509Certificate) CertificateFactory.getInstance(com.bytedance.badger.j.b(939243110723885964L)).generateCertificate(new ByteArrayInputStream(r3.getBytes())))));
        goto L27
    L22:
        r3 = "";
    L27:
        return JSONObjectProtectorUtils.getString(r2, com.bytedance.badger.j.b(3852863012899441828L));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String c(byte[] r8) {
        if (r8 != null) goto L5;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: raw data is null");
        throw new IllegalArgumentException("raw data is null");
    L5:
        if (r8.length >= 4) goto L7;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: raw data length smaller than RAW_LENGTH_PREFIX");
    L7:
        byte[] r1 = new byte[4];
        System.arraycopy(r8, 0, r1, 0, 4);
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= 4) goto L11;
        r5 = r5 + ((r1[r4] & 255) << (r4 * 8));
        r4 = r4 + 1;
        goto L8
    L11:
        if (r5 > 1048576) goto L32;
        byte[] r2 = new byte[r5];
        if (r8.length < (r5 + 4)) goto L30;
        System.arraycopy(r8, 4, r2, 0, r5);
        JSONObject r3 = new JSONObject(new String(r2));     // Catch: Exception -> L27
        BadgerCore.Companion.getClass();     // Catch: Exception -> L27
        String r9 = com.bytedance.badger.j.b(5910110494103413445L);     // Catch: Exception -> L27
        if (r3.has(r9) == false) goto L26;
        JSONArray r10 = r3.optJSONArray(r9);     // Catch: Exception -> L27
        if (r10 != null) goto L20;
    L23:
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: array size too small");     // Catch: Exception -> L27
        throw new IllegalArgumentException("certs size too small");     // Catch: Exception -> L27
    L20:
        if (r10.length() < 2) goto L23;
        return JSONObjectProtectorUtils.getString(b.e((X509Certificate) CertificateFactory.getInstance(com.bytedance.badger.j.b(939243110723885964L)).generateCertificate(new ByteArrayInputStream(r10.optString(0).getBytes()))), com.bytedance.badger.j.b(3852863012899441828L));
    L26:
        return r3.optString(com.bytedance.badger.j.b(3852863012899441828L));
    L27:
        e = move-exception;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: to convert json exception: " + e.getMessage());
        throw e;
    L30:
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: length not correct 2");
        throw new IllegalArgumentException("length not correct 2");
    L32:
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: too large json result!");
        throw new IllegalArgumentException("too large json result!");
    }

    public static boolean d(Context r6) {
        PackageManager r7 = r6.getPackageManager();
        Intent r0 = new Intent();
        com.bytedance.badger.j r2 = BadgerCore.Companion;
        r2.getClass();
        String r3 = com.bytedance.badger.j.b(8129550834698778238L);
        r2.getClass();
        r0.setComponent(new ComponentName(r3, com.bytedance.badger.j.b(1078607345834032513L)));
        return !r7.queryIntentServices(r0, 0).isEmpty();
    }
}
