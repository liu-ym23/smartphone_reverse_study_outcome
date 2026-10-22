package gb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends jc8.a implements jc8.j {
    @Override // jc8.a
    public final String g() {
        return "DeepThinkTextBlockBizModel";
    }

    @Override // jc8.j
    public final String c() {
        BlockContent r0 = this.a.getContent();
        if (r0 == null) goto L7;
        TextBlock r1 = r0.getTextBlock();
        if (r1 == null) goto L7;
        String r2 = r1.summary;
    L8:
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.e;
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
    public final boolean e(jc8.a r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        BlockContent r1 = this.a.getContent();
        TextBlock r2 = null;
        if (r1 == null) goto L8;
        TextBlock r3 = r1.getTextBlock();
    L9:
        if (r3 == null) goto L11;
        int r4 = r3.hashCode();
    L12:
        BlockContent r6 = r5.a.getContent();
        if (r6 == null) goto L15;
        r2 = r6.getTextBlock();
    L15:
        if (r2 == null) goto L17;
        int r7 = r2.hashCode();
    L18:
        if (r4 != r7) goto L32;
        List r8 = this.a.getMetaInfo();
        if (r8 == null) goto L22;
        int r9 = r8.hashCode();
    L23:
        List r10 = r5.a.getMetaInfo();
        if (r10 == null) goto L26;
        int r11 = r10.hashCode();
    L27:
        if (r9 == r11) goto L29;
        return false;
    L29:
        if (n() != r5.n()) goto L34;
        return true;
    L34:
        return false;
    L26:
        r11 = 0;
        goto L27
    L22:
        r9 = 0;
        goto L23
    L32:
        return false;
    L17:
        r7 = 0;
        goto L18
    L11:
        r4 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public i(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
