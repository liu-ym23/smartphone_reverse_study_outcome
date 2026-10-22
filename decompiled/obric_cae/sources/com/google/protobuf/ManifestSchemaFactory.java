package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = null;
    private final MessageInfoFactory messageInfoFactory;

    /* JADX INFO: renamed from: com.google.protobuf.ManifestSchemaFactory$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$ProtoSyntax = null;

        static {
            int[] r8 = new int[ProtoSyntax.values().length];
            $SwitchMap$com$google$protobuf$ProtoSyntax = r8;
            r8[ProtoSyntax.PROTO3.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        public CompositeMessageInfoFactory(MessageInfoFactory... r8) {
            this.factories = r8;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> r8) {
            MessageInfoFactory[] r10 = this.factories;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            if (r10[r12].isSupported(r8) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> r8) {
            MessageInfoFactory[] r10 = this.factories;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L10;
            MessageInfoFactory r13 = r10[r12];
            if (r13.isSupported(r8) == true) goto L7;
            r12 = r12 + 1;
            goto L3
        L7:
            return r13.messageInfoFor(r8);
        L10:
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(r8.getName()));
        }
    }

    static {
        EMPTY_FACTORY = new AnonymousClass1();
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private static boolean allowExtensions(MessageInfo r8) {
        if (AnonymousClass2.$SwitchMap$com$google$protobuf$ProtoSyntax[r8.getSyntax().ordinal()] == 1) goto L5;
        return true;
    L5:
        return false;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(new MessageInfoFactory[]{GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory()});
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        if (Android.assumeLiteRuntime == true) goto L5;
        int r8 = DescriptorMessageInfoFactory.f5185a;     // Catch: Exception -> L8
        return (MessageInfoFactory) DescriptorMessageInfoFactory.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    L9:
        return EMPTY_FACTORY;
    L5:
        return EMPTY_FACTORY;
    }

    private static <T> Schema<T> newSchema(Class<T> r10, MessageInfo r11) {
        ExtensionSchema<?> r8 = null;
        if (useLiteRuntime(r10) == false) goto L8;
        NewInstanceSchema r12 = NewInstanceSchemas.lite();
        ListFieldSchema r13 = ListFieldSchemas.lite();
        UnknownFieldSchema<?, ?> r14 = SchemaUtil.unknownFieldSetLiteSchema();
        if (allowExtensions(r11) == false) goto L13;
        r8 = ExtensionSchemas.lite();
    L13:
        return MessageSchema.newSchema(r10, r11, r12, r13, r14, r8, MapFieldSchemas.lite());
    L8:
        NewInstanceSchema r15 = NewInstanceSchemas.full();
        ListFieldSchema r16 = ListFieldSchemas.full();
        UnknownFieldSchema<?, ?> r17 = SchemaUtil.unknownFieldSetFullSchema();
        if (allowExtensions(r11) == false) goto L12;
        r8 = ExtensionSchemas.full();
    L12:
        return MessageSchema.newSchema(r10, r11, r15, r16, r17, r8, MapFieldSchemas.full());
    }

    private static boolean useLiteRuntime(Class<?> r8) {
        if (Android.assumeLiteRuntime == false) goto L5;
    L8:
        return true;
    L5:
        if (GeneratedMessageLite.class.isAssignableFrom(r8) == true) goto L8;
        return false;
    }

    @Override // com.google.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> r8) {
        SchemaUtil.requireGeneratedMessage(r8);
        MessageInfo r10 = this.messageInfoFactory.messageInfoFor(r8);
        if (r10.isMessageSetWireFormat() == false) goto L11;
        if (useLiteRuntime(r8) == false) goto L7;
        UnknownFieldSchema<?, ?> r11 = SchemaUtil.unknownFieldSetLiteSchema();
        ExtensionSchema<?> r12 = ExtensionSchemas.lite();
    L9:
        return MessageSetSchema.newSchema(r11, r12, r10.getDefaultInstance());
    L7:
        r11 = SchemaUtil.unknownFieldSetFullSchema();
        r12 = ExtensionSchemas.full();
        goto L9
    L11:
        return newSchema(r8, r10);
    }

    private ManifestSchemaFactory(MessageInfoFactory r8) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(r8, "messageInfoFactory");
    }
}
