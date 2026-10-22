package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle;
import com.ss.android.lark.officesdk.api.OfficeSDKHostSession;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements IOfficeSDKUserHandle {
    public final OfficeSDKHostSession a;
    public final UserManagerImpl b;

    @Override // com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle
    public final OfficeSDKUserApi getUserApiOrNull() {
        return this.b.j(this.a);
    }

    public i(OfficeSDKHostSession r2, UserManagerImpl r3) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r3, "userManager");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle
    public final Object awaitUserApi(long r3, Continuation<? super OfficeSDKUserApi> r5) {
        return this.b.e(this.a, r3, r5);
    }
}
