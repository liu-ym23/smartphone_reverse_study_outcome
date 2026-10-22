package j1c;

import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends g1c.a<Map<String, ? extends Double>> implements i1c.a {
    public final double d;

    public static final class a {
    }

    static {
    }

    @Override // g1c.b
    public final boolean isValid() {
        return true;
    }

    public b() {
        super(new HashMap());
        this.d = com.ss.android.lark.preload.c.a().getHitRateDisableValue();
    }

    @Override // g1c.b
    public final Class<k1c.b<Map<String, Double>>> b() {
        return l1c.b.class;
    }

    @Override // g1c.a, g1c.b
    public final void e(o1c.c<?, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r10, "task");
        Map r0 = (Map) this.c;
        if (r0 == null) goto L28;
        Double r1 = (Double) r0.get(r10.getClass().getSimpleName());
        if (r1 == null) goto L29;
        double r2 = r1.doubleValue();
        if (r2 <= 0.9d) goto L11;
        int r3 = 8;
    L9:
        boolean r4 = true;
    L23:
        Log.d("PreloadHitRate", "checkCondition PreloadHitRate:" + r10 + " / " + r2 + " / " + r3 + " / " + r4 + " / " + this.d);
        r10.setPriority(r10.getPriority() + (r3 * 10));
        if (r4 == false) goto L26;
        d r11 = r10.R();
        r11.a = true;
        r11.b = null;
        r11.c = null;
        return;
    L26:
        d r12 = r10.R();
        Map<String, ? extends Object> r5 = MapsKt.mapOf(TuplesKt.to("frequency", Double.valueOf(r2)));
        r12.a = false;
        r12.b = "PreloadHitRate";
        r12.c = r5;
        return;
    L11:
        if (r2 <= 0.7d) goto L14;
        r3 = 6;
        goto L9
    L14:
        if (r2 <= 0.5d) goto L17;
        r3 = 2;
        goto L9
    L17:
        if (r2 <= 0.3d) goto L20;
        r3 = -2;
        goto L9
    L20:
        if (r2 <= this.d) goto L22;
        r3 = -4;
        goto L9
    L22:
        r3 = -6;
        r4 = false;
        goto L23
    L29:
        return;
    }
}
