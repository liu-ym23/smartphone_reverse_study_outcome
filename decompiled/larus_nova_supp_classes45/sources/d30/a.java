package d30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.CommunityCloseAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.b0;
import w20.i8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.closeAnchorInteractPluginLynxContainer")
public final class a extends b0<i8, CommunityCloseAnchorInteractPluginLynxContainerResultModel> {
    public a() {
    }

    public final void invoke(Object r2, CallContext r3) {
        i8 r4 = (i8) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        s0 r5 = new s0();
        r5.a(r4.a());
        IBroadcastService r6 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r6 != null) goto L5;
    L7:
        CommunityCloseAnchorInteractPluginLynxContainerResultModel r7 = new CommunityCloseAnchorInteractPluginLynxContainerResultModel();
        r7.a(CommunityCloseAnchorInteractPluginLynxContainerResultModel.Code.Failed);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
        return;
    L5:
        if (r6.closeLynxPlugin(r5) != true) goto L7;
        CommunityCloseAnchorInteractPluginLynxContainerResultModel r9 = new CommunityCloseAnchorInteractPluginLynxContainerResultModel();
        r9.a(CommunityCloseAnchorInteractPluginLynxContainerResultModel.Code.Success);
        Unit r11 = Unit.INSTANCE;
        finishWithResult(r9);
    }
}
