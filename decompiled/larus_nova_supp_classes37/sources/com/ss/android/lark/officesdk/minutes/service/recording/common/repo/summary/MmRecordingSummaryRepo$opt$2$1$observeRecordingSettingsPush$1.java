package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPushSettings;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$observeRecordingSettingsPush$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSummaryRepo$opt$2$1$observeRecordingSettingsPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSummaryRepo this$0;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$1;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 a;

        public a(MmRecordingSummaryRepo$opt$2.AnonymousClass1 r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            MinutesRecordingPushSettings r5 = (MinutesRecordingPushSettings) r3;
            MmRecordingSummaryRepo$opt$2.AnonymousClass1 r6 = this.a;
            if (Intrinsics.areEqual(r5.session_id, r6.h.j.a.w.a) == false) goto L7;
            lvb.a.e(r6.h.l, "[onPushRecordingSettings] sessionId=" + r5.session_id + ", aiView=" + r5.ai_view);
        L7:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSummaryRepo$opt$2$1$observeRecordingSettingsPush$1(MmRecordingSummaryRepo r1, MmRecordingSummaryRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSummaryRepo$opt$2$1$observeRecordingSettingsPush$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSummaryRepo$opt$2$1$observeRecordingSettingsPush$1(this.this$0, this.this$1, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1 r6 = this.this$0.k.Q().b(Command.MINUTES_RECORDING_PUSH_SETTINGS, MinutesRecordingPushSettings.class);
        a r2 = new a(this.this$1);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
