package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends ir1.c {
    public Class<? extends zq1.a> c;

    public final boolean o() {
        mq1.g r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.q.b();
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (b() == false) goto L13;
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == true) goto L10;
    L11:
        r1 = true;
        goto L13
    L10:
        if (a() == false) goto L11;
    L13:
        return !Intrinsics.areEqual(this.c, r0.f(r1));
    }

    public i() {
    }
}
