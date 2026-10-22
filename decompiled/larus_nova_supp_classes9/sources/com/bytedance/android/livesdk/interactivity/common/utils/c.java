package com.bytedance.android.livesdk.interactivity.common.utils;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void c(boolean r4) {
        HashMap r0 = new HashMap();
        r0.put("enable", String.valueOf(r4));
        j0.l().sendLog("livesdk_live_contour_enable", r0, new Object[]{new x(), IRoom.class});
    }

    @JvmStatic
    public static final void a(Long r6, Long r7) {
        HashMap r0 = new HashMap();
        if (r6 != null) goto L6;
    L8:
        if (r6 != null) goto L11;
    L13:
        String r8 = BuildConfig.FLAVOR;
    L14:
        r0.put("trigger_type", r8);
        r0.put("duration", String.valueOf(r7));
        j0.l().sendLog("livesdk_comment_carnival_loading_time", r0, new Object[]{new x(), IRoom.class});
        return;
    L11:
        if (r6.longValue() != 2) goto L13;
        r8 = com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_SETTING;
        goto L14
    L6:
        if (r6.longValue() != 1) goto L8;
        r8 = "prop";
        goto L14
    }

    @JvmStatic
    public static final void b(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r8, String r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r9, "carnivalType");
        Intrinsics.checkNotNullParameter(r10, "extra");
        HashMap r0 = new HashMap();
        if (r8 == null) goto L5;
        Long r2 = Long.valueOf(r8.h());
    L6:
        if (r2 != null) goto L9;
    L11:
        if (r2 != null) goto L14;
    L16:
        String r3 = BuildConfig.FLAVOR;
    L17:
        r0.put("trigger_type", r3);
        if (r8 == null) goto L20;
        Long r4 = Long.valueOf(r8.getMessageId());
    L21:
        r0.put("comment_carnival_ID", String.valueOf(r4));
        if (r8 == null) goto L26;
        Map<String, String> r11 = r8.f();
        if (r11 == null) goto L26;
        r0.putAll(r11);
    L26:
        r0.put("carnival_type", r9);
        if ((!r10.isEmpty()) == true) goto L30;
        r10 = null;
    L30:
        if (r10 == null) goto L32;
        r0.putAll(r10);
    L32:
        j0.l().sendLog("livesdk_comment_carnival_start_show", r0, new Object[]{new x(), IRoom.class});
        return;
    L20:
        r4 = null;
        goto L21
    L14:
        if (r2.longValue() != 2) goto L16;
        r3 = com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_SETTING;
        goto L17
    L9:
        if (r2.longValue() != 1) goto L11;
        r3 = "prop";
        goto L17
    L5:
        r2 = null;
        goto L6
    }
}
