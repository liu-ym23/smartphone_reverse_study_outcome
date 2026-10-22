package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends OptionAction {
    public x(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        xs2.b.a().post(new tp2.c(this.b));
    }
}
