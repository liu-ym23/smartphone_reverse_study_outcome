package com.bytedance.android.live.room.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    static {
    }

    public static boolean a(Room r7) {
        boolean r0 = false;
        Object r1 = null;
        if (r7 == null) goto L18;
        LiveToolbarData r3 = r7.getToolbarData();
        if (r3 == null) goto L18;
        List r4 = r3.getLandScapeTop();
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        if (((ToolbarComponentData) r6).getId() != 20) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L10;
        r1 = r6;
        goto L17
    L14:
        r8 = false;
    L17:
        r1 = (ToolbarComponentData) r1;
    L18:
        if (r1 == null) goto L20;
        r0 = true;
    L20:
        if (r7 == null) goto L25;
        if (r7.isMergeVSRoom() != true) goto L25;
        return true;
    L25:
        return r0;
    }
}
