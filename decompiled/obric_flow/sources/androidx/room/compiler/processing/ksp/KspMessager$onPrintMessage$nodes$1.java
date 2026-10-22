package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XElement;
import il.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lil/j;", "", "<anonymous>", "(Lkotlin/sequences/SequenceScope;)V"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.room.compiler.processing.ksp.KspMessager$onPrintMessage$nodes$1", f = "KspMessager.kt", i = {0, 1}, l = {46, 47, 48}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
public final class KspMessager$onPrintMessage$nodes$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super j>, Continuation<? super Unit>, Object> {
    final /* synthetic */ XAnnotation $annotation;
    final /* synthetic */ XAnnotationValue $annotationValue;
    final /* synthetic */ XElement $element;
    private /* synthetic */ Object L$0;
    int label;

    public KspMessager$onPrintMessage$nodes$1(XAnnotationValue r5, XAnnotation r10, XElement r11, Continuation<? super KspMessager$onPrintMessage$nodes$1> r12) {
        this.$annotationValue = r5;
        this.$annotation = r10;
        this.$element = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        KspMessager$onPrintMessage$nodes$1 r11 = new KspMessager$onPrintMessage$nodes$1(this.$annotationValue, this.$annotation, this.$element, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super j> r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L42:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        SequenceScope r12 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L31:
        XElement r13 = this.$element;
        if ((r13 instanceof KspElement) == false) goto L34;
        KspElement r14 = (KspElement) r13;
    L35:
        if (r14 == null) goto L37;
        il.a r15 = r14.getDeclaration();
    L38:
        this.L$0 = null;
        this.label = 3;
        if (r12.yield(r15, this) != r5) goto L42;
        return r5;
    L37:
        r15 = null;
        goto L38
    L34:
        r14 = null;
        goto L35
    L11:
        r12 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        XAnnotation r16 = this.$annotation;
        if ((r16 instanceof KspAnnotation) == false) goto L25;
        KspAnnotation r17 = (KspAnnotation) r16;
    L26:
        if (r17 == null) goto L28;
        r17.getKsAnnotated();
    L28:
        this.L$0 = r12;
        this.label = 2;
        if (r12.yield(null, this) != r5) goto L31;
        return r5;
    L25:
        r17 = null;
        goto L26
    L12:
        ResultKt.throwOnFailure(r10);
        SequenceScope r18 = (SequenceScope) this.L$0;
        XAnnotationValue r19 = this.$annotationValue;
        if ((r19 instanceof KspAnnotationValue) == false) goto L15;
        KspAnnotationValue r20 = (KspAnnotationValue) r19;
    L16:
        if (r20 == null) goto L18;
        r20.getValueArgument();
    L18:
        this.L$0 = r18;
        this.label = 1;
        if (r18.yield(null, this) != r5) goto L21;
        return r5;
    L21:
        r12 = r18;
        goto L22
    L15:
        r20 = null;
        goto L16
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super j> r5, Continuation<? super Unit> r10) {
        return ((KspMessager$onPrintMessage$nodes$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
