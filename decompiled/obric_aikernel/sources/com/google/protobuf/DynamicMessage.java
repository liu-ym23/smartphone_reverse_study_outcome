package com.google.protobuf;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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
            int[] r10 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r10;
            r10[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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

        private Builder(Descriptors.Descriptor r10) {
            this.type = r10;
            this.fields = FieldSet.newBuilder();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new Descriptors.FieldDescriptor[r10.toProto().getOneofDeclCount()];
        }

        /* synthetic */ Builder(Descriptors.Descriptor r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ DynamicMessage access$000(Builder r10) {
            return r10.buildParsed();
        }

        private DynamicMessage buildParsed() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r10 = this.type;
            FieldSet<T> r11 = this.fields.build();
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            throw AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(r10, r11, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r12, r12.length), this.unknownFields)).asInvalidProtocolBufferException();
        L5:
            return buildPartial();
        }

        private static Message.Builder toMessageBuilder(Object r10) {
            if ((r10 instanceof Message.Builder) == false) goto L7;
            return (Message.Builder) r10;
        L7:
            if ((r10 instanceof LazyField) == false) goto L10;
            r10 = ((LazyField) r10).getValue();
        L10:
            if ((r10 instanceof Message) == false) goto L14;
            return ((Message) r10).toBuilder();
        L14:
            throw new IllegalArgumentException(String.format("Cannot convert %s to Message.Builder", new Object[]{r10.getClass()}));
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyOneofContainingType(Descriptors.OneofDescriptor r10) {
            if (r10.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private void verifySingularValueType(Descriptors.FieldDescriptor r10, Object r11) {
            int r12 = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r10.getType().ordinal()];
            if (r12 != 1) goto L5;
            Internal.checkNotNull(r11);
            if ((r11 instanceof Descriptors.EnumValueDescriptor) == false) goto L16;
            return;
        L16:
            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        L5:
            if (r12 == 2) goto L8;
            return;
        L8:
            if ((r11 instanceof Message.Builder) == true) goto L11;
            return;
        L11:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r10.getNumber()), r10.getLiteType().getJavaType(), r11.getClass().getName()}));
        }

        private void verifyType(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isRepeated() == false) goto L8;
            Iterator r12 = ((List) r11).iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            verifySingularValueType(r10, r12.next());
            goto L6
        L11:
            return;
        L8:
            verifySingularValueType(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            verifyContainingType(r10);
            verifySingularValueType(r10, r11);
            this.fields.addRepeatedField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage build() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r10 = this.type;
            FieldSet<T> r11 = this.fields.build();
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            throw AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(r10, r11, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r12, r12.length), this.unknownFields));
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
            Iterator<Descriptors.FieldDescriptor> r10 = this.type.getFields().iterator();
        L6:
            if (r10.hasNext() == false) goto L16;
            Descriptors.FieldDescriptor r11 = r10.next();
            if (r11.isOptional() == false) goto L6;
            if (this.fields.hasField(r11) == true) goto L6;
            if (r11.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L14;
            FieldSet.Builder<Descriptors.FieldDescriptor> r12 = this.fields;
            Object r13 = DynamicMessage.getDefaultInstance(r11.getMessageType());
        L15:
            r12.setField(r11, r13);
            goto L6
        L14:
            r12 = this.fields;
            r13 = r11.getDefaultValue();
        L16:
            Descriptors.Descriptor r14 = this.type;
            FieldSet<T> r15 = this.fields.buildPartial();
            Descriptors.FieldDescriptor[] r16 = this.oneofCases;
            return new DynamicMessage(r14, r15, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r16, r16.length), this.unknownFields);
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
        public Builder clearField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            Descriptors.OneofDescriptor r11 = r10.getContainingOneof();
            if (r11 == null) goto L7;
            int r12 = r11.getIndex();
            Descriptors.FieldDescriptor[] r13 = this.oneofCases;
            if (r13[r12] != r10) goto L7;
            r13[r12] = null;
        L7:
            this.fields.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r10) {
            verifyOneofContainingType(r10);
            Descriptors.FieldDescriptor r11 = this.oneofCases[r10.getIndex()];
            if (r11 == null) goto L5;
            clearField(r11);
        L5:
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
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
            Builder r10 = new Builder(this.type);
            r10.fields.mergeFrom(this.fields.build());
            r10.mergeUnknownFields(this.unknownFields);
            Descriptors.FieldDescriptor[] r11 = this.oneofCases;
            System.arraycopy(r11, 0, r10.oneofCases, 0, r11.length);
            return r10;
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
        public /* bridge */ /* synthetic */ Object mo13clone() {
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
        public Object getField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            Object r11 = this.fields.getField(r10);
            if (r11 == null) goto L5;
            return r11;
        L5:
            if (r10.isRepeated() == false) goto L8;
            return Collections.emptyList();
        L8:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return DynamicMessage.getDefaultInstance(r10.getMessageType());
        L11:
            return r10.getDefaultValue();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            if (r10.isMapField() == true) goto L15;
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            Object r11 = this.fields.getFieldAllowBuilders(r10);
            if (r11 != null) goto L9;
            Message.Builder r12 = new Builder(r10.getMessageType());
        L10:
            this.fields.setField(r10, r12);
            return r12;
        L9:
            r12 = toMessageBuilder(r11);
            goto L10
        L13:
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        L15:
            throw new UnsupportedOperationException("Nested builder not supported for map fields.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            verifyOneofContainingType(r10);
            return this.oneofCases[r10.getIndex()];
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            verifyContainingType(r10);
            return this.fields.getRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11) {
            verifyContainingType(r10);
            if (r10.isMapField() == true) goto L11;
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            Message.Builder r12 = toMessageBuilder(this.fields.getRepeatedFieldAllowBuilders(r10, r11));
            this.fields.setRepeatedField(r10, r11, r12);
            return r12;
        L9:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L11:
            throw new UnsupportedOperationException("Map fields cannot be repeated");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            return this.fields.getRepeatedFieldCount(r10);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            return this.fields.hasField(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            verifyOneofContainingType(r10);
            if (this.oneofCases[r10.getIndex()] != null) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r10 = this.type.getFields().iterator();
        L4:
            if (r10.hasNext() == false) goto L12;
            Descriptors.FieldDescriptor r11 = r10.next();
            if (r11.isRequired() == false) goto L4;
            if (this.fields.hasField(r11) == true) goto L4;
            return false;
        L12:
            return this.fields.isInitialized();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof DynamicMessage) == false) goto L22;
            DynamicMessage r11 = (DynamicMessage) r10;
            if (DynamicMessage.access$200(r11) != this.type) goto L20;
            this.fields.mergeFrom(DynamicMessage.access$300(r11));
            mergeUnknownFields(DynamicMessage.access$400(r11));
            int r12 = 0;
        L7:
            Descriptors.FieldDescriptor[] r13 = this.oneofCases;
            if (r12 >= r13.length) goto L18;
            if (r13[r12] != null) goto L13;
            r13[r12] = DynamicMessage.access$500(r11)[r12];
        L17:
            r12 = r12 + 1;
            goto L7
        L13:
            if (DynamicMessage.access$500(r11)[r12] == null) goto L17;
            if (this.oneofCases[r12] == DynamicMessage.access$500(r11)[r12]) goto L17;
            this.fields.clearField(this.oneofCases[r12]);
            this.oneofCases[r12] = DynamicMessage.access$500(r11)[r12];
            goto L17
        L18:
            return this;
        L20:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        L22:
            return (Builder) super.mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeUnknownFields(UnknownFieldSet r10) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(r10).build();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
            return new Builder(r10.getMessageType());
        L7:
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            return newBuilderForField(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            verifyContainingType(r10);
            verifyType(r10, r11);
            Descriptors.OneofDescriptor r12 = r10.getContainingOneof();
            if (r12 == null) goto L10;
            int r13 = r12.getIndex();
            Descriptors.FieldDescriptor r14 = this.oneofCases[r13];
            if (r14 == null) goto L8;
            if (r14 == r10) goto L8;
            this.fields.clearField(r14);
        L8:
            this.oneofCases[r13] = r10;
        L17:
            this.fields.setField(r10, r11);
            return this;
        L10:
            if (r10.hasPresence() == true) goto L17;
            if (r10.isRepeated() == true) goto L17;
            if (r11.equals(r10.getDefaultValue()) == false) goto L17;
            this.fields.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            verifyContainingType(r10);
            verifySingularValueType(r10, r12);
            this.fields.setRepeatedField(r10, r11, r12);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setUnknownFields(UnknownFieldSet r10) {
            this.unknownFields = r10;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }
    }

    DynamicMessage(Descriptors.Descriptor r10, FieldSet<Descriptors.FieldDescriptor> r11, Descriptors.FieldDescriptor[] r12, UnknownFieldSet r13) {
        this.memoizedSize = -1;
        this.type = r10;
        this.fields = r11;
        this.oneofCases = r12;
        this.unknownFields = r13;
    }

    static /* synthetic */ Descriptors.Descriptor access$200(DynamicMessage r10) {
        return r10.type;
    }

    static /* synthetic */ FieldSet access$300(DynamicMessage r10) {
        return r10.fields;
    }

    static /* synthetic */ UnknownFieldSet access$400(DynamicMessage r10) {
        return r10.unknownFields;
    }

    static /* synthetic */ Descriptors.FieldDescriptor[] access$500(DynamicMessage r10) {
        return r10.oneofCases;
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor r10) {
        Descriptors.FieldDescriptor[] r11 = new Descriptors.FieldDescriptor[r10.toProto().getOneofDeclCount()];
        return new DynamicMessage(r10, FieldSet.emptySet(), r11, UnknownFieldSet.getDefaultInstance());
    }

    static boolean isInitialized(Descriptors.Descriptor r10, FieldSet<Descriptors.FieldDescriptor> r11) {
        Iterator<Descriptors.FieldDescriptor> r12 = r10.getFields().iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r13 = r12.next();
        if (r13.isRequired() == false) goto L4;
        if (r11.hasField(r13) == true) goto L4;
        return false;
    L12:
        return r11.isInitialized();
    }

    public static Builder newBuilder(Descriptors.Descriptor r10) {
        return new Builder(r10, null);
    }

    public static Builder newBuilder(Message r10) {
        return new Builder(r10.getDescriptorForType(), null).mergeFrom(r10);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, ByteString r11) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, ByteString r11, ExtensionRegistry r12) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, CodedInputStream r11) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, CodedInputStream r11, ExtensionRegistry r12) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, InputStream r11) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, InputStream r11, ExtensionRegistry r12) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, byte[] r11) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, byte[] r11, ExtensionRegistry r12) {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    private void verifyContainingType(Descriptors.FieldDescriptor r10) {
        if (r10.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void verifyOneofContainingType(Descriptors.OneofDescriptor r10) {
        if (r10.getContainingType() != this.type) goto L6;
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
    public Object getField(Descriptors.FieldDescriptor r10) {
        verifyContainingType(r10);
        Object r11 = this.fields.getField(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        if (r10.isRepeated() == false) goto L8;
        return Collections.emptyList();
    L8:
        if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        return getDefaultInstance(r10.getMessageType());
    L11:
        return r10.getDefaultValue();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
        verifyOneofContainingType(r10);
        return this.oneofCases[r10.getIndex()];
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<DynamicMessage> getParserForType() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
        verifyContainingType(r10);
        return this.fields.getRepeatedField(r10, r11);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
        verifyContainingType(r10);
        return this.fields.getRepeatedFieldCount(r10);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L8;
        int r11 = this.fields.getMessageSetSerializedSize();
        int r12 = this.unknownFields.getSerializedSizeAsMessageSet();
    L9:
        int r13 = r11 + r12;
        this.memoizedSize = r13;
        return r13;
    L8:
        r11 = this.fields.getSerializedSize();
        r12 = this.unknownFields.getSerializedSize();
        goto L9
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r10) {
        verifyContainingType(r10);
        return this.fields.hasField(r10);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r10) {
        verifyOneofContainingType(r10);
        if (this.oneofCases[r10.getIndex()] != null) goto L6;
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
    public void writeTo(CodedOutputStream r10) {
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L5;
        this.fields.writeMessageSetTo(r10);
        this.unknownFields.writeAsMessageSetTo(r10);
        return;
    L5:
        this.fields.writeTo(r10);
        this.unknownFields.writeTo(r10);
    }
}
