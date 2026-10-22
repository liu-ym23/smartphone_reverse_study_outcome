package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.OSkillCache$refreshIfStale$1", f = "OSkillCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OSkillCache$refreshIfStale$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;

    public OSkillCache$refreshIfStale$1(String r1, Continuation<? super OSkillCache$refreshIfStale$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OSkillCache$refreshIfStale$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r10);
        OSkillCache.a.getClass();     // Catch: Throwable -> L23
        OSkillCache.k();     // Catch: Throwable -> L23
        IAgentSkillManagerIDL r4 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));     // Catch: Throwable -> L23
        if (r4 == null) goto L9;
        OSkillCache.h(r4);     // Catch: Throwable -> L23
        long r3 = r4.getSkillListVersion();     // Catch: Throwable -> L23
        if (r3 != 0) goto L15;
        FLogger.a.w("OSkillCache", "refreshIfStale ignored invalid remote version, reason=" + this.$reason);     // Catch: Throwable -> L23
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L10:
        OSkillCache.g.set(false);
        return r0;
    L15:
        long r6 = OSkillCache.j.get();     // Catch: Throwable -> L23
        if (OSkillCache.n.b == true) goto L18;
    L20:
        FLogger.a.i("OSkillCache", "refreshIfStale syncing, reason=" + this.$reason + ", remoteVersion=" + r3 + ", localVersion=" + r6);     // Catch: Throwable -> L23
        OSkillCache.l(this.$reason, Boxing.boxLong(r3));     // Catch: Throwable -> L23
        OSkillCache.g.set(false);
        return Unit.INSTANCE;
    L18:
        if (r3 != r6) goto L20;
        FLogger.a.i("OSkillCache", "refreshIfStale skipped same version=" + r3 + ", reason=" + this.$reason);     // Catch: Throwable -> L23
        r0 = Unit.INSTANCE;     // Catch: Throwable -> L23
        goto L10
    L9:
        OSkillCache.d(null);     // Catch: Throwable -> L23
        FLogger.a.i("OSkillCache", "refreshIfStale waiting for SkillManager IPC, reason=" + this.$reason);     // Catch: Throwable -> L23
        r0 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        OSkillCache.g.set(false);
        throw th;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
