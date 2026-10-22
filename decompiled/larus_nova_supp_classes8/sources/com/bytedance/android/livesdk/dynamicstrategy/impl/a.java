package com.bytedance.android.livesdk.dynamicstrategy.impl;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.g0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.j;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.l;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final List<d<?, ?>> a = null;
    public static final List<f<?>> b = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.a$a, reason: collision with other inner class name */
    public interface InterfaceC0304a<T, R> {
        R convert(T r1);
    }

    public static final class b implements InterfaceC0304a<Integer, Integer> {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC0304a
        public final Integer convert(Integer r1) {
            return Integer.valueOf(r1.intValue());
        }
    }

    public static final class c implements InterfaceC0304a<Long, Long> {
        public static final c a = null;

        public c() {
        }

        static {
            a = new c();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC0304a
        public final Long convert(Long r3) {
            return Long.valueOf(r3.longValue());
        }
    }

    public static final class d<T, R> {
        public final String a;
        public final T b;
        public final String c;
        public final R d;
        public final InterfaceC0304a<T, R> e;

        public d(String r2, T r3, String r4, R r5, InterfaceC0304a<T, R> r6) {
            Intrinsics.checkNotNullParameter(r2, "featureName");
            Intrinsics.checkNotNullParameter(r4, "factorName");
            Intrinsics.checkNotNullParameter(r6, "convert");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class e extends DynamicFactor<Object> implements z90.a.b {
        public final z90.a b;
        public final d<Object, Object> c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.a$e$a, reason: collision with other inner class name */
        public static final class RunnableC0305a implements Runnable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ e b;

            public RunnableC0305a(Object r1, e r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.update(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final Object b() {
            z90.a r0 = this.b;
            if (r0 == null) goto L6;
            d<Object, Object> r1 = this.c;
            Object r2 = r0.getFeature(r1.a, r1.b);
            if (r2 == null) goto L6;
        L8:
            return this.c.e.convert(r2);
        L6:
            r2 = this.c.b;
            goto L8
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final String c() {
            return this.c.c;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void d() {
            z90.a r0 = this.b;
            if (r0 == null) goto L6;
            r0.e(this, CollectionsKt.listOf(this.c.a));
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void e() {
            z90.a r0 = this.b;
            if (r0 == null) goto L6;
            r0.h(this);
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public DynamicFactor.Type getType() {
            return DynamicFactor.Type.SMART_MIX;
        }

        public e(d<Object, Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "mixFeature");
            this.c = r2;
            IFeatureService r3 = k.f(IFeatureService.class);
            if (r3 == null) goto L5;
            z90.a r4 = r3.getFeatureManager();
        L6:
            this.b = r4;
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final <T> void a(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
            if (r3 == null) goto L8;
            Object r4 = this.c.e.convert(r3);
            if (r4 == null) goto L9;
            MainThreadPostUtils.e(new RunnableC0305a(r4, this));
            return;
        L9:
            return;
        }
    }

    public static final class f<R> {
        public final String a;
        public final R b;

        public f(String r2, R r3) {
            Intrinsics.checkNotNullParameter(r2, "factorName");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class g extends DynamicFactor<Object> implements z90.a.b, Observer<KVData> {
        public final z90.a b;
        public final f<Object> c;

        public final <T> void a(String r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, LiveEndPageData.TAG_NAME);
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final Object b() {
            return this.c.b;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final String c() {
            return this.c.a;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void d() {
            z90.a r0 = this.b;
            if (r0 == null) goto L6;
            r0.e(this, CollectionsKt.listOf(this.c.a));
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public final void e() {
            z90.a r0 = this.b;
            if (r0 == null) goto L6;
            r0.h(this);
            return;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
        public DynamicFactor.Type getType() {
            return DynamicFactor.Type.SMART_MIX;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L17;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
            if (TextUtils.isEmpty(r4.getKey()) == false) goto L7;
        L9:
            Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Result.box-impl(r5);
            return;
        L7:
            if (TextUtils.equals(r4.getKey(), this.c.a) == false) goto L9;
            MainThreadPostUtils.e(new com.bytedance.android.livesdk.dynamicstrategy.impl.b(this, r4));     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }

        public g(f<Object> r2, DataCenter r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "mixFeature");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "key");
            this.c = r2;
            IFeatureService r5 = k.f(IFeatureService.class);
            if (r5 == null) goto L5;
            z90.a r6 = r5.getFeatureManager();
        L6:
            this.b = r6;
            if (TextUtils.isEmpty(r4) == true) goto L10;
            r3.observe(r4, this);
            return;
        L10:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class h implements InterfaceC0304a<Float, Integer> {
        public h() {
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC0304a
        public final Integer convert(Float r1) {
            return Integer.valueOf((int) r1.floatValue());
        }
    }

    public static final class i implements InterfaceC0304a<Integer, Boolean> {
        public i() {
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.a.InterfaceC0304a
        public final Boolean convert(Integer r2) {
            int r3 = r2.intValue();
            if (r3 != 2) goto L5;
        L8:
            boolean r4 = true;
        L10:
            return Boolean.valueOf(r4);
        L5:
            if (r3 == 5) goto L8;
            r4 = false;
            goto L10
        }
    }

    static {
        b r16 = b.a;
        a = CollectionsKt.mutableListOf(new d[]{new d("live_ecom_live_cart_tag_click_count", 0, "live_ecom_live_cart_tag_click_count", 0, r16), new d("live_comment_count", 0, "live_comment_count", 0, r16), new d("live_gift_send_count", 0, "live_gift_send_count", 0, r16), new d("live_like_amount", 0, "live_like_amount", 0, r16), new d("live_watch_duration", 0L, "live_watch_duration", 0L, c.a), new d("solaria_features_cl_is_wifi", -1, "network_type", 0, r16), new d("net_quality", 0, "net_quality", 0, r16), new d("battery_level", Float.valueOf(0.0f), "battery_level", 0, new h()), new d("battery_state_android", 0, "is_charging", Boolean.FALSE, new i())});
        b = CollectionsKt.mutableListOf(new f[]{new f("live_short_touch_ecom_redpack_type", 0), new f("live_short_touch_ecom_redpack_total_amount", 0), new f("live_short_touch_ecom_redpack_total_stock", 0), new f("live_short_touch_ecom_redpack_sub_type", 0)});
    }

    public static List a() {
        ArrayList r0 = new ArrayList();
        List r1 = CollectionsKt.listOf(new DynamicFactor[]{com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.e.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.c.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.d.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.b.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.f.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.g.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.h.b, l.b, j.b, com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.k.b, g0.b});
        if (r1 == null) goto L5;
        r0.addAll(r1);
    L5:
        boolean r2 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a;
        List r3 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.c();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L21;
        m r7 = (m) r5.next();
        Intrinsics.checkNotNullParameter(r7, "$this$isNFALiveRoom");
        if (r7.featureType != 6) goto L15;
        s r8 = r7.nfaInfo;
        if (r8 == null) goto L15;
        if (r8.c() != 3) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L18;
        n r10 = lu1.j.a(r7);
    L19:
        if (r10 == null) goto L7;
        r4.add(r10);
        goto L7
    L18:
        r10 = null;
    L15:
        r9 = false;
        goto L16
    L21:
        List r6 = CollectionsKt.toList(r4);
        if (r6 == null) goto L24;
        r0.addAll(r6);
    L24:
        return r0;
    }
}
