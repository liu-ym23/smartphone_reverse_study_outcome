package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "roomId");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Keva r1 = Keva.getRepo("need_delete_room_after_report");
        String[] r2 = r1.getStringArray("room_list", new String[0]);
        if (r2 != null) goto L11;
        r2 = new String[0];
    L11:
        List r3 = ArraysKt.toMutableList(r2);
        if (r3.contains(r6) == false) goto L14;
    L17:
        Object[] r4 = r3.toArray(new String[0]);
        if (r4 == null) goto L22;
        r1.storeStringArray("room_list", (String[]) r4);
        ALogger.d("ReportRoomHelper", "record need deleted room " + r6 + " in keva");
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        if (r3.size() < 10) goto L16;
        ListProtector.remove(r3, 0);
    L16:
        r3.add(r6);
        goto L17
    L5:
        r0 = false;
        goto L6
    }
}
