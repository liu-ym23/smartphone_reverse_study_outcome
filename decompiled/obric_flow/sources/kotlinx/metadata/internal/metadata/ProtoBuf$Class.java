package kotlinx.metadata.internal.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf$Class extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Class> implements au.d {
    public static final int COMPANION_OBJECT_NAME_FIELD_NUMBER = 4;
    public static final int CONSTRUCTOR_FIELD_NUMBER = 8;
    public static final int CONTEXT_RECEIVER_TYPE_FIELD_NUMBER = 20;
    public static final int CONTEXT_RECEIVER_TYPE_ID_FIELD_NUMBER = 21;
    public static final int ENUM_ENTRY_FIELD_NUMBER = 13;
    public static final int FLAGS_FIELD_NUMBER = 1;
    public static final int FQ_NAME_FIELD_NUMBER = 3;
    public static final int FUNCTION_FIELD_NUMBER = 9;
    public static final int INLINE_CLASS_UNDERLYING_PROPERTY_NAME_FIELD_NUMBER = 17;
    public static final int INLINE_CLASS_UNDERLYING_TYPE_FIELD_NUMBER = 18;
    public static final int INLINE_CLASS_UNDERLYING_TYPE_ID_FIELD_NUMBER = 19;
    public static final int MULTI_FIELD_VALUE_CLASS_UNDERLYING_NAME_FIELD_NUMBER = 22;
    public static final int MULTI_FIELD_VALUE_CLASS_UNDERLYING_TYPE_FIELD_NUMBER = 23;
    public static final int MULTI_FIELD_VALUE_CLASS_UNDERLYING_TYPE_ID_FIELD_NUMBER = 24;
    public static final int NESTED_CLASS_NAME_FIELD_NUMBER = 7;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int PROPERTY_FIELD_NUMBER = 10;
    public static final int SEALED_SUBCLASS_FQ_NAME_FIELD_NUMBER = 16;
    public static final int SUPERTYPE_FIELD_NUMBER = 6;
    public static final int SUPERTYPE_ID_FIELD_NUMBER = 2;
    public static final int TYPE_ALIAS_FIELD_NUMBER = 11;
    public static final int TYPE_PARAMETER_FIELD_NUMBER = 5;
    public static final int TYPE_TABLE_FIELD_NUMBER = 30;
    public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;
    public static final int VERSION_REQUIREMENT_TABLE_FIELD_NUMBER = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Class f19043a = null;
    private static final long serialVersionUID = 0;
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
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;
    private List<Integer> versionRequirement_;

    public static final enum Kind extends Enum<Kind> implements kotlinx.metadata.internal.protobuf.r {
        public static final Kind ANNOTATION_CLASS = null;
        public static final int ANNOTATION_CLASS_VALUE = 4;
        public static final Kind CLASS = null;
        public static final int CLASS_VALUE = 0;
        public static final Kind COMPANION_OBJECT = null;
        public static final int COMPANION_OBJECT_VALUE = 6;
        public static final Kind ENUM_CLASS = null;
        public static final int ENUM_CLASS_VALUE = 2;
        public static final Kind ENUM_ENTRY = null;
        public static final int ENUM_ENTRY_VALUE = 3;
        public static final Kind INTERFACE = null;
        public static final int INTERFACE_VALUE = 1;
        public static final Kind OBJECT = null;
        public static final int OBJECT_VALUE = 5;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f19044a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f19045b = null;
        private final int value;

        static {
            Kind r5 = new Kind("CLASS", 0, 0);
            CLASS = r5;
            Kind r10 = new Kind("INTERFACE", 1, 1);
            INTERFACE = r10;
            Kind r11 = new Kind("ENUM_CLASS", 2, 2);
            ENUM_CLASS = r11;
            Kind r12 = new Kind("ENUM_ENTRY", 3, 3);
            ENUM_ENTRY = r12;
            Kind r13 = new Kind("ANNOTATION_CLASS", 4, 4);
            ANNOTATION_CLASS = r13;
            Kind r14 = new Kind("OBJECT", 5, 5);
            OBJECT = r14;
            Kind r15 = new Kind("COMPANION_OBJECT", 6, 6);
            COMPANION_OBJECT = r15;
            f19045b = new Kind[]{r5, r10, r11, r12, r13, r14, r15};
            f19044a = new j();
        }

        public Kind(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19044a;
        }

        public static Kind valueOf(String r5) {
            return (Kind) Enum.valueOf(Kind.class, r5);
        }

        public static Kind[] values() {
            return (Kind[]) f19045b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static Kind valueOf(int r5) {
            switch(r5) {
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
    }

    static {
        PARSER = new au.b(1);
        ProtoBuf$Class r5 = new ProtoBuf$Class();
        f19043a = r5;
        r5.b();
    }

    public /* synthetic */ ProtoBuf$Class(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10, au.a r11) throws InvalidProtocolBufferException {
        this(r5, r10);
    }

    public static /* synthetic */ List access$10000(ProtoBuf$Class r5) {
        return r5.property_;
    }

    public static /* synthetic */ List access$10002(ProtoBuf$Class r5, List r10) {
        r5.property_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$10100(ProtoBuf$Class r5) {
        return r5.typeAlias_;
    }

    public static /* synthetic */ List access$10102(ProtoBuf$Class r5, List r10) {
        r5.typeAlias_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$10200(ProtoBuf$Class r5) {
        return r5.enumEntry_;
    }

    public static /* synthetic */ List access$10202(ProtoBuf$Class r5, List r10) {
        r5.enumEntry_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$10300(ProtoBuf$Class r5) {
        return r5.sealedSubclassFqName_;
    }

    public static /* synthetic */ List access$10302(ProtoBuf$Class r5, List r10) {
        r5.sealedSubclassFqName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$10402(ProtoBuf$Class r5, int r10) {
        r5.inlineClassUnderlyingPropertyName_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$10502(ProtoBuf$Class r5, ProtoBuf$Type r10) {
        r5.inlineClassUnderlyingType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$10602(ProtoBuf$Class r5, int r10) {
        r5.inlineClassUnderlyingTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$10700(ProtoBuf$Class r5) {
        return r5.multiFieldValueClassUnderlyingName_;
    }

    public static /* synthetic */ List access$10702(ProtoBuf$Class r5, List r10) {
        r5.multiFieldValueClassUnderlyingName_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$10800(ProtoBuf$Class r5) {
        return r5.multiFieldValueClassUnderlyingType_;
    }

    public static /* synthetic */ List access$10802(ProtoBuf$Class r5, List r10) {
        r5.multiFieldValueClassUnderlyingType_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$10900(ProtoBuf$Class r5) {
        return r5.multiFieldValueClassUnderlyingTypeId_;
    }

    public static /* synthetic */ List access$10902(ProtoBuf$Class r5, List r10) {
        r5.multiFieldValueClassUnderlyingTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$TypeTable access$11002(ProtoBuf$Class r5, ProtoBuf$TypeTable r10) {
        r5.typeTable_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$11100(ProtoBuf$Class r5) {
        return r5.versionRequirement_;
    }

    public static /* synthetic */ List access$11102(ProtoBuf$Class r5, List r10) {
        r5.versionRequirement_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$VersionRequirementTable access$11202(ProtoBuf$Class r5, ProtoBuf$VersionRequirementTable r10) {
        r5.versionRequirementTable_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$11302(ProtoBuf$Class r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$11400(ProtoBuf$Class r5) {
        return r5.unknownFields;
    }

    public static /* synthetic */ int access$8902(ProtoBuf$Class r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$9002(ProtoBuf$Class r5, int r10) {
        r5.fqName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$9102(ProtoBuf$Class r5, int r10) {
        r5.companionObjectName_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9200(ProtoBuf$Class r5) {
        return r5.typeParameter_;
    }

    public static /* synthetic */ List access$9202(ProtoBuf$Class r5, List r10) {
        r5.typeParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9300(ProtoBuf$Class r5) {
        return r5.supertype_;
    }

    public static /* synthetic */ List access$9302(ProtoBuf$Class r5, List r10) {
        r5.supertype_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9400(ProtoBuf$Class r5) {
        return r5.supertypeId_;
    }

    public static /* synthetic */ List access$9402(ProtoBuf$Class r5, List r10) {
        r5.supertypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9500(ProtoBuf$Class r5) {
        return r5.nestedClassName_;
    }

    public static /* synthetic */ List access$9502(ProtoBuf$Class r5, List r10) {
        r5.nestedClassName_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9600(ProtoBuf$Class r5) {
        return r5.contextReceiverType_;
    }

    public static /* synthetic */ List access$9602(ProtoBuf$Class r5, List r10) {
        r5.contextReceiverType_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9700(ProtoBuf$Class r5) {
        return r5.contextReceiverTypeId_;
    }

    public static /* synthetic */ List access$9702(ProtoBuf$Class r5, List r10) {
        r5.contextReceiverTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9800(ProtoBuf$Class r5) {
        return r5.constructor_;
    }

    public static /* synthetic */ List access$9802(ProtoBuf$Class r5, List r10) {
        r5.constructor_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$9900(ProtoBuf$Class r5) {
        return r5.function_;
    }

    public static /* synthetic */ List access$9902(ProtoBuf$Class r5, List r10) {
        r5.function_ = r10;
        return r10;
    }

    public static ProtoBuf$Class getDefaultInstance() {
        return f19043a;
    }

    public static au.c newBuilder(ProtoBuf$Class r5) {
        au.c r10 = newBuilder();
        r10.j(r5);
        return r10;
    }

    public static ProtoBuf$Class parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Class parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public final void b() {
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

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public ProtoBuf$Constructor getConstructor(int r5) {
        return this.constructor_.get(r5);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<ProtoBuf$Constructor> getConstructorList() {
        return this.constructor_;
    }

    public au.f getConstructorOrBuilder(int r5) {
        return this.constructor_.get(r5);
    }

    public List<? extends au.f> getConstructorOrBuilderList() {
        return this.constructor_;
    }

    public ProtoBuf$Type getContextReceiverType(int r5) {
        return this.contextReceiverType_.get(r5);
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public int getContextReceiverTypeId(int r5) {
        return this.contextReceiverTypeId_.get(r5).intValue();
    }

    public int getContextReceiverTypeIdCount() {
        return this.contextReceiverTypeId_.size();
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public b0 getContextReceiverTypeOrBuilder(int r5) {
        return this.contextReceiverType_.get(r5);
    }

    public List<? extends b0> getContextReceiverTypeOrBuilderList() {
        return this.contextReceiverType_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public ProtoBuf$EnumEntry getEnumEntry(int r5) {
        return this.enumEntry_.get(r5);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<ProtoBuf$EnumEntry> getEnumEntryList() {
        return this.enumEntry_;
    }

    public au.i getEnumEntryOrBuilder(int r5) {
        return this.enumEntry_.get(r5);
    }

    public List<? extends au.i> getEnumEntryOrBuilderList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public ProtoBuf$Function getFunction(int r5) {
        return this.function_.get(r5);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    public au.k getFunctionOrBuilder(int r5) {
        return this.function_.get(r5);
    }

    public List<? extends au.k> getFunctionOrBuilderList() {
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

    public int getMultiFieldValueClassUnderlyingName(int r5) {
        return this.multiFieldValueClassUnderlyingName_.get(r5).intValue();
    }

    public int getMultiFieldValueClassUnderlyingNameCount() {
        return this.multiFieldValueClassUnderlyingName_.size();
    }

    public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
        return this.multiFieldValueClassUnderlyingName_;
    }

    public ProtoBuf$Type getMultiFieldValueClassUnderlyingType(int r5) {
        return this.multiFieldValueClassUnderlyingType_.get(r5);
    }

    public int getMultiFieldValueClassUnderlyingTypeCount() {
        return this.multiFieldValueClassUnderlyingType_.size();
    }

    public int getMultiFieldValueClassUnderlyingTypeId(int r5) {
        return this.multiFieldValueClassUnderlyingTypeId_.get(r5).intValue();
    }

    public int getMultiFieldValueClassUnderlyingTypeIdCount() {
        return this.multiFieldValueClassUnderlyingTypeId_.size();
    }

    public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
        return this.multiFieldValueClassUnderlyingTypeId_;
    }

    public List<ProtoBuf$Type> getMultiFieldValueClassUnderlyingTypeList() {
        return this.multiFieldValueClassUnderlyingType_;
    }

    public b0 getMultiFieldValueClassUnderlyingTypeOrBuilder(int r5) {
        return this.multiFieldValueClassUnderlyingType_.get(r5);
    }

    public List<? extends b0> getMultiFieldValueClassUnderlyingTypeOrBuilderList() {
        return this.multiFieldValueClassUnderlyingType_;
    }

    public int getNestedClassName(int r5) {
        return this.nestedClassName_.get(r5).intValue();
    }

    public int getNestedClassNameCount() {
        return this.nestedClassName_.size();
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Property getProperty(int r5) {
        return this.property_.get(r5);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    public au.o getPropertyOrBuilder(int r5) {
        return this.property_.get(r5);
    }

    public List<? extends au.o> getPropertyOrBuilderList() {
        return this.property_;
    }

    public int getSealedSubclassFqName(int r5) {
        return this.sealedSubclassFqName_.get(r5).intValue();
    }

    public int getSealedSubclassFqNameCount() {
        return this.sealedSubclassFqName_.size();
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.flags_);
    L9:
        int r12 = 0;
        int r13 = 0;
    L11:
        if (r12 >= this.supertypeId_.size()) goto L13;
        r13 = androidx.room.jarjarred.org.antlr.runtime.a.f(r13, this.supertypeId_.get(r12));
        r12 = r12 + 1;
        goto L11
    L13:
        int r14 = r11 + r13;
        if (getSupertypeIdList().isEmpty() == true) goto L16;
        r14 = (r14 + 1) + kotlinx.metadata.internal.protobuf.g.d(r13);
    L16:
        this.supertypeIdMemoizedSerializedSize = r13;
        if ((this.bitField0_ & 2) != 2) goto L20;
        r14 = r14 + kotlinx.metadata.internal.protobuf.g.c(3, this.fqName_);
    L20:
        if ((this.bitField0_ & 4) != 4) goto L22;
        r14 = r14 + kotlinx.metadata.internal.protobuf.g.c(4, this.companionObjectName_);
    L22:
        int r15 = 0;
    L24:
        if (r15 >= this.typeParameter_.size()) goto L26;
        r14 = r14 + kotlinx.metadata.internal.protobuf.g.e(5, this.typeParameter_.get(r15));
        r15 = r15 + 1;
        goto L24
    L26:
        int r16 = 0;
    L28:
        if (r16 >= this.supertype_.size()) goto L30;
        r14 = r14 + kotlinx.metadata.internal.protobuf.g.e(6, this.supertype_.get(r16));
        r16 = r16 + 1;
        goto L28
    L30:
        int r17 = 0;
        int r18 = 0;
    L32:
        if (r17 >= this.nestedClassName_.size()) goto L34;
        r18 = androidx.room.jarjarred.org.antlr.runtime.a.f(r18, this.nestedClassName_.get(r17));
        r17 = r17 + 1;
        goto L32
    L34:
        int r19 = r14 + r18;
        if (getNestedClassNameList().isEmpty() == true) goto L37;
        r19 = (r19 + 1) + kotlinx.metadata.internal.protobuf.g.d(r18);
    L37:
        this.nestedClassNameMemoizedSerializedSize = r18;
        int r20 = 0;
    L39:
        if (r20 >= this.constructor_.size()) goto L41;
        r19 = r19 + kotlinx.metadata.internal.protobuf.g.e(8, this.constructor_.get(r20));
        r20 = r20 + 1;
        goto L39
    L41:
        int r21 = 0;
    L43:
        if (r21 >= this.function_.size()) goto L45;
        r19 = r19 + kotlinx.metadata.internal.protobuf.g.e(9, this.function_.get(r21));
        r21 = r21 + 1;
        goto L43
    L45:
        int r22 = 0;
    L47:
        if (r22 >= this.property_.size()) goto L49;
        r19 = r19 + kotlinx.metadata.internal.protobuf.g.e(10, this.property_.get(r22));
        r22 = r22 + 1;
        goto L47
    L49:
        int r23 = 0;
    L51:
        if (r23 >= this.typeAlias_.size()) goto L53;
        r19 = r19 + kotlinx.metadata.internal.protobuf.g.e(11, this.typeAlias_.get(r23));
        r23 = r23 + 1;
        goto L51
    L53:
        int r24 = 0;
    L55:
        if (r24 >= this.enumEntry_.size()) goto L57;
        r19 = r19 + kotlinx.metadata.internal.protobuf.g.e(13, this.enumEntry_.get(r24));
        r24 = r24 + 1;
        goto L55
    L57:
        int r25 = 0;
        int r26 = 0;
    L59:
        if (r25 >= this.sealedSubclassFqName_.size()) goto L61;
        r26 = androidx.room.jarjarred.org.antlr.runtime.a.f(r26, this.sealedSubclassFqName_.get(r25));
        r25 = r25 + 1;
        goto L59
    L61:
        int r27 = r19 + r26;
        if (getSealedSubclassFqNameList().isEmpty() == true) goto L64;
        r27 = (r27 + 2) + kotlinx.metadata.internal.protobuf.g.d(r26);
    L64:
        this.sealedSubclassFqNameMemoizedSerializedSize = r26;
        if ((this.bitField0_ & 8) != 8) goto L68;
        r27 = r27 + kotlinx.metadata.internal.protobuf.g.c(17, this.inlineClassUnderlyingPropertyName_);
    L68:
        if ((this.bitField0_ & 16) != 16) goto L71;
        r27 = r27 + kotlinx.metadata.internal.protobuf.g.e(18, this.inlineClassUnderlyingType_);
    L71:
        if ((this.bitField0_ & 32) != 32) goto L73;
        r27 = r27 + kotlinx.metadata.internal.protobuf.g.c(19, this.inlineClassUnderlyingTypeId_);
    L73:
        int r28 = 0;
    L75:
        if (r28 >= this.contextReceiverType_.size()) goto L77;
        r27 = r27 + kotlinx.metadata.internal.protobuf.g.e(20, this.contextReceiverType_.get(r28));
        r28 = r28 + 1;
        goto L75
    L77:
        int r29 = 0;
        int r30 = 0;
    L79:
        if (r29 >= this.contextReceiverTypeId_.size()) goto L81;
        r30 = androidx.room.jarjarred.org.antlr.runtime.a.f(r30, this.contextReceiverTypeId_.get(r29));
        r29 = r29 + 1;
        goto L79
    L81:
        int r31 = r27 + r30;
        if (getContextReceiverTypeIdList().isEmpty() == true) goto L84;
        r31 = (r31 + 2) + kotlinx.metadata.internal.protobuf.g.d(r30);
    L84:
        this.contextReceiverTypeIdMemoizedSerializedSize = r30;
        int r32 = 0;
        int r33 = 0;
    L86:
        if (r32 >= this.multiFieldValueClassUnderlyingName_.size()) goto L88;
        r33 = androidx.room.jarjarred.org.antlr.runtime.a.f(r33, this.multiFieldValueClassUnderlyingName_.get(r32));
        r32 = r32 + 1;
        goto L86
    L88:
        int r34 = r31 + r33;
        if (getMultiFieldValueClassUnderlyingNameList().isEmpty() == true) goto L91;
        r34 = (r34 + 2) + kotlinx.metadata.internal.protobuf.g.d(r33);
    L91:
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r33;
        int r35 = 0;
    L93:
        if (r35 >= this.multiFieldValueClassUnderlyingType_.size()) goto L95;
        r34 = r34 + kotlinx.metadata.internal.protobuf.g.e(23, this.multiFieldValueClassUnderlyingType_.get(r35));
        r35 = r35 + 1;
        goto L93
    L95:
        int r36 = 0;
        int r37 = 0;
    L97:
        if (r36 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
        r37 = androidx.room.jarjarred.org.antlr.runtime.a.f(r37, this.multiFieldValueClassUnderlyingTypeId_.get(r36));
        r36 = r36 + 1;
        goto L97
    L99:
        int r38 = r34 + r37;
        if (getMultiFieldValueClassUnderlyingTypeIdList().isEmpty() == true) goto L102;
        r38 = (r38 + 2) + kotlinx.metadata.internal.protobuf.g.d(r37);
    L102:
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r37;
        if ((this.bitField0_ & 64) != 64) goto L105;
        r38 = r38 + kotlinx.metadata.internal.protobuf.g.e(30, this.typeTable_);
    L105:
        int r39 = 0;
    L107:
        if (r10 >= this.versionRequirement_.size()) goto L109;
        r39 = androidx.room.jarjarred.org.antlr.runtime.a.f(r39, this.versionRequirement_.get(r10));
        r10 = r10 + 1;
        goto L107
    L109:
        int r40 = (getVersionRequirementList().size() * 2) + (r38 + r39);
        if ((this.bitField0_ & 128) != 128) goto L112;
        r40 = r40 + kotlinx.metadata.internal.protobuf.g.e(32, this.versionRequirementTable_);
    L112:
        int r41 = this.unknownFields.size() + (extensionsSerializedSize() + r40);
        this.memoizedSerializedSize = r41;
        return r41;
    L8:
        r11 = 0;
        goto L9
    }

    public ProtoBuf$Type getSupertype(int r5) {
        return this.supertype_.get(r5);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public int getSupertypeId(int r5) {
        return this.supertypeId_.get(r5).intValue();
    }

    public int getSupertypeIdCount() {
        return this.supertypeId_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<ProtoBuf$Type> getSupertypeList() {
        return this.supertype_;
    }

    public b0 getSupertypeOrBuilder(int r5) {
        return this.supertype_.get(r5);
    }

    public List<? extends b0> getSupertypeOrBuilderList() {
        return this.supertype_;
    }

    public ProtoBuf$TypeAlias getTypeAlias(int r5) {
        return this.typeAlias_.get(r5);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public au.r getTypeAliasOrBuilder(int r5) {
        return this.typeAlias_.get(r5);
    }

    public List<? extends au.r> getTypeAliasOrBuilderList() {
        return this.typeAlias_;
    }

    public ProtoBuf$TypeParameter getTypeParameter(int r5) {
        return this.typeParameter_.get(r5);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public e0 getTypeParameterOrBuilder(int r5) {
        return this.typeParameter_.get(r5);
    }

    public List<? extends e0> getTypeParameterOrBuilderList() {
        return this.typeParameter_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public int getVersionRequirement(int r5) {
        return this.versionRequirement_.get(r5).intValue();
    }

    public int getVersionRequirementCount() {
        return this.versionRequirement_.size();
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L6;
        return true;
    L6:
        if (r5 != 0) goto L9;
        return false;
    L9:
        if (hasFqName() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        int r10 = 0;
    L14:
        if (r10 >= getTypeParameterCount()) goto L20;
        if (getTypeParameter(r10).isInitialized() == false) goto L17;
        r10 = r10 + 1;
        goto L14
    L17:
        this.memoizedIsInitialized = 0;
        return false;
    L20:
        int r11 = 0;
    L22:
        if (r11 >= getSupertypeCount()) goto L28;
        if (getSupertype(r11).isInitialized() == false) goto L25;
        r11 = r11 + 1;
        goto L22
    L25:
        this.memoizedIsInitialized = 0;
        return false;
    L28:
        int r12 = 0;
    L30:
        if (r12 >= getContextReceiverTypeCount()) goto L36;
        if (getContextReceiverType(r12).isInitialized() == false) goto L33;
        r12 = r12 + 1;
        goto L30
    L33:
        this.memoizedIsInitialized = 0;
        return false;
    L36:
        int r13 = 0;
    L38:
        if (r13 >= getConstructorCount()) goto L44;
        if (getConstructor(r13).isInitialized() == false) goto L41;
        r13 = r13 + 1;
        goto L38
    L41:
        this.memoizedIsInitialized = 0;
        return false;
    L44:
        int r14 = 0;
    L46:
        if (r14 >= getFunctionCount()) goto L52;
        if (getFunction(r14).isInitialized() == false) goto L49;
        r14 = r14 + 1;
        goto L46
    L49:
        this.memoizedIsInitialized = 0;
        return false;
    L52:
        int r15 = 0;
    L54:
        if (r15 >= getPropertyCount()) goto L60;
        if (getProperty(r15).isInitialized() == false) goto L57;
        r15 = r15 + 1;
        goto L54
    L57:
        this.memoizedIsInitialized = 0;
        return false;
    L60:
        int r16 = 0;
    L62:
        if (r16 >= getTypeAliasCount()) goto L68;
        if (getTypeAlias(r16).isInitialized() == false) goto L65;
        r16 = r16 + 1;
        goto L62
    L65:
        this.memoizedIsInitialized = 0;
        return false;
    L68:
        int r17 = 0;
    L70:
        if (r17 >= getEnumEntryCount()) goto L77;
        if (getEnumEntry(r17).isInitialized() == false) goto L73;
        r17 = r17 + 1;
        goto L70
    L73:
        this.memoizedIsInitialized = 0;
        return false;
    L77:
        if (hasInlineClassUnderlyingType() == true) goto L79;
    L82:
        int r18 = 0;
    L84:
        if (r18 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L91;
        if (getMultiFieldValueClassUnderlyingType(r18).isInitialized() == false) goto L87;
        r18 = r18 + 1;
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(kotlinx.metadata.internal.protobuf.g r10) throws IOException {
        getSerializedSize();
        kotlinx.metadata.internal.protobuf.o r5 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r10.n(1, this.flags_);
    L6:
        if (getSupertypeIdList().size() <= 0) goto L8;
        r10.v(18);
        r10.v(this.supertypeIdMemoizedSerializedSize);
    L8:
        int r11 = 0;
        int r12 = 0;
    L10:
        if (r12 >= this.supertypeId_.size()) goto L13;
        r10.o(this.supertypeId_.get(r12).intValue());
        r12 = r12 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 2) != 2) goto L16;
        r10.n(3, this.fqName_);
    L16:
        if ((this.bitField0_ & 4) != 4) goto L18;
        r10.n(4, this.companionObjectName_);
    L18:
        int r13 = 0;
    L20:
        if (r13 >= this.typeParameter_.size()) goto L22;
        r10.p(5, this.typeParameter_.get(r13));
        r13 = r13 + 1;
        goto L20
    L22:
        int r14 = 0;
    L24:
        if (r14 >= this.supertype_.size()) goto L27;
        r10.p(6, this.supertype_.get(r14));
        r14 = r14 + 1;
        goto L24
    L27:
        if (getNestedClassNameList().size() <= 0) goto L29;
        r10.v(58);
        r10.v(this.nestedClassNameMemoizedSerializedSize);
    L29:
        int r15 = 0;
    L31:
        if (r15 >= this.nestedClassName_.size()) goto L33;
        r10.o(this.nestedClassName_.get(r15).intValue());
        r15 = r15 + 1;
        goto L31
    L33:
        int r16 = 0;
    L35:
        if (r16 >= this.constructor_.size()) goto L37;
        r10.p(8, this.constructor_.get(r16));
        r16 = r16 + 1;
        goto L35
    L37:
        int r17 = 0;
    L39:
        if (r17 >= this.function_.size()) goto L41;
        r10.p(9, this.function_.get(r17));
        r17 = r17 + 1;
        goto L39
    L41:
        int r18 = 0;
    L43:
        if (r18 >= this.property_.size()) goto L45;
        r10.p(10, this.property_.get(r18));
        r18 = r18 + 1;
        goto L43
    L45:
        int r19 = 0;
    L47:
        if (r19 >= this.typeAlias_.size()) goto L49;
        r10.p(11, this.typeAlias_.get(r19));
        r19 = r19 + 1;
        goto L47
    L49:
        int r20 = 0;
    L51:
        if (r20 >= this.enumEntry_.size()) goto L54;
        r10.p(13, this.enumEntry_.get(r20));
        r20 = r20 + 1;
        goto L51
    L54:
        if (getSealedSubclassFqNameList().size() <= 0) goto L56;
        r10.v(130);
        r10.v(this.sealedSubclassFqNameMemoizedSerializedSize);
    L56:
        int r21 = 0;
    L58:
        if (r21 >= this.sealedSubclassFqName_.size()) goto L61;
        r10.o(this.sealedSubclassFqName_.get(r21).intValue());
        r21 = r21 + 1;
        goto L58
    L61:
        if ((this.bitField0_ & 8) != 8) goto L64;
        r10.n(17, this.inlineClassUnderlyingPropertyName_);
    L64:
        if ((this.bitField0_ & 16) != 16) goto L67;
        r10.p(18, this.inlineClassUnderlyingType_);
    L67:
        if ((this.bitField0_ & 32) != 32) goto L69;
        r10.n(19, this.inlineClassUnderlyingTypeId_);
    L69:
        int r22 = 0;
    L71:
        if (r22 >= this.contextReceiverType_.size()) goto L74;
        r10.p(20, this.contextReceiverType_.get(r22));
        r22 = r22 + 1;
        goto L71
    L74:
        if (getContextReceiverTypeIdList().size() <= 0) goto L76;
        r10.v(170);
        r10.v(this.contextReceiverTypeIdMemoizedSerializedSize);
    L76:
        int r23 = 0;
    L78:
        if (r23 >= this.contextReceiverTypeId_.size()) goto L81;
        r10.o(this.contextReceiverTypeId_.get(r23).intValue());
        r23 = r23 + 1;
        goto L78
    L81:
        if (getMultiFieldValueClassUnderlyingNameList().size() <= 0) goto L83;
        r10.v(178);
        r10.v(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
    L83:
        int r24 = 0;
    L85:
        if (r24 >= this.multiFieldValueClassUnderlyingName_.size()) goto L87;
        r10.o(this.multiFieldValueClassUnderlyingName_.get(r24).intValue());
        r24 = r24 + 1;
        goto L85
    L87:
        int r25 = 0;
    L89:
        if (r25 >= this.multiFieldValueClassUnderlyingType_.size()) goto L92;
        r10.p(23, this.multiFieldValueClassUnderlyingType_.get(r25));
        r25 = r25 + 1;
        goto L89
    L92:
        if (getMultiFieldValueClassUnderlyingTypeIdList().size() <= 0) goto L94;
        r10.v(194);
        r10.v(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
    L94:
        int r26 = 0;
    L96:
        if (r26 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
        r10.o(this.multiFieldValueClassUnderlyingTypeId_.get(r26).intValue());
        r26 = r26 + 1;
        goto L96
    L99:
        if ((this.bitField0_ & 64) != 64) goto L102;
        r10.p(30, this.typeTable_);
    L102:
        if (r11 >= this.versionRequirement_.size()) goto L105;
        r10.n(31, this.versionRequirement_.get(r11).intValue());
        r11 = r11 + 1;
        goto L102
    L105:
        if ((this.bitField0_ & 128) != 128) goto L107;
        r10.p(32, this.versionRequirementTable_);
    L107:
        r5.a(19000, r10);
        r10.r(this.unknownFields);
    }

    public ProtoBuf$Class(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static au.c newBuilder() {
        return au.c.i();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Class getDefaultInstanceForType() {
        return f19043a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.c newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.c toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Class parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Class parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public static ProtoBuf$Class parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Class parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public ProtoBuf$Class() {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Class parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Class parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Class parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBuf$Class(kotlinx.metadata.internal.protobuf.f r18, kotlinx.metadata.internal.protobuf.i r19) {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        b();
        kotlinx.metadata.internal.protobuf.d r5 = kotlinx.metadata.internal.protobuf.e.k();
        kotlinx.metadata.internal.protobuf.g r10 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        boolean r11 = false;
        int r12 = 0;
    L4:
        if (r11 == true) goto L233;
        int r15 = r18.n();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        Cloneable r16 = null;
        switch(r15) {
            case 0: goto L171;
            case 8: goto L169;
            case 16: goto L166;
            case 18: goto L156;
            case 24: goto L155;
            case 32: goto L154;
            case 42: goto L151;
            case 50: goto L147;
            case 56: goto L143;
            case 58: goto L133;
            case 66: goto L130;
            case 74: goto L126;
            case 82: goto L122;
            case 90: goto L118;
            case 106: goto L114;
            case 128: goto L110;
            case 130: goto L100;
            case 136: goto L99;
            case 146: goto L93;
            case 152: goto L91;
            case 162: goto L88;
            case 168: goto L84;
            case 170: goto L74;
            case 176: goto L71;
            case 178: goto L61;
            case 186: goto L58;
            case 192: goto L54;
            case 194: goto L44;
            case 242: goto L38;
            case 248: goto L34;
            case 250: goto L24;
            case 258: goto L18;
            default: goto L8;
        };     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L24:
        int r14 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 4194304) == 4194304) goto L30;
        if (r18.b() <= 0) goto L30;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 4194304;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L30:
        if (r18.b() <= 0) goto L32;
        this.versionRequirement_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L30
    L32:
        r18.c(r14);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L10:
        boolean r17 = true;
        goto L4
    L44:
        int r13 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 1048576) == 1048576) goto L50;
        if (r18.b() <= 0) goto L50;
        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 1048576;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L50:
        if (r18.b() <= 0) goto L52;
        this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L50
    L52:
        r18.c(r13);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L61:
        int r20 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 262144) == 262144) goto L67;
        if (r18.b() <= 0) goto L67;
        this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 262144;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L67:
        if (r18.b() <= 0) goto L69;
        this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L67
    L69:
        r18.c(r20);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L74:
        int r21 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 256) == 256) goto L80;
        if (r18.b() <= 0) goto L80;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 256;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L80:
        if (r18.b() <= 0) goto L82;
        this.contextReceiverTypeId_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L80
    L82:
        r18.c(r21);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L91:
        this.bitField0_ |= 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.inlineClassUnderlyingTypeId_ = r18.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L99:
        this.bitField0_ |= 8;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.inlineClassUnderlyingPropertyName_ = r18.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L100:
        int r22 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 16384) == 16384) goto L106;
        if (r18.b() <= 0) goto L106;
        this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 16384;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L106:
        if (r18.b() <= 0) goto L108;
        this.sealedSubclassFqName_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L106
    L108:
        r18.c(r22);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L133:
        int r23 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 64) == 64) goto L139;
        if (r18.b() <= 0) goto L139;
        this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L139:
        if (r18.b() <= 0) goto L141;
        this.nestedClassName_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L139
    L141:
        r18.c(r23);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L154:
        this.bitField0_ |= 4;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.companionObjectName_ = r18.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L155:
        this.bitField0_ |= 2;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.fqName_ = r18.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L156:
        int r24 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r12 & 32) == 32) goto L162;
        if (r18.b() <= 0) goto L162;
        this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L162:
        if (r18.b() <= 0) goto L164;
        this.supertypeId_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L162
    L164:
        r18.c(r24);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L169:
        r17 = true;
        this.bitField0_ |= 1;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.flags_ = r18.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L4
    L171:
        r17 = true;
        r11 = true;
        goto L4
    L8:
        if (parseUnknownField(r18, r10, r19, r15) == true) goto L10;
        r11 = true;
        goto L10
    L18:
        if ((this.bitField0_ & 128) != 128) goto L20;
        r16 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L20:
        au.v r110 = r16;
        ProtoBuf$VersionRequirementTable r111 = (ProtoBuf$VersionRequirementTable) r18.g(ProtoBuf$VersionRequirementTable.PARSER, r19);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.versionRequirementTable_ = r111;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r110 == 0) goto L23;
        r110.g(r111);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.versionRequirementTable_ = r110.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L23:
        this.bitField0_ |= 128;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L34:
        if ((r12 & 4194304) == 4194304) goto L36;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 4194304;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L36:
        this.versionRequirement_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L38:
        if ((this.bitField0_ & 64) != 64) goto L40;
        r16 = this.typeTable_.toBuilder();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L40:
        au.s r25 = r16;
        ProtoBuf$TypeTable r112 = (ProtoBuf$TypeTable) r18.g(ProtoBuf$TypeTable.PARSER, r19);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.typeTable_ = r112;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r25 == 0) goto L43;
        r25.g(r112);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.typeTable_ = r25.f();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L43:
        this.bitField0_ |= 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L54:
        if ((r12 & 1048576) == 1048576) goto L56;
        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 1048576;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L56:
        this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L58:
        if ((r12 & 524288) == 524288) goto L60;
        this.multiFieldValueClassUnderlyingType_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 524288;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L60:
        this.multiFieldValueClassUnderlyingType_.add((ProtoBuf$Type) r18.g(ProtoBuf$Type.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L71:
        if ((r12 & 262144) == 262144) goto L73;
        this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 262144;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L73:
        this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L84:
        if ((r12 & 256) == 256) goto L86;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 256;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L86:
        this.contextReceiverTypeId_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L88:
        if ((r12 & 128) == 128) goto L90;
        this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 128;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L90:
        this.contextReceiverType_.add((ProtoBuf$Type) r18.g(ProtoBuf$Type.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L93:
        if ((this.bitField0_ & 16) != 16) goto L95;
        r16 = this.inlineClassUnderlyingType_.toBuilder();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L95:
        a0 r26 = r16;
        ProtoBuf$Type r113 = (ProtoBuf$Type) r18.g(ProtoBuf$Type.PARSER, r19);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.inlineClassUnderlyingType_ = r113;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r26 == 0) goto L98;
        r26.i(r113);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.inlineClassUnderlyingType_ = r26.h();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L98:
        this.bitField0_ |= 16;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L110:
        if ((r12 & 16384) == 16384) goto L112;
        this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 16384;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L112:
        this.sealedSubclassFqName_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L114:
        if ((r12 & 8192) == 8192) goto L116;
        this.enumEntry_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 8192;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L116:
        this.enumEntry_.add((ProtoBuf$EnumEntry) r18.g(ProtoBuf$EnumEntry.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L118:
        if ((r12 & 4096) == 4096) goto L120;
        this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 4096;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L120:
        this.typeAlias_.add((ProtoBuf$TypeAlias) r18.g(ProtoBuf$TypeAlias.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L122:
        if ((r12 & 2048) == 2048) goto L124;
        this.property_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 2048;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L124:
        this.property_.add((ProtoBuf$Property) r18.g(ProtoBuf$Property.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L126:
        if ((r12 & 1024) == 1024) goto L128;
        this.function_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 1024;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L128:
        this.function_.add((ProtoBuf$Function) r18.g(ProtoBuf$Function.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L130:
        if ((r12 & 512) == 512) goto L132;
        this.constructor_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 512;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L132:
        this.constructor_.add((ProtoBuf$Constructor) r18.g(ProtoBuf$Constructor.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L143:
        if ((r12 & 64) == 64) goto L145;
        this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L145:
        this.nestedClassName_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L147:
        if ((r12 & 16) == 16) goto L149;
        this.supertype_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 16;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L149:
        this.supertype_.add((ProtoBuf$Type) r18.g(ProtoBuf$Type.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L151:
        if ((r12 & 8) == 8) goto L153;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 8;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L153:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r18.g(ProtoBuf$TypeParameter.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L166:
        if ((r12 & 32) == 32) goto L168;
        this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r12 = r12 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L168:
        this.supertypeId_.add(Integer.valueOf(r18.f()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L10
    L11:
        th = move-exception;
        if ((r12 & 32) != 32) goto L181;
        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
    L181:
        if ((r12 & 8) != 8) goto L184;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L184:
        if ((r12 & 16) != 16) goto L187;
        this.supertype_ = Collections.unmodifiableList(this.supertype_);
    L187:
        if ((r12 & 64) != 64) goto L190;
        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
    L190:
        if ((r12 & 512) != 512) goto L193;
        this.constructor_ = Collections.unmodifiableList(this.constructor_);
    L193:
        if ((r12 & 1024) != 1024) goto L196;
        this.function_ = Collections.unmodifiableList(this.function_);
    L196:
        if ((r12 & 2048) != 2048) goto L199;
        this.property_ = Collections.unmodifiableList(this.property_);
    L199:
        if ((r12 & 4096) != 4096) goto L202;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L202:
        if ((r12 & 8192) != 8192) goto L205;
        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
    L205:
        if ((r12 & 16384) != 16384) goto L208;
        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
    L208:
        if ((r12 & 128) != 128) goto L211;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L211:
        if ((r12 & 256) != 256) goto L214;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L214:
        if ((r12 & 262144) != 262144) goto L217;
        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
    L217:
        if ((r12 & 524288) != 524288) goto L220;
        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
    L220:
        if ((r12 & 1048576) != 1048576) goto L223;
        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
    L223:
        if ((r12 & 4194304) != 4194304) goto L291;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L291:
        r10.i();     // Catch: IOException -> L288 Throwable -> L227
    L227:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L226:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L233:
        if ((r12 & 32) != 32) goto L236;
        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
    L236:
        if ((r12 & 8) != 8) goto L239;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L239:
        if ((r12 & 16) != 16) goto L242;
        this.supertype_ = Collections.unmodifiableList(this.supertype_);
    L242:
        if ((r12 & 64) != 64) goto L245;
        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
    L245:
        if ((r12 & 512) != 512) goto L248;
        this.constructor_ = Collections.unmodifiableList(this.constructor_);
    L248:
        if ((r12 & 1024) != 1024) goto L251;
        this.function_ = Collections.unmodifiableList(this.function_);
    L251:
        if ((r12 & 2048) != 2048) goto L254;
        this.property_ = Collections.unmodifiableList(this.property_);
    L254:
        if ((r12 & 4096) != 4096) goto L257;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L257:
        if ((r12 & 8192) != 8192) goto L260;
        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
    L260:
        if ((r12 & 16384) != 16384) goto L263;
        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
    L263:
        if ((r12 & 128) != 128) goto L266;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L266:
        if ((r12 & 256) != 256) goto L269;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L269:
        if ((r12 & 262144) != 262144) goto L272;
        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
    L272:
        if ((r12 & 524288) != 524288) goto L275;
        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
    L275:
        if ((r12 & 1048576) != 1048576) goto L278;
        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
    L278:
        if ((r12 & 4194304) != 4194304) goto L293;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L293:
        r10.i();     // Catch: IOException -> L287 Throwable -> L282
    L282:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L281:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Class parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Class) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
