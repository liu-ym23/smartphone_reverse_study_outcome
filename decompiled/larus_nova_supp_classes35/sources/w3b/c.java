package w3b;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<S> {
    public final String a;
    public final d<S> b;
    public Function1<? super Result<? extends S>, Unit> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Function1<? super Result<? extends S>, Unit> r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DataPreloaderJob(taskKey=" + this.a + ", task=" + this.b + ", callback=" + this.c + ')';
    }

    public c(String r2, d<S> r3, Function1<? super Result<? extends S>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "taskKey");
        Intrinsics.checkNotNullParameter(r3, "task");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
