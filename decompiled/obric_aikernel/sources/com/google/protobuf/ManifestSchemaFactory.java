package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = null;
    private final MessageInfoFactory messageInfoFactory;

    /* JADX INFO: renamed from: com.google.protobuf.ManifestSchemaFactory$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$ProtoSyntax = null;

        static {
            int[] r10 = new int[ProtoSyntax.values().length];
            $SwitchMap$com$google$protobuf$ProtoSyntax = r10;
            r10[ProtoSyntax.PROTO3.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    private static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        CompositeMessageInfoFactory(MessageInfoFactory... r10) {
            this.factories = r10;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> r10) {
            MessageInfoFactory[] r11 = this.factories;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            if (r11[r13].isSupported(r10) == true) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> r10) {
            MessageInfoFactory[] r11 = this.factories;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            MessageInfoFactory r14 = r11[r13];
            if (r14.isSupported(r10) == true) goto L7;
            r13 = r13 + 1;
            goto L3
        L7:
            return r14.messageInfoFor(r10);
        L10:
            throw new UnsupportedOperationException("No factory is available for message type: " + r10.getName());
        }
    }

    static {
        EMPTY_FACTORY = new AnonymousClass1();
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private ManifestSchemaFactory(MessageInfoFactory r10) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(r10, "messageInfoFactory");
    }

    private static boolean allowExtensions(MessageInfo r10) {
        if (AnonymousClass2.$SwitchMap$com$google$protobuf$ProtoSyntax[r10.getSyntax().ordinal()] == 1) goto L5;
        return true;
    L5:
        return false;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(new MessageInfoFactory[]{GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory()});
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        if (Protobuf.assumeLiteRuntime == true) goto L5;
        int r10 = DescriptorMessageInfoFactory.f4289a;     // Catch: Exception -> L8
        return (MessageInfoFactory) DescriptorMessageInfoFactory.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    L9:
        return EMPTY_FACTORY;
    L5:
        return EMPTY_FACTORY;
    }

    private static <T> Schema<T> newSchema(Class<T> r10, MessageInfo r11) {
        ExtensionSchema<?> r12 = null;
        if (useLiteRuntime(r10) == false) goto L8;
        NewInstanceSchema r13 = NewInstanceSchemas.lite();
        ListFieldSchema r14 = ListFieldSchemas.lite();
        UnknownFieldSchema<?, ?> r15 = SchemaUtil.unknownFieldSetLiteSchema();
        if (allowExtensions(r11) == false) goto L13;
        r12 = ExtensionSchemas.lite();
    L13:
        return MessageSchema.newSchema(r10, r11, r13, r14, r15, r12, MapFieldSchemas.lite());
    L8:
        NewInstanceSchema r16 = NewInstanceSchemas.full();
        ListFieldSchema r17 = ListFieldSchemas.full();
        UnknownFieldSchema<?, ?> r18 = SchemaUtil.unknownFieldSetFullSchema();
        if (allowExtensions(r11) == false) goto L12;
        r12 = ExtensionSchemas.full();
    L12:
        return MessageSchema.newSchema(r10, r11, r16, r17, r18, r12, MapFieldSchemas.full());
    }

    private static boolean useLiteRuntime(Class<?> r10) {
        if (Protobuf.assumeLiteRuntime == false) goto L5;
    L8:
        return true;
    L5:
        if (GeneratedMessageLite.class.isAssignableFrom(r10) == true) goto L8;
        return false;
    }

    @Override // com.google.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> r10) {
        SchemaUtil.requireGeneratedMessage(r10);
        MessageInfo r11 = this.messageInfoFactory.messageInfoFor(r10);
        if (r11.isMessageSetWireFormat() == false) goto L11;
        if (useLiteRuntime(r10) == false) goto L7;
        UnknownFieldSchema<?, ?> r12 = SchemaUtil.unknownFieldSetLiteSchema();
        ExtensionSchema<?> r13 = ExtensionSchemas.lite();
    L9:
        return MessageSetSchema.newSchema(r12, r13, r11.getDefaultInstance());
    L7:
        r12 = SchemaUtil.unknownFieldSetFullSchema();
        r13 = ExtensionSchemas.full();
        goto L9
    L11:
        return newSchema(r10, r11);
    }
}
