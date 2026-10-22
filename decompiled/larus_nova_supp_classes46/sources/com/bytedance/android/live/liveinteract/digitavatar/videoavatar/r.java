package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ o a;

    public r(o r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r2;
        if (this.a.l == VideoShowMode.DIGIT_AVATAR) goto L10;
        DigitAvatarContext r4 = DigitAvatarContext.Companion.getContext();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.getUsedAvatarThisLinkRound();
        if (r5 == null) goto L12;
        r5.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    L11:
        return;
    }
}
