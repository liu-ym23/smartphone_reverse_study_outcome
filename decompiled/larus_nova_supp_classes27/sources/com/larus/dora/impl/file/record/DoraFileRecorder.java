package com.larus.dora.impl.file.record;

import com.larus.dora.impl.file.DoraFileFetchTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraFileRecorder {
    public static final StateFlowImpl a = null;
    public static final StateFlowImpl b = null;
    public static final Lazy c = null;

    static {
        a = j1.a(CollectionsKt.emptyList());
        b = j1.a(CollectionsKt.emptyList());
        c = LazyKt.lazy(new a());
    }

    public static void a(DoraFileFetchTask r7) {
        Intrinsics.checkNotNullParameter(r7, "task");
        BuildersKt.launch$default((CoroutineScope) c.getValue(), null, null, new DoraFileRecorder$addOrUpdateTask$1(r7, null), 3, null);
    }

    public static void b(DoraFileFetchTask r7) {
        Intrinsics.checkNotNullParameter(r7, "task");
        BuildersKt.launch$default((CoroutineScope) c.getValue(), null, null, new DoraFileRecorder$removeTask$1(r7, null), 3, null);
    }
}
