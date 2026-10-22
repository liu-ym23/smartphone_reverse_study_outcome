package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.broadcastgame.api.openplatform.b {
    public static final g a = null;

    public g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void c(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void d(String r1, Map<String, String> r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void e(u r2) {
        Intrinsics.checkNotNullParameter(r2, "gameItem");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String h() {
        Intrinsics.checkNotNullParameter("", "appId");
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void i(long r1, String r3, String r4, Map<String, ? extends Object> r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "schema");
        Intrinsics.checkNotNullParameter(r5, "params");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void j(String r3) {
        Intrinsics.checkNotNullParameter("sei", "name");
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void k() {
        Intrinsics.checkNotNullParameter("", "appId");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void notifyStartLinkCastResult(boolean r1, Surface r2, int r3) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void stopGameCastToAudience() {
    }

    static {
        a = new g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String getGameCategory() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
