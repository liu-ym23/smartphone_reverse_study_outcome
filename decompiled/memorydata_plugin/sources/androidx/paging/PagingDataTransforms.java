package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aN\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\r*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u000f0\u0007H\u0007\u001a^\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\r*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012(\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u000f0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a9\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001a9\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001a^\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\r0\tH\u0007\u001an\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\u0002*\u0002H\r\"\b\b\u0001\u0010\r*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122.\u0010\u0017\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0018H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aH\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\r*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r0\u0007H\u0007\u001aX\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\r*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001ag\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\r*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000120\b\u0004\u0010\u000e\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u001b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0082\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"filter", "Landroidx/paging/PagingData;", ExifInterface.GPS_DIRECTION_TRUE, "", "executor", "Ljava/util/concurrent/Executor;", "predicate", "Lkotlin/Function1;", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Landroidx/paging/PagingData;Lkotlin/jvm/functions/Function2;)Landroidx/paging/PagingData;", "flatMap", "R", "transform", "", "insertFooterItem", "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "item", "(Landroidx/paging/PagingData;Landroidx/paging/TerminalSeparatorType;Ljava/lang/Object;)Landroidx/paging/PagingData;", "insertHeaderItem", "insertSeparators", "generator", "Lkotlin/Function3;", "(Landroidx/paging/PagingData;Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)Landroidx/paging/PagingData;", "map", "Landroidx/paging/PageEvent;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagingDataTransforms {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertFooterItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "<anonymous parameter 0>", "after"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertFooterItem$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<T> extends SuspendLambda implements Function3<T, T, Continuation<? super T>, Object> {
        final /* synthetic */ T $item;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(T r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$item = r3;
            super(3, r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return invoke(r3, r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(T r2, T r3, Continuation<? super T> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r6 = new AnonymousClass1(this.$item, r5);
            r6.L$0 = r3;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (this.L$0 == null) goto L11;
            return null;
        L11:
            return this.$item;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertHeaderItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "before", "<anonymous parameter 1>"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertHeaderItem$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09591<T> extends SuspendLambda implements Function3<T, T, Continuation<? super T>, Object> {
        final /* synthetic */ T $item;
        /* synthetic */ Object L$0;
        int label;

        C09591(T r3, Continuation<? super C09591> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$item = r3;
            super(3, r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return invoke(r3, r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(T r2, T r3, Continuation<? super T> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C09591 r6 = new C09591(this.$item, r5);
            r6.L$0 = r2;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (this.L$0 == null) goto L11;
            return null;
        L11:
            return this.$item;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0003H\u008a@"}, d2 = {"<anonymous>", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "before", "after"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertSeparators$1", f = "PagingDataTransforms.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
    static final class C09601<R, T> extends SuspendLambda implements Function3<T, T, Continuation<? super R>, Object> {
        final /* synthetic */ Executor $executor;
        final /* synthetic */ Function2<T, T, R> $generator;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertSeparators$1$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00371 extends SuspendLambda implements Function2<al, Continuation<? super R>, Object> {
            final /* synthetic */ T $after;
            final /* synthetic */ T $before;
            final /* synthetic */ Function2<T, T, R> $generator;
            int label;

            C00371(Function2<? super T, ? super T, ? extends R> r3, T r4, T r5, Continuation<? super C00371> r6) {
                Function2<T, T, R> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.$generator = r7;
                this.$before = r4;
                this.$after = r5;
                super(2, r8);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00371(this.$generator, this.$before, this.$after, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Object r4) {
                return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(al r3, Continuation<? super R> r4) {
                return ((C00371) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C00371.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return this.$generator.invoke(this.$before, this.$after);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C09601(Executor r3, Function2<? super T, ? super T, ? extends R> r4, Continuation<? super C09601> r5) {
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            Function2<T, T, R> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$executor = r6;
            this.$generator = r7;
            super(3, r8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return invoke(r3, r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(T r3, T r4, Continuation<? super R> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C09601 r0 = new C09601(this.$executor, this.$generator, r6);
            r0.L$0 = r3;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L11:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            Object r10 = this.L$0;
            Object r2 = this.L$1;
            CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.preCheckCast(bo.a(this.$executor), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r11 = (Function2) ZeusTransformUtils.preCheckCast(new C00371(this.$generator, r10, r2, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 1;
            r9 = i.a(r3, r11, r4);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    public static final <T> PagingData<T> filter(PagingData<T> r9, Executor r10, Function1<? super T, Boolean> r11) {
        final Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        final Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "executor");
        Intrinsics.checkNotNullParameter(r13, "predicate");
        final kotlinx.coroutines.flow.i<PageEvent<T>> r2 = r9.getFlow$paging_common();
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$filter$$inlined$transform$2(r2, r12, r13), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final /* synthetic */ PagingData filter(PagingData r9, Function2 r10) {
        final Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        final kotlinx.coroutines.flow.i r2 = r9.getFlow$paging_common();
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$filter$$inlined$transform$1(r2, r11), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final <T, R> PagingData<R> flatMap(PagingData<T> r9, Executor r10, Function1<? super T, ? extends Iterable<? extends R>> r11) {
        final Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        final Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "executor");
        Intrinsics.checkNotNullParameter(r13, "transform");
        final kotlinx.coroutines.flow.i<PageEvent<T>> r2 = r9.getFlow$paging_common();
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$flatMap$$inlined$transform$2(r2, r12, r13), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final /* synthetic */ PagingData flatMap(PagingData r9, Function2 r10) {
        final Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        final kotlinx.coroutines.flow.i r2 = r9.getFlow$paging_common();
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$flatMap$$inlined$transform$1(r2, r11), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final <T> PagingData<T> insertFooterItem(PagingData<T> r2, TerminalSeparatorType r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(r4, "item");
        return insertSeparators(r2, r3, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, null), Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> PagingData<T> insertFooterItem(PagingData<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        return insertFooterItem$default(r2, null, r3, 1, null);
    }

    public static /* synthetic */ PagingData insertFooterItem$default(PagingData r0, TerminalSeparatorType r1, Object r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = TerminalSeparatorType.FULLY_COMPLETE;
    L6:
        return insertFooterItem(r0, r1, r2);
    }

    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> r2, TerminalSeparatorType r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(r4, "item");
        return insertSeparators(r2, r3, (Function3) ZeusTransformUtils.preCheckCast(new C09591(r4, null), Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        return insertHeaderItem$default(r2, null, r3, 1, null);
    }

    public static /* synthetic */ PagingData insertHeaderItem$default(PagingData r0, TerminalSeparatorType r1, Object r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = TerminalSeparatorType.FULLY_COMPLETE;
    L6:
        return insertHeaderItem(r0, r1, r2);
    }

    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> r3, TerminalSeparatorType r4, Executor r5, Function2<? super T, ? super T, ? extends R> r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(r7, "executor");
        Intrinsics.checkNotNullParameter(r8, "generator");
        return insertSeparators(r3, r4, (Function3) ZeusTransformUtils.preCheckCast(new C09601(r7, r8, null), Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ PagingData insertSeparators(PagingData r8, TerminalSeparatorType r9, Function3 r10) {
        Function3 r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(r11, "generator");
        return new PagingData(SeparatorsKt.insertEventSeparators(r8.getFlow$paging_common(), r9, r11), r8.getUiReceiver$paging_common(), r8.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> r8, Executor r9, Function2<? super T, ? super T, ? extends R> r10) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.memorydata.plugin");
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r4, "executor");
        Intrinsics.checkNotNullParameter(r5, "generator");
        return insertSeparators$default(r8, null, r4, r5, 1, null);
    }

    public static /* synthetic */ PagingData insertSeparators$default(PagingData r1, TerminalSeparatorType r2, Executor r3, Function2 r4, int r5, Object r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = TerminalSeparatorType.FULLY_COMPLETE;
    L6:
        return insertSeparators(r1, r2, r7, r8);
    }

    public static /* synthetic */ PagingData insertSeparators$default(PagingData r1, TerminalSeparatorType r2, Function3 r3, int r4, Object r5) {
        Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = TerminalSeparatorType.FULLY_COMPLETE;
    L6:
        return insertSeparators(r1, r2, r6);
    }

    public static final <T, R> PagingData<R> map(PagingData<T> r9, Executor r10, Function1<? super T, ? extends R> r11) {
        final Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        final Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "executor");
        Intrinsics.checkNotNullParameter(r13, "transform");
        final kotlinx.coroutines.flow.i<PageEvent<T>> r2 = r9.getFlow$paging_common();
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$map$$inlined$transform$2(r2, r12, r13), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final /* synthetic */ PagingData map(PagingData r9, Function2 r10) {
        final Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        final kotlinx.coroutines.flow.i r2 = r9.getFlow$paging_common();
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$map$$inlined$transform$1(r2, r11), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }

    private static final <T, R> PagingData<R> transform(PagingData<T> r9, Function2<? super PageEvent<T>, ? super Continuation<? super PageEvent<R>>, ? extends Object> r10) {
        Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        return new PagingData((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new PagingDataTransforms$transform$$inlined$map$1(r9.getFlow$paging_common(), r11), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r9.getUiReceiver$paging_common(), r9.getHintReceiver$paging_common(), null, 8, null);
    }
}
