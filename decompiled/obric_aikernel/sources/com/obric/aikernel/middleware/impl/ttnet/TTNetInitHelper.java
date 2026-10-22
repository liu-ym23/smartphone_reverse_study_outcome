package com.obric.aikernel.middleware.impl.ttnet;

import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.g;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.retrofit2.a0;
import com.bytedance.retrofit2.t;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.middleware.api.ttnet.ITTNetInitHelper;
import com.obric.aikernel.res.utils.MemoryUtils;
import com.obric.aikernel.utils.k;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import o2.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class TTNetInitHelper implements ITTNetInitHelper {
    public static final a Companion = null;
    private static final String STATIC_DEBUG_PPE = null;
    private static final String TAG = "TTNetInitHelper";
    private static final boolean isBoe = false;
    private final f.d<a5.b> sApiProcessHook;
    private final f.l<a5.b> sMonitorProcessHook;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements f.d<a5.b> {
        b() {
        }

        @Override // o2.f.d
        public String a(String r10, boolean r11, Object... r12) {
            Intrinsics.checkNotNullParameter(r10, "url");
            Intrinsics.checkNotNullParameter(r12, WsConstants.KEY_EXTRA);
            return r10;
        }

        @Override // o2.f.d
        public /* bridge */ /* synthetic */ void b(String r10, Throwable r11, long r12, o2.b r13) {
            f(r10, r11, r12, (a5.b) r13);
        }

        @Override // o2.f.d
        public /* bridge */ /* synthetic */ void c(String r10, long r11, o2.b r12) {
            g(r10, r11, (a5.b) r12);
        }

        @Override // o2.f.d
        public String d(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "url");
            String r12 = com.bytedance.applog.a.b(AppContext.INSTANCE.getContext(), r10, r11, Level.L1);
            Intrinsics.checkNotNullExpressionValue(r12, "after");
            boolean r13 = false;
            if (StringsKt.contains$default(r12, "soc_model=", false, 2, null) == true) goto L9;
            k r14 = k.f5601a;
            if (r14.a().length() <= 0) goto L7;
            r13 = true;
        L7:
            if (r13 == false) goto L9;
            r12 = r12 + "&soc_model=" + r14.a() + "&mem_size=" + MemoryUtils.f5219a.c();
        L9:
            Intrinsics.checkNotNullExpressionValue(r12, "after");
            return r12;
        }

        @Override // o2.f.d
        public void e() {
            AIKLog.INSTANCE.i(TTNetInitHelper.TAG, "onTryInit " + Thread.currentThread());
            if (AppContext.INSTANCE.getServerDeviceId().length() != 0) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L14;
            new CountDownLatch(1).await(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L14:
            return;
        L5:
            r10 = false;
            goto L6
        }

        public void f(String r10, Throwable r11, long r12, a5.b r13) {
            Intrinsics.checkNotNullParameter(r10, "url");
            Intrinsics.checkNotNullParameter(r11, "e");
        }

        public void g(String r10, long r11, a5.b r12) {
            Intrinsics.checkNotNullParameter(r10, "url");
        }
    }

    public static final class c implements f.l<a5.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TTNetInitHelper f4619a;

        c(TTNetInitHelper r10) {
            this.f4619a = r10;
        }

        @Override // o2.f.l
        public /* bridge */ /* synthetic */ void a(long r10, long r11, String r12, String r13, o2.b r14, Throwable r15) {
            c(r10, r11, r12, r13, (a5.b) r14, r15);
        }

        @Override // o2.f.l
        public /* bridge */ /* synthetic */ void b(long r10, long r11, String r12, String r13, o2.b r14) {
            d(r10, r11, r12, r13, (a5.b) r14);
        }

        public void c(long r18, long r20, String r22, String r23, a5.b r24, Throwable r25) {
            if (AppContext.INSTANCE.isAdminMode() == false) goto L35;
            TTNetInitHelper.access$monitorHttpRequest(this.f4619a, NotificationCompat.CATEGORY_ERROR, r24, r18);
        L35:
            String[] r13 = new String[1];     // Catch: Throwable -> L32
            int r14 = com.obric.aikernel.middleware.impl.ttnet.a.a(r25, r13);     // Catch: Throwable -> L32
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L32
            if (r25 == null) goto L23;
            if (g.b(r25.getClass().getName()) == true) goto L23;
            r15.put("ex_name", r25.getClass().getName());     // Catch: Throwable -> L32
            if (r14 != 1) goto L15;
            if (ApmDelegate.j().k("ex_message_open") == false) goto L15;
        L16:
            String r10 = com.bytedance.ttnet.utils.d.c(r25);     // Catch: Throwable -> L32
            if (g.b(r10) == true) goto L19;
            r15.put("ex_message", r10);     // Catch: Throwable -> L32
        L19:
            String r11 = com.bytedance.ttnet.c.a();     // Catch: Throwable -> L32
            if (g.b(r11) == true) goto L23;
            r15.put("cronet_init_ex_message", r11);     // Catch: Throwable -> L32
        L15:
            if (ApmDelegate.j().k("debug_ex_message_open") == true) goto L16;
        L23:
            if (g.b(r13[0]) == false) goto L28;
            if (r24 == null) goto L26;
            String r12 = r24.f11397d;     // Catch: Throwable -> L32
        L27:
            r13[0] = r12;     // Catch: Throwable -> L32
            goto L28
        L26:
            r12 = null;
        L28:
            TTNetInitHelper.access$packageRequestParamters(this.f4619a, r24, r15);     // Catch: Throwable -> L32
            com.bytedance.apm.c.d(r18, r20, r22, r13[0], r23, r14, r15);     // Catch: Throwable -> L32
            com.bytedance.apm.c.k(r18, r20, r22, r13[0], r23, r14, r15);     // Catch: Throwable -> L32
            if (r22 == null) goto L37;
            Uri r16 = Uri.parse(r22);     // Catch: Throwable -> L32
            AIKLog.INSTANCE.i(TTNetInitHelper.TAG, "monitorApiError host: " + r16.getHost() + " path: " + r16.getPath() + "  logId: " + r23 + "\n\tduration: " + r18 + " remoteIp: " + r13[0] + "\n\tThrowable: " + r25 + "\n\tjsonObject: " + r15);     // Catch: Throwable -> L32
            return;
        L37:
            return;
        L32:
            th = move-exception;
            AIKLog.INSTANCE.e(TTNetInitHelper.TAG, "monitorApiError : " + ExceptionsKt.stackTraceToString(th));
        }

        public void d(long r16, long r18, String r20, String r21, a5.b r22) {
            if (AppContext.INSTANCE.isAdminMode() == false) goto L19;
            TTNetInitHelper.access$monitorHttpRequest(this.f4619a, "ok", r22, r16);
        L19:
            String[] r12 = new String[1];     // Catch: Throwable -> L16
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L16
            if (g.b(r12[0]) == false) goto L12;
            if (r22 == null) goto L10;
            String r10 = r22.f11397d;     // Catch: Throwable -> L16
        L11:
            r12[0] = r10;     // Catch: Throwable -> L16
            goto L12
        L10:
            r10 = null;
        L12:
            TTNetInitHelper.access$packageRequestParamters(this.f4619a, r22, r13);     // Catch: Throwable -> L16
            com.bytedance.apm.c.k(r16, r18, r20, r12[0], r21, 200, r13);     // Catch: Throwable -> L16
            if (r20 == null) goto L21;
            Uri r11 = Uri.parse(r20);     // Catch: Throwable -> L16
            AIKLog.INSTANCE.i(TTNetInitHelper.TAG, "monitorApiOK host: " + r11.getHost() + " path: " + r11.getPath() + " logId: " + r21 + "\n\tduration: " + r16 + " remoteIp: " + r12[0] + " sendTime: " + r18 + ", info:" + r13);     // Catch: Throwable -> L16
            return;
        L21:
            return;
        L16:
            th = move-exception;
            AIKLog.INSTANCE.e(TTNetInitHelper.TAG, "monitorApiOk : " + ExceptionsKt.stackTraceToString(th));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.ttnet.TTNetInitHelper$monitorHttpRequest$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.middleware.impl.ttnet.TTNetInitHelper$monitorHttpRequest$1", f = "TTNetInitHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $event;
        final /* synthetic */ String $host;
        final /* synthetic */ String $path;
        int label;

        AnonymousClass1(String r10, String r11, String r12, Continuation<? super AnonymousClass1> r13) {
            this.$event = r10;
            this.$host = r11;
            this.$path = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$event, this.$host, this.$path, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            TrackerApi r11 = TrackerApi.INSTANCE;
            JSONObject r12 = new JSONObject();
            String r13 = this.$event;
            String r14 = this.$host;
            String r15 = this.$path;
            r12.put(NotificationCompat.CATEGORY_EVENT, r13);
            r12.put("host", r14);
            r12.put("path", r15);
            Unit r16 = Unit.INSTANCE;
            r11.onEvent("net_request", r12);
            return r16;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public TTNetInitHelper() {
        this.sMonitorProcessHook = new c(this);
        this.sApiProcessHook = new b();
    }

    public static /* synthetic */ a0 a(q4.a.InterfaceC0283a r10) {
        return initRetrofit$lambda$0(r10);
    }

    public static final /* synthetic */ String access$getSTATIC_DEBUG_PPE$cp() {
        return STATIC_DEBUG_PPE;
    }

    public static final /* synthetic */ void access$monitorHttpRequest(TTNetInitHelper r10, String r11, a5.b r12, long r13) {
        r10.monitorHttpRequest(r11, r12, r13);
    }

    public static final /* synthetic */ void access$monitorHttpRequest(TTNetInitHelper r10, String r11, String r12, String r13) {
        r10.monitorHttpRequest(r11, r12, r13);
    }

    public static final /* synthetic */ void access$packageRequestParamters(TTNetInitHelper r10, a5.b r11, JSONObject r12) {
        r10.packageRequestParamters(r11, r12);
    }

    private final void initRetrofit() {
        RetrofitUtils.a(d.f4623c);
    }

    private static final a0 initRetrofit$lambda$0(q4.a.InterfaceC0283a r10) {
        n4.c r11 = r10.a();
        a5.d r12 = new a5.d();
        r12.f11422c = 15000;
        r12.f11423d = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        r12.f11424e = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        r12.f11425f = 15000;
        r12.f11427h = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        r12.f11426g = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        r12.f11428i = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        r11.R(r12);
        return r10.c(r11);
    }

    private final void monitorHttpRequest(String r10, a5.b r11, long r12) {
        long r13 = e.f4540a.g();
        if (r13 <= 0) goto L25;
        TrackerApi r14 = TrackerApi.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put(NotificationCompat.CATEGORY_EVENT, r10);
        Long r16 = null;
        if (r11 == null) goto L9;
        URL r17 = r11.f11394a;
        if (r17 == null) goto L9;
        String r18 = r17.getHost();
    L10:
        r15.put("host", r18);
        if (r11 == null) goto L15;
        URL r19 = r11.f11394a;
        if (r19 == null) goto L15;
        String r20 = r19.getPath();
    L16:
        r15.put("path", r20);
        if (r11 == null) goto L19;
        Long r21 = Long.valueOf(r11.f11415v);
    L20:
        r15.put("sent_count", r21);
        if (r11 == null) goto L23;
        r16 = Long.valueOf(r11.f11416w);
    L23:
        r15.put("recv_count", r16);
        r15.put("off_dur", r13);
        r15.put("dur", r12);
        Unit r22 = Unit.INSTANCE;
        r14.onEvent("net_request", r15);
        return;
    L19:
        r21 = null;
    L15:
        r20 = null;
    L9:
        r18 = null;
        goto L10
    }

    private final void monitorHttpRequest(String r10, String r11, String r12) {
        if (e.f4540a.g() <= 0) goto L6;
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(r10, r11, r12, null), 3, null);
        return;
    }

    private final void packageRequestParamters(a5.b r10, JSONObject r11) {
        if (r10 == null) goto L18;
        if (r11 == null) goto L19;
        r11.put("cronet_plugin_install", TTNetInit.getTTNetDepend().g());     // Catch: JSONException -> L13
        r11.put("appLevelRequestStart", r10.f11399f);     // Catch: JSONException -> L13
        r11.put("beforeAllInterceptors", r10.f11400g);     // Catch: JSONException -> L13
        r11.put("requestStart", r10.f11401h);     // Catch: JSONException -> L13
        r11.put("responseBack", r10.f11402i);     // Catch: JSONException -> L13
        r11.put("completeReadResponse", r10.f11404k);     // Catch: JSONException -> L13
        r11.put("requestEnd", r10.f11405l);     // Catch: JSONException -> L13
        r11.put("recycleCount", r10.f11406m);     // Catch: JSONException -> L13
        if (r10.f11417x != 0) goto L8;
        r11.put("timing_dns", r10.f11407n);     // Catch: JSONException -> L13
        r11.put("timing_connect", r10.f11408o);     // Catch: JSONException -> L13
        r11.put("timing_ssl", r10.f11409p);     // Catch: JSONException -> L13
        r11.put("timing_send", r10.f11410q);     // Catch: JSONException -> L13
        r11.put("timing_waiting", r10.f11413t);     // Catch: JSONException -> L13
        r11.put("timing_receive", r10.f11411r);     // Catch: JSONException -> L13
        r11.put("timing_total", r10.f11414u);     // Catch: JSONException -> L13
        r11.put("timing_isSocketReused", r10.f11412s);     // Catch: JSONException -> L13
        r11.put("timing_totalSendBytes", r10.f11415v);     // Catch: JSONException -> L13
        r11.put("timing_totalReceivedBytes", r10.f11416w);     // Catch: JSONException -> L13
        r11.put("timing_remoteIP", r10.f11397d);     // Catch: JSONException -> L13
        r11.put(ICronetClient.KEY_REQUEST_LOG, r10.A);     // Catch: JSONException -> L13
    L8:
        JSONObject r12 = r10.B;     // Catch: JSONException -> L13
        if (r12 == null) goto L11;
        r11.put("req_info", r12);     // Catch: JSONException -> L13
    L11:
        r11.put("streaming", r10.C);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "packageRequestParamters : " + ExceptionsKt.stackTraceToString(e));
        return;
    L19:
        return;
    }

    @Override // com.obric.aikernel.middleware.api.ttnet.ITTNetInitHelper
    public void initTTNet() {
        Log.i(TAG, "initTTNet : " + Thread.currentThread());     // Catch: Throwable -> L5
        initRetrofit();     // Catch: Throwable -> L5
        com.obric.aikernel.middleware.impl.ttnet.b.f4621a.a();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new com.obric.aikernel.middleware.impl.ttnet.c());     // Catch: Throwable -> L5
        Log.i(TAG, "initTTNet 22 : " + Thread.currentThread());     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(new com.obric.aikernel.middleware.impl.ttnet.b());     // Catch: Throwable -> L5
        AppContext r10 = AppContext.INSTANCE;     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r10.getContext(), r10.getApplication(), this.sApiProcessHook, this.sMonitorProcessHook, null, true, new boolean[0]);     // Catch: Throwable -> L5
        Log.i(TAG, "initTTNet 33 : " + Thread.currentThread());     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        Log.i(TAG, "initTTNet 44 : " + Thread.currentThread());     // Catch: Throwable -> L5
        com.obric.aikernel.api.b.f4431a.j().a();     // Catch: Throwable -> L5
        Log.i(TAG, "initTTNet 55 : " + Thread.currentThread());     // Catch: Throwable -> L5
    L7:
        com.bytedance.common.utility.e.g(new p1.a());
        t.s(new CopyOnWriteArrayList(new q4.a[]{new TTNetInitHelper$initTTNet$interceptor$1(this)}));
        return;
    L5:
        th = move-exception;
        AIKLog.INSTANCE.e(TAG, "initTTNet : " + ExceptionsKt.stackTraceToString(th));
        goto L7
    }

    public final String replaceKey(String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r15, "key");
        Intrinsics.checkNotNullParameter(r16, "content");
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L20
        int r12 = StringsKt.indexOf$default(r14, r15 + '=', 0, false, 6, null);     // Catch: Throwable -> L20
        if (r12 != (-1)) goto L6;
        String r13 = r14 + Typography.amp + r15 + '=' + r16;     // Catch: Throwable -> L20
    L18:
        Object r17 = Result.m32constructorimpl(r13);     // Catch: Throwable -> L20
    L22:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L26;
        AIKLog.INSTANCE.e(TAG, "replaceKey failed, src: " + r14 + "\n " + r18);
    L26:
        if (Result.m38isFailureimpl(r17) == true) goto L29;
        r10 = r17;
    L29:
        String r19 = (String) r10;
        if (r19 != null) goto L33;
        return r14;
    L33:
        return r19;
    L6:
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L20
        boolean r111 = false;
        String r20 = r14.substring(0, r12);     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r20, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Throwable -> L20
        r110.append(r20);     // Catch: Throwable -> L20
        r110.append(r15);     // Catch: Throwable -> L20
        r110.append('=');     // Catch: Throwable -> L20
        r110.append(r16);     // Catch: Throwable -> L20
        Integer r21 = Integer.valueOf(StringsKt.indexOf$default(r14, "&", r12, false, 4, null));     // Catch: Throwable -> L20
        if (r21.intValue() < 0) goto L10;
        r111 = true;
    L10:
        if (Boolean.valueOf(r111).booleanValue() == true) goto L13;
        r21 = null;
    L13:
        if (r21 == null) goto L16;
        String r22 = r14.substring(r21.intValue());     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L20
        if (r22 == null) goto L16;
    L17:
        r110.append(r22);     // Catch: Throwable -> L20
        r13 = r110.toString();     // Catch: Throwable -> L20
    L16:
        r22 = "";
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
