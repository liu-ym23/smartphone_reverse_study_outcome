package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends l {
    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final AbsPanel<?> f(h1 r3) {
        Intrinsics.checkNotNullParameter(r3, "gift");
        if (r3.getItemType() != 2) goto L6;
        b1 r0 = (b1) f.c(b1.class);
        r0.setSchemaUrl(r3.getSchemeUrl());
        r0.setImage(r3.getImage());
        r0.setText(r3.getName());
        return new pz1.c(r0);
    L6:
        super.f(r3);
        return null;
    }

    public a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r3, SelectedStatus r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "selectedStatus");
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.a == 3) goto L7;
        return false;
    L7:
        if ((r3 instanceof pz1.c) == true) goto L9;
    L15:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return false;
    L9:
        if (r4 != SelectedStatus.LOCATE) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        return true;
    L14:
        int r7 = BannerGiftHelperKt.a;
        Context r8 = getContext();
        pz1.c r9 = (pz1.c) r3;
        Intrinsics.checkNotNullParameter(r9, "bannerPanel");
        BannerGiftHelperKt.a(r8, (b1) r9.h, null);
        goto L15
    L11:
        r6 = false;
        goto L12
    }
}
