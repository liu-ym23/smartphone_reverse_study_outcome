package com.obric.aikernel.service.session.inr;

import android.os.Process;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.multiproc.d;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.service.session.ClientSessionService;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class InferNotResponseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClientSessionService f5558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f5559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v1 f5561d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InferNotResponseHandler f5562a;

        b(InferNotResponseHandler r10) {
            this.f5562a = r10;
        }

        @Override // com.obric.aikernel.middleware.api.appcontext.receiver.e.a
        public void a() {
            v1 r10 = InferNotResponseHandler.a(this.f5562a);
            if (r10 == null) goto L5;
            r10.c(new CancellationException("screen is on, stop process inr event."));
        L5:
            InferNotResponseHandler.e(this.f5562a, null);
        }

        @Override // com.obric.aikernel.middleware.api.appcontext.receiver.e.a
        public void b() {
            InferNotResponseHandler.d(this.f5562a);
        }
    }

    static {
        new a(null);
    }

    public InferNotResponseHandler(ClientSessionService r10) {
        Intrinsics.checkNotNullParameter(r10, "service");
        this.f5558a = r10;
        this.f5559b = new b(this);
    }

    public static final /* synthetic */ v1 a(InferNotResponseHandler r10) {
        return r10.f5561d;
    }

    public static final /* synthetic */ ClientSessionService b(InferNotResponseHandler r10) {
        return r10.f5558a;
    }

    public static final /* synthetic */ void c(InferNotResponseHandler r10) {
        r10.i();
    }

    public static final /* synthetic */ void d(InferNotResponseHandler r10) {
        r10.k();
    }

    public static final /* synthetic */ void e(InferNotResponseHandler r10, v1 r11) {
        r10.f5561d = r11;
    }

    public static final /* synthetic */ void f(InferNotResponseHandler r10, RequestParams r11) {
        r10.l(r11);
    }

    private final void i() {
        Process.killProcess(Process.myPid());
    }

    private final void k() {
        if (this.f5560c == true) goto L5;
        return;
    L5:
        if (this.f5561d != null) goto L9;
        this.f5561d = h.d(m0.a(new k0("InrProcessor").plus(z0.b())), null, null, new InferNotResponseHandler$processInr$1(this, null), 3, null);
        return;
    }

    private final void l(RequestParams r10) {
        JSONObject r11 = new JSONObject();
        r11.put("caller", e8.a.j(r10.getBackend()));
        r11.put(ITrackerApi.CALLER_PKG, e8.a.j(r10.getBackend()));
        r11.put("biz", e8.a.e(r10.getBackend()));
        r11.put(EnsureReportData.METHOD, e8.a.h(r10.getBackend()));
        r11.put("sdk_ver", e8.a.k(r10.getBackend()));
        r11.put("inr_interval", AppSettingsManager.INSTANCE.getVmSettings().c());
        r11.put("trace_id", e8.a.d(r10.getBackend()));
        Ensure.ensureNotReachHere(r11.toString());
    }

    public final void g() {
        e.f4540a.f(this.f5559b);
        this.f5560c = false;
    }

    public final void h() {
        e.f4540a.a(this.f5559b);
        this.f5560c = false;
    }

    public final void j(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        this.f5560c = true;
        h.d(m0.a(new k0("InrStat").plus(z0.b())), null, null, new InferNotResponseHandler$onInferNotResponseEvent$1(this, r10, null), 3, null);
        if (e.f4540a.d() == false) goto L8;
        d r11 = d.f4707a;
        if (r11.b() != null) goto L7;
        return;
    L7:
        if (r11.f() == true) goto L8;
        return;
    L8:
        k();
    }
}
