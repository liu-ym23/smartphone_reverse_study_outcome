package com.bytedance.android.live.profit.format.voicechat.rtc;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ProfitRTCService$rtcRoomListener$2$1$onRoomMessageReceived$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $message;
    final /* synthetic */ String $uid;
    final /* synthetic */ ProfitRTCService$rtcRoomListener$2.a this$0;

    public ProfitRTCService$rtcRoomListener$2$1$onRoomMessageReceived$1(ProfitRTCService$rtcRoomListener$2.a r1, String r2, String r3) {
        this.this$0 = r1;
        this.$uid = r2;
        this.$message = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m163invoke() {
        Iterator<T> r0 = this.this$0.a.this$0.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).s(this.$uid, this.$message);
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m163invoke();
        return Unit.INSTANCE;
    }
}
