package com.obric.assistant.special_input;

import android.os.IBinder;
import android.os.IInterface;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.OSkillCache$sync$2", f = "OSkillCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OSkillCache$sync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $expectedVersion;
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public OSkillCache$sync$2(Long r1, String r2, Continuation<? super OSkillCache$sync$2> r3) {
        this.$expectedVersion = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OSkillCache$sync$2 r0 = new OSkillCache$sync$2(this.$expectedVersion, this.$reason, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        String r3 = "pending";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L94;
        ResultKt.throwOnFailure(r28);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        IInterface r8 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));     // Catch: Throwable -> L15
        if (r8 != null) goto L17;
        OSkillCache.a.getClass();     // Catch: Throwable -> L15
        OSkillCache.d(null);     // Catch: Throwable -> L15
        FLogger.a.i("OSkillCache", "waiting for SkillManager IPC");     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        OSkillCache.f.set(false);
        long r7 = OSkillCache.i.getAndSet(0);
        if (r7 != 0) goto L12;
    L14:
        return r0;
    L12:
        if (r7 == OSkillCache.n.d) goto L14;
        OSkillCache.l("pending", Boxing.boxLong(r7));
        goto L14
    L17:
        Long r11 = this.$expectedVersion;     // Catch: Throwable -> L15
        String r12 = this.$reason;     // Catch: Throwable -> L15
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L72
        if (r11 == null) goto L21;
        long r14 = r11.longValue();     // Catch: Throwable -> L72
    L23:
        if (r14 != 0) goto L25;
        FLogger.a.w("OSkillCache", "sync ignored invalid remote version, reason=" + r12);     // Catch: Throwable -> L72
        String r17 = "pending";
        String r19 = "sync failed, keep old cache, reason=";
        IInterface r18 = r8;
    L70:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L75:
        String r4 = this.$reason;     // Catch: Throwable -> L85
        Long r6 = this.$expectedVersion;     // Catch: Throwable -> L85
        Throwable r2 = Result.exceptionOrNull-impl(r1);     // Catch: Throwable -> L85
        if (r2 == null) goto L78;
        OSkillCache r9 = OSkillCache.a;     // Catch: Throwable -> L85
        IBinder r10 = r18.asBinder();     // Catch: Throwable -> L85
        r9.getClass();     // Catch: Throwable -> L85
        OSkillCache.d(r10);     // Catch: Throwable -> L85
        s0 r15 = OSkillCache.n;     // Catch: Throwable -> L85
        List<OSkill> r16 = r15.a;     // Catch: Throwable -> L85
        boolean r20 = r15.b;     // Catch: Throwable -> L85
        long r21 = r15.d;     // Catch: Throwable -> L85
        Intrinsics.checkNotNullParameter(r16, "skills");     // Catch: Throwable -> L85
        OSkillCache.n = new s0(r16, r20, false, r21);     // Catch: Throwable -> L85
        FLogger.a.e("OSkillCache", r19 + r4 + ", expectedVersion=" + r6 + ", oldCount=" + OSkillCache.n.a.size() + ", oldVersion=" + OSkillCache.n.d, r2);     // Catch: Throwable -> L85
    L85:
        th = th;
        r3 = r17;
    L87:
        OSkillCache.f.set(false);
        long r22 = OSkillCache.i.getAndSet(0);
        if (r22 != 0) goto L90;
    L92:
        throw th;
    L90:
        if (r22 == OSkillCache.n.d) goto L92;
        OSkillCache r23 = OSkillCache.a;
        Long r24 = Boxing.boxLong(r22);
        r23.getClass();
        OSkillCache.l(r3, r24);
    L78:
        OSkillCache.f.set(false);
        long r25 = OSkillCache.i.getAndSet(0);
        if (r25 == 0) goto L84;
        if (r25 == OSkillCache.n.d) goto L84;
        OSkillCache r26 = OSkillCache.a;
        Long r27 = Boxing.boxLong(r25);
        r26.getClass();
        OSkillCache.l(r17, r27);
    L84:
        return Unit.INSTANCE;
    L61:
        th = th;
    L98:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L85
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L85
        goto L75
    L25:
        List r30 = r8.listSkills();     // Catch: Throwable -> L72
        if (r30 != null) goto L28;
        r30 = CollectionsKt.emptyList();     // Catch: Throwable -> L72
    L28:
        OSkillCache r110 = OSkillCache.a;     // Catch: Throwable -> L72
        List r111 = OSkillCache.b(r110, r30);     // Catch: Throwable -> L72
        s0 r31 = OSkillCache.n;     // Catch: Throwable -> L72
        int r32 = r31.a.size();     // Catch: Throwable -> L72
        s0 r33 = new s0(r111, true, true, r14);     // Catch: Throwable -> L72
        r17 = "pending";
        if (r31.b == r33.b) goto L95;
    L46:
        r19 = "sync failed, keep old cache, reason=";
        r18 = r8;
    L47:
        boolean r34 = false;
    L48:
        if (r34 == true) goto L50;
        boolean r35 = true;
    L51:
        OSkillCache.n = r33;     // Catch: Throwable -> L61
        OSkillCache.j.set(r14);     // Catch: Throwable -> L61
        if (OSkillCache.h.compareAndSet(false, true) == false) goto L54;
        String r36 = "initial sync success";
    L56:
        if (r35 == false) goto L63;
        FLogger.a.i("OSkillCache", r36 + ", reason=" + r12 + ", version=" + r14 + ", count=" + ((ArrayList) r111).size() + ", oldCount=" + r32 + ", rawSkills=" + OSkillCache.m(r30) + ", sortedSkills=" + OSkillCache.m(r111));     // Catch: Throwable -> L61
        if (OSkillCache.k.isEmpty() == false) goto L60;
        List r37 = r111;
        List<OSkill> r38 = null;
    L64:
        List<OSkill> r39 = OSkillCache.o;     // Catch: Throwable -> L61
        if ((!r39.isEmpty()) == false) goto L67;
        List<OSkill> r40 = r39;
    L68:
        if (r40 == null) goto L70;
        OSkillCache.a(r110, r40, r37);     // Catch: Throwable -> L61
        goto L70
    L67:
        r40 = r38;
        goto L68
    L60:
        r38 = null;
        BuildersKt.launch$default(OSkillCache.c, null, null, new OSkillCache$notifyListeners$1(r33, null), 3, null);     // Catch: Throwable -> L61
        r37 = r111;
        goto L64
    L63:
        r37 = r111;
        r38 = null;
        FLogger.a.i("OSkillCache", r36 + " skipped notify, reason=" + r12 + ", version=" + r14 + ", count=" + ((ArrayList) r37).size() + ", sortedSkills=" + OSkillCache.m(r37));     // Catch: Throwable -> L61
        goto L64
    L54:
        r36 = "sync success";
        goto L56
    L50:
        r35 = false;
        goto L51
    L95:
        if (r31.c != r33.c) goto L46;
        r19 = "sync failed, keep old cache, reason=";
        r18 = r8;
        if (r31.d != r33.d) goto L47;
        if (Intrinsics.areEqual(r31.a, r33.a) == false) goto L47;
        r34 = true;
    L41:
        th = th;
        r19 = "sync failed, keep old cache, reason=";
    L43:
        r18 = r8;
    L44:
        th = th;
    L45:
        r19 = "sync failed, keep old cache, reason=";
        goto L43
    L21:
        r14 = r8.getSkillListVersion();     // Catch: Throwable -> L72
    L72:
        th = th;
        r17 = "pending";
    L15:
        th = th;
        goto L87
    L94:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
