package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap a(IRoom r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L6;
        return r0;
    L6:
        if (r5.getWithLinkMic() == true) goto L8;
    L18:
        return r0;
    L8:
        if (r5.isLiveTypeAudio() == true) goto L17;
        Map r6 = r5.getLinkMap();
        if (r6 == null) goto L14;
        Long r7 = (Long) r6.get("8");
        if (r7 == null) goto L14;
        long r3 = r7.longValue();
    L16:
        if (r3 <= 0) goto L18;
    L14:
        r3 = 0;
    L17:
        r0.put("interact_function", "chat_room");
        goto L18
    }

    @JvmStatic
    public static final String b(IRoom r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 == null) goto L12;
        if (r2.isMediaRoom() != true) goto L12;
        return "is_media";
    L12:
        if (d1.a(r2) == false) goto L14;
        return "is_game";
    L14:
        return "other";
    L5:
        if (r2.isMergeVSRoom() != true) goto L7;
        return "is_vs";
    }
}
