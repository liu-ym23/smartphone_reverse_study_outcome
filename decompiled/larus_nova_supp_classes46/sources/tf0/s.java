package tf0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ltf0/s;", "", "", "x", "F", "a", "()F", "y", "b", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s {

    @SerializedName("x")
    private final float x;

    @SerializedName("y")
    private final float y;

    public final String toString() {
        return "Point(x=" + this.x + ", y=" + this.y + ')';
    }

    public final float a() {
        return this.x;
    }

    public final float b() {
        return this.y;
    }

    public s(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }
}
