package com.bytedance.android.livesdk.gift.platform.business;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class AbsBannerGiftPlugin extends l {
    public h1 e;
    public Long f;
    public final PublishSubject<Boolean> g;
    public b h;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b {
        public final AbsBannerGiftPlugin k;

        @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
        public final void d() {
            e0 r0 = this.d;
            String r1 = BuildConfig.FLAVOR;
            if (r0 == null) goto L6;
            String r2 = r0.uri;
            if (r2 == null) goto L6;
        L7:
            Uri r3 = UriProtector.parse(r2);
            if (r3 == null) goto L12;
            String r4 = UriProtector.getQueryParameter(r3, "hide_panel");
            if (r4 == null) goto L12;
            int r5 = CastIntegerProtector.parseInt(r4);
        L14:
            if (r5 != 1) goto L16;
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        L16:
            AbsBannerGiftPlugin r6 = this.k;
            e0 r7 = this.d;
            if (r7 == null) goto L19;
            String r8 = r7.uri;
        L20:
            r6.getClass();
            Context r9 = r6.getContext();     // Catch: Throwable -> L29
            if (r9 == null) goto L34;
            if (r8 == null) goto L27;
            r1 = r8;
        L27:
            zz0.h.a(r9, UriProtector.parse(r1));     // Catch: Throwable -> L29
            r6.N(r8, com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString());     // Catch: Throwable -> L29
            return;
        L34:
            return;
        L29:
            th = move-exception;
            jy0.b.b("ttlive_default_banner", "failed to open uri " + r8, th);
            return;
        L19:
            r8 = null;
        L12:
            r5 = 0;
        L6:
            r2 = BuildConfig.FLAVOR;
            goto L7
        }

        public b(Context r2, DataCenter r3, AbsBannerGiftPlugin r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "plugin");
            super(r2, r3);
            this.k = r4;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ AbsBannerGiftPlugin a;
        public final /* synthetic */ long b;

        public c(AbsBannerGiftPlugin r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsBannerGiftPlugin r0 = this.a;     // Catch: Throwable -> L9
            h1 r3 = null;
            h1 r1 = GiftManagerKt.j(this.b, null);     // Catch: Throwable -> L9
            if (r1 != null) goto L5;
        L7:
            AbsBannerGiftPlugin.I(r0, r3);     // Catch: Throwable -> L9
            return;
        L5:
            if (this.a.J(r1) == false) goto L7;
            r3 = r1;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AbsBannerGiftPlugin a;
        public final /* synthetic */ AbsPanel b;

        public d(AbsBannerGiftPlugin r1, AbsPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsBannerGiftPlugin r0 = this.a;     // Catch: Throwable -> L16
            AbsPanel r1 = this.b;     // Catch: Throwable -> L16
            r0.getClass();     // Catch: Throwable -> L16
            h1 r2 = null;
            if (r1 == null) goto L5;
            Object r3 = r1.h;     // Catch: Throwable -> L16
        L7:
            if ((r3 instanceof h1) == true) goto L9;
            r3 = null;
        L9:
            h1 r4 = (h1) r3;     // Catch: Throwable -> L16
            if (r4 != null) goto L12;
        L14:
            AbsBannerGiftPlugin.I(r0, r2);     // Catch: Throwable -> L16
            return;
        L12:
            if (r0.J(r4) == false) goto L14;
            r2 = r4;
            goto L14
        L5:
            r3 = null;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L20;
            return;
        L20:
            throw th;
        }
    }

    static {
    }

    public abstract boolean J(h1 r1);

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i<Boolean> E() {
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i(this.g, new AbsBannerGiftPlugin$provideTopViewController$1(this));
    }

    public final com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a K() {
        return L(getContext(), this.b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void c() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.c.a();
        this.h = null;
        super.c();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.c.a();
        this.h = null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void i(h1 r4) {
        Intrinsics.checkNotNullParameter(r4, "gift");
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r0 = K();
        if (r0 == null) goto L6;
        r0.e(r4.getId());
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void y(p2 r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r0 = K();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public AbsBannerGiftPlugin(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.g = PublishSubject.create();
    }

    public static final void I(AbsBannerGiftPlugin r2, h1 r3) {
        r2.e = r3;
        if (r3 == null) goto L11;
        r2.f = Long.valueOf(r3.getId());
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r0 = r2.K();
        if (r0 == null) goto L7;
        r0.c = r3;
    L7:
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a r1 = r2.K();
        if (r1 == null) goto L10;
        r1.g(r3.getGiftBanner());
    L10:
        r2.g.onNext(Boolean.TRUE);
        return;
    L11:
        r2.f = 0L;
        r2.g.onNext(Boolean.FALSE);
    }

    public com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a L(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (r2 == null) goto L8;
        if (this.h != null) goto L8;
        this.h = new b(r2, r3, this);
    L8:
        return this.h;
    }

    public final void N(String r13, String r14) {
        Map r0 = MapsKt.mapOf(TuplesKt.to("uri", String.valueOf(r13)));
        boolean r2 = d0.a;
        if (r13 != null) goto L5;
        r13 = BuildConfig.FLAVOR;
    L5:
        Intrinsics.checkNotNullParameter(r13, "uriString");
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r9, "metric");
        EventModule r3 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r3, "eventModule");
        String r6 = r3.getValue();
        r9.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter("uri", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r10.put("uri", r13);
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r15 = m.b(r1).b(n97.a.class);
        Intrinsics.checkNotNull(r15);
        ((com.bytedance.live.kmp.core.c) r15).g("ttlive_default_gift_banner_click", r6, "bussiness_api_call", r8, r9, r10);
        jy0.b.a("ttlive_default_banner", "ttlive_default_gift_banner_click " + r0);
        Pair[] r16 = new Pair[2];
        Object r4 = this.f;
        if (r4 != null) goto L8;
        r4 = BuildConfig.FLAVOR;
    L8:
        r16[0] = TuplesKt.to("gift_id", r4.toString());
        if (r14 != null) goto L11;
        r14 = BuildConfig.FLAVOR;
    L11:
        r16[1] = TuplesKt.to("user_id", r14);
        Map r17 = MapsKt.mapOf(r16);
        n r18 = new n();
        Map r5 = r18.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r5.putAll(r17);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        r19.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r18.b).addAll(r19.a);
        Object r110 = m.b(r1).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((f80.a) r110).w3("livesdk_gift_bubble_banner_click", r18.a, r18.b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void j(long r2, Integer r4) {
        new Handler(Looper.getMainLooper()).post(new c(this, r2));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r3, SelectedStatus r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "selectedStatus");
        new Handler(Looper.getMainLooper()).post(new d(this, r3));
        Intrinsics.checkNotNullParameter(r4, "selectedStatus");
        return false;
    }
}
