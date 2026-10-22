package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.livesdk.utils.g7;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0<T> implements Consumer {
    public final /* synthetic */ NetSpeedMonitorWidget a;

    public m0(NetSpeedMonitorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        if (((q3) r1) == null) goto L7;
        View r2 = ((Widget) this.a).contentView;
        if (r2 == null) goto L11;
        g7.a(r2);
        return;
    L11:
        return;
    L7:
        View r3 = ((Widget) this.a).contentView;
        if (r3 == null) goto L13;
        g7.b(r3);
        return;
    }
}
