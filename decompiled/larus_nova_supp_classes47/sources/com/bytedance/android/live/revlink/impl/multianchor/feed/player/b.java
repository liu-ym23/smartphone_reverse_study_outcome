package com.bytedance.android.live.revlink.impl.multianchor.feed.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.multianchor.feed.c;
import com.bytedance.android.live.revlink.impl.multianchor.transfer.f;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.livesdk.utils.e5;
import k31.h;
import k31.n;
import k31.p;
import kc0.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final f a;
    public k31.f b;
    public h c;
    public h d;
    public final k31.a e;
    public a f;
    public final z21.a g;
    public final c h;
    public final boolean i;

    public final a a() {
        Context r0 = this.g.getContext();
        boolean r2 = true;
        boolean r1 = !e5.n();
        int r3 = s1.y();
        if (rc0.b.a() != DeviceType.NORMAL_MOBILE) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        int r5 = s1.w();
    L9:
        if (r5 > r3) goto L12;
        r2 = false;
    L12:
        if (r1 == r2) goto L15;
        r3 = r5;
        r5 = r3;
    L15:
        return new a(r1, r3, r5);
    L8:
        r5 = p.a(r0, r1, false);
        goto L9
    L5:
        r4 = false;
        goto L6
    }

    public final a b() {
        FrameLayout r0 = this.g.f;
        boolean r2 = true;
        boolean r1 = !e5.n();
        int r3 = r0.getWidth();
        int r4 = r0.getHeight();
        if (r4 > r3) goto L6;
        r2 = false;
    L6:
        if (r1 == r2) goto L9;
        r3 = r4;
        r4 = r3;
    L9:
        return new a(r1, r3, r4);
    }

    public static void d(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        if (c(r4.getLayoutParams(), r1) == true) goto L13;
        r4.setLayoutParams(r1);
    L13:
        if ((r0 instanceof RelativeLayout.LayoutParams) == false) goto L18;
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, -1);
        if (c(r4.getLayoutParams(), r2) == true) goto L19;
        r4.setLayoutParams(r2);
        return;
    L19:
        return;
    }

    public static boolean c(ViewGroup.LayoutParams r6, ViewGroup.LayoutParams r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r6;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r7;
        if (r1.width == r3.width) goto L9;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L23;
        return false;
    L9:
        if (r1.height != r3.height) goto L19;
        if (r1.leftMargin != r3.leftMargin) goto L19;
        if (r1.rightMargin != r3.rightMargin) goto L19;
        if (r1.topMargin != r3.topMargin) goto L19;
        if (r1.bottomMargin != r3.bottomMargin) goto L19;
        r2 = true;
    L23:
        if ((r6 instanceof FrameLayout.LayoutParams) == false) goto L31;
        if ((r7 instanceof FrameLayout.LayoutParams) == false) goto L31;
        if (((FrameLayout.LayoutParams) r6).gravity != ((FrameLayout.LayoutParams) r7).gravity) goto L38;
        return true;
    L38:
        return false;
    L31:
        if ((r6 instanceof RelativeLayout.LayoutParams) == true) goto L33;
        return false;
    L33:
        if ((r7 instanceof RelativeLayout.LayoutParams) == true) goto L35;
        return false;
    L35:
        if (((RelativeLayout.LayoutParams) r6).alignWithParent != ((RelativeLayout.LayoutParams) r7).alignWithParent) goto L42;
        return true;
    L42:
        return false;
    }

    public b(z21.a r2, c r3, boolean r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "feedView");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = new f();
        this.e = new k31.a(null, y.f(new n(com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.a().s6(), 0)));
        if (r4 == true) goto L5;
        a r6 = a();
    L6:
        this.f = r6;
        return;
    L5:
        r6 = b();
        goto L6
    }
}
