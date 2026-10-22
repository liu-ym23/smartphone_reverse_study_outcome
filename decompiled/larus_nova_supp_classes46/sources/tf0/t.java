package tf0;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a¨\u0006&"}, d2 = {"Ltf0/t;", "", "", "property", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "duration", "J", "c", "()J", "from", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "to", "h", "", "reload", "Ljava/lang/Boolean;", "getReload", "()Ljava/lang/Boolean;", "delay", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "", "interpolator", "Ljava/util/List;", "e", "()Ljava/util/List;", "Ltf0/s;", "bezierControls", "a", "repeatCount", "g", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t {

    @SerializedName("bezier_controls")
    private final List<s> bezierControls;

    @SerializedName("delay")
    private final Long delay;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("from")
    private final Object from;

    @SerializedName("interpolator")
    private final List<Float> interpolator;

    @SerializedName("property")
    private final String property;

    @SerializedName("reload")
    private final Boolean reload;

    @SerializedName("repeat_count")
    private final Long repeatCount;

    @SerializedName("to")
    private final Object to;

    public t() {
        throw null;
    }

    public final String toString() {
        return "PropertyAnimation(property='" + this.property + "', duration=" + this.duration + ", from=" + this.from + ", to=" + this.to + ", reload=" + this.reload + ", delay=" + this.delay + ", interpolator=" + this.interpolator + ", bezierControls=" + this.bezierControls + ", repeatCount=" + this.repeatCount + ')';
    }

    public final List<s> a() {
        return this.bezierControls;
    }

    public final Long b() {
        return this.delay;
    }

    public final long c() {
        return this.duration;
    }

    public final Object d() {
        return this.from;
    }

    public final List<Float> e() {
        return this.interpolator;
    }

    public final String f() {
        return this.property;
    }

    public final Long g() {
        return this.repeatCount;
    }

    public final Object h() {
        return this.to;
    }

    public t(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "property");
        this.property = r3;
        this.duration = 0;
        this.from = null;
        this.to = r4;
        this.reload = null;
        this.delay = null;
        this.interpolator = null;
        this.bezierControls = null;
        this.repeatCount = null;
    }
}
