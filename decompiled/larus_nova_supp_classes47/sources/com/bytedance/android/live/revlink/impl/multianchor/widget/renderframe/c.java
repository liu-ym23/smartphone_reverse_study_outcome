package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements u11.a {
    public final FrameLayout a;
    public final View b;

    public static final class a {
    }

    static {
    }

    @Override // u11.a
    public final void a() {
    }

    @Override // u11.a
    public final void detach() {
        jy0.b.c("NormalRenderFrame", "detach", null, 4);
        this.a.removeView(this.b);
    }

    @Override // u11.a
    public final void b(p r10) {
        Intrinsics.checkNotNullParameter(r10, "renderState");
        RectF r0 = r10.c;
        jy0.b.c("NormalRenderFrame", String.valueOf(this.b.getParent()), null, 4);
        if (this.b.getParent() != null) goto L5;
        this.a.addView(this.b, 0, new FrameLayout.LayoutParams((int) r0.width(), (int) r0.height()));
        jy0.b.c("NormalRenderFrame", "add view", null, 4);
    L5:
        ViewGroup.LayoutParams r1 = this.b.getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r1 = null;
    L8:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 != null) goto L11;
        return;
    L11:
        r2.leftMargin = (int) r0.left;
        r2.topMargin = (int) r0.top;
        r2.width = (int) r0.width();
        r2.height = (int) r0.height();
        jy0.b.c("NormalRenderFrame", "add view with  " + r2, null, 4);
        this.b.setLayoutParams(r2);
        UtilityKotlinExtentionsKt.z(this.b, r10.b);
    }

    public c(FrameLayout r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "renderContainer");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r2;
        this.b = r3;
    }
}
