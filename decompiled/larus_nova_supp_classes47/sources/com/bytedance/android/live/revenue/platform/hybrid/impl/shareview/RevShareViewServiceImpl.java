package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.t0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevShareViewServiceImpl implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a, o {
    public final Map<String, BehaviorSubject<h80.c<View>>> a;
    public final WeakHashMap<Context, l> b;
    public final List<com.lynx.tasm.behavior.a> c;
    public final List<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e> d;
    public final Lazy e;
    public final vy0.c f;

    public static final class a {
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("rev-share-view");
        }

        public final LynxUI createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new RevShareViewUI(r2);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ RevShareViewServiceImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d c;

        public c(RevShareViewServiceImpl r1, String r2, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v6 */
        public final Object apply(Object r25) {
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r1 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c) r25;
            Intrinsics.checkNotNullParameter(r1, "sharer");
            RevShareViewServiceImpl r2 = this.a;
            String r3 = this.b;
            BehaviorSubject<h80.c<View>> r4 = (BehaviorSubject) ((LinkedHashMap) r2.a).get(r3);
            if (r4 != null) goto L5;
            r4 = BehaviorSubject.create();
            r2.a.put(r3, r4);
        L5:
            Observable r5 = r4.filter(j.a).map(k.a).doOnDispose(new f(this, r1));
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f r6 = this.c.c;
            if (r6 == null) goto L8;
            r6.e(r1);
        L8:
            RevShareViewServiceImpl r7 = this.a;
            String r8 = this.b;
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d r9 = this.c;
            r7.getClass();
            Pair[] r10 = new Pair[5];
            ?? r12 = 0;
            r10[0] = TuplesKt.to("id", r8);
            r10[1] = TuplesKt.to("url", r9.a.toString());
            Map<String, Object> r13 = r9.b;
            if (r13 == null) goto L12;
            Map r14 = MapsKt.toMutableMap(r13);
            if (r14 == null) goto L12;
        L13:
            String r15 = UriProtector.getQueryParameter(r9.a, "initialProps");
            int r16 = 2;
            Object r17 = null;
            if (r15 != null) goto L16;
            GsonMap r18 = null;
        L35:
            r14.put("initialProps", r18);
            Unit r19 = Unit.INSTANCE;
            r10[2] = TuplesKt.to("initData", r14);
            Pair<Integer, Integer> r20 = r9.e;
            if (r20 == null) goto L38;
            List r22 = CollectionsKt.listOf(new Integer[]{(Integer) r20.getFirst(), (Integer) r20.getSecond()});
        L39:
            r10[3] = TuplesKt.to("initSize", r22);
            r10[4] = TuplesKt.to("startTime", Double.valueOf(r9.f));
            Map<String, ? extends Object> r23 = MapsKt.mapOf(r10);
            r1.a("share-view-load", r23);
            if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.h.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.a[6])).booleanValue() == false) goto L42;
            r1.getLynxView().sendGlobalEventToLepus("share-view-load", CollectionsKt.listOf(r23));
        L42:
            return r5;
        L38:
            r22 = null;
            goto L39
        L16:
            Gson r110 = new Gson();
            JsonObject r111 = new JsonObject();
            Iterator<T> r24 = ((JsonArray) GsonProtectorUtils.fromJson(r110, r15, JsonArray.class)).iterator();
        L18:
            if (r24.hasNext() == false) goto L34;
            String r112 = ((JsonElement) r24.next()).getAsString();
            if (StringsKt.startsWith$default(r112, "setting:", r12, r16, r17) == false) goto L27;
            JsonObject r26 = new JsonObject();
            String r113 = r112.substring(8);
            char[] r114 = new char[1];
            r114[r12] = ':';
            Iterator r115 = SettingUtilExtensionKt.getSettingsValue(StringsKt.split$default(r113, r114, false, 0, 6, null)).iterator();
        L23:
            if (r115.hasNext() == false) goto L25;
            Pair r116 = (Pair) r115.next();
            r26.add((String) r116.component1(), (JsonElement) r116.component2());
            goto L23
        L25:
            r111.add("setting", r26);
        L33:
            r12 = 0;
            r16 = 2;
            r17 = null;
            goto L18
        L27:
            if (StringsKt.startsWith$default(r112, "storage:", false, 2, r17) == false) goto L33;
            JsonObject r27 = new JsonObject();
            Iterator<T> r28 = StringsKt.split$default(r112.substring(8), new char[]{':'}, false, 0, 6, null).iterator();
        L30:
            if (r28.hasNext() == false) goto L32;
            String r117 = (String) r28.next();
            r27.add(r117, GsonProtectorUtils.toJsonTree(r110, ((nr2.a) r7.e.getValue()).G0(r117, Object.class)));
            goto L30
        L32:
            r111.add("storage", r27);
            goto L33
        L34:
            r18 = UtilsKt.i(r111);
        L12:
            r14 = new LinkedHashMap();
            goto L13
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            View r3 = (View) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return TuplesKt.to(this.a, r3);
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        Iterator r0 = ((LinkedHashMap) this.a).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BehaviorSubject) r0.next()).onError(new Throwable("ShareViewService released"));
        goto L4
    L6:
        ((LinkedHashMap) this.a).clear();
        Collection<l> r1 = this.b.values();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if ((r4 instanceof l.a) == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        Iterator r5 = r2.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        ((l.a) r5.next()).a.release();
        goto L14
    }

    public static void a() {
        Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final List<com.lynx.tasm.behavior.a> Z9() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final List<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e> getMethods() {
        return this.d;
    }

    public RevShareViewServiceImpl(vy0.c r3) {
        Intrinsics.checkNotNullParameter(r3, "hybridService");
        this.f = r3;
        this.a = new LinkedHashMap();
        this.b = new WeakHashMap();
        this.c = CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new b()});
        this.d = new ArrayList();
        this.e = LazyKt.lazy(RevShareViewServiceImpl$propertyService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c Ka(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        l r3 = this.b.get(r2);
        if ((r3 instanceof l.a) == true) goto L5;
        return null;
    L5:
        return ((l.a) r3).a;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final void Y3(String r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "view");
        a();
        BehaviorSubject r4 = (BehaviorSubject) ((LinkedHashMap) this.a).get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        h80.c r0 = (h80.c) r4.getValue();
        if (r0 == null) goto L14;
        View r1 = (View) z0.b(r0);
        if (r1 == null) goto L15;
        if (r1 == r3) goto L12;
        return;
    L12:
        UtilityKotlinExtentionsKt.q(r3);
        r4.onNext(h80.c.b);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final void li(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "id");
        a();
        BehaviorSubject r0 = (BehaviorSubject) ((LinkedHashMap) this.a).get(r5);
        if (r0 == null) goto L5;
        h80.c r1 = (h80.c) r0.getValue();
        Object r2 = null;
        if (r1 == null) goto L9;
        View r3 = (View) z0.b(r1);
    L10:
        if (r3 != null) goto L12;
    L19:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L23;
        r0.onError(r7);
    L23:
        if (Result.isSuccess-impl(r6) == false) goto L26;
        r0.onNext(new h80.c((View) r6));
        return;
    L26:
        return;
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r2 = r6;
    L16:
        if (((View) r2) != r3) goto L18;
        return;
    L18:
        Y3(r5, r3);
        goto L19
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        t0.a r4 = t0.a.a;
        Intrinsics.checkNotNullParameter("revenue.requestStickerEffectStatus", "name");
        Intrinsics.checkNotNullParameter(r4, "methodProvider");
        List<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e> r5 = this.d;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a());
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a
    public final Observable<Pair<String, View>> vd(Context r7, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "config");
        a();
        String r0 = UUID.randomUUID().toString();
        a();
        l r1 = this.b.get(r7);
        if (r1 == null) goto L16;
        if ((r1 instanceof l.b) == false) goto L8;
        Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r9 = ((l.b) r1).a;
    L41:
        return r9.toObservable().flatMap(new c(this, r0, r8)).map(new d(r0));
    L8:
        if ((r1 instanceof l.a) == false) goto L14;
        l.a r2 = (l.a) r1;
        if (r2.a.isValid() == false) goto L12;
        r9 = Single.just(r2.a);
        goto L41
    L12:
        r2.a.release();
        l r3 = this.b.remove(r7);
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if ((r7 instanceof Activity) == true) goto L18;
    L39:
        r9 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "context " + r7 + " is not an Activity or not a LifecycleOwner"));
        goto L41
    L18:
        if ((r7 instanceof LifecycleOwner) == false) goto L39;
        if (((Activity) r7).isDestroyed() == false) goto L23;
        r9 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "context has been destroyed"));
        goto L41
    L23:
        ReadOnlyProperty r4 = com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.g;
        KProperty[] r5 = com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.a;
        if (((Boolean) r4.getValue(null, r5[5])).booleanValue() == false) goto L26;
        Single r6 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "force use standalone sharer"));
    L38:
        Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r10 = r6.onErrorResumeNext(new g(this, r7)).map(new h(this, r7)).doOnError(new i(this, r7)).toObservable().share().firstOrError();
        this.b.put(r7, new l.b(r10));
        r9 = r10;
        goto L41
    L26:
        com.bytedance.android.live.revenue.platform.container.impl.core.d r12 = (com.bytedance.android.live.revenue.platform.container.impl.core.d) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.live.revenue.platform.container.impl.core.d.class);
        if (r12 != null) goto L30;
        r6 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "service center not ready"));
        goto L38
    L30:
        if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.e.getValue(null, r5[3])).booleanValue() == false) goto L35;
        if (r12.d.hasValue() == true) goto L35;
        r6 = Single.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "ignore the service center lazy load"));
    L35:
        if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.c.getValue(null, r5[1])).booleanValue() == false) goto L37;
        r12.a();
    L37:
        r6 = RxUtilKt.h(r12.d.flatMap(new com.bytedance.android.live.revenue.platform.hybrid.impl.shareview.c(r7))).take(1).firstOrError().map(e.a);
        goto L38
    }
}
