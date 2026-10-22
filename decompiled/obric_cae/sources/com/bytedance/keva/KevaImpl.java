package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import defpackage.a;
import defpackage.b;
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

/* JADX INFO: loaded from: classes.dex */
abstract class KevaImpl extends Keva {
    static final Executor sExecutor = null;
    static final KevaMonitor sMonitor = null;
    private static final ConcurrentHashMap<String, HashMap<String, Keva>> sPathRepoMap = null;
    private static final String sPortedSpRepoName = null;
    private static final HashMap<String, Keva> sRepoMap = null;
    private static final File sSharedPrefsDir = null;
    private final List<Keva.OnChangeListener> mChangeListeners;
    private List<KevaValueWrapper> mDuplicatedOldWrappers;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    private final int mMode;
    private final String mName;
    private String mSpecifiedPath;
    volatile HashMap<String, KevaValueWrapper> mValueMap;

    public static class KevaValueWrapper {
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        public KevaValueWrapper() {
        }
    }

    public static class PortedSpRepoHolder {
        private static final KevaImpl sInstance = null;
        private static final Map<String, ?> sPortedSpMap = null;

        static {
            KevaMultiProcessImpl r8 = new KevaMultiProcessImpl(KevaImpl.access$000(), null, 1);
            sInstance = r8;
            r8.init(true);
            sPortedSpMap = r8.buildNewMap(new HashMap());
        }

        private PortedSpRepoHolder() {
        }

        public static /* synthetic */ KevaImpl access$100() {
            return sInstance;
        }

        public static /* synthetic */ Map access$300() {
            return sPortedSpMap;
        }
    }

    public interface PrivateConstants {
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
        KevaBuilder r8 = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new HashMap();
        sPathRepoMap = new ConcurrentHashMap();
        Executor r10 = r8.mExecutor;
        Executor r11 = r10;
        if (r10 != null) goto L6;
        int r12 = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(r12, r12, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r13.allowCoreThreadTimeOut(true);
        r11 = r13;
    L6:
        sExecutor = r11;
        String r14 = r8.mPortedRepoName;
        if (r14 != null) goto L10;
        r14 = PrivateConstants.PORTED_SP;
    L10:
        sPortedSpRepoName = r14;
        Context r15 = r8.mContext;
        File r16 = r15.getFilesDir();
        if (r16 != null) goto L14;
        r16 = new File(r15.getApplicationInfo().dataDir, PrivateConstants.FILES_DIR_NAME);
    L14:
        if (r16.exists() == true) goto L16;
        r16.mkdirs();
    L16:
        File r17 = r8.mWorkDir;
        if (r17 != null) goto L19;
        r17 = new File(r16, "keva");
    L19:
        sSharedPrefsDir = new File(r16.getParent(), PrivateConstants.SP_DIR_NAME);
        KevaMonitor r18 = r8.mMonitor;
        if (r18 != null) goto L23;
        r18 = new KevaMonitor();
    L23:
        sMonitor = r18;
        r18.logDebug("Keva version: 1.6.10.SHARED");
        if (r17.exists() == false) goto L26;
    L33:
        r18.loadLibrary("keva");     // Catch: Throwable -> L30
        initialize(r17.getAbsolutePath());     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        KevaMonitor r19 = sMonitor;
        r19.logDebug("fail to load so and init");
        r19.reportThrowable(1, null, null, null, th);
        return;
    L26:
        if (r17.mkdirs() == true) goto L33;
        r18.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + r17.getPath()));
        goto L33
    }

    public KevaImpl(String r8, String r10, int r11) {
        this.mValueMap = new HashMap();
        this.mChangeListeners = new ArrayList();
        this.mDuplicatedOldWrappers = new ArrayList();
        this.mName = r8;
        this.mMode = r11;
        this.mSpecifiedPath = r10;
        boolean r12 = true;
        if ((r11 & 1) != 0) goto L6;
        r12 = false;
    L6:
        this.mIsMultiProcess = r12;
    }

    public static /* synthetic */ String access$000() {
        return sPortedSpRepoName;
    }

    public static /* synthetic */ void access$200(KevaImpl r8, Context r10) {
        r8.doPortingFromSp(r10);
    }

    public static /* synthetic */ String access$400(KevaImpl r8) {
        return r8.mName;
    }

    private void addMapObjectWhenLoading(String r8, Object r10, long r11, int r12) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        KevaValueWrapper r13 = new KevaValueWrapper();
        r13.value = r10;
        r13.offset = r11;
        r13.type = r12;
        if (this.mIsMultiProcess == true) goto L8;
        r13.loaded = true;
    L8:
        KevaValueWrapper r14 = this.mValueMap.put(r8, r13);
        if (r14 == null) goto L14;
        List<KevaValueWrapper> r15 = this.mDuplicatedOldWrappers;
        if (r15 == null) goto L15;
        r15.add(r14);
        return;
    L15:
        return;
    }

    public static native void checkReportException(long r8);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L14;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L14:
        Iterator<KevaValueWrapper> r8 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L11
    L7:
        if (r8.hasNext() == false) goto L9;
        eraseUnusedChunk(this.mHandle, r8.next().offset);     // Catch: Throwable -> L11
        goto L7
    L9:
        this.mDuplicatedOldWrappers = null;     // Catch: Throwable -> L11
        checkReportException(this.mHandle);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private static native void clear(long r8);

    private static native boolean delete(String r8);

    private void doLoadRepo(boolean r8) {
        String r10 = this.mSpecifiedPath;     // Catch: Throwable -> L11
        if (r10 != null) goto L6;
        long r11 = loadRepo(this.mName, this.mMode, r8);     // Catch: Throwable -> L11
    L5:
        this.mHandle = r11;     // Catch: Throwable -> L11
        cleanUpAfterLoadRepo();     // Catch: Throwable -> L11
        if (r8 == true) goto L16;
        sMonitor.onLoadRepo(this.mName, this.mMode);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L6:
        r11 = loadRepoWithPath(this.mName, r10, this.mMode);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private void doPortingFromSp(Context r20) {
        monitor-enter(this);
    L81:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L8:
        boolean r10 = this instanceof KevaMultiProcessImpl;     // Catch: Throwable -> L81
        int r8 = -1;
        if (r10 == false) goto L15;
        r8 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L81
        if (isRepoPorted(this.mName) == false) goto L15;
        doLoadRepo(false);     // Catch: Throwable -> L81
        protectPortingInterProcess(this.mName, false, r8);     // Catch: Throwable -> L81
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L15:
        int r13 = r8;
        if (r10 == false) goto L18;
    L20:
        boolean r11 = false;
    L21:
        KevaMonitor r12 = sMonitor;     // Catch: Throwable -> L81
        r12.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L81
        doLoadRepo(false);     // Catch: Throwable -> L81
        if (this.mHandle != 0) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L81
        return;
    L25:
        if (r11 == true) goto L27;
        clear();     // Catch: Throwable -> L81
    L27:
        SharedPreferences r14 = r20.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L81
        r12.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L81
        Map<String, ?> r15 = r14.getAll();     // Catch: Throwable -> L81
        r12.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L81
        Iterator<Map.Entry<String, ?>> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L81
    L29:
        if (r16.hasNext() == false) goto L75;
        Map.Entry<String, ?> r17 = r16.next();     // Catch: Throwable -> L81
        String r18 = r17.getKey();     // Catch: Throwable -> L81
        Object r19 = r17.getValue();     // Catch: Throwable -> L81
        if (r19 == null) goto L29;
        if ("".equals(r18) == false) goto L36;
        r18 = null;
    L36:
        String r21 = r18;
        KevaMonitor r22 = sMonitor;     // Catch: Throwable -> L81
        r22.logDebug("poring process key: " + r21 + ", value: " + r19 + " >> " + this.mName);     // Catch: Throwable -> L81
        KevaValueWrapper r23 = new KevaValueWrapper();     // Catch: Throwable -> L81
        this.mValueMap.put(r21, r23);     // Catch: Throwable -> L81
    L70:
        th = th;
        String r110 = r21;
    L72:
        Throwable r24 = th;
    L73:
        sMonitor.reportThrowable(3, this.mName, r110, r19, r24);     // Catch: Throwable -> L81
        goto L29
    L38:
        if ((r19 instanceof Boolean) == false) goto L45;
        r23.offset = storeBoolean(this.mHandle, r21, r23.offset, ((Boolean) r19).booleanValue());     // Catch: Throwable -> L42
    L40:
        r23.value = r19;     // Catch: Throwable -> L42
        r110 = r21;
    L89:
        if (this.mIsMultiProcess == true) goto L29;
        r23.loaded = true;     // Catch: Throwable -> L68
    L68:
        th = th;
    L42:
        th = move-exception;
        r24 = th;
        r110 = r21;
        goto L73
    L45:
        if ((r19 instanceof Integer) == false) goto L49;
        r23.offset = storeInt(this.mHandle, r21, r23.offset, ((Integer) r19).intValue());     // Catch: Throwable -> L42
        goto L40
    L49:
        if ((r19 instanceof Long) == false) goto L54;
        r110 = r21;
        r23.offset = storeLong(this.mHandle, r21, r23.offset, ((Long) r19).longValue());     // Catch: Throwable -> L68
    L53:
        r23.value = r19;     // Catch: Throwable -> L68
        goto L89
    L54:
        r110 = r21;
        if ((r19 instanceof Float) == false) goto L58;
        r23.offset = storeFloat(this.mHandle, r110, r23.offset, ((Float) r19).floatValue());     // Catch: Throwable -> L68
        goto L53
    L58:
        if ((r19 instanceof String) == false) goto L61;
        r23.offset = storeString(this.mHandle, r110, r23.offset, (String) r19);     // Catch: Throwable -> L68
        goto L53
    L61:
        if ((r19 instanceof Set) == false) goto L63;
        Set r25 = (Set) r19;     // Catch: Throwable -> L68
        String[] r26 = new String[r25.size()];     // Catch: Throwable -> L68
        r25.toArray(r26);     // Catch: Throwable -> L68
        r23.offset = storeStringArray(this.mHandle, r110, r23.offset, r26, 3);     // Catch: Throwable -> L68
        r23.value = r26;     // Catch: Throwable -> L68
        goto L89
    L63:
        r22.reportThrowable(1, this.mName, r110, r19, new IllegalStateException("do not support type: " + r19.getClass()));     // Catch: Throwable -> L68
        goto L89
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
        r11 = true;
        goto L21
    }

    private native void dump(long r8);

    private native void erase(long r8, String r10, long r11);

    private native void eraseUnusedChunk(long r8, long r10);

    private static boolean existSharedPrefs(String r8) {
        return new File(sSharedPrefsDir, a.e(r8, ".xml")).exists();
    }

    private Set<String> fetchStringSet(String r8, Set<String> r10, boolean r11) {
        if (r10 == null) goto L5;
        String[] r12 = (String[]) r10.toArray(new String[0]);
    L6:
        String[] r13 = fetchStringArray(r8, r12, r11);
        if (r13 != null) goto L9;
        return null;
    L9:
        return new HashSet(Arrays.asList(r13));
    L5:
        r12 = null;
        goto L6
    }

    public static void forceInitImpl() {
        Log.println(4, KevaConstants.TAG, "force initializing Keva");
    }

    public static KevaImpl getEmptyRepoImpl(String r8, String r10, int r11) {
        if (r11 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r8, null, null, new IllegalArgumentException(a.d("mode is not valid: ", r11)));
    L7:
        if ((r11 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r8, r10, r11);
    L10:
        return new KevaMultiProcessImpl(r8, r10, r11);
    L4:
        if (r11 < 2) goto L7;
        goto L5
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.access$100();
    }

    public static Keva getRepo(String r8, int r10) {
        return getRepoImpl(r8, null, r10, false);
    }

    public static Keva getRepoFromSp(Context r8, String r10, int r11) {
        return getRepoFromSpImpl(r8, r10, r11, false);
    }

    private static Keva getRepoFromSpImpl(final Context r10, final String r11, final int r12, boolean r13) {
        if (isRepoPorted(r11) == true) goto L5;
        boolean r8 = true;
        if (existSharedPrefs(r11) == true) goto L10;
        getPortedSpRepo().storeBoolean(r11, true);
        return getRepo(r11, r12);
    L10:
        sMonitor.logDebug("do poring from sp: " + r11);
        HashMap<String, Keva> r14 = sRepoMap;
        monitor-enter(r14);
        Keva r15 = r14.get(r11);     // Catch: Throwable -> L35
        if (r15 == null) goto L16;
        r8 = false;
    L16:
        if (r8 == false) goto L22;
        if (r13 == false) goto L20;
        Keva r16 = getEmptyRepoImpl(r11, null, r12);     // Catch: Throwable -> L35
    L19:
        r15 = r16;
        r14.put(r11, r15);     // Catch: Throwable -> L35
        goto L22
    L20:
        r16 = new KevaFuture(r11, r12, new AnonymousClass2(r11, r12, r10));     // Catch: Throwable -> L35
    L22:
        monitor-exit(r14);     // Catch: Throwable -> L35
        if (r8 == false) goto L31;
        if ((r15 instanceof KevaImpl) == true) goto L40;
    L34:
        return r15;
    L40:
        ((KevaImpl) r15).doPortingFromSp(r10);     // Catch: UnsatisfiedLinkError -> L28
    L28:
        e = move-exception;
        sMonitor.reportThrowable(1, r11, null, null, e);
        goto L34
    L31:
        if ((r15 instanceof KevaImpl) == false) goto L33;
        ((KevaImpl) r15).checkMode(r12);
        goto L34
    L33:
        ((KevaFuture) r15).checkMode(r12);
    L35:
        th = move-exception;
        throw th;
    L5:
        return getRepo(r11, r12);
    }

    public static Keva getRepoFromSpSync(Context r8, String r10, int r11) {
        return getRepoFromSpImpl(r8, r10, r11, true);
    }

    private static Keva getRepoImpl(final String r8, final String r10, final int r11, boolean r12) {
        if (r10 != null) goto L4;
        HashMap<String, Keva> r13 = sRepoMap;
    L5:
        monitor-enter(r13);
        Keva r14 = r13.get(r8);     // Catch: Throwable -> L24
        if (r14 != null) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L15;
        if (r12 == false) goto L13;
        r14 = getEmptyRepoImpl(r8, r10, r11);     // Catch: Throwable -> L24
    L14:
        r13.put(r8, r14);     // Catch: Throwable -> L24
        goto L15
    L13:
        r14 = new KevaFuture(r8, r11, new AnonymousClass1(r8, r10, r11));     // Catch: Throwable -> L24
    L15:
        monitor-exit(r13);     // Catch: Throwable -> L24
        boolean r16 = r14 instanceof KevaFuture;
        if (r15 == false) goto L20;
        if (r16 == true) goto L23;
        ((KevaImpl) r14).init(false);
    L23:
        return r14;
    L20:
        if (r16 == true) goto L22;
        ((KevaImpl) r14).checkMode(r11);
        goto L23
    L22:
        ((KevaFuture) r14).checkMode(r11);
        goto L23
    L9:
        r15 = false;
    L24:
        th = move-exception;
        throw th;
    L4:
        ConcurrentHashMap<String, HashMap<String, Keva>> r17 = sPathRepoMap;
        r17.putIfAbsent(r10, new HashMap());
        r13 = r17.get(r10);
        goto L5
    }

    public static Keva getRepoSync(String r8, int r10) {
        return getRepoImpl(r8, null, r10, true);
    }

    public static Keva getRepoSyncWithPath(String r8, String r10, int r11) {
        if (r10 == null) goto L12;
        if ("".equals(r10) == true) goto L12;
        if (r10.startsWith("/") == true) goto L12;
        if (r10.endsWith("/") == false) goto L12;
        return getRepoImpl(r8, r10, r11, true);
    L12:
        throw new IllegalArgumentException(b.c("path is wrong: ", r10));
    }

    private static native void initialize(String r8);

    public static boolean isRepoPorted(String r8) {
        if (PortedSpRepoHolder.access$300().get(r8) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r8, false);
    }

    private native long loadRepo(String r8, int r10, boolean r11);

    private native long loadRepoWithPath(String r8, String r10, int r11);

    private void notifyChangeListeners(Keva r8, String r10) {
        if (this.mChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Iterator<Keva.OnChangeListener> r11 = this.mChangeListeners.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().onChanged(r8, r10);
        goto L7
    }

    private KevaValueWrapper obtainWrapperLocked(String r8) {
        KevaValueWrapper r10 = this.mValueMap.get(r8);
        if (r10 != null) goto L6;
        KevaValueWrapper r11 = new KevaValueWrapper();
        this.mValueMap.put(r8, r11);
        return r11;
    L6:
        return r10;
    }

    public static void passWarning(int r8, String r10, String r11, Object r12, String r13) {
        sMonitor.reportWarning(r8, r10, r11, r12, r13);
    }

    private native int protectPortingInterProcess(String r8, boolean r10, int r11);

    private void reportBigValue(final String r8, final Object r10, final int r11) {
        if (r11 <= 10000) goto L6;
        sExecutor.execute(new AnonymousClass3(this, r8, r10, r11));
        return;
    }

    private native long storeBoolean(long r8, String r10, long r11, boolean r12);

    private native long storeBytes(long r8, String r10, long r11, byte[] r12, int r13);

    private native long storeDouble(long r8, String r10, long r11, double r12);

    private native long storeFloat(long r8, String r10, long r11, float r12);

    private native long storeInt(long r8, String r10, long r11, int r12);

    private native long storeLong(long r8, String r10, long r11, long r12);

    private native long storeString(long r8, String r10, long r11, String r12);

    private native long storeStringArray(long r8, String r10, long r11, String[] r12, int r13);

    public void addMapBoolWhenLoading(String r8, boolean r10, long r11) {
        addMapObjectWhenLoading(r8, Boolean.valueOf(r10), r11, 2);
    }

    public void addMapDoubleWhenLoading(String r8, double r10, long r11) {
        addMapObjectWhenLoading(r8, Double.valueOf(r10), r11, 5);
    }

    public void addMapFloatWhenLoading(String r8, float r10, long r11) {
        addMapObjectWhenLoading(r8, Float.valueOf(r10), r11, 4);
    }

    public void addMapIntWhenLoading(String r8, int r10, long r11) {
        addMapObjectWhenLoading(r8, Integer.valueOf(r10), r11, 1);
    }

    public void addMapLongWhenLoading(String r8, long r10, long r11) {
        addMapObjectWhenLoading(r8, Long.valueOf(r10), r11, 3);
    }

    public void addMapOffsetWhenLoading(String r8, long r10, int r11) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        KevaValueWrapper r12 = new KevaValueWrapper();
        r12.offset = r10;
        r12.type = r11;
        KevaValueWrapper r13 = this.mValueMap.put(r8, r12);
        if (r13 == null) goto L11;
        List<KevaValueWrapper> r14 = this.mDuplicatedOldWrappers;
        if (r14 == null) goto L12;
        r14.add(r13);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r12) {
        Map<String, Object> r8 = KevaConstants.FLAG_CURRENT_KEY_MAP;
        monitor-enter(this);
        if (r12 == r8) goto L58;
        Iterator<Map.Entry<String, KevaValueWrapper>> r10 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L53
    L13:
        if (r10.hasNext() == false) goto L51;
        Map.Entry<String, KevaValueWrapper> r11 = r10.next();     // Catch: Throwable -> L53
        KevaValueWrapper r13 = r11.getValue();     // Catch: Throwable -> L53
        if (r13.offset == 0) goto L13;
        String r14 = r11.getKey();     // Catch: Throwable -> L53
    L48:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r14, Long.valueOf(r13.offset), th);     // Catch: Throwable -> L53
        goto L13
    L19:
        if (r13.loaded == true) goto L46;
        int r15 = r13.type;     // Catch: Throwable -> L48
        if (r15 != 6) goto L23;
        Object r16 = fetchString(this.mHandle, r14, r13.offset, null);     // Catch: Throwable -> L48
    L38:
        r13.value = r16;     // Catch: Throwable -> L48
    L44:
        if (this.mIsMultiProcess == true) goto L46;
        r13.loaded = true;     // Catch: Throwable -> L48
        goto L46
    L23:
        if (r15 != 7) goto L25;
        r13.value = fetchBytes(this.mHandle, r14, r13.offset, null, 0);     // Catch: Throwable -> L48
        goto L44
    L25:
        if (r15 == 23) goto L40;
        if (r15 == 39) goto L40;
        if (r15 != 55) goto L31;
        r16 = fetchStringArray(this.mHandle, r14, r13.offset, null, 3);     // Catch: Throwable -> L48
        goto L38
    L31:
        if (this.mIsMultiProcess == false) goto L36;
        if (r13.type <= 5) goto L44;
    L36:
        throw new UnsupportedOperationException("keva has not implemented type " + r13.type);     // Catch: Throwable -> L48
    L40:
        throw new UnsupportedOperationException("keva has not implemented type " + r13.type);     // Catch: Throwable -> L48
    L46:
        r12.put(r14, r13.value);     // Catch: Throwable -> L48
        goto L13
    L51:
        monitor-exit(this);     // Catch: Throwable -> L53
        return r12;
    L53:
        th = move-exception;
        throw th;
    L58:
        HashMap r17 = (HashMap) this.mValueMap.clone();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r17;
    L8:
        th = move-exception;
        throw th;
    }

    public void checkMode(int r10) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r10) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r10));
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

    public native boolean contains(long r8, String r10, long r11);

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, KevaValueWrapper>> r8 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r8.hasNext() == false) goto L8;
        Map.Entry<String, KevaValueWrapper> r10 = r8.next();     // Catch: Throwable -> L11
        KevaValueWrapper r11 = r10.getValue();     // Catch: Throwable -> L11
        String r12 = r10.getKey();     // Catch: Throwable -> L11
        sMonitor.logDebug("key: " + r12 + ", value: " + r11.value + ", offset: " + r11.offset + ", loaded: " + r11.loaded);     // Catch: Throwable -> L11
        goto L6
    L8:
        sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
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
    public void erase(String r10) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L10
        erase(this.mHandle, r10, r8.offset);     // Catch: Throwable -> L10
        r8.value = null;     // Catch: Throwable -> L10
        r8.offset = 0;     // Catch: Throwable -> L10
        if (this.mIsMultiProcess == true) goto L13;
        r8.loaded = true;     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, r10, null, th);     // Catch: Throwable -> L15
        goto L13
    }

    public native boolean fetchBoolean(long r8, String r10, long r11, boolean r12);

    public abstract boolean fetchBoolean(String r8, boolean r10);

    public native byte[] fetchBytes(long r8, String r10, long r11, byte[] r12, int r13);

    public abstract byte[] fetchBytes(String r8, byte[] r10, int r11, boolean r12);

    public native double fetchDouble(long r8, String r10, long r11, double r12);

    public abstract double fetchDouble(String r8, double r10);

    public native float fetchFloat(long r8, String r10, long r11, float r12);

    public abstract float fetchFloat(String r8, float r10);

    public native int fetchInt(long r8, String r10, long r11, int r12);

    public abstract int fetchInt(String r8, int r10);

    public native long fetchLong(long r8, String r10, long r11, long r12);

    public abstract long fetchLong(String r8, long r10);

    public native String fetchString(long r8, String r10, long r11, String r12);

    public abstract String fetchString(String r8, String r10, boolean r11);

    public native String[] fetchStringArray(long r8, String r10, long r11, String[] r12, int r13);

    public abstract String[] fetchStringArray(String r8, String[] r10, boolean r11);

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r8, boolean r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        boolean r12 = fetchBoolean(r11, r10);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, null, th);     // Catch: Throwable -> L10
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r8, byte[] r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        byte[] r12 = fetchBytes(r11, r10, 0, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r8, byte[] r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        byte[] r12 = fetchBytes(r11, r10, 0, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r8, double r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        double r12 = fetchDouble(r11, r10);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, Double.valueOf(r10), th);     // Catch: Throwable -> L10
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r8, float r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        float r12 = fetchFloat(r11, r10);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, Float.valueOf(r10), th);     // Catch: Throwable -> L10
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r8, int r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        int r12 = fetchInt(r11, r10);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, Integer.valueOf(r10), th);     // Catch: Throwable -> L10
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r8, long r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        long r12 = fetchLong(r11, r10);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, Long.valueOf(r10), th);     // Catch: Throwable -> L10
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r8, String r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        String r12 = fetchString(r11, r10, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r8, String[] r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        String[] r12 = fetchStringArray(r11, r10, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r8, String[] r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        String[] r12 = fetchStringArray(r11, r10, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r8, String r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        String r12 = fetchString(r11, r10, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r8, Set<String> r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        Set<String> r12 = fetchStringSet(r11, r10, false);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r8, Set<String> r10) {
        if ("".equals(r8) == false) goto L5;
        r8 = null;
    L5:
        String r11 = r8;
        monitor-enter(this);
        Set<String> r12 = fetchStringSet(r11, r10, true);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r11, r10, th);     // Catch: Throwable -> L11
        return r10;
    }

    public void init(boolean r8) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        doLoadRepo(r8);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public native void rebuildValueMap(long r8);

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r8) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mChangeListeners.contains(r8) == true) goto L6;
        this.mChangeListeners.add(r8);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r10, boolean r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r12 = r10;
        r8.offset = storeBoolean(this.mHandle, r12, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Boolean.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r13 = r10;
        sMonitor.reportThrowable(3, this.mName, r13, Boolean.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Boolean.valueOf(r11)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r8, byte[] r10) {
        storeBytes(r8, r10, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r8, byte[] r10) {
        storeBytes(r8, r10, 0, true);
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
        String r12 = r10;
        r8.offset = storeDouble(this.mHandle, r12, r8.offset, r11);     // Catch: Throwable -> L21
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
        String r13 = r10;
        sMonitor.reportThrowable(3, this.mName, r13, Double.valueOf(r11), th);     // Catch: Throwable -> L26
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
    public void storeFloat(String r10, float r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r12 = r10;
        r8.offset = storeFloat(this.mHandle, r12, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Float.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r13 = r10;
        sMonitor.reportThrowable(3, this.mName, r13, Float.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Float.valueOf(r11)) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r10, int r11) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L26
        if (this.mIsMultiProcess == false) goto L9;
    L29:
        String r12 = r10;
        r8.offset = storeInt(this.mHandle, r12, r8.offset, r11);     // Catch: Throwable -> L21
        r8.value = Integer.valueOf(r11);     // Catch: Throwable -> L21
        if (this.mIsMultiProcess == true) goto L19;
        r8.loaded = true;     // Catch: Throwable -> L21
    L19:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        th = move-exception;
        String r13 = r10;
        sMonitor.reportThrowable(3, this.mName, r13, Integer.valueOf(r11), th);     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r8.loaded == false) goto L29;
        if (r8.value == null) goto L29;
        if (r8.value.equals(Integer.valueOf(r11)) == false) goto L29;
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
        String r12 = r10;
        r8.offset = storeLong(this.mHandle, r12, r8.offset, r11);     // Catch: Throwable -> L21
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
        String r13 = r10;
        sMonitor.reportThrowable(3, this.mName, r13, Long.valueOf(r11), th);     // Catch: Throwable -> L26
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
    public void storeString(String r8, String r10) {
        storeString(r8, r10, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r8, String[] r10) {
        storeStringArray(r8, r10, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r8, String[] r10) {
        storeStringArray(r8, r10, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r8, String r10) {
        storeString(r8, r10, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r8, Set<String> r10) {
        storeStringSet(r8, r10, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r8, Set<String> r10) {
        storeStringSet(r8, r10, true);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r8) {
        monitor-enter(this);
        this.mChangeListeners.remove(r8);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void storeBytes(final String r11, byte[] r12, int r13, boolean r14) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r8.offset = storeBytes(this.mHandle, r11, r8.offset, r12, r13);     // Catch: Throwable -> L15
        r8.type = (r13 << 4) | 7;     // Catch: Throwable -> L15
        if (r14 == true) goto L12;
        r8.value = r12;     // Catch: Throwable -> L15
        if (this.mIsMultiProcess == true) goto L13;
        r8.loaded = true;     // Catch: Throwable -> L15
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
        r8.value = null;     // Catch: Throwable -> L15
        r8.loaded = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, r12, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private void storeString(final String r10, final String r11, boolean r12) {
        if ("".equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r10);     // Catch: Throwable -> L33
        if (this.mIsMultiProcess == false) goto L9;
    L36:
        r8.offset = storeString(this.mHandle, r10, r8.offset, r11);     // Catch: Throwable -> L24
        r8.type = 6;     // Catch: Throwable -> L24
        if (r12 == true) goto L21;
        r8.value = r11;     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L22;
        r8.loaded = true;     // Catch: Throwable -> L24
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
        r8.value = null;     // Catch: Throwable -> L24
        r8.loaded = false;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, r11, th);     // Catch: Throwable -> L33
        goto L27
    L9:
        if (r8.loaded == false) goto L36;
        if (r8.value == null) goto L36;
        if (r8.value.equals(r11) == false) goto L36;
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    }

    private void storeStringArray(final String r11, String[] r12, boolean r13) {
        if ("".equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        KevaValueWrapper r8 = obtainWrapperLocked(r11);     // Catch: Throwable -> L24
        r8.offset = storeStringArray(this.mHandle, r11, r8.offset, r12, 3);     // Catch: Throwable -> L15
        r8.type = 55;     // Catch: Throwable -> L15
        if (r13 == true) goto L12;
        r8.value = r12;     // Catch: Throwable -> L15
        if (this.mIsMultiProcess == true) goto L13;
        r8.loaded = true;     // Catch: Throwable -> L15
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
        r8.value = null;     // Catch: Throwable -> L15
        r8.loaded = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, null, th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private void storeStringSet(String r8, Set<String> r10, boolean r11) {
        if (r10 == null) goto L4;
        String[] r12 = new String[r10.size()];
        r10.toArray(r12);
    L5:
        storeStringArray(r8, r12, r11);
        return;
    L4:
        r12 = null;
        goto L5
    }
}
