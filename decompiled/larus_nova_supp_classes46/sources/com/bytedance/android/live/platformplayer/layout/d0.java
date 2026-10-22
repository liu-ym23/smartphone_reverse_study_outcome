package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentManager;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ boolean b;

    public d0(LivePlayerWidget r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (Intrinsics.areEqual((Boolean) this.a.U2.e().getStartPull().getValue(), Boolean.FALSE) == false) goto L19;
        ILivePlayerClient r0 = this.a.dr();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isPlaying() == false) goto L9;
        return;
    L9:
        if (this.a.S1 == false) goto L11;
        return;
    L11:
        if (this.b == true) goto L23;
        IMiddlewareLiveService r1 = TTLiveServiceMiddleware.getLiveService();
        if (r1 == null) goto L17;
        LiveInnerIndependentManager r2 = r1.getLiveInnerIndependentManage();
        if (r2 == null) goto L17;
        r2.d("LivePlayer", "postResumeStream is called");
    L17:
        this.a.Rz(false);
        return;
    L23:
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
