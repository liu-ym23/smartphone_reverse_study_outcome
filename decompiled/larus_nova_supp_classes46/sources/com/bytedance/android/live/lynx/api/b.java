package com.bytedance.android.live.lynx.api;

import com.bytedance.android.live.broadcastgame.opengame.lynx.LynxOpenPlugin;
import com.lynx.tasm.LynxView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b extends io0.a {
    void a();

    void b(String r1, Object r2);

    void d(String r1, byte[] r2, Map<String, ? extends Object> r3);

    void e(LynxOpenPlugin.createLynxView.1 r1);

    LynxView getLynxView();

    String getUrl();

    void release();

    <T> void sendJsEvent(String r1, T r2);
}
