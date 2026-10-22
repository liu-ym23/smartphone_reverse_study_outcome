package com.bytedance.android.live.revlink.impl.pk.feedview.lynx;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.jsb.g;
import com.bytedance.android.live.revlink.impl.jsb.i;
import com.bytedance.android.live.revlink.impl.jsb.s;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedBreakThroughBarWidget {
    public ViewGroup a;
    public a b;
    public zy0.b c;
    public com.bytedance.android.live.revlink.impl.lynxcontainer.a d;
    public final Lazy e;

    public interface a {
        void a();

        void b(zy0.b r1);
    }

    public static final class b implements f.b {
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.lynxcontainer.a a;

        public b(com.bytedance.android.live.revlink.impl.lynxcontainer.a r1) {
            this.a = r1;
        }

        public final f<Object, Object> a() {
            return new g(com.bytedance.android.live.revlink.impl.global.b.k(), this.a);
        }
    }

    public static final class c implements f.b {
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.lynxcontainer.a a;

        public c(com.bytedance.android.live.revlink.impl.lynxcontainer.a r1) {
            this.a = r1;
        }

        public final f<Object, Object> a() {
            return new i(com.bytedance.android.live.revlink.impl.global.b.k(), this.a);
        }
    }

    public static final class d implements f.b {
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.lynxcontainer.a a;

        public d(com.bytedance.android.live.revlink.impl.lynxcontainer.a r1) {
            this.a = r1;
        }

        public final f<Object, Object> a() {
            return new s(this.a);
        }
    }

    public FeedBreakThroughBarWidget() {
        this.e = LazyKt.lazy(FeedBreakThroughBarWidget$isFeedOpt$2.INSTANCE);
    }

    private final HybridType getType(zy0.b r1) {
        if (r1 == null) goto L6;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L6;
        return r2.o();
    L6:
        return null;
    }

    public static final String a(FeedBreakThroughBarWidget r3, IRoom r4) {
        r3.getClass();
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(d51.a.g.a()), "fallback_url");
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        return u.c(r5, MapsKt.mapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r4.getId())), TuplesKt.to("anchor_id", String.valueOf(iz.a.a(r4.getOwner()))), TuplesKt.to("user_id", String.valueOf(iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b())))}));
    }

    public static final String b(FeedBreakThroughBarWidget r2, IRoom r3) {
        r2.getClass();
        Uri r4 = UriProtector.parse(d51.a.g.a());
        Uri.Builder r0 = r4.buildUpon();
        if (UriProtector.getQueryParameterNames(r4).contains("is_preview_stream") == true) goto L6;
        r0.appendQueryParameter("is_preview_stream", DataType.TRUE);
    L6:
        return ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).appendFeedCommonParams(r0.build().toString(), r3);
    }

    public static final /* synthetic */ HybridType c(FeedBreakThroughBarWidget r0, zy0.b r1) {
        return r0.getType(r1);
    }

    public static void e(zy0.b r3, com.bytedance.android.live.revlink.impl.lynxcontainer.a r4) {
        if (r3 == null) goto L6;
        xy0.a<?> r0 = r3.g();
        if (r0 == null) goto L6;
        r0.registerMethod("getAnchorPkInfo", new b(r4));
    L6:
        if (r3 == null) goto L10;
        xy0.a<?> r1 = r3.g();
        if (r1 == null) goto L10;
        r1.registerMethod("revenue.getRevenueInteractData", new c(r4));
    L10:
        if (r3 == null) goto L15;
        xy0.a<?> r5 = r3.g();
        if (r5 == null) goto L16;
        r5.registerMethod("observeRevenueInteractData", new d(r4));
        return;
    L16:
        return;
    }

    public static final void d(FeedBreakThroughBarWidget r1, View r2, View r3, HybridType r4) {
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

    public final void f(Context r3, ViewGroup r4, IRoom r5, com.bytedance.android.live.revlink.impl.lynxcontainer.a r6, a r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "service");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.a = r4;
        this.b = r7;
        this.d = r6;
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L5;
        this.c = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(r3, null, new FeedBreakThroughBarWidget$onInit$1(this, r5, r7));
    L6:
        e(this.c, r6);
        return;
    L5:
        this.c = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r3, null, new FeedBreakThroughBarWidget$onInit$2(this, r5, r7));
        goto L6
    }
}
