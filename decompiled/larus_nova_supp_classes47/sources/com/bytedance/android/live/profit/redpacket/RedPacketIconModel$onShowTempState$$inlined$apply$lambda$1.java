package com.bytedance.android.live.profit.redpacket;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "count", "", "invoke", "com/bytedance/android/live/profit/redpacket/RedPacketIconModel$onShowTempState$1$1$1", "com/bytedance/android/live/profit/redpacket/RedPacketIconModel$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 3})
public final class RedPacketIconModel$onShowTempState$$inlined$apply$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ n0 $curPacket$inlined;
    final /* synthetic */ Ref.BooleanRef $hasReportedTempIconShow;
    final /* synthetic */ boolean $isCountDownMoreThan5Sec$inlined;
    final /* synthetic */ int $strategy$inlined;
    final /* synthetic */ TextView $tvDesc;
    final /* synthetic */ TextView $tvNum;
    final /* synthetic */ RedPacketIconModel this$0;

    public RedPacketIconModel$onShowTempState$$inlined$apply$lambda$1(TextView r1, Ref.BooleanRef r2, TextView r3, RedPacketIconModel r4, int r5, boolean r6, n0 r7) {
        this.$tvNum = r1;
        this.$hasReportedTempIconShow = r2;
        this.$tvDesc = r3;
        this.this$0 = r4;
        this.$strategy$inlined = r5;
        this.$isCountDownMoreThan5Sec$inlined = r6;
        this.$curPacket$inlined = r7;
        super(1);
    }

    public final void invoke(int r10) {
        if (r10 <= 10000) goto L5;
        this.$tvNum.setText(s1.C(2131922038, new Object[]{String.valueOf(r10 / 10000)}));
    L7:
        if (this.$hasReportedTempIconShow.element == true) goto L10;
        this.this$0.n = this.$tvDesc.getText().toString() + this.$tvNum.getText().toString();
        w0 r2 = this.this$0.p;
        int r12 = com.bytedance.android.live.profit.util.m.a;
        int r3 = com.bytedance.android.live.profit.util.m.b;
        String r4 = String.valueOf(this.$strategy$inlined);
        long r5 = this.this$0.getTempShowTime(this.$strategy$inlined);
        RedPacketIconModel r13 = this.this$0;
        com.bytedance.android.live.profit.util.e.c(r2, r3, r4, r5, r13.n, r13.o);
        this.$hasReportedTempIconShow.element = true;
        return;
    L10:
        return;
    L5:
        this.$tvNum.setText(s1.C(2131922037, new Object[]{String.valueOf(r10)}));
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
