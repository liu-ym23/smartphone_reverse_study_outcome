package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v extends b7.a {
    public final /* synthetic */ DrawerLynxViewHolder a;

    public v(DrawerLynxViewHolder r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r3) {
        super.onLoadSuccess(r3);
        DrawerLynxViewHolder r4 = this.a;
        r4.h.post(new x(r4));
        ALogger.i(this.a.a4(), "onLoadSuccess");
    }

    public final boolean onFallback(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        DrawerLynxViewHolder r0 = this.a;
        r0.h.post(new w(r0));
        ALogger.e(this.a.a4(), "onFallback  " + r4 + "   " + r5);
        return super.onFallback(r4, r5);
    }
}
