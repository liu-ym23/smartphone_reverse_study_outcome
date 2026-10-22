package c31;

import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.revenue.service.room.c;
import dy0.b;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final int a() {
        c r0 = (b) e.c(j.C0.a(), c.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L11;
        Pair r2 = r1.getPlayerSize();
        if (r2 == null) goto L11;
        Integer r3 = (Integer) r2.getSecond();
        if (r3 == null) goto L11;
        return r3.intValue();
    L11:
        return 0;
    }
}
