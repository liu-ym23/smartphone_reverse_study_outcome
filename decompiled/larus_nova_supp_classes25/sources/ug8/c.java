package ug8;

import com.larus.bmhome.chat.list.cell.text.components.middle.h0;
import com.larus.bmhome.chat.list.cell.text.interceptor.ErrorEnum;
import com.larus.bmhome.chat.list.cell.text.interceptor.InterceptedMessageException;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TextBlock;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements b {
    public final Set<String> a;
    public final Function0<String> b;

    @Override // ug8.b
    public final h0 a(h0 r49) {
        Intrinsics.checkNotNullParameter(r49, "p");
        String r2 = r49.d.getMessageId();
        if (r2 != null) goto L5;
    L9:
        return r49;
    L5:
        if (this.a.contains(r2) == false) goto L9;
        Message r3 = r49.d;
        g r1 = g.a;
        String r4 = (String) this.b.invoke();
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        Message r5 = Message.copy$default(r3, null, null, null, 0, 0, null, 0, false, null, new JSONObject().put(ChatDraftItem.TYPE_TEXT, r4).toString(), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -513, 31, null);
        ErrorEnum r6 = ErrorEnum.BLOCK_MESSAGE;
        throw new InterceptedMessageException(r5, Integer.valueOf(r6.getErrorCode()), r6.getErrorMessage());
    }

    @Override // ug8.b
    public final Message b(Message r123) {
        Intrinsics.checkNotNullParameter(r123, "msg");
        String r2 = r123.getMessageId();
        if (r2 != null) goto L5;
    L28:
        return r123;
    L5:
        if (this.a.contains(r2) == false) goto L28;
        Intrinsics.checkNotNullParameter(r123, "<this>");
        Iterator r3 = r.a(r123).iterator();
    L7:
        String r4 = null;
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();
        Block r6 = (Block) r5;
        boolean r8 = false;
        if (r6.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L20;
        String r7 = r6.getParentId();
        if (r7 != null) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r9 == false) goto L20;
        r8 = true;
        goto L20
    L14:
        if (r7.length() == 0) goto L17;
        r9 = false;
    L20:
        if (r8 == false) goto L7;
    L23:
        Block r10 = (Block) r5;
        int r31 = BlockType.BLOCK_TYPE_TEXT.getValue();
        if (r10 == null) goto L26;
        r4 = r10.getBlockId();
    L26:
        Message r1 = Message.copy$default(r123, null, null, null, 0, 0, null, 0, false, null, null, CollectionsKt.listOf(new Block(r31, r4, null, new BlockContent(new TextBlock((String) this.b.invoke(), null, null, null, 0, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null), false, null, null, null, 244, null)), null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1025, 31, null);
        ErrorEnum r11 = ErrorEnum.BLOCK_MESSAGE;
        throw new InterceptedMessageException(r1, Integer.valueOf(r11.getErrorCode()), r11.getErrorMessage());
    L22:
        r5 = null;
        goto L23
    }

    public c(Set<String> r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "blockedIds");
        Intrinsics.checkNotNullParameter(r3, "errorText");
        this.a = r2;
        this.b = r3;
    }
}
