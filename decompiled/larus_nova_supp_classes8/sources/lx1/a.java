package lx1;

import android.content.Context;
import com.bytedance.android.live.base.model.feedback.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements b<kx1.b> {
    public final Context a;
    public final kx1.e b;

    @Override // lx1.b
    public final List<kx1.b> a(List<Option> r6) {
        if (r6 == null) goto L7;
        List<Option> r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L10;
        Option r1 = (Option) r8.next();
        r0.add(new kx1.b(this.a, r1, this.b));
        goto L5
    L10:
        return r0;
    L7:
        return null;
    }

    public a(Context r2, mx1.a.C0402a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "selectListener");
        this.a = r2;
        this.b = r3;
    }
}
