package com.bytedance.bdinstall.dtrait.handler;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.DTraitService;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.executor.ExecutorUtil;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.bytedance.bdinstall.dtrait.extra_finger.ExtraLoaderConfigHandler;
import com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler;
import com.bytedance.bdinstall.dtrait.manager.DTraitCacheManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.bytedance.bdinstall.dtrait.model.ExtraLoaderInfo;
import com.bytedance.bdinstall.dtrait.utils.Utils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitCollectHandlerImpl extends AbsLoaderHandler {
    private volatile String encryptDTraitResult;
    private final Map<String, ExtraLoaderInfo> extraLoaderInfoMap;
    private final List<String> whiteList;

    public DTraitCollectHandlerImpl(Context r2, ExtraLoaderConfigHandler r3, DTraitCacheManager r4, DTraitNativeManager r5, boolean r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r6);
        this.encryptDTraitResult = "";
        this.extraLoaderInfoMap = new HashMap();
        this.whiteList = new ArrayList();
    }

    static /* synthetic */ DTraitCacheManager access$000(DTraitCollectHandlerImpl r0) {
        return r0.cacheHandler;
    }

    static /* synthetic */ Context access$100(DTraitCollectHandlerImpl r0) {
        return r0.context;
    }

    static /* synthetic */ boolean access$200(DTraitCollectHandlerImpl r0) {
        return r0.hasLocalDid;
    }

    static /* synthetic */ ExtraLoaderConfigHandler access$300(DTraitCollectHandlerImpl r0) {
        return r0.configHandler;
    }

    static /* synthetic */ boolean access$400(DTraitCollectHandlerImpl r0) {
        return r0.hasLocalDid;
    }

    static /* synthetic */ void access$500(DTraitCollectHandlerImpl r0, JSONObject r1, boolean r2) {
        r0.report(r1, r2);
    }

    static /* synthetic */ String access$600(DTraitCollectHandlerImpl r0) {
        return r0.encryptDTraitResult;
    }

    static /* synthetic */ ExtraLoaderConfigHandler access$700(DTraitCollectHandlerImpl r0) {
        return r0.configHandler;
    }

    static /* synthetic */ Context access$800(DTraitCollectHandlerImpl r0) {
        return r0.context;
    }

    static /* synthetic */ ExtraLoaderConfigHandler access$900(DTraitCollectHandlerImpl r0) {
        return r0.configHandler;
    }

    private void report(final JSONObject r8, final boolean r9) {
        if (this.extraLoaderInfoMap.size() > 0) goto L6;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "doReport# loaderInfoList is 0, return.");
        return;
    L6:
        final JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, ExtraLoaderInfo>> r2 = this.extraLoaderInfoMap.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.putOpt((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), Utils.encryptByBDSword(((ExtraLoaderInfo) ZeusTransformUtils.preCheckCast(r3.getValue(), ExtraLoaderInfo.class, "com.obric.memorydata.plugin")).getResult()));     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        Logger.e(DTraitConstant.TAG_DTRAIT + getTAG() + "doReport# error " + e.getMessage());
        goto L8
    L15:
        if (DTraitConfig.isEnableDTrait() == false) goto L19;
        DTraitService r4 = (DTraitService) ZeusTransformUtils.preCheckCast(DTraitServiceManager.getService(DTraitService.class), DTraitService.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        Logger.d(DTraitConstant.TAG_DTRAIT + getTAG() + "LoaderManager#statsCollect start get dtrait...... ");
        this.encryptDTraitResult = (String) ZeusTransformUtils.preCheckCast(r4.getDTraitManager().getDTrait(DTraitConstant.BUSINESS_TAG_STATUS_COLLECT, DTraitRiskType.HIGH, LocationInfoConst.HALF_MINUTES).get(DTraitConstant.HEADER_DTRAIT), String.class, "com.obric.memorydata.plugin");
    L19:
        ExecutorUtil.runOnNetExecutor(new AnonymousClass2(this, r8, r0, r9));
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public void addCollectors(long r1) {
        Map<String, JSONObject> r2 = this.configHandler.getFiledsMap();
        if (r2.isEmpty() == false) goto L6;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "parseCollectorByConfig# config map is empty");
        return;
    L6:
        addLoader(r2);
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public void collect() {
        if (this.loaderList.size() > 0) goto L6;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# futureList is 0, return.");
        return;
    L6:
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# futureList size: " + this.loaderList.size());
        ExecutorCompletionService r0 = new ExecutorCompletionService(ExecutorUtil.getDtraitLoaderExecutor());
        Iterator<BaseExtraLoader> r2 = this.loaderList.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.submit((BaseExtraLoader) ZeusTransformUtils.preCheckCast(r2.next(), BaseExtraLoader.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        int r3 = 0;
    L12:
        if (r3 >= this.loaderList.size()) goto L20;
        ExtraLoaderInfo r4 = (ExtraLoaderInfo) ZeusTransformUtils.preCheckCast(r0.take().get(5, TimeUnit.SECONDS), ExtraLoaderInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        this.extraLoaderInfoMap.put(r4.getName(), r4);     // Catch: Exception -> L17
        if (DTLog.debug() == false) goto L19;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# result: " + r4);     // Catch: Exception -> L17
    L19:
        r3 = r3 + 1;
    L17:
        e = move-exception;
        DTLog.e(DTraitConstant.TAG_DTRAIT + getTAG() + "doCollect# error " + e.getMessage());
        goto L19
    }

    public void doDTraitCollectReport(final JSONObject r3) {
        DTLog.d(DTraitConstant.TAG_DTRAIT + getTAG() + "start collect loader......");
        ExecutorUtil.getHandler().postDelayed(new AnonymousClass1(this, r3), this.configHandler.getDelayTime());
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public List<String> getLoaderWhiteList() {
        this.whiteList.add(DTraitConstant.D_I0);
        this.whiteList.add(DTraitConstant.D_A0);
        this.whiteList.add(DTraitConstant.D_R0);
        this.whiteList.add(DTraitConstant.D_B0);
        this.whiteList.add(DTraitConstant.D_M0);
        return this.whiteList;
    }

    @Override // com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler
    public String getTAG() {
        return "[collectLoader] ";
    }
}
