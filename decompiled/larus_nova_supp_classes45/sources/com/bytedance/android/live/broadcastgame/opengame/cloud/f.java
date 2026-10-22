package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public long a;
    public final ConcurrentHashMap<String, ICloudNetworkApi> b;
    public final /* synthetic */ i20.a c;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ u10.c a;

        public b(u10.c r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<HttpResponse> r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.onNext(this.a.a());     // Catch: Exception -> L5
        L10:
            r3.onComplete();
            return;
        L5:
            e = move-exception;
            if (r3.isDisposed() == true) goto L9;
            r3.onError(e);
            goto L10
        L9:
            ALogger.d("CloudNetworkExecutor", e.getMessage());
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ Function4 b;

        public c(f r1, Function4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            HttpResponse r8 = (HttpResponse) r7;
            StringBuilder r0 = new StringBuilder("network request success, statusCode = ");
            r0.append(r8.getStatusCode());
            r0.append(", reason = ");
            r0.append(r8.getReason());
            r0.append(", \nheader = ");
            r0.append(f.a(this.a, r8.getHeaders()));
            r0.append(", \nbody = ");
            byte[] r1 = r8.getBody();
            Charset r3 = Charsets.UTF_8;
            r0.append(new String(r1, r3));
            ALogger.i("CloudNetworkExecutor_doOnBuildRequest", r0.toString());
            this.b.invoke(Integer.valueOf(r8.getStatusCode()), r8.getReason(), f.a(this.a, r8.getHeaders()), new String(r8.getBody(), r3));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.i("CloudNetworkExecutor_doOnBuildRequest", "network request error: errMsg = " + o1.a(r4) + ", errNo = " + com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r4));
            this.a.invoke(r4);
        }
    }

    static {
    }

    public f() {
        this.c = new i20.a();
        this.a = 60000;
        this.b = new ConcurrentHashMap();
    }

    public static final JSONObject a(f r2, List r3) {
        r2.getClass();
        JSONObject r4 = new JSONObject();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        NameValuePair r0 = (NameValuePair) r5.next();
        r4.put(r0.getName(), r0.getValue());
        goto L4
    L6:
        return r4;
    }

    public final ICloudNetworkApi e(String r3, String r4, boolean r5) {
        ICloudNetworkApi r0 = this.b.get(r3 + r4);
        if (r0 != null) goto L9;
        if (r5 == false) goto L6;
        ICloudNetworkApi r6 = (ICloudNetworkApi) new RetrofitProvider().getRetrofitInstance(r3).create(ICloudNetworkApi.class);
    L7:
        ICloudNetworkApi r1 = r6;
        this.b.put(r3 + r4, r1);
        return r1;
    L6:
        r6 = (ICloudNetworkApi) RetrofitUtils.getSsRetrofit(r3).create(ICloudNetworkApi.class);
        goto L7
    L9:
        return r0;
    }

    public final void b(Call<?> r4, long r5, Function4<? super Integer, ? super String, ? super JSONObject, ? super String, Unit> r7, Function1<? super Throwable, Unit> r8) {
        u10.c r0 = new u10.c(r4);
        if (r5 <= 60000) goto L6;
        r5 = 60000;
    L8:
        Disposable r6 = Observable.create(new b(r0)).timeout(r5, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r7), new d(r8));
        Intrinsics.checkNotNullParameter(r6, "$this$autoDispose");
        this.c.a(r6);
        return;
    L6:
        if (r5 > 0) goto L8;
        r5 = this.a;
        goto L8
    }

    public static /* synthetic */ void d(f r12, String r13, CloudConstant$Method r14, String r15, Map r16, Map r17, Function4 r18, Function1 r19) {
        r12.c(r13, r14, r15, r16, r17, null, 0, true, r18, r19);
    }

    public final void c(String r19, CloudConstant$Method r21, String r22, Map<String, String> r23, Map<String, String> r24, byte[] r25, long r26, boolean r27, Function4<? super Integer, ? super String, ? super JSONObject, ? super String, Unit> r28, Function1<? super Throwable, Unit> r29) {
        String r0 = r19;
        Intrinsics.checkNotNullParameter(r0, "domain");
        Intrinsics.checkNotNullParameter(r21, "method");
        Intrinsics.checkNotNullParameter(r22, "relativeUrl");
        Intrinsics.checkNotNullParameter(r23, "headerMap");
        Intrinsics.checkNotNullParameter(r24, "queryMap");
        Intrinsics.checkNotNullParameter(r28, "onSuccess");
        Intrinsics.checkNotNullParameter(r29, "onError");
        ALogger.i("CloudNetworkExecutor_doRequest", "request start");     // Catch: Throwable -> L45
        int r2 = h.a;     // Catch: Throwable -> L45
        String r12 = new URL(r0).getHost();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r12, "$this$isRawIp");     // Catch: Throwable -> L45
        List r3 = StringsKt.split$default(r12, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L45
        if (r3.size() != 4) goto L17;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L45
    L8:
        if (r4.hasNext() == false) goto L18;
        int r13 = CastIntegerProtector.parseInt((String) r4.next());     // Catch: NumberFormatException -> L16 Throwable -> L45
        if (r13 < 0) goto L17;
        if (255 < r13) goto L17;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
    L23:
        if (r25 == null) goto L29;
        String r6 = r23.get("Content-Type");     // Catch: Throwable -> L45
        if (r6 != null) goto L27;
        r6 = "application/json";
    L27:
        TypedByteArray r14 = new TypedByteArray(r6, r25, new String[0]);     // Catch: Throwable -> L45
    L51:
        ICloudNetworkApi r1 = e(r0, r22, r27);     // Catch: Throwable -> L43
        switch(g.a[r21.ordinal()]) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            default: goto L42;
        };     // Catch: Throwable -> L43
    L34:
        Call<TypedInput> r7 = r1.doDelete(r27, Integer.MAX_VALUE, r22, r23, r24, r14);     // Catch: Throwable -> L43
    L40:
        ALogger.i("CloudNetworkExecutor_doRequest", "do request: url = " + r7.request().getUrl() + ", method = " + r7.request().getMethod() + ", headers = " + r7.request().getHeaders() + ", body = " + r7.request().getRequestBody());     // Catch: Throwable -> L43
        b(r7, r26, r28, r29);     // Catch: Throwable -> L43
        return;
    L35:
        r7 = r1.doOptions(r27, Integer.MAX_VALUE, r22, r23, r24, r14);     // Catch: Throwable -> L43
        goto L40
    L36:
        r7 = r1.doPut(r27, Integer.MAX_VALUE, r22, r23, r24, r14);     // Catch: Throwable -> L43
        goto L40
    L37:
        r7 = r1.doPost(r27, Integer.MAX_VALUE, r22, r23, r24, r14);     // Catch: Throwable -> L43
        goto L40
    L38:
        r7 = r1.doHead(r27, Integer.MAX_VALUE, r22, r23, r24);     // Catch: Throwable -> L43
        goto L40
    L39:
        r7 = r1.doGet(r27, Integer.MAX_VALUE, r22, r23, r24);     // Catch: Throwable -> L43
        goto L40
    L42:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L43
    L43:
        th = th;
    L47:
        r29.invoke(th);
        ALogger.e("CloudNetworkExecutor_doRequest", "onError", th);
        return;
    L29:
        r14 = new TypedByteArray("", new byte[0], new String[0]);     // Catch: Throwable -> L45
        goto L51
    L21:
        if (k.n(IHostContext.class).isBoe() == false) goto L23;
        r0 = r0 + ".boe-gateway.byted.org";     // Catch: Throwable -> L45
    L17:
        r5 = false;
    L45:
        th = th;
        goto L47
    }
}
