package cl;

import a3.j;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.c;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.g;
import com.bytedance.salamander.anniex.b0;
import io.reactivex.internal.observers.h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import m.b;
import mh.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v0.d;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1217a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f1218b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f1219c = -1;

    public static boolean A(File r5) {
        if (r5.exists() == true) goto L6;
        return false;
    L6:
        File[] r10 = r5.listFiles();     // Catch: Throwable -> L15
        int r11 = r10.length;     // Catch: Throwable -> L15
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L14;
        if (r10[r12].getName().equals("drop") == true) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        io.reactivex.exceptions.a.i("find a disaster drop crash");     // Catch: Throwable -> L15
        return true;
    L14:
        return false;
    }

    public static p B(String r5) {
        String r10 = D(r5);     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L8
        p r12 = new p(17, false);     // Catch: Throwable -> L8
        r12.f23312b = r11.optString("url");     // Catch: Throwable -> L8
        r12.f23313c = r11.optJSONObject("body");     // Catch: Throwable -> L8
        r11.optString("dump_file");     // Catch: Throwable -> L8
        r11.optBoolean("encrypt", false);     // Catch: Throwable -> L8
        return r12;
    L8:
        return null;
    }

    public static boolean C(File r5) {
        boolean r10 = true;
        if (r5.exists() == true) goto L6;
        return true;
    L6:
        if (r5.canWrite() == true) goto L9;
        return false;
    L9:
        if (r5.isFile() == false) goto L13;
        return r5.delete();
    L13:
        if (r5.isDirectory() == false) goto L29;
        File[] r11 = r5.listFiles();
        int r12 = 0;
    L15:
        if (r11 == null) goto L28;
        if (r12 >= r11.length) goto L28;
        if (r11[r12].isFile() == true) goto L21;
        boolean r13 = C(r11[r12]);
    L23:
        r10 = r10 & r13;
    L26:
        r12 = r12 + 1;
        goto L15
    L21:
        if (r11[r12].canWrite() == false) goto L24;
        r13 = r11[r12].delete();
        goto L23
    L24:
        r10 = false;
    L28:
        return r5.delete() & r10;
    L29:
        return true;
    }

    public static String D(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return c(-1, new File(r5), "\n");
    }

    public static boolean E(File r5) {
        if (r5.isFile() == true) goto L7;
        r5 = new File(r5, "lock");
    L7:
        if (r5.exists() == true) goto L19;
        return false;
    L19:
        int r10 = NativeTools.k().G(r5.getAbsolutePath());     // Catch: Throwable -> L13
        if (r10 <= 0) goto L15;
        NativeTools.k().w(r10);     // Catch: Throwable -> L13
        return false;
    L15:
        return true;
    L13:
        th = move-exception;
        c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        return false;
    }

    public static JSONArray F(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return d(-1, new File(r5));
    }

    public static void G(File r5) {
        if (r5.getName().contains("deleted") == true) goto L7;
        r5.renameTo(new File(r5.getParent(), r5.getName() + "deleted"));     // Catch: Throwable -> L10
    L7:
        if (new File(r5, "deleted").exists() == true) goto L13;
        new File(r5, "deleted").createNewFile();     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    public static HashMap H(File r10) {
        FileInputStream r5 = null;
        Properties r11 = new Properties();     // Catch: Throwable -> L15 IOException -> L17
        FileInputStream r12 = new FileInputStream(r10);     // Catch: Throwable -> L15 IOException -> L17
    L31:
        r11.load(r12);     // Catch: Throwable -> L9 IOException -> L11
        Set<String> r13 = r11.stringPropertyNames();     // Catch: Throwable -> L9 IOException -> L11
        HashMap r14 = new HashMap();     // Catch: Throwable -> L9 IOException -> L11
        Iterator<String> r15 = r13.iterator();     // Catch: Throwable -> L9 IOException -> L11
    L6:
        if (r15.hasNext() == false) goto L13;
        String r16 = r15.next();     // Catch: Throwable -> L9 IOException -> L11
        r14.put(r16, r11.getProperty(r16));     // Catch: Throwable -> L9 IOException -> L11
    L13:
        f.h(r12);
        return r14;
    L11:
        e = e;
    L27:
        io.reactivex.exceptions.a.j(e);     // Catch: Throwable -> L22
        f.h(r12);
        return null;
    L22:
        th = th;
        r5 = r12;
    L24:
        r12 = r5;
    L25:
        f.h(r12);
        throw th;
    L9:
        th = th;
    L17:
        e = e;
        r12 = null;
    L15:
        th = th;
        goto L24
    }

    public static void I(File r5) {
        r5.createNewFile();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        io.reactivex.exceptions.a.i("err create file " + r5.getAbsolutePath());
    }

    public static Object J(String r5, ConcurrentHashMap r10) {
        Intrinsics.checkNotNullParameter(r10, TestRig.LEXER_START_RULE_NAME);
        if (r5 != null) goto L5;
    L4:
        String r11 = null;
    L9:
        if (r11 != null) goto L11;
    L15:
        return null;
    L11:
        if (r11.length() == 0) goto L15;
        return r10.get(r11);
    L5:
        String r12 = r5.toLowerCase(Locale.ROOT);
        if (r12 == null) goto L4;
        r11 = StringsKt.trim(r12).toString();
        goto L9
    }

    public static void K(ConcurrentHashMap r5, Map r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "tokenMap");
        Intrinsics.checkNotNullParameter(r10, "customTokens");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        if (r11 == false) goto L12;
        Iterator r12 = r10.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L20;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        Object r15 = r13.getValue();
        String r16 = StringsKt.trim(r14.toLowerCase(Locale.ROOT)).toString();
        if (r16.length() <= 0) goto L8;
        r5.put(r16, r15);
        goto L8
    L20:
        return;
    L12:
        Iterator r17 = r10.entrySet().iterator();
    L14:
        if (r17.hasNext() == false) goto L33;
        Map.Entry r18 = (Map.Entry) r17.next();
        String r19 = (String) r18.getKey();
        Object r20 = r18.getValue();
        String r21 = StringsKt.trim(r19.toLowerCase(Locale.ROOT)).toString();
        if (r21.length() <= 0) goto L14;
        if (r5.containsKey(r21) == true) goto L14;
        r5.put(r21, r20);
        goto L14
    }

    public static int a(z8.c r10, File r11) {
        JSONObject r5 = r10.f23416a;
        int r12 = -1;
        int r13 = 0;
    L4:
        if (r13 >= 6) goto L10;
        String r14 = com.lynx.jsbridge.a.d(r13, ".");
        String r15 = g.f4181a;
        File r16 = new File(r11, r11.getName() + r14);
        if (r16.exists() == false) goto L9;
        z8.c.n(r5, new JSONObject(D(r16.getAbsolutePath())));     // Catch: Throwable -> L12
        e.g(Integer.valueOf(r13), "succ_step", r5);     // Catch: Throwable -> L12
        r12 = r13;
    L9:
        r13 = r13 + 1;
        goto L4
    L10:
        z8.c.l(r10.b(), "filters", "succ_step", String.valueOf(r12));
        return r12;
    }

    public static final j b(String r5, LinkedHashMap r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        j r11 = (j) r10.get(r5);
        if (r11 != null) goto L6;
        j r12 = new j();
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }

    public static String c(long r5, File r10, String r11) {
        if (r10 != null) goto L4;
        return "";
    L4:
        if (r10.exists() == false) goto L36;
        StringBuilder r12 = new StringBuilder();
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L23
        if (r5 <= 0) goto L13;
        r14.skip(r5);     // Catch: Throwable -> L11
        r14.readLine();     // Catch: Throwable -> L11
    L11:
        th = th;
        r13 = r14;
    L24:
        f.h(r13);
        throw th;
    L13:
        String r15 = r14.readLine();     // Catch: Throwable -> L11
        if (r15 == null) goto L20;
        if (r12.length() == 0) goto L18;
        r12.append(r11);     // Catch: Throwable -> L11
    L18:
        r12.append(r15);     // Catch: Throwable -> L11
        goto L13
    L20:
        f.h(r14);
        return r12.toString();
    L23:
        th = th;
        goto L24
    L36:
        return "";
    }

    public static JSONArray d(long r5, File r10) {
        JSONArray r11 = new JSONArray();
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L19
        if (r5 <= 0) goto L9;
        r13.skip(r5);     // Catch: Throwable -> L7
        r13.readLine();     // Catch: Throwable -> L7
    L7:
        th = th;
        r12 = r13;
    L20:
        f.h(r12);
        throw th;
    L9:
        String r14 = r13.readLine();     // Catch: Throwable -> L7
        if (r14 == null) goto L16;
        if (r14.contains(" liblog  :") == true) goto L9;
        r11.put(r14);     // Catch: Throwable -> L7
        goto L9
    L16:
        f.h(r13);
        return r11;
    L19:
        th = th;
        goto L20
    }

    public static final JSONObject e(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "jsbError");
        JSONObject r10 = new JSONObject();
        qo.a.t("event_type", "jsbError", r10);
        qo.a.t("bridge_name", (String) r5.d, r10);
        qo.a.t("error_activity", null, r10);
        qo.a.e(r5.f7246b, WsConstants.ERROR_CODE, r10);
        qo.a.t("error_message", (String) r5.f7247c, r10);
        qo.a.t("js_type", null, r10);
        qo.a.t("error_url", null, r10);
        qo.a.e(0, "is_sync", r10);
        return r10;
    }

    public static final JSONObject f(String r5, Boolean r10, Integer r11, String r12, Integer r13) {
        JSONObject r14 = new JSONObject();
        qo.a.t("event_type", "nativeError", r14);
        qo.a.e(r11.intValue(), WsConstants.ERROR_CODE, r14);
        if (r12 == null) goto L6;
        qo.a.t("error_msg", r12, r14);
    L6:
        if (r10 != null) goto L9;
        qo.a.t("scene", "web_process_terminate", r14);
    L13:
        if (r5 == null) goto L15;
        qo.a.t("error_url", r5, r14);
    L15:
        if (r13 == null) goto L17;
        qo.a.e(r13.intValue(), "http_status", r14);
    L17:
        return r14;
    L9:
        if (r10.booleanValue() == false) goto L11;
        String r15 = "main_frame";
    L12:
        qo.a.t("scene", r15, r14);
        goto L13
    L11:
        r15 = "child_resource";
        goto L12
    }

    public static final JSONObject g(x4.e r5) {
        Intrinsics.checkNotNullParameter(r5, "jsbInfo");
        JSONObject r10 = new JSONObject();
        qo.a.t("event_type", "jsbPerf", r10);
        qo.a.t("bridge_name", r5.f22965a, r10);
        qo.a.e(r5.f22966b, "status_code", r10);
        qo.a.t("status_description", r5.f22967c, r10);
        qo.a.t("protocol_version", r5.d, r10);
        qo.a.k("cost_time", r5.e, r10);
        qo.a.k("invoke_ts", r5.f, r10);
        qo.a.k("callback_ts", r5.g, r10);
        qo.a.k("fireEvent_ts", 0, r10);
        qo.a.t("request_url", r5.f22968h, r10);
        return r10;
    }

    public static d h() {
        return (d) d.f22502n.getValue();
    }

    public static wc.a i(wc.a r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        wc.a r10 = new wc.a(r5.f22821a);
        if (r5.e == null) goto L9;
        ArrayList r11 = new ArrayList();
        List r12 = r5.e;
        Intrinsics.checkNotNull(r12);
        r11.addAll(r12);
        r10.e = r11;
    L9:
        if (r5.f22823c == null) goto L12;
        ArrayList r13 = new ArrayList();
        List r14 = r5.f22823c;
        Intrinsics.checkNotNull(r14);
        r13.addAll(r14);
        r10.f22823c = r13;
    L12:
        if (r5.d == null) goto L15;
        ArrayList r15 = new ArrayList();
        ArrayList r16 = r5.d;
        Intrinsics.checkNotNull(r16);
        r15.addAll(r16);
        r10.d = r15;
    L15:
        if (r5.f22822b.isEmpty() == true) goto L17;
        r10.f22822b.addAll(r5.f22822b);
    L17:
        return r10;
    }

    public static p j(File r18, CrashType r19) {
        File r5 = new File(r18, "logEventStack");
        boolean r10 = r18.getName().contains("oom");
        z8.c r11 = new z8.c();
        String r12 = "InvalidStack.NoStackAvailable: Not OOM.\n";
        if (r5.exists() == true) goto L86;
        if (r10 == true) goto L10;
    L11:
        String r13 = null;
        String r14 = null;
    L68:
        JSONObject r15 = r11.f23416a;
        e.g(r12, "data", r15);
        e.g(r13, "process_name", r15);
        e.g(r14, "crash_thread_name", r15);
        e.g(Boolean.valueOf(r10), "isOOM", r15);
        a(r11, r18);
        JSONObject r16 = r15.optJSONObject("header");
        String r17 = r15.optString("process_name");
        Context r20 = n.f4057a;
        z8.c r21 = Header.c(r17, r15.optLong("app_start_time", 0), r15.optLong("crash_time", 0));
        if (r16 != null) goto L71;
        e.g(r21.o().f4029a, "header", r15);
    L72:
        e.j(r11.b(), r21.b());
        String r22 = r18.getName();
        String r23 = r22.substring(r22.lastIndexOf(95) + 1);
        JSONObject r24 = r15.optJSONObject("header");
        if (r24.optString("unique_key", null) == null) goto L84;
    L78:
        p r25 = new p(17, false);
        if (r19 != CrashType.LAUNCH) goto L81;
        String r26 = n.f4062j.getLaunchCrashUploadUrl();
    L82:
        r25.f23312b = com.bytedance.crash.upload.b.i(r26, r24);
        r25.f23313c = r15;
        return r25;
    L81:
        r26 = n.f4062j.getJavaCrashUploadUrl();
        goto L82
    L84:
        r24.put("unique_key", "android_" + n.g().e() + "_" + r23 + "_" + CrashType.LAUNCH);     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        th.printStackTrace();
        goto L78
    L71:
        e.j(r16, r21.o().f4029a);
    L10:
        r12 = "InvalidStack.NoStackAvailable: Is OOM.\n";
        goto L11
    L86:
        String r27 = D(r5.getAbsolutePath());     // Catch: IOException -> L6
    L8:
        if (TextUtils.isEmpty(r27) == false) goto L12;
        if (r10 == false) goto L11;
    L12:
        String[] r28 = r27.split("\n");
        ArrayList r110 = new ArrayList();
        StringBuilder r111 = new StringBuilder();
        StringBuilder r112 = new StringBuilder();
        int r113 = r28.length;
        int r114 = 0;
        boolean r115 = false;
        boolean r116 = false;
    L13:
        if (r114 >= r113) goto L30;
        String r117 = r28[r114];
        if (r115 == false) goto L17;
    L19:
        if (r116 == false) goto L21;
    L23:
        if (r116 == false) goto L25;
        r112.append(r117);
        r112.append("\n");
    L28:
        r114 = r114 + 1;
        goto L13
    L25:
        if (r115 == false) goto L27;
        r111.append(r117);
        r111.append("\n");
        goto L28
    L27:
        r110.add(r117);
        goto L28
    L21:
        if (r117.startsWith("err:") == false) goto L23;
        r116 = true;
        goto L28
    L17:
        if (r117.startsWith("stack:") == false) goto L19;
        r115 = true;
        goto L28
    L30:
        if (r110.size() < 1) goto L32;
        r13 = (String) r110.get(0);
    L34:
        if (r110.size() < 2) goto L36;
        String r29 = (String) r110.get(1);
    L38:
        if (r110.size() < 3) goto L40;
        String r30 = (String) r110.get(2);
    L42:
        if (r110.size() < 4) goto L44;
        r14 = (String) r110.get(3);
    L45:
        if (r115 == false) goto L50;
        if (r111.length() <= 0) goto L50;
        r12 = r111.toString();
    L62:
        if (r116 == false) goto L68;
        if (r112.length() <= 0) goto L68;
        r12 = r12 + "\nCaused by: InvalidStack.CrashWhenWriteStack: err\n" + r112;
    L50:
        if (r30 == null) goto L55;
        StringBuilder r31 = com.lynx.tasm.utils.j.d(r30, "\nCaused by: ");
        if (r10 == false) goto L54;
        r12 = "InvalidStack.NoStackAvailable: Is OOM.\n";
    L54:
        r31.append(r12);
        r12 = r31.toString();
        goto L62
    L55:
        if (r29 == null) goto L60;
        StringBuilder r32 = com.lynx.tasm.utils.j.d(r29, "\nCaused by: ");
        if (r10 == false) goto L59;
        r12 = "InvalidStack.NoStackAvailable: Is OOM.\n";
    L59:
        r32.append(r12);
        r12 = r32.toString();
        goto L62
    L60:
        if (r10 == false) goto L62;
        r12 = "InvalidStack.NoStackAvailable: Is OOM.\n";
        goto L62
    L44:
        r14 = null;
        goto L45
    L40:
        r30 = null;
        goto L42
    L36:
        r29 = null;
        goto L38
    L32:
        r13 = null;
    L6:
        r27 = null;
        goto L8
    }

    public static void k(File r10, File r11) {
        if (r10.exists() == false) goto L31;
        int r5 = 0;
        if (r10.isFile() == false) goto L16;
        if (r11.exists() == true) goto L10;
    L13:
        l(r10, r11, false, Integer.MAX_VALUE);     // Catch: Throwable -> L32
        return;
    L10:
        if (r11.isDirectory() == true) goto L35;
        r11.delete();     // Catch: Throwable -> L32
        goto L13
    L35:
        return;
    L16:
        if (r11.exists() == true) goto L18;
        r11.mkdirs();     // Catch: Throwable -> L32
    L24:
        String[] r12 = r10.list();     // Catch: Throwable -> L32
        if (r12 == null) goto L37;
        int r13 = r12.length;     // Catch: Throwable -> L32
    L28:
        if (r5 >= r13) goto L39;
        String r14 = r12[r5];     // Catch: Throwable -> L32
        k(new File(r10, r14), new File(r11, r14));     // Catch: Throwable -> L32
        r5 = r5 + 1;
        goto L28
    L39:
        return;
    L37:
        return;
    L18:
        if (r11.isFile() == false) goto L21;
        r11.delete();     // Catch: Throwable -> L32
        goto L24
    L21:
        if (r11.getName().equals(r10.getName()) == true) goto L24;
        return;
    L31:
        return;
    }

    public static void l(File r5, File r10, boolean r11, int r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == true) goto L6;
        return;
    L6:
        if (r10.exists() == false) goto L9;
        if (r11 == true) goto L9;
        return;
    L9:
        FileOutputStream r13 = null;
        r10.getParentFile().mkdirs();     // Catch: Throwable -> L28 Exception -> L32
        FileInputStream r14 = new FileInputStream(r5);     // Catch: Throwable -> L28 Exception -> L32
    L38:
        FileOutputStream r15 = new FileOutputStream(r10, r11);     // Catch: Throwable -> L26 Exception -> L35
        goto L33
    L40:
        byte[] r16 = new byte[8192];     // Catch: Throwable -> L20 Exception -> L25
        int r17 = 0;
    L14:
        int r18 = r14.read(r16);     // Catch: Throwable -> L20 Exception -> L25
        if (r18 <= 0) goto L22;
        r15.write(r16, 0, r18);     // Catch: Throwable -> L20 Exception -> L25
        r17 = r17 + r18;
        if (r17 < r12) goto L14;
    L22:
        f.h(r14);
        f.h(r15);
        return;
    L25:
        r13 = r15;
    L20:
        Throwable th2 = th;
        r13 = r15;
    L30:
        f.h(r14);
        f.h(r13);
        throw th2;
    L26:
        th = move-exception;
        th2 = th;
    L33:
        f.h(r14);
        f.h(r13);
        return;
    L32:
        r14 = null;
    L28:
        th = move-exception;
        th2 = th;
        r14 = null;
        goto L30
    }

    public static void m(File r5, String r10, String r11, JSONObject r12) {
        if (r5.exists() == true) goto L5;
        r5.mkdirs();
    L5:
        File r13 = new File(r5, r10);
        JSONObject r14 = new JSONObject();
        r14.put("url", r11);     // Catch: JSONException -> L8
        r14.put("body", r12);     // Catch: JSONException -> L8
        r14.put("dump_file", "");     // Catch: JSONException -> L8
        r14.put("encrypt", true);     // Catch: JSONException -> L8
        q(r13, r14);     // Catch: JSONException -> L8
    L10:
        r13.getAbsolutePath();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void n(File r5, String r10, ZipOutputStream r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == false) goto L42;
        int r12 = 0;
        if (r5.isDirectory() == false) goto L18;
        File[] r13 = r5.listFiles();
        if (r13 == null) goto L43;
        r11.putNextEntry(new ZipEntry(h.b(r10, "/")));
        if (r10.length() != 0) goto L14;
        String r14 = "";
    L15:
        int r15 = r13.length;
    L16:
        if (r12 >= r15) goto L44;
        File r16 = r13[r12];
        StringBuilder r17 = sk.a.a(r14);
        r17.append(r16.getName());
        n(r16, r17.toString(), r11);
        r12 = r12 + 1;
        goto L16
    L44:
        return;
    L14:
        r14 = r10.concat("/");
        goto L15
    L43:
        return;
    L18:
        r11.putNextEntry(new ZipEntry(r10));
        FileInputStream r18 = null;
        FileInputStream r19 = new FileInputStream(r5);     // Catch: Throwable -> L31
        byte[] r20 = new byte[4096];     // Catch: Throwable -> L26
    L22:
        int r21 = r19.read(r20);     // Catch: Throwable -> L26
        if ((-1) == r21) goto L28;
        r11.write(r20, 0, r21);     // Catch: Throwable -> L26
        goto L22
    L28:
        f.h(r19);
        return;
    L26:
        th = th;
        r18 = r19;
    L32:
        f.h(r18);
        throw th;
    L31:
        th = th;
        goto L32
    }

    public static void o(File r5, Map r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L36;
        FileOutputStream r11 = null;
        Properties r12 = new Properties();     // Catch: Throwable -> L20 IOException -> L22
        FileOutputStream r13 = new FileOutputStream(r5);     // Catch: Throwable -> L20 IOException -> L22
        Iterator r14 = r10.entrySet().iterator();     // Catch: Throwable -> L12 IOException -> L14
    L10:
        if (r14.hasNext() == false) goto L16;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L12 IOException -> L14
        r12.setProperty((String) r15.getKey(), (String) r15.getValue());     // Catch: Throwable -> L12 IOException -> L14
        goto L10
    L16:
        r12.store(r13, "no");     // Catch: Throwable -> L12 IOException -> L14
        f.h(r13);
        return;
    L14:
        e = e;
        r11 = r13;
    L23:
        io.reactivex.exceptions.a.j(e);     // Catch: Throwable -> L20
        f.h(r11);
        return;
    L12:
        th = th;
    L26:
        f.h(r13);
        throw th;
    L22:
        e = e;
    L20:
        th = th;
        r13 = r11;
        goto L26
    }

    public static void p(File r5, JSONArray r10) {
        if (r10 == null) goto L17;
        r5.getParentFile().mkdirs();
        BufferedWriter r11 = new BufferedWriter(new FileWriter(r5, false));     // Catch: Throwable -> L9
        new com.bytedance.crash.util.f(r11).d(r10);     // Catch: Throwable -> L12
        r11.flush();     // Catch: Throwable -> L12
        f.h(r11);
        return;
    L10:
        f.h(r11);
        return;
    L9:
        r11 = null;
        goto L10
    }

    public static void q(File r5, JSONObject r10) {
        if (r10 == null) goto L17;
        r5.getParentFile().mkdirs();
        BufferedWriter r11 = new BufferedWriter(new FileWriter(r5, false));     // Catch: Throwable -> L9
        new com.bytedance.crash.util.f(r11).e(r10);     // Catch: Throwable -> L12
        r11.flush();     // Catch: Throwable -> L12
        f.h(r11);
        return;
    L10:
        f.h(r11);
        return;
    L9:
        r11 = null;
        goto L10
    }

    public static void r(OutputStream r10, c5.a... r11) {
        ZipOutputStream r5 = new ZipOutputStream(r10);     // Catch: Throwable -> L21
        r5.putNextEntry(new ZipEntry("/"));     // Catch: Throwable -> L15
        int r12 = r11.length;     // Catch: Throwable -> L15
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L19;
        c5.a r14 = r11[r13];     // Catch: Throwable -> L15
        if (r14 == null) goto L18;
        boolean r15 = r14.f1118b;     // Catch: Throwable -> L15
        File r16 = (File) r14.f1119c;     // Catch: Throwable -> L15
        if (r16 != null) goto L17;
        File[] r17 = (File[]) r14.d;     // Catch: Throwable -> L15
        if (r17 == null) goto L17;
        int r18 = r17.length;     // Catch: Throwable -> L15
        int r19 = 0;
    L13:
        if (r19 >= r18) goto L18;
        y(r5, r17[r19], r15);     // Catch: Throwable -> L15
        r19 = r19 + 1;     // Catch: Throwable -> L15
    L17:
        y(r5, r16, r15);     // Catch: Throwable -> L15
    L18:
        r13 = r13 + 1;
        goto L4
    L19:
        f.h(r5);
        return;
    L15:
        th = th;
    L23:
        f.h(r5);
        throw th;
    L21:
        th = th;
        r5 = null;
        goto L23
    }

    public static void s(String r5) {
        new File(r5, "drop").createNewFile();     // Catch: Throwable -> L5
        io.reactivex.exceptions.a.i("create drop flag:" + r5);     // Catch: Throwable -> L5
        return;
    }

    public static void t(String r10, com.bytedance.ies.bullet.service.sdk.b r11, int r12) {
        Iterator r13 = StringsKt.J(r10, new char[]{Typography.amp}, 0, 6).iterator();
    L4:
        if (r13.hasNext() == false) goto L57;
        List r5 = StringsKt.J((String) r13.next(), new char[]{'='}, 2, 2);
        if (r5.size() != 2) goto L4;
        String r14 = Uri.decode((String) r5.get(0));
        String r15 = Uri.decode((String) r5.get(1));
        if (r14 == null) goto L4;
        if (r15 == null) goto L4;
        ConcurrentHashMap r16 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r17 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r17 == null) goto L15;
        xc.d r18 = (xc.d) r17.a(xc.d.class);
        if (r18 == null) goto L15;
        boolean r19 = r18.N0();
    L17:
        if (r19 == false) goto L26;
        if (Intrinsics.areEqual(r14, "target") == false) goto L21;
    L31:
        boolean r20 = true;
    L32:
        LinkedHashMap r21 = r11.f6143o;
        if (r20 == false) goto L37;
        Intrinsics.checkNotNullParameter(r14, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r15, "value");
        if (((String) r21.get(r14)) != null) goto L42;
        r21.put(r14, r15);
    L42:
        if (r20 == false) goto L4;
        if (Intrinsics.areEqual(r14, "fallback_url") == true) goto L4;
        int r22 = StringsKt.r("://", 0, 6, r15);
        if (r22 == (-1)) goto L50;
        int r23 = StringsKt.q(r15, '?', r22 + 3, 4);
        if (r23 == (-1)) goto L50;
        int r24 = r23 + 1;
        int r25 = StringsKt.q(r15, '#', r24, 4);
        if (r25 != (-1)) goto L54;
        String r26 = r15.substring(r24, r15.length());
    L55:
        if (r26 == null) goto L4;
        t(r26, r11, r12 + 1);
        goto L4
    L54:
        r26 = r15.substring(r24, r25);
    L50:
        r26 = null;
        goto L55
    L37:
        Intrinsics.checkNotNullParameter(r14, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r15, "value");
        LinkedHashMap r27 = r11.f6142n;
        Integer r28 = (Integer) r27.get(r14);
        if (r28 != null) goto L40;
    L41:
        r27.put(r14, Integer.valueOf(r12));
        r21.put(r14, r15);
        goto L42
    L40:
        if (r28.intValue() >= r12) goto L42;
    L21:
        if (Intrinsics.areEqual(r14, "url") == true) goto L31;
        if (Intrinsics.areEqual(r14, "surl") == true) goto L31;
    L30:
        r20 = false;
        goto L32
    L26:
        if (Intrinsics.areEqual(r14, "target") == true) goto L31;
        if (StringsKt.k(r14, "url") == false) goto L30;
    L15:
        r19 = true;
        goto L17
    }

    public static void u(String r5, File r10, boolean r11) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        r10.getParentFile().mkdirs();
        FileOutputStream r12 = null;
        FileOutputStream r13 = new FileOutputStream(r10, r11);     // Catch: Throwable -> L12
        r13.write(r5.getBytes());     // Catch: Throwable -> L10
        r13.flush();     // Catch: Throwable -> L10
        f.h(r13);
        return;
    L10:
        th = th;
        r12 = r13;
    L13:
        f.h(r12);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static void v(String r5, String r10) {
        File r11 = new File(r5);
        ZipOutputStream r12 = null;
        new File(r10).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r13 = new ZipOutputStream(new FileOutputStream(r10));     // Catch: Throwable -> L9
        n(r11, "", r13);     // Catch: Throwable -> L7
        f.h(r13);
        return;
    L7:
        th = move-exception;
        th = th;
        r12 = r13;
    L10:
        f.h(r12);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void w(String r5, ArrayList r10) {
        ZipOutputStream r11 = null;
        ZipOutputStream r12 = new ZipOutputStream(new FileOutputStream(r5));     // Catch: Throwable -> L14
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L9
    L6:
        if (r13.hasNext() == false) goto L11;
        File r14 = new File((String) r13.next());     // Catch: Throwable -> L9
        n(r14, r14.getName(), r12);     // Catch: Throwable -> L9
        goto L6
    L11:
        f.h(r12);
        return;
    L9:
        th = th;
        r11 = r12;
    L15:
        f.h(r11);
        throw th;
    L14:
        th = th;
        goto L15
    }

    public static void x(ArrayList r10) {
        ArrayList r5 = new ArrayList();
        Iterator r11 = r10.iterator();     // Catch: ThreadDeath -> L9
    L4:
        if (r11.hasNext() == false) goto L36;
        String r12 = (String) r11.next();     // Catch: ThreadDeath -> L9
        StringBuilder r13 = new StringBuilder();     // Catch: ThreadDeath -> L9
        r13.append(g.h(n.f4057a));     // Catch: ThreadDeath -> L9
        r13.append("/");     // Catch: ThreadDeath -> L9
        String r14 = x8.a.f22982a;     // Catch: ThreadDeath -> L9
        r13.append("npth");     // Catch: ThreadDeath -> L9
        String r15 = r13.toString();     // Catch: ThreadDeath -> L9
        String r16 = g.h(n.f4057a) + "/npth_diggo";     // Catch: ThreadDeath -> L9
        String r17 = "";
        if (r12.contains(r15) == false) goto L11;
        r17 = r12.replace(r15, r16);     // Catch: ThreadDeath -> L9
    L11:
        File r18 = new File(r12);     // Catch: ThreadDeath -> L9
        File r19 = new File(r17);     // Catch: ThreadDeath -> L9
        if (r18.exists() == true) goto L14;
    L22:
        r12 = r17;
    L24:
        if (TextUtils.isEmpty(r12) == true) goto L4;
        r5.add(r12);     // Catch: ThreadDeath -> L9
        goto L4
    L14:
        if (r19.exists() == true) goto L22;
        if (r12.contains("asdawd") == true) goto L24;
        if (r18.isDirectory() == false) goto L21;
        k(r18, r19);     // Catch: ThreadDeath -> L9
        goto L22
    L21:
        l(r18, r19, false, Integer.MAX_VALUE);     // Catch: ThreadDeath -> L9
        goto L22
    L36:
        return;
    L9:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
    }

    public static void y(ZipOutputStream r5, File r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == false) goto L22;
        if (r11 == false) goto L8;
    L11:
        int r12 = 0;
        if (r10.isDirectory() == false) goto L14;
        File[] r13 = r10.listFiles();
    L15:
        if (r13 == null) goto L23;
        int r14 = r13.length;
    L18:
        if (r12 >= r14) goto L24;
        File r15 = r13[r12];
        n(r15, r15.getName(), r5);
        r12 = r12 + 1;
        goto L18
    L24:
        return;
    L23:
        return;
    L14:
        r13 = new File[]{r10};
        goto L15
    L8:
        if (r10.isDirectory() == false) goto L11;
        n(r10, r10.getName(), r5);
        return;
    }

    public static void z(JSONObject r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == null) goto L11;
        Iterator<String> r11 = r10.keys();
    L6:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();
        if (r5.has(r12) == true) goto L6;
        r5.put(r12, r10.get(r12));
        goto L6
    L17:
        return;
    }
}
