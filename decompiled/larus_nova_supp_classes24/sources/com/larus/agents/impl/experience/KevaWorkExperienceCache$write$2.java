package com.larus.agents.impl.experience;

import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.experience.KevaWorkExperienceCache$write$2", f = "WorkExperienceCache.kt", i = {0}, l = {376}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class KevaWorkExperienceCache$write$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ Function1<Keva, T> $block;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ KevaWorkExperienceCache this$0;

    public KevaWorkExperienceCache$write$2(Function1<? super Keva, ? extends T> r1, KevaWorkExperienceCache r2, String r3, Continuation<? super KevaWorkExperienceCache$write$2> r4) {
        this.$block = r1;
        this.this$0 = r2;
        this.$accountId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new KevaWorkExperienceCache$write$2(this.$block, this.this$0, this.$accountId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super T> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$3;
        KevaWorkExperienceCache r3 = (KevaWorkExperienceCache) this.L$2;
        Function1<Keva, T> r4 = (Function1) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        Object r8 = r4.invoke(KevaWorkExperienceCache.m(r3, r2));     // Catch: Throwable -> L15
        r5.unlock(null);
        return r8;
    L15:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r5 = KevaWorkExperienceCache.a;
        Function1<Keva, T> r9 = this.$block;
        r3 = this.this$0;
        String r6 = this.$accountId;
        this.L$0 = r5;
        this.L$1 = r9;
        this.L$2 = r3;
        this.L$3 = r6;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r4 = r9;
        r2 = r6;
        goto L18
    }
}
