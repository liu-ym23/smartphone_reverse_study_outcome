package androidx.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", i = {0}, l = {185}, m = "reportWhenComplete", n = {"$this$reportWhenComplete"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporterKt$reportWhenComplete$1\n*L\n1#1,190:1\n*E\n"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    public static final Object reportWhenComplete(FullyDrawnReporter r5, Function1<? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        FullyDrawnReporter r17 = (FullyDrawnReporter) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        FullyDrawnReporter r18 = r17;
    L25:
        InlineMarker.finallyStart(1);
        r18.removeReporter();
        InlineMarker.finallyEnd(1);
        r5 = Unit.INSTANCE;
        return r5;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r5.addReporter();
        if (r5.isFullyDrawnReported() == true) goto L21;
        r12.L$0 = r5;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        r18 = r5;
        if (r10.invoke(r12) != r15) goto L25;
        return r15;
    L21:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.removeReporter();
        InlineMarker.finallyEnd(1);
        throw th;
    L7:
        r12 = new AnonymousClass1(r11);
        goto L8
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter r5, Function1<? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Unit> r11) {
        r5.addReporter();
        if (r5.isFullyDrawnReported() == false) goto L13;
        return Unit.INSTANCE;
    L13:
        r10.invoke(r11);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r5.removeReporter();
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.removeReporter();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
