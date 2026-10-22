package com.ss.android.lark.chat.api.chatpreview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "Ljava/io/Serializable;", "<init>", "()V", "ID", "NoneChat", "UnloadChat", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId$ID;", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId$NoneChat;", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId$UnloadChat;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChatId implements Serializable {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/api/chatpreview/ChatId$ID;", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "id", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ID extends ChatId {
        private final String id;

        public final String getId() {
            return this.id;
        }

        public ID(String r2) {
            Intrinsics.checkNotNullParameter(r2, "id");
            super(null);
            this.id = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/chat/api/chatpreview/ChatId$NoneChat;", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "<init>", "()V", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NoneChat extends ChatId {
        public static final NoneChat INSTANCE = null;

        static {
            INSTANCE = new NoneChat();
        }

        private NoneChat() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/chat/api/chatpreview/ChatId$UnloadChat;", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "<init>", "()V", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UnloadChat extends ChatId {
        public static final UnloadChat INSTANCE = null;

        static {
            INSTANCE = new UnloadChat();
        }

        private UnloadChat() {
            super(null);
        }
    }

    private ChatId() {
    }

    public /* synthetic */ ChatId(DefaultConstructorMarker r1) {
        this();
    }
}
