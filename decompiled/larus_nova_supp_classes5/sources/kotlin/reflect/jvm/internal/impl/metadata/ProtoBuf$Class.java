package kotlin.reflect.jvm.internal.impl.metadata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$Class extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Class> implements ProtoBuf$ClassOrBuilder {
    public static Parser<ProtoBuf$Class> PARSER;
    private static final ProtoBuf$Class defaultInstance = null;
    private int bitField0_;
    private int companionObjectName_;
    private List<ProtoBuf$Constructor> constructor_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private List<ProtoBuf$EnumEntry> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<ProtoBuf$Function> function_;
    private int inlineClassUnderlyingPropertyName_;
    private int inlineClassUnderlyingTypeId_;
    private ProtoBuf$Type inlineClassUnderlyingType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
    private List<Integer> multiFieldValueClassUnderlyingName_;
    private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
    private List<Integer> multiFieldValueClassUnderlyingTypeId_;
    private List<ProtoBuf$Type> multiFieldValueClassUnderlyingType_;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<ProtoBuf$Property> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<ProtoBuf$Type> supertype_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;
    private List<Integer> versionRequirement_;

    public static final enum Kind extends Enum<Kind> implements Internal$EnumLite {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind ANNOTATION_CLASS = null;
        public static final Kind CLASS = null;
        public static final Kind COMPANION_OBJECT = null;
        public static final Kind ENUM_CLASS = null;
        public static final Kind ENUM_ENTRY = null;
        public static final Kind INTERFACE = null;
        public static final Kind OBJECT = null;
        private static Internal$EnumLiteMap<Kind> internalValueMap;
        private final int value;

        static {
            Kind r0 = new Kind("CLASS", 0, 0, 0);
            CLASS = r0;
            Kind r1 = new Kind("INTERFACE", 1, 1, 1);
            INTERFACE = r1;
            Kind r3 = new Kind("ENUM_CLASS", 2, 2, 2);
            ENUM_CLASS = r3;
            Kind r5 = new Kind("ENUM_ENTRY", 3, 3, 3);
            ENUM_ENTRY = r5;
            Kind r7 = new Kind("ANNOTATION_CLASS", 4, 4, 4);
            ANNOTATION_CLASS = r7;
            Kind r9 = new Kind("OBJECT", 5, 5, 5);
            OBJECT = r9;
            Kind r11 = new Kind("COMPANION_OBJECT", 6, 6, 6);
            COMPANION_OBJECT = r11;
            $VALUES = new Kind[]{r0, r1, r3, r5, r7, r9, r11};
            internalValueMap = new AnonymousClass1();
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Kind valueOf(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return COMPANION_OBJECT;
        L8:
            return OBJECT;
        L10:
            return ANNOTATION_CLASS;
        L12:
            return ENUM_ENTRY;
        L14:
            return ENUM_CLASS;
        L16:
            return INTERFACE;
        L18:
            return CLASS;
        }

        public static Kind valueOf(String r1) {
            return (Kind) a.a(Kind.class, r1);
        }

        private Kind(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.value = r4;
        }
    }

    private void initFields() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.contextReceiverType_ = Collections.emptyList();
        this.contextReceiverTypeId_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.inlineClassUnderlyingPropertyName_ = 0;
        this.inlineClassUnderlyingType_ = ProtoBuf$Type.getDefaultInstance();
        this.inlineClassUnderlyingTypeId_ = 0;
        this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
        this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
        this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Class r0 = new ProtoBuf$Class(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public int getMultiFieldValueClassUnderlyingNameCount() {
        return this.multiFieldValueClassUnderlyingName_.size();
    }

    public int getMultiFieldValueClassUnderlyingTypeCount() {
        return this.multiFieldValueClassUnderlyingType_.size();
    }

    public int getMultiFieldValueClassUnderlyingTypeIdCount() {
        return this.multiFieldValueClassUnderlyingTypeId_.size();
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    L9:
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r3 >= this.supertypeId_.size()) goto L13;
        r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.supertypeId_, r3)).intValue());
        r3 = r3 + 1;
        goto L11
    L13:
        int r5 = r1 + r4;
        if (getSupertypeIdList().isEmpty() == true) goto L16;
        r5 = (r5 + 1) + CodedOutputStream.computeInt32SizeNoTag(r4);
    L16:
        this.supertypeIdMemoizedSerializedSize = r4;
        if ((this.bitField0_ & 2) != 2) goto L20;
        r5 = r5 + CodedOutputStream.computeInt32Size(3, this.fqName_);
    L20:
        if ((this.bitField0_ & 4) != 4) goto L22;
        r5 = r5 + CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
    L22:
        int r6 = 0;
    L24:
        if (r6 >= this.typeParameter_.size()) goto L26;
        r5 = r5 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.typeParameter_, r6));
        r6 = r6 + 1;
        goto L24
    L26:
        int r7 = 0;
    L28:
        if (r7 >= this.supertype_.size()) goto L30;
        r5 = r5 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.supertype_, r7));
        r7 = r7 + 1;
        goto L28
    L30:
        int r8 = 0;
        int r9 = 0;
    L32:
        if (r8 >= this.nestedClassName_.size()) goto L34;
        r9 = r9 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.nestedClassName_, r8)).intValue());
        r8 = r8 + 1;
        goto L32
    L34:
        int r10 = r5 + r9;
        if (getNestedClassNameList().isEmpty() == true) goto L37;
        r10 = (r10 + 1) + CodedOutputStream.computeInt32SizeNoTag(r9);
    L37:
        this.nestedClassNameMemoizedSerializedSize = r9;
        int r11 = 0;
    L39:
        if (r11 >= this.constructor_.size()) goto L41;
        r10 = r10 + CodedOutputStream.computeMessageSize(8, (MessageLite) ListProtector.get(this.constructor_, r11));
        r11 = r11 + 1;
        goto L39
    L41:
        int r12 = 0;
    L43:
        if (r12 >= this.function_.size()) goto L45;
        r10 = r10 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.function_, r12));
        r12 = r12 + 1;
        goto L43
    L45:
        int r13 = 0;
    L47:
        if (r13 >= this.property_.size()) goto L49;
        r10 = r10 + CodedOutputStream.computeMessageSize(10, (MessageLite) ListProtector.get(this.property_, r13));
        r13 = r13 + 1;
        goto L47
    L49:
        int r14 = 0;
    L51:
        if (r14 >= this.typeAlias_.size()) goto L53;
        r10 = r10 + CodedOutputStream.computeMessageSize(11, (MessageLite) ListProtector.get(this.typeAlias_, r14));
        r14 = r14 + 1;
        goto L51
    L53:
        int r15 = 0;
    L55:
        if (r15 >= this.enumEntry_.size()) goto L57;
        r10 = r10 + CodedOutputStream.computeMessageSize(13, (MessageLite) ListProtector.get(this.enumEntry_, r15));
        r15 = r15 + 1;
        goto L55
    L57:
        int r16 = 0;
        int r17 = 0;
    L59:
        if (r16 >= this.sealedSubclassFqName_.size()) goto L61;
        r17 = r17 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.sealedSubclassFqName_, r16)).intValue());
        r16 = r16 + 1;
        goto L59
    L61:
        int r18 = r10 + r17;
        if (getSealedSubclassFqNameList().isEmpty() == true) goto L64;
        r18 = (r18 + 2) + CodedOutputStream.computeInt32SizeNoTag(r17);
    L64:
        this.sealedSubclassFqNameMemoizedSerializedSize = r17;
        if ((this.bitField0_ & 8) != 8) goto L68;
        r18 = r18 + CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
    L68:
        if ((this.bitField0_ & 16) != 16) goto L71;
        r18 = r18 + CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
    L71:
        if ((this.bitField0_ & 32) != 32) goto L73;
        r18 = r18 + CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
    L73:
        int r19 = 0;
    L75:
        if (r19 >= this.contextReceiverType_.size()) goto L77;
        r18 = r18 + CodedOutputStream.computeMessageSize(20, (MessageLite) ListProtector.get(this.contextReceiverType_, r19));
        r19 = r19 + 1;
        goto L75
    L77:
        int r20 = 0;
        int r21 = 0;
    L79:
        if (r20 >= this.contextReceiverTypeId_.size()) goto L81;
        r21 = r21 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r20)).intValue());
        r20 = r20 + 1;
        goto L79
    L81:
        int r22 = r18 + r21;
        if (getContextReceiverTypeIdList().isEmpty() == true) goto L84;
        r22 = (r22 + 2) + CodedOutputStream.computeInt32SizeNoTag(r21);
    L84:
        this.contextReceiverTypeIdMemoizedSerializedSize = r21;
        int r23 = 0;
        int r24 = 0;
    L86:
        if (r23 >= this.multiFieldValueClassUnderlyingName_.size()) goto L88;
        r24 = r24 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingName_, r23)).intValue());
        r23 = r23 + 1;
        goto L86
    L88:
        int r25 = r22 + r24;
        if (getMultiFieldValueClassUnderlyingNameList().isEmpty() == true) goto L91;
        r25 = (r25 + 2) + CodedOutputStream.computeInt32SizeNoTag(r24);
    L91:
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r24;
        int r26 = 0;
    L93:
        if (r26 >= this.multiFieldValueClassUnderlyingType_.size()) goto L95;
        r25 = r25 + CodedOutputStream.computeMessageSize(23, (MessageLite) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r26));
        r26 = r26 + 1;
        goto L93
    L95:
        int r27 = 0;
        int r28 = 0;
    L97:
        if (r27 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
        r28 = r28 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingTypeId_, r27)).intValue());
        r27 = r27 + 1;
        goto L97
    L99:
        int r29 = r25 + r28;
        if (getMultiFieldValueClassUnderlyingTypeIdList().isEmpty() == true) goto L102;
        r29 = (r29 + 2) + CodedOutputStream.computeInt32SizeNoTag(r28);
    L102:
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r28;
        if ((this.bitField0_ & 64) != 64) goto L105;
        r29 = r29 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
    L105:
        int r30 = 0;
    L107:
        if (r2 >= this.versionRequirement_.size()) goto L109;
        r30 = r30 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r2)).intValue());
        r2 = r2 + 1;
        goto L107
    L109:
        int r31 = (r29 + r30) + (getVersionRequirementList().size() * 2);
        if ((this.bitField0_ & 128) != 128) goto L112;
        r31 = r31 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
    L112:
        int r32 = (r31 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r32;
        return r32;
    L8:
        r1 = 0;
        goto L9
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public boolean hasCompanionObjectName() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasFqName() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasInlineClassUnderlyingPropertyName() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasInlineClassUnderlyingType() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasInlineClassUnderlyingTypeId() {
        if ((this.bitField0_ & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeTable() {
        if ((this.bitField0_ & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasVersionRequirementTable() {
        if ((this.bitField0_ & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (hasFqName() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= getTypeParameterCount()) goto L20;
        if (getTypeParameter(r1).isInitialized() == false) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        this.memoizedIsInitialized = 0;
        return false;
    L20:
        int r2 = 0;
    L22:
        if (r2 >= getSupertypeCount()) goto L28;
        if (getSupertype(r2).isInitialized() == false) goto L25;
        r2 = r2 + 1;
        goto L22
    L25:
        this.memoizedIsInitialized = 0;
        return false;
    L28:
        int r3 = 0;
    L30:
        if (r3 >= getContextReceiverTypeCount()) goto L36;
        if (getContextReceiverType(r3).isInitialized() == false) goto L33;
        r3 = r3 + 1;
        goto L30
    L33:
        this.memoizedIsInitialized = 0;
        return false;
    L36:
        int r4 = 0;
    L38:
        if (r4 >= getConstructorCount()) goto L44;
        if (getConstructor(r4).isInitialized() == false) goto L41;
        r4 = r4 + 1;
        goto L38
    L41:
        this.memoizedIsInitialized = 0;
        return false;
    L44:
        int r5 = 0;
    L46:
        if (r5 >= getFunctionCount()) goto L52;
        if (getFunction(r5).isInitialized() == false) goto L49;
        r5 = r5 + 1;
        goto L46
    L49:
        this.memoizedIsInitialized = 0;
        return false;
    L52:
        int r6 = 0;
    L54:
        if (r6 >= getPropertyCount()) goto L60;
        if (getProperty(r6).isInitialized() == false) goto L57;
        r6 = r6 + 1;
        goto L54
    L57:
        this.memoizedIsInitialized = 0;
        return false;
    L60:
        int r7 = 0;
    L62:
        if (r7 >= getTypeAliasCount()) goto L68;
        if (getTypeAlias(r7).isInitialized() == false) goto L65;
        r7 = r7 + 1;
        goto L62
    L65:
        this.memoizedIsInitialized = 0;
        return false;
    L68:
        int r8 = 0;
    L70:
        if (r8 >= getEnumEntryCount()) goto L77;
        if (getEnumEntry(r8).isInitialized() == false) goto L73;
        r8 = r8 + 1;
        goto L70
    L73:
        this.memoizedIsInitialized = 0;
        return false;
    L77:
        if (hasInlineClassUnderlyingType() == true) goto L79;
    L82:
        int r9 = 0;
    L84:
        if (r9 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L91;
        if (getMultiFieldValueClassUnderlyingType(r9).isInitialized() == false) goto L87;
        r9 = r9 + 1;
        goto L84
    L87:
        this.memoizedIsInitialized = 0;
        return false;
    L91:
        if (hasTypeTable() == false) goto L97;
        if (getTypeTable().isInitialized() == true) goto L97;
        this.memoizedIsInitialized = 0;
        return false;
    L97:
        if (extensionsAreInitialized() == true) goto L100;
        this.memoizedIsInitialized = 0;
        return false;
    L100:
        this.memoizedIsInitialized = 1;
        return true;
    L79:
        if (getInlineClassUnderlyingType().isInitialized() == true) goto L82;
        this.memoizedIsInitialized = 0;
        return false;
    }

    public static Builder newBuilder() {
        return Builder.access$8700();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Class getDefaultInstance() {
        return defaultInstance;
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public List<ProtoBuf$Constructor> getConstructorList() {
        return this.constructor_;
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public List<ProtoBuf$EnumEntry> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    public int getInlineClassUnderlyingPropertyName() {
        return this.inlineClassUnderlyingPropertyName_;
    }

    public ProtoBuf$Type getInlineClassUnderlyingType() {
        return this.inlineClassUnderlyingType_;
    }

    public int getInlineClassUnderlyingTypeId() {
        return this.inlineClassUnderlyingTypeId_;
    }

    public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
        return this.multiFieldValueClassUnderlyingName_;
    }

    public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
        return this.multiFieldValueClassUnderlyingTypeId_;
    }

    public List<ProtoBuf$Type> getMultiFieldValueClassUnderlyingTypeList() {
        return this.multiFieldValueClassUnderlyingType_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Class> getParserForType() {
        return PARSER;
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<ProtoBuf$Type> getSupertypeList() {
        return this.supertype_;
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Class getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: newBuilderForType */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo379newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: toBuilder */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo380toBuilder() {
        return toBuilder();
    }

    private ProtoBuf$Class(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Class, ?> r2) {
        super(r2);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$10000(ProtoBuf$Class r0) {
        return r0.property_;
    }

    public static /* synthetic */ List access$10100(ProtoBuf$Class r0) {
        return r0.typeAlias_;
    }

    public static /* synthetic */ List access$10200(ProtoBuf$Class r0) {
        return r0.enumEntry_;
    }

    public static /* synthetic */ List access$10300(ProtoBuf$Class r0) {
        return r0.sealedSubclassFqName_;
    }

    public static /* synthetic */ List access$10700(ProtoBuf$Class r0) {
        return r0.multiFieldValueClassUnderlyingName_;
    }

    public static /* synthetic */ List access$10800(ProtoBuf$Class r0) {
        return r0.multiFieldValueClassUnderlyingType_;
    }

    public static /* synthetic */ List access$10900(ProtoBuf$Class r0) {
        return r0.multiFieldValueClassUnderlyingTypeId_;
    }

    public static /* synthetic */ List access$11100(ProtoBuf$Class r0) {
        return r0.versionRequirement_;
    }

    public static /* synthetic */ ByteString access$11400(ProtoBuf$Class r0) {
        return r0.unknownFields;
    }

    public static /* synthetic */ List access$9200(ProtoBuf$Class r0) {
        return r0.typeParameter_;
    }

    public static /* synthetic */ List access$9300(ProtoBuf$Class r0) {
        return r0.supertype_;
    }

    public static /* synthetic */ List access$9400(ProtoBuf$Class r0) {
        return r0.supertypeId_;
    }

    public static /* synthetic */ List access$9500(ProtoBuf$Class r0) {
        return r0.nestedClassName_;
    }

    public static /* synthetic */ List access$9600(ProtoBuf$Class r0) {
        return r0.contextReceiverType_;
    }

    public static /* synthetic */ List access$9700(ProtoBuf$Class r0) {
        return r0.contextReceiverTypeId_;
    }

    public static /* synthetic */ List access$9800(ProtoBuf$Class r0) {
        return r0.constructor_;
    }

    public static /* synthetic */ List access$9900(ProtoBuf$Class r0) {
        return r0.function_;
    }

    public static Builder newBuilder(ProtoBuf$Class r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Constructor getConstructor(int r2) {
        return (ProtoBuf$Constructor) ListProtector.get(this.constructor_, r2);
    }

    public ProtoBuf$Type getContextReceiverType(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.contextReceiverType_, r2);
    }

    public ProtoBuf$EnumEntry getEnumEntry(int r2) {
        return (ProtoBuf$EnumEntry) ListProtector.get(this.enumEntry_, r2);
    }

    public ProtoBuf$Function getFunction(int r2) {
        return (ProtoBuf$Function) ListProtector.get(this.function_, r2);
    }

    public ProtoBuf$Type getMultiFieldValueClassUnderlyingType(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r2);
    }

    public ProtoBuf$Property getProperty(int r2) {
        return (ProtoBuf$Property) ListProtector.get(this.property_, r2);
    }

    public ProtoBuf$Type getSupertype(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.supertype_, r2);
    }

    public ProtoBuf$TypeAlias getTypeAlias(int r2) {
        return (ProtoBuf$TypeAlias) ListProtector.get(this.typeAlias_, r2);
    }

    public ProtoBuf$TypeParameter getTypeParameter(int r2) {
        return (ProtoBuf$TypeParameter) ListProtector.get(this.typeParameter_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r8.writeInt32(1, this.flags_);
    L6:
        if (getSupertypeIdList().size() <= 0) goto L8;
        r8.writeRawVarint32(18);
        r8.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
    L8:
        int r1 = 0;
        int r3 = 0;
    L10:
        if (r3 >= this.supertypeId_.size()) goto L13;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.supertypeId_, r3)).intValue());
        r3 = r3 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 2) != 2) goto L16;
        r8.writeInt32(3, this.fqName_);
    L16:
        if ((this.bitField0_ & 4) != 4) goto L18;
        r8.writeInt32(4, this.companionObjectName_);
    L18:
        int r4 = 0;
    L20:
        if (r4 >= this.typeParameter_.size()) goto L22;
        r8.writeMessage(5, (MessageLite) ListProtector.get(this.typeParameter_, r4));
        r4 = r4 + 1;
        goto L20
    L22:
        int r5 = 0;
    L24:
        if (r5 >= this.supertype_.size()) goto L27;
        r8.writeMessage(6, (MessageLite) ListProtector.get(this.supertype_, r5));
        r5 = r5 + 1;
        goto L24
    L27:
        if (getNestedClassNameList().size() <= 0) goto L29;
        r8.writeRawVarint32(58);
        r8.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
    L29:
        int r6 = 0;
    L31:
        if (r6 >= this.nestedClassName_.size()) goto L33;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.nestedClassName_, r6)).intValue());
        r6 = r6 + 1;
        goto L31
    L33:
        int r7 = 0;
    L35:
        if (r7 >= this.constructor_.size()) goto L37;
        r8.writeMessage(8, (MessageLite) ListProtector.get(this.constructor_, r7));
        r7 = r7 + 1;
        goto L35
    L37:
        int r9 = 0;
    L39:
        if (r9 >= this.function_.size()) goto L41;
        r8.writeMessage(9, (MessageLite) ListProtector.get(this.function_, r9));
        r9 = r9 + 1;
        goto L39
    L41:
        int r10 = 0;
    L43:
        if (r10 >= this.property_.size()) goto L45;
        r8.writeMessage(10, (MessageLite) ListProtector.get(this.property_, r10));
        r10 = r10 + 1;
        goto L43
    L45:
        int r11 = 0;
    L47:
        if (r11 >= this.typeAlias_.size()) goto L49;
        r8.writeMessage(11, (MessageLite) ListProtector.get(this.typeAlias_, r11));
        r11 = r11 + 1;
        goto L47
    L49:
        int r12 = 0;
    L51:
        if (r12 >= this.enumEntry_.size()) goto L54;
        r8.writeMessage(13, (MessageLite) ListProtector.get(this.enumEntry_, r12));
        r12 = r12 + 1;
        goto L51
    L54:
        if (getSealedSubclassFqNameList().size() <= 0) goto L56;
        r8.writeRawVarint32(130);
        r8.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
    L56:
        int r13 = 0;
    L58:
        if (r13 >= this.sealedSubclassFqName_.size()) goto L61;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.sealedSubclassFqName_, r13)).intValue());
        r13 = r13 + 1;
        goto L58
    L61:
        if ((this.bitField0_ & 8) != 8) goto L64;
        r8.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
    L64:
        if ((this.bitField0_ & 16) != 16) goto L67;
        r8.writeMessage(18, this.inlineClassUnderlyingType_);
    L67:
        if ((this.bitField0_ & 32) != 32) goto L69;
        r8.writeInt32(19, this.inlineClassUnderlyingTypeId_);
    L69:
        int r2 = 0;
    L71:
        if (r2 >= this.contextReceiverType_.size()) goto L74;
        r8.writeMessage(20, (MessageLite) ListProtector.get(this.contextReceiverType_, r2));
        r2 = r2 + 1;
        goto L71
    L74:
        if (getContextReceiverTypeIdList().size() <= 0) goto L76;
        r8.writeRawVarint32(170);
        r8.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
    L76:
        int r14 = 0;
    L78:
        if (r14 >= this.contextReceiverTypeId_.size()) goto L81;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r14)).intValue());
        r14 = r14 + 1;
        goto L78
    L81:
        if (getMultiFieldValueClassUnderlyingNameList().size() <= 0) goto L83;
        r8.writeRawVarint32(178);
        r8.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
    L83:
        int r15 = 0;
    L85:
        if (r15 >= this.multiFieldValueClassUnderlyingName_.size()) goto L87;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingName_, r15)).intValue());
        r15 = r15 + 1;
        goto L85
    L87:
        int r16 = 0;
    L89:
        if (r16 >= this.multiFieldValueClassUnderlyingType_.size()) goto L92;
        r8.writeMessage(23, (MessageLite) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r16));
        r16 = r16 + 1;
        goto L89
    L92:
        if (getMultiFieldValueClassUnderlyingTypeIdList().size() <= 0) goto L94;
        r8.writeRawVarint32(194);
        r8.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
    L94:
        int r17 = 0;
    L96:
        if (r17 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingTypeId_, r17)).intValue());
        r17 = r17 + 1;
        goto L96
    L99:
        if ((this.bitField0_ & 64) != 64) goto L102;
        r8.writeMessage(30, this.typeTable_);
    L102:
        if (r1 >= this.versionRequirement_.size()) goto L105;
        r8.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r1)).intValue());
        r1 = r1 + 1;
        goto L102
    L105:
        if ((this.bitField0_ & 128) != 128) goto L107;
        r8.writeMessage(32, this.versionRequirementTable_);
    L107:
        r0.writeUntil(19000, r8);
        r8.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Class(boolean r1) {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Class(CodedInputStream r18, ExtensionRegistryLite r19) throws InvalidProtocolBufferException {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r4 = ByteString.newOutput();
        CodedOutputStream r6 = CodedOutputStream.newInstance(r4, 1);
        boolean r7 = false;
        int r8 = 0;
    L4:
        if (r7 == true) goto L233;
        int r15 = r18.readTag();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        Cloneable r16 = null;
        switch(r15) {
            case 0: goto L164;
            case 8: goto L161;
            case 16: goto L157;
            case 18: goto L147;
            case 24: goto L146;
            case 32: goto L145;
            case 42: goto L142;
            case 50: goto L138;
            case 56: goto L134;
            case 58: goto L124;
            case 66: goto L121;
            case 74: goto L117;
            case 82: goto L113;
            case 90: goto L109;
            case 106: goto L105;
            case 128: goto L101;
            case 130: goto L91;
            case 136: goto L90;
            case 146: goto L84;
            case 152: goto L82;
            case 162: goto L79;
            case 168: goto L75;
            case 170: goto L65;
            case 176: goto L62;
            case 178: goto L52;
            case 186: goto L49;
            case 192: goto L45;
            case 194: goto L35;
            case 242: goto L29;
            case 248: goto L25;
            case 250: goto L15;
            case 258: goto L9;
            default: goto L165;
        };     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L15:
        int r12 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 4194304) == 4194304) goto L21;
        if (r18.getBytesUntilLimit() <= 0) goto L21;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 4194304;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L21:
        if (r18.getBytesUntilLimit() <= 0) goto L23;
        this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L21
    L23:
        r18.popLimit(r12);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L35:
        int r11 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 1048576) == 1048576) goto L41;
        if (r18.getBytesUntilLimit() <= 0) goto L41;
        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 1048576;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L41:
        if (r18.getBytesUntilLimit() <= 0) goto L43;
        this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L41
    L43:
        r18.popLimit(r11);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L52:
        int r13 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 262144) == 262144) goto L58;
        if (r18.getBytesUntilLimit() <= 0) goto L58;
        this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 262144;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L58:
        if (r18.getBytesUntilLimit() <= 0) goto L60;
        this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L58
    L60:
        r18.popLimit(r13);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L65:
        int r14 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 256) == 256) goto L71;
        if (r18.getBytesUntilLimit() <= 0) goto L71;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 256;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L71:
        if (r18.getBytesUntilLimit() <= 0) goto L73;
        this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L71
    L73:
        r18.popLimit(r14);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L82:
        this.bitField0_ |= 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.inlineClassUnderlyingTypeId_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L90:
        this.bitField0_ |= 8;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.inlineClassUnderlyingPropertyName_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L91:
        int r17 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 16384) == 16384) goto L97;
        if (r18.getBytesUntilLimit() <= 0) goto L97;
        this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 16384;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L97:
        if (r18.getBytesUntilLimit() <= 0) goto L99;
        this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L97
    L99:
        r18.popLimit(r17);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L124:
        int r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 64) == 64) goto L130;
        if (r18.getBytesUntilLimit() <= 0) goto L130;
        this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L130:
        if (r18.getBytesUntilLimit() <= 0) goto L132;
        this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L130
    L132:
        r18.popLimit(r110);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L145:
        this.bitField0_ |= 4;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.companionObjectName_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L146:
        this.bitField0_ |= 2;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.fqName_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L147:
        int r111 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if ((r8 & 32) == 32) goto L153;
        if (r18.getBytesUntilLimit() <= 0) goto L153;
        this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L153:
        if (r18.getBytesUntilLimit() <= 0) goto L155;
        this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L153
    L155:
        r18.popLimit(r111);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L161:
        this.bitField0_ |= 1;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.flags_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L165:
        if (parseUnknownField(r18, r6, r19, r15) == true) goto L4;
    L9:
        if ((this.bitField0_ & 128) != 128) goto L11;
        r16 = this.versionRequirementTable_.mo380toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L11:
        ProtoBuf$VersionRequirementTable.Builder r112 = r16;
        ProtoBuf$VersionRequirementTable r113 = (ProtoBuf$VersionRequirementTable) r18.readMessage(ProtoBuf$VersionRequirementTable.PARSER, r19);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.versionRequirementTable_ = r113;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if (r112 == 0) goto L14;
        r112.mergeFrom(r113);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.versionRequirementTable_ = r112.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L14:
        this.bitField0_ |= 128;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L25:
        if ((r8 & 4194304) == 4194304) goto L27;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 4194304;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L27:
        this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L29:
        if ((this.bitField0_ & 64) != 64) goto L31;
        r16 = this.typeTable_.mo380toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L31:
        ProtoBuf$TypeTable.Builder r114 = r16;
        ProtoBuf$TypeTable r115 = (ProtoBuf$TypeTable) r18.readMessage(ProtoBuf$TypeTable.PARSER, r19);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.typeTable_ = r115;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if (r114 == 0) goto L34;
        r114.mergeFrom(r115);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.typeTable_ = r114.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L34:
        this.bitField0_ |= 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L45:
        if ((r8 & 1048576) == 1048576) goto L47;
        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 1048576;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L47:
        this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L49:
        if ((r8 & 524288) == 524288) goto L51;
        this.multiFieldValueClassUnderlyingType_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 524288;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L51:
        this.multiFieldValueClassUnderlyingType_.add((ProtoBuf$Type) r18.readMessage(ProtoBuf$Type.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L62:
        if ((r8 & 262144) == 262144) goto L64;
        this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 262144;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L64:
        this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L75:
        if ((r8 & 256) == 256) goto L77;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 256;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L77:
        this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L79:
        if ((r8 & 128) == 128) goto L81;
        this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 128;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L81:
        this.contextReceiverType_.add((ProtoBuf$Type) r18.readMessage(ProtoBuf$Type.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L84:
        if ((this.bitField0_ & 16) != 16) goto L86;
        r16 = this.inlineClassUnderlyingType_.mo380toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L86:
        ProtoBuf$Type.Builder r116 = r16;
        ProtoBuf$Type r117 = (ProtoBuf$Type) r18.readMessage(ProtoBuf$Type.PARSER, r19);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.inlineClassUnderlyingType_ = r117;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        if (r116 == 0) goto L89;
        r116.mergeFrom(r117);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        this.inlineClassUnderlyingType_ = r116.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L89:
        this.bitField0_ |= 16;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L101:
        if ((r8 & 16384) == 16384) goto L103;
        this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 16384;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L103:
        this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L105:
        if ((r8 & 8192) == 8192) goto L107;
        this.enumEntry_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 8192;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L107:
        this.enumEntry_.add((ProtoBuf$EnumEntry) r18.readMessage(ProtoBuf$EnumEntry.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L109:
        if ((r8 & 4096) == 4096) goto L111;
        this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 4096;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L111:
        this.typeAlias_.add((ProtoBuf$TypeAlias) r18.readMessage(ProtoBuf$TypeAlias.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L113:
        if ((r8 & 2048) == 2048) goto L115;
        this.property_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 2048;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L115:
        this.property_.add((ProtoBuf$Property) r18.readMessage(ProtoBuf$Property.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L117:
        if ((r8 & 1024) == 1024) goto L119;
        this.function_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 1024;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L119:
        this.function_.add((ProtoBuf$Function) r18.readMessage(ProtoBuf$Function.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L121:
        if ((r8 & 512) == 512) goto L123;
        this.constructor_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 512;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L123:
        this.constructor_.add((ProtoBuf$Constructor) r18.readMessage(ProtoBuf$Constructor.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L134:
        if ((r8 & 64) == 64) goto L136;
        this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L136:
        this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L138:
        if ((r8 & 16) == 16) goto L140;
        this.supertype_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 16;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L140:
        this.supertype_.add((ProtoBuf$Type) r18.readMessage(ProtoBuf$Type.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L142:
        if ((r8 & 8) == 8) goto L144;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 8;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L144:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r18.readMessage(ProtoBuf$TypeParameter.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        goto L4
    L157:
        if ((r8 & 32) == 32) goto L159;
        this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        r8 = r8 | 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L159:
        this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
    L164:
        r7 = true;
        goto L4
    L168:
        th = move-exception;
        if ((r8 & 32) != 32) goto L181;
        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
    L181:
        if ((r8 & 8) != 8) goto L184;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L184:
        if ((r8 & 16) != 16) goto L187;
        this.supertype_ = Collections.unmodifiableList(this.supertype_);
    L187:
        if ((r8 & 64) != 64) goto L190;
        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
    L190:
        if ((r8 & 512) != 512) goto L193;
        this.constructor_ = Collections.unmodifiableList(this.constructor_);
    L193:
        if ((r8 & 1024) != 1024) goto L196;
        this.function_ = Collections.unmodifiableList(this.function_);
    L196:
        if ((r8 & 2048) != 2048) goto L199;
        this.property_ = Collections.unmodifiableList(this.property_);
    L199:
        if ((r8 & 4096) != 4096) goto L202;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L202:
        if ((r8 & 8192) != 8192) goto L205;
        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
    L205:
        if ((r8 & 16384) != 16384) goto L208;
        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
    L208:
        if ((r8 & 128) != 128) goto L211;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L211:
        if ((r8 & 256) != 256) goto L214;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L214:
        if ((r8 & 262144) != 262144) goto L217;
        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
    L217:
        if ((r8 & 524288) != 524288) goto L220;
        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
    L220:
        if ((r8 & 1048576) != 1048576) goto L223;
        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
    L223:
        if ((r8 & 4194304) != 4194304) goto L291;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L291:
        r6.flush();     // Catch: IOException -> L288 Throwable -> L227
    L227:
        th = move-exception;
        this.unknownFields = r4.toByteString();
        throw th;
    L226:
        this.unknownFields = r4.toByteString();
        makeExtensionsImmutable();
        throw th;
    L174:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L168
    L170:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L168
    L233:
        if ((r8 & 32) != 32) goto L236;
        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
    L236:
        if ((r8 & 8) != 8) goto L239;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L239:
        if ((r8 & 16) != 16) goto L242;
        this.supertype_ = Collections.unmodifiableList(this.supertype_);
    L242:
        if ((r8 & 64) != 64) goto L245;
        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
    L245:
        if ((r8 & 512) != 512) goto L248;
        this.constructor_ = Collections.unmodifiableList(this.constructor_);
    L248:
        if ((r8 & 1024) != 1024) goto L251;
        this.function_ = Collections.unmodifiableList(this.function_);
    L251:
        if ((r8 & 2048) != 2048) goto L254;
        this.property_ = Collections.unmodifiableList(this.property_);
    L254:
        if ((r8 & 4096) != 4096) goto L257;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L257:
        if ((r8 & 8192) != 8192) goto L260;
        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
    L260:
        if ((r8 & 16384) != 16384) goto L263;
        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
    L263:
        if ((r8 & 128) != 128) goto L266;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L266:
        if ((r8 & 256) != 256) goto L269;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L269:
        if ((r8 & 262144) != 262144) goto L272;
        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
    L272:
        if ((r8 & 524288) != 524288) goto L275;
        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
    L275:
        if ((r8 & 1048576) != 1048576) goto L278;
        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
    L278:
        if ((r8 & 4194304) != 4194304) goto L293;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L293:
        r6.flush();     // Catch: IOException -> L287 Throwable -> L282
    L282:
        th = move-exception;
        this.unknownFields = r4.toByteString();
        throw th;
    L281:
        this.unknownFields = r4.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ List access$10002(ProtoBuf$Class r0, List r1) {
        r0.property_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$10102(ProtoBuf$Class r0, List r1) {
        r0.typeAlias_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$10202(ProtoBuf$Class r0, List r1) {
        r0.enumEntry_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$10302(ProtoBuf$Class r0, List r1) {
        r0.sealedSubclassFqName_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$10402(ProtoBuf$Class r0, int r1) {
        r0.inlineClassUnderlyingPropertyName_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$10502(ProtoBuf$Class r0, ProtoBuf$Type r1) {
        r0.inlineClassUnderlyingType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$10602(ProtoBuf$Class r0, int r1) {
        r0.inlineClassUnderlyingTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$10702(ProtoBuf$Class r0, List r1) {
        r0.multiFieldValueClassUnderlyingName_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$10802(ProtoBuf$Class r0, List r1) {
        r0.multiFieldValueClassUnderlyingType_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$10902(ProtoBuf$Class r0, List r1) {
        r0.multiFieldValueClassUnderlyingTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$TypeTable access$11002(ProtoBuf$Class r0, ProtoBuf$TypeTable r1) {
        r0.typeTable_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$11102(ProtoBuf$Class r0, List r1) {
        r0.versionRequirement_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$VersionRequirementTable access$11202(ProtoBuf$Class r0, ProtoBuf$VersionRequirementTable r1) {
        r0.versionRequirementTable_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$11302(ProtoBuf$Class r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$8902(ProtoBuf$Class r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$9002(ProtoBuf$Class r0, int r1) {
        r0.fqName_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$9102(ProtoBuf$Class r0, int r1) {
        r0.companionObjectName_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9202(ProtoBuf$Class r0, List r1) {
        r0.typeParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9302(ProtoBuf$Class r0, List r1) {
        r0.supertype_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9402(ProtoBuf$Class r0, List r1) {
        r0.supertypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9502(ProtoBuf$Class r0, List r1) {
        r0.nestedClassName_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9602(ProtoBuf$Class r0, List r1) {
        r0.contextReceiverType_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9702(ProtoBuf$Class r0, List r1) {
        r0.contextReceiverTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9802(ProtoBuf$Class r0, List r1) {
        r0.constructor_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$9902(ProtoBuf$Class r0, List r1) {
        r0.function_ = r1;
        return r1;
    }

    public static ProtoBuf$Class parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
        return PARSER.parseFrom(r1, r2);
    }

    public /* synthetic */ ProtoBuf$Class(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Class(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
