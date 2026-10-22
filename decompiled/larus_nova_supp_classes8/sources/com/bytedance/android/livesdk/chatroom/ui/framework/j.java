package com.bytedance.android.livesdk.chatroom.ui.framework;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.log.InteractionSlardarUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import vh1.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements Runnable {
    public final /* synthetic */ NewAudienceInteractionFragment a;
    public final /* synthetic */ Runnable b;

    public j(NewAudienceInteractionFragment r1, c0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        NewAudienceInteractionFragment r0 = this.a;
        int r1 = NewAudienceInteractionFragment.l;
        String r2 = r0.T90();
        if (r2 == null) goto L6;
        com.bytedance.android.live.core.tetris.widgets.d.g("continueRoomEnter checkInteractionValid failed, reason is ".concat(r2));
        int r3 = InteractionSlardarUtils.a;
        InteractionSlardarUtils.c(this.a.d, "continue", r2);
        return;
    L6:
        IComponentScheduler r4 = this.a.f.f;
        if (r4 == null) goto L9;
        r4.l();
    L9:
        Runnable r5 = this.b;
        if (r5 == null) goto L13;
        MainThreadPostUtils.b(r5);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
