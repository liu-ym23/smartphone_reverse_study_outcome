package com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final View a;
    public final int b;
    public final int c;

    public final Rect b() {
        int[] r0 = new int[2];
        this.a.getLocationInWindow(r0);
        int r1 = this.b;
        if (r1 < 0) goto L5;
        int r3 = r0[0] + r1;
    L6:
        int r2 = this.c;
        if (r2 < 0) goto L9;
        int r5 = r0[1] + r2;
    L10:
        int r4 = r0[0] + this.a.getWidth();
        int r6 = r0[1] + this.a.getHeight();
        if (r3 >= r4) goto L16;
        if (r5 < r6) goto L15;
        return null;
    L15:
        return new Rect(r3, r5, r4, r6);
    L16:
        return null;
    L9:
        r5 = r0[1];
        goto L10
    L5:
        r3 = r0[0];
        goto L6
    }

    public final Bitmap a() {
        int r0 = (this.a.getWidth() - this.b) / 10;
        int r1 = (this.a.getHeight() - this.c) / 10;
        if (r0 <= 0) goto L8;
        if (r1 > 0) goto L7;
        return null;
    L7:
        return Bitmap.createBitmap(r0, r1, Bitmap.Config.RGB_565);
    L8:
        return null;
    }

    public a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
        this.b = 0;
        this.c = r3;
    }
}
