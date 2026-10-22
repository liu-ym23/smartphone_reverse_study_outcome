package com.bytedance.android.livesdk.dynamicstrategy.impl;

import android.text.TextUtils;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.d;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.e;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.f;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.g;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.h;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.i;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.j;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.k;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final List<String> a = null;
    public static final boolean b = false;
    public static final boolean c = false;
    public static final List<String> d = null;

    static {
        a = CollectionsKt.listOf(new String[]{"short_touch_tempstate_lottery_activity", "short_touch_tempstate_lottery_interest", "short_touch_tempstate_redpack_interest", "short_touch_tempstate_redpack_behavior", "short_touch_tempstate_coupon_behavior", "short_touch_tempstate_redpack_entry_type", "short_touch_tempstate_redpack_match_amunt", "short_touch_tempstate_redpack_user_wish_tobuy", "public_screen_speed_strategy", "danmaku_speed_strategy", "public_screen_load_history_strategy"});
        ku1.c r0 = ku1.c.a;
        b = ((ku1.b) r0.getValue()).b();
        c = ((ku1.b) r0.getValue()).g();
        d = ((ku1.b) r0.getValue()).a();
    }

    public static iu1.b a(String r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "strategyName");
        if (b == false) goto L11;
        boolean r0 = a.contains(r4);
        boolean r1 = c;
        List<String> r2 = d;
        if (r0 == false) goto L12;
        if (r1 == true) goto L12;
        if (r2.contains(r4) == false) goto L11;
    L12:
        boolean r3 = true;
    L13:
        iu1.b r6 = null;
        if (r3 == false) goto L27;
        boolean r7 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a;
        Iterator r8 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a().iterator();
    L17:
        if (r8.hasNext() == false) goto L21;
        Object r9 = r8.next();
        if (TextUtils.equals(((a0) r9).strategyName, r4) == false) goto L17;
    L22:
        a0 r10 = (a0) r9;
        if (r10 == null) goto L27;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.b r11 = mu1.b.c(r10);
        if (r11 == null) goto L27;
        o r12 = new o(r11);
    L28:
        if (r12 == null) goto L30;
        return r12;
    L30:
        switch(r4.hashCode()) {
            case -2121324133: goto L68;
            case -930212246: goto L65;
            case -426427736: goto L62;
            case -330904760: goto L58;
            case -175901183: goto L55;
            case 134276292: goto L52;
            case 199833222: goto L49;
            case 707863213: goto L46;
            case 1038451578: goto L42;
            case 1074786284: goto L39;
            case 1296157317: goto L36;
            case 1608053371: goto L33;
            default: goto L73;
        };
    L33:
        if (r4.equals("short_touch_tempstate_redpack_match_amunt") == false) goto L73;
        r6 = new com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.c();
        goto L73
    L36:
        if (r4.equals("short_touch_tempstate_lottery_interest") == false) goto L73;
        r6 = new i();
        goto L73
    L39:
        if (r4.equals("short_touch_tempstate_redpack_behavior") == false) goto L73;
        r6 = new k();
        goto L73
    L42:
        if (r4.equals("public_screen_load_history_strategy") == false) goto L73;
        if (r5 == null) goto L73;
        iu1.b r13 = new e(r5);
    L71:
        r6 = r13;
        goto L73
    L46:
        if (r4.equals("short_touch_tempstate_redpack_user_wish_tobuy") == false) goto L73;
        r6 = new d();
        goto L73
    L49:
        if (r4.equals("short_touch_tempstate_coupon_behavior") == false) goto L73;
        r6 = new com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.a();
        goto L73
    L52:
        if (r4.equals("short_touch_tempstate_redpack_interest") == false) goto L73;
        r6 = new l();
        goto L73
    L55:
        if (r4.equals("short_touch_tempstate_redpack_entry_type") == false) goto L73;
        r6 = new com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy.b();
        goto L73
    L58:
        if (r4.equals("public_screen_speed_strategy") == false) goto L73;
        if (r5 == null) goto L73;
        r13 = new j(r5);
        goto L71
    L62:
        if (r4.equals("live_component_strategy") == false) goto L73;
        r6 = new g();
        goto L73
    L65:
        if (r4.equals("short_touch_tempstate_lottery_activity") == false) goto L73;
        r6 = new h();
        goto L73
    L68:
        if (r4.equals("danmaku_speed_strategy") == false) goto L73;
        if (r5 == null) goto L73;
        r13 = new f(r5);
    L73:
        return r6;
    L21:
        r9 = null;
    L27:
        r12 = null;
    L11:
        r3 = false;
        goto L13
    }
}
