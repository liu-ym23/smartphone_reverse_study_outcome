package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class CoreContext$attach$1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public CoreContext$attach$1(CoreContext r8) {
        super(1, r8, CoreContext.class, "onChannelIDChange", "onChannelIDChange(Ljava/lang/Long;)V", 0);
    }

    public final void invoke(Long r3) {
        CoreContext r0 = (CoreContext) ((CallableReference) this).receiver;
        int r1 = CoreContext.l;
        r0.getClass();
        if (r3 == null) goto L6;
        r3.longValue();
        r0.c.getChannelId().setValue(r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Long) r1);
        return Unit.INSTANCE;
    }
}
