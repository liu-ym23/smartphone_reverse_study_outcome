package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.f2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AnchorMiniAppMoreLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniAppMoreLoader extends AbsDynamicLoader {
    public final f2 h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L7;
        n r2 = r1.getShelfInfo();
        if (r2 == null) goto L7;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
    L8:
        if (r3 != null) goto L18;
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L18;
        n r5 = r4.getCouponInfoOnMorePanel();
        if (r5 == null) goto L18;
        com.bytedance.android.live.openplatform.api.model.coupon.b r6 = (com.bytedance.android.live.openplatform.api.model.coupon.b) r5.getValue();
        if (r6 == null) goto L18;
        if (r6.a != true) goto L18;
        r0.add(ToolbarButton.OPEN_PLATFORM_MINI_APP_MORE);
    L18:
        return r0;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.OPEN_PLATFORM_MINI_APP_MORE, this.h);
    }

    public AnchorMiniAppMoreLoader(e r2, Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2);
        this.h = new f2(r3, r4);
    }
}
