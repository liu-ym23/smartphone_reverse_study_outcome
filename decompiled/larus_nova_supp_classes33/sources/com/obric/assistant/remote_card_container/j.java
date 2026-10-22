package com.obric.assistant.remote_card_container;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j implements Function0<u7> {
    public final /* synthetic */ AttachReceiver a;

    public j(AttachReceiver r1) {
        this.a = r1;
    }

    public final Object invoke() {
        AttachReceiver r0 = this.a;
        if ((r0 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
    }
}
