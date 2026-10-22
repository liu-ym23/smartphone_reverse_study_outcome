package com.larus.vesdk.impl.utils;

import com.ss.android.vesdk.VEEditor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoEditProcessor {
    public static final Map<String, VEEditor> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(VEEditor r7, long r8) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoEditProcessor$delayDestroy$1(r8, r7, null), 3, null);
    }
}
