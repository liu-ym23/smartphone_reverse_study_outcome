package r6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Lr6/a;", "", "", "srAlgType", "I", "getSrAlgType", "()I", "srScaleType", "getSrScaleType", "srMaxTextureWidth", "getSrMaxTextureWidth", "srMaxTextureHeight", "getSrMaxTextureHeight", "a", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("sr_alg_type")
    private final int srAlgType;

    @SerializedName("sr_max_texture_height")
    private final int srMaxTextureHeight;

    @SerializedName("sr_max_texture_width")
    private final int srMaxTextureWidth;

    @SerializedName("sr_scale_type")
    private final int srScaleType;

    /* JADX INFO: renamed from: r6.a$a, reason: collision with other inner class name */
    public static final class C0190a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L14;
        a r11 = (a) r10;
        if (this.srAlgType == r11.srAlgType) goto L8;
        return false;
    L8:
        if (this.srScaleType == r11.srScaleType) goto L10;
        return false;
    L10:
        if (this.srMaxTextureWidth == r11.srMaxTextureWidth) goto L12;
        return false;
    L12:
        if (this.srMaxTextureHeight == r11.srMaxTextureHeight) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.srAlgType * 31) + this.srScaleType) * 31) + this.srMaxTextureWidth) * 31) + this.srMaxTextureHeight;
    }

    public final String toString() {
        return "AdVideoBmfSrConfig(srAlgType=" + this.srAlgType + ", srScaleType=" + this.srScaleType + ", srMaxTextureWidth=" + this.srMaxTextureWidth + ", srMaxTextureHeight=" + this.srMaxTextureHeight + ")";
    }

    public a() {
        this.srAlgType = 10;
        this.srScaleType = 0;
        this.srMaxTextureWidth = 1600;
        this.srMaxTextureHeight = 1600;
    }
}
