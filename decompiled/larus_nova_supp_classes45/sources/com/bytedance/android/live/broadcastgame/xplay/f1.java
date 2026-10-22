package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.livesdk.config.hk1;
import com.bytedance.android.livesdk.config.uz0;
import com.bytedance.android.livesdk.config.y20;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static hk1 a(XplayScene r2, IXplayCoreService.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "startParams");
        Map r4 = (Map) ((Map) uz0.a.getValue()).get(String.valueOf(r2.getSceneId()));
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.e);
        r0.append('_');
        r0.append(r3.f);
        String r5 = r0.toString();
        hk1 r1 = null;
        if (r4 == null) goto L5;
        hk1 r6 = (hk1) r4.get(r5);
    L6:
        if (r4 == null) goto L8;
        r1 = (hk1) r4.get("default");
    L8:
        if (r6 != null) goto L10;
        r6 = r1;
    L10:
        if (r6 == null) goto L12;
        return r6;
    L12:
        return hk1.a;
    L5:
        r6 = null;
        goto L6
    }

    public static String b(XplayScene r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Map r0 = (Map) y20.a.getValue();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        if (r2 == false) goto L9;
        Map r4 = (Map) r0.get(String.valueOf(r1.getSceneId()));
        if (r4 != null) goto L18;
    L16:
        return null;
    L18:
        return (String) r4.get("anchor");
    L9:
        if (r3 == false) goto L13;
        Map r5 = (Map) r0.get(String.valueOf(r1.getSceneId()));
        if (r5 == null) goto L16;
        return (String) r5.get("enter_anim");
    L13:
        Map r6 = (Map) r0.get(String.valueOf(r1.getSceneId()));
        if (r6 == null) goto L16;
        return (String) r6.get("audience");
    }
}
