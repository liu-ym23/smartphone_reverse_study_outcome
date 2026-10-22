package com.larus.audio.call.aec;

import com.larus.audio.call.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(byte[] r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "audioData");
        v58.a r0 = f.b(r5);
        int r1 = 1;
        com.larus.audio.call.play.b r6 = f.a(true, r5, null);
        if (r0.b != 12) goto L6;
        r1 = 2;
    L6:
        return (r4.length * r6.c) / (r0.a * r1);
    }
}
