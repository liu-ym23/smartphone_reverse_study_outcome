package com.bytedance.android.live.browser.schema.impl.gecko;

import android.net.Uri;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.setting.e4;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.config.tm0;
import com.bytedance.mt.protector.impl.UriProtector;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final String a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = (String) tm0.a.getValue();
        this.b = !((Boolean) e4.a.getValue()).booleanValue();
    }

    public static final String a(d r4) {
        r4.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Uri.Builder r5 = UriProtector.parse(r4.a).buildUpon().appendQueryParameter("sdkVersion", GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Throwable -> L18
        if (v.a() == false) goto L16;
        IMiddleWareHostContext r2 = k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L18
        if (r2 == null) goto L16;
        HostBoeParams r3 = r2.getHostBoeParams();     // Catch: Throwable -> L18
        if (r3 == null) goto L16;
        if (r3.getBoeEnable() == false) goto L14;
        r5.appendQueryParameter("x-use-boe", GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Throwable -> L18
        r5.appendQueryParameter("x-tt-env", r3.getBoeLane());     // Catch: Throwable -> L18
    L14:
        if (r3.getPpeEnable() == false) goto L16;
        r5.appendQueryParameter("x-use-ppe", GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Throwable -> L18
        r5.appendQueryParameter("x-tt-env", r3.getPpeLane());     // Catch: Throwable -> L18
    L16:
        Object r6 = Result.constructor-impl(r5.build().toString());     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r6) == false) goto L24;
        r6 = "";
    L24:
        return (String) r6;
    L18:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
