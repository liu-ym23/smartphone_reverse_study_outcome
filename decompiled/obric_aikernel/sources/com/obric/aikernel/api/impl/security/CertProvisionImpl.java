package com.obric.aikernel.api.impl.security;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.gson.d;
import com.google.gson.k;
import com.google.gson.m;
import com.obric.aikernel.api.security.CertProvisionFeature;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.runtime.utils.DeviceUtils;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class CertProvisionImpl extends CertProvisionFeature {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicLong f4452f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CertProvisionImpl$conn$1 f4453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f4454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile r0<Boolean> f4455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l0 f4456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4457e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f4452f = new AtomicLong(0);
    }

    public CertProvisionImpl() {
        this.f4453a = new CertProvisionImpl$conn$1(this);
        this.f4456d = m0.a(q2.b(null, 1, null).plus(z0.b()));
        String r10 = DeviceUtils.f5383a.f();
        int r11 = r10.hashCode();
        if (r11 == (-80147032)) goto L17;
        if (r11 == 3357597) goto L14;
        if (r11 == 288116635) goto L10;
    L18:
        String r12 = "ocean.device_intelligence.model_center_srv";
    L20:
        this.f4457e = r12;
        return;
    L10:
        if (r10.equals("genesis_r") == false) goto L18;
        r12 = "ocean_aikernel_gr";
        goto L20
    L14:
        if (r10.equals("moto") == false) goto L18;
        r12 = "ocean_aikernel_gl";
        goto L20
    L17:
        if (r10.equals("genesis") == false) goto L18;
        r12 = "ocean_aikernel_g1";
        goto L20
    }

    public static final /* synthetic */ boolean f(CertProvisionImpl r10, String r11) {
        return r10.j(r11);
    }

    public static final /* synthetic */ Object g(CertProvisionImpl r10, Continuation r11) {
        return r10.l(r11);
    }

    public static final /* synthetic */ Object h(CertProvisionImpl r10, Continuation r11) {
        return r10.o(r11);
    }

    private final String i() {
        StackTraceElement[] r10 = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(r10, "Throwable().stackTrace");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        StackTraceElement r13 = null;
        if (r12 >= r11) goto L16;
        StackTraceElement r14 = r10[r12];
        String r15 = r14.getClassName();
        Intrinsics.checkNotNullExpressionValue(r15, "cls");
        if (StringsKt.startsWith$default(r15, "java.", false, 2, null) == false) goto L8;
    L12:
        boolean r16 = false;
    L13:
        if (r16 == true) goto L14;
        r12 = r12 + 1;
        goto L3
    L14:
        r13 = r14;
        goto L16
    L8:
        if (StringsKt.startsWith$default(r15, "kotlin.", false, 2, null) == true) goto L12;
        if (StringsKt.contains$default(r15, "CertProvisionImpl", false, 2, null) == true) goto L12;
        r16 = true;
    L16:
        if (r13 == null) goto L20;
        String r17 = r13.getClassName() + '#' + r13.getMethodName() + ':' + r13.getLineNumber();
        if (r17 == null) goto L20;
        return r17;
    L20:
        return "unknown";
    }

    private final boolean j(String r10) {
        boolean r11 = com.obric.aikernel.api.impl.security.a.f4466a.b(r10);
        AIKLog.INSTANCE.i("CertProvisionImpl", "checkProvisionState " + r11);
        if (r11 == false) goto L5;
        this.f4454b = true;
    L5:
        return r11;
    }

    private final String k(String r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r11 = true;
    L8:
        if (r11 == false) goto L32;
        return "null";
    L32:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L24
        k r13 = (k) new d().k(r10, k.class);     // Catch: Throwable -> L24
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L24
        r14.append("plat=");     // Catch: Throwable -> L24
        m r15 = r13.v("platform_param_provisioned");     // Catch: Throwable -> L24
        Boolean r16 = null;
        if (r15 == null) goto L14;
        Boolean r17 = Boolean.valueOf(r15.a());     // Catch: Throwable -> L24
    L15:
        r14.append(r17);     // Catch: Throwable -> L24
        r14.append(",tls=");     // Catch: Throwable -> L24
        m r18 = r13.v("tls_cert_provisioned");     // Catch: Throwable -> L24
        if (r18 == null) goto L18;
        Boolean r19 = Boolean.valueOf(r18.a());     // Catch: Throwable -> L24
    L19:
        r14.append(r19);     // Catch: Throwable -> L24
        r14.append(",device=");     // Catch: Throwable -> L24
        m r20 = r13.v("dev_cert_provisioned");     // Catch: Throwable -> L24
        if (r20 == null) goto L22;
        r16 = Boolean.valueOf(r20.a());     // Catch: Throwable -> L24
    L22:
        r14.append(r16);     // Catch: Throwable -> L24
        r14.append(",status=");     // Catch: Throwable -> L24
        r14.append(r13.s("status"));     // Catch: Throwable -> L24
        r14.append(",version=");     // Catch: Throwable -> L24
        r14.append(r13.s("version"));     // Catch: Throwable -> L24
        Object r21 = Result.m32constructorimpl(r14.toString());     // Catch: Throwable -> L24
    L26:
        Throwable r22 = Result.m35exceptionOrNullimpl(r21);
        if (r22 == null) goto L31;
        r21 = "parseError:" + r22.getClass().getSimpleName();
    L31:
        return (String) r21;
    L18:
        r19 = null;
        goto L19
    L14:
        r17 = null;
    L24:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L26
    L4:
        if (StringsKt.isBlank(r10) == true) goto L7;
        r11 = false;
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00af -> B:33:0x00b2). Please report as a decompilation issue!!! */
    private final Object l(Continuation<? super Unit> r10) {
        if ((r10 instanceof CertProvisionImpl$ensureConnected$1) == false) goto L7;
        CertProvisionImpl$ensureConnected$1 r11 = (CertProvisionImpl$ensureConnected$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        int r16 = r11.I$1;
        int r17 = r11.I$0;
        CertProvisionImpl r18 = (CertProvisionImpl) r11.L$0;
        ResultKt.throwOnFailure(r13);
        CertProvisionImpl r19 = r18;
    L33:
        r16 = r16 + 1;
    L22:
        if (r16 >= r17) goto L36;
        IBinder r20 = r19.f4453a.a();
        if (r20 != null) goto L26;
    L28:
        boolean r21 = false;
    L29:
        if (r21 == true) goto L35;
        r11.L$0 = r19;
        r11.I$0 = r17;
        r11.I$1 = r16;
        r11.label = 1;
        if (DelayKt.b(100, r11) != r14) goto L33;
        return r14;
    L35:
        return Unit.INSTANCE;
    L26:
        if (r20.isBinderAlive() != true) goto L28;
        r21 = true;
    L36:
        AIKLog.INSTANCE.d("CertProvisionImpl", "ensureConnected end");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AIKLog r22 = AIKLog.INSTANCE;
        r22.d("CertProvisionImpl", "ensureConnected start");
        IBinder r23 = this.f4453a.a();
        if (r23 != null) goto L17;
    L19:
        boolean r24 = false;
    L20:
        if (r24 == true) goto L36;
        Context r25 = AppContext.INSTANCE.getContext();
        Intent r26 = new Intent("com.bytedance.securityserver.ACTION_START_PROVISION");
        r26.setPackage("com.bytedance.securityserver");
        r22.d("CertProvisionImpl", "ensureConnected bind " + r25.bindService(r26, this.f4453a, 1));
        r17 = 50;
        r19 = this;
        r16 = 0;
        goto L22
    L17:
        if (r23.isBinderAlive() != true) goto L19;
        r24 = true;
    L7:
        r11 = new CertProvisionImpl$ensureConnected$1(this, r10);
        goto L8
    }

    private final String m(Bundle r10) {
        return c.f4467a.a(AppContext.INSTANCE.getContext(), r10);
    }

    static /* synthetic */ String n(CertProvisionImpl r10, Bundle r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = new Bundle();
    L6:
        return r10.m(r11);
    }

    private final Object o(Continuation<? super Boolean> r17) {
        CertProvisionImpl r10 = this;
        if ((r17 instanceof CertProvisionImpl$performWaitCertProvisioned$1) == false) goto L7;
        CertProvisionImpl$performWaitCertProvisioned$1 r11 = (CertProvisionImpl$performWaitCertProvisioned$1) r17;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        int r16 = 0;
        int r18 = 1;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        long r19 = r11.J$0;
        String r20 = (String) r11.L$1;
        CertProvisionImpl r21 = (CertProvisionImpl) r11.L$0;
        ResultKt.throwOnFailure(r13);
        String r22 = r20;
        r10 = r21;
    L24:
        AIKLog r23 = AIKLog.INSTANCE;
        StringBuilder r110 = new StringBuilder();
        r110.append("waitCertProvisioned#");
        r110.append(r19);
        r110.append(" afterEnsureConnected caller=");
        r110.append(r22);
        r110.append(" binderAlive=");
        IBinder r24 = r10.f4453a.a();
        if (r24 != null) goto L27;
    L29:
        boolean r25 = false;
    L30:
        r110.append(r25);
        r23.d("CertProvisionImpl", r110.toString());
    L32:
        if (r16 >= 3) goto L38;
        String r111 = n(r10, null, r18, null);
        boolean r112 = r10.j(r111);
        AIKLog r113 = AIKLog.INSTANCE;
        StringBuilder r114 = new StringBuilder();
        r114.append("waitCertProvisioned#");
        r114.append(r19);
        r114.append(" round=");
        r16 = r16 + 1;
        r114.append(r16);
        r114.append(" caller=");
        r114.append(r22);
        r114.append(" ready=");
        r114.append(r112);
        r114.append(" state=");
        r114.append(r10.k(r111));
        r113.d("CertProvisionImpl", r114.toString());
        if (r112 == true) goto L37;
        r113.w("CertProvisionImpl", "waitCertProvisioned#" + r19 + " round=" + r16 + " caller=" + r22 + " triggerStartKeyProvision");
        q(r10, null, 1, null);
        r18 = 1;
        goto L32
    L37:
        return Boxing.boxBoolean(true);
    L38:
        String r26 = n(r10, null, r18, null);
        boolean r27 = r10.j(r26);
        AIKLog.INSTANCE.d("CertProvisionImpl", "waitCertProvisioned#" + r19 + " final caller=" + r22 + " ready=" + r27 + " state=" + r10.k(r26));
        return Boxing.boxBoolean(r27);
    L27:
        if (r24.isBinderAlive() != true) goto L29;
        r25 = true;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        long r115 = f4452f.incrementAndGet();
        r22 = i();
        IBinder r28 = r10.f4453a.a();
        if (r28 != null) goto L17;
    L19:
        boolean r29 = false;
    L20:
        AIKLog.INSTANCE.d("CertProvisionImpl", "waitCertProvisioned#" + r115 + " start caller=" + r22 + " cachedProvisioned=" + r10.f4454b + " binderAlive=" + r29);
        r11.L$0 = r10;
        r11.L$1 = r22;
        r11.J$0 = r115;
        r11.label = 1;
        if (r10.l(r11) != r14) goto L23;
        return r14;
    L23:
        r19 = r115;
        goto L24
    L17:
        if (r28.isBinderAlive() != true) goto L19;
        r29 = true;
    L7:
        r11 = new CertProvisionImpl$performWaitCertProvisioned$1(r10, r17);
        goto L8
    }

    private final synchronized Bundle p(Bundle r10) {
        monitor-enter(this);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(r(r10));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);     // Catch: Throwable -> L16
        if (r13 == null) goto L11;
        AIKLog.INSTANCE.e("CertProvisionImpl", "startKeyProvision failed " + r13);     // Catch: Throwable -> L16
    L11:
        if (Result.m38isFailureimpl(r12) == false) goto L13;
        r12 = null;
    L13:
        Bundle r14 = (Bundle) r12;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r14;
    L16:
        th = move-exception;
        throw th;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L16
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L16
        goto L7
    }

    static /* synthetic */ Bundle q(CertProvisionImpl r10, Bundle r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = new Bundle();
    L6:
        return r10.p(r11);
    }

    private final Bundle r(Bundle r10) {
        Parcel r11 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r11, "obtain()");
        Parcel r12 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r12, "obtain()");
        r11.writeInterfaceToken("com.bytedance.securityserver.provision.ISecurityProvisionService");     // Catch: Throwable -> L18
        boolean r13 = true;
        r11.writeInt(1);     // Catch: Throwable -> L18
        r10.writeToParcel(r11, 0);     // Catch: Throwable -> L18
        IBinder r14 = this.f4453a.a();     // Catch: Throwable -> L18
        if (r14 != null) goto L6;
    L8:
        r13 = false;
    L9:
        Bundle r15 = null;
        if (r13 == true) goto L13;
        r12.recycle();
        r11.recycle();
        return null;
    L13:
        r12.readException();     // Catch: Throwable -> L18
        if (r12.readInt() == 0) goto L16;
        r15 = (Bundle) Bundle.CREATOR.createFromParcel(r12);     // Catch: Throwable -> L18
    L16:
        r12.recycle();
        r11.recycle();
        return r15;
    L6:
        if (r14.transact(1, r11, r12, 0) != true) goto L8;
    L18:
        th = move-exception;
        r12.recycle();
        r11.recycle();
        throw th;
    }

    @Override // com.obric.aikernel.api.security.CertProvisionFeature
    public String a() {
        return this.f4457e;
    }

    @Override // com.obric.aikernel.api.security.CertProvisionFeature
    public boolean b() {
        return true;
    }

    @Override // com.obric.aikernel.api.security.CertProvisionFeature
    public Object c(Continuation<? super Boolean> r13) {
        if ((r13 instanceof CertProvisionImpl$waitCertProvisioned$1) == false) goto L7;
        CertProvisionImpl$waitCertProvisioned$1 r10 = (CertProvisionImpl$waitCertProvisioned$1) r13;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        r0<Boolean> r16 = (r0) r10.L$1;
        CertProvisionImpl r17 = (CertProvisionImpl) r10.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L36:
        boolean r18 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L14
        if (r16.a() == false) goto L50;
        monitor-enter(r17);
    L46:
        th = move-exception;
        throw th;
    L41:
        if (r17.f4455c != r16) goto L43;
        r17.f4455c = null;     // Catch: Throwable -> L46
    L43:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L46
        monitor-exit(r17);
    L50:
        return Boxing.boxBoolean(r18);
    L14:
        Throwable th = th;
    L54:
        if (r16.a() == false) goto L65;
        monitor-enter(r17);
    L62:
        th = move-exception;
        throw th;
    L57:
        if (r17.f4455c != r16) goto L59;
        r17.f4455c = null;     // Catch: Throwable -> L62
    L59:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(r17);
    L65:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        if (this.f4454b == true) goto L21;
        monitor-enter(this);
        r0<Boolean> r111 = this.f4455c;     // Catch: Throwable -> L66
        if (r111 != null) goto L26;
    L30:
        r111 = h.b(this.f4456d, null, null, new CertProvisionImpl$waitCertProvisioned$sharedWait$1$2(this, null), 3, null);     // Catch: Throwable -> L66
        this.f4455c = r111;     // Catch: Throwable -> L66
    L31:
        monitor-exit(this);
        r10.L$0 = this;     // Catch: Throwable -> L51
        r10.L$1 = r111;     // Catch: Throwable -> L51
        r10.label = 1;     // Catch: Throwable -> L51
        Object r20 = r111.r(r10);     // Catch: Throwable -> L51
        if (r20 != r12) goto L35;
        return r12;
    L35:
        r17 = this;
        r16 = r111;
        r14 = r20;
    L51:
        th = move-exception;
        r17 = this;
        r16 = r111;
        th = th;
        goto L54
    L26:
        if (r111.isActive() == true) goto L29;
        r111 = null;
    L29:
        if (r111 != null) goto L31;
    L66:
        th = move-exception;
        throw th;
    L21:
        return Boxing.boxBoolean(true);
    L7:
        r10 = new CertProvisionImpl$waitCertProvisioned$1(this, r13);
        goto L8
    }
}
