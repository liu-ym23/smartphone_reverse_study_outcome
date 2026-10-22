package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseOaidImpl<SERVICE> implements OaidApi {
    private final String packageName;
    private final Singleton<Boolean> support;

    BaseOaidImpl(String r10) {
        this.support = new AnonymousClass1(this);
        this.packageName = r10;
    }

    static /* synthetic */ String access$000(BaseOaidImpl r10) {
        return r10.packageName;
    }

    private OaidApi.Result wrapOaid(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        OaidApi.Result r11 = new OaidApi.Result();
        r11.oaid = r10;
        return r11;
    }

    protected abstract Intent buildIntent(Context r10);

    protected abstract ServiceBlockBinder.ServiceBindedListener<SERVICE, String> buildServiceImpl();

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
        return wrapOaid((String) new ServiceBlockBinder(r10, buildIntent(r10), buildServiceImpl()).blockFetchResult());
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return this.support.get(new Object[]{r10}).booleanValue();
    }
}
