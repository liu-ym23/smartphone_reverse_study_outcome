package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class CoreContext$attach$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public CoreContext$attach$3(CoreContext r8) {
        super(1, r8, CoreContext.class, "onEffectStatusChange", "onEffectStatusChange(Ljava/lang/Boolean;)V", 0);
    }

    public final void invoke(Boolean r6) {
        CoreContext r0 = (CoreContext) ((CallableReference) this).receiver;
        int r1 = CoreContext.l;
        r0.getClass();
        jy0.b.c("CoreContext", "onEffectStatusChange with enable: " + r6 + ", self = " + r0.g.d.k, null, 4);
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L6;
        r0.g.l.d("output_view_stream_x_" + r0.g.d.k);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Boolean) r1);
        return Unit.INSTANCE;
    }
}
