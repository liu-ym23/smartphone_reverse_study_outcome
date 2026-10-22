package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(LiveWidget r2) {
        if (r2 != null) goto L4;
    L14:
        return false;
    L4:
        if (((Widget) r2).dataCenter == null) goto L14;
        if (((Widget) r2).isViewValid != true) goto L14;
        Widget.WidgetCallback r3 = ((Widget) r2).widgetCallback;
        if (r3 == null) goto L14;
        WidgetManager r4 = r3.getWidgetManager();
        if (r4 == null) goto L14;
        if (r4.isAdded() != true) goto L14;
        return true;
    }
}
