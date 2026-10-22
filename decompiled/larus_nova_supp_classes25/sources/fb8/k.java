package fb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SpringLynxBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends jc8.a {
    @Override // jc8.a
    public final String g() {
        return "SpringLynxBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.W;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r3) {
        BlockContent r0 = this.a.getContent();
        SpringLynxBlock r1 = null;
        if (r0 == null) goto L5;
        SpringLynxBlock r2 = r0.getSpringLynxBlock();
    L6:
        if (r3 == null) goto L13;
        Block r4 = r3.a;
        if (r4 == null) goto L13;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L13;
        r1 = r5.getSpringLynxBlock();
    L13:
        return Intrinsics.areEqual(r2, r1);
    L5:
        r2 = null;
        goto L6
    }

    public k(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
