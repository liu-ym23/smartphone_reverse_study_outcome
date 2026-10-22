package com.obric.capabilitykit;

import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.intent.IntentResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wia.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/AbstractCapabilityManager;", "it", "", "invoke", "(Lcom/obric/capabilitykit/AbstractCapabilityManager;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class AtomicCapabilitySdk$l extends Lambda implements Function1<n, Unit> {
    public final /* synthetic */ IntentResult<?> a;
    public final /* synthetic */ IMAppAction b;

    public AtomicCapabilitySdk$l(IntentResult<?> r1, IMAppAction r2) {
        this.a = r1;
        this.b = r2;
        super(1);
    }

    public final void a(n r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).i(this.a, this.b);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        a((n) r1);
        return Unit.INSTANCE;
    }
}
