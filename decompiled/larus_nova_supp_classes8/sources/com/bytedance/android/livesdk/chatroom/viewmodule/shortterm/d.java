package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends d0 {
    public final /* synthetic */ e a;
    public final /* synthetic */ f.b b;
    public final /* synthetic */ String c;

    public final void a() {
        this.b.b();
        int r0 = com.bytedance.android.livesdk.chatroom.utils.a.a;
        int r1 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
        ActivityHybridMonitor.ContainerType r3 = ActivityHybridMonitor.ContainerType.LYNX;
        int r4 = this.a.b;
        com.bytedance.android.livesdk.chatroom.o r2 = z51.a.h(null, 3);
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.m r5 = r2.getRoom();
        if (r5 == null) goto L10;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L10;
        String r7 = r6.getIdStr();
        if (r7 == null) goto L10;
    L11:
        com.bytedance.android.livesdk.chatroom.utils.a.c(r1, "onFallback", r3, r4, r7, this.c);
        return;
    L10:
        r7 = "";
        goto L11
    }

    public final void g(View r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        this.b.onLoadSuccess();
        this.a.getClass();
        new JSONObject().put("visible", true);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public d(e r1, a.C0055a r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
