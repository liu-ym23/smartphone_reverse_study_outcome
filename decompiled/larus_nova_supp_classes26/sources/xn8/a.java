package xn8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final int i;
    public final String j;

    public final String g() {
        return "RelatedVideoBlockBizModel";
    }

    public final String h() {
        return this.j;
    }

    public final int l() {
        return this.i;
    }

    public final boolean e(jc8.a r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        BlockContent r1 = ((jc8.a) this).a.getContent();
        Integer r2 = null;
        if (r1 == null) goto L8;
        SearchRichMediaBlock r3 = r1.getRichMediaBlock();
    L9:
        BlockContent r7 = r6.a.getContent();
        if (r7 == null) goto L12;
        SearchRichMediaBlock r8 = r7.getRichMediaBlock();
    L13:
        if (r3 == null) goto L15;
        Integer r4 = r3.scene;
    L16:
        if (r8 == null) goto L18;
        Integer r5 = r8.scene;
    L20:
        if (Intrinsics.areEqual(r4, r5) == false) goto L46;
        if (r3 == null) goto L25;
        List r9 = r3.creations;
        if (r9 == null) goto L25;
        Integer r10 = Integer.valueOf(r9.size());
    L26:
        if (r8 == null) goto L30;
        List r11 = r8.creations;
        if (r11 == null) goto L30;
        Integer r12 = Integer.valueOf(r11.size());
    L32:
        if (Intrinsics.areEqual(r10, r12) == false) goto L47;
        if (r3 == null) goto L37;
        List r13 = r3.creations;
        if (r13 == null) goto L37;
        Integer r14 = Integer.valueOf(r13.hashCode());
    L38:
        if (r8 == null) goto L43;
        List r15 = r8.creations;
        if (r15 == null) goto L43;
        r2 = Integer.valueOf(r15.hashCode());
    L43:
        if (Intrinsics.areEqual(r14, r2) == false) goto L48;
        return true;
    L48:
        return false;
    L37:
        r14 = null;
        goto L38
    L47:
        return false;
    L30:
        r12 = null;
    L25:
        r10 = null;
        goto L26
    L46:
        return false;
    L18:
        r5 = null;
        goto L20
    L15:
        r4 = null;
        goto L16
    L12:
        r8 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = j.B;
        String r4 = r3.getBlockId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.j = r4;
    }
}
