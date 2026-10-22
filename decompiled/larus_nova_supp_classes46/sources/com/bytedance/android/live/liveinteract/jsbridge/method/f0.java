package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.OpenChooseGuestPanelResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.ec;
import w20.f4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 extends f4<ec, OpenChooseGuestPanelResultModel> {
    public final DataCenter a;

    public static final class a {
    }

    static {
    }

    public f0(DataCenter r1) {
        this.a = r1;
    }

    public final void invoke(Object r4, CallContext r5) {
        ec r6 = (ec) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        r6.b();
        ((IInteractService) jc1.k.n(IInteractService.class)).tryOpenChooseGuestPanelWithUsage(r5.getContext(), r6.b(), r6.a(), this.a);
    }
}
