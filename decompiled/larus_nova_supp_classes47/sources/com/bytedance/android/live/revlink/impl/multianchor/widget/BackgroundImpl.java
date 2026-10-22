package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.pk.utils.w;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BackgroundImpl {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public RectF e;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.b f;
    public boolean g;
    public final FrameLayout h;
    public final Context i;

    public final void a() {
        RectF r6 = this.e;
        if (r6 != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r0 = this.f;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.c == false) goto L11;
        w.a((HSImageView) this.a.getValue(), r0.a);
    L13:
        if (r0.d == false) goto L15;
        w.a((HSImageView) this.b.getValue(), r0.b);
    L16:
        b();
        int r7 = this.h.getHeight();
        int r8 = this.h.getWidth();
        d((HSImageView) this.a.getValue(), (int) r6.left, 0, (int) r6.width(), (int) r6.top);
        d((HSImageView) this.b.getValue(), (int) r6.left, (int) r6.bottom, (int) r6.width(), RangesKt.coerceAtLeast(r7 - ((int) r6.height()), 0));
        d((ImageView) this.c.getValue(), 0, 0, (int) r6.left, r7);
        ImageView r1 = (ImageView) this.d.getValue();
        int r2 = (int) r6.right;
        d(r1, r2, 0, RangesKt.coerceAtLeast(r8 - r2, 0), r7);
        return;
    L15:
        ImageLoader.bindImage((HSImageView) this.b.getValue(), r0.b);
        goto L16
    L11:
        ImageLoader.bindImage((HSImageView) this.a.getValue(), r0.a);
        goto L13
    }

    public final void b() {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        HSImageView r1 = (HSImageView) this.a.getValue();
        boolean r3 = false;
        LiveMode r5 = null;
        if (this.g == true) goto L14;
        IRoom r2 = u.a();
        if (r2 == null) goto L10;
        LiveMode r4 = r2.getStreamType();
    L12:
        if (r4 == LiveMode.SCREEN_RECORD) goto L14;
        boolean r6 = true;
    L15:
        ViewUtilsKt.g(r1, r6);
        HSImageView r7 = (HSImageView) this.b.getValue();
        if (this.g == true) goto L23;
        IRoom r8 = u.a();
        if (r8 == null) goto L21;
        r5 = r8.getStreamType();
    L21:
        if (r5 == LiveMode.SCREEN_RECORD) goto L23;
        boolean r9 = true;
    L24:
        ViewUtilsKt.g(r7, r9);
        ImageView r10 = (ImageView) this.c.getValue();
        if (r0.f == true) goto L27;
    L29:
        boolean r12 = false;
    L30:
        ViewUtilsKt.g(r10, r12);
        ImageView r13 = (ImageView) this.d.getValue();
        if (r0.g == true) goto L33;
    L35:
        ViewUtilsKt.g(r13, r3);
        return;
    L33:
        if (this.g == true) goto L35;
        r3 = true;
        goto L35
    L27:
        if (this.g == true) goto L29;
        r12 = true;
    L23:
        r9 = false;
        goto L24
    L10:
        r4 = null;
    L14:
        r6 = false;
        goto L15
    }

    public final void c(com.bytedance.android.live.revlink.link.domain.anchorimpl.b r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        String r0 = r4.a;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r1 = this.f;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.a;
    L7:
        if ((!Intrinsics.areEqual(r0, r3)) == true) goto L27;
        String r5 = r4.b;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r6 = this.f;
        if (r6 == null) goto L12;
        r2 = r6.b;
    L12:
        if ((!Intrinsics.areEqual(r5, r2)) == true) goto L27;
        boolean r7 = r4.c;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r8 = this.f;
        if (r8 == null) goto L27;
        if (r7 != r8.c) goto L27;
        if (r4.d != r8.d) goto L27;
        if ((!Intrinsics.areEqual(r4.e, r8.e)) == true) goto L27;
        boolean r9 = r4.f;
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r10 = this.f;
        if (r10 == null) goto L27;
        if (r9 != r10.f) goto L27;
        if (r4.g != r10.g) goto L27;
        return;
    L27:
        this.f = r4;
        a();
        return;
    L5:
        r3 = null;
        goto L7
    }

    public BackgroundImpl(FrameLayout r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "containerView");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.h = r2;
        this.i = r3;
        this.a = LazyKt.lazy(new BackgroundImpl$tobBgView$2(this));
        this.b = LazyKt.lazy(new BackgroundImpl$bottomBgView$2(this));
        this.c = LazyKt.lazy(new BackgroundImpl$leftBgView$2(this));
        this.d = LazyKt.lazy(new BackgroundImpl$rightBgView$2(this));
    }

    public final void d(View r3, int r4, int r5, int r6, int r7) {
        if (r3.getParent() != null) goto L5;
        this.h.addView(r3, 0);
    L5:
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r0 = null;
    L8:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 != null) goto L11;
        return;
    L11:
        r1.leftMargin = r4;
        r1.topMargin = r5;
        r1.width = r6;
        r1.height = r7;
        r3.setLayoutParams(r1);
    }
}
