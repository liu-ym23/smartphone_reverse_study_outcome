package com.ss.android.lark.chat.entity.message.content;

import com.bytedance.lark.pb.basic.v1.TodoOperationContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/TodoContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "messageType", "Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;", "getMessageType", "()Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;", "setMessageType", "(Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;)V", "cardContentData", "Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent;", "getCardContentData", "()Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent;", "setCardContentData", "(Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent;)V", "TodoMessageType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoContent extends Content {
    private TodoOperationContent cardContentData;
    private TodoMessageType messageType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/TodoContent$TodoMessageType;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "TODO_MESSAGE_CARD", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TodoMessageType extends Enum<TodoMessageType> {
        public static final a Companion = null;
        public static final TodoMessageType TODO_MESSAGE_CARD = null;
        public static final TodoMessageType UNKNOWN = null;
        public static final /* synthetic */ TodoMessageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TodoMessageType> getEntries() {
            return b;
        }

        static {
            TodoMessageType r0 = new TodoMessageType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TodoMessageType r1 = new TodoMessageType("TODO_MESSAGE_CARD", 1, 1);
            TODO_MESSAGE_CARD = r1;
            TodoMessageType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static TodoMessageType[] values() {
            return (TodoMessageType[]) a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static TodoMessageType valueOf(String r1) {
            return (TodoMessageType) r27.a.a(TodoMessageType.class, r1);
        }

        public TodoMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    public TodoContent() {
        this.messageType = TodoMessageType.UNKNOWN;
    }

    public final TodoOperationContent getCardContentData() {
        return this.cardContentData;
    }

    public final TodoMessageType getMessageType() {
        return this.messageType;
    }

    public final void setCardContentData(TodoOperationContent r1) {
        this.cardContentData = r1;
    }

    public final void setMessageType(TodoMessageType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.messageType = r2;
    }
}
