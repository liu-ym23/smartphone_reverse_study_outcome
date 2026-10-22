package com.ss.android.lark.feed.shared.page.binder2;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r {
    public final ViewGroup a;
    public final aeb.f b;
    public final Context c;

    public final BaseFeedSwipeActionView a() {
        int r0 = dfb.b.a;
        Context r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "context");
        Map r2 = com.ss.android.lark.im.base.d.a;
        dfb.c r3 = (dfb.c) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_SWIPE_ACTION_VIEW, dfb.c.class));
        if (r3 == null) goto L5;
        com.ss.android.lark.flow.feed.action.a r4 = r3.createView(r1);
    L6:
        if (r4 == null) goto L10;
        r4.c();
        return r4;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r4 = null;
        goto L6
    }

    public r(ViewGroup r2, aeb.f r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "rightActionContainer");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
