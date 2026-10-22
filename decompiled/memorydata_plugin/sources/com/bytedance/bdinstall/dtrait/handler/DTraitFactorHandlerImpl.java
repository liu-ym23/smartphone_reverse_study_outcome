package com.bytedance.bdinstall.dtrait.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.executor.ExecutorUtil;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.bytedance.bdinstall.dtrait.extra_finger.ExtraLoaderConfigHandler;
import com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler;
import com.bytedance.bdinstall.dtrait.manager.DTraitCacheManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;
import com.bytedance.bdinstall.dtrait.model.DTraitCipherEvent;
import com.bytedance.bdinstall.dtrait.model.DTraitInfo;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.bdinstall.dtrait.model.DTraitPlainEvent;
import com.bytedance.bdinstall.dtrait.model.DTraitTimeMonitorEvent;
import com.bytedance.bdinstall.dtrait.model.ExtraLoaderInfo;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import com.bytedance.bdinstall.dtrait.utils.Utils;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitFactorHandlerImpl extends AbsLoaderHandler {
    private static final int MAX_RETRY_COUNT = 3;
    private static final int RETRY_INTERVAL = 30000;
    private static final int WAIT_PUBLIC_KEY_TIME = 30;
    private final Map<String, JSONObject> basicDTraitMap;
    private final CountDownLatch countDownLatch;
    private volatile DTraitInfo dTraitInfo;
    private final DTraitNativeManager dTraitNativeManager;
    private final Map<String, EncryptDTraitEntry> encryptBasicDTraitCacheMap;
    private final Handler handler;
    private volatile byte[] highBasicDTraitValue;
    private final AtomicBoolean isBindDTraitCountDown;
    private final ReentrantLock lock;
    private volatile byte[] lowBasicDTraitValue;
    private final ReentrantLock preHandleDTraitLock;
    private int retryCount;
    private final List<String> whiteList;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.dtrait.handler.DTraitFactorHandlerImpl$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType = null;

        static {
            int[] r0 = new int[DTraitRiskType.values().length];
            $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType = r0;
            r0[DTraitRiskType.HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType[DTraitRiskType.LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class EncryptDTraitEntry {
        private final long expireAt;
        private final String value;

        public EncryptDTraitEntry(String r1, long r2) {
            this.value = r1;
            this.expireAt = r2;
        }

        static /* synthetic */ String access$800(EncryptDTraitEntry r0) {
            return r0.value;
        }

        public long getExpireAt() {
            return this.expireAt;
        }

        public String getValue() {
            return this.value;
        }
    }

    public DTraitFactorHandlerImpl(Context r3, ExtraLoaderConfigHandler r4, DTraitCacheManager r5, DTraitNativeManager r6, boolean r7) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r7);
        this.lock = new ReentrantLock();
        this.preHandleDTraitLock = new ReentrantLock();
        this.countDownLatch = new CountDownLatch(1);
        this.isBindDTraitCountDown = new AtomicBoolean(false);
        this.retryCount = 0;
        loadDTraitInfo();
        this.basicDTraitMap = new ConcurrentHashMap();
        this.encryptBasicDTraitCacheMap = new ConcurrentHashMap();
        this.whiteList = new ArrayList();
        this.handler = ExecutorUtil.getHandler();
        this.dTraitNativeManager = r6;
    }

    static /* synthetic */ DTraitCacheManager access$000(DTraitFactorHandlerImpl r0) {
        return r0.cacheHandler;
    }

    static /* synthetic */ Context access$100(DTraitFactorHandlerImpl r0) {
        return r0.context;
    }

    static /* synthetic */ boolean access$1000(DTraitFactorHandlerImpl r0) {
        return r0.hasLocalDid;
    }

    static /* synthetic */ boolean access$200(DTraitFactorHandlerImpl r0) {
        return r0.hasLocalDid;
    }

    static /* synthetic */ int access$300(DTraitFactorHandlerImpl r0) {
        return r0.retryCount;
    }

    static /* synthetic */ int access$308(DTraitFactorHandlerImpl r2) {
        int r0 = r2.retryCount;
        r2.retryCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ Handler access$400(DTraitFactorHandlerImpl r0) {
        return r0.handler;
    }

    static /* synthetic */ ExtraLoaderConfigHandler access$500(DTraitFactorHandlerImpl r0) {
        return r0.configHandler;
    }

    static /* synthetic */ void access$600(DTraitFactorHandlerImpl r0, JSONObject r1) {
        r0.preHandleDTrait(r1);
    }

    static /* synthetic */ Map access$700(DTraitFactorHandlerImpl r0) {
        return r0.encryptBasicDTraitCacheMap;
    }

    static /* synthetic */ CountDownLatch access$900(DTraitFactorHandlerImpl r0) {
        return r0.countDownLatch;
    }

    private void appendCandidateFactorFromHeaders(JSONObject r9, Map<String, JSONObject> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        JSONObject r1 = new JSONObject();
        Utils.copy(r1, r9);
        Map<String, JSONObject> r8 = this.configHandler.getDTraitFiledsMap();
        if (r8.containsKey(DTraitConstant.D_I1) == true) goto L5;
        return;
    L5:
        DTraitTraceUtil.start(DTraitConstant.METHOD_APPEND_CANDIDATE_FACTOR_FROM_HEADERS);
        JSONArray r2 = r1.optJSONArray("ipv6_list");
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.length() <= 0) goto L33;
        int r4 = 0;
    L11:
        if (r4 >= r2.length()) goto L24;
        JSONObject r5 = r2.getJSONObject(r4);     // Catch: Exception -> L21
        if ("client_tun".equals(r5.getString("type")) == false) goto L23;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L21
        r6.putOpt(EventBody.KEY_VALUE, r5.optString(EventBody.KEY_VALUE));     // Catch: Exception -> L21
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r8.get(DTraitConstant.D_I1), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        if (r7 == null) goto L18;
        int r12 = r7.getInt("index");     // Catch: Exception -> L21
    L19:
        r6.putOpt("index", Integer.valueOf(r12));     // Catch: Exception -> L21
        r11.put(DTraitConstant.D_I1, r6);     // Catch: Exception -> L21
        goto L23
    L18:
        r12 = -1;
    L23:
        r4 = r4 + 1;
    L21:
        e = move-exception;
        DTLog.e("[dt] appendCandidateFactorToMap# error: " + e.getMessage());
        goto L23
    L24:
        DTraitTraceUtil.stop(DTraitConstant.METHOD_APPEND_CANDIDATE_FACTOR_FROM_HEADERS);
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_APPEND_CANDIDATE_FACTOR_FROM_HEADERS, "appendCandidateFactorFromHeaders# append ipv6 to basic d map success!");
        return;
    }

    private byte[] appendTimeStampToBytesArray(byte[] r5) {
        if (r5 == null) goto L4;
        byte[] r4 = "_".getBytes();
        long r0 = (long) (System.currentTimeMillis() * 0.001d);
        ByteBuffer r2 = ByteBuffer.wrap(new byte[(r5.length + r4.length) + 8]);
        r2.order(ByteOrder.BIG_ENDIAN);
        r2.put(r5);
        r2.put(r4);
        r2.putLong(r0);
        return r2.array();
    L4:
        return new byte[0];
    }

    private Pair<String, byte[]> getBasicDTraitPair(DTraitRiskType r2) {
        int r3 = AnonymousClass4.$SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitRiskType[r2.ordinal()];
        if (r3 != 1) goto L5;
        byte[] r1 = this.highBasicDTraitValue;
        String r4 = DTraitConstant.KEY_DTRAIT_PK1;
    L10:
        return new Pair(r4, r1);
    L5:
        if (r3 == 2) goto L7;
        r1 = null;
        r4 = "";
        goto L10
    L7:
        r1 = this.lowBasicDTraitValue;
        r4 = DTraitConstant.KEY_DTRAIT_PK2;
        goto L10
    }

    private String getCacheOrWaitValue(String r6, String r7, String r8) {
        String r0 = this.cacheHandler.getCacheOrFromDisk(r8);
        if (TextUtils.isEmpty(r0) == false) goto L8;
        DTraitTraceUtil.start(r7);
        if (this.cacheHandler.awaitUpdate(30, TimeUnit.SECONDS) == false) goto L7;
        r0 = this.cacheHandler.getCacheOrFromDisk(r8);
    L7:
        DTraitTraceUtil.stop(r7);
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, r6, r7, String.format("%s# wait value..., excepted time:%ss", new Object[]{r7, 30}));
    L8:
        return r0;
    }

    private boolean isMarkNewUser() {
        SharedPreferences r4 = Utils.getCommonSp(this.context);
        if (r4.contains("device_id") == true) goto L5;
        return false;
    L5:
        if (r4.contains("install_id") == true) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r4.getString("device_id", "")) == false) goto L9;
    L10:
        return true;
    L9:
        if (TextUtils.isEmpty(r4.getString("install_id", "")) == true) goto L10;
        return false;
    }

    private void loadDTraitInfo() {
        String r3 = this.cacheHandler.getValueFromSp(DTraitConstant.KEY_DTRAIT_PK1);
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.dTraitInfo = new DTraitInfo(r3, this.cacheHandler.getValueFromSp(DTraitConstant.KEY_DTRAIT_PK2), this.cacheHandler.getValueFromSp(DTraitConstant.KEY_DTRAIT_PK1_VERSION), this.cacheHandler.getValueFromSp(DTraitConstant.KEY_DTRAIT_PK2_VERSION), this.cacheHandler.getValueFromSp(DTraitConstant.KEY_DTRAIT_TOKEN), this.cacheHandler.getValueFromSp(DTraitConstant.KEY_DTRAIT_VERSION), false);
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_LOAD_DTRAIT_INFO, "loadInfo success: " + this.dTraitInfo.toString());
        return;
    }

    private void onPlainEvent(boolean r1, String r2) {
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT);
        DTraitPlainEvent.setPlainResult(r1);
        DTraitPlainEvent.setError(r2);
        DTraitPlainEvent.setDuration(DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT));
        DTraitPlainEvent.onEvent();
    }

    private void preHandleDTrait(JSONObject r3) {
        this.preHandleDTraitLock.lock();
        addCollectors(20000);     // Catch: Throwable -> L6
        collect();     // Catch: Throwable -> L6
        appendCandidateFactorFromHeaders(r3, this.basicDTraitMap);     // Catch: Throwable -> L6
        this.preHandleDTraitLock.unlock();
        return;
    L6:
        th = move-exception;
        this.preHandleDTraitLock.unlock();
        throw th;
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public void addCollectors(long r4) {
        if (this.configHandler.getDTraitFiledsMap().isEmpty() == false) goto L9;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "parseCollectorByConfig# config map is empty, again fetch config from cache.");
        String r5 = this.cacheHandler.getCacheOrFromDisk(DTraitConstant.KEY_D_DATA);
        if (TextUtils.isEmpty(r5) == true) goto L9;
        JSONObject r0 = new JSONObject();
        r0.putOpt("message", "ok");     // Catch: Exception -> L18
        r0.putOpt("data", r5);     // Catch: Exception -> L18
        this.configHandler.parseLoaderConfig(r0);     // Catch: Exception -> L18
    L9:
        if (this.configHandler.getDTraitFiledsMap().isEmpty() == false) goto L12;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_ADD_COLLECT, "again fetch config from cache error, return");
        return;
    L12:
        Map<String, JSONObject> r6 = this.configHandler.getDTraitFiledsMap();
        if (r6.isEmpty() == false) goto L16;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "parseCollectorByConfig# config map is empty");
        return;
    L16:
        addLoader(r6);
    }

    public void bindDTrait(final JSONObject r2) {
        ExecutorUtil.runOnNetExecutor(new AnonymousClass3(this, r2));
    }

    public void cacheDTraitInfo(DTraitInfo r3) {
        this.dTraitInfo = r3;
        this.cacheHandler.updateMemoryCache(r3.getCacheMap());
        this.cacheHandler.updateDiskCache(r3.getCacheMap());
        DTraitLogLevel r4 = DTraitLogLevel.DEBUG;
        Object[] r0 = new Object[1];
        if (this.dTraitInfo == null) goto L5;
        String r2 = this.dTraitInfo.toString();
    L6:
        r0[0] = r2;
        DTraitTraceUtil.log(r4, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_CACHE_DTRAIT_INFO, String.format("cDt# update dtraitInfo success from server: %s", r0));
        return;
    L5:
        r2 = "";
        goto L6
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public void collect() {
        DTraitTraceUtil.start(DTraitConstant.METHOD_COLLECT_DTRAIT_MAP);
        if (this.loaderList.size() > 0) goto L6;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# loaderList is 0, return.");
        return;
    L6:
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# loaderList size: " + this.loaderList.size());
        int r1 = 0;
    L8:
        if (r1 >= this.loaderList.size()) goto L18;
        ExtraLoaderInfo r3 = ((BaseExtraLoader) ZeusTransformUtils.preCheckCast(this.loaderList.get(r1), BaseExtraLoader.class, "com.obric.memorydata.plugin")).doLoad();     // Catch: Exception -> L15
        if (r3 == null) goto L17;
        if (TextUtils.isEmpty(r3.getName()) == true) goto L17;
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L15
        r4.putOpt(EventBody.KEY_VALUE, r3.getData());     // Catch: Exception -> L15
        r4.putOpt("index", Integer.valueOf(r3.getIndex()));     // Catch: Exception -> L15
        this.basicDTraitMap.put(r3.getName(), r4);     // Catch: Exception -> L15
    L17:
        r1 = r1 + 1;
    L15:
        e = move-exception;
        DTLog.e(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# error " + Log.getStackTraceString(e));
        goto L17
    L18:
        DTraitTraceUtil.stop(DTraitConstant.METHOD_COLLECT_DTRAIT_MAP);
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_COLLECT_DTRAIT_MAP, "collect# d map:" + this.basicDTraitMap.keySet());
    }

    public void generateBasicDTrait(String r9) {
        this.lock.lock();
        DTraitTraceUtil.start(DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT);     // Catch: Throwable -> L54
        DTraitPlainEvent.setBusinessPath(r9);     // Catch: Throwable -> L54
        DTraitTraceUtil.start(DTraitConstant.METHOD_WAIT_DTRAIT_VERSION);     // Catch: Throwable -> L54
        if (this.highBasicDTraitValue != null) goto L6;
    L13:
        String r1 = getCacheOrWaitValue(r9, DTraitConstant.METHOD_WAIT_DTRAIT_VERSION, DTraitConstant.KEY_DTRAIT_VERSION);     // Catch: Throwable -> L54
        if (TextUtils.equals(r1, String.valueOf(-1000)) == false) goto L16;
    L52:
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, r9, DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT, "gbd# device_register response's dtrait_version is empty, default dtrait_version: " + r1);     // Catch: Throwable -> L54
        String r0 = "dtrait version from server is empty";
    L34:
        onPlainEvent(false, r0);     // Catch: Throwable -> L54
    L11:
        this.lock.unlock();
        return;
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L52;
        if (this.highBasicDTraitValue == null) goto L24;
        if (this.highBasicDTraitValue.length <= 0) goto L24;
        DTLog.d("[dt] gbd# highBasicDTraitValue build fail, return ");     // Catch: Throwable -> L54
    L24:
        if (this.basicDTraitMap.isEmpty() == false) goto L32;
        JSONObject r4 = null;
        if (DTraitConfig.getDtraitInterface() == null) goto L28;
        r4 = DTraitConfig.getDtraitInterface().getDeviceHeader();     // Catch: Throwable -> L54
    L28:
        if (r4 != null) goto L30;
        r4 = new JSONObject();     // Catch: Throwable -> L54
    L30:
        preHandleDTrait(r4);     // Catch: Throwable -> L54
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, r9, DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT, "gbd# basicDTraitMap is empty, again fetch collect().");     // Catch: Throwable -> L54
    L32:
        if (this.basicDTraitMap.isEmpty() == false) goto L35;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, r9, DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT, "gbd# basicDTraitMap is empty, fetch collect() failure return.");     // Catch: Throwable -> L54
        r0 = "basicDTraitMap is empty";
        goto L34
    L35:
        this.highBasicDTraitValue = this.dTraitNativeManager.getMMMapResult(this.basicDTraitMap, Integer.parseInt(r1), 0, DTraitRiskType.HIGH.getValue());     // Catch: Throwable -> L54
        this.lowBasicDTraitValue = this.dTraitNativeManager.getMMMapResult(this.basicDTraitMap, Integer.parseInt(r1), 0, DTraitRiskType.LOW.getValue());     // Catch: Throwable -> L54
        if (DTLog.debug() == false) goto L41;
        Iterator<Map.Entry<String, JSONObject>> r2 = this.basicDTraitMap.entrySet().iterator();     // Catch: Throwable -> L54
    L39:
        if (r2.hasNext() == false) goto L41;
        DTLog.d("[dt] gbd# get basicDTraitMap map: " + ((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L54
    L41:
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, r9, DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT, "write basic d success high size:" + this.highBasicDTraitValue.length + ", low size:" + this.lowBasicDTraitValue.length + ", keyMaps: " + Arrays.toString(this.basicDTraitMap.keySet().toArray()));     // Catch: Throwable -> L54
        if (this.highBasicDTraitValue != null) goto L44;
    L50:
        boolean r3 = false;
    L51:
        onPlainEvent(r3, "");     // Catch: Throwable -> L54
    L56:
        this.lock.unlock();
        return;
    L44:
        if (this.highBasicDTraitValue.length <= 0) goto L50;
        if (this.lowBasicDTraitValue == null) goto L50;
        if (this.lowBasicDTraitValue.length <= 0) goto L50;
        r3 = true;
        goto L51
    L6:
        if (this.highBasicDTraitValue.length <= 0) goto L13;
        if (this.lowBasicDTraitValue == null) goto L13;
        if (this.lowBasicDTraitValue.length <= 0) goto L13;
    L54:
        th = move-exception;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, r9, DTraitConstant.METHOD_GENERATE_BASIC_DTRAIT, "gbd error: " + th.getMessage(), th);     // Catch: Throwable -> L58
        onPlainEvent(false, th.getMessage());     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public String generateEncryptBase64DTrait(String r19, DTraitRiskType r20, int r21) {
        this.lock.lock();
        DTraitCipherEvent.setBusinessPath(r19);     // Catch: Throwable -> L46
        DTraitCipherEvent.setExpectedTime(r21);     // Catch: Throwable -> L46
        DTraitTraceUtil.start(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT);     // Catch: Throwable -> L46
        if (r20 != DTraitRiskType.HIGH) goto L6;
        int r7 = 0;
    L7:
        DTraitCipherEvent.setRiskType(r7);     // Catch: Throwable -> L46
        if (this.dTraitInfo == null) goto L13;
        String r8 = this.dTraitInfo.getDTraitToken();     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r8) == true) goto L13;
        DTraitCipherEvent.setdT(r8.substring(0, (int) (((double) r8.length()) * 0.25d)));     // Catch: Throwable -> L46
    L13:
        if (this.highBasicDTraitValue != null) goto L15;
    L44:
        DTLog.w("[dt] ed# highBasicDTraitValue or lowBasicDTraitValue is null", null);     // Catch: Throwable -> L46
    L42:
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT);
        DTraitCipherEvent.setEncryptResult(!this.encryptBasicDTraitCacheMap.isEmpty());
        DTraitCipherEvent.setDuration(DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT));
        DTraitCipherEvent.onEvent();
        DTraitTraceUtil.reportLogs(this.context);
        DTraitTimeMonitorEvent.setPreHandleDTraitFinish();
        this.lock.unlock();
        return "";
    L15:
        if (this.lowBasicDTraitValue == null) goto L44;
        Pair<String, byte[]> r9 = getBasicDTraitPair(r20);     // Catch: Throwable -> L46
        byte[] r10 = (byte[]) ZeusTransformUtils.preCheckCast(r9.second, byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        EncryptDTraitEntry r3 = (EncryptDTraitEntry) ZeusTransformUtils.preCheckCast(this.encryptBasicDTraitCacheMap.get(r11), EncryptDTraitEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        if (r3 != null) goto L20;
    L26:
        String r4 = getCacheOrWaitValue(r19, DTraitConstant.METHOD_WAIT_PUBLIC_KEY, r11);     // Catch: Throwable -> L46
        if (this.dTraitInfo != null) goto L29;
    L37:
        DTraitLogLevel r12 = DTraitLogLevel.ERROR;     // Catch: Throwable -> L46
        Object[] r13 = new Object[3];     // Catch: Throwable -> L46
        if (this.dTraitInfo != null) goto L40;
        boolean r14 = true;
    L41:
        r13[0] = Boolean.valueOf(r14);     // Catch: Throwable -> L46
        r13[1] = Boolean.valueOf(TextUtils.isEmpty(r4));     // Catch: Throwable -> L46
        r13[2] = r20;     // Catch: Throwable -> L46
        DTraitTraceUtil.log(r12, r19, DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT, String.format("ed# dt is null? %s or pk is empty? %s type: %s, return method", r13));     // Catch: Throwable -> L46
        goto L42
    L40:
        r14 = false;
        goto L41
    L29:
        if (TextUtils.isEmpty(r4) == true) goto L37;
        String r15 = this.dTraitInfo.getPKVersionByType(r20) + "_" + Utils.getEncryptBase64StrByRSA(appendTimeStampToBytesArray(r10), r4);     // Catch: Throwable -> L46
        this.encryptBasicDTraitCacheMap.put(r11, new EncryptDTraitEntry(r15, System.currentTimeMillis() + this.configHandler.getDtraitExpireTime()));     // Catch: Throwable -> L46
        if (this.isBindDTraitCountDown.get() == true) goto L34;
        this.countDownLatch.countDown();     // Catch: Throwable -> L46
        this.isBindDTraitCountDown.set(true);     // Catch: Throwable -> L46
    L34:
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, r19, DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT, String.format("ed# encrypt key:%s, type: %s, result=%s, pk: %s", new Object[]{r11, r20, r15, r4}));     // Catch: Throwable -> L46
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT);
        DTraitCipherEvent.setEncryptResult(!this.encryptBasicDTraitCacheMap.isEmpty());
        DTraitCipherEvent.setDuration(DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT));
        DTraitCipherEvent.onEvent();
        DTraitTraceUtil.reportLogs(this.context);
        DTraitTimeMonitorEvent.setPreHandleDTraitFinish();
        this.lock.unlock();
        return r15;
    L20:
        if (TextUtils.isEmpty(EncryptDTraitEntry.access$800(r3)) == true) goto L26;
        if (isExpired(r3) == true) goto L26;
        DTraitCipherEvent.setUseCache(true);     // Catch: Throwable -> L46
        DTLog.d("[dt] ed# return memory " + r20 + " type cache!");     // Catch: Throwable -> L46
        String r0 = EncryptDTraitEntry.access$800(r3);     // Catch: Throwable -> L46
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT);
        DTraitCipherEvent.setEncryptResult(!this.encryptBasicDTraitCacheMap.isEmpty());
        DTraitCipherEvent.setDuration(DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT));
        DTraitCipherEvent.onEvent();
        DTraitTraceUtil.reportLogs(this.context);
        DTraitTimeMonitorEvent.setPreHandleDTraitFinish();
        this.lock.unlock();
        return r0;
    L6:
        r7 = 1;
    L46:
        th = move-exception;
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, r19, DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT, "ed# encrypt msg= " + th.getMessage());     // Catch: Throwable -> L50
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT);
        DTraitCipherEvent.setEncryptResult(!this.encryptBasicDTraitCacheMap.isEmpty());
        DTraitCipherEvent.setDuration(DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT));
        DTraitCipherEvent.onEvent();
        DTraitTraceUtil.reportLogs(this.context);
        DTraitTimeMonitorEvent.setPreHandleDTraitFinish();
        this.lock.unlock();
        return "";
    L50:
        th = move-exception;
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT);
        DTraitCipherEvent.setEncryptResult(!this.encryptBasicDTraitCacheMap.isEmpty());
        DTraitCipherEvent.setDuration(DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_GENERATE_BASE_64_ENCRYPT_BASIC_DTRAIT));
        DTraitCipherEvent.onEvent();
        DTraitTraceUtil.reportLogs(this.context);
        DTraitTimeMonitorEvent.setPreHandleDTraitFinish();
        this.lock.unlock();
        throw th;
    }

    public String getDTraitToken() {
        if (this.dTraitInfo != null) goto L5;
        return "";
    L5:
        return this.dTraitInfo.getDTraitToken();
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public List<String> getLoaderWhiteList() {
        this.whiteList.add(DTraitConstant.D_I0);
        this.whiteList.add(DTraitConstant.D_A0);
        this.whiteList.add(DTraitConstant.D_R0);
        this.whiteList.add(DTraitConstant.D_B0);
        return this.whiteList;
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public String getTAG() {
        return "[factorLoader] ";
    }

    public void handleDTrait(final JSONObject r2, final String r3) {
        ExecutorUtil.runOnIOExecutor(new AnonymousClass2(this, r2, r3));
    }

    public boolean isExpired(EncryptDTraitEntry r3) {
        if (System.currentTimeMillis() <= r3.getExpireAt()) goto L5;
        return true;
    L5:
        return false;
    }

    public void preHandleConfig() {
        this.handler.post(new AnonymousClass1(this));
    }
}
