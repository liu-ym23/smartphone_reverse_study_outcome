package com.bytedance.android.live.liveinteract.plantform;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.interact.data.LinkmicAIGuestType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final boolean a(ILinkPlayerInfoBridge r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isAIGuest");
        if (r1.getAiGuestType() <= LinkmicAIGuestType.None.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }
}
