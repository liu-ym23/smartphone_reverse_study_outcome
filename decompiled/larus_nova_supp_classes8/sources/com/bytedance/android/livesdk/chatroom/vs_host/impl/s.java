package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements com.bytedance.android.scope.o, vr1.p {
    public s() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.p
    public final Context a(Context r3) {
        if ((r3 instanceof LynxContext) == true) goto L5;
        r3 = null;
    L5:
        LynxContext r4 = (LynxContext) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getBaseContext();
    }
}
