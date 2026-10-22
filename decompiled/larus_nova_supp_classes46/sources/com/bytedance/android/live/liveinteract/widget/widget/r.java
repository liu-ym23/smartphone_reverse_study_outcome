package com.bytedance.android.live.liveinteract.widget.widget;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ LinkUserFollowGuideDialog a;

    public r(LinkUserFollowGuideDialog r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        Long r6 = (Long) r5;
        Intrinsics.checkNotNullParameter(r6, "sec");
        return Long.valueOf(((long) this.a.b) - r6.longValue());
    }
}
