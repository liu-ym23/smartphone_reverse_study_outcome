package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkStateListener f4510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<a> f4512c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ConnectivityManager f4513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f4514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final g1<Boolean> f4515f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final g1<b> f4516g = null;

    public interface a {
        void a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f4518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f4520c;

        public b() {
            this(false, false, false, 7, null);
        }

        public b(boolean r10, boolean r11, boolean r12) {
            this.f4518a = r10;
            this.f4519b = r11;
            this.f4520c = r12;
        }

        public /* synthetic */ b(boolean r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = false;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = false;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = false;
        L11:
            this(r10, r11, r12);
        }

        public final boolean a() {
            return this.f4518a;
        }

        public final boolean b() {
            return this.f4519b;
        }

        public final boolean c() {
            return this.f4520c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f4518a == r11.f4518a) goto L12;
            return false;
        L12:
            if (this.f4519b == r11.f4519b) goto L15;
            return false;
        L15:
            if (this.f4520c == r11.f4520c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            boolean r10 = this.f4518a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f4519b;
            ?? r15 = r14;
            if (r14 == false) goto L8;
            r15 = 1;
        L8:
            int r16 = (r13 + r15) * 31;
            boolean r17 = this.f4520c;
            if (r17 == true) goto L13;
            r11 = r17;
        L13:
            return r16 + r11;
        }

        public String toString() {
            return "NetworkSnapshot(hasInternet=" + this.f4518a + ", hasValidatedInternet=" + this.f4519b + ", isUnmetered=" + this.f4520c + ')';
        }
    }

    public static final class c extends ConnectivityManager.NetworkCallback {
        c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            Intrinsics.checkNotNullParameter(r10, "network");
            super.onAvailable(r10);
            NetworkStateListener.f(NetworkStateListener.f4510a, "onAvailable", null, 2, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
            Intrinsics.checkNotNullParameter(r10, "network");
            Intrinsics.checkNotNullParameter(r11, "networkCapabilities");
            super.onCapabilitiesChanged(r10, r11);
            NetworkStateListener r12 = NetworkStateListener.f4510a;
            NetworkStateListener.a(r12, "onCapabilitiesChanged", NetworkStateListener.c(r12, r11));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            Intrinsics.checkNotNullParameter(r10, "network");
            super.onLost(r10);
            NetworkStateListener.f(NetworkStateListener.f4510a, "onLost", null, 2, null);
        }
    }

    static {
        f4510a = new NetworkStateListener();
        f4511b = "NetworkStateListener";
        f4512c = new ArrayList();
        f4515f = q1.a(Boolean.FALSE);
        f4516g = q1.a(new b(false, false, false, 7, null));
    }

    private NetworkStateListener() {
    }

    public static final /* synthetic */ void a(NetworkStateListener r10, String r11, b r12) {
        r10.e(r11, r12);
    }

    public static final /* synthetic */ String b() {
        return f4511b;
    }

    public static final /* synthetic */ b c(NetworkStateListener r10, NetworkCapabilities r11) {
        return r10.o(r11);
    }

    private final void e(String r10, b r11) {
        List<a> r12 = f4512c;     // Catch: RuntimeException -> L16
        monitor-enter(r12);     // Catch: RuntimeException -> L16
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L13
    L6:
        if (r13.hasNext() == false) goto L8;
        ((a) r13.next()).a();     // Catch: Throwable -> L13
        goto L6
    L8:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: RuntimeException -> L16
        b r15 = m(g(), r11);     // Catch: RuntimeException -> L16
        NetworkStateListener r16 = f4510a;     // Catch: RuntimeException -> L16
        g1<b> r17 = f4516g;     // Catch: RuntimeException -> L16
        b r18 = r17.getValue();     // Catch: RuntimeException -> L16
        r17.setValue(r15);     // Catch: RuntimeException -> L16
        f4515f.setValue(Boolean.valueOf(r15.b()));     // Catch: RuntimeException -> L16
        r16.p(r15);     // Catch: RuntimeException -> L16
        if (r16.n(r18, r15) == false) goto L26;
        AIKLog.INSTANCE.i(f4511b, "broadcastState source=" + r10 + " snapshot=" + r15 + " previous=" + r18 + ' ' + r16.h());     // Catch: RuntimeException -> L16
        return;
    L26:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L16
    L16:
        e = move-exception;
        if (com.obric.aikernel.runtime.utils.a.a(e) == false) goto L21;
        AIKLog.INSTANCE.w(f4511b, "broadcastState skipped due to dead system. source=" + r10 + " error=" + e);
        return;
    L21:
        throw e;
    }

    static /* synthetic */ void f(NetworkStateListener r10, String r11, b r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.e(r11, r12);
    }

    private final b g() {
        b r10 = new b(false, false, false, 7, null);
        NetworkStateListener$currentNetworkSnapshot$1 r11 = NetworkStateListener$currentNetworkSnapshot$1.INSTANCE;
        ConnectivityManager r12 = f4513d;     // Catch: RuntimeException -> L13
        if (r12 == null) goto L6;
        Network r13 = r12.getActiveNetwork();     // Catch: RuntimeException -> L13
        if (r13 == null) goto L10;
        NetworkCapabilities r14 = r12.getNetworkCapabilities(r13);     // Catch: RuntimeException -> L13
    L22:
        return f4510a.o(r14);
    L10:
        r14 = null;
        goto L22
    L6:
        return new b(false, false, false, 7, null);
    L13:
        e = move-exception;
        if (com.obric.aikernel.runtime.utils.a.a(e) == false) goto L19;
        if (r11 == null) goto L21;
        r11.invoke(e);
        return r10;
    L21:
        return r10;
    L19:
        throw e;
    }

    private final String h() {
        NetworkStateListener$describeActiveNetwork$1 r10 = NetworkStateListener$describeActiveNetwork$1.INSTANCE;
        ConnectivityManager r11 = f4513d;     // Catch: RuntimeException -> L21
        if (r11 != null) goto L7;
        return "activeNetwork=null caps=null";
    L7:
        Network r12 = r11.getActiveNetwork();     // Catch: RuntimeException -> L21
        if (r12 == null) goto L10;
        NetworkCapabilities r13 = r11.getNetworkCapabilities(r12);     // Catch: RuntimeException -> L21
    L11:
        StringBuilder r14 = new StringBuilder();     // Catch: RuntimeException -> L21
        r14.append("activeNetwork=");     // Catch: RuntimeException -> L21
        Object r15 = r12;
        if (r12 != null) goto L15;
        r15 = "null";
    L15:
        r14.append(r15);     // Catch: RuntimeException -> L21
        r14.append(" caps=");     // Catch: RuntimeException -> L21
        if (r13 != null) goto L18;
        r14.append("null");     // Catch: RuntimeException -> L21
    L19:
        String r16 = r14.toString();     // Catch: RuntimeException -> L21
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");     // Catch: RuntimeException -> L21
        return r16;
    L18:
        r14.append("internet=" + r13.hasCapability(12) + " validated=" + r13.hasCapability(16) + " unmetered=" + r13.hasCapability(11) + " wifi=" + r13.hasTransport(1));     // Catch: RuntimeException -> L21
        goto L19
    L10:
        r13 = null;
    L21:
        e = move-exception;
        if (com.obric.aikernel.runtime.utils.a.a(e) == false) goto L28;
        if (r10 == null) goto L26;
        r10.invoke(e);
    L26:
        return "activeNetwork=dead_system";
    L28:
        throw e;
    }

    private final b o(NetworkCapabilities r10) {
        boolean r11 = true;
        if (r10 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r10 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        if (r10 != null) goto L15;
    L17:
        r11 = false;
    L19:
        return new b(r12, r13, r11);
    L15:
        if (r10.hasCapability(11) != true) goto L17;
    L10:
        if (r10.hasCapability(16) != true) goto L12;
        r13 = true;
        goto L13
    L5:
        if (r10.hasCapability(12) != true) goto L7;
        r12 = true;
        goto L8
    }

    public final Object d(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof NetworkStateListener$actWhenNetAvail$1) == false) goto L7;
        NetworkStateListener$actWhenNetAvail$1 r12 = (NetworkStateListener$actWhenNetAvail$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L13;
        ResultKt.throwOnFailure(r14);
    L27:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r14);
        g1<Boolean> r17 = f4515f;
        if (r17.getValue().booleanValue() == false) goto L23;
        Boolean r18 = Boxing.boxBoolean(true);
        r12.label = 1;
        if (r10.invoke(r18, r12) != r15) goto L22;
        return r15;
    L23:
        AIKLog.INSTANCE.i(f4511b, "actWhenNetAvail: validated network unavailable, wait connect.");
        NetworkStateListener$actWhenNetAvail$2 r19 = new NetworkStateListener$actWhenNetAvail$2(r10);
        r12.label = 2;
        if (r17.a(r19, r12) != r15) goto L27;
        return r15;
    L7:
        r12 = new NetworkStateListener$actWhenNetAvail$1(this, r11);
        goto L8
    }

    public final g1<Boolean> i() {
        return f4515f;
    }

    public final g1<b> j() {
        return f4516g;
    }

    public final void k(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f4514e == false) goto L9;
        AIKLog.INSTANCE.d(f4511b, "init skipped: already initialized");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        Object r11 = r10.getSystemService("connectivity");     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Throwable -> L16
        f4513d = (ConnectivityManager) r11;     // Catch: Throwable -> L16
        c r12 = new c();     // Catch: Throwable -> L16
        NetworkRequest r13 = new NetworkRequest.Builder().addCapability(12).build();     // Catch: Throwable -> L16
        ConnectivityManager r14 = f4513d;     // Catch: Throwable -> L16
        if (r14 == null) goto L12;
        r14.registerNetworkCallback(r13, r12);     // Catch: Throwable -> L16
    L12:
        f4514e = true;     // Catch: Throwable -> L16
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        f(this, CommonConsts.APM_INNER_EVENT_COST_INIT, null, 2, null);
    }

    public final void l() {
        f(this, "refresh", null, 2, null);
    }

    public final b m(b r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, "direct");
        if (r10.a() == false) goto L5;
        return r10;
    L5:
        if (r10.b() == false) goto L7;
        return r10;
    L7:
        if (r10.c() == true) goto L15;
        if (r11 != null) goto L12;
        return r10;
    L12:
        return r11;
    L15:
        return r10;
    }

    public final boolean n(b r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, "previous");
        Intrinsics.checkNotNullParameter(r11, "next");
        return !Intrinsics.areEqual(r10, r11);
    }

    public final void p(b r10) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        com.obric.aikernel.runtime.utils.f.f5423a.b(new com.obric.aikernel.runtime.utils.f.a(r10.a(), r10.b(), r10.c()));
    }
}
