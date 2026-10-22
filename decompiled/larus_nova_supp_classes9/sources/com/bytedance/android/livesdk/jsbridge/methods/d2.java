package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "activityMagicGestureStatusChange")
public final class d2 extends com.bytedance.ies.web.jsbridge2.g<a, JSONObject> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d2$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "status", "I", "e", "()I", BuildConfig.FLAVOR, "effectId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "actionType", "b", "actionSchema", "a", "bizId", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("action_schema")
        private final String actionSchema;

        @SerializedName("action_type")
        private final int actionType;

        @SerializedName("biz_id")
        private final String bizId;

        @SerializedName("effect_id")
        private final String effectId;

        @SerializedName("status")
        private final int status;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (this.status == r4.status) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.effectId, r4.effectId) == true) goto L10;
            return false;
        L10:
            if (this.actionType == r4.actionType) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.actionSchema, r4.actionSchema) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.bizId, r4.bizId) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r0 = this.status * 31;
            String r1 = this.effectId;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (((r0 + r3) * 31) + this.actionType) * 31;
            String r5 = this.actionSchema;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.bizId;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            return r7 + r2;
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(status=" + this.status + ", effectId=" + this.effectId + ", actionType=" + this.actionType + ", actionSchema=" + this.actionSchema + ", bizId=" + this.bizId + ")";
        }

        public a() {
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "effectId");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "bizId");
            this.status = 0;
            this.effectId = BuildConfig.FLAVOR;
            this.actionType = 0;
            this.actionSchema = null;
            this.bizId = BuildConfig.FLAVOR;
        }

        public final String a() {
            return this.actionSchema;
        }

        public final int b() {
            return this.actionType;
        }

        public final String c() {
            return this.bizId;
        }

        public final String d() {
            return this.effectId;
        }

        public final int e() {
            return this.status;
        }
    }

    public d2() {
    }

    public final Object invoke(Object r8, CallContext r9) {
        a r10 = (a) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        ALogger.e("MagicGestureActivityMethod", "invoke status: " + r10.e() + ", effectId: " + r10.d() + ",actionType: " + r10.b() + ", actionSchema: " + r10.a() + ", bizId: " + r10.c());
        xs2.b.a().post(new zg1.q1(r10.e(), r10.d(), r10.b(), r10.a(), r10.c()));
        return null;
    }
}
