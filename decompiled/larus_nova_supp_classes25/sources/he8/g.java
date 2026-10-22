package he8;

import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.x;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.platform.spi.IAIChatService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements je8.a {
    public g() {
    }

    public final boolean a(Object r5) {
        Message r6 = (Message) r5;
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        IChatAzerothService r0 = x.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return false;
    L11:
        if (r6.getContentType() == 1) goto L18;
        if (r6.getContentType() == 66) goto L18;
        if (r6.getContentType() == 9999) goto L18;
        return false;
    L18:
        if (r6.getMessageStatus() == MessageStatus.MessageStatus_INVISIBLE) goto L46;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Block r2 = (Block) CollectionsKt.firstOrNull(r.a(r6));
        if (r2 == null) goto L27;
        BlockContent r3 = r2.getContent();
        if (r3 == null) goto L27;
        TextBlock r4 = r3.getTextBlock();
        if (r4 == null) goto L27;
        String r7 = r4.text;
    L28:
        if (r7 != null) goto L30;
    L33:
        boolean r8 = true;
    L34:
        if (r8 == false) goto L37;
        return false;
    L37:
        if (IAIChatService.a.B7(r6) == null) goto L40;
        return false;
    L40:
        if (com.larus.bmhome.chat.bean.d.G0(r6) == false) goto L49;
        return true;
    L49:
        return false;
    L30:
        if (StringsKt.isBlank(r7) == true) goto L33;
        r8 = false;
    L27:
        r7 = null;
        goto L28
    L46:
        return false;
    L5:
        if (r0.d(r6) != true) goto L7;
        r1 = true;
        goto L8
    }

    public final ei9.f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new f(r3);
    }
}
