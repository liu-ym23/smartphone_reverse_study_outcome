package rm8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final String g() {
        return "QuickReplyInputPanelBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.G;
    }

    public final boolean e(jc8.a r5) {
        if ((r5 instanceof a) == true) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        Integer r2 = null;
        if (r0 == null) goto L10;
        QuickReplyBlock r1 = r0.getQuickReplyBlock();
        if (r1 == null) goto L10;
        Integer r3 = Integer.valueOf(r1.hashCode());
    L11:
        a r6 = (a) r5;
        BlockContent r4 = ((jc8.a) r6).a.getContent();
        if (r4 == null) goto L16;
        QuickReplyBlock r7 = r4.getQuickReplyBlock();
        if (r7 == null) goto L16;
        r2 = Integer.valueOf(r7.hashCode());
    L16:
        boolean r8 = Intrinsics.areEqual(r3, r2);
        boolean r9 = Intrinsics.areEqual(j().getBusinessExt(), r6.j().getBusinessExt());
        if (r8 == false) goto L21;
        if (r9 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L10:
        r3 = null;
        goto L11
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
