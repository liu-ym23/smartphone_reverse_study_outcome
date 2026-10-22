package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.effectmanager.common.utils.MD5Utils;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class t3 implements Consumer {
    public final /* synthetic */ u3 a;

    public /* synthetic */ t3(gj1.d.a r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        gj1.d.a r0 = this.a;
        JSONObject r9 = (JSONObject) r8;
        Room r1 = jc1.k.f(ILiveRoomService.class).getCurrentRoom();
        if (r1 == null) goto L5;
        String r2 = r1.getIdStr();
    L7:
        if (r9.has("ts") == false) goto L9;
        long r3 = JSONObjectProtectorUtils.getLong(r9, "ts");
    L11:
        if (r9.has("heart_beat") == false) goto L29;
        JSONObject r10 = r9.optJSONObject("heart_beat");
        if (r10 != null) goto L15;
    L17:
        if (r10 == null) goto L29;
        if (r10.has("sign") == false) goto L29;
        String r11 = r10.optString("sign");
        if (TextUtils.isEmpty(r11) == true) goto L29;
        if (TextUtils.isEmpty(r2) == true) goto L29;
        String r4 = MD5Utils.getMD5String(r2);
        if (r4.length() < 5) goto L29;
        if (TextUtils.equals(r11, r4.substring(r4.length() - 5)) == true) goto L29;
        return;
    L15:
        if (r10.has("ts") == false) goto L17;
        r3 = r10.optLong("ts");
    L29:
        if (r0 == null) goto L32;
        r0.a.updateStreamDelay(r3);
        return;
    L32:
        return;
    L9:
        r3 = 0;
        goto L11
    L5:
        r2 = "";
        goto L7
    }
}
