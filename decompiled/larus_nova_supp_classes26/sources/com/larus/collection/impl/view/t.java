package com.larus.collection.impl.view;

import com.collection.profile.api.CollectServiceDelegate;
import com.larus.platform.service.z2;
import com.larus.profile.api.IProfileApi;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    static {
    }

    public static List a() {
        if (IProfileApi.a.g() == false) goto L5;
        int r0 = z2.a.profileLikeCollectListConfig().getLikeCollectListStyle();
        if (r0 != 1) goto L9;
        List r1 = CollectionsKt.createListBuilder();
        if (CollectServiceDelegate.b.a() == false) goto L15;
        r1.add(RevisitListTab.Collection);
    L15:
        r1.add(RevisitListTab.Like);
        return CollectionsKt.build(r1);
    L9:
        if (r0 == 2) goto L18;
        return CollectionsKt.listOf(RevisitListTab.Collection);
    L18:
        return CollectionsKt.listOf(RevisitListTab.LikeWithHistory);
    L5:
        return CollectionsKt.emptyList();
    }
}
