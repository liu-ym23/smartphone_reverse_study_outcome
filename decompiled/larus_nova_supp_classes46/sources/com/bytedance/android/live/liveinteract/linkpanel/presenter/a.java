package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.liveinteract.linkpanel.list.a {
    public final IRoom i;

    public a(IRoom r2, BaseTalkApplyListWidgetContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2, r3);
        this.i = r2;
    }
}
