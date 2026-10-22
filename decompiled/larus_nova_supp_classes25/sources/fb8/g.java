package fb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LynxBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends jc8.a {
    @Override // jc8.a
    public final String g() {
        return "LynxCardBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.X;
    }

    public final String o() {
        return "LynxCardBlock(msgId=" + j().getMessageId() + ",serverIndex=" + j().getServerIndex() + ')';
    }

    @Override // jc8.a
    public final boolean e(jc8.a r3) {
        BlockContent r0 = this.a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L7;
        LynxBlock r2 = r0.getLynxBlock();
        if (r2 == null) goto L7;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L8:
        if (r3 == null) goto L17;
        Block r5 = r3.a;
        if (r5 == null) goto L17;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L17;
        LynxBlock r7 = r6.getLynxBlock();
        if (r7 == null) goto L17;
        r1 = Integer.valueOf(r7.hashCode());
    L17:
        return Intrinsics.areEqual(r4, r1);
    L7:
        r4 = null;
        goto L8
    }

    public g(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
