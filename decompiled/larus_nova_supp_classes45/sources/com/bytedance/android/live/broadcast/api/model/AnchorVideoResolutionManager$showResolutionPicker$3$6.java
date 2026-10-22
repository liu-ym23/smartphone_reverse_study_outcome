package com.bytedance.android.live.broadcast.api.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnchorVideoResolutionManager$showResolutionPicker$3$6 extends Lambda implements Function1<String, Unit> {
    public static final AnchorVideoResolutionManager$showResolutionPicker$3$6 INSTANCE = null;

    static {
        INSTANCE = new AnchorVideoResolutionManager$showResolutionPicker$3$6();
    }

    public AnchorVideoResolutionManager$showResolutionPicker$3$6() {
        super(1);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Map<String, Pair<Integer, Integer>> r0 = AnchorVideoResolutionManager.a;
        AnchorVideoResolutionManager.k(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
