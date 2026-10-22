package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = null;
    private final MessageInfoFactory messageInfoFactory;

    /* JADX INFO: renamed from: com.google.protobuf.ManifestSchemaFactory$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$ProtoSyntax = null;

        static {
            int[] r0 = new int[ProtoSyntax.values().length];
            $SwitchMap$com$google$protobuf$ProtoSyntax = r0;
            r0[ProtoSyntax.PROTO3.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    private static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        CompositeMessageInfoFactory(MessageInfoFactory... r1) {
            this.factories = r1;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> r5) {
            MessageInfoFactory[] r4 = this.factories;
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (r4[r2].isSupported(r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> r5) {
            MessageInfoFactory[] r4 = this.factories;
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            MessageInfoFactory r2 = r4[r1];
            if (r2.isSupported(r5) == true) goto L7;
            r1 = r1 + 1;
            goto L3
        L7:
            return r2.messageInfoFor(r5);
        L10:
            throw new UnsupportedOperationException("No factory is available for message type: " + r5.getName());
        }
    }

    static {
        EMPTY_FACTORY = new AnonymousClass1();
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private ManifestSchemaFactory(MessageInfoFactory r3) {
        this.messageInfoFactory = (MessageInfoFactory) ZeusTransformUtils.preCheckCast(Internal.checkNotNull((MessageInfoFactory) ZeusTransformUtils.wrapperContextForParams(r3, MessageInfoFactory.class, "com.obric.memorydata.plugin"), "messageInfoFactory"), MessageInfoFactory.class, "com.obric.memorydata.plugin");
    }

    private static boolean allowExtensions(MessageInfo r2) {
        MessageInfo r3 = (MessageInfo) ZeusTransformUtils.wrapperContextForParams(r2, MessageInfo.class, "com.obric.memorydata.plugin");
        if (AnonymousClass2.$SwitchMap$com$google$protobuf$ProtoSyntax[r3.getSyntax().ordinal()] == 1) goto L5;
        return true;
    L5:
        return false;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(new MessageInfoFactory[]{GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory()});
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        if (Protobuf.assumeLiteRuntime == true) goto L5;
        return (MessageInfoFactory) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.google.protobuf.DescriptorMessageInfoFactory", "com.obric.memorydata.plugin").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), MessageInfoFactory.class, "com.obric.memorydata.plugin");
    L9:
        return EMPTY_FACTORY;
    L5:
        return EMPTY_FACTORY;
    }

    private static <T> Schema<T> newSchema(Class<T> r7, MessageInfo r8) {
        MessageInfo r1 = (MessageInfo) ZeusTransformUtils.wrapperContextForParams(r8, MessageInfo.class, "com.obric.memorydata.plugin");
        if (useLiteRuntime(r7) == false) goto L9;
        NewInstanceSchema r2 = NewInstanceSchemas.lite();
        ListFieldSchema r3 = ListFieldSchemas.lite();
        UnknownFieldSchema<?, ?> r4 = SchemaUtil.unknownFieldSetLiteSchema();
        if (allowExtensions(r1) == false) goto L7;
        ExtensionSchema<?> r5 = ExtensionSchemas.lite();
    L8:
        MapFieldSchema r6 = MapFieldSchemas.lite();
    L15:
        return MessageSchema.newSchema(r7, r1, r2, r3, r4, r5, r6);
    L7:
        r5 = null;
        goto L8
    L9:
        r2 = NewInstanceSchemas.full();
        r3 = ListFieldSchemas.full();
        r4 = SchemaUtil.unknownFieldSetFullSchema();
        if (allowExtensions(r1) == false) goto L12;
        r5 = ExtensionSchemas.full();
    L13:
        r6 = MapFieldSchemas.full();
        goto L15
    L12:
        r5 = null;
        goto L13
    }

    private static boolean useLiteRuntime(Class<?> r1) {
        if (Protobuf.assumeLiteRuntime == false) goto L5;
    L8:
        return true;
    L5:
        if (GeneratedMessageLite.class.isAssignableFrom(r1) == true) goto L8;
        return false;
    }

    @Override // com.google.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> r2) {
        SchemaUtil.requireGeneratedMessage(r2);
        MessageInfo r1 = this.messageInfoFactory.messageInfoFor(r2);
        if (r1.isMessageSetWireFormat() == false) goto L11;
        if (useLiteRuntime(r2) == false) goto L7;
        UnknownFieldSchema<?, ?> r3 = SchemaUtil.unknownFieldSetLiteSchema();
        ExtensionSchema<?> r0 = ExtensionSchemas.lite();
    L9:
        return MessageSetSchema.newSchema(r3, r0, r1.getDefaultInstance());
    L7:
        r3 = SchemaUtil.unknownFieldSetFullSchema();
        r0 = ExtensionSchemas.full();
        goto L9
    L11:
        return newSchema(r2, r1);
    }
}
