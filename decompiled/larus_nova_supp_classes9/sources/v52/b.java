package v52;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lv52/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lv52/a;", "hotWords", "Ljava/util/List;", "getHotWords", "()Ljava/util/List;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("hotwords")
    private final List<a> hotWords;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.hotWords, ((b) r2).hotWords) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<a> r0 = this.hotWords;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "HotWordList(hotWords=" + this.hotWords + ")";
    }

    public b(List<a> r2) {
        Intrinsics.checkNotNullParameter(r2, "hotWords");
        this.hotWords = r2;
    }
}
