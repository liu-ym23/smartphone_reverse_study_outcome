package com.obric.aikernel.phx.sdk.api;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.cae.libs.useraware.ApWakeEvent;
import ge.p;
import he.o;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.CancellationException;
import pe.a0;
import pe.e1;
import pe.g0;
import pe.h0;
import pe.n0;
import pe.s1;
import pe.x;
import pe.x1;
import pe.z;

/* JADX INFO: loaded from: classes.dex */
public final class AIKernelApi implements IAIKernelManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f5238d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ua.c f5239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ue.d f5240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5241c;

    public static final class Companion {

        @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", l = {277, 391}, m = "getPackageInfos-BWLJW6A")
        public static final class a extends ce.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AIKBinder f5242a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List f5243b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public ae.f f5244m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public o f5245n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public /* synthetic */ Object f5246o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ Companion f5247p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public int f5248q;

            public a(Companion r8, ae.d<? super a> r10) {
                this.f5247p = r8;
                super(r10);
            }

            @Override // ce.a
            public final Object invokeSuspend(Object r8) {
                this.f5246o = r8;
                this.f5248q |= Integer.MIN_VALUE;
                Object r10 = this.f5247p.a(null, null, null, this);
                if (r10 != be.a.f3165a) goto L6;
                return r10;
            L6:
                return new xd.e(r10);
            }
        }

        public static final class b extends he.j implements ge.a<xd.j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ pe.g<xd.e<? extends List<PackageResource>>> f5249a;

            public b(pe.h r8) {
                this.f5249a = r8;
                super(0);
            }

            @Override // ge.a
            public final xd.j f() {
                defpackage.c.c0(new xd.e(defpackage.c.D(new AIKernelException(113, "binder died!", null, 0, 12, null))), this.f5249a);
                return xd.j.f13877a;
            }
        }

        @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", l = {358, 388}, m = "loadPackage")
        public static final class c extends ce.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AIKBinder f5250a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f5251b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public Object f5252m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public Object f5253n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public /* synthetic */ Object f5254o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ Companion f5255p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public int f5256q;

            public c(Companion r8, ae.d<? super c> r10) {
                this.f5255p = r8;
                super(r10);
            }

            @Override // ce.a
            public final Object invokeSuspend(Object r8) {
                this.f5254o = r8;
                this.f5256q |= Integer.MIN_VALUE;
                return this.f5255p.b(null, null, null, this);
            }
        }

        public static final class d extends he.j implements ge.a<xd.j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ pe.g<AIKBinder> f5257a;

            public d(pe.h r8) {
                this.f5257a = r8;
                super(0);
            }

            @Override // ge.a
            public final xd.j f() {
                defpackage.c.c0(null, this.f5257a);
                return xd.j.f13877a;
            }
        }

        @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion", f = "AIKernelApi.kt", l = {324, 391}, m = "updatePackages-BWLJW6A")
        public static final class e extends ce.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AIKBinder f5258a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f5259b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public Object f5260m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public Object f5261n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public /* synthetic */ Object f5262o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ Companion f5263p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public int f5264q;

            public e(Companion r8, ae.d<? super e> r10) {
                this.f5263p = r8;
                super(r10);
            }

            @Override // ce.a
            public final Object invokeSuspend(Object r8) {
                this.f5262o = r8;
                this.f5264q |= Integer.MIN_VALUE;
                Object r10 = this.f5263p.c(null, null, null, this);
                if (r10 != be.a.f3165a) goto L6;
                return r10;
            L6:
                return new xd.e(r10);
            }
        }

        public static final class f extends he.j implements ge.a<xd.j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ pe.g<xd.e<? extends List<PackageResource>>> f5265a;

            public f(pe.h r8) {
                this.f5265a = r8;
                super(0);
            }

            @Override // ge.a
            public final xd.j f() {
                defpackage.c.c0(new xd.e(defpackage.c.D(new AIKernelException(113, "binder died!", null, 0, 12, null))), this.f5265a);
                return xd.j.f13877a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11, types: [he.o] */
        /* JADX WARN: Type inference failed for: r2v12, types: [he.o] */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [he.o] */
        /* JADX WARN: Type inference failed for: r2v7, types: [T, pe.e1] */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v5, types: [he.o] */
        public final Object a(AIKBinder r22, List<String> r23, RequestParams r24, ae.d<? super xd.e<? extends List<PackageResource>>> r25) {
            if ((r25 instanceof a) == false) goto L7;
            a r8 = (a) r25;
            int r10 = r8.f5248q;
            if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
            r8.f5248q = r10 - Integer.MIN_VALUE;
        L8:
            Object r11 = r8.f5246o;
            be.a r12 = be.a.f3165a;
            ?? r13 = r8.f5248q;
            if (r13 == 0) goto L22;
            if (r13 == 1) goto L19;
            if (r13 != 2) goto L18;
            ?? r14 = r8.f5245n;
            defpackage.c.m0(r11);     // Catch: Throwable -> L15
            r14 = r14;
        L31:
            Object r15 = ((xd.e) r11).f13869a;     // Catch: Throwable -> L15
            e1 r16 = (e1) r14.f8064a;     // Catch: Throwable -> L15
            if (r16 == null) goto L34;
            r16.H(null);     // Catch: Throwable -> L15
        L34:
            AIKLog r17 = AIKLog.INSTANCE;     // Catch: Throwable -> L15
            StringBuilder r18 = new StringBuilder("[SDK] end getPackageInfos: ");     // Catch: Throwable -> L15
            if ((r15 instanceof xd.e.a) == false) goto L37;
            Object r19 = null;
        L38:
            r18.append(r19);     // Catch: Throwable -> L15
            r18.append(' ');     // Catch: Throwable -> L15
            r18.append(xd.e.a(r15));     // Catch: Throwable -> L15
            r17.i("AIKernelApi", r18.toString());     // Catch: Throwable -> L15
            return ((xd.e) r11).f13869a;
        L37:
            r19 = r15;
        L15:
            th = move-exception;
            Throwable r110 = th;
            ?? r20 = r14;
        L43:
            AIKLog.INSTANCE.e("AIKernelApi", "[SDK] getPackageInfos error: " + r110);
            e1 r21 = (e1) r20.f8064a;
            if (r21 == null) goto L47;
            r21.H(null);
        L47:
            return defpackage.c.D(new AIKernelException(102, "Got remote error.", r110, 0, 8, null));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            o r26 = r8.f5245n;
            ae.f r27 = r8.f5244m;
            final List<String> r111 = r8.f5243b;
            AIKBinder r112 = r8.f5242a;
            defpackage.c.m0(r11);     // Catch: Throwable -> L41
            r13 = r26;
        L27:
            Bundle r28 = (Bundle) r11;     // Catch: Throwable -> L41
            wa.a.a(r28, null, IdlKeys.Method_GetPackageRes, IdlKeys.Call_Type_CallBiz, null, "AIKernelApi", "getPackageInfos", 201);     // Catch: Throwable -> L41
            r28.putStringArray(IdlKeys.Args_Pkgs, (String[]) r111.toArray(new String[0]));     // Catch: Throwable -> L41
            r8.f5242a = r112;     // Catch: Throwable -> L41
            r8.f5243b = r111;     // Catch: Throwable -> L41
            r8.f5244m = r27;     // Catch: Throwable -> L41
            r8.f5245n = r13;     // Catch: Throwable -> L41
            r8.getClass();     // Catch: Throwable -> L41
            r8.f5248q = 2;     // Catch: Throwable -> L41
            final pe.h r29 = new pe.h(1, l6.a.b0(r8));     // Catch: Throwable -> L41
            r29.q();     // Catch: Throwable -> L41
            r13.f8064a = ua.b.f12525a.b(r27, r112, new b(r29));     // Catch: Throwable -> L41
            r112.o0(r28, new AIKernelApi$Companion$getPackageInfos$2$2(r29, r111));     // Catch: Throwable -> L41
            r11 = r29.p();     // Catch: Throwable -> L41
            if (r11 != r12) goto L30;
            return r12;
        L30:
            r14 = r13;
            goto L31
        L22:
            defpackage.c.m0(r11);
            AIKLog.INSTANCE.i("AIKernelApi", "[SDK] start getPackageInfos count:" + r23.size());
            r27 = r8.getContext();
            o r30 = new o();
            sa.a r31 = sa.a.f12056a;     // Catch: Throwable -> L41
            r8.f5242a = r22;     // Catch: Throwable -> L41
            r8.f5243b = r23;     // Catch: Throwable -> L41
            r8.f5244m = r27;     // Catch: Throwable -> L41
            r8.f5245n = r30;     // Catch: Throwable -> L41
            r8.f5248q = 1;     // Catch: Throwable -> L41
            r11 = r31.c(r24, r8);     // Catch: Throwable -> L41
            if (r11 != r12) goto L26;
            return r12;
        L26:
            r112 = r22;
            r111 = r23;
            r13 = r30;
        L41:
            th = move-exception;
            r110 = th;
            r20 = r13;
        L7:
            r8 = new a(this, r25);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [T, pe.e1] */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [he.o] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [he.o] */
        /* JADX WARN: Type inference failed for: r3v8, types: [he.o] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v6, types: [he.o, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v9 */
        public final Object b(AIKBinder r20, String r21, RequestParams r22, ae.d<? super AIKBinder> r23) {
            if ((r23 instanceof c) == false) goto L7;
            c r8 = (c) r23;
            int r10 = r8.f5256q;
            if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
            r8.f5256q = r10 - Integer.MIN_VALUE;
        L8:
            Object r11 = r8.f5254o;
            be.a r12 = be.a.f3165a;
            ?? r13 = r8.f5256q;
            if (r13 == 0) goto L20;
            if (r13 == 1) goto L17;
            if (r13 != 2) goto L16;
            Bundle r14 = (Bundle) r8.f5253n;
            ?? r15 = (o) r8.f5252m;
            ae.f r16 = (ae.f) r8.f5251b;
            defpackage.c.m0(r11);     // Catch: Throwable -> L33
            r15 = r15;
        L29:
            AIKBinder r17 = (AIKBinder) r11;     // Catch: Throwable -> L33
            e1 r18 = (e1) r15.f8064a;     // Catch: Throwable -> L33
            if (r18 == null) goto L35;
            r18.H(null);     // Catch: Throwable -> L33
        L35:
            return r11;
        L33:
            th = th;
        L38:
            AIKLog.INSTANCE.e("AIKernelApi", "[SDK] loadPackage error: " + th);
            e1 r19 = (e1) r15.f8064a;
            if (r19 == null) goto L41;
            r19.H(null);
        L41:
            return null;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            o r24 = (o) r8.f5253n;
            ae.f r25 = (ae.f) r8.f5252m;
            String r26 = (String) r8.f5251b;
            AIKBinder r110 = r8.f5250a;
            defpackage.c.m0(r11);     // Catch: Throwable -> L36
            String r111 = r26;
            r13 = r24;
        L25:
            Bundle r27 = (Bundle) r11;     // Catch: Throwable -> L36
            wa.a.a(r27, r111, IdlKeys.Method_LoadPackage, IdlKeys.Call_Type_CallBiz, null, "AIKernelApi", "loadPackage", 200);     // Catch: Throwable -> L36
            r8.f5250a = r110;     // Catch: Throwable -> L36
            r8.f5251b = r25;     // Catch: Throwable -> L36
            r8.f5252m = r13;     // Catch: Throwable -> L36
            r8.f5253n = r27;     // Catch: Throwable -> L36
            r8.f5256q = 2;     // Catch: Throwable -> L36
            final pe.h r28 = new pe.h(1, l6.a.b0(r8));     // Catch: Throwable -> L36
            r28.q();     // Catch: Throwable -> L36
            r13.f8064a = ua.b.f12525a.b(r25, r110, new d(r28));     // Catch: Throwable -> L36
            r110.o0(r27, new AIKernelApi$Companion$loadPackage$2$2(r28));     // Catch: Throwable -> L36
            r11 = r28.p();     // Catch: Throwable -> L36
            if (r11 != r12) goto L28;
            return r12;
        L28:
            r15 = r13;
            goto L29
        L20:
            defpackage.c.m0(r11);
            AIKLog.INSTANCE.i("AIKernelApi", "[SDK] start loadPackage " + r21);
            ae.f r29 = r8.getContext();
            o r30 = new o();
            sa.a r31 = sa.a.f12056a;     // Catch: Throwable -> L36
            r110 = r20;
            r8.f5250a = r110;     // Catch: Throwable -> L36
            r8.f5251b = r21;     // Catch: Throwable -> L36
            r8.f5252m = r29;     // Catch: Throwable -> L36
            r8.f5253n = r30;     // Catch: Throwable -> L36
            r8.f5256q = 1;     // Catch: Throwable -> L36
            Object r32 = r31.c(r22, r8);     // Catch: Throwable -> L36
            if (r32 != r12) goto L24;
            return r12;
        L24:
            r111 = r21;
            r25 = r29;
            r11 = r32;
            r13 = r30;
        L36:
            th = th;
            r15 = r13;
        L7:
            r8 = new c(this, r23);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v6, types: [T, pe.e1] */
        /* JADX WARN: Type inference failed for: r3v10, types: [he.o] */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [he.o] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [he.o] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v5, types: [he.o, java.lang.Object] */
        public final Object c(AIKBinder r22, List<PackageResource> r23, RequestParams r24, ae.d<? super xd.e<? extends List<PackageResource>>> r25) {
            if ((r25 instanceof e) == false) goto L7;
            e r8 = (e) r25;
            int r10 = r8.f5264q;
            if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
            r8.f5264q = r10 - Integer.MIN_VALUE;
        L8:
            Object r11 = r8.f5262o;
            be.a r12 = be.a.f3165a;
            ?? r13 = r8.f5264q;
            if (r13 == 0) goto L22;
            if (r13 == 1) goto L19;
            if (r13 != 2) goto L18;
            Bundle r14 = (Bundle) r8.f5261n;
            ?? r15 = (o) r8.f5260m;
            ae.f r16 = (ae.f) r8.f5259b;
            defpackage.c.m0(r11);     // Catch: Throwable -> L15
            r15 = r15;
        L31:
            Object r17 = ((xd.e) r11).f13869a;     // Catch: Throwable -> L15
            e1 r18 = (e1) r15.f8064a;     // Catch: Throwable -> L15
            if (r18 == null) goto L34;
            r18.H(null);     // Catch: Throwable -> L15
        L34:
            AIKLog r19 = AIKLog.INSTANCE;     // Catch: Throwable -> L15
            StringBuilder r20 = new StringBuilder("[SDK] end updatePackages: ");     // Catch: Throwable -> L15
            if ((r17 instanceof xd.e.a) == false) goto L37;
            Object r21 = null;
        L38:
            r20.append(r21);     // Catch: Throwable -> L15
            r20.append(' ');     // Catch: Throwable -> L15
            r20.append(xd.e.a(r17));     // Catch: Throwable -> L15
            r19.i("AIKernelApi", r20.toString());     // Catch: Throwable -> L15
            return ((xd.e) r11).f13869a;
        L37:
            r21 = r17;
        L15:
            th = move-exception;
            Throwable r110 = th;
            ?? r26 = r15;
        L43:
            AIKLog.INSTANCE.e("AIKernelApi", "[SDK] updatePackages error: " + r110);
            e1 r27 = (e1) r26.f8064a;
            if (r27 == null) goto L47;
            r27.H(null);
        L47:
            return defpackage.c.D(new AIKernelException(102, "Got remote error.", r110, 0, 8, null));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            o r28 = (o) r8.f5261n;
            ae.f r29 = (ae.f) r8.f5260m;
            List<PackageResource> r111 = (List) r8.f5259b;
            AIKBinder r112 = r8.f5258a;
            defpackage.c.m0(r11);     // Catch: Throwable -> L41
            r13 = r28;
        L27:
            Bundle r30 = (Bundle) r11;     // Catch: Throwable -> L41
            wa.a.a(r30, null, IdlKeys.Method_UpdatePackages, IdlKeys.Call_Type_CallBiz, null, "AIKernelApi", "updatePackages", 201);     // Catch: Throwable -> L41
            r30.putParcelableArray(IdlKeys.Args_Pkgs, (Parcelable[]) r111.toArray(new PackageResource[0]));     // Catch: Throwable -> L41
            r8.f5258a = r112;     // Catch: Throwable -> L41
            r8.f5259b = r29;     // Catch: Throwable -> L41
            r8.f5260m = r13;     // Catch: Throwable -> L41
            r8.f5261n = r30;     // Catch: Throwable -> L41
            r8.f5264q = 2;     // Catch: Throwable -> L41
            final pe.h r31 = new pe.h(1, l6.a.b0(r8));     // Catch: Throwable -> L41
            r31.q();     // Catch: Throwable -> L41
            r13.f8064a = ua.b.f12525a.b(r29, r112, new f(r31));     // Catch: Throwable -> L41
            r112.o0(r30, new AIKernelApi$Companion$updatePackages$2$2(r31));     // Catch: Throwable -> L41
            r11 = r31.p();     // Catch: Throwable -> L41
            if (r11 != r12) goto L30;
            return r12;
        L30:
            r15 = r13;
            goto L31
        L22:
            defpackage.c.m0(r11);
            AIKLog.INSTANCE.i("AIKernelApi", "[SDK] start updatePackages count:" + r23.size());
            r29 = r8.getContext();
            o r32 = new o();
            sa.a r33 = sa.a.f12056a;     // Catch: Throwable -> L41
            r8.f5258a = r22;     // Catch: Throwable -> L41
            r8.f5259b = r23;     // Catch: Throwable -> L41
            r8.f5260m = r29;     // Catch: Throwable -> L41
            r8.f5261n = r32;     // Catch: Throwable -> L41
            r8.f5264q = 1;     // Catch: Throwable -> L41
            r11 = r33.c(r24, r8);     // Catch: Throwable -> L41
            if (r11 != r12) goto L26;
            return r12;
        L26:
            r112 = r22;
            r111 = r23;
            r13 = r32;
        L41:
            th = move-exception;
            r110 = th;
            r26 = r13;
        L7:
            r8 = new e(this, r25);
            goto L8
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {189}, m = "clearAIKernelData")
    public static final class a extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RequestParams f5270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f5271b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5272m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f5273n;

        public a(AIKernelApi r8, ae.d<? super a> r10) {
            this.f5272m = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5271b = r8;
            this.f5273n |= Integer.MIN_VALUE;
            return this.f5272m.clearAIKernelData(null, this);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {110}, m = "getPackage-0E7RQCE")
    public static final class b extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5275b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f5276m;

        public b(AIKernelApi r8, ae.d<? super b> r10) {
            this.f5275b = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5274a = r8;
            this.f5276m |= Integer.MIN_VALUE;
            Object r10 = this.f5275b.mo9getPackage0E7RQCE(null, null, this);
            if (r10 != be.a.f3165a) goto L6;
            return r10;
        L6:
            return new xd.e(r10);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$getPackage$2", f = "AIKernelApi.kt", l = {110}, m = "invokeSuspend")
    public static final class c extends ce.h implements ge.l<ae.d<? super xd.e<? extends PackageResource>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5278b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f5279m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5280n;

        public c(AIKernelApi r8, String r10, RequestParams r11, ae.d<? super c> r12) {
            this.f5278b = r8;
            this.f5279m = r10;
            this.f5280n = r11;
            super(1, r12);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            String r10 = this.f5279m;
            RequestParams r11 = this.f5280n;
            return new c(this.f5278b, r10, r11, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super xd.e<? extends PackageResource>> r8) {
            return ((c) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f5277a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
            Object r12 = ((xd.e) r8).f13869a;
        L12:
            return new xd.e(r12);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            this.f5277a = 1;
            r12 = AIKernelApi.a(this.f5278b, this.f5279m, this.f5280n, this);
            if (r12 != r10) goto L12;
            return r10;
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {132, 133}, m = "getPackageInfos-0E7RQCE")
    public static final class d extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f5283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RequestParams f5284b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f5285m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5286n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f5287o;

        public d(AIKernelApi r8, ae.d<? super d> r10) {
            this.f5286n = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5285m = r8;
            this.f5287o |= Integer.MIN_VALUE;
            Object r10 = this.f5286n.e(null, null, this);
            if (r10 != be.a.f3165a) goto L6;
            return r10;
        L6:
            return new xd.e(r10);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5", f = "AIKernelApi.kt", l = {97}, m = "invokeSuspend")
    public static final class e extends ce.h implements p<z, ae.d<? super xd.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5289b;

        public e(AIKernelApi r8, ae.d<? super e> r10) {
            this.f5289b = r8;
            super(2, r10);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
            return new e(this.f5289b, r10);
        }

        @Override // ge.p
        public final Object invoke(z r8, ae.d<? super xd.j> r10) {
            return ((e) create(r8, r10)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f5288a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
        L14:
            return xd.j.f13877a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            ua.c r12 = this.f5289b.f5239a;
            if (r12 == null) goto L15;
            this.f5288a = 1;
            if (r12.k(5000, this) != r10) goto L14;
            return r10;
        L15:
            he.i.j("connector");
            throw null;
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2", f = "AIKernelApi.kt", l = {177, 182}, m = "invokeSuspend")
    public static final class f extends ce.h implements ge.l<ae.d<? super AbsApi>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AIKBinder f5290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5291b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f5292m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f5293n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5294o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5295p;

        public f(boolean r8, String r10, AIKernelApi r11, RequestParams r12, ae.d<? super f> r13) {
            this.f5292m = r8;
            this.f5293n = r10;
            this.f5294o = r11;
            this.f5295p = r12;
            super(1, r13);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            return new f(this.f5292m, this.f5293n, this.f5294o, this.f5295p, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super AbsApi> r8) {
            return ((f) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r10) {
            be.a r8 = be.a.f3165a;
            int r11 = this.f5291b;
            AIKernelApi r12 = this.f5294o;
            RequestParams r13 = this.f5295p;
            String r14 = this.f5293n;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            AIKBinder r15 = this.f5290a;
            defpackage.c.m0(r10);
        L25:
            AIKBinder r16 = (AIKBinder) r10;
            if (r16 != null) goto L28;
            r16 = r15;
        L28:
            if (r16 != null) goto L32;
            return null;
        L32:
            return new ta.d(r14, r13, r16);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            defpackage.c.m0(r10);
        L17:
            r16 = (AIKBinder) r10;
            if (r12.f5241c == true) goto L28;
            if (r16 == null) goto L28;
            Companion r17 = AIKernelApi.f5238d;
            this.f5290a = r16;
            this.f5291b = 2;
            Object r18 = r17.b(r16, r14, r13, this);
            if (r18 != r8) goto L24;
            return r8;
        L24:
            r10 = r18;
            r15 = r16;
            goto L25
        L10:
            defpackage.c.m0(r10);
            if (this.f5292m == true) goto L13;
            this.f5291b = 1;
            r10 = AIKernelApi.d(r12, this);
            if (r10 != r8) goto L17;
            return r8;
        L13:
            return new ta.b(r14);
        }
    }

    public static final class g extends ae.a implements x {
        public g() {
            super(x.a.f10084a);
        }

        @Override // pe.x
        public final void e0(ae.f r8, Throwable r10) {
            AIKLog.INSTANCE.e("AIKernelApi", r8 + " crashed " + r10);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {ApWakeEvent.OTHER_START}, m = "updatePackage-0E7RQCE")
    public static final class h extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5297b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f5298m;

        public h(AIKernelApi r8, ae.d<? super h> r10) {
            this.f5297b = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5296a = r8;
            this.f5298m |= Integer.MIN_VALUE;
            Object r10 = this.f5297b.mo10updatePackage0E7RQCE(null, null, this);
            if (r10 != be.a.f3165a) goto L6;
            return r10;
        L6:
            return new xd.e(r10);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$updatePackage$2", f = "AIKernelApi.kt", l = {ApWakeEvent.OTHER_START}, m = "invokeSuspend")
    public static final class i extends ce.h implements ge.l<ae.d<? super xd.e<? extends PackageResource>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5300b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ PackageResource f5301m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5302n;

        public i(AIKernelApi r8, PackageResource r10, RequestParams r11, ae.d<? super i> r12) {
            this.f5300b = r8;
            this.f5301m = r10;
            this.f5302n = r11;
            super(1, r12);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            PackageResource r10 = this.f5301m;
            RequestParams r11 = this.f5302n;
            return new i(this.f5300b, r10, r11, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super xd.e<? extends PackageResource>> r8) {
            return ((i) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f5299a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
            Object r12 = ((xd.e) r8).f13869a;
        L12:
            return new xd.e(r12);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            this.f5299a = 1;
            r12 = AIKernelApi.c(this.f5300b, this.f5301m, this.f5302n, this);
            if (r12 != r10) goto L12;
            return r10;
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {165, 166}, m = "updatePackages-0E7RQCE")
    public static final class j extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f5303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RequestParams f5304b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f5305m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5306n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f5307o;

        public j(AIKernelApi r8, ae.d<? super j> r10) {
            this.f5306n = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5305m = r8;
            this.f5307o |= Integer.MIN_VALUE;
            Object r10 = this.f5306n.g(null, null, this);
            if (r10 != be.a.f3165a) goto L6;
            return r10;
        L6:
            return new xd.e(r10);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {232, 260, 262}, m = "wrapApiCall")
    public static final class k<T> extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AIKernelApi f5308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RequestParams f5309b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public h0 f5310m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f5311n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5312o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f5313p;

        public k(AIKernelApi r8, ae.d<? super k> r10) {
            this.f5312o = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5311n = r8;
            this.f5313p |= Integer.MIN_VALUE;
            return this.f5312o.h(null, null, null, this);
        }
    }

    public static final class l extends he.j implements ge.l<Throwable, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIKBinder f5314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0<T> f5315b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AIKernelApi f5316m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5317n;

        /* JADX WARN: Multi-variable type inference failed */
        public l(AIKBinder r8, g0<? extends T> r10, AIKernelApi r11, RequestParams r12) {
            this.f5314a = r8;
            this.f5315b = r10;
            this.f5316m = r11;
            this.f5317n = r12;
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(Throwable r10) {
            Throwable r11 = r10;
            if (r11 != null) goto L7;
            int r8 = 2;
        L5:
            int r12 = r8;
            AIKBinder r13 = this.f5314a;
            if (r13 == null) goto L13;
            RequestParams r14 = this.f5317n;
            l6.a.j0(AIKernelApi.b(this.f5316m), new com.obric.aikernel.phx.sdk.api.a(r14, r12, r11, r13, null));
        L13:
            e1 r15 = this.f5315b;
            if (r15.a() == true) goto L17;
            r15 = null;
        L17:
            if (r15 == null) goto L20;
            r15.H(defpackage.c.e(r11));
        L20:
            return xd.j.f13877a;
        L7:
            if ((r11 instanceof CancellationException) == false) goto L9;
            r8 = 1;
            goto L5
        L9:
            r8 = 3;
            goto L5
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$3$1", f = "AIKernelApi.kt", l = {260}, m = "invokeSuspend")
    public static final class m<T> extends ce.h implements p<z, ae.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0<T> f5319b;

        /* JADX WARN: Multi-variable type inference failed */
        public m(g0<? extends T> r8, ae.d<? super m> r10) {
            this.f5319b = r8;
            super(2, r10);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
            return new m(this.f5319b, r10);
        }

        @Override // ge.p
        public final Object invoke(z r8, Object r10) {
            return ((m) create(r8, (ae.d) r10)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f5318a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            this.f5318a = 1;
            r8 = this.f5319b.c0(this);
            if (r8 != r10) goto L11;
            return r10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @ce.e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$ipcJob$1", f = "AIKernelApi.kt", l = {225, 226}, m = "invokeSuspend")
    public static final class n<T> extends ce.h implements p<z, ae.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ge.l f5320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5321b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5322m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ge.l<ae.d<? super T>, Object> f5323n;

        /* JADX WARN: Multi-variable type inference failed */
        public n(RequestParams r8, ge.l<? super ae.d<? super T>, ? extends Object> r10, ae.d<? super n> r11) {
            this.f5322m = r8;
            this.f5323n = r10;
            super(2, r11);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
            return new n(this.f5322m, this.f5323n, r10);
        }

        @Override // ge.p
        public final Object invoke(z r8, Object r10) {
            return ((n) create(r8, (ae.d) r10)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f5321b;
            if (r11 == 0) goto L13;
            if (r11 == 1) goto L10;
            if (r11 != 2) goto L9;
            defpackage.c.m0(r8);     // Catch: Throwable -> L20
        L22:
            Throwable r12 = xd.e.a(r8);
            if (r12 == null) goto L26;
            AIKLog.INSTANCE.w("AIKernelApi", "asyncTransact got exception: " + r12);
        L26:
            if ((r8 instanceof xd.e.a) == false) goto L29;
            return null;
        L29:
            return r8;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ge.l<ae.d<? super T>, Object> r13 = this.f5320a;
            defpackage.c.m0(r8);     // Catch: Throwable -> L20
        L17:
            this.f5320a = null;     // Catch: Throwable -> L20
            this.f5321b = 2;     // Catch: Throwable -> L20
            r8 = r13.invoke(this);     // Catch: Throwable -> L20
            if (r8 != r10) goto L22;
            return r10;
        L13:
            defpackage.c.m0(r8);
            RequestParams r14 = this.f5322m;
            r13 = this.f5323n;
            sa.a r15 = sa.a.f12056a;     // Catch: Throwable -> L20
            this.f5320a = r13;     // Catch: Throwable -> L20
            this.f5321b = 1;     // Catch: Throwable -> L20
            if (r15.c(r14, this) != r10) goto L17;
            return r10;
        L20:
            th = move-exception;
            r8 = defpackage.c.D(th);
            goto L22
        }
    }

    static {
        f5238d = new Companion();
    }

    public AIKernelApi() {
        ve.b r8 = n0.f10049b;
        s1 r10 = l6.a.e();
        r8.getClass();
        this.f5240b = a0.a(ae.f.a.a(r8, r10).C(new g()));
        this.f5241c = true;
    }

    public static final Object a(AIKernelApi r8, String r10, RequestParams r11, ae.d r12) {
        r8.getClass();
        if ((r12 instanceof va.a) == false) goto L7;
        va.a r13 = (va.a) r12;
        int r14 = r13.f12778m;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f12778m = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f12776a;
        Object r16 = be.a.f3165a;
        int r17 = r13.f12778m;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        defpackage.c.m0(r15);
        Object r18 = ((xd.e) r15).f13869a;
    L19:
        boolean r19 = r18 instanceof xd.e.a;
        if ((!r19) == false) goto L28;
        if (r19 == false) goto L23;
        r18 = null;
    L23:
        List r20 = (List) r18;
        if (r20 == null) goto L36;
        Object r21 = (PackageResource) yd.i.g1(r20);
        if (r21 == null) goto L36;
    L33:
        return r21;
    L36:
        return defpackage.c.D(new AIKernelException(108, "call success but got null!", null, 0, 12, null));
    L28:
        AIKernelException.Companion.getClass();
        Throwable r22 = xd.e.a(r18);
        if (r22 != null) goto L31;
        r22 = new AIKernelException(108, "call failed but no exception set.", null, 0, 12, null);
    L31:
        r21 = defpackage.c.D(r22);
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r15);
        if (r11.getUseLocalPapaya() == true) goto L35;
        List<String> r23 = l6.a.k0(r10);
        r13.f12778m = 1;
        r18 = r8.e(r23, r11, r13);
        if (r18 != r16) goto L19;
        return r16;
    L35:
        throw new xd.c();
    L7:
        r13 = new va.a(r8, r12);
        goto L8
    }

    public static final /* synthetic */ ue.d b(AIKernelApi r8) {
        return r8.f5240b;
    }

    public static final Object c(AIKernelApi r8, PackageResource r10, RequestParams r11, ae.d r12) {
        r8.getClass();
        if ((r12 instanceof va.b) == false) goto L7;
        va.b r13 = (va.b) r12;
        int r14 = r13.f12781m;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f12781m = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f12779a;
        Object r16 = be.a.f3165a;
        int r17 = r13.f12781m;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        defpackage.c.m0(r15);
        Object r18 = ((xd.e) r15).f13869a;
    L19:
        boolean r19 = r18 instanceof xd.e.a;
        if ((!r19) == false) goto L28;
        if (r19 == false) goto L23;
        r18 = null;
    L23:
        List r20 = (List) r18;
        if (r20 == null) goto L36;
        Object r21 = (PackageResource) yd.i.g1(r20);
        if (r21 == null) goto L36;
    L33:
        return r21;
    L36:
        return defpackage.c.D(new AIKernelException(108, "call success but got null!", null, 0, 12, null));
    L28:
        AIKernelException.Companion.getClass();
        Throwable r22 = xd.e.a(r18);
        if (r22 != null) goto L31;
        r22 = new AIKernelException(108, "call failed but no exception set.", null, 0, 12, null);
    L31:
        r21 = defpackage.c.D(r22);
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r15);
        if (r11.getUseLocalPapaya() == true) goto L35;
        List<PackageResource> r23 = l6.a.k0(r10);
        r13.f12781m = 1;
        r18 = r8.g(r23, r11, r13);
        if (r18 != r16) goto L19;
        return r16;
    L35:
        throw new xd.c();
    L7:
        r13 = new va.b(r8, r12);
        goto L8
    }

    public static Object d(AIKernelApi r8, ae.d r10) {
        ua.c r11 = r8.f5239a;
        if (r11 != null) goto L5;
        he.i.j("connector");
        throw null;
    L5:
        return r11.k(5000, r10);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public final Object clearAIKernelData(RequestParams r10, ae.d<? super xd.j> r11) {
        if ((r11 instanceof a) == false) goto L7;
        a r8 = (a) r11;
        int r12 = r8.f5273n;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5273n = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r8.f5271b;
        be.a r14 = be.a.f3165a;
        int r15 = r8.f5273n;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r10 = r8.f5270a;
        defpackage.c.m0(r13);
    L19:
        AIKBinder r16 = (AIKBinder) r13;
        if (r16 != null) goto L31;
        AIKLog.INSTANCE.d("AIKernelApi", "binder is not ready.");
        return xd.j.f13877a;
    L31:
        Bundle r17 = r10.start();     // Catch: RemoteException -> L25
        wa.a.a(r17, "", IdlKeys.Method_ClearData, IdlKeys.Call_Type_CallBiz, "", "AIKernelApi", "clearAIKernelData", 192);     // Catch: RemoteException -> L25
        AIKLog.INSTANCE.i("AIKernelApi", "[SDK] clearAIKernelData formatBundle:" + r17);     // Catch: RemoteException -> L25
        r16.o0(r17, new AnonymousClass2());     // Catch: RemoteException -> L25
    L28:
        return xd.j.f13877a;
    L25:
        e = move-exception;
        AIKLog.INSTANCE.e("AIKernelApi", "clearAIKernelData error: " + e);
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r13);
        r8.f5270a = r10;
        r8.f5273n = 1;
        ua.c r18 = this.f5239a;
        if (r18 == null) goto L29;
        r13 = r18.k(60000, r8);
        if (r13 != r14) goto L19;
        return r14;
    L29:
        he.i.j("connector");
        throw null;
    L7:
        r8 = new a(this, r11);
        goto L8
    }

    public final Object e(List<String> r10, RequestParams r11, ae.d<? super xd.e<? extends List<PackageResource>>> r12) {
        if ((r12 instanceof d) == false) goto L7;
        d r8 = (d) r12;
        int r13 = r8.f5287o;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5287o = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r8.f5285m;
        be.a r15 = be.a.f3165a;
        int r16 = r8.f5287o;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        defpackage.c.m0(r14);
        return ((xd.e) r14).f13869a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r8.f5284b;
        r10 = r8.f5283a;
        defpackage.c.m0(r14);
    L19:
        AIKBinder r17 = (AIKBinder) r14;
        if (r17 == null) goto L25;
        Companion r18 = f5238d;
        r8.f5283a = null;
        r8.f5284b = null;
        r8.f5287o = 2;
        Object r19 = r18.a(r17, r10, r11, r8);
        if (r19 != r15) goto L27;
        return r15;
    L27:
        return r19;
    L25:
        return defpackage.c.D(new AIKernelException(102, "Binder not ready.", null, 0, 12, null));
    L16:
        defpackage.c.m0(r14);
        r8.f5283a = r10;
        r8.f5284b = r11;
        r8.f5287o = 1;
        r14 = d(this, r8);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r8 = new d(this, r12);
        goto L8
    }

    public final synchronized void f(AIKernelConfig r10, ILog r11) {
        monitor-enter(this);
        he.i.f(r10, "config");     // Catch: Throwable -> L44
        if (this.f5239a == null) goto L9;
        AIKLog.INSTANCE.d("AIKernelApi", "sdk is already inited!");     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L9:
        ra.a.f11538a = r10;     // Catch: Throwable -> L44
        ra.a.f11539b = "3.0.0-SNAPSHOT";     // Catch: Throwable -> L44
        ra.a.f11540c = r10.getAuthBySign();     // Catch: Throwable -> L44
        if (r11 == null) goto L12;
        AIKLog.INSTANCE.registerLog(r11);     // Catch: Throwable -> L44
    L12:
        ComponentName r12 = new ComponentName(IAIKernelManager.PACKAGE_NAME_AIK, IAIKernelManager.SERVICE_NAME);     // Catch: Throwable -> L44
        ComponentName r8 = new ComponentName("com.larus.nova", IAIKernelManager.SERVICE_NAME);     // Catch: Throwable -> L34
        PackageManager r13 = r10.getContext().getPackageManager();     // Catch: Throwable -> L34
        Intent r14 = new Intent();     // Catch: Throwable -> L34
        r14.setComponent(r8);     // Catch: Throwable -> L34
        List<ResolveInfo> r15 = r13.queryIntentServices(r14, 131072);     // Catch: Throwable -> L34
        if (r15 != null) goto L17;
    L20:
        boolean r16 = true;
    L21:
        if (r16 == false) goto L48;
        PackageInfo r17 = r10.getContext().getPackageManager().getPackageInfo(IAIKernelManager.PACKAGE_NAME_AIK, 0);     // Catch: Throwable -> L34
        if (r17 != null) goto L25;
        Object r18 = null;
    L38:
        Throwable r19 = xd.e.a(r18);     // Catch: Throwable -> L44
        if (r19 == null) goto L41;
        AIKLog r20 = AIKLog.INSTANCE;     // Catch: Throwable -> L44
        StringWriter r21 = new StringWriter();     // Catch: Throwable -> L44
        PrintWriter r22 = new PrintWriter(r21);     // Catch: Throwable -> L44
        r19.printStackTrace(r22);     // Catch: Throwable -> L44
        r22.flush();     // Catch: Throwable -> L44
        String r23 = r21.toString();     // Catch: Throwable -> L44
        he.i.e(r23, "sw.toString()");     // Catch: Throwable -> L44
        r20.e("AIKernelApi", "getServicePackageInfo failed: ".concat(r23));     // Catch: Throwable -> L44
    L41:
        this.f5239a = new ua.c(r10.getContext(), r10, r12);     // Catch: Throwable -> L44
        l6.a.j0(this.f5240b, new e(this, null));     // Catch: Throwable -> L44
        AIKLog.INSTANCE.i("AIKernelApi", "initialize success.");     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L25:
        if (r17.getLongVersionCode() < 200000999) goto L27;
        this.f5241c = false;     // Catch: Throwable -> L34
    L27:
        r18 = xd.j.f13877a;     // Catch: Throwable -> L34
        goto L38
    L48:
        this.f5241c = false;     // Catch: Throwable -> L32
        Object r110 = xd.j.f13877a;     // Catch: Throwable -> L32
    L37:
        ComponentName r24 = r8;
        r18 = r110;
        r12 = r24;
    L32:
        Throwable th = th;
    L36:
        r110 = defpackage.c.D(th);     // Catch: Throwable -> L44
        goto L37
    L17:
        if (r15.isEmpty() == true) goto L20;
        r16 = false;
    L34:
        th = move-exception;
        r8 = r12;
        th = th;
    L44:
        th = move-exception;
        throw th;
    }

    public final Object g(List<PackageResource> r10, RequestParams r11, ae.d<? super xd.e<? extends List<PackageResource>>> r12) {
        if ((r12 instanceof j) == false) goto L7;
        j r8 = (j) r12;
        int r13 = r8.f5307o;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5307o = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r8.f5305m;
        be.a r15 = be.a.f3165a;
        int r16 = r8.f5307o;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        defpackage.c.m0(r14);
        return ((xd.e) r14).f13869a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r8.f5304b;
        r10 = r8.f5303a;
        defpackage.c.m0(r14);
    L19:
        AIKBinder r17 = (AIKBinder) r14;
        if (r17 == null) goto L25;
        Companion r18 = f5238d;
        r8.f5303a = null;
        r8.f5304b = null;
        r8.f5307o = 2;
        Object r19 = r18.c(r17, r10, r11, r8);
        if (r19 != r15) goto L27;
        return r15;
    L27:
        return r19;
    L25:
        return defpackage.c.D(new AIKernelException(102, "Binder is null.", null, 0, 12, null));
    L16:
        defpackage.c.m0(r14);
        AIKLog.INSTANCE.i("AIKernelApi", "[SDK] updatePackages count:" + r10.size());
        r8.f5303a = r10;
        r8.f5304b = r11;
        r8.f5307o = 1;
        r14 = d(this, r8);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r8 = new j(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    public final Object mo9getPackage0E7RQCE(String r8, RequestParams r10, ae.d<? super xd.e<PackageResource>> r11) {
        if ((r11 instanceof b) == false) goto L7;
        b r12 = (b) r11;
        int r13 = r12.f5276m;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f5276m = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f5274a;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f5276m;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        defpackage.c.m0(r14);
    L17:
        xd.e r17 = (xd.e) r14;
        if (r17 == null) goto L21;
        return r17.f13869a;
    L21:
        return defpackage.c.D(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r14);
        c r18 = new c(this, r8, r10, null);
        r12.f5276m = 1;
        r14 = h(r10, null, r18, r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new b(this, r11);
        goto L8
    }

    public final <T> Object h(RequestParams r11, AIKBinder r12, ge.l<? super ae.d<? super T>, ? extends Object> r13, ae.d<? super T> r14) {
        if ((r14 instanceof k) == false) goto L7;
        k r8 = (k) r14;
        int r10 = r8.f5313p;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5313p = r10 - Integer.MIN_VALUE;
    L8:
        Object r15 = r8.f5311n;
        be.a r16 = be.a.f3165a;
        int r17 = r8.f5313p;
        if (r17 == 0) goto L18;
        if (r17 == 1) goto L17;
        if (r17 == 2) goto L16;
        if (r17 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        defpackage.c.m0(r15);
    L36:
        return r15;
    L17:
        h0 r18 = r8.f5310m;
        r11 = r8.f5309b;
        AIKernelApi r19 = r8.f5308a;
        defpackage.c.m0(r15);
    L24:
        AIKBinder r110 = (AIKBinder) r15;
        h0 r111 = r18;
        AIKernelApi this = r19;
        r12 = r110;
    L25:
        e1 r112 = (e1) r8.getContext().q0(e1.b.f10008a);
        if (r112 == null) goto L28;
        r112.i(new l(r12, r111, this, r11));
    L28:
        long r113 = r11.getTimeout();
        if (r113 <= 0) goto L33;
        m r114 = new m(r111, null);
        r8.f5308a = null;
        r8.f5309b = null;
        r8.f5310m = null;
        r8.f5313p = 2;
        r15 = x1.b(r113, r114, r8);
        if (r15 != r16) goto L36;
        return r16;
    L33:
        r8.f5308a = null;
        r8.f5309b = null;
        r8.f5310m = null;
        r8.f5313p = 3;
        r15 = r111.c0(r8);
        if (r15 != r16) goto L36;
        return r16;
    L18:
        defpackage.c.m0(r15);
        n r115 = new n(r11, r13, null);
        r111 = l6.a.n(this.f5240b, r115);
        if (r12 != null) goto L25;
        r8.f5308a = this;
        r8.f5309b = r11;
        r8.f5310m = r111;
        r8.f5313p = 1;
        r15 = d(this, r8);
        if (r15 != r16) goto L23;
        return r16;
    L23:
        r19 = this;
        r18 = r111;
    L7:
        r8 = new k(this, r14);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public final Object loadPackage(String r8, boolean r10, RequestParams r11, ae.d<? super IBaseModel> r12) {
        return h(r11, null, new f(r10, r8, this, r11, null), r12);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    public final Object mo10updatePackage0E7RQCE(PackageResource r8, RequestParams r10, ae.d<? super xd.e<PackageResource>> r11) {
        if ((r11 instanceof h) == false) goto L7;
        h r12 = (h) r11;
        int r13 = r12.f5298m;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f5298m = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f5296a;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f5298m;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        defpackage.c.m0(r14);
    L17:
        xd.e r17 = (xd.e) r14;
        if (r17 == null) goto L21;
        return r17.f13869a;
    L21:
        return defpackage.c.D(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r14);
        i r18 = new i(this, r8, r10, null);
        r12.f5298m = 1;
        r14 = h(r10, null, r18, r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new h(this, r11);
        goto L8
    }
}
