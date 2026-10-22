package j1c;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends g1c.a<Map<Biz, ? extends Double>> implements i1c.a {
    public final double d;

    /* JADX INFO: renamed from: j1c.a$a, reason: collision with other inner class name */
    public static final class C0150a {
    }

    static {
    }

    @Override // g1c.b
    public final boolean isValid() {
        return true;
    }

    public a() {
        super(new HashMap());
        this.d = com.ss.android.lark.preload.c.a().getBizFrequencyDisableValue();
    }

    @Override // g1c.b
    public final Class<k1c.b<Map<Biz, Double>>> b() {
        return l1c.a.class;
    }

    @Override // g1c.a, g1c.b
    public final void e(o1c.c<?, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r10, "task");
        Map r0 = (Map) this.c;
        if (r0 == null) goto L7;
        Double r1 = (Double) r0.get(r10.getBiz());
        if (r1 == null) goto L7;
        double r2 = r1.doubleValue();
    L9:
        if (r2 <= 0.9d) goto L13;
        int r3 = 7;
    L11:
        boolean r4 = true;
    L28:
        Log.d("BizFrequency", "checkCondition BizFrequency:" + r10 + " / " + r2 + " / " + r3 + " / " + r4 + " / " + this.d);
        r10.setPriority(r10.getPriority() + (r3 * 10));
        if (r4 == false) goto L31;
        d r11 = r10.R();
        r11.a = true;
        r11.b = null;
        r11.c = null;
        return;
    L31:
        d r12 = r10.R();
        Map<String, ? extends Object> r5 = MapsKt.mapOf(TuplesKt.to("frequency", Double.valueOf(r2)));
        r12.a = false;
        r12.b = "BizFrequency";
        r12.c = r5;
        return;
    L13:
        if (r2 <= 0.7d) goto L16;
        r3 = 5;
        goto L11
    L16:
        if (r2 <= 0.5d) goto L19;
        r3 = 1;
        goto L11
    L19:
        if (r2 <= 0.3d) goto L22;
        r3 = -1;
        goto L11
    L22:
        if (r2 <= 0.1d) goto L25;
        r3 = -3;
        goto L11
    L25:
        if (r2 <= this.d) goto L27;
        r3 = -5;
        goto L11
    L27:
        r3 = -8;
        r4 = false;
    L7:
        r2 = 0.0d;
        goto L9
    }
}
