package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import yt1.h;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements h {
    public final Context a;

    @Override // yt1.h
    public final String a() {
        return null;
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.SubscribeAnchorPlay;
    }

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // yt1.h
    public final void b(Map r9, j r10) {
        Object r1 = null;
        if (r9 == null) goto L5;
        Object r2 = r9.get("appointment_id");
    L6:
        String r3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r2);
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return;
    L9:
        if (r9 == null) goto L11;
        Object r4 = r9.get("is_subscribe");
    L12:
        if (r4 == null) goto L28;
        boolean r5 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r9.get("is_subscribe"));
        String r6 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r9.get("send_event"));
        Object r7 = r9.get("live_dsl_success_callback");
        if ((r7 instanceof String) == true) goto L17;
        r7 = null;
    L17:
        String r8 = (String) r7;
        Object r11 = r9.get("live_dsl_error_callback");
        if ((r11 instanceof String) == false) goto L21;
        r1 = r11;
    L21:
        String r12 = (String) r1;
        if (r5 == false) goto L24;
        Uri r13 = UriProtector.parse("sslocal://webcast_dispatch/SubscribeAnchor/subscribePlay/");
    L25:
        k.n(IBaseLiveActionHandler.class).handle(this.a, r13.buildUpon().appendQueryParameter("appointment_id", r3).appendQueryParameter("send_event", r6).build(), new f(r8, r10, r12));
        return;
    L24:
        r13 = UriProtector.parse("sslocal://webcast_dispatch/SubscribeAnchor/unsubscribePlay/");
        goto L25
    L28:
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
