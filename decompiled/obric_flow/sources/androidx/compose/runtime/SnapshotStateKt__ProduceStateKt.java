package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aq\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052-\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ag\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052-\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052-\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001ak\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u00052-\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aS\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022-\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"produceState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "initialValue", "key1", "", "key2", "key3", "producer", "Lkotlin/Function2;", "Landroidx/compose/runtime/ProduceStateScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "keys", "", "(Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
@SourceDebugExtension({"SMAP\nProduceState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProduceState.kt\nandroidx/compose/runtime/SnapshotStateKt__ProduceStateKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,223:1\n25#2:224\n25#2:231\n25#2:238\n25#2:245\n25#2:252\n1097#3,6:225\n1097#3,6:232\n1097#3,6:239\n1097#3,6:246\n1097#3,6:253\n*S KotlinDebug\n*F\n+ 1 ProduceState.kt\nandroidx/compose/runtime/SnapshotStateKt__ProduceStateKt\n*L\n81#1:224\n114#1:231\n148#1:238\n183#1:245\n216#1:252\n81#1:225,6\n114#1:232,6\n148#1:239,6\n183#1:246,6\n216#1:253,6\n*E\n"})
final /* synthetic */ class SnapshotStateKt__ProduceStateKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1", f = "ProduceState.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r5, MutableState<T> r10, Continuation<? super AnonymousClass1> r11) {
            this.$producer = r5;
            this.$result = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(this.$producer, this.$result, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1 for r5v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r5.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r6);
        L11:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE;
            return r5;
        L6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r6);
            java.lang.Object r6 = r5.L$0;
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
            kotlin.jvm.functions.Function2<androidx.compose.runtime.ProduceStateScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$producer;
            androidx.compose.runtime.MutableState<T> r4 = r5.$result;
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext();
            androidx.compose.runtime.ProduceStateScopeImpl r3 = new androidx.compose.runtime.ProduceStateScopeImpl(r4, r6);
            r5.label = 1;
            androidx.compose.runtime.ProduceStateScopeImpl r3 = r3;
            java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
            java.lang.Object r5 = r1.mo2invoke(r3, r5);
            if (r5 != r0) goto L11;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2", f = "ProduceState.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r5, MutableState<T> r10, Continuation<? super AnonymousClass2> r11) {
            this.$producer = r5;
            this.$result = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass2 r11 = new AnonymousClass2(this.$producer, this.$result, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2 for r5v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r5.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r6);
        L11:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE;
            return r5;
        L6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r6);
            java.lang.Object r6 = r5.L$0;
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
            kotlin.jvm.functions.Function2<androidx.compose.runtime.ProduceStateScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$producer;
            androidx.compose.runtime.MutableState<T> r4 = r5.$result;
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext();
            androidx.compose.runtime.ProduceStateScopeImpl r3 = new androidx.compose.runtime.ProduceStateScopeImpl(r4, r6);
            r5.label = 1;
            androidx.compose.runtime.ProduceStateScopeImpl r3 = r3;
            java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
            java.lang.Object r5 = r1.mo2invoke(r3, r5);
            if (r5 != r0) goto L11;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3", f = "ProduceState.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r5, MutableState<T> r10, Continuation<? super AnonymousClass3> r11) {
            this.$producer = r5;
            this.$result = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass3 r11 = new AnonymousClass3(this.$producer, this.$result, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3 for r5v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r5.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r6);
        L11:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE;
            return r5;
        L6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r6);
            java.lang.Object r6 = r5.L$0;
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
            kotlin.jvm.functions.Function2<androidx.compose.runtime.ProduceStateScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$producer;
            androidx.compose.runtime.MutableState<T> r4 = r5.$result;
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext();
            androidx.compose.runtime.ProduceStateScopeImpl r3 = new androidx.compose.runtime.ProduceStateScopeImpl(r4, r6);
            r5.label = 1;
            androidx.compose.runtime.ProduceStateScopeImpl r3 = r3;
            java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
            java.lang.Object r5 = r1.mo2invoke(r3, r5);
            if (r5 != r0) goto L11;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4", f = "ProduceState.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r5, MutableState<T> r10, Continuation<? super AnonymousClass4> r11) {
            this.$producer = r5;
            this.$result = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass4 r11 = new AnonymousClass4(this.$producer, this.$result, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4 for r5v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r5.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r6);
        L11:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE;
            return r5;
        L6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r6);
            java.lang.Object r6 = r5.L$0;
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
            kotlin.jvm.functions.Function2<androidx.compose.runtime.ProduceStateScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$producer;
            androidx.compose.runtime.MutableState<T> r4 = r5.$result;
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext();
            androidx.compose.runtime.ProduceStateScopeImpl r3 = new androidx.compose.runtime.ProduceStateScopeImpl(r4, r6);
            r5.label = 1;
            androidx.compose.runtime.ProduceStateScopeImpl r3 = r3;
            java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
            java.lang.Object r5 = r1.mo2invoke(r3, r5);
            if (r5 != r0) goto L11;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass4) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5", f = "ProduceState.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r5, MutableState<T> r10, Continuation<? super AnonymousClass5> r11) {
            this.$producer = r5;
            this.$result = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass5 r11 = new AnonymousClass5(this.$producer, this.$result, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5 for r5v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r5.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r6);
        L11:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE;
            return r5;
        L6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r6);
            java.lang.Object r6 = r5.L$0;
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
            kotlin.jvm.functions.Function2<androidx.compose.runtime.ProduceStateScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$producer;
            androidx.compose.runtime.MutableState<T> r4 = r5.$result;
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext();
            androidx.compose.runtime.ProduceStateScopeImpl r3 = new androidx.compose.runtime.ProduceStateScopeImpl(r4, r6);
            r5.label = 1;
            androidx.compose.runtime.ProduceStateScopeImpl r3 = r3;
            java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
            java.lang.Object r5 = r1.mo2invoke(r3, r5);
            if (r5 != r0) goto L11;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass5) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "producer");
        r11.startReplaceableGroup(10454275);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(10454275, r12, -1, "androidx.compose.runtime.produceState (ProduceState.kt:76)");
    L5:
        r11.startReplaceableGroup(-492369756);
        Object r13 = r11.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L8;
        r13 = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        r11.updateRememberedValue(r13);
    L8:
        r11.endReplaceableGroup();
        MutableState r14 = (MutableState) r13;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AnonymousClass1(r10, r14, null), r11, 70);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r11.endReplaceableGroup();
        return r14;
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object r10, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "producer");
        r12.startReplaceableGroup(-1928268701);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1928268701, r13, -1, "androidx.compose.runtime.produceState (ProduceState.kt:108)");
    L5:
        r12.startReplaceableGroup(-492369756);
        Object r14 = r12.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L8;
        r14 = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        r12.updateRememberedValue(r14);
    L8:
        r12.endReplaceableGroup();
        MutableState r15 = (MutableState) r14;
        EffectsKt.LaunchedEffect(r10, new AnonymousClass2(r11, r15, null), r12, 72);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r12.endReplaceableGroup();
        return r15;
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object r10, Object r11, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r12, Composer r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "producer");
        r13.startReplaceableGroup(-1703169085);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1703169085, r14, -1, "androidx.compose.runtime.produceState (ProduceState.kt:141)");
    L5:
        r13.startReplaceableGroup(-492369756);
        Object r15 = r13.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L8;
        r15 = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        r13.updateRememberedValue(r15);
    L8:
        r13.endReplaceableGroup();
        MutableState r16 = (MutableState) r15;
        EffectsKt.LaunchedEffect(r10, r11, new AnonymousClass3(r12, r16, null), r13, 584);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r13.endReplaceableGroup();
        return r16;
    }

    @Composable
    public static final <T> State<T> produceState(T r10, Object r11, Object r12, Object r13, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r14, Composer r15, int r16) {
        Intrinsics.checkNotNullParameter(r14, "producer");
        r15.startReplaceableGroup(1807205155);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1807205155, r16, -1, "androidx.compose.runtime.produceState (ProduceState.kt:175)");
    L5:
        r15.startReplaceableGroup(-492369756);
        Object r17 = r15.rememberedValue();
        if (r17 != Composer.Companion.getEmpty()) goto L8;
        r17 = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
        r15.updateRememberedValue(r17);
    L8:
        r15.endReplaceableGroup();
        MutableState r18 = (MutableState) r17;
        EffectsKt.LaunchedEffect(r11, r12, r13, new AnonymousClass4(r14, r18, null), r15, 4680);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r15.endReplaceableGroup();
        return r18;
    }

    @Composable
    public static final <T> State<T> produceState(T r5, Object[] r10, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        Intrinsics.checkNotNullParameter(r11, "producer");
        r12.startReplaceableGroup(490154582);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(490154582, r13, -1, "androidx.compose.runtime.produceState (ProduceState.kt:210)");
    L5:
        r12.startReplaceableGroup(-492369756);
        Object r14 = r12.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L8;
        r14 = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        r12.updateRememberedValue(r14);
    L8:
        r12.endReplaceableGroup();
        MutableState r15 = (MutableState) r14;
        EffectsKt.LaunchedEffect(Arrays.copyOf(r10, r10.length), new AnonymousClass5(r11, r15, null), r12, 72);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r12.endReplaceableGroup();
        return r15;
    }
}
