package t51;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lt51/b;", "", "", "x", "F", "e", "()F", "m", "(F)V", "y", "f", "n", "w", "d", "l", "h", "a", "", "position", "I", "b", "()I", "i", "(I)V", "zOrder", "g", "o", "type", "getType", "j", "", "visible", "Z", "c", "()Z", "k", "(Z)V", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class b {

    @SerializedName("h")
    private float h;

    @SerializedName("p")
    private int position;

    @SerializedName("type")
    private int type;

    @SerializedName("visible")
    private boolean visible;

    @SerializedName("w")
    private float w;

    @SerializedName("x")
    private float x;

    @SerializedName("y")
    private float y;

    @SerializedName("z_order")
    private int zOrder;

    public final void k() {
        this.visible = false;
    }

    public final void o() {
        this.zOrder = 1;
    }

    public String toString() {
        return "BasePosition(x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ", position=" + this.position + ", zOrder=" + this.zOrder + ", visible=" + this.visible + ')';
    }

    public b() {
        this.visible = true;
    }

    public final float a() {
        return this.h;
    }

    public final int b() {
        return this.position;
    }

    public final boolean c() {
        return this.visible;
    }

    public final float d() {
        return this.w;
    }

    public final float e() {
        return this.x;
    }

    public final float f() {
        return this.y;
    }

    public final int g() {
        return this.zOrder;
    }

    public final int getType() {
        return this.type;
    }

    public final void h(float r1) {
        this.h = r1;
    }

    public final void i(int r1) {
        this.position = r1;
    }

    public final void j(int r1) {
        this.type = r1;
    }

    public final void l(float r1) {
        this.w = r1;
    }

    public final void m(float r1) {
        this.x = r1;
    }

    public final void n(float r1) {
        this.y = r1;
    }
}
