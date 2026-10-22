package com.ss.android.lark.integrator.im.impl.feed;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.ApiUtils;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class a implements fza.a {
    @Inject
    public a() {
    }

    public final void peakFeedCard(String r2, FeedCard.Type r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r3, "entityType");
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 == null) goto L6;
        r0.peakFeedCard(r2, r3);
        return;
    }
}
