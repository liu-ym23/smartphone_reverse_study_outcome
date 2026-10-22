package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z extends tk6.e<com.bytedance.android.livesdk.interactivity.zdanmaku.d, View> {
    public final ViewGroup e;
    public final h80.d<p22.i> f;

    public z(View r4, h80.d<p22.i> r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "settingSupplier");
        super(r4, DanmakuCacheProviders.a, null, 12);
        this.f = r5;
        this.e = (ViewGroup) r4.findViewById(2131367728);
    }

    public final void b(Object r2, RenderEntity r3) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.d r4 = (com.bytedance.android.livesdk.interactivity.zdanmaku.d) r2;
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r3, "entity");
        this.e.removeAllViews();
        ConstraintLayout r5 = r4.a;
        if (r5 == null) goto L7;
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 80;
        this.e.addView(r5, r6);
        return;
    }
}
