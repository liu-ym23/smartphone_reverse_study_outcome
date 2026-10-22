package com.obric.aikernel.sdk.autotest;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Keep;
import ce.e;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import ge.l;
import he.i;
import he.j;
import org.json.JSONObject;
import pe.x1;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class AutoTestManager {
    public static final AutoTestManager INSTANCE = null;
    private static final String TAG = "AutoTestManager";

    @e(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", l = {38, 39}, m = "autoTest")
    public static final class a extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AutoTestManager f5329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f5330b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f5331m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ AutoTestManager f5332n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f5333o;

        public a(AutoTestManager r8, ae.d<? super a> r10) {
            this.f5332n = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5331m = r8;
            this.f5333o |= Integer.MIN_VALUE;
            return this.f5332n.autoTest(null, null, this);
        }
    }

    public static final class b extends j implements l<Bundle, xa.a<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5334a = null;

        static {
            f5334a = new b();
        }

        public b() {
            super(1);
        }

        @Override // ge.l
        public final xa.a<Object> invoke(Bundle r8) {
            Bundle r10 = r8;
            i.f(r10, "it");
            return wa.a.p(r10, com.obric.aikernel.sdk.autotest.a.f5349a);
        }
    }

    @e(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", l = {53}, m = "callAutoTestAsResponse")
    public static final class c<T> extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f5335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l f5336b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f5337m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f5338n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ AutoTestManager f5339o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f5340p;

        public c(AutoTestManager r8, ae.d<? super c> r10) {
            this.f5339o = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5338n = r8;
            this.f5340p |= Integer.MIN_VALUE;
            return AutoTestManager.access$callAutoTestAsResponse(this.f5339o, null, null, 0, null, this);
        }
    }

    public static final class d implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ge.a f5348a;

        public d(AutoTestManager$callAutoTestAsResponse$responseBundle$1.a r8) {
            this.f5348a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final /* synthetic */ void binderDied() {
            this.f5348a.f();
        }
    }

    static {
        INSTANCE = new AutoTestManager();
    }

    private AutoTestManager() {
    }

    public static final /* synthetic */ Object access$callAutoTestAsResponse(AutoTestManager r8, AIKBinder r10, Bundle r11, long r12, l r13, ae.d r14) {
        return r8.callAutoTestAsResponse(r10, r11, r12, r13, r14);
    }

    private final <T> Object callAutoTestAsResponse(AIKBinder r10, Bundle r11, long r12, l<? super Bundle, ? extends T> r14, ae.d<? super T> r15) {
        if ((r15 instanceof c) == false) goto L7;
        c r8 = (c) r15;
        int r13 = r8.f5340p;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5340p = r13 - Integer.MIN_VALUE;
    L8:
        Object r16 = r8.f5338n;
        be.a r17 = be.a.f3165a;
        int r18 = r8.f5340p;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        r12 = r8.f5337m;
        r14 = r8.f5336b;
        r11 = r8.f5335a;
        defpackage.c.m0(r16);
    L17:
        Bundle r19 = (Bundle) r16;
        if (r19 != null) goto L21;
        AIKLog.INSTANCE.v(TAG, "callAutoTestlAsResponse " + r11.getString(IdlKeys.MethodName) + " timeout after " + r12 + " ms");
        r19 = new Bundle();
        StringBuilder r110 = new StringBuilder("timeout after ");
        r110.append(r12);
        r110.append(" ms");
        wa.a.l(r19, 107, r110.toString(), 4);
    L21:
        return r14.invoke(r19);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r16);
        AutoTestManager$callAutoTestAsResponse$responseBundle$1 r20 = new AutoTestManager$callAutoTestAsResponse$responseBundle$1(r11, r12, r10, null);
        r8.getClass();
        r8.f5335a = r11;
        r8.f5336b = r14;
        r8.f5337m = r12;
        r8.f5340p = 1;
        r16 = x1.b(r12, r20, r8);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r8 = new c(this, r15);
        goto L8
    }

    public static /* synthetic */ Object callAutoTestAsResponse$default(AutoTestManager r8, AIKBinder r10, Bundle r11, long r12, l r13, ae.d r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r12 = 3000;
    L6:
        return r8.callAutoTestAsResponse(r10, r11, r12, r13, r14);
    }

    public final Object autoTest(Context r10, JSONObject r11, ae.d<? super xa.a<Object>> r12) {
        if ((r12 instanceof a) == false) goto L7;
        a r8 = (a) r12;
        int r13 = r8.f5333o;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5333o = r13 - Integer.MIN_VALUE;
    L8:
        a r14 = r8;
        Object r15 = r14.f5331m;
        be.a r16 = be.a.f3165a;
        int r17 = r14.f5333o;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        defpackage.c.m0(r15);
    L31:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r18 = r14.f5330b;
        AutoTestManager r19 = r14.f5329a;
        defpackage.c.m0(r15);
        Bundle r20 = r18;
        AutoTestManager r21 = r19;
    L25:
        AIKBinder r22 = (AIKBinder) r15;
        if (r22 != null) goto L28;
        Bundle r23 = new Bundle();
        int r24 = wa.a.f13086a;
        wa.a.k(IdlErrors.INSTANCE.toString(102), r23);
    L20:
        return wa.a.m(r23);
    L28:
        b r25 = b.f5334a;
        r14.f5329a = null;
        r14.f5330b = null;
        r14.f5333o = 2;
        r15 = r21.callAutoTestAsResponse(r22, r20, 5000, r25, r14);
        if (r15 != r16) goto L31;
        return r16;
    L16:
        defpackage.c.m0(r15);
        String r26 = r10.getPackageName();
        i.e(r26, "context.packageName");
        if (isAutoTestApp(r26) == true) goto L21;
        r23 = new Bundle();
        wa.a.l(r23, 101, "only auto test app can call this method.", 4);
        goto L20
    L21:
        Bundle r27 = wa.a.h(r11, true);
        r14.f5329a = this;
        r14.f5330b = r27;
        r14.f5333o = 1;
        r15 = AIKernelApi.d(AIKernelManager.INSTANCE.getInstance$sdk_release(), r14);
        if (r15 != r16) goto L24;
        return r16;
    L24:
        r21 = this;
        r20 = r27;
    L7:
        r8 = new a(this, r12);
        goto L8
    }

    public final boolean isAutoTestApp(String r8) {
        i.f(r8, "packageName");
        return i.a(r8, "com.obric.aikernelautotest");
    }
}
