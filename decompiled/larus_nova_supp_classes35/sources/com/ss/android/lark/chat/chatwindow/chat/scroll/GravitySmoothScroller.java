package com.ss.android.lark.chat.chatwindow.chat.scroll;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class GravitySmoothScroller extends LinearSmoothScroller {
    public final int a;
    public int b;
    public boolean c;
    public int d;

    public final int getVerticalSnapPreference() {
        int r0 = this.b;
        if (r0 != 48) goto L7;
        return -1;
    L7:
        if (r0 != 80) goto L10;
        return 1;
    L10:
        return 0;
    }

    public final float calculateSpeedPerPixel(DisplayMetrics r3) {
        int r0 = this.d;
        if (r0 == (-1)) goto L9;
        if (r0 <= 0) goto L9;
        return 1.0f / r0;
    L9:
        return super.calculateSpeedPerPixel(r3);
    }

    public final int calculateTimeForScrolling(int r2) {
        if (this.c == false) goto L5;
        int r3 = 1;
    L7:
        return super.calculateTimeForScrolling(r3);
    L5:
        r3 = Math.max(ChameleonWebViewClient.DEFAULT_SAFE_TIME, Math.min(r2, 1500));
        goto L7
    }

    public GravitySmoothScroller(Context r1, int r2) {
        super(r1);
        this.d = -1;
        this.a = r2;
    }

    public final int calculateDtToFit(int r2, int r3, int r4, int r5, int r6) {
        int r7 = this.b;
        if (r7 == 48) goto L16;
        if (r7 != 17) goto L10;
        if (Math.abs(r3 - r2) > Math.abs(r5 - r4)) goto L16;
    L10:
        if (this.b != 80) goto L14;
        return r5 - r3;
    L14:
        return (r4 + ((r5 - r4) / 2)) - (r2 + ((r3 - r2) / 2));
    L16:
        return (r4 - r2) + this.a;
    }
}
