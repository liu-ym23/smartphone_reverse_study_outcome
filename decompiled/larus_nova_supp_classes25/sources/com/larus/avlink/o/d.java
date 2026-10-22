package com.larus.avlink.o;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CallbackFlowBuilder b() {
        return e.e(new DoraOCapability$observeSimulBudsState$1(null));
    }

    public static Object a(Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOCapability$getAlbumPreviewData$2(5, null), r4);
    }

    public static CallbackFlowBuilder c(boolean r2) {
        return e.e(new DoraOCapability$observeSimulSubtitles$1(r2, null));
    }
}
