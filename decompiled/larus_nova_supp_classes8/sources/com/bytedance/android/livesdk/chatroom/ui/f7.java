package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.eq;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f7 {
    public static final Map<Long, Long> a = null;
    public static boolean b;
    public static long c;

    static {
        a = new LinkedHashMap();
    }

    public static boolean a(Room r9) {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L8;
        if (r0.ignoreECWidgetFrequency() != true) goto L8;
        return true;
    L8:
        if (r9 != null) goto L10;
        return false;
    L10:
        long r2 = r9.getRoomId();
        if (((Boolean) eq.a.getValue()).booleanValue() == true) goto L14;
        return false;
    L14:
        if (b == false) goto L17;
        return false;
    L17:
        if (r9.getRoomCart() != null) goto L19;
    L47:
        return false;
    L19:
        if (r9.getRoomCart().getShowCartExt() != 1) goto L47;
        User r10 = r9.getOwner();
        if (r10 != null) goto L25;
        return false;
    L25:
        if (r10.isFollowing() == true) goto L27;
        return false;
    L27:
        long r4 = System.currentTimeMillis() - c;
        Map<Long, Long> r11 = a;
        Long r6 = Long.valueOf(r2);
        Long r3 = (Long) ((LinkedHashMap) r11).get(Long.valueOf(r2));
        if (r3 == null) goto L30;
        long r5 = r3.longValue();
    L31:
        r11.put(r6, Long.valueOf(r5 + r4));
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r12 = ((LinkedHashMap) r11).entrySet().iterator();
    L33:
        if (r12.hasNext() == false) goto L41;
        Map.Entry r8 = (Map.Entry) r12.next();
        if (((Number) r8.getValue()).longValue() <= 30000) goto L37;
        boolean r13 = true;
    L38:
        if (r13 == false) goto L33;
        r7.put(r8.getKey(), r8.getValue());
        goto L33
    L37:
        r13 = false;
        goto L38
    L41:
        if (r7.size() > 0) goto L44;
        return false;
    L44:
        if (com.bytedance.android.livesdk.chatroom.utils.o4.e == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        r5 = 0;
        goto L31
    }
}
