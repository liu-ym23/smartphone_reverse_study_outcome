package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class MmStandaloneAIInterpretationRepo$opt$2$1$syncSaveArtifactStatus$recordingId$1 extends FunctionReferenceImpl implements Function1<Continuation<? super String>, Object>, SuspendFunction {
    public MmStandaloneAIInterpretationRepo$opt$2$1$syncSaveArtifactStatus$recordingId$1(Object r8) {
        super(1, r8, MmRecordingStatesSyncService.class, "awaitRecordingIdReady", "awaitRecordingIdReady(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return ((MmRecordingStatesSyncService) ((CallableReference) this).receiver).d(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }
}
