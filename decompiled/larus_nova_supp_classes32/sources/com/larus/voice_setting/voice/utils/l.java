package com.larus.voice_setting.voice.utils;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        return Intrinsics.areEqual(r1.i0(), Boolean.TRUE);
    L7:
        return false;
    }
}
