package com.obric.aikernel.api.impl.security;

import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.ttnet.TTNetInit;
import com.obric.aikernel.api.security.TlsBootstrapState;
import com.obric.aikernel.api.security.e;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricTlsImpl extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f4460e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f4461f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f4462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile TlsBootstrapState f4463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile r0<Boolean> f4464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l0 f4465d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        String[] r10 = {"ofa.oceancloudapi.com", "ofa.obriccloud.com"};
        f4460e = r10;
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(ReportConsts.HTTPS + r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        f4461f = CollectionsKt.toSet(r11);
    }

    public ObricTlsImpl() {
        this.f4463b = TlsBootstrapState.IDLE;
        this.f4465d = m0.a(q2.b(null, 1, null).plus(z0.b()));
    }

    public static final /* synthetic */ void e(ObricTlsImpl r10) {
        r10.l();
    }

    public static final /* synthetic */ r0 f(ObricTlsImpl r10) {
        return r10.f4464c;
    }

    public static final /* synthetic */ TlsBootstrapState g(ObricTlsImpl r10) {
        return r10.f4463b;
    }

    public static final /* synthetic */ boolean h(ObricTlsImpl r10) {
        return r10.f4462a;
    }

    public static final /* synthetic */ void i(ObricTlsImpl r10, r0 r11) {
        r10.f4464c = r11;
    }

    public static final /* synthetic */ void j(ObricTlsImpl r10, TlsBootstrapState r11) {
        r10.f4463b = r11;
    }

    public static final /* synthetic */ Object k(ObricTlsImpl r10, Continuation r11) {
        return r10.m(r11);
    }

    private final void l() {
        String[] r10 = f4460e;
        b.a r11 = b.a.d();
        X509Certificate r12 = r11.b("SYSTEM_Device_TLS_cert").get(0);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r12, "keyManagerRef.getCertChain(certType)[0]");     // Catch: Throwable -> L9
        X509Certificate r13 = r12;     // Catch: Throwable -> L9
        if (r11.g("SYSTEM_Device_TLS_pkey") == false) goto L6;
        TTNetInit.addClientOpaqueDataV1(AppContext.INSTANCE.getApplication(), r10, r13.getEncoded(), null, r11.a(), r11.c("SYSTEM_Device_TLS_pkey"));     // Catch: Throwable -> L9
    L7:
        this.f4462a = true;     // Catch: Throwable -> L9
        this.f4463b = TlsBootstrapState.READY;     // Catch: Throwable -> L9
        AIKLog.INSTANCE.i("ObricTlsImpl", "enable8gen4DuaDirectionCert done!");     // Catch: Throwable -> L9
        return;
    L6:
        TTNetInit.addClientOpaqueDataV1(AppContext.INSTANCE.getApplication(), r10, r13.getEncoded(), r11.e("SYSTEM_Device_TLS_pkey").getEncoded());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        AIKLog.INSTANCE.e("ObricTlsImpl", "enable8gen4DuaDirectionCert failed: " + th);
    }

    private final Object m(Continuation<? super Boolean> r10) {
        if ((r10 instanceof ObricTlsImpl$waitForValidatedNetworkIfNeeded$1) == false) goto L7;
        ObricTlsImpl$waitForValidatedNetworkIfNeeded$1 r11 = (ObricTlsImpl$waitForValidatedNetworkIfNeeded$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L21:
        AIKLog.INSTANCE.d("ObricTlsImpl", "tls bootstrap resumed: validated network recovered");
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        NetworkStateListener r16 = NetworkStateListener.f4510a;
        if (r16.j().getValue().b() == true) goto L17;
        this.f4463b = TlsBootstrapState.WAITING_NETWORK;
        AIKLog.INSTANCE.d("ObricTlsImpl", "tls bootstrap paused: validated network unavailable");
        g1<NetworkStateListener.b> r17 = r16.j();
        ObricTlsImpl$waitForValidatedNetworkIfNeeded$2 r18 = new ObricTlsImpl$waitForValidatedNetworkIfNeeded$2(null);
        r11.label = 1;
        if (kotlinx.coroutines.flow.e.q(r17, r18, r11) != r14) goto L21;
        return r14;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r11 = new ObricTlsImpl$waitForValidatedNetworkIfNeeded$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.api.security.e
    public void a() {
        b((String) CollectionsKt.first(f4461f));
    }

    @Override // com.obric.aikernel.api.security.e
    public void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        if (f4461f.contains(r10) == true) goto L5;
        return;
    L5:
        if (this.f4462a == true) goto L30;
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (this.f4462a == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        r0<Boolean> r11 = this.f4464c;     // Catch: Throwable -> L24
        if (r11 != null) goto L15;
    L21:
        final r0<Boolean> r12 = h.b(this.f4465d, null, null, new ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3(this, null), 3, null);     // Catch: Throwable -> L24
        r12.A(new ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$4$1(this, r12));     // Catch: Throwable -> L24
        this.f4464c = r12;     // Catch: Throwable -> L24
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L15:
        if (r11.isActive() == true) goto L18;
        r11 = null;
    L18:
        if (r11 == null) goto L21;
        monitor-exit(this);
        return;
    }

    @Override // com.obric.aikernel.api.security.e
    public TlsBootstrapState c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        if (f4461f.contains(r10) == true) goto L7;
        return TlsBootstrapState.NOT_REQUIRED;
    L7:
        if (this.f4462a == false) goto L10;
        return TlsBootstrapState.READY;
    L10:
        return this.f4463b;
    }

    @Override // com.obric.aikernel.api.security.e
    public boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        if (f4461f.contains(r10) == true) goto L7;
        return true;
    L7:
        return this.f4462a;
    }
}
