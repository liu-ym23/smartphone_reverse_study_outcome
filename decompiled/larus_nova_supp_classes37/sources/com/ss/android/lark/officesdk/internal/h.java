package com.ss.android.lark.officesdk.internal;

import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class h implements OfficeSDKUserApi {
    public final String a;
    public final OfficeSDKUserComponentManager b;
    public final n c;

    public static final class a {
    }

    static {
    }

    public final String getUserId() {
        return this.a;
    }

    public final <T extends IOfficeSDKCapacity> T getService(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "serviceClass");
        Log.i("OfficeSDKUserApiImpl", "getService: " + r5.getSimpleName() + ", userId: " + this.a);
        OfficeSDKUserComponent r2 = this.b.findComponent();     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        return (T) OfficeSDKSPIKtxKt.spiByDwarf(r2, r5);
    L12:
        return null;
    L7:
        e = move-exception;
        Log.w("OfficeSDKUserApiImpl", "getService failed: ".concat(r5.getSimpleName()), e);
        return null;
    }

    public final <T extends IOfficeSDKProtocol> void setHostService(Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "serviceType");
        Intrinsics.checkNotNullParameter(r4, "service");
        Log.i("OfficeSDKUserApiImpl", "setHostService: " + r3.getSimpleName() + ", userId: " + this.a);
        OfficeSDKManager.injectUserService$officesdk_core_release(this.a, r3, r4);
    }

    @Inject
    public h(String r2, OfficeSDKUserComponentManager r3, n r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "componentManager");
        Intrinsics.checkNotNullParameter(r4, "rustSDK");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
