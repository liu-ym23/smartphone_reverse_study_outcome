package com.obric.audio.enroll;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.utils.j;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$clearAllVoicePrintByUid$1", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollServiceImpl$clearAllVoicePrintByUid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $fallbackUid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VoiceEnrollServiceImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceEnrollServiceImpl$clearAllVoicePrintByUid$1(VoiceEnrollServiceImpl r1, Function1<? super Boolean, Unit> r2, String r3, Continuation<? super VoiceEnrollServiceImpl$clearAllVoicePrintByUid$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$fallbackUid = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        VoiceEnrollServiceImpl$clearAllVoicePrintByUid$1 r0 = new VoiceEnrollServiceImpl$clearAllVoicePrintByUid$1(this.this$0, this.$callback, this.$fallbackUid, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L102;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        VoiceEnrollServiceImpl r14 = this.this$0;
        VoiceEnrollServiceImpl.b r0 = VoiceEnrollServiceImpl.k;
        r14.getClass();
        VoiceEnrollServiceImpl.C();
        LinkedHashSet r15 = new LinkedHashSet();
        String r1 = this.$fallbackUid;
        r15.addAll(pia.d.e());
        if (r1 != null) goto L7;
    L12:
        List r16 = CollectionsKt.toList(r15);
        FLogger.a.i("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid start size=" + r16.size());
        if (r16.isEmpty() == false) goto L26;
        Object r17 = this.this$0.c;
        monitor-enter(r17);
        VoiceEnrollServiceImpl.k.getClass();     // Catch: Throwable -> L23
        VoiceEnrollServiceImpl.b.b("clear all default voice print by uid empty");     // Catch: Throwable -> L23
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r17);
        Function1<Boolean, Unit> r18 = this.$callback;
        if (r18 == null) goto L22;
        r18.invoke(Boxing.boxBoolean(true));
    L22:
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        throw th;
    L26:
        Object r3 = this.this$0.c;
        monitor-enter(r3);
        VoiceEnrollServiceImpl.k.getClass();     // Catch: Throwable -> L98
        VoiceEnrollServiceImpl.b.b("clear all default voice print by uid");     // Catch: Throwable -> L98
        Iterator r4 = r16.iterator();     // Catch: Throwable -> L98
    L30:
        if (r4.hasNext() == false) goto L49;
        String r5 = (String) r4.next();     // Catch: Throwable -> L98
        if (StringsKt.isBlank(r5) == true) goto L30;
        VoiceEnrollServiceImpl.A(r5, "clear all default voice print");     // Catch: Throwable -> L98
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L36
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L36
        Object r7 = Result.constructor-impl(Boxing.boxInt(SamiEnrollEngine.l(r5)));     // Catch: Throwable -> L36
    L38:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L98
        if (r8 == null) goto L41;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid local failed uid=" + j.d(r5) + ": " + r8.getMessage());     // Catch: Throwable -> L98
    L41:
        Integer r9 = Boxing.boxInt(Integer.MIN_VALUE);     // Catch: Throwable -> L98
        if (Result.isFailure-impl(r7) == false) goto L44;
        r7 = r9;
    L44:
        int r10 = ((Number) r7).intValue();     // Catch: Throwable -> L98
        FLogger.a.i("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid local ret=" + r10 + " uid=" + j.d(r5));     // Catch: Throwable -> L98
        pia.d.k(r5);     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r5, "uid");     // Catch: Throwable -> L98
        if (StringsKt.isBlank(r5) == true) goto L48;
        pia.d.i().erase("default_voice_print_mic0_recorded_".concat(r5));     // Catch: Throwable -> L98
    L48:
        pia.d.m(r5);     // Catch: Throwable -> L98
        VoiceEnrollServiceImpl.D(r5, "delete", "clear_all_by_uid intent");     // Catch: Throwable -> L98
        goto L30
    L36:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L98
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L98
        goto L38
    L49:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L98
        monitor-exit(r3);
        Iterator r20 = r16.iterator();
    L53:
        if (r20.hasNext() == false) goto L63;
        String r21 = (String) r20.next();
        if (StringsKt.isBlank(r21) == true) goto L53;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L58
        ObricEnrollInteropDelegate r23 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L58
        r23.n(r21, false);     // Catch: Throwable -> L58
        r23.z(r21);     // Catch: Throwable -> L58
        Object r24 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L58
    L60:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L53;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid per-uid settings failed uid=" + j.d(r21) + ": " + r25.getMessage());
    L58:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    L63:
        FLogger.a.i("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid local phase done");
        Function1<Boolean, Unit> r27 = this.$callback;
        if (r27 == null) goto L66;
        r27.invoke(Boxing.boxBoolean(true));
    L66:
        Iterator r110 = r16.iterator();
    L68:
        if (r110.hasNext() == false) goto L96;
        String r28 = (String) r110.next();
        if (StringsKt.isBlank(r28) == true) goto L68;
        VoiceEnrollServiceImpl r29 = this.this$0;
        Object r30 = r29.c;
        monitor-enter(r30);
        String r31 = pia.d.d(r28);     // Catch: Throwable -> L93
        if (Intrinsics.areEqual(r31, "delete") == true) goto L103;
        FLogger.a.i("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid online phase skip: desired=" + r31 + " uid=" + j.d(r28));     // Catch: Throwable -> L93
        int r32 = 0;
    L90:
        monitor-exit(r30);
        if (r32 == 0) goto L68;
        this.this$0.E(r28, "clear_all_by_uid_retry");
        goto L68
    L103:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L79
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L79
        Object r34 = Result.constructor-impl(Boxing.boxInt(SamiEnrollEngine.m(r28)));     // Catch: Throwable -> L79
    L81:
        Throwable r35 = Result.exceptionOrNull-impl(r34);     // Catch: Throwable -> L93
        if (r35 == null) goto L84;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid online failed uid=" + j.d(r28) + ": " + r35.getMessage());     // Catch: Throwable -> L93
    L84:
        Integer r36 = Boxing.boxInt(Integer.MIN_VALUE);     // Catch: Throwable -> L93
        if (Result.isFailure-impl(r34) == false) goto L87;
        r34 = r36;
    L87:
        r32 = ((Number) r34).intValue();     // Catch: Throwable -> L93
        FLogger.a.i("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid online ret=" + r32 + " uid=" + j.d(r28));     // Catch: Throwable -> L93
        if (r32 != 0) goto L90;
        VoiceEnrollServiceImpl.w(r29, r28, "delete", "clear_all_by_uid online_success");     // Catch: Throwable -> L93
        goto L90
    L79:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L93
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        throw th;
    L96:
        FLogger.a.i("VoiceEnrollServiceImpl", "clearAllVoicePrintByUid online phase done");
        return Unit.INSTANCE;
    L98:
        th = move-exception;
        throw th;
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r15.add(r1);
        goto L12
    L102:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
