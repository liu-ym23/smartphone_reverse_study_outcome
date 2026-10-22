package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 implements View.OnLongClickListener {
    public final /* synthetic */ RecordCompositeWidget a;

    public s0(RecordCompositeWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        xs2.b r5 = xs2.b.a();
        DataCenter r1 = ((Widget) this.a).dataCenter;
        if (r1 == null) goto L5;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r1);
    L6:
        r5.post(new zg1.h1(26, r2));
        RecordCompositeWidget.wq(this.a);
        return true;
    L5:
        r2 = null;
        goto L6
    }
}
