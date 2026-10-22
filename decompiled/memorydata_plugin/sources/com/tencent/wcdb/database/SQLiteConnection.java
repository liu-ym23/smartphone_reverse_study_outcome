package com.tencent.wcdb.database;

import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteConnection implements com.tencent.wcdb.support.a.InterfaceC0846a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f15826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f15827b = null;
    private static final Pattern c = null;
    private static final String[] w = null;
    private static final String[] x = null;
    private final SQLiteConnectionPool d;
    private final f e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private final d i;
    private c j;
    private final b k;
    private Thread l;
    private int m;
    private StackTraceElement[] n;
    private long o;
    private long p;
    private boolean q;
    private int r;
    private byte[] s;
    private SQLiteCipherSpec t;
    private a u;
    private int v;

    /* JADX INFO: renamed from: com.tencent.wcdb.database.SQLiteConnection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {
        private static final SimpleDateFormat k = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f15828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f15829b;
        String c;
        String d;
        ArrayList<Object> e;
        boolean f;
        Exception g;
        int h;
        int i;
        int j;

        static {
            k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private String a() {
            if (this.f == true) goto L7;
            return "running";
        L7:
            if (this.g == null) goto L9;
            return "failed";
        L9:
            return "succeeded";
        }

        public void a(StringBuilder r7, boolean r8) {
            r7.append(this.c);
            if (this.f == false) goto L5;
            StringBuilder r0 = r7.append(" took ").append(this.f15829b - this.f15828a);
            String r1 = "ms";
        L6:
            r0.append(r1);
            r7.append(" - ").append(a());
            if (this.d == null) goto L10;
            r7.append(", sql=\"").append(SQLiteConnection.d(this.d)).append("\"");
        L10:
            if (this.j <= 0) goto L12;
            r7.append(", tid=").append(this.j);
        L12:
            if (r8 == false) goto L34;
            ArrayList<Object> r9 = this.e;
            if (r9 == null) goto L34;
            if (r9.size() == 0) goto L34;
            r7.append(", bindArgs=[");
            int r10 = this.e.size();
            int r2 = 0;
        L18:
            if (r2 >= r10) goto L33;
            Object r3 = this.e.get(r2);
            if (r2 == 0) goto L22;
            r7.append(", ");
        L22:
            if (r3 != null) goto L26;
            String r4 = "null";
        L24:
            r7.append(r4);
        L32:
            r2 = r2 + 1;
            goto L18
        L26:
            if ((r3 instanceof byte[]) == false) goto L29;
            r4 = "<byte[]>";
            goto L24
        L29:
            if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L31;
            r7.append("\"").append((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")).append("\"");
            goto L32
        L31:
            r7.append(r3);
            goto L32
        L33:
            r7.append("]");
        L34:
            Exception r11 = this.g;
            if (r11 != null) goto L37;
            return;
        L37:
            if (r11.getMessage() == null) goto L45;
            r7.append(", exception=\"").append(this.g.getMessage()).append("\"");
            return;
        L45:
            return;
        L5:
            r0 = r7.append(" started ").append(System.currentTimeMillis() - this.f15828a);
            r1 = "ms ago";
            goto L6
        }
    }

    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteConnection f15830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a[] f15831b;
        private int c;
        private int d;

        private b(SQLiteConnection r1) {
            this.f15830a = r1;
            this.f15831b = new a[20];
        }

        /* synthetic */ b(SQLiteConnection r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void a(a r2, String r3) {
            StringBuilder r1 = new StringBuilder();
            r2.a(r1, false);
            if (r3 == null) goto L5;
            r1.append(", ").append(r3);
        L5:
            Log.c("WCDB.SQLiteConnection", r1.toString());
        }

        private boolean a(a r3) {
            if (r3 == null) goto L10;
            r3.f15829b = System.currentTimeMillis();
            r3.f = true;
            if (r3.g == null) goto L9;
            if (r3.g.getMessage() == null) goto L9;
            return true;
        L9:
            return SQLiteDebug.a(r3.f15829b - r3.f15828a);
        L10:
            return false;
        }

        private int c(int r3) {
            int r0 = this.d;
            this.d = r0 + 1;
            return (r0 << 8) | r3;
        }

        private a d(int r2) {
            a[] r1 = this.f15831b;
            a r3 = r1[r2 & 255];
            if (r3.h == r2) goto L7;
            return null;
        L7:
            return r3;
        }

        a a(String r8, String r9, Object[] r10) {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            int r1 = (this.c + 1) % 20;     // Catch: Throwable -> L28
            a r2 = this.f15831b[r1];     // Catch: Throwable -> L28
            AnonymousClass1 r3 = null;
            int r4 = 0;
            if (r2 != null) goto L7;
            r2 = new a(r3);     // Catch: Throwable -> L28
            this.f15831b[r1] = r2;     // Catch: Throwable -> L28
        L10:
            r2.f15828a = System.currentTimeMillis();     // Catch: Throwable -> L28
            r2.c = r8;     // Catch: Throwable -> L28
            r2.d = r9;     // Catch: Throwable -> L28
            if (r10 != null) goto L13;
        L25:
            r2.h = c(r1);     // Catch: Throwable -> L28
            r2.j = SQLiteConnection.b(this.f15830a);     // Catch: Throwable -> L28
            this.c = r1;     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return r2;
        L13:
            if (r2.e != null) goto L15;
            r2.e = new ArrayList();     // Catch: Throwable -> L28
        L17:
            if (r4 >= r10.length) goto L25;
            Object r11 = r10[r4];     // Catch: Throwable -> L28
            if (r11 != null) goto L21;
        L23:
            r2.e.add(r11);     // Catch: Throwable -> L28
        L24:
            r4 = r4 + 1;     // Catch: Throwable -> L28
            goto L17
        L21:
            if ((r11 instanceof byte[]) == false) goto L23;
            r2.e.add(SQLiteConnection.g());     // Catch: Throwable -> L28
            goto L24
        L15:
            r2.e.clear();     // Catch: Throwable -> L28
            goto L17
        L7:
            r2.f = false;     // Catch: Throwable -> L28
            r2.g = null;     // Catch: Throwable -> L28
            if (r2.e == null) goto L10;
            r2.e.clear();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }

        String a() {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            a r3 = this.f15831b[this.c];     // Catch: Throwable -> L14
            if (r3 == null) goto L12;
            if (r3.f == true) goto L12;
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L14
            r3.a(r1, false);     // Catch: Throwable -> L14
            String r4 = r1.toString();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r4;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        void a(int r9) {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            a r10 = d(r9);     // Catch: Throwable -> L13
            if (a(r10) == false) goto L7;
            a(r10, null);     // Catch: Throwable -> L13
        L7:
            String r1 = r10.d;     // Catch: Throwable -> L13
            String r2 = r10.c;     // Catch: Throwable -> L13
            int r3 = r10.i;     // Catch: Throwable -> L13
            long r4 = r10.f15829b - r10.f15828a;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            if (LBSLightLocationTraceLogger.PREPARE.equals(r2) == true) goto L18;
            SQLiteConnection.c(this.f15830a).a(r1, r3, r4);
            return;
        L18:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        void a(int r2, Exception r3) {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            a r1 = d(r2);     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            r1.g = r3;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        void a(int r2, String r3) {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            a r4 = d(r2);     // Catch: Throwable -> L9
            if (r4 == null) goto L7;
            a(r4, r3);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        o.a<String> b() {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            a r5 = this.f15831b[this.c];     // Catch: Throwable -> L14
            if (r5 == null) goto L12;
            if (r5.f == true) goto L12;
            o.a<String> r1 = new o.a(r5.d, r5.f15828a, r5.j);     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r1;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        boolean b(int r10) {
            a[] r0 = this.f15831b;
            monitor-enter(r0);
            a r11 = d(r10);     // Catch: Throwable -> L15
            if (r11 == null) goto L7;
            boolean r1 = a(r11);     // Catch: Throwable -> L15
            String r2 = r11.d;     // Catch: Throwable -> L15
            String r3 = r11.c;     // Catch: Throwable -> L15
            int r4 = r11.i;     // Catch: Throwable -> L15
            long r5 = r11.f15829b - r11.f15828a;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            if (LBSLightLocationTraceLogger.PREPARE.equals(r3) == true) goto L14;
            SQLiteConnection.c(this.f15830a).a(r2, r4, r5);
        L14:
            return r1;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return false;
        L15:
            th = move-exception;
            throw th;
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<SQLiteConnection> f15832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f15833b;
        private String c;
        private long d;
        private int e;
        private int f;
        private boolean g;
        private boolean h;
        private boolean i;
        private a j;

        c(SQLiteConnection r2) {
            this.f15832a = new WeakReference(r2);
        }

        static /* synthetic */ int a(c r0) {
            return r0.f;
        }

        static /* synthetic */ int a(c r0, int r1) {
            r0.e = r1;
            return r1;
        }

        static /* synthetic */ long a(c r0, long r1) {
            r0.d = r1;
            return r1;
        }

        static /* synthetic */ c a(c r0, c r1) {
            r0.f15833b = r1;
            return r1;
        }

        static /* synthetic */ String a(c r0, String r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ boolean a(c r0, boolean r1) {
            r0.i = r1;
            return r1;
        }

        static /* synthetic */ int b(c r0) {
            return r0.e;
        }

        static /* synthetic */ int b(c r0, int r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ boolean b(c r0, boolean r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ boolean c(c r0) {
            return r0.g;
        }

        static /* synthetic */ boolean c(c r0, boolean r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ boolean d(c r0) {
            return r0.i;
        }

        static /* synthetic */ boolean e(c r0) {
            return r0.h;
        }

        static /* synthetic */ String f(c r0) {
            return r0.c;
        }

        static /* synthetic */ c g(c r0) {
            return r0.f15833b;
        }

        public long a() {
            return this.d;
        }

        public void a(com.tencent.wcdb.support.a r3) {
            SQLiteConnection r2 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.f15832a.get(), SQLiteConnection.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L5;
            return;
        L5:
            SQLiteConnection.a(r2, r3);
        }

        public void a(String r4) {
            if (this.j != null) goto L5;
            return;
        L5:
            SQLiteConnection r0 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.f15832a.get(), SQLiteConnection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
            return;
        L9:
            if (SQLiteConnection.a(r0).b(this.j.h) == false) goto L11;
            SQLiteConnection.a(r0).a(this.j.h, r4);
        L11:
            this.j = null;
        }

        public int getType() {
            return this.f;
        }
    }

    private final class d extends com.tencent.wcdb.support.c<String, c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteConnection f15834a;

        public d(SQLiteConnection r1, int r2) {
            this.f15834a = r1;
            super(r2);
        }

        @Override // com.tencent.wcdb.support.c
        public /* synthetic */ void a(boolean r3, String r4, c r5, c r6) {
            a2(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(boolean r1, String r2, c r3, c r4) {
            c.b(r3, false);
            if (c.d(r3) == true) goto L6;
            SQLiteConnection.a(this.f15834a, r3);
            return;
        }
    }

    static {
        f15826a = new String[0];
        f15827b = new byte[0];
        c = Pattern.compile("[\\s]*\\n+[\\s]*");
        w = new String[]{CipherConst.HMAC_SHA1, CipherConst.HMAC_SHA256, CipherConst.HMAC_SHA512};
        x = new String[]{CipherConst.PBKDF2_HMAC_SHA1, CipherConst.PBKDF2_HMAC_SHA256, CipherConst.PBKDF2_HMAC_SHA512};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SQLiteConnection(SQLiteConnectionPool r3, f r4, int r5, boolean r6, byte[] r7, SQLiteCipherSpec r8) {
        SQLiteCipherSpec r1 = null;
        this.k = new b(this, 0 == true ? 1 : 0);
        this.s = r7;
        if (r8 == null) goto L6;
        r1 = new SQLiteCipherSpec(r8);
    L6:
        this.t = r1;
        this.d = r3;
        f r9 = new f(r4);
        this.e = r9;
        this.f = r5;
        this.g = r6;
        boolean r10 = true;
        if ((r4.d & 1) != 0) goto L10;
        r10 = false;
    L10:
        this.h = r10;
        this.i = new d(this, r9.e);
    }

    static /* synthetic */ b a(SQLiteConnection r0) {
        return r0.k;
    }

    private c a(String r3, long r4, int r6, int r7, boolean r8) {
        c r0 = this.j;
        if (r0 == null) goto L5;
        this.j = c.g(r0);
        c.a(r0, null);
        c.b(r0, false);
    L6:
        c.a(r0, r3);
        c.a(r0, r4);
        c.a(r0, r6);
        c.b(r0, r7);
        c.c(r0, r8);
        return r0;
    L5:
        r0 = new c(this);
        goto L6
    }

    static SQLiteConnection a(SQLiteConnectionPool r8, f r9, int r10, boolean r11, byte[] r12, SQLiteCipherSpec r13) {
        SQLiteConnection r7 = new SQLiteConnection(r8, r9, r10, r11, r12, r13);
        r7.h();     // Catch: SQLiteException -> L5
        return r7;
    L5:
        e = move-exception;
        SQLiteDebug.a(r7);
        r7.b(false);
        throw e;
    }

    private void a(c r3, boolean r4) {
        nativeResetStatement(this.p, r3.a(), r4);
    }

    private void a(c r14, Object[] r15) {
        int r1 = 0;
        if (r15 == null) goto L5;
        int r2 = r15.length;
    L7:
        if (r2 != c.b(r14)) goto L36;
        if (r2 != 0) goto L10;
        return;
    L10:
        long r11 = r14.a();
    L11:
        if (r1 >= r2) goto L34;
        Object r16 = r15[r1];
        int r3 = com.tencent.wcdb.h.a(r16);
        if (r3 != 0) goto L15;
        nativeBindNull(this.p, r11, r1 + 1);
    L33:
        r1 = r1 + 1;
        goto L11
    L15:
        if (r3 != 1) goto L17;
        long r5 = this.p;
        int r8 = r1 + 1;
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue();
    L31:
        nativeBindLong(r5, r11, r8, r9);
        goto L33
    L17:
        if (r3 != 2) goto L19;
        nativeBindDouble(this.p, r11, r1 + 1, ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L33
    L19:
        if (r3 != 4) goto L21;
        nativeBindBlob(this.p, r11, r1 + 1, (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r16, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
        goto L33
    L21:
        if (ZeusTransformUtils.instanceOf(r16, Boolean.class) == false) goto L27;
        r5 = this.p;
        r8 = r1 + 1;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L25;
        long r4 = 1;
    L26:
        r9 = r4;
        goto L31
    L25:
        r4 = 0;
        goto L26
    L27:
        nativeBindString(this.p, r11, r1 + 1, r16.toString());
        goto L33
    L34:
        return;
    L36:
        throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + c.b(r14) + " bind arguments but " + r2 + " were provided.");
    L5:
        r2 = 0;
        goto L7
    }

    static /* synthetic */ void a(SQLiteConnection r0, c r1) {
        r0.b(r1);
    }

    static /* synthetic */ void a(SQLiteConnection r0, com.tencent.wcdb.support.a r1) {
        r0.b(r1);
    }

    private void a(com.tencent.wcdb.support.a r5) {
        if (r5 == null) goto L7;
        r5.b();
        int r0 = this.r + 1;
        this.r = r0;
        if (r0 != 1) goto L8;
        nativeResetCancel(this.p, true);
        r5.a(this);
        return;
    L8:
        return;
    }

    private static boolean a(int r2) {
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    static /* synthetic */ int b(SQLiteConnection r0) {
        return r0.m;
    }

    private void b(c r5) {
        nativeFinalizeStatement(this.p, r5.a());
        e(r5);
    }

    private void b(com.tencent.wcdb.support.a r2) {
        if (r2 == null) goto L7;
        int r0 = this.r - 1;
        this.r = r0;
        if (r0 != 0) goto L8;
        r2.a(null);
        nativeResetCancel(this.p, false);
        return;
    L8:
        return;
    }

    private void b(boolean r5) {
        if (this.p == 0) goto L10;
        int r6 = this.k.a(IslandSession.REOPEN_VALUE_CLOSE, null, null).h;
        this.i.a();     // Catch: Throwable -> L7
        nativeClose(this.p);     // Catch: Throwable -> L7
        this.p = 0;     // Catch: Throwable -> L7
        this.k.a(r6);
        return;
    L7:
        th = move-exception;
        this.k.a(r6);
        throw th;
    }

    static /* synthetic */ SQLiteConnectionPool c(SQLiteConnection r0) {
        return r0.d;
    }

    private void c(c r1) {
        if (this.q == true) goto L5;
        return;
    L5:
        if (c.c(r1) == false) goto L8;
        return;
    L8:
        throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }

    static /* synthetic */ String d(String r0) {
        return f(r0);
    }

    private void d(c r1) {
    }

    private void e(c r2) {
        c.a(r2, null);
        c.a(r2, this.j);
        this.j = r2;
    }

    private void e(String r5) {
        String r0 = c("PRAGMA journal_mode", null, null);
        if (r0.equalsIgnoreCase(r5) == true) goto L12;
        if (c("PRAGMA journal_mode=" + r5, null, null).equalsIgnoreCase(r5) == false) goto L7;
        return;
    L7:
        Log.b("WCDB.SQLiteConnection", "Could not change the database journal mode of '" + this.e.f15851b + "' from '" + r0 + "' to '" + r5 + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        return;
    }

    private static String f(String r1) {
        return c.matcher(r1).replaceAll(" ");
    }

    static /* synthetic */ byte[] g() {
        return f15827b;
    }

    private void h() {
        long r0 = nativeOpen(this.e.f15850a, this.e.d, this.e.c);
        this.p = r0;
        byte[] r2 = this.s;
        if (r2 != null) goto L5;
    L7:
        byte[] r3 = this.s;
        if (r3 == null) goto L10;
        nativeSetKey(r0, r3);
        j();
    L10:
        i();
        q();
        m();
        n();
        o();
        l();
        k();
        p();
        long r1 = WCDBInitializationProbe.apiEnv;
        long r4 = nativeSQLiteHandle(this.p, true);
        Iterator<com.tencent.wcdb.extension.a> r5 = this.e.l.iterator();     // Catch: Throwable -> L18
    L13:
        if (r5.hasNext() == false) goto L16;
        ((com.tencent.wcdb.extension.a) ZeusTransformUtils.preCheckCast(r5.next(), com.tencent.wcdb.extension.a.class, "com.obric.memorydata.plugin")).a(r4, r1);     // Catch: Throwable -> L18
        goto L13
    L16:
        nativeSQLiteHandle(this.p, false);
        r();
        return;
    L18:
        th = move-exception;
        nativeSQLiteHandle(this.p, false);
        throw th;
    L5:
        if (r2.length != 0) goto L7;
        this.s = null;
        goto L7
    }

    private void i() {
        if (this.e.a() == false) goto L5;
        return;
    L5:
        if (this.s == null) goto L14;
        SQLiteCipherSpec r0 = this.t;
        if (r0 != null) goto L9;
    L12:
        int r1 = SQLiteGlobal.f15849a;
    L13:
        long r2 = r1;
        String r3 = "PRAGMA cipher_page_size";
    L16:
        if (b(r3, null, null) == r2) goto L20;
        a(r3 + "=" + r2, null, null);
        return;
    L20:
        return;
    L9:
        if (r0.pageSize <= 0) goto L12;
        r1 = this.t.pageSize;
        goto L13
    L14:
        r2 = SQLiteGlobal.f15849a;
        r3 = "PRAGMA page_size";
        goto L16
    }

    private void j() {
        SQLiteCipherSpec r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.kdfIteration == 0) goto L7;
        a("PRAGMA kdf_iter=" + this.t.kdfIteration, null, null);
    L7:
        a("PRAGMA cipher_use_hmac=" + this.t.hmacEnabled, null, null);
        if (this.t.hmacAlgorithm == (-1)) goto L11;
        a("PRAGMA cipher_hmac_algorithm=" + w[this.t.hmacAlgorithm], null, null);
    L11:
        if (this.t.kdfAlgorithm == (-1)) goto L15;
        a("PRAGMA cipher_kdf_algorithm=" + x[this.t.kdfAlgorithm], null, null);
        return;
    }

    private void k() {
        if (this.e.a() == false) goto L5;
        return;
    L5:
        if (this.h == false) goto L7;
        return;
    L7:
        if (this.e.h == false) goto L10;
        nativeSetWalHook(this.p);
        return;
    L10:
        if (b("PRAGMA wal_autocheckpoint", null, null) == 100) goto L16;
        b("PRAGMA wal_autocheckpoint=100", null, null);
        return;
    }

    private void l() {
        if (this.e.a() == false) goto L5;
        return;
    L5:
        if (this.h == false) goto L7;
        return;
    L7:
        if (b("PRAGMA journal_size_limit", null, null) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L12;
        b("PRAGMA journal_size_limit=524288", null, null);
        return;
    }

    private void m() {
        if (this.h == false) goto L5;
        return;
    L5:
        if (this.e.g == false) goto L7;
        long r0 = 1;
    L9:
        if (b("PRAGMA foreign_keys", null, null) == r0) goto L13;
        a("PRAGMA foreign_keys=" + r0, null, null);
        return;
    L13:
        return;
    L7:
        r0 = 0;
        goto L9
    }

    private void n() {
        if (this.e.a() == false) goto L5;
        return;
    L5:
        if (this.h == false) goto L7;
        return;
    L7:
        if ((this.e.d & net.zetetic.database.sqlcipher.SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L9;
        String r0 = "WAL";
    L10:
        e(r0);
        return;
    L9:
        r0 = "PERSIST";
        goto L10
    }

    private static native void nativeBindBlob(long r0, long r2, int r4, byte[] r5);

    private static native void nativeBindDouble(long r0, long r2, int r4, double r5);

    private static native void nativeBindLong(long r0, long r2, int r4, long r5);

    private static native void nativeBindNull(long r0, long r2, int r4);

    private static native void nativeBindString(long r0, long r2, int r4, String r5);

    private static native void nativeCancel(long r0);

    private static native void nativeClose(long r0);

    private static native void nativeExecute(long r0, long r2);

    private static native int nativeExecuteForChangedRowCount(long r0, long r2);

    private static native long nativeExecuteForCursorWindow(long r0, long r2, long r4, int r6, int r7, boolean r8);

    private static native long nativeExecuteForLastInsertedRowId(long r0, long r2);

    private static native long nativeExecuteForLong(long r0, long r2);

    private static native String nativeExecuteForString(long r0, long r2);

    private static native void nativeFinalizeStatement(long r0, long r2);

    private static native int nativeGetColumnCount(long r0, long r2);

    private static native String nativeGetColumnName(long r0, long r2, int r4);

    private static native int nativeGetDbLookaside(long r0);

    private static native int nativeGetParameterCount(long r0, long r2);

    private static native boolean nativeIsReadOnly(long r0, long r2);

    private native long nativeOpen(String r1, int r2, String r3);

    private static native long nativePrepareStatement(long r0, String r2);

    private static native void nativeRegisterCustomFunction(long r0, SQLiteCustomFunction r2);

    private static native void nativeRegisterLocalizedCollators(long r0, String r2);

    private static native void nativeResetCancel(long r0, boolean r2);

    private static native void nativeResetStatement(long r0, long r2, boolean r4);

    private static native long nativeSQLiteHandle(long r0, boolean r2);

    private static native void nativeSetKey(long r0, byte[] r2);

    private static native void nativeSetUpdateNotification(long r0, boolean r2, boolean r3);

    private static native void nativeSetWalHook(long r0);

    private static native long nativeWalCheckpoint(long r0, String r2);

    private void notifyChange(String r7, String r8, long[] r9, long[] r10, long[] r11) {
        this.d.a(r7, r8, r9, r10, r11);
    }

    private void notifyCheckpoint(String r1, int r2) {
        this.d.a(r1, r2);
    }

    private void o() {
        a("PRAGMA synchronous=" + this.e.i, null, null);
    }

    private void p() {
        this.e.d |= 16;
        if ((this.e.d & 16) == 0) goto L5;
        return;
    L5:
        String r0 = this.e.f.toString();
        nativeRegisterLocalizedCollators(this.p, r0);
        if (this.h == false) goto L25;
        return;
    L25:
        a("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);     // Catch: RuntimeException -> L20
        String r1 = c("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);     // Catch: RuntimeException -> L20
        if (r1 != null) goto L11;
    L13:
        a("BEGIN", null, null);     // Catch: RuntimeException -> L20
        a("DELETE FROM android_metadata", null, null);     // Catch: Throwable -> L17
        a("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{r0}, null);     // Catch: Throwable -> L17
        a("REINDEX LOCALIZED", null, null);     // Catch: Throwable -> L17
        a("COMMIT", null, null);     // Catch: RuntimeException -> L20
        return;
    L17:
        th = move-exception;
        a("ROLLBACK", null, null);     // Catch: RuntimeException -> L20
        throw th;     // Catch: RuntimeException -> L20
    L11:
        if (r1.equals(r0) == false) goto L13;
        return;
    L20:
        e = move-exception;
        throw new SQLiteException("Failed to change locale for db '" + this.e.f15851b + "' to '" + r0 + "'.", e);
    }

    private void q() {
        if (this.h == false) goto L6;
        a("PRAGMA query_only = 1", null, null);
        return;
    }

    private void r() {
        nativeSetUpdateNotification(this.p, this.e.j, this.e.k);
    }

    public int a(String r25, Object[] r26, CursorWindow r27, int r28, int r29, boolean r30, com.tencent.wcdb.support.a r31) {
        if (r25 == null) goto L71;
        if (r27 == null) goto L69;
        r27.acquireReference();
        a r4 = this.k.a("executeForCursorWindow", r25, r26);     // Catch: Throwable -> L65
        int r9 = r4.h;     // Catch: Throwable -> L65
        int r16 = -1;
        c r6 = c(r25);     // Catch: Throwable -> L53 RuntimeException -> L55
        r4.i = c.a(r6);     // Catch: Throwable -> L53 RuntimeException -> L55
        c(r6);     // Catch: Throwable -> L47
        a(r6, r26);     // Catch: Throwable -> L47
        d(r6);     // Catch: Throwable -> L47
        a(r31);     // Catch: Throwable -> L47
        c r2 = r6;
        String r12 = "window='";
        String r11 = ", countedRows=";
        int r15 = r9;
        String r7 = "', startPos=";
        String r10 = ", actualPos=";
        String r13 = ", filledRows=";
        long r5 = nativeExecuteForCursorWindow(this.p, r6.a(), r27.mWindowPtr, r28, r29, r30);     // Catch: Throwable -> L36
        int r8 = (int) (r5 >> 32);
        int r14 = (int) r5;
        int r17 = r27.getNumRows();     // Catch: Throwable -> L33
        r27.setStartPosition(r8);     // Catch: Throwable -> L31
        b(r31);     // Catch: Throwable -> L29
        a(r2);     // Catch: Throwable -> L25 RuntimeException -> L27
    L21:
        if (this.k.b(r15) == false) goto L23;
        this.k.a(r15, r12 + r27 + r7 + r28 + r10 + r8 + r13 + r17 + r11 + r14);     // Catch: Throwable -> L65
    L23:
        r27.releaseReference();
        return r14;
    L27:
        e = e;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
        r16 = r8;
    L57:
        this.k.a(r15, e);     // Catch: Throwable -> L59
        throw e;     // Catch: Throwable -> L59
    L59:
        th = th;
        r8 = r16;
    L62:
        if (this.k.b(r15) == false) goto L64;
        this.k.a(r15, r12 + r27 + r7 + r28 + r10 + r8 + r13 + r17 + r11 + r14);     // Catch: Throwable -> L65
    L64:
        throw th;     // Catch: Throwable -> L65
    L25:
        th = th;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
    L29:
        th = th;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
        r16 = r8;
    L76:
        a(r2);     // Catch: RuntimeException -> L51 Throwable -> L59
        throw th;     // Catch: RuntimeException -> L51 Throwable -> L59
    L51:
        e = e;
    L31:
        th = th;
    L35:
        r16 = r8;
    L84:
        b(r31);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = th;
    L33:
        th = th;
        r17 = -1;
    L36:
        th = th;
        r28 = r28;
        r12 = r12;
        r11 = r11;
        r7 = r7;
        r10 = r10;
        r13 = r13;
    L42:
        r14 = -1;
        r17 = -1;
    L38:
        th = th;
        r7 = "', startPos=";
        r10 = ", actualPos=";
        r13 = ", filledRows=";
        r28 = r28;
        r11 = ", countedRows=";
        r15 = r9;
        r12 = "window='";
        r2 = r6;
    L40:
        th = th;
        r2 = r6;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
    L47:
        th = th;
        r2 = r6;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
        r14 = -1;
        r17 = -1;
        goto L76
    L55:
        e = e;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
        r14 = -1;
        r17 = -1;
    L53:
        th = th;
        r7 = "', startPos=";
        r13 = ", filledRows=";
        r12 = "window='";
        r28 = r28;
        r15 = r9;
        r10 = ", actualPos=";
        r11 = ", countedRows=";
        r14 = -1;
        r17 = -1;
        r8 = -1;
    L65:
        th = move-exception;
        r27.releaseReference();
        throw th;
    L69:
        throw new IllegalArgumentException("window must not be null.");
    L71:
        throw new IllegalArgumentException("sql must not be null.");
    }

    long a(String r5) {
        if (this.p != 0) goto L5;
        return 0;
    L5:
        if (r5 != null) goto L7;
    L9:
        this.v++;
        return nativeSQLiteHandle(this.p, true);
    L7:
        if (this.u != null) goto L9;
        a r6 = this.k.a(r5, null, null);
        this.u = r6;
        r6.i = 99;
        goto L9
    }

    void a() {
        b(false);
    }

    void a(c r2) {
        c.a(r2, false);
        if (c.e(r2) == true) goto L10;
        b(r2);
        return;
    L10:
        a(r2, true);     // Catch: SQLiteException -> L7
        return;
    L7:
        this.i.b(c.f(r2));
    }

    void a(f r11) {
        boolean r0 = false;
        this.q = false;
        long r1 = WCDBInitializationProbe.apiEnv;
        long r3 = nativeSQLiteHandle(this.p, true);
        Iterator<com.tencent.wcdb.extension.a> r6 = r11.l.iterator();     // Catch: Throwable -> L45
    L5:
        if (r6.hasNext() == false) goto L10;
        com.tencent.wcdb.extension.a r7 = (com.tencent.wcdb.extension.a) ZeusTransformUtils.preCheckCast(r6.next(), com.tencent.wcdb.extension.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        if (this.e.l.contains(r7) == true) goto L5;
        r7.a(r3, r1);     // Catch: Throwable -> L45
        goto L5
    L10:
        nativeSQLiteHandle(this.p, false);
        if (((r11.d ^ this.e.d) & net.zetetic.database.sqlcipher.SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L13;
        boolean r2 = true;
    L15:
        if (r11.g == this.e.g) goto L17;
        boolean r4 = true;
    L18:
        boolean r5 = !r11.f.equals(this.e.f);
        if (r11.h == this.e.h) goto L21;
        boolean r8 = true;
    L23:
        if (r11.i == this.e.i) goto L25;
        boolean r9 = true;
    L27:
        if (r11.j == this.e.j) goto L29;
    L30:
        r0 = true;
    L31:
        this.e.a(r11);
        this.i.a(r11.e);
        if (r4 == false) goto L34;
        m();
    L34:
        if (r2 == false) goto L36;
        n();
    L36:
        if (r9 == false) goto L38;
        o();
    L38:
        if (r8 == false) goto L40;
        k();
    L40:
        if (r5 == false) goto L42;
        p();
    L42:
        if (r0 == false) goto L55;
        r();
        return;
    L55:
        return;
    L29:
        if (r11.k == this.e.k) goto L31;
    L25:
        r9 = false;
        goto L27
    L21:
        r8 = false;
        goto L23
    L17:
        r4 = false;
        goto L18
    L13:
        r2 = false;
    L45:
        th = move-exception;
        nativeSQLiteHandle(this.p, false);
        throw th;
    }

    void a(Exception r4) {
        int r0 = this.v - 1;
        this.v = r0;
        if (r0 == 0) goto L5;
        return;
    L5:
        if (this.u == null) goto L13;
        nativeSQLiteHandle(this.p, false);
        if (r4 != null) goto L9;
        this.k.b(this.u.h);
    L10:
        this.u = null;
        return;
    L9:
        this.k.a(this.u.h, r4);
        goto L10
    }

    public void a(String r9, n r10) {
        if (r9 == null) goto L27;
        a r0 = this.k.a(LBSLightLocationTraceLogger.PREPARE, r9, null);
        int r1 = r0.h;
        c r11 = c(r9);     // Catch: Throwable -> L19 RuntimeException -> L21
        r0.i = c.a(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        if (r10 != null) goto L30;
    L16:
        a(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        this.k.a(r1);
        return;
    L30:
        r10.f15865a = c.b(r11);     // Catch: Throwable -> L13
        r10.c = c.c(r11);     // Catch: Throwable -> L13
        int r2 = nativeGetColumnCount(this.p, r11.a());     // Catch: Throwable -> L13
        if (r2 != 0) goto L9;
        r10.f15866b = f15826a;     // Catch: Throwable -> L13
        goto L16
    L9:
        r10.f15866b = new String[r2];     // Catch: Throwable -> L13
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L16;
        r10.f15866b[r3] = nativeGetColumnName(this.p, r11.a(), r3);     // Catch: Throwable -> L13
        r3 = r3 + 1;
    L13:
        th = move-exception;
        a(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        throw th;     // Catch: Throwable -> L19 RuntimeException -> L21
    L21:
        e = move-exception;
        this.k.a(r1, e);     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.k.a(r1);
        throw th;
    L27:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public void a(String r7, Object[] r8, com.tencent.wcdb.support.a r9) {
        if (r7 == null) goto L25;
        a r0 = this.k.a("execute", r7, r8);
        int r1 = r0.h;
        c r10 = c(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.i = c.a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        c(r10);     // Catch: Throwable -> L14
        a(r10, r8);     // Catch: Throwable -> L14
        d(r10);     // Catch: Throwable -> L14
        a(r9);     // Catch: Throwable -> L14
        nativeExecute(this.p, r10.a());     // Catch: Throwable -> L11
        b(r9);     // Catch: Throwable -> L14
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.k.a(r1);
        return;
    L11:
        th = move-exception;
        b(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.k.a(r1);
        throw th;
    L19:
        e = move-exception;
        this.k.a(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    void a(boolean r1) {
        this.q = r1;
    }

    void a(boolean r4, boolean r5) {
        if (r4 == false) goto L7;
        this.l = Thread.currentThread();
        this.m = Process.myTid();
        if (r5 == false) goto L8;
        this.n = this.l.getStackTrace();
        this.o = System.currentTimeMillis();
        return;
    L8:
        this.n = null;
        this.o = 0;
        return;
    L7:
        this.l = null;
        this.m = 0;
        goto L8
    }

    public long b(String r7, Object[] r8, com.tencent.wcdb.support.a r9) {
        if (r7 == null) goto L25;
        a r0 = this.k.a("executeForLong", r7, r8);
        int r1 = r0.h;
        c r10 = c(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.i = c.a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        c(r10);     // Catch: Throwable -> L14
        a(r10, r8);     // Catch: Throwable -> L14
        d(r10);     // Catch: Throwable -> L14
        a(r9);     // Catch: Throwable -> L14
        long r2 = nativeExecuteForLong(this.p, r10.a());     // Catch: Throwable -> L11
        b(r9);     // Catch: Throwable -> L14
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.k.a(r1);
        return r2;
    L11:
        th = move-exception;
        b(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.k.a(r1);
        throw th;
    L19:
        e = move-exception;
        this.k.a(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public boolean b() {
        return this.g;
    }

    boolean b(String r1) {
        if (this.i.a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    c c(String r14) {
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.i.a(r14), c.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        boolean r2 = false;
    L10:
        long r3 = nativePrepareStatement(this.p, r14);
        int r9 = nativeGetParameterCount(this.p, r3);     // Catch: RuntimeException -> L18
        int r12 = com.tencent.wcdb.h.a(r14);     // Catch: RuntimeException -> L18
        r0 = a(r14, r3, r9, r12, nativeIsReadOnly(this.p, r3));     // Catch: RuntimeException -> L18
        if (r2 == false) goto L14;
    L16:
        c.a(r0, true);
        return r0;
    L14:
        if (a(r12) == false) goto L16;
        this.i.a(r14, r0);     // Catch: RuntimeException -> L18
        c.b(r0, true);     // Catch: RuntimeException -> L18
    L18:
        e = move-exception;
        if (r0 != null) goto L21;
    L22:
        nativeFinalizeStatement(this.p, r3);
    L23:
        throw e;
    L21:
        if (c.e(r0) == true) goto L23;
    L5:
        if (c.d(r0) == true) goto L8;
        c.a(r0, true);
        return r0;
    L8:
        r2 = true;
        goto L10
    }

    public String c(String r7, Object[] r8, com.tencent.wcdb.support.a r9) {
        if (r7 == null) goto L25;
        a r0 = this.k.a("executeForString", r7, r8);
        int r1 = r0.h;
        c r10 = c(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.i = c.a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        c(r10);     // Catch: Throwable -> L14
        a(r10, r8);     // Catch: Throwable -> L14
        d(r10);     // Catch: Throwable -> L14
        a(r9);     // Catch: Throwable -> L14
        String r11 = nativeExecuteForString(this.p, r10.a());     // Catch: Throwable -> L11
        b(r9);     // Catch: Throwable -> L14
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.k.a(r1);
        return r11;
    L11:
        th = move-exception;
        b(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.k.a(r1);
        throw th;
    L19:
        e = move-exception;
        this.k.a(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    @Override // com.tencent.wcdb.support.a.InterfaceC0846a
    public void c() {
        nativeCancel(this.p);
    }

    public int d(String r9, Object[] r10, com.tencent.wcdb.support.a r11) {
        if (r9 == null) goto L30;
        a r2 = this.k.a("executeForChangedRowCount", r9, r10);
        int r3 = r2.h;
        c r12 = c(r9);     // Catch: Throwable -> L20 RuntimeException -> L22
        r2.i = c.a(r12);     // Catch: Throwable -> L20 RuntimeException -> L22
        c(r12);     // Catch: Throwable -> L17
        a(r12, r10);     // Catch: Throwable -> L17
        d(r12);     // Catch: Throwable -> L17
        a(r11);     // Catch: Throwable -> L17
        int r1 = nativeExecuteForChangedRowCount(this.p, r12.a());     // Catch: Throwable -> L14
        b(r11);     // Catch: Throwable -> L17
        a(r12);     // Catch: Throwable -> L20 RuntimeException -> L22
        if (this.k.b(r3) == false) goto L13;
        this.k.a(r3, "changedRows=" + r1);
    L13:
        return r1;
    L14:
        th = move-exception;
        b(r11);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        a(r12);     // Catch: Throwable -> L20 RuntimeException -> L22
        throw th;     // Catch: Throwable -> L20 RuntimeException -> L22
    L22:
        e = move-exception;
        this.k.a(r3, e);     // Catch: Throwable -> L20
        throw e;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (this.k.b(r3) == false) goto L28;
        this.k.a(r3, "changedRows=0");
    L28:
        throw th;
    L30:
        throw new IllegalArgumentException("sql must not be null.");
    }

    String d() {
        return this.k.a();
    }

    public long e(String r7, Object[] r8, com.tencent.wcdb.support.a r9) {
        if (r7 == null) goto L25;
        a r0 = this.k.a("executeForLastInsertedRowId", r7, r8);
        int r1 = r0.h;
        c r10 = c(r7);     // Catch: Throwable -> L17 RuntimeException -> L19
        r0.i = c.a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        c(r10);     // Catch: Throwable -> L14
        a(r10, r8);     // Catch: Throwable -> L14
        d(r10);     // Catch: Throwable -> L14
        a(r9);     // Catch: Throwable -> L14
        long r2 = nativeExecuteForLastInsertedRowId(this.p, r10.a());     // Catch: Throwable -> L11
        b(r9);     // Catch: Throwable -> L14
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.k.a(r1);
        return r2;
    L11:
        th = move-exception;
        b(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(r10);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.k.a(r1);
        throw th;
    L19:
        e = move-exception;
        this.k.a(r1, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    o.a<String> e() {
        return this.k.b();
    }

    o.a<StackTraceElement[]> f() {
        StackTraceElement[] r0 = this.n;
        if (r0 != null) goto L6;
        return null;
    L6:
        return new o.a(r0, this.o, this.m);
    }

    public void finalize() {
        SQLiteConnectionPool r0 = this.d;     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
    L7:
        b(true);     // Catch: Throwable -> L10
        super.finalize();
        return;
    L5:
        if (this.p == 0) goto L7;
        r0.a();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public String toString() {
        return "SQLiteConnection: " + this.e.f15850a + " (" + this.f + ")";
    }
}
