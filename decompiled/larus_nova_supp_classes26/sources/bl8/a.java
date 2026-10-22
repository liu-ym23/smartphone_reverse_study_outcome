package bl8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.im.bean.message.block.FileOperationBlock;
import jc8.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements j {
    public final String g() {
        return "FileOperationBlockBizModel";
    }

    public final String c() {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        if (r0 == null) goto L9;
        FileOperationBlock r1 = r0.getFileOperationBlock();
        if (r1 == null) goto L9;
        DisplayHeader r2 = r1.header;
        if (r2 == null) goto L9;
        String r3 = r2.getSummary();
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.e0;
    }

    public final String a(boolean r4) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L7;
        FileOperationBlock r2 = r0.getFileOperationBlock();
        if (r2 == null) goto L7;
        DisplayHeader r3 = r2.header;
    L9:
        if (r4 == false) goto L14;
        if (r3 == null) goto L12;
        r1 = r3.getIconUrlDark();
    L12:
        if (r1 != null) goto L19;
        return "";
    L19:
        return r1;
    L14:
        if (r3 == null) goto L16;
        r1 = r3.getIconUrl();
    L16:
        if (r1 != null) goto L19;
        return "";
    L7:
        r3 = null;
        goto L9
    }

    public final boolean e(jc8.a r5) {
        FileOperationBlock r1 = null;
        if ((r5 instanceof a) == false) goto L5;
        a r6 = (a) r5;
    L7:
        if (r6 != null) goto L9;
        return false;
    L9:
        BlockContent r2 = ((jc8.a) this).a.getContent();
        if (r2 == null) goto L12;
        FileOperationBlock r3 = r2.getFileOperationBlock();
    L13:
        BlockContent r4 = ((jc8.a) r6).a.getContent();
        if (r4 == null) goto L16;
        r1 = r4.getFileOperationBlock();
    L16:
        if (r3 == null) goto L18;
        int r7 = r3.hashCode();
    L19:
        if (r1 == null) goto L21;
        int r8 = r1.hashCode();
    L22:
        if (r7 == r8) goto L24;
        return false;
    L24:
        if (il8.b.a(this) != il8.b.a(r6)) goto L28;
        return true;
    L28:
        return false;
    L21:
        r8 = 0;
        goto L22
    L18:
        r7 = 0;
        goto L19
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
