package xl8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final yl8.a i;

    public final String g() {
        return "LyricsToSongBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.k0;
    }

    public final boolean e(jc8.a r3) {
        if (super.e(r3) == false) goto L17;
        Map r0 = j().getExt();
        if (r0 == null) goto L7;
        int r1 = r0.hashCode();
    L8:
        if (r3 == null) goto L10;
        Map r4 = r3.j().getExt();
    L11:
        if (r4 == null) goto L13;
        int r5 = r4.hashCode();
    L14:
        if (r1 != r5) goto L18;
        return true;
    L18:
        return false;
    L13:
        r5 = 0;
        goto L14
    L10:
        r4 = null;
        goto L11
    L7:
        r1 = 0;
        goto L8
    L17:
        return false;
    }

    public a(Message r2, Block r3, yl8.a r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3);
        this.i = r4;
    }
}
