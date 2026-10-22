package wa8;

import com.larus.im.FlowRuntime;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final Map<Integer, Integer> a = null;

    static {
        Pair[] r0 = new Pair[19];
        int r3 = 0;
        r0[0] = TuplesKt.to(1, 0);
        r0[1] = TuplesKt.to(2, 0);
        r0[2] = TuplesKt.to(3, 0);
        r0[3] = TuplesKt.to(4, 0);
        if (FlowRuntime.b().a().appId() != 482431) goto L6;
        r3 = 101;
    L6:
        r0[4] = TuplesKt.to(5, Integer.valueOf(r3));
        r0[5] = TuplesKt.to(6, 0);
        r0[6] = TuplesKt.to(7, 0);
        r0[7] = TuplesKt.to(29, 0);
        r0[8] = TuplesKt.to(8, 0);
        r0[9] = TuplesKt.to(9, 0);
        r0[10] = TuplesKt.to(11, 0);
        r0[11] = TuplesKt.to(12, 0);
        r0[12] = TuplesKt.to(13, 0);
        r0[13] = TuplesKt.to(15, 0);
        r0[14] = TuplesKt.to(16, 0);
        r0[15] = TuplesKt.to(18, 1);
        r0[16] = TuplesKt.to(22, 0);
        r0[17] = TuplesKt.to(20, 0);
        r0[18] = TuplesKt.to(24, 1);
        a = MapsKt.mapOf(r0);
    }
}
