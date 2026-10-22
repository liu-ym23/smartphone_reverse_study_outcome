package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements com.bytedance.android.livesdk.interactivity.api.publicscreen.a.a {
    public final /* synthetic */ CommentServiceWidget a;

    public final void onCancel() {
        CommentServiceWidget r0 = this.a;
        int r1 = CommentServiceWidget.i;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r2 = r0.zq();
        if (r2 == null) goto L6;
        r2.Hc();
        return;
    }

    public h(CommentServiceWidget r1) {
        this.a = r1;
    }

    public final void a(Integer r5, Integer r6) {
        CommentServiceWidget r0 = this.a;
        int r1 = CommentServiceWidget.i;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r2 = r0.zq();
        if (r2 == null) goto L6;
        r2.Hc();
    L6:
        if (r6 == null) goto L8;
        RxBusAbility.INSTANCE.getRxBus(((Widget) this.a).dataCenter).post(new o42.c(false, true, "PublicScreenConfigDialog"));
        xs2.b.a().post(new o42.d());
    L8:
        if (r5 == null) goto L11;
        RxBusAbility.INSTANCE.getRxBus(((Widget) this.a).dataCenter).post(new o42.b("PublicScreenConfigDialog"));
        return;
    }
}
