package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorStickerWrapperWidget a;
    public final /* synthetic */ RoomDecoration b;

    public b(AnchorStickerWrapperWidget r1, RoomDecoration r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Long r11 = (Long) r10;
        AnchorStickerWrapperWidget r12 = this.a;
        RoomDecoration r0 = this.b;
        String r1 = AnchorStickerWrapperWidget.C;
        r12.getClass();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getType() != 1) goto L7;
        boolean r2 = true;
    L8:
        long r4 = r12.i.id;
        HashMap r6 = new HashMap();
        r6.put("room_id", String.valueOf(r4));
        r6.put("prop_id", String.valueOf(r0.getId()));
        if (r2 == false) goto L14;
        String r3 = r12.Iq().k0(r0);
        if (StringsKt.isBlank(r3) == false) goto L13;
        ALogger.w(AnchorStickerWrapperWidget.C, "reportEffectiveUseLogger text sticker empty content, aborting");
        return;
    L13:
        r6.put("words", r3);
    L14:
        User r5 = r12.i.getOwner();
        if (r5 == null) goto L17;
        r6.put("anchor_id", r5.getIdStr());
    L17:
        com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
        if (r2 == false) goto L20;
        String r8 = "live_character_prop_effective_use";
    L21:
        am2.x r9 = new am2.x();
        r9.b = "live_take_detail";
        r9.e = "other";
        r9.a = "live_take";
        r7.sendLog(r8, r6, new Object[]{r9, new am2.z()});
        if (r2 == false) goto L24;
        r12.l = true;
        return;
    L24:
        r12.k = true;
        return;
    L20:
        r8 = "live_picture_prop_effective_use";
        goto L21
    L7:
        r2 = false;
        goto L8
    }
}
