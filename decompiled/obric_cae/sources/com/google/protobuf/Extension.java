package com.google.protobuf;

import com.google.protobuf.MessageLite;

/* JADX INFO: loaded from: classes.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    public static final enum ExtensionType extends java.lang.Enum<ExtensionType> {
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

        private ExtensionType(String r8, int r10) {
            super(r8, r10);
        }

        public static ExtensionType valueOf(String r8) {
            return (ExtensionType) java.lang.Enum.valueOf(ExtensionType.class, r8);
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

        private MessageType(String r8, int r10) {
            super(r8, r10);
        }

        public static MessageType valueOf(String r8) {
            return (MessageType) java.lang.Enum.valueOf(MessageType.class, r8);
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }
    }

    public Extension() {
    }

    public abstract Object fromReflectionType(Object r8);

    public abstract Descriptors.FieldDescriptor getDescriptor();

    public abstract ExtensionType getExtensionType();

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
    public final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object r8);

    public abstract Object singularToReflectionType(Object r8);

    public abstract Object toReflectionType(Object r8);
}
