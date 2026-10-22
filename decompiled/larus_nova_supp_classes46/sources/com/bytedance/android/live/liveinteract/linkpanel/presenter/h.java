package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends BaseTalkInviteListWidgetPresenter {
    public final IRoom d;

    public h(IRoom r2, BaseTalkInviteListWidgetContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2, r3);
        this.d = r2;
    }
}
