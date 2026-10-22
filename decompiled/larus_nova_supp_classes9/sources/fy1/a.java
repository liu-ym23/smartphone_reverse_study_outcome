package fy1;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lfy1/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "preInflateNext", "Z", "b", "()Z", "setPreInflateNext", "(Z)V", "asyncLogTrayShow", "getAsyncLogTrayShow", "setAsyncLogTrayShow", "enableSortUniqueKey", "a", "setEnableSortUniqueKey", "enableGetGiftOpt", "getEnableGetGiftOpt", "setEnableGetGiftOpt", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("async_log_tray_show")
    private boolean asyncLogTrayShow;

    @SerializedName("enable_get_gift_opt")
    private boolean enableGetGiftOpt;

    @SerializedName("enable_sort_unique_key")
    private boolean enableSortUniqueKey;

    @SerializedName("pre_inflate_next")
    private boolean preInflateNext;

    public a() {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("GiftTrayJankOptConfig{");
        r0.append("preInflateNext=" + this.preInflateNext + ',');
        r0.append("asyncLogTrayShow=" + this.asyncLogTrayShow + ',');
        r0.append("sortUniqueKey=" + this.enableSortUniqueKey + ',');
        StringBuilder r1 = new StringBuilder("getGiftOpt=");
        r1.append(this.enableGetGiftOpt);
        r0.append(r1.toString());
        r0.append("}");
        return r0.toString();
    }

    public final boolean a() {
        return this.enableSortUniqueKey;
    }

    public final boolean b() {
        return this.preInflateNext;
    }
}
