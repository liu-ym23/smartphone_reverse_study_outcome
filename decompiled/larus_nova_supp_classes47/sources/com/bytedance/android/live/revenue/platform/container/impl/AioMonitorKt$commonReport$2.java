package com.bytedance.android.live.revenue.platform.container.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 128)
public final class AioMonitorKt$commonReport$2 extends Lambda implements Function1<Map<String, Object>, Unit> {
    public static final AioMonitorKt$commonReport$2 INSTANCE = null;

    static {
        INSTANCE = new AioMonitorKt$commonReport$2();
    }

    public AioMonitorKt$commonReport$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Map) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
    }
}
