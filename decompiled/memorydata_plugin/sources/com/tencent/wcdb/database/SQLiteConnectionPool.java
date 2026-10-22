package com.tencent.wcdb.database;

import android.os.SystemClock;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteConnectionPool implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f15835a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<SQLiteDatabase> f15836b;
    private volatile com.tencent.wcdb.database.a c;
    private volatile o d;
    private volatile com.tencent.wcdb.database.b e;
    private byte[] f;
    private SQLiteCipherSpec g;
    private final Object h;
    private final AtomicBoolean i;
    private final f j;
    private int k;
    private boolean l;
    private int m;
    private b n;
    private b o;
    private final ArrayList<SQLiteConnection> p;
    private SQLiteConnection q;
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> r;

    static final enum AcquiredConnectionStatus extends Enum<AcquiredConnectionStatus> {
        private static final /* synthetic */ AcquiredConnectionStatus[] $VALUES = null;
        public static final AcquiredConnectionStatus DISCARD = null;
        public static final AcquiredConnectionStatus NORMAL = null;
        public static final AcquiredConnectionStatus RECONFIGURE = null;

        static {
            AcquiredConnectionStatus r0 = new AcquiredConnectionStatus("NORMAL", 0);
            NORMAL = r0;
            AcquiredConnectionStatus r1 = new AcquiredConnectionStatus("RECONFIGURE", 1);
            RECONFIGURE = r1;
            AcquiredConnectionStatus r3 = new AcquiredConnectionStatus("DISCARD", 2);
            DISCARD = r3;
            $VALUES = new AcquiredConnectionStatus[]{r0, r1, r3};
        }

        private AcquiredConnectionStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static AcquiredConnectionStatus valueOf(String r2) {
            return (AcquiredConnectionStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AcquiredConnectionStatus.class, r2), AcquiredConnectionStatus.class, "com.obric.memorydata.plugin");
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AcquiredConnectionStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<String> f15840b;
        int c;
        int d;
        int e;
        ArrayList<o.a<String>> f;
        ArrayList<o.a<StackTraceElement[]>> g;

        private a() {
            this.f15840b = new ArrayList();
            this.f = new ArrayList();
            this.g = new ArrayList();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f15841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f15842b;
        public long c;
        public int d;
        public boolean e;
        public String f;
        public int g;
        public SQLiteConnection h;
        public RuntimeException i;
        public int j;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    private SQLiteConnectionPool(SQLiteDatabase r2, f r3, int r4) {
        this.h = new Object();
        this.i = new AtomicBoolean();
        this.p = new ArrayList();
        this.r = new WeakHashMap();
        this.f15836b = new WeakReference(r2);
        this.j = new f(r3);
        c(r4);
    }

    private SQLiteConnection a(int r6) {
        SQLiteConnection r0 = this.q;
        if (r0 == null) goto L7;
        this.q = null;
    L5:
        a(r0, r6);
        return r0;
    L7:
        Iterator<SQLiteConnection> r1 = this.r.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((SQLiteConnection) ZeusTransformUtils.preCheckCast(r1.next(), SQLiteConnection.class, "com.obric.memorydata.plugin")).b() == false) goto L9;
        return null;
    L13:
        r0 = a(this.j, true);
        goto L5
    }

    private SQLiteConnection a(f r7, boolean r8) {
        int r2 = this.m;
        this.m = r2 + 1;
        return SQLiteConnection.a(this, r7, r2, r8, this.f, this.g);
    }

    private b a(Thread r4, long r5, int r7, boolean r8, String r9, int r10) {
        b r0 = this.n;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        this.n = r0.f15841a;
        r0.f15841a = null;
    L6:
        r0.f15842b = r4;
        r0.c = r5;
        r0.d = r7;
        r0.e = r8;
        r0.f = r9;
        r0.g = r10;
        return r0;
    L5:
        r0 = new b(r1);
        goto L6
    }

    public static SQLiteConnectionPool a(SQLiteDatabase r1, f r2, byte[] r3, SQLiteCipherSpec r4, int r5) {
        if (r2 == null) goto L10;
        SQLiteConnectionPool r0 = new SQLiteConnectionPool(r1, r2, r5);
        r0.f = r3;
        if (r4 != null) goto L6;
        SQLiteCipherSpec r6 = null;
    L7:
        r0.g = r6;
        r0.c();
        return r0;
    L6:
        r6 = new SQLiteCipherSpec(r4);
        goto L7
    L10:
        throw new IllegalArgumentException("configuration must not be null.");
    }

    static /* synthetic */ Object a(SQLiteConnectionPool r0) {
        return r0.h;
    }

    private void a(SQLiteConnection r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        boolean r0 = true;
    L11:
        r4.a(r0);     // Catch: RuntimeException -> L8
        this.r.put(r4, AcquiredConnectionStatus.NORMAL);     // Catch: RuntimeException -> L8
        return;
    L8:
        e = move-exception;
        Log.a("WCDB.SQLiteConnectionPool", "Failed to prepare acquired connection for session, closing it: " + r4 + ", connectionFlags=" + r5);
        b(r4);
        throw e;
    L5:
        r0 = false;
        goto L11
    }

    private void a(AcquiredConnectionStatus r7) {
        if (this.r.isEmpty() == true) goto L15;
        ArrayList r0 = new ArrayList(this.r.size());
        Iterator<Map.Entry<SQLiteConnection, AcquiredConnectionStatus>> r1 = this.r.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        AcquiredConnectionStatus r3 = (AcquiredConnectionStatus) ZeusTransformUtils.preCheckCast(r2.getValue(), AcquiredConnectionStatus.class, "com.obric.memorydata.plugin");
        if (r7 == r3) goto L6;
        if (r3 == AcquiredConnectionStatus.DISCARD) goto L6;
        r0.add(r2.getKey());
        goto L6
    L12:
        int r4 = r0.size();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L24;
        this.r.put((SQLiteConnection) r0.get(r5), r7);
        r5 = r5 + 1;
        goto L13
    L24:
        return;
    }

    private void a(a r4, long r5, int r7) {
        StringBuilder r3 = new StringBuilder();
        if (r5 == 0) goto L5;
        Thread r0 = Thread.currentThread();
        r3.append("The connection pool for database '").append(r4.f15839a);
        r3.append("' has been unable to grant a connection to thread ");
        r3.append(r0.getId()).append(" (").append(r0.getName()).append(") ");
        r3.append("with flags 0x").append(Integer.toHexString(r7));
        r3.append(" for ").append(r5 * 0.001f).append(" seconds.\n");
    L5:
        r3.append("Connections: ").append(r4.c).append(" active, ");
        r3.append(r4.d).append(" idle, ");
        r3.append(r4.e).append(" available.\n");
        if (r4.f15840b.isEmpty() == true) goto L11;
        r3.append("\nRequests in progress:\n");
        Iterator<String> r6 = r4.f15840b.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        r3.append("  ").append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")).append("\n");
    L11:
        Log.b("WCDB.SQLiteConnectionPool", r3.toString());
    }

    private void a(b r4) {
        if (r4.h == null) goto L5;
        return;
    L5:
        if (r4.i != null) goto L28;
        b r0 = null;
        b r1 = this.o;
    L8:
        b r2 = r1;
        b r3 = r0;
        r0 = r2;
        if (r0 == r4) goto L17;
        if (f15835a == true) goto L16;
        if (r0 != null) goto L16;
        throw new AssertionError();
    L16:
        r1 = r0.f15841a;
        goto L8
    L17:
        b r5 = r4.f15841a;
        if (r3 == null) goto L20;
        r3.f15841a = r5;
    L21:
        r4.i = new OperationCanceledException();
        LockSupport.unpark(r4.f15842b);
        j();
        return;
    L20:
        this.o = r5;
        goto L21
    }

    static /* synthetic */ void a(SQLiteConnectionPool r0, b r1) {
        r0.a(r1);
    }

    private void a(boolean r5) {
        if (r5 == true) goto L14;
        Object r6 = this.h;
        monitor-enter(r6);
        k();     // Catch: Throwable -> L11
        this.l = false;     // Catch: Throwable -> L11
        d();     // Catch: Throwable -> L11
        int r0 = this.r.size();     // Catch: Throwable -> L11
        if (r0 == 0) goto L8;
        Log.c("WCDB.SQLiteConnectionPool", "The connection pool for " + this.j.f15851b + " has been closed but there are still " + r0 + " connections in use.  They will be closed as they are released back to the pool.");     // Catch: Throwable -> L11
    L8:
        j();     // Catch: Throwable -> L11
        monitor-exit(r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean a(SQLiteConnection r5, AcquiredConnectionStatus r6) {
        if (r6 != AcquiredConnectionStatus.RECONFIGURE) goto L9;
        r5.a(this.j);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.a("WCDB.SQLiteConnectionPool", "Failed to reconfigure released connection, closing it: " + r5, new Object[]{e});
        r6 = AcquiredConnectionStatus.DISCARD;
    L9:
        if (r6 != AcquiredConnectionStatus.DISCARD) goto L12;
        b(r5);
        return false;
    L12:
        return true;
    }

    private static int b(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }

    private SQLiteConnection b(String r8, int r9) {
        int r0 = this.p.size();
        if (r0 <= 1) goto L12;
        if (r8 == null) goto L12;
        int r4 = 0;
    L6:
        if (r4 >= r0) goto L12;
        SQLiteConnection r5 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.p.get(r4), SQLiteConnection.class, "com.obric.memorydata.plugin");
        if (r5.b(r8) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        this.p.remove(r4);
        a(r5, r9);
        return r5;
    L12:
        if (r0 <= 0) goto L16;
        SQLiteConnection r10 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.p.remove(r0 - 1), SQLiteConnection.class, "com.obric.memorydata.plugin");
    L14:
        a(r10, r9);
        return r10;
    L16:
        int r11 = this.r.size();
        if (this.q == null) goto L20;
        r11 = r11 + 1;
    L20:
        if (r11 < this.k) goto L23;
        return null;
    L23:
        r10 = a(this.j, false);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v7, types: [long] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.wcdb.support.a$a] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.wcdb.support.a$a] */
    /* JADX WARN: Type inference failed for: r2v8, types: [long] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.tencent.wcdb.support.a] */
    private SQLiteConnection b(String r28, int r29, com.tencent.wcdb.support.a r30) {
        if ((r29 & 2) == 0) goto L5;
        boolean r21 = true;
    L6:
        Object r13 = this.h;
        monitor-enter(r13);
        k();     // Catch: Throwable -> L88
        if (r30 == 0) goto L11;
        r30.b();     // Catch: Throwable -> L88
    L11:
        a r15 = null;
        if (r21 == true) goto L14;
        SQLiteConnection r1 = b(r28, r29);     // Catch: Throwable -> L88
    L15:
        if (r1 != null) goto L17;
        r1 = a(r29);     // Catch: Throwable -> L88
    L17:
        if (r1 == null) goto L20;
        monitor-exit(r13);     // Catch: Throwable -> L88
        return r1;
    L20:
        int r14 = b(r29);     // Catch: Throwable -> L88
        final b r2 = a(Thread.currentThread(), SystemClock.uptimeMillis(), r14, r21, r28, r29);     // Catch: Throwable -> L88
        b r3 = this.o;     // Catch: Throwable -> L88
        b r4 = null;
    L21:
        if (r3 == null) goto L26;
        if (r14 > r3.d) goto L24;
        r4 = r3;
        r3 = r3.f15841a;     // Catch: Throwable -> L88
        goto L21
    L24:
        r2.f15841a = r3;     // Catch: Throwable -> L88
    L26:
        if (r4 == null) goto L28;
        r4.f15841a = r2;     // Catch: Throwable -> L88
    L29:
        final int r5 = r2.j;     // Catch: Throwable -> L88
        monitor-exit(r13);     // Catch: Throwable -> L88
        if (r30 == 0) goto L93;
        r30.a(new AnonymousClass1(this, r2, r5));
    L93:
        long r6 = 3000;
        ?? r7 = r2.c + 3000;     // Catch: Throwable -> L83
    L35:
        if (this.i.compareAndSet(true, false) == false) goto L44;
        Object r8 = this.h;     // Catch: Throwable -> L83
        monitor-enter(r8);     // Catch: Throwable -> L83
        j();     // Catch: Throwable -> L41
        monitor-exit(r8);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L44:
        LockSupport.parkNanos(r6 * TimeUtils.NANOSECONDS_PER_MILLISECOND);     // Catch: Throwable -> L83
        Thread.interrupted();     // Catch: Throwable -> L83
        Object r9 = this.h;     // Catch: Throwable -> L83
        monitor-enter(r9);     // Catch: Throwable -> L83
        k();     // Catch: Throwable -> L75
        SQLiteConnection r10 = r2.h;     // Catch: Throwable -> L75
        RuntimeException r11 = r2.i;     // Catch: Throwable -> L75
        if (r10 != null) goto L67;
        if (r11 != null) goto L67;
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L75
        if (r12 >= r7) goto L53;
        ?? r22 = r7;
        long r24 = r12 - r7;     // Catch: Throwable -> L75
        a r16 = r15;
    L54:
        monitor-exit(r9);     // Catch: Throwable -> L75
        if (r16 == null) goto L65;
        long r17 = r12 - r2.c;     // Catch: Throwable -> L83
        a(r16, r17, r29);     // Catch: Throwable -> L83
        SQLiteDatabase r18 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(this.f15836b.get(), SQLiteDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        o r19 = this.d;     // Catch: Throwable -> L83
        if (r18 == null) goto L65;
        if (r19 == null) goto L65;
        a r20 = r15;
        r19.a(r18, r28, r17, r21, r16.f, r16.g);     // Catch: Throwable -> L63
    L66:
        r15 = r20;
        r7 = r22;
        r6 = r24;
    L63:
        th = th;
        r7 = r20;
    L85:
        if (r30 == 0) goto L87;
        r30.a(r7);
    L87:
        throw th;
    L65:
        r20 = r15;
        goto L66
    L53:
        r16 = i();     // Catch: Throwable -> L75
        r24 = 3000;
        r22 = r12 + 3000;     // Catch: Throwable -> L75
    L67:
        ?? r23 = r15;
        b(r2);     // Catch: Throwable -> L81
        if (r10 == null) goto L74;
        monitor-exit(r9);     // Catch: Throwable -> L81
        if (r30 == 0) goto L73;
        r30.a(r23);
    L73:
        return r10;
    L74:
        throw r11;     // Catch: Throwable -> L81
    L75:
        th = th;
        r7 = r15;
    L77:
        monitor-exit(r9);     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L79
    L79:
        th = th;
    L81:
        th = th;
    L83:
        th = th;
        r7 = r15;
        goto L85
    L28:
        this.o = r2;     // Catch: Throwable -> L88
        goto L29
    L14:
        r1 = null;
    L88:
        th = move-exception;
        throw th;
    L5:
        r21 = false;
        goto L6
    }

    private void b(SQLiteConnection r3) {
        r3.a();     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Log.a("WCDB.SQLiteConnectionPool", "Failed to close connection, its fate is now in the hands of the merciful GC: " + r3 + e.getMessage());
    }

    private void b(b r2) {
        r2.f15841a = this.n;
        r2.f15842b = null;
        r2.f = null;
        r2.h = null;
        r2.i = null;
        r2.j++;
        this.n = r2;
    }

    private void c() {
        this.q = a(this.j, true);
        this.l = true;
    }

    private void c(int r3) {
        if (r3 <= 0) goto L5;
    L8:
        this.k = r3;
        Log.c("WCDB.SQLiteConnectionPool", "Max connection pool size is %d.", new Object[]{Integer.valueOf(r3)});
        return;
    L5:
        if ((this.j.d & net.zetetic.database.sqlcipher.SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L7;
        r3 = 4;
        goto L8
    L7:
        r3 = 1;
        goto L8
    }

    private void d() {
        e();
        SQLiteConnection r0 = this.q;
        if (r0 == null) goto L6;
        b(r0);
        this.q = null;
        return;
    }

    private void e() {
        int r0 = this.p.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        b((SQLiteConnection) ZeusTransformUtils.preCheckCast(this.p.get(r1), SQLiteConnection.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L3
    L5:
        this.p.clear();
    }

    private void f() {
        int r0 = this.p.size();
    L3:
        int r1 = r0 - 1;
        if (r0 <= (this.k - 1)) goto L6;
        b((SQLiteConnection) ZeusTransformUtils.preCheckCast(this.p.remove(r1), SQLiteConnection.class, "com.obric.memorydata.plugin"));
        r0 = r1;
        goto L3
    }

    private void g() {
        a(AcquiredConnectionStatus.DISCARD);
    }

    private void h() {
        SQLiteConnection r0 = this.q;
        if (r0 != null) goto L20;
    L8:
        int r1 = this.p.size();
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L16;
        SQLiteConnection r5 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.p.get(r4), SQLiteConnection.class, "com.obric.memorydata.plugin");
        r5.a(this.j);     // Catch: RuntimeException -> L13
    L15:
        r4 = r4 + 1;
    L13:
        e = move-exception;
        Log.a("WCDB.SQLiteConnectionPool", "Failed to reconfigure available non-primary connection, closing it: " + r5, new Object[]{e});
        b(r5);
        this.p.remove(r4);
        r1 = r1 - 1;
        r4 = r4 - 1;
        goto L15
    L16:
        a(AcquiredConnectionStatus.RECONFIGURE);
        return;
    L20:
        r0.a(this.j);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.a("WCDB.SQLiteConnectionPool", "Failed to reconfigure available primary connection, closing it: " + this.q, new Object[]{e});
        b(this.q);
        this.q = null;
        goto L8
    }

    private a i() {
        a r0 = new a(null);
        r0.c = 0;
        r0.d = 0;
        if (this.r.isEmpty() == true) goto L17;
        Iterator<SQLiteConnection> r1 = this.r.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L17;
        SQLiteConnection r2 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(r1.next(), SQLiteConnection.class, "com.obric.memorydata.plugin");
        o.a<StackTraceElement[]> r3 = r2.f();
        if (r3 == null) goto L10;
        r0.g.add(r3);
    L10:
        o.a<String> r4 = r2.e();
        if (r4 != null) goto L12;
        r0.d++;
        goto L6
    L12:
        r0.f.add(r4);
        String r5 = r2.d();
        if (r5 == null) goto L15;
        r0.f15840b.add(r5);
    L15:
        r0.c++;
    L17:
        r0.e = this.p.size();
        if (this.q == null) goto L20;
        r0.e++;
    L20:
        return r0;
    }

    private void j() {
        b r0 = this.o;
        boolean r3 = false;
        boolean r5 = false;
        b r4 = null;
    L3:
        if (r0 == null) goto L36;
        boolean r7 = true;
        if (this.l == true) goto L37;
    L28:
        b r6 = r0.f15841a;
        if (r7 == false) goto L34;
        if (r4 == null) goto L32;
        r4.f15841a = r6;
    L33:
        r0.f15841a = null;
        LockSupport.unpark(r0.f15842b);
    L35:
        r0 = r6;
        goto L3
    L32:
        this.o = r6;
        goto L33
    L34:
        r4 = r0;
        goto L35
    L37:
        if (r0.e == true) goto L13;
        if (r3 == true) goto L13;
        SQLiteConnection r8 = b(r0.f, r0.g);     // Catch: RuntimeException -> L26
        if (r8 != null) goto L14;
        r3 = true;
    L14:
        if (r8 != null) goto L19;
        if (r5 == true) goto L19;
        r8 = a(r0.g);     // Catch: RuntimeException -> L26
        if (r8 != null) goto L19;
        r5 = true;
    L19:
        if (r8 == null) goto L22;
        r0.h = r8;     // Catch: RuntimeException -> L26
        goto L28
    L22:
        if (r3 == false) goto L25;
        if (r5 == false) goto L25;
        return;
    L25:
        r7 = false;
    L13:
        r8 = null;
    L26:
        e = move-exception;
        r0.i = e;
        goto L28
    }

    private void k() {
        if (this.l == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
    }

    public SQLiteConnection a(String r9, int r10, com.tencent.wcdb.support.a r11) {
        long r0 = SystemClock.uptimeMillis();
        SQLiteConnection r12 = b(r9, r10, r11);
        o r2 = this.d;
        if (r2 == null) goto L11;
        long r5 = SystemClock.uptimeMillis() - r0;
        SQLiteDatabase r3 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(this.f15836b.get(), SQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if ((r10 & 2) == 0) goto L9;
        boolean r8 = true;
    L10:
        r2.a(r3, r9, r5, r8);
        goto L11
    L9:
        r8 = false;
    L11:
        return r12;
    }

    void a() {
        Log.b("WCDB.SQLiteConnectionPool", "A SQLiteConnection object for database '" + this.j.f15851b + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.i.set(true);
    }

    public void a(SQLiteConnection r5) {
        Object r0 = this.h;
        monitor-enter(r0);
        AcquiredConnectionStatus r1 = (AcquiredConnectionStatus) ZeusTransformUtils.preCheckCast(this.r.remove(r5), AcquiredConnectionStatus.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r1 == null) goto L31;
        if (this.l == true) goto L10;
    L8:
        b(r5);     // Catch: Throwable -> L32
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L32
        return;
    L10:
        if (r5.b() == false) goto L23;
        if (a(r5, r1) == true) goto L14;
    L21:
        j();     // Catch: Throwable -> L32
        goto L28
    L14:
        if (f15835a == false) goto L16;
    L20:
        this.q = r5;     // Catch: Throwable -> L32
        goto L21
    L16:
        if (this.q == null) goto L20;
        throw new AssertionError();     // Catch: Throwable -> L32
    L23:
        if (this.p.size() >= (this.k - 1)) goto L8;
        if (a(r5, r1) == false) goto L21;
        this.p.add(r5);     // Catch: Throwable -> L32
        goto L21
    L31:
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public void a(f r7) {
        if (r7 == null) goto L43;
        Object r0 = this.h;
        monitor-enter(r0);
        k();     // Catch: Throwable -> L39
        if (((r7.d ^ this.j.d) & net.zetetic.database.sqlcipher.SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        if (this.r.isEmpty() == false) goto L14;
        e();     // Catch: Throwable -> L39
        goto L16
    L14:
        throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");     // Catch: Throwable -> L39
    L16:
        if (r7.g == this.j.g) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L26;
        if (this.r.isEmpty() == true) goto L26;
        throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");     // Catch: Throwable -> L39
    L26:
        if (((this.j.d ^ r7.d) & 268435473) == 0) goto L28;
    L33:
        if (r1 == false) goto L35;
        d();     // Catch: Throwable -> L39
    L35:
        SQLiteConnection r2 = a(r7, true);     // Catch: Throwable -> L39
        d();     // Catch: Throwable -> L39
        g();     // Catch: Throwable -> L39
        this.q = r2;     // Catch: Throwable -> L39
        this.j.a(r7);     // Catch: Throwable -> L39
        c(0);     // Catch: Throwable -> L39
    L36:
        j();     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L28:
        if (com.tencent.wcdb.h.a(this.j.c, r7.c) == false) goto L33;
        if (r7.l.containsAll(this.j.l) == false) goto L33;
        this.j.a(r7);     // Catch: Throwable -> L39
        c(0);     // Catch: Throwable -> L39
        f();     // Catch: Throwable -> L39
        h();     // Catch: Throwable -> L39
        goto L36
    L18:
        r4 = false;
        goto L19
    L8:
        r1 = false;
    L39:
        th = move-exception;
        throw th;
    L43:
        throw new IllegalArgumentException("configuration must not be null.");
    }

    void a(o r3) {
        this.d = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
    }

    void a(String r4, int r5) {
        SQLiteDatabase r0 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(this.f15836b.get(), SQLiteDatabase.class, "com.obric.memorydata.plugin");
        com.tencent.wcdb.database.b r3 = this.e;
        if (r3 == null) goto L8;
        if (r0 == null) goto L9;
        r3.a(r0, r4, r5);
        return;
    L9:
        return;
    }

    void a(String r8, int r9, long r10) {
        SQLiteDatabase r2 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(this.f15836b.get(), SQLiteDatabase.class, "com.obric.memorydata.plugin");
        o r1 = this.d;
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        r1.a(r2, r8, r9, r10);
        return;
    L9:
        return;
    }

    void a(String r9, String r10, long[] r11, long[] r12, long[] r13) {
        SQLiteDatabase r2 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(this.f15836b.get(), SQLiteDatabase.class, "com.obric.memorydata.plugin");
        com.tencent.wcdb.database.a r1 = this.c;
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        r1.a(r2, r9, r10, r11, r12, r13);
        return;
    L9:
        return;
    }

    o b() {
        return this.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(false);
    }

    public void finalize() {
        a(true);     // Catch: Throwable -> L6
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public String toString() {
        return "SQLiteConnectionPool: " + this.j.f15850a;
    }
}
