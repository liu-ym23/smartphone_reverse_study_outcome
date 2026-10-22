package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import jc1.k;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c {
    public int a;
    public final com.bytedance.android.live.pushstream.d b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = -1;
        this.b = k.n(IPushStreamService.class).getPushLiveStream();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void a(int r3) {
        int r0 = qo0.a.a;
        qo0.a.c("MiniGameServerMixStream", "setCameraPushFrameRotation " + r3);
        com.bytedance.android.live.pushstream.d r1 = this.b;
        if (r1 == null) goto L6;
        r1.Y0(r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void setRadioMode(boolean r6) {
        com.bytedance.android.live.pushstream.d r0 = this.b;
        if (r0 == null) goto L22;
        d0 r1 = r0.getLiveCore();
        if (r1 == null) goto L26;
        int r2 = qo0.a.a;
        qo0.a.c("MiniGameServerMixStream", "setRadioMode " + r6 + ", old video device=" + this.a);
        uv0.a r3 = new uv0.a(LiveRequestSourceRole.Business, "MiniGameServerMixStream.setRadioMode", null);
        if (r6 == true) goto L10;
        int r7 = this.a;
        if (r7 == (-1)) goto L25;
        com.bytedance.android.live.pushstream.d r4 = this.b;
        if (r4 == null) goto L20;
        r4.Z0(r7, r3);
    L20:
        this.a = -1;
        return;
    L25:
        return;
    L10:
        if (this.a != (-1)) goto L12;
        this.a = r1.g();
    L12:
        com.bytedance.android.live.pushstream.d r8 = this.b;
        if (r8 == null) goto L23;
        r8.Z0(5, r3);
        return;
    L23:
        return;
    L26:
        return;
    }
}
