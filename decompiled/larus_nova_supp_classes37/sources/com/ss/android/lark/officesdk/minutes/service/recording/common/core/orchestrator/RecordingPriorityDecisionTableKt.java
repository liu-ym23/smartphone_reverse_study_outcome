package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecordingPriorityDecisionTableKt {
    public static final Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> a = null;

    static {
        RecordingPriorityDecisionTableKt$recordingPriorityDecisionTable$1 r0 = RecordingPriorityDecisionTableKt$recordingPriorityDecisionTable$1.INSTANCE;
        f r1 = new f();
        r0.invoke(r1);
        a = MapsKt.toMap(r1.a);
    }
}
