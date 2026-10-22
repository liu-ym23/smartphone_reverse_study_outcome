package com.obric.livecard.api.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "element", "Ljava/lang/StackTraceElement;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class GlobalCommonUtils$getStackInfo$1 extends Lambda implements Function1<StackTraceElement, CharSequence> {
    public static final GlobalCommonUtils$getStackInfo$1 INSTANCE = null;

    static {
        INSTANCE = new GlobalCommonUtils$getStackInfo$1();
    }

    public GlobalCommonUtils$getStackInfo$1() {
        super(1);
    }

    public final CharSequence invoke(StackTraceElement r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        return r3.getClassName() + '.' + r3.getMethodName() + '(' + r3.getFileName() + ':' + r3.getLineNumber() + ')';
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((StackTraceElement) r1);
    }
}
