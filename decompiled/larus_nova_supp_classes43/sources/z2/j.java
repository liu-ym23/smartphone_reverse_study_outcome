package z2;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class j implements r {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ j(i r1) {
        this.a = r1;
    }

    public final void a(List r10) {
        Function1 r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "uris");
        r0.invoke(r10);
    }
}
