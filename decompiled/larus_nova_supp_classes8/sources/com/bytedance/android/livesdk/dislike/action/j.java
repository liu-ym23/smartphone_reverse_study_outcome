package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import kotlin.jvm.internal.Intrinsics;
import zg1.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends OptionAction {
    public final ActionsManager e;

    public j(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        RxBusAbility.INSTANCE.getRxBus(this.e.f).post(new z2(false));
    }
}
