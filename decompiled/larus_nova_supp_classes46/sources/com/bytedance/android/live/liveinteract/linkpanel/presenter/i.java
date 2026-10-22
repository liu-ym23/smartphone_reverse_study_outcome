package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends b {
    public final IRoom d;

    public i(IRoom r2, BaseTalkInviteListContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2, r3);
        this.d = r2;
    }
}
