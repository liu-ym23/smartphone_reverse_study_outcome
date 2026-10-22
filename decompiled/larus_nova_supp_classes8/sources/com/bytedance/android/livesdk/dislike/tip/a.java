package com.bytedance.android.livesdk.dislike.tip;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.keva.Keva;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static Keva e() {
        return Keva.getRepo("live_optimize_recommend_tip");
    }

    public static String f() {
        Date r0 = new Date();
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(r0);
    }

    public static String a() {
        return e().getString("key_optimize_recommend_use_last_date", "");
    }

    public static long b() {
        String r0 = a();
        if (TextUtils.equals(r0, "") == false) goto L7;
        e().storeString("key_optimize_recommend_use_last_date", f());
        return 0;
    L7:
        return g(r0, f());
    }

    @JvmStatic
    public static final String c() {
        return e().getString("key_optimize_recommend_tip_show_last_date", "");
    }

    @JvmStatic
    public static final long d() {
        String r0 = c();
        if (TextUtils.equals(r0, "") == false) goto L7;
        return Long.MAX_VALUE;
    L7:
        return g(r0, f());
    }

    static {
    }

    public static Date h(String r4) {
        Object r0 = null;
        if (r4 != null) goto L18;
        return null;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(r4));     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r5);
        if (r2 == null) goto L13;
        b0.o().getClass();
        g.e("LiveOptimizeRecommendTipKeva", r2);
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r0 = r5;
    L17:
        return (Date) r0;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static long g(String r4, String r5) {
        Date r6 = h(r4);
        Date r7 = h(r5);
        if (r6 == null) goto L10;
        if (r7 == null) goto L12;
        long r2 = r7.getTime() - r6.getTime();
        TimeUnit r8 = TimeUnit.DAYS;
        if (r2 > 0) goto L9;
        return 0;
    L9:
        return r8.convert(r2, TimeUnit.MILLISECONDS);
    L12:
        return 0;
    L10:
        return 0;
    }
}
