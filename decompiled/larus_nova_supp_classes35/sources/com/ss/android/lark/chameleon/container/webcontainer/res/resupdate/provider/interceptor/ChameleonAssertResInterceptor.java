package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor;

import android.content.Context;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResource;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAssertResInterceptor;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor;", "()V", "getResource", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResource;", "context", "Landroid/content/Context;", "ChameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "sync", BuildConfig.FLAVOR, "session", BuildConfig.FLAVOR, "shouldIntercept", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonAssertResInterceptor extends ChameleonAbsResInterceptor {
    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor
    public boolean shouldIntercept(Context r1, ChameleonConfig r2) {
        return true;
    }

    public ChameleonAssertResInterceptor() {
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor
    public ChameleonResource getResource(Context r3, ChameleonConfig r4, boolean r5, String r6) {
        Log.i(ChameleonAbsResInterceptor.TAG, "getResource, use assert");
        return getDefaultResource(r3, r4, r5, r6);
    }
}
