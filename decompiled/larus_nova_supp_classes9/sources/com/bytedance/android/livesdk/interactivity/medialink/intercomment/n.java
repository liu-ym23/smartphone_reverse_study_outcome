package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements MediaInteractCommentBeInviteDialog.a {
    public final /* synthetic */ MediaInteractCommentWidget a;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentBeInviteDialog.a
    public final void a() {
        MediaInteractCommentWidget.xq(this.a);
        this.a.g.getClass();
        d.d(false);
    }

    public n(MediaInteractCommentWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentBeInviteDialog.a
    public final void b(int r4, boolean r5) {
        MediaInteractCommentDataContext r0 = this.a.a;
        if (r0 == null) goto L5;
        r0.reply(r4, r5);
    L5:
        MediaInteractCommentWidget r1 = this.a;
        if (r1.d == false) goto L20;
        r1.g.getClass();
        HashMap r2 = new HashMap();
        r2.put("connection_scene", "connection");
        r2.put("channel_id", String.valueOf(e92.m.b()));
        if (r4 != 1) goto L11;
        String r6 = "agree";
    L14:
        r2.put("result", r6);
        if (r5 == false) goto L17;
        String r7 = "1";
    L18:
        r2.put("is_no_more_recieve", r7);
        d.a(r2);
        u.l().sendLog("livesdk_comment_interflow_invite_handle", r2, new Object[]{Room.class});
        return;
    L17:
        r7 = "0";
        goto L18
    L11:
        if (r4 != 3) goto L13;
        r6 = "refuse_time_up";
        goto L14
    L13:
        r6 = "refuse_click";
        goto L14
    }
}
