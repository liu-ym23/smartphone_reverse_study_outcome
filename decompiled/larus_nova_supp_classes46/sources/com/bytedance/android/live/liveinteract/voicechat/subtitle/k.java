package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.chatroom.event.KtvRoomLyricsStateEventType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public k(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        jd0.d r5 = (jd0.d) r4;
        LinkmicSubtitleBusinessWidget r0 = this.a;
        int r1 = LinkmicSubtitleBusinessWidget.x;
        r0.getClass();
        ALogger.i("LinkmicSubtitleBusinessWidget", "[AudioSubtitle] KtvRoomLyricsStateEvent type = " + r5.a.getValue());
        KtvRoomLyricsStateEventType r6 = r5.a;
        if (r6 != KtvRoomLyricsStateEventType.TURNING_NEXT) goto L5;
    L12:
        boolean r7 = true;
    L14:
        if (r0.m == r7) goto L16;
        r0.cr();
    L16:
        r0.m = r7;
        r0.fr();
        return;
    L5:
        if (r6 == KtvRoomLyricsStateEventType.SINGER_BEGIN_SING) goto L12;
        if (r6 == KtvRoomLyricsStateEventType.SING) goto L12;
        if (r6 == KtvRoomLyricsStateEventType.RESUME_SING) goto L12;
        r7 = false;
        goto L14
    }
}
