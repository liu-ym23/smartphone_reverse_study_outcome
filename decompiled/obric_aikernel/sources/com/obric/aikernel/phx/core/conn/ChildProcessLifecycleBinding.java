package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ChildProcessLifecycleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChildProcessLifecycleBinding f4776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f4777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, c> f4778c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l0 f4779d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4780e;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ServiceConnection f4782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private v1 f4784d;

        public a(Context r10, ServiceConnection r11, int r12, v1 r13) {
            Intrinsics.checkNotNullParameter(r10, "appContext");
            Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION);
            this.f4781a = r10;
            this.f4782b = r11;
            this.f4783c = r12;
            this.f4784d = r13;
        }

        public /* synthetic */ a(Context r10, ServiceConnection r11, int r12, v1 r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 8) == 0) goto L5;
            r13 = null;
        L5:
            this(r10, r11, r12, r13);
        }

        public final int a() {
            return this.f4783c;
        }

        public final Context b() {
            return this.f4781a;
        }

        public final ServiceConnection c() {
            return this.f4782b;
        }

        public final v1 d() {
            return this.f4784d;
        }

        public final void e(int r10) {
            this.f4783c = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f4781a, r11.f4781a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4782b, r11.f4782b) == true) goto L15;
            return false;
        L15:
            if (this.f4783c == r11.f4783c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f4784d, r11.f4784d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final void f(v1 r10) {
            this.f4784d = r10;
        }

        public int hashCode() {
            int r10 = ((((this.f4781a.hashCode() * 31) + this.f4782b.hashCode()) * 31) + Integer.hashCode(this.f4783c)) * 31;
            v1 r11 = this.f4784d;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return r10 + r12;
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        public String toString() {
            return "BindingRecord(appContext=" + this.f4781a + ", connection=" + this.f4782b + ", activeCount=" + this.f4783c + ", releaseJob=" + this.f4784d + ')';
        }
    }

    private static final class b implements com.obric.aikernel.phx.core.conn.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f4786b;

        public b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "bindingKey");
            this.f4785a = r10;
            this.f4786b = new AtomicBoolean(false);
        }

        @Override // com.obric.aikernel.phx.core.conn.b
        public void close() {
            if (this.f4786b.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            ChildProcessLifecycleBinding.b(ChildProcessLifecycleBinding.f4776a, this.f4785a);
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ServiceConnection f4787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4788b;

        public c(ServiceConnection r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
            this.f4787a = r10;
        }

        public final boolean a() {
            return this.f4788b;
        }

        public final ServiceConnection b() {
            return this.f4787a;
        }

        public final void c(boolean r10) {
            this.f4788b = r10;
        }
    }

    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4789c;

        d(String r10) {
            this.f4789c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            ChildProcessLifecycleBinding.a(ChildProcessLifecycleBinding.f4776a, this.f4789c, this);
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            ChildProcessLifecycleBinding.a(ChildProcessLifecycleBinding.f4776a, this.f4789c, this);
        }
    }

    static {
        f4776a = new ChildProcessLifecycleBinding();
        f4777b = new ConcurrentHashMap();
        f4778c = new ConcurrentHashMap();
        f4779d = m0.a(z0.b().plus(q2.b(null, 1, null)));
        f4780e = 300000;
    }

    private ChildProcessLifecycleBinding() {
    }

    public static final /* synthetic */ void a(ChildProcessLifecycleBinding r10, String r11, ServiceConnection r12) {
        r10.f(r11, r12);
    }

    public static final /* synthetic */ void b(ChildProcessLifecycleBinding r10, String r11) {
        r10.h(r11);
    }

    public static final /* synthetic */ void c(ChildProcessLifecycleBinding r10, String r11) {
        r10.l(r11);
    }

    public static /* synthetic */ com.obric.aikernel.phx.core.conn.b e(ChildProcessLifecycleBinding r10, Context r11, String r12, String r13, boolean r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L11;
        AIKernelConfig r17 = f7.a.f8866a.a();
        if (r17 != null) goto L7;
    L9:
        r14 = false;
        goto L11
    L7:
        if (r17.getChildProcessImportantBindEnabled() != true) goto L9;
        r14 = true;
    L11:
        return r10.d(r11, r12, r13, r14);
    }

    private final void f(String r10, ServiceConnection r11) {
        monitor-enter(this);
        c r12 = f4778c.get(r10);     // Catch: Throwable -> L22
        if (r12 == null) goto L6;
        ServiceConnection r13 = r12.b();     // Catch: Throwable -> L22
    L8:
        if (Intrinsics.areEqual(r13, r11) == false) goto L10;
        r12.c(true);     // Catch: Throwable -> L22
    L10:
        ConcurrentHashMap<String, a> r14 = f4777b;     // Catch: Throwable -> L22
        a r15 = r14.get(r10);     // Catch: Throwable -> L22
        if (r15 != null) goto L14;
        monitor-exit(this);
        return;
    L14:
        Intrinsics.checkNotNullExpressionValue(r15, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r15.c(), r11) == false) goto L19;
        r14.remove(r10);     // Catch: Throwable -> L22
        v1 r16 = r15.d();     // Catch: Throwable -> L22
        if (r16 == null) goto L19;
        v1.a.a(r16, null, 1, null);     // Catch: Throwable -> L22
    L19:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        r13 = null;
    L22:
        th = move-exception;
        throw th;
    }

    private final void h(String r10) {
        monitor-enter(this);
        a r11 = f4777b.get(r10);     // Catch: Throwable -> L19
        if (r11 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Intrinsics.checkNotNullExpressionValue(r11, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L19
        if (r11.a() <= 0) goto L11;
        r11.e(r11.a() - 1);     // Catch: Throwable -> L19
    L11:
        if (r11.a() != 0) goto L16;
        v1 r12 = r11.d();     // Catch: Throwable -> L19
        if (r12 == null) goto L15;
        v1.a.a(r12, null, 1, null);     // Catch: Throwable -> L19
    L15:
        r11.f(h.d(f4779d, null, null, new ChildProcessLifecycleBinding$release$1$1(r10, null), 3, null));     // Catch: Throwable -> L19
    L16:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private final void l(String r10) {
        monitor-enter(this);
        ConcurrentHashMap<String, a> r11 = f4777b;     // Catch: Throwable -> L21
        a r12 = r11.get(r10);     // Catch: Throwable -> L21
        if (r12 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Intrinsics.checkNotNullExpressionValue(r12, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L21
        if (r12.a() == 0) goto L11;
        monitor-exit(this);
        return;
    L11:
        r11.remove(r10);     // Catch: Throwable -> L21
        r12.f(null);     // Catch: Throwable -> L21
        monitor-exit(this);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L15
        r12.b().unbindService(r12.c());     // Catch: Throwable -> L15
        Object r14 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L28;
        AIKLog.INSTANCE.w("ChildLifecycleBinding", "unbind child lifecycle service failed, key=" + r10 + ' ' + r15);
        return;
    L28:
        return;
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        throw th;
    }

    private final void m(Context r10, ServiceConnection r11, String r12) {
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L4
        r10.unbindService(r11);     // Catch: Throwable -> L4
        Object r14 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L12;
        AIKLog.INSTANCE.w("ChildLifecycleBinding", "unbind unpublished child lifecycle service failed, key=" + r12 + ' ' + r15);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final com.obric.aikernel.phx.core.conn.b d(Context r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "servicePackage");
        if (r15 == true) goto L7;
        AIKLog.INSTANCE.d("ChildLifecycleBinding", "skip child lifecycle important bind by config, process=" + r14);
        return com.obric.aikernel.phx.core.conn.a.f4811a;
    L7:
        if (r12 == null) goto L9;
        Context r16 = r12.getApplicationContext();
    L10:
        if (r16 == null) goto L12;
        ComponentName r10 = j(r13, r14);
        if (r10 == null) goto L16;
        String r17 = i(r13, r14);
        if (r17 == null) goto L20;
        d r11 = new d(r17);
        Intent r18 = new Intent();
        r18.setComponent(r10);
        monitor-enter(this);
        a r19 = f4777b.get(r17);     // Catch: Throwable -> L71
        boolean r20 = true;
        if (r19 == null) goto L31;
        r19.e(r19.a() + 1);     // Catch: Throwable -> L71
        v1 r110 = r19.d();     // Catch: Throwable -> L71
        if (r110 == null) goto L28;
        v1.a.a(r110, null, 1, null);     // Catch: Throwable -> L71
    L28:
        r19.f(null);     // Catch: Throwable -> L71
        b r111 = new b(r17);     // Catch: Throwable -> L71
        monitor-exit(this);
        return r111;
    L31:
        ConcurrentHashMap<String, c> r112 = f4778c;     // Catch: Throwable -> L71
        if (r112.containsKey(r17) == false) goto L36;
        AIKLog.INSTANCE.d("ChildLifecycleBinding", "skip child lifecycle bind, pending process=" + r14);     // Catch: Throwable -> L71
        com.obric.aikernel.phx.core.conn.a r113 = com.obric.aikernel.phx.core.conn.a.f4811a;     // Catch: Throwable -> L71
        monitor-exit(this);
        return r113;
    L36:
        c r21 = new c(r11);     // Catch: Throwable -> L71
        r112.put(r17, r21);     // Catch: Throwable -> L71
        monitor-exit(this);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L40
        Object r115 = Result.m32constructorimpl(Boolean.valueOf(com.obric.aikernel.phx.core.conn.c.b(r16, r18, m1.a(z0.b()), r11)));     // Catch: Throwable -> L40
    L42:
        Throwable r22 = Result.m35exceptionOrNullimpl(r115);
        if (r22 == null) goto L45;
        AIKLog.INSTANCE.w("ChildLifecycleBinding", "bind child lifecycle service failed, process=" + r14 + ' ' + r22);
    L45:
        Boolean r23 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r115) == false) goto L48;
        r115 = r23;
    L48:
        boolean r116 = ((Boolean) r115).booleanValue();
        monitor-enter(this);
        ConcurrentHashMap<String, c> r24 = f4778c;     // Catch: Throwable -> L68
        if (Intrinsics.areEqual(r24.get(r17), r21) == true) goto L53;
    L52:
        r20 = false;
    L59:
        monitor-exit(this);
        if (r20 == true) goto L67;
        if (r116 == true) goto L63;
        AIKLog.INSTANCE.i("ChildLifecycleBinding", "skip bind child lifecycle service, process=" + r14 + " result=false");
    L65:
        return com.obric.aikernel.phx.core.conn.a.f4811a;
    L63:
        AIKLog.INSTANCE.i("ChildLifecycleBinding", "skip bind child lifecycle service, process=" + r14 + " connection cleared");
        m(r16, r11, r17);
        goto L65
    L67:
        return new b(r17);
    L53:
        r24.remove(r17);     // Catch: Throwable -> L68
        if (r116 == false) goto L52;
        if (r21.a() == true) goto L52;
        f4777b.put(r17, new a(r16, r11, 1, null, 8, null));     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;
    L40:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r115 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L71:
        th = move-exception;
        throw th;
    L20:
        return com.obric.aikernel.phx.core.conn.a.f4811a;
    L16:
        return com.obric.aikernel.phx.core.conn.a.f4811a;
    L12:
        return com.obric.aikernel.phx.core.conn.a.f4811a;
    L9:
        r16 = null;
        goto L10
    }

    public final long g() {
        return f4780e;
    }

    public final String i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "servicePackage");
        String r12 = k(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r10 + '/' + r12;
    }

    public final ComponentName j(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "servicePackage");
        String r12 = k(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new ComponentName(r10, r12);
    }

    public final String k(String r10) {
        boolean r11 = true;
        if (r10 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L10;
        return "com.obric.aikernel.InferLifeCycleService";
    L10:
        if (r10 != null) goto L12;
    L14:
        r11 = false;
    L15:
        if (r11 == false) goto L19;
        return "com.obric.aikernel.LLMLifeCycleService";
    L19:
        return null;
    L12:
        if (StringsKt.endsWith$default(r10, ":llm", false, 2, null) != true) goto L14;
    L5:
        if (StringsKt.endsWith$default(r10, ":infer", false, 2, null) != true) goto L7;
        r12 = true;
        goto L8
    }
}
