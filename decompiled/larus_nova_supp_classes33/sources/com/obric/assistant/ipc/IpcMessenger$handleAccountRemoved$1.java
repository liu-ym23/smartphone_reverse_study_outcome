package com.obric.assistant.ipc;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.utils.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import q38.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$handleAccountRemoved$1", f = "IpcMessenger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IpcMessenger$handleAccountRemoved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $removedUid;
    private /* synthetic */ Object L$0;
    int label;

    public IpcMessenger$handleAccountRemoved$1(String r1, Continuation<? super IpcMessenger$handleAccountRemoved$1> r2) {
        this.$removedUid = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        IpcMessenger$handleAccountRemoved$1 r0 = new IpcMessenger$handleAccountRemoved$1(this.$removedUid, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L77;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        if (StringsKt.isBlank(this.$removedUid) == false) goto L8;
        FLogger.a.i(SvaSdkIPCService.TAG, "handleAccountRemoved skip restore: removed uid blank");
        return Unit.INSTANCE;
    L8:
        IpcMessenger.c.remove(this.$removedUid);
        IpcMessenger.a.getClass();
        b r13 = IpcMessenger.a();
        Boolean r1 = null;
        if (r13 == null) goto L11;
        String r2 = r13.j();
    L12:
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        if (StringsKt.isBlank(r2) == false) goto L17;
    L74:
        FLogger.a.i(SvaSdkIPCService.TAG, "handleAccountRemoved skip restore removedUid=" + j.d(this.$removedUid) + " restoreUid=" + j.d(r2) + " restoreBlank=" + StringsKt.isBlank(r2) + " removedIsActive=" + Intrinsics.areEqual(r2, this.$removedUid));
        return Unit.INSTANCE;
    L17:
        if (Intrinsics.areEqual(r2, this.$removedUid) == true) goto L74;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        Object r4 = Result.constructor-impl(Boxing.boxBoolean(ObricEnrollInteropDelegate.b.u(r2)));     // Catch: Throwable -> L21
    L23:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L26;
        FLogger.a.e(SvaSdkIPCService.TAG, "account removed get wakeup switch failed: " + r5.getMessage());
    L26:
        boolean r6 = false;
        Boolean r7 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r4) == false) goto L29;
        r4 = r7;
    L29:
        boolean r8 = ((Boolean) r4).booleanValue();
        Object r9 = Result.constructor-impl(Boxing.boxBoolean(ObricEnrollInteropDelegate.b.y(r2)));     // Catch: Throwable -> L32
    L34:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L37;
        FLogger.a.e(SvaSdkIPCService.TAG, "account removed get breath switch failed: " + r10.getMessage());
    L37:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r9) == false) goto L40;
        r9 = r14;
    L40:
        boolean r15 = ((Boolean) r9).booleanValue();
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("handleAccountRemoved restore active wakeup uid=");
        r17.append(j.d(r2));
        r17.append(" isEnterprise=");
        if (r13 == null) goto L43;
        r1 = Boxing.boxBoolean(r13.l());
    L43:
        r17.append(r1);
        r17.append(" enabled=");
        r17.append(r8);
        r17.append(" breathEnabled=");
        r17.append(r15);
        r16.i(SvaSdkIPCService.TAG, r17.toString());
        IpcMessenger.a.getClass();
        IpcMessenger.i(9, 1, r8 ? 1 : 0, r2);
        ObricEnrollInteropDelegate r18 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L50
        if (r8 == false) goto L47;
        boolean r19 = true;
    L48:
        r18.n(r2, r19);     // Catch: Throwable -> L50
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L86;
        FLogger.a.e(SvaSdkIPCService.TAG, "account removed sync wakeup switch failed: " + r111.getMessage());
    L86:
        ObricEnrollInteropDelegate r112 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L60
        if (r15 == false) goto L58;
        r6 = true;
    L58:
        r112.r(r2, r6);     // Catch: Throwable -> L60
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L80;
        FLogger.a.e(SvaSdkIPCService.TAG, "account removed sync breath switch failed: " + r114.getMessage());
    L80:
        ObricEnrollInteropDelegate.b.j(r15);     // Catch: Throwable -> L67
        Object r115 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
    L69:
        Throwable r116 = Result.exceptionOrNull-impl(r115);
        if (r116 == null) goto L73;
        FLogger.a.e(SvaSdkIPCService.TAG, "account removed apply breath switch failed: " + r116.getMessage());
    L73:
        return Unit.INSTANCE;
    L67:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
    L60:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L47:
        r19 = false;
    L50:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L11:
        r2 = null;
        goto L12
    L77:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
