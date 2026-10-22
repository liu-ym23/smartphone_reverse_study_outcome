package com.bytedance.android.live.core.arch.mvi.widgetcompat;

import com.bytedance.android.livesdk.utils.a2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements a2<DataContext> {
    public final /* synthetic */ MVIDataWidget a;

    public final DataCenter getDataCenter() {
        return ((Widget) this.a).dataCenter;
    }

    public a(MVIDataWidget r1) {
        this.a = r1;
    }
}
