package com.larus.podcast.handler;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class PodcastGenerationHandler {

    public static final class a {
    }

    static {
    }

    public static void a(vr9.a r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(r12, "podcastGenerateContext");
        FLogger.a.i("PodcastMenuHandler", "handleAction...");
        CoroutineScope r3 = r12.b;
        if (r3 == null) goto L6;
        BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new PodcastGenerationHandler$generatePodcast$1$1(r12, r12, r14, r13, null), 2, null);
        return;
    }
}
