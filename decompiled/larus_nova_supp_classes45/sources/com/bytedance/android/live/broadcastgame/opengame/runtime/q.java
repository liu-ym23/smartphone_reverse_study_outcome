package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface q {
    void a();

    void b(String r1);

    void c(boolean r1);

    void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r1);

    void e(String r1, PluginType r2, Map<String, ? extends Object> r3, boolean r4, r r5);

    void g(Map<String, String> r1);

    /* JADX INFO: renamed from: getContext */
    PluginContext mo311getContext();

    com.bytedance.android.live.broadcastgame.opengame.t getPluginInfo();

    String h();

    Long i();

    void j(String r1);

    void k();

    void m();

    void notifyStartLinkCastResult(boolean r1, Surface r2, int r3);

    void stopGameCastToAudience();
}
