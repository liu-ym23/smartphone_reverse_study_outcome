package c19;

import android.graphics.Path;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final Path a;
    public final d b;
    public final List<Path> c;

    public h() {
        throw null;
    }

    public h(Path r3, d r4) {
        List<Path> r0 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r0, "clips");
        this.a = r3;
        this.b = r4;
        this.c = r0;
    }
}
