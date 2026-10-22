package com.bytedance.android.live.profit.format.voicechat.rtc;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ProfitRTCService$rtcRoomListener$2$1$onRemoteRtcUserLeave$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $rtcUserId;
    final /* synthetic */ ProfitRTCService$rtcRoomListener$2.a this$0;

    public ProfitRTCService$rtcRoomListener$2$1$onRemoteRtcUserLeave$1(ProfitRTCService$rtcRoomListener$2.a r1, String r2) {
        this.this$0 = r1;
        this.$rtcUserId = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m162invoke() {
        String r0 = this.$rtcUserId;
        if (r0 == null) goto L11;
        ALogger.i("ProfitRTCService", this.$rtcUserId + " onRemoteRtcUserLeave");
        Iterator<a> r1 = this.this$0.a.this$0.b.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().t(r0);
        goto L6
    L8:
        this.this$0.a.this$0.d.remove(r0);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m162invoke();
        return Unit.INSTANCE;
    }
}
