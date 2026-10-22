package com.bytedance.android.live.revlink.impl.multianchor.feed.widget;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;
import zy0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiBreakThroughBarWidget {
    public ViewGroup a;
    public a b;
    public b c;
    public final Lazy d;

    public interface a {
        void a();

        void b(b r1);
    }

    public FeedMultiBreakThroughBarWidget() {
        this.d = LazyKt.lazy(FeedMultiBreakThroughBarWidget$isAnniexOpt$2.INSTANCE);
    }

    private final HybridType getType(b r1) {
        if (r1 == null) goto L6;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L6;
        return r2.o();
    L6:
        return null;
    }

    public static final String a(FeedMultiBreakThroughBarWidget r3, IRoom r4) {
        r3.getClass();
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(d51.a.g.a()), "fallback_url");
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        return u.c(r5, MapsKt.mapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r4.getId())), TuplesKt.to("anchor_id", String.valueOf(iz.a.a(r4.getOwner()))), TuplesKt.to("user_id", String.valueOf(iz.a.a(c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b())))}));
    }

    public static final String b(FeedMultiBreakThroughBarWidget r4, IRoom r5) {
        r4.getClass();
        Uri r6 = UriProtector.parse(d51.a.g.a());
        Uri.Builder r0 = r6.buildUpon();
        Set r7 = UriProtector.getQueryParameterNames(r6);
        if (r7.contains("is_preview_stream") == true) goto L6;
        r0.appendQueryParameter("is_preview_stream", DataType.TRUE);
    L6:
        if (r7.contains("enable_hide_score") == true) goto L9;
        r0.appendQueryParameter("enable_hide_score", DataType.TRUE);
    L9:
        return ((vy0.c) f.a(vy0.c.class)).appendFeedCommonParams(r0.build().toString(), r5);
    }

    public static final /* synthetic */ HybridType c(FeedMultiBreakThroughBarWidget r0, b r1) {
        return r0.getType(r1);
    }

    public static final void d(FeedMultiBreakThroughBarWidget r1, View r2, View r3, HybridType r4) {
        ViewGroup r5 = r1.a;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r4 != HybridType.H5) goto L12;
        if (r3 == null) goto L10;
        ((WebView) r3).setBackgroundColor(0);
        goto L12
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.webkit.WebView");
    L12:
        if (r5.indexOfChild(r2) != (-1)) goto L15;
        r5.addView(r2);
        return;
    }

    public final void e(Context r3, ViewGroup r4, IRoom r5, a r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.a = r4;
        this.b = r6;
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L5;
        this.c = ((vy0.c) f.a(vy0.c.class)).q8(r3, null, new FeedMultiBreakThroughBarWidget$onInit$1(this, r5, r6));
        return;
    L5:
        this.c = ((vy0.c) f.a(vy0.c.class)).J8(r3, null, new FeedMultiBreakThroughBarWidget$onInit$2(this, r5, r6));
    }
}
