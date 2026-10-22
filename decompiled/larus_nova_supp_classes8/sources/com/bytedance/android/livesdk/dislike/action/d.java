package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends OptionAction {
    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.b.c;
    }

    public d(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        int r0 = qt1.a.a;
        qt1.a.b(this.b, r2.getContext());
    }
}
