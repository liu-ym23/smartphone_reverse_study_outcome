package com.obric.flow.cardlistpage.mvi;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0005*\u00020\u0007H\u008a@¢\u0006\u0004\b\t\u0010\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/flow/cardlistpage/mvi/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/obric/flow/cardlistpage/mvi/j;", "I", "Lcom/obric/flow/cardlistpage/mvi/e;", "K", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.flow.cardlistpage.mvi.BaseMviComponent$collectLatestState$1", f = "BaseMviComponent.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBaseMviComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMviComponent.kt\ncom/obric/flow/cardlistpage/mvi/BaseMviComponent$collectLatestState$1\n*L\n1#1,99:1\n*E\n"})
public final class BaseMviComponent$collectLatestState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ Function0<Object> $selector;
    int label;

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.mvi.BaseMviComponent$collectLatestState$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/flow/cardlistpage/mvi/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/obric/flow/cardlistpage/mvi/j;", "I", "Lcom/obric/flow/cardlistpage/mvi/e;", "K", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @SourceDebugExtension({"SMAP\nBaseMviComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMviComponent.kt\ncom/obric/flow/cardlistpage/mvi/BaseMviComponent$collectLatestState$1$1\n*L\n1#1,99:1\n*E\n"})
    public static final class AnonymousClass1 extends Lambda implements Function0<Object> {
        final /* synthetic */ Function0<Object> $selector;

        public AnonymousClass1(Function0<Object> r5) {
            this.$selector = r5;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.$selector.invoke();
        }
    }

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.mvi.BaseMviComponent$collectLatestState$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/flow/cardlistpage/mvi/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/obric/flow/cardlistpage/mvi/j;", "I", "Lcom/obric/flow/cardlistpage/mvi/e;", "K", "value", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.obric.flow.cardlistpage.mvi.BaseMviComponent$collectLatestState$1$2", f = "BaseMviComponent.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nBaseMviComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMviComponent.kt\ncom/obric/flow/cardlistpage/mvi/BaseMviComponent$collectLatestState$1$2\n*L\n1#1,99:1\n*E\n"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass2> r10) {
            this.$action = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass2 r11 = new AnonymousClass2(this.$action, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            Object r12 = this.L$0;
            Function2<Object, Continuation<? super Unit>, Object> r13 = this.$action;
            this.label = 1;
            if (r13.mo2invoke(r12, this) != r10) goto L12;
            return r10;
        }

        public final Object invokeSuspend$$forInline(Object r5) {
            Object r10 = this.L$0;
            this.$action.mo2invoke(r10, this);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Object r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMviComponent$collectLatestState$1(Function0<Object> r5, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super BaseMviComponent$collectLatestState$1> r11) {
        this.$selector = r5;
        this.$action = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new BaseMviComponent$collectLatestState$1(this.$selector, this.$action, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.flow.g r12 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(this.$selector));
        AnonymousClass2 r13 = new AnonymousClass2(this.$action, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.i.f(r12, r13, this) != r5) goto L12;
        return r5;
    }

    public final Object invokeSuspend$$forInline(Object r5) {
        kotlinx.coroutines.flow.g r10 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(this.$selector));
        AnonymousClass2 r11 = new AnonymousClass2(this.$action, null);
        InlineMarker.mark(0);
        kotlinx.coroutines.flow.i.f(r10, r11, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((BaseMviComponent$collectLatestState$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
