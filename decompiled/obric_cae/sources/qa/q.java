package qa;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class q extends l implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Integer> f10946e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f10947d;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f10948a;

        /* JADX INFO: renamed from: qa.q$a$a, reason: collision with other inner class name */
        public class C0142a extends Thread {
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                super.run();     // Catch: Throwable -> L4
                return;
            }
        }

        public a() {
            this.f10948a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            return new C0142a(r8, "pama#" + this.f10948a.getAndIncrement());
        }
    }

    static {
        f10946e = Collections.synchronizedSet(new HashSet());
        new a();
    }

    public q(Context r8) {
        this.f10947d = r8;
        Thread.UncaughtExceptionHandler r10 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        this.f10779a = r10;     // Catch: Throwable -> L17
        if (r10 != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f10780b = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r11 = r10.toString();     // Catch: Throwable -> L17
        if (r11.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f10780b = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r11.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.f10780b = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r11.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public static synchronized void c(Context r8, s4 r10) {
        monitor-enter(q.class);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (r10.a() == null) goto L28;
        if ("".equals(r10.a()) == true) goto L28;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L25:
        monitor-exit(q.class);
        return;
    L9:
        if (f10946e.add(Integer.valueOf(r10.hashCode())) == true) goto L12;
        monitor-exit(q.class);
        return;
    L12:
        q r11 = l.f10778c;     // Catch: Throwable -> L15
        if (r11 != null) goto L17;
        l.f10778c = new q(r8);     // Catch: Throwable -> L15
    L18:
        q r12 = l.f10778c;     // Catch: Throwable -> L15
        boolean r13 = r12.f10780b;     // Catch: Throwable -> L15
        l1.f10784d.a(new p(r12, r10, r13));     // Catch: Throwable -> L21 RejectedExecutionException -> L32
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        goto L25
    L17:
        r11.f10780b = false;     // Catch: Throwable -> L15
    L28:
        throw new g4("sdk name is invalid");     // Catch: Throwable -> L29
    }

    public static void d(s4 r8, String r10, String r11, String r12, String r13, String r14) {
        if (l.f10778c == null) goto L19;
        q r15 = l.f10778c;     // Catch: Throwable -> L16
        String r16 = "path:" + r10 + ",type:" + r11 + ",gsid:" + r12 + ",csid:" + r13 + ",code:" + r14;     // Catch: Throwable -> L16
        r15.getClass();     // Catch: Throwable -> L16
        boolean r17 = false;
        if (r8 != null) goto L7;
    L12:
        if (r17 == false) goto L20;
        s.b(r15.f10947d, r8, 1, "networkError", r16);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L7:
        if (r8.f11093c != 1) goto L9;
        boolean r18 = true;
    L10:
        if (r18 == false) goto L12;
        r17 = true;
        goto L12
    L9:
        r18 = false;
        goto L10
    L19:
        return;
    }

    public static synchronized void e() {
        monitor-enter(q.class);
        ThreadPoolExecutor r8 = e0.B;     // Catch: Throwable -> L10
        if (r8 != null) goto L7;
    L31:
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        return;
    L13:
        if (l.f10778c == null) goto L19;
        Thread.UncaughtExceptionHandler r10 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L22
        q r11 = l.f10778c;     // Catch: Throwable -> L22
        if (r10 != r11) goto L19;
        Thread.UncaughtExceptionHandler r12 = r11.f10779a;     // Catch: Throwable -> L22
        if (r12 == null) goto L19;
        Thread.setDefaultUncaughtExceptionHandler(r12);     // Catch: Throwable -> L22
    L19:
        l.f10778c = null;     // Catch: Throwable -> L22
        monitor-exit(q.class);
        return;
    L7:
        if (r8.isShutdown() == true) goto L31;
        e0.B.shutdown();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static void f(String r8, String r10, Throwable r11) {
        q r12 = l.f10778c;     // Catch: Throwable -> L6
        if (r12 == null) goto L9;
        r12.b(1, r8, r10, r11);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void g() {
        q r8 = l.f10778c;
        if (r8 == null) goto L15;
        Context r10 = r8.f10947d;
        Vector<s4> r11 = n.f10841b;
    L10:
        th = move-exception;
        f("Lg", "proL", th);
        return;
    L6:
        if ((System.currentTimeMillis() - n.f10840a) < 60000) goto L16;
        n.f10840a = System.currentTimeMillis();     // Catch: Throwable -> L10
        l1.f10784d.a(new m(r10));     // Catch: Throwable -> L10
        return;
    L16:
        return;
    }

    public final void b(int r18, String r19, String r20, Throwable r21) {
        String[] r8 = t4.f11124a;
        StringWriter r10 = new StringWriter();     // Catch: Throwable -> L23
        PrintWriter r11 = new PrintWriter(r10);     // Catch: Throwable -> L21
        r21.printStackTrace(r11);     // Catch: Throwable -> L19
        Throwable r12 = r21;
    L7:
        r12 = r12.getCause();     // Catch: Throwable -> L19
        if (r12 == null) goto L10;
        r12.printStackTrace(r11);     // Catch: Throwable -> L19
        goto L7
    L10:
        String r13 = r10.toString();     // Catch: Throwable -> L19
        r10.close();     // Catch: Throwable -> L13
    L151:
        r11.close();     // Catch: Throwable -> L17
    L38:
        Vector<s4> r14 = n.f10841b;
        Looper r15 = Looper.getMainLooper();     // Catch: Throwable -> L47
        monitor-enter(r15);     // Catch: Throwable -> L47
        List r16 = n.f10841b;     // Catch: Throwable -> L44
        monitor-exit(r15);     // Catch: Throwable -> L44
    L49:
        if (r16 != null) goto L51;
        r16 = new ArrayList();
    L51:
        boolean r17 = false;
        if (r13 != null) goto L54;
    L100:
        s4 r22 = null;
    L101:
        if (r22 != null) goto L103;
    L108:
        if (r17 == false) goto L176;
        String r23 = r13.replaceAll("\n", "<br/>");
        String r24 = r21.toString();
        if (r24 != null) goto L113;
        return;
    L113:
        if ("".equals(r24) == true) goto L177;
        StringBuilder r25 = new StringBuilder();
        if (r19 == null) goto L118;
        r25.append("class:");
        r25.append(r19);
    L118:
        if (r20 == null) goto L120;
        r25.append(" method:");
        r25.append(r20);
        r25.append("$<br/>");
    L120:
        r25.append(r23);
        s.b(this.f10947d, r22, r18, r24, r25.toString());
        return;
    L177:
        return;
    L176:
        return;
    L103:
        if (r22.f11093c != 1) goto L105;
        boolean r26 = true;
    L106:
        if (r26 == false) goto L108;
        r17 = true;
        goto L108
    L105:
        r26 = false;
        goto L106
    L54:
        if ("".equals(r13) == true) goto L100;
        Iterator r110 = r16.iterator();
    L58:
        if (r110.hasNext() == false) goto L85;
        s4 r111 = (s4) r110.next();
        String[] r27 = r111.d();
        String[] r112 = r13.split("\n");     // Catch: Throwable -> L79
        int r113 = r112.length;     // Catch: Throwable -> L79
        int r114 = 0;
    L61:
        if (r114 >= r113) goto L73;
        String r115 = r112[r114].trim();     // Catch: Throwable -> L79
        if (TextUtils.isEmpty(r115) == false) goto L65;
    L69:
        boolean r28 = false;
    L70:
        if (r28 == true) goto L81;
        r114 = r114 + 1;     // Catch: Throwable -> L79
    L81:
        boolean r29 = false;
    L82:
        if (r29 == false) goto L58;
        r22 = r111;
        goto L101
    L65:
        if (r115.startsWith("at ") == false) goto L69;
        if (r115.contains("uncaughtException") == false) goto L69;
        r28 = true;
        goto L70
    L73:
        int r30 = r112.length;     // Catch: Throwable -> L79
        int r116 = 0;
    L74:
        if (r116 >= r30) goto L81;
        if (n.a(r112[r116].trim(), r27) == true) goto L77;
        r116 = r116 + 1;
        goto L74
    L77:
        r29 = true;
    L79:
        th = move-exception;
        th.printStackTrace();
        goto L81
    L85:
        if (r13.contains("com.amap.api.col") == false) goto L91;
        s4.a r31 = new s4.a("collection", "1.0", "AMap_collection_1.0");     // Catch: g4 -> L88
        r31.f11105e = (String[]) new String[]{"com.amap.api.collection"}.clone();     // Catch: g4 -> L88
        r22 = r31.a();     // Catch: g4 -> L88
    L88:
        e = move-exception;
        e.printStackTrace();
    L91:
        if (r13.contains("com.amap.co") == false) goto L93;
    L137:
        String[] r32 = t4.f11124a;     // Catch: g4 -> L98
        s4.a r33 = new s4.a("co", "1.0.0", "AMap_co_1.0.0");     // Catch: g4 -> L98
        r33.f11105e = (String[]) new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}.clone();     // Catch: g4 -> L98
        s4 r34 = r33.a();     // Catch: g4 -> L98
        r34.f11093c = 1;     // Catch: g4 -> L98
        r22 = r34;
    L98:
        e = move-exception;
        e.printStackTrace();
        goto L100
    L93:
        if (r13.contains("com.amap.opensdk.co") == true) goto L137;
        if (r13.contains("com.amap.location") == false) goto L100;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
        r16 = n.f10841b;
    L17:
        th = move-exception;
        th.printStackTrace();
    L13:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = th;
    L135:
        th.printStackTrace();     // Catch: Throwable -> L122
        if (r10 != null) goto L149;
    L32:
        if (r11 != null) goto L155;
    L37:
        r13 = null;
        goto L38
    L155:
        r11.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L149:
        r10.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
    L122:
        th = move-exception;
        if (r10 != null) goto L143;
    L129:
        if (r11 == null) goto L178;
        r11.close();     // Catch: Throwable -> L132
        throw th;
    L132:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L178:
        throw th;
    L143:
        r10.close();     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = th;
    L25:
        r11 = null;
    L23:
        th = th;
        r10 = null;
        goto L25
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r8, Throwable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        b(0, null, null, r10);
        Thread.UncaughtExceptionHandler r11 = this.f10779a;
        if (r11 == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(r11);     // Catch: Throwable -> L9
    L7:
        this.f10779a.uncaughtException(r8, r10);
        return;
    }
}
