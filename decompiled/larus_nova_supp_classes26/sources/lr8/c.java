package lr8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.service.AccountService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getContentType() != 800) goto L7;
        if (Intrinsics.areEqual(r5.getBizContentType(), "flow_nested") == false) goto L7;
        return true;
    L7:
        if (com.larus.im.bean.message.a.b0(r5) == false) goto L32;
        List r0 = r5.getContentBlock();
        if (r0 == null) goto L27;
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L13;
    L15:
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L24;
        if (((Block) r2.next()).getBlockType() != BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L17;
        boolean r4 = true;
    L25:
        if (r4 != true) goto L27;
        boolean r6 = true;
    L28:
        if (r6 == false) goto L32;
        if (Intrinsics.areEqual(AccountService.a.getUserId(), r5.getSenderId()) == false) goto L32;
        boolean r7 = true;
    L33:
        if (r7 == true) goto L43;
        return false;
    L43:
        return true;
    L21:
        r3 = false;
    L24:
        r4 = false;
        goto L25
    L13:
        if (r1.isEmpty() == false) goto L15;
    L27:
        r6 = false;
    L32:
        r7 = false;
        goto L33
    }
}
