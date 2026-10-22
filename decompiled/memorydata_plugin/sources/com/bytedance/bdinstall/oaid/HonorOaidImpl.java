package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.bytedance.bdinstall.honor.HonorOAIDCallback;
import com.bytedance.bdinstall.honor.HonorOAIDLimitCallback;
import com.bytedance.bdinstall.oaid.impl.IOAIDService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class HonorOaidImpl extends BaseOaidImpl<IOAIDService> {
    final HonorOAIDLimitCallback limitCallback;
    final HonorOAIDCallback oaidCallback;

    HonorOaidImpl() {
        super("com.hihonor.id");
        this.oaidCallback = new HonorOAIDCallback();
        this.limitCallback = new HonorOAIDLimitCallback();
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public Intent buildIntent(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intent r3 = new Intent();
        r3.setAction("com.hihonor.id.HnOaIdService");
        r3.setPackage("com.hihonor.id");
        return r3;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public ServiceBlockBinder.ServiceBindedListener<IOAIDService, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return HonorKeys.NAME;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        OaidApi.Result r0 = new OaidApi.Result();
        new ServiceBlockBinder(r6, buildIntent(r6), buildServiceImpl()).blockFetchResult();     // Catch: Exception -> L5
        r0.oaid = this.oaidCallback.getOaid();     // Catch: Exception -> L5
        r0.isTrackLimit = this.limitCallback.isLimit();     // Catch: Exception -> L5
        DrLog.d("honor# getOaid " + r0.oaid);     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public /* synthetic */ boolean support(Context r3) {
        return super.support((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }
}
