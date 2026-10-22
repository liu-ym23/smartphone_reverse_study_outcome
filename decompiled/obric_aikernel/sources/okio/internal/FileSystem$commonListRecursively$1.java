package okio.internal;

import java.util.Iterator;
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

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", i = {0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super y>, Continuation<? super Unit>, Object> {
    final /* synthetic */ y $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ i $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    FileSystem$commonListRecursively$1(y r10, i r11, boolean r12, Continuation<? super FileSystem$commonListRecursively$1> r13) {
        this.$dir = r10;
        this.$this_commonListRecursively = r11;
        this.$followSymlinks = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FileSystem$commonListRecursively$1 r12 = new FileSystem$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super y> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super y> r10, Continuation<? super Unit> r11) {
        return ((FileSystem$commonListRecursively$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        Iterator<y> r12 = (Iterator) this.L$2;
        ArrayDeque r14 = (ArrayDeque) this.L$1;
        SequenceScope r15 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r13);
        SequenceScope r16 = r15;
    L10:
        if (r12.hasNext() == false) goto L15;
        y r17 = r12.next();
        i r18 = this.$this_commonListRecursively;
        boolean r19 = this.$followSymlinks;
        this.L$0 = r16;
        this.L$1 = r14;
        this.L$2 = r12;
        this.label = 1;
        if (FileSystem.a(r16, r18, r14, r17, r19, false, this) != r10) goto L10;
        return r10;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        r16 = (SequenceScope) this.L$0;
        ArrayDeque r20 = new ArrayDeque();
        r20.addLast(this.$dir);
        Iterator<y> r21 = this.$this_commonListRecursively.a(this.$dir).iterator();
        r14 = r20;
        r12 = r21;
        goto L10
    }
}
