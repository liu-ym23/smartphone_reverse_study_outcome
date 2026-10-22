package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.adapter.MessageModifyMode;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x7 implements Function1 {
    public final /* synthetic */ MessageModifyMode a;

    public /* synthetic */ x7(MessageModifyMode r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return CoreInputViewModel.tp(this.a, (CoreInputComponentState) r2);
    }
}
