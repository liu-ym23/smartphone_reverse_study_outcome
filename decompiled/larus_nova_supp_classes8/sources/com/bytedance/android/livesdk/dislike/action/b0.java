package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 extends OptionAction {
    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public b0(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
    }
}
