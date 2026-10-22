package com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView;

import com.bytedance.android.livesdk.gift.platform.business.effect.player.AssembleLynxPlayer;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final String a;
    public final Map<String, String> b;
    public final Map<String, f.b> c;
    public final Map<String, g<Object, Object>> d;
    public final boolean e;
    public final a f;

    public b(String r2, Map r3, Map r4, AssembleLynxPlayer.b r5) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = true;
        this.f = r5;
    }
}
