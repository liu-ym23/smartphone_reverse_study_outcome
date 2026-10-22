package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ TempAreaDynamicLoader a;

    public i(TempAreaDynamicLoader r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        List r14 = (List) r13;
        TempAreaDynamicLoader r0 = this.a;
        r0.h = false;
        JSONObject r2 = new JSONObject();
        Room r3 = r0.g;
        ExtendedToolbarButton.c r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getOwnerUserIdString();
    L6:
        r2.put("anchor_id", String.valueOf(r5));
        Room r1 = r0.g;
        if (r1 == null) goto L9;
        String r6 = r1.getIdStr();
    L10:
        r2.put("room_id", String.valueOf(r6));
        com.bytedance.android.livesdk.service.f r7 = TTLiveSDKContext.getHostService();
        if (r7 == null) goto L16;
        com.bytedance.android.livesdk.user.f r8 = r7.h();
        if (r8 == null) goto L16;
        String r9 = r8.n();
        if (r9 == null) goto L16;
    L17:
        r2.put("user_id", r9);
        r2.put("source_type", "interaction_pannel");
        r2.put("squad_enter", "false");
        if (r14 == null) goto L31;
        Iterator<T> r10 = r14.iterator();
    L21:
        if (r10.hasNext() == false) goto L29;
        T r11 = r10.next();
        if (((ExtendedToolbarButton.c) r11).n != TempStateAreaReachMessage.ELEM_TYPE.PLAY_TOGETHER.getType()) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L21;
        r4 = r11;
        goto L29
    L25:
        r12 = false;
    L29:
        if (r4 == null) goto L31;
        r2.put("squad_enter", "true");
    L31:
        ALogger.i("ttlive_audience_squad_entrance_response", r2.toString());
        this.a.j.clear();
        if (r14 == null) goto L36;
        List r15 = r14;
        if ((!r15.isEmpty()) != true) goto L36;
        this.a.j.addAll(r15);
    L36:
        this.a.s.invoke("temp area fetch success");
        return;
    L16:
        r9 = "0";
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
