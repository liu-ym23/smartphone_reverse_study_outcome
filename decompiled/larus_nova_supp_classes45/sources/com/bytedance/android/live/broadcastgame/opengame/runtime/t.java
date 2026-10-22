package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements s<T> {
    public final List<T> a;
    public T b;

    public t() {
        this.a = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<T> getListeners() {
        return this.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(T r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void registerListener(T r2) {
        if (((ArrayList) getListeners()).contains(r2) == true) goto L7;
        ((ArrayList) getListeners()).add(r2);
        return;
    }
}
