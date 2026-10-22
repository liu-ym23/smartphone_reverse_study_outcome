package com.bytedance.ai.process;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.s;
import kotlinx.coroutines.v;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f2416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static s f2417c;
    public static final AtomicBoolean d = null;
    public static final int e = 0;
    public static final long f = 0;
    public static final e1 g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Binder f2418h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static u0.c f2419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IBinder f2420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static a f2421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f2422l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AISDKRemoteServiceProxy$initBroadcastReceiver$1 f2423m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f2424n = null;

    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.ai.process.AISDKRemoteServiceProxy$initBroadcastReceiver$1] */
    static {
        f2415a = new d();
        f2417c = j0.a();
        d = new AtomicBoolean(false);
        e = 3;
        f = 100;
        g = new e1(Executors.newSingleThreadExecutor());
        f2418h = new Binder();
        b r5 = new b(0);
        r5.attachInterface(r5, "com.bytedance.ai.process.IAISDKClientCallback");
        f2422l = r5;
        f2423m = new AISDKRemoteServiceProxy$initBroadcastReceiver$1();
        f2424n = new c();
    }

    public static void b(Application r10, u0.c r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "multiProcessConfig");
        f2419i = r11;
        String r12 = r11.f22210b;
        if (r12 == null) goto L11;
        IntentFilter r5 = new IntentFilter(ai.j0.j(r12, ".AISDK_INIT_ACTION"));
        String r13 = ug.a.c(new StringBuilder("register receiver: "), r12, ".AISDK_INIT_ACTION", "AISDKRemoteServiceProxy");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L8;
        r14.d("AISDKRemoteServiceProxy", r13);
    L8:
        if (Build.VERSION.SDK_INT < 34) goto L10;
        r10.registerReceiver(f2423m, r5, "com.bytedance.ai.process.INIT_BROADCAST_ACCESS", null, 2);
        goto L11
    L10:
        r10.registerReceiver(f2423m, r5, "com.bytedance.ai.process.INIT_BROADCAST_ACCESS", null);
    L11:
        BuildersKt.launch$default(h0.a(g), null, null, new AISDKRemoteServiceProxy$init$2(null), 3, null);
    }

    public static void c(Context r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        r5.unbindService(f2424n);     // Catch: Throwable -> L4
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L11;
        String r13 = "unbindService failed: " + r12;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L11;
        r14.e("AISDKRemoteServiceProxy", r13);
    L11:
        IBinder r15 = f2420j;
        if (r15 == null) goto L26;
        a r16 = f2421k;
        if (r16 != null) goto L22;
        return;
    L22:
        Object r17 = Result.m124constructorimpl(Boolean.valueOf(r15.unlinkToDeath(r16, 0)));     // Catch: Throwable -> L18
    L20:
        Result.m123boximpl(r17);
        return;
    L18:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    L26:
        return;
    L4:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void d(Throwable r5) {
        f2416b = null;
        f2420j = null;
        if (f2417c.isCompleted() == true) goto L6;
        s r10 = f2417c;
        r10.getClass();
        r10.N(new v(false, r5));
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0218 -> B:155:0x030b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x0308 -> B:155:0x030b). Please report as a decompilation issue!!! */
    public final Object a(ContinuationImpl r24) {
        d r5 = this;
        if ((r24 instanceof AISDKRemoteServiceProxy$ensureInitialize$1) == false) goto L7;
        AISDKRemoteServiceProxy$ensureInitialize$1 r10 = (AISDKRemoteServiceProxy$ensureInitialize$1) r24;
        int r11 = r10.g;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.g = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.e;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.g;
        AtomicBoolean r15 = d;
        int r16 = e;
        long r17 = f;
        boolean r18 = false;
        if (r14 == 0) goto L28;
        if (r14 == 1) goto L23;
        if (r14 == 2) goto L22;
        if (r14 == 3) goto L17;
        if (r14 == 4) goto L22;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r19 = r10.d;
        int r20 = r10.f2409c;
        Context r21 = (Context) r10.f2408b;
        d r110 = r10.f2407a;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L20
        r15 = r15;
    L159:
        Object r22 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L119
    L125:
        if (Result.m127exceptionOrNullimpl(r22) == null) goto L127;
        AtomicBoolean r23 = r15;
        r23.set(false);
    L128:
        long r111 = SystemClock.uptimeMillis() - r19;
        g r25 = f2416b;
        if (r25 == null) goto L135;
        IBinder r26 = ((e) r25).f2425a;
        if (r26 == null) goto L135;
        if (r26.isBinderAlive() != true) goto L135;
        boolean r27 = true;
    L136:
        r15 = r23;
        String r28 = "initialize await done success=" + Result.m131isSuccessimpl(r22) + " binderAlive=" + r27 + " costMs=" + r111 + " attempt=" + r20;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L140;
        r29.i("AISDKRemoteServiceProxy", r28);
    L140:
        if (Result.m131isSuccessimpl(r22) == false) goto L144;
        if (r27 == false) goto L144;
        return Unit.INSTANCE;
    L144:
        r110.getClass();
        c(r21);
        f2416b = null;
        f2420j = null;
        boolean r30 = true;
        int r31 = r20 + 1;
        if (r31 > 0) goto L147;
        long r112 = r17;
    L148:
        if (r31 <= r16) goto L149;
    L110:
        AtomicBoolean r32 = r15;
        boolean r33 = false;
    L157:
        r32.set(r33);
        return Unit.INSTANCE;
    L149:
        String r34 = "initialize failed, retryIn=" + r112 + "ms attempt=" + r31;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r35 = com.bytedance.ai.utils.c.f2846a;
        if (r35 == null) goto L152;
        r35.e("AISDKRemoteServiceProxy", r34);
    L152:
        r10.f2407a = r110;
        r10.f2408b = r21;
        r10.f2409c = r31;
        r10.g = 4;
        if (DelayKt.delay(r112, r10) != r13) goto L155;
    L154:
        return r13;
    L155:
        r20 = r31;
        r15 = r15;
        r18 = false;
    L68:
        if (r20 <= r16) goto L70;
        r32 = r15;
        r33 = r18;
        goto L157
    L70:
        if (f2417c.isCompleted() == false) goto L72;
        f2417c = j0.a();
    L72:
        r19 = SystemClock.uptimeMillis();
        Intent r36 = new Intent("com.bytedance.ai.process.REMOTE_SERVICE_ACTION");
        r36.putExtra("packageNameOfCaller", r21.getPackageName());
        u0.c r37 = f2419i;
        if (r37 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessConfig");
        r37 = null;
    L75:
        String r38 = r37.f22210b;
        if (r38 == null) goto L169;
        r36.setComponent(new ComponentName(r38, "com.bytedance.ai.process.AISDKRemoteService"));
    L169:
        boolean r39 = r21.bindService(r36, f2424n, 1);     // Catch: Throwable -> L81 SecurityException -> L83
    L94:
        String r40 = "bindService result: " + r39 + " attempt=" + r20;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r41 = com.bytedance.ai.utils.c.f2846a;
        if (r41 == null) goto L97;
        r41.i("AISDKRemoteServiceProxy", r40);
    L97:
        if (r39 == true) goto L161;
        r31 = r20 + 1;
        r110.getClass();
        if (r31 > 0) goto L101;
        long r42 = r17;
    L102:
        String r43 = "bindService failed, retryIn=" + r42 + "ms attempt=" + r31;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r44 = com.bytedance.ai.utils.c.f2846a;
        if (r44 == null) goto L105;
        r44.e("AISDKRemoteServiceProxy", r43);
    L105:
        if (r31 > r16) goto L110;
        r10.f2407a = r110;
        r10.f2408b = r21;
        r10.f2409c = r31;
        r10.g = 2;
        if (DelayKt.delay(r42, r10) == r13) goto L154;
        r30 = true;
        goto L155
    L101:
        r42 = (1 << RangesKt.coerceAtMost(r20, 8)) * r17;
        goto L102
    L161:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L121
        s r46 = f2417c;     // Catch: Throwable -> L121
        r10.f2407a = r110;     // Catch: Throwable -> L121
        r10.f2408b = r21;     // Catch: Throwable -> L121
        r10.f2409c = r20;     // Catch: Throwable -> L121
        r10.d = r19;     // Catch: Throwable -> L121
        r10.g = 3;     // Catch: Throwable -> L119
        if (r46.d(r10) != r13) goto L159;
    L121:
        Throwable th2 = th;
    L123:
        Result.Companion r47 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th2));
        goto L125
    L83:
        e = move-exception;
        String r48 = "bindService SecurityException: " + e;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r49 = com.bytedance.ai.utils.c.f2846a;
        if (r49 == null) goto L93;
        r49.e("AISDKRemoteServiceProxy", r48);
    L93:
        r110.getClass();
        c(r21);
        d(e);
    L89:
        r39 = false;
    L81:
        th = move-exception;
        String r50 = "bindService error: " + th;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r51 = com.bytedance.ai.utils.c.f2846a;
        if (r51 == null) goto L88;
        r51.e("AISDKRemoteServiceProxy", r50);
    L88:
        r110.getClass();
        c(r21);
        d(th);
        goto L89
    L147:
        r112 = (1 << RangesKt.coerceAtMost(r20, 8)) * r17;
    L135:
        r27 = false;
        goto L136
    L127:
        r23 = r15;
    L119:
        th2 = th;
    L20:
        th2 = th;
        r15 = r15;
    L22:
        int r52 = r10.f2409c;
        r21 = (Context) r10.f2408b;
        d r113 = r10.f2407a;
        ResultKt.throwOnFailure(r12);
        r31 = r52;
        r15 = r15;
        r110 = r113;
        r30 = true;
        goto L155
    L23:
        u0.a r53 = (u0.a) r10.f2408b;
        d r54 = r10.f2407a;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L26
        u0.a r55 = r53;
        r5 = r54;
    L51:
        g r56 = f2416b;
        if (r56 == null) goto L60;
        IBinder r57 = ((e) r56).f2425a;
        if (r57 == null) goto L60;
        if (r57.isBinderAlive() != true) goto L60;
        return Unit.INSTANCE;
    L60:
        if (r15.compareAndSet(true, false) == true) goto L64;
        return Unit.INSTANCE;
    L64:
        if (r15.compareAndSet(false, true) == false) goto L66;
    L67:
        r21 = r55.f22194a;
        r110 = r5;
        r20 = 0;
        goto L68
    L66:
        return Unit.INSTANCE;
    L26:
        th = th;
        r55 = r53;
        r5 = r54;
    L48:
        r15.set(false);
        String r58 = "ensureInitialize await exception: " + th;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r114 = com.bytedance.ai.utils.c.f2846a;
        if (r114 == null) goto L51;
        r114.e("AISDKRemoteServiceProxy", r58);
        goto L51
    L28:
        ResultKt.throwOnFailure(r12);
        r55 = s0.a.f21800c;
        if (r55 != null) goto L35;
        Intrinsics.checkNotNullParameter("AISDKRemoteService", "tag");
        t0.d r59 = com.bytedance.ai.utils.c.f2846a;
        if (r59 == null) goto L34;
        r59.e("AISDKRemoteService", "application is NULL");
    L34:
        return Unit.INSTANCE;
    L35:
        g r60 = f2416b;
        if (r60 == null) goto L43;
        if (((e) r60).f2425a.isBinderAlive() == true) goto L40;
        f2416b = null;
        f2420j = null;
        r15.set(false);
        goto L43
    L40:
        return Unit.INSTANCE;
    L43:
        if (r15.compareAndSet(false, true) == true) goto L67;
        s r61 = f2417c;     // Catch: Throwable -> L47
        r10.f2407a = r5;     // Catch: Throwable -> L47
        r10.f2408b = r55;     // Catch: Throwable -> L47
        r10.g = 1;     // Catch: Throwable -> L47
        if (r61.d(r10) != r13) goto L51;
    L47:
        th = th;
    L7:
        r10 = new AISDKRemoteServiceProxy$ensureInitialize$1(r5, r24);
        goto L8
    }

    public final Object e(ContinuationImpl r5) {
        if ((r5 instanceof AISDKRemoteServiceProxy$getRemoteService$1) == false) goto L7;
        AISDKRemoteServiceProxy$getRemoteService$1 r10 = (AISDKRemoteServiceProxy$getRemoteService$1) r5;
        int r11 = r10.f2412c;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f2412c = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2410a;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.f2412c;
        if (r14 == 0) goto L17;
        if (r14 != 1) goto L16;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L13
    L21:
        Object r15 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L24:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L29;
        String r17 = "ensureInitialize failed: " + r16;
        Intrinsics.checkNotNullParameter("AISDKRemoteServiceProxy", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L29;
        r18.e("AISDKRemoteServiceProxy", r17);
    L29:
        g r19 = f2416b;
        if (r19 != null) goto L32;
    L34:
        return null;
    L32:
        if (((e) r19).f2425a.isBinderAlive() == false) goto L34;
        return r19;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r12);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L13
        r10.f2412c = 1;     // Catch: Throwable -> L13
        if (a(r10) != r13) goto L21;
        return r13;
    L13:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L7:
        r10 = new AISDKRemoteServiceProxy$getRemoteService$1(this, r5);
        goto L8
    }
}
