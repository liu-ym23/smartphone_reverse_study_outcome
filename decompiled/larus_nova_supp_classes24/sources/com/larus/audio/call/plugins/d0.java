package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.AVKitCoreStates$DownWaiting;
import com.larus.audio.call.mgr.AVKitCoreStates$Listening;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d0 {
    public static final boolean a(AVKitDuplexState r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1.getUpState() instanceof AVKitCoreStates$Listening) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1.getDownState() instanceof AVKitCoreStates$DownWaiting) == false) goto L7;
        return true;
    }
}
