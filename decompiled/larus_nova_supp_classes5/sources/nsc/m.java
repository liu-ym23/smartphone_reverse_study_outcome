package nsc;

import android.text.style.ParagraphStyle;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import dtc.a;
import io.noties.markwon.core.spans.w;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m implements x {
    public final ThematicBreakConfig a;

    public m(ThematicBreakConfig r1) {
        this.a = r1;
    }

    @Override // lsc.x
    public final Object a(lsc.h r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Intrinsics.checkNotNullParameter(r4, "props");
        ThematicBreakConfig r5 = this.a;
        if (r5 == null) goto L10;
        Integer r6 = r5.getHeight();
        if (r6 == null) goto L10;
        int r7 = r6.intValue();
        if (r7 > 0) goto L12;
        r7 = MarkdownDimensExtKt.a();
    L12:
        return new ParagraphStyle[]{new w(r3.a), a.a(r7)};
    L10:
        r7 = MarkdownDimensExtKt.a();
        goto L12
    }
}
