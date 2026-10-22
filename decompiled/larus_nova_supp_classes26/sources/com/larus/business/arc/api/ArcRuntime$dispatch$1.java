package com.larus.business.arc.api;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.k1;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.arc.api.ArcRuntime", f = "ArcRuntime.kt", i = {1}, l = {73, 84, 92, 92}, m = "dispatch", n = {"lifecycle"}, s = {"L$0"})
final class ArcRuntime$dispatch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public ArcRuntime$dispatch$1(u r1, Continuation<? super ArcRuntime$dispatch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.business.arc.api.ArcCallLifecycle, int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.larus.business.arc.api.ArcCallLifecycle] */
    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        u r10 = this.this$0;
        r10.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ArcRuntime$dispatch$1 r0 = this;
    L6:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ArcCallLifecycle r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L28;
        if (r3 != 1) goto L10;
        ResultKt.throwOnFailure(r11);
    L108:
        return r11;
    L10:
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L16;
        if (r3 != 4) goto L14;
        Throwable r5 = (Throwable) r0.L$0;
        ResultKt.throwOnFailure(r11);
        throw r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
        return r6;
    L17:
        r3 = (ArcCallLifecycle) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L22 CancellationException -> L24
        r11 = (String) r11;     // Catch: Throwable -> L22 CancellationException -> L24
        k1 r7 = k1.a;
        ArcRuntime$dispatch$5 r8 = new ArcRuntime$dispatch$5(r3, null);
        r0.L$0 = r11;
        r0.label = 3;
        if (BuildersKt.withContext(r7, r8, r0) != r2) goto L108;
        return r2;
    L90:
        th = move-exception;
        k1 r12 = k1.a;
        ArcRuntime$dispatch$5 r13 = new ArcRuntime$dispatch$5(r3, null);
        r0.L$0 = th;
        r0.label = 4;
        if (BuildersKt.withContext(r12, r13, r0) != r2) goto L95;
        return r2;
    L95:
        throw th;
    L28:
        ResultKt.throwOnFailure(r11);
        Regex r14 = v.a;
        wt7.c r15 = wt7.a.a;     // Catch: Throwable -> L43
        kuc.a.f(StringCompanionObject.INSTANCE);     // Catch: Throwable -> L43
        nuc.f r16 = kuc.a.b(v2.a);     // Catch: Throwable -> L43
        r15.getClass();     // Catch: Throwable -> L43
        List r17 = (List) wt7.c.a(null, r16);     // Catch: Throwable -> L43
        if (r17 == null) goto L44;
        String r18 = (String) CollectionsKt.firstOrNull(r17);     // Catch: Throwable -> L43
        if (r18 == null) goto L44;
        String r19 = StringsKt.trim(r18).toString();     // Catch: Throwable -> L43
        if (r19 == null) goto L44;
        String r20 = r19.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L43
        if (r20 == null) goto L44;
        if (r20.length() > 0) goto L41;
        r4 = false;
    L41:
        if (r4 == false) goto L44;
    L45:
        if (r20 != null) goto L47;
    L59:
        ArcCallLifecycle r21 = null;
    L60:
        String r22 = "";
        if (r21 != null) goto L105;
        c r23 = v.a();
        String r24 = r23.i;
        if (v.a.matches(r24) == true) goto L66;
        r24 = null;
    L66:
        if (r24 != null) goto L68;
        r24 = "";
    L68:
        c.a(r23, r24, "", null);
        throw null;
    L105:
        r21.a(ArcStage.PREPARE);     // Catch: Throwable -> L72
    L73:
        c r25 = v.a();     // Catch: Throwable -> L22 CancellationException -> L24
        String r26 = r25.i;     // Catch: Throwable -> L22 CancellationException -> L24
        if (v.a.matches(r26) == true) goto L77;
        r26 = null;
    L77:
        if (r26 == null) goto L80;
        r22 = r26;
    L80:
        c.a(r25, r22, v.b(), r21);     // Catch: Throwable -> L22 CancellationException -> L24
        throw null;     // Catch: Throwable -> L22 CancellationException -> L24
    L72:
        r21.k();
        goto L73
    L47:
        if (Intrinsics.areEqual(r20, "call") == true) goto L50;
        r20 = null;
    L50:
        if (r20 == null) goto L59;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L53
        Object r28 = Result.constructor-impl(new ArcCallLifecycle(0));     // Catch: Throwable -> L53
    L56:
        if (Result.isFailure-impl(r28) == false) goto L58;
        r28 = null;
    L58:
        r21 = (ArcCallLifecycle) r28;
    L53:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        r20 = null;
    L24:
        e = move-exception;
        r3.c();     // Catch: Throwable -> L88
    L89:
        throw e;     // Catch: Throwable -> L90
    L88:
        r3.k();     // Catch: Throwable -> L90
    L22:
        th = move-exception;
        r3.e();     // Catch: Throwable -> L84
    L85:
        throw th;     // Catch: Throwable -> L90
    L84:
        r3.k();     // Catch: Throwable -> L90
        goto L85
    L5:
        r0 = new ArcRuntime$dispatch$1(r10, this);
        goto L6
    }
}
