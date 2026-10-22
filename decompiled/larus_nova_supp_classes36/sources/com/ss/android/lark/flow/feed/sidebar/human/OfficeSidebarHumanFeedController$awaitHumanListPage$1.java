package com.ss.android.lark.flow.feed.sidebar.human;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.sidebar.human.OfficeSidebarHumanFeedController", f = "OfficeSidebarHumanFeedController.kt", i = {0, 0}, l = {664}, m = "awaitHumanListPage", n = {"request", "scene"}, s = {"L$0", "L$1"})
public final class OfficeSidebarHumanFeedController$awaitHumanListPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeSidebarHumanFeedController this$0;

    public OfficeSidebarHumanFeedController$awaitHumanListPage$1(OfficeSidebarHumanFeedController r1, Continuation<? super OfficeSidebarHumanFeedController$awaitHumanListPage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        OfficeSidebarHumanFeedController r3 = this.this$0;
        int r0 = OfficeSidebarHumanFeedController.E;
        return r3.l(null, null, this);
    }
}
