package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.notification.MmDoubaoRecordingNotificationProcessor$start$1", f = "MmDoubaoRecordingNotificationProcessor.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_WIKI_SPACE}, m = "invokeSuspend", n = {}, s = {})
public final class MmDoubaoRecordingNotificationProcessor$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingNotificationRepo $notificationRepo;
    int label;
    final /* synthetic */ MmDoubaoRecordingNotificationProcessor this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmDoubaoRecordingNotificationProcessor a;

        public a(MmDoubaoRecordingNotificationProcessor r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            b r7 = (b) r5;
            if ((r7 instanceof b.d) == false) goto L13;
            MmDoubaoRecordingNotificationProcessor r0 = this.a;
            boolean r8 = ((b.d) r7).a;
            r0.getClass();
            Object r9 = BuildersKt.withContext(Dispatchers.getMain(), new MmDoubaoRecordingNotificationProcessor$handleWeakNetwork$2(r8, r0, null), r6);
            if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
            r9 = Unit.INSTANCE;
        L9:
            if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
            return r9;
        L34:
            return Unit.INSTANCE;
        L13:
            if ((r7 instanceof b.a) == false) goto L23;
            MmDoubaoRecordingNotificationProcessor r10 = this.a;
            r10.getClass();
            Object r11 = BuildersKt.withContext(Dispatchers.getMain(), new MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2(r10, null), r6);
            if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
            r11 = Unit.INSTANCE;
        L19:
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
            return r11;
        L35:
            return Unit.INSTANCE;
        L23:
            if ((r7 instanceof b.c) == false) goto L33;
            MmDoubaoRecordingNotificationProcessor r1 = this.a;
            boolean r12 = ((b.c) r7).a;
            r1.getClass();
            Object r13 = BuildersKt.withContext(Dispatchers.getMain(), new MmDoubaoRecordingNotificationProcessor$handleSubtitleFailed$2(r12, r1, null), r6);
            if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            r13 = Unit.INSTANCE;
        L29:
            if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
            return r13;
        L36:
            return Unit.INSTANCE;
        L33:
            return Unit.INSTANCE;
        }
    }

    public MmDoubaoRecordingNotificationProcessor$start$1(MmRecordingNotificationRepo r1, MmDoubaoRecordingNotificationProcessor r2, Continuation<? super MmDoubaoRecordingNotificationProcessor$start$1> r3) {
        this.$notificationRepo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmDoubaoRecordingNotificationProcessor$start$1(this.$notificationRepo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1<b> r6 = this.$notificationRepo.e();
        a r2 = new a(this.this$0);
        this.label = 1;
        Object r7 = r6.collect(new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1.2(r2), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r7 = Unit.INSTANCE;
    L12:
        if (r7 != r0) goto L15;
        return r0;
    }
}
