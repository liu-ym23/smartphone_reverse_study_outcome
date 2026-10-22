package com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.pk.feedview.FeedPkLynxWidget;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.FeedBreakThroughBarWidget;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements FeedBreakThroughBarWidget.a {
    public pc0.a a;
    public final FrameLayout b;
    public final b c;
    public FeedBreakThroughBarState d;
    public IRoom e;
    public boolean f;
    public boolean g;
    public FeedBreakThroughBarWidget h;
    public final Lazy i;
    public final Context j;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a k;

    public final boolean e() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.lynx.FeedBreakThroughBarWidget.a
    public final void a() {
        b r0 = this.c;
        r0.b = false;
        r0.c = null;
    }

    public final void c() {
        FeedBreakThroughBarWidget r0 = this.h;
        if (r0 == null) goto L11;
        ViewGroup r2 = r0.a;
        if (r2 == null) goto L7;
        r2.removeAllViews();
    L7:
        zy0.b r3 = r0.c;
        if (r3 == null) goto L10;
        r3.dispose();
    L10:
        r0.c = null;
    L11:
        this.h = null;
        this.d = null;
        b r1 = this.c;
        r1.b = false;
        r1.c = null;
        r1.a.clear();
        this.g = false;
    }

    public final void d() {
        if (this.g == false) goto L5;
        return;
    L5:
        if (this.f == true) goto L7;
        return;
    L7:
        if (e() == true) goto L9;
    L11:
        IRoom r4 = this.e;
        if (r4 != null) goto L14;
        return;
    L14:
        this.d = new FeedBreakThroughBarState(this.c);
        int r0 = com.bytedance.android.live.revlink.impl.pk.feedview.lynx.a.a;
        FeedBreakThroughBarWidget r1 = new FeedBreakThroughBarWidget();
        this.h = r1;
        r1.f(this.j, this.b, r4, this.k, this);
        this.g = true;
        return;
    L9:
        if (this.a != null) goto L11;
    }

    public final Context getContext() {
        return this.j;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.lynx.FeedBreakThroughBarWidget.a
    public final void b(zy0.b r4) {
        b r0 = this.c;
        r0.b = true;
        r0.c = r4;
    L4:
        if (r0.a.isEmpty() == true) goto L10;
        JSONObject r5 = r0.a.poll();
        zy0.b r1 = r0.c;
        if (r1 == null) goto L4;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L4;
        r2.sendJsEvent("H5_webcastNotification", r5);
        goto L4
    }

    public a(Context r2, FeedPkLynxWidget r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "service");
        this.j = r2;
        this.k = r3;
        this.b = new FrameLayout(r2);
        this.c = new b();
        this.i = LazyKt.lazy(FeedBreakThroughBarManager$isFeedOpt$2.INSTANCE);
    }
}
