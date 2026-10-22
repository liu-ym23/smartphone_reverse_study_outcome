package com.bytedance.android.live.revenue.platform.network.dynamic;

import com.bytedance.android.live.base.annotation.SkipLivePBCheck;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.base.model.message.c3;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService;
import com.bytedance.android.live.revenue.platform.network.api.RegisterMessageType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParser;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DynamicHostNetworkServiceImpl implements IDynamicHostNetworkService, dy0.c, o {
    public final Lazy a;
    public final String b;
    public final MultiLinkFrequencyOptConfig c;
    public final com.bytedance.android.livesdk.revenue.service.network.a d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001Jj\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072$\b\u0001\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\n2$\b\u0001\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\nH'J\u0090\u0001\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072$\b\u0001\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\n2$\b\u0001\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\n2$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\nH'Jt\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072$\b\u0001\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\n2$\b\u0001\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\n2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/dynamic/DynamicHostNetworkServiceImpl$NetworkApi;", "", "get", "Lio/reactivex/Single;", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "path", "", "queryMap", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "headers", "postForm", "fieldMap", "postJson", "jsonBody", "Lcom/google/gson/JsonElement;", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface NetworkApi {
        @SkipLivePBCheck
        @GET
        Single<SsResponse<TypedInput>> get(@Url String r1, @QueryMap Map<String, String> r2, @HeaderMap Map<String, String> r3);

        @FormUrlEncoded
        @POST
        @SkipLivePBCheck
        Single<SsResponse<TypedInput>> postForm(@Url String r1, @QueryMap Map<String, String> r2, @HeaderMap Map<String, String> r3, @FieldMap Map<String, String> r4);

        @POST
        @SkipLivePBCheck
        Single<SsResponse<TypedInput>> postJson(@Url String r1, @QueryMap Map<String, String> r2, @HeaderMap Map<String, String> r3, @Body JsonElement r4);
    }

    public static final class a<T, R> implements Function {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
            IDynamicHostNetworkService.d r0 = new IDynamicHostNetworkService.d();
            if ((r3 instanceof c3) == false) goto L6;
            byte[] r4 = ((c3) r3).getRawPayload();
        L16:
            r0.b(r4);
            return r0;
        L6:
            if ((r3 instanceof t) == false) goto L9;
            r4 = ((t) r3).getRawPayload();
            goto L16
        L9:
            if ((r3 instanceof com.ss.ugc.live.sdk.message.wrsc.data.a) == false) goto L19;
            ByteString r5 = ((com.ss.ugc.live.sdk.message.wrsc.data.a) r3).d;
            if (r5 == null) goto L15;
            r4 = r5.toByteArray();
            if (r4 != null) goto L16;
        L15:
            r4 = new byte[0];
            goto L16
        L19:
            throw new IllegalStateException(("unsupported msg: " + r3 + ", " + this.a).toString());
        }
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            IDynamicHostNetworkService.d r3 = (IDynamicHostNetworkService.d) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.a() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ Disposable a;

        public c(Disposable r1) {
            this.a = r1;
        }

        public final void run() {
            if (this.a.isDisposed() == true) goto L6;
            this.a.dispose();
            return;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ Disposable a;

        public d(Disposable r1) {
            this.a = r1;
        }

        public final void run() {
            if (((Boolean) l.b.getValue(null, l.a[0])).booleanValue() == true) goto L5;
            return;
        L5:
            if (this.a.isDisposed() == true) goto L9;
            this.a.dispose();
            return;
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r7) {
            SsResponse r8 = (SsResponse) r7;
            Intrinsics.checkNotNullParameter(r8, "httpResponse");
            TypedInput r0 = r8.raw().getBody();
            byte[] r1 = ByteStreamsKt.readBytes(r0.in());
            if (Intrinsics.areEqual(r0.mimeType(), "application/x-protobuf") == false) goto L5;
            Pair r2 = TuplesKt.to(IDynamicHostNetworkService.ContentType.PROTOBUF, r1);
        L6:
            IDynamicHostNetworkService.ContentType r3 = (IDynamicHostNetworkService.ContentType) r2.component1();
            Object r4 = r2.component2();
            IDynamicHostNetworkService.b r5 = new IDynamicHostNetworkService.b();
            r5.f(r8.code());
            List r9 = r8.headers();
            LinkedHashMap r6 = new LinkedHashMap();
            Iterator<T> r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L10;
            Header r12 = (Header) r10.next();
            Pair r13 = TuplesKt.to(r12.getName(), r12.getValue());
            r6.put(r13.getFirst(), r13.getSecond());
            goto L8
        L10:
            r5.e(r6);
            IDynamicHostNetworkService.b.a r14 = new IDynamicHostNetworkService.b.a();
            r14.d(r3.ordinal());
            r14.c(r4);
            Unit r15 = Unit.INSTANCE;
            r5.d(r14);
            return r5;
        L5:
            IDynamicHostNetworkService.ContentType r16 = IDynamicHostNetworkService.ContentType.JSON;
            String r17 = new String(r1, Charsets.UTF_8);
            r2 = TuplesKt.to(r16, GsonProtectorUtils.parse(new JsonParser(), r17));
            goto L6
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r6) {
            NetworkErrorException r7 = (Throwable) r6;
            Intrinsics.checkNotNullParameter(r7, "throwable");
            if ((r7 instanceof NetworkErrorException) == false) goto L31;
            Throwable r0 = r7.getCause();
            Object r2 = null;
            if ((r0 instanceof CronetIOException) == true) goto L7;
            r0 = null;
        L7:
            CronetIOException r1 = (CronetIOException) r0;
            IDynamicHostNetworkService.b r3 = new IDynamicHostNetworkService.b();
            r3.f(r7.statusCode);
            if (r1 == null) goto L35;
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L17
            BaseHttpRequestInfo r9 = r1.getRequestInfo();     // Catch: Throwable -> L17
            if (r9 == null) goto L14;
            String r10 = r9.responseHeaders;     // Catch: Throwable -> L17
            if (r10 == null) goto L14;
            JSONObject r4 = new JSONObject(r10);     // Catch: Throwable -> L17
        L15:
            Object r12 = Result.constructor-impl(r4);     // Catch: Throwable -> L17
        L20:
            if (Result.isFailure-impl(r12) == true) goto L23;
            r2 = r12;
        L23:
            JSONObject r5 = (JSONObject) r2;
            if (r5 == null) goto L35;
            Iterator<String> r13 = r5.keys();
        L27:
            if (r13.hasNext() == false) goto L35;
            String r14 = r13.next();
            r3.b().put(r14, JSONObjectProtectorUtils.getString(r5, r14));
        L14:
            r4 = null;
        L17:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
        L35:
            return Single.just(r3);
        L31:
            return Single.error(r7);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public DynamicHostNetworkServiceImpl(com.bytedance.android.livesdk.revenue.service.network.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hostNetworkService");
        this.d = r2;
        this.a = LazyKt.lazy(new DynamicHostNetworkServiceImpl$networkApi$2(this));
        this.b = "DynamicHostNetworkServiceImpl";
        this.c = (MultiLinkFrequencyOptConfig) v2.a.getValue();
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService
    public final Observable<IDynamicHostNetworkService.d> registerMessage(i57.a r7, final String r8, Boolean r9, final String r10, Integer r12) {
        Intrinsics.checkNotNullParameter(r7, "aioCallContext");
        Intrinsics.checkNotNullParameter(r8, "method");
        vh6.c.b(zh6.c.class).i1(r8);
        com.bytedance.android.scope.j r13 = (com.bytedance.android.scope.j) r7.a(i57.e.f.b());
        if (r13 != null) goto L7;
        return Observable.error(com.bytedance.platform.aio.d.d("webcast.revenue.biz.foundation.NetworkService.registerMessage"));
    L7:
        if (com.bytedance.android.scope.l.b(r13) == false) goto L9;
        final BehaviorSubject r0 = BehaviorSubject.create();
        final Function1<Object, Unit> r1 = new DynamicHostNetworkServiceImpl$registerMessage$listener$1(this, r8, r0);
        m.e.getClass();
        final yz0.i r2 = (yz0.i) m.b(r13).a(Reflection.getOrCreateKotlinClass(yz0.i.class));
        if (r2 == null) goto L13;
        int r14 = RegisterMessageType.ByteLink.getType();
        if (r12 == null) goto L23;
        if (r14 != r12.intValue()) goto L23;
        if (((Boolean) l.c.getValue(null, l.a[1])).booleanValue() == false) goto L23;
        final com.bytedance.android.live.revenue.platform.network.dynamic.a r15 = new com.bytedance.android.live.revenue.platform.network.dynamic.a(r1);
        r2.Lk(new DynamicHostNetworkServiceImpl$registerByteLinkListener$1(r8, r15));
        Disposable r16 = Disposables.fromAction(new DynamicHostNetworkServiceImpl$registerByteLinkListener$2(r2, r8, r15));
    L36:
        return r0.map(new a(r8)).filter(b.a).doAfterTerminate(new c(r16)).doOnDispose(new d(r16));
    L23:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L31;
        int r17 = RegisterMessageType.WRDS.getType();
        if (r12 != null) goto L28;
    L30:
        final com.bytedance.android.live.revenue.platform.network.dynamic.b r18 = new com.bytedance.android.live.revenue.platform.network.dynamic.b(r1);
        r2.ra(new DynamicHostNetworkServiceImpl$registerSimpleListener$1(r8, r18));
        r16 = Disposables.fromAction(new DynamicHostNetworkServiceImpl$registerSimpleListener$2(r2, r8, r18));
        goto L36
    L28:
        if (r17 != r12.intValue()) goto L30;
    L31:
        ALogger.i("DynamicCenterWrds", "registerWRDSListener: " + r8 + ", wrdsSubkey: " + r10);
        if (StringsKt.endsWith$default(r8, "SyncData", false, 2, null) == false) goto L34;
        final CompositeDisposable r19 = new CompositeDisposable();
        PublishProcessor r20 = new PublishProcessor();
        com.bytedance.revenue.platform.api.core.rx.f.a(r20.onBackpressureLatest().groupBy(i.a).flatMap(new com.bytedance.android.live.revenue.platform.network.dynamic.d(this, r1)).subscribe(new com.bytedance.android.live.revenue.platform.network.dynamic.e(r1)), r19);
        PublishSubject r110 = PublishSubject.create();
        com.bytedance.revenue.platform.api.core.rx.f.a(r110.subscribe(new com.bytedance.android.live.revenue.platform.network.dynamic.f(r1)), r19);
        final k r111 = new k(r8);
        final g r3 = new g(this, r20, r110);
        r2.pe(new DynamicHostNetworkServiceImpl$registerWRDSListener$1(r111, r1, r3));
        r16 = Disposables.fromAction(new DynamicHostNetworkServiceImpl$registerWRDSListener$2(r2, r111, r3, r19));
        goto L36
    L34:
        final h r22 = new h(r10, r1);
        r2.ra(new DynamicHostNetworkServiceImpl$registerWRDSListener$3(r8, r22, r10));
        r16 = Disposables.fromAction(new DynamicHostNetworkServiceImpl$registerWRDSListener$4(r2, r8, r22));
        goto L36
    L13:
        return Observable.error(new IllegalStateException("IMessageManagerUsable not found, scope: " + r13 + ", isEntered: " + com.bytedance.android.scope.l.b(r13)));
    L9:
        return Observable.error(com.bytedance.platform.aio.d.c("webcast.revenue.biz.foundation.NetworkService.registerMessage"));
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService
    public final Single<IDynamicHostNetworkService.b> requestHttp(String r3, String r4, Map<String, String> r5, Map<String, String> r6, int r7, IDynamicHostNetworkService.c r8, IDynamicHostNetworkService.a r9) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "method");
        if (r5 != null) goto L5;
        r5 = MapsKt.emptyMap();
    L5:
        if (r6 != null) goto L8;
        r6 = MapsKt.emptyMap();
    L8:
        if (r7 != IDynamicHostNetworkService.ContentType.PROTOBUF.ordinal()) goto L10;
        r6 = MapsKt.toMutableMap(r6);
        r6.put("response-format", "protobuf");
    L10:
        String r10 = r4.toLowerCase();
        int r0 = r10.hashCode();
        if (r0 == 102230) goto L27;
        if (r0 != 3446944) goto L32;
        if (r10.equals("post") == false) goto L32;
        if (r9 == null) goto L18;
        Single<SsResponse<TypedInput>> r12 = ((NetworkApi) this.a.getValue()).postForm(r3, r5, r6, r9.getContent());
    L30:
        return r12.subscribeOn(Schedulers.io()).map(e.a).onErrorResumeNext(f.a);
    L18:
        NetworkApi r13 = (NetworkApi) this.a.getValue();
        if (r8 == null) goto L24;
        String r14 = r8.getContent();
        if (r14 == null) goto L24;
        JsonElement r15 = GsonProtectorUtils.parse(new JsonParser(), r14);
        if (r15 == null) goto L24;
    L25:
        r12 = r13.postJson(r3, r5, r6, r15);
    L24:
        r15 = JsonNull.INSTANCE;
    L32:
        throw new IllegalStateException("unsupported http method: ".concat(r4).toString());
    L27:
        if (r10.equals("get") == false) goto L32;
        r12 = ((NetworkApi) this.a.getValue()).get(r3, r5, r6);
        goto L30
    }
}
