package com.larus.bmhome.chat.list.cell.lynx;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import s1a.d;
import va8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LynxCell$b implements Function0<p> {
    public final /* synthetic */ AttachReceiver a;

    public LynxCell$b(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
    }
}
