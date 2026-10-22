package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorShowAddDialogResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openAnchorShowAddDialog")
public final class m8 extends w20.e4<w20.dc, OpenAnchorShowAddDialogResultModel> {

    public static final class a {
    }

    static {
    }

    public m8() {
    }

    public final void invoke(Object r4, CallContext r5) {
        w20.dc r6 = (w20.dc) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        Context r7 = r5.getContext();
        Integer r1 = r6.b();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        Integer r8 = r6.a();
        if (r8 == null) goto L9;
        int r9 = r8.intValue();
    L10:
        r0.showAddAnchorShowDialog(r7, r2, r9, new n8());
        return;
    L9:
        r9 = 10;
        goto L10
    L5:
        r2 = 20;
        goto L6
    }
}
