package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.utils.f5;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ MessageCompositeWidget a;

    public i0(MessageCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        dh1.b r11 = (dh1.b) r10;
        com.bytedance.android.livesdk.log.b0 r0 = com.bytedance.android.livesdk.log.b0.o();
        String r1 = "receive BroadcastRtcRoomMessageEvent type:" + r11.b;
        r0.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_msg", r1);
        int r2 = r11.b;
        boolean r3 = true;
        if (r2 != 1) goto L24;
        MessageCompositeWidget r4 = this.a;
        String r5 = r11.a;
        dh1.a r12 = r11.c;
        int r6 = MessageCompositeWidget.d;
        MiddlewareRoomContext r7 = r4.getMiddlewareRoomContext();
        Context r8 = ((Widget) r4).context;
        if (r7 == null) goto L27;
        if (r8 == null) goto L28;
        com.bytedance.android.livesdk.log.b0 r9 = com.bytedance.android.livesdk.log.b0.o();
        String r13 = "startFetchRtcRoomMessage roomId: " + r12.a;
        r9.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_msg", r13);
        vlc.d r14 = (vlc.d) r7.getRtcRoomMessageManager().getValue();
        if (r14 == null) goto L10;
        r14.release();
    L10:
        f5 r15 = z4.b(r5, r12.a, r8, new LinkedHashMap());
        vlc.f r16 = r15.a;
        String r17 = r12.c;
        if (r17 != null) goto L13;
    L18:
        r17 = null;
    L19:
        if (r16 == null) goto L22;
        if (r17 == null) goto L22;
        r16.p(new j0(r17));
    L22:
        r15.startMessage();
        r7.getRtcRoomMessageManager().setValue(r15);
        r7.getRtcRoomInfo().setValue(r12);
        return;
    L13:
        if (r17.length() > 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L18;
    L28:
        return;
    L27:
        return;
    L24:
        if (r2 != 2) goto L30;
        MessageCompositeWidget r18 = this.a;
        int r19 = MessageCompositeWidget.d;
        r18.wq();
        return;
    }
}
