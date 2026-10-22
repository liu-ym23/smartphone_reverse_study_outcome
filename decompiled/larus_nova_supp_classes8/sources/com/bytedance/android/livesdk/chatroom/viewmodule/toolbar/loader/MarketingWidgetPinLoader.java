package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livehostapi.business.IHostMarketing;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.w0;
import java.util.HashSet;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/MarketingWidgetPinLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingWidgetPinLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        HashSet r0 = new HashSet();
        if (this.d == false) goto L14;
        if (tb1.c.a == false) goto L14;
        if (y3.m(this.a).n(ToolbarButton.COMMERCE) == false) goto L14;
        IHostMarketing r1 = k.f(IHostMarketing.class);
        if (r1 == null) goto L14;
        if (r1.canInstallShoppingFakeIcon() != true) goto L14;
        r0.add(ToolbarButton.MARKETING_WIDGET_PIN_BUTTON);
    L14:
        return CollectionsKt.toList(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.MARKETING_WIDGET_PIN_BUTTON, new w0());
    }

    public MarketingWidgetPinLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
