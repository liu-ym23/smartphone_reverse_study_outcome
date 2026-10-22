package ua8;

import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import jc8.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends jc8.a implements j {
    public final int i;

    @Override // jc8.j
    public final String c() {
        return "";
    }

    @Override // jc8.a
    public final String g() {
        return "BasicTextBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        return this.i;
    }

    public b(Block r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        super(r2, null);
        this.i = com.larus.bmhome.chat.deepresearch.view.j.e;
    }

    @Override // jc8.j
    public final String a(boolean r4) {
        BlockContent r0 = this.a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        TextBlock r2 = r0.getTextBlock();
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

    @Override // jc8.a
    public final boolean e(jc8.a r4) {
        if ((r4 instanceof b) == false) goto L26;
        BlockContent r0 = this.a.getContent();
        TextBlock r1 = null;
        if (r0 == null) goto L7;
        TextBlock r2 = r0.getTextBlock();
    L8:
        b r5 = (b) r4;
        BlockContent r3 = r5.a.getContent();
        if (r3 == null) goto L12;
        r1 = r3.getTextBlock();
    L12:
        if (Intrinsics.areEqual(r2, r1) == false) goto L26;
        if (Intrinsics.areEqual(this.a.getMetaInfo(), r5.a.getMetaInfo()) == false) goto L26;
        if (this.a.isFinish() != r5.a.isFinish()) goto L26;
        if (m() != r5.m()) goto L26;
        if (n() != r5.n()) goto L26;
        if (Intrinsics.areEqual(this.e.e, r5.e.e) == false) goto L26;
        if (this.e.d != r5.e.d) goto L26;
        return true;
    L7:
        r2 = null;
    L26:
        return false;
    }
}
