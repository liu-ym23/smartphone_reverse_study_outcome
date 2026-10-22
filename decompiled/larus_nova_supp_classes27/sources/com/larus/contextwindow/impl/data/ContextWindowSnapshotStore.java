package com.larus.contextwindow.impl.data;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ContextWindowSnapshotStore {
    public static final StateFlowImpl a = null;

    static {
        a = j1.a(null);
    }

    public static Flow a(final ContextWindowSnapshot r3) {
        Intrinsics.checkNotNullParameter(r3, "initialSnapshot");
        final FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1 r1 = new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(a);
        Flow<ContextWindowSnapshot> r0 = new ContextWindowSnapshotStore$observe$$inlined$filter$1(r1, r3);
        return e.n(new FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1(new ContextWindowSnapshotStore$observe$2(r3, null), r0));
    }
}
