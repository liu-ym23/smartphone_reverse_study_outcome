package com.bytedance.bdinstall.dtrait;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.constant.DTraitEnum;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.executor.ExecutorUtil;
import com.bytedance.bdinstall.dtrait.extra_finger.ExtraLoaderConfigHandler;
import com.bytedance.bdinstall.dtrait.handler.DTraitCollectHandlerImpl;
import com.bytedance.bdinstall.dtrait.handler.DTraitFactorHandlerImpl;
import com.bytedance.bdinstall.dtrait.handler.DTraitLoaderHandlerFactory;
import com.bytedance.bdinstall.dtrait.manager.DTraitCacheManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;
import com.bytedance.bdinstall.dtrait.model.DTraitInfo;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitProcessor {
    private final DTraitCollectHandlerImpl collectHandler;
    private volatile Future<String> dTraitFuture;
    private final Map<String, DTraitCacheEntry> dtraitCacheMap;
    private final DTraitFactorHandlerImpl factorHandler;
    private final AtomicBoolean isUpdating;
    private final Object updateMonitor;

    static class DTraitCacheEntry {
        private final long expireAt;
        private final Map<String, String> value;

        public DTraitCacheEntry(Map<String, String> r3) {
            this.value = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.expireAt = System.currentTimeMillis();
        }

        public Map<String, String> getValue() {
            return this.value;
        }

        public boolean isValid() {
            if ((System.currentTimeMillis() - this.expireAt) >= DTraitConfig.getDtraitExipreTime()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public DTraitProcessor(Context r9, DTraitCacheManager r10, DTraitNativeManager r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        this.isUpdating = new AtomicBoolean(false);
        this.updateMonitor = new Object();
        ExtraLoaderConfigHandler r0 = new ExtraLoaderConfigHandler(r13, r10);
        this.collectHandler = (DTraitCollectHandlerImpl) ZeusTransformUtils.preCheckCast(DTraitLoaderHandlerFactory.createLoaderHandler(DTraitEnum.COLLECT, r13, r0, r10, r11, r12), DTraitCollectHandlerImpl.class, "com.obric.memorydata.plugin");
        this.factorHandler = (DTraitFactorHandlerImpl) ZeusTransformUtils.preCheckCast(DTraitLoaderHandlerFactory.createLoaderHandler(DTraitEnum.FACTOR, r13, r0, r10, r11, r12), DTraitFactorHandlerImpl.class, "com.obric.memorydata.plugin");
        this.dtraitCacheMap = new ConcurrentHashMap();
    }

    static /* synthetic */ DTraitFactorHandlerImpl access$000(DTraitProcessor r0) {
        return r0.factorHandler;
    }

    private Map<String, String> generateDTrait(final String r5, final DTraitRiskType r6, final int r7) {
        HashMap r1 = new HashMap();
        this.dTraitFuture = ExecutorUtil.submitToDtraitExecutor(new AnonymousClass1(this, r5, r6, r7));
        DTraitTraceUtil.start(DTraitConstant.METHOD_GET_DTRAIT);     // Catch: Exception -> L14
        String r8 = (String) ZeusTransformUtils.preCheckCast(this.dTraitFuture.get(r7, TimeUnit.MILLISECONDS), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r8) == true) goto L7;
        r1.put(DTraitConstant.HEADER_DTRAIT, r8);     // Catch: Exception -> L14
    L7:
        if (TextUtils.isEmpty(this.factorHandler.getDTraitToken()) == true) goto L10;
        r1.put(DTraitConstant.HEADER_DTRAIT_TOKEN, this.factorHandler.getDTraitToken());     // Catch: Exception -> L14
    L10:
        if (DTLog.debug() == false) goto L12;
        DTLog.d("[dt] getDTrait# resultMap, dtrait: " + r8 + "\n token: " + this.factorHandler.getDTraitToken());     // Catch: Exception -> L14
    L12:
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GET_DTRAIT);     // Catch: Exception -> L14
    L16:
        return r1;
    L14:
        e = move-exception;
        DTraitTraceUtil.stop(DTraitConstant.METHOD_GET_DTRAIT);
        DTraitTraceUtil.log(DTraitLogLevel.ERROR, r5, DTraitConstant.METHOD_GET_DTRAIT, "getDTrait# error: " + e.getMessage(), e);
        goto L16
    }

    public void bindDTrait(JSONObject r1) {
        this.factorHandler.bindDTrait(r1);
    }

    public void cacheDTraitInfo(DTraitInfo r1) {
        this.factorHandler.cacheDTraitInfo(r1);
    }

    public void doDTraitCollectReport(JSONObject r1) {
        this.collectHandler.doDTraitCollectReport(r1);
    }

    public Map<String, String> getDTrait(String r8, DTraitRiskType r9, int r10) {
        if (DTraitConfig.isEnableDTrait() == false) goto L5;
        long r0 = System.currentTimeMillis();
        DTraitCacheEntry r2 = (DTraitCacheEntry) ZeusTransformUtils.preCheckCast(this.dtraitCacheMap.get(r9.getValue()), DTraitCacheEntry.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        if (r2.isValid() == false) goto L16;
        if (DTLog.debug() == false) goto L14;
        DTLog.d("[dt] getDTrait# dtrait缓存=" + r2.getValue());
    L14:
        return r2.getValue();
    L16:
        if (this.isUpdating.compareAndSet(false, true) == true) goto L93;
        long r3 = ((long) r10) - (System.currentTimeMillis() - r0);
        if (DTLog.debug() == false) goto L57;
        DTLog.d("[dt] getDTrait# 更新失败，尝试等待 " + Thread.currentThread().getName() + r3 + "ms");
    L57:
        if (r3 <= 0) goto L78;
        Object r11 = this.updateMonitor;
        monitor-enter(r11);
        this.updateMonitor.wait(r3);     // Catch: Throwable -> L62 InterruptedException -> L64
    L65:
        monitor-exit(r11);     // Catch: Throwable -> L62
        r2 = (DTraitCacheEntry) ZeusTransformUtils.preCheckCast(this.dtraitCacheMap.get(r9.getValue()), DTraitCacheEntry.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L78;
        if (r2.isValid() == false) goto L78;
        if (DTLog.debug() == false) goto L74;
        DTLog.d("[dt] getDTrait# 等待成功 " + Thread.currentThread().getName() + r2.getValue());
    L74:
        return r2.getValue();
    L64:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;
    L78:
        if (DTLog.debug() == false) goto L80;
        DTLog.d("[dt] getDTrait# 等待后仍未获取到最新数据，返回历史数据 " + Thread.currentThread().getName());
    L80:
        if (r2 == null) goto L83;
        return r2.getValue();
    L83:
        return new HashMap();
    L93:
        DTraitCacheEntry r1 = (DTraitCacheEntry) ZeusTransformUtils.preCheckCast(this.dtraitCacheMap.get(r9.getValue()), DTraitCacheEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r1 == null) goto L31;
        if (r1.isValid() == false) goto L31;
        Map<String, String> r12 = r1.getValue();     // Catch: Throwable -> L44
        this.isUpdating.set(false);
        Object r13 = this.updateMonitor;
        monitor-enter(r13);
        this.updateMonitor.notifyAll();     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        return r12;
    L27:
        th = move-exception;
        throw th;
    L31:
        if (DTLog.debug() == false) goto L33;
        DTLog.d("[dt] getDTrait# 尝试更新数据 " + Thread.currentThread().getName());     // Catch: Throwable -> L44
    L33:
        Map<String, String> r14 = generateDTrait(r8, r9, r10);     // Catch: Throwable -> L44
        if (r14.isEmpty() == true) goto L36;
        this.dtraitCacheMap.put(r9.getValue(), new DTraitCacheEntry(r14));     // Catch: Throwable -> L44
    L36:
        this.isUpdating.set(false);
        Object r15 = this.updateMonitor;
        monitor-enter(r15);
        this.updateMonitor.notifyAll();     // Catch: Throwable -> L41
        monitor-exit(r15);     // Catch: Throwable -> L41
        return r14;
    L41:
        th = move-exception;
        throw th;
    L44:
        th = move-exception;
        this.isUpdating.set(false);
        monitor-enter(this.updateMonitor);
        this.updateMonitor.notifyAll();     // Catch: Throwable -> L50
        throw th;
    L50:
        th = move-exception;
        throw th;
    L5:
        return new HashMap();
    }

    public void handleDTrait(JSONObject r1, String r2) {
        this.factorHandler.handleDTrait(r1, r2);
    }

    public void preHandleConfigForDTrait() {
        this.factorHandler.preHandleConfig();
    }
}
