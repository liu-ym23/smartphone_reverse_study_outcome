package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.utils.JsonUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends String>, Unit> {
    public static final HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2 INSTANCE = null;

    static {
        INSTANCE = new HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2();
    }

    public HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2() {
        super(2, HybridPropertyUtilsKt.class, "writeStringMapToString", "writeStringMapToString(Ljava/lang/String;Ljava/util/Map;)V", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Map) r2);
        return Unit.INSTANCE;
    }

    public final void invoke(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        HybridPropertyUtilsKt.a.edit().putString(r2, JsonUtil.toJSONString(r3)).apply();
    }
}
