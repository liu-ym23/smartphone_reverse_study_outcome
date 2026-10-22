package qp8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final Function0<String> d;

    public e(String r2, boolean r3, boolean r4, Function0<String> r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r5, "conversationIdProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
