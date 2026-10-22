package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPushSubtitleStatusData;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$startSubtitleStatusPushListening$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {763}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSubtitleRepo$opt$2$1$startSubtitleStatusPushListening$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 a;

        public a(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            MinutesRecordingPushSubtitleStatusData r8 = (MinutesRecordingPushSubtitleStatusData) r6;
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r9 = this.a;
            r9.getClass();
            MinutesRecordingPushSubtitleStatusData.SimultaneousInterpretationSpokenLanguageChange r0 = r8.simultaneous_interpretation_spoken_language_change;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.spoken_language;
        L6:
            MinutesRecordingPushSubtitleStatusData.SubtitleTranslationChange r3 = r8.subtitle_translation_change;
            if (r3 == null) goto L9;
            r1 = r3.language;
        L9:
            lvb.a.e(r9.s.m, "[onPushSubtitleStatus] status=" + r8.status + ", spokenLanguage=" + r2 + ", translateLanguage=" + r1);
            MinutesRecordingPushSubtitleStatusData.Status r10 = r8.status;
            MmRecordingSubtitleRepo$opt$2$1$onPushSubtitleStatus$1 r4 = new MmRecordingSubtitleRepo$opt$2$1$onPushSubtitleStatus$1(r9.s.k);
            MmRecordingSubtitleRepo$opt$2$1$onPushSubtitleStatus$2 r5 = new MmRecordingSubtitleRepo$opt$2$1$onPushSubtitleStatus$2(r9.s.k);
            Intrinsics.checkNotNullParameter(r10, "status");
            Intrinsics.checkNotNullParameter(r4, "notifyAutoTranslationSuggested");
            Intrinsics.checkNotNullParameter(r5, "notifySpokenLanguageNotSupported");
            int r11 = g.a.b[r10.ordinal()];
            if (r11 != 1) goto L12;
            r4.invoke(r1);
        L17:
            return Unit.INSTANCE;
        L12:
            if (r11 != 2) goto L17;
            r5.invoke(r2);
            goto L17
        L5:
            r2 = null;
            goto L6
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$startSubtitleStatusPushListening$1(MmRecordingSubtitleRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$startSubtitleStatusPushListening$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSubtitleRepo$opt$2$1$startSubtitleStatusPushListening$1(this.this$0, this.this$1, r4);
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
        d1 r6 = this.this$0.l.Q().b(Command.MINUTES_RECORDING_PUSH_SUBTITLE_STATUS_DATA, MinutesRecordingPushSubtitleStatusData.class);
        a r2 = new a(this.this$1);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
