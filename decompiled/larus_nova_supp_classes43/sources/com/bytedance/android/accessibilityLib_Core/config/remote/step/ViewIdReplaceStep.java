package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.f;
import com.bytedance.android.accessibilityLib_Core.config.remote.subjob.LocalFileCheckJob;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ViewIdReplaceStep extends com.bytedance.android.accessibilityLib_Core.config.remote.step.a<Boolean, List<? extends f>> {
    public static final /* synthetic */ int c = 0;
    public final ParseStep a;
    public final com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b b;

    public static final class a {
    }

    static {
    }

    public ViewIdReplaceStep(ParseStep r1, com.bytedance.android.accessibilityLib_Core.config.remote.subjob.b r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object a(Boolean r23, Continuation<? super List<f>> r24) {
        if ((r24 instanceof ViewIdReplaceStep$excute$1) == false) goto L7;
        ViewIdReplaceStep$excute$1 r10 = (ViewIdReplaceStep$excute$1) r24;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r0 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        List r14 = (List) r10.L$1;
        ViewIdReplaceStep r15 = (ViewIdReplaceStep) r10.L$0;
        ResultKt.throwOnFailure(r0);
    L77:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ViewIdReplaceStep r16 = (ViewIdReplaceStep) r10.L$0;
        ResultKt.throwOnFailure(r0);
        final ViewIdReplaceStep r17 = r16;
    L20:
        final List r18 = (List) r0;
        r10.L$0 = r17;
        r10.L$1 = r18;
        r10.label = 2;
        final SafeContinuation r19 = new SafeContinuation(IntrinsicsKt.intercepted(r10));
    L28:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L71;
        Context r1 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L71:
        Context r20 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        r19.resumeWith(Result.constructor-impl(r18));
        Unit r21 = Unit.INSTANCE;
    L72:
        r0 = r19.getOrThrow();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L75;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L75:
        if (r0 != r12) goto L77;
        return r12;
    L80:
        InputStream r22 = com.bytedance.android.accessibilityLib_Core.helper.a.a().getResources().getAssets().open("raw_r_accessibility.txt");     // Catch: Exception -> L24
    L23:
        InputStream r110 = r22;
        if (r110 == null) goto L65;
        Reader r25 = new InputStreamReader(r110, Charsets.UTF_8);     // Catch: Exception -> L28
        if ((r25 instanceof BufferedReader) == false) goto L35;
        BufferedReader r26 = (BufferedReader) r25;     // Catch: Exception -> L28
    L36:
        List r27 = TextStreamsKt.readLines(r26);     // Catch: Exception -> L28
        if (r27.isEmpty() == false) goto L39;
        r19.resumeWith(Result.constructor-impl(r18));     // Catch: Exception -> L28
    L66:
        Unit r28 = Unit.INSTANCE;     // Catch: Exception -> L28
        goto L72
    L39:
        final Function1<List<? extends String>, Unit> r111 = new ViewIdReplaceStep$excute$$inlined$suspendCoroutine$lambda$1(r19, r17, r18);     // Catch: Exception -> L28
        if (r27.size() >= 2) goto L57;
        List r29 = StringsKt.split$default((String) ListProtector.get(r27, 0), new String[]{"="}, false, 0, 6, null);     // Catch: Exception -> L28
        if (r29.size() >= 2) goto L44;
        r19.resumeWith(Result.constructor-impl(r18));     // Catch: Exception -> L28
        goto L66
    L44:
        final String r30 = (String) ListProtector.get(r29, 1);     // Catch: Exception -> L28
        String r31 = "rTxtUrlValue = " + r30;     // Catch: Exception -> L28
        InputStream r32 = r110;
        new LocalFileCheckJob(r17.b).a(r30, new ViewIdReplaceStep$excute$$inlined$suspendCoroutine$lambda$2(r30, r111, r19, r17, r18));     // Catch: Exception -> L49
        Unit r33 = Unit.INSTANCE;     // Catch: Exception -> L49
    L78:
        r32.close();     // Catch: Exception -> L60
        Unit r34 = Unit.INSTANCE;     // Catch: Exception -> L60
    L60:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L64;
        Context r35 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
    L64:
        Context r36 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
        Unit r37 = Unit.INSTANCE;     // Catch: Exception -> L28
    L49:
        e = e;
    L54:
        if (("Try exception occur " + e.getMessage()) == null) goto L56;
        Context r38 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
    L56:
        Context r39 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
        r19.resumeWith(Result.constructor-impl(r18));     // Catch: Exception -> L28
        Unit r40 = Unit.INSTANCE;     // Catch: Exception -> L28
    L51:
        e = e;
        r32 = r110;
        goto L54
    L57:
        r32 = r110;
        r111.invoke(r27);     // Catch: Exception -> L28
        goto L78
    L35:
        r26 = new BufferedReader(r25, 8192);     // Catch: Exception -> L28
        goto L36
    L65:
        r19.resumeWith(Result.constructor-impl(r18));     // Catch: Exception -> L28
        goto L66
    L24:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L30;
        Context r41 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
    L30:
        Context r42 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
        r22 = null;
        goto L23
    L16:
        ResultKt.throwOnFailure(r0);
        Context r43 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        ParseStep r44 = this.a;
        Boolean r45 = Boxing.boxBoolean(true);
        r10.L$0 = this;
        r10.label = 1;
        r0 = r44.a(r45, r10);
        if (r0 != r12) goto L19;
        return r12;
    L19:
        r17 = this;
    L7:
        r10 = new ViewIdReplaceStep$excute$1(this, r24);
        goto L8
    }
}
