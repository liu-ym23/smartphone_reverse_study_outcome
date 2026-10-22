package com.obric.oui.button;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "value", "", "velocity", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OProgressButton$updateProgress$1 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ OProgressButton this$0;

    public OProgressButton$updateProgress$1(OProgressButton r5) {
        this.this$0 = r5;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r5, Object r10, Object r11) {
        invoke2(r5, r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r5, Object r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "$noName_0");
        Intrinsics.checkNotNullParameter(r10, "value");
        Intrinsics.checkNotNullParameter(r11, "velocity");
        OProgressButton r12 = this.this$0;
        r12.f12146v = ((Float) r10).floatValue();
        OProgressButton r13 = this.this$0;
        r13.n(r13.f12146v);
        OProgressButton r14 = this.this$0;
        if (r14.f12141p == false) goto L5;
        r14.o();
    L5:
        this.this$0.invalidate();
    }
}
