package fb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends jc8.a {
    @Override // jc8.a
    public final String g() {
        return "BizMergeForwardBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.o0;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = this.a.getContent();
        BizMergeForwardBlock r1 = null;
        if (r0 == null) goto L8;
        BizMergeForwardBlock r2 = r0.getBizMergeForwardBlock();
    L9:
        BlockContent r4 = r3.a.getContent();
        if (r4 == null) goto L13;
        r1 = r4.getBizMergeForwardBlock();
    L13:
        return Intrinsics.areEqual(r2, r1);
    L8:
        r2 = null;
        goto L9
    }

    public b(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
