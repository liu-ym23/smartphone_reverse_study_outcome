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
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final List<b> a;
    public final Function0<String> b;

    public final Pair<h0, ErrorEnum> a(h0 r49) {
        h0 r2 = r49;
        Intrinsics.checkNotNullParameter(r2, "input");
        Iterator<b> r0 = this.a.iterator();     // Catch: Throwable -> L9 InterceptedMessageException -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        r2 = r0.next().a(r2);     // Catch: Throwable -> L9 InterceptedMessageException -> L10
        goto L5
    L7:
    L17:
        return new Pair(r2, null);
    L10:
        e = move-exception;
        Pair<h0, ErrorEnum> r3 = new Pair(h0.a(r2, e.getReplacement()), ErrorEnum.BLOCK_MESSAGE);
    L13:
        return r3;
    L9:
        Message r4 = r2.d;
        g r1 = g.a;
        String r5 = (String) this.b.invoke();
        Intrinsics.checkNotNullParameter(r5, ChatDraftItem.TYPE_TEXT);
        r3 = new Pair(h0.a(r2, Message.copy$default(r4, null, null, null, 0, 0, null, 0, false, null, new JSONObject().put(ChatDraftItem.TYPE_TEXT, r5).toString(), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -513, 31, null)), ErrorEnum.BLOCK_MESSAGE_CONTENT);
        goto L13
    }

    public final Pair<Message, ErrorEnum> b(Message r102) {
        Message r2 = r102;
        Intrinsics.checkNotNullParameter(r2, "message");
        String r0 = null;
        Iterator<b> r3 = this.a.iterator();     // Catch: Throwable -> L9 InterceptedMessageException -> L30
    L5:
        if (r3.hasNext() == false) goto L7;
        r2 = r3.next().b(r2);     // Catch: Throwable -> L9 InterceptedMessageException -> L30
        goto L5
    L7:
    L43:
        return new Pair(r2, null);
    L30:
        e = move-exception;
        return new Pair(e.getReplacement(), ErrorEnum.BLOCK_MESSAGE);
    L9:
        Message r4 = r2;
        Iterator r5 = com.larus.im.bean.message.a.d(r4).iterator();
    L11:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        Block r7 = (Block) r6;
        boolean r8 = false;
        if (r7.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L23;
        String r9 = r7.getParentId();
        if (r9 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L23;
        r8 = true;
        goto L23
    L17:
        if (r9.length() == 0) goto L20;
        r10 = false;
    L23:
        if (r8 == false) goto L11;
    L26:
        Block r11 = (Block) r6;
        int r16 = BlockType.BLOCK_TYPE_TEXT.getValue();
        if (r11 == null) goto L42;
        r0 = r11.getBlockId();
    L42:
        return new Pair(Message.copy$default(r4, null, null, null, 0, 0, null, 0, false, null, null, CollectionsKt.listOf(new Block(r16, r0, null, new BlockContent(new TextBlock((String) this.b.invoke(), null, null, null, 0, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null), false, null, null, null, 244, null)), null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1025, 31, null), ErrorEnum.BLOCK_MESSAGE_CONTENT);
    L25:
        r6 = null;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends b> r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r3, "errorTextProvider");
        this.a = r2;
        this.b = r3;
    }
}
