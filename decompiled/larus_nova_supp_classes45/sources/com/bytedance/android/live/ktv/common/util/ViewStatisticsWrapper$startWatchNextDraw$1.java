package com.bytedance.android.live.ktv.common.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isTimeOut", "", "timeStamp", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class ViewStatisticsWrapper$startWatchNextDraw$1 extends Lambda implements Function2<Boolean, Long, Unit> {
    final /* synthetic */ v this$0;

    public ViewStatisticsWrapper$startWatchNextDraw$1(v r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(boolean r4, long r5) {
        v r0 = this.this$0;
        k r1 = r0.c;
        String r2 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "name");
        l r3 = r1.a;
        if (r3 == null) goto L5;
        r3.ue(r2, r4, r5);
    L5:
        this.this$0.b.setOneDrawCallback(null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Boolean) r3).booleanValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }
}
