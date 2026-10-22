package ehb;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final List<com.ss.android.lark.flow.feed.component.title.a> b;
    public final boolean c;
    public final int d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r2, List<? extends com.ss.android.lark.flow.feed.component.title.a> r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "titleText");
        Intrinsics.checkNotNullParameter(r3, "tags");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ b(String r2, List r3, boolean r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 16;
    L11:
        this(r2, r3, r4, r5);
    }
}
