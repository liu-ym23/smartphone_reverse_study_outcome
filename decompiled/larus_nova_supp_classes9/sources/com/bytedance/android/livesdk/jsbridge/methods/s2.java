package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/s2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "page_source", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setPage_source", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "page_type", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setPage_type", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/livesdk/jsbridge/methods/s2$a;", "params", "Lcom/bytedance/android/livesdk/jsbridge/methods/s2$a;", "c", "()Lcom/bytedance/android/livesdk/jsbridge/methods/s2$a;", "setParams", "(Lcom/bytedance/android/livesdk/jsbridge/methods/s2$a;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s2 {

    @SerializedName("page_source")
    private String page_source;

    @SerializedName("page_type")
    private Integer page_type;

    @SerializedName("params")
    private a params;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/s2$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "coupon_ids", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setCoupon_ids", "(Ljava/lang/String;)V", "from_position", "c", "setFrom_position", "extra_request_params", "b", "setExtra_request_params", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("coupon_ids")
        private String coupon_ids;

        @SerializedName("extra_request_params")
        private String extra_request_params;

        @SerializedName("from_position")
        private String from_position;

        public a() {
        }

        public final String a() {
            return this.coupon_ids;
        }

        public final String b() {
            return this.extra_request_params;
        }

        public final String c() {
            return this.from_position;
        }
    }

    public s2() {
    }

    public final String a() {
        return this.page_source;
    }

    public final Integer b() {
        return this.page_type;
    }

    public final a c() {
        return this.params;
    }
}
