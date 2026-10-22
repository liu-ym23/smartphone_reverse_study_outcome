package br0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends lr0.a {
    public h(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r2) {
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L8;
        rj0.m r4 = r3.getVideoTalkService();
        if (r4 == null) goto L8;
        r4.finishVideoTalk("cloud game cast");
    L8:
        return new Bundle();
    }
}
