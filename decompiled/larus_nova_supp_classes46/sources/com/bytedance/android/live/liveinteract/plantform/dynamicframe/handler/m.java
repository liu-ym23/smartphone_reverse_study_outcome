package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public static final void a(ih0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "service");
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L8;
        JsonObject r1 = r0.getRecordeLastSpeechRhythmBeats();
        if (r1 == null) goto L9;
        r4.Dk("audiochat_stage", "speech_effect", r1, false);
        return;
    L9:
        return;
    }
}
