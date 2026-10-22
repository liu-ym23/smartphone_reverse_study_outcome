package com.bytedance.android.live.broadcastgame.opengame.behavior;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {
    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == false) goto L10;
        ((a) r2).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "AudienceGameVisibilityCommand(visibility=0, name=null, iconUrl=null)";
    }
}
