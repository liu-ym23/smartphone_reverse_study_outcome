package com.bytedance.crash;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.ListMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    static /* synthetic */ ConcurrentHashMap access$000(UserDataCenter r10) {
        return r10.mCustomTagHashMap;
    }

    static /* synthetic */ boolean access$102(UserDataCenter r10, boolean r11) {
        r10.isAlreadyPut = r11;
        return r11;
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

    private boolean isIgnored(CrashType r10, JSONObject r11) {
        ICrashFilter r12 = this.mCrashFilter;
        if (r12 != null) goto L19;
        return false;
    L19:
        if (r10 != CrashType.NATIVE) goto L11;
        return !this.mCrashFilter.onNativeCrashFilter(r11.optString("data"), r11.optString(CrashBody.CRASH_THREAD_NAME));
    L11:
        if (r10 != CrashType.ANR) goto L17;
        if ((r12 instanceof ICrashFilterExt) == false) goto L17;
        return !((ICrashFilterExt) this.mCrashFilter).onAnrFilter(r11.optString("data"), r11.optString(AnrInfoParser.ANR_INFO));
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

    public static void setCloseBgAnr(boolean r10) {
        sEnableCloseBgAnr = r10;
    }

    static void setEnsureOpt(boolean r10) {
        sEnsureOpt = r10;
    }

    public static void setIgnoreExceptionTagEnable(boolean r10) {
        isIgnoreExceptionTag = r10;
    }

    public static void setNpthInitOptEnable(boolean r10) {
        sOptNpthInit = r10;
    }

    public static void setOpenDumpTraceOpt(boolean r10) {
        sOptDumpTrace = r10;
    }

    static void setTerminateOpt(boolean r10) {
        sTerminateOpt = r10;
    }

    public void addANRCallback(IANRCallback r10) {
        this.mAnrCallbacksList.add(r10);
    }

    public void addAnrUploadCallback(IAnrUploadCallback r10) {
        this.mAnrUploadCallbackList.add(r10);
    }

    public void addAttachUserData(AttachUserData r10, CrashType r11) {
        if (r10 == null) goto L14;
        ListMap<CrashType, AttachUserData> r12 = this.mAttachUserDataListMap;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r11 != CrashType.ALL) goto L8;
        this.mAttachUserDataListMap.addMulti(r10, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        this.mAttachUserDataListMap.add(r11, r10);     // Catch: Throwable -> L11
        goto L9
    }

    public void addCrashCallback(ICrashCallback r10, CrashType r11) {
        ListMap<CrashType, ICrashCallback> r12 = this.mCrashCallbackListMap;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11 != CrashType.ALL) goto L7;
        this.mCrashCallbackListMap.addMulti(r10, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashCallbackListMap.add(r11, r10);     // Catch: Throwable -> L10
        goto L8
    }

    public void addCrashInfoCallback(CrashInfoCallback r10, CrashType r11) {
        ListMap<CrashType, CrashInfoCallback> r12 = this.mCrashInfoCallbackListMap;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11 != CrashType.ALL) goto L7;
        this.mCrashInfoCallbackListMap.addMulti(r10, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashInfoCallbackListMap.add(r11, r10);     // Catch: Throwable -> L10
        goto L8
    }

    void addCrashReasonArray(@NonNull String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.mPriorityCrashReasonDataMap.containsKey(r10) == true) goto L16;
        Map<String, LinkedList<String>> r12 = this.mPriorityCrashReasonDataMap;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mPriorityCrashReasonDataMap.containsKey(r10) == true) goto L11;
        this.mPriorityCrashReasonDataMap.put(r10, new LinkedList());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    L16:
        LinkedList<String> r13 = this.mPriorityCrashReasonDataMap.get(r10);
        if (r13 != null) goto L19;
        return;
    L19:
        monitor-enter(r13);
    L32:
        th = move-exception;
        throw th;
    L21:
        if (r13.contains(r11) == false) goto L25;
        monitor-exit(r13);     // Catch: Throwable -> L32
        return;
    L25:
        if (this.mCrashReasonLimitMap.containsKey(r10) == false) goto L29;
        int r14 = this.mCrashReasonLimitMap.get(r10).intValue();     // Catch: Throwable -> L32
        if (r13.size() <= r14) goto L29;
        r13.removeFirst();     // Catch: Throwable -> L32
    L29:
        r13.add(r11);     // Catch: Throwable -> L32
        monitor-exit(r13);     // Catch: Throwable -> L32
    }

    public void addCustomTag(String r10, String r11) {
        if (NativeBridge.isSoLoaded() == true) goto L5;
    L11:
        if (r11 != null) goto L13;
        this.mCustomTagHashMap.remove(r10);
        return;
    L13:
        if (r10 == null) goto L20;
        this.mCustomTagHashMap.put(r10, r11);
        return;
    L20:
        return;
    L5:
        if (this.mIsTagOptEnable == false) goto L11;
        if (r11 != null) goto L9;
        NativeBridge.remove(r10);
        return;
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L17;
        NativeBridge.register(r10, r11);
        return;
    }

    public void addCustomTags(Map<? extends String, ? extends String> r10) {
        if (r10 != null) goto L24;
        return;
    L24:
        if (r10.isEmpty() == true) goto L43;
        Iterator<Map.Entry<? extends String, ? extends String>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L23
    L6:
        if (r11.hasNext() == false) goto L45;
        Map.Entry<? extends String, ? extends String> r12 = r11.next();     // Catch: Throwable -> L23
        String r13 = r12.getKey();     // Catch: Throwable -> L23
        String r14 = r12.getValue();     // Catch: Throwable -> L23
        if (NativeBridge.isSoLoaded() == false) goto L17;
        if (this.mIsTagOptEnable == false) goto L17;
        if (r14 == null) goto L13;
        if (TextUtils.isEmpty(r13) == true) goto L6;
        NativeBridge.register(r13, r14);     // Catch: Throwable -> L23
        goto L6
    L13:
        NativeBridge.remove(r13);     // Catch: Throwable -> L23
    L17:
        if (r14 == null) goto L18;
        if (r13 == null) goto L6;
        this.mCustomTagHashMap.put(r13, r14);     // Catch: Throwable -> L23
        goto L6
    L18:
        this.mCustomTagHashMap.remove(r13);     // Catch: Throwable -> L23
        goto L6
    L45:
        return;
    L43:
        return;
    }

    public void addHprofCallback(IOOMCallback r10) {
        this.mHprofCallbacksList.add(r10);
    }

    public void addOOMCallback(IOOMCallback r10) {
        this.mOomCallbacksList.add(r10);
    }

    public void addPreANRCallback(IPreANRCallback r10) {
        this.mPreAnrCallbackList.add(r10);
    }

    public void addPreCrashCallback(IPreCrashCallback r10, CrashType r11) {
        ListMap<CrashType, IPreCrashCallback> r12 = this.mPreCrashCallbacks;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11 != CrashType.ALL) goto L7;
        this.mPreCrashCallbacks.addMulti(r10, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L7:
        this.mPreCrashCallbacks.add(r11, r10);     // Catch: Throwable -> L10
        goto L8
    }

    public void addUserCrashInfoCallback(IUserCrashInfoCallback r10, CrashType r11) {
        if (r10 == null) goto L14;
        ListMap<CrashType, IUserCrashInfoCallback> r12 = this.mUserCrashInfoCallbackListMap;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r11 != CrashType.ALL) goto L8;
        this.mUserCrashInfoCallbackListMap.addMulti(r10, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        this.mUserCrashInfoCallbackListMap.add(r11, r10);     // Catch: Throwable -> L11
        goto L9
    }

    public boolean beforeUpload(CrashType r12, JSONObject r13) {
        if (isIgnored(r12, r13) == false) goto L6;
        return true;
    L6:
        CrashUploadCallback r10 = this.mCrashUploadCallback;     // Catch: Throwable -> L18
        if (r10 == null) goto L10;
        r10.beforeUpload(r12, r13);     // Catch: Throwable -> L18
    L10:
        if (r12 != CrashType.ANR) goto L16;
        long r11 = r13.optLong("app_start_time");     // Catch: Throwable -> L18
        long r14 = r13.optLong("crash_time");     // Catch: Throwable -> L18
        String r15 = r13.optString("process_name");     // Catch: Throwable -> L18
        Iterator<IAnrUploadCallback> r16 = this.mAnrUploadCallbackList.iterator();     // Catch: Throwable -> L18
    L12:
        if (r16.hasNext() == false) goto L23;
        r16.next().onCrash(r11, r14, r15, r13);     // Catch: Throwable -> L18
        goto L12
    L23:
        return false;
    L16:
        return false;
    L22:
        return false;
    }

    @NonNull
    public void clearCustomTags() {
        this.mCustomTagHashMap.clear();
    }

    @NonNull
    public List<IANRCallback> getANRCallback() {
        return this.mAnrCallbacksList;
    }

    @NonNull
    public List<IAnrUploadCallback> getAnrUploadCallback() {
        return this.mAnrUploadCallbackList;
    }

    @Nullable
    public List<AttachUserData> getAttachUserData(CrashType r10) {
        ListMap<CrashType, AttachUserData> r11 = this.mAttachUserDataListMap;
        monitor-enter(r11);
        List<AttachUserData> r12 = this.mAttachUserDataListMap.getList(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public JSONObject getAttachUserDataToJson(CrashType r10) {
        List<AttachUserData> r11 = this.mAttachUserDataListMap.getList(r10);
        HashMap r12 = new HashMap();
        Iterator<AttachUserData> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Map<? extends String, ? extends String> r14 = r13.next().getUserData(r10);
        if (r14 == null) goto L4;
        r12.putAll(r14);
        goto L4
    L9:
        return new JSONObject(r12);
    }

    public Map<String, String> getAttachUserDataToMap(CrashType r10) {
        ListMap<CrashType, AttachUserData> r11 = this.mAttachUserDataListMap;
        monitor-enter(r11);
        List<AttachUserData> r12 = this.mAttachUserDataListMap.getList(r10);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        HashMap r13 = new HashMap();
        Iterator<AttachUserData> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        Map<? extends String, ? extends String> r15 = r14.next().getUserData(r10);
        if (r15 == null) goto L8;
        r13.putAll(r15);
        goto L8
    L12:
        return r13;
    L13:
        th = move-exception;
        throw th;
    }

    @NonNull
    public Map<String, String> getCacheCustomTags() {
        if (NativeBridge.isSoLoaded() == false) goto L9;
        if (this.mIsTagOptEnable == false) goto L9;
        return NativeBridge.getTags();
    L9:
        return this.mCustomTagHashMap;
    }

    @NonNull
    public List<ICrashCallback> getCrashCallback(CrashType r10) {
        ListMap<CrashType, ICrashCallback> r11 = this.mCrashCallbackListMap;
        monitor-enter(r11);
        List<ICrashCallback> r12 = this.mCrashCallbackListMap.getList(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public List<CrashInfoCallback> getCrashInfoCallback(CrashType r10) {
        ListMap<CrashType, CrashInfoCallback> r11 = this.mCrashInfoCallbackListMap;
        monitor-enter(r11);
        List<CrashInfoCallback> r12 = this.mCrashInfoCallbackListMap.getList(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, JSONArray> getCustomData() {
        HashMap r10 = new HashMap();
        Iterator<String> r11 = this.mPriorityCrashReasonDataMap.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        String r12 = r11.next();
        JSONArray r13 = new JSONArray();
        LinkedList<String> r14 = this.mPriorityCrashReasonDataMap.get(r12);
        if (r14 == null) goto L17;
        monitor-enter(r14);
        Iterator<String> r15 = r14.iterator();     // Catch: Throwable -> L14
    L10:
        if (r15.hasNext() == false) goto L12;
        r13.put(r15.next());     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r14);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        r10.put(r12, r13);
        goto L4
    L18:
        return r10;
    }

    @NonNull
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

    @NonNull
    public List<IOOMCallback> getHprofCallback() {
        return this.mHprofCallbacksList;
    }

    public ConcurrentHashMap<String, String> getInnerSDKInfo() {
        return this.mInnerSdkVersionHashMap;
    }

    @NonNull
    public JSONObject getInnerSdkInfoToJson() {
        return new JSONObject(this.mInnerSdkVersionHashMap);
    }

    @NonNull
    public List<IOOMCallback> getOOMCallback() {
        return this.mOomCallbacksList;
    }

    @NonNull
    public List<IPreANRCallback> getPreANRCallback() {
        return this.mPreAnrCallbackList;
    }

    @NonNull
    public List<IPreCrashCallback> getPreCrashCallback(CrashType r10) {
        ListMap<CrashType, IPreCrashCallback> r11 = this.mPreCrashCallbacks;
        monitor-enter(r11);
        List<IPreCrashCallback> r12 = this.mPreCrashCallbacks.getList(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public ConcurrentHashMap<Integer, String> getSdkInfo() {
        return this.mSdkVersionHashMap;
    }

    public List<IUserCrashInfoCallback> getUserCrashInfoCallback(CrashType r10) {
        ListMap<CrashType, IUserCrashInfoCallback> r11 = this.mUserCrashInfoCallbackListMap;
        monitor-enter(r11);
        List<IUserCrashInfoCallback> r12 = this.mUserCrashInfoCallbackListMap.getList(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isIgnored(Thread r10, Throwable r11) {
        ICrashFilter r12 = this.mCrashFilter;     // Catch: Throwable -> L9
        if (r12 == null) goto L12;
        if (r12.onJavaCrashFilter(r11, r10) == true) goto L13;
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

    public void registerInnerSdkInfo(String r10, String r11) {
        this.mInnerSdkVersionHashMap.put(r10, r11);
    }

    public void registerSdkInfo(int r10, String r11) {
        this.mSdkVersionHashMap.put(Integer.valueOf(r10), r11);
    }

    public void removeAttachUserData(CrashType r10, AttachUserData r11) {
        if (r11 == null) goto L14;
        ListMap<CrashType, AttachUserData> r12 = this.mAttachUserDataListMap;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r10 != CrashType.ALL) goto L8;
        this.mAttachUserDataListMap.removeAll(r11);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        this.mAttachUserDataListMap.removeInList(r10, r11);     // Catch: Throwable -> L11
        goto L9
    }

    public void removeCrashCallback(ICrashCallback r10, CrashType r11) {
        ListMap<CrashType, ICrashCallback> r12 = this.mCrashCallbackListMap;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11 != CrashType.ALL) goto L7;
        this.mCrashCallbackListMap.removeAll(r10);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashCallbackListMap.removeInList(r11, r10);     // Catch: Throwable -> L10
        goto L8
    }

    public void removeCrashInfoCallback(CrashInfoCallback r10, CrashType r11) {
        ListMap<CrashType, CrashInfoCallback> r12 = this.mCrashInfoCallbackListMap;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11 != CrashType.ALL) goto L7;
        this.mCrashInfoCallbackListMap.removeAll(r10);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCrashInfoCallbackListMap.removeInList(r11, r10);     // Catch: Throwable -> L10
        goto L8
    }

    void removeCrashReasonArray(String r10) {
        this.mPriorityCrashReasonDataMap.remove(r10);
    }

    public void removeCustomTag(String r10) {
        if (NativeBridge.isSoLoaded() == true) goto L5;
    L9:
        this.mCustomTagHashMap.remove(r10);
        return;
    L5:
        if (this.mIsTagOptEnable == false) goto L9;
        if (this.isAlreadyPut == false) goto L9;
        NativeBridge.remove(r10);
    }

    public void removeHprofCallback(IOOMCallback r10) {
        this.mHprofCallbacksList.remove(r10);
    }

    public void removeOOMCallback(IOOMCallback r10) {
        this.mOomCallbacksList.remove(r10);
    }

    public void removePreANRCallback(IPreANRCallback r10) {
        this.mPreAnrCallbackList.remove(r10);
    }

    public void removePreCrashCallback(IPreCrashCallback r10, CrashType r11) {
        ListMap<CrashType, IPreCrashCallback> r12 = this.mPreCrashCallbacks;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11 != CrashType.ALL) goto L7;
        this.mPreCrashCallbacks.removeAll(r10);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L7:
        this.mPreCrashCallbacks.removeInList(r11, r10);     // Catch: Throwable -> L10
        goto L8
    }

    public void removeUserCrashInfoCallback(IUserCrashInfoCallback r10, CrashType r11) {
        if (r10 == null) goto L14;
        ListMap<CrashType, IUserCrashInfoCallback> r12 = this.mUserCrashInfoCallbackListMap;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r11 != CrashType.ALL) goto L8;
        this.mUserCrashInfoCallbackListMap.removeAll(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        this.mUserCrashInfoCallbackListMap.removeInList(r11, r10);     // Catch: Throwable -> L11
        goto L9
    }

    public void setCrashFilter(ICrashFilter r10) {
        this.mCrashFilter = r10;
    }

    public void setCrashReasonArrayLimit(String r10, int r11) {
        this.mCrashReasonLimitMap.put(r10, Integer.valueOf(r11));
    }

    public void setTagOpt(boolean r10) {
        if (this.mIsTagOptEnable == true) goto L10;
        if (r10 == false) goto L10;
        this.mIsTagOptEnable = true;
        if (this.mCustomTagHashMap.isEmpty() == true) goto L10;
        if (NativeBridge.isSoLoaded() == false) goto L10;
        this.isAlreadyPut = false;
        DefaultWorkThread.post(new AnonymousClass1(this));
    L10:
        this.mIsTagOptEnable = r10;
    }

    public void setUploadCallback(CrashUploadCallback r10) {
        this.mCrashUploadCallback = r10;
    }
}
