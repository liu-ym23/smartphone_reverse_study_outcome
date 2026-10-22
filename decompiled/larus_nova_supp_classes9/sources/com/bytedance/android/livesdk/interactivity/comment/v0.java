package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v0 implements h80.a<IRoom> {
    public final /* synthetic */ CommentWidget a;

    public v0(CommentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        IRoom r6 = (IRoom) r5;
        if (this.a.r == null) goto L6;
        ALogger.i("CommentWidget", "emoji entry visible, roomId:" + this.a.r.getRoomId());
    L6:
        if (this.a.K == true) goto L9;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_emoji_show", null, new Object[]{am2.x.class, Room.class});
        this.a.K = true;
        return;
    }
}
