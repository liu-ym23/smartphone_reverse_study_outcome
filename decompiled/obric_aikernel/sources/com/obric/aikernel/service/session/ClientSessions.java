package com.obric.aikernel.service.session;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ClientSessions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f5556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, ApiRequestSession> f5557c;

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

    public ClientSessions(String r10) {
        Intrinsics.checkNotNullParameter(r10, "clientId");
        this.f5555a = r10;
        this.f5556b = m0.a(z0.b());
        this.f5557c = new ConcurrentHashMap();
    }

    public static final /* synthetic */ Map a(ClientSessions r10) {
        return r10.f5557c;
    }

    private final void g(String r10) {
        h.d(this.f5556b, null, null, new ClientSessions$monitorNewSession$1(this, r10, null), 3, null);
    }

    public final void b(ApiRequestSession r10) {
        Intrinsics.checkNotNullParameter(r10, "session");
        this.f5557c.put(r10.g(), r10);
        AIKLog.INSTANCE.v("ClientSessionService", "Client " + this.f5555a + " addSession " + r10.f());
        g(r10.g());
    }

    public final String c() {
        return this.f5555a;
    }

    public final ApiRequestSession d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reqId");
        return this.f5557c.get(r10);
    }

    public final Map<String, ApiRequestSession> e() {
        return this.f5557c;
    }

    public final boolean f() {
        Iterator<T> r10 = this.f5557c.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if ((!((ApiRequestSession) r11).i()) == false) goto L4;
    L9:
        if (r11 != null) goto L16;
        return false;
    L16:
        return true;
    L8:
        r11 = null;
        goto L9
    }

    public final boolean h() {
        Iterator<T> r10 = this.f5557c.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (((ApiRequestSession) r10.next()).j() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final void i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reqId");
        ApiRequestSession r11 = d(r10);
        if (r11 == null) goto L5;
        r11.k();
    L5:
        this.f5557c.remove(r10);
    }

    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reqId");
        ApiRequestSession r11 = d(r10);
        String r12 = null;
        if (r11 == null) goto L5;
        Boolean r13 = Boolean.valueOf(r11.l());
    L6:
        AIKLog r14 = AIKLog.INSTANCE;
        StringBuilder r15 = new StringBuilder();
        r15.append("Client ");
        r15.append(this.f5555a);
        r15.append(" tryReleaseSession ");
        if (r11 == null) goto L9;
        r12 = r11.f();
    L9:
        r15.append(r12);
        r15.append(" release:");
        r15.append(r13);
        r14.i("ClientSessionService", r15.toString());
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == true) goto L13;
        i(r10);
        return;
    L13:
        return;
    L5:
        r13 = null;
        goto L6
    }
}
