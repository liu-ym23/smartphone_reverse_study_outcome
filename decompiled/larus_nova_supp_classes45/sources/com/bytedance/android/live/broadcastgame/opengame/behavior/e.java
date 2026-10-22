package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        public static void b(DataCenter r1, ToolbarButton r2) {
            if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
            return;
        L5:
            y3.m(r1).i(r2.extended());
            jc1.k.n(IPerformanceManager.class).onModuleStop("open_platform_toolbar_entrance");
        }

        public static void a(DataCenter r1, PluginType r2, Map r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "params");
            int r4 = d.a[r2.ordinal()];
            if (r4 != 1) goto L5;
            b(r1, ToolbarButton.OPEN_PLATFORM_MINI_GAME);
            return;
        L5:
            if (r4 != 2) goto L11;
            b(r1, ToolbarButton.OPEN_PLATFORM_MINI_GAME);
            return;
        }
    }

    static {
        a = new a();
    }
}
