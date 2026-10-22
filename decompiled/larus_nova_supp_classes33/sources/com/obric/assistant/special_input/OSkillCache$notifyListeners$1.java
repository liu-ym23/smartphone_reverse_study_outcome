package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.OSkillCache$notifyListeners$1", f = "OSkillCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OSkillCache$notifyListeners$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s0 $snapshot;
    private /* synthetic */ Object L$0;
    int label;

    public OSkillCache$notifyListeners$1(s0 r1, Continuation<? super OSkillCache$notifyListeners$1> r2) {
        this.$snapshot = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        OSkillCache$notifyListeners$1 r0 = new OSkillCache$notifyListeners$1(this.$snapshot, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Ref.IntRef r12 = new Ref.IntRef();
        Ref.IntRef r0 = new Ref.IntRef();
        CopyOnWriteArraySet<WeakReference<Function1<s0, Unit>>> r1 = OSkillCache.k;
        s0 r2 = this.$snapshot;
        Iterator<WeakReference<Function1<s0, Unit>>> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L20;
        WeakReference<Function1<s0, Unit>> r4 = r3.next();
        Function1<s0, Unit> r5 = r4.get();
        if (r5 == null) goto L10;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        r5.invoke(r2);     // Catch: Throwable -> L14
        int r7 = r0.element;     // Catch: Throwable -> L14
        r0.element = r7 + 1;     // Catch: Throwable -> L14
        Object r8 = Result.constructor-impl(Boxing.boxInt(r7));     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L6;
        FLogger.a.e("OSkillCache", "notify listener failed, listenerHash=" + System.identityHashCode(r5), r9);
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L10:
        if (OSkillCache.k.remove(r4) == false) goto L6;
        r12.element++;
        goto L6
    L20:
        if (r12.element <= 0) goto L23;
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("notifyListeners cleaned invalid listeners, removed=");
        r15.append(r12.element);
        r15.append(", notified=");
        r15.append(r0.element);
        r15.append(", activeSize=");
        OSkillCache.a.getClass();
        r15.append(OSkillCache.c());
        r14.i("OSkillCache", r15.toString());
    L23:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
