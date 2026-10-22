package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "t", "", "c", "invoke"}, k = 3, mv = {1, 4, 3})
final class TimeCostUtil$logger$1 extends Lambda implements Function2<String, String, Unit> {
    public static final TimeCostUtil$logger$1 INSTANCE = null;

    static {
        INSTANCE = new TimeCostUtil$logger$1();
    }

    public TimeCostUtil$logger$1() {
        super(2);
    }

    public final void invoke(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "t");
        Intrinsics.checkNotNullParameter(r3, "c");
        ALogger.i(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
