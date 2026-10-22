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
public final class NfcHceEvent2 extends GeneratedMessageV3 implements MessageOrBuilder {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final NfcHceEvent2 f3971t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Deprecated
    public static final a f3972u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3974b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile Object f3975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Object f3976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f3979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile Object f3980r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte f3981s;

    public static final enum Type extends Enum<Type> implements ProtocolMessageEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CE_ACTIVATED = null;
        public static final int CE_ACTIVATED_VALUE = 4;
        public static final Type HCE_EVENT = null;
        public static final int HCE_EVENT_VALUE = 1;
        public static final Type LAUNCH_CHOOSER = null;
        public static final int LAUNCH_CHOOSER_VALUE = 2;
        public static final Type TAP_AGAIN = null;
        public static final int TAP_AGAIN_VALUE = 3;
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
            return new Type[]{UNKNOWN, HCE_EVENT, LAUNCH_CHOOSER, TAP_AGAIN, CE_ACTIVATED};
        }

        static {
            UNKNOWN = new Type(BdimCategoryConstants.VALUE_UNKNOWN, 0, 0);
            HCE_EVENT = new Type("HCE_EVENT", 1, 1);
            LAUNCH_CHOOSER = new Type("LAUNCH_CHOOSER", 2, 2);
            TAP_AGAIN = new Type("TAP_AGAIN", 3, 3);
            CE_ACTIVATED = new Type("CE_ACTIVATED", 4, 4);
            $VALUES = $values();
            internalValueMap = new a();
            VALUES = values();
        }

        private Type(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static Type forNumber(int r8) {
            if (r8 == 0) goto L22;
            if (r8 == 1) goto L20;
            if (r8 == 2) goto L18;
            if (r8 == 3) goto L16;
            if (r8 == 4) goto L14;
            return null;
        L14:
            return CE_ACTIVATED;
        L16:
            return TAP_AGAIN;
        L18:
            return LAUNCH_CHOOSER;
        L20:
            return HCE_EVENT;
        L22:
            return UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return NfcHceEvent2.getDescriptor().getEnumTypes().get(0);
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

    public class a extends AbstractParser<NfcHceEvent2> {
        @Override // com.google.protobuf.Parser
        public final Object parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            b r11 = NfcHceEvent2.newBuilder();
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
        public int f3982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3983b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f3984m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f3985n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f3986o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f3987p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f3988q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f3989r;

        public b() {
            this.f3983b = 0;
            this.f3984m = "";
            this.f3985n = "";
            this.f3989r = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return f8.a.f7353g;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcHceEvent2 build() {
            NfcHceEvent2 r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcHceEvent2 buildPartial() {
            NfcHceEvent2 r8 = new NfcHceEvent2(this);
            int r10 = this.f3982a;
            if (r10 != 0) goto L5;
        L27:
            onBuilt();
            return r8;
        L5:
            if ((r10 & 1) == 0) goto L7;
            r8.f3974b = this.f3983b;
            int r11 = 1;
        L9:
            if ((r10 & 2) == 0) goto L12;
            r8.f3975m = this.f3984m;
            r11 = r11 | 2;
        L12:
            if ((r10 & 4) == 0) goto L15;
            r8.f3976n = this.f3985n;
            r11 = r11 | 4;
        L15:
            if ((r10 & 8) == 0) goto L18;
            r8.f3977o = this.f3986o;
            r11 = r11 | 8;
        L18:
            if ((r10 & 16) == 0) goto L21;
            r8.f3978p = this.f3987p;
            r11 = r11 | 16;
        L21:
            if ((r10 & 32) == 0) goto L24;
            r8.f3979q = this.f3988q;
            r11 = r11 | 32;
        L24:
            if ((r10 & 64) == 0) goto L26;
            r8.f3980r = this.f3989r;
            r11 = r11 | 64;
        L26:
            r8.f3973a |= r11;
            goto L27
        L7:
            r11 = 0;
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clear() {
            super.clear();
            this.f3982a = 0;
            this.f3983b = 0;
            this.f3984m = "";
            this.f3985n = "";
            this.f3986o = 0;
            this.f3987p = false;
            this.f3988q = 0;
            this.f3989r = "";
            return this;
        }

        public b clearAction() {
            this.f3982a &= -9;
            this.f3986o = 0;
            onChanged();
            return this;
        }

        public b clearActivated() {
            this.f3982a &= -17;
            this.f3987p = false;
            onChanged();
            return this;
        }

        public b clearAid() {
            this.f3984m = NfcHceEvent2.getDefaultInstance().getAid();
            this.f3982a &= -3;
            onChanged();
            return this;
        }

        public b clearCategory() {
            this.f3985n = NfcHceEvent2.getDefaultInstance().getCategory();
            this.f3982a &= -5;
            onChanged();
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

        public b clearServiceName() {
            this.f3989r = NfcHceEvent2.getDefaultInstance().getServiceName();
            this.f3982a &= -65;
            onChanged();
            return this;
        }

        public b clearTimestamp() {
            this.f3982a &= -33;
            this.f3988q = 0;
            onChanged();
            return this;
        }

        public b clearType() {
            this.f3982a &= -2;
            this.f3983b = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clone() {
            return (b) super.clone();
        }

        public int getAction() {
            return this.f3986o;
        }

        public boolean getActivated() {
            return this.f3987p;
        }

        public String getAid() {
            Object r8 = this.f3984m;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.f3984m = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        public ByteString getAidBytes() {
            Object r8 = this.f3984m;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.f3984m = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        public String getCategory() {
            Object r8 = this.f3985n;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.f3985n = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        public ByteString getCategoryBytes() {
            Object r8 = this.f3985n;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.f3985n = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public NfcHceEvent2 getDefaultInstanceForType() {
            return NfcHceEvent2.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return f8.a.f7353g;
        }

        public String getServiceName() {
            Object r8 = this.f3989r;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.f3989r = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        public ByteString getServiceNameBytes() {
            Object r8 = this.f3989r;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.f3989r = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        public long getTimestamp() {
            return this.f3988q;
        }

        public Type getType() {
            Type r8 = Type.forNumber(this.f3983b);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Type.UNKNOWN;
        }

        public boolean hasAction() {
            if ((this.f3982a & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasActivated() {
            if ((this.f3982a & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasAid() {
            if ((this.f3982a & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasCategory() {
            if ((this.f3982a & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasServiceName() {
            if ((this.f3982a & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTimestamp() {
            if ((this.f3982a & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasType() {
            if ((this.f3982a & 1) != 0) goto L7;
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

        public b mergeFrom(NfcHceEvent2 r8) {
            if (r8 != NfcHceEvent2.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasType() == false) goto L9;
            setType(r8.getType());
        L9:
            if (r8.hasAid() == false) goto L12;
            this.f3984m = r8.f3975m;
            this.f3982a |= 2;
            onChanged();
        L12:
            if (r8.hasCategory() == false) goto L15;
            this.f3985n = r8.f3976n;
            this.f3982a |= 4;
            onChanged();
        L15:
            if (r8.hasAction() == false) goto L18;
            setAction(r8.getAction());
        L18:
            if (r8.hasActivated() == false) goto L21;
            setActivated(r8.getActivated());
        L21:
            if (r8.hasTimestamp() == false) goto L24;
            setTimestamp(r8.getTimestamp());
        L24:
            if (r8.hasServiceName() == false) goto L26;
            this.f3989r = r8.f3980r;
            this.f3982a |= 64;
            onChanged();
        L26:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final b mergeUnknownFields(UnknownFieldSet r8) {
            return (b) super.mergeUnknownFields(r8);
        }

        public b setAction(int r8) {
            this.f3986o = r8;
            this.f3982a |= 8;
            onChanged();
            return this;
        }

        public b setActivated(boolean r8) {
            this.f3987p = r8;
            this.f3982a |= 16;
            onChanged();
            return this;
        }

        public b setAid(String r8) {
            if (r8 == null) goto L6;
            this.f3984m = r8;
            this.f3982a |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setAidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.f3984m = r8;
            this.f3982a |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setCategory(String r8) {
            if (r8 == null) goto L6;
            this.f3985n = r8;
            this.f3982a |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setCategoryBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.f3985n = r8;
            this.f3982a |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (b) super.setRepeatedField(r8, r10, r11);
        }

        public b setServiceName(String r8) {
            if (r8 == null) goto L6;
            this.f3989r = r8;
            this.f3982a |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setServiceNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.f3989r = r8;
            this.f3982a |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setTimestamp(long r8) {
            this.f3988q = r8;
            this.f3982a |= 32;
            onChanged();
            return this;
        }

        public b setType(Type r8) {
            if (r8 == null) goto L6;
            this.f3982a |= 1;
            this.f3983b = r8.getNumber();
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
            this.f3983b = 0;
            this.f3984m = "";
            this.f3985n = "";
            this.f3989r = "";
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
            return f8.a.f7354h.ensureFieldAccessorsInitialized(NfcHceEvent2.class, b.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L46;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L43;
            int r12 = r8.readTag();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r12 == 0) goto L35;
            if (r12 != 8) goto L10;
            int r13 = r8.readEnum();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (Type.forNumber(r13) == null) goto L32;
            this.f3983b = r13;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L32:
            mergeUnknownVarintField(1, r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L10:
            if (r12 != 18) goto L12;
            this.f3984m = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L12:
            if (r12 != 26) goto L14;
            this.f3985n = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.f3986o = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.f3987p = r8.readBool();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L18:
            if (r12 != 48) goto L20;
            this.f3988q = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L20:
            if (r12 != 58) goto L22;
            this.f3989r = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.f3982a |= 64;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L35:
            r11 = true;
            goto L4
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L43:
            onChanged();
            return this;
        L46:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public b mergeFrom(Message r8) {
            if ((r8 instanceof NfcHceEvent2) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NfcHceEvent2) r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
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
        f3971t = new NfcHceEvent2();
        f3972u = new a();
    }

    public NfcHceEvent2() {
        this.f3974b = 0;
        this.f3975m = "";
        this.f3976n = "";
        this.f3977o = 0;
        this.f3978p = false;
        this.f3979q = 0;
        this.f3980r = "";
        this.f3981s = -1;
        this.f3974b = 0;
        this.f3975m = "";
        this.f3976n = "";
        this.f3980r = "";
    }

    public static NfcHceEvent2 getDefaultInstance() {
        return f3971t;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return f8.a.f7353g;
    }

    public static b newBuilder() {
        return f3971t.toBuilder();
    }

    public static NfcHceEvent2 parseDelimitedFrom(InputStream r8) {
        return (NfcHceEvent2) GeneratedMessage.parseDelimitedWithIOException(f3972u, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcHceEvent2 parseFrom(ByteString r8) {
        return (NfcHceEvent2) f3972u.parseFrom(r8);
    }

    public static Parser<NfcHceEvent2> parser() {
        return f3972u;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NfcHceEvent2) == false) goto L8;
        NfcHceEvent2 r10 = (NfcHceEvent2) r8;
        if (hasType() == r10.hasType()) goto L13;
        return false;
    L13:
        if (hasType() == false) goto L18;
        if (this.f3974b == r10.f3974b) goto L18;
        return false;
    L18:
        if (hasAid() == r10.hasAid()) goto L21;
        return false;
    L21:
        if (hasAid() == false) goto L26;
        if (getAid().equals(r10.getAid()) == true) goto L26;
        return false;
    L26:
        if (hasCategory() == r10.hasCategory()) goto L29;
        return false;
    L29:
        if (hasCategory() == false) goto L34;
        if (getCategory().equals(r10.getCategory()) == true) goto L34;
        return false;
    L34:
        if (hasAction() == r10.hasAction()) goto L37;
        return false;
    L37:
        if (hasAction() == false) goto L42;
        if (getAction() == r10.getAction()) goto L42;
        return false;
    L42:
        if (hasActivated() == r10.hasActivated()) goto L45;
        return false;
    L45:
        if (hasActivated() == false) goto L50;
        if (getActivated() == r10.getActivated()) goto L50;
        return false;
    L50:
        if (hasTimestamp() == r10.hasTimestamp()) goto L53;
        return false;
    L53:
        if (hasTimestamp() == false) goto L58;
        if (getTimestamp() == r10.getTimestamp()) goto L58;
        return false;
    L58:
        if (hasServiceName() == r10.hasServiceName()) goto L61;
        return false;
    L61:
        if (hasServiceName() == false) goto L66;
        if (getServiceName().equals(r10.getServiceName()) == true) goto L66;
        return false;
    L66:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L68;
        return false;
    L68:
        return true;
    L8:
        return super.equals(r8);
    }

    public int getAction() {
        return this.f3977o;
    }

    public boolean getActivated() {
        return this.f3978p;
    }

    public String getAid() {
        Object r8 = this.f3975m;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.f3975m = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    public ByteString getAidBytes() {
        Object r8 = this.f3975m;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.f3975m = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    public String getCategory() {
        Object r8 = this.f3976n;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.f3976n = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    public ByteString getCategoryBytes() {
        Object r8 = this.f3976n;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.f3976n = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NfcHceEvent2 getDefaultInstanceForType() {
        return f3971t;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NfcHceEvent2> getParserForType() {
        return f3972u;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.f3973a & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeEnumSize(1, this.f3974b);
    L9:
        if ((this.f3973a & 2) == 0) goto L12;
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.f3975m);
    L12:
        if ((this.f3973a & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.f3976n);
    L15:
        if ((this.f3973a & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.f3977o);
    L18:
        if ((this.f3973a & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeBoolSize(5, this.f3978p);
    L21:
        if ((this.f3973a & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt64Size(6, this.f3979q);
    L24:
        if ((this.f3973a & 64) == 0) goto L26;
        r10 = r10 + GeneratedMessage.computeStringSize(7, this.f3980r);
    L26:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    public String getServiceName() {
        Object r8 = this.f3980r;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.f3980r = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    public ByteString getServiceNameBytes() {
        Object r8 = this.f3980r;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.f3980r = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    public long getTimestamp() {
        return this.f3979q;
    }

    public Type getType() {
        Type r8 = Type.forNumber(this.f3974b);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Type.UNKNOWN;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasAction() {
        if ((this.f3973a & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasActivated() {
        if ((this.f3973a & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasAid() {
        if ((this.f3973a & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasCategory() {
        if ((this.f3973a & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasServiceName() {
        if ((this.f3973a & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTimestamp() {
        if ((this.f3973a & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasType() {
        if ((this.f3973a & 1) != 0) goto L7;
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
        r10 = defpackage.b.a(r10, 37, 1, 53) + this.f3974b;
    L9:
        if (hasAid() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getAid().hashCode();
    L12:
        if (hasCategory() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getCategory().hashCode();
    L15:
        if (hasAction() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getAction();
    L18:
        if (hasActivated() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + Internal.hashBoolean(getActivated());
    L21:
        if (hasTimestamp() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + Internal.hashLong(getTimestamp());
    L24:
        if (hasServiceName() == false) goto L26;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getServiceName().hashCode();
    L26:
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
        byte r8 = this.f3981s;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.f3981s = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new NfcHceEvent2();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b toBuilder() {
        if (this != f3971t) goto L6;
        return new b();
    L6:
        return new b().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.f3973a & 1) == 0) goto L6;
        r8.writeEnum(1, this.f3974b);
    L6:
        if ((this.f3973a & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.f3975m);
    L9:
        if ((this.f3973a & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.f3976n);
    L12:
        if ((this.f3973a & 8) == 0) goto L15;
        r8.writeInt32(4, this.f3977o);
    L15:
        if ((this.f3973a & 16) == 0) goto L18;
        r8.writeBool(5, this.f3978p);
    L18:
        if ((this.f3973a & 32) == 0) goto L21;
        r8.writeInt64(6, this.f3979q);
    L21:
        if ((this.f3973a & 64) == 0) goto L23;
        GeneratedMessage.writeString(r8, 7, this.f3980r);
    L23:
        getUnknownFields().writeTo(r8);
    }

    public NfcHceEvent2(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.f3974b = 0;
        this.f3975m = "";
        this.f3976n = "";
        this.f3977o = 0;
        this.f3978p = false;
        this.f3979q = 0;
        this.f3980r = "";
        this.f3981s = -1;
    }

    public static b newBuilder(NfcHceEvent2 r8) {
        return f3971t.toBuilder().mergeFrom(r8);
    }

    public static NfcHceEvent2 parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcHceEvent2) GeneratedMessage.parseDelimitedWithIOException(f3972u, r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcHceEvent2 parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return (NfcHceEvent2) f3972u.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return f8.a.f7354h.ensureFieldAccessorsInitialized(NfcHceEvent2.class, b.class);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static NfcHceEvent2 parseFrom(CodedInputStream r8) {
        return (NfcHceEvent2) GeneratedMessage.parseWithIOException(f3972u, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new b(r8);
    }

    public static NfcHceEvent2 parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NfcHceEvent2) GeneratedMessage.parseWithIOException(f3972u, r8, r10);
    }

    public static NfcHceEvent2 parseFrom(InputStream r8) {
        return (NfcHceEvent2) GeneratedMessage.parseWithIOException(f3972u, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public static NfcHceEvent2 parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcHceEvent2) GeneratedMessage.parseWithIOException(f3972u, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcHceEvent2 parseFrom(ByteBuffer r8) {
        return (NfcHceEvent2) f3972u.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcHceEvent2 parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return (NfcHceEvent2) f3972u.parseFrom(r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcHceEvent2 parseFrom(byte[] r8) {
        return (NfcHceEvent2) f3972u.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcHceEvent2 parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return (NfcHceEvent2) f3972u.parseFrom(r8, r10);
    }
}
