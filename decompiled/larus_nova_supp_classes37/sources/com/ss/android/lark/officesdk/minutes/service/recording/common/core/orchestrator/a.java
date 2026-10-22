package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final RecordingPriorityScene a;
    public final Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> b;

    public final void b(Function1<? super e, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        a(SceneRelation.COEXIST, r2);
    }

    public final void c(Function1<? super e, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        a(SceneRelation.INTERRUPT, r2);
    }

    public a(RecordingPriorityScene r2, Map<Pair<RecordingPriorityScene, RecordingPriorityScene>, SceneRelation> r3) {
        Intrinsics.checkNotNullParameter(r2, "currentScene");
        Intrinsics.checkNotNullParameter(r3, "relations");
        this.a = r2;
        this.b = r3;
    }

    public final void a(SceneRelation r4, Function1<? super e, Unit> r5) {
        e r0 = new e();
        r5.invoke(r0);
        Iterator r6 = ((ArrayList) r0.a).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        RecordingPriorityScene r1 = (RecordingPriorityScene) r6.next();
        this.b.put(TuplesKt.to(this.a, r1), r4);
        goto L4
    }
}
