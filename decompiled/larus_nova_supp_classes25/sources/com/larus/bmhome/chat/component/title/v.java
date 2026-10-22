package com.larus.bmhome.chat.component.title;

import com.larus.im.bean.IMConnectState;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function1 {
    public /* synthetic */ v() {
    }

    public final Object invoke(Object r2) {
        int r0 = ChatTitleComponent.P1;
        if (((Boolean) r2).booleanValue() == false) goto L6;
        return IMConnectState.CONNECTED;
    L6:
        return IMConnectState.DISCONNECTED;
    }
}
