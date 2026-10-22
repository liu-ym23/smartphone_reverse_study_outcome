package t2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.appcompat.app.h;
import androidx.lifecycle.m;
import androidx.work.impl.WorkDatabase;
import androidx.work.v;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import he.i;
import j0.i0;
import j1.e0;
import j1.f0;
import j1.p;
import j1.r;
import j1.s;
import ja.t;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URI;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k5.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.d;
import r5.f;
import x4.e;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.compression.zstd.b, i0, t {
    public static boolean A = false;
    public static boolean B = false;
    public static final Object[] C = null;
    public static final Class[] D = null;
    public static String E = "";
    public static boolean F = false;
    public static volatile boolean G = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12241a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f12242b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h8.a f12243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12244d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f12245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f12246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f12247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f12248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f12249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f12250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f12251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f12252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f12253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f12254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f12255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f12256p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f12257q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f12258r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f12259s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f12260t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f12261u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f12262v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f12263w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Class f12264x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static Method f12265y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static Method f12266z;

    static {
        f12244d = new b();
        f12263w = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, BWDLCommandBuilder.CUSTOMIZED_CMD, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BWDLDataStructure.DataLinkParamStructure.NFC, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        C = new Object[0];
        D = new Class[0];
    }

    public b(TextView r8) {
        r8.getClass();
    }

    public static String A() {
        String r8 = f12262v;
        if (TextUtils.isEmpty(r8) == true) goto L5;
        return r8;
    L5:
        BufferedReader r10 = null;
        String r11 = null;
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L13
        StringBuilder r13 = new StringBuilder(32);     // Catch: Throwable -> L18
    L8:
        int r14 = r12.read();     // Catch: Throwable -> L18
        if (r14 <= 0) goto L11;
        r13.append((char) r14);     // Catch: Throwable -> L18
        goto L8
    L11:
        r11 = r13.toString();     // Catch: Throwable -> L18
    L12:
        String r15 = r11;
        r10 = r12;
    L14:
        defpackage.c.e0(r10);
        f12262v = r15;
        if (r15 != null) goto L24;
        return "";
    L24:
        return r15;
    L13:
        r15 = null;
        goto L14
    }

    public static int B(nc.b r8, int r10) {
        v(r8);     // Catch: Exception -> L11
        Method r11 = f12265y;     // Catch: Exception -> L11
        if (r11 == null) goto L6;
        Object r12 = r11.invoke(r8, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L11
    L7:
        if (r12 == null) goto L10;
        double r13 = ((Double) r12).doubleValue();     // Catch: Exception -> L11
    L13:
        if (r10 != 0) goto L15;
        Number r14 = 0;
    L19:
        return r14.intValue();
    L15:
        if (r10 <= 0) goto L17;
        r14 = Double.valueOf(r13);
        goto L19
    L17:
        r14 = Double.valueOf(-r13);
        goto L19
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");     // Catch: Exception -> L11
    L6:
        r12 = null;
    L11:
        e = move-exception;
        zc.b.c("ScrollerExt", "reflectGetSplineFlingDistance, velocity: " + r10 + ", error", e);
        A = false;
        r13 = 0.0d;
        goto L13
    }

    public static String C(Context r8) {
        if (f12246f != null) goto L21;
        String r10 = defpackage.c.f3212q;
        if (TextUtils.isEmpty(r10) == false) goto L19;
        String r11 = null;
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L23
    L10:
        int r14 = r12.read();     // Catch: Throwable -> L23
        if (r14 <= 0) goto L13;
        r13.append((char) r14);     // Catch: Throwable -> L23
        goto L10
    L13:
        r11 = r13.toString();     // Catch: Throwable -> L23
    L28:
        r12.close();     // Catch: Exception -> L22
    L18:
        r10 = r11;
        defpackage.c.f3212q = r10;
    L16:
        if (r12 == null) goto L18;
    L15:
        r12 = null;
    L19:
        String r15 = r10.replace(r8.getPackageName(), "p").replace(BdimCategoryConstants.SEPARATOR_COLON, "_");
        f12246f = r15;
        f12246f = r15.replace(".", "_");
    L21:
        return f12246f;
    }

    public static String D(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L8;
        int r10 = r8.indexOf("at ") + 3;
        int r11 = r8.indexOf(40);
        if (r10 < r11) goto L7;
        return "unknownMethodName";
    L7:
        return r8.substring(r10, r11);
    L8:
        return "unknownMethodName";
    }

    public static boolean F(int r20) {
        if (r20 == 0) goto L25;
        ThreadLocal<double[]> r8 = a0.a.f2a;
        double[] r10 = r8.get();
        if (r10 != null) goto L6;
        r10 = new double[3];
        r8.set(r10);
    L6:
        int r11 = Color.red(r20);
        int r12 = Color.green(r20);
        int r13 = Color.blue(r20);
        if (r10.length != 3) goto L24;
        double r14 = ((double) r11) / 255.0d;
        if (r14 >= 0.04045d) goto L11;
        double r15 = r14 / 12.92d;
    L12:
        double r16 = ((double) r12) / 255.0d;
        if (r16 >= 0.04045d) goto L15;
        double r17 = r16 / 12.92d;
    L16:
        double r18 = ((double) r13) / 255.0d;
        if (r18 >= 0.04045d) goto L19;
        double r19 = r18 / 12.92d;
    L20:
        double r110 = 0.3576d * r17;
        double r111 = r110 + (0.4124d * r15);
        boolean r21 = false;
        r10[0] = ((0.1805d * r19) + r111) * 100.0d;
        double r112 = 0.7152d * r17;
        double r113 = r112 + (0.2126d * r15);
        double r22 = ((0.0722d * r19) + r113) * 100.0d;
        r10[1] = r22;
        double r23 = r17 * 0.1192d;
        double r24 = r19 * 0.9505d;
        r10[2] = (r24 + (r23 + (r15 * 0.0193d))) * 100.0d;
        if ((r22 / 100.0d) <= 0.5d) goto L27;
        return true;
    L27:
        return r21;
    L19:
        r19 = Math.pow((r18 + 0.055d) / 1.055d, 2.4d);
        goto L20
    L15:
        r17 = Math.pow((r16 + 0.055d) / 1.055d, 2.4d);
        goto L16
    L11:
        r15 = Math.pow((r14 + 0.055d) / 1.055d, 2.4d);
        goto L12
    L24:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    L25:
        r21 = false;
        goto L27
    }

    public static boolean G() {
        if (B == false) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean I(MotionEvent r8, int r10) {
        if ((r8.getSource() & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean J(Context r8) {
        i.f(r8, "context");
        Resources r10 = r8.getResources();     // Catch: Exception -> L7
        i.e(r10, "context.resources");     // Catch: Exception -> L7
        if (r10.getConfiguration().orientation != 2) goto L9;
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        zc.b.c("ResourceUtils", "isLandscape error", e);
        goto L9
    }

    public static int K(float r8, int r10, int r11) {
        return a0.a.c(a0.a.d(r11, Math.round(Color.alpha(r11) * r8)), r10);
    }

    public static void L(Object r8, boolean r10) {
        if ((r8 instanceof String) == false) goto L5;
        String r11 = (String) r8;
    L6:
        JSONObject r12 = new JSONObject();
        if ((r8 instanceof d2.a) == false) goto L10;
        r12.put("label", ((d2.a) r8).a());     // Catch: Exception -> L17
    L10:
        if (r10 == false) goto L12;
        String r13 = "page_show";
    L13:
        if (r10 == false) goto L15;
        ApmDelegate.a.f3770a.getClass();
        new j2.a(new j2.a.C0096a());
    L15:
        defpackage.c.T(r12, r13, r11);
        return;
    L12:
        r13 = "page_hide";
        goto L13
    L5:
        r11 = r8.getClass().getName();
        goto L6
    }

    public static void M(JSONObject r8) {
        r8.put("passport-sdk-version", 18);     // Catch: JSONException -> L4
        r8.put("result", 0);     // Catch: JSONException -> L4
        throw new IllegalStateException("not init TTAccount config");     // Catch: JSONException -> L4
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static ArrayList N(String r8, JSONObject r10) {
        JSONArray r11 = r10.optJSONArray(r8);     // Catch: Exception -> L19
        int r12 = 0;
        if (r11 != null) goto L6;
    L9:
        boolean r13 = true;
    L10:
        if (r13 == false) goto L12;
        return null;
    L12:
        int r14 = r11.length();     // Catch: Exception -> L19
        ArrayList r15 = new ArrayList(r14);     // Catch: Exception -> L19
    L13:
        if (r12 >= r14) goto L18;
        String r16 = r11.getString(r12);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r16) == true) goto L17;
        r15.add(r16);     // Catch: Exception -> L19
    L17:
        r12 = r12 + 1;
        goto L13
    L18:
        return r15;
    L6:
        if (r11.length() == 0) goto L9;
        r13 = false;
    L19:
        return null;
    }

    public static ArrayList O(String r8, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(r8);     // Catch: Exception -> L20
        if (r11 != null) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
        return null;
    L12:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L20
        Iterator<String> r14 = r11.keys();     // Catch: Exception -> L20
    L13:
        if (r14.hasNext() == false) goto L19;
        String r15 = r14.next();     // Catch: Exception -> L20
        if (r11.optInt(r15) != 1) goto L13;
        r13.add(r15);     // Catch: Exception -> L20
        goto L13
    L19:
        return r13;
    L6:
        if (r11.length() == 0) goto L9;
        r12 = false;
    L20:
        return null;
    }

    public static String P(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L43;
        return "unknown message";
    L43:
        String[] r8 = r10.split(BdimCategoryConstants.SEPARATOR_COLON);     // Catch: Throwable -> L40
        if (r8.length != 2) goto L10;
        String r11 = r8[1];     // Catch: Throwable -> L40
    L12:
        if (r10.contains("{") == true) goto L14;
    L17:
        String r12 = r10;
    L19:
        if (r10.contains("@") == false) goto L24;
        String[] r13 = r10.split("@");     // Catch: Throwable -> L38
        if (r13.length <= 1) goto L24;
        r10 = r13[0];     // Catch: Throwable -> L38
    L24:
        if (r10.contains("(") == false) goto L34;
        if (r10.contains(")") == false) goto L34;
        if (r10.endsWith(" null") == true) goto L34;
        String[] r14 = r10.split("\\(");     // Catch: Throwable -> L38
        if (r14.length <= 1) goto L32;
        r10 = r14[1];     // Catch: Throwable -> L38
    L32:
        r10 = r10.replace(")", "");     // Catch: Throwable -> L38
    L34:
        if (r10.startsWith(" ") == false) goto L36;
        r10 = r10.replace(" ", "");     // Catch: Throwable -> L38
    L36:
        return r10 + r11;
    L39:
        return r12;
    L14:
        if (r10.contains("}") == false) goto L17;
        r12 = r10.split("\\{")[0];     // Catch: Throwable -> L40
        r10 = r12 + r10.split("\\}")[1];     // Catch: Throwable -> L38
        goto L19
    L10:
        r11 = "";
    L45:
        return r10;
    }

    public static long Q(String r8) {
        Logger.d("b", "utcTime " + r8);
        SimpleDateFormat r10 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r10.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date r11 = r10.parse(r8);     // Catch: ParseException -> L7
        if (r11 == null) goto L12;
        return r11.getTime();
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void R(AnimatorSet r10, ArrayList r11) {
        int r8 = r11.size();
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r8) goto L5;
        Animator r14 = (Animator) r11.get(r13);
        r12 = Math.max(r12, r14.getDuration() + r14.getStartDelay());
        r13 = r13 + 1;
        goto L3
    L5:
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{0, 0});
        r15.setDuration(r12);
        r11.add(0, r15);
        r10.playTogether(r11);
    }

    public static boolean S(int r8) {
        if (r8 > 0) goto L6;
        return false;
    L6:
        if (r8 < 10000) goto L9;
        return true;
    L9:
        if (new SecureRandom().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) < r8) goto L11;
        return false;
    L11:
        return true;
    }

    public static URI T(String r8) {
        if (f.b(r8) == false) goto L12;
        return null;
    L12:
        return new URI(r8);
    L8:
        return URI.create(r8.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return s(r8);
    }

    public static boolean U(FileInputStream r8, String r10, String r11) {
        FileOutputStream r12 = null;
        File r13 = new File(r10);     // Catch: Throwable -> L30 Exception -> L32
        if (r13.exists() == false) goto L6;
    L12:
        FileOutputStream r14 = new FileOutputStream(new File(r13, r11));     // Catch: Throwable -> L30 Exception -> L32
        byte[] r15 = new byte[1024];     // Catch: Throwable -> L26 Exception -> L28
    L15:
        int r16 = r8.read(r15);     // Catch: Throwable -> L26 Exception -> L28
        if (r16 == (-1)) goto L18;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L26 Exception -> L28
        goto L15
    L18:
        r14.flush();     // Catch: Throwable -> L26 Exception -> L28
        r14.close();     // Catch: Throwable -> L26 Exception -> L28
        r8.close();     // Catch: Throwable -> L30 Exception -> L32
        r8.close();     // Catch: Exception -> L22
        return true;
    L22:
        e = move-exception;
        e.printStackTrace();
        return true;
    L28:
        e = e;
        r12 = r14;
    L33:
        Logger.d("FileUtils", "save inputstream error: " + e);     // Catch: Throwable -> L30
        if (r12 != null) goto L57;
    L51:
        r8.close();     // Catch: Exception -> L38
    L40:
        return false;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L57:
        r12.close();     // Catch: Exception -> L50
    L26:
        th = th;
    L42:
        if (r14 != null) goto L59;
    L55:
        r8.close();     // Catch: Exception -> L46
        throw th;
    L46:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L59:
        r14.close();     // Catch: Exception -> L49
        goto L55
    L6:
        if (r13.mkdirs() == true) goto L12;
        r8.close();     // Catch: Exception -> L9
    L11:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = e;
    L30:
        th = th;
        r14 = r12;
        goto L42
    }

    public static void V(String r8, JSONObject r10, JSONObject r11, JSONObject r12) {
        return;
    L4:
        e = move-exception;
        i.f("event report exception " + Log.getStackTraceString(e), "msg");
    }

    public static boolean W(String r8, String r10, ArrayList r11) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty("=") == true) goto L42;
        String[] r12 = r8.split(r10);
        if (r12 != null) goto L11;
        return false;
    L11:
        int r13 = 0;
    L13:
        if (r13 >= r12.length) goto L30;
        if (TextUtils.isEmpty(r12[r13]) == true) goto L28;
        String[] r14 = r12[r13].trim().split("=");
        if (r14 == null) goto L28;
        if (r14.length != 2) goto L28;
        if (TextUtils.isEmpty(r14[0]) == true) goto L28;
        if (TextUtils.isEmpty(r14[1]) == true) goto L28;
        r11.add(new Pair(r14[0].trim(), r14[1].trim()));
    L28:
        r13 = r13 + 1;
        goto L13
    L30:
        if (r11.size() != 0) goto L32;
        return false;
    L32:
        return true;
    L42:
        return false;
    }

    public static boolean X(String r8, ArrayList r10) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (r8.contains("~") == true) goto L8;
        return false;
    L8:
        String[] r11 = r8.split("~");
        if (r11.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r11[0]) == false) goto L14;
    L25:
        return false;
    L14:
        if (TextUtils.isEmpty(r11[1]) == true) goto L25;
        long r12 = Q(r11[0]);
        long r13 = Q(r11[1]);
        if (r12 <= 0) goto L25;
        if (r13 <= 0) goto L25;
        if (r12 >= r13) goto L25;
        r10.add(Long.valueOf(r12));
        r10.add(Long.valueOf(r13));
        return true;
    }

    public static String Y(StackTraceElement[] r8) {
        if (r8 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r10 = new StringBuilder();
        int r11 = r8.length;
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L12;
        StackTraceElement r14 = r8[r12];
        r13 = r13 + 1;
        r10.append("\tat " + r14.getClassName());
        r10.append(".");
        r10.append(r14.getMethodName());
        r10.append("(");
        r10.append(r14.getFileName());
        r10.append(BdimCategoryConstants.SEPARATOR_COLON);
        r10.append(r14.getLineNumber());
        r10.append(")\n");
        if (r13 > 40) goto L12;
        r12 = r12 + 1;
    L12:
        return r10.toString();
    }

    public static synchronized void Z() {
        monitor-enter(b.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f12241a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f12241a = false;     // Catch: Throwable -> L15
        h8.a r8 = f12243c;     // Catch: Throwable -> L15
        EvilMethodSwitcher.isLimitEvilMethodDepth();     // Catch: Throwable -> L15
        r8.getClass();     // Catch: Throwable -> L15
        long r10 = EvilMethodSwitcher.getEvilThresholdMs();     // Catch: Throwable -> L15
        if (r10 >= 70) goto L12;
        r10 = 1000;
    L12:
        h8.a.f7923i = r10;     // Catch: Throwable -> L15
        com.bytedance.apm.block.c.f3756c = true;     // Catch: Throwable -> L15
        com.bytedance.apm.block.c.f3754a.remove("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L15
        monitor-exit(b.class);
    }

    public static String a0(org.tensorflow.lite.a r8) {
        switch(r8.ordinal()) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L6;
            case 5: goto L8;
            case 6: goto L14;
            case 7: goto L12;
            default: goto L5;
        };
    L6:
        return "string";
    L8:
        return "bool";
    L10:
        return MultiProcessSharedProvider.LONG_TYPE;
    L12:
        return "byte";
    L14:
        return "short";
    L16:
        return QesdkUtils.TYPES.DATA_TYPE_INT;
    L18:
        return "float";
    L5:
        throw new IllegalArgumentException("DataType error: DataType " + r8 + " is not supported yet");
    }

    public static final void b0(p r10, final WorkDatabase r11, androidx.work.c r12, final List r13, final r1.t r14, final Set r15) {
        final String r8 = r14.f11339a;
        final r1.t r16 = r11.f().g(r8);
        if (r16 == null) goto L24;
        if (r16.f11340b.a() == false) goto L9;
        v.a[] r17 = v.a.f2959a;
        return;
    L9:
        if ((r16.f() ^ r14.f()) == true) goto L21;
        final boolean r18 = r10.c(r8);
        if (r18 == true) goto L16;
        Iterator r19 = r13.iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        ((r) r19.next()).b(r8);
    L16:
        r11.runInTransaction(new e0(r11, r14, r16, r13, r8, r15, r18));
        if (r18 == true) goto L19;
        s.a(r12, r11, r13);
    L19:
        v.a[] r20 = v.a.f2959a;
        return;
    L21:
        StringBuilder r110 = new StringBuilder("Can't update ");
        f0 r111 = f0.f8478a;
        r110.append((String) r111.invoke(r16));
        r110.append(" Worker to ");
        throw new UnsupportedOperationException(android.aimedia.a.i(r110, (String) r111.invoke(r14), " Worker. Update operation must preserve worker's type."));
    L24:
        throw new IllegalArgumentException(defpackage.b.d("Worker with ", r8, " doesn't exist"));
    }

    public static final int e(WorkDatabase r8, String r10) {
        Long r11 = r8.b().b(r10);
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = (int) r11.longValue();
    L7:
        if (r13 == Integer.MAX_VALUE) goto L10;
        r12 = r13 + 1;
    L10:
        r8.b().a(new d(Long.valueOf(r12), r10));
        return r13;
    L5:
        r13 = 0;
        goto L7
    }

    public static final void f(Activity r8) {
        i.f(r8, "$this$adaptLightDarkStatusBar");
        Window r10 = r8.getWindow();
        if (r10 == null) goto L5;
        WindowInsetsController r11 = r10.getInsetsController();
    L6:
        if (r11 == null) goto L23;
        Resources r12 = Resources.getSystem();
        i.e(r12, "Resources.getSystem()");
        int r13 = r12.getConfiguration().uiMode & 48;
        boolean r14 = true;
        if (r13 != 32) goto L10;
        boolean r15 = true;
    L11:
        zc.b.a("ActivityUtils", "isSystemInDarkTheme: " + r15 + ", currentNightMode" + r13);
        if (r15 == false) goto L14;
    L21:
        r11.setSystemBarsAppearance(0, 8);
        return;
    L14:
        if (h.f649b == 2) goto L17;
        r14 = false;
    L17:
        zc.b.a("ActivityUtils", "isAppInDarkTheme: " + r14);
        if (r14 == true) goto L21;
        r11.setSystemBarsAppearance(8, 8);
        return;
    L10:
        r15 = false;
        goto L11
    L23:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static void g(Context r8, j0 r10, StringBuilder r11) {
        if (r10.f13480r == true) goto L15;
        e.b(r11, "build_serial", k.b(r8, r10));
        if (r10.A == false) goto L15;
        String[] r12 = k.f8944b.b(new Object[]{r8, r10});
        if (r12 == null) goto L15;
        if (r12.length <= 0) goto L15;
        String r13 = r12[0];
        int r14 = 1;
    L12:
        if (r14 >= r12.length) goto L14;
        StringBuilder r15 = android.aimedia.a.k(r13, ",");
        r15.append(r12[r14]);
        r13 = r15.toString();
        r14 = r14 + 1;
        goto L12
    L14:
        e.b(r11, "sim_serial_number", r13);
    L15:
        g5.k.c(r8).b();
        int r16 = x4.r.f13543a;
    }

    public static final int h(int r8, float r10) {
        if (r10 != 1.0f) goto L5;
        return r8;
    L5:
        float r11 = l6.a.w(r10);
        return Color.argb((int) (Color.alpha(r8) * r11), Color.red(r8), Color.green(r8), Color.blue(r8));
    }

    public static JSONArray i() {
        JSONArray r8 = new JSONArray();
        JSONObject r10 = new JSONObject();
        r10.put("module_name", "base");
        r10.put("span_name", "app_constructor");
        r10.put("start", f12247g);
        r10.put("end", f12248h);
        JSONObject r11 = new JSONObject();
        r11.put("module_name", "base");
        r11.put("span_name", "app_attachBaseContext");
        r11.put("start", f12249i);
        r11.put("end", f12250j);
        JSONObject r12 = new JSONObject();
        r12.put("module_name", "base");
        r12.put("span_name", "app_onCreate");
        r12.put("start", f12251k);
        r12.put("end", f12252l);
        JSONObject r13 = new JSONObject();
        r13.put("module_name", "base");
        r13.put("span_name", "activity_onCreate");
        r13.put("start", f12253m);
        r13.put("end", f12254n);
        JSONObject r14 = new JSONObject();
        r14.put("module_name", "base");
        r14.put("span_name", "activity_onResume");
        r14.put("start", f12257q);
        r14.put("end", f12258r);
        JSONObject r15 = new JSONObject();
        r15.put("module_name", "base");
        r15.put("span_name", "activity_onStart");
        r15.put("start", f12255o);
        r15.put("end", f12256p);
        if (f12259s <= 0) goto L5;
        JSONObject r16 = new JSONObject();
        r16.put("module_name", "base");
        r16.put("span_name", "activity_onWindowFocusChanged");
        r16.put("start", f12259s);
        r8.put(r16);
    L5:
        r8.put(r10);
        r8.put(r11);
        r8.put(r12);
        r8.put(r13);
        r8.put(r14);
        r8.put(r15);
        return r8;
    }

    public static String j(String r8) {
        return new String(Base64.decode(r8.getBytes("UTF-8"), 2));
    L4:
        return "";
    }

    public static void k(m r8, StringBuilder r10) {
        if (r8 != null) goto L4;
        String r11 = "null";
    L10:
        r10.append(r11);
        return;
    L4:
        String r12 = r8.getClass().getSimpleName();
        if (r12.length() > 0) goto L9;
        r12 = r8.getClass().getName();
        int r13 = r12.lastIndexOf(46);
        if (r13 <= 0) goto L9;
        r12 = r12.substring(r13 + 1);
    L9:
        r10.append(r12);
        r10.append('{');
        r11 = Integer.toHexString(System.identityHashCode(r8));
        goto L10
    }

    public static void l(String r8, boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r8);
    }

    public static void m(int r8) {
        if (r8 < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void n(Object r8, String r10) {
        if (r8 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }

    public static float o(float r8, float r10, float r11) {
        if (r8 >= r10) goto L6;
        return r10;
    L6:
        if (r8 <= r11) goto L8;
        return r11;
    L8:
        return r8;
    }

    public static int p(int r8, int r10, int r11) {
        if (r8 >= r10) goto L4;
        return r10;
    L4:
        if (r8 <= r11) goto L6;
        return r11;
    L6:
        return r8;
    }

    public static void q(Closeable r8) {
        if (r8 == null) goto L8;
        r8.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static byte[] r(byte[] r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L14
        GZIPOutputStream r11 = new GZIPOutputStream(r10);     // Catch: Throwable -> L12
        if (r8 != null) goto L24;
    L10:
        l6.a.K0(r11);
        l6.a.K0(r10);
        return r10.toByteArray();
    L24:
        r11.write(r8);     // Catch: Throwable -> L8
    L8:
        th = th;
    L28:
        c4.m.u().k(th, 14, "compress with gzip failed", new Object[0]);     // Catch: Throwable -> L19
        l6.a.K0(r11);
        l6.a.K0(r10);
        return null;
    L19:
        th = move-exception;
        l6.a.K0(r11);
        l6.a.K0(r10);
        throw th;
    L12:
        th = th;
        r11 = null;
    L14:
        th = th;
        r10 = null;
        r11 = null;
        goto L28
    }

    public static URI s(String r8) {
        if (f.b(r8) == false) goto L14;
        return null;
    L14:
        int r10 = r8.indexOf("?");     // Catch: Exception -> L11
        if (r10 <= 0) goto L9;
        r8 = r8.substring(0, r10);     // Catch: Exception -> L11
    L9:
        return URI.create(r8);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String t(String r8, byte[] r10) {
        String r11 = "";
        byte[] r12 = Base64.decode(r10, 0);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r8) == false) goto L19;
        return "";
    L19:
        SecretKeySpec r13 = new SecretKeySpec(r8.getBytes(), "AES");     // Catch: Exception -> L16
        Cipher r14 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L16
        r14.init(2, r13);     // Catch: Exception -> L16
        String r15 = new String(r14.doFinal(r12));     // Catch: Exception -> L16
        int r16 = r15.indexOf("$");     // Catch: Exception -> L12
        if (r16 == (-1)) goto L23;
        return r15.substring(0, r16);
    L23:
        return r15;
    L12:
        r11 = r15;
    L14:
        return r11;
    L15:
        return "";
    }

    public static String u(String r8, byte[] r10) {
        byte[] r11 = Base64.decode(r10, 0);     // Catch: Exception -> L5
        Cipher r12 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L5
        r12.init(2, new SecretKeySpec(r8.getBytes(), "AES"), new IvParameterSpec("NIfb&95GUY86Gfgh".getBytes()));     // Catch: Exception -> L5
        return new String(r12.doFinal(r11)).trim();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void v(nc.b r8) {
    L11:
        e = move-exception;
        zc.b.f("ScrollerExt", 8, "disableDynamicScroll, failed", e, 16);
        return;
    L3:
        if (f12266z != null) goto L7;
        Method r10 = OverScroller.class.getDeclaredMethod("disableDynamicScroll", new Class[0]);     // Catch: Exception -> L11
        f12266z = r10;     // Catch: Exception -> L11
        if (r10 == null) goto L7;
        r10.setAccessible(true);     // Catch: Exception -> L11
    L7:
        Method r11 = f12266z;     // Catch: Exception -> L11
        if (r11 == null) goto L16;
        r11.invoke(r8, new Object[0]);     // Catch: Exception -> L11
        return;
    }

    public static byte[] w(String r8, String r10) {
        Cipher r11 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L7
        int r12 = r11.getBlockSize();     // Catch: Exception -> L7
        byte[] r13 = r8.getBytes();     // Catch: Exception -> L7
        int r14 = r13.length;     // Catch: Exception -> L7
        if ((r14 % r12) == 0) goto L5;
        r14 = r14 + (r12 - (r14 % r12));     // Catch: Exception -> L7
    L5:
        byte[] r15 = new byte[r14];     // Catch: Exception -> L7
        System.arraycopy(r13, 0, r15, 0, r13.length);     // Catch: Exception -> L7
        r11.init(1, new SecretKeySpec(r10.getBytes(), "AES"), new IvParameterSpec("NIfb&95GUY86Gfgh".getBytes()));     // Catch: Exception -> L7
        return Base64.encode(r11.doFinal(r15), 0);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String x() {
        if (TextUtils.isEmpty(f12245e) == false) goto L6;
        f12245e = j("Ynl0ZWRhbmNl");
    L6:
        return f12245e;
    }

    public static int y(Context r8, int r10, int r11) {
        TypedValue r12 = x9.b.a(r8, r10);
        if (r12 == null) goto L9;
        int r13 = r12.resourceId;
        if (r13 == 0) goto L7;
        Object r14 = androidx.core.content.a.f1674a;
        int r15 = androidx.core.content.a.c.a(r8, r13);
    L8:
        Integer r16 = Integer.valueOf(r15);
    L10:
        if (r16 != null) goto L12;
        return r11;
    L12:
        return r16.intValue();
    L7:
        r15 = r12.data;
        goto L8
    L9:
        r16 = null;
        goto L10
    }

    public static int z(View r8, int r10) {
        Context r11 = r8.getContext();
        TypedValue r12 = x9.b.c(r8.getContext(), r10, r8.getClass().getCanonicalName());
        int r13 = r12.resourceId;
        if (r13 == 0) goto L6;
        Object r14 = androidx.core.content.a.f1674a;
        return androidx.core.content.a.c.a(r11, r13);
    L6:
        return r12.data;
    }

    public String E() {
        throw null;
    }

    public boolean H() {
        throw null;
    }

    public void a(View r8) {
    }

    @Override // ja.t
    public Object b() {
        return new ArrayDeque();
    }

    public void c() {
    }
}
