package com.google.protobuf;

import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    protected static final enum ExtensionType extends java.lang.Enum<ExtensionType> {
        private static final /* synthetic */ ExtensionType[] $VALUES = null;
        public static final ExtensionType IMMUTABLE = null;
        public static final ExtensionType MUTABLE = null;
        public static final ExtensionType PROTO1 = null;

        private static /* synthetic */ ExtensionType[] $values() {
            return new ExtensionType[]{IMMUTABLE, MUTABLE, PROTO1};
        }

        static {
            IMMUTABLE = new ExtensionType("IMMUTABLE", 0);
            MUTABLE = new ExtensionType("MUTABLE", 1);
            PROTO1 = new ExtensionType("PROTO1", 2);
            $VALUES = $values();
        }

        private ExtensionType(String r10, int r11) {
            super(r10, r11);
        }

        public static ExtensionType valueOf(String r10) {
            return (ExtensionType) java.lang.Enum.valueOf(ExtensionType.class, r10);
        }

        public static ExtensionType[] values() {
            return (ExtensionType[]) $VALUES.clone();
        }
    }

    public static final enum MessageType extends java.lang.Enum<MessageType> {
        private static final /* synthetic */ MessageType[] $VALUES = null;
        public static final MessageType PROTO1 = null;
        public static final MessageType PROTO2 = null;

        private static /* synthetic */ MessageType[] $values() {
            return new MessageType[]{PROTO1, PROTO2};
        }

        static {
            PROTO1 = new MessageType("PROTO1", 0);
            PROTO2 = new MessageType("PROTO2", 1);
            $VALUES = $values();
        }

        private MessageType(String r10, int r11) {
            super(r10, r11);
        }

        public static MessageType valueOf(String r10) {
            return (MessageType) java.lang.Enum.valueOf(MessageType.class, r10);
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }
    }

    public Extension() {
    }

    protected abstract Object fromReflectionType(Object r10);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    protected abstract ExtensionType getExtensionType();

    @Override // com.google.protobuf.ExtensionLite
    public abstract Message getMessageDefaultInstance();

    @Override // com.google.protobuf.ExtensionLite
    public /* bridge */ /* synthetic */ MessageLite getMessageDefaultInstance() {
        return getMessageDefaultInstance();
    }

    public MessageType getMessageType() {
        return MessageType.PROTO2;
    }

    @Override // com.google.protobuf.ExtensionLite
    final boolean isLite() {
        return false;
    }

    protected abstract Object singularFromReflectionType(Object r10);

    protected abstract Object singularToReflectionType(Object r10);

    protected abstract Object toReflectionType(Object r10);
}
