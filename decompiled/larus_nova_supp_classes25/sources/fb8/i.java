package fb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends jc8.a {
    @Override // jc8.a
    public final String g() {
        return "ResearchProcessBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.h;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = this.a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L10;
        ResearchProcessBlock r2 = r0.getResearchProcessBlock();
        if (r2 == null) goto L10;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L11:
        BlockContent r5 = r3.a.getContent();
        if (r5 == null) goto L17;
        ResearchProcessBlock r6 = r5.getResearchProcessBlock();
        if (r6 == null) goto L17;
        r1 = Integer.valueOf(r6.hashCode());
    L17:
        return Intrinsics.areEqual(r4, r1);
    L10:
        r4 = null;
        goto L11
    }

    public i(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
