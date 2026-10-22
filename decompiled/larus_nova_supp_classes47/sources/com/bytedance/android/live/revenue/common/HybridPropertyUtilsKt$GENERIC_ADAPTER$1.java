package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "k", "", "d", "invoke", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
final class HybridPropertyUtilsKt$GENERIC_ADAPTER$1 extends Lambda implements Function2<String, Object, Object> {
    final /* synthetic */ Class $cls;

    public HybridPropertyUtilsKt$GENERIC_ADAPTER$1(Class r1) {
        this.$cls = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, r2);
    }

    public final Object invoke(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "k");
        String r5 = HybridPropertyUtilsKt.a.getString(r3, null);
        if (r5 != null) goto L6;
        return r4;
    L6:
        return GsonProtectorUtils.fromJson(GsonHelper.get(), r5, this.$cls);
    }
}
