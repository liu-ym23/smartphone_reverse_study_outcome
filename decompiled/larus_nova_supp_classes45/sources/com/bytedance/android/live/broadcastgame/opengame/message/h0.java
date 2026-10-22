package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameLaunchSource;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 extends com.bytedance.android.live.broadcastgame.d0<f0> {
    public h0() {
    }

    @Override // com.bytedance.android.live.broadcastgame.d0
    public final Observable a(com.bytedance.android.live.broadcastgame.v r16) {
        f0 r0 = (f0) r16;
        Intrinsics.checkNotNullParameter(r0, "message");
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r1 = AnchorGameContext.a.a();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<GameLaunchSource> r2 = r1.getOpenGameLaunchSource();
        if (r2 == null) goto L9;
        GameLaunchSource r3 = (GameLaunchSource) r2.getValue();
        if (r3 == null) goto L9;
    L10:
        long r6 = r3.getSource();
        String r11 = GsonProtectorUtils.toJson(GsonHelper.get(), r0.v);
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.isRequsetingAppStart();
        if (r5 == null) goto L15;
        r5.setValue(Boolean.TRUE);
    L15:
        Lazy r7 = LiveOpenGameClient.d;
        AnchorGameNetApi r8 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        long r9 = r0.b;
        String r12 = r0.a;
        String r13 = r0.a().toString();
        boolean r14 = r0.s;
        AnchorGameContext r15 = AnchorGameContext.a.a();
        if (r15 == null) goto L22;
        com.bytedance.live.datacontext.m<Boolean> r17 = r15.getOpenGameIntroCardAutoShow();
        if (r17 == null) goto L22;
        if (((Boolean) r17.getValue()).booleanValue() != true) goto L22;
        boolean r18 = true;
    L23:
        JSONObject r19 = new JSONObject();
        if (r18 == false) goto L26;
        int r21 = 1;
    L27:
        r19.put("display_status", r21);
        r19.put("status", 1);
        r19.put("open_url", r0.h);
        r19.put(OpenPlatformBaseDebugger.APP_ID, r0.a);
        r19.put("save_time", System.currentTimeMillis() / ((long) 1000));
        String r110 = r19.toString();
        JSONObject r22 = r0.z;
        if (r22 == null) goto L31;
        String r23 = r22.toString();
        if (r23 == null) goto L31;
    L33:
        return r8.sendAppStart(r9, r12, r6, r13, r14, r11, r110, r23).compose(RxUtil.rxSchedulerHelper()).map(g0.a);
    L31:
        r23 = "";
        goto L33
    L26:
        r21 = 2;
    L22:
        r18 = false;
    L9:
        r3 = GameLaunchSource.Panel;
        goto L10
    }
}
