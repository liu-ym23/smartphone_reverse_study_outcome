package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class MmStandaloneAIInterpretationStateHandler$onStateChanged$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public MmStandaloneAIInterpretationStateHandler$onStateChanged$4(Object r8) {
        super(0, r8, MmRecordingUploadService.class, "checkNeedTransitionToUploaded", "checkNeedTransitionToUploaded()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m305invoke() {
        ((MmRecordingUploadService) ((CallableReference) this).receiver).d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m305invoke();
        return Unit.INSTANCE;
    }
}
