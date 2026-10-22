package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class RecordingPriorityRejectMessageResolver$1 extends FunctionReferenceImpl implements Function2<RecordingPriorityScene, RecordingPriorityScene, String> {
    public static final RecordingPriorityRejectMessageResolver$1 INSTANCE = null;

    static {
        INSTANCE = new RecordingPriorityRejectMessageResolver$1();
    }

    public RecordingPriorityRejectMessageResolver$1() {
        super(2, d.class, "defaultScenePairMessage", "defaultScenePairMessage(Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityScene;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityScene;)Ljava/lang/String;", 1);
    }

    public final String invoke(RecordingPriorityScene r2, RecordingPriorityScene r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        Integer r4 = d.a.get(TuplesKt.to(r2, r3));
        if (r4 == null) goto L5;
        int r5 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.e.a;
        return UIHelper.getString(r4.intValue());
    L5:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((RecordingPriorityScene) r1, (RecordingPriorityScene) r2);
    }
}
