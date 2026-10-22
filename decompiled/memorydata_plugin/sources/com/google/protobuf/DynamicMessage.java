package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class DynamicMessage extends AbstractMessage {
    private final FieldSet<Descriptors.FieldDescriptor> fields;
    private int memoizedSize;
    private final Descriptors.FieldDescriptor[] oneofCases;
    private final Descriptors.Descriptor type;
    private final UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.DynamicMessage$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r0 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0;
            r0[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class Builder extends AbstractMessage.Builder<Builder> {
        private FieldSet.Builder<Descriptors.FieldDescriptor> fields;
        private final Descriptors.FieldDescriptor[] oneofCases;
        private final Descriptors.Descriptor type;
        private UnknownFieldSet unknownFields;

        private Builder(Descriptors.Descriptor r2) {
            this.type = r2;
            this.fields = FieldSet.newBuilder();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new Descriptors.FieldDescriptor[r2.toProto().getOneofDeclCount()];
        }

        /* synthetic */ Builder(Descriptors.Descriptor r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ DynamicMessage access$000(Builder r0) {
            return r0.buildParsed();
        }

        private DynamicMessage buildParsed() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r1 = this.type;
            FieldSet<T> r2 = this.fields.build();
            Descriptors.FieldDescriptor[] r3 = this.oneofCases;
            throw newUninitializedMessageException(new DynamicMessage(r1, r2, (Descriptors.FieldDescriptor[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), Descriptors.FieldDescriptor[].class, "com.obric.memorydata.plugin"), this.unknownFields)).asInvalidProtocolBufferException();
        L5:
            return buildPartial();
        }

        private static Message.Builder toMessageBuilder(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Message.Builder.class) == false) goto L7;
            return (Message.Builder) ZeusTransformUtils.preCheckCast(r3, Message.Builder.class, "com.obric.memorydata.plugin");
        L7:
            if (ZeusTransformUtils.instanceOf(r3, LazyField.class) == false) goto L10;
            r3 = ((LazyField) ZeusTransformUtils.preCheckCast(r3, LazyField.class, "com.obric.memorydata.plugin")).getValue();
        L10:
            if (ZeusTransformUtils.instanceOf(r3, Message.class) == false) goto L14;
            return ((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.memorydata.plugin")).toBuilder();
        L14:
            throw new IllegalArgumentException(String.format("Cannot convert %s to Message.Builder", new Object[]{r3.getClass()}));
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r1) {
            if (r1.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyOneofContainingType(Descriptors.OneofDescriptor r1) {
            if (r1.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private void verifySingularValueType(Descriptors.FieldDescriptor r6, Object r7) {
            int r5 = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r6.getType().ordinal()];
            if (r5 != 1) goto L5;
            Internal.checkNotNull(r7);
            if (ZeusTransformUtils.instanceOf(r7, Descriptors.EnumValueDescriptor.class) == false) goto L16;
            return;
        L16:
            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        L5:
            if (r5 == 2) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r7, Message.Builder.class) == true) goto L11;
            return;
        L11:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r6.getNumber()), r6.getLiteType().getJavaType(), r7.getClass().getName()}));
        }

        private void verifyType(Descriptors.FieldDescriptor r3, Object r4) {
            if (r3.isRepeated() == false) goto L8;
            Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        L6:
            if (r5.hasNext() == false) goto L11;
            verifySingularValueType(r3, r5.next());
            goto L6
        L11:
            return;
        L8:
            verifySingularValueType(r3, r4);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r2, Object r3) {
            verifyContainingType(r2);
            verifySingularValueType(r2, r3);
            this.fields.addRepeatedField(r2, r3);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage build() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r1 = this.type;
            FieldSet<T> r2 = this.fields.build();
            Descriptors.FieldDescriptor[] r3 = this.oneofCases;
            throw newUninitializedMessageException(new DynamicMessage(r1, r2, (Descriptors.FieldDescriptor[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), Descriptors.FieldDescriptor[].class, "com.obric.memorydata.plugin"), this.unknownFields));
        L5:
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage buildPartial() {
            if (this.type.getOptions().getMapEntry() == false) goto L16;
            Iterator<Descriptors.FieldDescriptor> r0 = this.type.getFields().iterator();
        L6:
            if (r0.hasNext() == false) goto L16;
            Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
            if (r2.isOptional() == false) goto L6;
            if (this.fields.hasField(r2) == true) goto L6;
            if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L14;
            FieldSet.Builder<Descriptors.FieldDescriptor> r3 = this.fields;
            Object r4 = DynamicMessage.getDefaultInstance(r2.getMessageType());
        L15:
            r3.setField(r2, r4);
            goto L6
        L14:
            r3 = this.fields;
            r4 = r2.getDefaultValue();
        L16:
            Descriptors.Descriptor r5 = this.type;
            FieldSet<T> r6 = this.fields.buildPartial();
            Descriptors.FieldDescriptor[] r7 = this.oneofCases;
            return new DynamicMessage(r5, r6, (Descriptors.FieldDescriptor[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), Descriptors.FieldDescriptor[].class, "com.obric.memorydata.plugin"), this.unknownFields);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            this.fields = FieldSet.newBuilder();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r4) {
            verifyContainingType(r4);
            Descriptors.OneofDescriptor r0 = r4.getContainingOneof();
            if (r0 == null) goto L7;
            int r1 = r0.getIndex();
            Descriptors.FieldDescriptor[] r2 = this.oneofCases;
            if (r2[r1] != r4) goto L7;
            r2[r1] = null;
        L7:
            this.fields.clearField(r4);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r2) {
            verifyOneofContainingType(r2);
            Descriptors.FieldDescriptor r3 = this.oneofCases[r2.getIndex()];
            if (r3 == null) goto L5;
            clearField(r3);
        L5:
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder r0 = new Builder(this.type);
            r0.fields.mergeFrom(this.fields.build());
            r0.mergeUnknownFields(this.unknownFields);
            Descriptors.FieldDescriptor[] r4 = this.oneofCases;
            System.arraycopy(r4, 0, r0.oneofCases, 0, r4.length);
            return r0;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo141clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r2) {
            verifyContainingType(r2);
            Object r1 = this.fields.getField(r2);
            if (r1 == null) goto L5;
            return r1;
        L5:
            if (r2.isRepeated() == false) goto L8;
            return Collections.emptyList();
        L8:
            if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return DynamicMessage.getDefaultInstance(r2.getMessageType());
        L11:
            return r2.getDefaultValue();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r3) {
            verifyContainingType(r3);
            if (r3.isMapField() == true) goto L15;
            if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            Object r0 = this.fields.getFieldAllowBuilders(r3);
            if (r0 != null) goto L9;
            Message.Builder r1 = new Builder(r3.getMessageType());
        L10:
            this.fields.setField(r3, r1);
            return r1;
        L9:
            r1 = toMessageBuilder(r0);
            goto L10
        L13:
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        L15:
            throw new UnsupportedOperationException("Nested builder not supported for map fields.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
            verifyOneofContainingType(r1);
            return this.oneofCases[r1.getIndex()];
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r1, int r2) {
            verifyContainingType(r1);
            return this.fields.getRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r3, int r4) {
            verifyContainingType(r3);
            if (r3.isMapField() == true) goto L11;
            if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            Message.Builder r0 = toMessageBuilder(this.fields.getRepeatedFieldAllowBuilders(r3, r4));
            this.fields.setRepeatedField(r3, r4, r0);
            return r0;
        L9:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L11:
            throw new UnsupportedOperationException("Map fields cannot be repeated");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r1) {
            verifyContainingType(r1);
            return this.fields.getRepeatedFieldCount(r1);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r1) {
            verifyContainingType(r1);
            return this.fields.hasField(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r1) {
            verifyOneofContainingType(r1);
            if (this.oneofCases[r1.getIndex()] != null) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r0 = this.type.getFields().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            Descriptors.FieldDescriptor r1 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
            if (r1.isRequired() == false) goto L4;
            if (this.fields.hasField(r1) == true) goto L4;
            return false;
        L12:
            return this.fields.isInitialized();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r4) {
            Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, DynamicMessage.class) == false) goto L22;
            DynamicMessage r6 = (DynamicMessage) ZeusTransformUtils.preCheckCast(r5, DynamicMessage.class, "com.obric.memorydata.plugin");
            if (DynamicMessage.access$200(r6) != this.type) goto L20;
            this.fields.mergeFrom(DynamicMessage.access$300(r6));
            mergeUnknownFields(DynamicMessage.access$400(r6));
            int r0 = 0;
        L7:
            Descriptors.FieldDescriptor[] r1 = this.oneofCases;
            if (r0 >= r1.length) goto L18;
            if (r1[r0] != null) goto L13;
            r1[r0] = DynamicMessage.access$500(r6)[r0];
        L17:
            r0 = r0 + 1;
            goto L7
        L13:
            if (DynamicMessage.access$500(r6)[r0] == null) goto L17;
            if (this.oneofCases[r0] == DynamicMessage.access$500(r6)[r0]) goto L17;
            this.fields.clearField(this.oneofCases[r0]);
            this.oneofCases[r0] = DynamicMessage.access$500(r6)[r0];
            goto L17
        L18:
            return this;
        L20:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        L22:
            return (Builder) ZeusTransformUtils.preCheckCast(super.mergeFrom(r5), Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeUnknownFields(UnknownFieldSet r2) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(r2).build();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder newBuilderForField(Descriptors.FieldDescriptor r2) {
            verifyContainingType(r2);
            if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
            return new Builder(r2.getMessageType());
        L7:
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForField(Descriptors.FieldDescriptor r1) {
            return newBuilderForField(r1);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r4, Object r5) {
            verifyContainingType(r4);
            verifyType(r4, r5);
            Descriptors.OneofDescriptor r0 = r4.getContainingOneof();
            if (r0 == null) goto L10;
            int r1 = r0.getIndex();
            Descriptors.FieldDescriptor r2 = this.oneofCases[r1];
            if (r2 == null) goto L8;
            if (r2 == r4) goto L8;
            this.fields.clearField(r2);
        L8:
            this.oneofCases[r1] = r4;
        L17:
            this.fields.setField(r4, r5);
            return this;
        L10:
            if (r4.hasPresence() == true) goto L17;
            if (r4.isRepeated() == true) goto L17;
            if (r5.equals(r4.getDefaultValue()) == false) goto L17;
            this.fields.clearField(r4);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r2, int r3, Object r4) {
            verifyContainingType(r2);
            verifySingularValueType(r2, r4);
            this.fields.setRepeatedField(r2, r3, r4);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setUnknownFields(UnknownFieldSet r1) {
            this.unknownFields = r1;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }
    }

    DynamicMessage(Descriptors.Descriptor r2, FieldSet<Descriptors.FieldDescriptor> r3, Descriptors.FieldDescriptor[] r4, UnknownFieldSet r5) {
        this.memoizedSize = -1;
        this.type = r2;
        this.fields = r3;
        this.oneofCases = r4;
        this.unknownFields = r5;
    }

    static /* synthetic */ Descriptors.Descriptor access$200(DynamicMessage r0) {
        return r0.type;
    }

    static /* synthetic */ FieldSet access$300(DynamicMessage r0) {
        return r0.fields;
    }

    static /* synthetic */ UnknownFieldSet access$400(DynamicMessage r0) {
        return r0.unknownFields;
    }

    static /* synthetic */ Descriptors.FieldDescriptor[] access$500(DynamicMessage r0) {
        return r0.oneofCases;
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor r4) {
        Descriptors.FieldDescriptor[] r0 = new Descriptors.FieldDescriptor[r4.toProto().getOneofDeclCount()];
        return new DynamicMessage(r4, FieldSet.emptySet(), r0, UnknownFieldSet.getDefaultInstance());
    }

    static boolean isInitialized(Descriptors.Descriptor r3, FieldSet<Descriptors.FieldDescriptor> r4) {
        Iterator<Descriptors.FieldDescriptor> r5 = r3.getFields().iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r0 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r5.next(), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin");
        if (r0.isRequired() == false) goto L4;
        if (r4.hasField(r0) == true) goto L4;
        return false;
    L12:
        return r4.isInitialized();
    }

    public static Builder newBuilder(Descriptors.Descriptor r2) {
        return new Builder(r2, null);
    }

    public static Builder newBuilder(Message r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
        return new Builder(r4.getDescriptorForType(), null).mergeFrom(r4);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r1, ByteString r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r1).mergeFrom(r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r0, ByteString r1, ExtensionRegistry r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r0).mergeFrom(r1, r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r1, CodedInputStream r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r1).mergeFrom(r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r0, CodedInputStream r1, ExtensionRegistry r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r0).mergeFrom(r1, r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r1, InputStream r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r1).mergeFrom(r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r0, InputStream r1, ExtensionRegistry r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r0).mergeFrom(r1, r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r1, byte[] r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r1).mergeFrom(r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r0, byte[] r1, ExtensionRegistry r2) {
        return Builder.access$000((Builder) ZeusTransformUtils.preCheckCast(newBuilder(r0).mergeFrom(r1, r2), Builder.class, "com.obric.memorydata.plugin"));
    }

    private void verifyContainingType(Descriptors.FieldDescriptor r1) {
        if (r1.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void verifyOneofContainingType(Descriptors.OneofDescriptor r1) {
        if (r1.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r2) {
        verifyContainingType(r2);
        Object r1 = this.fields.getField(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (r2.isRepeated() == false) goto L8;
        return Collections.emptyList();
    L8:
        if (r2.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        return getDefaultInstance(r2.getMessageType());
    L11:
        return r2.getDefaultValue();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r1) {
        verifyOneofContainingType(r1);
        return this.oneofCases[r1.getIndex()];
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<DynamicMessage> getParserForType() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r1, int r2) {
        verifyContainingType(r1);
        return this.fields.getRepeatedField(r1, r2);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r1) {
        verifyContainingType(r1);
        return this.fields.getRepeatedFieldCount(r1);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L8;
        int r1 = this.fields.getMessageSetSerializedSize();
        int r2 = this.unknownFields.getSerializedSizeAsMessageSet();
    L9:
        int r3 = r1 + r2;
        this.memoizedSize = r3;
        return r3;
    L8:
        r1 = this.fields.getSerializedSize();
        r2 = this.unknownFields.getSerializedSize();
        goto L9
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r1) {
        verifyContainingType(r1);
        return this.fields.hasField(r1);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r1) {
        verifyOneofContainingType(r1);
        if (this.oneofCases[r1.getIndex()] != null) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return new Builder(this.type, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r2) {
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L5;
        this.fields.writeMessageSetTo(r2);
        this.unknownFields.writeAsMessageSetTo(r2);
        return;
    L5:
        this.fields.writeTo(r2);
        this.unknownFields.writeTo(r2);
    }
}
