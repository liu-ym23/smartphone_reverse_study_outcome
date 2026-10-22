package n4a;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r extends n implements Thread.UncaughtExceptionHandler {
    public static final Set<Integer> e = null;
    public final Context d;

    public r(Context r4) {
        this.d = r4;
        Thread.UncaughtExceptionHandler r5 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        this.a = r5;     // Catch: Throwable -> L17
        if (r5 != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.b = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r6 = r5.toString();     // Catch: Throwable -> L17
        if (r6.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.b = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r6.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.b = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r6.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public static void f(Throwable r2, String r3, String r4) {
        r r0 = n.c;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.c(r2, 1, r3, r4);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r3, Throwable r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        c(r4, 0, null, null);
        Thread.UncaughtExceptionHandler r0 = this.a;
        if (r0 == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(r0);     // Catch: Throwable -> L9
    L7:
        this.a.uncaughtException(r3, r4);
        return;
    }

    static {
        e = Collections.synchronizedSet(new HashSet());
        new AtomicInteger(1);
    }

    public static synchronized void e() {
        monitor-enter(r.class);
        PThreadPoolExecutor r1 = h0.r;     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
    L31:
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        return;
    L13:
        if (n.c == null) goto L19;
        Thread.UncaughtExceptionHandler r2 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L22
        r r3 = n.c;     // Catch: Throwable -> L22
        if (r2 != r3) goto L19;
        Thread.UncaughtExceptionHandler r4 = r3.a;     // Catch: Throwable -> L22
        if (r4 == null) goto L19;
        Thread.setDefaultUncaughtExceptionHandler(r4);     // Catch: Throwable -> L22
    L19:
        n.c = null;     // Catch: Throwable -> L22
        monitor-exit(r.class);
        return;
    L7:
        if (r1.isShutdown() == true) goto L31;
        h0.r.shutdown();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static void g() {
        r r0 = n.c;
        if (r0 == null) goto L15;
        Context r1 = r0.d;
        Vector<e5> r2 = p.b;
    L10:
        th = move-exception;
        f(th, "Lg", "proL");
        return;
    L6:
        if ((System.currentTimeMillis() - p.a) < AutoEndConversationTime.AFTER_60_SECONDS) goto L16;
        p.a = System.currentTimeMillis();     // Catch: Throwable -> L10
        k1.d.b(new o(r1));     // Catch: Throwable -> L10
        return;
    L16:
        return;
    }

    public static synchronized void b(Context r4, e5 r5) throws com.loc.l {
        monitor-enter(r.class);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (r5.a() == null) goto L28;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r5.a()) == true) goto L28;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L25:
        monitor-exit(r.class);
        return;
    L9:
        if (e.add(Integer.valueOf(r5.hashCode())) == true) goto L12;
        monitor-exit(r.class);
        return;
    L12:
        r r1 = n.c;     // Catch: Throwable -> L15
        if (r1 != null) goto L17;
        n.c = new r(r4);     // Catch: Throwable -> L15
    L18:
        r r6 = n.c;     // Catch: Throwable -> L15
        boolean r2 = r6.b;     // Catch: Throwable -> L15
        k1.d.b(new q(r6, r5, r2));     // Catch: Throwable -> L21 RejectedExecutionException -> L32
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        goto L25
    L17:
        r1.b = false;     // Catch: Throwable -> L15
    L28:
        throw new com.loc.l("sdk name is invalid");     // Catch: Throwable -> L29
    }

    public final void c(Throwable r18, int r19, String r20, String r21) {
        Context r4 = this.d;
        String[] r0 = f5.a;
        StringWriter r6 = new StringWriter();     // Catch: Throwable -> L23
        PrintWriter r7 = new PrintWriter(r6);     // Catch: Throwable -> L21
        r18.printStackTrace(r7);     // Catch: Throwable -> L19
        Throwable r1 = r18;
    L7:
        r1 = r1.getCause();     // Catch: Throwable -> L19
        if (r1 == null) goto L10;
        r1.printStackTrace(r7);     // Catch: Throwable -> L19
        goto L7
    L10:
        String r9 = r6.toString();     // Catch: Throwable -> L19
        r6.close();     // Catch: Throwable -> L13
    L156:
        r7.close();     // Catch: Throwable -> L17
    L38:
        Vector<e5> r2 = p.b;
        Looper r8 = Looper.getMainLooper();     // Catch: Throwable -> L47
        monitor-enter(r8);     // Catch: Throwable -> L47
        List r3 = p.b;     // Catch: Throwable -> L44
        monitor-exit(r8);     // Catch: Throwable -> L44
    L49:
        if (r3 != null) goto L52;
        r3 = new ArrayList();
    L52:
        if (r9 != null) goto L54;
    L100:
        e5 r5 = null;
    L101:
        if (r5 == null) goto L108;
        boolean r10 = true;
        if (r5.c != 1) goto L105;
        boolean r11 = true;
    L106:
        if (r11 == false) goto L108;
    L109:
        if (r10 == false) goto L177;
        String r12 = r9.replaceAll("\n", "<br/>");
        String r13 = r18.toString();
        if (r13 != null) goto L114;
        return;
    L114:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r13) == true) goto L178;
        StringBuilder r14 = new StringBuilder();
        if (r20 == null) goto L119;
        r14.append("class:");
        r14.append(r20);
    L119:
        if (r21 == null) goto L121;
        r14.append(" method:");
        r14.append(r21);
        r14.append("$<br/>");
    L121:
        r14.append(r12);
        t.b(r4, r5, r19, r13, r14.toString());
        return;
    L178:
        return;
    L177:
        return;
    L105:
        r11 = false;
    L108:
        r10 = false;
        goto L109
    L54:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r9) == true) goto L100;
        Iterator r15 = r3.iterator();
    L58:
        if (r15.hasNext() == false) goto L85;
        e5 r16 = (e5) r15.next();
        String[] r17 = r16.d();
        String[] r110 = r9.split("\n");     // Catch: Throwable -> L79
        int r111 = r110.length;     // Catch: Throwable -> L79
        int r22 = 0;
    L61:
        if (r22 >= r111) goto L73;
        String r112 = r110[r22].trim();     // Catch: Throwable -> L79
        if (TextUtils.isEmpty(r112) == false) goto L65;
    L69:
        boolean r113 = false;
    L70:
        if (r113 == true) goto L81;
        r22 = r22 + 1;     // Catch: Throwable -> L79
    L81:
        boolean r23 = false;
    L82:
        if (r23 == false) goto L58;
        r5 = r16;
        goto L101
    L65:
        if (r112.startsWith("at ") == false) goto L69;
        if (r112.contains("uncaughtException") == false) goto L69;
        r113 = true;
        goto L70
    L73:
        int r24 = r110.length;     // Catch: Throwable -> L79
        int r114 = 0;
    L74:
        if (r114 >= r24) goto L81;
        if (p.b(r17, r110[r114].trim()) == true) goto L77;
        r114 = r114 + 1;
        goto L74
    L77:
        r23 = true;
    L79:
        th = move-exception;
        th.printStackTrace();
        goto L81
    L85:
        if (r9.contains("com.amap.api.col") == false) goto L91;
        e5.a r25 = new e5.a("collection", "1.0", "AMap_collection_1.0");     // Catch: com.loc.l -> L88
        r25.e = (String[]) new String[]{"com.amap.api.collection"}.clone();     // Catch: com.loc.l -> L88
        r5 = r25.a();     // Catch: com.loc.l -> L88
    L88:
        e = move-exception;
        e.printStackTrace();
    L91:
        if (r9.contains("com.amap.co") == false) goto L93;
    L158:
        String[] r26 = f5.a;     // Catch: com.loc.l -> L98
        e5.a r27 = new e5.a("co", "1.0.0", "AMap_co_1.0.0");     // Catch: com.loc.l -> L98
        r27.e = (String[]) new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}.clone();     // Catch: com.loc.l -> L98
        e5 r28 = r27.a();     // Catch: com.loc.l -> L98
        r28.c = 1;     // Catch: com.loc.l -> L98
        r5 = r28;
    L98:
        e = move-exception;
        e.printStackTrace();
        goto L100
    L93:
        if (r9.contains("com.amap.opensdk.co") == true) goto L158;
        if (r9.contains("com.amap.location") == false) goto L100;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
        r3 = p.b;
    L17:
        th = move-exception;
        th.printStackTrace();
    L13:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = th;
    L140:
        th.printStackTrace();     // Catch: Throwable -> L123
        if (r6 != null) goto L152;
    L32:
        if (r7 != null) goto L160;
    L37:
        r9 = null;
        goto L38
    L160:
        r7.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L152:
        r6.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
    L123:
        th = move-exception;
        if (r6 != null) goto L144;
    L130:
        if (r7 == null) goto L179;
        r7.close();     // Catch: Throwable -> L133
        throw th;
    L133:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L179:
        throw th;
    L144:
        r6.close();     // Catch: Throwable -> L128
    L128:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = th;
    L25:
        r7 = null;
    L23:
        th = th;
        r6 = null;
        goto L25
    }

    public static void d(e5 r2, String r3, String r4, String r5, String r6, String r7) {
        if (n.c == null) goto L19;
        String r8 = "path:" + r3 + ",type:" + r4 + ",gsid:" + r5 + ",csid:" + r6 + ",code:" + r7;     // Catch: Throwable -> L16
        Context r9 = n.c.d;     // Catch: Throwable -> L16
        boolean r10 = false;
        if (r2 != null) goto L7;
    L12:
        if (r10 == false) goto L20;
        t.b(r9, r2, 1, "networkError", r8);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L7:
        if (r2.c != 1) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        r10 = true;
        goto L12
    L9:
        r0 = false;
        goto L10
    L19:
        return;
    }
}
