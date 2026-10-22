package com.obric.assistant.chat.impl;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ a(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        String r0 = this.a;
        bda.b r6 = (bda.b) r5;
        FLogger.a.i("MessageApiImpl", "unregisterSendMessageExtCallback, " + r0 + ", " + r6.getScene());
        return Boolean.valueOf(Intrinsics.areEqual(r6.getScene(), r0));
    }
}
