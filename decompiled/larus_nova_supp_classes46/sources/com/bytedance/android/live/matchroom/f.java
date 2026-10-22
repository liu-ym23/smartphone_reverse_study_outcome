package com.bytedance.android.live.matchroom;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends ViewOutlineProvider {
    public final Rect a;

    public static final class a {
    }

    static {
    }

    public f(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "playerVisibleRect");
        this.a = r2;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r2, Outline r3) {
        if (r2 == null) goto L7;
        Rect r4 = new Rect();
        r4.set(this.a);
        r4.left -= 5;
        r4.right += 5;
        r4.top -= 5;
        r4.bottom += 5;
        if (r3 == null) goto L8;
        r3.setRoundRect(r4, 0.0f);
        return;
    L8:
        return;
    }
}
