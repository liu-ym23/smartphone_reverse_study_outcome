package com.bytedance.android.live.broadcastgame.opengame.service;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/broadcastgame/opengame/service/ReportService$liveStreamCatchPic$1$1$onCatchedPic$1"}, k = 3, mv = {1, 4, 3})
final class ReportService$liveStreamCatchPic$$inlined$let$lambda$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ g this$0;

    public ReportService$liveStreamCatchPic$$inlined$let$lambda$1$1(g r1, Bitmap r2) {
        this.this$0 = r1;
        this.$bitmap = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m322invoke() {
        this.this$0.b.invoke(this.$bitmap);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m322invoke();
        return Unit.INSTANCE;
    }
}
