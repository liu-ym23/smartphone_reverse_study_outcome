package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class k extends FrameLayout {
    public Path a;

    public final Path getMClipPath() {
        return this.a;
    }

    public k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.view.View
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Path r0 = this.a;
        if (r0 == null) goto L5;
        r3.clipPath(r0, Region.Op.DIFFERENCE);
    L5:
        super.draw(r3);
    }

    public final void setMClipPath(Path r1) {
        this.a = r1;
        invalidate();
    }
}
