package eab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.l;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends s {
    public final List<l> j;

    @Override // v7b.s
    public final s h() {
        List<l> r0 = this.j;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        s r3 = ((l) r2.next()).h();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.Image");
        r1.add((l) r3);
        goto L4
    L7:
        return new d(r1);
    }

    public d() {
        this(CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends l> r2) {
        Intrinsics.checkNotNullParameter(r2, "images");
        this.j = r2;
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        if (r1 == null) goto L5;
        r1.a(this);
        return;
    }
}
