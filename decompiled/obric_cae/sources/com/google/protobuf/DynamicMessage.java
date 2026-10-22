package com.google.protobuf;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DynamicMessage extends AbstractMessage {
    private final FieldSet<Descriptors.FieldDescriptor> fields;
    private int memoizedSize;
    private final Descriptors.FieldDescriptor[] oneofCases;
    private final Descriptors.Descriptor type;
    private final UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.DynamicMessage$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r8 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r8;
            r8[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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

        private Builder(Descriptors.Descriptor r8) {
            this.type = r8;
            this.fields = FieldSet.newBuilder();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new Descriptors.FieldDescriptor[r8.toProto().getOneofDeclCount()];
        }

        public static /* synthetic */ DynamicMessage access$000(Builder r8) {
            return r8.buildParsed();
        }

        private DynamicMessage buildParsed() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r8 = this.type;
            FieldSet<T> r10 = this.fields.build();
            Descriptors.FieldDescriptor[] r11 = this.oneofCases;
            throw AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(r8, r10, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r11, r11.length), this.unknownFields)).asInvalidProtocolBufferException();
        L5:
            return buildPartial();
        }

        private static Message.Builder toMessageBuilder(Object r8) {
            if ((r8 instanceof Message.Builder) == false) goto L7;
            return (Message.Builder) r8;
        L7:
            if ((r8 instanceof LazyField) == false) goto L10;
            r8 = ((LazyField) r8).getValue();
        L10:
            if ((r8 instanceof Message) == false) goto L14;
            return ((Message) r8).toBuilder();
        L14:
            throw new IllegalArgumentException(String.format("Cannot convert %s to Message.Builder", new Object[]{r8.getClass()}));
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r8) {
            if (r8.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyOneofContainingType(Descriptors.OneofDescriptor r8) {
            if (r8.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private void verifySingularValueType(Descriptors.FieldDescriptor r8, Object r10) {
            int r11 = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r8.getType().ordinal()];
            if (r11 != 1) goto L5;
            Internal.checkNotNull(r10);
            if ((r10 instanceof Descriptors.EnumValueDescriptor) == false) goto L16;
            return;
        L16:
            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        L5:
            if (r11 == 2) goto L8;
            return;
        L8:
            if ((r10 instanceof Message.Builder) == true) goto L11;
            return;
        L11:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(r8.getNumber()), r8.getLiteType().getJavaType(), r10.getClass().getName()}));
        }

        private void verifyType(Descriptors.FieldDescriptor r8, Object r10) {
            if (r8.isRepeated() == false) goto L8;
            Iterator r11 = ((List) r10).iterator();
        L6:
            if (r11.hasNext() == false) goto L11;
            verifySingularValueType(r8, r11.next());
            goto L6
        L11:
            return;
        L8:
            verifySingularValueType(r8, r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            verifyContainingType(r8);
            verifySingularValueType(r8, r10);
            this.fields.addRepeatedField(r8, r10);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage build() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r8 = this.type;
            FieldSet<T> r10 = this.fields.build();
            Descriptors.FieldDescriptor[] r11 = this.oneofCases;
            throw AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(r8, r10, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r11, r11.length), this.unknownFields));
        L5:
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage buildPartial() {
            if (this.type.getOptions().getMapEntry() == false) goto L16;
            Iterator<Descriptors.FieldDescriptor> r8 = this.type.getFields().iterator();
        L6:
            if (r8.hasNext() == false) goto L16;
            Descriptors.FieldDescriptor r10 = r8.next();
            if (r10.isOptional() == false) goto L6;
            if (this.fields.hasField(r10) == true) goto L6;
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L14;
            FieldSet.Builder<Descriptors.FieldDescriptor> r11 = this.fields;
            Object r12 = DynamicMessage.getDefaultInstance(r10.getMessageType());
        L15:
            r11.setField(r10, r12);
            goto L6
        L14:
            r11 = this.fields;
            r12 = r10.getDefaultValue();
        L16:
            Descriptors.Descriptor r13 = this.type;
            FieldSet<T> r14 = this.fields.buildPartial();
            Descriptors.FieldDescriptor[] r15 = this.oneofCases;
            return new DynamicMessage(r13, r14, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r15, r15.length), this.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r8) {
            verifyContainingType(r8);
            Descriptors.OneofDescriptor r10 = r8.getContainingOneof();
            if (r10 == null) goto L7;
            int r11 = r10.getIndex();
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            if (r12[r11] != r8) goto L7;
            r12[r11] = null;
        L7:
            this.fields.clearField(r8);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r8) {
            verifyContainingType(r8);
            Object r10 = this.fields.getField(r8);
            if (r10 == null) goto L5;
            return r10;
        L5:
            if (r8.isRepeated() == false) goto L8;
            return Collections.emptyList();
        L8:
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return DynamicMessage.getDefaultInstance(r8.getMessageType());
        L11:
            return r8.getDefaultValue();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r8) {
            verifyContainingType(r8);
            if (r8.isMapField() == true) goto L15;
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            Object r10 = this.fields.getFieldAllowBuilders(r8);
            if (r10 != null) goto L9;
            Message.Builder r11 = new Builder(r8.getMessageType());
        L10:
            this.fields.setField(r8, r11);
            return r11;
        L9:
            r11 = toMessageBuilder(r10);
            goto L10
        L13:
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        L15:
            throw new UnsupportedOperationException("Nested builder not supported for map fields.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
            verifyOneofContainingType(r8);
            return this.oneofCases[r8.getIndex()];
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
            verifyContainingType(r8);
            return this.fields.getRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r8, int r10) {
            verifyContainingType(r8);
            if (r8.isMapField() == true) goto L11;
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            Message.Builder r11 = toMessageBuilder(this.fields.getRepeatedFieldAllowBuilders(r8, r10));
            this.fields.setRepeatedField(r8, r10, r11);
            return r11;
        L9:
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        L11:
            throw new UnsupportedOperationException("Map fields cannot be repeated");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
            verifyContainingType(r8);
            return this.fields.getRepeatedFieldCount(r8);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            verifyContainingType(r8);
            return this.fields.hasField(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r8) {
            verifyOneofContainingType(r8);
            if (this.oneofCases[r8.getIndex()] != null) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r8 = this.type.getFields().iterator();
        L4:
            if (r8.hasNext() == false) goto L12;
            Descriptors.FieldDescriptor r10 = r8.next();
            if (r10.isRequired() == false) goto L4;
            if (this.fields.hasField(r10) == true) goto L4;
            return false;
        L12:
            return this.fields.isInitialized();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder newBuilderForField(Descriptors.FieldDescriptor r8) {
            verifyContainingType(r8);
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
            return new Builder(r8.getMessageType());
        L7:
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            verifyContainingType(r8);
            verifyType(r8, r10);
            Descriptors.OneofDescriptor r11 = r8.getContainingOneof();
            if (r11 == null) goto L10;
            int r12 = r11.getIndex();
            Descriptors.FieldDescriptor r13 = this.oneofCases[r12];
            if (r13 == null) goto L8;
            if (r13 == r8) goto L8;
            this.fields.clearField(r13);
        L8:
            this.oneofCases[r12] = r8;
        L20:
            this.fields.setField(r8, r10);
            return this;
        L10:
            if (r8.hasPresence() == true) goto L20;
            if (r8.isRepeated() == false) goto L17;
            if (((List) r10).isEmpty() == false) goto L20;
        L18:
            this.fields.clearField(r8);
            return this;
        L17:
            if (r10.equals(r8.getDefaultValue()) == false) goto L20;
            goto L18
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            verifyContainingType(r8);
            verifySingularValueType(r8, r11);
            this.fields.setRepeatedField(r8, r10, r11);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setUnknownFields(UnknownFieldSet r8) {
            this.unknownFields = r8;
            return this;
        }

        public /* synthetic */ Builder(Descriptors.Descriptor r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            this.fields = FieldSet.newBuilder();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r8) {
            verifyOneofContainingType(r8);
            Descriptors.FieldDescriptor r10 = this.oneofCases[r8.getIndex()];
            if (r10 == null) goto L5;
            clearField(r10);
        L5:
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof DynamicMessage) == false) goto L22;
            DynamicMessage r10 = (DynamicMessage) r8;
            if (DynamicMessage.access$200(r10) != this.type) goto L20;
            this.fields.mergeFrom(DynamicMessage.access$300(r10));
            mergeUnknownFields(DynamicMessage.access$400(r10));
            int r11 = 0;
        L7:
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            if (r11 >= r12.length) goto L18;
            if (r12[r11] != null) goto L13;
            r12[r11] = DynamicMessage.access$500(r10)[r11];
        L17:
            r11 = r11 + 1;
            goto L7
        L13:
            if (DynamicMessage.access$500(r10)[r11] == null) goto L17;
            if (this.oneofCases[r11] == DynamicMessage.access$500(r10)[r11]) goto L17;
            this.fields.clearField(this.oneofCases[r11]);
            this.oneofCases[r11] = DynamicMessage.access$500(r10)[r11];
            goto L17
        L18:
            return this;
        L20:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        L22:
            return (Builder) super.mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeUnknownFields(UnknownFieldSet r8) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(r8).build();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForField(Descriptors.FieldDescriptor r8) {
            return newBuilderForField(r8);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder r8 = new Builder(this.type);
            r8.fields.mergeFrom(this.fields.build());
            r8.mergeUnknownFields(this.unknownFields);
            Descriptors.FieldDescriptor[] r10 = this.oneofCases;
            System.arraycopy(r10, 0, r8.oneofCases, 0, r10.length);
            return r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
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
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }
    }

    public DynamicMessage(Descriptors.Descriptor r8, FieldSet<Descriptors.FieldDescriptor> r10, Descriptors.FieldDescriptor[] r11, UnknownFieldSet r12) {
        this.memoizedSize = -1;
        this.type = r8;
        this.fields = r10;
        this.oneofCases = r11;
        this.unknownFields = r12;
    }

    public static /* synthetic */ Descriptors.Descriptor access$200(DynamicMessage r8) {
        return r8.type;
    }

    public static /* synthetic */ FieldSet access$300(DynamicMessage r8) {
        return r8.fields;
    }

    public static /* synthetic */ UnknownFieldSet access$400(DynamicMessage r8) {
        return r8.unknownFields;
    }

    public static /* synthetic */ Descriptors.FieldDescriptor[] access$500(DynamicMessage r8) {
        return r8.oneofCases;
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor r8) {
        Descriptors.FieldDescriptor[] r10 = new Descriptors.FieldDescriptor[r8.toProto().getOneofDeclCount()];
        return new DynamicMessage(r8, FieldSet.emptySet(), r10, UnknownFieldSet.getDefaultInstance());
    }

    public static Builder newBuilder(Descriptors.Descriptor r8) {
        return new Builder(r8, null);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, ByteString r10) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10));
    }

    private void verifyContainingType(Descriptors.FieldDescriptor r8) {
        if (r8.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void verifyOneofContainingType(Descriptors.OneofDescriptor r8) {
        if (r8.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r8) {
        verifyContainingType(r8);
        Object r10 = this.fields.getField(r8);
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (r8.isRepeated() == false) goto L8;
        return Collections.emptyList();
    L8:
        if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        return getDefaultInstance(r8.getMessageType());
    L11:
        return r8.getDefaultValue();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
        verifyOneofContainingType(r8);
        return this.oneofCases[r8.getIndex()];
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<DynamicMessage> getParserForType() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
        verifyContainingType(r8);
        return this.fields.getRepeatedField(r8, r10);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
        verifyContainingType(r8);
        return this.fields.getRepeatedFieldCount(r8);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L6;
        return r8;
    L6:
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L8;
        int r10 = this.fields.getMessageSetSerializedSize();
        int r11 = this.unknownFields.getSerializedSizeAsMessageSet();
    L9:
        int r12 = r11 + r10;
        this.memoizedSize = r12;
        return r12;
    L8:
        r10 = this.fields.getSerializedSize();
        r11 = this.unknownFields.getSerializedSize();
        goto L9
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r8) {
        verifyContainingType(r8);
        return this.fields.hasField(r8);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r8) {
        verifyOneofContainingType(r8);
        if (this.oneofCases[r8.getIndex()] != null) goto L6;
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
    public Builder toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L5;
        this.fields.writeMessageSetTo(r8);
        this.unknownFields.writeAsMessageSetTo(r8);
        return;
    L5:
        this.fields.writeTo(r8);
        this.unknownFields.writeTo(r8);
    }

    public static boolean isInitialized(Descriptors.Descriptor r8, FieldSet<Descriptors.FieldDescriptor> r10) {
        Iterator<Descriptors.FieldDescriptor> r11 = r8.getFields().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r12 = r11.next();
        if (r12.isRequired() == false) goto L4;
        if (r10.hasField(r12) == true) goto L4;
        return false;
    L12:
        return r10.isInitialized();
    }

    public static Builder newBuilder(Message r8) {
        return new Builder(r8.getDescriptorForType(), null).mergeFrom(r8);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, ByteString r10, ExtensionRegistry r11) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10, r11));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, CodedInputStream r10) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, CodedInputStream r10, ExtensionRegistry r11) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10, r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, InputStream r10) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, InputStream r10, ExtensionRegistry r11) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10, r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, byte[] r10) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r8, byte[] r10, ExtensionRegistry r11) {
        return Builder.access$000(newBuilder(r8).mergeFrom(r10, r11));
    }
}
