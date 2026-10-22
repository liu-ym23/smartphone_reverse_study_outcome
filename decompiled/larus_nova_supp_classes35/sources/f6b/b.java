package f6b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends u3b.a {
    public final String a;
    public final d b;

    public static final class a {
    }

    static {
    }

    @Override // u3b.a
    public final String a() {
        return "ChatDestinationPreLoad_" + this.a;
    }

    public b(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.a = r2;
        this.b = r3;
    }
}
