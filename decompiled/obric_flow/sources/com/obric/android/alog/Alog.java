package com.obric.android.alog;

import ai.j0;
import android.content.Context;
import android.util.Log;
import androidx.room.solver.CodeGenScope;
import com.obric.android.agilelogger.ALog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import m.f0;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
public class Alog {
    static final long INVALID_NATIVE_REF = 0;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_SILENT = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final int defaultAsymCrypt = 0;
    private static final int defaultCacheFileSizeEach = 65536;
    private static final int defaultCacheFileSizeTotal = 196608;
    private static final int defaultCompress = 0;
    private static final String defaultInstanceName = "default";
    private static final int defaultLevel = 0;
    private static final int defaultLogFileExpDays = 7;
    private static final int defaultLogFileSizeEach = 2097152;
    private static final int defaultLogFileSizeTotal = 20971520;
    private static final int defaultMode = 0;
    private static final int defaultPrefixFormat = 0;
    private static final String defaultServerPublicKey = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
    private static final String defaultSubFolder = "/alog";
    private static final int defaultSymCrypt = 0;
    private static final boolean defaultSyslog = false;
    private static final int defaultTimeFormat = 0;
    private static boolean inited = false;
    private static final ArrayList<String> instanceNames = null;
    private static final String libName = "oalog";
    private static volatile List<e> sMessageInterceptors;
    private int cacheFileCount;
    private String cacheFileDir;
    private int cacheFileSizeEach;
    private Context ctx;
    private String instanceName;
    private int level;
    private String logFileDir;
    private String processName;
    private long ref;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AsymCrypt[] f11221a = null;
        private final int value;

        static {
            AsymCrypt r5 = new AsymCrypt("NONE", 0, 0);
            NONE = r5;
            AsymCrypt r10 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r10;
            AsymCrypt r11 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r11;
            f11221a = new AsymCrypt[]{r5, r10, r11};
        }

        public AsymCrypt(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static AsymCrypt valueOf(String r5) {
            return (AsymCrypt) Enum.valueOf(AsymCrypt.class, r5);
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) f11221a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Compress[] f11222a = null;
        private final int value;

        static {
            Compress r5 = new Compress("NONE", 0, 0);
            NONE = r5;
            Compress r10 = new Compress("ZLIB", 1, 1);
            ZLIB = r10;
            Compress r11 = new Compress("ZSTD", 2, 2);
            ZSTD = r11;
            f11222a = new Compress[]{r5, r10, r11};
        }

        public Compress(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Compress valueOf(String r5) {
            return (Compress) Enum.valueOf(Compress.class, r5);
        }

        public static Compress[] values() {
            return (Compress[]) f11222a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f11223a = null;
        private final int value;

        static {
            Mode r5 = new Mode("SPEED", 0, 0);
            SPEED = r5;
            Mode r10 = new Mode("SAFE", 1, 1);
            SAFE = r10;
            f11223a = new Mode[]{r5, r10};
        }

        public Mode(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Mode valueOf(String r5) {
            return (Mode) Enum.valueOf(Mode.class, r5);
        }

        public static Mode[] values() {
            return (Mode[]) f11223a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrefixFormat[] f11224a = null;
        private final int value;

        static {
            PrefixFormat r5 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r5;
            PrefixFormat r10 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r10;
            f11224a = new PrefixFormat[]{r5, r10};
        }

        public PrefixFormat(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static PrefixFormat valueOf(String r5) {
            return (PrefixFormat) Enum.valueOf(PrefixFormat.class, r5);
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) f11224a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SymCrypt[] f11225a = null;
        private final int value;

        static {
            SymCrypt r5 = new SymCrypt("NONE", 0, 0);
            NONE = r5;
            SymCrypt r10 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r10;
            SymCrypt r11 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r11;
            SymCrypt r12 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r12;
            f11225a = new SymCrypt[]{r5, r10, r11, r12};
        }

        public SymCrypt(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static SymCrypt valueOf(String r5) {
            return (SymCrypt) Enum.valueOf(SymCrypt.class, r5);
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) f11225a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeFormat[] f11226a = null;
        private final int value;

        static {
            TimeFormat r5 = new TimeFormat("RAW", 0);
            RAW = r5;
            TimeFormat r10 = new TimeFormat("ISO_8601", 1);
            ISO_8601 = r10;
            f11226a = new TimeFormat[]{r5, r10};
        }

        public TimeFormat(String r5, int r10) {
            super(r5, r10);
            this.value = 1;
        }

        public static TimeFormat valueOf(String r5) {
            return (TimeFormat) Enum.valueOf(TimeFormat.class, r5);
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) f11226a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        defaultMode = Mode.SAFE.getValue();
        defaultTimeFormat = TimeFormat.RAW.getValue();
        defaultPrefixFormat = PrefixFormat.DEFAULT.getValue();
        defaultCompress = Compress.ZSTD.getValue();
        defaultSymCrypt = SymCrypt.TEA_16.getValue();
        defaultAsymCrypt = AsymCrypt.EC_SECP256K1.getValue();
        sMessageInterceptors = null;
        instanceNames = new ArrayList();
        inited = false;
    }

    public Alog(Context r10, int r11, boolean r12, String r13, String r14, int r15, int r16, int r17, String r18, int r19, int r110, String r111, int r112, int r20, int r21, int r22, int r23, int r24, String r25) {
        this.ctx = r10;
        this.level = r11;
        this.logFileDir = r14;
        this.cacheFileDir = r18;
        this.cacheFileSizeEach = r19;
        this.cacheFileCount = r110 / r19;
        this.processName = null;
        this.instanceName = r13;
        this.ref = nativeCreate(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ int access$000() {
        return defaultMode;
    }

    public static /* synthetic */ int access$100() {
        return defaultTimeFormat;
    }

    public static /* synthetic */ int access$200() {
        return defaultPrefixFormat;
    }

    public static /* synthetic */ int access$300() {
        return defaultCompress;
    }

    public static /* synthetic */ int access$400() {
        return defaultSymCrypt;
    }

    public static /* synthetic */ int access$500() {
        return defaultAsymCrypt;
    }

    public static /* synthetic */ ArrayList access$600() {
        return instanceNames;
    }

    public static void addMessageInterceptor(e r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (sMessageInterceptors != null) goto L8;
        sMessageInterceptors = new CopyOnWriteArrayList();
    L8:
        if (sMessageInterceptors.contains(r5) == true) goto L11;
        sMessageInterceptors.add(r5);
        return;
    }

    public static synchronized void init() {
        monitor-enter(Alog.class);
        init(null);     // Catch: Throwable -> L8
        monitor-exit(Alog.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static native void nativeAsyncFlush(long r5);

    private static native long nativeCreate(int r5, boolean r10, String r11, String r12, int r13, int r14, int r15, String r16, int r17, int r18, String r19, int r110, int r111, int r112, int r113, int r114, int r115, String r116);

    private static native void nativeDestroy(long r5);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    public static native void nativeSetDefaultInstance(long r5);

    private static native void nativeSetLevel(long r5, int r10);

    private static native void nativeSetSyslog(long r5, boolean r10);

    private static native void nativeSyncFlush(long r5);

    private static native void nativeTimedSyncFlush(long r5, int r10);

    private static native void nativeWrite(long r5, int r10, String r11, String r12);

    private static native void nativeWriteAsyncMsg(long r5, int r10, String r11, String r12, long r13, long r14);

    public static void removeMessageInterceptor(e r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (sMessageInterceptors == null) goto L9;
        sMessageInterceptors.remove(r5);
        return;
    }

    public void asyncFlush() {
        long r5 = this.ref;
        if (r5 == 0) goto L6;
        nativeAsyncFlush(r5);
        return;
    }

    public void close() {
        monitor-enter(this);
        long r5 = this.ref;     // Catch: Throwable -> L6
        if (r5 == 0) goto L8;
        this.ctx = null;     // Catch: Throwable -> L6
        this.level = 6;     // Catch: Throwable -> L6
        nativeDestroy(r5);     // Catch: Throwable -> L6
        this.ref = 0;     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void d(String r5, String r10) {
        write(1, r5, r10);
    }

    public void e(String r5, String r10) {
        write(4, r5, r10);
    }

    public void f(String r5, String r10) {
        write(5, r5, r10);
    }

    public void finalize() throws Throwable {
        super.finalize();     // Catch: Throwable -> L5
        close();
        return;
    L5:
        th = move-exception;
        close();
        throw th;
    }

    public HashMap<String, String> getLastFetchErrorInfo() {
        HashMap<String, String> r5 = new HashMap();
        r5.put("start", Long.toString(f0.f19876b));
        r5.put("end", Long.toString(f0.f19877c));
        r5.put("reason", f0.e);
        if (f0.d == null) goto L12;
        StringBuilder r10 = new StringBuilder();
        Iterator r11 = f0.d.iterator();
    L6:
        if (r11.hasNext() == false) goto L11;
        String r12 = (String) r11.next();
        if (r12.endsWith(".olog") == false) goto L10;
        r12 = androidx.constraintlayout.motion.widget.a.n(r12, 5, 0);
    L10:
        r10.append(r12);
        r10.append(";");
        goto L6
    L11:
        r5.put("file", r10.toString());
    L12:
        f0.e = null;
        f0.d = null;
        return r5;
    }

    public long getLegacyFlushFuncAddr() {
        if (this.ref != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyFlushFuncAddr();
    }

    public long getLegacyGetLogFileDirFuncAddr() {
        if (this.ref != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyGetLogFileDirFuncAddr();
    }

    public long getLegacyWriteFuncAddr() {
        if (this.ref != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public File[] getLogs(long r10, long r11) {
        if (this.processName != null) goto L9;
        String r5 = j.i();
        this.processName = r5;
        if (r5 != null) goto L9;
        return new File[0];
    L9:
        return f0.m(this.logFileDir, this.processName, this.instanceName, r10, r11);
    }

    public long getNativeRef() {
        return this.ref;
    }

    public long getNativeWriteFuncAddr() {
        if (this.ref != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeWriteFuncAddr();
    }

    public String getStatus() {
        if (inited == true) goto L7;
        return "not inited";
    L7:
        if (this.processName != null) goto L9;
        this.processName = j.i();
    L9:
        String r5 = this.processName;
        if (r5 != null) goto L13;
        return "get process name failed";
    L13:
        String r10 = r5.replace(':', '-');
        File r11 = new File(this.cacheFileDir);
        if (r11.exists() == true) goto L17;
        return "cache dir not exists";
    L17:
        File[] r12 = r11.listFiles();
        if (r12 != null) goto L21;
        return "cache dir is empty";
    L21:
        String r13 = j0.q(j0.w(r10, CodeGenScope.CLASS_PROPERTY_PREFIX), this.instanceName, ".alog.cache.guard");
        Pattern r14 = Pattern.compile("^" + Pattern.quote(r10) + CodeGenScope.CLASS_PROPERTY_PREFIX + Pattern.quote(this.instanceName) + "__\\d{5}\\.alog\\.cache$");
        int r15 = r12.length;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
    L22:
        if (r16 >= r15) goto L39;
        File r111 = r12[r16];
        if (r111.getName().equals(r13) == false) goto L30;
        r17 = r17 + 1;
        if (r111.length() < 24576) goto L28;
        r18 = r18 + 1;
    L28:
        File[] r112 = r12;
    L29:
        Pattern r113 = r14;
        int r114 = r15;
    L37:
        r16 = r16 + 1;
        r14 = r113;
        r12 = r112;
        r15 = r114;
        goto L22
    L30:
        String r115 = r111.getName();
        StringBuilder r116 = j0.w(r10, CodeGenScope.CLASS_PROPERTY_PREFIX);
        r112 = r12;
        r116.append(this.instanceName);
        r116.append(CodeGenScope.CLASS_PROPERTY_PREFIX);
        if (r115.startsWith(r116.toString()) == false) goto L29;
        if (r14.matcher(r111.getName()).find() == false) goto L29;
        r19 = r19 + 1;
        r113 = r14;
        r114 = r15;
        if (r111.length() < this.cacheFileSizeEach) goto L37;
        r110 = r110 + 1;
        goto L37
    L39:
        if (r17 >= 1) goto L42;
        Log.d("alog_trace", r13);
        Log.d("alog_trace", r11.getAbsolutePath());
        return "cache guard not exists";
    L42:
        if (r18 >= 1) goto L45;
        return "cache guard size insufficiently";
    L45:
        int r20 = this.cacheFileCount;
        if (r19 >= r20) goto L49;
        return "cache block count insufficiently";
    L49:
        if (r110 >= r20) goto L52;
        return "cache block size insufficiently";
    L52:
        File r21 = new File(this.logFileDir);
        if (r21.exists() == true) goto L56;
        return "log dir not exists";
    L56:
        File[] r22 = r21.listFiles(new a(this, Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(r10) + CodeGenScope.CLASS_PROPERTY_PREFIX + Pattern.quote(this.instanceName) + "\\.alog\\.hot$")));
        if (r22 != null) goto L59;
        return "no log file for current process and instance";
    L59:
        if (r22.length == 0) goto L69;
        return "OK";
    L69:
        return "no log file for current process and instance";
    }

    public void i(String r5, String r10) {
        write(2, r5, r10);
    }

    public void setLevel(int r5) {
        this.level = r5;
        long r10 = this.ref;
        if (r10 == 0) goto L6;
        nativeSetLevel(r10, r5);
        return;
    }

    public void setSyslog(boolean r5) {
        long r10 = this.ref;
        if (r10 == 0) goto L6;
        nativeSetSyslog(r10, r5);
        return;
    }

    public void syncFlush() {
        long r5 = this.ref;
        if (r5 == 0) goto L6;
        nativeSyncFlush(r5);
        return;
    }

    public void timedSyncFlush(int r5) {
        long r10 = this.ref;
        if (r10 == 0) goto L6;
        nativeTimedSyncFlush(r10, r5);
        return;
    }

    public void v(String r5, String r10) {
        write(0, r5, r10);
    }

    public void w(String r5, String r10) {
        write(3, r5, r10);
    }

    public void write(int r5, String r10, String r11) {
        if (this.ref != 0) goto L5;
        return;
    L5:
        if (r5 < this.level) goto L18;
        if (r10 == null) goto L19;
        if (r11 != null) goto L9;
        return;
    L9:
        if (sMessageInterceptors == null) goto L15;
        Iterator<e> r12 = sMessageInterceptors.iterator();
        if (r12.hasNext() == true) goto L13;
        nativeWrite(this.ref, r5, r10, r11);
        return;
    L13:
        j0.A(r12.next());
        throw null;
    L15:
        nativeWrite(this.ref, r5, r10, r11);
        return;
    L19:
        return;
    }

    public void writeAsyncMsg(int r12, String r13, String r14, long r15, long r17) {
        if (this.ref != 0) goto L5;
        return;
    L5:
        if (r12 < this.level) goto L18;
        if (r13 == null) goto L19;
        if (r14 != null) goto L9;
        return;
    L9:
        if (sMessageInterceptors == null) goto L15;
        Iterator<e> r5 = sMessageInterceptors.iterator();
        if (r5.hasNext() == true) goto L13;
        nativeWriteAsyncMsg(this.ref, r12, r13, r14, r15, r17);
        return;
    L13:
        j0.A(r5.next());
        throw null;
    L15:
        nativeWriteAsyncMsg(this.ref, r12, r13, r14, r15, r17);
        return;
    L19:
        return;
    }

    public static synchronized void init(d r5) {
        monitor-enter(Alog.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r5 != null) goto L23;
        System.loadLibrary(libName);     // Catch: Throwable -> L10
    L16:
        inited = true;     // Catch: Throwable -> L10
        monitor-exit(Alog.class);
        return;
    L23:
        io.reactivex.exceptions.a.p(ALog.sConfig.f21981a, libName);     // Catch: Throwable -> L15
    L15:
        System.loadLibrary(libName);     // Catch: Throwable -> L10
        goto L16
    }

    public File[] getLogs(String r10, long r11, long r12) {
        return getLogs(r10, this.instanceName, r11, r12);
    }

    public File[] getLogs(String r10, String r11, long r12, long r13) {
        return f0.m(this.logFileDir, r10, r11, r12, r13);
    }

    public static File[] getLogs(String r5, String r10, String r11, long r12, long r13) {
        return f0.m(r5, r10, r11, r12, r13);
    }
}
