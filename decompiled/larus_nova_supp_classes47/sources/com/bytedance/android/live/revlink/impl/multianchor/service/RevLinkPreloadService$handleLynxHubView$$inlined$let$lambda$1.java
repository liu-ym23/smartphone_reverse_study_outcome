package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.livesdk.utils.u6;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lyy0/b;", "", "invoke", "(Lyy0/b;)V", "com/bytedance/android/live/revlink/impl/multianchor/service/RevLinkPreloadService$handleLynxHubView$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class RevLinkPreloadService$handleLynxHubView$$inlined$let$lambda$1 extends Lambda implements Function1<yy0.b, Unit> {
    final /* synthetic */ long $loadStartTime;
    final /* synthetic */ u6 $scheme$inlined;
    final /* synthetic */ RevLinkPreloadService this$0;

    public RevLinkPreloadService$handleLynxHubView$$inlined$let$lambda$1(long r1, RevLinkPreloadService r3, u6 r4) {
        this.$loadStartTime = r1;
        this.this$0 = r3;
        this.$scheme$inlined = r4;
        super(1);
    }

    public final void invoke(yy0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.b) r1);
        return Unit.INSTANCE;
    }
}
