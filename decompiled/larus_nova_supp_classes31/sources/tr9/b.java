package tr9;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import tx9.k;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Message r13) {
        Intrinsics.checkNotNullParameter(r13, "message");
        boolean r11 = !Intrinsics.areEqual("client_receive_msg", "card_bind");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Iterator r12 = r.a(r13).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        a(r13, (Block) r12.next(), "client_receive_msg", 0, "success", null, r11);
        goto L4
    }

    public static void a(Message r9, Block r10, String r11, int r12, String r13, String r14, boolean r15) {
        if (r10.getBlockType() == BlockType.BLOCK_TYPE_AUDIO_RECORD.getValue()) goto L5;
        return;
    L5:
        k.a.a(r11, a.a(r9, r10), r14, Integer.valueOf(r12), r13, r15);
    }
}
