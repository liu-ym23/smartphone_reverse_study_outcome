package l6;

import ae.d;
import ae.f;
import ae.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import androidx.work.m;
import androidx.work.n;
import androidx.work.u;
import be.b;
import be.c;
import com.amap.api.location.AMapLocation;
import com.bytedance.common.utility.Logger;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
import com.ttnet.org.chromium.net.NetError;
import ge.p;
import ge.q;
import he.i;
import ja.t;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import ka.r;
import n6.e;
import org.json.JSONException;
import org.json.JSONObject;
import pe.b0;
import pe.h0;
import pe.k1;
import pe.o;
import pe.r1;
import pe.s0;
import pe.s1;
import pe.u1;
import pe.v;
import pe.x;
import pe.x0;
import pe.z;
import qa.p2;
import qa.t3;
import qa.t4;
import r1.l;
import r4.k;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements ab.a, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9132a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9133b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CopyOnWriteArrayList f9134c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d6.a f9135d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f9136e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f9137f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char[] f9138g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile p2 f9139h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile byte f9140i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile String f9141j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile String f9142k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile String f9143l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile String f9144m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile String f9145n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile String f9146o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile String f9147p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile String f9148q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile String f9149r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile String f9150s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile int f9151t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile String f9152u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final char[] f9153v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static m8.a f9154w;

    static {
        f9133b = new a();
        f9135d = new d6.a();
        f9137f = new Object[0];
        f9138g = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f9153v = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static int A(int r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r8;
    L6:
        if (r10.contains("ECONNRESET") == false) goto L8;
    L39:
        return NetError.ERR_CONNECTION_RESET;
    L8:
        if (r10.contains("Connection reset") == true) goto L39;
        if (r10.contains("reset by peer") == true) goto L39;
        if (r10.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r10.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r10.contains("connection abort") == true) goto L38;
        if (r10.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r10.contains("Network is unreachable") == true) goto L37;
        if (r10.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r10.contains("ENETUNREACH") == true) goto L36;
        if (r10.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r10.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r8;
    }

    public static final void A0(String r8) {
        if (r8 == null) goto L5;
        Log.i("OUILogger", r8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final d B(Object r8, d r10, p r11) {
        i.f(r11, "<this>");
        i.f(r10, "completion");
        if ((r11 instanceof ce.a) == true) goto L10;
        f r12 = r10.getContext();
        if (r12 != g.f354a) goto L9;
        return new b(r8, r10, r11);
    L9:
        return new c(r10, r12, r11, r8);
    L10:
        return ((ce.a) r11).create(r8, r10);
    }

    public static final void B0(d r8) {
        i.f(r8, "frame");
    }

    public static byte[] C(byte[] r17, n6.d r18) {
        int r13 = e.a(Arrays.copyOfRange(r17, 0, 4));     // Catch: Exception -> L45
        if (r13 != 315433677) goto L44;
        int r10 = e.a(Arrays.copyOfRange(r17, 4, 8));     // Catch: Exception -> L45
        if (r10 != 1) goto L42;
        byte[] r11 = r18.f9465h;     // Catch: Exception -> L45
        if (Arrays.equals(r11, Arrays.copyOfRange(r17, 8, r11.length + 8)) == false) goto L40;
        int r8 = r18.f9465h.length + 8;     // Catch: Exception -> L45
        int r12 = r8 + 32;     // Catch: Exception -> L45
        byte[] r14 = Arrays.copyOfRange(r17, r8, r12);     // Catch: Exception -> L45
        int r15 = r12 + 4;     // Catch: Exception -> L45
        int r16 = e.a(Arrays.copyOfRange(r17, r12, r15));     // Catch: Exception -> L45
        if (r16 != 317666031) goto L38;
        int r19 = r15 + 8;     // Catch: Exception -> L45
        byte[] r20 = Arrays.copyOfRange(r17, r15, r19);     // Catch: Exception -> L45
        if (r20.length != 8) goto L36;
        long r21 = ((((long) (r20[6] & 255)) << 8) | ((((((((long) (r20[0] & 255)) << 56) | (((long) (r20[1] & 255)) << 48)) | (((long) (r20[2] & 255)) << 40)) | (((long) (r20[3] & 255)) << 32)) | (((long) (r20[4] & 255)) << 24)) | (((long) (r20[5] & 255)) << 16))) | ((long) (r20[7] & 255));     // Catch: Exception -> L45
        if (r21 != r18.f9463f) goto L18;
        SecretKeySpec r22 = new SecretKeySpec(F(r18.f9460c, r14, r18.f9464g), "AES");     // Catch: Exception -> L45
    L22:
        int r23 = r19 + 4;     // Catch: Exception -> L45
        int r24 = e.a(Arrays.copyOfRange(r17, r19, r23));     // Catch: Exception -> L45
        int r25 = r23 + 12;     // Catch: Exception -> L45
        byte[] r26 = Arrays.copyOfRange(r17, r23, r25);     // Catch: Exception -> L45
        int r27 = r23 + r24;     // Catch: Exception -> L45
        byte[] r28 = Arrays.copyOfRange(r17, r25, r27);     // Catch: Exception -> L45
        byte[] r29 = "cloud_trans_key_v2".getBytes();     // Catch: Exception -> L45
        Cipher r30 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L45
        r30.init(2, r22, new GCMParameterSpec(128, r26));     // Catch: Exception -> L45
        if (r29 == null) goto L25;
        r30.updateAAD(r29);     // Catch: Exception -> L45
    L25:
        byte[] r31 = r30.doFinal(r28);     // Catch: Exception -> L45
        int r32 = r27 + 12;     // Catch: Exception -> L45
        byte[] r33 = Arrays.copyOfRange(r17, r27, r32);     // Catch: Exception -> L45
        byte[] r34 = Arrays.copyOfRange(r17, r32, r17.length);     // Catch: Exception -> L45
        SecretKeySpec r35 = new SecretKeySpec(r31, "AES");     // Catch: Exception -> L45
        byte[] r36 = "cloud_trans_data_v2".getBytes();     // Catch: Exception -> L45
        Cipher r37 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L45
        r37.init(2, r35, new GCMParameterSpec(128, r33));     // Catch: Exception -> L45
        if (r36 == null) goto L28;
        r37.updateAAD(r36);     // Catch: Exception -> L45
    L28:
        byte[] r38 = r37.doFinal(r34);     // Catch: Exception -> L45
        byte[] r39 = Arrays.copyOfRange(r38, 0, r38.length - 32);     // Catch: Exception -> L45
        if (Arrays.equals(Arrays.copyOfRange(r38, r38.length - 32, r38.length), e.h(r39)) == false) goto L32;
        return r39;
    L32:
        throw new n6.c("data decrypt failed，sha256 is error");     // Catch: Exception -> L45
    L18:
        if (r18.f9467j == false) goto L34;
        if (r21 != r18.f9468k) goto L34;
        Log.w("DataEncryptHelper", "use old key decrypt, key version is " + r21);     // Catch: Exception -> L45
        r22 = new SecretKeySpec(F(r18.f9469l, r14, r18.f9464g), "AES");     // Catch: Exception -> L45
    L34:
        throw new n6.c("key version is error, web version: " + r21 + ", current version: " + r18.f9463f, 0);     // Catch: Exception -> L45
    L36:
        throw new IllegalArgumentException("Byte array must be exactly 8 bytes long");     // Catch: Exception -> L45
    L38:
        throw new n6.c("key cipher magic num is error, web magic num: " + r16 + ", current magic num: 317666031");     // Catch: Exception -> L45
    L40:
        throw new n6.c("dId and appId is error, " + s6.b.a(Arrays.copyOfRange(r17, 8, r18.f9465h.length + 8)));     // Catch: Exception -> L45
    L42:
        throw new n6.c("cipher version is error, web version: " + r10);     // Catch: Exception -> L45
    L44:
        throw new n6.c("magic num is error, web num: " + r13 + ", current magic num: 315433677");     // Catch: Exception -> L45
    L45:
        e = move-exception;
        if ((e instanceof n6.c) == false) goto L51;
        throw ((n6.c) e);
    L51:
        throw new n6.c("data decrypt failed, error: " + e);
    }

    public static byte[] C0(InputStream r8, int r10) {
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        int r13 = r8.read(r11, r12, r10 - r12);
        if (r13 < 0) goto L8;
        r12 = r12 + r13;
        goto L3
    L8:
        throw new IllegalStateException(defpackage.a.d("Not enough bytes to read: ", r10));
    L9:
        return r11;
    }

    public static byte[] D(byte[] r13, n6.d r14) {
        byte[] r8 = new byte[32];
        new SecureRandom().nextBytes(r8);
        byte[] r10 = new SecretKeySpec(r8, "AES").getEncoded();
        SecretKeySpec r11 = new SecretKeySpec(r10, "AES");
        byte[] r12 = new byte[12];
        new SecureRandom().nextBytes(r12);
        byte[] r15 = e.d(new byte[][]{r13, e.h(r13)});     // Catch: Exception -> L24
        byte[] r16 = "cloud_trans_data_v2".getBytes();     // Catch: Exception -> L24
        Cipher r17 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L24
        r17.init(1, r11, new GCMParameterSpec(128, r12));     // Catch: Exception -> L24
        if (r16 == null) goto L6;
        r17.updateAAD(r16);     // Catch: Exception -> L24
    L6:
        byte[] r18 = r17.doFinal(r15);     // Catch: Exception -> L24
        byte[] r19 = new byte[12];
        new SecureRandom().nextBytes(r19);
        SecretKeySpec r110 = new SecretKeySpec(r14.f9459b, "AES");
        byte[] r20 = "cloud_trans_key_v2".getBytes();     // Catch: Exception -> L21
        Cipher r21 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L21
        r21.init(1, r110, new GCMParameterSpec(128, r19));     // Catch: Exception -> L21
        if (r20 == null) goto L11;
        r21.updateAAD(r20);     // Catch: Exception -> L21
    L11:
        byte[] r22 = r21.doFinal(r10);     // Catch: Exception -> L21
        int r23 = r22.length + 12;
        long r24 = r14.f9463f;     // Catch: IOException -> L19
        ByteBuffer r25 = ByteBuffer.allocate(8);     // Catch: IOException -> L19
        r25.putLong(r24);     // Catch: IOException -> L19
        byte[] r111 = e.d(new byte[][]{e.f(315433677), e.f(1), r14.f9465h, r14.f9462e, e.f(317666031), r25.array(), e.f(r23), r19, r22, r12, r18});     // Catch: IOException -> L19
        if (r111.length == 0) goto L18;
        return r111;
    L18:
        throw new n6.c("data encrypt failed, cipher is empty.");
    L20:
        throw new n6.c("data encrypt failed, concatenate error.");
    L21:
        e = move-exception;
        throw new n6.c("key encrypt failed.", e);
    L24:
        e = move-exception;
        throw new n6.c("data encrypt failed", e);
    }

    public static byte[] D0(FileInputStream r8, int r10, int r11) {
        Inflater r12 = new Inflater();
        byte[] r13 = new byte[r11];     // Catch: Throwable -> L29
        byte[] r14 = new byte[2048];     // Catch: Throwable -> L29
        int r15 = 0;
        int r16 = 0;
    L5:
        if (r12.finished() == true) goto L20;
        if (r12.needsDictionary() == true) goto L20;
        if (r15 >= r10) goto L20;
        int r17 = r8.read(r14);     // Catch: Throwable -> L29
        if (r17 < 0) goto L19;
        r12.setInput(r14, 0, r17);     // Catch: Throwable -> L29
        r16 = r16 + r12.inflate(r13, r16, r11 - r16);
        r15 = r15 + r17;
        goto L5
    L15:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());     // Catch: Throwable -> L29
    L19:
        throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r10 + " bytes");     // Catch: Throwable -> L29
    L20:
        if (r15 != r10) goto L28;
        if (r12.finished() == false) goto L26;
        r12.end();
        return r13;
    L26:
        throw new IllegalStateException("Inflater did not finish");     // Catch: Throwable -> L29
    L28:
        throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + r10 + " actual=" + r15);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r12.end();
        throw th;
    }

    public static JSONObject E(JSONObject r8) {
        if (r8 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r8.toString());
    L7:
        return r8;
    }

    public static long E0(InputStream r8, int r10) {
        byte[] r11 = C0(r8, r10);
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12 = r12 + (((long) (r11[r13] & 255)) << (r13 * 8));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static byte[] F(byte[] r8, byte[] r10, byte[] r11) {
        if (r10 != null) goto L5;
    L6:
        r10 = new byte[32];
    L7:
        Mac r12 = Mac.getInstance("HmacSHA256");
        r12.init(new SecretKeySpec(r10, "HmacSHA256"));
        byte[] r13 = r12.doFinal(r8);
        Mac r14 = Mac.getInstance("HmacSHA256");
        r14.init(new SecretKeySpec(r13, "HmacSHA256"));
        byte[] r15 = new byte[32];
        byte[] r16 = new byte[0];
        int r17 = (int) Math.ceil(((double) 32) / ((double) r14.getMacLength()));
        int r18 = 1;
        int r19 = 0;
    L8:
        if (r18 > r17) goto L10;
        r14.reset();
        r14.update(r16);
        r14.update(r11);
        r14.update((byte) r18);
        r16 = r14.doFinal();
        System.arraycopy(r16, 0, r15, r19, Math.min(r16.length, 32 - r19));
        r19 = r19 + r16.length;
        r18 = r18 + 1;
        goto L8
    L10:
        return r15;
    L5:
        if (r10.length != 0) goto L7;
        goto L6
    }

    public static int F0(InputStream r8) {
        return (int) E0(r8, 2);
    }

    public static final int G(int r8) {
        Resources r10 = Resources.getSystem();
        i.e(r10, "Resources.getSystem()");
        return (int) ((r8 * r10.getDisplayMetrics().density) + 0.5f);
    }

    public static final Object G0(Object r8) {
        if ((r8 instanceof o) == true) goto L5;
        return r8;
    L5:
        return defpackage.c.D(((o) r8).f10052a);
    }

    public static void H(String r8, String r10) {
        Log.e(r8, r10);
    }

    public static final void H0(int r8, int r10, Object[] r11) {
        i.f(r11, "<this>");
    L3:
        if (r8 >= r10) goto L5;
        r11[r8] = null;
        r8 = r8 + 1;
        goto L3
    }

    public static final boolean I(char r8, char r10, boolean r11) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if (r11 == true) goto L8;
        return false;
    L8:
        char r12 = Character.toUpperCase(r8);
        char r13 = Character.toUpperCase(r10);
        if (r12 != r13) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r12) != Character.toLowerCase(r13)) goto L14;
        return true;
    L14:
        return false;
    }

    public static final int I0(float r8) {
        if (Float.isNaN(r8) == true) goto L7;
        return Math.round(r8);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final void J(xa.a r8, q r10) {
        i.f(r10, "block");
        int r11 = r8.f13764a;
        if (r11 != 0) goto L5;
        return;
    L5:
        if (r11 == 1) goto L12;
        Integer r12 = Integer.valueOf(r11);
        String r13 = r8.f13765b;
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        r10.invoke(r12, r13, r8.f13769f);
        return;
    }

    public static Object J0(p r8) {
        Thread r10 = Thread.currentThread();
        x0 r11 = x0.f10085a;
        s0 r12 = u1.a();
        pe.c r13 = new pe.c(v.a(r11, r12), r10, r12);
        r13.W(b0.f9995a, r13, r8);
        s0 r14 = r13.f10000o;
        if (r14 == null) goto L30;
        int r15 = s0.f10060p;
        r14.u0(false);
    L30:
    L26:
        th = move-exception;
        if (r14 == null) goto L29;
        int r16 = s0.f10060p;
        r14.t0(false);
    L29:
        throw th;
    L6:
        if (Thread.interrupted() == true) goto L24;
        if (r14 == null) goto L9;
        long r17 = r14.v0();     // Catch: Throwable -> L26
    L11:
        if (r13.G() == true) goto L14;
        LockSupport.parkNanos(r13, r17);     // Catch: Throwable -> L26
        goto L30
    L14:
        if (r14 == null) goto L16;
        int r18 = s0.f10060p;
        r14.t0(false);
    L16:
        Object r19 = k1.a(r13.t());
        if ((r19 instanceof o) == false) goto L19;
        o r20 = (o) r19;
    L20:
        if (r20 != null) goto L23;
        return r19;
    L23:
        throw r20.f10052a;
    L19:
        r20 = null;
        goto L20
    L9:
        r17 = Long.MAX_VALUE;
        goto L11
    L24:
        InterruptedException r21 = new InterruptedException();     // Catch: Throwable -> L26
        r13.g(r21);     // Catch: Throwable -> L26
        throw r21;     // Catch: Throwable -> L26
    }

    public static final ArrayList K(View r8) {
        i.f(r8, "view");
        ArrayList r10 = new ArrayList();
        if ((r8 instanceof ViewGroup) == false) goto L8;
        ViewGroup r11 = (ViewGroup) r8;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        View r14 = r11.getChildAt(r13);
        i.e(r14, "child");
        r10.addAll(K(r14));
        r13 = r13 + 1;
    L10:
        return r10;
    L8:
        if ((r8 instanceof EditText) == false) goto L10;
        r10.add(r8);
        goto L10
    }

    public static void K0(OutputStream r8) {
        if (r8 == null) goto L8;
        r8.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static final l L(r1.t r8) {
        i.f(r8, "<this>");
        return new l(r8.f11339a, r8.f11358t);
    }

    public static final void M() {
        be.a r8 = be.a.f3165a;
    }

    public static final byte[] M0(Set r8) {
        i.f(r8, "triggers");
        if (r8.isEmpty() == true) goto L5;
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        ObjectOutputStream r11 = new ObjectOutputStream(r10);     // Catch: Throwable -> L22
        r11.writeInt(r8.size());     // Catch: Throwable -> L17
        Iterator r12 = r8.iterator();     // Catch: Throwable -> L17
    L10:
        if (r12.hasNext() == false) goto L12;
        androidx.work.d.b r13 = (androidx.work.d.b) r12.next();     // Catch: Throwable -> L17
        r11.writeUTF(r13.f2820a.toString());     // Catch: Throwable -> L17
        r11.writeBoolean(r13.f2821b);     // Catch: Throwable -> L17
        goto L10
    L12:
        j r14 = j.f13877a;     // Catch: Throwable -> L17
    L14:
        defpackage.c.A(r11, null);     // Catch: Throwable -> L22
        defpackage.c.A(r10, null);
        byte[] r15 = r10.toByteArray();
        i.e(r15, "outputStream.toByteArray()");
        return r15;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        defpackage.c.A(r11, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        defpackage.c.A(r10, th);
        throw th;
    L5:
        return new byte[0];
    }

    public static final Class N(le.b r8) {
        i.f(r8, "<this>");
        Class<?> r10 = ((he.c) r8).a();
        if (r10.isPrimitive() == true) goto L5;
        return r10;
    L5:
        String r11 = r10.getName();
        switch(r11.hashCode()) {
            case -1325958191: goto L41;
            case 104431: goto L37;
            case 3039496: goto L33;
            case 3052374: goto L29;
            case 3327612: goto L25;
            case 3625364: goto L21;
            case 64711720: goto L17;
            case 97526364: goto L13;
            case 109413500: goto L9;
            default: goto L53;
        };
    L53:
        return r10;
    L9:
        if (r11.equals("short") == false) goto L54;
        return Short.class;
    L54:
        return r10;
    L13:
        if (r11.equals("float") == false) goto L55;
        return Float.class;
    L55:
        return r10;
    L17:
        if (r11.equals("boolean") == false) goto L56;
        return Boolean.class;
    L56:
        return r10;
    L21:
        if (r11.equals("void") == false) goto L57;
        return Void.class;
    L57:
        return r10;
    L25:
        if (r11.equals(MultiProcessSharedProvider.LONG_TYPE) == false) goto L58;
        return Long.class;
    L58:
        return r10;
    L29:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_CHAR) == false) goto L59;
        return Character.class;
    L59:
        return r10;
    L33:
        if (r11.equals("byte") == false) goto L60;
        return Byte.class;
    L60:
        return r10;
    L37:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_INT) == false) goto L61;
        return Integer.class;
    L61:
        return r10;
    L41:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L62;
        return Double.class;
    L62:
        return r10;
    }

    public static gb.b N0() {
        hb.e[] r8 = hb.e.f8026a;
        hb.f[] r10 = hb.f.f8027a;
        return new gb.b(0.8f, 322, 0);
    }

    public static final int O(List r8) {
        i.f(r8, "<this>");
        return r8.size() - 1;
    }

    public static void O0(i4.f r10, i4.a r11, i4.i r12) {
        if (r10.f() == true) goto L5;
        return;
    L5:
        r10.l(r12.f8238e, r12.f8239f, r11, r12.f8234a, r12.f8235b, r12.f8236c, r12.f8237d);
    }

    public static String P(int r8) {
        if (TextUtils.isEmpty(f9136e) == true) goto L39;
        return f9136e;
    L39:
        BufferedReader r10 = new BufferedReader(new FileReader("/proc/" + r8 + "/cmdline"));     // Catch: Throwable -> L19
        String r11 = r10.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r11) == true) goto L11;
        r11 = r11.trim();     // Catch: Throwable -> L17
    L11:
        f9136e = r11;     // Catch: Throwable -> L17
        r10.close();     // Catch: IOException -> L14
    L16:
        return r11;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L37:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r10 != null) goto L41;
    L27:
        return null;
    L41:
        r10.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r10 != null) goto L45;
    L34:
        throw th;
    L45:
        r10.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r10 = null;
        goto L37
    }

    public static void P0(i4.f r11, i4.a r12, r4.a r13) {
        if (r11.f() == true) goto L6;
        return;
    L6:
        if ((r13 instanceof r4.c) == false) goto L10;
        String r8 = ((r4.c) r13).I;
        String r10 = String.valueOf(r13.B);
        long r14 = r13.f11450b;
        i4.j r15 = i4.j.f8241m;
    L21:
        r11.k(r12, r8, r10, r14, r15);
        return;
    L10:
        if ((r13 instanceof r4.e) == false) goto L13;
        r8 = ((r4.e) r13).J;
        r10 = String.valueOf(r13.B);
        r14 = r13.f11450b;
        r15 = i4.j.f8240b;
        goto L21
    L13:
        if ((r13 instanceof r4.d) == false) goto L16;
        r8 = ((r4.d) r13).I;
        r10 = String.valueOf(r13.B);
        r14 = r13.f11450b;
        r15 = i4.j.f8242n;
        goto L21
    L16:
        if ((r13 instanceof r4.g) == false) goto L19;
        r10 = String.valueOf(r13.B);
        r14 = r13.f11450b;
        r15 = i4.j.f8243o;
        r8 = "launch";
        goto L21
    L19:
        if ((r13 instanceof k) == false) goto L23;
        r10 = String.valueOf(r13.B);
        r14 = r13.f11450b;
        r15 = i4.j.f8244p;
        r8 = "terminate";
        goto L21
    }

    public static final int Q(Context r8) {
        i.f(r8, "$this$getScreenHeight");
        Resources r10 = r8.getResources();
        i.e(r10, "resources");
        DisplayMetrics r11 = r10.getDisplayMetrics();
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.heightPixels;
    }

    public static final int Q0(u.a r8) {
        i.f(r8, "state");
        int r10 = r8.ordinal();
        if (r10 != 0) goto L5;
        return 0;
    L5:
        if (r10 != 1) goto L7;
        return 1;
    L7:
        if (r10 != 2) goto L9;
        return 2;
    L9:
        if (r10 != 3) goto L11;
        return 3;
    L11:
        if (r10 != 4) goto L13;
        return 4;
    L13:
        if (r10 != 5) goto L16;
        return 5;
    L16:
        throw new ha.t();
    }

    public static void R(Throwable r8) {
        StackTraceElement[] r10 = r8.getStackTrace();
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L8;
        StackTraceElement r14 = r10[r12];
        r13 = r13 + 1;
        new StringBuilder("\tat ").append(r14.getClassName());
        r14.getMethodName();
        r14.getFileName();
        r14.getLineNumber();
        if (r13 > 10) goto L11;
        r12 = r12 + 1;
        goto L3
    L11:
        return;
    }

    public static final long R0(long r21, String r23, long r24, long r26) {
        int r8 = ue.v.f12626a;
        String r10 = System.getProperty(r23);     // Catch: SecurityException -> L5
    L6:
        if (r10 == null) goto L58;
        v(10);
        int r11 = r10.length();
        if (r11 == 0) goto L43;
        char r12 = r10.charAt(0);
        if (r12 >= '0') goto L14;
        byte r13 = -1;
    L17:
        long r14 = -9223372036854775807L;
        if (r13 >= 0) goto L27;
        if (r11 == 1) goto L43;
        if (r12 != '-') goto L25;
        r14 = Long.MIN_VALUE;
        int r15 = 1;
    L28:
        int r16 = r15;
    L29:
        long r17 = 0;
        long r18 = -256204778801521550L;
    L30:
        if (r15 >= r11) goto L45;
        int r19 = Character.digit(r10.charAt(r15), 10);
        if (r19 < 0) goto L43;
        if (r17 < r18) goto L37;
    L41:
        long r20 = r17 * ((long) 10);
        long r22 = r19;
        if (r20 < (r14 + r22)) goto L43;
        r17 = r20 - r22;
        r15 = r15 + 1;
        goto L30
    L37:
        if (r18 != (-256204778801521550L)) goto L43;
        r18 = r14 / ((long) 10);
        if (r17 >= r18) goto L41;
    L45:
        if (r16 == 0) goto L47;
        Long r25 = Long.valueOf(r17);
    L49:
        if (r25 == null) goto L62;
        long r27 = r25.longValue();
        if (r24 > r27) goto L55;
        long r28 = r26;
        if (r27 > r28) goto L56;
        boolean r29 = true;
    L57:
        if (r29 == false) goto L60;
        return r27;
    L60:
        throw new IllegalStateException(("System property '" + r23 + "' should be in range " + r24 + ".." + r28 + ", but is '" + r27 + '\'').toString());
    L56:
        r29 = false;
        goto L57
    L55:
        r28 = r26;
        goto L56
    L62:
        throw new IllegalStateException(("System property '" + r23 + "' has unrecognized value '" + r10 + '\'').toString());
    L47:
        r25 = Long.valueOf(-r17);
        goto L49
    L25:
        if (r12 != '+') goto L43;
        r16 = 0;
        r15 = 1;
        goto L29
    L27:
        r15 = 0;
        goto L28
    L14:
        if (r12 != '0') goto L16;
        r13 = 0;
        goto L17
    L16:
        r13 = 1;
    L43:
        r25 = null;
        goto L49
    L58:
        return r21;
    L5:
        r10 = null;
        goto L6
    }

    public static int S(i4.f r8, r4.a r10) {
        if (r8.f() == true) goto L6;
    L4:
        boolean r11 = false;
    L21:
        if (r11 == true) goto L23;
        return 0;
    L23:
        if (r8.f8212a.f8170o == false) goto L25;
        return 3;
    L25:
        return 1;
    L6:
        if ((r10 instanceof r4.c) == false) goto L9;
        String r12 = ((r4.c) r10).J;
    L11:
        r11 = r8.d(r12);
        goto L21
    L9:
        if ((r10 instanceof r4.e) == false) goto L13;
        r12 = ((r4.e) r10).J;
        goto L11
    L13:
        if ((r10 instanceof r4.d) == false) goto L16;
        r12 = ((r4.d) r10).I;
        goto L11
    L16:
        if ((r10 instanceof r4.g) == false) goto L19;
        r12 = "launch";
        goto L11
    L19:
        if ((r10 instanceof k) == false) goto L4;
        r12 = "terminate";
        goto L11
    }

    public static int S0(String r8, int r10, int r11, int r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r11 = 1;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r12 = Integer.MAX_VALUE;
    L9:
        return (int) R0(r10, r8, r11, r12);
    }

    public static SimpleDateFormat T(int r8, int r10) {
        StringBuilder r11 = new StringBuilder();
        if (r8 == 0) goto L12;
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L10;
        if (r8 != 3) goto L9;
        String r12 = "M/d/yy";
    L13:
        r11.append(r12);
        r11.append(" ");
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L21;
        if (r10 != 3) goto L20;
        String r13 = "h:mm a";
    L23:
        r11.append(r13);
        return new SimpleDateFormat(r11.toString(), Locale.US);
    L20:
        throw new IllegalArgumentException(defpackage.a.d("Unknown DateFormat style: ", r10));
    L21:
        r13 = "h:mm:ss a";
    L22:
        r13 = "h:mm:ss a z";
        goto L23
    L9:
        throw new IllegalArgumentException(defpackage.a.d("Unknown DateFormat style: ", r8));
    L10:
        r12 = "MMM d, yyyy";
        goto L13
    L11:
        r12 = "MMMM d, yyyy";
        goto L13
    L12:
        r12 = "EEEE, MMMM d, yyyy";
        goto L13
    }

    public static final void T0() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void U(f r8, Throwable r10) {
        Iterator r11 = ue.e.f12591a.iterator();
    L4:
        if (r11.hasNext() == true) goto L17;
        defpackage.c.o(r10, new ue.f(r8));     // Catch: Throwable -> L16
    L14:
        Thread r12 = Thread.currentThread();
        r12.getUncaughtExceptionHandler().uncaughtException(r12, r10);
        return;
    L17:
        ((x) r11.next()).e0(r8, r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r10 != th) goto L11;
        Throwable r13 = r10;
    L12:
        Thread r14 = Thread.currentThread();
        r14.getUncaughtExceptionHandler().uncaughtException(r14, r13);
        goto L4
    L11:
        r13 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        defpackage.c.o(r13, r10);
        goto L12
    }

    public static final Object[] U0(Collection r8) {
        i.f(r8, "collection");
        int r10 = r8.size();
        Object[] r11 = f9137f;
        if (r10 == 0) goto L32;
        Iterator r12 = r8.iterator();
        if (r12.hasNext() == false) goto L33;
        Object[] r13 = new Object[r10];
        int r14 = 0;
    L9:
        int r15 = r14 + 1;
        r13[r14] = r12.next();
        if (r15 < r13.length) goto L23;
        if (r12.hasNext() == false) goto L34;
        int r16 = ((r15 * 3) + 1) >>> 1;
        if (r16 > r15) goto L21;
        r16 = 2147483645;
        if (r15 < 2147483645) goto L21;
        throw new OutOfMemoryError();
    L21:
        r13 = Arrays.copyOf(r13, r16);
        i.e(r13, "copyOf(result, newSize)");
    L26:
        r14 = r15;
        goto L9
    L34:
        return r13;
    L23:
        if (r12.hasNext() == true) goto L26;
        Object[] r17 = Arrays.copyOf(r13, r15);
        i.e(r17, "copyOf(result, size)");
        return r17;
    L33:
        return r11;
    L32:
        return r11;
    }

    public static boolean V(String r34, long r35) {
        if (r35 > 0) goto L5;
        return true;
    L5:
        if (r35 > 10000) goto L54;
        boolean r8 = p4.a.f9938a;
        if (r34 != null) goto L10;
        String r10 = "NULL";
    L11:
        p4.a.f9939b.getClass();
        byte[] r11 = r10.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L45
        int r12 = r11.length;
        long r17 = -7286425919675154353L;
        if (r12 > 32) goto L28;
        if (r12 > 16) goto L26;
        int r13 = r11.length;
        if (r13 < 8) goto L20;
        long r14 = ((long) (r13 * 2)) - 7286425919675154353L;
        long r15 = p4.a.b(0, r11) - 7286425919675154353L;
        long r16 = p4.a.b(r13 - 8, r11);
        long r18 = (p4.a.d(37, r16) * r14) + r15;
        long r19 = (p4.a.d(25, r15) + r16) * r14;
    L22:
        long r20 = (r18 ^ r19) * r14;
        long r21 = ((r20 ^ (r20 >>> 47)) ^ r19) * r14;
        r17 = (r21 ^ (r21 >>> 47)) * r14;
    L25:
        boolean r22 = false;
    L30:
        long r23 = r17;
    L36:
        if (r23 < 0) goto L38;
        BigInteger r24 = BigInteger.valueOf(r23);
    L40:
        if (((r24.longValue() >>> 32) % (10000 / r35)) != 0) goto L43;
        return true;
    L43:
        return r22;
    L38:
        r24 = BigInteger.valueOf(r23 & Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE)).add(BigInteger.valueOf(1));
        goto L40
    L20:
        if (r13 < 4) goto L23;
        r14 = ((long) (r13 * 2)) - 7286425919675154353L;
        long r25 = ((long) r13) + ((((long) p4.a.a(0, r11)) & QesdkUtils.LIMITS.UINT_32_UPPER) << 3);
        r19 = ((long) p4.a.a(r13 - 4, r11)) & QesdkUtils.LIMITS.UINT_32_UPPER;
        r18 = r25;
        goto L22
    L23:
        if (r13 <= 0) goto L25;
        long r26 = (((long) ((r11[0] & 255) + ((r11[r13 >>> 1] & 255) << 8))) * (-7286425919675154353L)) ^ (((long) (r13 + ((r11[r13 - 1] & 255) << 2))) * (-4348849565147123417L));
        r17 = (-7286425919675154353L) * (r26 ^ (r26 >>> 47));
        goto L25
    L26:
        int r27 = r11.length;
        long r28 = ((long) (r27 * 2)) - 7286425919675154353L;
        long r29 = p4.a.b(0, r11) * (-5435081209227447693L);
        long r30 = p4.a.b(8, r11);
        long r110 = p4.a.b(r27 - 8, r11) * r28;
        long r31 = (p4.a.d(30, r110) + p4.a.d(43, r29 + r30)) + (p4.a.b(r27 - 16, r11) * (-7286425919675154353L));
        long r32 = (p4.a.d(18, r30 - 7286425919675154353L) + r29) + r110;
        long r33 = (r31 ^ r32) * r28;
        long r36 = (r32 ^ (r33 ^ (r33 >>> 47))) * r28;
        r23 = (r36 ^ (r36 >>> 47)) * r28;
        r22 = false;
        goto L36
    L28:
        if (r12 > 64) goto L31;
        int r37 = r11.length;
        long r38 = ((long) (r37 * 2)) - 7286425919675154353L;
        r22 = false;
        long r111 = p4.a.b(0, r11) * (-7286425919675154353L);
        long r112 = p4.a.b(8, r11);
        long r113 = p4.a.b(r37 - 24, r11);
        long r210 = p4.a.b(r37 - 32, r11);
        long r211 = p4.a.b(16, r11) * (-7286425919675154353L);
        long r114 = p4.a.b(24, r11) * 9;
        long r39 = p4.a.b(r37 - 8, r11);
        long r40 = p4.a.b(r37 - 16, r11) * r38;
        long r115 = r111 + r39;
        long r41 = ((p4.a.d(30, r112) + r113) * 9) + p4.a.d(43, r115);
        long r42 = ((r115 ^ r210) + r114) + 1;
        long r43 = Long.reverseBytes((r41 + r42) * r38) + r40;
        long r116 = r211 + r114;
        long r117 = p4.a.d(42, r116) + r113;
        long r118 = r116 + r113;
        long r44 = ((((Long.reverseBytes(((r117 + r118) * r38) + ((Long.reverseBytes((r42 + r43) * r38) + r39) * r38)) + r112) + r118) * r38) + r210) + r40;
        r17 = (((r44 >>> 47) ^ r44) * r38) + r117;
        goto L30
    L31:
        r22 = false;
        long r45 = p4.a.b(r12 - 40, r11);
        long r119 = p4.a.b(r12 - 56, r11) + p4.a.b(r12 - 16, r11);
        long r46 = r12;
        long r47 = p4.a.c(p4.a.b(r12 - 48, r11) + r46, p4.a.b(r12 - 24, r11));
        p4.b r212 = p4.a.e(r11, r12 - 64, r46, r47);
        p4.b r48 = p4.a.e(r11, r12 - 32, r119 - 5435081209227447693L, r45);
        long r49 = p4.a.b(0, r11) + (r45 * (-5435081209227447693L));
        int r50 = (r12 - 1) & (-64);
        int r51 = 0;
        p4.b r52 = r48;
        p4.b r53 = r212;
    L32:
        long r54 = p4.a.d(37, p4.a.b(r51 + 8, r11) + ((r49 + r119) + r53.f9943a)) * (-5435081209227447693L);
        long r120 = p4.a.d(42, p4.a.b(r51 + 48, r11) + (r119 + r53.f9944b)) * (-5435081209227447693L);
        long r121 = r52.f9944b ^ r54;
        long r213 = (p4.a.b(r51 + 40, r11) + r53.f9943a) + r120;
        long r55 = p4.a.d(33, r47 + r52.f9943a) * (-5435081209227447693L);
        p4.b r122 = p4.a.e(r11, r51, r53.f9944b * (-5435081209227447693L), r121 + r52.f9943a);
        p4.b r56 = p4.a.e(r11, r51 + 32, r52.f9944b + r55, p4.a.b(r51 + 16, r11) + r213);
        r51 = r51 + 64;
        r50 = r50 - 64;
        if (r50 == 0) goto L34;
        r49 = r55;
        r47 = r121;
        r119 = r213;
        r53 = r122;
        r52 = r56;
        goto L32
    L34:
        r23 = p4.a.c((((r213 ^ (r213 >>> 47)) * (-5435081209227447693L)) + p4.a.c(r122.f9943a, r56.f9943a)) + r121, p4.a.c(r122.f9944b, r56.f9944b) + r55);
    L45:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        r10 = r34;
        goto L11
    L54:
        return true;
    }

    public static final Object[] V0(Collection r8, Object[] r10) {
        i.f(r8, "collection");
        if (r10 == null) goto L38;
        int r11 = r8.size();
        int r12 = 0;
        if (r11 == 0) goto L7;
        Iterator r13 = r8.iterator();
        if (r13.hasNext() == true) goto L15;
        if (r10.length <= 0) goto L47;
        r10[0] = null;
        return r10;
    L47:
        return r10;
    L15:
        if (r11 > r10.length) goto L17;
        Object[] r14 = r10;
    L18:
        int r15 = r12 + 1;
        r14[r12] = r13.next();
        if (r15 < r14.length) goto L32;
        if (r13.hasNext() == false) goto L49;
        int r16 = ((r15 * 3) + 1) >>> 1;
        if (r16 > r15) goto L30;
        r16 = 2147483645;
        if (r15 < 2147483645) goto L30;
        throw new OutOfMemoryError();
    L30:
        r14 = Arrays.copyOf(r14, r16);
        i.e(r14, "copyOf(result, newSize)");
    L37:
        r12 = r15;
        goto L18
    L49:
        return r14;
    L32:
        if (r13.hasNext() == true) goto L37;
        if (r14 != r10) goto L35;
        r10[r15] = null;
        return r10;
    L35:
        Object[] r17 = Arrays.copyOf(r14, r15);
        i.e(r17, "copyOf(result, size)");
        return r17;
    L17:
        Object r18 = Array.newInstance(r10.getClass().getComponentType(), r11);
        i.d(r18, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r14 = (Object[]) r18;
        goto L18
    L7:
        if (r10.length <= 0) goto L45;
        r10[0] = null;
        return r10;
    L45:
        return r10;
    L38:
        throw null;
    }

    public static void W(String r8, String r10) {
        Log.i(r8, r10);
    }

    public static String[] W0(Set r8) {
        String[] r10 = new String[r8.size()];
        Iterator r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r10[r12] = (String) r11.next();
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    public static final androidx.work.a X(int r8) {
        if (r8 == 0) goto L9;
        if (r8 != 1) goto L7;
        return androidx.work.a.f2792b;
    L7:
        throw new IllegalArgumentException(android.aimedia.a.c("Could not convert ", r8, " to BackoffPolicy"));
    L9:
        return androidx.work.a.f2791a;
    }

    public static String X0(byte[] r10) {
        if (r10 == null) goto L13;
        int r8 = r10.length;
        if ((0 + r8) > r10.length) goto L11;
        int r11 = r8 * 2;
        char[] r12 = new char[r11];
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r8) goto L9;
        int r15 = r10[r13 + 0] & 255;
        int r16 = r14 + 1;
        char[] r17 = f9138g;
        r12[r14] = r17[r15 >> 4];
        r14 = r16 + 1;
        r12[r16] = r17[r15 & 15];
        r13 = r13 + 1;
        goto L6
    L9:
        return new String(r12, 0, r11);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }

    public static final n Y(int r8) {
        if (r8 == 0) goto L22;
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L25;
        if (r8 == 3) goto L24;
        if (r8 == 4) goto L23;
        if (r8 != 5) goto L16;
        return n.f2937p;
    L16:
        throw new IllegalArgumentException(android.aimedia.a.c("Could not convert ", r8, " to NetworkType"));
    L23:
        return n.f2936o;
    L24:
        return n.f2935n;
    L25:
        return n.f2934m;
    L26:
        return n.f2933b;
    L22:
        return n.f2932a;
    }

    public static String Y0(byte[] r10) {
        if (r10 == null) goto L13;
        int r8 = r10.length;
        if ((0 + r8) > r10.length) goto L11;
        int r11 = r8 * 2;
        char[] r12 = new char[r11];
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r8) goto L9;
        int r15 = r10[r13 + 0] & 255;
        int r16 = r14 + 1;
        char[] r17 = f9153v;
        r12[r14] = r17[r15 >> 4];
        r14 = r16 + 1;
        r12[r16] = r17[r15 & 15];
        r13 = r13 + 1;
        goto L6
    L9:
        return new String(r12, 0, r11);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }

    public static final androidx.work.q Z(int r8) {
        if (r8 == 0) goto L9;
        if (r8 != 1) goto L7;
        return androidx.work.q.f2943b;
    L7:
        throw new IllegalArgumentException(android.aimedia.a.c("Could not convert ", r8, " to OutOfQuotaPolicy"));
    L9:
        return androidx.work.q.f2942a;
    }

    public static final Map Z0(LinkedHashMap r8) {
        Map.Entry r10 = (Map.Entry) r8.entrySet().iterator().next();
        Map r11 = Collections.singletonMap(r10.getKey(), r10.getValue());
        i.e(r11, "with(entries.iterator().…ingletonMap(key, value) }");
        return r11;
    }

    public static final u.a a0(int r8) {
        if (r8 == 0) goto L21;
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L25;
        if (r8 == 3) goto L24;
        if (r8 == 4) goto L23;
        if (r8 != 5) goto L15;
        return u.a.f2957p;
    L15:
        throw new IllegalArgumentException(android.aimedia.a.c("Could not convert ", r8, " to State"));
    L23:
        return u.a.f2956o;
    L24:
        return u.a.f2955n;
    L25:
        return u.a.f2954m;
    L26:
        return u.a.f2953b;
    L21:
        return u.a.f2952a;
    }

    public static String a1(ArrayList r8) {
        StringBuilder r10 = new StringBuilder();
        int r11 = 0;
    L4:
        if (r11 >= r8.size()) goto L10;
        r10.append((String) r8.get(r11));
        if (r11 == (r8.size() - 1)) goto L8;
        r10.append(',');
    L8:
        r11 = r11 + 1;
        goto L4
    L10:
        return r10.toString();
    }

    public static final d b0(d r8) {
        i.f(r8, "<this>");
        if ((r8 instanceof ce.c) == false) goto L5;
        ce.c r10 = (ce.c) r8;
    L6:
        if (r10 == null) goto L12;
        d<Object> r11 = r10.intercepted();
        if (r11 != null) goto L11;
        return r8;
    L11:
        return r11;
    L12:
        return r8;
    L5:
        r10 = null;
        goto L6
    }

    public static void b1(String r8) {
        Log.w("SensitiveData", r8);
    }

    public static boolean c0() {
        String r8 = Build.MANUFACTURER;
        String r10 = "";
        if (r8 == null) goto L5;
        String r11 = r8.toLowerCase(Locale.ENGLISH);
    L7:
        if (r11.equals("lge") == true) goto L14;
        if (r8 == null) goto L11;
        r10 = r8.toLowerCase(Locale.ENGLISH);
    L11:
        if (r10.equals("samsung") == true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r11 = "";
        goto L7
    }

    public static void c1(String r8, String r10, Object... r11) {
        if (r11.length == 0) goto L6;
        r10 = String.format(r10, r11);
    L6:
        Log.w(r8, r10);
    }

    public static boolean d0(ArrayList r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.size() == 0) goto L7;
        return false;
    }

    public static void d1(ByteArrayOutputStream r8, long r10, int r11) {
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = (byte) ((r10 >> (r13 * 8)) & 255);
        r13 = r13 + 1;
        goto L3
    L5:
        r8.write(r12);
    }

    public static s1 e() {
        return new s1(null);
    }

    public static boolean e0(List r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.size() == 0) goto L7;
        return false;
    }

    public static void e1(ByteArrayOutputStream r8, int r10) {
        d1(r8, r10, 2);
    }

    public static Object f(Object r8, Class r10, String r11, Object... r12) {
        Class<?>[] r13 = new Class[r12.length];
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L14;
        Class<?> r16 = r12[r15].getClass();
        r13[r15] = r16;
        if (r16 != Integer.class) goto L8;
        r13[r15] = Integer.TYPE;
    L8:
        if (r13[r15] != Boolean.class) goto L11;
        r13[r15] = Boolean.TYPE;
    L11:
        if (r13[r15] != Double.class) goto L13;
        r13[r15] = Double.TYPE;
    L13:
        r15 = r15 + 1;
        goto L3
    L14:
        Method r17 = r10.getDeclaredMethod(r11, r13);
        if (r17.isAccessible() == true) goto L26;
        r17.setAccessible(true);
    L26:
        return r17.invoke(r8, r12);
    L19:
        th = move-exception;
        if ((th instanceof InvocationTargetException) == false) goto L23;
        Throwable r18 = th.getTargetException();     // Catch: Throwable -> L25
        t3.g("Reflect", "invokeMethod ".concat(r11), r18);     // Catch: Throwable -> L25
    L23:
        return null;
    }

    public static boolean f0(JSONObject r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.length() == 0) goto L7;
        return false;
    }

    public static Object g(Object r8, String r10, Object... r11) {
        return f(r8, r8.getClass(), r10, r11);
    L4:
        return null;
    }

    public static boolean g0(List r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.size() == 0) goto L7;
        return false;
    }

    public static Object h(String r8, String r10) {
        Class<?> r11 = Class.forName(r8);
        Field r12 = r11.getField(r10);
        r12.setAccessible(true);
        return r12.get(r11);
    }

    public static boolean h0(String r8) {
        if (r8 == null) goto L31;
        char[] r10 = r8.toCharArray();
        if (r10.length <= 0) goto L31;
        if (r10.length > 255) goto L31;
        int r11 = r10.length;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L29;
        char r13 = r10[r12];
        if (r13 < 'A') goto L16;
        if (r13 > 'Z') goto L16;
    L28:
        r12 = r12 + 1;
    L16:
        if (r13 < 'a') goto L20;
        if (r13 <= 'z') goto L28;
    L20:
        if (r13 < '0') goto L24;
        if (r13 <= '9') goto L28;
    L24:
        if (r13 == '.') goto L28;
        if (r13 == '-') goto L28;
        return false;
    L29:
        return true;
    L31:
        return false;
    }

    public static Object i(String r8, String r10, Object[] r11, Class[] r12) {
        Method r13 = Class.forName(r8).getDeclaredMethod(r10, r12);
        if (r13.isAccessible() == true) goto L6;
        r13.setAccessible(true);
    L6:
        return r13.invoke(null, r11);
    }

    public static final boolean i0(char r8) {
        if (Character.isWhitespace(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r8) == true) goto L8;
        return false;
    }

    public static String j(String r8) {
        if (r8 != null) goto L16;
        return null;
    L16:
        MessageDigest r10 = MessageDigest.getInstance(t4.n("ETUQ1"));     // Catch: Throwable -> L7
        r10.update(t4.i(r8));     // Catch: Throwable -> L7
        byte[] r11 = r10.digest();     // Catch: Throwable -> L7
    L14:
        return t4.r(r11);
    L11:
        th = move-exception;
        qa.l.a("ut", "h2s", th);
        return null;
    L7:
        th = move-exception;
        qa.l.a("MD5", "gmb", th);
        r11 = new byte[0];
        goto L14
    }

    public static r1 j0(z r8, p r10) {
        g r11 = g.f354a;
        b0 r12 = b0.f9995a;
        f r13 = v.a(r8, r11);
        b0 r14 = b0.f9995a;
        r1 r15 = new r1(r13, true);
        r15.W(r12, r15, r10);
        return r15;
    }

    public static PublicKey k(String r8) {
        byte[] r10 = defpackage.c.k(r8);     // Catch: NullPointerException -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
        return KeyFactory.getInstance(t4.n("EUlNB")).generatePublic(new X509EncodedKeySpec(r10));
    L5:
        throw new Exception("公钥数据为空");
    L9:
        throw new Exception("无此算法");
    L7:
        throw new Exception("公钥非法");
    }

    public static final List k0(Object r8) {
        List r10 = Collections.singletonList(r8);
        i.e(r10, "singletonList(element)");
        return r10;
    }

    public static void l(AMapLocation r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Bundle r10 = r8.getExtras();
        if (r10 != null) goto L9;
        Bundle r11 = new Bundle();
        r11.putInt("realLocationType", r8.f3649z);
        r8.setExtras(r11);
        return;
    L9:
        if (r10.containsKey("realLocationType") == true) goto L12;
        r10.putInt("realLocationType", r8.f3649z);
        return;
    }

    public static final List l0(Object... r8) {
        if (r8.length <= 0) goto L6;
        return yd.e.r0(r8);
    L6:
        return yd.k.f14119a;
    }

    public static final Object[] m(int r8) {
        if (r8 < 0) goto L4;
        boolean r10 = true;
    L5:
        if (r10 == false) goto L9;
        return new Object[r8];
    L9:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L4:
        r10 = false;
        goto L5
    }

    public static synchronized void m0() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f9132a == false) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        System.loadLibrary("bdzstd");     // Catch: Throwable -> L11
        f9132a = true;     // Catch: Throwable -> L11
        monitor-exit(a.class);
    }

    public static h0 n(z r8, p r10) {
        g r11 = g.f354a;
        b0 r12 = b0.f9995a;
        f r13 = v.a(r8, r11);
        b0 r14 = b0.f9995a;
        h0 r15 = new h0(r13, true);
        r15.W(r12, r15, r10);
        return r15;
    }

    public static final int n0(int r8) {
        if (r8 >= 0) goto L5;
        return r8;
    L5:
        if (r8 >= 3) goto L8;
        return r8 + 1;
    L8:
        if (r8 < 1073741824) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return (int) ((r8 / 0.75f) + 1.0f);
    }

    public static final int o(androidx.work.a r8) {
        i.f(r8, "backoffPolicy");
        int r10 = r8.ordinal();
        if (r10 != 0) goto L5;
        return 0;
    L5:
        if (r10 != 1) goto L8;
        return 1;
    L8:
        throw new ha.t();
    }

    public static final void o0(Context r10) {
        i.f(r10, "context");
        File r8 = r10.getDatabasePath("androidx.work.workdb");
        i.e(r8, "context.getDatabasePath(WORK_DATABASE_NAME)");
        if (r8.exists() == false) goto L27;
        m.d().a(j1.x.f8554a, "Migrating WorkDatabase to the no-backup directory");
        File r11 = r10.getDatabasePath("androidx.work.workdb");
        i.e(r11, "context.getDatabasePath(WORK_DATABASE_NAME)");
        File r12 = new File(j1.a.f8446a.a(r10), "androidx.work.workdb");
        String[] r13 = j1.x.f8555b;
        int r14 = n0(r13.length);
        if (r14 >= 16) goto L7;
        r14 = 16;
    L7:
        LinkedHashMap r15 = new LinkedHashMap(r14);
        int r16 = r13.length;
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L11;
        String r18 = r13[r17];
        r15.put(new File(r11.getPath() + r18), new File(r12.getPath() + r18));
        r17 = r17 + 1;
        goto L8
    L11:
        if (r15.isEmpty() == false) goto L13;
        Map r19 = Collections.singletonMap(r11, r12);
        i.e(r19, "singletonMap(pair.first, pair.second)");
        Map r110 = r19;
    L14:
        Iterator r111 = r110.entrySet().iterator();
    L16:
        if (r111.hasNext() == false) goto L34;
        Map.Entry r20 = (Map.Entry) r111.next();
        File r21 = (File) r20.getKey();
        File r22 = (File) r20.getValue();
        if (r21.exists() == false) goto L16;
        if (r22.exists() == false) goto L23;
        m.d().g(j1.x.f8554a, "Over-writing contents of " + r22);
    L23:
        if (r21.renameTo(r22) == false) goto L25;
        StringBuilder r23 = new StringBuilder("Migrated ");
        r23.append(r21);
        r23.append("to ");
        r23.append(r22);
    L26:
        m.d().a(j1.x.f8554a, r23.toString());
        goto L16
    L25:
        r23 = new StringBuilder("Renaming ");
        r23.append(r21);
        r23.append(" to ");
        r23.append(r22);
        r23.append(" failed");
        goto L26
    L34:
        return;
    L13:
        LinkedHashMap r112 = new LinkedHashMap(r15);
        r112.put(r11, r12);
        r110 = r112;
        goto L14
    }

    public static final Boolean p(boolean r8) {
        return Boolean.valueOf(r8);
    }

    public static void p0(int r8, rb.q r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L5
        r11.put("status", "status_receiver_result");     // Catch: Exception -> L5
        r11.put("cmd", r8);     // Catch: Exception -> L5
        r11.put("way", 1);     // Catch: Exception -> L5
        r11.put("package_name", "");     // Catch: Exception -> L5
        Integer r12 = r10.f11692b;     // Catch: Exception -> L5
        i.e(r12, "response.statusCode");     // Catch: Exception -> L5
        r11.put("error_code", r12.intValue());     // Catch: Exception -> L5
        r11.put("error_message", r10.f11693m);     // Catch: Exception -> L5
        t2.b.V("event_send_cmd_result", r11, new JSONObject(), new JSONObject());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        i.f("report exception " + Log.getStackTraceString(e), "msg");
    }

    public static final zd.a q(zd.a r8) {
        if (r8.f14341o != null) goto L7;
        r8.e();
        r8.f14340n = true;
        return r8;
    L7:
        throw new IllegalStateException();
    }

    public static final int q0(n r8) {
        i.f(r8, "networkType");
        int r10 = r8.ordinal();
        if (r10 != 0) goto L5;
        return 0;
    L5:
        if (r10 != 1) goto L7;
        return 1;
    L7:
        if (r10 != 2) goto L9;
        return 2;
    L9:
        if (r10 != 3) goto L11;
        return 3;
    L11:
        if (r10 != 4) goto L13;
        return 4;
    L13:
        if (r8 != n.f2937p) goto L16;
        return 5;
    L16:
        throw new IllegalArgumentException("Could not convert " + r8 + " to int");
    }

    public static final zd.f r(zd.f r8) {
        zd.b<E, ?> r10 = r8.f14366a;
        r10.c();
        r10.f14357v = true;
        return r8;
    }

    public static final void r0(xa.a r8, q r10) {
        i.f(r10, "block");
        int r11 = r8.f13764a;
        if (r11 != 0) goto L5;
    L6:
        r10.invoke(Boolean.valueOf(r8.f13767d), r8.f13766c, r8.f13769f);
        return;
    L5:
        if (r11 == 1) goto L6;
    }

    public static final LinkedHashSet s(byte[] r10) {
        i.f(r10, "bytes");
        LinkedHashSet r8 = new LinkedHashSet();
        int r11 = 0;
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return r8;
    L8:
        ByteArrayInputStream r13 = new ByteArrayInputStream(r10);
        ObjectInputStream r14 = new ObjectInputStream(r13);     // Catch: Throwable -> L21 IOException -> L23
        int r15 = r14.readInt();     // Catch: Throwable -> L16
    L11:
        if (r11 >= r15) goto L13;
        Uri r16 = Uri.parse(r14.readUTF());     // Catch: Throwable -> L16
        boolean r17 = r14.readBoolean();     // Catch: Throwable -> L16
        i.e(r16, "uri");     // Catch: Throwable -> L16
        r8.add(new androidx.work.d.b(r17, r16));     // Catch: Throwable -> L16
        r11 = r11 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        j r18 = j.f13877a;     // Catch: Throwable -> L16
        defpackage.c.A(r14, null);     // Catch: Throwable -> L21 IOException -> L23
    L25:
        j r19 = j.f13877a;     // Catch: Throwable -> L21
        defpackage.c.A(r13, null);
        return r8;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        defpackage.c.A(r14, th);     // Catch: Throwable -> L21 IOException -> L23
        throw th;     // Catch: Throwable -> L21 IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        defpackage.c.A(r13, th);
        throw th;
    L5:
        r12 = false;
        goto L6
    }

    public static void s0(String r8, long r10, long r11, boolean r12, JSONObject r13) {
        int r14 = od.a.f9776a;
        if (r13 != null) goto L6;
    L13:
        od.c.a(r8, od.e.f9782a);
        if (od.b.f9777b == null) goto L16;
    L25:
        od.b r15 = od.b.f9777b;
        LinkedList<od.b.a> r16 = r15.f9778a;
        monitor-enter(r16);
    L36:
        th = move-exception;
        throw th;
    L28:
        if (r15.f9778a.size() <= 200) goto L32;
        od.b.a r17 = r15.f9778a.poll();     // Catch: Throwable -> L36
        if (r17 == null) goto L32;
        od.c.a(r17.f9779a, od.e.f9783b);     // Catch: Throwable -> L36
    L32:
        r15.f9778a.add(new od.b.a(r8));     // Catch: Throwable -> L36
        monitor-exit(r16);     // Catch: Throwable -> L36
        Logger.w("AppLog", "null context when onEvent");
        return;
    L16:
        monitor-enter(od.b.class);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (od.b.f9777b != null) goto L20;
        od.b.f9777b = new od.b();     // Catch: Throwable -> L22
    L20:
        monitor-exit(od.b.class);     // Catch: Throwable -> L22
        goto L25
    L6:
        if (r13.has("ab_sdk_version") == true) goto L13;
        if (TextUtils.isEmpty(null) == true) goto L13;
        r13.put("ab_sdk_version", null);     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static void t(boolean r8) {
        if (r8 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void t0(Context r8, String r10, Bundle r11) {
        if (r5.f.b(r10) == false) goto L5;
        return;
    L5:
        JSONObject r12 = new JSONObject();
        r12.put("_event_v3", 1);     // Catch: Throwable -> L11
        Iterator<String> r13 = r11.keySet().iterator();     // Catch: Throwable -> L11
    L8:
        if (r13.hasNext() == false) goto L14;
        String r14 = r13.next();     // Catch: Throwable -> L11
        r12.put(r14, r11.get(r14));     // Catch: Throwable -> L11
    L14:
        if (r5.f.b("event_v3") == false) goto L16;
        return;
    L16:
        if (r5.f.b(r10) == true) goto L25;
        new td.c(r8, r10, r12).a();
        return;
    L25:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    public static final void u(int r8) {
        boolean r10 = true;
        if (r8 >= 1) goto L6;
        r10 = false;
    L6:
        if (r10 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(defpackage.a.d("Expected positive parallelism level, but got ", r8).toString());
    }

    public static JSONObject u0(JSONObject r8, String r10, String r11) {
        if (r8 != null) goto L5;
        return null;
    L5:
        JSONObject r12 = r8.optJSONObject(r10);
        if (r12 != null) goto L9;
        return null;
    L9:
        return r12.optJSONObject(r11);
    }

    public static final void v(int r8) {
        ke.c r10 = new ke.c(2, 36);
        if (2 <= r8) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        return;
    L10:
        StringBuilder r12 = defpackage.b.f("radix ", r8, " was not in valid range ");
        r12.append(new ke.c(2, 36));
        throw new IllegalArgumentException(r12.toString());
    L5:
        if (r8 > r10.f9110b) goto L7;
        r11 = true;
        goto L8
    }

    public static final List v0(List r8) {
        int r10 = r8.size();
        if (r10 == 0) goto L9;
        if (r10 == 1) goto L10;
        return r8;
    L10:
        return k0(r8.get(0));
    L9:
        return yd.k.f14119a;
    }

    public static final float w(float r8) {
        if (r8 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r8 <= 1.0f) goto L8;
        return 1.0f;
    L8:
        return r8;
    }

    public static final int w0(androidx.work.q r8) {
        i.f(r8, "policy");
        int r10 = r8.ordinal();
        if (r10 != 0) goto L5;
        return 0;
    L5:
        if (r10 != 1) goto L8;
        return 1;
    L8:
        throw new ha.t();
    }

    public static final int x(int r8, int r10) {
        if (r10 < 0) goto L10;
        if (r8 >= 0) goto L6;
        return 0;
    L6:
        if (r8 <= r10) goto L8;
        return r10;
    L8:
        return r8;
    L10:
        throw new IllegalArgumentException(android.aimedia.a.c("Cannot coerce value to an empty range: maximum ", r10, " is less than minimum 0."));
    }

    public static ha.p x0(pa.a r8) {
        r8.h0();     // Catch: NumberFormatException -> L7 IOException -> L10 pa.d -> L13 EOFException -> L16
        return (ha.p) r.f9079z.a(r8);
    L5:
        e = e;
        boolean r10 = false;
    L18:
        if (r10 == false) goto L22;
        return ha.r.f8002a;
    L22:
        throw new ha.q(e);
    L16:
        e = e;
        r10 = true;
    L13:
        e = move-exception;
        throw new ha.q(e);
    L10:
        e = move-exception;
        throw new ha.q(e);
    L7:
        e = move-exception;
        throw new ha.q(e);
    }

    public static final long y(long r8, long r10, long r11) {
        if (r10 > r11) goto L12;
        if (r8 >= r10) goto L8;
        return r10;
    L8:
        if (r8 <= r11) goto L10;
        return r11;
    L10:
        return r8;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    }

    public static ha.p y0(pa.a r8) {
        boolean r10 = r8.f9952b;
        r8.f9952b = true;
        ha.p r11 = x0(r8);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r8.f9952b = r10;
        return r11;
    L6:
        th = move-exception;
        r8.f9952b = r10;
        throw th;
    L11:
        e = move-exception;
        throw new ha.t("Failed parsing JSON source: " + r8 + " to Json", e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new ha.t("Failed parsing JSON source: " + r8 + " to Json", e);     // Catch: Throwable -> L6
    }

    public static byte[] z(byte[] r8) {
        Deflater r10 = new Deflater(1);
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        DeflaterOutputStream r12 = new DeflaterOutputStream(r11, r10);     // Catch: Throwable -> L14
        r12.write(r8);     // Catch: Throwable -> L8
        r12.close();     // Catch: Throwable -> L14
        r10.end();
        return r11.toByteArray();
    L8:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r10.end();
        throw th;
    }

    public static ha.p z0(String r8) {
        pa.a r10 = new pa.a(new StringReader(r8));     // Catch: NumberFormatException -> L11 IOException -> L14 pa.d -> L17
        ha.p r11 = y0(r10);     // Catch: NumberFormatException -> L11 IOException -> L14 pa.d -> L17
        r11.getClass();     // Catch: NumberFormatException -> L11 IOException -> L14 pa.d -> L17
        if ((r11 instanceof ha.r) == false) goto L6;
    L10:
        return r11;
    L6:
        if (r10.h0() == pa.b.f9975t) goto L10;
        throw new ha.q("Did not consume the entire document.");     // Catch: NumberFormatException -> L11 IOException -> L14 pa.d -> L17
    L14:
        e = move-exception;
        throw new ha.q(e);
    L11:
        e = move-exception;
        throw new ha.q(e);
    L17:
        e = move-exception;
        throw new ha.q(e);
    }

    public void L0(m.a r11, float r12) {
        CardView.a r13 = (CardView.a) r11;
        m.b r10 = (m.b) r13.f1339a;
        boolean r8 = r13.f1340b.getUseCompatPadding();
        CardView r14 = r13.f1340b;
        boolean r15 = r14.getPreventCornerOverlap();
        if (r12 == r10.f9236e) goto L5;
    L9:
        r10.f9236e = r12;
        r10.f9237f = r8;
        r10.f9238g = r15;
        r10.c(null);
        r10.invalidateSelf();
    L11:
        if (r14.getUseCompatPadding() == true) goto L13;
        r13.a(0, 0, 0, 0);
        return;
    L13:
        Drawable r16 = r13.f1339a;
        float r17 = ((m.b) r16).f9236e;
        float r18 = ((m.b) r16).f9232a;
        if (r14.getPreventCornerOverlap() == false) goto L16;
        float r19 = (float) (((1.0d - m.c.f9243a) * ((double) r18)) + ((double) r17));
    L17:
        int r20 = (int) Math.ceil(r19);
        float r110 = r17 * 1.5f;
        if (r14.getPreventCornerOverlap() == false) goto L20;
        r110 = (float) (((1.0d - m.c.f9243a) * ((double) r18)) + ((double) r110));
    L20:
        int r111 = (int) Math.ceil(r110);
        r13.a(r20, r111, r20, r111);
        return;
    L16:
        int r21 = m.c.f9244b;
        r19 = r17;
        goto L17
    L5:
        if (r10.f9237f != r8) goto L9;
        if (r10.f9238g != r15) goto L9;
        goto L9
    }

    @Override // ab.a
    public float a(long r8, Object r10, Object r11, float r12, fb.a r13) {
        int r14 = ((Number) r10).intValue();
        int r15 = ((Number) r11).intValue();
        i.f(r13, "spec");
        return r13.b(r8, Integer.valueOf(r14), Integer.valueOf(r15), r12);
    }

    @Override // ja.t
    public Object b() {
        return new LinkedHashSet();
    }

    @Override // ab.a
    public Object c(long r8, Object r10, Object r11, float r12, fb.a r13) {
        int r14 = ((Number) r10).intValue();
        int r15 = ((Number) r11).intValue();
        i.f(r13, "spec");
        return (Integer) r13.d(r8, Integer.valueOf(r14), Integer.valueOf(r15), r12);
    }

    @Override // ab.a
    public boolean d(long r8, long r10, fb.a r11) {
        i.f(r11, "spec");
        return r11.e(r8, r10);
    }
}
