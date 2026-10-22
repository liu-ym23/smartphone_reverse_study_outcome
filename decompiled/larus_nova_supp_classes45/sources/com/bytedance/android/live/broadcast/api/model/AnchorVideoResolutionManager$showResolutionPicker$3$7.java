package com.bytedance.android.live.broadcast.api.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "key", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnchorVideoResolutionManager$showResolutionPicker$3$7 extends Lambda implements Function1<String, String> {
    public static final AnchorVideoResolutionManager$showResolutionPicker$3$7 INSTANCE = null;

    static {
        INSTANCE = new AnchorVideoResolutionManager$showResolutionPicker$3$7();
    }

    public AnchorVideoResolutionManager$showResolutionPicker$3$7() {
        super(1);
    }

    public final String invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Map<String, Pair<Integer, Integer>> r0 = AnchorVideoResolutionManager.a;
        return AnchorVideoResolutionManager.g(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
