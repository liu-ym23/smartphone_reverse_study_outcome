package com.larus.bmhome.view;

import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r6) {
        StackTraceElement r7 = (StackTraceElement) r6;
        int r0 = BottomMenuGridLayout.h;
        return StringsKt.substringAfterLast$default(r7.getClassName(), '.', null, 2, null) + '.' + r7.getMethodName() + ':' + r7.getLineNumber();
    }
}
