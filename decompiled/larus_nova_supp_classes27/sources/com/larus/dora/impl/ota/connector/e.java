package com.larus.dora.impl.ota.connector;

import com.bytedance.dora.transfer.DoraTransferDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import ok4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DoraOTAWifiConnector c;
    public final /* synthetic */ Ref.LongRef d;

    public /* synthetic */ e(ok4.e r1, String r2, DoraOTAWifiConnector r3, Ref.LongRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r12) {
        ok4.e r0 = this.a;
        String r1 = this.b;
        DoraOTAWifiConnector r2 = this.c;
        Ref.LongRef r3 = this.d;
        String r13 = (String) r12;
        Intrinsics.checkNotNullParameter(r13, "reason");
        long r5 = r3.element;
        r2.getClass();
        int r4 = (int) RangesKt.coerceIn(r5, 0, 2147483647L);
        DoraTransferDirection r6 = DoraTransferDirection.UPLINK;
        ok4.e r7 = r0;
        r7.d(r1, r4);
        r7.b(r1, ok4.a.b, new ok4.f.a(r13));
        return Unit.INSTANCE;
    }
}
