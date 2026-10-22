package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p8 implements DialogInterface.OnShowListener {
    public final /* synthetic */ m8 a;

    public p8(m8 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r6) {
        m8 r7 = this.a;
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("remaining", String.valueOf(r7.j / BubbleId.PadCast));
        s5 r8 = r7.g;
        if (r8 == null) goto L8;
        i6 r9 = r8.b();
        if (r9 == null) goto L8;
        String r10 = r9.b();
        if (r10 == null) goto L8;
    L9:
        r1[1] = TuplesKt.to("score", r10);
        Map r11 = MapsKt.mutableMapOf(r1);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_keep_popup_show", r11, new Object[]{Room.class, am2.x.class});
        return;
    L8:
        r10 = "";
        goto L9
    }
}
