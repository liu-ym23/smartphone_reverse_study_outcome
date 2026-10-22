package com.bytedance.android.live.browser.service;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements w9.c {
    public y() {
    }

    public final boolean handleHttpSchema(Context r2, Uri r3, View r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return jc1.k.n(IMiddlewareRoomService.class).actionHandler().handleHttpSchema(r2, r3, r4, r5);
    }

    public final boolean j0(Context r4, Uri r5, View r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "uri");
        IBaseLiveActionHandler r1 = jc1.k.n(IMiddlewareRoomService.class).actionHandler();
        int r2 = r30.a.a;
        Intrinsics.checkNotNullParameter(r5, "uri");
        IMiddlewareHostBusiness r0 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r0 == null) goto L14;
        String r8 = r0.getSourceBtmToken2Schema(r6, r7);
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L14;
        r5 = r5.buildUpon().appendQueryParameter("source_btm_token", r8).build();
        goto L14
    L7:
        if (r8.length() == 0) goto L10;
        r9 = false;
    L14:
        return r1.handle(r4, r5);
    }

    public final void v1(Context r2, String r3, View r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        jc1.k.n(IMiddlewareRoomService.class).actionHandler().pageFinished(r2, r3, r4, r5);
    }
}
