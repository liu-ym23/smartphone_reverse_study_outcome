package com.larus.bmhome.upload.sdk.impl.core;

import com.larus.bmhome.upload.sdk.api.model.UploadStage;
import com.larus.bmhome.upload.sdk.impl.post.PostUploadActionChain;
import is8.g;
import is8.h;
import is8.j;
import is8.k;
import is8.l;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class UploadOrchestrator {
    public final ks8.b a;
    public final js8.a b;
    public final com.larus.bmhome.upload.sdk.impl.engine.a c;
    public final PostUploadActionChain d;
    public final UploadPreprocessChain e;

    public final Object b(String r23, g r24, e r25, Continuation<? super Unit> r26) {
        e r2 = r25;
        if ((r26 instanceof UploadOrchestrator$execute$1) == false) goto L7;
        UploadOrchestrator$execute$1 r4 = (UploadOrchestrator$execute$1) r26;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        UploadOrchestrator$execute$1 r8 = r4;
        Object r0 = r8.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r8.label;
        if (r6 == 0) goto L46;
        if (r6 == 1) goto L37;
        if (r6 == 2) goto L30;
        if (r6 == 3) goto L23;
        if (r6 != 4) goto L22;
        e r1 = (e) r8.L$1;
        String r3 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L17 CancellationException -> L19
    L68:
        r1.a(r3, new j.g((h) r0));     // Catch: Throwable -> L17 CancellationException -> L19
    L93:
        return Unit.INSTANCE;
    L19:
        e = e;
    L88:
        String r9 = e.getMessage();
        if (r9 != null) goto L91;
        r9 = "";
    L91:
        r1.a(r3, new j.a(r9));
    L17:
        th = th;
    L82:
        UploadStage r10 = UploadStage.FAILED;
        String r11 = th.getMessage();
        if (r11 != null) goto L85;
        r11 = "";
    L85:
        r1.a(r3, new j.d(new is8.d(r10, r11, th)));
        goto L93
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        long r12 = r8.J$0;
        is8.a r13 = (is8.a) r8.L$3;
        g r14 = (g) r8.L$2;
        e r15 = (e) r8.L$1;
        String r16 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L26 CancellationException -> L28
        long r18 = r12;
        String r17 = r16;
        e r19 = r15;
        is8.a r20 = r13;
        Object r21 = r0;
    L96:
        com.larus.bmhome.upload.sdk.impl.engine.b r110 = (com.larus.bmhome.upload.sdk.impl.engine.b) r21;     // Catch: Throwable -> L70 CancellationException -> L72
        if (r20.c == false) goto L64;
        r19.a(r17, new j.f(r110.a, r20));     // Catch: Throwable -> L70 CancellationException -> L72
    L64:
        r8.L$0 = r17;     // Catch: Throwable -> L70 CancellationException -> L72
        r8.L$1 = r19;     // Catch: Throwable -> L70 CancellationException -> L72
        r8.L$2 = r15;     // Catch: Throwable -> L70 CancellationException -> L72
        r8.L$3 = 0;     // Catch: Throwable -> L70 CancellationException -> L72
        r8.label = 4;     // Catch: Throwable -> L70 CancellationException -> L72
        Object r22 = a(r17, r14, r20, r18, r110, r8);     // Catch: Throwable -> L70 CancellationException -> L72
        if (r22 != r7) goto L67;
        return r7;
    L67:
        r0 = r22;
        r1 = r19;
        r3 = r17;
        goto L68
    L72:
        e = e;
        r1 = r19;
        r3 = r17;
    L70:
        th = th;
        r1 = r19;
        r3 = r17;
        goto L82
    L28:
        e = e;
        r1 = r15;
        r3 = r16;
    L26:
        th = th;
        r1 = r15;
        r3 = r16;
        goto L82
    L30:
        long r27 = r8.J$0;
        is8.a r28 = (is8.a) r8.L$3;
        g r111 = (g) r8.L$2;
        e r112 = (e) r8.L$1;
        String r113 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L33 CancellationException -> L35
        g r29 = r111;
        r2 = r112;
        String r30 = r113;
        long r114 = r27;
    L55:
        js8.b r31 = (js8.b) r0;     // Catch: Throwable -> L80 CancellationException -> L86
        r2.a(r30, new j.h(0, r28));     // Catch: Throwable -> L80 CancellationException -> L86
        com.larus.bmhome.upload.sdk.impl.engine.c r32 = this.c.a(r28);     // Catch: Throwable -> L80 CancellationException -> L86
        if (r32 == null) goto L75;
        UploadOrchestrator$execute$engineResult$1 r33 = new UploadOrchestrator$execute$engineResult$1(r2, r30, r28, null);     // Catch: Throwable -> L80 CancellationException -> L86
        r8.L$0 = r30;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.L$1 = r2;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.L$2 = r29;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.L$3 = r28;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.J$0 = r114;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.label = 3;     // Catch: Throwable -> L80 CancellationException -> L86
        r18 = r114;
        r21 = r32.b(r30, r29, r28, r31, r33, r8);     // Catch: Throwable -> L80 CancellationException -> L86
        if (r21 != r7) goto L60;
        return r7;
    L60:
        r17 = r30;
        r19 = r2;
        r20 = r28;
        r14 = r29;
        goto L96
    L75:
        throw new IllegalStateException("No upload engine bound for route: " + r28);     // Catch: Throwable -> L80 CancellationException -> L86
    L35:
        e = e;
        r1 = r112;
        r3 = r113;
    L33:
        th = th;
        r1 = r112;
        r3 = r113;
        goto L82
    L37:
        long r34 = r8.J$0;
        e r35 = (e) r8.L$1;
        String r115 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L40 CancellationException -> L43
        r114 = r34;
        r2 = r35;
    L94:
        g r36 = (g) r0;     // Catch: Throwable -> L76 CancellationException -> L78
        r28 = this.a.a(r36);     // Catch: Throwable -> L76 CancellationException -> L78
        r2.a(r115, new j.c(r28.a));     // Catch: Throwable -> L76 CancellationException -> L78
        js8.a r37 = this.b;     // Catch: Throwable -> L76 CancellationException -> L78
        r8.L$0 = r115;     // Catch: Throwable -> L76 CancellationException -> L78
        r8.L$1 = r2;     // Catch: Throwable -> L76 CancellationException -> L78
        r8.L$2 = r36;     // Catch: Throwable -> L76 CancellationException -> L78
        r8.L$3 = r28;     // Catch: Throwable -> L76 CancellationException -> L78
        r8.J$0 = r114;     // Catch: Throwable -> L76 CancellationException -> L78
        r8.label = 2;     // Catch: Throwable -> L76 CancellationException -> L78
        Object r38 = r37.a(r36, r28, r8);     // Catch: Throwable -> L76 CancellationException -> L78
        if (r38 != r7) goto L54;
        return r7;
    L54:
        r29 = r36;
        r0 = r38;
        r30 = r115;
        goto L55
    L78:
        e = e;
        r1 = r2;
    L45:
        r3 = r115;
    L76:
        th = th;
        r1 = r2;
    L42:
        r3 = r115;
        goto L82
    L43:
        e = e;
        r1 = r35;
    L40:
        th = th;
        r1 = r35;
        goto L42
    L46:
        ResultKt.throwOnFailure(r0);
        r114 = System.currentTimeMillis();
        r2.a(r23, new j.e(0));     // Catch: Throwable -> L80 CancellationException -> L86
        UploadPreprocessChain r39 = this.e;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.L$0 = r23;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.L$1 = r2;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.J$0 = r114;     // Catch: Throwable -> L80 CancellationException -> L86
        r8.label = 1;     // Catch: Throwable -> L80 CancellationException -> L86
        r0 = r39.a(r24, r8);     // Catch: Throwable -> L80 CancellationException -> L86
        if (r0 != r7) goto L50;
        return r7;
    L50:
        r115 = r23;
    L86:
        e = e;
        r3 = r23;
        r1 = r2;
    L80:
        th = th;
        r3 = r23;
        r1 = r2;
    L7:
        r4 = new UploadOrchestrator$execute$1(this, r26);
        goto L8
    }

    public UploadOrchestrator(ks8.a r2, js8.a r3, com.larus.bmhome.upload.sdk.impl.engine.a r4, PostUploadActionChain r5, UploadPreprocessChain r6) {
        Intrinsics.checkNotNullParameter(r2, "routeResolver");
        Intrinsics.checkNotNullParameter(r3, "credentialProvider");
        Intrinsics.checkNotNullParameter(r4, "engineRegistry");
        Intrinsics.checkNotNullParameter(r5, "postUploadActionChain");
        Intrinsics.checkNotNullParameter(r6, "preprocessChain");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final Object a(String r15, g r16, is8.a r17, long r18, com.larus.bmhome.upload.sdk.impl.engine.b r20, Continuation<? super h> r21) {
        if ((r21 instanceof UploadOrchestrator$buildResult$1) == false) goto L7;
        UploadOrchestrator$buildResult$1 r3 = (UploadOrchestrator$buildResult$1) r21;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r7 = r3.J$0;
        is8.a r1 = (is8.a) r3.L$1;
        String r8 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        is8.a r9 = r1;
        String r10 = r8;
        long r11 = r7;
    L17:
        com.larus.bmhome.upload.sdk.impl.post.c r12 = (com.larus.bmhome.upload.sdk.impl.post.c) r2;
        String r13 = r12.c;
        String r14 = r12.e;
        l r19 = r12.d;
        long r110 = r11;
        k r111 = new k(r110, System.currentTimeMillis(), r12.f);
        return new h(r10, r13, r14, r19, r9, r111);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        PostUploadActionChain r22 = this.d;
        com.larus.bmhome.upload.sdk.impl.post.c r23 = new com.larus.bmhome.upload.sdk.impl.post.c(r16, r17, r20.a, r20.b, null, MapsKt.emptyMap());
        r10 = r15;
        r3.L$0 = r10;
        r9 = r17;
        r3.L$1 = r9;
        r11 = r18;
        r3.J$0 = r11;
        r3.label = 1;
        r2 = r22.a(r23, r3);
        if (r2 != r5) goto L17;
        return r5;
    L7:
        r3 = new UploadOrchestrator$buildResult$1(this, r21);
        goto L8
    }
}
