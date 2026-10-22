package h98;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.DoraDiaryImageBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends jc8.a {
    @Override // jc8.a
    public final String g() {
        return "DiaryImageBlockBizModel";
    }

    public b(Block r48) {
        Intrinsics.checkNotNullParameter(r48, "block");
        super(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null), r48);
    }

    @Override // jc8.a
    public final boolean e(jc8.a r5) {
        if ((r5 instanceof b) == true) goto L5;
        return false;
    L5:
        BlockContent r0 = ((b) r5).a.getContent();
        if (r0 == null) goto L16;
        DoraDiaryImageBlock r1 = r0.getDoraImageBlock();
        if (r1 == null) goto L16;
        BlockContent r3 = this.a.getContent();
        if (r3 == null) goto L12;
        DoraDiaryImageBlock r4 = r3.getDoraImageBlock();
    L14:
        if (r1.equals(r4) != true) goto L16;
        boolean r2 = true;
    L18:
        if (super.e(r5) == false) goto L22;
        if (r2 == false) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L12:
        r4 = null;
    L16:
        r2 = false;
        goto L18
    }
}
