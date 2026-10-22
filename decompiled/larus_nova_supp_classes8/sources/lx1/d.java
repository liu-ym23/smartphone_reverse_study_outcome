package lx1;

import android.content.Context;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.livesdk.feedback.view.feedback.LargeCardPreviewFeedback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kx1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements b<g> {
    public final Context a;
    public final kx1.d b;

    @Override // lx1.b
    public final List<g> a(List<Option> r6) {
        if (r6 == null) goto L7;
        List<Option> r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L10;
        Option r1 = (Option) r8.next();
        r0.add(new g(this.a, r1, this.b));
        goto L5
    L10:
        return r0;
    L7:
        return null;
    }

    public d(Context r2, LargeCardPreviewFeedback.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "clickListener");
        this.a = r2;
        this.b = r3;
    }
}
