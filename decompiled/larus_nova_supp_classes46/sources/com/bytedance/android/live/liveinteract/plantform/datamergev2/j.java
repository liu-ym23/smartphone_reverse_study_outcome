package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements vlc.l {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r3) {
        if (this.a.f.getFeedLiveType() == 5) goto L6;
        return;
    L6:
        if ((r3 instanceof h1) == false) goto L18;
        h1 r4 = (h1) r3;
        if (r4.getMType() != 12) goto L19;
        ILinkerUpdateUserContent r0 = r4.getMUpdateUser();
        ClientUIInfo r1 = null;
        if (r0 == null) goto L12;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2 = r0.getMLinkUsers();
    L13:
        ILinkerUpdateUserContent r5 = r4.getMUpdateUser();
        if (r5 == null) goto L16;
        r1 = r5.getClientUiInfo();
    L16:
        this.a.g(r2, r1);
        return;
    L12:
        r2 = null;
        goto L13
    L19:
        return;
    }
}
