package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
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
    private static final String libName = "alog";
    private static volatile List<IMessageInterceptor> sMessageInterceptors;
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
        private static final /* synthetic */ AsymCrypt[] $VALUES = null;
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;
        private final int value;

        static {
            AsymCrypt r10 = new AsymCrypt("NONE", 0, 0);
            NONE = r10;
            AsymCrypt r11 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r11;
            AsymCrypt r12 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r12;
            $VALUES = new AsymCrypt[]{r10, r11, r12};
        }

        private AsymCrypt(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static AsymCrypt valueOf(String r10) {
            return (AsymCrypt) Enum.valueOf(AsymCrypt.class, r10);
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) $VALUES.clone();
        }

        int getValue() {
            return this.value;
        }
    }

    public static class Builder {
        private String appVersion;
        private int asymCrypt;
        private String cacheFileDir;
        private int cacheFileSizeEach;
        private int cacheFileSizeTotal;
        private int compress;
        private Context ctx;
        private String instanceName;
        private int level;
        private String logFileDir;
        private int logFileExpDays;
        private int logFileSizeEach;
        private int logFileSizeTotal;
        private int mode;
        private int prefixFormat;
        private String serverPublicKey;
        private int symCrypt;
        private boolean syslog;
        private int timeFormat;

        public Builder(Context r10) {
            this.level = 0;
            this.syslog = false;
            this.instanceName = null;
            this.logFileDir = null;
            this.logFileSizeEach = 2097152;
            this.logFileSizeTotal = Alog.defaultLogFileSizeTotal;
            this.logFileExpDays = 7;
            this.cacheFileDir = null;
            this.cacheFileSizeEach = 65536;
            this.cacheFileSizeTotal = 196608;
            this.appVersion = null;
            this.mode = Alog.access$000();
            this.timeFormat = Alog.access$100();
            this.prefixFormat = Alog.access$200();
            this.compress = Alog.access$300();
            this.symCrypt = Alog.access$400();
            this.asymCrypt = Alog.access$500();
            this.serverPublicKey = Alog.defaultServerPublicKey;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L5;
            r10 = r11;
        L5:
            this.ctx = r10;
        }

        public Alog build() {
            if (this.instanceName != null) goto L5;
            this.instanceName = "default";
        L5:
            ArrayList r10 = Alog.access$600();
            monitor-enter(r10);
            Iterator r11 = Alog.access$600().iterator();     // Catch: Throwable -> L37
        L9:
            if (r11.hasNext() == false) goto L14;
            if (((String) r11.next()).equals(this.instanceName) == false) goto L9;
            monitor-exit(r10);     // Catch: Throwable -> L37
            return null;
        L14:
            Alog.access$600().add(this.instanceName);     // Catch: Throwable -> L37
            monitor-exit(r10);     // Catch: Throwable -> L37
            if (this.logFileDir != null) goto L24;
            File r12 = this.ctx.getExternalFilesDir(null);
            if (r12 == null) goto L21;
            String r13 = r12.getPath() + Alog.defaultSubFolder;
        L22:
            this.logFileDir = r13;
            goto L24
        L21:
            r13 = this.ctx.getFilesDir() + Alog.defaultSubFolder;
        L24:
            if (this.cacheFileDir != null) goto L27;
            this.cacheFileDir = this.ctx.getFilesDir() + Alog.defaultSubFolder;
        L27:
            if (this.appVersion != null) goto L29;
            this.appVersion = Util.getAppVersion(this.ctx);
        L29:
            int r14 = (this.cacheFileSizeEach / 4096) * 4096;
            this.cacheFileSizeEach = r14;
            int r15 = (this.cacheFileSizeTotal / 4096) * 4096;
            this.cacheFileSizeTotal = r15;
            if (r14 >= 4096) goto L32;
            this.cacheFileSizeEach = 4096;
        L32:
            int r16 = this.cacheFileSizeEach;
            if (r15 >= (r16 * 2)) goto L36;
            this.cacheFileSizeTotal = r16 * 2;
        L36:
            return new Alog(this.ctx, this.level, this.syslog, this.instanceName, this.logFileDir, this.logFileSizeEach, this.logFileSizeTotal, this.logFileExpDays, this.cacheFileDir, this.cacheFileSizeEach, this.cacheFileSizeTotal, this.appVersion, this.mode, this.timeFormat, this.prefixFormat, this.compress, this.symCrypt, this.asymCrypt, this.serverPublicKey);
        L37:
            th = move-exception;
            throw th;
        }

        public Builder setAppVersion(String r10) {
            this.appVersion = r10;
            return this;
        }

        public Builder setAsymCrypt(AsymCrypt r10) {
            this.asymCrypt = r10.getValue();
            return this;
        }

        public Builder setCacheFileDir(String r10) {
            this.cacheFileDir = r10;
            return this;
        }

        public Builder setCacheFileSizeEach(int r10) {
            this.cacheFileSizeEach = r10;
            return this;
        }

        public Builder setCacheFileSizeTotal(int r10) {
            this.cacheFileSizeTotal = r10;
            return this;
        }

        public Builder setCompress(Compress r10) {
            this.compress = r10.getValue();
            return this;
        }

        public Builder setInstanceName(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L5;
        L13:
            return this;
        L5:
            if (r10.contains("-") == false) goto L8;
            r10 = r10.replace("-", "");
        L8:
            if (r10.contains("_") == false) goto L11;
            r10 = r10.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r10) == true) goto L13;
            this.instanceName = r10;
            goto L13
        }

        public Builder setLevel(int r10) {
            this.level = r10;
            return this;
        }

        public Builder setLogFileDir(String r10) {
            this.logFileDir = r10;
            return this;
        }

        public Builder setLogFileExpDays(int r10) {
            this.logFileExpDays = r10;
            return this;
        }

        public Builder setLogFileSizeEach(int r10) {
            this.logFileSizeEach = r10;
            return this;
        }

        public Builder setLogFileSizeTotal(int r10) {
            this.logFileSizeTotal = r10;
            return this;
        }

        public Builder setMode(Mode r10) {
            this.mode = r10.getValue();
            return this;
        }

        public Builder setPrefixFormat(PrefixFormat r10) {
            this.prefixFormat = r10.getValue();
            return this;
        }

        public Builder setServerPublicKey(String r10) {
            this.serverPublicKey = r10;
            return this;
        }

        public Builder setSymCrypt(SymCrypt r10) {
            this.symCrypt = r10.getValue();
            return this;
        }

        public Builder setSyslog(boolean r10) {
            this.syslog = r10;
            return this;
        }

        public Builder setTimeFormat(TimeFormat r10) {
            this.timeFormat = r10.getValue();
            return this;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        private static final /* synthetic */ Compress[] $VALUES = null;
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;
        private final int value;

        static {
            Compress r10 = new Compress("NONE", 0, 0);
            NONE = r10;
            Compress r11 = new Compress("ZLIB", 1, 1);
            ZLIB = r11;
            Compress r12 = new Compress("ZSTD", 2, 2);
            ZSTD = r12;
            $VALUES = new Compress[]{r10, r11, r12};
        }

        private Compress(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Compress valueOf(String r10) {
            return (Compress) Enum.valueOf(Compress.class, r10);
        }

        public static Compress[] values() {
            return (Compress[]) $VALUES.clone();
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
            Mode r10 = new Mode("SPEED", 0, 0);
            SPEED = r10;
            Mode r11 = new Mode("SAFE", 1, 1);
            SAFE = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
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
            PrefixFormat r10 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r10;
            PrefixFormat r11 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r11;
            $VALUES = new PrefixFormat[]{r10, r11};
        }

        private PrefixFormat(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static PrefixFormat valueOf(String r10) {
            return (PrefixFormat) Enum.valueOf(PrefixFormat.class, r10);
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) $VALUES.clone();
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
            SymCrypt r10 = new SymCrypt("NONE", 0, 0);
            NONE = r10;
            SymCrypt r11 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r11;
            SymCrypt r12 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r12;
            SymCrypt r13 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r13;
            $VALUES = new SymCrypt[]{r10, r11, r12, r13};
        }

        private SymCrypt(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static SymCrypt valueOf(String r10) {
            return (SymCrypt) Enum.valueOf(SymCrypt.class, r10);
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) $VALUES.clone();
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
            TimeFormat r10 = new TimeFormat("RAW", 0, 0);
            RAW = r10;
            TimeFormat r11 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r11;
            $VALUES = new TimeFormat[]{r10, r11};
        }

        private TimeFormat(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static TimeFormat valueOf(String r10) {
            return (TimeFormat) Enum.valueOf(TimeFormat.class, r10);
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) $VALUES.clone();
        }

        int getValue() {
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

    static /* synthetic */ int access$000() {
        return defaultMode;
    }

    static /* synthetic */ int access$100() {
        return defaultTimeFormat;
    }

    static /* synthetic */ int access$200() {
        return defaultPrefixFormat;
    }

    static /* synthetic */ int access$300() {
        return defaultCompress;
    }

    static /* synthetic */ int access$400() {
        return defaultSymCrypt;
    }

    static /* synthetic */ int access$500() {
        return defaultAsymCrypt;
    }

    static /* synthetic */ ArrayList access$600() {
        return instanceNames;
    }

    public static void addMessageInterceptor(IMessageInterceptor r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (sMessageInterceptors != null) goto L8;
        sMessageInterceptors = new CopyOnWriteArrayList();
    L8:
        if (sMessageInterceptors.contains(r10) == true) goto L11;
        sMessageInterceptors.add(r10);
        return;
    }

    public static File[] getLogs(String r10, String r11, String r12, long r13, long r14) {
        return FileManager.getLogs(r10, r11, r12, r13, r14);
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

    public static synchronized void init(ILibLoader r10) {
        monitor-enter(Alog.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r10 != null) goto L10;
        System.loadLibrary(libName);     // Catch: Throwable -> L14
    L11:
        inited = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r10.loadLibrary(libName);     // Catch: Throwable -> L14
        goto L11
    }

    private static native void nativeAsyncFlush(long r10);

    private static native long nativeCreate(int r10, boolean r11, String r12, String r13, int r14, int r15, int r16, String r17, int r18, int r19, String r110, int r111, int r112, int r113, int r114, int r115, int r116, String r117);

    private static native void nativeDestroy(long r10);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    static native void nativeSetDefaultInstance(long r10);

    private static native void nativeSetLevel(long r10, int r11);

    private static native void nativeSetSyslog(long r10, boolean r11);

    private static native void nativeSyncFlush(long r10);

    private static native void nativeTimedSyncFlush(long r10, int r11);

    private static native void nativeWrite(long r10, int r11, String r12, String r13);

    private static native void nativeWriteAsyncMsg(long r10, int r11, String r12, String r13, long r14, long r15);

    public static void removeMessageInterceptor(IMessageInterceptor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (sMessageInterceptors == null) goto L9;
        sMessageInterceptors.remove(r10);
        return;
    }

    public void asyncFlush() {
        long r10 = this.ref;
        if (r10 == 0) goto L6;
        nativeAsyncFlush(r10);
        return;
    }

    public void close() {
        monitor-enter(this);
        long r10 = this.ref;     // Catch: Throwable -> L8
        if (r10 == 0) goto L6;
        this.ctx = null;     // Catch: Throwable -> L8
        this.level = 6;     // Catch: Throwable -> L8
        nativeDestroy(r10);     // Catch: Throwable -> L8
        this.ref = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void d(String r10, String r11) {
        write(1, r10, r11);
    }

    public void e(String r10, String r11) {
        write(4, r10, r11);
    }

    public void f(String r10, String r11) {
        write(5, r10, r11);
    }

    public void finalize() {
        super.finalize();     // Catch: Throwable -> L5
        close();
        return;
    L5:
        th = move-exception;
        close();
        throw th;
    }

    public HashMap<String, String> getLastFetchErrorInfo() {
        return FileManager.getLastErrorInfo();
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
        String r12 = Util.getProcessName(this.ctx);
        this.processName = r12;
        if (r12 != null) goto L9;
        return new File[0];
    L9:
        return FileManager.getLogs(this.logFileDir, this.processName, this.instanceName, r10, r11);
    }

    public File[] getLogs(String r10, long r11, long r12) {
        return getLogs(r10, this.instanceName, r11, r12);
    }

    public File[] getLogs(String r10, String r11, long r12, long r13) {
        return FileManager.getLogs(this.logFileDir, r10, r11, r12, r13);
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
        this.processName = Util.getProcessName(this.ctx);
    L9:
        String r10 = this.processName;
        if (r10 != null) goto L13;
        return "get process name failed";
    L13:
        String r11 = r10.replace(':', '-');
        File r12 = new File(this.cacheFileDir);
        if (r12.exists() == true) goto L17;
        return "cache dir not exists";
    L17:
        File[] r13 = r12.listFiles();
        if (r13 != null) goto L21;
        return "cache dir is empty";
    L21:
        String r14 = r11 + "__" + this.instanceName + ".alog.cache.guard";
        Pattern r15 = Pattern.compile("^" + Pattern.quote(r11) + "__" + Pattern.quote(this.instanceName) + "__\\d{5}\\.alog\\.cache$");
        int r16 = r13.length;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
        int r111 = 0;
    L22:
        if (r17 >= r16) goto L39;
        File r112 = r13[r17];
        if (r112.getName().equals(r14) == false) goto L30;
        r18 = r18 + 1;
        if (r112.length() < 24576) goto L28;
        r19 = r19 + 1;
    L28:
        File[] r113 = r13;
    L29:
        Pattern r114 = r15;
        int r115 = r16;
    L37:
        r17 = r17 + 1;
        r15 = r114;
        r13 = r113;
        r16 = r115;
        goto L22
    L30:
        String r116 = r112.getName();
        StringBuilder r117 = new StringBuilder();
        r117.append(r11);
        r117.append("__");
        r113 = r13;
        r117.append(this.instanceName);
        r117.append("__");
        if (r116.startsWith(r117.toString()) == false) goto L29;
        if (r15.matcher(r112.getName()).find() == false) goto L29;
        r110 = r110 + 1;
        r114 = r15;
        r115 = r16;
        if (r112.length() < this.cacheFileSizeEach) goto L37;
        r111 = r111 + 1;
        goto L37
    L39:
        if (r18 >= 1) goto L42;
        android.util.Log.d("alog_trace", r14);
        android.util.Log.d("alog_trace", r12.getAbsolutePath());
        return "cache guard not exists";
    L42:
        if (r19 >= 1) goto L45;
        return "cache guard size insufficiently";
    L45:
        int r20 = this.cacheFileCount;
        if (r110 >= r20) goto L49;
        return "cache block count insufficiently";
    L49:
        if (r111 >= r20) goto L52;
        return "cache block size insufficiently";
    L52:
        File r21 = new File(this.logFileDir);
        if (r21.exists() == true) goto L56;
        return "log dir not exists";
    L56:
        final Pattern r22 = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(r11) + "__" + Pattern.quote(this.instanceName) + "\\.alog\\.hot$");
        File[] r23 = r21.listFiles(new AnonymousClass1(this, r22));
        if (r23 != null) goto L59;
        return "no log file for current process and instance";
    L59:
        if (r23.length == 0) goto L69;
        return "OK";
    L69:
        return "no log file for current process and instance";
    }

    public void i(String r10, String r11) {
        write(2, r10, r11);
    }

    public void setLevel(int r10) {
        this.level = r10;
        long r11 = this.ref;
        if (r11 == 0) goto L6;
        nativeSetLevel(r11, r10);
        return;
    }

    public void setSyslog(boolean r10) {
        long r11 = this.ref;
        if (r11 == 0) goto L6;
        nativeSetSyslog(r11, r10);
        return;
    }

    public void syncFlush() {
        long r10 = this.ref;
        if (r10 == 0) goto L6;
        nativeSyncFlush(r10);
        return;
    }

    public void timedSyncFlush(int r10) {
        long r11 = this.ref;
        if (r11 == 0) goto L6;
        nativeTimedSyncFlush(r11, r10);
        return;
    }

    public void v(String r10, String r11) {
        write(0, r10, r11);
    }

    public void w(String r10, String r11) {
        write(3, r10, r11);
    }

    public void write(int r10, String r11, String r12) {
        if (this.ref != 0) goto L5;
        return;
    L5:
        if (r10 < this.level) goto L21;
        if (r11 == null) goto L22;
        if (r12 != null) goto L9;
        return;
    L9:
        if (sMessageInterceptors == null) goto L17;
        MsgInfo r13 = new MsgInfo(r10, r11, r12);
        Iterator<IMessageInterceptor> r14 = sMessageInterceptors.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r13 = r14.next().intercept(r13);
        goto L12
    L14:
        if (r13 != null) goto L16;
        return;
    L16:
        nativeWrite(this.ref, r13.level, r13.tag, r13.msg);
        return;
    L17:
        nativeWrite(this.ref, r10, r11, r12);
        return;
    L22:
        return;
    }

    public void writeAsyncMsg(int r13, String r14, String r15, long r16, long r18) {
        if (this.ref != 0) goto L5;
        return;
    L5:
        if (r13 < this.level) goto L21;
        if (r14 == null) goto L22;
        if (r15 != null) goto L9;
        return;
    L9:
        if (sMessageInterceptors == null) goto L17;
        MsgInfo r10 = new MsgInfo(r13, r14, r15);
        Iterator<IMessageInterceptor> r11 = sMessageInterceptors.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r10 = r11.next().intercept(r10);
        goto L12
    L14:
        if (r10 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.ref, r10.level, r10.tag, r10.msg, r16, r18);
        return;
    L17:
        nativeWriteAsyncMsg(this.ref, r13, r14, r15, r16, r18);
        return;
    L22:
        return;
    }
}
