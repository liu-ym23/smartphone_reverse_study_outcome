package com.bytedance.android.livesdk.interactivity.barrage.widget;

import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final BarrageWidgetContext a(DataContext r1, DataCenter r2) {
        h r3 = i.a(r1, r2);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r4 = null;
        if (r3 == null) goto L7;
        j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r5 = r3.getBarrageContext();
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r6 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r5.getValue();
    L9:
        if ((r6 instanceof BarrageWidgetContext) == false) goto L13;
        r4 = r6;
    L13:
        return (BarrageWidgetContext) r4;
    L7:
        r6 = null;
        goto L9
    }
}
