package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends o2.a {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof l) == true) goto L6;
        return false;
    L6:
        if (this.a == ((l) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "PreviewToolbarBehaviorExtra(toBeExtended=" + this.a + ")";
    }

    public l() {
        this.a = 0;
    }
}
