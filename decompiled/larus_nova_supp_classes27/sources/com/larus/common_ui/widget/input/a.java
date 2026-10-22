package com.larus.common_ui.widget.input;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(byte[] r4, int r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AudioUtils$getAudioWave$2(r4, 16, r5, null), r6);
    }
}
