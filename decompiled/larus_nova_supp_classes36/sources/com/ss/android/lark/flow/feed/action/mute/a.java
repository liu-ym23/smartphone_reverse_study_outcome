package com.ss.android.lark.flow.feed.action.mute;

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
        return new FlowNoDisturbActionHandler(this.a);
    }

    public final FeedActionType d() {
        return FeedActionType.NO_DISTURB;
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "feedContext");
        this.a = r2;
    }
}
