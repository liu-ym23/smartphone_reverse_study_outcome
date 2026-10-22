package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, Integer> a = null;

    static {
        RecordingPriorityScene r1 = RecordingPriorityScene.D3200_RECORDING;
        RecordingPriorityScene r2 = RecordingPriorityScene.OTA;
        RecordingPriorityScene r3 = RecordingPriorityScene.D3200_FILE_SYNC;
        RecordingPriorityScene r5 = RecordingPriorityScene.D1204_CHARGING_CASE_RECORDING;
        RecordingPriorityScene r6 = RecordingPriorityScene.D1204_CHARGING_CASE_FILE_SYNC;
        RecordingPriorityScene r7 = RecordingPriorityScene.D1204_UPLOAD_WALLPAPER;
        RecordingPriorityScene r8 = RecordingPriorityScene.SOFTWARE_RECORDING;
        RecordingPriorityScene r9 = RecordingPriorityScene.CALL_RECORD;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(TuplesKt.to(r1, r2), 2131893870), TuplesKt.to(TuplesKt.to(r3, r2), 2131893870), TuplesKt.to(TuplesKt.to(r5, r2), 2131893870), TuplesKt.to(TuplesKt.to(r6, r2), 2131893870), TuplesKt.to(TuplesKt.to(r7, r2), 2131893625), TuplesKt.to(TuplesKt.to(r8, r9), 2131893925), TuplesKt.to(TuplesKt.to(RecordingPriorityScene.STANDALONE_AI_INTERPRETATION, r9), 2131893925), TuplesKt.to(TuplesKt.to(r9, r2), 2131893870), TuplesKt.to(TuplesKt.to(r9, r3), 2131893864), TuplesKt.to(TuplesKt.to(r2, r1), 2131893683), TuplesKt.to(TuplesKt.to(r2, r5), 2131893683), TuplesKt.to(TuplesKt.to(r2, r9), 2131893788), TuplesKt.to(TuplesKt.to(r2, r7), 2131893863), TuplesKt.to(TuplesKt.to(r2, r3), 2131893863), TuplesKt.to(TuplesKt.to(r2, r6), 2131893863), TuplesKt.to(TuplesKt.to(r2, r2), 2131893870)});
    }
}
