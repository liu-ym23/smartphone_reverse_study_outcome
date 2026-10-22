package com.larus.bmhome.view;

import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class t0 implements Function1 {
    public /* synthetic */ t0() {
    }

    public final Object invoke(Object r6) {
        StackTraceElement r7 = (StackTraceElement) r6;
        Lazy r0 = ChatMessageList.V0;
        return StringsKt.substringAfterLast$default(r7.getClassName(), '.', null, 2, null) + '.' + r7.getMethodName() + ':' + r7.getLineNumber();
    }
}
