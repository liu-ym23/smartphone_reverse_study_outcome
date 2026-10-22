package com.obric.audio.enroll.sidauth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        if (r3 != 220014) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        return r2 + " ret=" + r3 + " registerAudioLoadFromDbFailed";
    L10:
        return r2 + " ret=" + r3;
    L5:
        r0 = false;
        goto L7
    }
}
