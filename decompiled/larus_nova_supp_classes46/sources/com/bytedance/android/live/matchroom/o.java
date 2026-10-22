package com.bytedance.android.live.matchroom;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends ViewOutlineProvider {
    public final float a;

    public o() {
        this.a = s1.f(8.0f);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r4, Outline r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "outline");
        r5.setRoundRect(new Rect(0, 0, r4.getWidth(), r4.getHeight()), this.a);
    }
}
