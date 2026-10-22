package com.bytedance.android.livesdk.dispatch.utils;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements IBaseCallbackSchemaHandler.SchemaCallback<String> {
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback a;
    public final /* synthetic */ String b;

    public final void onComplete() {
        IBaseCallbackSchemaHandler.SchemaCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onComplete();
        return;
    }

    public final void onFailure(Throwable r3) {
        IBaseCallbackSchemaHandler.SchemaCallback r0 = this.a;
        if (r0 == null) goto L5;
        r0.onFailure(r3);
    L5:
        Lazy r4 = DispatchLogUtil.a;
        DispatchLogUtil.e(9, this.b, null);
    }

    public e(IBaseCallbackSchemaHandler.SchemaCallback r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSuccess(Integer r2, Object r3) {
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        IBaseCallbackSchemaHandler.SchemaCallback r0 = this.a;
        if (r0 == null) goto L5;
        r0.onSuccess(r2, r4);
    L5:
        Lazy r5 = DispatchLogUtil.a;
        DispatchLogUtil.e(7, this.b, null);
    }
}
