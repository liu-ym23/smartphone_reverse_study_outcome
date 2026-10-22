package com.obric.aikernel.service.session;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.service.b;
import com.obric.aikernel.service.session.inr.InferNotResponseHandler;
import com.obric.aikernel.service.session.inr.IoThreadWatchdog;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import s7.e;
import s7.i;

/* JADX INFO: loaded from: classes2.dex */
public final class ClientSessionService implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, ClientSessions> f5550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IoThreadWatchdog f5551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InferNotResponseHandler f5552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v1 f5553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5554e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public ClientSessionService() {
        this.f5550a = new ConcurrentHashMap();
        IoThreadWatchdog r10 = new IoThreadWatchdog();
        this.f5551b = r10;
        this.f5554e = i.f12731a.a();
        e.a("vm_controller_configs", new AnonymousClass1(this));
        r10.f();
    }

    public static final /* synthetic */ long d(ClientSessionService r10) {
        return r10.f5554e;
    }

    public static final /* synthetic */ Map e(ClientSessionService r10) {
        return r10.f5550a;
    }

    public static final /* synthetic */ InferNotResponseHandler f(ClientSessionService r10) {
        return r10.f5552c;
    }

    public static final /* synthetic */ void g(ClientSessionService r10, long r11) {
        r10.f5554e = r11;
    }

    public static final /* synthetic */ void h(ClientSessionService r10, InferNotResponseHandler r11) {
        r10.f5552c = r11;
    }

    @Override // com.obric.aikernel.service.b
    public void a(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "requestParams");
        AIKLog.INSTANCE.d("ClientSessionService", "handle event:" + r10.getEvent() + ", req:" + ApiRequestSession.f5534j.a(r10.getTraceIdStr(), r10.getClientId()));
        int r11 = r10.getEvent();
        if (r11 != 1) goto L5;
        ClientSessions r12 = this.f5550a.get(r10.getClientId());
        if (r12 == null) goto L18;
        r12.i(r10.getTraceIdStr());
        return;
    L18:
        return;
    L5:
        if (r11 != 2) goto L7;
    L9:
        ClientSessions r13 = this.f5550a.get(r10.getClientId());
        if (r13 == null) goto L16;
        r13.j(r10.getTraceIdStr());
        return;
    L16:
        return;
    L7:
        if (r11 == 3) goto L9;
    }

    @Override // com.obric.aikernel.service.b
    public int b() {
        return 2;
    }

    @Override // com.obric.aikernel.service.b
    public void c(FileDescriptor r10, PrintWriter r11, List<String> r12) {
        b.a.a(this, r10, r11, r12);
    }

    public final void i(ApiRequestSession r10) {
        Intrinsics.checkNotNullParameter(r10, "session");
        Map<String, ClientSessions> r11 = this.f5550a;
        String r12 = r10.e();
        ClientSessions r13 = r11.get(r12);
        if (r13 != null) goto L5;
        r13 = new ClientSessions(r10.e());
        r11.put(r12, r13);
    L5:
        r13.b(r10);
    }

    public final ApiRequestSession j(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r10.getClientId().length() <= 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L12;
        ClientSessions r12 = this.f5550a.get(r10.getClientId());
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.d(r10.getTraceIdStr());
    L12:
        return null;
    L5:
        r11 = false;
        goto L7
    }

    public final void k(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        ApiRequestSession r11 = j(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.i() == true) goto L11;
        InferNotResponseHandler r12 = this.f5552c;
        if (r12 == null) goto L12;
        r12.j(r10);
        return;
    L12:
        return;
    }

    public final boolean l() {
        Iterator<T> r10 = this.f5550a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Map.Entry r11 = (Map.Entry) r10.next();
        boolean r12 = ((ClientSessions) r11.getValue()).h();
        AIKLog.INSTANCE.d("ClientSessionService", ((String) r11.getKey()) + " processInr " + r12);
        if (r12 == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final synchronized void m() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f5553d != null) goto L6;
        this.f5553d = h.d(m0.a(z0.b()), null, null, new ClientSessionService$scheduleRestart$1(this, null), 3, null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // com.obric.aikernel.service.b
    public String name() {
        return "session";
    }
}
