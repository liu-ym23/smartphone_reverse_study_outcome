package com.bytedance.android.live.liveinteract.revenue.battle;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static long a() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        return r1.getRoomId();
    L7:
        return 0;
    }

    static {
    }

    public static String b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getTextBgColorByDressId] dressId ".concat(r8));
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L11;
        zt0.e r1 = yt0.c.a();
        Intrinsics.checkNotNull(r8);
        com.bytedance.android.live.profit.dress.s r9 = r1.getDressData(r8, 33, a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new f());
        if (r9 == null) goto L11;
        return r9.g;
    L11:
        return null;
    L5:
        r0 = false;
        goto L6
    }

    public static String c(String r8) {
        Intrinsics.checkNotNullParameter(r8, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getTextColorByDressId] dressId ".concat(r8));
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L11;
        zt0.e r1 = yt0.c.a();
        Intrinsics.checkNotNull(r8);
        com.bytedance.android.live.profit.dress.s r9 = r1.getDressData(r8, 33, a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new g());
        if (r9 == null) goto L11;
        return r9.h;
    L11:
        return null;
    L5:
        r0 = false;
        goto L6
    }

    public static Uri d(String r9) {
        Intrinsics.checkNotNullParameter(r9, "dressId");
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L12;
        zt0.e r2 = yt0.c.a();
        Intrinsics.checkNotNull(r9);
        com.bytedance.android.live.profit.dress.s r10 = r2.getDressData(r9, 33, a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new d());
        if (r10 == null) goto L12;
        String r11 = r10.b;
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L17;
        return null;
    L17:
        return UriProtector.parse(r11);
    L12:
        r11 = null;
        goto L14
    L5:
        r0 = false;
        goto L7
    }
}
