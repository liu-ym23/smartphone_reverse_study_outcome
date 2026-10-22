package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public s(MultiLinkVideoTalkRoomGuestWidget r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r22) {
        Long r1 = (Long) r22;
        jy0.b.f("ttlive_link_video", " auto timer apply set show_mode to audio", null, 4);
        DigitAvatarContext r2 = DigitAvatarContext.Companion.getContext();
        if (r2 == null) goto L5;
        DigitAvatarContext.setVideoShowMode$default(r2, VideoShowMode.AUDIO, null, 2, null);
    L5:
        MultiLinkVideoTalkRoomGuestWidget r3 = this.a;
        int r5 = this.b;
        r3.apply(new sf0.a(0, this.c, r5, 16, null, null, "video_auto_link_mic", 0, 0, 0, false, false, 0, null, null, 2, 393073));
    }
}
