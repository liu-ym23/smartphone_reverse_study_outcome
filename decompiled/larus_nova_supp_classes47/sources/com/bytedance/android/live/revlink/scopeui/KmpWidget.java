package com.bytedance.android.live.revlink.scopeui;

import android.content.res.Configuration;
import b03.b;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import j11.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/scopeui/KmpWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KmpWidget extends LiveWidget {
    public abstract b wq(Object r1);

    public final void enableSubWidgetManager() {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.enableSubWidgetManager();
        WidgetManager r0 = ((Widget) this).subWidgetManager;
        if ((r0 instanceof RecyclableWidgetManager) == true) goto L5;
        r0 = null;
    L5:
        RecyclableWidgetManager r1 = (RecyclableWidgetManager) r0;
        if (r1 == null) goto L9;
        r1.h = true;
        return;
    }

    public void onDestroy() {
        super.onDestroy();
        a r0 = a.d;
        r0.getClass();
        if (((Boolean) a.c.getValue(r0, a.a[1])).booleanValue() == false) goto L6;
        ((Widget) this).widgetCallback = null;
        return;
    }

    public KmpWidget() {
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r1);
        wq(r1);
    }
}
