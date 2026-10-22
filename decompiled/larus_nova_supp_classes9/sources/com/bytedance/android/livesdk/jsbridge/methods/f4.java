package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.aa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/f4;", "Lw20/aa;", BuildConfig.FLAVOR, "code", "Ljava/lang/Number;", "getCode", "()Ljava/lang/Number;", "a", "(Ljava/lang/Number;)V", "Lcom/bytedance/android/livesdk/jsbridge/methods/f4$a;", "data", "Lcom/bytedance/android/livesdk/jsbridge/methods/f4$a;", "getData", "()Lcom/bytedance/android/livesdk/jsbridge/methods/f4$a;", "b", "(Lcom/bytedance/android/livesdk/jsbridge/methods/f4$a;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f4 implements aa {

    @SerializedName("code")
    private Number code;

    @SerializedName("data")
    private a data;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/f4$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id_existed", "Ljava/lang/Number;", "getId_existed", "()Ljava/lang/Number;", "a", "(Ljava/lang/Number;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("id_existed")
        private Number id_existed;

        public a() {
        }

        public final void a(Number r1) {
            this.id_existed = r1;
        }
    }

    public f4() {
    }

    public final void a(Number r1) {
        this.code = r1;
    }

    public final void b(a r1) {
        this.data = r1;
    }
}
