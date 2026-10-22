package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Predicate {
    public final /* synthetic */ i a;

    public d(i r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter((ParticipateStatus) r2, "it");
        com.bytedance.android.live.profit.lottery.g r3 = (com.bytedance.android.live.profit.lottery.g) this.a.getCurrentLottery().getValue();
        if (r3 == null) goto L11;
        LotteryState r4 = r3.getState();
        if (r4 == null) goto L11;
        t r5 = l.a(r4);
        if (r5 == null) goto L11;
        if (r5.d != 52) goto L11;
        return true;
    L11:
        return false;
    }
}
