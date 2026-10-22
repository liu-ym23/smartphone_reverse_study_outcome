package ty0;

import com.bytedance.android.live.revenue.platform.container.impl.z;
import com.bytedance.android.scope.o;
import com.bytedance.platform.aio.channel.RpcException;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ty0.d, o {
    public final CompositeDisposable a;
    public final com.bytedance.android.live.revenue.platform.container.impl.b b;
    public final com.bytedance.android.live.revenue.platform.container.impl.core.g c;

    /* JADX INFO: renamed from: ty0.a$a, reason: collision with other inner class name */
    public static final class C0320a<T, R> implements Function {
        public static final C0320a a = null;

        static {
            a = new C0320a();
        }

        public C0320a() {
        }

        public final Object apply(Object r4) {
            Long r5 = (Long) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            ty0.c r0 = new ty0.c();
            r0.a("greeting: myName " + r5);
            return r0;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4) {
            Long r5 = (Long) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            ty0.c r0 = new ty0.c();
            r0.a("greeting: myName " + r5);
            return r0;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r4) {
            Long r5 = (Long) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            ty0.c r0 = new ty0.c();
            r0.a("greeting: myName " + r5);
            return r0;
        }
    }

    public static final class d<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$d$a, reason: collision with other inner class name */
        public static final class C0321a<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public C0321a(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Unit r4 = (Unit) r3;
                this.a.onError(com.bytedance.platform.aio.d.b("expect biz_error, received success", null));
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r6) {
                Throwable r7 = (Throwable) r6;
                boolean r0 = r7 instanceof RpcException;
                if (r0 == true) goto L5;
                Throwable r2 = null;
            L6:
                RpcException r3 = (RpcException) r2;
                if (r3 == null) goto L9;
                String r4 = r3.getRpcCategory();
            L11:
                if (Intrinsics.areEqual(r4, "biz_error") == false) goto L13;
                this.a.onSuccess(Unit.INSTANCE);
                return;
            L13:
                SingleEmitter r5 = this.a;
                StringBuilder r8 = new StringBuilder("rpcCategory is ");
                if (r0 == true) goto L16;
                r7 = null;
            L16:
                RpcException r9 = (RpcException) r7;
                if (r9 == null) goto L19;
                String r10 = r9.getRpcCategory();
            L20:
                r8.append(r10);
                r8.append(", expect biz_error");
                r5.onError(com.bytedance.platform.aio.d.b(r8.toString(), null));
                return;
            L19:
                r10 = null;
                goto L20
            L9:
                r4 = null;
                goto L11
            L5:
                r2 = r7;
                goto L6
            }
        }

        public d(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            com.bytedance.revenue.platform.api.core.rx.f.a(((ty0.e) ny0.a.C0280a.a(this.a.b, Reflection.getOrCreateKotlinClass(ty0.e.class))).dynamicHelloThrowBizError().subscribe(new C0321a(r4), new b(r4)), this.a.a);
        }
    }

    public static final class e<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$e$a, reason: collision with other inner class name */
        public static final class C0322a<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public C0322a(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                ty0.b r3 = (ty0.b) r2;
                this.a.onSuccess(Unit.INSTANCE);
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                SingleEmitter r0 = this.a;
                r0.onError((Throwable) r2);
            }
        }

        public e(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            com.bytedance.revenue.platform.api.core.rx.f.a(((ty0.e) ny0.a.C0280a.a(this.a.b, Reflection.getOrCreateKotlinClass(ty0.e.class))).dynamicHello("native").subscribe(new C0322a(r4), new b(r4)), this.a.a);
        }
    }

    public static final class f<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$f$a, reason: collision with other inner class name */
        public static final class C0323a<T> implements Consumer {
            public final /* synthetic */ Ref.IntRef a;
            public final /* synthetic */ SingleEmitter b;

            public C0323a(Ref.IntRef r1, SingleEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r2) {
                ty0.b r3 = (ty0.b) r2;
                Ref.IntRef r4 = this.a;
                int r0 = r4.element + 1;
                r4.element = r0;
                if (r0 != 3) goto L6;
                this.b.onSuccess(Unit.INSTANCE);
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                SingleEmitter r0 = this.a;
                r0.onError((Throwable) r2);
            }
        }

        public static final class c implements Action {
            public final /* synthetic */ Ref.IntRef a;
            public final /* synthetic */ SingleEmitter b;

            public c(Ref.IntRef r1, SingleEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void run() {
                if (this.a.element >= 3) goto L6;
                this.b.onError(com.bytedance.platform.aio.d.b("count < 3 when complete", null));
                return;
            }
        }

        public f(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r6) {
            Intrinsics.checkNotNullParameter(r6, "emitter");
            Ref.IntRef r0 = new Ref.IntRef();
            r0.element = 0;
            com.bytedance.revenue.platform.api.core.rx.f.a(((ty0.e) ny0.a.C0280a.a(this.a.b, Reflection.getOrCreateKotlinClass(ty0.e.class))).dynamicHelloStream("native").subscribe(new C0323a(r0, r6), new b(r6), new c(r0, r6)), this.a.a);
        }
    }

    public static final class g<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$g$a, reason: collision with other inner class name */
        public static final class C0324a<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public C0324a(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Unit r4 = (Unit) r3;
                this.a.onError(com.bytedance.platform.aio.d.b("expect no_such_method, received success", null));
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r6) {
                Throwable r7 = (Throwable) r6;
                boolean r0 = r7 instanceof RpcException;
                if (r0 == true) goto L5;
                Throwable r2 = null;
            L6:
                RpcException r3 = (RpcException) r2;
                if (r3 == null) goto L9;
                String r4 = r3.getRpcCategory();
            L11:
                if (Intrinsics.areEqual(r4, "no_such_method") == false) goto L13;
                this.a.onSuccess(Unit.INSTANCE);
                return;
            L13:
                SingleEmitter r5 = this.a;
                StringBuilder r8 = new StringBuilder("rpcCategory is ");
                if (r0 == true) goto L16;
                r7 = null;
            L16:
                RpcException r9 = (RpcException) r7;
                if (r9 == null) goto L19;
                String r10 = r9.getRpcCategory();
            L20:
                r8.append(r10);
                r8.append(", expect no_such_method");
                r5.onError(com.bytedance.platform.aio.d.b(r8.toString(), null));
                return;
            L19:
                r10 = null;
                goto L20
            L9:
                r4 = null;
                goto L11
            L5:
                r2 = r7;
                goto L6
            }
        }

        public g(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r7) {
            Intrinsics.checkNotNullParameter(r7, "emitter");
            com.bytedance.android.live.revenue.platform.container.impl.core.g r0 = this.a.c;
            com.bytedance.android.live.revenue.platform.container.impl.core.g.D0.getClass();
            com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.platform.container.impl.core.g.b.a(r0, com.bytedance.android.live.revenue.platform.container.impl.core.g.a.b, "webcast.revenue.biz.demo.DynamicDemoService", "1919810", new z(new JsonObject(), System.currentTimeMillis())).subscribe(new C0324a(r7), new b(r7)), this.a.a);
        }
    }

    public static final class h<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$h$a, reason: collision with other inner class name */
        public static final class C0325a<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public C0325a(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Unit r4 = (Unit) r3;
                this.a.onError(com.bytedance.platform.aio.d.b("expect no_such_service, received success", null));
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r6) {
                Throwable r7 = (Throwable) r6;
                boolean r0 = r7 instanceof RpcException;
                if (r0 == true) goto L5;
                Throwable r2 = null;
            L6:
                RpcException r3 = (RpcException) r2;
                if (r3 == null) goto L9;
                String r4 = r3.getRpcCategory();
            L11:
                if (Intrinsics.areEqual(r4, "no_such_service") == false) goto L13;
                this.a.onSuccess(Unit.INSTANCE);
                return;
            L13:
                SingleEmitter r5 = this.a;
                StringBuilder r8 = new StringBuilder("rpcCategory is ");
                if (r0 == true) goto L16;
                r7 = null;
            L16:
                RpcException r9 = (RpcException) r7;
                if (r9 == null) goto L19;
                String r10 = r9.getRpcCategory();
            L20:
                r8.append(r10);
                r8.append(", expect no_such_service");
                r5.onError(com.bytedance.platform.aio.d.b(r8.toString(), null));
                return;
            L19:
                r10 = null;
                goto L20
            L9:
                r4 = null;
                goto L11
            L5:
                r2 = r7;
                goto L6
            }
        }

        public h(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r7) {
            Intrinsics.checkNotNullParameter(r7, "emitter");
            com.bytedance.android.live.revenue.platform.container.impl.core.g r0 = this.a.c;
            com.bytedance.android.live.revenue.platform.container.impl.core.g.D0.getClass();
            com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.platform.container.impl.core.g.b.a(r0, com.bytedance.android.live.revenue.platform.container.impl.core.g.a.b, "webcast.fake.114514", "1919810", new z(new JsonObject(), System.currentTimeMillis())).subscribe(new C0325a(r7), new b(r7)), this.a.a);
        }
    }

    public static final class i<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$i$a, reason: collision with other inner class name */
        public static final class C0326a<T, R> implements Function {
            public static final C0326a a = null;

            static {
                a = new C0326a();
            }

            public C0326a() {
            }

            public final Object apply(Object r2) {
                ty0.b r3 = (ty0.b) r2;
                Intrinsics.checkNotNullParameter(r3, "it");
                ty0.c r0 = new ty0.c();
                r0.a(r3.a());
                return r0;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                ty0.c r2 = (ty0.c) r1;
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public c(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                SingleEmitter r0 = this.a;
                r0.onError((Throwable) r2);
            }
        }

        public static final class d implements Action {
            public final /* synthetic */ SingleEmitter a;

            public d(SingleEmitter r1) {
                this.a = r1;
            }

            public final void run() {
                this.a.onSuccess(Unit.INSTANCE);
            }
        }

        public i(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            com.bytedance.revenue.platform.api.core.rx.f.a(((ty0.e) ny0.a.C0280a.a(this.a.b, Reflection.getOrCreateKotlinClass(ty0.e.class))).dynamicHelloStreamActiveClose().map(C0326a.a).subscribe(b.a, new c(r5), new d(r5)), this.a.a);
        }
    }

    public static final class j<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: ty0.a$j$a, reason: collision with other inner class name */
        public static final class C0327a<T> implements Consumer {
            public static final C0327a a = null;

            static {
                a = new C0327a();
            }

            public C0327a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                ty0.b r2 = (ty0.b) r1;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                SingleEmitter r0 = this.a;
                r0.onError((Throwable) r2);
            }
        }

        public static final class c implements Action {
            public final /* synthetic */ SingleEmitter a;

            public c(SingleEmitter r1) {
                this.a = r1;
            }

            public final void run() {
                this.a.onSuccess(Unit.INSTANCE);
            }
        }

        public j(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            com.bytedance.revenue.platform.api.core.rx.f.a(((ty0.e) ny0.a.C0280a.a(this.a.b, Reflection.getOrCreateKotlinClass(ty0.e.class))).dynamicHelloStreamPassiveClose().take(4).subscribe(C0327a.a, new b(r5), new c(r5)), this.a.a);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // ty0.d
    public final Observable<ty0.c> helloStreamActiveClose() {
        return Observable.interval(5, TimeUnit.SECONDS).map(b.a);
    }

    @Override // ty0.d
    public final Observable<ty0.c> helloStreamPassiveClose() {
        return Observable.interval(5, TimeUnit.SECONDS).map(c.a).take(3);
    }

    @Override // ty0.d
    public final void helloThrowBizError() {
        throw com.bytedance.platform.aio.d.b("fake biz exception", null);
    }

    @Override // ty0.d
    public final Single<Unit> helloThrowInternalError() {
        return Single.error(com.bytedance.platform.aio.d.e("fake framework exception", null));
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerBizError() {
        return Single.create(new d(this));
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerHello() {
        return Single.create(new e(this));
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerHelloStream() {
        return Single.create(new f(this));
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerNoSuchMethod() {
        return Single.create(new g(this));
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerNoSuchService() {
        return Single.create(new h(this));
    }

    @Override // ty0.d
    public final ty0.c hello(String r2) {
        Intrinsics.checkNotNullParameter(r2, "myName");
        ty0.c r3 = new ty0.c();
        r3.a("greeting: myName");
        return r3;
    }

    @Override // ty0.d
    public final Observable<ty0.c> helloStream(String r3) {
        Intrinsics.checkNotNullParameter(r3, "myName");
        return Observable.interval(5, TimeUnit.SECONDS).map(C0320a.a);
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerStreamActiveClose(String r2) {
        Intrinsics.checkNotNullParameter(r2, "myName");
        return Single.create(new i(this));
    }

    @Override // ty0.d
    public final Single<Unit> nativeTriggerStreamPassiveClose(String r2) {
        Intrinsics.checkNotNullParameter(r2, "myName");
        return Single.create(new j(this));
    }

    public a(com.bytedance.android.live.revenue.platform.container.impl.b r2, com.bytedance.android.live.revenue.platform.container.impl.core.g r3) {
        Intrinsics.checkNotNullParameter(r2, "rpcService");
        Intrinsics.checkNotNullParameter(r3, "centerService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
