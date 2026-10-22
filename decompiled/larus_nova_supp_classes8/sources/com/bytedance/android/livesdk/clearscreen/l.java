package com.bytedance.android.livesdk.clearscreen;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.tp0;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends k {
    public final com.bytedance.android.livesdk.widget.b.c L;

    public static final class a {
    }

    static {
    }

    public final f0 getConfig() {
        return this.L;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final boolean b(ViewGroup r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (f() == false) goto L6;
    L12:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L47;
        int r1 = r7.getAction() & 255;     // Catch: IllegalArgumentException -> L44
        if (r1 != 0) goto L18;
        this.y = new k.b(r7);     // Catch: IllegalArgumentException -> L44
        goto L47
    L18:
        if (r1 != 1) goto L20;
    L36:
        this.G = false;     // Catch: IllegalArgumentException -> L44
        if (this.q == false) goto L39;
    L40:
        s();     // Catch: IllegalArgumentException -> L44
    L41:
        this.H = false;     // Catch: IllegalArgumentException -> L44
        goto L47
    L39:
        if (this.r == false) goto L41;
    L20:
        if (r1 != 2) goto L22;
        h(r7);     // Catch: IllegalArgumentException -> L44
        goto L47
    L22:
        if (r1 == 3) goto L36;
        if (r1 == 5) goto L30;
        if (r1 != 6) goto L47;
        i(r7);     // Catch: IllegalArgumentException -> L44
        goto L47
    L30:
        if (r7.getPointerCount() != 2) goto L33;
        r6.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L44
        this.H = true;     // Catch: IllegalArgumentException -> L44
    L33:
        if (g(r7, r6) == false) goto L47;
        return true;
    L44:
        e = move-exception;
        ALogger.e("NomalPinchZoomGestureBehavior", "IllegalArgumentException error: " + e.toString());
    L47:
        return this.H;
    L6:
        if (m() == false) goto L8;
    L13:
        ALogger.i("GestureBaseBehavior", "isMultiLinkRoom == " + m() + " __ isMultiInfoRoom == " + l() + " __ isPk == " + k.n());
        r0 = tp0.a.getValue().booleanValue();
        goto L14
    L8:
        if (l() == true) goto L13;
        if (k.n() == false) goto L12;
        goto L12
    }

    public l(LivePlayerView r2, DataCenter r3, Context r4, View r5, ZoomType r6) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "zoomType");
        super(r2, r3, r4, r5, r6);
        this.L = com.bytedance.android.livesdk.widget.b.c.c;
    }
}
