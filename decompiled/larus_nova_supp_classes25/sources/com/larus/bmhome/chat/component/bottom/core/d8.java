package com.larus.bmhome.chat.component.bottom.core;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d8 implements Function1 {
    public final /* synthetic */ Message a;

    public /* synthetic */ d8(Message r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return CoreInputViewModel.To(this.a, (CoreInputComponentState) r2);
    }
}
