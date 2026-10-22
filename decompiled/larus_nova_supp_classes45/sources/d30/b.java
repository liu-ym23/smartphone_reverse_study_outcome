package d30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.CommunityOpenAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.f0;
import w20.l8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.openAnchorInteractPluginLynxContainer")
public final class b extends f0<l8, CommunityOpenAnchorInteractPluginLynxContainerResultModel> {
    public b() {
    }

    public final void invoke(Object r2, CallContext r3) {
        l8 r4 = (l8) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        s0 r5 = new s0();
        r5.a(r4.a());
        r5.e(r4.e());
        r5.d(r4.d());
        r5.c(r4.c());
        r5.b(r4.b());
        IBroadcastService r6 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r6 != null) goto L5;
    L7:
        CommunityOpenAnchorInteractPluginLynxContainerResultModel r7 = new CommunityOpenAnchorInteractPluginLynxContainerResultModel();
        r7.a(CommunityOpenAnchorInteractPluginLynxContainerResultModel.Code.Failed);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
        return;
    L5:
        if (r6.startLynxPlugin(r5) != true) goto L7;
        CommunityOpenAnchorInteractPluginLynxContainerResultModel r9 = new CommunityOpenAnchorInteractPluginLynxContainerResultModel();
        r9.a(CommunityOpenAnchorInteractPluginLynxContainerResultModel.Code.Success);
        Unit r11 = Unit.INSTANCE;
        finishWithResult(r9);
    }
}
