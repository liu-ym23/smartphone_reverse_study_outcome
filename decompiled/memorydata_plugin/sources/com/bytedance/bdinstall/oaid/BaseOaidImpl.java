package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseOaidImpl<SERVICE> implements OaidApi {
    private final String packageName;
    private final Singleton<Boolean> support;

    BaseOaidImpl(String r2) {
        this.support = new AnonymousClass1(this);
        this.packageName = r2;
    }

    static /* synthetic */ String access$000(BaseOaidImpl r0) {
        return r0.packageName;
    }

    private OaidApi.Result wrapOaid(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        OaidApi.Result r0 = new OaidApi.Result();
        r0.oaid = r1;
        return r0;
    }

    public abstract Intent buildIntent(Context r1);

    public abstract ServiceBlockBinder.ServiceBindedListener<SERVICE, String> buildServiceImpl();

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        return wrapOaid((String) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder(r6, buildIntent(r6), buildServiceImpl()).blockFetchResult(), String.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.support.get(new Object[]{r5}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}
