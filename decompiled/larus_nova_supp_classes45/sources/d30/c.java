package d30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.CommunityUpdateAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.g0;
import w20.m8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.updateAnchorInteractPluginLynxContainer")
public final class c extends g0<m8, CommunityUpdateAnchorInteractPluginLynxContainerResultModel> {
    public c() {
    }

    public final void invoke(Object r2, CallContext r3) {
        m8 r4 = (m8) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        s0 r5 = new s0();
        r5.a(r4.a());
        r5.c(r4.b());
        IBroadcastService r6 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r6 != null) goto L5;
    L7:
        CommunityUpdateAnchorInteractPluginLynxContainerResultModel r7 = new CommunityUpdateAnchorInteractPluginLynxContainerResultModel();
        r7.a(CommunityUpdateAnchorInteractPluginLynxContainerResultModel.Code.Failed);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
        return;
    L5:
        if (r6.updateLynxPlugin(r5) != true) goto L7;
        CommunityUpdateAnchorInteractPluginLynxContainerResultModel r9 = new CommunityUpdateAnchorInteractPluginLynxContainerResultModel();
        r9.a(CommunityUpdateAnchorInteractPluginLynxContainerResultModel.Code.Success);
        Unit r11 = Unit.INSTANCE;
        finishWithResult(r9);
    }
}
