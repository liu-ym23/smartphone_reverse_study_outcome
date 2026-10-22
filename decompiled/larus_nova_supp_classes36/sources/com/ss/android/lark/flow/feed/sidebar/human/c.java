package com.ss.android.lark.flow.feed.sidebar.human;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements qtb.c {
    public final /* synthetic */ OfficeSidebarHumanFeedController a;

    public c(OfficeSidebarHumanFeedController r1) {
        this.a = r1;
    }

    public final void onLoginFailed() {
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "user login failed listener invoke");
        OfficeSidebarHumanFeedController r1 = this.a;
        r1.w = true;
        List<iza.c> r2 = r1.m(r1.p, CollectionsKt.emptyList());
        r1.p = CollectionsKt.emptyList();
        r1.h.clear();
        r1.q = false;
        r1.r = Long.MIN_VALUE;
        r1.o();
        OfficeSidebarHumanFeedController.s(r1, r2);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "remove human data success");
    }
}
