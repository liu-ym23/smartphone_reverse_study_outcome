package com.obric.assistant.card.list.cell;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import fp8.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppEntityCell$d implements Function0<a> {
    public final /* synthetic */ AttachReceiver a;

    public AppEntityCell$d(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return d.a(r0).g(Reflection.getOrCreateKotlinClass(a.class));
    }
}
