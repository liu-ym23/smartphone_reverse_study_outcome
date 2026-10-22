package com.ss.android.lark.ka.message.api.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MessageInfo {
    private String channelId;
    private String key;
    private final String messageId;
    private String mime;
    private String name;
    private final long size;
    private final MessageType type;

    /* JADX INFO: renamed from: com.ss.android.lark.ka.message.api.model.MessageInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private String channelId;
        private String key;
        private String messageId;
        private String mime;
        private String name;
        private long size;
        private MessageType type;

        public MessageInfo build() {
            return new MessageInfo(this, null);
        }

        public Builder() {
        }

        public static /* synthetic */ String access$000(Builder r0) {
            return r0.key;
        }

        public static /* synthetic */ String access$100(Builder r0) {
            return r0.messageId;
        }

        public static /* synthetic */ String access$200(Builder r0) {
            return r0.channelId;
        }

        public static /* synthetic */ MessageType access$300(Builder r0) {
            return r0.type;
        }

        public static /* synthetic */ String access$400(Builder r0) {
            return r0.name;
        }

        public static /* synthetic */ long access$500(Builder r2) {
            return r2.size;
        }

        public static /* synthetic */ String access$600(Builder r0) {
            return r0.mime;
        }

        public Builder channelId(String r1) {
            this.channelId = r1;
            return this;
        }

        public Builder key(String r1) {
            this.key = r1;
            return this;
        }

        public Builder messageId(String r1) {
            this.messageId = r1;
            return this;
        }

        public Builder mime(String r1) {
            this.mime = r1;
            return this;
        }

        public Builder name(String r1) {
            this.name = r1;
            return this;
        }

        public Builder size(long r1) {
            this.size = r1;
            return this;
        }

        public Builder type(MessageType r1) {
            this.type = r1;
            return this;
        }
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMime() {
        return this.mime;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public MessageType getType() {
        return this.type;
    }

    private MessageInfo(Builder r3) {
        if (Builder.access$000(r3) == null) goto L6;
        this.key = Builder.access$000(r3);
    L6:
        if (Builder.access$100(r3) == null) goto L22;
        this.messageId = Builder.access$100(r3);
        if (Builder.access$200(r3) == null) goto L11;
        this.channelId = Builder.access$200(r3);
    L11:
        if (Builder.access$300(r3) == null) goto L20;
        this.type = Builder.access$300(r3);
        if (Builder.access$400(r3) == null) goto L15;
        this.name = Builder.access$400(r3);
    L15:
        this.size = Builder.access$500(r3);
        if (Builder.access$600(r3) == null) goto L23;
        this.mime = Builder.access$600(r3);
        return;
    L23:
        return;
    L20:
        throw new IllegalStateException("type is null");
    L22:
        throw new IllegalStateException("messageId is null");
    }

    public /* synthetic */ MessageInfo(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
