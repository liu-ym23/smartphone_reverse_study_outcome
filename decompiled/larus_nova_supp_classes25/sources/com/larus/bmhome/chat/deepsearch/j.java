package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.api.q0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final void a(q0 r8, List r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "messageList");
        int r1 = i.a;
        Intrinsics.checkNotNullParameter(r8, "adapter");
        Intrinsics.checkNotNullParameter(r9, "messageList");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DeepSearchMessageAdapterCreator$setData$1(r8, r9, r10, null), 3, null);
    }
}
