package com.bytedance.android.livesdk.interactivity.comment.mention;

import am2.x;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ MentionSectionController a;

    public c(MentionSectionController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        int r6 = r5.getAction();
        if (r6 == 1) goto L9;
        if (r6 != 3) goto L12;
        this.a.m = false;
    L12:
        return false;
    L9:
        if (this.a.m == false) goto L11;
        j0.l().sendLog("livesdk_comment_expansion_mention_list_slide", null, new Object[]{IRoom.class, x.class});
    L11:
        this.a.m = false;
        goto L12
    }
}
