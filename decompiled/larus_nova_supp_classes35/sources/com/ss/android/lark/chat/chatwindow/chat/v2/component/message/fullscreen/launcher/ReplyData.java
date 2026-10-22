package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import android.os.Bundle;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyData;", "Ljava/io/Serializable;", "messageId", BuildConfig.FLAVOR, "replyType", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;", "partialReplyInfo", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;)V", "getMessageId", "()Ljava/lang/String;", "getReplyType", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;", "getPartialReplyInfo", "()Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "toBundle", "Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyData implements Serializable {
    public static final a Companion = null;
    public static final String KEY_MESSAGE_ID = "key_msg_id";
    public static final String KEY_PARTIAL_REPLY_INFO = "key_reply_partial_info";
    public static final String KEY_REPLY_TYPE = "key_reply_type";
    private final String messageId;
    private final PartialReplyInfo partialReplyInfo;
    private final ReplyType replyType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ReplyData copy$default(ReplyData r0, String r1, ReplyType r2, PartialReplyInfo r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.messageId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.replyType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.partialReplyInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.messageId;
    }

    public final ReplyType component2() {
        return this.replyType;
    }

    public final PartialReplyInfo component3() {
        return this.partialReplyInfo;
    }

    public final ReplyData copy(String r2, ReplyType r3, PartialReplyInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "replyType");
        return new ReplyData(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReplyData) == true) goto L8;
        return false;
    L8:
        ReplyData r6 = (ReplyData) r5;
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L12;
        return false;
    L12:
        if (this.replyType == r6.replyType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.partialReplyInfo, r6.partialReplyInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.messageId.hashCode() * 31) + this.replyType.hashCode()) * 31;
        PartialReplyInfo r1 = this.partialReplyInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ReplyData(messageId=" + this.messageId + ", replyType=" + this.replyType + ", partialReplyInfo=" + this.partialReplyInfo + ')';
    }

    public final Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putString(KEY_MESSAGE_ID, this.messageId);
        r0.putInt(KEY_REPLY_TYPE, this.replyType.getValue());
        PartialReplyInfo r1 = this.partialReplyInfo;
        if (r1 == null) goto L5;
        r0.putSerializable(KEY_PARTIAL_REPLY_INFO, r1);
    L5:
        return r0;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final PartialReplyInfo getPartialReplyInfo() {
        return this.partialReplyInfo;
    }

    public final ReplyType getReplyType() {
        return this.replyType;
    }

    @JvmStatic
    public static final ReplyData fromBundle(Bundle r5) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r0 = r5.getString(KEY_MESSAGE_ID);
        ReplyType.a r1 = ReplyType.Companion;
        int r2 = r5.getInt(KEY_REPLY_TYPE);
        r1.getClass();
        ReplyType r3 = ReplyType.REPLY_NORMAL;
        if (r2 == r3.getValue()) goto L8;
        ReplyType r4 = ReplyType.REPLY_PARTIAL;
        if (r2 != r4.getValue()) goto L8;
        r3 = r4;
    L8:
        Serializable r6 = r5.getSerializable(KEY_PARTIAL_REPLY_INFO);
        if ((r6 instanceof PartialReplyInfo) == false) goto L11;
        PartialReplyInfo r7 = (PartialReplyInfo) r6;
    L12:
        if (r0 != null) goto L15;
        return null;
    L15:
        return new ReplyData(r0, r3, r7);
    L11:
        r7 = null;
        goto L12
    }

    public ReplyData(String r2, ReplyType r3, PartialReplyInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "replyType");
        this.messageId = r2;
        this.replyType = r3;
        this.partialReplyInfo = r4;
    }

    public /* synthetic */ ReplyData(String r1, ReplyType r2, PartialReplyInfo r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
