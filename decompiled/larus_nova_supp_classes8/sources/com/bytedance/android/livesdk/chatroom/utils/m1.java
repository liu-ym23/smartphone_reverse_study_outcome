package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m1 {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.mutableListOf(new String[]{"*bottom_bar"});
    }

    @JvmStatic
    public static final void b(ILiveRoomPlayFragment r3) {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r0 == null) goto L29;
        Map r1 = r0.getMap();
        if (r1 == null) goto L30;
        String r2 = (String) r1.get("action_type");
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L32;
        if (r3 == null) goto L33;
        ILiveRoomPlayFragment r5 = r3.getRealAction();
        if (r5 == null) goto L34;
        as0.a r6 = r5.roomPlayerContext();
        if (r6 == null) goto L35;
        ILivePlayerClient r7 = r6.player();
        if (r7 == null) goto L36;
        IPlayerLogger r8 = r7.logger();
        if (r8 == null) goto L37;
        ILivePlayerAppLogger r9 = r8.appLog();
        if (r9 == null) goto L38;
        r9.injectPlayEndParam("action_type", r2);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L11:
        r4 = false;
        goto L12
    L30:
        return;
    }

    @JvmStatic
    public static final boolean a(String r8, String r9) {
        if (r8 == null) goto L25;
        if (r9 == null) goto L25;
        Iterator<String> r1 = a.iterator();
    L8:
        if (r1.hasNext() == false) goto L25;
        String r2 = r1.next();
        boolean r4 = true;
        if (Intrinsics.areEqual(r2, r8 + '_' + r9) == true) goto L23;
        if (StringsKt.endsWith$default(r2, "*", false, 2, null) == false) goto L18;
        if (StringsKt.startsWith$default(r2, r8, false, 2, null) == true) goto L23;
    L18:
        if (StringsKt.startsWith$default(r2, "*", false, 2, null) == true) goto L20;
    L22:
        r4 = false;
        goto L23
    L20:
        if (StringsKt.endsWith$default(r2, r9, false, 2, null) == false) goto L22;
    L23:
        if (r4 == false) goto L8;
        return r4;
    L25:
        return false;
    }
}
