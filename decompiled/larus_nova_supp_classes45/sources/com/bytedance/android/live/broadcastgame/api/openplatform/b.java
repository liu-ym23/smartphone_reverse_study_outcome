package com.bytedance.android.live.broadcastgame.api.openplatform;

import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    void b(String r1);

    void c(boolean r1);

    void d(String r1, Map<String, String> r2);

    void e(u r1);

    void g(String r1, Map<String, String> r2, f.a r3);

    String getGameCategory();

    String h();

    void i(long r1, String r3, String r4, Map<String, ? extends Object> r5, boolean r6, boolean r7);

    void j(String r1);

    void k();

    void notifyStartLinkCastResult(boolean r1, Surface r2, int r3);

    void onDestroy();

    void stopGameCastToAudience();
}
