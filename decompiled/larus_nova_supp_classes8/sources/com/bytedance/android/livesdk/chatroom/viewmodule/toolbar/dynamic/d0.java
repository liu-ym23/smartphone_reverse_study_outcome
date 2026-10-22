package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.z7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 {
    public static final /* synthetic */ int a = 0;

    public d0() {
    }

    static {
    }

    public static void a(String r8, DataCenter r9, boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "toolbarId");
        Intrinsics.checkNotNullParameter(r11, "reason");
        if (Intrinsics.areEqual(r8, String.valueOf(5)) == false) goto L7;
        if (r9 == null) goto L7;
        r9.put("data_game_promote_has_toolbar_error", Boolean.TRUE);
    L7:
        if (((Boolean) z7.a.getValue()).booleanValue() == true) goto L10;
        return;
    L10:
        if (r9 == null) goto L14;
        Boolean r3 = (Boolean) r9.get("data_is_anchor", Boolean.FALSE);
        if (r3 == null) goto L14;
        boolean r4 = r3.booleanValue();
    L15:
        if (r9 == null) goto L20;
        IRoom r5 = com.bytedance.android.live.core.utils.a0.o(r9);
        if (r5 == null) goto L20;
        String r6 = String.valueOf(r5.getRoomId());
        if (r6 == null) goto L20;
    L21:
        if (r9 == null) goto L23;
        boolean r13 = com.bytedance.android.live.core.utils.a0.c(r9);
    L24:
        Pair[] r7 = new Pair[8];
        r7[0] = TuplesKt.to("toolbar_id", r8);
        String r14 = "1";
        if (r4 == false) goto L27;
        Object r15 = "1";
    L28:
        r7[1] = TuplesKt.to("is_anchor", r15);
        r7[2] = TuplesKt.to("room_id", r6);
        if (r10 == false) goto L31;
        Object r16 = "1";
    L32:
        r7[3] = TuplesKt.to("is_from_im", r16);
        if (r13 == false) goto L35;
        Object r17 = "1";
    L36:
        r7[4] = TuplesKt.to("is_preview", r17);
        r7[5] = TuplesKt.to("reason", r11);
        if (e5.n() == false) goto L40;
        r14 = "0";
    L40:
        r7[6] = TuplesKt.to("is_portrait", r14);
        r7[7] = TuplesKt.to("extra", r12);
        Map r18 = MapsKt.mutableMapOf(r7);
        j0.l().sendLog("livesdk_toolbar_error_event", r18, new Object[0]);
        return;
    L35:
        r17 = "0";
        goto L36
    L31:
        r16 = "0";
        goto L32
    L27:
        r15 = "0";
        goto L28
    L23:
        r13 = false;
    L20:
        r6 = "";
    L14:
        r4 = false;
        goto L15
    }
}
