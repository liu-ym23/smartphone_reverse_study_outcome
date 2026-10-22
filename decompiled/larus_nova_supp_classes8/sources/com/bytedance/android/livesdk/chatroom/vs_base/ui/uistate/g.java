package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class g extends ir1.c {

    public static final class a {
    }

    static {
    }

    public int o() {
        ReplayDialogUIStyle r0 = p();
        int r1 = h.a[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L10;
        return -2;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return UtilityKotlinExtentionsKt.c(375);
    L13:
        return UtilityKotlinExtentionsKt.c(375);
    }

    public ReplayDialogUIStyle p() {
        if (g() == true) goto L16;
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == false) goto L10;
        if (a() == true) goto L16;
    L10:
        if (d() == false) goto L14;
        return ReplayDialogUIStyle.RightStyle;
    L14:
        return ReplayDialogUIStyle.BottomStyle;
    L16:
        return ReplayDialogUIStyle.RightBottomStyle;
    }

    public g() {
    }
}
