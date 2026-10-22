package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class UserTextCell$e implements Function0<va8.p> {
    public final /* synthetic */ AttachReceiver a;

    public UserTextCell$e(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
    }
}
