package com.ss.android.lark.feed.shared.page.utils;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(UIFeedCard r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        if (0 == r4.getOnTopRankTime()) goto L5;
        return true;
    L5:
        return false;
    }
}
