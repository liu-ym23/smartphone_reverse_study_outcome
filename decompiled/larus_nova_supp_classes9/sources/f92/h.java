package f92;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lf92/h;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lf92/i;", "layoutParam", "Ljava/util/List;", "a", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("layout_param")
    private List<i> layoutParam;

    public final double b() {
        List<i> r0 = this.layoutParam;
        double r1 = 0.0d;
        if (r0 == null) goto L9;
        Iterator<i> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        i r3 = r2.next();
        r1 = RangesKt.coerceAtLeast(r1, r3.f() + r3.a());
    L9:
        return r1 - c();
    }

    public final double c() {
        List<i> r0 = this.layoutParam;
        double r1 = 1.0d;
        if (r0 == null) goto L8;
        Iterator<i> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1 = RangesKt.coerceAtMost(r1, r2.next().f());
    L8:
        return r1;
    }

    public h() {
        this.layoutParam = new ArrayList();
    }

    public final List<i> a() {
        return this.layoutParam;
    }

    public final void d(List<i> r1) {
        this.layoutParam = r1;
    }
}
