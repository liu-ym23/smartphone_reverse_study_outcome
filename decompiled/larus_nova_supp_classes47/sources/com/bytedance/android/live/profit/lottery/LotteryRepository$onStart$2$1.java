package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryIMDataSource$b;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/lottery/LotteryIMDataSource$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LotteryRepository$onStart$2$1 extends FunctionReferenceImpl implements Function1<LotteryIMDataSource.b, Unit> {
    public LotteryRepository$onStart$2$1(LotteryRepository r8) {
        super(1, r8, LotteryRepository.class, "onLotteryEvent", "onLotteryEvent(Lcom/bytedance/android/live/profit/lottery/LotteryIMDataSource$LocalLotteryEvent;)V", 0);
    }

    public final void invoke(LotteryIMDataSource.b r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        LotteryRepository r0 = (LotteryRepository) ((CallableReference) this).receiver;
        Lottery r1 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r0.d);
        int r2 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_lottery", "onLotteryEvent curLottery=" + r1 + ", event=" + r8);
        Intrinsics.checkNotNullParameter(r0, "$this$monitorLotteryFromImDataSource");
        Intrinsics.checkNotNullParameter(r8, "ev");
        JSONObject r3 = new JSONObject();
        d1.a(r0, r3);
        BaseMonitor.add(r3, "lottery_id", r8.a().a);
        boolean r4 = r8 instanceof LotteryIMDataSource.b.c;
        if (r4 == false) goto L6;
        LotteryFromIMStatus r5 = LotteryFromIMStatus.LOTTERY_ONGOING;
        BaseMonitor.add(r3, "lottery_from_im_status", r5.getStatusMsg());
        d1.b(r5.getStatusMsg(), r3);
    L14:
        LotteryState r6 = null;
        if (r4 == false) goto L26;
        if (w2.c() == true) goto L22;
        if (r1 == null) goto L22;
        if ((r1.getState() instanceof LotteryState.d) == false) goto L22;
        r1.b(LotteryAction.c.a);
        r1 = null;
    L22:
        if (r1 != null) goto L24;
        r0.h(new Lottery(new LotteryState.g(r8.a())));
        return;
    L24:
        x2 r7 = f3.a;
        f3.a(r8.a());
        r1.b(new LotteryAction.b(r8.a()));
        return;
    L26:
        if ((r8 instanceof LotteryIMDataSource.b.C0032b) == false) goto L43;
        if (r1 == null) goto L29;
        LotteryState r9 = r1.getState();
    L31:
        if ((r9 instanceof LotteryState.g) == false) goto L34;
        r6 = r9;
    L34:
        LotteryState.g r10 = (LotteryState.g) r6;
        if (r10 == null) goto L54;
        t r12 = r10.a;
        if (r12 != null) goto L39;
        return;
    L39:
        if (r12.a != r8.a().a) goto L56;
        if (r1 == null) goto L57;
        r1.b(LotteryAction.d.a);
        return;
    L57:
        return;
    L56:
        return;
    L54:
        return;
    L29:
        r9 = null;
        goto L31
    L43:
        if ((r8 instanceof LotteryIMDataSource.b.d) == false) goto L48;
        if (r1 != null) goto L46;
        r0.h(new Lottery(new LotteryState.e(((LotteryIMDataSource.b.d) r8).b, null)));
        return;
    L46:
        r1.b(new LotteryAction.g(((LotteryIMDataSource.b.d) r8).b, r8.a()));
        return;
    L48:
        if ((r8 instanceof LotteryIMDataSource.b.a) == false) goto L61;
        if (r1 == null) goto L62;
        r1.b(LotteryAction.a.a);
        return;
    L62:
        return;
    L61:
        return;
    L6:
        if ((r8 instanceof LotteryIMDataSource.b.C0032b) == false) goto L9;
        LotteryFromIMStatus r13 = LotteryFromIMStatus.LOTTERY_FINISHED;
        BaseMonitor.add(r3, "lottery_from_im_status", r13.getStatusMsg());
        d1.b(r13.getStatusMsg(), r3);
        goto L14
    L9:
        if ((r8 instanceof LotteryIMDataSource.b.d) == false) goto L12;
        LotteryFromIMStatus r14 = LotteryFromIMStatus.LOTTERY_REJECTED;
        BaseMonitor.add(r3, "lottery_from_im_status", r14.getStatusMsg());
        BaseMonitor.add(r3, "lottery_reject_info_reason", ((LotteryIMDataSource.b.d) r8).b.b);
        d1.b(r14.getStatusMsg(), r3);
        goto L14
    L12:
        if ((r8 instanceof LotteryIMDataSource.b.a) == false) goto L14;
        LotteryFromIMStatus r15 = LotteryFromIMStatus.LOTTERY_CANCELED;
        BaseMonitor.add(r3, "lottery_from_im_status", r15.getStatusMsg());
        d1.b(r15.getStatusMsg(), r3);
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LotteryIMDataSource.b) r1);
        return Unit.INSTANCE;
    }
}
