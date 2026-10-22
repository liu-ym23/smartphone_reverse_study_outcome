package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class WindowClickImpl {
    public View a;
    public final String b;
    public final Lazy c;
    public final Lazy d;
    public final FrameLayout e;
    public final p f;
    public final Context g;

    public WindowClickImpl(FrameLayout r2, p r3, Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "renderState");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "selfLinkerID");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.b = r3.a;
        this.c = LazyKt.lazy(WindowClickImpl$anchorRegionRect$2.INSTANCE);
        this.d = LazyKt.lazy(new WindowClickImpl$anchorRegionGestureDetector$2(this));
    }
}
