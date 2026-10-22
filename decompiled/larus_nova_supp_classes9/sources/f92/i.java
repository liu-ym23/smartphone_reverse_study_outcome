package f92;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lf92/i;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, sz1.a.KEY_X, "D", "e", "()D", "k", "(D)V", sz1.a.KEY_Y, "f", "l", sz1.a.KEY_WIDTH, "d", "j", sz1.a.KEY_HEIGHT, "a", "g", BuildConfig.FLAVOR, "pushMode", "I", "c", "()I", "i", "(I)V", "layoutType", "b", "h", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName(sz1.a.KEY_HEIGHT)
    private double height;

    @SerializedName("layout_type")
    private int layoutType;

    @SerializedName("push_mode")
    private int pushMode;

    @SerializedName(sz1.a.KEY_WIDTH)
    private double width;

    @SerializedName(sz1.a.KEY_X)
    private double x;

    @SerializedName(sz1.a.KEY_Y)
    private double y;

    public i() {
    }

    public final double a() {
        return this.height;
    }

    public final int b() {
        return this.layoutType;
    }

    public final int c() {
        return this.pushMode;
    }

    public final double d() {
        return this.width;
    }

    public final double e() {
        return this.x;
    }

    public final double f() {
        return this.y;
    }

    public final void g(double r1) {
        this.height = r1;
    }

    public final void h(int r1) {
        this.layoutType = r1;
    }

    public final void i(int r1) {
        this.pushMode = r1;
    }

    public final void j(double r1) {
        this.width = r1;
    }

    public final void k(double r1) {
        this.x = r1;
    }

    public final void l(double r1) {
        this.y = r1;
    }
}
