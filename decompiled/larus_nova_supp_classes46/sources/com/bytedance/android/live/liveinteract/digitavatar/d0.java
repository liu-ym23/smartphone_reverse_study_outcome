package com.bytedance.android.live.liveinteract.digitavatar;

import android.view.View;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ TalkRoomBaseDynamicEmoji a;
    public final /* synthetic */ e0 b;

    public d0(TalkRoomBaseDynamicEmoji r1, e0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.live.liveinteract.videotalk.emoji.s r3 = this.b.b;
        if (r3 == null) goto L6;
        r3.j0(this.a);
        return;
    }
}
