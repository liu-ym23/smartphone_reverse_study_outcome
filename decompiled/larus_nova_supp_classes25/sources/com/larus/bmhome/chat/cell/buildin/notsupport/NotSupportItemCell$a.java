package com.larus.bmhome.chat.cell.buildin.notsupport;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import s1a.d;
import va8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NotSupportItemCell$a implements Function0<y> {
    public final /* synthetic */ AttachReceiver a;

    public NotSupportItemCell$a(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
    }
}
