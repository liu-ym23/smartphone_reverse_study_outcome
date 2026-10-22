package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.UriProtector;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.time.Instant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ShareViewCard {
    public final FrameLayout a;
    public final Lazy b;
    public final CompositeDisposable c;
    public d d;
    public final Context e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ShareViewCard a;
        public final /* synthetic */ d b;

        public a(ShareViewCard r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Pair r3 = (Pair) r2;
            String r0 = (String) r3.component1();
            View r4 = (View) r3.component2();
            this.a.a.addView(r4);
            this.a.getClass();
            f r5 = this.b.c;
            if (r5 == null) goto L6;
            r5.a();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ShareViewCard a;
        public final /* synthetic */ d b;

        public b(ShareViewCard r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r13) {
            Throwable r14 = (Throwable) r13;
            if ((r14 instanceof ShareViewLoadError) == false) goto L5;
            LoadFailCode r0 = ((ShareViewLoadError) r14).getCode();
        L6:
            String r1 = r14.getMessage();
            if (r1 != null) goto L9;
            r1 = "unknown error";
        L9:
            jy0.b.b("ShareViewCard", "share view load failed: url=" + this.b.a + ", code=" + r0, r14);
            f r15 = this.b.c;
            if (r15 == null) goto L12;
            r15.b(r1, r0);
        L12:
            d r16 = this.b;
            if (r16.d == false) goto L25;
            ShareViewCard r2 = this.a;
            r2.getClass();
            jy0.b.a("ShareViewCard", "loading fallback " + r16.a);
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r3 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(r2.e, UriProtector.parse((String) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.d.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.a[2])).buildUpon().appendQueryParameter("single_comp", DataType.TRUE).appendQueryParameter("comp_url", r16.a.toString()).build(), new ShareViewCard$loadFallback$card$1(r2, r16));
            if (r3 != null) goto L20;
            jy0.b.c("ShareViewCard", "fallback load failed", null, 4);
            f r4 = r16.c;
            if (r4 == null) goto L19;
            r4.d("annie return null");
        L19:
            ShareViewCard.b(r16, "annie return null");
            return;
        L20:
            com.bytedance.revenue.platform.api.core.rx.f.a(r3, r2.c);
            r3.d.b(r16.b);
            r2.a.addView(r3.c);
            f r5 = r16.c;
            if (r5 == null) goto L23;
            r5.onFallback();
        L23:
            JSONObject r6 = new JSONObject();
            JSONObject r7 = new JSONObject();
            JSONObject r8 = new JSONObject();
            Intrinsics.checkNotNullParameter(r8, "extra");
            Intrinsics.checkNotNullParameter(r7, "metric");
            Intrinsics.checkNotNullParameter(r6, "map");
            Uri r9 = r16.a;
            Intrinsics.checkNotNullParameter("url", "key");
            Intrinsics.checkNotNullParameter(r9, "value");
            r6.put("url", r9);
            Intrinsics.checkNotNullParameter("reason", "key");
            Intrinsics.checkNotNullParameter(r1, "value");
            r6.put("reason", r1);
            Intrinsics.checkNotNullParameter(r7, "map");
            Double r17 = Double.valueOf(r16.f);
            Intrinsics.checkNotNullParameter("startTime", "key");
            Intrinsics.checkNotNullParameter(r17, "value");
            r7.put("startTime", r17);
            cy0.e.a.getClass();
            j r10 = cy0.e.a.a;
            m.e.getClass();
            Object r18 = m.b(r10).b(n97.a.class);
            Intrinsics.checkNotNull(r18);
            ((com.bytedance.live.kmp.core.c) r18).g("ttlive_shareview_card_fallback", "revenue", "bussiness_api_call", r6, r7, r8);
            return;
        L25:
            return;
        L5:
            r0 = LoadFailCode.Unknown;
            goto L6
        }
    }

    public final void c() {
        this.a.removeAllViews();
        d r0 = this.d;
        if (r0 == null) goto L7;
        f r1 = r0.c;
        if (r1 == null) goto L7;
        r1.c();
    L7:
        this.c.clear();
    }

    public final Context getContext() {
        return this.e;
    }

    public ShareViewCard(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.e = r2;
        this.a = new FrameLayout(r2);
        this.b = LazyKt.lazy(ShareViewCard$service$2.INSTANCE);
        this.c = new CompositeDisposable();
    }

    public final void a(d r12) {
        Intrinsics.checkNotNullParameter(r12, "config");
        if (this.d != null) goto L14;
        this.d = r12;
        if (r12.f == 0.0d) goto L7;
    L11:
        com.bytedance.revenue.platform.api.core.rx.f.a(((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.b.getValue()).vd(this.e, r12).subscribe(new a(this, r12), new b(this, r12)), this.c);
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r7, "metric");
        Intrinsics.checkNotNullParameter(r6, "map");
        Uri r1 = r12.a;
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        r6.put("url", r1);
        Boolean r2 = Boolean.valueOf(r12.d);
        Intrinsics.checkNotNullParameter("allowFallback", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r6.put("allowFallback", r2);
        Intrinsics.checkNotNullParameter(r7, "map");
        Double r13 = Double.valueOf(r12.f);
        Intrinsics.checkNotNullParameter("startTime", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r7.put("startTime", r13);
        cy0.e.a.getClass();
        j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r14 = m.b(r0).b(n97.a.class);
        Intrinsics.checkNotNull(r14);
        ((com.bytedance.live.kmp.core.c) r14).g("ttlive_shareview_card_load", "revenue", "bussiness_api_call", r6, r7, r8);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        Instant r3 = Instant.now();
        double r4 = (r3.getEpochSecond() * 1000.0d) + (((double) ((int) (((double) r3.getNano()) / 1000.0d))) / 1000.0d);
    L10:
        r12.f = r4;
        goto L11
    L9:
        r4 = System.currentTimeMillis();
        goto L10
    L14:
        throw new Error("the ShareViewCard has loaded");
    }

    public static void b(d r12, String r13) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        Intrinsics.checkNotNullParameter(r4, "map");
        Uri r7 = r12.a;
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r4.put("url", r7);
        Intrinsics.checkNotNullParameter("reason", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r4.put("reason", r13);
        Intrinsics.checkNotNullParameter(r5, "map");
        Double r14 = Double.valueOf(r12.f);
        Intrinsics.checkNotNullParameter("startTime", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r5.put("startTime", r14);
        cy0.e.a.getClass();
        j r15 = cy0.e.a.a;
        m.e.getClass();
        Object r16 = m.b(r15).b(n97.a.class);
        Intrinsics.checkNotNull(r16);
        ((com.bytedance.live.kmp.core.c) r16).g("ttlive_shareview_card_fallback_fail", "revenue", "bussiness_api_call", r4, r5, r6);
    }
}
