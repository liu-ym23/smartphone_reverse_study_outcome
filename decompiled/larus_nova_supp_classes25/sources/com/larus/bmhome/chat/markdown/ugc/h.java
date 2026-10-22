package com.larus.bmhome.chat.markdown.ugc;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.platform.service.z2;
import com.larus.utils.t0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements ip8.e {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ MarkdownUgcWidget b;

    public final void b(View r1, Content r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public h(RecyclerView r1, MarkdownUgcWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.bmhome.chat.markdown.ugc.d] */
    public final void c(View r9, final Content r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        if (this.a.getContext() == null) goto L22;
        if (r10 == null) goto L24;
        final MarkdownUgcWidget r3 = this.b;
        final String r7 = MarkdownUgcWidget.j(r3);
        final int r4 = r9.getWidth();
        final int r5 = r9.getHeight();
        List<Content> r0 = this.b.p;
        if (r0 == null) goto L9;
        final int r6 = r0.indexOf(r10);
    L10:
        final ?? r1 = new d(r10, r3, r4, r5, r6, r7);
        if (z2.a.enableTrackerOptimize() == false) goto L13;
        t0.a(new e(r1));
    L14:
        Integer r2 = r10.getItemType();
        int r8 = ItemType.ARTICLE.getValue();
        if (r2 != null) goto L18;
    L20:
        MarkdownUgcWidget.l(this.b, r9, r10);
        return;
    L18:
        if (r2.intValue() != r8) goto L20;
        MarkdownUgcWidget.k(this.b, r9, r10);
        return;
    L13:
        r1.invoke();
        goto L14
    L9:
        r6 = 0;
        goto L10
    L24:
        return;
    }
}
