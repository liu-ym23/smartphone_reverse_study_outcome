package com.bytedance.android.livesdk.chatroom.ui.framework;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.helper.RoomContextInitHelper;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionComponentManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements Runnable {
    public final /* synthetic */ NewAudienceInteractionFragment a;

    public m(NewAudienceInteractionFragment r1) {
        this.a = r1;
    }

    public final void a() {
        InteractionComponentManager r0 = this.a.f;
        if (r0.e == true) goto L11;
        Context r1 = r0.getContext().q.getContext();
        if (r1 == null) goto L10;
        RoomContextInitHelper.a(r0.getContext().d(), r1, r0.getContext().b(), !r0.getContext().r);
        return;
    L10:
        throw new RuntimeException("context is null!!!");
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
