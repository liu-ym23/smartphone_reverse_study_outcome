package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.config.w9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e7 {
    public static final Map<Long, Long> a = null;
    public static boolean b;
    public static long c;

    static {
        a = new LinkedHashMap();
    }

    public static boolean a(Room r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        long r1 = r9.getRoomId();
        if (w9.a.getValue().booleanValue() == true) goto L9;
        return false;
    L9:
        if (b == false) goto L11;
        return false;
    L11:
        User r10 = r9.getOwner();
        if (r10 != null) goto L15;
        return false;
    L15:
        if (r10.isFollowing() == true) goto L17;
        return false;
    L17:
        long r3 = System.currentTimeMillis() - c;
        Map<Long, Long> r11 = a;
        Long r5 = Long.valueOf(r1);
        Long r2 = (Long) ((LinkedHashMap) r11).get(Long.valueOf(r1));
        if (r2 == null) goto L20;
        long r4 = r2.longValue();
    L21:
        r11.put(r5, Long.valueOf(r4 + r3));
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r12 = ((LinkedHashMap) r11).entrySet().iterator();
    L22:
        boolean r7 = true;
        if (r12.hasNext() == false) goto L31;
        Map.Entry r8 = (Map.Entry) r12.next();
        if (((Number) r8.getValue()).longValue() > 30000) goto L28;
        r7 = false;
    L28:
        if (r7 == false) goto L22;
        r6.put(r8.getKey(), r8.getValue());
        goto L22
    L31:
        if (r6.size() > 0) goto L34;
        return false;
    L34:
        if (com.bytedance.android.livesdk.chatroom.utils.o4.f == true) goto L36;
        return false;
    L36:
        return true;
    L20:
        r4 = 0;
        goto L21
    }
}
