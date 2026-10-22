package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECShopSettingMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSettingMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECShopSettingMethod() {
        this.e = "optShopSetting";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r0 = r10.optString("key");
        Object r12 = r10.optString("defaultValue");
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L20;
        int r13 = p.a;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        jj4.b r15 = jj4.b.b;     // Catch: Throwable -> L12
        Object r16 = jj4.a.a(r0, String.class, r12, false);     // Catch: Throwable -> L12
        if (r16 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L12
    L18:
        r11.onSuccess(r16);
        return;
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Object r18 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r18) == true) goto L17;
        r12 = r18;
    L17:
        r16 = r12;
        goto L18
    L20:
        r11.onFailed(0, "key 不能为空");
        return;
    L5:
        r1 = false;
        goto L6
    }
}
