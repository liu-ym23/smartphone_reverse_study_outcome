package bh8;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterKt$doOnScrollIdle$listener$1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    /* JADX WARN: Type inference failed for: r0v0, types: [bh8.c, java.lang.Object, kotlin.jvm.functions.Function1] */
    public static void a(final RecyclerView r2, final Function0 r3) {
        final ?? r0 = new c();
        Intrinsics.checkNotNullParameter(r0, "scrollIdle");
        Intrinsics.checkNotNullParameter(r3, "action");
        if (r2 != null) goto L5;
    L8:
        r3.invoke();
        return;
    L5:
        if (((Boolean) r0.invoke(r2)).booleanValue() == true) goto L8;
        r2.addOnScrollListener(new PagingAdapterKt$doOnScrollIdle$listener$1(r0, r2, r3));
    }
}
