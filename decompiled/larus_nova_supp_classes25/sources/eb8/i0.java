package eb8;

import android.graphics.RectF;
import android.view.ViewGroup;
import com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 extends h<fb8.l> {
    public final boolean i;

    @Override // jc8.b
    public final String c() {
        return "TextBlockHolder";
    }

    public i0() {
        boolean r0 = com.larus.platform.exp.h.a;
        if (com.larus.platform.exp.h.a == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.i = r1;
        return;
    L5:
        if (z2.a.enableMarkdownContainerAppletLastBlockInset() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((fb8.l) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // eb8.h
    public final MarkdownTextBlockView j(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        return new MarkdownTextBlockView(r2.getContext());
    }

    @Override // eb8.h
    public final RectF k(jc8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "baseBlockBizModel");
        jc8.d r0 = jc8.e.d(r5);
        if (r5.n() == true) goto L5;
    L12:
        int r6 = r0.d;
    L14:
        return new RectF(r0.a, r0.b, r0.c, r6);
    L5:
        if (com.larus.platform.exp.h.a == false) goto L7;
        boolean r1 = this.i;
    L8:
        if (r1 == false) goto L12;
        if (h0.a(r5) == false) goto L12;
        r6 = ((Number) h0.a.getValue()).intValue();
        goto L14
    L7:
        r1 = z2.a.enableMarkdownContainerAppletLastBlockInset();
        goto L8
    }
}
