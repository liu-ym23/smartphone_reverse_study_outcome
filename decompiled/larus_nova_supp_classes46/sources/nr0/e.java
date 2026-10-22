package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ i a;

    public e(i r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((ParticipateStatus) r4) != ParticipateStatus.PARTICIPATEINSUCCESS) goto L5;
        CompositeDisposable r5 = h.a;
        h.d("participate_success", null);
    L5:
        com.bytedance.android.live.profit.lottery.g r6 = (com.bytedance.android.live.profit.lottery.g) this.a.getCurrentLottery().getValue();
        if (r6 == null) goto L13;
        LotteryState r7 = r6.getState();
        if (r7 == null) goto L14;
        t r8 = l.a(r7);
        if (r8 == null) goto L15;
        h.a(r8.a, false, true);
        return;
    L15:
        return;
    L14:
        return;
    }
}
