package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface k {
    void e(Context r1, String r2, Map<String, ? extends Object> r3, n r4);

    void f();

    void onHide();

    void onShow(Map<String, String> r1);

    void onStart();

    void onStop();

    <T> void sendEvent(String r1, T r2);
}
