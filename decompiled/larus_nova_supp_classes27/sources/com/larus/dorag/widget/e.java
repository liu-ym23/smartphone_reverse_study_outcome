package com.larus.dorag.widget;

import com.larus.network.util.ScreenStateManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements ScreenStateManager.b {
    public e() {
    }

    public final void onScreenOff() {
        f.c = true;
    }

    public final void onScreenOn() {
        f.c = false;
        String r0 = f.a;
        f.a();
    }

    public final void onUserPresent() {
    }
}
