package zs9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public String a;
    public String b;
    public List<b> c;

    public c() {
        this.c = CollectionsKt.emptyList();
    }

    public final void a(List<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }
}
