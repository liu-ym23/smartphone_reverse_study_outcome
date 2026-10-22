package okio.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.i;
import okio.y;

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super y>, Continuation<? super Unit>, Object> {
    final /* synthetic */ y $fileOrDirectory;
    final /* synthetic */ i $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    int label;

    FileSystem$commonDeleteRecursively$sequence$1(i r10, y r11, Continuation<? super FileSystem$commonDeleteRecursively$sequence$1> r12) {
        this.$this_commonDeleteRecursively = r10;
        this.$fileOrDirectory = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FileSystem$commonDeleteRecursively$sequence$1 r12 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super y> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super y> r10, Continuation<? super Unit> r11) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        SequenceScope r13 = (SequenceScope) this.L$0;
        i r14 = this.$this_commonDeleteRecursively;
        ArrayDeque r15 = new ArrayDeque();
        y r16 = this.$fileOrDirectory;
        this.label = 1;
        if (FileSystem.a(r13, r14, r15, r16, false, true, this) != r10) goto L12;
        return r10;
    }
}
