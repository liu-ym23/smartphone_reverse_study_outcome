package com.obric.assistant.special_input;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputTaskImpl$openAssistantInputPanel$2", f = "SpecialInputTaskImpl.kt", i = {0, 0, 1}, l = {532, 266}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
public final class SpecialInputTaskImpl$openAssistantInputPanel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $force;
    final /* synthetic */ boolean $isAppInnerCall;
    final /* synthetic */ boolean $isAutoOpen;
    final /* synthetic */ StateInfo $stateInfo;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    final /* synthetic */ SpecialInputTaskImpl this$0;

    public SpecialInputTaskImpl$openAssistantInputPanel$2(SpecialInputTaskImpl r1, StateInfo r2, boolean r3, boolean r4, boolean r5, Continuation<? super SpecialInputTaskImpl$openAssistantInputPanel$2> r6) {
        this.this$0 = r1;
        this.$stateInfo = r2;
        this.$isAppInnerCall = r3;
        this.$force = r4;
        this.$isAutoOpen = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        SpecialInputTaskImpl$openAssistantInputPanel$2 r7 = new SpecialInputTaskImpl$openAssistantInputPanel$2(this.this$0, this.$stateInfo, this.$isAppInnerCall, this.$force, this.$isAutoOpen, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L12;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r30);     // Catch: Throwable -> L9
    L82:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r2.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r11 = r2;
    L87:
        r11.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        boolean r4 = this.Z$2;
        boolean r7 = this.Z$1;
        boolean r8 = this.Z$0;
        SpecialInputTaskImpl r9 = (SpecialInputTaskImpl) this.L$3;
        StateInfo r10 = (StateInfo) this.L$2;
        r11 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r30);
        boolean r13 = r4;
    L17:
        boolean r15 = r7;
        boolean r19 = r8;
        StateInfo r14 = r10;
        Ref.ObjectRef r16 = new Ref.ObjectRef();     // Catch: Throwable -> L86
        if (r14 == null) goto L24;
        Map r5 = r14.getExt();     // Catch: Throwable -> L86
        if (r5 == null) goto L24;
        String r6 = (String) r5.get("o_foreground_app");     // Catch: Throwable -> L86
    L25:
        String r17 = "";
        if (r6 != null) goto L28;
        r6 = "";
    L28:
        r16.element = r6;     // Catch: Throwable -> L86
        if (r19 == true) goto L44;
        if (r6.length() != 0) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == false) goto L44;
        IObricLaunchService r20 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);     // Catch: Throwable -> L86
        if (r20 == null) goto L38;
        String r21 = r20.getBackgroundAppPkgName();     // Catch: Throwable -> L86
    L39:
        if (r21 == null) goto L42;
        r17 = r21;
    L42:
        r16.element = r17;     // Catch: Throwable -> L86
        goto L44
    L38:
        r21 = null;
        goto L39
    L33:
        r18 = false;
    L44:
        if (r14 == null) goto L64;
        Map r22 = r14.getExt();     // Catch: Throwable -> L86
        if (r22 == null) goto L64;
        String r23 = (String) r22.get("o_meta");     // Catch: Throwable -> L86
        if (r23 == null) goto L64;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L55
        if (com.larus.utils.o0.d(r23) == false) goto L52;
        w0 r24 = (w0) new Gson().fromJson(r23, w0.class);     // Catch: Throwable -> L55
    L53:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L55
    L57:
        Throwable r111 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L86
        if (r111 == null) goto L61;
        FLogger.a.w("SpecialInputTaskImpl", "parse meta failed", r111);     // Catch: Throwable -> L86
    L61:
        if (Result.isFailure-impl(r25) == false) goto L63;
        r25 = null;
    L63:
        w0 r26 = (w0) r25;     // Catch: Throwable -> L86
    L65:
        FLogger.a.i("SpecialInputTaskImpl", "openAssistantInputPanel: topPkg = " + ((String) r16.element) + ", meta = " + r26);     // Catch: Throwable -> L86
        if (r14.getStartWithAsr() == true) goto L73;
        if (r26 == null) goto L69;
        boolean r27 = Intrinsics.areEqual(r26.a(), Boxing.boxBoolean(true));     // Catch: Throwable -> L86
    L70:
        if (r27 == true) goto L73;
        boolean r112 = false;
    L74:
        CoroutineScope r28 = r9.g;     // Catch: Throwable -> L86
        if (r13 == false) goto L77;
        boolean r29 = true;
    L78:
        Job r31 = BuildersKt.launch$default(r28, null, null, new SpecialInputTaskImpl$openAssistantInputPanel$2$1$1(r14, r15, r112, r26, r9, r19, r16, r29, null), 3, null);     // Catch: Throwable -> L86
        this.L$0 = r11;     // Catch: Throwable -> L86
        this.L$1 = null;     // Catch: Throwable -> L86
        this.L$2 = null;     // Catch: Throwable -> L86
        this.L$3 = null;     // Catch: Throwable -> L86
        this.label = 2;     // Catch: Throwable -> L86
        if (r31.join(this) != r3) goto L81;
        return r3;
    L81:
        r2 = r11;
        goto L82
    L77:
        r29 = false;
        goto L78
    L69:
        r27 = false;
    L73:
        r112 = true;
        goto L74
    L52:
        r24 = null;
    L55:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L86
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L86
    L64:
        r26 = null;
    L24:
        r6 = null;
    L86:
        th = th;
        goto L87
    L14:
        ResultKt.throwOnFailure(r30);
        CoroutineScope r32 = (CoroutineScope) this.L$0;
        r9 = this.this$0;
        r11 = r9.i;
        r10 = this.$stateInfo;
        r8 = this.$isAppInnerCall;
        r7 = this.$force;
        r13 = this.$isAutoOpen;
        this.L$0 = r32;
        this.L$1 = r11;
        this.L$2 = r10;
        this.L$3 = r9;
        this.Z$0 = r8;
        this.Z$1 = r7;
        this.Z$2 = r13;
        this.label = 1;
        if (r11.a(null, this) != r3) goto L17;
        return r3;
    }
}
