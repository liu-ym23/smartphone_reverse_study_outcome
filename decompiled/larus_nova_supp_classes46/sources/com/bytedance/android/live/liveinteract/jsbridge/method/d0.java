package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveCloseLinkResultModel;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import kotlin.jvm.internal.Intrinsics;
import w20.l2;
import w20.ma;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 extends l2<ma, LiveCloseLinkResultModel> {
    public final DataCenter a;

    public d0(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final void invoke(Object r4, CallContext r5) {
        ma r6 = (ma) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        c0 r0 = new c0(this, new LiveCloseLinkResultModel());
        IMultiLinkInternalService r7 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        cg6.a r1 = null;
        if (r7 == null) goto L5;
        r1 = r7.getMultiLinkComponentService(this.a, null);
    L5:
        if (r1 == null) goto L9;
        vb6.g r8 = r1.O5();
        if (r8 == null) goto L9;
        r8.X0(r0, false);
    L9:
        if (r1 == null) goto L21;
        MultiLinkGuestManager r9 = r1.W4();
        if (r9 == null) goto L22;
        String r2 = r6.a();
        if (r2 != null) goto L15;
        r2 = "leave_normally";
    L15:
        Boolean r10 = r6.b();
        if (r10 == null) goto L18;
        boolean r11 = r10.booleanValue();
    L19:
        r9.f(r2, r11);
        return;
    L18:
        r11 = true;
        goto L19
    L22:
        return;
    }
}
