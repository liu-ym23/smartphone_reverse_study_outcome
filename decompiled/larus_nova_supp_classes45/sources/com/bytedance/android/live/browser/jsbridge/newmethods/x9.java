package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.PreloadReplayResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "preloadReplay")
public final class x9 extends w20.a5<w20.bd, PreloadReplayResultModel> {
    public x9() {
    }

    public final void invoke(Object r11, CallContext r12) {
        w20.bd r13 = (w20.bd) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        nm1.k r14 = pm1.f.i();
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.c() != true) goto L31;
        Episode r15 = (Episode) GsonHelper.get().fromJson(r13.a(), Episode.class);     // Catch: Exception -> L21
        if (r15 != null) goto L10;
        return;
    L10:
        if (r15.getPlayVideoModel() == null) goto L28;
        nm1.i r16 = pm1.f.g();     // Catch: Exception -> L21
        if (r16 == null) goto L14;
        lm1.c r17 = r16.a();     // Catch: Exception -> L21
    L15:
        if (r17 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.replay.enter.preload.i r18 = r17.g();     // Catch: Exception -> L21
        if (r18 == null) goto L30;
        long r1 = r15.getIdExt();     // Catch: Exception -> L21
        ReplayVideoPositionInfo.Companion.getClass();     // Catch: Exception -> L21
        r18.preLoad(new pm1.b(r1, new ReplayVideoPositionInfo(-1000, -1000, false, true)));     // Catch: Exception -> L21
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r17 = null;
        goto L15
    L28:
        return;
    L21:
        e = move-exception;
        ALogger.e("PreloadReplayMethod", "invoke parse error: " + e);
        return;
    }
}
