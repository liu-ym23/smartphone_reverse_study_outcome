package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Alog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1001a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f1002b = 0;
    private static final int c = 0;
    private static final int d = 0;
    private static final int e = 0;
    private static final int f = 0;
    private static volatile List<c> g;
    private static final ArrayList<String> h = null;
    private static boolean i;
    private Context j;
    private int k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private String q;
    private long r;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        private static final /* synthetic */ AsymCrypt[] $VALUES = null;
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;
        private final int value;

        static {
            AsymCrypt r0 = new AsymCrypt("NONE", 0, 0);
            NONE = r0;
            AsymCrypt r1 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r1;
            AsymCrypt r3 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r3;
            $VALUES = new AsymCrypt[]{r0, r1, r3};
        }

        private AsymCrypt(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static AsymCrypt valueOf(String r2) {
            return (AsymCrypt) ZeusTransformUtils.preCheckCast(Enum.valueOf(AsymCrypt.class, r2), AsymCrypt.class, "com.obric.memorydata.plugin");
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AsymCrypt[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        private static final /* synthetic */ Compress[] $VALUES = null;
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;
        private final int value;

        static {
            Compress r0 = new Compress("NONE", 0, 0);
            NONE = r0;
            Compress r1 = new Compress("ZLIB", 1, 1);
            ZLIB = r1;
            Compress r3 = new Compress("ZSTD", 2, 2);
            ZSTD = r3;
            $VALUES = new Compress[]{r0, r1, r3};
        }

        private Compress(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Compress valueOf(String r2) {
            return (Compress) ZeusTransformUtils.preCheckCast(Enum.valueOf(Compress.class, r2), Compress.class, "com.obric.memorydata.plugin");
        }

        public static Compress[] values() {
            return (Compress[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Compress[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;
        private final int value;

        static {
            Mode r0 = new Mode("SPEED", 0, 0);
            SPEED = r0;
            Mode r1 = new Mode("SAFE", 1, 1);
            SAFE = r1;
            $VALUES = new Mode[]{r0, r1};
        }

        private Mode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        private static final /* synthetic */ PrefixFormat[] $VALUES = null;
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;
        private final int value;

        static {
            PrefixFormat r0 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r0;
            PrefixFormat r1 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r1;
            $VALUES = new PrefixFormat[]{r0, r1};
        }

        private PrefixFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static PrefixFormat valueOf(String r2) {
            return (PrefixFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(PrefixFormat.class, r2), PrefixFormat.class, "com.obric.memorydata.plugin");
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PrefixFormat[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        private static final /* synthetic */ SymCrypt[] $VALUES = null;
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;
        private final int value;

        static {
            SymCrypt r0 = new SymCrypt("NONE", 0, 0);
            NONE = r0;
            SymCrypt r1 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r1;
            SymCrypt r3 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r3;
            SymCrypt r5 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r5;
            $VALUES = new SymCrypt[]{r0, r1, r3, r5};
        }

        private SymCrypt(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static SymCrypt valueOf(String r2) {
            return (SymCrypt) ZeusTransformUtils.preCheckCast(Enum.valueOf(SymCrypt.class, r2), SymCrypt.class, "com.obric.memorydata.plugin");
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SymCrypt[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        private static final /* synthetic */ TimeFormat[] $VALUES = null;
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;
        private final int value;

        static {
            TimeFormat r0 = new TimeFormat("RAW", 0, 0);
            RAW = r0;
            TimeFormat r1 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r1;
            $VALUES = new TimeFormat[]{r0, r1};
        }

        private TimeFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static TimeFormat valueOf(String r2) {
            return (TimeFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(TimeFormat.class, r2), TimeFormat.class, "com.obric.memorydata.plugin");
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TimeFormat[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f1003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1004b;
        private boolean c;
        private String d;
        private String e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private String l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private String s;
        private boolean t;

        public a(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            this.f1004b = 0;
            this.c = false;
            this.d = null;
            this.e = null;
            this.f = 2097152;
            this.g = 20971520;
            this.h = 7;
            this.i = null;
            this.j = 65536;
            this.k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            this.l = null;
            this.m = Alog.f();
            this.n = Alog.g();
            this.o = Alog.h();
            this.p = Alog.i();
            this.q = Alog.j();
            this.r = Alog.k();
            this.s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            this.t = false;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            r6 = r0;
        L5:
            this.f1003a = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        }

        public a a(int r1) {
            this.f1004b = r1;
            return this;
        }

        public a a(AsymCrypt r1) {
            this.r = r1.getValue();
            return this;
        }

        public a a(Compress r1) {
            this.p = r1.getValue();
            return this;
        }

        public a a(Mode r1) {
            this.m = r1.getValue();
            return this;
        }

        public a a(PrefixFormat r1) {
            this.o = r1.getValue();
            return this;
        }

        public a a(SymCrypt r1) {
            this.q = r1.getValue();
            return this;
        }

        public a a(TimeFormat r1) {
            this.n = r1.getValue();
            return this;
        }

        public a a(String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L5;
        L13:
            return this;
        L5:
            if (r4.contains("-") == false) goto L8;
            r4 = r4.replace("-", "");
        L8:
            if (r4.contains("_") == false) goto L11;
            r4 = r4.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r4) == true) goto L13;
            this.d = r4;
            goto L13
        }

        public a a(boolean r1) {
            this.c = r1;
            return this;
        }

        public Alog a() {
            if (this.d != null) goto L5;
            this.d = "default";
        L5:
            ArrayList r1 = Alog.l();
            monitor-enter(r1);
            Iterator r2 = Alog.l().iterator();     // Catch: Throwable -> L37
        L9:
            if (r2.hasNext() == false) goto L14;
            if (((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")).equals(this.d) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L37
            return null;
        L14:
            Alog.l().add(this.d);     // Catch: Throwable -> L37
            monitor-exit(r1);     // Catch: Throwable -> L37
            if (this.e != null) goto L24;
            File r3 = this.f1003a.getExternalFilesDir(null);
            if (r3 == null) goto L21;
            StringBuilder r4 = new StringBuilder().append(r3.getPath());
        L22:
            this.e = r4.append("/alog").toString();
            goto L24
        L21:
            r4 = new StringBuilder().append(this.f1003a.getFilesDir());
        L24:
            if (this.i != null) goto L27;
            this.i = this.f1003a.getFilesDir() + "/alog";
        L27:
            if (this.l != null) goto L29;
            this.l = f.a(this.f1003a);
        L29:
            int r5 = (this.j / 4096) * 4096;
            this.j = r5;
            int r6 = (this.k / 4096) * 4096;
            this.k = r6;
            if (r5 >= 4096) goto L32;
            this.j = 4096;
        L32:
            int r7 = this.j;
            if (r6 >= (r7 * 2)) goto L36;
            this.k = r7 * 2;
        L36:
            return new Alog(this.f1003a, this.f1004b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t);
        L37:
            th = move-exception;
            throw th;
        }

        public a b(int r1) {
            this.f = r1;
            return this;
        }

        public a b(String r1) {
            this.e = r1;
            return this;
        }

        public a b(boolean r1) {
            this.t = r1;
            return this;
        }

        public a c(int r1) {
            this.g = r1;
            return this;
        }

        public a c(String r1) {
            this.i = r1;
            return this;
        }

        public a d(int r1) {
            this.h = r1;
            return this;
        }

        public a d(String r1) {
            this.s = r1;
            return this;
        }

        public a e(int r1) {
            this.j = r1;
            return this;
        }

        public a f(int r1) {
            this.k = r1;
            return this;
        }
    }

    static {
        f1001a = Mode.SAFE.getValue();
        f1002b = TimeFormat.RAW.getValue();
        c = PrefixFormat.DEFAULT.getValue();
        d = Compress.ZSTD.getValue();
        e = SymCrypt.TEA_16.getValue();
        f = AsymCrypt.EC_SECP256K1.getValue();
        g = null;
        h = new ArrayList();
        i = false;
    }

    public Alog(Context r26, int r27, boolean r28, String r29, String r30, int r31, int r32, int r33, String r34, int r35, int r36, String r37, int r38, int r39, int r40, int r41, int r42, int r43, String r44, boolean r45) {
        this.j = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.k = r27;
        this.l = r30;
        this.m = r34;
        this.n = r35;
        this.o = r36 / r35;
        this.p = null;
        this.q = r29;
        this.r = nativeCreate(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, TimeZone.getDefault().getRawOffset() / 1000);
    }

    public static synchronized void a(b r3) {
        monitor-enter(Alog.class);
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (i == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r4 != null) goto L10;
        System.loadLibrary("alog");     // Catch: Throwable -> L14
    L11:
        i = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r4.a("alog");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void a(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (g != null) goto L9;
        g = new CopyOnWriteArrayList();
    L9:
        if (g.contains(r3) == true) goto L12;
        g.add(r3);
        return;
    }

    static /* synthetic */ int f() {
        return f1001a;
    }

    static /* synthetic */ int g() {
        return f1002b;
    }

    static /* synthetic */ int h() {
        return c;
    }

    static /* synthetic */ int i() {
        return d;
    }

    static /* synthetic */ int j() {
        return e;
    }

    static /* synthetic */ int k() {
        return f;
    }

    static /* synthetic */ ArrayList l() {
        return h;
    }

    private static native void nativeAsyncFlush(long r0);

    private static native long nativeCreate(int r0, boolean r1, String r2, String r3, int r4, int r5, int r6, String r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, int r16, String r17, boolean r18, long r19);

    private static native void nativeDestroy(long r0);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeInitFuncAddr();

    private static native long nativeGetNativeWriteAsyncFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    static native void nativeSetDefaultInstance(long r0);

    private static native void nativeSetLevel(long r0, int r2);

    private static native void nativeSetSyslog(long r0, boolean r2);

    private static native void nativeSyncFlush(long r0);

    private static native void nativeTimedSyncFlush(long r0, int r2);

    private static native void nativeWrite(long r0, int r2, String r3, String r4);

    private static native void nativeWriteAsyncMsg(long r0, int r2, String r3, String r4, long r5, long r7);

    public void a() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.r == 0) goto L6;
        this.j = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        this.k = 6;     // Catch: Throwable -> L8
        nativeDestroy(this.r);     // Catch: Throwable -> L8
        this.r = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void a(int r5, String r6, String r7) {
        if (this.r != 0) goto L5;
        return;
    L5:
        if (r5 < this.k) goto L21;
        if (r6 == null) goto L22;
        if (r7 != null) goto L9;
        return;
    L9:
        if (g == null) goto L17;
        e r0 = new e(r5, r6, r7);
        Iterator<c> r8 = g.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r0 = ((c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.memorydata.plugin")).a(r0);
        goto L12
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        nativeWrite(this.r, r0.f1010a, r0.f1011b, r0.c);
        return;
    L17:
        nativeWrite(this.r, r5, r6, r7);
        return;
    L22:
        return;
    }

    public void a(int r13, String r14, String r15, long r16, long r18) {
        if (this.r != 0) goto L5;
        return;
    L5:
        if (r13 < this.k) goto L21;
        if (r14 == null) goto L22;
        if (r15 != null) goto L9;
        return;
    L9:
        if (g == null) goto L17;
        e r1 = new e(r13, r14, r15);
        Iterator<c> r2 = g.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r1 = ((c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin")).a(r1);
        goto L12
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.r, r1.f1010a, r1.f1011b, r1.c, r16, r18);
        return;
    L17:
        nativeWriteAsyncMsg(this.r, r13, r14, r15, r16, r18);
        return;
    L22:
        return;
    }

    public void a(String r2, String r3) {
        a(0, r2, r3);
    }

    public void a(boolean r5) {
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeSetSyslog(r0, r5);
        return;
    }

    public File[] a(String r8, String r9, long r10, long r12) {
        return com.bytedance.android.alog.a.a(this.l, r8, r9, r10, r12);
    }

    public void b() {
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeAsyncFlush(r0);
        return;
    }

    public void b(String r2, String r3) {
        a(1, r2, r3);
    }

    public void c() {
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeSyncFlush(r0);
        return;
    }

    public void c(String r2, String r3) {
        a(2, r2, r3);
    }

    public long d() {
        if (this.r != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public void d(String r2, String r3) {
        a(3, r2, r3);
    }

    public long e() {
        return this.r;
    }

    public void e(String r2, String r3) {
        a(4, r2, r3);
    }

    public void finalize() {
        super.finalize();     // Catch: Throwable -> L5
        a();
        return;
    L5:
        th = move-exception;
        a();
        throw th;
    }
}
