package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import kotlin.text.Typography;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public final class Descriptors {
    private static final Descriptor[] EMPTY_DESCRIPTORS = null;
    private static final EnumDescriptor[] EMPTY_ENUM_DESCRIPTORS = null;
    private static final FieldDescriptor[] EMPTY_FIELD_DESCRIPTORS = null;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final OneofDescriptor[] EMPTY_ONEOF_DESCRIPTORS = null;
    private static final ServiceDescriptor[] EMPTY_SERVICE_DESCRIPTORS = null;
    private static final ConcurrentHashMap<Integer, DescriptorProtos.FeatureSet> FEATURE_CACHE = null;
    private static volatile DescriptorProtos.FeatureSetDefaults javaEditionDefaults;
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.Descriptors$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Descriptor extends GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final int[] extensionRangeLowerBounds;
        private final int[] extensionRangeUpperBounds;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FieldDescriptor[] fieldsSortedByNumber;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private final OneofDescriptor[] oneofs;
        private volatile DescriptorProtos.MessageOptions options;
        private DescriptorProtos.DescriptorProto proto;
        private final int realOneofCount;

        private Descriptor(DescriptorProtos.DescriptorProto r12, FileDescriptor r13, Descriptor r14, int r15) {
            AnonymousClass1 r0 = null;
            super(r0);
            if (r14 != null) goto L5;
            this.parent = r13;
        L6:
            this.index = r15;
            this.proto = r12;
            this.fullName = Descriptors.access$2600(r13, r14, r12.getName());
            this.file = r13;
            this.containingType = r14;
            if (r12.getOneofDeclCount() <= 0) goto L9;
            OneofDescriptor[] r16 = new OneofDescriptor[r12.getOneofDeclCount()];
        L10:
            this.oneofs = r16;
            int r17 = 0;
            int r18 = 0;
        L12:
            if (r18 >= r12.getOneofDeclCount()) goto L15;
            this.oneofs[r18] = new OneofDescriptor(r12.getOneofDecl(r18), r13, this, r18, null);
            r18 = r18 + 1;
            goto L12
        L15:
            if (r12.getNestedTypeCount() <= 0) goto L17;
            Descriptor[] r19 = new Descriptor[r12.getNestedTypeCount()];
        L18:
            this.nestedTypes = r19;
            int r110 = 0;
        L20:
            if (r110 >= r12.getNestedTypeCount()) goto L23;
            this.nestedTypes[r110] = new Descriptor(r12.getNestedType(r110), r13, this, r110);
            r110 = r110 + 1;
            goto L20
        L23:
            if (r12.getEnumTypeCount() <= 0) goto L25;
            EnumDescriptor[] r111 = new EnumDescriptor[r12.getEnumTypeCount()];
        L26:
            this.enumTypes = r111;
            int r112 = 0;
        L28:
            if (r112 >= r12.getEnumTypeCount()) goto L31;
            this.enumTypes[r112] = new EnumDescriptor(r12.getEnumType(r112), r13, this, r112, null);
            r112 = r112 + 1;
            goto L28
        L31:
            if (r12.getFieldCount() <= 0) goto L33;
            FieldDescriptor[] r113 = new FieldDescriptor[r12.getFieldCount()];
        L34:
            this.fields = r113;
            int r114 = 0;
        L36:
            if (r114 >= r12.getFieldCount()) goto L39;
            this.fields[r114] = new FieldDescriptor(r12.getField(r114), r13, this, r114, false, null);
            r114 = r114 + 1;
            goto L36
        L39:
            if (r12.getFieldCount() <= 0) goto L41;
            FieldDescriptor[] r115 = (FieldDescriptor[]) ZeusTransformUtils.preCheckCast(this.fields.clone(), FieldDescriptor[].class, "com.obric.memorydata.plugin");
        L42:
            this.fieldsSortedByNumber = r115;
            if (r12.getExtensionCount() <= 0) goto L45;
            FieldDescriptor[] r116 = new FieldDescriptor[r12.getExtensionCount()];
        L46:
            this.extensions = r116;
            int r117 = 0;
        L48:
            if (r117 >= r12.getExtensionCount()) goto L50;
            this.extensions[r117] = new FieldDescriptor(r12.getExtension(r117), r13, this, r117, true, null);
            r117 = r117 + 1;
            goto L48
        L50:
            int r118 = 0;
        L52:
            if (r118 >= r12.getOneofDeclCount()) goto L54;
            OneofDescriptor[] r2 = this.oneofs;
            OneofDescriptor.access$2802(r2[r118], new FieldDescriptor[r2[r118].getFieldCount()]);
            OneofDescriptor.access$2902(this.oneofs[r118], 0);
            r118 = r118 + 1;
            goto L52
        L54:
            int r119 = 0;
        L56:
            if (r119 >= r12.getFieldCount()) goto L61;
            OneofDescriptor r3 = this.fields[r119].getContainingOneof();
            if (r3 == null) goto L60;
            OneofDescriptor.access$2800(r3)[OneofDescriptor.access$2908(r3)] = this.fields[r119];
        L60:
            r119 = r119 + 1;
            goto L56
        L61:
            OneofDescriptor[] r120 = this.oneofs;
            int r4 = r120.length;
            int r5 = 0;
            int r6 = 0;
        L62:
            if (r5 >= r4) goto L70;
            if (r120[r5].isSynthetic() == false) goto L66;
            r6 = r6 + 1;
        L67:
            r5 = r5 + 1;
            goto L62
        L66:
            if (r6 <= 0) goto L67;
            throw new DescriptorValidationException(this, "Synthetic oneofs must come last.", r0);
        L70:
            this.realOneofCount = this.oneofs.length - r6;
            FileDescriptor.access$2200(r13).addSymbol(this);
            if (r12.getExtensionRangeCount() <= 0) goto L77;
            this.extensionRangeLowerBounds = new int[r12.getExtensionRangeCount()];
            this.extensionRangeUpperBounds = new int[r12.getExtensionRangeCount()];
            Iterator<DescriptorProtos.DescriptorProto.ExtensionRange> r121 = r12.getExtensionRangeList().iterator();
        L74:
            if (r121.hasNext() == false) goto L76;
            DescriptorProtos.DescriptorProto.ExtensionRange r122 = (DescriptorProtos.DescriptorProto.ExtensionRange) ZeusTransformUtils.preCheckCast(r121.next(), DescriptorProtos.DescriptorProto.ExtensionRange.class, "com.obric.memorydata.plugin");
            this.extensionRangeLowerBounds[r17] = r122.getStart();
            this.extensionRangeUpperBounds[r17] = r122.getEnd();
            r17 = r17 + 1;
            goto L74
        L76:
            Arrays.sort(this.extensionRangeLowerBounds);
            Arrays.sort(this.extensionRangeUpperBounds);
            return;
        L77:
            this.extensionRangeLowerBounds = Descriptors.access$3100();
            this.extensionRangeUpperBounds = Descriptors.access$3100();
            return;
        L45:
            r116 = Descriptors.access$900();
            goto L46
        L41:
            r115 = Descriptors.access$900();
            goto L42
        L33:
            r113 = Descriptors.access$900();
            goto L34
        L25:
            r111 = Descriptors.access$500();
            goto L26
        L17:
            r19 = Descriptors.access$300();
            goto L18
        L9:
            r16 = Descriptors.access$2500();
            goto L10
        L5:
            this.parent = r14;
            goto L6
        }

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto r1, FileDescriptor r2, Descriptor r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        Descriptor(String r8) {
            super(null);
            int r1 = r8.lastIndexOf(46);
            if (r1 == (-1)) goto L5;
            String r3 = r8.substring(r1 + 1);
            String r2 = r8.substring(0, r1);
        L6:
            this.index = 0;
            this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(r3).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING).build()).build();
            this.fullName = r8;
            this.containingType = null;
            this.nestedTypes = Descriptors.access$300();
            this.enumTypes = Descriptors.access$500();
            this.fields = Descriptors.access$900();
            this.fieldsSortedByNumber = Descriptors.access$900();
            this.extensions = Descriptors.access$900();
            this.oneofs = Descriptors.access$2500();
            this.realOneofCount = 0;
            FileDescriptor r9 = new FileDescriptor(r2, this);
            this.file = r9;
            this.parent = r9;
            this.extensionRangeLowerBounds = new int[]{1};
            this.extensionRangeUpperBounds = new int[]{SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING};
            return;
        L5:
            r2 = "";
            r3 = r8;
            goto L6
        }

        static /* synthetic */ void access$1100(Descriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$1500(Descriptor r0) {
            r0.crossLink();
        }

        static /* synthetic */ void access$1800(Descriptor r0, DescriptorProtos.DescriptorProto r1) {
            r0.setProto(r1);
        }

        private void crossLink() {
            Descriptor[] r0 = this.nestedTypes;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r0[r3].crossLink();
            r3 = r3 + 1;
            goto L3
        L5:
            FieldDescriptor[] r4 = this.fields;
            int r5 = r4.length;
            int r6 = 0;
        L6:
            if (r6 >= r5) goto L8;
            FieldDescriptor.access$1700(r4[r6]);
            r6 = r6 + 1;
            goto L6
        L8:
            Arrays.sort(this.fieldsSortedByNumber);
            validateNoDuplicateFieldNumbers();
            FieldDescriptor[] r7 = this.extensions;
            int r8 = r7.length;
        L9:
            if (r2 >= r8) goto L11;
            FieldDescriptor.access$1700(r7[r2]);
            r2 = r2 + 1;
            goto L9
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            Descriptor[] r0 = this.nestedTypes;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r0[r3].resolveAllFeatures();
            r3 = r3 + 1;
            goto L3
        L5:
            EnumDescriptor[] r4 = this.enumTypes;
            int r5 = r4.length;
            int r6 = 0;
        L6:
            if (r6 >= r5) goto L8;
            EnumDescriptor.access$1200(r4[r6]);
            r6 = r6 + 1;
            goto L6
        L8:
            OneofDescriptor[] r7 = this.oneofs;
            int r8 = r7.length;
            int r9 = 0;
        L9:
            if (r9 >= r8) goto L11;
            OneofDescriptor.access$3200(r7[r9]);
            r9 = r9 + 1;
            goto L9
        L11:
            FieldDescriptor[] r10 = this.fields;
            int r11 = r10.length;
            int r12 = 0;
        L12:
            if (r12 >= r11) goto L14;
            FieldDescriptor.access$1400(r10[r12]);
            r12 = r12 + 1;
            goto L12
        L14:
            FieldDescriptor[] r13 = this.extensions;
            int r14 = r13.length;
        L15:
            if (r2 >= r14) goto L17;
            FieldDescriptor.access$1400(r13[r2]);
            r2 = r2 + 1;
            goto L15
        }

        private void setProto(DescriptorProtos.DescriptorProto r5) {
            this.proto = r5;
            this.options = null;
            resolveFeatures(r5.getOptions().getFeatures());
            int r0 = 0;
            int r1 = 0;
        L3:
            Descriptor[] r2 = this.nestedTypes;
            if (r1 >= r2.length) goto L6;
            r2[r1].setProto(r5.getNestedType(r1));
            r1 = r1 + 1;
            goto L3
        L6:
            int r3 = 0;
        L7:
            OneofDescriptor[] r4 = this.oneofs;
            if (r3 >= r4.length) goto L10;
            OneofDescriptor.access$3300(r4[r3], r5.getOneofDecl(r3));
            r3 = r3 + 1;
            goto L7
        L10:
            int r6 = 0;
        L11:
            EnumDescriptor[] r7 = this.enumTypes;
            if (r6 >= r7.length) goto L14;
            EnumDescriptor.access$1900(r7[r6], r5.getEnumType(r6));
            r6 = r6 + 1;
            goto L11
        L14:
            int r8 = 0;
        L15:
            FieldDescriptor[] r9 = this.fields;
            if (r8 >= r9.length) goto L18;
            FieldDescriptor.access$2100(r9[r8], r5.getField(r8));
            r8 = r8 + 1;
        L18:
            FieldDescriptor[] r10 = this.extensions;
            if (r0 >= r10.length) goto L21;
            FieldDescriptor.access$2100(r10[r0], r5.getExtension(r0));
            r0 = r0 + 1;
            goto L18
        }

        private void validateNoDuplicateFieldNumbers() {
            int r0 = 0;
        L3:
            int r1 = r0 + 1;
            FieldDescriptor[] r2 = this.fieldsSortedByNumber;
            if (r1 >= r2.length) goto L10;
            FieldDescriptor r3 = r2[r0];
            FieldDescriptor r4 = r2[r1];
            if (r3.getNumber() == r4.getNumber()) goto L9;
            r0 = r1;
            goto L3
        L9:
            throw new DescriptorValidationException(r4, "Field number " + r4.getNumber() + " has already been used in \"" + r4.getContainingType().getFullName() + "\" by field \"" + r3.getName() + "\".", null);
        }

        public EnumDescriptor findEnumTypeByName(String r3) {
            GenericDescriptor r2 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r3);
            if (ZeusTransformUtils.instanceOf(r2, EnumDescriptor.class) == true) goto L5;
            return null;
        L5:
            return (EnumDescriptor) ZeusTransformUtils.preCheckCast(r2, EnumDescriptor.class, "com.obric.memorydata.plugin");
        }

        public FieldDescriptor findFieldByName(String r3) {
            GenericDescriptor r2 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r3);
            if (ZeusTransformUtils.instanceOf(r2, FieldDescriptor.class) == true) goto L5;
            return null;
        L5:
            return (FieldDescriptor) ZeusTransformUtils.preCheckCast(r2, FieldDescriptor.class, "com.obric.memorydata.plugin");
        }

        public FieldDescriptor findFieldByNumber(int r3) {
            FieldDescriptor[] r2 = this.fieldsSortedByNumber;
            return (FieldDescriptor) ZeusTransformUtils.preCheckCast(Descriptors.access$2400(r2, r2.length, FieldDescriptor.access$2300(), r3), FieldDescriptor.class, "com.obric.memorydata.plugin");
        }

        public Descriptor findNestedTypeByName(String r4) {
            GenericDescriptor r3 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r4);
            if (ZeusTransformUtils.instanceOf(r3, Descriptor.class) == true) goto L5;
            return null;
        L5:
            return (Descriptor) ZeusTransformUtils.preCheckCast(r3, Descriptor.class, "com.obric.memorydata.plugin");
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<OneofDescriptor> getOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs));
        }

        public DescriptorProtos.MessageOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.MessageOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public List<OneofDescriptor> getRealOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs).subList(0, this.realOneofCount));
        }

        public boolean isExtendable() {
            return !this.proto.getExtensionRangeList().isEmpty();
        }

        public boolean isExtensionNumber(int r3) {
            int r0 = Arrays.binarySearch(this.extensionRangeLowerBounds, r3);
            if (r0 >= 0) goto L5;
            r0 = (~r0) - 1;
        L5:
            if (r0 >= 0) goto L7;
        L9:
            return false;
        L7:
            if (r3 >= this.extensionRangeUpperBounds[r0]) goto L9;
            return true;
        }

        public boolean isReservedName(String r4) {
            Internal.checkNotNull(r4);
            Iterator<String> r3 = this.proto.getReservedNameList().iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            if (((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")).equals(r4) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r4) {
            Iterator<DescriptorProtos.DescriptorProto.ReservedRange> r3 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r3.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ReservedRange r0 = (DescriptorProtos.DescriptorProto.ReservedRange) ZeusTransformUtils.preCheckCast(r3.next(), DescriptorProtos.DescriptorProto.ReservedRange.class, "com.obric.memorydata.plugin");
            if (r0.getStart() > r4) goto L4;
            if (r4 >= r0.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    private static final class DescriptorPool {
        private final boolean allowUnknownDependencies;
        private final Set<FileDescriptor> dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName;

        private static final class PackageDescriptor extends GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            PackageDescriptor(String r2, String r3, FileDescriptor r4) {
                super(null);
                this.file = r4;
                this.fullName = r3;
                this.name = r2;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public FileDescriptor getFile() {
                return this.file;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getFullName() {
                return this.fullName;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getName() {
                return this.name;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }
        }

        static final enum SearchFilter extends java.lang.Enum<SearchFilter> {
            private static final /* synthetic */ SearchFilter[] $VALUES = null;
            public static final SearchFilter AGGREGATES_ONLY = null;
            public static final SearchFilter ALL_SYMBOLS = null;
            public static final SearchFilter TYPES_ONLY = null;

            private static /* synthetic */ SearchFilter[] $values() {
                return new SearchFilter[]{TYPES_ONLY, AGGREGATES_ONLY, ALL_SYMBOLS};
            }

            static {
                TYPES_ONLY = new SearchFilter("TYPES_ONLY", 0);
                AGGREGATES_ONLY = new SearchFilter("AGGREGATES_ONLY", 1);
                ALL_SYMBOLS = new SearchFilter("ALL_SYMBOLS", 2);
                $VALUES = $values();
            }

            private SearchFilter(String r1, int r2) {
                super(r1, r2);
            }

            public static SearchFilter valueOf(String r2) {
                return (SearchFilter) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(SearchFilter.class, r2), SearchFilter.class, "com.obric.memorydata.plugin");
            }

            public static SearchFilter[] values() {
                return (SearchFilter[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchFilter[].class, "com.obric.memorydata.plugin");
            }
        }

        DescriptorPool(FileDescriptor[] r4, boolean r5) {
            this.descriptorsByName = new HashMap();
            this.dependencies = Collections.newSetFromMap(new IdentityHashMap(r4.length));
            this.allowUnknownDependencies = r5;
            int r6 = r4.length;
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L5;
            FileDescriptor r1 = r4[r0];
            this.dependencies.add(r1);
            importPublicDependencies(r1);
            r0 = r0 + 1;
            goto L3
        L5:
            Iterator<FileDescriptor> r7 = this.dependencies.iterator();
        L7:
            if (r7.hasNext() == false) goto L14;
            FileDescriptor r8 = (FileDescriptor) ZeusTransformUtils.preCheckCast(r7.next(), FileDescriptor.class, "com.obric.memorydata.plugin");
            addPackage(r8.getPackage(), r8);     // Catch: DescriptorValidationException -> L11
        L11:
            e = move-exception;
            throw new AssertionError(e);
        }

        private void importPublicDependencies(FileDescriptor r4) {
            Iterator<FileDescriptor> r5 = r4.getPublicDependencies().iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            FileDescriptor r0 = (FileDescriptor) ZeusTransformUtils.preCheckCast(r5.next(), FileDescriptor.class, "com.obric.memorydata.plugin");
            if (this.dependencies.add(r0) == false) goto L4;
            importPublicDependencies(r0);
            goto L4
        }

        static void validateSymbolName(GenericDescriptor r5) {
            String r0 = r5.getName();
            AnonymousClass1 r2 = null;
            if (r0.length() == 0) goto L28;
            int r1 = 0;
        L6:
            if (r1 >= r0.length()) goto L26;
            char r3 = r0.charAt(r1);
            if ('a' > r3) goto L12;
            if (r3 > 'z') goto L12;
        L25:
            r1 = r1 + 1;
        L12:
            if ('A' > r3) goto L16;
            if (r3 <= 'Z') goto L25;
        L16:
            if (r3 == '_') goto L25;
            if ('0' > r3) goto L24;
            if (r3 > '9') goto L24;
            if (r1 > 0) goto L25;
        L24:
            throw new DescriptorValidationException(r5, Typography.quote + r0 + "\" is not a valid identifier.", r2);
        L26:
            return;
        L28:
            throw new DescriptorValidationException(r5, "Missing name.", r2);
        }

        void addPackage(String r5, FileDescriptor r6) {
            int r0 = r5.lastIndexOf(46);
            if (r0 != (-1)) goto L5;
            String r1 = r5;
        L6:
            GenericDescriptor r2 = (GenericDescriptor) ZeusTransformUtils.preCheckCast(this.descriptorsByName.put(r5, new PackageDescriptor(r1, r5, r6)), GenericDescriptor.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L13;
            this.descriptorsByName.put(r5, r2);
            if (ZeusTransformUtils.instanceOf(r2, PackageDescriptor.class) == false) goto L12;
            return;
        L12:
            throw new DescriptorValidationException(r6, Typography.quote + r1 + "\" is already defined (as something other than a package) in file \"" + r2.getFile().getName() + "\".", null);
        L13:
            return;
        L5:
            addPackage(r5.substring(0, r0), r6);
            r1 = r5.substring(r0 + 1);
            goto L6
        }

        void addSymbol(GenericDescriptor r7) {
            validateSymbolName(r7);
            String r0 = r7.getFullName();
            GenericDescriptor r1 = (GenericDescriptor) ZeusTransformUtils.preCheckCast(this.descriptorsByName.put(r0, r7), GenericDescriptor.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L14;
            this.descriptorsByName.put(r0, r1);
            AnonymousClass1 r4 = null;
            if (r7.getFile() != r1.getFile()) goto L13;
            int r6 = r0.lastIndexOf(46);
            if (r6 != (-1)) goto L11;
            throw new DescriptorValidationException(r7, Typography.quote + r0 + "\" is already defined.", r4);
        L11:
            throw new DescriptorValidationException(r7, Typography.quote + r0.substring(r6 + 1) + "\" is already defined in \"" + r0.substring(0, r6) + "\".", r4);
        L13:
            throw new DescriptorValidationException(r7, Typography.quote + r0 + "\" is already defined in file \"" + r1.getFile().getName() + "\".", r4);
        }

        GenericDescriptor findSymbol(String r2) {
            return findSymbol(r2, SearchFilter.ALL_SYMBOLS);
        }

        GenericDescriptor findSymbol(String r5, SearchFilter r6) {
            GenericDescriptor r0 = (GenericDescriptor) ZeusTransformUtils.preCheckCast(this.descriptorsByName.get(r5), GenericDescriptor.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L15:
            Iterator<FileDescriptor> r1 = this.dependencies.iterator();
        L17:
            if (r1.hasNext() == false) goto L31;
            GenericDescriptor r2 = (GenericDescriptor) ZeusTransformUtils.preCheckCast(FileDescriptor.access$2200((FileDescriptor) ZeusTransformUtils.preCheckCast(r1.next(), FileDescriptor.class, "com.obric.memorydata.plugin")).descriptorsByName.get(r5), GenericDescriptor.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L17;
            if (r6 == SearchFilter.ALL_SYMBOLS) goto L30;
            if (r6 != SearchFilter.TYPES_ONLY) goto L27;
            if (isType(r2) == true) goto L30;
        L27:
            if (r6 != SearchFilter.AGGREGATES_ONLY) goto L17;
            if (isAggregate(r2) == false) goto L17;
        L30:
            return r2;
        L31:
            return null;
        L5:
            if (r6 != SearchFilter.ALL_SYMBOLS) goto L7;
        L14:
            return r0;
        L7:
            if (r6 != SearchFilter.TYPES_ONLY) goto L11;
            if (isType(r0) == true) goto L14;
        L11:
            if (r6 != SearchFilter.AGGREGATES_ONLY) goto L15;
            if (isAggregate(r0) == false) goto L15;
            goto L14
        }

        boolean isAggregate(GenericDescriptor r1) {
            if (ZeusTransformUtils.instanceOf(r1, Descriptor.class) == false) goto L5;
        L12:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, EnumDescriptor.class) == true) goto L12;
            if (ZeusTransformUtils.instanceOf(r1, PackageDescriptor.class) == true) goto L12;
            if (ZeusTransformUtils.instanceOf(r1, ServiceDescriptor.class) == true) goto L12;
            return false;
        }

        boolean isType(GenericDescriptor r1) {
            if (ZeusTransformUtils.instanceOf(r1, Descriptor.class) == false) goto L5;
        L8:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, EnumDescriptor.class) == true) goto L8;
            return false;
        }

        GenericDescriptor lookupSymbol(String r10, GenericDescriptor r11, SearchFilter r12) {
            if (r10.startsWith(".") == false) goto L5;
            String r0 = r10.substring(1);
            GenericDescriptor r1 = findSymbol(r0, r12);
        L19:
            if (r1 == null) goto L21;
            return r1;
        L21:
            if (this.allowUnknownDependencies == false) goto L27;
            if (r12 != SearchFilter.TYPES_ONLY) goto L27;
            Descriptors.access$000().warning("The descriptor for message type \"" + r10 + "\" cannot be found and a placeholder is created for it");
            Descriptor r13 = new Descriptor(r0);
            this.dependencies.add(r13.getFile());
            return r13;
        L27:
            throw new DescriptorValidationException(r11, Typography.quote + r10 + "\" is not defined.", null);
        L5:
            int r2 = r10.indexOf(46);
            if (r2 != (-1)) goto L8;
            String r3 = r10;
        L9:
            StringBuilder r4 = new StringBuilder(r11.getFullName());
        L10:
            int r5 = r4.lastIndexOf(".");
            if (r5 == (-1)) goto L12;
            int r6 = r5 + 1;
            r4.setLength(r6);
            r4.append(r3);
            GenericDescriptor r7 = findSymbol(r4.toString(), SearchFilter.AGGREGATES_ONLY);
            if (r7 != null) goto L15;
            r4.setLength(r5);
            goto L10
        L15:
            if (r2 == (-1)) goto L17;
            r4.setLength(r6);
            r4.append(r10);
            r1 = findSymbol(r4.toString(), r12);
        L18:
            r0 = r4.toString();
            goto L19
        L17:
            r1 = r7;
            goto L18
        L12:
            r1 = findSymbol(r10, r12);
            r0 = r10;
            goto L19
        L8:
            r3 = r10.substring(0, r2);
            goto L9
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        private DescriptorValidationException(FileDescriptor r3, String r4) {
            super(r3.getName() + ": " + r4);
            this.name = r3.getName();
            this.proto = r3.toProto();
            this.description = r4;
        }

        /* synthetic */ DescriptorValidationException(FileDescriptor r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private DescriptorValidationException(GenericDescriptor r3, String r4) {
            super(r3.getFullName() + ": " + r4);
            this.name = r3.getFullName();
            this.proto = r3.toProto();
            this.description = r4;
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private DescriptorValidationException(GenericDescriptor r1, String r2, Throwable r3) {
            this(r1, r2);
            initCause(r3);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor r1, String r2, Throwable r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public String getDescription() {
            return this.description;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getProblemSymbolName() {
            return this.name;
        }
    }

    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
        private ReferenceQueue<EnumValueDescriptor> cleanupQueue;
        private final Descriptor containingType;
        private final int distinctNumbers;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.EnumOptions options;
        private DescriptorProtos.EnumDescriptorProto proto;
        private Map<Integer, WeakReference<EnumValueDescriptor>> unknownValues;
        private final EnumValueDescriptor[] values;
        private final EnumValueDescriptor[] valuesSortedByNumber;

        private static class UnknownEnumValueReference extends WeakReference<EnumValueDescriptor> {
            private final int number;

            private UnknownEnumValueReference(int r1, EnumValueDescriptor r2) {
                super(r2);
                this.number = r1;
            }

            /* synthetic */ UnknownEnumValueReference(int r1, EnumValueDescriptor r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            static /* synthetic */ int access$3700(UnknownEnumValueReference r0) {
                return r0.number;
            }
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13) {
            AnonymousClass1 r0 = null;
            super(r0);
            this.unknownValues = null;
            this.cleanupQueue = null;
            if (r12 != null) goto L5;
            this.parent = r11;
        L6:
            this.index = r13;
            this.proto = r10;
            this.fullName = Descriptors.access$2600(r11, r12, r10.getName());
            this.file = r11;
            this.containingType = r12;
            if (r10.getValueCount() == 0) goto L22;
            this.values = new EnumValueDescriptor[r10.getValueCount()];
            int r14 = 0;
            int r15 = 0;
        L10:
            if (r15 >= r10.getValueCount()) goto L12;
            this.values[r15] = new EnumValueDescriptor(r10.getValue(r15), r11, this, r15, null);
            r15 = r15 + 1;
            goto L10
        L12:
            EnumValueDescriptor[] r16 = (EnumValueDescriptor[]) ZeusTransformUtils.preCheckCast(this.values.clone(), EnumValueDescriptor[].class, "com.obric.memorydata.plugin");
            this.valuesSortedByNumber = r16;
            Arrays.sort(r16, EnumValueDescriptor.BY_NUMBER);
            int r1 = 1;
        L14:
            if (r1 >= r10.getValueCount()) goto L19;
            EnumValueDescriptor[] r2 = this.valuesSortedByNumber;
            EnumValueDescriptor r3 = r2[r14];
            EnumValueDescriptor r4 = r2[r1];
            if (r3.getNumber() == r4.getNumber()) goto L18;
            r14 = r14 + 1;
            this.valuesSortedByNumber[r14] = r4;
        L18:
            r1 = r1 + 1;
            goto L14
        L19:
            int r17 = r14 + 1;
            this.distinctNumbers = r17;
            Arrays.fill(this.valuesSortedByNumber, r17, r10.getValueCount(), null);
            FileDescriptor.access$2200(r11).addSymbol(this);
            return;
        L22:
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", r0);
        L5:
            this.parent = r12;
            goto L6
        }

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto r1, FileDescriptor r2, Descriptor r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ void access$1200(EnumDescriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$1900(EnumDescriptor r0, DescriptorProtos.EnumDescriptorProto r1) {
            r0.setProto(r1);
        }

        static /* synthetic */ FileDescriptor access$4300(EnumDescriptor r0) {
            return r0.file;
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            EnumValueDescriptor[] r3 = this.values;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            EnumValueDescriptor.access$4100(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.EnumDescriptorProto r4) {
            this.proto = r4;
            this.options = null;
            resolveFeatures(r4.getOptions().getFeatures());
            int r0 = 0;
        L3:
            EnumValueDescriptor[] r1 = this.values;
            if (r0 >= r1.length) goto L6;
            EnumValueDescriptor.access$4200(r1[r0], r4.getValue(r0));
            r0 = r0 + 1;
            goto L3
        }

        public EnumValueDescriptor findValueByName(String r3) {
            GenericDescriptor r2 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r3);
            if (ZeusTransformUtils.instanceOf(r2, EnumValueDescriptor.class) == true) goto L5;
            return null;
        L5:
            return (EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r2, EnumValueDescriptor.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int r3) {
            return (EnumValueDescriptor) ZeusTransformUtils.preCheckCast(Descriptors.access$2400(this.valuesSortedByNumber, this.distinctNumbers, EnumValueDescriptor.NUMBER_GETTER, r3), EnumValueDescriptor.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public /* bridge */ /* synthetic */ Internal.EnumLite findValueByNumber(int r1) {
            return findValueByNumber(r1);
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(int r6) {
            EnumValueDescriptor r0 = findValueByNumber(r6);
            if (r0 == null) goto L5;
            return r0;
        L5:
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L7:
            if (this.cleanupQueue != null) goto L9;
            this.cleanupQueue = new ReferenceQueue();     // Catch: Throwable -> L20
            this.unknownValues = new HashMap();     // Catch: Throwable -> L20
        L11:
            WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(this.unknownValues.get(Integer.valueOf(r6)), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            AnonymousClass1 r2 = null;
            if (r1 != null) goto L14;
            EnumValueDescriptor r3 = null;
        L15:
            if (r3 != null) goto L17;
            r3 = new EnumValueDescriptor(this, Integer.valueOf(r6), r2);     // Catch: Throwable -> L20
            this.unknownValues.put(Integer.valueOf(r6), new UnknownEnumValueReference(r6, r3, r2));     // Catch: Throwable -> L20
        L17:
            monitor-exit(this);     // Catch: Throwable -> L20
            return r3;
        L14:
            r3 = (EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r1.get(), EnumValueDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        L9:
            UnknownEnumValueReference r4 = (UnknownEnumValueReference) ZeusTransformUtils.preCheckCast(this.cleanupQueue.poll(), UnknownEnumValueReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            if (r4 == null) goto L11;
            this.unknownValues.remove(Integer.valueOf(UnknownEnumValueReference.access$3700(r4)));     // Catch: Throwable -> L20
            goto L9
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.EnumOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.EnumOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        int getUnknownEnumValueDescriptorCount() {
            return this.unknownValues.size();
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        public boolean isClosed() {
            if (getFeatures().getEnumType() != DescriptorProtos.FeatureSet.EnumType.CLOSED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isReservedName(String r4) {
            Internal.checkNotNull(r4);
            Iterator<String> r3 = this.proto.getReservedNameList().iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            if (((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")).equals(r4) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r4) {
            Iterator<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> r3 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r3.hasNext() == false) goto L11;
            DescriptorProtos.EnumDescriptorProto.EnumReservedRange r0 = (DescriptorProtos.EnumDescriptorProto.EnumReservedRange) ZeusTransformUtils.preCheckCast(r3.next(), DescriptorProtos.EnumDescriptorProto.EnumReservedRange.class, "com.obric.memorydata.plugin");
            if (r0.getStart() > r4) goto L4;
            if (r4 > r0.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
        static final Comparator<EnumValueDescriptor> BY_NUMBER = null;
        static final NumberGetter<EnumValueDescriptor> NUMBER_GETTER = null;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.EnumValueOptions options;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        static {
            BY_NUMBER = new AnonymousClass1();
            NUMBER_GETTER = new AnonymousClass2();
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r2, FileDescriptor r3, EnumDescriptor r4, int r5) {
            super(null);
            this.parent = r4;
            this.index = r5;
            this.proto = r2;
            this.type = r4;
            this.fullName = r4.getFullName() + '.' + r2.getName();
            FileDescriptor.access$2200(r3).addSymbol(this);
        }

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r1, FileDescriptor r2, EnumDescriptor r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        private EnumValueDescriptor(EnumDescriptor r3, Integer r4) {
            super(null);
            DescriptorProtos.EnumValueDescriptorProto r5 = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + r3.getName() + "_" + r4).setNumber(r4.intValue()).build();
            this.parent = r3;
            this.index = -1;
            this.proto = r5;
            this.type = r3;
            this.fullName = r3.getFullName() + '.' + r5.getName();
        }

        /* synthetic */ EnumValueDescriptor(EnumDescriptor r1, Integer r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ void access$4100(EnumValueDescriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$4200(EnumValueDescriptor r0, DescriptorProtos.EnumValueDescriptorProto r1) {
            r0.setProto(r1);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.EnumValueDescriptorProto r2) {
            this.proto = r2;
            this.options = null;
            resolveFeatures(r2.getOptions().getFeatures());
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return EnumDescriptor.access$4300(this.type);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public DescriptorProtos.EnumValueOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.EnumValueOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public String toString() {
            return this.proto.getName();
        }
    }

    public static final class FieldDescriptor extends GenericDescriptor implements FieldSet.FieldDescriptorLite<FieldDescriptor>, Comparable<FieldDescriptor> {
        private static final NumberGetter<FieldDescriptor> NUMBER_GETTER = null;
        private static final WireFormat.FieldType[] table = null;
        private OneofDescriptor containingOneof;
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final boolean isProto3Optional;
        private volatile boolean isReportable;
        private String jsonName;
        private Descriptor messageType;
        private volatile DescriptorProtos.FieldOptions options;
        private DescriptorProtos.FieldDescriptorProto proto;
        private volatile Sensitivity sensitivity;
        private Type type;

        public static final enum JavaType extends java.lang.Enum<JavaType> {
            private static final /* synthetic */ JavaType[] $VALUES = null;
            public static final JavaType BOOLEAN = null;
            public static final JavaType BYTE_STRING = null;
            public static final JavaType DOUBLE = null;
            public static final JavaType ENUM = null;
            public static final JavaType FLOAT = null;
            public static final JavaType INT = null;
            public static final JavaType LONG = null;
            public static final JavaType MESSAGE = null;
            public static final JavaType STRING = null;
            private final Object defaultDefault;

            private static /* synthetic */ JavaType[] $values() {
                return new JavaType[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE};
            }

            static {
                INT = new JavaType("INT", 0, 0);
                LONG = new JavaType("LONG", 1, 0L);
                FLOAT = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
                DOUBLE = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
                BOOLEAN = new JavaType("BOOLEAN", 4, false);
                STRING = new JavaType("STRING", 5, "");
                BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
                ENUM = new JavaType("ENUM", 7, null);
                MESSAGE = new JavaType("MESSAGE", 8, null);
                $VALUES = $values();
            }

            private JavaType(String r1, int r2, Object r3) {
                super(r1, r2);
                this.defaultDefault = r3;
            }

            static /* synthetic */ Object access$3600(JavaType r0) {
                return r0.defaultDefault;
            }

            public static JavaType valueOf(String r2) {
                return (JavaType) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(JavaType.class, r2), JavaType.class, "com.obric.memorydata.plugin");
            }

            public static JavaType[] values() {
                return (JavaType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JavaType[].class, "com.obric.memorydata.plugin");
            }
        }

        private static final enum Sensitivity extends java.lang.Enum<Sensitivity> {
            private static final /* synthetic */ Sensitivity[] $VALUES = null;
            public static final Sensitivity NOT_SENSITIVE = null;
            public static final Sensitivity SENSITIVE = null;
            public static final Sensitivity UNKNOWN = null;

            private static /* synthetic */ Sensitivity[] $values() {
                return new Sensitivity[]{UNKNOWN, SENSITIVE, NOT_SENSITIVE};
            }

            static {
                UNKNOWN = new Sensitivity("UNKNOWN", 0);
                SENSITIVE = new Sensitivity("SENSITIVE", 1);
                NOT_SENSITIVE = new Sensitivity("NOT_SENSITIVE", 2);
                $VALUES = $values();
            }

            private Sensitivity(String r1, int r2) {
                super(r1, r2);
            }

            public static Sensitivity valueOf(String r2) {
                return (Sensitivity) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Sensitivity.class, r2), Sensitivity.class, "com.obric.memorydata.plugin");
            }

            public static Sensitivity[] values() {
                return (Sensitivity[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Sensitivity[].class, "com.obric.memorydata.plugin");
            }
        }

        public static final enum Type extends java.lang.Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type BOOL = null;
            public static final Type BYTES = null;
            public static final Type DOUBLE = null;
            public static final Type ENUM = null;
            public static final Type FIXED32 = null;
            public static final Type FIXED64 = null;
            public static final Type FLOAT = null;
            public static final Type GROUP = null;
            public static final Type INT32 = null;
            public static final Type INT64 = null;
            public static final Type MESSAGE = null;
            public static final Type SFIXED32 = null;
            public static final Type SFIXED64 = null;
            public static final Type SINT32 = null;
            public static final Type SINT64 = null;
            public static final Type STRING = null;
            public static final Type UINT32 = null;
            public static final Type UINT64 = null;
            private static final Type[] types = null;
            private final JavaType javaType;

            private static /* synthetic */ Type[] $values() {
                return new Type[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};
            }

            static {
                DOUBLE = new Type("DOUBLE", 0, JavaType.DOUBLE);
                FLOAT = new Type("FLOAT", 1, JavaType.FLOAT);
                INT64 = new Type("INT64", 2, JavaType.LONG);
                UINT64 = new Type("UINT64", 3, JavaType.LONG);
                INT32 = new Type("INT32", 4, JavaType.INT);
                FIXED64 = new Type("FIXED64", 5, JavaType.LONG);
                FIXED32 = new Type("FIXED32", 6, JavaType.INT);
                BOOL = new Type("BOOL", 7, JavaType.BOOLEAN);
                STRING = new Type("STRING", 8, JavaType.STRING);
                GROUP = new Type("GROUP", 9, JavaType.MESSAGE);
                MESSAGE = new Type("MESSAGE", 10, JavaType.MESSAGE);
                BYTES = new Type("BYTES", 11, JavaType.BYTE_STRING);
                UINT32 = new Type("UINT32", 12, JavaType.INT);
                ENUM = new Type("ENUM", 13, JavaType.ENUM);
                SFIXED32 = new Type("SFIXED32", 14, JavaType.INT);
                SFIXED64 = new Type("SFIXED64", 15, JavaType.LONG);
                SINT32 = new Type("SINT32", 16, JavaType.INT);
                SINT64 = new Type("SINT64", 17, JavaType.LONG);
                $VALUES = $values();
                types = values();
            }

            private Type(String r1, int r2, JavaType r3) {
                super(r1, r2);
                this.javaType = r3;
            }

            static /* synthetic */ Type[] access$3400() {
                return types;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type r1) {
                return types[r1.getNumber() - 1];
            }

            public static Type valueOf(String r2) {
                return (Type) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
            }

            public static Type[] values() {
                return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }
        }

        static {
            NUMBER_GETTER = new AnonymousClass1();
            table = WireFormat.FieldType.values();
            if (Type.access$3400().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) goto L6;
            return;
        L6:
            throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto r3, FileDescriptor r4, Descriptor r5, int r6, boolean r7) {
            AnonymousClass1 r0 = null;
            super(r0);
            this.sensitivity = Sensitivity.UNKNOWN;
            this.isReportable = false;
            this.parent = r5;
            this.index = r6;
            this.proto = r3;
            this.fullName = Descriptors.access$2600(r4, r5, r3.getName());
            this.file = r4;
            if (r3.hasType() == false) goto L5;
            this.type = Type.valueOf(r3.getType());
        L5:
            this.isProto3Optional = r3.getProto3Optional();
            if (getNumber() <= 0) goto L38;
            boolean r8 = r3.hasExtendee();
            if (r7 == false) goto L21;
            if (r8 == false) goto L20;
            this.containingType = null;
            if (r5 == null) goto L13;
            this.extensionScope = r5;
        L15:
            if (r3.hasOneofIndex() == true) goto L18;
            this.containingOneof = null;
        L33:
            FileDescriptor.access$2200(r4).addSymbol(this);
            return;
        L18:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", r0);
        L13:
            this.extensionScope = null;
            this.parent = r4;
            goto L15
        L20:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", r0);
        L21:
            if (r8 == true) goto L36;
            this.containingType = r5;
            if (r3.hasOneofIndex() == true) goto L25;
            this.containingOneof = null;
        L32:
            this.extensionScope = null;
            goto L33
        L25:
            if (r3.getOneofIndex() < 0) goto L30;
            if (r3.getOneofIndex() >= r5.toProto().getOneofDeclCount()) goto L30;
            OneofDescriptor r9 = (OneofDescriptor) ZeusTransformUtils.preCheckCast(r5.getOneofs().get(r3.getOneofIndex()), OneofDescriptor.class, "com.obric.memorydata.plugin");
            this.containingOneof = r9;
            OneofDescriptor.access$2908(r9);
            this.parent = this.containingOneof;
        L30:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + r5.getName(), r0);
        L36:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", r0);
        L38:
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", r0);
        }

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto r1, FileDescriptor r2, Descriptor r3, int r4, boolean r5, AnonymousClass1 r6) {
            this(r1, r2, r3, r4, r5);
        }

        static /* synthetic */ void access$1400(FieldDescriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$1700(FieldDescriptor r0) {
            r0.crossLink();
        }

        static /* synthetic */ void access$2100(FieldDescriptor r0, DescriptorProtos.FieldDescriptorProto r1) {
            r0.setProto(r1);
        }

        static /* synthetic */ NumberGetter access$2300() {
            return NUMBER_GETTER;
        }

        static /* synthetic */ boolean access$4900(FieldDescriptor r0) {
            return r0.isProto3Optional;
        }

        private List<Boolean> calculateSensitivityData() {
            if (this.sensitivity != Sensitivity.UNKNOWN) goto L28;
            monitor-enter(this);
        L25:
            th = move-exception;
            throw th;
        L6:
            if (this.sensitivity != Sensitivity.UNKNOWN) goto L23;
            boolean r0 = this.proto.getOptions().getDebugRedact();     // Catch: Throwable -> L25
            Iterator<Map.Entry<FieldDescriptor, Object>> r1 = this.proto.getOptions().getAllFields().entrySet().iterator();     // Catch: Throwable -> L25
        L9:
            if (r1.hasNext() == false) goto L19;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            List<Boolean> r5 = isOptionSensitive((FieldDescriptor) ZeusTransformUtils.preCheckCast(r4.getKey(), FieldDescriptor.class, "com.obric.memorydata.plugin"), r4.getValue());     // Catch: Throwable -> L25
            if (r0 == false) goto L13;
        L16:
            r0 = true;
        L17:
            this.isReportable = ((Boolean) ZeusTransformUtils.preCheckCast(r5.get(1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L25
            if (r0 == false) goto L9;
        L13:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5.get(0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L16;
            r0 = false;
        L19:
            if (r0 == false) goto L21;
            Sensitivity r2 = Sensitivity.SENSITIVE;     // Catch: Throwable -> L25
        L22:
            this.sensitivity = r2;     // Catch: Throwable -> L25
            goto L23
        L21:
            r2 = Sensitivity.NOT_SENSITIVE;     // Catch: Throwable -> L25
        L23:
            monitor-exit(this);     // Catch: Throwable -> L25
        L28:
            Boolean[] r3 = new Boolean[2];
            if (this.sensitivity != Sensitivity.SENSITIVE) goto L31;
            boolean r6 = true;
        L32:
            r3[0] = Boolean.valueOf(r6);
            r3[1] = Boolean.valueOf(this.isReportable);
            return Arrays.asList(r3);
        L31:
            r6 = false;
            goto L32
        }

        private void crossLink() {
            AnonymousClass1 r4 = null;
            if (this.proto.hasExtendee() == false) goto L14;
            GenericDescriptor r0 = FileDescriptor.access$2200(this.file).lookupSymbol(this.proto.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (ZeusTransformUtils.instanceOf(r0, Descriptor.class) == false) goto L12;
            this.containingType = (Descriptor) ZeusTransformUtils.preCheckCast(r0, Descriptor.class, "com.obric.memorydata.plugin");
            if (getContainingType().isExtensionNumber(getNumber()) == true) goto L14;
            throw new DescriptorValidationException(this, Typography.quote + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", r4);
        L12:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getExtendee() + "\" is not a message type.", r4);
        L14:
            if (this.proto.hasTypeName() == false) goto L47;
            GenericDescriptor r1 = FileDescriptor.access$2200(this.file).lookupSymbol(this.proto.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (this.proto.hasType() == true) goto L27;
            if (ZeusTransformUtils.instanceOf(r1, Descriptor.class) == false) goto L22;
            Type r5 = Type.MESSAGE;
        L20:
            this.type = r5;
            goto L27
        L22:
            if (ZeusTransformUtils.instanceOf(r1, EnumDescriptor.class) == false) goto L25;
            r5 = Type.ENUM;
            goto L20
        L25:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getTypeName() + "\" is not a type.", r4);
        L27:
            if (this.type.getJavaType() != JavaType.MESSAGE) goto L38;
            if (ZeusTransformUtils.instanceOf(r1, Descriptor.class) == false) goto L36;
            this.messageType = (Descriptor) ZeusTransformUtils.preCheckCast(r1, Descriptor.class, "com.obric.memorydata.plugin");
            if (this.proto.hasDefaultValue() == false) goto L51;
            throw new DescriptorValidationException(this, "Messages can't have default values.", r4);
        L51:
            if (this.proto.getOptions().getPacked() == false) goto L58;
            if (isPackable() == true) goto L58;
            throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", r4);
        L58:
            if (this.proto.hasDefaultValue() == false) goto L111;
            if (isRepeated() == true) goto L109;
        L105:
            e = move-exception;
            throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + Typography.quote, e, r4);
        L63:
            switch(this.type.ordinal()) {
                case 0: goto L95;
                case 1: goto L85;
                case 2: goto L83;
                case 3: goto L82;
                case 4: goto L81;
                case 5: goto L82;
                case 6: goto L80;
                case 7: goto L79;
                case 8: goto L77;
                case 9: goto L76;
                case 10: goto L76;
                case 11: goto L125;
                case 12: goto L80;
                case 13: goto L65;
                case 14: goto L81;
                case 15: goto L83;
                case 16: goto L81;
                case 17: goto L83;
                default: goto L130;
            };
        L65:
            EnumValueDescriptor r2 = this.enumType.findValueByName(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            this.defaultValue = r2;     // Catch: NumberFormatException -> L105
            if (r2 == null) goto L69;
            return;
        L69:
            throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + Typography.quote, r4);     // Catch: NumberFormatException -> L105
        L77:
            Object r3 = this.proto.getDefaultValue();     // Catch: NumberFormatException -> L105
        L78:
            this.defaultValue = r3;     // Catch: NumberFormatException -> L105
            return;
        L79:
            r3 = Boolean.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            goto L78
        L80:
            r3 = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L81:
            r3 = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L82:
            r3 = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L83:
            r3 = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L125:
            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());     // Catch: TextFormat.InvalidEscapeSequenceException -> L72 NumberFormatException -> L105
        L131:
            return;
        L72:
            e = move-exception;
            throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, r4);     // Catch: NumberFormatException -> L105
        L130:
            return;
        L76:
            throw new DescriptorValidationException(this, "Message type had default value.", r4);     // Catch: NumberFormatException -> L105
        L85:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L88;
            r3 = Float.valueOf(Float.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L88:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L91;
            r3 = Float.valueOf(Float.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L91:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L93;
            r3 = Float.valueOf(Float.NaN);     // Catch: NumberFormatException -> L105
            goto L78
        L93:
            r3 = Float.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            goto L78
        L95:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L98;
            r3 = Double.valueOf(Double.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L98:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L101;
            r3 = Double.valueOf(Double.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L101:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L103;
            r3 = Double.valueOf(Double.NaN);     // Catch: NumberFormatException -> L105
            goto L78
        L103:
            r3 = Double.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            goto L78
        L109:
            throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", r4);
        L111:
            if (isRepeated() == false) goto L114;
            Object r6 = Collections.emptyList();
        L113:
            this.defaultValue = r6;
            return;
        L114:
            int r7 = this.type.getJavaType().ordinal();
            if (r7 != 7) goto L117;
            r6 = this.enumType.getValues().get(0);
            goto L113
        L117:
            if (r7 == 8) goto L119;
            r6 = JavaType.access$3600(this.type.getJavaType());
            goto L113
        L119:
            this.defaultValue = null;
            return;
        L36:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getTypeName() + "\" is not a message type.", r4);
        L38:
            if (this.type.getJavaType() != JavaType.ENUM) goto L45;
            if (ZeusTransformUtils.instanceOf(r1, EnumDescriptor.class) == false) goto L43;
            this.enumType = (EnumDescriptor) ZeusTransformUtils.preCheckCast(r1, EnumDescriptor.class, "com.obric.memorydata.plugin");
            goto L51
        L43:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getTypeName() + "\" is not an enum type.", r4);
        L45:
            throw new DescriptorValidationException(this, "Field with primitive type has type_name.", r4);
        L47:
            if (this.type.getJavaType() == JavaType.MESSAGE) goto L123;
            if (this.type.getJavaType() != JavaType.ENUM) goto L51;
        L123:
            throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", r4);
        }

        private static String fieldNameToJsonName(String r7) {
            int r0 = r7.length();
            StringBuilder r1 = new StringBuilder(r0);
            int r3 = 0;
            boolean r4 = false;
        L3:
            if (r3 >= r0) goto L17;
            char r5 = r7.charAt(r3);
            if (r5 != '_') goto L7;
            r4 = true;
        L15:
            r3 = r3 + 1;
            goto L3
        L7:
            if (r4 == true) goto L9;
            r1.append(r5);
            goto L15
        L9:
            if ('a' <= r5) goto L11;
        L13:
            r1.append(r5);
            r4 = false;
            goto L15
        L11:
            if (r5 > 'z') goto L13;
            r5 = (char) ((r5 - 'a') + 65);
            goto L13
        L17:
            return r1.toString();
        }

        private List<Boolean> isOptionSensitive(FieldDescriptor r10, Object r11) {
            if (r10.getType() != Type.ENUM) goto L18;
            if (r10.isRepeated() == false) goto L14;
            Iterator r9 = ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r9.hasNext() == false) goto L37;
            if (((EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r9.next(), EnumValueDescriptor.class, "com.obric.memorydata.plugin")).getOptions().getDebugRedact() == false) goto L8;
            return Arrays.asList(new Boolean[]{true, false});
        L37:
            return Arrays.asList(new Boolean[]{false, false});
        L14:
            if (((EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r11, EnumValueDescriptor.class, "com.obric.memorydata.plugin")).getOptions().getDebugRedact() == false) goto L37;
            return Arrays.asList(new Boolean[]{true, false});
        L18:
            if (r10.getJavaType() != JavaType.MESSAGE) goto L37;
            if (r10.isRepeated() == false) goto L30;
            Iterator r12 = ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).iterator();
        L23:
            if (r12.hasNext() == false) goto L37;
            Iterator<Map.Entry<FieldDescriptor, Object>> r13 = ((Message) ZeusTransformUtils.preCheckCast(r12.next(), Message.class, "com.obric.memorydata.plugin")).getAllFields().entrySet().iterator();
        L26:
            if (r13.hasNext() == false) goto L23;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            List<Boolean> r2 = isOptionSensitive((FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.getKey(), FieldDescriptor.class, "com.obric.memorydata.plugin"), r1.getValue());
            if (((Boolean) ZeusTransformUtils.preCheckCast(r2.get(0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
            return r2;
        L30:
            Iterator<Map.Entry<FieldDescriptor, Object>> r14 = ((Message) ZeusTransformUtils.preCheckCast(r11, Message.class, "com.obric.memorydata.plugin")).getAllFields().entrySet().iterator();
        L32:
            if (r14.hasNext() == false) goto L37;
            Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            List<Boolean> r16 = isOptionSensitive((FieldDescriptor) ZeusTransformUtils.preCheckCast(r15.getKey(), FieldDescriptor.class, "com.obric.memorydata.plugin"), r15.getValue());
            if (((Boolean) ZeusTransformUtils.preCheckCast(r16.get(0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L32;
            return r16;
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.FieldDescriptorProto r2) {
            this.proto = r2;
            this.options = null;
            resolveFeatures(r2.getOptions().getFeatures());
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FieldDescriptor r3) {
            if (r3.containingType != this.containingType) goto L7;
            return getNumber() - r3.getNumber();
        L7:
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(FieldDescriptor r3) {
            return compareTo2((FieldDescriptor) ZeusTransformUtils.preCheckCast(r3, FieldDescriptor.class, "com.obric.memorydata.plugin"));
        }

        public OneofDescriptor getContainingOneof() {
            return this.containingOneof;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public Object getDefaultValue() {
            if (getJavaType() == JavaType.MESSAGE) goto L7;
            return this.defaultValue;
        L7:
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public EnumDescriptor getEnumType() {
            if (getJavaType() != JavaType.ENUM) goto L7;
            return this.enumType;
        L7:
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[]{this.fullName}));
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public /* bridge */ /* synthetic */ Internal.EnumLiteMap getEnumType() {
            return getEnumType();
        }

        public Descriptor getExtensionScope() {
            if (isExtension() == false) goto L7;
            return this.extensionScope;
        L7:
            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[]{this.fullName}));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public JavaType getJavaType() {
            return getType().getJavaType();
        }

        public String getJsonName() {
            String r0 = this.jsonName;
            if (r0 == null) goto L6;
            return r0;
        L6:
            if (this.proto.hasJsonName() == false) goto L10;
            String r1 = this.proto.getJsonName();
        L8:
            this.jsonName = r1;
            return r1;
        L10:
            r1 = fieldNameToJsonName(this.proto.getName());
            goto L8
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return table[getType().ordinal()];
        }

        public Descriptor getMessageType() {
            if (getJavaType() != JavaType.MESSAGE) goto L7;
            return this.messageType;
        L7:
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", new Object[]{this.fullName}));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public DescriptorProtos.FieldOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.FieldOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public OneofDescriptor getRealContainingOneof() {
            OneofDescriptor r0 = this.containingOneof;
            if (r0 != null) goto L5;
        L7:
            return null;
        L5:
            if (r0.isSynthetic() == true) goto L7;
            return this.containingOneof;
        }

        public Type getType() {
            if (this.type != Type.MESSAGE) goto L19;
            Descriptor r0 = this.messageType;
            if (r0 != null) goto L7;
        L8:
            Descriptor r1 = this.containingType;
            if (r1 == null) goto L13;
            if (r1.toProto().getOptions().getMapEntry() == true) goto L19;
        L13:
            if (this.features == null) goto L19;
            if (getFeatures().getMessageEncoding() != DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED) goto L19;
            return Type.GROUP;
        L7:
            if (r0.toProto().getOptions().getMapEntry() == false) goto L8;
        L19:
            return this.type;
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        boolean hasInferredLegacyProtoFeatures() {
            if (getFile().getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L6;
            return false;
        L6:
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) goto L9;
            return true;
        L9:
            if (this.proto.getType() != DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP) goto L12;
            return true;
        L12:
            if (this.proto.getOptions().getPacked() == false) goto L15;
            return true;
        L15:
            if (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO3) goto L17;
        L21:
            return false;
        L17:
            if (this.proto.getOptions().hasPacked() == false) goto L21;
            if (this.proto.getOptions().getPacked() == true) goto L21;
            return true;
        }

        boolean hasOptionalKeyword() {
            if (this.isProto3Optional == false) goto L5;
        L14:
            return true;
        L5:
            if (this.file.getEdition() == DescriptorProtos.Edition.EDITION_PROTO2) goto L7;
        L13:
            return false;
        L7:
            if (isRequired() == true) goto L13;
            if (isRepeated() == true) goto L13;
            if (getContainingOneof() != null) goto L13;
            goto L13
        }

        public boolean hasPresence() {
            if (isRepeated() == false) goto L6;
            return false;
        L6:
            if (this.isProto3Optional == false) goto L8;
        L17:
            return true;
        L8:
            if (getType() == Type.MESSAGE) goto L17;
            if (getType() == Type.GROUP) goto L17;
            if (isExtension() == true) goto L17;
            if (getContainingOneof() != null) goto L17;
            if (getFeatures().getFieldPresence() != DescriptorProtos.FeatureSet.FieldPresence.IMPLICIT) goto L17;
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            DescriptorProtos.FeatureSet.Builder r0 = DescriptorProtos.FeatureSet.newBuilder();
            if (getFile().getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L7;
            return r0.build();
        L7:
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) goto L10;
            r0.setFieldPresence(DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED);
        L10:
            if (this.proto.getType() != DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP) goto L13;
            r0.setMessageEncoding(DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED);
        L13:
            if (getFile().getEdition() != DescriptorProtos.Edition.EDITION_PROTO2) goto L18;
            if (this.proto.getOptions().getPacked() == false) goto L18;
            r0.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.PACKED);
        L18:
            if (getFile().getEdition() != DescriptorProtos.Edition.EDITION_PROTO3) goto L25;
            if (this.proto.getOptions().hasPacked() == false) goto L25;
            if (this.proto.getOptions().getPacked() == true) goto L25;
            r0.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.EXPANDED);
        L25:
            return r0.build();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r2, MessageLite r3) {
            MessageLite.Builder r1 = (MessageLite.Builder) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.Builder.class, "com.obric.memorydata.plugin");
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            return ((Message.Builder) ZeusTransformUtils.preCheckCast(r1, Message.Builder.class, "com.obric.memorydata.plugin")).mergeFrom((Message) ZeusTransformUtils.preCheckCast(r4, Message.class, "com.obric.memorydata.plugin"));
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        boolean isGroupLike() {
            if (getType() == Type.GROUP) goto L6;
            return false;
        L6:
            if (getMessageType().getName().toLowerCase().equals(getName()) == true) goto L9;
            return false;
        L9:
            if (getMessageType().getFile() == getFile()) goto L12;
            return false;
        L12:
            if (isExtension() == false) goto L17;
            if (getMessageType().getContainingType() == getExtensionScope()) goto L19;
            return false;
        L19:
            return true;
        L17:
            if (getMessageType().getContainingType() == getContainingType()) goto L19;
            return false;
        }

        public boolean isMapField() {
            if (getType() == Type.MESSAGE) goto L5;
        L9:
            return false;
        L5:
            if (isRepeated() == false) goto L9;
            if (getMessageType().toProto().getOptions().getMapEntry() == false) goto L9;
            return true;
        }

        @Deprecated
        public boolean isOptional() {
            if (this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL) goto L5;
        L7:
            return false;
        L5:
            if (getFeatures().getFieldPresence() == DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED) goto L7;
            return true;
        }

        public boolean isPackable() {
            if (isRepeated() == true) goto L5;
        L7:
            return false;
        L5:
            if (getLiteType().isPackable() == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            if (isPackable() == true) goto L7;
            return false;
        L7:
            return getFeatures().getRepeatedFieldEncoding().equals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.PACKED);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isReportable() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(calculateSensitivityData().get(1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        public boolean isRequired() {
            if (getFeatures().getFieldPresence() != DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isSensitive() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(calculateSensitivityData().get(0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        public boolean legacyEnumFieldTreatedAsClosed() {
            if (getFile().getDependencies().isEmpty() == false) goto L12;
            if (getType() != Type.ENUM) goto L10;
            if (this.enumType.isClosed() == false) goto L10;
            return true;
        L10:
            return false;
        L12:
            if (getType() != Type.ENUM) goto L19;
            if (((JavaFeaturesProto.JavaFeatures) ZeusTransformUtils.preCheckCast(getFeatures().getExtension(JavaFeaturesProto.java_), JavaFeaturesProto.JavaFeatures.class, "com.obric.memorydata.plugin")).getLegacyClosedEnum() == false) goto L16;
            return true;
        L16:
            if (this.enumType.isClosed() == false) goto L19;
            return true;
        L19:
            return false;
        }

        public boolean needsUtf8Check() {
            if (getType() == Type.STRING) goto L7;
            return false;
        L7:
            if (getContainingType().toProto().getOptions().getMapEntry() == false) goto L10;
            return true;
        L10:
            if (((JavaFeaturesProto.JavaFeatures) ZeusTransformUtils.preCheckCast(getFeatures().getExtension(JavaFeaturesProto.java_), JavaFeaturesProto.JavaFeatures.class, "com.obric.memorydata.plugin")).getUtf8Validation().equals(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY) == false) goto L13;
            return true;
        L13:
            return getFeatures().getUtf8Validation().equals(DescriptorProtos.FeatureSet.Utf8Validation.VERIFY);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FieldDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public String toString() {
            return getFullName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        void validateFeatures() {
            Descriptor r0 = this.containingType;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.toProto().getOptions().getMessageSetWireFormat() == true) goto L7;
            return;
        L7:
            if (isExtension() == true) goto L9;
            return;
        L9:
            if (isRequired() == false) goto L11;
        L15:
            String r2 = "Extensions of MessageSets may not be required or repeated messages.";
            throw new DescriptorValidationException(this, r2, null);
        L11:
            if (isRepeated() == true) goto L15;
            if (getType() != Type.MESSAGE) goto L15;
        }
    }

    public static final class FileDescriptor extends GenericDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private volatile boolean featuresResolved;
        private final Descriptor[] messageTypes;
        private volatile DescriptorProtos.FileOptions options;
        private final DescriptorPool pool;
        private DescriptorProtos.FileDescriptorProto proto;
        private final FileDescriptor[] publicDependencies;
        private final ServiceDescriptor[] services;

        @Deprecated
        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor r1);
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11, DescriptorPool r12, boolean r13) {
            AnonymousClass1 r0 = null;
            super(r0);
            this.pool = r12;
            this.proto = r10;
            this.dependencies = (FileDescriptor[]) ZeusTransformUtils.preCheckCast(r11.clone(), FileDescriptor[].class, "com.obric.memorydata.plugin");
            int r1 = 0;
            this.featuresResolved = false;
            HashMap r2 = new HashMap();
            int r4 = r11.length;
            int r5 = 0;
        L3:
            if (r5 >= r4) goto L5;
            FileDescriptor r6 = r11[r5];
            r2.put(r6.getName(), r6);
            r5 = r5 + 1;
            goto L3
        L5:
            ArrayList r14 = new ArrayList();
            int r7 = 0;
        L7:
            if (r7 >= r10.getPublicDependencyCount()) goto L22;
            int r8 = r10.getPublicDependency(r7);
            if (r8 < 0) goto L21;
            if (r8 >= r10.getDependencyCount()) goto L21;
            String r9 = r10.getDependency(r8);
            FileDescriptor r15 = (FileDescriptor) ZeusTransformUtils.preCheckCast(r2.get(r9), FileDescriptor.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L18;
            if (r13 == true) goto L19;
            throw new DescriptorValidationException(this, "Invalid public dependency: " + r9, r0);
        L19:
            r7 = r7 + 1;
            goto L7
        L18:
            r14.add(r15);
        L21:
            throw new DescriptorValidationException(this, "Invalid public dependency index.", r0);
        L22:
            FileDescriptor[] r16 = new FileDescriptor[r14.size()];
            this.publicDependencies = r16;
            r14.toArray(r16);
            r12.addPackage(getPackage(), this);
            if (r10.getMessageTypeCount() <= 0) goto L25;
            Descriptor[] r17 = new Descriptor[r10.getMessageTypeCount()];
        L26:
            this.messageTypes = r17;
            int r18 = 0;
        L28:
            if (r18 >= r10.getMessageTypeCount()) goto L31;
            this.messageTypes[r18] = new Descriptor(r10.getMessageType(r18), this, null, r18, null);
            r18 = r18 + 1;
            goto L28
        L31:
            if (r10.getEnumTypeCount() <= 0) goto L33;
            EnumDescriptor[] r19 = new EnumDescriptor[r10.getEnumTypeCount()];
        L34:
            this.enumTypes = r19;
            int r110 = 0;
        L36:
            if (r110 >= r10.getEnumTypeCount()) goto L39;
            this.enumTypes[r110] = new EnumDescriptor(r10.getEnumType(r110), this, null, r110, null);
            r110 = r110 + 1;
            goto L36
        L39:
            if (r10.getServiceCount() <= 0) goto L41;
            ServiceDescriptor[] r111 = new ServiceDescriptor[r10.getServiceCount()];
        L42:
            this.services = r111;
            int r112 = 0;
        L44:
            if (r112 >= r10.getServiceCount()) goto L47;
            this.services[r112] = new ServiceDescriptor(r10.getService(r112), this, r112, r0);
            r112 = r112 + 1;
            goto L44
        L47:
            if (r10.getExtensionCount() <= 0) goto L49;
            FieldDescriptor[] r113 = new FieldDescriptor[r10.getExtensionCount()];
        L50:
            this.extensions = r113;
        L52:
            if (r1 >= r10.getExtensionCount()) goto L54;
            this.extensions[r1] = new FieldDescriptor(r10.getExtension(r1), this, null, r1, true, null);
            r1 = r1 + 1;
            goto L52
        L54:
            return;
        L49:
            r113 = Descriptors.access$900();
            goto L50
        L41:
            r111 = Descriptors.access$700();
            goto L42
        L33:
            r19 = Descriptors.access$500();
            goto L34
        L25:
            r17 = Descriptors.access$300();
            goto L26
        }

        FileDescriptor(String r7, Descriptor r8) {
            super(null);
            this.parent = null;
            DescriptorPool r0 = new DescriptorPool(new FileDescriptor[0], true);
            this.pool = r0;
            this.proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(r8.getFullName() + ".placeholder.proto").setPackage(r7).addMessageType(r8.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.featuresResolved = false;
            this.messageTypes = new Descriptor[]{r8};
            this.enumTypes = Descriptors.access$500();
            this.services = Descriptors.access$700();
            this.extensions = Descriptors.access$900();
            r0.addPackage(r7, this);
            r0.addSymbol(r8);
        }

        static /* synthetic */ DescriptorPool access$2200(FileDescriptor r0) {
            return r0.pool;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r1, FileDescriptor[] r2) {
            return buildFrom(r1, r2, false);
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r1, FileDescriptor[] r2, boolean r3) {
            return buildFrom(r1, r2, r3, false);
        }

        private static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r2, FileDescriptor[] r3, boolean r4, boolean r5) {
            FileDescriptor r1 = new FileDescriptor(r2, r3, new DescriptorPool(r3, r4), r4);
            r1.crossLink();
            if (r5 == true) goto L5;
            r1.resolveAllFeaturesInternal();
        L5:
            return r1;
        }

        private void crossLink() {
            Descriptor[] r0 = this.messageTypes;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            Descriptor.access$1500(r0[r3]);
            r3 = r3 + 1;
            goto L3
        L5:
            ServiceDescriptor[] r4 = this.services;
            int r5 = r4.length;
            int r6 = 0;
        L6:
            if (r6 >= r5) goto L8;
            ServiceDescriptor.access$1600(r4[r6]);
            r6 = r6 + 1;
            goto L6
        L8:
            FieldDescriptor[] r7 = this.extensions;
            int r8 = r7.length;
        L9:
            if (r2 >= r8) goto L11;
            FieldDescriptor.access$1700(r7[r2]);
            r2 = r2 + 1;
            goto L9
        }

        private static FileDescriptor[] findDescriptors(Class<?> r6, String[] r7, String[] r8) {
            ArrayList r0 = new ArrayList();
            int r2 = 0;
        L4:
            if (r2 >= r7.length) goto L10;
            r0.add((FileDescriptor) ZeusTransformUtils.preCheckCast(r6.getClassLoader().loadClass(r7[r2]).getField("descriptor").get(null), FileDescriptor.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L7
        L8:
            r2 = r2 + 1;
        L7:
            Descriptors.access$000().warning("Descriptors for \"" + r8[r2] + "\" can not be found.");
            goto L8
        L10:
            return (FileDescriptor[]) ZeusTransformUtils.preCheckCast(r0.toArray(new FileDescriptor[0]), FileDescriptor[].class, "com.obric.memorydata.plugin");
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] r0, Class<?> r1, String[] r2, String[] r3) {
            return internalBuildGeneratedFileFrom(r0, findDescriptors(r1, r2, r3));
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] r3, FileDescriptor[] r4) {
            DescriptorProtos.FileDescriptorProto r5 = DescriptorProtos.FileDescriptorProto.parseFrom(latin1Cat(r3));     // Catch: InvalidProtocolBufferException -> L10
            return buildFrom(r5, r4, true, true);
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r5.getName() + "\".", e);
        L10:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        public static void internalUpdateFileDescriptor(FileDescriptor r1, ExtensionRegistry r2) {
            r1.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r1.proto.toByteString(), r2));     // Catch: InvalidProtocolBufferException -> L5
            return;
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        private static byte[] latin1Cat(String[] r4) {
            int r1 = 0;
            if (r4.length != 1) goto L7;
            String r5 = r4[0];
        L6:
            return r5.getBytes(Internal.ISO_8859_1);
        L7:
            StringBuilder r0 = new StringBuilder();
            int r2 = r4.length;
        L8:
            if (r1 >= r2) goto L10;
            r0.append(r4[r1]);
            r1 = r1 + 1;
            goto L8
        L10:
            r5 = r0.toString();
            goto L6
        }

        private void resolveAllFeaturesInternal() {
            if (this.featuresResolved == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L25:
            th = move-exception;
            throw th;
        L7:
            if (this.featuresResolved == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L25
            return;
        L10:
            resolveFeatures(this.proto.getOptions().getFeatures());     // Catch: Throwable -> L25
            Descriptor[] r0 = this.messageTypes;     // Catch: Throwable -> L25
            int r1 = r0.length;     // Catch: Throwable -> L25
            int r2 = 0;
            int r3 = 0;
        L11:
            if (r3 >= r1) goto L13;
            Descriptor.access$1100(r0[r3]);     // Catch: Throwable -> L25
            r3 = r3 + 1;     // Catch: Throwable -> L25
            goto L11
        L13:
            EnumDescriptor[] r4 = this.enumTypes;     // Catch: Throwable -> L25
            int r5 = r4.length;     // Catch: Throwable -> L25
            int r6 = 0;
        L14:
            if (r6 >= r5) goto L16;
            EnumDescriptor.access$1200(r4[r6]);     // Catch: Throwable -> L25
            r6 = r6 + 1;     // Catch: Throwable -> L25
            goto L14
        L16:
            ServiceDescriptor[] r7 = this.services;     // Catch: Throwable -> L25
            int r8 = r7.length;     // Catch: Throwable -> L25
            int r9 = 0;
        L17:
            if (r9 >= r8) goto L19;
            ServiceDescriptor.access$1300(r7[r9]);     // Catch: Throwable -> L25
            r9 = r9 + 1;     // Catch: Throwable -> L25
            goto L17
        L19:
            FieldDescriptor[] r10 = this.extensions;     // Catch: Throwable -> L25
            int r11 = r10.length;     // Catch: Throwable -> L25
        L20:
            if (r2 >= r11) goto L22;
            FieldDescriptor.access$1400(r10[r2]);     // Catch: Throwable -> L25
            r2 = r2 + 1;     // Catch: Throwable -> L25
            goto L20
        L22:
            this.featuresResolved = true;     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
        }

        private synchronized void setProto(DescriptorProtos.FileDescriptorProto r5) {
            monitor-enter(this);
            this.proto = r5;     // Catch: Throwable -> L25
            this.options = null;     // Catch: Throwable -> L25
            resolveFeatures(r5.getOptions().getFeatures());     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            int r0 = 0;
            int r1 = 0;
        L5:
            Descriptor[] r2 = this.messageTypes;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r1 >= r2.length) goto L8;
            Descriptor.access$1800(r2[r1], r5.getMessageType(r1));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r1 = r1 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            goto L5
        L8:
            int r3 = 0;
        L9:
            EnumDescriptor[] r4 = this.enumTypes;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r3 >= r4.length) goto L12;
            EnumDescriptor.access$1900(r4[r3], r5.getEnumType(r3));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r3 = r3 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            goto L9
        L12:
            int r6 = 0;
        L13:
            ServiceDescriptor[] r7 = this.services;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r6 >= r7.length) goto L16;
            ServiceDescriptor.access$2000(r7[r6], r5.getService(r6));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r6 = r6 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
        L16:
            FieldDescriptor[] r8 = this.extensions;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r0 >= r8.length) goto L20;
            FieldDescriptor.access$2100(r8[r0], r5.getExtension(r0));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r0 = r0 + 1;
            goto L16
        L20:
            monitor-exit(this);
            return;
        L22:
            e = move-exception;
            throw new IllegalArgumentException("Invalid features for \"" + r5.getName() + "\".", e);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        public void copyHeadingTo(DescriptorProtos.FileDescriptorProto.Builder r3) {
            r3.setName(getName()).setSyntax(this.proto.getSyntax());
            if (getPackage().isEmpty() == true) goto L6;
            r3.setPackage(getPackage());
        L6:
            if (this.proto.getSyntax().equals("editions") == false) goto L9;
            r3.setEdition(this.proto.getEdition());
        L9:
            if (this.proto.hasOptions() == true) goto L11;
            return;
        L11:
            if (this.proto.getOptions().equals(DescriptorProtos.FileOptions.getDefaultInstance()) == true) goto L15;
            r3.setOptions(this.proto.getOptions());
            return;
        }

        public EnumDescriptor findEnumTypeByName(String r5) {
            if (r5.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r1 = getPackage();
            if (r1.isEmpty() == true) goto L8;
            r5 = r1 + '.' + r5;
        L8:
            GenericDescriptor r6 = this.pool.findSymbol(r5);
            if (ZeusTransformUtils.instanceOf(r6, EnumDescriptor.class) == true) goto L11;
        L14:
            return null;
        L11:
            if (r6.getFile() != this) goto L14;
            return (EnumDescriptor) ZeusTransformUtils.preCheckCast(r6, EnumDescriptor.class, "com.obric.memorydata.plugin");
        }

        public FieldDescriptor findExtensionByName(String r5) {
            if (r5.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r1 = getPackage();
            if (r1.isEmpty() == true) goto L8;
            r5 = r1 + '.' + r5;
        L8:
            GenericDescriptor r6 = this.pool.findSymbol(r5);
            if (ZeusTransformUtils.instanceOf(r6, FieldDescriptor.class) == true) goto L11;
        L14:
            return null;
        L11:
            if (r6.getFile() != this) goto L14;
            return (FieldDescriptor) ZeusTransformUtils.preCheckCast(r6, FieldDescriptor.class, "com.obric.memorydata.plugin");
        }

        public Descriptor findMessageTypeByName(String r5) {
            if (r5.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r1 = getPackage();
            if (r1.isEmpty() == true) goto L8;
            r5 = r1 + '.' + r5;
        L8:
            GenericDescriptor r6 = this.pool.findSymbol(r5);
            if (ZeusTransformUtils.instanceOf(r6, Descriptor.class) == true) goto L11;
        L14:
            return null;
        L11:
            if (r6.getFile() != this) goto L14;
            return (Descriptor) ZeusTransformUtils.preCheckCast(r6, Descriptor.class, "com.obric.memorydata.plugin");
        }

        public ServiceDescriptor findServiceByName(String r5) {
            if (r5.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r1 = getPackage();
            if (r1.isEmpty() == true) goto L8;
            r5 = r1 + '.' + r5;
        L8:
            GenericDescriptor r6 = this.pool.findSymbol(r5);
            if (ZeusTransformUtils.instanceOf(r6, ServiceDescriptor.class) == true) goto L11;
        L14:
            return null;
        L11:
            if (r6.getFile() != this) goto L14;
            return (ServiceDescriptor) ZeusTransformUtils.preCheckCast(r6, ServiceDescriptor.class, "com.obric.memorydata.plugin");
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        DescriptorProtos.Edition getEdition() {
            String r0 = this.proto.getSyntax();
            r0.hashCode();
            if (r0.equals("proto3") == true) goto L11;
            if (r0.equals("editions") == true) goto L9;
            return DescriptorProtos.Edition.EDITION_PROTO2;
        L9:
            return this.proto.getEdition();
        L11:
            return DescriptorProtos.Edition.EDITION_PROTO3;
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.proto.getName();
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.FileOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.FileOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        public List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        boolean hasInferredLegacyProtoFeatures() {
            if (getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L6;
            return false;
        L6:
            if (getEdition() == DescriptorProtos.Edition.EDITION_PROTO2) goto L8;
        L11:
            return false;
        L8:
            if (this.proto.getOptions().getJavaStringCheckUtf8() == false) goto L11;
            return true;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            DescriptorProtos.FeatureSet.Builder r0 = DescriptorProtos.FeatureSet.newBuilder();
            if (getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L7;
            return r0.build();
        L7:
            if (getEdition() != DescriptorProtos.Edition.EDITION_PROTO2) goto L12;
            if (this.proto.getOptions().getJavaStringCheckUtf8() == false) goto L12;
            r0.setExtension(JavaFeaturesProto.java_, JavaFeaturesProto.JavaFeatures.newBuilder().setUtf8Validation(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY).build());
        L12:
            return r0.build();
        }

        public void resolveAllFeaturesImmutable() {
            resolveAllFeaturesInternal();     // Catch: DescriptorValidationException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalArgumentException("Invalid features for \"" + this.proto.getName() + "\".", e);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FileDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    public static abstract class GenericDescriptor {
        volatile DescriptorProtos.FeatureSet features;
        GenericDescriptor parent;

        private GenericDescriptor() {
        }

        /* synthetic */ GenericDescriptor(AnonymousClass1 r1) {
            this();
        }

        DescriptorProtos.FeatureSet getFeatures() {
            if (this.features != null) goto L10;
            if (getFile().getEdition() != DescriptorProtos.Edition.EDITION_PROTO2) goto L7;
        L8:
            getFile().resolveAllFeaturesImmutable();
            goto L10
        L7:
            if (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO3) goto L8;
        L10:
            if (this.features == null) goto L14;
            return this.features;
        L14:
            throw new NullPointerException(String.format("Features not yet loaded for %s.", new Object[]{getFullName()}));
        }

        public abstract FileDescriptor getFile();

        public abstract String getFullName();

        public abstract String getName();

        boolean hasInferredLegacyProtoFeatures() {
            return false;
        }

        DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        }

        void resolveFeatures(DescriptorProtos.FeatureSet r8) {
            if (this.parent != null) goto L5;
        L11:
            Iterator<FieldDescriptor> r0 = r8.getExtensionFields().keySet().iterator();
            boolean r1 = true;
            boolean r3 = false;
        L13:
            if (r0.hasNext() == false) goto L20;
            FieldDescriptor r4 = (FieldDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), FieldDescriptor.class, "com.obric.memorydata.plugin");
            if (r4.getNumber() != JavaFeaturesProto.java_.getNumber()) goto L13;
            if (r4 == JavaFeaturesProto.java_.getDescriptor()) goto L13;
            r3 = true;
            goto L13
        L20:
            if (r8.getUnknownFields().isEmpty() == false) goto L22;
        L24:
            r1 = false;
        L25:
            if (r3 == true) goto L27;
            if (r1 == true) goto L27;
        L29:
            GenericDescriptor r2 = this.parent;
            if (r2 != null) goto L32;
            DescriptorProtos.FeatureSet r5 = Descriptors.getEditionDefaults(getFile().getEdition());
        L33:
            DescriptorProtos.FeatureSet.Builder r6 = r5.toBuilder();
            r6.mergeFrom(inferLegacyProtoFeatures());
            r6.mergeFrom(r8);
            DescriptorProtos.FeatureSet r9 = Descriptors.access$4800(r6.build());
        L9:
            this.features = r9;
            validateFeatures();
            return;
        L32:
            r5 = r2.features;
        L27:
            ExtensionRegistry r7 = ExtensionRegistry.newInstance();
            r7.add(JavaFeaturesProto.java_);
            r8 = DescriptorProtos.FeatureSet.parseFrom(r8.toByteString(), r7);     // Catch: InvalidProtocolBufferException -> L34
        L34:
            e = move-exception;
            throw new DescriptorValidationException(this, "Failed to parse features with Java feature extension registry.", e, null);
        L22:
            if (r8.getUnknownFields().hasField(JavaFeaturesProto.java_.getNumber()) == false) goto L24;
        L5:
            if (r8.equals(DescriptorProtos.FeatureSet.getDefaultInstance()) == false) goto L11;
            if (hasInferredLegacyProtoFeatures() == true) goto L11;
            r9 = this.parent.features;
            goto L9
        }

        public abstract Message toProto();

        void validateFeatures() {
        }
    }

    public static final class MethodDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private volatile DescriptorProtos.MethodOptions options;
        private Descriptor outputType;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto r2, FileDescriptor r3, ServiceDescriptor r4, int r5) {
            super(null);
            this.parent = r4;
            this.index = r5;
            this.proto = r2;
            this.file = r3;
            this.service = r4;
            this.fullName = r4.getFullName() + '.' + r2.getName();
            FileDescriptor.access$2200(r3).addSymbol(this);
        }

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto r1, FileDescriptor r2, ServiceDescriptor r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ void access$4500(MethodDescriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$4600(MethodDescriptor r0) {
            r0.crossLink();
        }

        static /* synthetic */ void access$4700(MethodDescriptor r0, DescriptorProtos.MethodDescriptorProto r1) {
            r0.setProto(r1);
        }

        private void crossLink() {
            GenericDescriptor r0 = FileDescriptor.access$2200(getFile()).lookupSymbol(this.proto.getInputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            AnonymousClass1 r2 = null;
            if (ZeusTransformUtils.instanceOf(r0, Descriptor.class) == false) goto L11;
            this.inputType = (Descriptor) ZeusTransformUtils.preCheckCast(r0, Descriptor.class, "com.obric.memorydata.plugin");
            GenericDescriptor r1 = FileDescriptor.access$2200(getFile()).lookupSymbol(this.proto.getOutputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (ZeusTransformUtils.instanceOf(r1, Descriptor.class) == false) goto L9;
            this.outputType = (Descriptor) ZeusTransformUtils.preCheckCast(r1, Descriptor.class, "com.obric.memorydata.plugin");
            return;
        L9:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getOutputType() + "\" is not a message type.", r2);
        L11:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getInputType() + "\" is not a message type.", r2);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.MethodDescriptorProto r2) {
            this.proto = r2;
            this.options = null;
            resolveFeatures(r2.getOptions().getFeatures());
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.MethodOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.MethodOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        public boolean isClientStreaming() {
            return this.proto.getClientStreaming();
        }

        public boolean isServerStreaming() {
            return this.proto.getServerStreaming();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.MethodDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    private interface NumberGetter<T> {
        int getNumber(T r1);
    }

    public static final class OneofDescriptor extends GenericDescriptor {
        private Descriptor containingType;
        private int fieldCount;
        private FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.OneofOptions options;
        private DescriptorProtos.OneofDescriptorProto proto;

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto r2, FileDescriptor r3, Descriptor r4, int r5) {
            super(null);
            this.parent = r4;
            this.proto = r2;
            this.fullName = Descriptors.access$2600(r3, r4, r2.getName());
            this.file = r3;
            this.index = r5;
            this.containingType = r4;
            this.fieldCount = 0;
        }

        /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto r1, FileDescriptor r2, Descriptor r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ FieldDescriptor[] access$2800(OneofDescriptor r0) {
            return r0.fields;
        }

        static /* synthetic */ FieldDescriptor[] access$2802(OneofDescriptor r0, FieldDescriptor[] r1) {
            r0.fields = r1;
            return r1;
        }

        static /* synthetic */ int access$2902(OneofDescriptor r0, int r1) {
            r0.fieldCount = r1;
            return r1;
        }

        static /* synthetic */ int access$2908(OneofDescriptor r2) {
            int r0 = r2.fieldCount;
            r2.fieldCount = r0 + 1;
            return r0;
        }

        static /* synthetic */ void access$3200(OneofDescriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$3300(OneofDescriptor r0, DescriptorProtos.OneofDescriptorProto r1) {
            r0.setProto(r1);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.OneofDescriptorProto r2) {
            this.proto = r2;
            this.options = null;
            resolveFeatures(r2.getOptions().getFeatures());
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public FieldDescriptor getField(int r1) {
            return this.fields[r1];
        }

        public int getFieldCount() {
            return this.fieldCount;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.OneofOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.OneofOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        boolean isSynthetic() {
            FieldDescriptor[] r3 = this.fields;
            if (r3.length == 1) goto L5;
            return false;
        L5:
            if (FieldDescriptor.access$4900(r3[0]) == true) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.OneofDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    public static final class ServiceDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private volatile DescriptorProtos.ServiceOptions options;
        private DescriptorProtos.ServiceDescriptorProto proto;

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r9, FileDescriptor r10, int r11) {
            super(null);
            this.parent = r10;
            this.index = r11;
            this.proto = r9;
            this.fullName = Descriptors.access$2600(r10, null, r9.getName());
            this.file = r10;
            this.methods = new MethodDescriptor[r9.getMethodCount()];
            int r12 = 0;
        L4:
            if (r12 >= r9.getMethodCount()) goto L6;
            int r4 = r12;
            this.methods[r12] = new MethodDescriptor(r9.getMethod(r12), r10, this, r4, null);
            r12 = r12 + 1;
            goto L4
        L6:
            FileDescriptor.access$2200(r10).addSymbol(this);
        }

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r1, FileDescriptor r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ void access$1300(ServiceDescriptor r0) {
            r0.resolveAllFeatures();
        }

        static /* synthetic */ void access$1600(ServiceDescriptor r0) {
            r0.crossLink();
        }

        static /* synthetic */ void access$2000(ServiceDescriptor r0, DescriptorProtos.ServiceDescriptorProto r1) {
            r0.setProto(r1);
        }

        private void crossLink() {
            MethodDescriptor[] r3 = this.methods;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            MethodDescriptor.access$4600(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            MethodDescriptor[] r3 = this.methods;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            MethodDescriptor.access$4500(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.ServiceDescriptorProto r4) {
            this.proto = r4;
            this.options = null;
            resolveFeatures(r4.getOptions().getFeatures());
            int r0 = 0;
        L3:
            MethodDescriptor[] r1 = this.methods;
            if (r0 >= r1.length) goto L6;
            MethodDescriptor.access$4700(r1[r0], r4.getMethod(r0));
            r0 = r0 + 1;
            goto L3
        }

        public MethodDescriptor findMethodByName(String r3) {
            GenericDescriptor r2 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r3);
            if (ZeusTransformUtils.instanceOf(r2, MethodDescriptor.class) == true) goto L5;
            return null;
        L5:
            return (MethodDescriptor) ZeusTransformUtils.preCheckCast(r2, MethodDescriptor.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.ServiceOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.ServiceOptions r0 = this.proto.getOptions();
            if (r0.hasFeatures() == false) goto L7;
            r0 = r0.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    static {
        logger = Logger.getLogger(Descriptors.class.getName());
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_DESCRIPTORS = new Descriptor[0];
        EMPTY_FIELD_DESCRIPTORS = new FieldDescriptor[0];
        EMPTY_ENUM_DESCRIPTORS = new EnumDescriptor[0];
        EMPTY_SERVICE_DESCRIPTORS = new ServiceDescriptor[0];
        EMPTY_ONEOF_DESCRIPTORS = new OneofDescriptor[0];
        FEATURE_CACHE = new ConcurrentHashMap();
        javaEditionDefaults = null;
    }

    public Descriptors() {
    }

    static /* synthetic */ Logger access$000() {
        return logger;
    }

    static /* synthetic */ Object access$2400(Object[] r2, int r3, NumberGetter r4, int r5) {
        return binarySearch(r2, r3, (NumberGetter) ZeusTransformUtils.wrapperContextForParams(r4, NumberGetter.class, "com.obric.memorydata.plugin"), r5);
    }

    static /* synthetic */ OneofDescriptor[] access$2500() {
        return EMPTY_ONEOF_DESCRIPTORS;
    }

    static /* synthetic */ String access$2600(FileDescriptor r0, Descriptor r1, String r2) {
        return computeFullName(r0, r1, r2);
    }

    static /* synthetic */ Descriptor[] access$300() {
        return EMPTY_DESCRIPTORS;
    }

    static /* synthetic */ int[] access$3100() {
        return EMPTY_INT_ARRAY;
    }

    static /* synthetic */ DescriptorProtos.FeatureSet access$4800(DescriptorProtos.FeatureSet r0) {
        return internFeatures(r0);
    }

    static /* synthetic */ EnumDescriptor[] access$500() {
        return EMPTY_ENUM_DESCRIPTORS;
    }

    static /* synthetic */ ServiceDescriptor[] access$700() {
        return EMPTY_SERVICE_DESCRIPTORS;
    }

    static /* synthetic */ FieldDescriptor[] access$900() {
        return EMPTY_FIELD_DESCRIPTORS;
    }

    private static <T> T binarySearch(T[] r4, int r5, NumberGetter<T> r6, int r7) {
        NumberGetter r8 = (NumberGetter) ZeusTransformUtils.wrapperContextForParams(r6, NumberGetter.class, "com.obric.memorydata.plugin");
        int r9 = r5 - 1;
        int r0 = 0;
    L3:
        if (r0 > r9) goto L10;
        int r1 = (r0 + r9) / 2;
        T r2 = r4[r1];
        int r3 = r8.getNumber(r2);
        if (r7 < r3) goto L6;
        if (r7 <= r3) goto L9;
        r0 = r1 + 1;
        goto L3
    L9:
        return r2;
    L6:
        r9 = r1 - 1;
        goto L3
    L10:
        return null;
    }

    private static String computeFullName(FileDescriptor r1, Descriptor r2, String r3) {
        if (r2 == null) goto L7;
        StringBuilder r4 = new StringBuilder().append(r2.getFullName());
    L6:
        return r4.append('.').append(r3).toString();
    L7:
        String r5 = r1.getPackage();
        if (r5.isEmpty() == true) goto L10;
        r4 = new StringBuilder().append(r5);
        goto L6
    L10:
        return r3;
    }

    static DescriptorProtos.FeatureSet getEditionDefaults(DescriptorProtos.Edition r6) {
        DescriptorProtos.FeatureSetDefaults r0 = getJavaEditionDefaults();
        if (r6.getNumber() < r0.getMinimumEdition().getNumber()) goto L21;
        if (r6.getNumber() > r0.getMaximumEdition().getNumber()) goto L19;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault r1 = null;
        Iterator<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault> r2 = r0.getDefaultsList().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault r3 = (DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault) ZeusTransformUtils.preCheckCast(r2.next(), DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.class, "com.obric.memorydata.plugin");
        if (r3.getEdition().getNumber() > r6.getNumber()) goto L13;
        r1 = r3;
    L13:
        if (r1 == null) goto L17;
        return r1.getFixedFeatures().toBuilder().mergeFrom(r1.getOverridableFeatures()).build();
    L17:
        throw new IllegalArgumentException("Edition " + r6 + " does not have a valid default FeatureSet!");
    L19:
        throw new IllegalArgumentException("Edition " + r6 + " is greater than the maximum supported edition " + r0.getMaximumEdition() + "!");
    L21:
        throw new IllegalArgumentException("Edition " + r6 + " is lower than the minimum supported edition " + r0.getMinimumEdition() + "!");
    }

    static DescriptorProtos.FeatureSetDefaults getJavaEditionDefaults() {
        DescriptorProtos.FeatureSetDefaults.getDescriptor();
        JavaFeaturesProto.getDescriptor();
        if (javaEditionDefaults != null) goto L19;
        monitor-enter(Descriptors.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (javaEditionDefaults == null) goto L21;
    L13:
        monitor-exit(Descriptors.class);     // Catch: Throwable -> L15
        goto L19
    L21:
        ExtensionRegistry r1 = ExtensionRegistry.newInstance();     // Catch: Exception -> L10 Throwable -> L15
        r1.add(JavaFeaturesProto.java_);     // Catch: Exception -> L10 Throwable -> L15
        setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults.parseFrom(JavaEditionDefaults.PROTOBUF_INTERNAL_JAVA_EDITION_DEFAULTS.getBytes(Internal.ISO_8859_1), r1));     // Catch: Exception -> L10 Throwable -> L15
    L10:
        e = move-exception;
        throw new AssertionError(e);     // Catch: Throwable -> L15
    L19:
        return javaEditionDefaults;
    }

    private static DescriptorProtos.FeatureSet internFeatures(DescriptorProtos.FeatureSet r3) {
        DescriptorProtos.FeatureSet r0 = (DescriptorProtos.FeatureSet) ZeusTransformUtils.preCheckCast(FEATURE_CACHE.putIfAbsent(Integer.valueOf(r3.hashCode()), r3), DescriptorProtos.FeatureSet.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0;
    }

    static void setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults r0) {
        javaEditionDefaults = r0;
    }
}
