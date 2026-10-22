package com.obric.assistant.view.listening;

import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements xaa.b {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    public final void a(final ObricListeningPresentationState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        final f r0 = this.a;
        r0.b.invoke(new g(r0, r4));
    }
}
