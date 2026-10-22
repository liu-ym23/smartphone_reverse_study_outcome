package com.bytedance.android.livesdk.gift.platform.business.effect;

import android.content.Context;
import ca0.c;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.t;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommonPlayerControllerManager implements c {
    public static final Lazy b = null;
    public PlayerController a;

    public static final class a {
    }

    public CommonPlayerControllerManager() {
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CommonPlayerControllerManager$Companion$INSTANCE$2.INSTANCE);
    }

    public final IPlayerController a(Context r3) {
        PlayerController r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Configuration r1 = new Configuration();
        r1.a = r3;
        r1.c = 1;
        PlayerController r4 = new PlayerController(r1, new t(r3));
        this.a = r4;
        return r4;
    }
}
