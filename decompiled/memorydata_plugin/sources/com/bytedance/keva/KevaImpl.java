package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
abstract class KevaImpl extends Keva implements Keva.ClearMemory {
    static final Executor sExecutor = null;
    static final KevaMonitor sMonitor = null;
    private static final ConcurrentHashMap<String, HashMap<String, Keva>> sPathRepoMap = null;
    private static final String sPortedSpRepoName = null;
    private static final HashMap<String, Keva> sRepoMap = null;
    private static final File sSharedPrefsDir = null;
    protected int mBigValueAccessIndex;
    private final List<Keva.OnChangeListener> mChangeListeners;
    private List<KevaValueWrapper> mDuplicatedOldWrappers;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    private int mLastClearAccessIndex;
    private final int mMode;
    private final String mName;
    private String mSpecifiedPath;
    volatile HashMap<String, KevaValueWrapper> mValueMap;

    static class KevaValueWrapper {
        int accessIndex;
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        KevaValueWrapper() {
        }
    }

    private static class PortedSpRepoHolder {
        private static final KevaImpl sInstance = null;
        private static final Map<String, ?> sPortedSpMap = null;

        static {
            KevaMultiProcessImpl r0 = new KevaMultiProcessImpl(KevaImpl.access$000(), null, 1);
            sInstance = r0;
            r0.init(true);
            sPortedSpMap = r0.buildNewMap(new HashMap());
        }

        private PortedSpRepoHolder() {
        }

        static /* synthetic */ KevaImpl access$100() {
            return sInstance;
        }

        static /* synthetic */ Map access$300() {
            return sPortedSpMap;
        }
    }

    protected interface PrivateConstants {
        public static final int BLOCK_TYPE_BYTES = 0;
        public static final int BLOCK_TYPE_OBJECT = 4;
        public static final int BLOCK_TYPE_STRING_ARRAY = 3;
        public static final int BLOCK_TYPE_STRING_UTF16 = 2;
        public static final int BLOCK_TYPE_STRING_UTF8 = 1;
        public static final String EMPTY_STRING = "";
        public static final int EXT_TYPE_BYTES = 7;
        public static final int EXT_TYPE_OBJECT = 71;
        public static final int EXT_TYPE_STRING_ARRAY = 55;
        public static final int EXT_TYPE_STRING_UTF16 = 39;
        public static final int EXT_TYPE_STRING_UTF8 = 23;
        public static final String FILES_DIR_NAME = "files";
        public static final String KEVA = "keva";
        public static final String LIB_NAME = "keva";
        public static final String PORTED_SP = "keva_porting_sp";
        public static final int REPORT_VALUE_SIZE_THRESHOLD = 10000;
        public static final String SP_DIR_NAME = "shared_prefs";
        public static final int TYPE_BOOL = 2;
        public static final int TYPE_BYTES = 7;
        public static final int TYPE_DOUBLE = 5;
        public static final int TYPE_FLOAT = 4;
        public static final int TYPE_INT = 1;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_LONG = 3;
        public static final int TYPE_STRING = 6;
    }

    static {
        KevaBuilder r0 = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new HashMap();
        sPathRepoMap = new ConcurrentHashMap();
        Executor r1 = r0.mExecutor;
        Executor r2 = r1;
        if (r1 != null) goto L6;
        int r5 = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
        ThreadPoolExecutor r3 = new ThreadPoolExecutor(r5, r5, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r3.allowCoreThreadTimeOut(true);
        r2 = r3;
    L6:
        sExecutor = r2;
        String r4 = r0.mPortedRepoName;
        if (r4 != null) goto L10;
        r4 = PrivateConstants.PORTED_SP;
    L10:
        sPortedSpRepoName = r4;
        Context r6 = r0.mContext;
        File r7 = r6.getFilesDir();
        if (r7 != null) goto L14;
        r7 = new File(r6.getApplicationInfo().dataDir, PrivateConstants.FILES_DIR_NAME);
    L14:
        if (r7.exists() == true) goto L16;
        r7.mkdirs();
    L16:
        File r8 = r0.mWorkDir;
        if (r8 != null) goto L19;
        r8 = new File(r7, "keva");
    L19:
        sSharedPrefsDir = new File(r7.getParent(), PrivateConstants.SP_DIR_NAME);
        KevaMonitor r9 = r0.mMonitor;
        if (r9 != null) goto L23;
        r9 = new KevaMonitor();
    L23:
        sMonitor = r9;
        r9.logDebug("Keva version: 1.6.11.SHARED.CXXAPI");
        if (r8.exists() == false) goto L26;
    L33:
        r9.loadLibrary("keva");     // Catch: Throwable -> L30
        initialize(r8.getAbsolutePath());     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        KevaMonitor r10 = sMonitor;
        r10.logDebug("fail to load so and init");
        r10.reportThrowable(1, null, null, null, th);
        return;
    L26:
        if (r8.mkdirs() == true) goto L33;
        r9.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + r8.getPath()));
        goto L33
    }

    KevaImpl(String r3, String r4, int r5) {
        this.mValueMap = new HashMap();
        this.mChangeListeners = new ArrayList();
        this.mDuplicatedOldWrappers = new ArrayList();
        boolean r0 = false;
        this.mBigValueAccessIndex = 0;
        this.mLastClearAccessIndex = -1;
        this.mName = r3;
        this.mMode = r5;
        this.mSpecifiedPath = r4;
        if ((r5 & 1) == 0) goto L5;
        r0 = true;
    L5:
        this.mIsMultiProcess = r0;
    }

    static /* synthetic */ String access$000() {
        return sPortedSpRepoName;
    }

    static /* synthetic */ void access$200(KevaImpl r2, Context r3) {
        r2.doPortingFromSp((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ String access$400(KevaImpl r0) {
        return r0.mName;
    }

    private void addMapObjectWhenLoading(String r2, Object r3, long r4, int r6) {
        if ("".equals(r2) == false) goto L5;
        r2 = null;
    L5:
        KevaValueWrapper r0 = new KevaValueWrapper();
        r0.value = r3;
        r0.offset = r4;
        r0.type = r6;
        if (this.mIsMultiProcess == true) goto L8;
        r0.loaded = true;
    L8:
        KevaValueWrapper r5 = (KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.put(r2, r0), KevaValueWrapper.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        List<KevaValueWrapper> r1 = this.mDuplicatedOldWrappers;
        if (r1 == null) goto L15;
        r1.add(r5);
        return;
    L15:
        return;
    }

    static native void checkReportException(long r0);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L14;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L14:
        Iterator<KevaValueWrapper> r0 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L11
    L7:
        if (r0.hasNext() == false) goto L9;
        eraseUnusedChunk(this.mHandle, ((KevaValueWrapper) ZeusTransformUtils.preCheckCast(r0.next(), KevaValueWrapper.class, "com.obric.memorydata.plugin")).offset);     // Catch: Throwable -> L11
        goto L7
    L9:
        this.mDuplicatedOldWrappers = null;     // Catch: Throwable -> L11
        checkReportException(this.mHandle);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private static native void clear(long r0);

    public static void clearOnLowMemory(int r5) {
        ArrayList r0 = new ArrayList();
        HashMap<String, Keva> r1 = sRepoMap;
        monitor-enter(r1);
        r0.addAll(r1.values());     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        Iterator<HashMap<String, Keva>> r2 = sPathRepoMap.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        HashMap r3 = (HashMap) ZeusTransformUtils.preCheckCast(r2.next(), HashMap.class, "com.obric.memorydata.plugin");
        monitor-enter(r3);
        r0.addAll(r3.values());     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Iterator r4 = r0.iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        Keva r6 = (Keva) ZeusTransformUtils.preCheckCast(r4.next(), Keva.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Keva.ClearMemory.class) == false) goto L19;
        ((Keva.ClearMemory) ZeusTransformUtils.preCheckCast(r6, Keva.ClearMemory.class, "com.obric.memorydata.plugin")).clearMemory(r5);
        goto L19
    L23:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private static native boolean delete(String r0);

    private void doLoadRepo(boolean r7) {
        String r0 = this.mSpecifiedPath;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
        long r1 = loadRepo(this.mName, this.mMode, r7);     // Catch: Throwable -> L11
    L5:
        this.mHandle = r1;     // Catch: Throwable -> L11
        cleanUpAfterLoadRepo();     // Catch: Throwable -> L11
        if (r7 == true) goto L16;
        sMonitor.onLoadRepo(this.mName, this.mMode);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L6:
        r1 = loadRepoWithPath(this.mName, r0, this.mMode);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private void doPortingFromSp(Context r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L81:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L8:
        boolean r10 = ZeusTransformUtils.instanceOf(this, KevaMultiProcessImpl.class);     // Catch: Throwable -> L81
        int r1 = -1;
        if (r10 == false) goto L15;
        r1 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L81
        if (isRepoPorted(this.mName) == false) goto L15;
        doLoadRepo(false);     // Catch: Throwable -> L81
        protectPortingInterProcess(this.mName, false, r1);     // Catch: Throwable -> L81
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L15:
        int r13 = r1;
        if (r10 == false) goto L18;
    L20:
        boolean r2 = false;
    L21:
        KevaMonitor r3 = sMonitor;     // Catch: Throwable -> L81
        r3.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L81
        doLoadRepo(false);     // Catch: Throwable -> L81
        if (this.mHandle != 0) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L25:
        if (r2 == true) goto L27;
        clear();     // Catch: Throwable -> L81
    L27:
        SharedPreferences r4 = r0.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L81
        r3.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L81
        Map<String, ?> r5 = r4.getAll();     // Catch: Throwable -> L81
        r3.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L81
        Iterator<Map.Entry<String, ?>> r14 = r5.entrySet().iterator();     // Catch: Throwable -> L81
    L29:
        if (r14.hasNext() == false) goto L75;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L81
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L81
        Object r15 = r6.getValue();     // Catch: Throwable -> L81
        if (r15 == null) goto L29;
        if ("".equals(r7) == false) goto L36;
        r7 = null;
    L36:
        String r8 = r7;
        KevaMonitor r9 = sMonitor;     // Catch: Throwable -> L81
        r9.logDebug("poring process key: " + r8 + ", value: " + r15 + " >> " + this.mName);     // Catch: Throwable -> L81
        KevaValueWrapper r11 = new KevaValueWrapper();     // Catch: Throwable -> L81
        this.mValueMap.put(r8, r11);     // Catch: Throwable -> L81
    L70:
        th = th;
        String r18 = r8;
    L72:
        Throwable r12 = th;
    L73:
        sMonitor.reportThrowable(3, this.mName, r18, r15, r12);     // Catch: Throwable -> L81
        goto L29
    L38:
        if (ZeusTransformUtils.instanceOf(r15, Boolean.class) == false) goto L45;
        r11.offset = storeBoolean(this.mHandle, r8, r11.offset, ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());     // Catch: Throwable -> L42
    L40:
        r11.value = r15;     // Catch: Throwable -> L42
        r18 = r8;
    L84:
        if (this.mIsMultiProcess == true) goto L29;
        r11.loaded = true;     // Catch: Throwable -> L68
    L68:
        th = th;
    L42:
        th = move-exception;
        r12 = th;
        r18 = r8;
        goto L73
    L45:
        if (ZeusTransformUtils.instanceOf(r15, Integer.class) == false) goto L49;
        r11.offset = storeInt(this.mHandle, r8, r11.offset, ((Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L42
        goto L40
    L49:
        if (ZeusTransformUtils.instanceOf(r15, Long.class) == false) goto L54;
        r18 = r8;
        r11.offset = storeLong(this.mHandle, r8, r11.offset, ((Long) ZeusTransformUtils.preCheckCast(r15, Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L68
    L53:
        r11.value = r15;     // Catch: Throwable -> L68
        goto L84
    L54:
        r18 = r8;
        if (ZeusTransformUtils.instanceOf(r15, Float.class) == false) goto L58;
        r11.offset = storeFloat(this.mHandle, r18, r11.offset, ((Float) ZeusTransformUtils.preCheckCast(r15, Float.class, "com.obric.memorydata.plugin")).floatValue());     // Catch: Throwable -> L68
        goto L53
    L58:
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L61;
        r11.offset = storeString(this.mHandle, r18, r11.offset, (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L68
        goto L53
    L61:
        if (ZeusTransformUtils.instanceOf(r15, Set.class) == false) goto L63;
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L68
        String[] r17 = new String[r16.size()];     // Catch: Throwable -> L68
        r16.toArray(r17);     // Catch: Throwable -> L68
        r11.offset = storeStringArray(this.mHandle, r18, r11.offset, r17, 3);     // Catch: Throwable -> L68
        r11.value = r17;     // Catch: Throwable -> L68
        goto L84
    L63:
        r9.reportThrowable(1, this.mName, r18, r15, new IllegalStateException("do not support type: " + r15.getClass()));     // Catch: Throwable -> L68
        goto L84
    L75:
        getPortedSpRepo().storeBoolean(this.mName, true);     // Catch: Throwable -> L81
        if (r10 == false) goto L78;
        protectPortingInterProcess(this.mName, false, r13);     // Catch: Throwable -> L81
    L78:
        monitor-exit(this);     // Catch: Throwable -> L81
        sMonitor.logDebug("poring set ported repo >> " + this.mName);
        return;
    L18:
        if (delete(this.mName) == false) goto L20;
        r2 = true;
        goto L21
    }

    private native void dump(long r1);

    private native void erase(long r1, String r3, long r4);

    private native void eraseUnusedChunk(long r1, long r3);

    private static boolean existSharedPrefs(String r3) {
        return new File(sSharedPrefsDir, r3 + ".xml").exists();
    }

    private Set<String> fetchStringSet(String r4, Set<String> r5, boolean r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(r7.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L6:
        String[] r3 = fetchStringArray(r4, r8, r6);
        if (r3 != null) goto L9;
        return null;
    L9:
        return new HashSet(Arrays.asList(r3));
    L5:
        r8 = null;
        goto L6
    }

    static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    static KevaImpl getEmptyRepoImpl(String r7, String r8, int r9) {
        if (r9 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r7, null, null, new IllegalArgumentException("mode is not valid: " + r9));
    L7:
        if ((r9 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r7, r8, r9);
    L10:
        return new KevaMultiProcessImpl(r7, r8, r9);
    L4:
        if (r9 < 2) goto L7;
        goto L5
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.access$100();
    }

    public static Keva getRepo(String r2, int r3) {
        return getRepoImpl(r2, null, r3, false);
    }

    public static Keva getRepoFromSp(Context r2, String r3, int r4) {
        return getRepoFromSpImpl((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, false);
    }

    private static Keva getRepoFromSpImpl(Context r10, final String r11, final int r12, boolean r13) {
        final Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (isRepoPorted(r11) == true) goto L5;
        boolean r2 = true;
        if (existSharedPrefs(r11) == true) goto L10;
        getPortedSpRepo().storeBoolean(r11, true);
        return getRepo(r11, r12);
    L10:
        sMonitor.logDebug("do poring from sp: " + r11);
        HashMap<String, Keva> r1 = sRepoMap;
        monitor-enter(r1);
        Keva r3 = (Keva) ZeusTransformUtils.preCheckCast(r1.get(r11), Keva.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r3 == null) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L22;
        if (r13 == false) goto L20;
        Keva r15 = getEmptyRepoImpl(r11, null, r12);     // Catch: Throwable -> L35
    L19:
        r3 = r15;
        r1.put(r11, r3);     // Catch: Throwable -> L35
        goto L22
    L20:
        r15 = new KevaFuture(r11, r12, new AnonymousClass2(r11, r12, r14));     // Catch: Throwable -> L35
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L35
        if (r2 == false) goto L31;
        if (ZeusTransformUtils.instanceOf(r3, KevaImpl.class) == true) goto L40;
    L34:
        return r3;
    L40:
        ((KevaImpl) ZeusTransformUtils.preCheckCast(r3, KevaImpl.class, "com.obric.memorydata.plugin")).doPortingFromSp(r14);     // Catch: UnsatisfiedLinkError -> L28
    L28:
        e = move-exception;
        sMonitor.reportThrowable(1, r11, null, null, e);
        goto L34
    L31:
        if (ZeusTransformUtils.instanceOf(r3, KevaImpl.class) == false) goto L33;
        ((KevaImpl) ZeusTransformUtils.preCheckCast(r3, KevaImpl.class, "com.obric.memorydata.plugin")).checkMode(r12);
        goto L34
    L33:
        ((KevaFuture) ZeusTransformUtils.preCheckCast(r3, KevaFuture.class, "com.obric.memorydata.plugin")).checkMode(r12);
    L35:
        th = move-exception;
        throw th;
    L5:
        return getRepo(r11, r12);
    }

    public static Keva getRepoFromSpSync(Context r2, String r3, int r4) {
        return getRepoFromSpImpl((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, true);
    }

    private static Keva getRepoImpl(final String r5, final String r6, final int r7, boolean r8) {
        if (r6 != null) goto L5;
        HashMap<String, Keva> r1 = sRepoMap;
    L6:
        monitor-enter(r1);
        Keva r2 = (Keva) ZeusTransformUtils.preCheckCast(r1.get(r5), Keva.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r2 != null) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L16;
        if (r8 == false) goto L14;
        r2 = getEmptyRepoImpl(r5, r6, r7);     // Catch: Throwable -> L25
    L15:
        r1.put(r5, r2);     // Catch: Throwable -> L25
        goto L16
    L14:
        r2 = new KevaFuture(r5, r7, new AnonymousClass1(r5, r6, r7));     // Catch: Throwable -> L25
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L25
        boolean r9 = ZeusTransformUtils.instanceOf(r2, KevaFuture.class);
        if (r4 == false) goto L21;
        if (r9 == true) goto L24;
        ((KevaImpl) ZeusTransformUtils.preCheckCast(r2, KevaImpl.class, "com.obric.memorydata.plugin")).init(false);
    L24:
        return r2;
    L21:
        if (r9 == true) goto L23;
        ((KevaImpl) ZeusTransformUtils.preCheckCast(r2, KevaImpl.class, "com.obric.memorydata.plugin")).checkMode(r7);
        goto L24
    L23:
        ((KevaFuture) ZeusTransformUtils.preCheckCast(r2, KevaFuture.class, "com.obric.memorydata.plugin")).checkMode(r7);
        goto L24
    L10:
        r4 = false;
    L25:
        th = move-exception;
        throw th;
    L5:
        ConcurrentHashMap<String, HashMap<String, Keva>> r3 = sPathRepoMap;
        r3.putIfAbsent(r6, new HashMap());
        r1 = (HashMap) ZeusTransformUtils.preCheckCast(r3.get(r6), HashMap.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static Keva getRepoSync(String r2, int r3) {
        return getRepoImpl(r2, null, r3, true);
    }

    public static Keva getRepoSyncWithPath(String r2, String r3, int r4) {
        if (r3 == null) goto L12;
        if ("".equals(r3) == true) goto L12;
        if (r3.startsWith("/") == true) goto L12;
        if (r3.endsWith("/") == false) goto L12;
        return getRepoImpl(r2, r3, r4, true);
    L12:
        throw new IllegalArgumentException("path is wrong: " + r3);
    }

    private static native void initialize(String r0);

    public static boolean isRepoPorted(String r2) {
        if (PortedSpRepoHolder.access$300().get(r2) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r2, false);
    }

    private native long loadRepo(String r1, int r2, boolean r3);

    private native long loadRepoWithPath(String r1, String r2, int r3);

    private void notifyChangeListeners(Keva r4, String r5) {
        if (this.mChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Iterator<Keva.OnChangeListener> r3 = this.mChangeListeners.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((Keva.OnChangeListener) ZeusTransformUtils.preCheckCast(r3.next(), Keva.OnChangeListener.class, "com.obric.memorydata.plugin")).onChanged(r4, r5);
        goto L7
    }

    private KevaValueWrapper obtainWrapperLocked(String r4) {
        KevaValueWrapper r0 = (KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.get(r4), KevaValueWrapper.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        KevaValueWrapper r1 = new KevaValueWrapper();
        this.mValueMap.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    static void passWarning(int r6, String r7, String r8, Object r9, String r10) {
        sMonitor.reportWarning(r6, r7, r8, r9, r10);
    }

    private native int protectPortingInterProcess(String r1, boolean r2, int r3);

    private void reportBigValue(final String r3, final Object r4, final int r5) {
        if (r5 <= 10000) goto L6;
        sExecutor.execute(new AnonymousClass3(this, r3, r4, r5));
        return;
    }

    private native long storeBoolean(long r1, String r3, long r4, boolean r6);

    private native long storeBytes(long r1, String r3, long r4, byte[] r6, int r7);

    private void storeBytes(final String r11, byte[] r12, int r13, boolean r14) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r0.offset = storeBytes(this.mHandle, r11, r0.offset, r12, r13);     // Catch: Throwable -> L15
        r0.type = (r13 << 4) | 7;     // Catch: Throwable -> L15
        if (r14 == true) goto L12;
        r0.value = r12;     // Catch: Throwable -> L15
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L15
    L13:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r12 == null) goto L31;
        final int r15 = r12.length;
        if (r15 <= 10000) goto L32;
        sExecutor.execute(new AnonymousClass5(this, r11, r15));
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r0.value = null;     // Catch: Throwable -> L15
        r0.loaded = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, r12, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private native long storeDouble(long r1, String r3, long r4, double r6);

    private native long storeFloat(long r1, String r3, long r4, float r6);

    private native long storeInt(long r1, String r3, long r4, int r6);

    private native long storeLong(long r1, String r3, long r4, long r6);

    private native long storeString(long r1, String r3, long r4, String r6);

    private void storeString(final String r10, final String r11, boolean r12) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L33
        if (this.mIsMultiProcess == false) goto L9;
    L36:
        r0.offset = storeString(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L24
        r0.type = 6;     // Catch: Throwable -> L24
        if (r12 == true) goto L21;
        r0.value = r11;     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L22;
        r0.loaded = true;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r11 == null) goto L39;
        final int r13 = r11.length();
        if (r13 <= 10000) goto L40;
        sExecutor.execute(new AnonymousClass4(this, r10, r11, r13));
        return;
    L40:
        return;
    L39:
        return;
    L21:
        r0.value = null;     // Catch: Throwable -> L24
        r0.loaded = false;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, r11, th);     // Catch: Throwable -> L33
        goto L27
    L9:
        if (r0.loaded == false) goto L36;
        if (r0.value == null) goto L36;
        if (r0.value.equals(r11) == false) goto L36;
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    }

    private native long storeStringArray(long r1, String r3, long r4, String[] r6, int r7);

    private void storeStringArray(final String r11, String[] r12, boolean r13) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r0.offset = storeStringArray(this.mHandle, r11, r0.offset, r12, 3);     // Catch: Throwable -> L15
        r0.type = 55;     // Catch: Throwable -> L15
        if (r13 == true) goto L12;
        r0.value = r12;     // Catch: Throwable -> L15
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L15
    L13:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r12 == null) goto L31;
        final String r14 = Arrays.toString(r12);
        final int r15 = r14.length();
        if (r15 <= 10000) goto L32;
        sExecutor.execute(new AnonymousClass6(this, r11, r14, r15));
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r0.value = null;     // Catch: Throwable -> L15
        r0.loaded = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, null, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private void storeStringSet(String r3, Set<String> r4, boolean r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        String[] r0 = new String[r6.size()];
        r6.toArray(r0);
    L6:
        storeStringArray(r3, r0, r5);
        return;
    L5:
        r0 = null;
        goto L6
    }

    void addMapBoolWhenLoading(String r7, boolean r8, long r9) {
        addMapObjectWhenLoading(r7, Boolean.valueOf(r8), r9, 2);
    }

    void addMapDoubleWhenLoading(String r7, double r8, long r10) {
        addMapObjectWhenLoading(r7, Double.valueOf(r8), r10, 5);
    }

    void addMapFloatWhenLoading(String r7, float r8, long r9) {
        addMapObjectWhenLoading(r7, Float.valueOf(r8), r9, 4);
    }

    void addMapIntWhenLoading(String r7, int r8, long r9) {
        addMapObjectWhenLoading(r7, Integer.valueOf(r8), r9, 1);
    }

    void addMapLongWhenLoading(String r7, long r8, long r10) {
        addMapObjectWhenLoading(r7, Long.valueOf(r8), r10, 3);
    }

    void addMapOffsetWhenLoading(String r2, long r3, int r5) {
        if ("".equals(r2) == false) goto L5;
        r2 = null;
    L5:
        KevaValueWrapper r0 = new KevaValueWrapper();
        r0.offset = r3;
        r0.type = r5;
        KevaValueWrapper r4 = (KevaValueWrapper) ZeusTransformUtils.preCheckCast(this.mValueMap.put(r2, r0), KevaValueWrapper.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        List<KevaValueWrapper> r1 = this.mDuplicatedOldWrappers;
        if (r1 == null) goto L12;
        r1.add(r4);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r15) {
        Map<String, Object> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        Map<String, Object> r0 = KevaConstants.FLAG_CURRENT_KEY_MAP;
        monitor-enter(this);
        if (r16 == r0) goto L63;
        Iterator<Map.Entry<String, KevaValueWrapper>> r1 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L59
    L13:
        if (r1.hasNext() == false) goto L57;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        KevaValueWrapper r3 = (KevaValueWrapper) ZeusTransformUtils.preCheckCast(r2.getValue(), KevaValueWrapper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        if (r3.offset == 0) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
    L54:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r4, Long.valueOf(r3.offset), th);     // Catch: Throwable -> L59
        goto L13
    L19:
        if (r3.loaded == true) goto L46;
        int r5 = r3.type;     // Catch: Throwable -> L54
        if (r5 == 6) goto L41;
        if (r5 != 7) goto L24;
        r3.value = fetchBytes(this.mHandle, r4, r3.offset, null, 0);     // Catch: Throwable -> L54
    L43:
        if (this.mIsMultiProcess == true) goto L46;
        r3.loaded = true;     // Catch: Throwable -> L54
        goto L46
    L24:
        if (r5 == 23) goto L39;
        if (r5 == 39) goto L39;
        if (r5 != 55) goto L30;
        Object r6 = fetchStringArray(this.mHandle, r4, r3.offset, null, 3);     // Catch: Throwable -> L54
    L37:
        r3.value = r6;     // Catch: Throwable -> L54
        goto L43
    L30:
        if (this.mIsMultiProcess == false) goto L35;
        if (r3.type <= 5) goto L43;
    L35:
        throw new UnsupportedOperationException("keva has not implemented type " + r3.type);     // Catch: Throwable -> L54
    L39:
        throw new UnsupportedOperationException("keva has not implemented type " + r3.type);     // Catch: Throwable -> L54
    L41:
        r6 = fetchString(this.mHandle, r4, r3.offset, null);     // Catch: Throwable -> L54
    L46:
        if (this.mIsMultiProcess == false) goto L48;
    L52:
        r16.put(r4, r3.value);     // Catch: Throwable -> L54
        goto L13
    L48:
        if (r3.type != 6) goto L50;
    L51:
        int r7 = this.mBigValueAccessIndex + 1;     // Catch: Throwable -> L54
        this.mBigValueAccessIndex = r7;     // Catch: Throwable -> L54
        r3.accessIndex = r7;     // Catch: Throwable -> L54
        goto L52
    L50:
        if ((r3.type & 7) == 0) goto L52;
    L57:
        monitor-exit(this);     // Catch: Throwable -> L59
        return r16;
    L59:
        th = move-exception;
        throw th;
    L63:
        HashMap r17 = (HashMap) ZeusTransformUtils.preCheckCast(this.mValueMap.clone(), HashMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r17;
    L8:
        th = move-exception;
        throw th;
    }

    void checkMode(int r9) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r9) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r9));
        return;
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        monitor-enter(this);
        this.mValueMap.clear();     // Catch: Throwable -> L5
        clear(this.mHandle);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L5:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, null, null, th);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.keva.Keva.ClearMemory
    public void clearMemory(int r5) {
        if (this.mIsMultiProcess == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r5 != 0) goto L29;
        int r6 = Integer.MAX_VALUE;
    L9:
        Iterator<KevaValueWrapper> r0 = this.mValueMap.values().iterator();     // Catch: Throwable -> L26
    L11:
        if (r0.hasNext() == false) goto L23;
        KevaValueWrapper r1 = (KevaValueWrapper) ZeusTransformUtils.preCheckCast(r0.next(), KevaValueWrapper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L11;
        if (r1.loaded == false) goto L11;
        if (r1.accessIndex > r6) goto L11;
        if (r1.type == 6) goto L22;
        if ((r1.type & 7) != 7) goto L11;
    L22:
        r1.value = null;     // Catch: Throwable -> L26
        r1.loaded = false;     // Catch: Throwable -> L26
        goto L11
    L23:
        this.mLastClearAccessIndex = this.mBigValueAccessIndex;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        r6 = this.mLastClearAccessIndex;     // Catch: Throwable -> L26
        goto L9
    }

    native boolean contains(long r1, String r3, long r4);

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L10
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        KevaValueWrapper r2 = (KevaValueWrapper) ZeusTransformUtils.preCheckCast(r1.getValue(), KevaValueWrapper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        sMonitor.logDebug("key: " + ((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")) + ", value: " + r2.value + ", offset: " + r2.offset + ", loaded: " + r2.loaded);     // Catch: Throwable -> L10
        goto L5
    L7:
        sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void dumpNative() {
        monitor-enter(this);
        dump(this.mHandle);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r9) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r0 = obtainWrapperLocked(r9);     // Catch: Throwable -> L10
        erase(this.mHandle, r9, r0.offset);     // Catch: Throwable -> L10
        r0.value = null;     // Catch: Throwable -> L10
        r0.offset = 0;     // Catch: Throwable -> L10
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, r9, null, th);     // Catch: Throwable -> L15
        goto L13
    }

    native boolean fetchBoolean(long r1, String r3, long r4, boolean r6);

    public abstract boolean fetchBoolean(String r1, boolean r2);

    native byte[] fetchBytes(long r1, String r3, long r4, byte[] r6, int r7);

    public abstract byte[] fetchBytes(String r1, byte[] r2, int r3, boolean r4);

    native double fetchDouble(long r1, String r3, long r4, double r6);

    public abstract double fetchDouble(String r1, double r2);

    native float fetchFloat(long r1, String r3, long r4, float r6);

    public abstract float fetchFloat(String r1, float r2);

    native int fetchInt(long r1, String r3, long r4, int r6);

    public abstract int fetchInt(String r1, int r2);

    native long fetchLong(long r1, String r3, long r4, long r6);

    public abstract long fetchLong(String r1, long r2);

    native String fetchString(long r1, String r3, long r4, String r6);

    public abstract String fetchString(String r1, String r2, boolean r3);

    native String[] fetchStringArray(long r1, String r3, long r4, String[] r6, int r7);

    public abstract String[] fetchStringArray(String r1, String[] r2, boolean r3);

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r7, boolean r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        boolean r9 = fetchBoolean(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, null, th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r7, byte[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        byte[] r9 = fetchBytes(r3, r8, 0, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r7, byte[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        byte[] r9 = fetchBytes(r3, r8, 0, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r7, double r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        double r9 = fetchDouble(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Double.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r7, float r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        float r9 = fetchFloat(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Float.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r7, int r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        int r9 = fetchInt(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Integer.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r7, long r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        long r9 = fetchLong(r3, r8);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r9;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Long.valueOf(r8), th);     // Catch: Throwable -> L10
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r7, String r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String r9 = fetchString(r3, r8, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r7, String[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String[] r9 = fetchStringArray(r3, r8, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r7, String[] r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String[] r9 = fetchStringArray(r3, r8, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r7, String r8) {
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        String r9 = fetchString(r3, r8, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r9;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L11
        return r8;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r7, Set<String> r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        Set<String> r10 = fetchStringSet(r3, r9, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r9, th);     // Catch: Throwable -> L11
        return r9;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r7, Set<String> r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        if ("".equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        Set<String> r10 = fetchStringSet(r3, r9, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r9, th);     // Catch: Throwable -> L11
        return r9;
    }

    void init(boolean r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        doLoadRepo(r5);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    native void rebuildValueMap(long r1);

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r3) {
        Keva.OnChangeListener r4 = (Keva.OnChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Keva.OnChangeListener.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mChangeListeners.contains(r4) == true) goto L7;
        this.mChangeListeners.add(r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r9, boolean r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r9;
        r7.offset = storeBoolean(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Boolean.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r7.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Boolean.valueOf(r10), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r7.loaded == false) goto L29;
        if (r7.value == null) goto L29;
        if (r7.value.equals(Boolean.valueOf(r10)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r2, byte[] r3) {
        storeBytes(r2, r3, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r3, byte[] r4) {
        storeBytes(r3, r4, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r10, double r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r10;
        r8.offset = storeDouble(this.mHandle, r3, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Double.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r10;
        sMonitor.reportThrowable(3, this.mName, r4, Double.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Double.valueOf(r11)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r9, float r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r9;
        r7.offset = storeFloat(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Float.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r7.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Float.valueOf(r10), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r7.loaded == false) goto L29;
        if (r7.value == null) goto L29;
        if (r7.value.equals(Float.valueOf(r10)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r9, int r10) {
        if ("".equals(r9) == false) goto L5;
        r9 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r7 = obtainWrapperLocked(r9);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r9;
        r7.offset = storeInt(this.mHandle, r3, r7.offset, r10);     // Catch: Throwable -> L21
        r7.value = Integer.valueOf(r10);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r7.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r9);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r9;
        sMonitor.reportThrowable(3, this.mName, r4, Integer.valueOf(r10), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r7.loaded == false) goto L29;
        if (r7.value == null) goto L29;
        if (r7.value.equals(Integer.valueOf(r10)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r10, long r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r3 = r10;
        r8.offset = storeLong(this.mHandle, r3, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Long.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r4 = r10;
        sMonitor.reportThrowable(3, this.mName, r4, Long.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Long.valueOf(r11)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r2, String r3) {
        storeString(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r2, String[] r3) {
        storeStringArray(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r2, String[] r3) {
        storeStringArray(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r2, String r3) {
        storeString(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r3, Set<String> r4) {
        storeStringSet(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r3, Set<String> r4) {
        storeStringSet(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), true);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r3) {
        Keva.OnChangeListener r4 = (Keva.OnChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Keva.OnChangeListener.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        this.mChangeListeners.remove(r4);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
