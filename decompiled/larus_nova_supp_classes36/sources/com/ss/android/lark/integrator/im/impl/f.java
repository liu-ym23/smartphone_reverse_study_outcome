package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.shared.data.LoadState;
import com.ss.android.lark.feed.shared.page.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements q {
    public f() {
    }

    public final void d() {
    }

    public final LoadState a() {
        return new LoadState();
    }

    public final FeedFolder b() {
        return FeedFolderCompat.INSTANCE.getMESSAGE();
    }

    public final void c(FeedCard.FeedType r2) {
        Intrinsics.checkNotNullParameter(r2, "inbox");
    }
}
