package com.bytedance.android.live.liveinteract.linkpanel.list;

import am2.x;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends SimpleShareCallback {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;

    public c(a r1) {
        this.a = r1;
        this.b = 0;
    }

    public final void onSuccess(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "platform");
        Intrinsics.checkNotNullParameter(r7, "shareType");
        HashMap r8 = new HashMap();
        IRoom r9 = this.a.h;
        if (r9 == null) goto L5;
        boolean r10 = r9.isLiveTypeAudio();
    L7:
        if (r10 == false) goto L9;
        r8.put("live_type", "voice_live");
    L11:
        if (this.b != 0) goto L13;
        r8.put("event_page", "apply_message_panel");
    L14:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r8, null, 6);
        if (vm2.c.d() == false) goto L17;
        j0.l().sendLog("livesdk_share", r8, new Object[]{am2.n.f(), x.class, Room.class});
        return;
    L17:
        j0.l().sendLog("livesdk_share", r8, new Object[]{am2.n.f()});
        return;
    L13:
        r8.put("event_page", "invite_connection_panel");
        goto L14
    L9:
        r8.put("live_type", "video_live");
        goto L11
    L5:
        r10 = false;
        goto L7
    }
}
