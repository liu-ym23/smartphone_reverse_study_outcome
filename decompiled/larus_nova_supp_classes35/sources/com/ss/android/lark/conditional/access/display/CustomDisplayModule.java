package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelByKeyRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class CustomDisplayModule implements g, r {
    public static final /* synthetic */ int f = 0;
    public final m a;
    public final h b;
    public final i c;
    public final apb.a d;
    public CompositeDisposable e;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            CustomDisplayModelResponse r3 = (CustomDisplayModelResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.config;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CustomDisplayModule a;

        public c(CustomDisplayModule r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CustomDisplayModule.a(this.a, ((CustomDisplayMGetResponse) r2).config_list);
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            CustomDisplayMGetResponse r6 = (CustomDisplayMGetResponse) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            List r7 = r6.config_list;
            String r0 = this.a;
            Iterator<T> r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L8;
            T r1 = r8.next();
            if (Intrinsics.areEqual(((CustomDisplayConfig) r1).id, r0) == false) goto L4;
        L9:
            CustomDisplayConfig r2 = (CustomDisplayConfig) r1;
            if (r2 == null) goto L13;
            return Single.just(new CustomDisplayModel(r2, System.currentTimeMillis()));
        L13:
            return Single.error(new Exception("fetch success, but no id match"));
        L8:
            r1 = null;
            goto L9
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final String c() {
        return StringsKt.replace$default(this.d.g(), '_', '-', false, 4, null);
    }

    public final m getPassport() {
        return this.a;
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        return this.b.U(r2);
    }

    public final void b(final long r4) {
        CustomDisplayPageListRequest.Builder r0 = new CustomDisplayPageListRequest.Builder();
        r0.offset = Long.valueOf(r4);
        r0.count = 50L;
        r0.locale = c();
        t4c.a.b(this.b.a(r0).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()), this.e, new CustomDisplayModule$batchUpdate$1(this, r4), CustomDisplayModule$batchUpdate$2.INSTANCE);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "onUserOffline");
        this.e.dispose();
    }

    public final void onUserOnline(f0c.h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "onUserOnline");
        if (w4c.c.a().Q() == true) goto L8;
        this.e = new CompositeDisposable();
        if (w4c.c.a().A() == false) goto L9;
        b(0);
        long r0 = w4c.c.a().f();
        Disposable r4 = Observable.interval(r0, r0, TimeUnit.SECONDS).subscribe(new com.ss.android.lark.conditional.access.display.b(this));
        this.e.add(r4);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single v5(String r5) {
        Intrinsics.checkNotNullParameter("fixed:advanced_login:geo_restricted", "displayKey");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "getDisplayModelByRust, displayKey is fixed:advanced_login:geo_restricted");
        String r2 = qqb.a.d();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "traceId");     // Catch: Throwable -> L7
        qqb.a.g(r5);     // Catch: Throwable -> L7
        CustomDisplayModelByKeyRequest.Builder r6 = new CustomDisplayModelByKeyRequest.Builder();     // Catch: Throwable -> L7
        r6.key = "fixed:advanced_login:geo_restricted";     // Catch: Throwable -> L7
        Single r7 = this.b.c(r6).map(com.ss.android.lark.conditional.access.display.a.a);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        return r7;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        throw th;
    L9:
        th = th;
        r2 = BuildConfig.FLAVOR;
        goto L11
    }

    public static final void a(CustomDisplayModule r6, List r7) {
        r6.getClass();
        if ((!r7.isEmpty()) == false) goto L11;
        i r0 = r6.c;
        String r8 = r6.c();
        List r9 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r1.add(new CustomDisplayModel((CustomDisplayConfig) r10.next(), System.currentTimeMillis()));
        goto L6
    L8:
        r0.a(r8, r1);
        return;
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<? extends CustomDisplayConfig> Ld(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "getDisplayModelByRust, id is " + r4);
        String r2 = qqb.a.d();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "traceId");     // Catch: Throwable -> L7
        qqb.a.g(r5);     // Catch: Throwable -> L7
        CustomDisplayModelRequest.Builder r6 = new CustomDisplayModelRequest.Builder();     // Catch: Throwable -> L7
        r6.id = r4;     // Catch: Throwable -> L7
        Single<? extends CustomDisplayConfig> r7 = this.b.d(r6).map(b.a);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        return r7;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        qqb.a.g(r2);
        throw th;
    L9:
        th = th;
        r2 = BuildConfig.FLAVOR;
        goto L11
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final void S5(List<String> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "ids");
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "tryUpdateDisplayModelByIds, ids is " + r9 + ",  force is " + r10);
        if (w4c.c.a().Q() == false) goto L5;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "tryUpdateDisplayModelByIds, direct return");
    L5:
        if (r10 == true) goto L21;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r9.iterator();
    L8:
        if (r12.hasNext() == false) goto L19;
        Object r1 = r12.next();
        CustomDisplayModel r2 = this.c.b(c(), (String) r1);
        if (r2 == null) goto L12;
        long r3 = r2.getLastUpdateTime();
    L14:
        if ((r3 + (w4c.c.a().f() * ((long) 1000))) >= System.currentTimeMillis()) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L8;
        r11.add(r1);
        goto L8
    L16:
        r4 = false;
        goto L17
    L12:
        r3 = 0;
        goto L14
    L19:
        r9 = r11;
    L21:
        if (r9.isEmpty() == false) goto L24;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "tryUpdateDisplayModelByIds, needUpdateIds.isEmpty().");
        return;
    L24:
        CustomDisplayMGetRequest.Builder r13 = new CustomDisplayMGetRequest.Builder();
        r13.id_list = r9;
        r13.locale = c();
        t4c.a.b(this.b.b(r13).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()), this.e, new CustomDisplayModule$tryUpdateDisplayModelByIds$2(this), CustomDisplayModule$tryUpdateDisplayModelByIds$3.INSTANCE);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<CustomDisplayModel> ye(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "traceId");
        String r1 = qqb.a.d();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r11, "traceId");     // Catch: Throwable -> L17
        qqb.a.g(r11);     // Catch: Throwable -> L17
        CustomDisplayModel r12 = this.c.b(c(), r10);     // Catch: Throwable -> L17
        if (r12 != null) goto L8;
        FileAuthMonitor.UpdateTrigger[] r13 = FileAuthMonitor.a;     // Catch: Throwable -> L17
        String r14 = u4c.a.a;     // Catch: Throwable -> L17
        u4c.a.a("scs_security_policy_custom_display", MapsKt.mapOf(TuplesKt.to("hitCache", Boolean.FALSE)), null, null, 0, 28);     // Catch: Throwable -> L17
        CustomDisplayMGetRequest.Builder r15 = new CustomDisplayMGetRequest.Builder();     // Catch: Throwable -> L17
        r15.id_list = CollectionsKt.listOf(r10);     // Catch: Throwable -> L17
        r15.locale = c();     // Catch: Throwable -> L17
        Single<CustomDisplayModel> r16 = this.b.b(r15).doOnSuccess(new c(this)).flatMap(new d(r10));     // Catch: Throwable -> L17
    L15:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        qqb.a.g(r1);
        return r16;
    L8:
        if ((r12.getLastUpdateTime() + (w4c.c.a().f() * ((long) 1000))) >= System.currentTimeMillis()) goto L14;
        CustomDisplayConfig r17 = r12.getConfig();     // Catch: Throwable -> L17
        if (r17 == null) goto L14;
        String r18 = r17.id;     // Catch: Throwable -> L17
        if (r18 == null) goto L14;
        S5(CollectionsKt.listOf(r18), true);     // Catch: Throwable -> L17
    L14:
        FileAuthMonitor.UpdateTrigger[] r19 = FileAuthMonitor.a;     // Catch: Throwable -> L17
        String r110 = u4c.a.a;     // Catch: Throwable -> L17
        u4c.a.a("scs_security_policy_custom_display", MapsKt.mapOf(TuplesKt.to("hitCache", Boolean.TRUE)), null, null, 0, 28);     // Catch: Throwable -> L17
        r16 = Single.just(r12);     // Catch: Throwable -> L17
    L17:
        th = th;
    L23:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        qqb.a.g(r1);
        throw th;
    L21:
        th = th;
        r1 = BuildConfig.FLAVOR;
        goto L23
    }

    @Inject
    public CustomDisplayModule(m r2, h r3, i r4, apb.a r5) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "networkRepository");
        Intrinsics.checkNotNullParameter(r4, "storage");
        Intrinsics.checkNotNullParameter(r5, "languageService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        s.a(this);
        this.e = new CompositeDisposable();
    }
}
