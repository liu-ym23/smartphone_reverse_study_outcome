package av;

import ai.j0;
import android.net.Uri;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SharedViewModelProvider;
import androidx.lifecycle.ViewModel;
import androidx.room.writer.DaoWriter;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt$getAISharedViewModel$1$1;
import com.bytedance.ai.viewmodel.AISharedViewModel;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f797a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f798b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f799c;

    public static int a(String r5) {
        String r10 = com.bytedance.crash.util.g.f4181a;
        return new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r5), "fds.txt"), 0).a();
    }

    public static long b() {
        if (cl.a.f1219c != (-1)) goto L14;
        long r5 = f798b;
        if (r5 > 0) goto L12;
        r5 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r5 > 0) goto L11;
        r5 = 100;
    L11:
        f798b = r5;
    L12:
        cl.a.f1219c = 1000 / r5;
    L14:
        return cl.a.f1219c;
    }

    public static final ViewModel c(SharedViewModelProvider r5, String r10, Lifecycle r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "customKey");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        Intrinsics.checkNotNullParameter(AISharedViewModel.class, "modelClass");
        String r12 = AISharedViewModel.class.getCanonicalName();
        if (r12 == null) goto L7;
        return r5.a(r11, td.d.b("androidx.lifecycle.ViewModelProvider.DefaultKey:", r10) + ':' + r12);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt$getAISharedViewModel$1$1] */
    public static final AISharedViewModel d(LifecycleOwner r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "appGroupId");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        return (AISharedViewModel) c(new SharedViewModelProvider(new SharedViewModelExtKt$getAISharedViewModel$1$1(r10)), r10, r5.getLifecycle());
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static com.bytedance.ies.bullet.service.sdk.d e() {
        return (com.bytedance.ies.bullet.service.sdk.d) com.bytedance.ies.bullet.service.sdk.d.e.getValue();
    }

    public static i9.c f(String r10, String r11) {
        i9.c r5 = new i9.c();
        String r12 = com.bytedance.crash.util.g.f4181a;
        File r13 = new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "threads.txt");
        String r14 = com.bytedance.crash.util.g.c(n.f4057a, r10).getAbsolutePath();
        if (r13.exists() == true) goto L5;
        NativeTools.k().u(r11, r14);
    L6:
        r5.f17525a = new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "meminfo.txt"), 1).a();
        r5.f17527c = new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "fds.txt"), 0).a();
        r5.d = new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "threads.txt"), 3).a();
        i9.b r15 = new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "meminfo.txt"), 0);
        r15.f17523b = "VmRSS:";
        r15.f17524c = "\\s+";
        r15.d = -1;
        r5.f17526b = r15.a();
        i(com.bytedance.crash.util.g.c(n.f4057a, r10), new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "fds.txt"));     // Catch: Throwable -> L9
    L61:
        a.a.i(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "fds.txt"), r5.f17528h);     // Catch: Throwable -> L14
    L16:
        JSONArray r16 = h(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "pthreads.txt"), new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "rountines.txt"));
        int r17 = r16.length();
        r5.e = r17;
        if (r17 > 0) goto L59;
    L19:
        String r18 = com.bytedance.crash.util.g.c(n.f4057a, r10).getAbsolutePath();
        long r19 = r5.f17525a;
        if (NativeTools.k().E() == false) goto L23;
        long r20 = Long.MAX_VALUE;
    L26:
        JSONArray r21 = null;
        if (r19 >= r20) goto L45;
        String r110 = NativeTools.k().o(r11, r18);
        Properties r22 = com.bytedance.apm.util.a.d(r18);
        if (r22 != null) goto L31;
    L37:
        r5.g = r21;
        if ("GPU".equals(r110) == false) goto L40;
    L43:
        r5.f = r110;
    L44:
        return r5;
    L40:
        if ("THREAD_STACK".equals(r110) == true) goto L43;
        r5.f = "EMPTY";
        goto L44
    L31:
        if (r22.isEmpty() == true) goto L37;
        Set r23 = r22.keySet();
        r21 = new JSONArray();
        Iterator r24 = r23.iterator();
    L35:
        if (r24.hasNext() == false) goto L37;
        Object r25 = r24.next();
        r21.put(((String) r25) + ":" + r22.get(r25));
        goto L35
    L45:
        r5.f = NativeTools.k().o(r11, r18);
        Properties r26 = com.bytedance.apm.util.a.d(r18);
        if (r26 != null) goto L48;
    L54:
        r5.g = r21;
        return r5;
    L48:
        if (r26.isEmpty() == true) goto L54;
        Set r111 = r26.keySet();
        r21 = new JSONArray();
        Iterator r112 = r111.iterator();
    L52:
        if (r112.hasNext() == false) goto L54;
        Object r27 = r112.next();
        r21.put(((String) r27) + ":" + r26.get(r27));
        goto L52
    L23:
        if (Header.h() == false) goto L25;
        r20 = 3891200;
        goto L26
    L25:
        r20 = 2867200;
        goto L26
    L59:
        cl.a.p(new File(com.bytedance.crash.util.g.c(n.f4057a, r10), "leakd_threads.txt"), r16);     // Catch: Throwable -> L56
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L9:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L61
    L5:
        NativeTools.k().x(r11, r14);
        goto L6
    }

    public static String g(String r5) {
        StringBuilder r10 = new StringBuilder();
        int r11 = 6;
    L3:
        if (r11 < 0) goto L13;
        r10.append(Integer.parseInt(r5.substring(r11, r11 + 2), 16));
        if (r11 == 0) goto L9;
        r10.append('.');
    L9:
        r11 = r11 - 2;
    L10:
        return null;
    L13:
        return r10.toString();
    }

    public static JSONArray h(File r10, File r11) {
        ListMap r5 = new ListMap();
        int r12 = 0;
        JSONArray r13 = cl.a.F(r10.getAbsolutePath());     // Catch: Throwable -> L19 IOException -> L58
        if (r13 == null) goto L25;
        int r14 = 0;
    L7:
        if (r14 >= r13.length()) goto L25;
        String r15 = r13.optString(r14);     // Catch: Throwable -> L19 IOException -> L58
        if (TextUtils.isEmpty(r15) == false) goto L13;
    L23:
        r14 = r14 + 1;
        goto L7
    L13:
        if (r15.startsWith("[tid:0") == false) goto L23;
        if (r15.endsWith("sigstack:0x0]") == false) goto L23;
        int r16 = r15.indexOf("[routine:0x");     // Catch: Throwable -> L19 IOException -> L58
        int r17 = r16 + 11;     // Catch: Throwable -> L19 IOException -> L58
        int r18 = r15.indexOf(93, r17);     // Catch: Throwable -> L19 IOException -> L58
        if (r16 <= 0) goto L21;
        String r19 = r15.substring(r17, r18);     // Catch: Throwable -> L19 IOException -> L58
    L22:
        r5.a(r19).add(r15);     // Catch: Throwable -> L19 IOException -> L58
        goto L23
    L21:
        r19 = "unknown addr";
        goto L22
    L19:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L25:
        JSONArray r20 = new JSONArray();
        if (r5.isEmpty() == false) goto L60;
    L57:
        return r20;
    L60:
        JSONArray r21 = cl.a.F(r11.getAbsolutePath());     // Catch: Throwable -> L44 IOException -> L59
        if (r21 == null) goto L57;
    L32:
        if (r12 >= r21.length()) goto L48;
        String r22 = r21.optString(r12);     // Catch: Throwable -> L44 IOException -> L59
        if (TextUtils.isEmpty(r22) == true) goto L47;
        String r23 = r22.substring(2, r22.indexOf(":"));     // Catch: Throwable -> L44 IOException -> L59
        if (r5.containsKey(r23) == false) goto L47;
        List r24 = r5.get(r23);     // Catch: Throwable -> L44 IOException -> L59
        if (r24 == null) goto L47;
        Iterator r25 = r24.iterator();     // Catch: Throwable -> L44 IOException -> L59
    L42:
        if (r25.hasNext() == false) goto L46;
        r20.put(((String) r25.next()) + " " + r22);     // Catch: Throwable -> L44 IOException -> L59
        goto L42
    L46:
        r5.remove(r23);     // Catch: Throwable -> L44 IOException -> L59
    L47:
        r12 = r12 + 1;     // Catch: Throwable -> L44 IOException -> L59
        goto L32
    L48:
        Iterator r26 = r5.values().iterator();     // Catch: Throwable -> L44 IOException -> L59
    L49:
        if (r26.hasNext() == false) goto L57;
        Iterator r27 = ((List) r26.next()).iterator();     // Catch: Throwable -> L44 IOException -> L59
    L53:
        if (r27.hasNext() == false) goto L49;
        r20.put(((String) r27.next()) + "  0x000000:unknown");     // Catch: Throwable -> L44 IOException -> L59
        goto L53
    L44:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L57
    }

    public static void i(File r26, File r27) {
        int r5 = 4;
        int r10 = 11;
        if (r27.exists() == false) goto L161;
        HashMap r11 = new HashMap();
        String[] r12 = {"net_tcp.txt", "net_tcp6.txt", "net_udp.txt", "net_udp6.txt"};
        int r13 = 0;
    L7:
        if (r13 >= r5) goto L59;
        File r14 = new File(r26, r12[r13]);
        if (r14.exists() == false) goto L55;
        int[] r15 = new int[r10];
        r15 = {x0200: FILL_ARRAY_DATA , data: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12} // fill-array;
        String[] r16 = {"sl", "local_address", "st", "tx_queue", "rx_queue", "tr", "tm->when", "retrnsmt", "uid", "timeout", "inode"};
        BufferedReader r17 = new BufferedReader(new InputStreamReader(new FileInputStream(r14)));     // Catch: Throwable -> L51
        String r18 = r17.readLine();     // Catch: Throwable -> L25
        if (r18 == null) goto L49;
        String[] r19 = r18.split("\\s+");     // Catch: Throwable -> L25
        if (r19.length <= r15[10]) goto L49;
        int r110 = 0;
    L20:
        if (r110 >= r10) goto L27;
        if (r19[r15[r110]].equals(r16[r110]) == false) goto L49;
        r110 = r110 + 1;     // Catch: Throwable -> L25
        r10 = 11;
    L27:
        String r20 = r17.readLine();     // Catch: Throwable -> L25
        if (r20 == null) goto L49;
        String[] r21 = r20.split("\\s+");     // Catch: Throwable -> L25
        if (r21.length == 0) goto L27;
        if (r21[0].length() == 0) goto L35;
        int r22 = -1;
    L37:
        int r111 = r22 + 10;
        if (r21.length <= r111) goto L27;
        long r112 = Long.parseLong(r21[r111]);     // Catch: Throwable -> L25 NumberFormatException -> L113
        Long r113 = Long.valueOf(r112);     // Catch: Throwable -> L25 NumberFormatException -> L113
        if (r112 == 0) goto L27;
        String r23 = k(r21[r22 + 3]);     // Catch: Throwable -> L25
        if (r23 == null) goto L27;
        r11.put(r113, r23);     // Catch: Throwable -> L25
        goto L27
    L35:
        r22 = 0;
    L49:
        com.bytedance.android.anniex.base.service.f.h(r17);
    L25:
        th = th;
        BufferedReader r114 = r17;
    L132:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L56
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L56
        com.bytedance.android.anniex.base.service.f.h(r114);
    L56:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r114);
        throw th;
    L51:
        th = th;
        r114 = null;
    L55:
        r13 = r13 + 1;
        r5 = 4;
        r10 = 11;
        goto L7
    L59:
        ArrayList r24 = new ArrayList();
        BufferedReader r25 = new BufferedReader(new InputStreamReader(new FileInputStream(r27)));     // Catch: Throwable -> L89
        String r28 = r25.readLine();     // Catch: Throwable -> L77
        if (r28 == null) goto L159;
        r24.add(r28);     // Catch: Throwable -> L77
        String r29 = r25.readLine();     // Catch: Throwable -> L77
    L65:
        if (r29 == null) goto L92;
        String[] r30 = r29.split("\\s++");     // Catch: Throwable -> L77
        if (r30.length != 0) goto L70;
    L87:
        r29 = r25.readLine();     // Catch: Throwable -> L77
        goto L65
    L70:
        if (r30[0].length() == 0) goto L72;
        int r31 = -1;
    L74:
        if (r30.length >= (r31 + 3)) goto L79;
        r24.add(r29);     // Catch: Throwable -> L77
        goto L87
    L79:
        int r32 = r31 + 2;
        long r115 = Long.parseLong(r30[r32]);     // Catch: Throwable -> L77 NumberFormatException -> L86
        int r33 = r31 + 1;
        int r34 = r29.indexOf(r30[r33]) + r30[r33].length();     // Catch: Throwable -> L77
        String r35 = r29.substring(0, r34) + r29.substring(r34).replaceFirst(r30[r32], "");     // Catch: Throwable -> L77
        String r36 = (String) r11.get(Long.valueOf(r115));     // Catch: Throwable -> L77
        if (r36 == null) goto L85;
        r35 = r35 + "   remote_addr:" + r36;     // Catch: Throwable -> L77
    L85:
        r24.add(r35);     // Catch: Throwable -> L77
        goto L87
    L86:
        r24.add(r29);     // Catch: Throwable -> L77
        goto L87
    L72:
        r31 = 0;
    L92:
        com.bytedance.android.anniex.base.service.f.h(r25);
        if (r27.delete() == false) goto L162;
        BufferedWriter r37 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r27)));     // Catch: Throwable -> L105
        Iterator r38 = r24.iterator();     // Catch: Throwable -> L101
    L98:
        if (r38.hasNext() == false) goto L103;
        r37.write(((String) r38.next()) + "\n");     // Catch: Throwable -> L101
        goto L98
    L103:
        com.bytedance.android.anniex.base.service.f.h(r37);
        return;
    L101:
        th = th;
        BufferedWriter r116 = r37;
    L124:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L110
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L110
        com.bytedance.android.anniex.base.service.f.h(r116);
        return;
    L110:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r116);
        throw th;
    L105:
        th = th;
        r116 = null;
        goto L124
    L162:
        return;
    L159:
        return;
    L77:
        th = th;
    L91:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L89:
        th = th;
        r25 = null;
        goto L91
    }

    public static int j(String r5) {
        String r10 = com.bytedance.crash.util.g.f4181a;
        return new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r5), "meminfo.txt"), 1).a();
    }

    public static String k(String r11) {
        String[] r12 = r11.split(":");
        if (r12.length == 2) goto L29;
        return null;
    L29:
        long r5 = Long.parseLong(r12[1], 16);     // Catch: NumberFormatException -> L28
        int r10 = 0;
        String r13 = r12[0];
        if (r13.length() != 8) goto L15;
        String r14 = g(r13);
        if (r14 != null) goto L13;
        return null;
    L13:
        return r14 + ":" + r5;
    L15:
        if (r13.length() != 32) goto L27;
        String r15 = g(r13.substring(24));
        if (r15 != null) goto L19;
        return null;
    L19:
        StringBuilder r16 = new StringBuilder();
        String r17 = r13.substring(0, 24);
        StringBuilder r18 = new StringBuilder();
    L20:
        if (r10 > 16) goto L25;
        int r19 = 6;
    L22:
        if (r19 < 0) goto L24;
        int r20 = r10 + r19;
        r18.append(r17.substring(r20, r20 + 2));
        r19 = r19 - 2;
        goto L22
    L24:
        r18.append(':');
        r10 = r10 + 8;
        goto L20
    L25:
        r16.append(r18.toString());
        r16.append(r15);
        r16.append(":");
        r16.append(r5);
        return r16.toString();
    L27:
        return null;
    }

    public static int l(String r5) {
        String r10 = com.bytedance.crash.util.g.f4181a;
        return new i9.b(new File(com.bytedance.crash.util.g.c(n.f4057a, r5), "threads.txt"), 3).a();
    }

    public static void m() {
        File[] r5 = new File(new File(System.getProperty("org.sqlite.tmpdir", System.getProperty("java.io.tmpdir"))).getAbsolutePath()).listFiles(new h());
        if (r5 == null) goto L13;
        int r10 = r5.length;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L20;
        File r12 = r5[r11];
        if (new File(r12.getAbsolutePath() + ".lck").exists() == true) goto L12;
        r12.delete();     // Catch: SecurityException -> L10
    L10:
        e = move-exception;
        System.err.println("Failed to delete old native lib" + e.getMessage());
    L12:
        r11 = r11 + 1;
        goto L5
    L20:
        return;
    }

    public static ConcurrentHashMap n(Class r10, Object r11) {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        if (r11 != null) goto L18;
    L17:
        return r5;
    L18:
        Field[] r12 = r11.getClass().getDeclaredFields();     // Catch: Throwable -> L13
        int r13 = r12.length;     // Catch: Throwable -> L13
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L17;
        Field r15 = r12[r14];     // Catch: Throwable -> L13
        if (t(r10, r15.getType()) == false) goto L15;
        r15.setAccessible(true);     // Catch: Throwable -> L13
        Object r16 = r15.get(r11);     // Catch: Throwable -> L13
        if (r16 == null) goto L15;
        r5.put(r15.getName().toLowerCase(Locale.ROOT), r16);     // Catch: Throwable -> L13
    L15:
        r14 = r14 + 1;
    L13:
        th = move-exception;
        Log.e("TokenCoreParser", "Failed to parse tokens from ".concat(r11.getClass().getSimpleName()), th);
        goto L17
    }

    public static final void o(List r5, LinkedHashSet r10) {
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        uu.a r12 = (uu.a) r11.next();
        r10.add(r12);
        o(r12.f, r10);
        goto L4
    }

    public static InputStream p(String r5) {
        String r10 = r5.substring(1);
        URL r11 = i.class.getClassLoader().getResource(r10);
        if (r11 != null) goto L10;
        return null;
    L10:
        URLConnection r12 = r11.openConnection();     // Catch: IOException -> L7
        r12.setDefaultUseCaches(false);     // Catch: IOException -> L7
        return r12.getInputStream();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String q() {
        URL r5 = i.class.getResource("/META-INF/maven/org.xerial/sqlite-jdbc/pom.properties");
        if (r5 != null) goto L6;
        r5 = i.class.getResource("/META-INF/maven/org.xerial/sqlite-jdbc/VERSION");
    L6:
        if (r5 == null) goto L14;
        Properties r10 = new Properties();     // Catch: IOException -> L9
        r10.load(r5.openStream());     // Catch: IOException -> L9
        return r10.getProperty("version", "unknown").trim().replaceAll("[^0-9\\.]", "");
    L9:
        e = move-exception;
        System.err.println(e);
        return "unknown";
    L14:
        return "unknown";
    }

    public static synchronized boolean r() {
        monitor-enter(i.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f797a == true) goto L9;
        m();     // Catch: Throwable -> L7
    L9:
        v();     // Catch: Throwable -> L7
        boolean r5 = f797a;     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r5;
    }

    public static boolean s(Uri r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if ("content".equals(r5.getScheme()) == false) goto L8;
        if ("media".equals(r5.getAuthority()) == false) goto L8;
        return true;
    }

    public static boolean t(Class r5, Class r10) {
        if (r5.isAssignableFrom(r10) == false) goto L6;
        return true;
    L6:
        if (r10.isPrimitive() == true) goto L9;
        return false;
    L9:
        if (r10 != Float.TYPE) goto L13;
        if (r5 != Float.class) goto L13;
        return true;
    L13:
        if (r10 != Integer.TYPE) goto L17;
        if (r5 != Integer.class) goto L17;
        return true;
    L17:
        if (r10 != Boolean.TYPE) goto L21;
        if (r5 != Boolean.class) goto L21;
        return true;
    L21:
        if (r10 != Long.TYPE) goto L25;
        if (r5 != Long.class) goto L25;
        return true;
    L25:
        if (r10 != Double.TYPE) goto L29;
        if (r5 != Double.class) goto L29;
        return true;
    L29:
        if (r10 != Short.TYPE) goto L33;
        if (r5 != Short.class) goto L33;
        return true;
    L33:
        if (r10 != Byte.TYPE) goto L37;
        if (r5 != Byte.class) goto L37;
        return true;
    L37:
        if (r10 != Character.TYPE) goto L42;
        if (r5 != Character.class) goto L42;
        return true;
    L42:
        return false;
    }

    public static boolean u(String r5, String r10) {
        if (new File(r5, r10).exists() == true) goto L10;
    L9:
        return false;
    L10:
        System.load(new File(r5, r10).getAbsolutePath());     // Catch: UnsatisfiedLinkError -> L7
        return true;
    L7:
        e = move-exception;
        PrintStream r11 = System.err;
        StringBuilder r12 = j0.x("Failed to load native library:", r10, ". osinfo: ");
        HashMap r13 = ev.a.f16871a;
        r12.append(ev.a.b() + "/" + ev.a.a());
        r11.println(r12.toString());
        r11.println(e);
        goto L9
    }

    public static void v() {
        if (f797a == false) goto L5;
        return;
    L5:
        LinkedList r5 = new LinkedList();
        String r10 = System.getProperty("org.sqlite.lib.path");
        String r11 = System.getProperty("org.sqlite.lib.name");
        if (r11 != null) goto L12;
        r11 = System.mapLibraryName("sqlitejdbc");
        if (r11 == null) goto L12;
        if (r11.endsWith(".dylib") == false) goto L12;
        r11 = r11.replace(".dylib", ".jnilib");
    L12:
        if (r10 != null) goto L14;
    L18:
        String r12 = i.class.getPackage().getName().replaceAll("\\.", "/");
        HashMap r13 = ev.a.f16871a;
        String r14 = androidx.constraintlayout.motion.widget.a.p("/", r12, "/native/", ev.a.b() + "/" + ev.a.a());
        if (i.class.getResource(r14 + "/" + r11) == null) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L24;
    L28:
        if (r15 == false) goto L76;
        String r16 = new File(System.getProperty("org.sqlite.tmpdir", System.getProperty("java.io.tmpdir"))).getAbsolutePath();
        String r17 = j0.D(r14, "/", r11);
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("sqlite-", q(), DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, UUID.randomUUID().toString(), DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r18.append(r11);
        String r19 = r18.toString();
        String r20 = r19.concat(".lck");
        File r21 = new File(r16, r19);
        File r110 = new File(r16, r20);
        InputStream r22 = p(r17);     // Catch: IOException -> L33
        if (r110.exists() == true) goto L35;
        new FileOutputStream(r110).close();     // Catch: IOException -> L33
    L35:
        FileOutputStream r111 = new FileOutputStream(r21);     // Catch: IOException -> L33
        byte[] r112 = new byte[8192];     // Catch: Throwable -> L42
    L38:
        int r113 = r22.read(r112);     // Catch: Throwable -> L42
        if (r113 == (-1)) goto L44;
        r111.write(r112, 0, r113);     // Catch: Throwable -> L42
    L44:
        r21.deleteOnExit();     // Catch: IOException -> L33
        r110.deleteOnExit();     // Catch: IOException -> L33
        r111.close();     // Catch: IOException -> L33
        r22.close();     // Catch: IOException -> L33
        r21.setReadable(true);     // Catch: IOException -> L33
        r21.setWritable(true, true);     // Catch: IOException -> L33
        r21.setExecutable(true);     // Catch: IOException -> L33
        InputStream r23 = p(r17);     // Catch: IOException -> L33
        FileInputStream r24 = new FileInputStream(r21);     // Catch: IOException -> L33
    L62:
        th = move-exception;
        if (r23 == null) goto L65;
        r23.close();     // Catch: IOException -> L33
    L65:
        r24.close();     // Catch: IOException -> L33
        throw th;     // Catch: IOException -> L33
    L46:
        if ((r23 instanceof BufferedInputStream) == true) goto L48;
        InputStream r114 = new BufferedInputStream(r23);     // Catch: Throwable -> L62
    L49:
        BufferedInputStream r115 = new BufferedInputStream(r24);     // Catch: Throwable -> L62
        int r116 = r114.read();     // Catch: Throwable -> L62
    L50:
        if (r116 == (-1)) goto L55;
        if (r116 != r115.read()) goto L61;
        r116 = r114.read();     // Catch: Throwable -> L62
    L61:
        throw new RuntimeException(String.format("Failed to write a native library file at %s", new Object[]{r21}));     // Catch: Throwable -> L62
    L55:
        if (r115.read() != (-1)) goto L61;
        if (r23 == null) goto L58;
        r23.close();     // Catch: IOException -> L33
    L58:
        r24.close();     // Catch: IOException -> L33
        boolean r25 = u(r16, r19);     // Catch: IOException -> L33
    L72:
        if (r25 == false) goto L75;
        f797a = true;
        return;
    L75:
        r5.add(r14);
        goto L76
    L48:
        r114 = r23;
    L42:
        th = move-exception;
        r21.deleteOnExit();     // Catch: IOException -> L33
        r110.deleteOnExit();     // Catch: IOException -> L33
        r111.close();     // Catch: IOException -> L33
        if (r22 == null) goto L70;
        r22.close();     // Catch: IOException -> L33
    L70:
        throw th;     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        r25 = false;
    L76:
        String[] r26 = System.getProperty("java.library.path", "").split(File.pathSeparator);
        int r27 = r26.length;
        int r28 = 0;
    L77:
        if (r28 >= r27) goto L87;
        String r29 = r26[r28];
        if (r29.isEmpty() == true) goto L86;
        if (u(r29, r11) == true) goto L83;
        r5.add(r29);
        goto L86
    L83:
        f797a = true;
        return;
    L86:
        r28 = r28 + 1;
        goto L77
    L87:
        f797a = false;
        String r30 = ev.a.b();
        String r31 = ev.a.a();
        throw new Exception(j0.q(androidx.constraintlayout.motion.widget.a.y("No native library found for os.name=", r30, ", os.arch=", r31, ", paths=["), f4.b.m(r5, File.pathSeparator), "]"));
    L24:
        if (ev.a.b().equals("Mac") == false) goto L28;
        if (i.class.getResource(r14.concat("/libsqlitejdbc.jnilib")) == null) goto L28;
        r11 = "libsqlitejdbc.jnilib";
        r15 = true;
        goto L28
    L21:
        r15 = false;
        goto L22
    L14:
        if (u(r10, r11) == false) goto L17;
        f797a = true;
        return;
    L17:
        r5.add(r10);
        goto L18
    }

    public static Object w(String r5, ConcurrentHashMap r10) {
        if (r5 == null) goto L9;
        String r11 = r5.toLowerCase(Locale.ROOT).trim();
        if (r11.length() != 0) goto L8;
        return null;
    L8:
        return r10.get(r11);
    L9:
        return null;
    }

    public static void x(ConcurrentHashMap r5, Map r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L29;
        Iterator r12 = r10.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L30;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        if (r14 == null) goto L8;
        String r15 = r14.toLowerCase(Locale.ROOT).trim();
        if (r15.length() == 0) goto L8;
        if (r11 == true) goto L16;
        r5.putIfAbsent(r15, r13.getValue());
        goto L8
    L16:
        r5.put(r15, r13.getValue());
        goto L8
    L30:
        return;
    }
}
