package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n.a {
    public final /* synthetic */ CommentServiceWidget a;

    public final void onCancel() {
        CommentServiceWidget r0 = this.a;
        int r1 = CommentServiceWidget.i;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r2 = r0.zq();
        if (r2 == null) goto L6;
        r2.Hc();
        return;
    }

    public final void onFinish() {
        CommentServiceWidget r0 = this.a;
        int r1 = CommentServiceWidget.i;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r2 = r0.zq();
        if (r2 == null) goto L6;
        r2.Hc();
        return;
    }

    public i(CommentServiceWidget r1) {
        this.a = r1;
    }
}
