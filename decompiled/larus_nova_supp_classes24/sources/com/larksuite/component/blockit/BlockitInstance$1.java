package com.larksuite.component.blockit;

import android.view.ViewGroup;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.service.BlockitService;
import com.larksuite.component.blockit.service.IGetDataCallbackWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
class BlockitInstance$1 implements IGetDataCallbackWrapper<BlockEntity> {
    final /* synthetic */ b this$0;
    final /* synthetic */ String val$blockId;
    final /* synthetic */ com.larksuite.component.blockit.core.a val$blockitContext;
    final /* synthetic */ boolean val$enableEntityCache;
    final /* synthetic */ c val$listener;
    final /* synthetic */ com.larksuite.component.blockit.core.b val$opContainerBundle;
    final /* synthetic */ Set val$providerSet;
    final /* synthetic */ ViewGroup val$rootView;
    final /* synthetic */ BlockEntity val$sourceEntity;
    final /* synthetic */ long val$startEntityTimestamp;

    @Override // com.larksuite.component.blockit.service.IGetDataCallbackWrapper, com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public final /* synthetic */ void onSuccess(Object r1) {
        IGetDataCallbackWrapper.CC.$default$onSuccess(this, r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r5) {
        AppBrandLogger.i("BlockitInstance", new Object[]{"request blockTypeId onError " + r5.getDebugMsg()});
        if (r5.getStatus() != 1) goto L5;
        d r0 = (d) ApiUtils.getApi(d.class);
        ncb.b r1 = ncb.b.a;
        r0.f();
    L6:
        r5.getDisplayMsg();
        throw null;
    L5:
        d r2 = (d) ApiUtils.getApi(d.class);
        ncb.b r3 = ncb.b.a;
        r2.f();
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public void onSuccess2(BlockEntity r5, IGetDataCallbackWrapper.a r6) {
        AppBrandLogger.i("BlockitInstance", new Object[]{"request block success, blockId:" + this.val$blockId});
        r5.setAppID(this.val$sourceEntity.getAppID());
        com.larksuite.component.blockit.core.b r0 = this.val$opContainerBundle;
        b r1 = this.this$0;
        ncb.b r2 = ncb.b.f;
        r1.getClass();
        OPMonitor r3 = b.a(r2, r0, r5).setResultTypeSuccess().addCategoryValue("use_cache", Integer.valueOf(r6.a ? 1 : 0)).addCategoryValue("enable_cache", Boolean.valueOf(((BlockitService.BlockCacheMGetBlockEntityV2ConfigModel) SettingManager.getInstance().get(BlockitService.BlockCacheMGetBlockEntityV2ConfigModel.class)).enable)).addCategoryValue("use_cache_when_fetch_fail", Boolean.valueOf(this.val$enableEntityCache)).addCategoryValue("cache_timestamp", Long.valueOf(r6.b));
        if (r6.a == false) goto L5;
        String r7 = "cache";
    L6:
        r3.addCategoryValue("from", r7).addMetricValue("duration", Long.valueOf(System.currentTimeMillis() - this.val$startEntityTimestamp)).flush();
        b r8 = this.this$0;
        ncb.b r4 = ncb.b.a;
        com.larksuite.component.blockit.core.b r9 = this.val$opContainerBundle;
        r8.getClass();
        b.a(r4, r9, r5).addCategoryValue("block_id", r5.getBlockID()).setResultTypeSuccess().flush();
        ((d) ApiUtils.getApi(d.class)).d();
        return;
    L5:
        r7 = "network";
        goto L6
    }

    @Override // com.larksuite.component.blockit.service.IGetDataCallbackWrapper
    public /* bridge */ /* synthetic */ void onSuccess(BlockEntity r1, IGetDataCallbackWrapper.a r2) {
        onSuccess2(r1, r2);
    }

    public BlockitInstance$1(b r1, String r2, BlockEntity r3, com.larksuite.component.blockit.core.b r4, boolean r5, long r6, ViewGroup r8, c r9, Set r10, com.larksuite.component.blockit.core.a r11) {
        this.this$0 = r1;
        this.val$blockId = r2;
        this.val$sourceEntity = r3;
        this.val$opContainerBundle = r4;
        this.val$enableEntityCache = r5;
        this.val$startEntityTimestamp = r6;
        this.val$rootView = r8;
        this.val$providerSet = r10;
    }
}
