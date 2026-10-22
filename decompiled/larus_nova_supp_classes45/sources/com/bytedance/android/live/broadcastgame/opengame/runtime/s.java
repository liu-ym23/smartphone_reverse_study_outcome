package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface s<T> {
    void C(T r1);

    List<T> getListeners();

    void registerListener(T r1);
}
