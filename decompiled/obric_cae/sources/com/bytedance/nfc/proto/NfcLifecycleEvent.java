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
public final class NfcLifecycleEvent extends GeneratedMessageV3 implements MessageOrBuilder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final NfcLifecycleEvent f3990q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Deprecated
    public static final a f3991r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3993b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f3996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte f3997p;

    public static final enum Type extends Enum<Type> implements ProtocolMessageEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BOOT_FINISHED = null;
        public static final int BOOT_FINISHED_VALUE = 8;
        public static final Type BOOT_STARTED = null;
        public static final int BOOT_STARTED_VALUE = 7;
        public static final Type DISABLE_FINISHED = null;
        public static final int DISABLE_FINISHED_VALUE = 6;
        public static final Type DISABLE_REQUEST = null;
        public static final int DISABLE_REQUEST_VALUE = 4;
        public static final Type DISABLE_STARTED = null;
        public static final int DISABLE_STARTED_VALUE = 5;
        public static final Type ENABLE_FINISHED = null;
        public static final int ENABLE_FINISHED_VALUE = 3;
        public static final Type ENABLE_REQUEST = null;
        public static final int ENABLE_REQUEST_VALUE = 1;
        public static final Type ENABLE_STARTED = null;
        public static final int ENABLE_STARTED_VALUE = 2;
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
            return new Type[]{UNKNOWN, ENABLE_REQUEST, ENABLE_STARTED, ENABLE_FINISHED, DISABLE_REQUEST, DISABLE_STARTED, DISABLE_FINISHED, BOOT_STARTED, BOOT_FINISHED};
        }

        static {
            UNKNOWN = new Type(BdimCategoryConstants.VALUE_UNKNOWN, 0, 0);
            ENABLE_REQUEST = new Type("ENABLE_REQUEST", 1, 1);
            ENABLE_STARTED = new Type("ENABLE_STARTED", 2, 2);
            ENABLE_FINISHED = new Type("ENABLE_FINISHED", 3, 3);
            DISABLE_REQUEST = new Type("DISABLE_REQUEST", 4, 4);
            DISABLE_STARTED = new Type("DISABLE_STARTED", 5, 5);
            DISABLE_FINISHED = new Type("DISABLE_FINISHED", 6, 6);
            BOOT_STARTED = new Type("BOOT_STARTED", 7, 7);
            BOOT_FINISHED = new Type("BOOT_FINISHED", 8, 8);
            $VALUES = $values();
            internalValueMap = new a();
            VALUES = values();
        }

        private Type(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static Type forNumber(int r8) {
            switch(r8) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return BOOT_FINISHED;
        L8:
            return BOOT_STARTED;
        L10:
            return DISABLE_FINISHED;
        L12:
            return DISABLE_STARTED;
        L14:
            return DISABLE_REQUEST;
        L16:
            return ENABLE_FINISHED;
        L18:
            return ENABLE_STARTED;
        L20:
            return ENABLE_REQUEST;
        L22:
            return UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return NfcLifecycleEvent.getDescriptor().getEnumTypes().get(0);
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

    public class a extends AbstractParser<NfcLifecycleEvent> {
        @Override // com.google.protobuf.Parser
        public final Object parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            b r11 = NfcLifecycleEvent.newBuilder();
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
        public int f3998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3999b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4000m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4001n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f4002o;

        public b() {
            this.f3999b = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return f8.a.f7347a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcLifecycleEvent build() {
            NfcLifecycleEvent r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcLifecycleEvent buildPartial() {
            NfcLifecycleEvent r8 = new NfcLifecycleEvent(this);
            int r10 = this.f3998a;
            if (r10 != 0) goto L5;
        L18:
            onBuilt();
            return r8;
        L5:
            if ((r10 & 1) == 0) goto L7;
            r8.f3993b = this.f3999b;
            int r11 = 1;
        L9:
            if ((r10 & 2) == 0) goto L12;
            r8.f3994m = this.f4000m;
            r11 = r11 | 2;
        L12:
            if ((r10 & 4) == 0) goto L15;
            r8.f3995n = this.f4001n;
            r11 = r11 | 4;
        L15:
            if ((r10 & 8) == 0) goto L17;
            r8.f3996o = this.f4002o;
            r11 = r11 | 8;
        L17:
            r8.f3992a |= r11;
            goto L18
        L7:
            r11 = 0;
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clear() {
            super.clear();
            this.f3998a = 0;
            this.f3999b = 0;
            this.f4000m = 0;
            this.f4001n = 0;
            this.f4002o = 0;
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

        public b clearState() {
            this.f3998a &= -3;
            this.f4000m = 0;
            onChanged();
            return this;
        }

        public b clearStatus() {
            this.f3998a &= -5;
            this.f4001n = 0;
            onChanged();
            return this;
        }

        public b clearTimestamp() {
            this.f3998a &= -9;
            this.f4002o = 0;
            onChanged();
            return this;
        }

        public b clearType() {
            this.f3998a &= -2;
            this.f3999b = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clone() {
            return (b) super.clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public NfcLifecycleEvent getDefaultInstanceForType() {
            return NfcLifecycleEvent.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return f8.a.f7347a;
        }

        public int getState() {
            return this.f4000m;
        }

        public int getStatus() {
            return this.f4001n;
        }

        public long getTimestamp() {
            return this.f4002o;
        }

        public Type getType() {
            Type r8 = Type.forNumber(this.f3999b);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Type.UNKNOWN;
        }

        public boolean hasState() {
            if ((this.f3998a & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasStatus() {
            if ((this.f3998a & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTimestamp() {
            if ((this.f3998a & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasType() {
            if ((this.f3998a & 1) != 0) goto L7;
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

        public b mergeFrom(NfcLifecycleEvent r8) {
            if (r8 != NfcLifecycleEvent.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasType() == false) goto L9;
            setType(r8.getType());
        L9:
            if (r8.hasState() == false) goto L12;
            setState(r8.getState());
        L12:
            if (r8.hasStatus() == false) goto L15;
            setStatus(r8.getStatus());
        L15:
            if (r8.hasTimestamp() == false) goto L17;
            setTimestamp(r8.getTimestamp());
        L17:
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

        public b setState(int r8) {
            this.f4000m = r8;
            this.f3998a |= 2;
            onChanged();
            return this;
        }

        public b setStatus(int r8) {
            this.f4001n = r8;
            this.f3998a |= 4;
            onChanged();
            return this;
        }

        public b setTimestamp(long r8) {
            this.f4002o = r8;
            this.f3998a |= 8;
            onChanged();
            return this;
        }

        public b setType(Type r8) {
            if (r8 == null) goto L6;
            this.f3998a |= 1;
            this.f3999b = r8.getNumber();
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
            this.f3999b = 0;
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
            return f8.a.f7348b.ensureFieldAccessorsInitialized(NfcLifecycleEvent.class, b.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L37;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L34;
            int r12 = r8.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r12 == 0) goto L26;
            if (r12 != 8) goto L10;
            int r13 = r8.readEnum();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (Type.forNumber(r13) == null) goto L23;
            this.f3999b = r13;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.f3998a |= 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L23:
            mergeUnknownVarintField(1, r13);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.f4000m = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.f3998a |= 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.f4001n = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.f3998a |= 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.f4002o = r8.readInt64();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.f3998a |= 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L16:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L26:
            r11 = true;
            goto L4
        L27:
            th = move-exception;
            onChanged();
            throw th;
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L34:
            onChanged();
            return this;
        L37:
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
            if ((r8 instanceof NfcLifecycleEvent) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NfcLifecycleEvent) r8);
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
        f3990q = new NfcLifecycleEvent();
        f3991r = new a();
    }

    public NfcLifecycleEvent() {
        this.f3994m = 0;
        this.f3995n = 0;
        this.f3996o = 0;
        this.f3997p = -1;
        this.f3993b = 0;
    }

    public static NfcLifecycleEvent getDefaultInstance() {
        return f3990q;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return f8.a.f7347a;
    }

    public static b newBuilder() {
        return f3990q.toBuilder();
    }

    public static NfcLifecycleEvent parseDelimitedFrom(InputStream r8) {
        return (NfcLifecycleEvent) GeneratedMessage.parseDelimitedWithIOException(f3991r, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcLifecycleEvent parseFrom(ByteString r8) {
        return (NfcLifecycleEvent) f3991r.parseFrom(r8);
    }

    public static Parser<NfcLifecycleEvent> parser() {
        return f3991r;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NfcLifecycleEvent) == false) goto L8;
        NfcLifecycleEvent r10 = (NfcLifecycleEvent) r8;
        if (hasType() == r10.hasType()) goto L13;
        return false;
    L13:
        if (hasType() == false) goto L18;
        if (this.f3993b == r10.f3993b) goto L18;
        return false;
    L18:
        if (hasState() == r10.hasState()) goto L21;
        return false;
    L21:
        if (hasState() == false) goto L26;
        if (getState() == r10.getState()) goto L26;
        return false;
    L26:
        if (hasStatus() == r10.hasStatus()) goto L29;
        return false;
    L29:
        if (hasStatus() == false) goto L34;
        if (getStatus() == r10.getStatus()) goto L34;
        return false;
    L34:
        if (hasTimestamp() == r10.hasTimestamp()) goto L37;
        return false;
    L37:
        if (hasTimestamp() == false) goto L42;
        if (getTimestamp() == r10.getTimestamp()) goto L42;
        return false;
    L42:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L44;
        return false;
    L44:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NfcLifecycleEvent getDefaultInstanceForType() {
        return f3990q;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NfcLifecycleEvent> getParserForType() {
        return f3991r;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.f3992a & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeEnumSize(1, this.f3993b);
    L9:
        if ((this.f3992a & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.f3994m);
    L12:
        if ((this.f3992a & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.f3995n);
    L15:
        if ((this.f3992a & 8) == 0) goto L17;
        r10 = r10 + CodedOutputStream.computeInt64Size(4, this.f3996o);
    L17:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    public int getState() {
        return this.f3994m;
    }

    public int getStatus() {
        return this.f3995n;
    }

    public long getTimestamp() {
        return this.f3996o;
    }

    public Type getType() {
        Type r8 = Type.forNumber(this.f3993b);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Type.UNKNOWN;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasState() {
        if ((this.f3992a & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasStatus() {
        if ((this.f3992a & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTimestamp() {
        if ((this.f3992a & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasType() {
        if ((this.f3992a & 1) != 0) goto L7;
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
        r10 = defpackage.b.a(r10, 37, 1, 53) + this.f3993b;
    L9:
        if (hasState() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getState();
    L12:
        if (hasStatus() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getStatus();
    L15:
        if (hasTimestamp() == false) goto L17;
        r10 = defpackage.b.a(r10, 37, 4, 53) + Internal.hashLong(getTimestamp());
    L17:
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
        byte r8 = this.f3997p;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.f3997p = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new NfcLifecycleEvent();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b toBuilder() {
        if (this != f3990q) goto L6;
        return new b();
    L6:
        return new b().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.f3992a & 1) == 0) goto L6;
        r8.writeEnum(1, this.f3993b);
    L6:
        if ((this.f3992a & 2) == 0) goto L9;
        r8.writeInt32(2, this.f3994m);
    L9:
        if ((this.f3992a & 4) == 0) goto L12;
        r8.writeInt32(3, this.f3995n);
    L12:
        if ((this.f3992a & 8) == 0) goto L14;
        r8.writeInt64(4, this.f3996o);
    L14:
        getUnknownFields().writeTo(r8);
    }

    public NfcLifecycleEvent(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.f3993b = 0;
        this.f3994m = 0;
        this.f3995n = 0;
        this.f3996o = 0;
        this.f3997p = -1;
    }

    public static b newBuilder(NfcLifecycleEvent r8) {
        return f3990q.toBuilder().mergeFrom(r8);
    }

    public static NfcLifecycleEvent parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcLifecycleEvent) GeneratedMessage.parseDelimitedWithIOException(f3991r, r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcLifecycleEvent parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return (NfcLifecycleEvent) f3991r.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return f8.a.f7348b.ensureFieldAccessorsInitialized(NfcLifecycleEvent.class, b.class);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static NfcLifecycleEvent parseFrom(CodedInputStream r8) {
        return (NfcLifecycleEvent) GeneratedMessage.parseWithIOException(f3991r, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new b(r8);
    }

    public static NfcLifecycleEvent parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NfcLifecycleEvent) GeneratedMessage.parseWithIOException(f3991r, r8, r10);
    }

    public static NfcLifecycleEvent parseFrom(InputStream r8) {
        return (NfcLifecycleEvent) GeneratedMessage.parseWithIOException(f3991r, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public static NfcLifecycleEvent parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcLifecycleEvent) GeneratedMessage.parseWithIOException(f3991r, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcLifecycleEvent parseFrom(ByteBuffer r8) {
        return (NfcLifecycleEvent) f3991r.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcLifecycleEvent parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return (NfcLifecycleEvent) f3991r.parseFrom(r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcLifecycleEvent parseFrom(byte[] r8) {
        return (NfcLifecycleEvent) f3991r.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcLifecycleEvent parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return (NfcLifecycleEvent) f3991r.parseFrom(r8, r10);
    }
}
