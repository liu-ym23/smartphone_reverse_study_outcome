package i02;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Li02/f;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "dynamicImgFlippable", "Z", "a", "()Z", BuildConfig.FLAVOR, "webpAngle", "I", "b", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("tray_dynamic_img_flippable")
    private final boolean dynamicImgFlippable;

    @SerializedName("webp_angle")
    private final int webpAngle;

    public f() {
        this.dynamicImgFlippable = false;
        this.webpAngle = Integer.MIN_VALUE;
    }

    public final boolean a() {
        return this.dynamicImgFlippable;
    }

    public final int b() {
        return this.webpAngle;
    }
}
