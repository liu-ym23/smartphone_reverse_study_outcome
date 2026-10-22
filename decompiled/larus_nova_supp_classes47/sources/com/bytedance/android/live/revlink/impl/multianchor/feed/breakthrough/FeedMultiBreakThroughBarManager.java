package com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.multianchor.feed.widget.FeedMultiBreakThroughBarWidget;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.a;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import k31.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiBreakThroughBarManager implements FeedMultiBreakThroughBarWidget.a {
    public f a;
    public final FrameLayout b;
    public final b c;
    public FeedMultiBreakThroughBarState d;
    public IRoom e;
    public boolean f;
    public boolean g;
    public FeedMultiBreakThroughBarWidget h;
    public final Lazy i;
    public final Context j;

    public final boolean e() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.widget.FeedMultiBreakThroughBarWidget.a
    public final void a() {
        b r0 = this.c;
        r0.b = false;
        r0.c = null;
    }

    public final void c() {
        FeedMultiBreakThroughBarWidget r0 = this.h;
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
        IRoom r0 = this.e;
        if (r0 != null) goto L14;
        return;
    L14:
        this.d = new FeedMultiBreakThroughBarState(this.c);
        int r1 = a.a;
        FeedMultiBreakThroughBarWidget r2 = new FeedMultiBreakThroughBarWidget();
        this.h = r2;
        r2.e(this.j, this.b, r0, this);
        this.g = true;
        return;
    L9:
        if (this.a != null) goto L11;
    }

    public final Context getContext() {
        return this.j;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.widget.FeedMultiBreakThroughBarWidget.a
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

    public FeedMultiBreakThroughBarManager(Context r2, z21.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.j = r2;
        this.b = new FrameLayout(r2);
        this.c = new b();
        this.i = LazyKt.lazy(FeedMultiBreakThroughBarManager$isFeedOpt$2.INSTANCE);
    }
}
