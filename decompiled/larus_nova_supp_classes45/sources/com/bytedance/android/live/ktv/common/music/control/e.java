package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class e extends d {
    public final IMusicControlNode.OperationType f;
    public final IRoom g;
    public final boolean h;

    public void e() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void c() {
        e();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public IMusicControlNode.OperationType getType() {
        return this.f;
    }

    public e(MusicPanel r2, boolean r3, ModeType r4) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        super(r2, r4);
        this.h = r3;
        this.f = IMusicControlNode.OperationType.PAUSE_MUSIC;
        m r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r5 == null) goto L5;
        IRoom r6 = (IRoom) r5.getValue();
    L6:
        this.g = r6;
        return;
    L5:
        r6 = null;
        goto L6
    }
}
