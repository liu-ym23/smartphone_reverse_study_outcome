package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ PanelType c;

    public c(a r1, Bitmap r2, PanelType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        new Canvas(this.b).drawColor(ContextCompat.getColor(this.a.c.getContext(), 2131107984));
        t r0 = new t();
        r0.a = 1;
        String r1 = this.a.c.m.i;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        this.a.c.m.a();
        this.c.getWidth();
        this.c.getHeight();
        r0.c = this.a.c.getContext();
        Object r2 = this.a.c.m.k.get("OPEN_APP_ICON_URL");
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        ((IBroadcastService) jc1.k.n(IBroadcastService.class)).startCast(r0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
