package fh8;

import android.view.View;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public static final List<lw8.k> b(lw8.l r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        List<k> r3 = o.a(r2);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = ((ArrayList) r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((k) r4.next()).b);
        goto L4
    L6:
        return r0;
    }

    public static final void a(lw8.l r5, final View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "onClick");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Iterator r7 = ((ArrayList) o.a(r5)).iterator();     // Catch: Throwable -> L12
        final int r1 = 0;
    L5:
        if (r7.hasNext() == false) goto L10;
        Object r2 = r7.next();     // Catch: Throwable -> L12
        int r3 = r1 + 1;     // Catch: Throwable -> L12
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L12
    L9:
        final k r4 = (k) r2;     // Catch: Throwable -> L12
        CustomLinkSpan r8 = r4.a;     // Catch: Throwable -> L12
        r8.g = new v(r1, r4, r6);     // Catch: Throwable -> L12
        r1 = r3;
        goto L5
    L10:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
