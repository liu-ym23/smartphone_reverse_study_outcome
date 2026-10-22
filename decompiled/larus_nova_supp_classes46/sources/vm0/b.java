package vm0;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> {
    public final String a;
    public final T b;
    public final T c;
    public final Type d;
    public final boolean e;

    public final Type getType() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r2, Object r3, Object r4, Type r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = false;
    }
}
