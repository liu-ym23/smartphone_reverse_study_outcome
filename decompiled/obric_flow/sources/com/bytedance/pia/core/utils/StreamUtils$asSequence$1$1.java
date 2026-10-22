package com.bytedance.pia.core.utils;

import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.pia.core.utils.StreamUtils$asSequence$1$1", f = "StreamUtils.kt", i = {0, 0}, l = {39}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
final class StreamUtils$asSequence$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super char[]>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f7131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f7133c;
    public final /* synthetic */ InputStreamReader d;

    public StreamUtils$asSequence$1$1(InputStreamReader r5, Continuation r10) {
        this.d = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        StreamUtils$asSequence$1$1 r11 = new StreamUtils$asSequence$1$1(this.d, r10);
        r11.f7133c = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(SequenceScope<? super char[]> r5, Continuation<? super Unit> r10) {
        InputStreamReader r11 = this.d;
        StreamUtils$asSequence$1$1 r12 = new StreamUtils$asSequence$1$1(r11, r10);
        r12.f7133c = r5;
        return r12.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0040 -> B:14:0x0043). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f7132b;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        char[] r12 = this.f7131a;
        SequenceScope r13 = (SequenceScope) this.f7133c;
        ResultKt.throwOnFailure(r10);
        SequenceScope r14 = r13;
    L14:
        int r15 = this.d.read(r12);
    L10:
        if (r15 == (-1)) goto L16;
        char[] r16 = ArraysKt.g(r12, r15);
        this.f7133c = r14;
        this.f7131a = r12;
        this.f7132b = 1;
        if (r14.yield(r16, this) != r5) goto L14;
        return r5;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r14 = (SequenceScope) this.f7133c;
        r12 = new char[1024];
        r15 = this.d.read(r12);
        goto L10
    }
}
