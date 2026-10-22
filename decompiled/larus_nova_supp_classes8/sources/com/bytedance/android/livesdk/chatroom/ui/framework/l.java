package com.bytedance.android.livesdk.chatroom.ui.framework;

import com.bytedance.android.livesdk.chatroom.ui.framework.base.CompatComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionComponentManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements Runnable {
    public final /* synthetic */ NewAudienceInteractionFragment a;

    public l(NewAudienceInteractionFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NewAudienceInteractionFragment r0 = this.a;     // Catch: Throwable -> L4
        InteractionComponentManager r1 = r0.f;     // Catch: Throwable -> L4
        com.bytedance.android.livesdk.chatroom.ui.framework.base.f r2 = r0.U90(r0.d.b());     // Catch: Throwable -> L4
        r1.getClass();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r2, "descriptorList");     // Catch: Throwable -> L4
        r1.d = r2;     // Catch: Throwable -> L4
        NewAudienceInteractionFragment r3 = this.a;     // Catch: Throwable -> L4
        r3.f.v((CompatComponentScheduler) r3.V90());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
