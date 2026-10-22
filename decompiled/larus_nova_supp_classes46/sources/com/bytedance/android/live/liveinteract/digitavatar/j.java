package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ DigitAvatarEmojiDialog a;
    public final /* synthetic */ long b;

    public j(DigitAvatarEmojiDialog r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        int r0 = nd0.g.a;
        nd0.g.c(je0.d.f(), 1, 2, this.b, r10);
        DigitAvatarEmojiDialog r1 = this.a;
        DATA r11 = r10.data;
        if (r11 == 0) goto L27;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r12 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.k) r11;
        int r2 = DigitAvatarEmojiDialog.n;
        UtilityKotlinExtentionsKt.t(r1.findViewById(2131378151));
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r3 = r12.getEmojiList();
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r4 = r3;
        boolean r5 = false;
        if (r4 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        r1.O0(true);
    L15:
        if (r12.getSendLimitTime() <= 1000) goto L17;
        long r7 = r12.getSendLimitTime();
    L18:
        r1.a = r7;
        String r8 = r12.getSendLimitDesc();
        if (r8 != null) goto L21;
    L22:
        r5 = true;
    L23:
        if (r5 == true) goto L28;
        r1.b = r12.getSendLimitDesc();
        return;
    L28:
        return;
    L21:
        if (r8.length() != 0) goto L23;
    L17:
        r7 = 1000;
        goto L18
    L13:
        r1.O0(false);
        r1.P0(r3);
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("digit_avatar_emoji_list", ""), GsonProtectorUtils.toJson(GsonHelper.get(), r12));
        goto L15
    L7:
        if (r4.isEmpty() == true) goto L10;
        r6 = false;
        goto L11
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.ITalkRoomEmojiListResponse");
    }
}
