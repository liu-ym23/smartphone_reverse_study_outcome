package com.bytedance.android.live.liveinteract.utils;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static RtcAudioScene a(int r1, int r2, List r3) {
        Intrinsics.checkNotNullParameter(r3, "playModes");
        boolean r4 = r3.contains(21);
        if (r2 == 62) goto L25;
        if (r2 == 63) goto L25;
        if (r1 == 9) goto L10;
        if (r4 == false) goto L19;
        return RtcAudioScene.KTV;
    L19:
        if (ArraysKt.contains(k1.a, Integer.valueOf(r1)) == false) goto L23;
        return RtcAudioScene.CHAT_ROOM;
    L23:
        return RtcAudioScene.NORMAL;
    L10:
        if (r2 != 61) goto L14;
        return RtcAudioScene.REAL_TIME_CHORUS;
    L14:
        return RtcAudioScene.KTV;
    L25:
        return RtcAudioScene.REAL_TIME_CHORUS;
    }
}
