package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui;

import android.content.Context;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerLinearlayout;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hp1.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends PanelComposer {
    @Override // jp1.c
    public final int a() {
        MoreMixSharePanelUtils r0 = MoreMixSharePanelUtils.INSTANCE;
        boolean r1 = z.e(this.i, false);
        DataCenter r2 = this.i;
        boolean r3 = true;
        if (r2 == null) goto L6;
        r3 = z.m(r2, true);
    L6:
        if (r0.isMoreMixShareMode(r1, r3) == false) goto L9;
        return 2131565647;
    L9:
        return 2131565646;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui.PanelComposer
    public final hp1.a e() {
        return new hp1.a(this.i);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui.PanelComposer, jp1.c
    public final void c(c r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        super.c(r3);
        if (PadConfigUtils.c() == false) goto L8;
        int r0 = UtilityKotlinExtentionsKt.i(10);
        RoundCornerLinearlayout r4 = r3.findView(2131381866);
        if (r4 == null) goto L9;
        r4.J(r0, r0, r0, r0);
        return;
    L9:
        return;
    }

    public a(Context r1, DataCenter r2) {
        super(r1, r2);
    }
}
