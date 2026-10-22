package com.obric.assistant.reporter;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/reporter/ObricReceiveStreamMessageTypeOverriderImpl;", "Lcom/obric/assistant/spi/chat/IReceiveStreamMessageTypeOverrider;", "<init>", "()V", "overrideMessageType", "", "msg", "Lcom/larus/im/bean/message/Message;", "defaultType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReceiveStreamMessageTypeOverriderImpl implements IReceiveStreamMessageTypeOverrider {
    public ObricReceiveStreamMessageTypeOverriderImpl() {
    }

    @Override // com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider
    public final String a(Message r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        List r7 = r5.getContentBlock();
        boolean r0 = false;
        if (r7 == null) goto L21;
        List r8 = r7;
        if ((r8 instanceof Collection) == true) goto L7;
    L9:
        Iterator r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L18;
        if (((Block) r9.next()).getBlockType() != BlockType.BLOCK_TYPE_O_OMNI_BUTTON_GROUP.getValue()) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L11;
        boolean r10 = true;
    L19:
        if (r10 != true) goto L21;
        r0 = true;
        goto L21
    L15:
        r1 = false;
    L18:
        r10 = false;
        goto L19
    L7:
        if (r8.isEmpty() == false) goto L9;
    L21:
        if (r0 == false) goto L29;
        return "obric_omni_confirmation";
    L29:
        return r6;
    }
}
