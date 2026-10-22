package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final LinkedHashMap<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> a;

    public f() {
        this.a = new LinkedHashMap();
    }

    public final void a(RecordingPriorityScene r3, Function1<? super a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        r4.invoke(new a(r3, this.a));
    }
}
