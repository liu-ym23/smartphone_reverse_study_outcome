package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import ca0.w;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends w {
    public final /* synthetic */ FormatGiftListViewModel a;
    public final /* synthetic */ Function1 b;

    public final void a() {
        this.b.invoke(new GiftStateMachineConfig.c(null, 63));
    }

    public final void b(List<? extends w1> r4) {
        Intrinsics.checkNotNullParameter(r4, "giftPages");
        Intrinsics.checkNotNullParameter(r4, "giftPages");
        if (r4.isEmpty() == false) goto L5;
        this.b.invoke(new GiftStateMachineConfig.c(null, 63));
        return;
    L5:
        this.a.j(r4, true, this.b);
    }

    public d(FormatGiftListViewModel r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
