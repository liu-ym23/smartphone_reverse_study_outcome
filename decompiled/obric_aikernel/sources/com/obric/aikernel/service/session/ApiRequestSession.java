package com.obric.aikernel.service.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.res.update.ApiTimeoutCancellationException;
import com.obric.aikernel.sdk.config.RequestParams;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes2.dex */
public final class ApiRequestSession {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f5534j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f5537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<RequestParams> f5538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference<CoroutineContext> f5539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<a> f5540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f5542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f5543i;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ ApiRequestSession d(Companion r10, RequestParams r11, CoroutineContext r12, a r13, Long r14, int r15, Object r16) {
            if ((r15 & 4) == 0) goto L6;
            r14 = null;
        L6:
            return r10.c(r11, r12, r13, r14);
        }

        public final String a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "reqId");
            Intrinsics.checkNotNullParameter(r11, "clientId");
            return r10 + Typography.less + r11;
        }

        public final long b() {
            return AppSettingsManager.INSTANCE.getVmSettings().c() + VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        }

        public final ApiRequestSession c(final RequestParams r10, CoroutineContext r11, final a r12, Long r13) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "coroutineContext");
            Intrinsics.checkNotNullParameter(r12, "callback");
            AIKLog r14 = AIKLog.INSTANCE;
            StringBuilder r15 = new StringBuilder();
            r15.append("startSession ");
            v1.b r16 = v1.f10723e;
            r15.append(r11.get(r16));
            r15.append(" id:");
            r15.append(a(r10.getTraceIdStr(), r10.getClientId()));
            r14.d("ClientSessionService", r15.toString());
            v1 r17 = (v1) r11.get(r16);
            if (r17 == null) goto L6;
            r17.A(new ApiRequestSession$Companion$startSession$1(r10, r12));
        L6:
            return new ApiRequestSession(r10.getClientId(), r10.getTraceIdStr(), r13, new WeakReference(r10), new WeakReference(r11), new WeakReference(r12));
        }
    }

    public static final class a implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f5544c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final RequestParams f5545g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Function1<Bundle, Unit> f5546h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f5547i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f5548j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f5549k;

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r10, RequestParams r11, Function1<? super Bundle, Unit> r12) {
            Intrinsics.checkNotNullParameter(r10, "origin");
            Intrinsics.checkNotNullParameter(r11, "params");
            this.f5544c = r10;
            this.f5545g = r11;
            this.f5546h = r12;
        }

        public /* synthetic */ a(b r10, RequestParams r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 4) == 0) goto L5;
            r12 = null;
        L5:
            this(r10, r11, r12);
        }

        public final boolean U0() {
            return this.f5548j;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IBinder r10 = this.f5544c.asBinder();
            Intrinsics.checkNotNullExpressionValue(r10, "origin.asBinder()");
            return r10;
        }

        public final void f2(String r10) {
            this.f5547i = r10;
        }

        @Override // com.obric.aikernel.b
        public void j2(Bundle r10) {
            monitor-enter(this);
            Boolean r11 = null;
            String r12 = null;
            if (this.f5548j == false) goto L15;
            AIKLog r13 = AIKLog.INSTANCE;     // Catch: Throwable -> L39
            StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L39
            r14.append("callback finished session ");     // Catch: Throwable -> L39
            r14.append(this.f5547i);     // Catch: Throwable -> L39
            r14.append(", ");     // Catch: Throwable -> L39
            if (r10 == null) goto L8;
            Boolean r15 = Boolean.valueOf(r10.getBoolean(IdlKeys.IsFinish));     // Catch: Throwable -> L39
        L9:
            r14.append(r15);     // Catch: Throwable -> L39
            r14.append(", ");     // Catch: Throwable -> L39
            if (r10 == null) goto L12;
            r12 = e8.a.h(r10);     // Catch: Throwable -> L39
        L12:
            r14.append(r12);     // Catch: Throwable -> L39
            r14.append(", ");     // Catch: Throwable -> L39
            r14.append(e8.a.f(r10));     // Catch: Throwable -> L39
            r13.w("ClientSessionService", r14.toString());     // Catch: Throwable -> L39
            monitor-exit(this);
            return;
        L8:
            r15 = null;
            goto L9
        L15:
            this.f5549k = SystemClock.elapsedRealtime();     // Catch: Throwable -> L39
            boolean r16 = true;
            boolean r17 = false;
            if (r10 != null) goto L18;
        L20:
            r16 = false;
        L21:
            if (r16 == false) goto L24;
            monitor-exit(this);
            return;
        L24:
            if (r10 == null) goto L26;
            r17 = r10.getBoolean(IdlKeys.IsFinish);     // Catch: Throwable -> L39
        L26:
            this.f5548j = r17;     // Catch: Throwable -> L39
            AIKLog r18 = AIKLog.INSTANCE;     // Catch: Throwable -> L39
            StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L39
            r19.append("callback session ");     // Catch: Throwable -> L39
            r19.append(this.f5547i);     // Catch: Throwable -> L39
            r19.append(" state:");     // Catch: Throwable -> L39
            r19.append(this.f5548j);     // Catch: Throwable -> L39
            r19.append('|');     // Catch: Throwable -> L39
            if (r10 == null) goto L29;
            r11 = Boolean.valueOf(r10.getBoolean(IdlKeys.IsFinish));     // Catch: Throwable -> L39
        L29:
            r19.append(r11);     // Catch: Throwable -> L39
            r19.append(", ");     // Catch: Throwable -> L39
            r19.append(this.f5549k);     // Catch: Throwable -> L39
            r18.i("ClientSessionService", r19.toString());     // Catch: Throwable -> L39
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L39
            monitor-exit(this);
            if (r10 == null) goto L35;
            Function1<Bundle, Unit> r21 = this.f5546h;
            if (r21 == null) goto L35;
            r21.invoke(r10);
        L35:
            if (r10 == null) goto L37;
            r10.putString("trace_id", this.f5545g.getTraceIdStr());
        L37:
            this.f5544c.j2(r10);
            return;
        L18:
            if (r10.getBoolean("_FkSignal", false) != true) goto L20;
        L39:
            th = move-exception;
            throw th;
        }

        public final long k1() {
            return this.f5549k;
        }
    }

    static {
        f5534j = new Companion(null);
    }

    public ApiRequestSession(String r18, String r19, Long r20, WeakReference<RequestParams> r21, WeakReference<CoroutineContext> r22, WeakReference<a> r23) {
        Long r10 = r20;
        Intrinsics.checkNotNullParameter(r18, "clientId");
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter(r22, "rootContext");
        Intrinsics.checkNotNullParameter(r23, "callback");
        this.f5535a = r18;
        this.f5536b = r19;
        this.f5537c = r10;
        this.f5538d = r21;
        this.f5539e = r22;
        this.f5540f = r23;
        Companion r11 = f5534j;
        String r12 = r11.a(r19, r18);
        this.f5541g = r12;
        long r13 = r11.b();
        RequestParams r14 = r21.get();
        boolean r15 = true;
        long r16 = 0;
        if (r14 == null) goto L13;
        Long r17 = Long.valueOf(r14.getTimeout());
        if (r17.longValue() <= 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == true) goto L11;
        r17 = null;
    L11:
        if (r17 == null) goto L13;
        long r111 = r17.longValue();
    L14:
        if (r10 != null) goto L16;
    L24:
        this.f5542h = Math.min(r111, r13);
        a r24 = r23.get();
        if (r24 == null) goto L28;
        r24.f2(r12);
    L28:
        RequestParams r25 = r21.get();
        if (r25 == null) goto L31;
        r16 = r25.getReqTime();
    L31:
        d(r16);
        return;
    L16:
        if (r20.longValue() > 0) goto L19;
        r15 = false;
    L19:
        if (r15 == true) goto L22;
        r10 = null;
    L22:
        if (r10 == null) goto L24;
        r13 = r10.longValue();
        goto L24
    L7:
        r110 = false;
    L13:
        r111 = r13;
        goto L14
    }

    public static final /* synthetic */ void a(ApiRequestSession r10, long r11) {
        r10.d(r11);
    }

    public static final /* synthetic */ WeakReference b(ApiRequestSession r10) {
        return r10.f5540f;
    }

    public static final /* synthetic */ long c(ApiRequestSession r10) {
        return r10.f5543i;
    }

    private final void d(long r10) {
        this.f5543i = this.f5542h + r10;
        AIKLog.INSTANCE.d("ClientSessionService", "session " + f5534j.a(this.f5536b, this.f5535a) + " timeoutMills refresh to " + this.f5543i + " < " + r10);
    }

    private static final long m(Lazy<Long> r10) {
        return r10.getValue().longValue();
    }

    public final String e() {
        return this.f5535a;
    }

    public final String f() {
        return this.f5541g;
    }

    public final String g() {
        return this.f5536b;
    }

    public final long h() {
        return this.f5542h;
    }

    public final boolean i() {
        a r10 = this.f5540f.get();
        if (r10 != null) goto L7;
        return true;
    L7:
        return r10.U0();
    }

    public final boolean j() {
        RequestParams r10 = this.f5538d.get();
        if (r10 == null) goto L7;
        Bundle r11 = r10.getBackend();
        if (r11 == null) goto L7;
        String r12 = e8.a.h(r11);
    L9:
        if (Intrinsics.areEqual(r12, IdlKeys.Method_RunBiz) == false) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        k();
    L14:
        return r13;
    L11:
        r13 = l();
    L7:
        r12 = null;
        goto L9
    }

    public final void k() {
        CoroutineContext r10 = this.f5539e.get();
        if (r10 == null) goto L5;
        y1.c(r10, new ApiTimeoutCancellationException(this.f5541g, this.f5542h));
    L5:
        a r11 = this.f5540f.get();
        boolean r12 = false;
        if (r11 != null) goto L8;
    L10:
        if (r12 == false) goto L29;
        StringBuilder r13 = new StringBuilder();
        r13.append("session ");
        r13.append(this.f5541g);
        r13.append(" released, method: ");
        RequestParams r14 = this.f5538d.get();
        Long r15 = null;
        if (r14 == null) goto L16;
        Bundle r16 = r14.getBackend();
        if (r16 == null) goto L16;
        String r17 = e8.a.h(r16);
    L17:
        r13.append(r17);
        r13.append(", Timeout info:[");
        r13.append(SystemClock.elapsedRealtime());
        r13.append(" < ");
        r13.append(this.f5543i);
        r13.append('|');
        RequestParams r18 = this.f5538d.get();
        if (r18 == null) goto L20;
        Long r19 = Long.valueOf(r18.getReqTime());
    L21:
        r13.append(r19);
        r13.append('+');
        r13.append(this.f5542h);
        r13.append('(');
        RequestParams r20 = this.f5538d.get();
        if (r20 == null) goto L24;
        r15 = Long.valueOf(r20.getTimeout());
    L24:
        r13.append(r15);
        r13.append('-');
        r13.append(this.f5537c);
        r13.append(")]");
        String r21 = r13.toString();
        a r22 = this.f5540f.get();
        if (r22 == null) goto L27;
        e8.a.c(r22, 107, r21);
    L27:
        AIKLog.INSTANCE.i("ClientSessionService", r21);
        return;
    L20:
        r19 = null;
    L16:
        r17 = null;
        goto L17
    L29:
        return;
    L8:
        if (r11.U0() == true) goto L10;
        r12 = true;
        goto L10
    }

    public final boolean l() {
        Lazy r10 = LazyKt.lazy(new ApiRequestSession$shouldRelease$targetMills$2(this));
        a r11 = this.f5540f.get();
        if (r11 == null) goto L5;
        boolean r12 = r11.U0();
    L6:
        if (r12 == false) goto L8;
        return true;
    L8:
        if (SystemClock.elapsedRealtime() >= m(r10)) goto L13;
        return false;
    L13:
        return true;
    L5:
        r12 = true;
        goto L6
    }
}
