package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/f1;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/lottery/f1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LotteryRepository$onStart$2$2 extends FunctionReferenceImpl implements Function1<f1, Unit> {
    public LotteryRepository$onStart$2$2(LotteryRepository r8) {
        super(1, r8, LotteryRepository.class, "onLotteryParticipateSuccessEvent", "onLotteryParticipateSuccessEvent(Lcom/bytedance/android/live/profit/lottery/LotteryParticipateSuccessInfo;)V", 0);
    }

    public final void invoke(f1 r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        LotteryRepository r0 = (LotteryRepository) ((CallableReference) this).receiver;
        int r1 = LotteryRepository.s;
        r0.getClass();
        long r2 = r9.d;
        if (r2 < r0.n) goto L41;
        r0.n = r2;
        Lottery r3 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r0.d);
        LotteryState r4 = null;
        if (r3 == null) goto L7;
        LotteryState r5 = r3.getState();
    L9:
        if ((r5 instanceof LotteryState.g) == false) goto L12;
        r4 = r5;
    L12:
        LotteryState.g r6 = (LotteryState.g) r4;
        if (Intrinsics.areEqual(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString(), String.valueOf(r9.b)) == false) goto L42;
        if (r6 == null) goto L43;
        t r7 = r6.a;
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.a == r9.a) goto L20;
        return;
    L20:
        if (r9.c == false) goto L39;
        t r10 = l.a(r3.getState());
        if (r10 == null) goto L38;
        Intrinsics.checkNotNullParameter(r10, "info");
        JSONObject r8 = new JSONObject();
        r8.put("current_page", "live_detail");
        int r12 = r10.d;
        String r13 = "";
        if (r12 == 1) goto L30;
        if (r12 != 2) goto L27;
    L29:
        String r14 = "material_benefit";
    L32:
        if (r10.g.contains(50) == false) goto L35;
        r13 = "install";
    L37:
        JSONObject r15 = new JSONObject();
        r15.put("gift_content", r14);
        r15.put("participate_way", r13);
        vh6.c.b(dr2.e.class).getTrackService().b(MapsKt.mapOf(new Pair[]{TuplesKt.to("location", r8.toString()), TuplesKt.to("product_type", "game_benefit_participate"), TuplesKt.to("attr", r15.toString())}));
        goto L38
    L35:
        if (r10.g.contains(3) == false) goto L37;
        r13 = "comment";
        goto L37
    L27:
        if (r12 == 4) goto L29;
        r14 = "";
        goto L32
    L30:
        r14 = "douyin_coin_benefit";
    L38:
        r0.g.a(ParticipateStatus.PARTICIPATEINSUCCESS);
        return;
    L39:
        r0.g.a(ParticipateStatus.PARTICIPATED);
        return;
    L43:
        return;
    L42:
        return;
    L7:
        r5 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((f1) r1);
        return Unit.INSTANCE;
    }
}
