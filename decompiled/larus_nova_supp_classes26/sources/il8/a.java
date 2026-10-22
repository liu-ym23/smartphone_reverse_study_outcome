package il8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.GenericToolBlock;
import jc8.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements j {
    public final String g() {
        return "GenericToolBlockBizModel";
    }

    public final String c() {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        GenericToolBlock r2 = r0.getGenericToolBlock();
    L6:
        if (r2 == null) goto L17;
        String r3 = r2.summary;
        if (r3 == null) goto L17;
        if (r3.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L17;
        return r3;
    L12:
        r4 = false;
    L17:
        if (r2 == null) goto L19;
        r1 = r2.title;
    L19:
        if (r1 != null) goto L22;
        return "";
    L22:
        return r1;
    L5:
        r2 = null;
        goto L6
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.Y;
    }

    public final String a(boolean r4) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        GenericToolBlock r2 = r0.getGenericToolBlock();
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

    public final boolean e(jc8.a r5) {
        GenericToolBlock r1 = null;
        if ((r5 instanceof a) == false) goto L5;
        a r6 = (a) r5;
    L7:
        if (r6 != null) goto L9;
        return false;
    L9:
        BlockContent r2 = ((jc8.a) this).a.getContent();
        if (r2 == null) goto L12;
        GenericToolBlock r3 = r2.getGenericToolBlock();
    L13:
        BlockContent r4 = ((jc8.a) r6).a.getContent();
        if (r4 == null) goto L17;
        r1 = r4.getGenericToolBlock();
    L17:
        if (Intrinsics.areEqual(r3, r1) == true) goto L19;
        return false;
    L19:
        if (b.a(this) != b.a(r6)) goto L23;
        return true;
    L23:
        return false;
    L12:
        r3 = null;
        goto L13
    L5:
        r6 = null;
        goto L7
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
