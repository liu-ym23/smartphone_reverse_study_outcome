package fb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchQueryResultBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends jc8.a implements jc8.j {
    public final int i;
    public final String j;

    @Override // jc8.j
    public final String c() {
        return "";
    }

    @Override // jc8.a
    public final String g() {
        return "ContentWebSearchBlockBizModel";
    }

    @Override // jc8.a
    public final String h() {
        return this.j;
    }

    @Override // jc8.a
    public final int l() {
        return this.i;
    }

    @Override // jc8.j
    public final String a(boolean r4) {
        BlockContent r0 = this.a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        SearchQueryResultBlock r2 = r0.getSearchQueryResultBlock();
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
        if (r4 != null) goto L5;
        return false;
    L5:
        BlockContent r1 = this.a.getContent();
        SearchQueryResultBlock r2 = null;
        if (r1 == null) goto L8;
        SearchQueryResultBlock r3 = r1.getSearchQueryResultBlock();
    L9:
        if (r3 == null) goto L11;
        int r5 = r3.hashCode();
    L12:
        BlockContent r6 = r4.a.getContent();
        if (r6 == null) goto L15;
        r2 = r6.getSearchQueryResultBlock();
    L15:
        if (r2 == null) goto L17;
        int r7 = r2.hashCode();
    L18:
        if (r5 != r7) goto L21;
        return true;
    L21:
        return false;
    L17:
        r7 = 0;
        goto L18
    L11:
        r5 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public e(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
        this.i = com.larus.bmhome.chat.deepresearch.view.j.v;
        String r4 = r3.getBlockId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.j = r4;
    }
}
