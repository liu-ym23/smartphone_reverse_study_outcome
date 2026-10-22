package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements com.bytedance.android.livesdk.log.filter.v {
    public static final g a = null;

    public g() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new g();
    }

    public static void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Integer r0 = je0.d.h();
        List<Integer> r1 = je0.d.d();
        int r2 = TalkRoomLogUtils.b.a;
        if (r0 == null) goto L5;
        String r3 = u0.i(r0, r1, Integer.valueOf(r2));
    L7:
        if (r3 != null) goto L9;
    L11:
        if (r3 == null) goto L13;
    L16:
        if (r0 != null) goto L28;
        com.bytedance.android.livesdk.chatroom.o r4 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r4 == null) goto L28;
        com.bytedance.live.datacontext.m r6 = r4.getRoom();
        if (r6 == null) goto L28;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L28;
        if (r7.isLiveTypeAudio() != true) goto L28;
        if (r5.get("voice_mode") != null) goto L28;
        r5.put("voice_mode", "head");
    L28:
        if (r0 == null) goto L36;
        if (r0.intValue() != 29) goto L36;
        if (r5.get("voice_mode") != null) goto L36;
        r5.put("voice_mode", "head");
    L36:
        if (je0.d.v() == true) goto L50;
        if (r0 != null) goto L40;
    L41:
        if (r0 == null) goto L47;
        if (r0.intValue() == 7) goto L50;
    L47:
        if (r5.get("seat_fit_status") != null) goto L53;
        r5.put("seat_fit_status", "off");
        return;
    L53:
        return;
    L40:
        if (r0.intValue() != 2) goto L41;
    L50:
        if (r5.get("seat_fit_status") != null) goto L55;
        r5.put("seat_fit_status", "on");
        return;
    L55:
        return;
    L13:
        if (r5.get("layout_type") != null) goto L16;
        r5.put("layout_type", "normal");
        goto L16
    L9:
        if (r5.get("layout_type") != null) goto L11;
        r5.put("layout_type", r3);
        goto L16
    L5:
        r3 = TalkRoomLogUtils.x;
        goto L7
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r3.containsKey("function_type2") == true) goto L6;
        r3.put("function_type2", TalkRoomLogUtils.h);
    L6:
        if (r3.containsKey("is_from_audience") == false) goto L8;
    L15:
        a(r3);
        return;
    L8:
        if (us1.e.a == false) goto L10;
    L13:
        String r0 = "0";
    L14:
        r3.put("is_from_audience", r0);
        goto L15
    L10:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L13;
        r0 = "1";
        goto L14
    }
}
