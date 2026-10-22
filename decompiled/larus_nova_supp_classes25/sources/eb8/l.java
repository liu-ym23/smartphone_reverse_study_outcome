package eb8;

import android.graphics.RectF;
import android.view.ViewGroup;
import com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends h<fb8.d> {
    @Override // jc8.b
    public final String c() {
        return "CommerceCreditBlockHolder";
    }

    @Override // eb8.h
    public final RectF k(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "baseBlockBizModel");
        return null;
    }

    public l() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        fb8.d r3 = (fb8.d) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    @Override // eb8.h
    public final MarkdownTextBlockView j(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        return new com.larus.bmhome.chat.deepresearch.view.f0(r2.getContext());
    }
}
