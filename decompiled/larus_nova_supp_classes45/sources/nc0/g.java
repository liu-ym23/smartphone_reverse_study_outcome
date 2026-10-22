package nc0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.revenuelink.connect.i {
    public final ey.h a;

    public g(ey.h r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final void Z2(fy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
        this.a.Z2(r2);
    }

    public final void h3(fy.f r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "joinChannelParams");
        this.a.h3(r2, r3);
    }

    public final void i3(fy.d r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
        this.a.i3(r2, r3);
    }

    public final void k3(fy.h r4, ExtraResponse<n0, Extra> r5) {
        Intrinsics.checkNotNullParameter(r4, "leaveParams");
        ey.h r0 = this.a;
        if (r5 == null) goto L9;
        Response<LinkLeaveResult> r1 = new Response();
        LinkLeaveResult r2 = k.a((vh7.c) r5.data);
        if (r2 == null) goto L8;
        ((BaseResponse) r1).data = r2;
        ((BaseResponse) r1).extra = r5.extra;
        ((BaseResponse) r1).logId = r5.logId;
        ((BaseResponse) r1).traceId = r5.b;
        ((BaseResponse) r1).requestType = r5.a;
    L10:
        r0.Pi(r4, r1);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult");
    L9:
        r1 = null;
        goto L10
    }

    public final void m2(fy.h r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "leaveParams");
        this.a.m2(r2, r3);
    }

    public final void m3(fy.f r4, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r5) {
        Intrinsics.checkNotNullParameter(r4, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r5, "response");
        ey.h r0 = this.a;
        Response<AnchorJoinChannelResult> r1 = new Response();
        AnchorJoinChannelResult r2 = k.a((vh7.c) r5.data);
        if (r2 == null) goto L7;
        ((BaseResponse) r1).data = r2;
        ((BaseResponse) r1).extra = r5.extra;
        ((BaseResponse) r1).logId = r5.logId;
        ((BaseResponse) r1).traceId = r5.b;
        ((BaseResponse) r1).requestType = r5.a;
        Unit r6 = Unit.INSTANCE;
        r0.pl(r4, r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult");
    }
}
