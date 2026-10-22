package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(d52.a r1) {
        if (Intrinsics.areEqual(r1, d52.a.c.a) == false) goto L6;
        return "14";
    L6:
        if (Intrinsics.areEqual(r1, d52.a.C0224a.b) == false) goto L9;
        return "16";
    L9:
        if (Intrinsics.areEqual(r1, d52.a.b.b) == false) goto L13;
        return "18";
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static String b(d52.b r1) {
        if (Intrinsics.areEqual(r1, d52.b.C0225b.a) == false) goto L6;
        return "standard";
    L6:
        if (Intrinsics.areEqual(r1, d52.b.c.b) == false) goto L9;
        return "middle";
    L9:
        if (Intrinsics.areEqual(r1, d52.b.a.b) == false) goto L13;
        return "high";
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final void c(String r6, d52.b r7, d52.a r8) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "quitHeight");
        Intrinsics.checkNotNullParameter(r8, "quitFontSize");
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L9;
        int r3 = r2.getAgeRange();
    L10:
        String r4 = "0";
        if (r3 < 4) goto L13;
        String r5 = "1";
    L14:
        Pair[] r9 = new Pair[7];
        r9[0] = TuplesKt.to("event_page", r6);
        r9[1] = TuplesKt.to("is_elder", r5);
        r9[2] = TuplesKt.to("height_setting_before", b(z42.a.c.e()));
        r9[3] = TuplesKt.to("height_setting_after", b(r7));
        String r10 = (String) ((HashMap) l42.a.b.getValue()).get("public_screen_operate_freq");
        if (r10 == null) goto L18;
        r4 = r10;
    L18:
        r9[4] = TuplesKt.to("screen_consume_layer", r4);
        r9[5] = TuplesKt.to("font_size_before", a(y42.a.c.b()));
        r9[6] = TuplesKt.to("font_size_after", a(r8));
        Map r11 = MapsKt.mutableMapOf(r9);
        j0.l().sendLog("livesdk_audience_screen_message_setting_submit", r11, new Object[]{IRoom.class, am2.x.class});
        return;
    L13:
        r5 = "0";
    L9:
        r3 = -1;
        goto L10
    }
}
