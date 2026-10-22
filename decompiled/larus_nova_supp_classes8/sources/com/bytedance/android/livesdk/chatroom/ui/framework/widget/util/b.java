package com.bytedance.android.livesdk.chatroom.ui.framework.widget.util;

import com.bytedance.android.livesdk.config.wg;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final HashMap<Long, ArrayList<HashMap<String, String>>> a = null;
    public static final HashMap<Long, Integer> b = null;

    static {
        a = new HashMap();
        b = new HashMap();
    }

    public static void a(Room r3, int r4, HashMap r5) {
        HashMap<Long, ArrayList<HashMap<String, String>>> r0 = a;
        if (r0.get(Long.valueOf(r3.id)) != null) goto L6;
        r0.put(Long.valueOf(r3.id), new ArrayList());
    L6:
        if (r4 >= wg.a.getValue().e()) goto L10;
        ArrayList<HashMap<String, String>> r6 = r0.get(Long.valueOf(r3.id));
        if (r6 == null) goto L14;
        r6.add(r5);
        return;
    L14:
        return;
    L10:
        ArrayList<HashMap<String, String>> r7 = r0.get(Long.valueOf(r3.getRoomId()));
        if (r7 == null) goto L16;
        r7.clear();
        return;
    }
}
