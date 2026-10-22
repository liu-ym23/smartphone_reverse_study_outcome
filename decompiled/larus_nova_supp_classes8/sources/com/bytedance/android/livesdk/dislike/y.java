package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.dislike.action.RecommendToFriendsAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y extends n {
    public y(RecommendToFriendsAction r2, ItemType r3) {
        Intrinsics.checkNotNullParameter(r2, "optionAction");
        Intrinsics.checkNotNullParameter(r3, "identity");
        super(r3, r2);
    }
}
