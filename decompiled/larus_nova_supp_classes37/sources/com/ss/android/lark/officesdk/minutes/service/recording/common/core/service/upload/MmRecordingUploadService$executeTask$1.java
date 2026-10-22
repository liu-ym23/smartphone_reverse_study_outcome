package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry.MmRecordingRetryPolicy;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.o;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$executeTask$1", f = "MmRecordingUploadService.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingUploadService$executeTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingUploadTask $task;
    int label;
    final /* synthetic */ MmRecordingUploadService this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$executeTask$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/MmRecordingUploadResponse;", "cause", "", "attempt", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$executeTask$1$1", f = "MmRecordingUploadService.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"response", "attempt"}, s = {"L$0", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<FlowCollector<? super MmRecordingUploadResponse>, Throwable, Long, Continuation<? super Boolean>, Object> {
        final /* synthetic */ MmRecordingUploadTask $task;
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingUploadService this$0;

        public AnonymousClass1(MmRecordingUploadService r1, MmRecordingUploadTask r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$task = r2;
            super(4, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10) {
            return invoke((FlowCollector) r7, (Throwable) r8, ((Number) r9).longValue(), (Continuation) r10);
        }

        public final Object invoke(FlowCollector<? super MmRecordingUploadResponse> r3, Throwable r4, long r5, Continuation<? super Boolean> r7) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$task, r7);
            r6.L$0 = r4;
            r6.J$0 = r5;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r2 = this.J$0;
            MmRecordingUploadResponse r3 = (MmRecordingUploadResponse) this.L$0;
            ResultKt.throwOnFailure(r13);
            MmRecordingUploadResponse r8 = r3;
        L14:
            boolean r14 = ((Boolean) r13).booleanValue();
            if (r14 == false) goto L26;
            MmRecordingUploadService r4 = this.this$0;
            int r5 = MmRecordingUploadService.q;
            n r6 = r4.f();
            MmRecordingUploadTask r7 = this.$task;
            o r9 = this.this$0.l(null);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r7, "task");
            Intrinsics.checkNotNullParameter(r8, "response");
            Intrinsics.checkNotNullParameter(r9, "snapshot");
            int r10 = RangesKt.coerceAtLeast((int) (r2 + ((long) 2)), 2);
            Object r11 = r6.d;
            monitor-enter(r11);
            r6.j++;     // Catch: Throwable -> L21
            r6.f.put(Integer.valueOf(r7.b), Integer.valueOf(r10));     // Catch: Throwable -> L21
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r11);
            n.h(r6, "retry", r7, r10, r9, r8, null, "retry", 32);
        L21:
            th = move-exception;
            throw th;
        L26:
            return Boxing.boxBoolean(r14);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            ErrorResult r15 = (Throwable) this.L$0;
            long r16 = this.J$0;
            lvb.a.b(this.this$0.c, "task:" + this.$task.c + ", index: " + this.$task.b + ", execute failed, cause:" + r15 + ", attempt:" + r16);
            if ((r15 instanceof ErrorResult) == false) goto L24;
            MmRecordingUploadResponse.a r17 = MmRecordingUploadResponse.Companion;
            ErrorResult r18 = r15;
            Integer r19 = Boxing.boxInt(r18.getCode());
            Integer r110 = Boxing.boxInt(r18.getStatus());
            r17.getClass();
            MmRecordingUploadResponse r111 = MmRecordingUploadResponse.a.a(r19, r110);
            MmRecordingRetryPolicy r20 = (MmRecordingRetryPolicy) this.this$0.j.getValue();
            this.L$0 = r111;
            this.J$0 = r16;
            this.label = 1;
            Object r21 = r20.a(r111, r16, this);
            if (r21 != r0) goto L13;
            return r0;
        L13:
            r8 = r111;
            r13 = r21;
            r2 = r16;
            goto L14
        L24:
            r14 = false;
            goto L26
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$executeTask$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/MmRecordingUploadResponse;", "cause", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$executeTask$1$2", f = "MmRecordingUploadService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super MmRecordingUploadResponse>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingUploadTask $task;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingUploadService this$0;

        public AnonymousClass2(MmRecordingUploadService r1, MmRecordingUploadTask r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$task = r2;
            super(3, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super MmRecordingUploadResponse> r3, Throwable r4, Continuation<? super Unit> r5) {
            AnonymousClass2 r6 = new AnonymousClass2(this.this$0, this.$task, r5);
            r6.L$0 = r4;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            ErrorResult r6 = (Throwable) this.L$0;
            lvb.a.b(this.this$0.c, "task:" + this.$task.c + ", index: " + this.$task.b + " exceed max retry count,  throw it");
            if ((r6 instanceof ErrorResult) == false) goto L18;
            MmRecordingUploadResponse.a r0 = MmRecordingUploadResponse.Companion;
            ErrorResult r7 = r6;
            Integer r2 = Boxing.boxInt(r7.getCode());
            Integer r8 = Boxing.boxInt(r7.getStatus());
            r0.getClass();
            MmRecordingUploadResponse r9 = MmRecordingUploadResponse.a.a(r2, r8);
            this.this$0.getClass();
            if (r9 != MmRecordingUploadResponse.UPLOAD_COMPLETED) goto L9;
        L14:
            boolean r1 = true;
        L15:
            if (r1 == true) goto L17;
            this.this$0.f().f(this.$task, r9, this.this$0.l(null));
        L17:
            MmRecordingUploadService.b(this.this$0, this.$task, r9);
        L20:
            return Unit.INSTANCE;
        L9:
            if (r9 == MmRecordingUploadResponse.REACH_MAX_DURATION) goto L14;
            if (r9 == MmRecordingUploadResponse.OBJECT_DELETED) goto L14;
            r1 = false;
            goto L15
        L18:
            this.this$0.f().f(this.$task, null, this.this$0.l(null));
            goto L20
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingUploadService a;
        public final /* synthetic */ MmRecordingUploadTask b;

        public a(MmRecordingUploadService r1, MmRecordingUploadTask r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            MmRecordingUploadResponse r5 = (MmRecordingUploadResponse) r3;
            lvb.a.e(this.a.c, "handle task:" + this.b.c + ", index: " + this.b.b + ", res: " + r5);
            MmRecordingUploadService.b(this.a, this.b, r5);
            return Unit.INSTANCE;
        }
    }

    public MmRecordingUploadService$executeTask$1(MmRecordingUploadService r1, MmRecordingUploadTask r2, Continuation<? super MmRecordingUploadService$executeTask$1> r3) {
        this.this$0 = r1;
        this.$task = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingUploadService$executeTask$1(this.this$0, this.$task, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        MmRecordingUploadService r14 = this.this$0;
        int r2 = MmRecordingUploadService.q;
        n r3 = r14.f();
        MmRecordingUploadTask r5 = this.$task;
        o r7 = this.this$0.l(null);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "task");
        Intrinsics.checkNotNullParameter(r7, "snapshot");
        Object r15 = r3.d;
        monitor-enter(r15);
        r3.f.put(Integer.valueOf(r5.b), 1);     // Catch: Throwable -> L17
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r15);
        n.h(r3, "start", r5, 1, r7, null, null, null, 112);
        MmRecordingUploadTask r16 = this.$task;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r6 = this.this$0.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r6, "userContext");
        FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r8 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new FlowKt__ErrorsKt$retryWhen$.inlined.unsafeFlow.1(new c1(new MmRecordingUploadTask$execute$1(r16, r6, null)), new AnonymousClass1(this.this$0, this.$task, null)), new AnonymousClass2(this.this$0, this.$task, null));
        a r17 = new a(this.this$0, this.$task);
        this.label = 1;
        if (r8.collect(r17, this) != r0) goto L16;
        return r0;
    L17:
        th = move-exception;
        throw th;
    }
}
