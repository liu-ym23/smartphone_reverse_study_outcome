package com.ss.android.lark.feed.shared.data.appconfig;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(FeedCard.Type r1) {
        Intrinsics.checkNotNullParameter(r1, IPortraitService.TYPE);
        Lazy r0 = FeedClearBadgeConfig.a;
        Boolean r2 = ((FeedClearBadgeConfigValue) FeedClearBadgeConfig.a.getValue()).getFeedEntitySwitchMap().get(String.valueOf(r1.getNumber()));
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }
}
