package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.hq0;
import com.bytedance.android.livesdk.config.wg1;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ AnchorPerfMonitorDialogNew a;

    public j(AnchorPerfMonitorDialogNew r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        CommonBottomDialog r6 = this.a;
        Context r0 = r6.getContext();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        Intent r7 = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        hq0 r1 = hq0.a;     // Catch: Throwable -> L8
        if (((wg1) r1.getValue()).b() == false) goto L6;
        String r2 = ((wg1) r1.getValue()).a();     // Catch: Throwable -> L8
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).injectRouteOutCertIdToIntent(r2, r7);     // Catch: Throwable -> L8
    L6:
        r0.startActivity(r7);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ALogger.e("AnchorVolumnOptiTAG", th.getMessage());
    }
}
