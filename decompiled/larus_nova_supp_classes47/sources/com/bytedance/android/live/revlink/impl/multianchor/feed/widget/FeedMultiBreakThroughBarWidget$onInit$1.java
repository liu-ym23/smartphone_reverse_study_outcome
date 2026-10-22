package com.bytedance.android.live.revlink.impl.multianchor.feed.widget;

import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yy0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/b;", "", "invoke", "(Lyy0/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class FeedMultiBreakThroughBarWidget$onInit$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ FeedMultiBreakThroughBarWidget.a $callback;
    final /* synthetic */ IRoom $room;
    final /* synthetic */ FeedMultiBreakThroughBarWidget this$0;

    public FeedMultiBreakThroughBarWidget$onInit$1(FeedMultiBreakThroughBarWidget r1, IRoom r2, FeedMultiBreakThroughBarWidget.a r3) {
        this.this$0 = r1;
        this.$room = r2;
        this.$callback = r3;
        super(1);
    }

    public final void invoke(b r5) {
        Intrinsics.checkNotNullParameter(r5, "$receiver");
        r5.e(FeedMultiBreakThroughBarWidget.b(this.this$0, this.$room), HybridType.LYNX, FeedMultiBreakThroughBarWidget.a(this.this$0, this.$room));
        r5.d(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b) r1);
        return Unit.INSTANCE;
    }
}
