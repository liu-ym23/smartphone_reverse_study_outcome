package yj8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CommonButtonV2Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final String g() {
        return "CommonButtonV2BlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.F;
    }

    public final boolean e(jc8.a r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        BlockContent r1 = ((jc8.a) this).a.getContent();
        Integer r2 = null;
        if (r1 == null) goto L13;
        CommonButtonV2Block r3 = r1.getCommonButtonBlock();
        if (r3 == null) goto L13;
        Integer r4 = Integer.valueOf(r3.hashCode());
    L14:
        a r6 = (a) r5;
        BlockContent r7 = ((jc8.a) r6).a.getContent();
        if (r7 == null) goto L19;
        CommonButtonV2Block r8 = r7.getCommonButtonBlock();
        if (r8 == null) goto L19;
        r2 = Integer.valueOf(r8.hashCode());
    L19:
        boolean r9 = Intrinsics.areEqual(r4, r2);
        boolean r10 = Intrinsics.areEqual(j().getBusinessExt(), r6.j().getBusinessExt());
        if (r9 == false) goto L24;
        if (r10 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L13:
        r4 = null;
        goto L14
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
