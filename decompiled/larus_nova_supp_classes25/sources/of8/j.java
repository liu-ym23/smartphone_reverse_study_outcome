package of8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final boolean a(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (com.larus.im.bean.message.a.b0(r5) == true) goto L5;
        return false;
    L5:
        List r6 = com.larus.im.bean.message.a.d(r5);
        if ((r6 instanceof Collection) == true) goto L8;
    L10:
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L32;
        Block r0 = (Block) r7.next();
        if (r0.getBlockType() == BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()) goto L22;
        BlockContent r1 = r0.getContent();
        if (r1 == null) goto L18;
        BizMergeForwardBlock r2 = r1.getBizMergeForwardBlock();
    L19:
        if (r2 != null) goto L22;
        boolean r3 = false;
    L23:
        if (r3 == false) goto L12;
        return true;
    L18:
        r2 = null;
    L22:
        r3 = true;
        goto L23
    L32:
        return false;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return false;
    }
}
