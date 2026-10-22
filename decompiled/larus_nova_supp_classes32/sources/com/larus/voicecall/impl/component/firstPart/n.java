package com.larus.voicecall.impl.component.firstPart;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.o4;
import com.larus.platform.api.x;
import com.larus.platform.model.music.MusicScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements x {
    public final /* synthetic */ RealtimeFirstPartComponent a;

    public final void b() {
    }

    public n(RealtimeFirstPartComponent r1) {
        this.a = r1;
    }

    public final void a(o4 r3) {
        Intrinsics.checkNotNullParameter(r3, "musicAuthResultData");
        RealtimeFirstPartComponent r0 = this.a;
        int r1 = RealtimeFirstPartComponent.y;
        IAiChatOpenDouyinAuthService r2 = r0.z3();
        if (r2 == null) goto L6;
        r2.g();
    L6:
        if (r3.d == false) goto L11;
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L12;
        r4.K0();
        com.larus.music.i.a.e(MusicScene.MusicSceneType.getValue(), r3.b);
        return;
    L12:
        return;
    }
}
