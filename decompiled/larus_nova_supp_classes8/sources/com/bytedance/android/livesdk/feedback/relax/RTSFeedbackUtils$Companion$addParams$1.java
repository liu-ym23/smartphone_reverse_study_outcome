package com.bytedance.android.livesdk.feedback.relax;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "value", "", "key", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class RTSFeedbackUtils$Companion$addParams$1 extends Lambda implements Function2<Object, String, Unit> {
    public static final RTSFeedbackUtils$Companion$addParams$1 INSTANCE = null;

    static {
        INSTANCE = new RTSFeedbackUtils$Companion$addParams$1();
    }

    public RTSFeedbackUtils$Companion$addParams$1() {
        super(2);
    }

    public final void invoke(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "key");
        RTSFeedbackUtils.b.getClass();
        Map<String, String> r0 = RTSFeedbackUtils.a;
        com.bytedance.rts.foundation.m.e(r0, r3, (String) r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(r1, (String) r2);
        return Unit.INSTANCE;
    }
}
