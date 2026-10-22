package com.ss.android.lark.log.trace;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/log/trace/TraceOptions;", "it", "Lcom/ss/android/lark/log/trace/TraceContext;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class StepTrace$trace$1 extends Lambda implements Function2<c, a, Unit> {
    public static final StepTrace$trace$1 INSTANCE = null;

    static {
        INSTANCE = new StepTrace$trace$1();
    }

    public StepTrace$trace$1() {
        super(2);
    }

    public final void invoke(c r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((c) r1, (a) r2);
        return Unit.INSTANCE;
    }
}
