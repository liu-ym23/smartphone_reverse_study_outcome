package com.obric.capabilitykit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class q$a extends Lambda implements Function1<String, CharSequence> {
    public static final q$a a = null;

    static {
        a = new q$a();
    }

    public q$a() {
        super(1);
    }

    public final CharSequence a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return a((String) r1);
    }
}
