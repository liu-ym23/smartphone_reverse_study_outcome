package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import jy0.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import t51.g;
import t51.i;
import y41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DefaultConfig {
    public static final /* synthetic */ int m = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    public static final class a {
    }

    static {
    }

    public final g c() {
        return (g) this.b.getValue();
    }

    public static t51.a a() {
        t51.a r0 = new t51.a();
        r0.m(AdjustBase.CONTENT.ordinal());
        d();
        r0.t(LayoutScale.FIT_WIDTH.ordinal());
        d();
        r0.n(LayoutAlign.CENTER_TOP.ordinal());
        i r1 = new i();
        r1.j(0.0f);
        r1.m(0.19f);
        r1.k(1.0f);
        r1.i(1.0f);
        Unit r2 = Unit.INSTANCE;
        r0.v(r1);
        r0.p(AnchorHeightFixMode.RationTransformHeight.ordinal());
        r0.u(16);
        r0.q(16);
        return r0;
    }

    public static t51.a b() {
        t51.a r0 = new t51.a();
        r0.m(AdjustBase.CONTENT.ordinal());
        d();
        r0.t(LayoutScale.FIT_WIDTH.ordinal());
        r0.n(LayoutAlign.CENTER_TOP.ordinal());
        i r1 = new i();
        d();
        r1.j(0.0f);
        d();
        r1.m(0.19f);
        d();
        r1.k(1.0f);
        d();
        r1.i(1.0f);
        Unit r2 = Unit.INSTANCE;
        r0.v(r1);
        r0.p(AnchorHeightFixMode.RationTransformHeight.ordinal());
        d();
        f r3 = f.N;
        int r4 = 16;
        if (r3.c() == false) goto L5;
        int r5 = 32;
    L6:
        r0.u(r5);
        d();
        if (r3.c() == false) goto L9;
        r4 = 32;
    L9:
        r0.q(r4);
        return r0;
    L5:
        r5 = 16;
        goto L6
    }

    public static void d() {
        b03.a r0 = b03.a.a;
        b.d("TripleFold", "isHarmonyNewStrategy h/w : " + (s1.w() / s1.y()) + ", h:" + s1.w() + ", w:" + s1.y());
    }

    public DefaultConfig() {
        this.a = LazyKt.lazy(new DefaultConfig$entrance$2(this));
        this.b = LazyKt.lazy(new DefaultConfig$normalConfig$2(this));
        this.c = LazyKt.lazy(new DefaultConfig$enlargeConfig$2(this));
        this.d = LazyKt.lazy(new DefaultConfig$fullConfig$2(this));
        this.e = LazyKt.lazy(new DefaultConfig$fullRecordConfig$2(this));
        this.f = LazyKt.lazy(new DefaultConfig$fullRecordNormalConfig$2(this));
        this.g = LazyKt.lazy(new DefaultConfig$pkConfig$2(this));
        this.h = LazyKt.lazy(new DefaultConfig$pkGameConfig$2(this));
        this.i = LazyKt.lazy(new DefaultConfig$pkGameFullConfig$2(this));
        this.j = LazyKt.lazy(new DefaultConfig$pkAudience$2(this));
        this.k = LazyKt.lazy(new DefaultConfig$gameHorizontalConfig$2(this));
        this.l = LazyKt.lazy(new DefaultConfig$gameLandscapeConfig$2(this));
    }
}
