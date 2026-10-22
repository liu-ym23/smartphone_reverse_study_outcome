package com.larksuite.component.blockit.entity.richtext;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.chat.entity.message.Message;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/blockit/entity/richtext/RichTextMessage;", "Ljava/io/Serializable;", "messageType", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "messageContent", "Lcom/larksuite/component/blockit/entity/richtext/MessageContentEntity;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/Message$Type;Lcom/larksuite/component/blockit/entity/richtext/MessageContentEntity;)V", "getMessageType", "()Lcom/ss/android/lark/chat/entity/message/Message$Type;", "setMessageType", "(Lcom/ss/android/lark/chat/entity/message/Message$Type;)V", "getMessageContent", "()Lcom/larksuite/component/blockit/entity/richtext/MessageContentEntity;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RichTextMessage implements Serializable {
    private final MessageContentEntity messageContent;
    private Message.Type messageType;

    public static /* synthetic */ RichTextMessage copy$default(RichTextMessage r0, Message.Type r1, MessageContentEntity r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.messageType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.messageContent;
    L9:
        return r0.copy(r1, r2);
    }

    public final Message.Type component1() {
        return this.messageType;
    }

    public final MessageContentEntity component2() {
        return this.messageContent;
    }

    public final RichTextMessage copy(Message.Type r2, MessageContentEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        Intrinsics.checkNotNullParameter(r3, "messageContent");
        return new RichTextMessage(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RichTextMessage) == true) goto L8;
        return false;
    L8:
        RichTextMessage r6 = (RichTextMessage) r5;
        if (this.messageType == r6.messageType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageContent, r6.messageContent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.messageType.hashCode() * 31) + this.messageContent.hashCode();
    }

    public String toString() {
        return "RichTextMessage(messageType=" + this.messageType + ", messageContent=" + this.messageContent + ')';
    }

    public final MessageContentEntity getMessageContent() {
        return this.messageContent;
    }

    public final Message.Type getMessageType() {
        return this.messageType;
    }

    public final void setMessageType(Message.Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.messageType = r2;
    }

    public RichTextMessage(Message.Type r2, MessageContentEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        Intrinsics.checkNotNullParameter(r3, "messageContent");
        this.messageType = r2;
        this.messageContent = r3;
    }
}
