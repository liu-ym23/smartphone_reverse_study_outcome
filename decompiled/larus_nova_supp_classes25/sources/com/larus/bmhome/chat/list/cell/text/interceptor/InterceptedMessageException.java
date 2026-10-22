package com.larus.bmhome.chat.list.cell.text.interceptor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/interceptor/InterceptedMessageException;", "Lcom/larus/bmhome/chat/list/cell/text/interceptor/IMarkdownRenderException;", "replacement", "Lcom/larus/im/bean/message/Message;", "errorCode", "", "errorMessage", "", "<init>", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;Ljava/lang/String;)V", "getReplacement", "()Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InterceptedMessageException extends IMarkdownRenderException {
    private final Message replacement;

    public final Message getReplacement() {
        return this.replacement;
    }

    public InterceptedMessageException(Message r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "replacement");
        super(r4, r3);
        this.replacement = r2;
    }

    public /* synthetic */ InterceptedMessageException(Message r2, Integer r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
