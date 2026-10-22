package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lrc/l;", "", "", "click", "Ljava/lang/String;", "getClick", "()Ljava/lang/String;", "exposure", "getExposure", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class l {

    @SerializedName("click")
    private final String click;

    @SerializedName("exposure")
    private final String exposure;

    public final int hashCode() {
        return (this.click.hashCode() * 31) + this.exposure.hashCode();
    }

    public l() {
        this.click = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
        this.exposure = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(l.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L21;
        l r12 = (l) r10;
        if ((!Intrinsics.areEqual(this.click, r12.click)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.exposure, r12.exposure)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bst.api.config.EventV2");
    L8:
        r11 = null;
        goto L10
    }
}
