package com.ss.android.lark.inline.ai.ui;

import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.inline.ai.ui.operates.OperatesAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements OperatesAdapter.b {
    public final /* synthetic */ InlineAIPanelController a;

    public t(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.ui.operates.OperatesAdapter.b
    public final void a(Operate r3) {
        Intrinsics.checkNotNullParameter(r3, "operate");
        Log.i("InlineAIPanelController", "click operate, operate = " + r3);
        this.a.i();
        this.a.b.k(r3);
    }
}
