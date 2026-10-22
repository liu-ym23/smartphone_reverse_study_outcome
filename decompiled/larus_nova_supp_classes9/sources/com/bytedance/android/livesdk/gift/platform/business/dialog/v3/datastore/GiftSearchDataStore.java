package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import android.text.TextUtils;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickSearchBack;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a2;
import com.bytedance.android.livesdk.gift.platform.core.utils.b0;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import oc6.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftSearchDataStore extends BaseMVIDataStore<GiftSearchDataStore> implements com.bytedance.android.scope.o, oc6.s {
    public static final /* synthetic */ KProperty[] k = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final BehaviorSubject<Boolean> g;
    public final com.bytedance.android.anya.t h;
    public final com.bytedance.android.anya.t i;
    public String j;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            g0 r0 = new g0();
            r0.a(r3.booleanValue());
            return r0;
        }
    }

    static {
        k = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftSearchDataStore.class, "currentIsSearch", "getCurrentIsSearch()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftSearchDataStore.class, "currentSearchKeyword", "getCurrentSearchKeyword()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftSearchDataStore.class, "_currentIsSearch", "get_currentIsSearch()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftSearchDataStore.class, "_currentSearchKeyword", "get_currentSearchKeyword()Ljava/lang/String;", 0))};
    }

    public final com.bytedance.android.anya.t<GiftSearchDataStore, Boolean> n() {
        return (com.bytedance.android.anya.t) this.e.getValue(this, k[0]);
    }

    public final com.bytedance.android.anya.t<GiftSearchDataStore, String> o() {
        return (com.bytedance.android.anya.t) this.f.getValue(this, k[1]);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean s() {
        return ((Boolean) this.h.getValue(this, k[2])).booleanValue();
    }

    public final Observable<g0> observeSearchResult() {
        return this.g.map(b.a);
    }

    public final String q() {
        return (String) this.i.getValue(this, k[3]);
    }

    public GiftSearchDataStore() {
        com.bytedance.android.anya.internal.k r0 = i(Boolean.FALSE).a();
        KProperty[] r1 = k;
        this.e = r0.a(r1[0]);
        this.f = i(BuildConfig.FLAVOR).a().a(r1[1]);
        int r2 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.g = BehaviorSubject.create();
        this.h = n();
        this.i = o();
        this.j = BuildConfig.FLAVOR;
    }

    public final void back() {
        if (s() == true) goto L5;
        return;
    L5:
        g("back", new AnonymousClass1(this));
        this.j = BuildConfig.FLAVOR;
        uz1.a r0 = b0.b();
        if (r0 == null) goto L9;
        r0.a(new ClickSearchBack());
        return;
    }

    public final void k() {
        if (s() == false) goto L5;
        return;
    L5:
        g("enterSearch", new GiftSearchDataStore$enterSearch$1(this));
    }

    public final void doSearch(final String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L11;
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L7;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, a2.class);
    L8:
        a2 r2 = (a2) r1;
        if (r2 == null) goto L11;
        r2.a(17, r4);
        goto L11
    L7:
        r1 = null;
    L11:
        g("doSearch", new C03001(this, r4));
    }
}
