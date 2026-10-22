package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingSubtitleRepo$opt$2$1$onPushSubtitleStatus$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public MmRecordingSubtitleRepo$opt$2$1$onPushSubtitleStatus$1(Object r8) {
        super(1, r8, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a.class, "notifyAutoTranslationSuggested", "notifyAutoTranslationSuggested(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(String r2) {
        ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a) ((CallableReference) this).receiver).m(r2);
    }
}
