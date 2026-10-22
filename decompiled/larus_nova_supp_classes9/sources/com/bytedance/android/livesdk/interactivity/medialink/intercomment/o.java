package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements MediaInteractCommentInviteDialog.a {
    public final /* synthetic */ MediaInteractCommentWidget a;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentInviteDialog.a
    public final void a() {
        MediaInteractCommentWidget.xq(this.a);
        this.a.g.getClass();
        d.d(true);
    }

    public o(MediaInteractCommentWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentInviteDialog.a
    public final void b(boolean r4) {
        MediaInteractCommentWidget r0 = this.a;
        if (r0.d == false) goto L5;
        r0.g.getClass();
        d.e(true, r4);
    L5:
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.b3;
        Boolean r5 = Boolean.valueOf(!r4);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r5);
        MediaInteractCommentDataContext r6 = this.a.a;
        if (r6 == null) goto L9;
        r6.invite();
        return;
    }
}
