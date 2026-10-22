package com.bytedance.android.ec.core.address.jsb;

import com.bytedance.android.ec.core.address.AddressSDK;
import com.bytedance.android.ec.core.address.AddressSDKLog;
import com.bytedance.android.ec.core.address.w;
import com.bytedance.android.ec.core.address.z;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o83.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/address/jsb/ECUpdateAddressMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUpdateAddressMethod extends ECBaseBridgeMethod {
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
            this.a.onSuccess(r10);
        }
    }

    public ECUpdateAddressMethod() {
        this.e = "ecUpdateAddress";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r1 = r10.optString("action");
        JSONObject r12 = r10.optJSONObject("address");
        w r13 = AddressSDK.a;
        a r14 = new a(r11);
        Intrinsics.checkNotNullParameter(r1, "action");
        if (AddressSDK.d == true) goto L5;
        r14.onFailed("未命中实验");
        return;
    L5:
        Integer r15 = null;
        if (r12 == null) goto L8;
        String r16 = z.b(r12);
    L9:
        if (r12 == null) goto L11;
        r15 = z.e(r12);
    L11:
        if (r16 == null) goto L20;
        if (r15 == null) goto L20;
        if ((!Intrinsics.areEqual(r1, "update")) == true) goto L17;
    L19:
        AddressSDKLog.a("updateAddress address=" + z.c(r12) + " action=" + r1, false);
        AddressSDK.s(r12, 0, r14, true, 2, null);
        return;
    L17:
        if ((!Intrinsics.areEqual(r1, "select")) == false) goto L19;
        r14.onFailed("传入的 action(" + r1 + ") 不合法");
        return;
    L20:
        r14.onFailed("传入的 address 不合法");
        return;
    L8:
        r16 = null;
        goto L9
    }
}
