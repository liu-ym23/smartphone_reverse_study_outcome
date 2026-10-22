package tj8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ButtonBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final ButtonBlock i;
    public final int j;

    public final String g() {
        return "CommonButtonBlockBizModel";
    }

    public final int l() {
        return this.j;
    }

    public final boolean e(jc8.a r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.i.hashCode() != ((a) r3).i.hashCode()) goto L12;
        return true;
    L12:
        return false;
    }

    public a(ButtonBlock r2, Message r3, Block r4) {
        Intrinsics.checkNotNullParameter(r2, "buttonBlock");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "block");
        super(r3, r4);
        this.i = r2;
        this.j = j.E;
    }
}
