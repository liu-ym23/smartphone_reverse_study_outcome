package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

    public q(MultiLinkVideoTalkRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r22) {
        Long r0 = (Long) r22;
        jy0.b.f("KtvDigitAvatar", " auto apply set show_mode to audio", null, 4);
        DigitAvatarContext r1 = DigitAvatarContext.Companion.getContext();
        if (r1 == null) goto L5;
        DigitAvatarContext.setVideoShowMode$default(r1, VideoShowMode.AUDIO, null, 2, null);
    L5:
        this.a.apply(new sf0.a(0, 0, LinkApplyType.CITY.getValue(), 16, null, null, "video_city_auto_apply", 0, 0, 0, false, false, 0, null, null, 2, 393075));
    }
}
