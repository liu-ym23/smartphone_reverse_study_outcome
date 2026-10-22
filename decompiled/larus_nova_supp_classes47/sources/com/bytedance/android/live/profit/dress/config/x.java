package com.bytedance.android.live.profit.dress.config;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x extends DressResource {
    public static final /* synthetic */ KProperty[] i = null;
    public final Map c;
    public final Map d;
    public final Map e;
    public final Map f;
    public final Map g;
    public final com.bytedance.android.live.profit.dress.v h;

    static {
        i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "parallaxAsset", "getParallaxAsset()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "panelExitWebp", "getPanelExitWebp()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "borderEnterWebp", "getBorderEnterWebp()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "borderLoopWebp", "getBorderLoopWebp()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(x.class, "flashCardAsset", "getFlashCardAsset()Lcom/bytedance/android/live/profit/dress/config/DressResource$ResourceState;", 0))};
    }

    public final void d(DressResource.a<? extends py.k> r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e.put(i[2].getName(), r4);
    }

    public final void e(DressResource.a<? extends py.k> r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f.put(i[3].getName(), r4);
    }

    public final void f(DressResource.a<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.g.put(i[4].getName(), r4);
    }

    public final void g(DressResource.a<? extends py.k> r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.d.put(i[1].getName(), r4);
    }

    public final void h(DressResource.a<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.c.put(i[0].getName(), r4);
    }

    public x(com.bytedance.android.live.profit.dress.v r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.h = r2;
        Map<String, DressResource.a<?>> r3 = this.a;
        this.c = r3;
        this.d = r3;
        this.e = r3;
        this.f = r3;
        this.g = r3;
    }
}
