package com.bytedance.android.ec.core.address.jsb;

import com.bytedance.android.ec.core.address.AddressSDK;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import o83.d;
import o83.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/address/jsb/ECSetAddressMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSetAddressMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a implements e {
        public final /* synthetic */ ECBaseBridgeMethod.a a;

        public a(ECBaseBridgeMethod.a r1) {
            this.a = r1;
        }

        public final void onFailed(String r10) {
            this.a.onFailed(0, r10);
        }

        public final void onSuccess(JSONObject r10) {
            this.a.onSuccess(null);
        }
    }

    public ECSetAddressMethod() {
        this.e = "ecSetAddress";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r12 = r10.optJSONObject("address");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        String r1 = r10.optString("extraParams");     // Catch: Throwable -> L5
        Lazy r13 = Json.a;     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl((d) ((Gson) Json.a.getValue()).fromJson(r1, d.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r14) == false) goto L10;
        r14 = null;
    L10:
        AddressSDK r15 = AddressSDK.j;
        boolean r16 = r10.optBoolean("is_session");
        int r17 = r10.optInt(com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE);
        a r18 = new a(r11);
        r15.u(r12, r17, r16, r18, (d) r14);
        return;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
