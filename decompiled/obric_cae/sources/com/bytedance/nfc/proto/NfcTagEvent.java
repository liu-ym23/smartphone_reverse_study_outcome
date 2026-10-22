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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class NfcTagEvent extends GeneratedMessageV3 implements MessageOrBuilder {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final NfcTagEvent f4014u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Deprecated
    public static final a f4015v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4017b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ByteString f4020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LazyStringList f4021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile Object f4023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile Object f4024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte f4025t;

    public static final enum Type extends Enum<Type> implements ProtocolMessageEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type NDEF_MESSAGE = null;
        public static final int NDEF_MESSAGE_VALUE = 4;
        public static final Type NDEF_READ = null;
        public static final int NDEF_READ_VALUE = 3;
        public static final Type OEM_PACKAGE_EXTRACT = null;
        public static final int OEM_PACKAGE_EXTRACT_VALUE = 5;
        public static final Type TAG_CONNECTED = null;
        public static final int TAG_CONNECTED_VALUE = 1;
        public static final Type TAG_DISPATCH = null;
        public static final int TAG_DISPATCH_VALUE = 2;
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
            return new Type[]{UNKNOWN, TAG_CONNECTED, TAG_DISPATCH, NDEF_READ, NDEF_MESSAGE, OEM_PACKAGE_EXTRACT};
        }

        static {
            UNKNOWN = new Type(BdimCategoryConstants.VALUE_UNKNOWN, 0, 0);
            TAG_CONNECTED = new Type("TAG_CONNECTED", 1, 1);
            TAG_DISPATCH = new Type("TAG_DISPATCH", 2, 2);
            NDEF_READ = new Type("NDEF_READ", 3, 3);
            NDEF_MESSAGE = new Type("NDEF_MESSAGE", 4, 4);
            OEM_PACKAGE_EXTRACT = new Type("OEM_PACKAGE_EXTRACT", 5, 5);
            $VALUES = $values();
            internalValueMap = new a();
            VALUES = values();
        }

        private Type(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static Type forNumber(int r8) {
            if (r8 == 0) goto L26;
            if (r8 == 1) goto L24;
            if (r8 == 2) goto L22;
            if (r8 == 3) goto L20;
            if (r8 == 4) goto L18;
            if (r8 == 5) goto L16;
            return null;
        L16:
            return OEM_PACKAGE_EXTRACT;
        L18:
            return NDEF_MESSAGE;
        L20:
            return NDEF_READ;
        L22:
            return TAG_DISPATCH;
        L24:
            return TAG_CONNECTED;
        L26:
            return UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return NfcTagEvent.getDescriptor().getEnumTypes().get(0);
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

    public class a extends AbstractParser<NfcTagEvent> {
        @Override // com.google.protobuf.Parser
        public final Object parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            b r11 = NfcTagEvent.newBuilder();
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
        public int f4026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4027b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4028m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f4029n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ByteString f4030o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public LazyStringList f4031p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f4032q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f4033r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Object f4034s;

        public b() {
            this.f4027b = 0;
            this.f4030o = ByteString.EMPTY;
            this.f4031p = LazyStringArrayList.EMPTY;
            this.f4033r = "";
            this.f4034s = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return f8.a.f7349c;
        }

        public final void a() {
            if ((this.f4026a & 16) != 0) goto L6;
            this.f4031p = new LazyStringArrayList(this.f4031p);
            this.f4026a |= 16;
            return;
        }

        public b addAllOemPackages(Iterable<String> r8) {
            a();
            AbstractMessageLite.Builder.addAll(r8, this.f4031p);
            onChanged();
            return this;
        }

        public b addOemPackages(String r8) {
            if (r8 == null) goto L6;
            a();
            this.f4031p.add(r8);
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b addOemPackagesBytes(ByteString r8) {
            if (r8 == null) goto L6;
            a();
            this.f4031p.add(r8);
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcTagEvent build() {
            NfcTagEvent r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NfcTagEvent buildPartial() {
            NfcTagEvent r8 = new NfcTagEvent(this);
            if ((this.f4026a & 16) == 0) goto L5;
            this.f4031p = this.f4031p.getUnmodifiableView();
            this.f4026a &= -17;
        L5:
            r8.f4021p = this.f4031p;
            int r10 = this.f4026a;
            if (r10 != 0) goto L8;
        L30:
            onBuilt();
            return r8;
        L8:
            if ((r10 & 1) == 0) goto L10;
            r8.f4017b = this.f4027b;
            int r11 = 1;
        L12:
            if ((r10 & 2) == 0) goto L15;
            r8.f4018m = this.f4028m;
            r11 = r11 | 2;
        L15:
            if ((r10 & 4) == 0) goto L18;
            r8.f4019n = this.f4029n;
            r11 = r11 | 4;
        L18:
            if ((r10 & 8) == 0) goto L21;
            r8.f4020o = this.f4030o;
            r11 = r11 | 8;
        L21:
            if ((r10 & 32) == 0) goto L24;
            r8.f4022q = this.f4032q;
            r11 = r11 | 16;
        L24:
            if ((r10 & 64) == 0) goto L27;
            r8.f4023r = this.f4033r;
            r11 = r11 | 32;
        L27:
            if ((r10 & 128) == 0) goto L29;
            r8.f4024s = this.f4034s;
            r11 = r11 | 64;
        L29:
            r8.f4016a |= r11;
            goto L30
        L10:
            r11 = 0;
            goto L12
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clear() {
            super.clear();
            this.f4026a = 0;
            this.f4027b = 0;
            this.f4028m = false;
            this.f4029n = false;
            this.f4030o = ByteString.EMPTY;
            this.f4031p = LazyStringArrayList.EMPTY;
            this.f4026a = 0 & (-17);
            this.f4032q = 0;
            this.f4033r = "";
            this.f4034s = "";
            return this;
        }

        public b clearConnected() {
            this.f4026a &= -3;
            this.f4028m = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b clearField(Descriptors.FieldDescriptor r8) {
            return (b) super.clearField(r8);
        }

        public b clearIsSkipped() {
            this.f4026a &= -5;
            this.f4029n = false;
            onChanged();
            return this;
        }

        public b clearNdefPayload() {
            this.f4026a &= -9;
            this.f4030o = NfcTagEvent.getDefaultInstance().getNdefPayload();
            onChanged();
            return this;
        }

        public b clearNdefText() {
            this.f4034s = NfcTagEvent.getDefaultInstance().getNdefText();
            this.f4026a &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public b clearOemPackages() {
            this.f4031p = LazyStringArrayList.EMPTY;
            this.f4026a &= -17;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public b clearOneof(Descriptors.OneofDescriptor r8) {
            return (b) super.clearOneof(r8);
        }

        public b clearTech() {
            this.f4033r = NfcTagEvent.getDefaultInstance().getTech();
            this.f4026a &= -65;
            onChanged();
            return this;
        }

        public b clearTimestamp() {
            this.f4026a &= -33;
            this.f4032q = 0;
            onChanged();
            return this;
        }

        public b clearType() {
            this.f4026a &= -2;
            this.f4027b = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b clone() {
            return (b) super.clone();
        }

        public boolean getConnected() {
            return this.f4028m;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public NfcTagEvent getDefaultInstanceForType() {
            return NfcTagEvent.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return f8.a.f7349c;
        }

        public boolean getIsSkipped() {
            return this.f4029n;
        }

        public ByteString getNdefPayload() {
            return this.f4030o;
        }

        public String getNdefText() {
            Object r8 = this.f4034s;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.f4034s = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        public ByteString getNdefTextBytes() {
            Object r8 = this.f4034s;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.f4034s = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        public String getOemPackages(int r8) {
            return this.f4031p.get(r8);
        }

        public ByteString getOemPackagesBytes(int r8) {
            return this.f4031p.getByteString(r8);
        }

        public int getOemPackagesCount() {
            return this.f4031p.size();
        }

        public ProtocolStringList getOemPackagesList() {
            return this.f4031p.getUnmodifiableView();
        }

        public String getTech() {
            Object r8 = this.f4033r;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.f4033r = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        public ByteString getTechBytes() {
            Object r8 = this.f4033r;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.f4033r = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        public long getTimestamp() {
            return this.f4032q;
        }

        public Type getType() {
            Type r8 = Type.forNumber(this.f4027b);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Type.UNKNOWN;
        }

        public boolean hasConnected() {
            if ((this.f4026a & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasIsSkipped() {
            if ((this.f4026a & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasNdefPayload() {
            if ((this.f4026a & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasNdefText() {
            if ((this.f4026a & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTech() {
            if ((this.f4026a & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTimestamp() {
            if ((this.f4026a & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasType() {
            if ((this.f4026a & 1) != 0) goto L7;
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

        public b mergeFrom(NfcTagEvent r8) {
            if (r8 != NfcTagEvent.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasType() == false) goto L9;
            setType(r8.getType());
        L9:
            if (r8.hasConnected() == false) goto L12;
            setConnected(r8.getConnected());
        L12:
            if (r8.hasIsSkipped() == false) goto L15;
            setIsSkipped(r8.getIsSkipped());
        L15:
            if (r8.hasNdefPayload() == false) goto L18;
            setNdefPayload(r8.getNdefPayload());
        L18:
            if (NfcTagEvent.b(r8).isEmpty() == true) goto L25;
            if (this.f4031p.isEmpty() == false) goto L22;
            this.f4031p = NfcTagEvent.b(r8);
            this.f4026a &= -17;
        L23:
            onChanged();
            goto L25
        L22:
            a();
            this.f4031p.addAll(NfcTagEvent.b(r8));
        L25:
            if (r8.hasTimestamp() == false) goto L28;
            setTimestamp(r8.getTimestamp());
        L28:
            if (r8.hasTech() == false) goto L31;
            this.f4033r = NfcTagEvent.c(r8);
            this.f4026a |= 64;
            onChanged();
        L31:
            if (r8.hasNdefText() == false) goto L33;
            this.f4034s = NfcTagEvent.a(r8);
            this.f4026a |= 128;
            onChanged();
        L33:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final b mergeUnknownFields(UnknownFieldSet r8) {
            return (b) super.mergeUnknownFields(r8);
        }

        public b setConnected(boolean r8) {
            this.f4028m = r8;
            this.f4026a |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (b) super.setField(r8, r10);
        }

        public b setIsSkipped(boolean r8) {
            this.f4029n = r8;
            this.f4026a |= 4;
            onChanged();
            return this;
        }

        public b setNdefPayload(ByteString r8) {
            if (r8 == null) goto L6;
            this.f4030o = r8;
            this.f4026a |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setNdefText(String r8) {
            if (r8 == null) goto L6;
            this.f4034s = r8;
            this.f4026a |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setNdefTextBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.f4034s = r8;
            this.f4026a |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setOemPackages(int r8, String r10) {
            if (r10 == null) goto L6;
            a();
            this.f4031p.set(r8, r10);
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public b setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (b) super.setRepeatedField(r8, r10, r11);
        }

        public b setTech(String r8) {
            if (r8 == null) goto L6;
            this.f4033r = r8;
            this.f4026a |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setTechBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.f4033r = r8;
            this.f4026a |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public b setTimestamp(long r8) {
            this.f4032q = r8;
            this.f4026a |= 32;
            onChanged();
            return this;
        }

        public b setType(Type r8) {
            if (r8 == null) goto L6;
            this.f4026a |= 1;
            this.f4027b = r8.getNumber();
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
            this.f4027b = 0;
            this.f4030o = ByteString.EMPTY;
            this.f4031p = LazyStringArrayList.EMPTY;
            this.f4033r = "";
            this.f4034s = "";
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

        /* JADX INFO: renamed from: getOemPackagesList, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ List m3getOemPackagesList() {
            return getOemPackagesList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return f8.a.f7350d.ensureFieldAccessorsInitialized(NfcTagEvent.class, b.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public b mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L49;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L46;
            int r12 = r8.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r12 == 0) goto L38;
            if (r12 != 8) goto L10;
            int r13 = r8.readEnum();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (Type.forNumber(r13) == null) goto L35;
            this.f4027b = r13;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L35:
            mergeUnknownVarintField(1, r13);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.f4028m = r8.readBool();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.f4029n = r8.readBool();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L14:
            if (r12 != 34) goto L16;
            this.f4030o = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L16:
            if (r12 != 42) goto L18;
            ByteString r14 = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            a();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4031p.add(r14);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L18:
            if (r12 != 48) goto L20;
            this.f4032q = r8.readInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L20:
            if (r12 != 58) goto L22;
            this.f4033r = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 64;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L22:
            if (r12 != 66) goto L24;
            this.f4034s = r8.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.f4026a |= 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L24:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L38:
            r11 = true;
            goto L4
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L46:
            onChanged();
            return this;
        L49:
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
            if ((r8 instanceof NfcTagEvent) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NfcTagEvent) r8);
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
        f4014u = new NfcTagEvent();
        f4015v = new a();
    }

    public NfcTagEvent() {
        this.f4017b = 0;
        this.f4018m = false;
        this.f4019n = false;
        ByteString r8 = ByteString.EMPTY;
        this.f4020o = r8;
        this.f4022q = 0;
        this.f4023r = "";
        this.f4024s = "";
        this.f4025t = -1;
        this.f4017b = 0;
        this.f4020o = r8;
        this.f4021p = LazyStringArrayList.EMPTY;
        this.f4023r = "";
        this.f4024s = "";
    }

    public static /* synthetic */ Object a(NfcTagEvent r8) {
        return r8.f4024s;
    }

    public static /* synthetic */ LazyStringList b(NfcTagEvent r8) {
        return r8.f4021p;
    }

    public static /* synthetic */ Object c(NfcTagEvent r8) {
        return r8.f4023r;
    }

    public static NfcTagEvent getDefaultInstance() {
        return f4014u;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return f8.a.f7349c;
    }

    public static b newBuilder() {
        return f4014u.toBuilder();
    }

    public static NfcTagEvent parseDelimitedFrom(InputStream r8) {
        return (NfcTagEvent) GeneratedMessage.parseDelimitedWithIOException(f4015v, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcTagEvent parseFrom(ByteString r8) {
        return (NfcTagEvent) f4015v.parseFrom(r8);
    }

    public static Parser<NfcTagEvent> parser() {
        return f4015v;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NfcTagEvent) == false) goto L8;
        NfcTagEvent r10 = (NfcTagEvent) r8;
        if (hasType() == r10.hasType()) goto L13;
        return false;
    L13:
        if (hasType() == false) goto L18;
        if (this.f4017b == r10.f4017b) goto L18;
        return false;
    L18:
        if (hasConnected() == r10.hasConnected()) goto L21;
        return false;
    L21:
        if (hasConnected() == false) goto L26;
        if (getConnected() == r10.getConnected()) goto L26;
        return false;
    L26:
        if (hasIsSkipped() == r10.hasIsSkipped()) goto L29;
        return false;
    L29:
        if (hasIsSkipped() == false) goto L34;
        if (getIsSkipped() == r10.getIsSkipped()) goto L34;
        return false;
    L34:
        if (hasNdefPayload() == r10.hasNdefPayload()) goto L37;
        return false;
    L37:
        if (hasNdefPayload() == false) goto L42;
        if (getNdefPayload().equals(r10.getNdefPayload()) == true) goto L42;
        return false;
    L42:
        if (getOemPackagesList().equals(r10.getOemPackagesList()) == true) goto L45;
        return false;
    L45:
        if (hasTimestamp() == r10.hasTimestamp()) goto L48;
        return false;
    L48:
        if (hasTimestamp() == false) goto L53;
        if (getTimestamp() == r10.getTimestamp()) goto L53;
        return false;
    L53:
        if (hasTech() == r10.hasTech()) goto L56;
        return false;
    L56:
        if (hasTech() == false) goto L61;
        if (getTech().equals(r10.getTech()) == true) goto L61;
        return false;
    L61:
        if (hasNdefText() == r10.hasNdefText()) goto L64;
        return false;
    L64:
        if (hasNdefText() == false) goto L69;
        if (getNdefText().equals(r10.getNdefText()) == true) goto L69;
        return false;
    L69:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L71;
        return false;
    L71:
        return true;
    L8:
        return super.equals(r8);
    }

    public boolean getConnected() {
        return this.f4018m;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NfcTagEvent getDefaultInstanceForType() {
        return f4014u;
    }

    public boolean getIsSkipped() {
        return this.f4019n;
    }

    public ByteString getNdefPayload() {
        return this.f4020o;
    }

    public String getNdefText() {
        Object r8 = this.f4024s;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.f4024s = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    public ByteString getNdefTextBytes() {
        Object r8 = this.f4024s;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.f4024s = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    public String getOemPackages(int r8) {
        return this.f4021p.get(r8);
    }

    public ByteString getOemPackagesBytes(int r8) {
        return this.f4021p.getByteString(r8);
    }

    public int getOemPackagesCount() {
        return this.f4021p.size();
    }

    public ProtocolStringList getOemPackagesList() {
        return this.f4021p;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NfcTagEvent> getParserForType() {
        return f4015v;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.f4016a & 1) == 0) goto L8;
        int r11 = CodedOutputStream.computeEnumSize(1, this.f4017b) + 0;
    L10:
        if ((this.f4016a & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeBoolSize(2, this.f4018m);
    L13:
        if ((this.f4016a & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeBoolSize(3, this.f4019n);
    L16:
        if ((this.f4016a & 8) == 0) goto L18;
        r11 = r11 + CodedOutputStream.computeBytesSize(4, this.f4020o);
    L18:
        int r12 = 0;
    L20:
        if (r10 >= this.f4021p.size()) goto L22;
        r12 = r12 + GeneratedMessage.computeStringSizeNoTag(this.f4021p.getRaw(r10));
        r10 = r10 + 1;
        goto L20
    L22:
        int r13 = (getOemPackagesList().size() * 1) + (r11 + r12);
        if ((this.f4016a & 16) == 0) goto L26;
        r13 = r13 + CodedOutputStream.computeInt64Size(6, this.f4022q);
    L26:
        if ((this.f4016a & 32) == 0) goto L29;
        r13 = r13 + GeneratedMessage.computeStringSize(7, this.f4023r);
    L29:
        if ((this.f4016a & 64) == 0) goto L31;
        r13 = r13 + GeneratedMessage.computeStringSize(8, this.f4024s);
    L31:
        int r14 = getUnknownFields().getSerializedSize() + r13;
        this.memoizedSize = r14;
        return r14;
    L8:
        r11 = 0;
        goto L10
    }

    public String getTech() {
        Object r8 = this.f4023r;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.f4023r = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    public ByteString getTechBytes() {
        Object r8 = this.f4023r;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.f4023r = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    public long getTimestamp() {
        return this.f4022q;
    }

    public Type getType() {
        Type r8 = Type.forNumber(this.f4017b);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Type.UNKNOWN;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasConnected() {
        if ((this.f4016a & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasIsSkipped() {
        if ((this.f4016a & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasNdefPayload() {
        if ((this.f4016a & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasNdefText() {
        if ((this.f4016a & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTech() {
        if ((this.f4016a & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTimestamp() {
        if ((this.f4016a & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasType() {
        if ((this.f4016a & 1) != 0) goto L7;
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
        r10 = defpackage.b.a(r10, 37, 1, 53) + this.f4017b;
    L9:
        if (hasConnected() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashBoolean(getConnected());
    L12:
        if (hasIsSkipped() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashBoolean(getIsSkipped());
    L15:
        if (hasNdefPayload() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getNdefPayload().hashCode();
    L18:
        if (getOemPackagesCount() <= 0) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getOemPackagesList().hashCode();
    L21:
        if (hasTimestamp() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + Internal.hashLong(getTimestamp());
    L24:
        if (hasTech() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getTech().hashCode();
    L27:
        if (hasNdefText() == false) goto L29;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getNdefText().hashCode();
    L29:
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
        byte r8 = this.f4025t;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.f4025t = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new NfcTagEvent();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public b toBuilder() {
        if (this != f4014u) goto L6;
        return new b();
    L6:
        return new b().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.f4016a & 1) == 0) goto L6;
        r8.writeEnum(1, this.f4017b);
    L6:
        if ((this.f4016a & 2) == 0) goto L9;
        r8.writeBool(2, this.f4018m);
    L9:
        if ((this.f4016a & 4) == 0) goto L12;
        r8.writeBool(3, this.f4019n);
    L12:
        if ((this.f4016a & 8) == 0) goto L14;
        r8.writeBytes(4, this.f4020o);
    L14:
        int r10 = 0;
    L16:
        if (r10 >= this.f4021p.size()) goto L19;
        GeneratedMessage.writeString(r8, 5, this.f4021p.getRaw(r10));
        r10 = r10 + 1;
        goto L16
    L19:
        if ((this.f4016a & 16) == 0) goto L22;
        r8.writeInt64(6, this.f4022q);
    L22:
        if ((this.f4016a & 32) == 0) goto L25;
        GeneratedMessage.writeString(r8, 7, this.f4023r);
    L25:
        if ((this.f4016a & 64) == 0) goto L27;
        GeneratedMessage.writeString(r8, 8, this.f4024s);
    L27:
        getUnknownFields().writeTo(r8);
    }

    public NfcTagEvent(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.f4017b = 0;
        this.f4018m = false;
        this.f4019n = false;
        this.f4020o = ByteString.EMPTY;
        this.f4022q = 0;
        this.f4023r = "";
        this.f4024s = "";
        this.f4025t = -1;
    }

    public static b newBuilder(NfcTagEvent r8) {
        return f4014u.toBuilder().mergeFrom(r8);
    }

    public static NfcTagEvent parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcTagEvent) GeneratedMessage.parseDelimitedWithIOException(f4015v, r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcTagEvent parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return (NfcTagEvent) f4015v.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    /* JADX INFO: renamed from: getOemPackagesList, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List m2getOemPackagesList() {
        return getOemPackagesList();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public final GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return f8.a.f7350d.ensureFieldAccessorsInitialized(NfcTagEvent.class, b.class);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static NfcTagEvent parseFrom(CodedInputStream r8) {
        return (NfcTagEvent) GeneratedMessage.parseWithIOException(f4015v, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public final Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new b(r8);
    }

    public static NfcTagEvent parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NfcTagEvent) GeneratedMessage.parseWithIOException(f4015v, r8, r10);
    }

    public static NfcTagEvent parseFrom(InputStream r8) {
        return (NfcTagEvent) GeneratedMessage.parseWithIOException(f4015v, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public static NfcTagEvent parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NfcTagEvent) GeneratedMessage.parseWithIOException(f4015v, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcTagEvent parseFrom(ByteBuffer r8) {
        return (NfcTagEvent) f4015v.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcTagEvent parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return (NfcTagEvent) f4015v.parseFrom(r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcTagEvent parseFrom(byte[] r8) {
        return (NfcTagEvent) f4015v.parseFrom(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static NfcTagEvent parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return (NfcTagEvent) f4015v.parseFrom(r8, r10);
    }
}
