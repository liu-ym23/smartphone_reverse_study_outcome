package com.bytedance.android.livesdk.dslservice.lynxair;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/util/f;", "", "invoke", "(Lcom/bytedance/android/livesdk/dslservice/util/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class AirPerformanceMonitor$onUpdate$1 extends Lambda implements Function1<com.bytedance.android.livesdk.dslservice.util.f, Unit> {
    final /* synthetic */ JSONObject $bulletMetrics;

    public AirPerformanceMonitor$onUpdate$1(JSONObject r1) {
        this.$bulletMetrics = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.livesdk.dslservice.util.f r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.b = this.$bulletMetrics.toString();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.dslservice.util.f) r1);
        return Unit.INSTANCE;
    }
}
