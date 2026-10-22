package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "k", "", "v", "invoke", "(Ljava/lang/String;Ljava/lang/Object;)V"}, k = 3, mv = {1, 5, 1})
final class HybridPropertyUtilsKt$GENERIC_ADAPTER$2 extends Lambda implements Function2<String, Object, Unit> {
    public static final HybridPropertyUtilsKt$GENERIC_ADAPTER$2 INSTANCE = null;

    static {
        INSTANCE = new HybridPropertyUtilsKt$GENERIC_ADAPTER$2();
    }

    public HybridPropertyUtilsKt$GENERIC_ADAPTER$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, r2);
        return Unit.INSTANCE;
    }

    public final void invoke(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "k");
        HybridPropertyUtilsKt.a.edit().putString(r3, GsonProtectorUtils.toJson(GsonHelper.get(), r4)).apply();
    }
}
