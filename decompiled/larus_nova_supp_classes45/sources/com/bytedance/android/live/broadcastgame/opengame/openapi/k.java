package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudConstant$Method;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudResultType$ClientResultType;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudSPHelper;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends BaseOpenMethod<n> {
    public static final /* synthetic */ int i = 0;
    public final CloudExecutor h;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ k a;

        public b(k r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            n r8 = (n) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            Lazy r0 = CloudSPHelper.a;
            if (CloudSPHelper.c(this.a.h.c) == true) goto L5;
        L8:
            k.t(this.a, r8);
        L10:
            return Unit.INSTANCE;
        L5:
            if (CloudSPHelper.b(this.a.h.c) > (System.currentTimeMillis() / ((long) 1000))) goto L8;
            ALogger.i("CloudCallContainerMethod_call", "sid expired, start to refresh");
            this.a.h.e(new m(this, r8));
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ k a;

        public d(k r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            k r0 = this.a;
            k.s(r0, (Throwable) r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "callContainer";
    }

    public static final void s(k r7, Throwable r8) {
        r7.getClass();
        ALogger.i("CloudCallContainerMethod_onResponseFailed", r8.toString());
        if ((r8 instanceof TimeoutException) == false) goto L5;
        r7.n(OpenApiErrorInfo.NET_REQUEST_TIMEOUT, null);
        return;
    L5:
        CloudResultType$ClientResultType r0 = CloudResultType$ClientResultType.NetworkError;
        int r2 = r0.getErrNo();
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        BaseOpenMethod.p(r7, r2, String.format(r0.getErrMsg(), Arrays.copyOf(new Object[]{o1.a(r8), Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8))}, 2)), null, 12);
    }

    public static final void t(final k r17, n r18) {
        r17.getClass();
        final long r2 = System.currentTimeMillis();
        ALogger.i("CloudCallContainerMethod_realCall", "call container start");
        com.bytedance.android.live.broadcastgame.opengame.cloud.f r4 = r17.h.d();
        CloudConstant$Method r6 = CloudConstant$Method.POST;
        LinkedHashMap r8 = new LinkedHashMap();
        Map<String, String> r0 = r18.c();
        if (r0 == null) goto L5;
        r8.putAll(r0);
    L5:
        int r1 = com.bytedance.android.live.broadcastgame.opengame.cloud.i.a;
        Pair[] r9 = new Pair[7];
        int r11 = 0;
        r9[0] = TuplesKt.to("X-TT-ENVID", r18.b());
        r9[1] = TuplesKt.to("X-TT-SERVICEID", r18.f());
        r9[2] = TuplesKt.to("X-TT-PATH", r18.e());
        CloudConstant$Method.a r3 = CloudConstant$Method.Companion;
        String r13 = r18.d();
        Locale r14 = Locale.ROOT;
        if (r13 == null) goto L60;
        String r15 = r13.toUpperCase(r14);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r15, "value");
        CloudConstant$Method[] r5 = CloudConstant$Method.values();
        ArrayList r16 = new ArrayList();
        int r12 = r5.length;
    L8:
        if (r11 >= r12) goto L13;
        CloudConstant$Method r19 = r5[r11];
        CloudConstant$Method[] r110 = r5;
        if (Intrinsics.areEqual(r15, r19.name()) == false) goto L12;
        r16.add(r19);
    L12:
        r11 = r11 + 1;
        r5 = r110;
        goto L8
    L13:
        Object r111 = null;
        if ((!r16.isEmpty()) == true) goto L17;
        r16 = null;
    L17:
        if (r16 == null) goto L20;
        CloudConstant$Method r7 = (CloudConstant$Method) ListProtector.get(r16, 0);
        if (r7 == null) goto L20;
    L21:
        r9[3] = TuplesKt.to("X-TT-METHOD", r7.name());
        r9[4] = TuplesKt.to("X-TT-APPID", r17.h.c);
        int r21 = com.bytedance.android.live.broadcastgame.opengame.cloud.h.a;
        String r22 = r17.d.m.j;
        Intrinsics.checkNotNullParameter(r22, "appVersion");
        StringBuilder r112 = new StringBuilder();     // Catch: Exception -> L28
        String r113 = System.getProperty("http.agent");     // Catch: Exception -> L28
        if (r113 != null) goto L26;
        r113 = null;
    L26:
        r112.append(r113);     // Catch: Exception -> L28
        r112.append(" ");     // Catch: Exception -> L28
        r112.append(jc1.k.n(IHostContext.class).appName());     // Catch: Exception -> L28
        r112.append("/");     // Catch: Exception -> L28
        r112.append(jc1.k.n(IHostContext.class).getVersionCode());     // Catch: Exception -> L28
        r112.append(" ToutiaoMicroApp/");     // Catch: Exception -> L28
        r112.append((String) com.bytedance.android.livesdk.sharedpref.b.B2.getValue());     // Catch: Exception -> L28
        r112.append(" PluginVersion/");     // Catch: Exception -> L28
        r112.append(r22);     // Catch: Exception -> L28
        String r23 = r112.toString();     // Catch: Exception -> L28
    L30:
        r9[5] = TuplesKt.to("User-Agent", r23);
        int r24 = com.bytedance.android.live.broadcastgame.opengame.cloud.h.a;
        com.bytedance.android.live.broadcastgame.opengame.t r25 = r17.d.m;
        String r114 = r25.i;
        String r26 = r25.j;
        Intrinsics.checkNotNullParameter(r114, "appId");
        Intrinsics.checkNotNullParameter(r26, "appVersion");
        r9[6] = TuplesKt.to("Referer", "https://tmaservice.developer.toutiao.com?appid=" + r114 + "&version=" + r26);
        Map r27 = MapsKt.mapOf(r9);
        Intrinsics.checkNotNullParameter(r8, "$this$putAll");
        Intrinsics.checkNotNullParameter(r27, "from");
        Set r28 = r8.keySet();
        ArrayList r115 = new ArrayList();
        Iterator r29 = r28.iterator();
    L32:
        if (r29.hasNext() == false) goto L36;
        Object r116 = r29.next();
        if (com.bytedance.android.live.broadcastgame.opengame.cloud.i.a(r27, (String) r116) == false) goto L32;
        r115.add(r116);
        goto L32
    L36:
        Iterator r31 = r115.iterator();
    L38:
        if (r31.hasNext() == false) goto L40;
        r8.remove((String) r31.next());
        goto L38
    L40:
        r8.putAll(r27);
        if (com.bytedance.android.live.broadcastgame.opengame.cloud.i.a(r8, "Content-Type") == true) goto L43;
        r8.put("Content-Type", "application/json");
    L43:
        Lazy r32 = CloudSPHelper.a;
        if (CloudSPHelper.c(r17.h.c) == false) goto L49;
        String r33 = CloudSPHelper.a(r17.h.c);
        Intrinsics.checkNotNullParameter(r8, "$this$put");
        Intrinsics.checkNotNullParameter("X-TT-SID", "key");
        Intrinsics.checkNotNullParameter(r33, "value");
        if (com.bytedance.android.live.broadcastgame.opengame.cloud.i.a(r8, "X-TT-SID") == false) goto L48;
        r8.remove("X-TT-SID");
    L48:
        r8.put("X-TT-SID", r33);
    L49:
        IHostContext r34 = jc1.k.n(IHostContext.class);
        Map<String, String> r35 = MapsKt.mapOf(new Pair[]{TuplesKt.to("aid", String.valueOf(r34.appId())), TuplesKt.to("version_code", r34.getVersionCode()), TuplesKt.to("device_platform", r34.getDevicePlatform())});
        Object r36 = r18.a();
        if ((r36 instanceof String) == false) goto L53;
        r111 = r36;
    L53:
        String r117 = (String) r111;
        if (r117 == null) goto L56;
        byte[] r37 = r117.getBytes(Charsets.UTF_8);
    L57:
        r4.c("https://dycloud.volces.com", r6, "/api/gateway/service/v1/", r8, r35, r37, r18.g(), false, new CloudCallContainerMethod$realCall$1(r17, r2), new CloudCallContainerMethod$realCall$2(r17, r2));
        return;
    L56:
        r37 = "".getBytes(Charsets.UTF_8);
    L28:
        e = move-exception;
        ALogger.d("CloudNetworkUtil_getUserAgent", o1.a(e));
        r23 = "android";
    L20:
        r7 = CloudConstant$Method.GET;
        goto L21
    L60:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(n r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        j(Single.just(r2).subscribeOn(Schedulers.io()).map(new b(this)).subscribe(c.a, new d(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(n r1, CallContext r2) {
        call2(r1, r2);
    }

    public k(PluginContext r2, CloudExecutor r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "cloudExecutor");
        super(r2, r4);
        this.h = r3;
    }
}
