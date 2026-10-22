package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements Runnable {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

    public o(AudioSceneBasicBusinessContentWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.i.a;     // Catch: Throwable -> L11
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.i.a(this.a) == false) goto L9;
        DataCenter r1 = ((Widget) this.a).dataCenter;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.get("data_room", null);     // Catch: Throwable -> L11
        if (r2 == null) goto L16;
        this.a.p3(r2);     // Catch: Throwable -> L11
    L16:
        return;
    L9:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("AudioSceneBasicBusinessContentWidget tryUpdateRoomAfterP1Load failed, reason is widget not valid");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
