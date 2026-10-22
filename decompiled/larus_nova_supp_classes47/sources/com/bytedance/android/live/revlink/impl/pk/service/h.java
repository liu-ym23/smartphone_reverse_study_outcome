package com.bytedance.android.live.revlink.impl.pk.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.link.model.bridge.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h {

    public static final class a {
        public static /* synthetic */ void a(h r1, Integer r2, int r3) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            r1.finishInteract(null, r2);
        }
    }

    void finish(String r1);

    void finishInteract(String r1, Integer r2);

    LiveData<Boolean> getGuestMuteState();

    oq2.d getPkLayoutData(boolean r1);

    void handlePkRoomClose(boolean r1);

    void onLynxMicInteractionEvent(int r1);

    void receiveChorusMessage(f0 r1);

    void sendGuestKickOut(String r1, String r2);
}
