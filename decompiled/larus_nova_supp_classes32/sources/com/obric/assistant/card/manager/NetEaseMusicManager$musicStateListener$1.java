package com.obric.assistant.card.manager;

import android.os.Bundle;
import android.os.Handler;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/card/manager/NetEaseMusicManager$musicStateListener$1", "Lcom/obric/aiagent/assistant/idl/IMusicStateListenerIDL$Stub;", "onMusicStateChanged", NameKeys.UnloadStrategy_No_Strategy, "state", "Landroid/os/Bundle;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetEaseMusicManager$musicStateListener$1 extends IMusicStateListenerIDL.Stub {
    public static /* synthetic */ void a(Bundle r0) {
        onMusicStateChanged$lambda$0(r0);
    }

    public NetEaseMusicManager$musicStateListener$1() {
    }

    private static final void onMusicStateChanged$lambda$0(Bundle r4) {
        NetEaseMusicManager.f = r4;
        if (r4.getBoolean("isPlaying", false) == true) goto L6;
        NetEaseMusicManager.a.getClass();
        NetEaseMusicManager.g = true;
        NetEaseMusicManager.c.removeCallbacks(NetEaseMusicManager.h);
    L8:
        NetEaseMusicManager.a.getClass();
        NetEaseMusicManager.e(null, r4);
        return;
    L6:
        if (NetEaseMusicManager.g == false) goto L8;
        NetEaseMusicManager.a.getClass();
        NetEaseMusicManager.g = false;
        Handler r0 = NetEaseMusicManager.c;
        NetEaseMusicManager.b r1 = NetEaseMusicManager.h;
        r0.removeCallbacks(r1);
        r0.postDelayed(r1, 1000);
        goto L8
    }

    public void onMusicStateChanged(final Bundle r3) {
        if (r3 != null) goto L4;
        r3 = new Bundle();
    L4:
        NetEaseMusicManager.c.post(new i(r3));
    }
}
