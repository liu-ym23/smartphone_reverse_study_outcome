package sm8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskContent;
import com.larus.im.bean.message.block.InteractionAskIcon;
import jc8.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a implements j {
    public final InteractionAskContent i;

    public final String g() {
        return "QuickReplyThinkingBlockBizModel";
    }

    public final String c() {
        String r0 = this.i.getProcessingStatusText();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.G;
    }

    public final String a(boolean r4) {
        InteractionAskIcon r0 = this.i.getIcon();
        String r2 = null;
        if (r4 == false) goto L8;
        if (r0 == null) goto L6;
        r2 = r0.getUrlDark();
    L6:
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L8:
        if (r0 == null) goto L10;
        r2 = r0.getUrlLight();
    L10:
        if (r2 != null) goto L13;
        return "";
    }

    public final boolean e(jc8.a r4) {
        if ((r4 instanceof a) == true) goto L5;
        return false;
    L5:
        a r5 = (a) r4;
        if (Intrinsics.areEqual(this.i, r5.i) == true) goto L8;
        return false;
    L8:
        if (((jc8.a) this).a.isFinish() != ((jc8.a) r5).a.isFinish()) goto L12;
        return true;
    L12:
        return false;
    }

    public a(Message r2, Block r3, InteractionAskContent r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        Intrinsics.checkNotNullParameter(r4, "thinkingContent");
        super(r2, r3);
        this.i = r4;
    }
}
