package com.ss.android.lark.flow.chat.titlebar;

import com.ss.android.lark.biz.im.api.n1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.PageUserStatusUrlPreviewViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Collection;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements PageUserStatusUrlPreviewViewModel.a {
    public final /* synthetic */ FlowTitleBarComponent a;

    public d(FlowTitleBarComponent r1) {
        this.a = r1;
    }

    public final Collection<n1> a() {
        FlowTitleBarComponent r0 = this.a;
        int r1 = FlowTitleBarComponent.J;
        Chat r2 = (Chat) r0.C0().getValue();
        if (r2 == null) goto L5;
        n1 r3 = this.a.H0(r2);
    L7:
        return CollectionsKt.listOfNotNull(r3);
    L5:
        r3 = null;
        goto L7
    }
}
