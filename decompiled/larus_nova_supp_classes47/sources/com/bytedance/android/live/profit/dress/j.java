package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.dress.backend.DressBackendProcessor;
import com.bytedance.android.live.revenue.common.l0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final CompositeDisposable a = null;
    public static final com.bytedance.android.live.profit.dress.b b = null;
    public static final DressLocalDataSource c = null;
    public static final r d = null;
    public static long e;
    public static long f;
    public static final Set<String> g = null;
    public static String h;
    public static final j i = null;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public a(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }

        public final Object apply(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            Intrinsics.checkNotNullParameter(r13, "resp");
            com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
            long r1 = System.currentTimeMillis() - this.a;
            com.bytedance.android.livedress.impl.o r2 = com.bytedance.android.livedress.impl.o.a;
            String r3 = j.h;
            String r4 = ((n) r13.data).getVersion();
            String r5 = "";
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            Intrinsics.checkNotNullParameter(r3, "localVersion");
            Intrinsics.checkNotNullParameter(r4, "remoteVersion");
            JSONObject r6 = com.bytedance.android.livedress.impl.o.b(r2, true, null, 6);
            JSONObject r7 = com.bytedance.android.livedress.impl.o.d(Long.valueOf(r1));
            JSONObject r8 = new JSONObject();
            com.bytedance.android.livedress.impl.o.m(r8, "room_id", com.bytedance.android.livedress.impl.o.e());
            com.bytedance.android.livedress.impl.o.m(r8, "local_version", r3);
            com.bytedance.android.livedress.impl.o.m(r8, "remote_version", r4);
            com.bytedance.android.livedress.impl.o.g("ttlive_dress_list_status_all", r6, r7, r8);
            List<p> r9 = ((n) r13.data).getDressList();
            if ((!r9.isEmpty()) == false) goto L12;
            String r14 = ((n) r13.data).getVersion();
            if (r14 == null) goto L11;
            r5 = r14;
        L11:
            j.h = r5;
            j.c.a(r9);
            r r15 = j.d;
            String r10 = j.h;
            r15.getClass();
            Intrinsics.checkNotNullParameter(r9, "list");
            Intrinsics.checkNotNullParameter(r10, Constants.Keys.VERSION);
            iz0.a r16 = i.a;
            Intrinsics.checkNotNullParameter(r9, "list");
            Intrinsics.checkNotNullParameter(r10, Constants.Keys.VERSION);
            int r17 = com.bytedance.revenue.platform.api.core.rx.e.a;
            Completable.merge(com.bytedance.revenue.platform.api.core.c.a(new Completable[]{i.a.clear(), i.b.clear()})).subscribe(new h(r9, r10));
            jy0.b.c("DressRepository", "Fetch all dress succeed. size=" + r9.size() + ", version=" + j.h, null, 4);
        L13:
            j.e = this.b;
            return j.h;
        L12:
            jy0.b.c("DressRepository", "Fetch all dress succeed with no update", null, 4);
            goto L13
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r7) {
            ApiServerException r8 = (Throwable) r7;
            com.bytedance.android.livedress.impl.o r0 = com.bytedance.android.livedress.impl.o.a;
            String r1 = h40.e.a(r8);
            Intrinsics.checkNotNullParameter(r8, "$this$errorCode");
            if ((r8 instanceof ApiServerException) == false) goto L5;
            int r2 = r8.getErrorCode();
        L6:
            Intrinsics.checkNotNullParameter(r1, Constants.Keys.ERROR);
            JSONObject r3 = com.bytedance.android.livedress.impl.o.a(false, r1, Integer.valueOf(r2));
            JSONObject r4 = com.bytedance.android.livedress.impl.o.d(null);
            JSONObject r5 = new JSONObject();
            com.bytedance.android.livedress.impl.o.m(r5, "room_id", com.bytedance.android.livedress.impl.o.e());
            com.bytedance.android.livedress.impl.o.g("ttlive_dress_list_status_all", r3, r4, r5);
            com.bytedance.android.livedress.impl.o.g("ttlive_dress_list_status_error", r3, r4, r5);
            jy0.b.c("DressRepository", "Fetch all dress failed. " + h40.e.a(r8), null, 4);
            return;
        L5:
            r2 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ zt0.b a;
        public final /* synthetic */ String b;

        public c(zt0.b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            List<p> r3 = ((n) ((ExtraResponse) r2).data).getDressList();
            if ((!r3.isEmpty()) == false) goto L5;
            j.c.a(r3);
        L5:
            zt0.b r4 = this.a;
            if (r4 == null) goto L9;
            r4.a(this.b);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ zt0.b a;
        public final /* synthetic */ String b;

        public d(zt0.b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            ApiServerException r6 = (Throwable) r5;
            jy0.b.c("DressRepository", "Fetch dress by ids failed. " + h40.e.a(r6), null, 4);
            zt0.b r0 = this.a;
            if (r0 == null) goto L10;
            String r1 = this.b;
            String r2 = j.h;
            Intrinsics.checkNotNullParameter(r6, "$this$errorCode");
            if ((r6 instanceof ApiServerException) == false) goto L7;
            int r3 = r6.getErrorCode();
        L8:
            r0.b(r1, r2, r3, h40.e.a(r6));
            return;
        L7:
            r3 = -1;
            goto L8
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ String a;

        public e(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            int r5 = DressBackendProcessor.a;
            if (l0.a("dress") == true) goto L7;
            CompositeDisposable r6 = j.a;
            return j.a(this.a);
        L7:
            return DressBackendProcessor.a(this.a, new DressRepository$onChangeRoom$1$1(this), new DressRepository$onChangeRoom$1$2(this), j.a);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            String r2 = (String) r1;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r4) {
            jy0.b.c("DressRepository", "Fetch all dress failed. " + h40.e.a((Throwable) r4), null, 4);
        }
    }

    public j() {
    }

    static {
        i = new j();
        a = new CompositeDisposable();
        b = new com.bytedance.android.live.profit.dress.b();
        c = new DressLocalDataSource();
        d = new r();
        g = new LinkedHashSet();
        h = "";
    }

    public static Single a(String r17) {
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        long r2 = System.currentTimeMillis();
        long r3 = System.currentTimeMillis();
        if ((r2 - e) <= 1500) goto L11;
        com.bytedance.android.live.profit.dress.b r5 = b;
        String r6 = h;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.VERSION);
        Intrinsics.checkNotNullParameter(r17, "roomId");
        int r8 = zt0.a.a;
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.VERSION);
        Intrinsics.checkNotNullParameter(r17, "roomId");
        tz0.b r7 = tz0.b.a;
        uz0.c r9 = new uz0.c();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map<String, String> r10 = r9.b;
        Intrinsics.checkNotNullParameter(r10, "queriesMap");
        Intrinsics.checkNotNullParameter(Constants.Keys.VERSION, "$this$setTo");
        if (r6 == null) goto L7;
        r10.put(Constants.Keys.VERSION, r6);
    L7:
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r17 == null) goto L10;
        r10.put("room_id", r17);
    L10:
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r0 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/dress/list/", TypesJVMKt.getJavaType(Reflection.typeOf(n.class)), Extra.class, r9.d, r9.a, r9.b, r9.c);
        int r12 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r4 = r0.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        h40.a r13 = new h40.a();
        Intrinsics.checkNotNullParameter(r4, "$this$retryWhenCompat");
        return r4.retryWhen(new h40.d(3, r13, 1000)).map(new a(r3, r2)).firstOrError().doOnError(b.a).subscribeOn(Schedulers.io());
    L11:
        int r14 = com.bytedance.revenue.platform.api.core.rx.q.a;
        return Single.just(h);
    }

    public static void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        if (h.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        d.getClass();
        iz0.a r1 = i.a;
        int r2 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r3 = i.a.getString();
        Single r5 = i.b.getString();
        final DressKevaUtils$load$1 r6 = DressKevaUtils$load$1.INSTANCE;
        Single r7 = Single.zip(r3, r5, new com.bytedance.android.live.profit.dress.e(r6)).flatMap(com.bytedance.android.live.profit.dress.g.a).map(k.a);
        int r8 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Single r9 = r7.subscribeOn(Schedulers.io());
    L9:
        Single r10 = r9.flatMap(new e(r4));
        int r12 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r10.subscribeOn(Schedulers.io()).subscribe(f.a, g.a), a);
        return;
    L8:
        int r13 = com.bytedance.revenue.platform.api.core.rx.q.a;
        r9 = Single.just(h);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static com.bytedance.android.live.profit.dress.d e(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dressId");
        DressLocalDataSource r1 = c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "dressId");
        Map r4 = (Map) ((LinkedHashMap) r1.c).get(Integer.valueOf(r3));
        if (r4 == null) goto L5;
        com.bytedance.android.live.profit.dress.d r5 = (com.bytedance.android.live.profit.dress.d) r4.get(r2);
    L7:
        if ((r5 instanceof com.bytedance.android.live.profit.dress.d) == true) goto L10;
        return null;
    L10:
        return r5;
    L5:
        r5 = null;
        goto L7
    }

    public static void b(String r7, String r8, zt0.b r9) {
        Intrinsics.checkNotNullParameter(r7, "dressId");
        Intrinsics.checkNotNullParameter(r8, "roomId");
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis();
        if ((r1 - f) <= 1500) goto L5;
        c(r7, r8, r9);
        f = r1;
        Set<String> r10 = g;
        r10.clear();
        r10.add(r7);
        return;
    L5:
        Set<String> r2 = g;
        if (r2.contains(r7) == true) goto L10;
        c(r7, r8, r9);
        r2.add(r7);
        return;
    }

    public static void c(String r10, String r12, zt0.b r13) {
        b.getClass();
        Intrinsics.checkNotNullParameter(r10, "dressId");
        Intrinsics.checkNotNullParameter(r12, "roomId");
        int r2 = zt0.a.a;
        Intrinsics.checkNotNullParameter(r10, "dressId");
        Intrinsics.checkNotNullParameter(r12, "roomId");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r1.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r12 == null) goto L5;
        r3.put("room_id", r12);
    L5:
        Intrinsics.checkNotNullParameter("dress_id", "$this$setTo");
        if (r10 == null) goto L8;
        r3.put("dress_id", r10);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        Observable r14 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/dress/list/", TypesJVMKt.getJavaType(Reflection.typeOf(n.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r14.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).singleOrError().subscribe(new c(r13, r10), new d(r13, r10)), a);
    }
}
