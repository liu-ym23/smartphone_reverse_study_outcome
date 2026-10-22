package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getGiftExtraData")
public final class q4 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/q4$a;", "", "", "giftId", "J", "a", "()J", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("gift_id")
        private final long giftId;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof a) == true) goto L6;
            return false;
        L6:
            if (this.giftId == ((a) r5).giftId) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            long r0 = this.giftId;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Param(giftId=" + this.giftId + ")";
        }

        public a() {
            this.giftId = 0;
        }

        public final long a() {
            return this.giftId;
        }
    }

    public final void onTerminate() {
    }

    public q4() {
    }

    public final void invoke(Object r2, CallContext r3) {
        a r4 = (a) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        long r5 = r4.a();
        com.bytedance.android.livesdk.gift.model.m1 r6 = ((IGiftService) jc1.k.n(IGiftService.class)).findGiftExtraInfo(r5);
        finishWithResult(GsonProtectorUtils.toJson(GsonHelper.get(), r6));     // Catch: JsonParseException -> L5
        return;
    L5:
        finishWithResult(new JSONObject());
    }
}
