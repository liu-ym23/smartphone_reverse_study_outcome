package com.bytedance.android.live.multilink.impl;

import com.bytedance.android.live.core.feature.RoomFeatureUtils;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t2 implements Consumer<com.bytedance.android.livesdk.chatroom.viewmodel.i> {
    public final /* synthetic */ LinkMultiControlWidget a;

    public t2(LinkMultiControlWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) throws Exception {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r5;
        ALogger.i("LinkControlWidget", "observeAudioScene, scene=" + r6.a + ",uiLayout=" + r6.b);
        if (r6.a == 0) goto L5;
    L7:
        Lazy r0 = RoomFeatureUtils.a;
        RoomFeatureUtils.b(this.a.l.getRoomId(), "live_multi_LinkmicScene", Integer.valueOf(r6.a));
        RoomFeatureUtils.b(this.a.l.getRoomId(), "live_multi_LinkMicUILayout", Integer.valueOf(r6.b));
        return;
    L5:
        if (r6.b != 0) goto L7;
        this.a.Lq("audio_scene");
        this.a.yq();
        goto L7
    }
}
