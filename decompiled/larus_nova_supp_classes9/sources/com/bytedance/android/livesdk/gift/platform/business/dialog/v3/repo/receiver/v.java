package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v {
    public static final int a(com.bytedance.android.scope.j r1, DataCenter r2) {
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return ((Number) r2.get("data_link_state", 0)).intValue();
    }

    public static final List<ILinkPlayerInfoBridge> b(com.bytedance.android.scope.j r1, DataCenter r2) {
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return (List) r2.get("data_online_changed_list", new ArrayList());
    }
}
