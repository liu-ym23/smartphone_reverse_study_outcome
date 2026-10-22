package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public l(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        if (((LinkmicSubtitleStatus) r10) != LinkmicSubtitleStatus.OPEN) goto L9;
        LinkmicSubtitleBusinessWidget r11 = this.a;
        int r0 = LinkmicSubtitleBusinessWidget.x;
        if (r11.isAnchor() == false) goto L7;
        s r12 = t.a;
        long r1 = System.currentTimeMillis();
        r12.b = r1;
        r12.a = r1;
        t.h(u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48), t.b(Integer.valueOf(((q2) this.a.Aq().getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        return;
    L7:
        int r13 = g0.a;
        s r14 = t.a;
        long r2 = System.currentTimeMillis();
        r14.b = r2;
        r14.a = r2;
        t.h(u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48), t.b(Integer.valueOf(((q2) this.a.Aq().getLinkmicSubtitleSettingStatus().getValue()).getSubtitleType())));
        return;
    }
}
