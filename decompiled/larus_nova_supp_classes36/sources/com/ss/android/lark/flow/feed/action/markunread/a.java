package com.ss.android.lark.flow.feed.action.markunread;

import aeb.e;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.export.feedcard.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements aeb.c {
    public final d a;

    public final e i() {
        return new c();
    }

    public final aeb.d m() {
        return new FlowMarkUnreadActionHandler(this.a);
    }

    public final FeedActionType d() {
        return FeedActionType.MARK_UNREAD;
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCardContext");
        this.a = r2;
    }
}
