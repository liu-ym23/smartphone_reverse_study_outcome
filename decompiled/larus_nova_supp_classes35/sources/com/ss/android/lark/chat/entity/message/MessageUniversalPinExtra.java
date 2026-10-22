package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageUniversalPinExtra;", "Lcom/ss/android/lark/chat/entity/message/UniversalPinExtra;", "messageId", BuildConfig.FLAVOR, "pinId", "pinChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "<init>", "(JLjava/lang/Long;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;)V", "getMessageId", "()J", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageUniversalPinExtra extends UniversalPinExtra {
    private final long messageId;

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public String toString() {
        return "MessageUniversalPinExtra(messageId = " + this.messageId + ", " + super.toString() + ')';
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public boolean isContentSame(UniversalPinExtra r7) {
        if ((r7 instanceof MessageUniversalPinExtra) == true) goto L6;
        return false;
    L6:
        if (this.messageId == ((MessageUniversalPinExtra) r7).messageId) goto L9;
        return false;
    L9:
        return super.isContentSame(r7);
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public boolean isItemSame(UniversalPinExtra r2) {
        if ((r2 instanceof MessageUniversalPinExtra) == true) goto L7;
        return false;
    L7:
        return super.isItemSame(r2);
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UniversalPinExtra) r1);
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UniversalPinExtra) r1);
    }

    public MessageUniversalPinExtra(long r2, Long r4, ChatChatter r5) {
        super(r4, r5, UniversalPinExtraType.MESSAGE_PIN);
        this.messageId = r2;
    }
}
