package com.larus.bmhome.chat.list.cell.text.components.middle;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements Function0<u29.b> {
    public final /* synthetic */ AttachReceiver a;

    public g0(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u29.b.class));
    }
}
