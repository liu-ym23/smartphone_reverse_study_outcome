package com.larus.dora.impl.guide.service;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$launch$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$launch$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$launch$2(GuideSession r1, Continuation<? super GuideSession$launch$2> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new GuideSession$launch$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r11);
        this.this$0.j.clear();     // Catch: Exception -> L18
        i59.d r12 = new i59.d(this.this$0);     // Catch: Exception -> L18
        GuideSession r0 = this.this$0;     // Catch: Exception -> L18
        Iterator<T> r1 = r0.f.iterator();     // Catch: Exception -> L18
    L7:
        if (r1.hasNext() == false) goto L11;
        l r2 = r12.a(((Number) r1.next()).intValue());     // Catch: Exception -> L18
        if (r2 == null) goto L7;
        r0.j.add(r2);     // Catch: Exception -> L18
        goto L7
    L11:
        GuideSession r13 = this.this$0;     // Catch: Exception -> L18
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        String r4 = CollectionsKt.joinToString$default(r13.j, ",", null, null, 0, null, new d(), 30, null);     // Catch: Throwable -> L14
        g49.d.d(r13.c(), "launch() created guides, page=" + r13.d + ", filter=" + r13.f + ", count=" + r13.j.size() + ", guides=[" + r4 + ']');     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        GuideSession r14 = this.this$0;     // Catch: Exception -> L18
        r14.getClass();     // Catch: Exception -> L18
        r14.e(new GuideSession$launchNextGuide$1(r14, null));     // Catch: Exception -> L18
    L21:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Exception -> L18
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        g49.d.c(this.this$0.c(), "launchGuideSession orchestrator failed: " + e.getMessage(), e);
        goto L21
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
