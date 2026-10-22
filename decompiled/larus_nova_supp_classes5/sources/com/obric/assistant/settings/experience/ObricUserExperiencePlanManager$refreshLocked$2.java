package com.obric.assistant.settings.experience;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import vea.l;
import vea.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanManager$State;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$refreshLocked$2", f = "ObricUserExperiencePlanManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {103, 104, 120}, m = "invokeSuspend", n = {"$this$supervisorScope", "accountUid", "local", "networkService", "modelDeferred", "$this$supervisorScope", "accountUid", "local", "networkService", "voiceResult", "accountUid", "local", "voiceResult", "modelResult", "voiceEnabled", "modelEnabled"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class ObricUserExperiencePlanManager$refreshLocked$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricUserExperiencePlanManager.a>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    public ObricUserExperiencePlanManager$refreshLocked$2(Continuation<? super ObricUserExperiencePlanManager$refreshLocked$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricUserExperiencePlanManager$refreshLocked$2 r0 = new ObricUserExperiencePlanManager$refreshLocked$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ObricUserExperiencePlanManager.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r7 = true;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        Ref$BooleanRef r3 = (Ref$BooleanRef) this.L$5;
        Ref$BooleanRef r4 = (Ref$BooleanRef) this.L$4;
        l r5 = (l) this.L$3;
        p r8 = (p) this.L$2;
        ObricUserExperiencePlanManager.a r9 = (ObricUserExperiencePlanManager.a) this.L$1;
        String r10 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L10
        Ref$BooleanRef r6 = r4;
        Object r11 = r21;
    L95:
        Object r1 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r11).booleanValue()));     // Catch: Throwable -> L58
        Ref$BooleanRef r12 = r3;
    L63:
        l r13 = r5;
        Throwable r14 = Result.exceptionOrNull-impl(r1);
        if (r14 == null) goto L66;
        FLogger.a.w("ObricExperiencePlan", "migrate voice setting failed", r14);
    L66:
        ObricUserExperiencePlanManager r15 = ObricUserExperiencePlanManager.a;
        if (ObricUserExperiencePlanManager.c(r10) == false) goto L69;
    L70:
        if (r13 == null) goto L76;
        Boolean r16 = r13.a();
        if (r16 == null) goto L76;
        boolean r17 = r16.booleanValue();
        r12.element = r17;
        if (r17 == r9.b) goto L76;
        t1.a.q0(r17);
    L76:
        boolean r18 = r6.element;
        boolean r19 = r12.element;
        if (r8 != null) goto L79;
    L81:
        boolean r20 = false;
    L82:
        if (r20 == false) goto L88;
        if (r13 == null) goto L85;
        Boolean r22 = r13.a();
    L86:
        if (r22 == null) goto L88;
    L89:
        ObricUserExperiencePlanManager.a r23 = new ObricUserExperiencePlanManager.a(r18, r19, r7);
        ObricUserExperiencePlanManager.d.setValue(r23);
        return r23;
    L85:
        r22 = null;
    L88:
        r7 = false;
        goto L89
    L79:
        if (r8.a != true) goto L81;
        r20 = true;
        goto L82
    L69:
        return ObricUserExperiencePlanManager.d();
    L58:
        th = th;
        r4 = r6;
    L62:
        Result.Companion r24 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r12 = r3;
        r6 = r4;
    L10:
        th = th;
        goto L62
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        p r25 = (p) this.L$4;
        IObricNetworkService r26 = (IObricNetworkService) this.L$3;
        ObricUserExperiencePlanManager.a r27 = (ObricUserExperiencePlanManager.a) this.L$2;
        String r28 = (String) this.L$1;
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r21);
        r10 = r28;
        r9 = r27;
        r8 = r25;
        Object r29 = r21;
    L32:
        r13 = (l) r29;
        ObricUserExperiencePlanManager r30 = ObricUserExperiencePlanManager.a;
        if (ObricUserExperiencePlanManager.c(r10) == false) goto L35;
        r6 = new Ref$BooleanRef();
        r6.element = r9.a;
        r12 = new Ref$BooleanRef();
        r12.element = r9.b;
        if (r8 != null) goto L39;
    L41:
        boolean r111 = false;
    L42:
        if (r111 == false) goto L70;
        if (r8.b == false) goto L51;
        Boolean r31 = r8.c;
        if (r31 == null) goto L70;
        boolean r32 = r31.booleanValue();
        r6.element = r32;
        if (r32 == r9.a) goto L70;
        t1.a.i1(r32);
        goto L70
    L51:
        if (r6.element == false) goto L70;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L60
        this.L$0 = r10;     // Catch: Throwable -> L60
        this.L$1 = r9;     // Catch: Throwable -> L60
        this.L$2 = r8;     // Catch: Throwable -> L60
        this.L$3 = r13;     // Catch: Throwable -> L60
        this.L$4 = r6;     // Catch: Throwable -> L60
        this.L$5 = r12;     // Catch: Throwable -> L60
        this.label = 3;     // Catch: Throwable -> L60
        r11 = r26.t(true, this);     // Catch: Throwable -> L60
        if (r11 != r0) goto L55;
        return r0;
    L55:
        r5 = r13;
        r3 = r12;
    L60:
        th = th;
        r5 = r13;
        r4 = r6;
        r3 = r12;
        goto L62
    L39:
        if (r8.a != true) goto L41;
        r111 = true;
        goto L42
    L35:
        return ObricUserExperiencePlanManager.d();
    L15:
        Deferred r33 = (Deferred) this.L$4;
        IObricNetworkService r34 = (IObricNetworkService) this.L$3;
        r9 = (ObricUserExperiencePlanManager.a) this.L$2;
        r10 = (String) this.L$1;
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r35 = r21;
        IObricNetworkService r36 = r34;
    L28:
        p r37 = (p) r35;
        this.L$0 = r113;
        this.L$1 = r10;
        this.L$2 = r9;
        this.L$3 = r36;
        this.L$4 = r37;
        this.label = 2;
        r29 = r33.await(this);
        if (r29 != r0) goto L31;
        return r0;
    L31:
        r26 = r36;
        r8 = r37;
        goto L32
    L16:
        ResultKt.throwOnFailure(r21);
        CoroutineScope r38 = (CoroutineScope) this.L$0;
        ObricUserExperiencePlanManager r39 = ObricUserExperiencePlanManager.a;
        String r114 = ObricUserExperiencePlanManager.a();
        ObricUserExperiencePlanManager.a r115 = ObricUserExperiencePlanManager.e();
        if (StringsKt.isBlank(r114) == false) goto L20;
        ObricUserExperiencePlanManager.d.setValue(r115);
        return r115;
    L20:
        IObricNetworkService r116 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r116 != null) goto L24;
        ObricUserExperiencePlanManager.d.setValue(r115);
        return r115;
    L24:
        r36 = r116;
        Deferred r117 = BuildersKt.async$default(r38, Dispatchers.getIO(), null, new ObricUserExperiencePlanManager$refreshLocked$2$voiceDeferred$1(r116, null), 2, null);
        Deferred r40 = BuildersKt.async$default(r38, Dispatchers.getIO(), null, new ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1(r36, null), 2, null);
        this.L$0 = r38;
        this.L$1 = r114;
        this.L$2 = r115;
        this.L$3 = r36;
        this.L$4 = r40;
        this.label = 1;
        r35 = r117.await(this);
        if (r35 != r0) goto L27;
        return r0;
    L27:
        r113 = r38;
        r33 = r40;
        r10 = r114;
        r9 = r115;
        goto L28
    }
}
