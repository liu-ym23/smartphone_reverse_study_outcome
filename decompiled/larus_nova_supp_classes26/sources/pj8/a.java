package pj8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import jc8.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements j {
    public final String c() {
        return "";
    }

    public final String g() {
        return "ContentCodeBlockBizModel";
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.o;
    }

    public final String a(boolean r4) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        CodeBlock r2 = r0.getCodeBlock();
    L7:
        if (r4 == false) goto L12;
        if (r2 == null) goto L10;
        r1 = r2.iconUrlDark;
    L10:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    L12:
        if (r2 == null) goto L14;
        r1 = r2.iconUrl;
    L14:
        if (r1 != null) goto L17;
        return "";
    L5:
        r2 = null;
        goto L7
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BlockContent r0 = ((jc8.a) this).a.getContent();
        Integer r1 = null;
        if (r0 == null) goto L10;
        CodeBlock r2 = r0.getCodeBlock();
        if (r2 == null) goto L10;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L11:
        BlockContent r5 = r3.a.getContent();
        if (r5 == null) goto L17;
        CodeBlock r6 = r5.getCodeBlock();
        if (r6 == null) goto L17;
        r1 = Integer.valueOf(r6.hashCode());
    L17:
        return Intrinsics.areEqual(r4, r1);
    L10:
        r4 = null;
        goto L11
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
