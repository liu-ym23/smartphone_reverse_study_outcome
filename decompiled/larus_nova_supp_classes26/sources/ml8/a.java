package ml8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.im.bean.message.block.GUIToolBlock;
import jc8.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements j {
    public final String g() {
        return "GuiToolBlockBizModel";
    }

    public final String c() {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        if (r0 == null) goto L9;
        GUIToolBlock r1 = r0.getGuiToolBlock();
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
        return com.larus.bmhome.chat.deepresearch.view.j.f0;
    }

    public final String a(boolean r4) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L7;
        GUIToolBlock r2 = r0.getGuiToolBlock();
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

    public final boolean e(jc8.a r3) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        GUIToolBlock r1 = null;
        if (r0 == null) goto L5;
        GUIToolBlock r2 = r0.getGuiToolBlock();
    L6:
        if (r3 == null) goto L13;
        Block r4 = r3.a;
        if (r4 == null) goto L13;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L13;
        r1 = r5.getGuiToolBlock();
    L13:
        return Intrinsics.areEqual(r2, r1);
    L5:
        r2 = null;
        goto L6
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
