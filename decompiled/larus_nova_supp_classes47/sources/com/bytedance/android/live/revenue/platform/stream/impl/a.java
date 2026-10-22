package com.bytedance.android.live.revenue.platform.stream.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import yz0.k;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, d01.a, m {
    public final PublishSubject a;
    public final PublishSubject b;
    public final Observable<JsonObject> c;
    public d01.b d;
    public final k e;
    public final or2.e f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.stream.impl.a$a, reason: collision with other inner class name */
    public static final class C0105a {
    }

    public static final class b implements d01.b {
        public final HashMap<String, Pair<Object, d01.b.a>> a;
        public d01.b b;

        public b() {
            this.a = new HashMap();
        }

        @Override // d01.b
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            d01.b r0 = this.b;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        L6:
            this.a.remove(r2);
        }

        @Override // d01.b
        public final void a(String r2, Object r3, d01.b.a r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            Intrinsics.checkNotNullParameter(r4, "attributes");
            d01.b r0 = this.b;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4);
            return;
        L6:
            this.a.put(r2, TuplesKt.to(r3, r4));
        }
    }

    public static final class c implements d01.b {
        public final d0 a;

        public c(d0 r2) {
            Intrinsics.checkNotNullParameter(r2, "liveCore");
            this.a = r2;
        }

        @Override // d01.b
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a.X();
        }

        @Override // d01.b
        public final void a(String r2, Object r3, d01.b.a r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            Intrinsics.checkNotNullParameter(r4, "attributes");
            d0 r5 = this.a;
            int r6 = r4.a;
            r5.X();
        }
    }

    public static final class d implements d01.b {
        public d() {
        }

        @Override // d01.b
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            throw new UnsupportedOperationException();
        }

        @Override // d01.b
        public final void a(String r2, Object r3, d01.b.a r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            Intrinsics.checkNotNullParameter(r4, "attributes");
            throw new UnsupportedOperationException();
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            JsonObject r0 = (JsonObject) GsonHelper.get().fromJson(r5, JsonObject.class);     // Catch: Throwable -> L7
            if (r0 != null) goto L12;
            return new JsonObject();
        L12:
            return r0;
        L7:
            th = move-exception;
            jy0.b.c("SeiServiceImpl", "failed to decode sei data: " + th + ": " + r5, null, 4);
            return new JsonObject();
        }
    }

    public static final class f<T> implements Predicate {
        public final /* synthetic */ String a;

        public f(String r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            JsonObject r3 = (JsonObject) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.has(this.a);
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ String a;

        public g(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            JsonObject r3 = (JsonObject) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.get(this.a);
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r2) {
            jy0.b.d("SeiServiceImpl", "push stream success");
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ a a;

        public i(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return this.a.g.getRoomContext().getLiveStream().b();
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ d01.b b;

        public j(a r1, d01.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.livesdk.revenue.pushstream.a r8 = (com.bytedance.android.livesdk.revenue.pushstream.a) sh6.c.b((sh6.b) r7);
            if (r8 == null) goto L5;
            d0 r9 = r8.A();
        L7:
            if (r9 == null) goto L13;
            c r0 = new c(r9);
            b r10 = (b) this.b;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r0, "other");
            Iterator<Map.Entry<String, Pair<Object, d01.b.a>>> r2 = r10.a.entrySet().iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            Map.Entry<String, Pair<Object, d01.b.a>> r3 = r2.next();
            String r4 = r3.getKey();
            Pair<Object, d01.b.a> r5 = r3.getValue();
            r0.a(r4, r5.component1(), (d01.b.a) r5.component2());
            goto L10
        L12:
            r10.a.clear();
            r10.b = r0;
            this.a.d = r0;
            jy0.b.d("SeiServiceImpl", "SEI writer is initialized");
            return;
        L13:
            jy0.b.c("SeiServiceImpl", "liveCore is null", null, 4);
            return;
        L5:
            r9 = null;
            goto L7
        }
    }

    static {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // d01.a
    public final d01.b E3() {
        d01.b r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_seiWriter");
    L5:
        return r0;
    }

    @Override // yz0.m
    public final void i() {
        this.a.onComplete();
        d01.b r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_seiWriter");
    L6:
        if ((r0 instanceof b) == false) goto L9;
        RxUtilKt.b(this.e.getDataCenter(), "cmd_anchor_broadcast_start", true).take(1).doOnNext(h.a).flatMapMaybe(new i(this)).takeUntil(this.b).subscribe(new j(this, r0));
        return;
    }

    public final void onStart() {
        if (this.e.isAnchor() == false) goto L5;
        d01.b r0 = new b();
    L6:
        this.d = r0;
        return;
    L5:
        r0 = new d();
        goto L6
    }

    public final void onStop() {
        this.b.onComplete();
        this.d = new d();
    }

    @Override // d01.a
    public final Observable<JsonObject> ri() {
        return this.c;
    }

    @Override // d01.a
    public final Observable<JsonElement> o6(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.c.filter(new f(r3)).map(new g(r3));
    }

    public a(k r2, or2.e r3, com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "roomPlayer");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        PublishSubject r5 = PublishSubject.create();
        this.a = r5;
        PublishSubject r6 = PublishSubject.create();
        this.b = r6;
        this.c = RxUtilKt.h(Observable.concat(r5, Observable.create(new com.bytedance.android.live.revenue.platform.stream.impl.b(this))).observeOn(Schedulers.computation()).map(e.a)).takeUntil(RxUtilKt.h(r6)).share();
    }
}
