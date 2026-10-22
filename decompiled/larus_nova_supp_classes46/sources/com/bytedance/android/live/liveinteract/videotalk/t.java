package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public t(MultiLinkVideoTalkRoomGuestWidget r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        Long r12 = (Long) r11;
        jy0.b.f("KtvDigitAvatar", " auto timer reply set show_mode to audio", null, 4);
        DigitAvatarContext r13 = DigitAvatarContext.Companion.getContext();
        if (r13 == null) goto L5;
        DigitAvatarContext.setVideoShowMode$default(r13, VideoShowMode.AUDIO, null, 2, null);
    L5:
        cg6.a r14 = this.a.Bq();
        if (r14 == null) goto L14;
        MultiLinkGuestManager r15 = r14.W4();
        if (r15 == null) goto L15;
        long r1 = this.a.getMRoom().getId();
        String r0 = this.b;
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        r15.j(new sf0.e(r1, r0, this.c, ReplyType.Agree.ordinal(), 2, 32, 0));
        return;
    L15:
        return;
    }
}
