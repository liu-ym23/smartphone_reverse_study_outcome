package h98;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DoraDiarySummaryBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j extends jc8.a {
    @Override // jc8.a
    public final String g() {
        return "DiarySummaryBlockBizModel";
    }

    public j(Block r48) {
        Intrinsics.checkNotNullParameter(r48, "block");
        super(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null), r48);
    }

    @Override // jc8.a
    public final boolean e(jc8.a r5) {
        if (r5 == null) goto L17;
        Block r2 = r5.a;
        if (r2 == null) goto L17;
        BlockContent r3 = r2.getContent();
        if (r3 == null) goto L17;
        DoraDiarySummaryBlock r4 = r3.getDoraDiarySummaryBlock();
        if (r4 == null) goto L17;
        BlockContent r6 = this.a.getContent();
        if (r6 == null) goto L13;
        DoraDiarySummaryBlock r7 = r6.getDoraDiarySummaryBlock();
    L15:
        if (r4.equals(r7) != true) goto L17;
        boolean r8 = true;
    L19:
        if (super.e(r5) == false) goto L22;
        if (r8 == false) goto L22;
        return true;
    L22:
        return false;
    L13:
        r7 = null;
    L17:
        r8 = false;
        goto L19
    }
}
