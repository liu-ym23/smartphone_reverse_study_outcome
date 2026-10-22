package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.l;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionEvent$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1815}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$listenSessionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionEvent$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionEvent$1$1", f = "MmRecordingSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<l, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $session;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingSessionManager this$0;

        public AnonymousClass1(MmRecordingSessionManager r1, MmRecordingSession r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$session = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$session, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(l r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((l) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            l r5 = (l) this.L$0;
            lvb.a.e(this.this$0.b, "[recordingEvent] recordingId:" + this.$session.e() + ", event: " + r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSessionManager a;

        public a(MmRecordingSessionManager r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            MutableSharedFlow<l> r0 = this.a.G;
            Object r4 = r0.emit((l) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSessionManager$listenSessionEvent$1(MmRecordingSession r1, MmRecordingSessionManager r2, Continuation<? super MmRecordingSessionManager$listenSessionEvent$1> r3) {
        this.$session = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSessionManager$listenSessionEvent$1(this.$session, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MmRecordingSession r8 = this.$session;
        a1 r2 = r8.r;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, r8, null);
        a r9 = new a(this.this$0);
        this.label = 1;
        Object r10 = r2.collect(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1.2(r9, r3), this);
        if (r10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r10 = Unit.INSTANCE;
    L12:
        if (r10 != r0) goto L15;
        return r0;
    }
}
