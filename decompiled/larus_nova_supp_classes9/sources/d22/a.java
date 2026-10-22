package d22;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.k;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r7, IntRange r8, int r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "rowLocation");
        String r1 = h.a;
        Intrinsics.checkNotNullParameter(r8, "rowLocation");
        GiftContext r0 = b.b();
        if (r0 == null) goto L9;
        n<Integer> r2 = r0.getCurrentSelectedGiftPosition();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        int r5 = r4 + 1;
        int r6 = r5 % 8;
        if (r6 != 0) goto L13;
        int r11 = 0;
    L14:
        Pair[] r13 = new Pair[9];
        r13[0] = TuplesKt.to("tab_name", ((e1) f.a(e1.class)).F5(r7));
        r13[1] = TuplesKt.to("page_location", String.valueOf((r5 / 8) + r11));
        int[] r14 = h.b;
        if (r11 != 0) goto L17;
        r6 = 8;
    L17:
        r13[2] = TuplesKt.to("gift_location", String.valueOf(r14[r6]));
        r13[3] = TuplesKt.to("start_row_location", String.valueOf(r8.getFirst()));
        r13[4] = TuplesKt.to("end_row_location", String.valueOf(r8.getLast()));
        r13[5] = TuplesKt.to("scroll_rows", String.valueOf((r8.getLast() - r8.getFirst()) + 1));
        r13[6] = TuplesKt.to("scroll_gift_num", String.valueOf(r9));
        long r15 = 10000;
        if (0 <= r10) goto L21;
    L23:
        String r16 = "0";
    L24:
        r13[7] = TuplesKt.to("scroll_duration", r16);
        AbsPanel<?> r17 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r17 == null) goto L27;
        Long r18 = Long.valueOf(r17.c());
    L28:
        r13[8] = TuplesKt.to("gift_id", String.valueOf(r18));
        LinkedHashMap r19 = new LinkedHashMap();
        MapsKt.putAll(r19, r13);
        com.bytedance.android.live.revenue.core.a r20 = k.a();
        if (r20 == null) goto L34;
        n01.a r21 = f.c(r20, n01.a.class);
        if (r21 == null) goto L35;
        r21.E0().sendLog("gift_panel_scroll", r19);
        return;
    L35:
        return;
    L34:
        return;
    L27:
        r18 = null;
        goto L28
    L21:
        if (r15 < r10) goto L23;
        r16 = String.valueOf(r10);
        goto L24
    L13:
        r11 = 1;
    L9:
        r4 = 0;
        goto L10
    }
}
