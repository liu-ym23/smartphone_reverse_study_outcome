package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import com.bytedance.live.kmp.core.KmpEnv;
import fr2.g0;
import fr2.k0;
import fr2.l;
import fr2.z1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements u11.a {
    public final l a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    @Override // u11.a
    public final void a() {
        k0 r2 = null;
        k0 r0 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(k0.class), null);
        if ((r0 instanceof k0) == false) goto L6;
        r2 = r0;
    L6:
        k0 r3 = r2;
        KmpEnv r1 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r3 == null) goto L10;
        r3.K1(0.0f);
        r3.I4(0.0f);
        r3.p1(1.0f);
        r3.J2(1.0f);
        r3.setVisible(true);
        r3.setMode(1);
        r3.h3(1);
        c(this.a, r3);
        return;
    }

    @Override // u11.a
    public final void detach() {
        if (this.b == false) goto L5;
        return;
    L5:
        k0 r2 = null;
        k0 r0 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(k0.class), null);
        if ((r0 instanceof k0) == false) goto L9;
        r2 = r0;
    L9:
        k0 r3 = r2;
        KmpEnv r1 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r3 == null) goto L13;
        r3.setVisible(false);
        r3.J2(-1.0f);
        r3.p1(0.0f);
        r3.I4(-2.0f);
        r3.K1(0.0f);
        c(this.a, r3);
        return;
    }

    @Override // u11.a
    public final void b(p r5) {
        Intrinsics.checkNotNullParameter(r5, "renderState");
        RectF r0 = r5.d;
        k0 r3 = null;
        k0 r1 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(k0.class), null);
        if ((r1 instanceof k0) == false) goto L6;
        r3 = r1;
    L6:
        k0 r4 = r3;
        KmpEnv r2 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        if (r4 == null) goto L10;
        r4.K1(r0.left);
        r4.I4(r0.top);
        r4.p1(r0.right);
        r4.J2(r0.bottom);
        r4.setVisible(r5.b);
        r4.setMode(2);
        r4.h3(r5.e);
        c(this.a, r4);
        return;
    }

    public b(l r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.a = r2;
        this.b = r3;
    }

    public static void c(l r4, k0 r5) {
        z1 r0 = r4.Y();
        if (r0 != null) goto L5;
    L16:
        jy0.b.c("LayerRenderFrame", "do layout layer with left=" + r5.getLeft() + ", top=" + r5.getTop() + ", right=" + r5.getRight() + ", bottom=" + r5.getBottom() + ", zOrder=" + r5.d() + "visible=" + r5.getVisible(), null, 4);
        r4.Y4(r5);
        return;
    L5:
        if (r0.getLeft() != r5.getLeft()) goto L16;
        if (r0.getTop() != r5.getTop()) goto L16;
        if (r0.getRight() != r5.getRight()) goto L16;
        if (r0.getBottom() != r5.getBottom()) goto L16;
        if (r0.getVisible() != r5.getVisible()) goto L16;
        if (r0.getMode() != r5.getMode()) goto L16;
    }
}
