package com.bytedance.android.live.core.utils;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.utils.KotlinUtilsKt$valueSequence$1", f = "KotlinUtils.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$sequence", "i"}, s = {"L$0", "I$0"})
final class KotlinUtilsKt$valueSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SparseArray $this_valueSequence;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public KotlinUtilsKt$valueSequence$1(SparseArray r1, Continuation r2) {
        this.$this_valueSequence = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        KotlinUtilsKt$valueSequence$1 r0 = new KotlinUtilsKt$valueSequence$1(this.$this_valueSequence, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0044 -> B:13:0x0047). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r3 = this.I$0;
        SequenceScope r4 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r7);
        KotlinUtilsKt$valueSequence$1 r8 = this;
    L13:
        r3 = r3 + 1;
    L9:
        if (r3 >= r2) goto L15;
        Object r5 = r8.$this_valueSequence.valueAt(r3);
        r8.L$0 = r4;
        r8.I$0 = r3;
        r8.I$1 = r2;
        r8.label = 1;
        if (r4.yield(r5, r8) != r0) goto L13;
        return r0;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        SequenceScope r9 = (SequenceScope) this.L$0;
        r2 = this.$this_valueSequence.size();
        r3 = 0;
        r4 = r9;
        r8 = this;
        goto L9
    }
}
