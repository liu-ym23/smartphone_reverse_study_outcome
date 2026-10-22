package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.ListMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UserDataCenter {
    private static boolean isIgnoreExceptionTag;
    private static boolean sEnableCloseBgAnr;
    private static boolean sEnsureOpt;
    private static boolean sOptDumpTrace;
    private static boolean sOptNpthInit;
    private static boolean sProcessTrackDiskOpt;
    private static boolean sTerminateOpt;
    private volatile boolean isAlreadyPut;
    private final List<IANRCallback> mAnrCallbacksList;
    private final List<IAnrUploadCallback> mAnrUploadCallbackList;
    private final ListMap<CrashType, AttachUserData> mAttachUserDataListMap;
    private final ListMap<CrashType, ICrashCallback> mCrashCallbackListMap;
    private ICrashFilter mCrashFilter;
    private final ListMap<CrashType, CrashInfoCallback> mCrashInfoCallbackListMap;
    private final Map<String, Integer> mCrashReasonLimitMap;
    private CrashUploadCallback mCrashUploadCallback;
    private final ConcurrentHashMap<String, String> mCustomTagHashMap;
    private final List<IOOMCallback> mHprofCallbacksList;
    private final ConcurrentHashMap<String, String> mInnerSdkVersionHashMap;
    private boolean mIsTagOptEnable;
    private final List<IOOMCallback> mOomCallbacksList;
    private final List<IPreANRCallback> mPreAnrCallbackList;
    private final ListMap<CrashType, IPreCrashCallback> mPreCrashCallbacks;
    private final Map<String, LinkedList<String>> mPriorityCrashReasonDataMap;
    private final ConcurrentHashMap<Integer, String> mSdkVersionHashMap;
    private final ListMap<CrashType, IUserCrashInfoCallback> mUserCrashInfoCallbackListMap;

    public UserDataCenter() {
        this.isAlreadyPut = true;
        this.mCustomTagHashMap = new ConcurrentHashMap();
        this.mSdkVersionHashMap = new ConcurrentHashMap();
        this.mInnerSdkVersionHashMap = new ConcurrentHashMap();
        this.mAttachUserDataListMap = new ListMap();
        this.mCrashCallbackListMap = new ListMap();
        this.mCrashInfoCallbackListMap = new ListMap();
        this.mOomCallbacksList = new CopyOnWriteArrayList();
        this.mHprofCallbacksList = new CopyOnWriteArrayList();
        this.mAnrCallbacksList = new CopyOnWriteArrayList();
        this.mPreAnrCallbackList = new CopyOnWriteArrayList();
        this.mAnrUploadCallbackList = new CopyOnWriteArrayList();
        this.mPriorityCrashReasonDataMap = new ConcurrentHashMap();
        this.mCrashReasonLimitMap = new ConcurrentHashMap();
        this.mPreCrashCallbacks = new ListMap();
        this.mUserCrashInfoCallbackListMap = new ListMap();
    }

    static /* synthetic */ ConcurrentHashMap access$000(UserDataCenter r0) {
        return r0.mCustomTagHashMap;
    }

    static /* synthetic */ boolean access$102(UserDataCenter r0, boolean r1) {
        r0.isAlreadyPut = r1;
        return r1;
    }

    public static boolean isCloseBgAnr() {
        return sEnableCloseBgAnr;
    }

    public static boolean isEnsureOpt() {
        return sEnsureOpt;
    }

    public static boolean isIgnoreExceptionTag() {
        return isIgnoreExceptionTag;
    }

    private boolean isIgnored(CrashType r4, JSONObject r5) {
        if (this.mCrashFilter != null) goto L19;
        return false;
    L19:
        if (r4 != CrashType.NATIVE) goto L11;
        return !this.mCrashFilter.onNativeCrashFilter(r5.optString("data"), r5.optString(CrashBody.CRASH_THREAD_NAME));
    L11:
        if (r4 != CrashType.ANR) goto L17;
        if (ZeusTransformUtils.instanceOf(this.mCrashFilter, ICrashFilterExt.class) == false) goto L17;
        return !((ICrashFilterExt) ZeusTransformUtils.preCheckCast(this.mCrashFilter, ICrashFilterExt.class, "com.obric.memorydata.plugin")).onAnrFilter(r5.optString("data"), r5.optString(AnrInfoParser.ANR_INFO));
    L17:
        return false;
    }

    @Deprecated
    public static boolean isOpenNewAnrMonitor() {
        return false;
    }

    public static boolean isOptDumpTrace() {
        return sOptDumpTrace;
    }

    public static boolean isOptNpthInit() {
        return sOptNpthInit;
    }

    public static boolean isProcessTrackDiskOpt() {
        return sProcessTrackDiskOpt;
    }

    @Deprecated
    public static boolean isTerminateOpt() {
        if (sTerminateOpt == true) goto L5;
    L7:
        return false;
    L5:
        if (isOpenNewAnrMonitor() == false) goto L7;
        return true;
    }

    static void optProcessTrackDisk() {
        sProcessTrackDiskOpt = true;
    }

    public static void setCloseBgAnr(boolean r0) {
        sEnableCloseBgAnr = r0;
    }

    static void setEnsureOpt(boolean r0) {
        sEnsureOpt = r0;
    }

    public static void setIgnoreExceptionTagEnable(boolean r0) {
        isIgnoreExceptionTag = r0;
    }

    public static void setNpthInitOptEnable(boolean r0) {
        sOptNpthInit = r0;
    }

    public static void setOpenDumpTraceOpt(boolean r0) {
        sOptDumpTrace = r0;
    }

    static void setTerminateOpt(boolean r0) {
        sTerminateOpt = r0;
    }

    public void addANRCallback(IANRCallback r3) {
        IANRCallback r4 = (IANRCallback) ZeusTransformUtils.wrapperContextForParams(r3, IANRCallback.class, "com.obric.memorydata.plugin");
        this.mAnrCallbacksList.add(r4);
    }

    public void addAnrUploadCallback(IAnrUploadCallback r3) {
        IAnrUploadCallback r4 = (IAnrUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAnrUploadCallback.class, "com.obric.memorydata.plugin");
        this.mAnrUploadCallbackList.add(r4);
    }

    public void addAttachUserData(AttachUserData r4, CrashType r5) {
        AttachUserData r6 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r4, AttachUserData.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        ListMap<CrashType, AttachUserData> r0 = this.mAttachUserDataListMap;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r5 != CrashType.ALL) goto L9;
        this.mAttachUserDataListMap.addMulti(r6, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.mAttachUserDataListMap.add(r5, r6);     // Catch: Throwable -> L12
        goto L10
    }

    public void addCrashCallback(ICrashCallback r4, CrashType r5) {
        ICrashCallback r6 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r4, ICrashCallback.class, "com.obric.memorydata.plugin");
        ListMap<CrashType, ICrashCallback> r0 = this.mCrashCallbackListMap;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        this.mCrashCallbackListMap.addMulti(r6, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashCallbackListMap.add(r5, r6);     // Catch: Throwable -> L10
        goto L8
    }

    public void addCrashInfoCallback(CrashInfoCallback r4, CrashType r5) {
        ListMap<CrashType, CrashInfoCallback> r0 = this.mCrashInfoCallbackListMap;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        this.mCrashInfoCallbackListMap.addMulti(r4, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashInfoCallbackListMap.add(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    void addCrashReasonArray(String r4, String r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mPriorityCrashReasonDataMap.containsKey(r4) == true) goto L16;
        Map<String, LinkedList<String>> r0 = this.mPriorityCrashReasonDataMap;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mPriorityCrashReasonDataMap.containsKey(r4) == true) goto L11;
        this.mPriorityCrashReasonDataMap.put(r4, new LinkedList());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L16:
        LinkedList r1 = (LinkedList) ZeusTransformUtils.preCheckCast(this.mPriorityCrashReasonDataMap.get(r4), LinkedList.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L19;
        return;
    L19:
        monitor-enter(r1);
    L32:
        th = move-exception;
        throw th;
    L21:
        if (r1.contains(r5) == false) goto L25;
        monitor-exit(r1);     // Catch: Throwable -> L32
        return;
    L25:
        if (this.mCrashReasonLimitMap.containsKey(r4) == false) goto L29;
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(this.mCrashReasonLimitMap.get(r4), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L32
        if (r1.size() <= r3) goto L29;
        r1.removeFirst();     // Catch: Throwable -> L32
    L29:
        r1.add(r5);     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
    }

    public void addCustomTag(String r2, String r3) {
        if (NativeBridge.isSoLoaded() == true) goto L5;
    L11:
        if (r3 != null) goto L13;
        this.mCustomTagHashMap.remove(r2);
        return;
    L13:
        if (r2 == null) goto L20;
        this.mCustomTagHashMap.put(r2, r3);
        return;
    L20:
        return;
    L5:
        if (this.mIsTagOptEnable == false) goto L11;
        if (r3 != null) goto L9;
        NativeBridge.remove(r2);
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        NativeBridge.register(r2, r3);
        return;
    }

    public void addCustomTags(Map<? extends String, ? extends String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L25;
        return;
    L25:
        if (r6.isEmpty() == true) goto L44;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L24
    L7:
        if (r7.hasNext() == false) goto L46;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (NativeBridge.isSoLoaded() == false) goto L18;
        if (this.mIsTagOptEnable == false) goto L18;
        if (r1 == null) goto L14;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        NativeBridge.register(r2, r1);     // Catch: Throwable -> L24
        goto L7
    L14:
        NativeBridge.remove(r2);     // Catch: Throwable -> L24
    L18:
        if (r1 == null) goto L19;
        if (r2 == null) goto L7;
        this.mCustomTagHashMap.put(r2, r1);     // Catch: Throwable -> L24
        goto L7
    L19:
        this.mCustomTagHashMap.remove(r2);     // Catch: Throwable -> L24
        goto L7
    L46:
        return;
    L44:
        return;
    }

    public void addHprofCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mHprofCallbacksList.add(r4);
    }

    public void addOOMCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mOomCallbacksList.add(r4);
    }

    public void addPreANRCallback(IPreANRCallback r3) {
        IPreANRCallback r4 = (IPreANRCallback) ZeusTransformUtils.wrapperContextForParams(r3, IPreANRCallback.class, "com.obric.memorydata.plugin");
        this.mPreAnrCallbackList.add(r4);
    }

    public void addPreCrashCallback(IPreCrashCallback r4, CrashType r5) {
        IPreCrashCallback r6 = (IPreCrashCallback) ZeusTransformUtils.wrapperContextForParams(r4, IPreCrashCallback.class, "com.obric.memorydata.plugin");
        ListMap<CrashType, IPreCrashCallback> r0 = this.mPreCrashCallbacks;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        this.mPreCrashCallbacks.addMulti(r6, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.mPreCrashCallbacks.add(r5, r6);     // Catch: Throwable -> L10
        goto L8
    }

    public void addUserCrashInfoCallback(IUserCrashInfoCallback r4, CrashType r5) {
        IUserCrashInfoCallback r6 = (IUserCrashInfoCallback) ZeusTransformUtils.wrapperContextForParams(r4, IUserCrashInfoCallback.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        ListMap<CrashType, IUserCrashInfoCallback> r0 = this.mUserCrashInfoCallbackListMap;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r5 != CrashType.ALL) goto L9;
        this.mUserCrashInfoCallbackListMap.addMulti(r6, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.mUserCrashInfoCallbackListMap.add(r5, r6);     // Catch: Throwable -> L12
        goto L10
    }

    public boolean beforeUpload(CrashType r12, JSONObject r13) {
        if (isIgnored(r12, r13) == false) goto L6;
        return true;
    L6:
        CrashUploadCallback r0 = this.mCrashUploadCallback;     // Catch: Throwable -> L18
        if (r0 == null) goto L10;
        r0.beforeUpload(r12, r13);     // Catch: Throwable -> L18
    L10:
        if (r12 != CrashType.ANR) goto L16;
        long r7 = r13.optLong("app_start_time");     // Catch: Throwable -> L18
        long r9 = r13.optLong("crash_time");     // Catch: Throwable -> L18
        String r14 = r13.optString("process_name");     // Catch: Throwable -> L18
        Iterator<IAnrUploadCallback> r11 = this.mAnrUploadCallbackList.iterator();     // Catch: Throwable -> L18
    L12:
        if (r11.hasNext() == false) goto L23;
        ((IAnrUploadCallback) ZeusTransformUtils.preCheckCast(r11.next(), IAnrUploadCallback.class, "com.obric.memorydata.plugin")).onCrash(r7, r9, r14, r13);     // Catch: Throwable -> L18
        goto L12
    L23:
        return false;
    L16:
        return false;
    L22:
        return false;
    }

    public void clearCustomTags() {
        this.mCustomTagHashMap.clear();
    }

    public List<IANRCallback> getANRCallback() {
        return this.mAnrCallbacksList;
    }

    public List<IAnrUploadCallback> getAnrUploadCallback() {
        return this.mAnrUploadCallbackList;
    }

    public List<AttachUserData> getAttachUserData(CrashType r2) {
        ListMap<CrashType, AttachUserData> r0 = this.mAttachUserDataListMap;
        monitor-enter(r0);
        List<AttachUserData> r1 = this.mAttachUserDataListMap.getList(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public JSONObject getAttachUserDataToJson(CrashType r5) {
        List<AttachUserData> r4 = this.mAttachUserDataListMap.getList(r5);
        HashMap r0 = new HashMap();
        Iterator<AttachUserData> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Map<? extends String, ? extends String> r1 = ((AttachUserData) ZeusTransformUtils.preCheckCast(r6.next(), AttachUserData.class, "com.obric.memorydata.plugin")).getUserData(r5);
        if (r1 == null) goto L4;
        r0.putAll(r1);
        goto L4
    L9:
        return new JSONObject(r0);
    }

    public Map<String, String> getAttachUserDataToMap(CrashType r5) {
        ListMap<CrashType, AttachUserData> r0 = this.mAttachUserDataListMap;
        monitor-enter(r0);
        List<AttachUserData> r4 = this.mAttachUserDataListMap.getList(r5);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        HashMap r1 = new HashMap();
        Iterator<AttachUserData> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Map<? extends String, ? extends String> r2 = ((AttachUserData) ZeusTransformUtils.preCheckCast(r6.next(), AttachUserData.class, "com.obric.memorydata.plugin")).getUserData(r5);
        if (r2 == null) goto L8;
        r1.putAll(r2);
        goto L8
    L12:
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public Map<String, String> getCacheCustomTags() {
        if (NativeBridge.isSoLoaded() == false) goto L9;
        if (this.mIsTagOptEnable == false) goto L9;
        return NativeBridge.getTags();
    L9:
        return this.mCustomTagHashMap;
    }

    public List<ICrashCallback> getCrashCallback(CrashType r2) {
        ListMap<CrashType, ICrashCallback> r0 = this.mCrashCallbackListMap;
        monitor-enter(r0);
        List<ICrashCallback> r1 = this.mCrashCallbackListMap.getList(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<CrashInfoCallback> getCrashInfoCallback(CrashType r2) {
        ListMap<CrashType, CrashInfoCallback> r0 = this.mCrashInfoCallbackListMap;
        monitor-enter(r0);
        List<CrashInfoCallback> r1 = this.mCrashInfoCallbackListMap.getList(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, JSONArray> getCustomData() {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = this.mPriorityCrashReasonDataMap.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        JSONArray r3 = new JSONArray();
        LinkedList r4 = (LinkedList) ZeusTransformUtils.preCheckCast(this.mPriorityCrashReasonDataMap.get(r2), LinkedList.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L17;
        monitor-enter(r4);
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L14
    L10:
        if (r5.hasNext() == false) goto L12;
        r3.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r4);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        r0.put(r2, r3);
        goto L4
    L18:
        return r0;
    }

    public Map<String, String> getCustomTags() {
        if (TagService.getTagCacheService() == null) goto L7;
        return TagService.getTags();
    L7:
        if (NativeBridge.isSoLoaded() == false) goto L13;
        if (this.mIsTagOptEnable == false) goto L13;
        return NativeBridge.getTags();
    L13:
        return this.mCustomTagHashMap;
    }

    public JSONObject getCustomTagsToJson() {
        return new JSONObject(getCustomTags());
    }

    public List<IOOMCallback> getHprofCallback() {
        return this.mHprofCallbacksList;
    }

    public ConcurrentHashMap<String, String> getInnerSDKInfo() {
        return this.mInnerSdkVersionHashMap;
    }

    public JSONObject getInnerSdkInfoToJson() {
        return new JSONObject(this.mInnerSdkVersionHashMap);
    }

    public List<IOOMCallback> getOOMCallback() {
        return this.mOomCallbacksList;
    }

    public List<IPreANRCallback> getPreANRCallback() {
        return this.mPreAnrCallbackList;
    }

    public List<IPreCrashCallback> getPreCrashCallback(CrashType r2) {
        ListMap<CrashType, IPreCrashCallback> r0 = this.mPreCrashCallbacks;
        monitor-enter(r0);
        List<IPreCrashCallback> r1 = this.mPreCrashCallbacks.getList(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ConcurrentHashMap<Integer, String> getSdkInfo() {
        return this.mSdkVersionHashMap;
    }

    public List<IUserCrashInfoCallback> getUserCrashInfoCallback(CrashType r2) {
        ListMap<CrashType, IUserCrashInfoCallback> r0 = this.mUserCrashInfoCallbackListMap;
        monitor-enter(r0);
        List<IUserCrashInfoCallback> r1 = this.mUserCrashInfoCallbackListMap.getList(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isIgnored(Thread r2, Throwable r3) {
        ICrashFilter r1 = this.mCrashFilter;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        if (r1.onJavaCrashFilter(r3, r2) == true) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public boolean isTagOptEnable() {
        return this.mIsTagOptEnable;
    }

    public void registerInnerSdkInfo(String r1, String r2) {
        this.mInnerSdkVersionHashMap.put(r1, r2);
    }

    public void registerSdkInfo(int r1, String r2) {
        this.mSdkVersionHashMap.put(Integer.valueOf(r1), r2);
    }

    public void removeAttachUserData(CrashType r3, AttachUserData r4) {
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r4, AttachUserData.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        ListMap<CrashType, AttachUserData> r0 = this.mAttachUserDataListMap;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r3 != CrashType.ALL) goto L9;
        this.mAttachUserDataListMap.removeAll(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.mAttachUserDataListMap.removeInList(r3, r5);     // Catch: Throwable -> L12
        goto L10
    }

    public void removeCrashCallback(ICrashCallback r3, CrashType r4) {
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICrashCallback.class, "com.obric.memorydata.plugin");
        ListMap<CrashType, ICrashCallback> r0 = this.mCrashCallbackListMap;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        this.mCrashCallbackListMap.removeAll(r5);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashCallbackListMap.removeInList(r4, r5);     // Catch: Throwable -> L10
        goto L8
    }

    public void removeCrashInfoCallback(CrashInfoCallback r3, CrashType r4) {
        ListMap<CrashType, CrashInfoCallback> r0 = this.mCrashInfoCallbackListMap;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        this.mCrashInfoCallbackListMap.removeAll(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashInfoCallbackListMap.removeInList(r4, r3);     // Catch: Throwable -> L10
        goto L8
    }

    void removeCrashReasonArray(String r1) {
        this.mPriorityCrashReasonDataMap.remove(r1);
    }

    public void removeCustomTag(String r2) {
        if (NativeBridge.isSoLoaded() == true) goto L5;
    L9:
        this.mCustomTagHashMap.remove(r2);
        return;
    L5:
        if (this.mIsTagOptEnable == false) goto L9;
        if (this.isAlreadyPut == false) goto L9;
        NativeBridge.remove(r2);
    }

    public void removeHprofCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mHprofCallbacksList.remove(r4);
    }

    public void removeOOMCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mOomCallbacksList.remove(r4);
    }

    public void removePreANRCallback(IPreANRCallback r3) {
        IPreANRCallback r4 = (IPreANRCallback) ZeusTransformUtils.wrapperContextForParams(r3, IPreANRCallback.class, "com.obric.memorydata.plugin");
        this.mPreAnrCallbackList.remove(r4);
    }

    public void removePreCrashCallback(IPreCrashCallback r3, CrashType r4) {
        IPreCrashCallback r5 = (IPreCrashCallback) ZeusTransformUtils.wrapperContextForParams(r3, IPreCrashCallback.class, "com.obric.memorydata.plugin");
        ListMap<CrashType, IPreCrashCallback> r0 = this.mPreCrashCallbacks;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        this.mPreCrashCallbacks.removeAll(r5);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        this.mPreCrashCallbacks.removeInList(r4, r5);     // Catch: Throwable -> L10
        goto L8
    }

    public void removeUserCrashInfoCallback(IUserCrashInfoCallback r3, CrashType r4) {
        IUserCrashInfoCallback r5 = (IUserCrashInfoCallback) ZeusTransformUtils.wrapperContextForParams(r3, IUserCrashInfoCallback.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        ListMap<CrashType, IUserCrashInfoCallback> r0 = this.mUserCrashInfoCallbackListMap;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r4 != CrashType.ALL) goto L9;
        this.mUserCrashInfoCallbackListMap.removeAll(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        this.mUserCrashInfoCallbackListMap.removeInList(r4, r5);     // Catch: Throwable -> L12
        goto L10
    }

    public void setCrashFilter(ICrashFilter r3) {
        this.mCrashFilter = (ICrashFilter) ZeusTransformUtils.wrapperContextForParams(r3, ICrashFilter.class, "com.obric.memorydata.plugin");
    }

    public void setCrashReasonArrayLimit(String r1, int r2) {
        this.mCrashReasonLimitMap.put(r1, Integer.valueOf(r2));
    }

    public void setTagOpt(boolean r2) {
        if (this.mIsTagOptEnable == true) goto L10;
        if (r2 == false) goto L10;
        this.mIsTagOptEnable = true;
        if (this.mCustomTagHashMap.isEmpty() == true) goto L10;
        if (NativeBridge.isSoLoaded() == false) goto L10;
        this.isAlreadyPut = false;
        DefaultWorkThread.post(new AnonymousClass1(this));
    L10:
        this.mIsTagOptEnable = r2;
    }

    public void setUploadCallback(CrashUploadCallback r3) {
        this.mCrashUploadCallback = (CrashUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, CrashUploadCallback.class, "com.obric.memorydata.plugin");
    }
}
