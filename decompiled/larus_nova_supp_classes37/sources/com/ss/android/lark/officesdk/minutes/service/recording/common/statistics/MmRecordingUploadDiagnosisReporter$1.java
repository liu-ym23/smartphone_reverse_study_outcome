package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingUploadDiagnosisReporter$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final MmRecordingUploadDiagnosisReporter$1 INSTANCE = null;

    static {
        INSTANCE = new MmRecordingUploadDiagnosisReporter$1();
    }

    public MmRecordingUploadDiagnosisReporter$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m379invoke() {
        return invoke();
    }
}
