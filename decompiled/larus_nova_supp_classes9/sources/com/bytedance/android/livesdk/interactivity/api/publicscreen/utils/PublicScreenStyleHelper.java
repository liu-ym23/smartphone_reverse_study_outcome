package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.settings.config.m0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenStyleHelper {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final float f = 0.0f;
    public static final float g = 0.0f;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> h = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> i = null;
    public static final Lazy j = null;
    public static long k;
    public static int l;
    public static boolean m;
    public static boolean n;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> o = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> p = null;
    public static int q;
    public static int r;

    public static final m0 b() {
        return (m0) j.getValue();
    }

    static {
        a = UtilityKotlinExtentionsKt.i(60);
        b = UtilityKotlinExtentionsKt.i(3);
        c = UtilityKotlinExtentionsKt.i(3);
        d = UtilityKotlinExtentionsKt.i(4);
        e = UtilityKotlinExtentionsKt.i(5);
        f = UtilityKotlinExtentionsKt.h(3);
        g = UtilityKotlinExtentionsKt.h(4);
        Boolean r1 = Boolean.TRUE;
        h = new com.bytedance.android.livesdk.sharedpref.e("live_public_screen_config_start_live_red_dot", r1);
        i = new com.bytedance.android.livesdk.sharedpref.e("live_public_scree_config_toolbar_red_dot", r1);
        j = LazyKt.lazy(PublicScreenStyleHelper$psOptConfig$2.INSTANCE);
        Class r2 = Integer.TYPE;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = new com.bytedance.android.livesdk.sharedpref.e("public_screen_font_size_level", r2);
        o = r0;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r3 = new com.bytedance.android.livesdk.sharedpref.e("public_screen_height_level", r2);
        p = r3;
        Integer r4 = (Integer) r0.getValue();
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        boolean r6 = true;
        int r7 = 0;
        if (r5 < 0) goto L11;
        if (2 < r5) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L15;
        r5 = 0;
    L15:
        q = r5;
        Integer r9 = (Integer) r3.getValue();
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L19:
        if (r10 < 0) goto L23;
        if (2 < r10) goto L23;
    L24:
        if (r6 == false) goto L26;
        r7 = r10;
    L26:
        r = r7;
        return;
    L23:
        r6 = false;
        goto L24
    L18:
        r10 = b().b();
    L11:
        r8 = false;
        goto L12
    L5:
        r5 = b().a();
        goto L6
    }

    @JvmStatic
    public static final int a() {
        if (n == false) goto L14;
        int r0 = q;
        if (r0 >= 0) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
        return 0;
    L13:
        return r0;
    L8:
        if (2 < r0) goto L10;
        r2 = true;
        goto L11
    L14:
        return 0;
    }

    @JvmStatic
    public static final int c() {
        if (n == false) goto L14;
        int r0 = r;
        if (r0 >= 0) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
        return 0;
    L13:
        return r0;
    L8:
        if (2 < r0) goto L10;
        r2 = true;
        goto L11
    L14:
        return 0;
    }

    @JvmStatic
    public static final void f(int r2) {
        if (r2 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r1 = p;
        Integer r3 = Integer.valueOf(r2);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r3);
        r = r2;
        return;
    L11:
        return;
    L5:
        if (2 < r2) goto L7;
        r0 = true;
        goto L8
    }

    @JvmStatic
    public static final void d(boolean r0, LiveMode r1) {
        if (r0 == true) goto L4;
    L8:
        boolean r2 = false;
    L9:
        n = r2;
        return;
    L4:
        if (r1 != LiveMode.VIDEO) goto L8;
        if (b().c() == false) goto L8;
        r2 = true;
        goto L9
    }

    @JvmStatic
    public static final void e(DataCenter r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        ALogger.i("PublicScreenOptHelper", "request adjust height. source: ".concat(r10));
        l++;
        long r2 = System.currentTimeMillis();
        long r4 = k;
        if (r4 > 0) goto L6;
        k = r2;
    L13:
        RxBusAbility.INSTANCE.getRxBus(r9).post(new o42.c(false, true, r10));
        return;
    L6:
        if ((r2 - r4) < IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L13;
        k = r2;
        if (l > 20) goto L10;
    L12:
        l = 0;
        goto L13
    L10:
        if (m == true) goto L12;
        m = true;
        SafetyGuard.a(null, null, "request adjust public screen height exception");
        goto L12
    }
}
