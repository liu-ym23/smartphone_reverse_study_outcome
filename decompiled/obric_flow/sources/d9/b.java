package d9;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashFilter;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.upload.s;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.d;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import mh.e;
import org.json.JSONArray;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Thread.UncaughtExceptionHandler {
    public static b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f16613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f16614i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArrayList f16615j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f16616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f16617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f16618c;
    public volatile int d;
    public volatile int e;
    public final ConcurrentHashMap f;

    static {
        f16614i = new ThreadLocal();
        f16615j = new ArrayList();
    }

    public b() {
        this.f = new ConcurrentHashMap();
        new ConcurrentHashMap();
        Thread.UncaughtExceptionHandler r5 = Thread.getDefaultUncaughtExceptionHandler();
        if (r5 == this) goto L6;
        this.f16616a = r5;
        Thread.setDefaultUncaughtExceptionHandler(this);
        return;
    }

    public static String a(File r11, Throwable r12, Thread r13, boolean r14) {
        String r5 = r11.getAbsolutePath();
        int r10 = -1;
        boolean r15 = true;
    L4:
        if (r15 == false) goto L109;
    L8:
        r11.getParentFile().mkdirs();     // Catch: IOException -> L6 Throwable -> L88
        r11.createNewFile();     // Catch: IOException -> L6 Throwable -> L88
        r10 = NativeTools.k().G(r5);     // Catch: IOException -> L6 Throwable -> L88
    L9:
        r15 = false;
    L11:
        if (r15 == false) goto L17;
        boolean r16 = !r15;
        if (r15 == false) goto L17;
        r15 = r16;
    L17:
        if (f.n() == true) goto L23;
        long r17 = 0;
        r17 = new StatFs(Environment.getDataDirectory().getPath()).getFreeBytes();     // Catch: Throwable -> L80
    L21:
        if (r17 >= 25165824) goto L23;
        f.f3132c = true;
    L23:
        String r18 = null;
        if (r14 == false) goto L36;
        NativeTools r19 = NativeTools.k();
        int r110 = r19.H(r5);
        if (r110 >= 0) goto L28;
        NativeTools.k().A();
        r110 = r19.H(r5);
    L28:
        if (r110 > 0) goto L97;
    L77:
        if (r10 <= 0) goto L79;
        NativeTools.k().w(r10);
    L79:
        return r18;
    L97:
        r19.c(r110, m.o(n.f4057a));     // Catch: Throwable -> L81
        r19.c(r110, "\n");     // Catch: Throwable -> L81
        r19.c(r110, r12.getMessage());     // Catch: Throwable -> L81
        r19.c(r110, "\n");     // Catch: Throwable -> L81
        r19.c(r110, r12.getClass().getName());     // Catch: Throwable -> L81
        if (r12.getMessage() == null) goto L32;
        r19.c(r110, ": ");     // Catch: Throwable -> L81
        r19.c(r110, r12.getMessage());     // Catch: Throwable -> L81
    L32:
        r19.c(r110, "\n");     // Catch: Throwable -> L81
        r19.c(r110, r13.getName());     // Catch: Throwable -> L81
        r19.c(r110, "\n");     // Catch: Throwable -> L81
    L105:
        r19.c(r110, "stack:");     // Catch: Throwable -> L82
        r19.c(r110, "\n");     // Catch: Throwable -> L82
    L107:
        h.f(r110, r12);     // Catch: Throwable -> L83
    L35:
        r19.b(r110);
        goto L77
    L36:
        boolean r111 = true;
        FileOutputStream r20 = null;
    L37:
        if (r111 == true) goto L111;
        io.reactivex.exceptions.a.i("retry save files");
    L111:
        r111 = false;
        r20 = new FileOutputStream(r11, true);     // Catch: IOException -> L41 Throwable -> L43
    L45:
        if (r111 == false) goto L113;
        boolean r21 = !r111;
        if (r111 == false) goto L113;
        r111 = r21;
    L113:
        r20.write((m.o(n.f4057a) + "\n").getBytes());     // Catch: IOException -> L52 Throwable -> L84
        r20.write((r12.getMessage() + "\n").getBytes());     // Catch: IOException -> L52 Throwable -> L84
        r20.write((r12 + "\n").getBytes());     // Catch: IOException -> L52 Throwable -> L84
        r20.write((r13.getName() + "\n").getBytes());     // Catch: IOException -> L52 Throwable -> L84
    L52:
        e = move-exception;
        f.i(e);
    L99:
        r20.write("stack:\n".getBytes());     // Catch: Throwable -> L85
    L93:
        PrintStream r112 = new PrintStream(r20);     // Catch: Throwable -> L58
        if (Looper.getMainLooper() != Looper.myLooper()) goto L60;
        wc.f r113 = new a(4);     // Catch: Throwable -> L58
    L61:
        int r114 = h.f4186a;     // Catch: Throwable -> L58
        MessageDigest r115 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L64
    L65:
        d r22 = new d(r112, r115, r113);     // Catch: Throwable -> L58
        h.h(r12, r22);     // Catch: Throwable -> L86
    L67:
        r22.close();     // Catch: Throwable -> L58
        if (r115 == null) goto L70;
        r18 = h.b(r115.digest());     // Catch: Throwable -> L58
    L70:
        f.h(r20);     // Catch: Throwable -> L58
        f.h(r20);
    L64:
        r115 = null;
        goto L65
    L60:
        r113 = new wc.f(4);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        r12.printStackTrace(new PrintStream(r20));     // Catch: Throwable -> L74
    L76:
        f.h(r20);
    L74:
        th = move-exception;
        r20.write("err:\n".getBytes());     // Catch: Throwable -> L87
        r20.write((th + "\n").getBytes());     // Catch: Throwable -> L87
        r20.write((th + "\n").getBytes());     // Catch: Throwable -> L87
        goto L76
    L41:
        e = move-exception;
        f.i(e);
    L43:
        return null;
    L109:
        io.reactivex.exceptions.a.i("retry save files");     // Catch: IOException -> L6 Throwable -> L88
    L6:
        e = move-exception;
        f.i(e);
        goto L11
    }

    public static void c() {
        Context r5 = n.f4057a;
        String r10 = g.f4181a;
        File r11 = new File(g.h(r5), x8.a.f22983b);
        File r12 = g.e;
        if (r12 != null) goto L5;
        r12 = g.g(n.f4057a);
    L5:
        String[] r13 = r11.list();
        if (r13 != null) goto L8;
    L9:
        String[] r14 = r12.list();
        if (r14 != null) goto L12;
        return;
    L12:
        if (r14.length == 0) goto L34;
    L14:
        long r15 = SystemClock.uptimeMillis();
    L16:
        if (com.bytedance.crash.upload.g.s().f == true) goto L35;
        if (m.q(n.f4057a) == false) goto L36;
        if ((SystemClock.uptimeMillis() - r15) >= 10000) goto L37;
        SystemClock.sleep(500);     // Catch: Throwable -> L26
        goto L16
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (r13.length != 0) goto L14;
        goto L9
    }

    public final void b() {
        monitor-enter(this);
        this.e--;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        long r5 = SystemClock.uptimeMillis();
    L7:
        if (this.e == 0) goto L11;
        if ((SystemClock.uptimeMillis() - r5) >= 10000) goto L19;
        SystemClock.sleep(50);
        goto L7
    L19:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v62, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v14 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r2v28, types: [com.bumptech.glide.load.engine.h0] */
    /* JADX WARN: Type inference failed for: r2v37, types: [com.bumptech.glide.load.engine.h0] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r22, Throwable r23) {
        ?? r11 = 1;
        Throwable r12 = r23;
    L4:
        if (this.d >= 3) goto L214;
        this.d += r11;
        this.e += r11;
        if (f16613h == false) goto L9;
        f16614i.set(Boolean.TRUE);
    L9:
        f16613h = r11;
        long r14 = System.currentTimeMillis();
        int r10 = 0;
        if ((r14 - n.f4059c) <= n.f4062j.getLaunchCrashInterval()) goto L12;
    L16:
        ?? r13 = 0;
    L304:
        boolean r5 = h.l(r12);     // Catch: Throwable -> L37
        if (r5 == false) goto L36;
        if (r12 == null) goto L36;
        int r15 = 0;
        Throwable r16 = r12;
    L22:
        if (r16 == null) goto L36;
        if ((r16 instanceof OutOfMemoryError) == false) goto L31;
        if (r16.getMessage().contains("allocate") == true) goto L35;
        if (r16.getMessage().contains("thrown") == true) goto L35;
    L31:
        if (r15 > 20) goto L36;
        r15 = r15 + r11;     // Catch: Throwable -> L271
        r16 = r16.getCause();     // Catch: Throwable -> L271
    L35:
        boolean r17 = r5;
        ?? r18 = r11;
    L38:
        if (r13 != 0) goto L312;
        CrashType r19 = CrashType.JAVA;     // Catch: Throwable -> L184
    L306:
        String r20 = n.b(r14, r19, r17, false);     // Catch: Throwable -> L184
        this.f.put(r20, new Object());     // Catch: Throwable -> L184
        Context r21 = n.f4057a;     // Catch: Throwable -> L184
        String r24 = g.f4181a;     // Catch: Throwable -> L184
        String r25 = g.h(r21);     // Catch: Throwable -> L184
        String r26 = x8.a.f22983b;     // Catch: Throwable -> L184
        File r27 = new File(new File(r25, r26), r20);     // Catch: Throwable -> L184
        File r28 = new File(r27, "logEventStack");     // Catch: Throwable -> L184
        String r29 = a(r28, r12, r22, r18);     // Catch: Throwable -> L184
        if (r13 == 0) goto L49;
        CrashType r110 = CrashType.LAUNCH;     // Catch: Throwable -> L41
    L51:
        if (s.m(null, r110) == false) goto L55;
        cl.a.s(r27.getAbsolutePath());     // Catch: Throwable -> L41
    L60:
        if (f.n() == false) goto L66;
        if (r13 == 0) goto L64;
        CrashType r30 = CrashType.LAUNCH;     // Catch: Throwable -> L41
    L328:
        r20 = n.b(r14, r30, r17, false);     // Catch: Throwable -> L67
        File r31 = new File(new File(g.h(n.f4057a), r26), r20);     // Catch: Throwable -> L67
        r28.getParentFile().renameTo(r31);     // Catch: Throwable -> L67
        r28 = new File(r31, "logEventStack");     // Catch: Throwable -> L67
    L67:
        th = th;
        r10 = 0;
    L69:
        int r111 = 0;
        int r112 = 0;
        ?? r113 = r13;
        ?? r210 = r18;
    L322:
    L190:
        th = move-exception;
        if (r10 == 0) goto L223;
        monitor-enter(this);
        boolean r32 = true;
        this.e--;     // Catch: Throwable -> L268
        this.d--;     // Catch: Throwable -> L268
    L248:
        ArrayList r33 = f16615j;
        if (r33.size() > 0) goto L320;
    L250:
        Throwable r34 = null;
    L261:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L326;
    L263:
        Throwable r114 = r34;
    L264:
        r12 = r114;
    L265:
        if (r12 == null) goto L267;
        r11 = r32;
        goto L4
    L267:
        return;
    L326:
        Looper.loop();     // Catch: Throwable -> L255
    L255:
        th = move-exception;
        r114 = th;
        goto L264
    L320:
        if (r33.get(r111) == null) goto L254;
        r34 = null;
        throw new ClassCastException();     // Catch: Throwable -> L273
    L254:
        throw null;     // Catch: Throwable -> L255
    L268:
        th = move-exception;
        throw th;
    L223:
        if (r210 == 0) goto L240;
        if (r112 != 0) goto L240;
        CopyOnWriteArrayList r35 = (CopyOnWriteArrayList) p.f.d;     // Catch: Throwable -> L274
        if (r113 == 0) goto L229;
        CrashType r36 = CrashType.LAUNCH;     // Catch: Throwable -> L274
    L228:
        CrashType r37 = r36;
        Iterator r115 = r35.iterator();     // Catch: Throwable -> L274
    L232:
        if (r115.hasNext() == false) goto L240;
        ((IOOMCallback) r115.next()).onCrash(r37, r12, r22, r14);     // Catch: Throwable -> L237
    L237:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);     // Catch: Throwable -> L274
        goto L232
    L229:
        r36 = CrashType.JAVA;     // Catch: Throwable -> L274
    L363:
        throw th;
    L240:
        c();     // Catch: Throwable -> L274
        b();     // Catch: Throwable -> L274
        Thread.UncaughtExceptionHandler r38 = this.f16616a;     // Catch: Throwable -> L274
        if (r38 == null) goto L361;
        if (r38 == this) goto L362;
        r38.uncaughtException(r22, r12);     // Catch: Throwable -> L274
        throw th;
    L362:
        throw th;
    L361:
        throw th;
    L187:
        if (h.l(th) == true) goto L192;
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L190
    L192:
        if (r10 != 0) goto L215;
        if (r210 == 0) goto L210;
        if (r112 != 0) goto L210;
        CopyOnWriteArrayList r39 = (CopyOnWriteArrayList) p.f.d;     // Catch: Throwable -> L277
        if (r113 == 0) goto L199;
        CrashType r40 = CrashType.LAUNCH;     // Catch: Throwable -> L277
    L198:
        CrashType r41 = r40;
        Iterator r42 = r39.iterator();     // Catch: Throwable -> L277
    L202:
        if (r42.hasNext() == false) goto L210;
        ((IOOMCallback) r42.next()).onCrash(r41, r12, r22, r14);     // Catch: Throwable -> L207
    L207:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);     // Catch: Throwable -> L277
        goto L202
    L199:
        r40 = CrashType.JAVA;     // Catch: Throwable -> L277
    L210:
        c();     // Catch: Throwable -> L277
        b();     // Catch: Throwable -> L277
        Thread.UncaughtExceptionHandler r43 = this.f16616a;     // Catch: Throwable -> L277
        if (r43 == null) goto L214;
        if (r43 == this) goto L214;
    L213:
        r43.uncaughtException(r22, r12);     // Catch: Throwable -> L277
        goto L214
    L215:
        monitor-enter(this);
        this.e--;     // Catch: Throwable -> L219
        this.d--;     // Catch: Throwable -> L219
        monitor-exit(this);     // Catch: Throwable -> L219
    L175:
        r32 = true;
    L219:
        th = move-exception;
        throw th;
    L64:
        r30 = CrashType.JAVA;     // Catch: Throwable -> L67
    L66:
        String r44 = r20;
        int r45 = 0;
    L298:
        ArrayList r46 = f16615j;     // Catch: Throwable -> L181
        if (r45 >= r46.size()) goto L83;
        if (r46.get(r45) != null) goto L82;
        throw null;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L67
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L67
        r45 = r45 + 1;
        goto L298
    L82:
        throw new ClassCastException();     // Catch: Throwable -> L275
    L83:
        if (r29 != null) goto L85;
    L87:
        int r116 = 0;
    L290:
        ConcurrentLinkedQueue r47 = z8.d.f23418a;     // Catch: Throwable -> L179
        new JSONArray();     // Catch: Throwable -> L179
        if (r116 == 0) goto L98;
        if (r13 != 0) goto L280;
        CrashType r48 = CrashType.JAVA;     // Catch: Throwable -> L93
    L96:
        String r49 = n.b(r14, r48, r17, true);     // Catch: Throwable -> L93
        File r50 = new File(new File(g.h(n.f4057a), x8.a.f22983b), r49);     // Catch: Throwable -> L93
        r28.getParentFile().renameTo(r50);     // Catch: Throwable -> L93
        new File(r50, "logEventStack");     // Catch: Throwable -> L93
        String r51 = r49;
    L99:
        File r52 = g.f(n.f4057a);     // Catch: Throwable -> L179
        r52.mkdirs();     // Catch: Throwable -> L179
        a.a.h(r52);     // Catch: Throwable -> L179
        com.bytedance.crash.upload.g.s().n();     // Catch: Throwable -> L179
        if (e.c(l9.c.e(), -1, new String[]{"exception_modules", "oom_callback"}) != 1) goto L103;
        r112 = 1;
    L104:
        if (r18 == 0) goto L127;
        if (r112 == 0) goto L127;
        CopyOnWriteArrayList r53 = (CopyOnWriteArrayList) p.f.d;     // Catch: Throwable -> L110
        if (r13 == 0) goto L113;
        CrashType r54 = CrashType.LAUNCH;     // Catch: Throwable -> L110
    L109:
        CrashType r117 = r54;
        Iterator r118 = r53.iterator();     // Catch: Throwable -> L110
        r18 = r18;
    L116:
        if (r118.hasNext() == false) goto L127;
        IOOMCallback r55 = (IOOMCallback) r118.next();     // Catch: Throwable -> L110
        Throwable r56 = r12;
        String r119 = r29;
        boolean r211 = r18 == true ? 1 : 0;
        r55.onCrash(r117, r56, r22, r14);     // Catch: Throwable -> L121
    L120:
        r29 = r119;
        r18 = r211 ? 1 : 0;
    L121:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);     // Catch: Throwable -> L125
    L125:
        th = th;
    L112:
        r113 = r13 == true ? 1 : 0;
        r10 = r116;
        r111 = 0;
        r210 = r211;
        goto L322
    L113:
        r54 = CrashType.JAVA;     // Catch: Throwable -> L110
    L110:
        th = th;
        r211 = r18 == true ? 1 : 0;
    L127:
        String r120 = r29;
        ?? r212 = r18;
        CrashType r57 = CrashType.LAUNCH;     // Catch: Throwable -> L144
        io.reactivex.exceptions.a.i("[uncaughtException] isLaunchCrash=" + r13);     // Catch: Throwable -> L144
        v8.a.d().getClass();     // Catch: Throwable -> L144
        ICrashFilter r58 = n.f4063k.f4024b;     // Catch: Throwable -> L144
        if (r58 != null) goto L302;
    L134:
        boolean r59 = true;
    L135:
        if (r59 == false) goto L143;
        ?? r60 = this.f16617b;     // Catch: Throwable -> L144
        if (r60 == 0) goto L143;
        if (r13 == 0) goto L143;
        Throwable r61 = r12;
        String r62 = r51;
        boolean r121 = r13 == true ? 1 : 0;
        r111 = 0;
        r60.a(r14, r22, r61, r62, r120, r116);     // Catch: Throwable -> L141
        io.reactivex.exceptions.a.i("[uncaughtException] mLaunchCrashDisposer " + r12);     // Catch: Throwable -> L141
        boolean r122 = r121;
    L150:
        if (r116 != 0) goto L172;
        if (r212 == 0) goto L168;
        if (r112 != 0) goto L168;
        CopyOnWriteArrayList r63 = (CopyOnWriteArrayList) p.f.d;     // Catch: Throwable -> L277
        if (r122 == false) goto L157;
        CrashType r64 = CrashType.LAUNCH;     // Catch: Throwable -> L277
    L156:
        CrashType r65 = r64;
        Iterator r66 = r63.iterator();     // Catch: Throwable -> L277
    L160:
        if (r66.hasNext() == false) goto L168;
        ((IOOMCallback) r66.next()).onCrash(r65, r12, r22, r14);     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);     // Catch: Throwable -> L277
        goto L160
    L157:
        r64 = CrashType.JAVA;     // Catch: Throwable -> L277
    L168:
        c();     // Catch: Throwable -> L277
        b();     // Catch: Throwable -> L277
        r43 = this.f16616a;     // Catch: Throwable -> L277
        if (r43 == null) goto L214;
        if (r43 == this) goto L214;
    L172:
        monitor-enter(this);
        this.e--;     // Catch: Throwable -> L176
        this.d--;     // Catch: Throwable -> L176
        monitor-exit(this);     // Catch: Throwable -> L176
    L176:
        th = move-exception;
        throw th;
    L141:
        th = th;
    L142:
        r10 = r116;
        r113 = r121;
        r210 = r212;
    L143:
        boolean r123 = r13 == true ? 1 : 0;
        r111 = 0;
        r122 = r123;
        if (r59 == false) goto L150;
        ?? r67 = this.f16618c;     // Catch: Throwable -> L141
        r122 = r123;
        if (r67 == 0) goto L150;
        r67.a(r14, r22, r12, r51, r120, r116);     // Catch: Throwable -> L141
        io.reactivex.exceptions.a.i("[uncaughtException] mLaunchCrashDisposer " + r12);     // Catch: Throwable -> L141
        r122 = r123;
        goto L150
    L302:
        if (r58.onJavaCrashFilter(r12, r22) == true) goto L134;
        r59 = false;
    L144:
        th = th;
        r121 = r13 == true ? 1 : 0;
        r111 = 0;
        goto L142
    L103:
        r112 = 0;
        goto L104
    L280:
        r48 = CrashType.LAUNCH;     // Catch: Throwable -> L93
    L93:
        th = th;
        r10 = r116;
        goto L69
    L98:
        r51 = r44;
    L179:
        th = th;
        r111 = 0;
        r10 = r116;
    L43:
        r112 = r111;
        r113 = r13;
        r210 = r18;
        goto L322
    L85:
        if (n.f4062j.isCrashIgnored(r29) == false) goto L87;
        r116 = 1;
    L181:
        th = th;
        r111 = 0;
        r10 = 0;
    L183:
        r112 = r10;
        r113 = r13;
        r210 = r18;
        goto L322
    L55:
        if (p.f4086j == false) goto L60;
        if (Debug.isDebuggerConnected() == false) goto L60;
        cl.a.s(r27.getAbsolutePath());     // Catch: Throwable -> L41
        goto L60
    L49:
        r110 = CrashType.JAVA;     // Catch: Throwable -> L184
    L184:
        th = th;
        r111 = 0;
        goto L183
    L312:
        r19 = CrashType.LAUNCH;     // Catch: Throwable -> L41
    L41:
        th = th;
        r111 = 0;
    L36:
        r17 = r5;
        r18 = 0;
    L37:
        r17 = false;
        r18 = 0;
        goto L38
    L12:
        if (n.f == true) goto L14;
    L15:
        r13 = r11;
        goto L304
    L14:
        if (n.f4069q == 0) goto L16;
    L214:
        r32 = true;
        r12 = null;
        goto L265
    }
}
