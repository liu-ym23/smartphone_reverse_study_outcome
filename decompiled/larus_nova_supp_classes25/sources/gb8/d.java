package gb8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.GenImageBlock;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends jc8.a implements jc8.j {
    @Override // jc8.a
    public final String g() {
        return "DeepThinkGenImageBlockBizModel";
    }

    @Override // jc8.j
    public final String c() {
        BlockContent r0 = this.a.getContent();
        if (r0 == null) goto L7;
        GenImageBlock r1 = r0.getGenImageBlock();
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
        return com.larus.bmhome.chat.deepresearch.view.j.q;
    }

    @Override // jc8.j
    public final String a(boolean r4) {
        BlockContent r0 = this.a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        GenImageBlock r2 = r0.getGenImageBlock();
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
    public final boolean e(jc8.a r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        BlockContent r1 = this.a.getContent();
        if (r1 == null) goto L67;
        GenImageBlock r2 = r1.getGenImageBlock();
        if (r2 == null) goto L74;
        BlockContent r9 = r8.a.getContent();
        if (r9 == null) goto L68;
        GenImageBlock r10 = r9.getGenImageBlock();
        if (r10 != null) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r2.summary, r10.summary) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r2.iconUrl, r10.iconUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(r2.iconUrlDark, r10.iconUrlDark) == false) goto L71;
        List r3 = r2.images;
        Integer r4 = null;
        if (r3 == null) goto L24;
        Integer r5 = Integer.valueOf(r3.size());
    L25:
        List r6 = r10.images;
        if (r6 == null) goto L29;
        r4 = Integer.valueOf(r6.size());
    L29:
        if (Intrinsics.areEqual(r5, r4) == false) goto L72;
        List r7 = r2.images;
        if (r7 == null) goto L55;
        List r11 = r7;
        if ((r11 instanceof Collection) == true) goto L35;
    L37:
        Iterator r12 = r11.iterator();
    L39:
        if (r12.hasNext() == false) goto L36;
        SearchImageInfo r13 = (SearchImageInfo) r12.next();
        List r14 = r10.images;
        if (r14 == null) goto L53;
        List r15 = r14;
        if ((r15 instanceof Collection) == true) goto L45;
    L47:
        Iterator r16 = r15.iterator();
    L49:
        if (r16.hasNext() == false) goto L53;
        if (Intrinsics.areEqual(r13.getThumbUrl(), ((SearchImageInfo) r16.next()).getThumbUrl()) == false) goto L49;
        boolean r17 = true;
    L54:
        if (r17 == true) goto L39;
    L45:
        if (r15.isEmpty() == false) goto L47;
    L53:
        r17 = false;
    L36:
        boolean r18 = true;
    L56:
        if (r18 == false) goto L73;
        return true;
    L73:
        return false;
    L35:
        if (r11.isEmpty() == false) goto L37;
    L55:
        r18 = false;
        goto L56
    L72:
        return false;
    L24:
        r5 = null;
        goto L25
    L71:
        return false;
    L68:
        return false;
    L74:
        return false;
    L67:
        return false;
    }

    public d(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
