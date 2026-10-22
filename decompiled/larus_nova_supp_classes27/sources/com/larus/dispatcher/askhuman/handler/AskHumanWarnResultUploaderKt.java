package com.larus.dispatcher.askhuman.handler;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AskHumanWarnResultUploaderKt {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static final p a(u r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "serverOption");
        Intrinsics.checkNotNullParameter(r8, "messageId");
        BuildersKt.launch$default(a, null, null, new AskHumanWarnResultUploaderKt$uploadAskHumanWarnResult$1(r8, r7, null), 3, null);
        return new p(true, true);
    }
}
