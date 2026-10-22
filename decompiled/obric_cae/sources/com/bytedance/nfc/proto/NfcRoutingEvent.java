package com.bytedance.nfc.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class NfcRoutingEvent extends GeneratedMessageV3 implements MessageOrBuilder {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final NfcRoutingEvent f4003p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    public static final a f4004q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4006b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte f4009o;

    public static final enum Type extends Enum<Type> implements ProtocolMessageEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type APPLY_ROUTING = null;
        public static final int APPLY_ROUTING_VALUE = 1;
        public static final Type ROUTING_CHANGED = null;
        public static final int ROUTING_CHANGED_VALUE = 2;
        public static final Type ROUTING_TABLE_FULL = null;
        public static final int ROUTING_TABLE_FULL_VALUE = 3;
        public static final Type UNKNOWN = null;
        public static final int UNKNOWN_VALUE = 0;
        private static final Type[] VALUES = null;
        private static final Internal.EnumLiteMap<Type> internalValueMap = null;
        private final int value;

        public class a implements Internal.EnumLiteMap<Type> {
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public final Internal.EnumLite findValueByNumber(int r8) {
                return Type.forNumber(r8);
            }
        }

        private static /* synthetic */ Type[] $values() {
            return new Type[]{UNKNOWN, APPLY_ROUTING, ROUTING_CHANGED, ROUTING_TABLE_FULL};
        }

        static {
            UNKNOWN = new Type(BdimCategoryConstants.VALUE_UNKNOWN, 0, 0);
            APPLY_ROUTING = new Type("APPLY_ROUTING", 1, 1);
            ROUTING_CHANGED = new Type("ROUTING_CHANGED", 2, 2);
            ROUTING_TABLE_FULL = new Type("ROUTING_TABLE_FULL", 3, 3);
            $VALUES = $values();
            internalValueMap = new a();
            VALUES = values();
        }

        private Type(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static Type forNumber(int r8) {
            if (r8 == 0) goto L18;
            if (r8 == 1) goto L16;
            if (r8 == 2) goto L14;
            if (r8 == 3) goto L12;
            return null;
        L12:
            return ROUTING_TABLE_FULL;
        L14:
            return ROUTING_CHANGED;
        L16:
            return APPLY_ROUTING;
        L18:
            return UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return NfcRoutingEvent.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Type valueOf(int r8) {
            return forNumber(r8);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public static Type valueOf(Descriptors.EnumValueDescriptor r8) {
            if (r8.getType() != getDescriptor()) goto L7;
            return VALUES[r8.getIndex()];
        L7:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Type valueOf(String r8) {
            return (Type) Enum.valueOf(Type.class, r8);
        }
    }

    public class a extends AbstractParser<NfcRoutingEvent> {
        @Override // com.google.protobuf.Parser
        public final Object parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            b r11 = NfcRoutingEvent.newBuilder();
            r11.mergeFrom(r8, r10);     // Catch: IOException -> L6 UninitializedMessageException -> L9 InvalidProtocolBufferException -> L12
        L5:
            return r11.buildPartial();
        L12:
            e = move-exception;
            throw e.setUnfinishedMessage(r11.buildPartial());
        L9:
            e = move-exception;
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r11.buildPartial());
        L6:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r11.buildPartial());
        }
    }

    public static final class b extends GeneratedMessageV3.Builder<b> implements MessageOrBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4011b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4012m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f4013n;

        public b() {
            this.f4011b = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return f8.a.f7351e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcRoutingEvent build() {
            NfcRoutingEvent r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcRoutingEvent buildPartial() {
            NfcRoutingEvent r8 = new NfcRoutingEvent(this);
            int r10 = this.f4010a;
            if (r10 != 0) goto L5;
        L15:
            onBuilt();
            return r8;
        L5:
            if ((r10 & 1) == 0) goto L7;
            r8.f4006b = this.f4011b;
            int r11 = 1;
        L9:
            if ((r10 & 2) == 0) goto L12;
            r8.f4007m = this.f4012m;
            r11 = r11 | 2;
        L12:
            if ((r10 & 4) == 0) goto L14;
            r8.f4008n = this.f4013n;
            r11 = r11 | 4;
        L14:
            r8.f4005a |= r11;
            goto L15
        L7:
            r11 = 0;
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clear() {
            super.clear();
            this.f4010a = 0;
            this.f4011b = 0;
            this.f4012m = false;
            this.f4013n = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b clearField(Descriptors.FieldDescriptor r8) {
            return (b) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public b clearOneof(Descriptors.OneofDescriptor r8) {
            return (b) super.clearOneof(r8);
        }

        public b clearSkipped() {
            this.f4010a &= -3;
            this.f4012m = false;
            onChanged();
            return this;
        }

        public b clearTimestamp() {
            this.f4010a &= -5;
            this.f4013n = 0;
            onChanged();
            return this;
        }

        public b clearType() {
            this.f4010a &= -2;
            this.f4011b = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clone() {
            return (b) super.clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public NfcRoutingEvent getDefaultInstanceForType() {
            return NfcRoutingEvent.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return f8.a.f7351e;
        }

        public boolean getSkipped() {
            return this.f4012m;
        }

        public long getTimestamp() {
            return this.f4013n;
        }

        public Type getType() {
            Type r8 = Type.forNumber(this.f4011b);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Type.UNKNOWN;
        }

        public boolean hasSkipped() {
            if ((this.f4010a & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTimestamp() {
            if ((this.f4010a & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasType() {
            if ((this.f4010a & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public final /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public b mergeFrom(NfcRoutingEvent r8) {
            if (r8 != NfcRoutingEvent.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasType() == false) goto L9;
            setType(r8.getType());
        L9:
            if (r8.hasSkipped() == false) goto L12;
            setSkipped(r8.getSkipped());
        L12:
            if (r8.hasTimestamp() == false) goto L14;
            setTimestamp(r8.getTimestamp());
        L14:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final b mergeUnknownFields(UnknownFieldSet r8) {
            return (b) super.mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (b) super.setRepeatedField(r8, r10, r11);
        }

        public b setSkipped(boolean r8) {
            this.f4012m = r8;
            this.f4010a |= 2;
            onChanged();
            return this;
        }

        public b setTimestamp(long r8) {
            this.f4013n = r8;
            this.f4010a |= 4;
            onChanged();
            return this;
        }

        public b setType(Type r8) {
            if (r8 == null) goto L6;
            this.f4010a |= 1;
            this.f4011b = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final b setUnknownFields(UnknownFieldSet r8) {
            return (b) super.setUnknownFields(r8);
        }

        public b(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.f4011b = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return f8.a.f7352f.ensureFieldAccessorsInitialized(NfcRoutingEvent.class, b.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L34;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L31;
            int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r12 == 0) goto L23;
            if (r12 != 8) goto L10;
            int r13 = r8.readEnum();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (Type.forNumber(r13) == null) goto L20;
            this.f4011b = r13;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.f4010a |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L20:
            mergeUnknownVarintField(1, r13);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.f4012m = r8.readBool();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.f4010a |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.f4013n = r8.readInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.f4010a |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L23:
            r11 = true;
            goto L4
        L24:
            th = move-exception;
            onChanged();
            throw th;
        L26:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L24
        L31:
            onChanged();
            return this;
        L34:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public b mergeFrom(Message r8) {
            if ((r8 instanceof NfcRoutingEvent) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NfcRoutingEvent) r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }
    }

    static {
        f4003p = new NfcRoutingEvent();
        f4004q = new a();
    }

    public NfcRoutingEvent() {
        this.f4007m = false;
        this.f4008n = 0;
        this.f4009o = -1;
        this.f4006b = 0;
    }

    public static NfcRoutingEvent getDefaultInstance() {
        return f4003p;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return f8.a.f7351e;
    }

    public static b newBuilder() {
        return f4003p.toBuilder();
    }

    public static NfcRoutingEvent parseDelimitedFrom(InputStream r8) {
        return (NfcRoutingEvent) GeneratedMessage.parseDelimitedWithIOException(f4004q, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcRoutingEvent parseFrom(ByteString r8) {
        return (NfcRoutingEvent) f4004q.parseFrom(r8);
    }

    public static Parser<NfcRoutingEvent> parser() {
        return f4004q;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NfcRoutingEvent) == false) goto L8;
        NfcRoutingEvent r10 = (NfcRoutingEvent) r8;
        if (hasType() == r10.hasType()) goto L13;
        return false;
    L13:
        if (hasType() == false) goto L18;
        if (this.f4006b == r10.f4006b) goto L18;
        return false;
    L18:
        if (hasSkipped() == r10.hasSkipped()) goto L21;
        return false;
    L21:
        if (hasSkipped() == false) goto L26;
        if (getSkipped() == r10.getSkipped()) goto L26;
        return false;
    L26:
        if (hasTimestamp() == r10.hasTimestamp()) goto L29;
        return false;
    L29:
        if (hasTimestamp() == false) goto L34;
        if (getTimestamp() == r10.getTimestamp()) goto L34;
        return false;
    L34:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NfcRoutingEvent getDefaultInstanceForType() {
        return f4003p;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NfcRoutingEvent> getParserForType() {
        return f4004q;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.f4005a & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeEnumSize(1, this.f4006b);
    L9:
        if ((this.f4005a & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeBoolSize(2, this.f4007m);
    L12:
        if ((this.f4005a & 4) == 0) goto L14;
        r10 = r10 + CodedOutputStream.computeInt64Size(3, this.f4008n);
    L14:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    public boolean getSkipped() {
        return this.f4007m;
    }

    public long getTimestamp() {
        return this.f4008n;
    }

    public Type getType() {
        Type r8 = Type.forNumber(this.f4006b);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Type.UNKNOWN;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasSkipped() {
        if ((this.f4005a & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTimestamp() {
        if ((this.f4005a & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasType() {
        if ((this.f4005a & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasType() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + this.f4006b;
    L9:
        if (hasSkipped() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashBoolean(getSkipped());
    L12:
        if (hasTimestamp() == false) goto L14;
        r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashLong(getTimestamp());
    L14:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public final /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r8 = this.f4009o;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.f4009o = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new NfcRoutingEvent();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b toBuilder() {
        if (this != f4003p) goto L6;
        return new b();
    L6:
        return new b().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.f4005a & 1) == 0) goto L6;
        r8.writeEnum(1, this.f4006b);
    L6:
        if ((this.f4005a & 2) == 0) goto L9;
        r8.writeBool(2, this.f4007m);
    L9:
        if ((this.f4005a & 4) == 0) goto L11;
        r8.writeInt64(3, this.f4008n);
    L11:
        getUnknownFields().writeTo(r8);
    }

    public NfcRoutingEvent(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.f4006b = 0;
        this.f4007m = false;
        this.f4008n = 0;
        this.f4009o = -1;
    }

    public static b newBuilder(NfcRoutingEvent r8) {
        return f4003p.toBuilder().mergeFrom(r8);
    }

    public static NfcRoutingEvent parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcRoutingEvent) GeneratedMessage.parseDelimitedWithIOException(f4004q, r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcRoutingEvent parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return (NfcRoutingEvent) f4004q.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return f8.a.f7352f.ensureFieldAccessorsInitialized(NfcRoutingEvent.class, b.class);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static NfcRoutingEvent parseFrom(CodedInputStream r8) {
        return (NfcRoutingEvent) GeneratedMessage.parseWithIOException(f4004q, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new b(r8);
    }

    public static NfcRoutingEvent parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NfcRoutingEvent) GeneratedMessage.parseWithIOException(f4004q, r8, r10);
    }

    public static NfcRoutingEvent parseFrom(InputStream r8) {
        return (NfcRoutingEvent) GeneratedMessage.parseWithIOException(f4004q, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public static NfcRoutingEvent parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcRoutingEvent) GeneratedMessage.parseWithIOException(f4004q, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcRoutingEvent parseFrom(ByteBuffer r8) {
        return (NfcRoutingEvent) f4004q.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcRoutingEvent parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return (NfcRoutingEvent) f4004q.parseFrom(r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcRoutingEvent parseFrom(byte[] r8) {
        return (NfcRoutingEvent) f4004q.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcRoutingEvent parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return (NfcRoutingEvent) f4004q.parseFrom(r8, r10);
    }
}
