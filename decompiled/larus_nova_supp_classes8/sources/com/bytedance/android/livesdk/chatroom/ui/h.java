package com.bytedance.android.livesdk.chatroom.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ AbsInteractionFragment a;
    public final /* synthetic */ com.bytedance.android.livesdk.message.model.e2 b;

    public /* synthetic */ h(AbsInteractionFragment r1, com.bytedance.android.livesdk.message.model.e2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbsInteractionFragment r0 = this.a;
        com.bytedance.android.livesdk.message.model.e2 r1 = this.b;
        vlc.d r2 = com.bytedance.android.livesdk.chatroom.utils.n3.e(r0.W);
        if (r2 == null) goto L6;
        r2.j(r1, true);
        return;
    }
}
