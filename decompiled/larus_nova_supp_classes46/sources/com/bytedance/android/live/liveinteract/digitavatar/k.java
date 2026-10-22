package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ DigitAvatarEmojiDialog a;
    public final /* synthetic */ long b;

    public k(DigitAvatarEmojiDialog r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r5 = (Throwable) r7;
        TalkRoomBusinessFullLinkMonitor r8 = TalkRoomBusinessFullLinkMonitor.a;
        int r0 = je0.d.f();
        long r3 = this.b;
        r8.getClass();
        TalkRoomBusinessFullLinkMonitor.y(r0, 1, 2, r3, r5);
        DigitAvatarEmojiDialog r9 = this.a;
        int r1 = DigitAvatarEmojiDialog.n;
        UtilityKotlinExtentionsKt.t(r9.findViewById(2131378151));
        String r2 = (String) new com.bytedance.android.livesdk.sharedpref.e("digit_avatar_emoji_list", "").getValue();
        if (StringUtils.isEmpty(r2) == false) goto L5;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r4 = null;
    L6:
        if (r4 == null) goto L8;
        r9.P0(r4);
    L8:
        e0 r6 = r9.i;
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.getItemCount() != 0) goto L15;
        r9.O0(true);
        return;
    L15:
        return;
    L5:
        r4 = ((com.bytedance.android.live.liveinteract.videotalk.emoji.model.k) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.k.class)).getEmojiList();
        goto L6
    }
}
