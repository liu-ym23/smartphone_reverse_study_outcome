package com.ss.android.lark.flow.chat.titlebar;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.PageUserStatusUrlPreviewViewModel;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements PageUserStatusUrlPreviewViewModel.b {
    public final /* synthetic */ FlowTitleBarComponent a;

    public e(FlowTitleBarComponent r1) {
        this.a = r1;
    }

    public final void a(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        FlowTitleBarComponent r3 = this.a;
        r3.u = null;
        r3.updateTitle();
    }
}
