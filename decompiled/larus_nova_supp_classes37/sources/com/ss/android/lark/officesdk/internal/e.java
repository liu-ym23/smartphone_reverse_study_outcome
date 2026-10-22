package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKGlobalScope
public final class e implements OfficeSDKGlobalApi {

    public static final class a {
    }

    static {
    }

    @Inject
    public e() {
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi
    public final <T extends IOfficeSDKCapacity> T getService(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "serviceClass");
        Log.i("OfficeSDKGlobalApiImpl", "getService: ".concat(r5.getSimpleName()));
        OfficeSDKGlobalComponent r2 = OfficeSDKManager.getOfficeSDKGlobalComponent();     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        return (T) OfficeSDKSPIKtxKt.spiByDwarf(r2, r5);
    L12:
        return null;
    L7:
        e = move-exception;
        Log.w("OfficeSDKGlobalApiImpl", "getService failed: ".concat(r5.getSimpleName()), e);
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi
    public final <T extends IOfficeSDKProtocol> void setHostService(Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "serviceType");
        Intrinsics.checkNotNullParameter(r4, "service");
        Log.i("OfficeSDKGlobalApiImpl", "setHostService: ".concat(r3.getSimpleName()));
        OfficeSDKManager.injectGlobalService$officesdk_core_release(r3, r4);
    }
}
