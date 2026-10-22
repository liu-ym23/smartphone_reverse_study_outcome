package v52;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lv52/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "word", "Ljava/lang/String;", "getWord", "()Ljava/lang/String;", BuildConfig.FLAVOR, "scale", "D", "getScale", "()D", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("scale")
    private final double scale;

    @SerializedName("word")
    private final String word;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L10;
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.word, r6.word) == true) goto L8;
        return false;
    L8:
        if (Double.compare(this.scale, r6.scale) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.word;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = Double.doubleToLongBits(this.scale);
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "HotWord(word=" + this.word + ", scale=" + this.scale + ")";
    }

    public a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "word");
        this.word = r3;
        this.scale = 50.0d;
    }
}
