package q1c;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final <T> b<T> a(com.larksuite.rucket.job.base.b<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L6;
        return new b.C0179b(((com.larksuite.rucket.job.base.b.c) r1).b);
    L6:
        if ((r1 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L10;
        return new b.a(((com.larksuite.rucket.job.base.b.b) r1).b);
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
