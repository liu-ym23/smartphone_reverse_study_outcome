package nk8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ResearchWebpageBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends jc8.a {
    public final int i;

    public final String g() {
        return "ResearchWebpageBlockBizModel";
    }

    public final int l() {
        return this.i;
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L10;
        ResearchWebpageBlock r2 = r0.getResearchWebpageBlock();
        if (r2 == null) goto L10;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L11:
        BlockContent r5 = r3.a.getContent();
        if (r5 == null) goto L17;
        ResearchWebpageBlock r6 = r5.getResearchWebpageBlock();
        if (r6 == null) goto L17;
        r1 = Integer.valueOf(r6.hashCode());
    L17:
        return Intrinsics.areEqual(r4, r1);
    L10:
        r4 = null;
        goto L11
    }

    public c(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = j.t;
    }
}
