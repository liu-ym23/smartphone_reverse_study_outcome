package com.bytedance.apm.util;

import ai.j0;
import android.net.Uri;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.utils.k;
import com.squareup.kotlinpoet.f0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements com.bytedance.lego.init.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3904a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f3905b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3906c = false;
    public static boolean d = false;
    public static boolean e = false;

    public static n a(OptionCheckUpdateParams r10, String r11, List r12) {
        String r5 = r10.getTag();
        if (r5 != null) goto L5;
    L8:
        r5 = "gecko_client_default";
    L7:
        String r13 = r5;
        IESGurdUpdatePriority r14 = IESGurdUpdatePriority.f6591b;
        int r15 = r10.getChannelUpdatePriority();
        if (r15 != 0) goto L12;
        r14 = IESGurdUpdatePriority.f6590a;
    L15:
        IESGurdUpdatePriority r16 = r14;
        n r17 = new n(r13, r11, r12, r10.isLazyUpdate(), r16, null, r10.isEnableDownloadAutoRetry(), 704);
        r17.f4758a = r10.isEnableThrottle();
        r17.f4759b = r10.isEnableRetry();
        r17.f4760c = r10.getListener();
        return r17;
    L12:
        if (r15 != 2) goto L14;
        r14 = IESGurdUpdatePriority.f6592c;
        goto L15
    L14:
        if (r15 != 3) goto L15;
        r14 = IESGurdUpdatePriority.d;
        goto L15
    L5:
        if (r5.length() != 0) goto L7;
        goto L7
    }

    public static AuthBridgeAccess b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        String r10 = r5.toLowerCase();
        switch(r10.hashCode()) {
            case -977423767: goto L22;
            case -906273929: goto L17;
            case -608539730: goto L12;
            case -314497661: goto L9;
            case -309012785: goto L6;
            default: goto L24;
        };
    L6:
        if (r10.equals("protect") == false) goto L24;
    L15:
        return AuthBridgeAccess.d;
    L9:
        if (r10.equals("private") == true) goto L15;
    L12:
        if (r10.equals("protected") == true) goto L15;
    L17:
        if (r10.equals("secure") == false) goto L24;
        return AuthBridgeAccess.e;
    L22:
        if (r10.equals("public") == false) goto L24;
        return AuthBridgeAccess.f7302c;
    L24:
        return AuthBridgeAccess.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
    public static String c(String r5, wc.g r10) {
        Intrinsics.checkNotNullParameter(r5, "srcUrl");
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r5;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L10
        if (r10 != null) goto L6;
    L17:
        ?? r13 = Uri.parse(r5).buildUpon().clearQuery().build().toString();     // Catch: Throwable -> L10
    L18:
        r11.element = r13;     // Catch: Throwable -> L10
        return r13;
    L6:
        if (k.o(r10.f) == false) goto L13;
        if (k.o(r10.g) == false) goto L13;
        r13 = r10.f + '_' + r10.g;     // Catch: Throwable -> L10
    L16:
        if (r13 != 0) goto L18;
    L13:
        if (k.o(r10.f22839h) == false) goto L15;
        r13 = Uri.parse(r10.f22839h).buildUpon().clearQuery().toString();     // Catch: Throwable -> L10
        goto L16
    L15:
        r13 = Uri.parse(r5).buildUpon().clearQuery().build().toString();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Throwable r15 = Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        if (r15 == null) goto L26;
        String r16 = androidx.room.jarjarred.org.antlr.runtime.a.x(r15, new StringBuilder("generateKey error "));
        if (r16 == null) goto L26;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPreload", r16, null, 12);
    L26:
        return (String) r11.element;
    }

    public static Properties d(String r5) {
        String r10 = io.reactivex.internal.observers.h.b(r5, "/map_size.txt");
        Properties r11 = new Properties();     // Catch: Throwable -> L5
        r11.load(new FileInputStream(r10));     // Catch: Throwable -> L5
        return r11;
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static final we.a e(FileInputStream r16) {
        Intrinsics.checkNotNullParameter(r16, "inputStream");
        BufferedReader r5 = new BufferedReader(new InputStreamReader(r16));     // Catch: Exception -> L36
        String r10 = TextStreamsKt.readText(r5);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L36
        JSONObject r11 = new JSONObject(r10);     // Catch: Exception -> L36
        String r12 = r11.optString("version", "");     // Catch: Exception -> L36
        JSONObject r13 = r11.optJSONObject("android");     // Catch: Exception -> L36
        if (r13 == null) goto L8;
        JSONArray r14 = r13.optJSONArray("card_list");     // Catch: Exception -> L36
    L9:
        HashMap r15 = new HashMap();     // Catch: Exception -> L36
        boolean r17 = false;
        if (r14 == null) goto L12;
        int r18 = r14.length();     // Catch: Exception -> L36
        int r19 = 0;
    L13:
        if (r19 >= r18) goto L27;
        if (r14 == null) goto L26;
        JSONObject r20 = r14.optJSONObject(r19);     // Catch: Exception -> L36
        if (r20 == null) goto L26;
        String r21 = r20.optString("card_version", "");     // Catch: Exception -> L36
        String r110 = r20.optString("card_id", "");     // Catch: Exception -> L36
        String r111 = r20.optString("card_template_path", "");     // Catch: Exception -> L36
        r20.optString("desc");     // Catch: Exception -> L36
        r20.optBoolean("fetch_res", r17);     // Catch: Exception -> L36
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L36
        JSONArray r113 = r20.optJSONArray("res_http_prefix");     // Catch: Exception -> L36
        if (r113 == null) goto L25;
        int r114 = r113.length();     // Catch: Exception -> L36
        int r115 = r17;
    L20:
        if (r115 >= r114) goto L25;
        String r22 = r113.optString(r115);     // Catch: Exception -> L36
        if (r22 == null) goto L24;
        r112.add(r22);     // Catch: Exception -> L36
    L24:
        r115 = r115 + 1;     // Catch: Exception -> L36
    L25:
        r20.optJSONObject("extra");     // Catch: Exception -> L36
        r15.put(r110, new p000if.a(r21, r110, r111, r112));     // Catch: Exception -> L36
    L26:
        r19 = r19 + 1;     // Catch: Exception -> L36
        r17 = false;
        goto L13
    L27:
        Intrinsics.checkNotNullParameter(r12, "version");     // Catch: Exception -> L36
        Intrinsics.checkNotNullParameter(r15, "cardConfigs");     // Catch: Exception -> L36
        we.a r23 = new we.a();     // Catch: Exception -> L36
        r23.f22857a = r15;     // Catch: Exception -> L36
        return r23;
    L12:
        r18 = 0;
        r19 = 0;
        goto L13
    L8:
        r14 = null;
        goto L9
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L36:
        return null;
    }

    public static wn.c f(pm.a r5) {
        wn.c r10 = new wn.c();
        r10.f22882a = false;
        r10.f22883b = false;
        if (r5 != null) goto L6;
        r10.f22882a = false;
        return r10;
    L6:
        ReadableType r11 = r5.getType();
        if (r11 != ReadableType.Boolean) goto L11;
        r10.f22882a = r5.asBoolean();
        r10.f22883b = false;
        return r10;
    L11:
        if (r11 != ReadableType.String) goto L31;
        String r12 = r5.asString();
        if (TextUtils.isEmpty(r12) == false) goto L15;
    L30:
        r10.f22882a = false;
        r10.f22883b = false;
        goto L31
    L15:
        if ("none".equals(r12) == true) goto L30;
        if ("false".equals(r12) == true) goto L30;
        if ("default".equals(r12) == false) goto L22;
    L28:
        r10.f22882a = true;
        r10.f22883b = false;
        return r10;
    L22:
        if ("true".equals(r12) == true) goto L28;
        if ("await".equals(r12) == false) goto L31;
        r10.f22882a = true;
        r10.f22883b = true;
        return r10;
    L31:
        return r10;
    }

    public static boolean g(n r12) {
        int r5 = 0;
        String r10 = r12.g;
        if (r10 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        boolean r11 = r12.f4762i;
        List r13 = r12.f4761h;
        if (r11 == false) goto L43;
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L35;
        Iterator r15 = r13.iterator();
    L11:
        if (r15.hasNext() == false) goto L35;
        String r16 = (String) r15.next();
        PrepareMeta r17 = com.bytedance.iesgurd.meta.f.a(r10, r16);
        if (r17 != null) goto L15;
        ChannelMeta r18 = com.bytedance.iesgurd.meta.e.a(r10, r16);
        if (r18 == null) goto L24;
        Long r19 = r18.getId();
    L25:
        if (r19 != null) goto L26;
        IllegalStateException r20 = new IllegalStateException("No update meta for the channel");
        CopyOnWriteArraySet r21 = pa.b.f21323a;
        pa.a r22 = r12.f4760c;
        sa.a r23 = new sa.a(r16, 0);
        if (r22 == null) goto L33;
        r22.f(r23, r20);
    L33:
        r12.b(r16, "No update meta for the channel");
        goto L11
    L26:
        CopyOnWriteArraySet r24 = pa.b.f21323a;
        pa.b.a(r12.f4760c, r10, r16, r19.longValue());
        long r25 = r19.longValue();
        if (r12.f4764k == null) goto L11;
        r12.a(r16, new com.bytedance.iesgurd.g(null, r25, true));
        goto L11
    L24:
        r19 = null;
        goto L25
    L15:
        if (r17.getOnDemand() == true) goto L16;
        CopyOnWriteArraySet r26 = pa.b.f21323a;
        pa.a r27 = r12.f4760c;
        sa.a r28 = r17.getPack();
        IllegalArgumentException r29 = new IllegalArgumentException("Not on demand channel");
        if (r27 == null) goto L20;
        r27.f(r28, r29);
        String r30 = r28.f21882a;
    L20:
        r12.b(r16, "Not on demand channel");
        goto L11
    L16:
        r14.add(r17);
    L35:
        if (r14.isEmpty() == true) goto L42;
        Iterator r31 = r14.iterator();
    L39:
        if (r31.hasNext() == false) goto L41;
        PrepareMeta r32 = (PrepareMeta) r31.next();
        r32.setReqType(ReqType.LAZY);
        r32.ignoreBlocks();
        goto L39
    L41:
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new ab.b(r5, r14, r12));
    L42:
        return true;
    L43:
        if (r13 != null) goto L45;
    L61:
        return false;
    L45:
        if (r13.size() != 1) goto L61;
        ConcurrentHashMap r33 = com.bytedance.iesgurd.meta.f.f6652a;
        PrepareMeta r34 = com.bytedance.iesgurd.meta.f.a(r10, (String) r13.get(0));
        if (r34 == null) goto L61;
        if (r34.getOnDemand() == true) goto L52;
        return false;
    L52:
        List r35 = CollectionsKt.listOf(r34);
        if (r35.isEmpty() == true) goto L60;
        Iterator r36 = r35.iterator();
    L57:
        if (r36.hasNext() == false) goto L59;
        PrepareMeta r37 = (PrepareMeta) r36.next();
        r37.setReqType(ReqType.LAZY);
        r37.ignoreBlocks();
        goto L57
    L59:
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new ab.b(r5, r35, r12));
    L60:
        return true;
    }

    public static long h() {
        BufferedReader r5 = null;
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L9
        String r11 = r10.readLine();     // Catch: Throwable -> L6
        r10.close();     // Catch: Throwable -> L6
        String[] r12 = r11.split(" ");     // Catch: Throwable -> L6
        long r13 = ((Long.parseLong(r12[13]) + Long.parseLong(r12[14])) + Long.parseLong(r12[15])) + Long.parseLong(r12[16]);
        td.c.j(r10);
        return r13;
    L6:
        r5 = r10;
    L7:
        td.c.j(r5);
        return -1;
    }

    public static synchronized int i() {
        monitor-enter(a.class);
        int r5 = f3904a;     // Catch: Throwable -> L27
        if (r5 == 0) goto L37;
        monitor-exit(a.class);
        return r5;
    L37:
        BufferedReader r10 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);     // Catch: Throwable -> L19
        int r11 = 0;
    L35:
        String r12 = r10.readLine();     // Catch: Throwable -> L16
        if (r12 == null) goto L18;
        if (r12.startsWith("processor") == false) goto L35;
        r11 = r11 + 1;
        goto L35
    L18:
        r10.close();     // Catch: Throwable -> L30
        f3904a = r11;     // Catch: Throwable -> L30
    L16:
        Throwable th2 = th;
    L21:
        if (r10 == null) goto L23;
        r10.close();     // Catch: Throwable -> L30
    L23:
        throw th2;     // Catch: Throwable -> L30
    L19:
        th = move-exception;
        r10 = null;
        th2 = th;
    L24:
        int r13 = f3904a;     // Catch: Throwable -> L27
        monitor-exit(a.class);
        return r13;
    L27:
        th = move-exception;
        throw th;
    }

    public static long j() {
        if (f3905b != (-1)) goto L10;
        long r5 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r5 > 0) goto L8;
        r5 = 100;
    L8:
        f3905b = r5;
    L10:
        return f3905b;
    }

    public static String l(String r5) {
        FileInputStream r10 = new FileInputStream(new File(r5));     // Catch: Throwable -> L22
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L20
        BufferedReader r12 = new BufferedReader(new InputStreamReader(r10));     // Catch: Throwable -> L15
    L31:
        String r13 = r12.readLine();     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
        r11.append(r13);     // Catch: Throwable -> L10
        r11.append('\n');     // Catch: Throwable -> L10
        goto L31
    L12:
        r12.close();     // Catch: Throwable -> L20
        String r14 = r11.toString();     // Catch: Throwable -> L20
        r10.close();
        return r14;
    L10:
        Throwable th2 = th;
    L17:
        if (r12 == null) goto L19;
        r12.close();     // Catch: Throwable -> L20
    L19:
        throw th2;     // Catch: Throwable -> L20
    L15:
        th = move-exception;
        r12 = null;
        th2 = th;
    L20:
        Throwable th3 = th;
    L24:
        if (r10 == null) goto L26;
        r10.close();
    L26:
        throw th3;
    L22:
        th = move-exception;
        r10 = null;
        th3 = th;
        goto L24
    }

    public static long m() {
        int r5 = i();
        long r10 = -1;
        if (r5 > 0) goto L5;
        return -1;
    L5:
        int r11 = 0;
    L6:
        if (r11 >= r5) goto L26;
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + r11 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
    L30:
        String r14 = r13.readLine();     // Catch: Throwable -> L19
        if (r14 != null) goto L12;
    L28:
        r13.close();     // Catch: Throwable -> L27
        r11 = r11 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r14.isEmpty() == true) goto L28;
        String[] r15 = r14.split("\\s+");     // Catch: Throwable -> L19
        if (r15.length != 2) goto L30;
        r10 = r10 + Long.parseLong(r15[1]);
    L19:
        th = th;
        r12 = r13;
    L23:
        if (r12 == null) goto L25;
        r12.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r10;
    }

    public static long n() {
        String[] r5 = l(j0.h(Process.myPid(), "/proc/", "/status")).trim().split("\n");     // Catch: Exception -> L21
        int r10 = r5.length;     // Catch: Exception -> L21
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L15;
        String r12 = r5[r11];     // Catch: Exception -> L21
        if (r12.startsWith("VmSize") == false) goto L13;
        Matcher r13 = Pattern.compile("\\d+").matcher(r12);     // Catch: Exception -> L21
        if (r13.find() == false) goto L13;
        return Long.parseLong(r13.group());
    L13:
        r11 = r11 + 1;     // Catch: Exception -> L21
        goto L6
    L15:
        if (r5.length <= 12) goto L20;
        Matcher r14 = Pattern.compile("\\d+").matcher(r5[12]);     // Catch: Exception -> L21
        if (r14.find() == false) goto L20;
        return Long.parseLong(r14.group());
    L20:
        return -1;
    }

    public static boolean o(char r10) {
        return f0.g(Character.valueOf(r10), (char) 8677, (char) 8676, 171, 187, 48);
    }

    public static com.squareup.kotlinpoet.e p(String r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "format");
        Intrinsics.checkNotNullParameter(r10, "args");
        com.squareup.kotlinpoet.d r11 = new com.squareup.kotlinpoet.d();
        r11.a(r5, Arrays.copyOf(r10, r10.length));
        return r11.d();
    }

    public abstract Object k(Class r5);
}
