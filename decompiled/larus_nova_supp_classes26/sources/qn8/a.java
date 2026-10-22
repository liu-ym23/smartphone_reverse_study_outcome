package qn8;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends jc8.a {
    public final boolean e(jc8.a r1) {
        return true;
    }

    public final String g() {
        return "SpliteLineBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.p0;
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
