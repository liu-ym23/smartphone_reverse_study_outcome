package com.bytedance.android.live.liveinteract.model;

import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicAudienceContent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final List<String> a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$rankUidList");
        boolean r0 = r2 instanceof ListUserLinkmicAudienceContent;
        Object r3 = r2;
        if (r0 == true) goto L5;
        r3 = null;
    L5:
        ListUserLinkmicAudienceContent r4 = (ListUserLinkmicAudienceContent) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getRankUserIdStrList();
    }
}
