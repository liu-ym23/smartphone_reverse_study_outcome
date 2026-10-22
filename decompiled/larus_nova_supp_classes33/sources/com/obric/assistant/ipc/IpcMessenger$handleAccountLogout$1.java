package com.obric.assistant.ipc;

import android.content.Context;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.utils.j;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$handleAccountLogout$1", f = "IpcMessenger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IpcMessenger$handleAccountLogout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uidLeaving;
    private /* synthetic */ Object L$0;
    int label;

    public IpcMessenger$handleAccountLogout$1(String r1, Continuation<? super IpcMessenger$handleAccountLogout$1> r2) {
        this.$uidLeaving = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        IpcMessenger$handleAccountLogout$1 r0 = new IpcMessenger$handleAccountLogout$1(this.$uidLeaving, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v53 */
    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L119;
        ResultKt.throwOnFailure(r15);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        IpcMessenger r17 = IpcMessenger.a;
        String r1 = this.$uidLeaving;
        r17.getClass();
        if (StringsKt.isBlank(r1) == false) goto L7;
        Boolean r18 = null;
    L11:
        boolean r2 = false;
        if (Intrinsics.areEqual(r18, Boxing.boxBoolean(false)) == false) goto L132;
        String r3 = this.$uidLeaving;
    L25:
        boolean r5 = Intrinsics.areEqual(r18, Boxing.boxBoolean(false));
        FLogger.a.i(SvaSdkIPCService.TAG, "handleAccountLogout uid=" + j.d(this.$uidLeaving) + " personalUid=" + j.d(r3) + " leavingIsEnterprise=" + r18 + " isPersonalLogout=" + r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L32
        VoiceEnrollServiceDelegate r7 = VoiceEnrollServiceDelegate.c;     // Catch: Throwable -> L32
        StringBuilder r8 = new StringBuilder("logout_");     // Catch: Throwable -> L32
        if (r5 == false) goto L29;
        boolean r0 = true;
    L30:
        r8.append(r0);     // Catch: Throwable -> L32
        r7.i(r8.toString());     // Catch: Throwable -> L32
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r9 = Result.exceptionOrNull-impl(r4);
        if (r9 == null) goto L38;
        FLogger.a.e(SvaSdkIPCService.TAG, "release for logout failed: " + r9.getMessage());
    L38:
        if (r5 == false) goto L49;
        HostStateSyncManager r10 = HostStateSyncManager.a;
        String r11 = "account_logout:" + j.d(this.$uidLeaving);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, WindowEvent.Params.REASON);
        Context r12 = AppHost.a.getApplication().getApplicationContext();
        Bundle r13 = new Bundle();
        r13.putString(WindowEvent.Params.REASON, r11);
        BuildersKt.launch$default(HostStateSyncManager.c, null, null, new HostStateSyncManager$clearInteractorUploadQueue$1(r12, r13, r11, null), 3, null);
        obricDeviceManagerDelegate.b.b();
        VoiceEnrollServiceDelegate.c.q(this.$uidLeaving);     // Catch: Throwable -> L42
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r19 = Result.exceptionOrNull-impl(r14);
        if (r19 == null) goto L47;
        FLogger.a.e(SvaSdkIPCService.TAG, "clearAllVoicePrintByUid failed: " + r19.getMessage());
    L47:
        IpcMessenger.k(IpcMessenger.a, 3, 1, null, 12);
    L116:
        IpcMessenger.c.remove(this.$uidLeaving);
        return Unit.INSTANCE;
    L42:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L49:
        if ((!StringsKt.isBlank(this.$uidLeaving)) == true) goto L134;
    L58:
        IpcMessenger.k(IpcMessenger.a, 3, 0, null, 12);
        if (r3 != null) goto L62;
        r3 = "";
    L62:
        if ((!StringsKt.isBlank(r3)) == true) goto L122;
        ?? r21 = 0;
    L73:
        if ((!StringsKt.isBlank(r3)) == true) goto L128;
        boolean r22 = false;
    L84:
        if ((!StringsKt.isBlank(r3)) == false) goto L115;
        IpcMessenger.a.getClass();
        IpcMessenger.i(9, 1, r21, r3);
        ObricEnrollInteropDelegate r23 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L92
        if (r21 == 0) goto L89;
        boolean r24 = true;
    L90:
        r23.n(r3, r24);     // Catch: Throwable -> L92
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L94:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L136;
        FLogger.a.e(SvaSdkIPCService.TAG, "restore wakeup after enterprise logout failed: " + r26.getMessage());
    L136:
        ObricEnrollInteropDelegate r27 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L102
        if (r22 == false) goto L100;
        r2 = true;
    L100:
        r27.r(r3, r2);     // Catch: Throwable -> L102
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L102
    L104:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L120;
        FLogger.a.e(SvaSdkIPCService.TAG, "restore breath after enterprise logout failed: " + r111.getMessage());
    L120:
        ObricEnrollInteropDelegate.b.j(r22);     // Catch: Throwable -> L109
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L109
    L111:
        Throwable r28 = Result.exceptionOrNull-impl(r112);
        if (r28 == null) goto L114;
        FLogger.a.e(SvaSdkIPCService.TAG, "apply breath after enterprise logout failed: " + r28.getMessage());
    L114:
        Result.box-impl(r112);
    L109:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
    L102:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L104
    L89:
        r24 = false;
    L92:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L94
    L115:
        FLogger.a.i(SvaSdkIPCService.TAG, "skip restore after enterprise logout: restore uid blank");
        goto L116
    L128:
        Object r32 = Result.constructor-impl(Boxing.boxBoolean(ObricEnrollInteropDelegate.b.y(r3)));     // Catch: Throwable -> L76
    L78:
        Boolean r33 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r32) == false) goto L81;
        r32 = r33;
    L81:
        r22 = ((Boolean) r32).booleanValue();
    L76:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L122:
        Object r35 = Result.constructor-impl(Boxing.boxBoolean(ObricEnrollInteropDelegate.b.u(r3)));     // Catch: Throwable -> L65
    L67:
        Boolean r36 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r35) == false) goto L70;
        r35 = r36;
    L70:
        r21 = ((Boolean) r35).booleanValue();
    L65:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L134:
        VoiceEnrollServiceDelegate.c.t(this.$uidLeaving);     // Catch: Throwable -> L53
        Object r38 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L58;
        FLogger.a.e(SvaSdkIPCService.TAG, "clearVoicePrintForUid failed: " + r39.getMessage());
    L53:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L29:
        r0 = false;
    L32:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L132:
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L16
        Object r43 = Result.constructor-impl(ObricAccountSPIServiceDelegate.b.a());     // Catch: Throwable -> L16
    L18:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L22;
        FLogger.a.e(SvaSdkIPCService.TAG, "getCurrentPersonalAccountUid failed: " + r44.getMessage());
    L22:
        if (Result.isFailure-impl(r43) == false) goto L24;
        r43 = null;
    L24:
        r3 = (String) r43;
    L16:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L7:
        ConcurrentHashMap r113 = IpcMessenger.c;
        Boolean r46 = (Boolean) r113.get(r1);
        if (r46 == null) goto L10;
        r18 = Boolean.valueOf(r46.booleanValue());
        goto L11
    L10:
        IpcMessenger.f();
        r18 = (Boolean) r113.get(r1);
        goto L11
    L119:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
