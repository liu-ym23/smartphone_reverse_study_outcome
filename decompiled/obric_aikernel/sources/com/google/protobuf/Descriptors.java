package com.google.protobuf;

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

/* JADX INFO: loaded from: classes2.dex */
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

        private Descriptor(DescriptorProtos.DescriptorProto r11, FileDescriptor r12, Descriptor r13, int r14) {
            AnonymousClass1 r10 = null;
            super(r10);
            if (r13 != null) goto L5;
            this.parent = r12;
        L6:
            this.index = r14;
            this.proto = r11;
            this.fullName = Descriptors.access$2600(r12, r13, r11.getName());
            this.file = r12;
            this.containingType = r13;
            if (r11.getOneofDeclCount() <= 0) goto L9;
            OneofDescriptor[] r15 = new OneofDescriptor[r11.getOneofDeclCount()];
        L10:
            this.oneofs = r15;
            int r16 = 0;
            int r17 = 0;
        L12:
            if (r17 >= r11.getOneofDeclCount()) goto L15;
            this.oneofs[r17] = new OneofDescriptor(r11.getOneofDecl(r17), r12, this, r17, null);
            r17 = r17 + 1;
            goto L12
        L15:
            if (r11.getNestedTypeCount() <= 0) goto L17;
            Descriptor[] r18 = new Descriptor[r11.getNestedTypeCount()];
        L18:
            this.nestedTypes = r18;
            int r19 = 0;
        L20:
            if (r19 >= r11.getNestedTypeCount()) goto L23;
            this.nestedTypes[r19] = new Descriptor(r11.getNestedType(r19), r12, this, r19);
            r19 = r19 + 1;
            goto L20
        L23:
            if (r11.getEnumTypeCount() <= 0) goto L25;
            EnumDescriptor[] r110 = new EnumDescriptor[r11.getEnumTypeCount()];
        L26:
            this.enumTypes = r110;
            int r111 = 0;
        L28:
            if (r111 >= r11.getEnumTypeCount()) goto L31;
            this.enumTypes[r111] = new EnumDescriptor(r11.getEnumType(r111), r12, this, r111, null);
            r111 = r111 + 1;
            goto L28
        L31:
            if (r11.getFieldCount() <= 0) goto L33;
            FieldDescriptor[] r112 = new FieldDescriptor[r11.getFieldCount()];
        L34:
            this.fields = r112;
            int r113 = 0;
        L36:
            if (r113 >= r11.getFieldCount()) goto L39;
            this.fields[r113] = new FieldDescriptor(r11.getField(r113), r12, this, r113, false, null);
            r113 = r113 + 1;
            goto L36
        L39:
            if (r11.getFieldCount() <= 0) goto L41;
            FieldDescriptor[] r114 = (FieldDescriptor[]) this.fields.clone();
        L42:
            this.fieldsSortedByNumber = r114;
            if (r11.getExtensionCount() <= 0) goto L45;
            FieldDescriptor[] r115 = new FieldDescriptor[r11.getExtensionCount()];
        L46:
            this.extensions = r115;
            int r116 = 0;
        L48:
            if (r116 >= r11.getExtensionCount()) goto L50;
            this.extensions[r116] = new FieldDescriptor(r11.getExtension(r116), r12, this, r116, true, null);
            r116 = r116 + 1;
            goto L48
        L50:
            int r117 = 0;
        L52:
            if (r117 >= r11.getOneofDeclCount()) goto L54;
            OneofDescriptor[] r20 = this.oneofs;
            OneofDescriptor.access$2802(r20[r117], new FieldDescriptor[r20[r117].getFieldCount()]);
            OneofDescriptor.access$2902(this.oneofs[r117], 0);
            r117 = r117 + 1;
            goto L52
        L54:
            int r118 = 0;
        L56:
            if (r118 >= r11.getFieldCount()) goto L61;
            OneofDescriptor r21 = this.fields[r118].getContainingOneof();
            if (r21 == null) goto L60;
            OneofDescriptor.access$2800(r21)[OneofDescriptor.access$2908(r21)] = this.fields[r118];
        L60:
            r118 = r118 + 1;
            goto L56
        L61:
            OneofDescriptor[] r119 = this.oneofs;
            int r22 = r119.length;
            int r23 = 0;
            int r24 = 0;
        L62:
            if (r23 >= r22) goto L70;
            if (r119[r23].isSynthetic() == false) goto L66;
            r24 = r24 + 1;
        L67:
            r23 = r23 + 1;
            goto L62
        L66:
            if (r24 <= 0) goto L67;
            throw new DescriptorValidationException(this, "Synthetic oneofs must come last.", r10);
        L70:
            this.realOneofCount = this.oneofs.length - r24;
            FileDescriptor.access$2200(r12).addSymbol(this);
            if (r11.getExtensionRangeCount() <= 0) goto L77;
            this.extensionRangeLowerBounds = new int[r11.getExtensionRangeCount()];
            this.extensionRangeUpperBounds = new int[r11.getExtensionRangeCount()];
            Iterator<DescriptorProtos.DescriptorProto.ExtensionRange> r120 = r11.getExtensionRangeList().iterator();
        L74:
            if (r120.hasNext() == false) goto L76;
            DescriptorProtos.DescriptorProto.ExtensionRange r121 = r120.next();
            this.extensionRangeLowerBounds[r16] = r121.getStart();
            this.extensionRangeUpperBounds[r16] = r121.getEnd();
            r16 = r16 + 1;
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
            r115 = Descriptors.access$900();
            goto L46
        L41:
            r114 = Descriptors.access$900();
            goto L42
        L33:
            r112 = Descriptors.access$900();
            goto L34
        L25:
            r110 = Descriptors.access$500();
            goto L26
        L17:
            r18 = Descriptors.access$300();
            goto L18
        L9:
            r15 = Descriptors.access$2500();
            goto L10
        L5:
            this.parent = r13;
            goto L6
        }

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        Descriptor(String r10) {
            super(null);
            int r11 = r10.lastIndexOf(46);
            if (r11 == (-1)) goto L5;
            String r12 = r10.substring(r11 + 1);
            String r13 = r10.substring(0, r11);
        L6:
            this.index = 0;
            this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(r12).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
            this.fullName = r10;
            this.containingType = null;
            this.nestedTypes = Descriptors.access$300();
            this.enumTypes = Descriptors.access$500();
            this.fields = Descriptors.access$900();
            this.fieldsSortedByNumber = Descriptors.access$900();
            this.extensions = Descriptors.access$900();
            this.oneofs = Descriptors.access$2500();
            this.realOneofCount = 0;
            FileDescriptor r14 = new FileDescriptor(r13, this);
            this.file = r14;
            this.parent = r14;
            this.extensionRangeLowerBounds = new int[]{1};
            this.extensionRangeUpperBounds = new int[]{536870912};
            return;
        L5:
            r13 = "";
            r12 = r10;
            goto L6
        }

        static /* synthetic */ void access$1100(Descriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$1500(Descriptor r10) {
            r10.crossLink();
        }

        static /* synthetic */ void access$1800(Descriptor r10, DescriptorProtos.DescriptorProto r11) {
            r10.setProto(r11);
        }

        private void crossLink() {
            Descriptor[] r10 = this.nestedTypes;
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            r10[r13].crossLink();
            r13 = r13 + 1;
            goto L3
        L5:
            FieldDescriptor[] r14 = this.fields;
            int r15 = r14.length;
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L8;
            FieldDescriptor.access$1700(r14[r16]);
            r16 = r16 + 1;
            goto L6
        L8:
            Arrays.sort(this.fieldsSortedByNumber);
            validateNoDuplicateFieldNumbers();
            FieldDescriptor[] r17 = this.extensions;
            int r18 = r17.length;
        L9:
            if (r12 >= r18) goto L11;
            FieldDescriptor.access$1700(r17[r12]);
            r12 = r12 + 1;
            goto L9
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            Descriptor[] r10 = this.nestedTypes;
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            r10[r13].resolveAllFeatures();
            r13 = r13 + 1;
            goto L3
        L5:
            EnumDescriptor[] r14 = this.enumTypes;
            int r15 = r14.length;
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L8;
            EnumDescriptor.access$1200(r14[r16]);
            r16 = r16 + 1;
            goto L6
        L8:
            OneofDescriptor[] r17 = this.oneofs;
            int r18 = r17.length;
            int r19 = 0;
        L9:
            if (r19 >= r18) goto L11;
            OneofDescriptor.access$3200(r17[r19]);
            r19 = r19 + 1;
            goto L9
        L11:
            FieldDescriptor[] r20 = this.fields;
            int r21 = r20.length;
            int r22 = 0;
        L12:
            if (r22 >= r21) goto L14;
            FieldDescriptor.access$1400(r20[r22]);
            r22 = r22 + 1;
            goto L12
        L14:
            FieldDescriptor[] r23 = this.extensions;
            int r24 = r23.length;
        L15:
            if (r12 >= r24) goto L17;
            FieldDescriptor.access$1400(r23[r12]);
            r12 = r12 + 1;
            goto L15
        }

        private void setProto(DescriptorProtos.DescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
            int r11 = 0;
            int r12 = 0;
        L3:
            Descriptor[] r13 = this.nestedTypes;
            if (r12 >= r13.length) goto L6;
            r13[r12].setProto(r10.getNestedType(r12));
            r12 = r12 + 1;
            goto L3
        L6:
            int r14 = 0;
        L7:
            OneofDescriptor[] r15 = this.oneofs;
            if (r14 >= r15.length) goto L10;
            OneofDescriptor.access$3300(r15[r14], r10.getOneofDecl(r14));
            r14 = r14 + 1;
            goto L7
        L10:
            int r16 = 0;
        L11:
            EnumDescriptor[] r17 = this.enumTypes;
            if (r16 >= r17.length) goto L14;
            EnumDescriptor.access$1900(r17[r16], r10.getEnumType(r16));
            r16 = r16 + 1;
            goto L11
        L14:
            int r18 = 0;
        L15:
            FieldDescriptor[] r19 = this.fields;
            if (r18 >= r19.length) goto L18;
            FieldDescriptor.access$2100(r19[r18], r10.getField(r18));
            r18 = r18 + 1;
        L18:
            FieldDescriptor[] r20 = this.extensions;
            if (r11 >= r20.length) goto L21;
            FieldDescriptor.access$2100(r20[r11], r10.getExtension(r11));
            r11 = r11 + 1;
            goto L18
        }

        private void validateNoDuplicateFieldNumbers() {
            int r10 = 0;
        L3:
            int r11 = r10 + 1;
            FieldDescriptor[] r12 = this.fieldsSortedByNumber;
            if (r11 >= r12.length) goto L10;
            FieldDescriptor r13 = r12[r10];
            FieldDescriptor r14 = r12[r11];
            if (r13.getNumber() == r14.getNumber()) goto L9;
            r10 = r11;
            goto L3
        L9:
            throw new DescriptorValidationException(r14, "Field number " + r14.getNumber() + " has already been used in \"" + r14.getContainingType().getFullName() + "\" by field \"" + r13.getName() + "\".", null);
        }

        public EnumDescriptor findEnumTypeByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r10);
            if ((r11 instanceof EnumDescriptor) == true) goto L5;
            return null;
        L5:
            return (EnumDescriptor) r11;
        }

        public FieldDescriptor findFieldByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r10);
            if ((r11 instanceof FieldDescriptor) == true) goto L5;
            return null;
        L5:
            return (FieldDescriptor) r11;
        }

        public FieldDescriptor findFieldByNumber(int r10) {
            FieldDescriptor[] r11 = this.fieldsSortedByNumber;
            return (FieldDescriptor) Descriptors.access$2400(r11, r11.length, FieldDescriptor.access$2300(), r10);
        }

        public Descriptor findNestedTypeByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r10);
            if ((r11 instanceof Descriptor) == true) goto L5;
            return null;
        L5:
            return (Descriptor) r11;
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
            DescriptorProtos.MessageOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
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

        public boolean isExtensionNumber(int r10) {
            int r11 = Arrays.binarySearch(this.extensionRangeLowerBounds, r10);
            if (r11 >= 0) goto L5;
            r11 = (~r11) - 1;
        L5:
            if (r11 >= 0) goto L7;
        L9:
            return false;
        L7:
            if (r10 >= this.extensionRangeUpperBounds[r11]) goto L9;
            return true;
        }

        public boolean isReservedName(String r10) {
            Internal.checkNotNull(r10);
            Iterator<String> r11 = this.proto.getReservedNameList().iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            if (r11.next().equals(r10) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r10) {
            Iterator<DescriptorProtos.DescriptorProto.ReservedRange> r11 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ReservedRange r12 = r11.next();
            if (r12.getStart() > r10) goto L4;
            if (r10 >= r12.getEnd()) goto L4;
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

            PackageDescriptor(String r10, String r11, FileDescriptor r12) {
                super(null);
                this.file = r12;
                this.fullName = r11;
                this.name = r10;
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

            private SearchFilter(String r10, int r11) {
                super(r10, r11);
            }

            public static SearchFilter valueOf(String r10) {
                return (SearchFilter) java.lang.Enum.valueOf(SearchFilter.class, r10);
            }

            public static SearchFilter[] values() {
                return (SearchFilter[]) $VALUES.clone();
            }
        }

        DescriptorPool(FileDescriptor[] r10, boolean r11) {
            this.descriptorsByName = new HashMap();
            this.dependencies = Collections.newSetFromMap(new IdentityHashMap(r10.length));
            this.allowUnknownDependencies = r11;
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            FileDescriptor r14 = r10[r13];
            this.dependencies.add(r14);
            importPublicDependencies(r14);
            r13 = r13 + 1;
            goto L3
        L5:
            Iterator<FileDescriptor> r15 = this.dependencies.iterator();
        L7:
            if (r15.hasNext() == false) goto L14;
            FileDescriptor r16 = r15.next();
            addPackage(r16.getPackage(), r16);     // Catch: DescriptorValidationException -> L11
        L11:
            e = move-exception;
            throw new AssertionError(e);
        }

        private void importPublicDependencies(FileDescriptor r10) {
            Iterator<FileDescriptor> r11 = r10.getPublicDependencies().iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            FileDescriptor r12 = r11.next();
            if (this.dependencies.add(r12) == false) goto L4;
            importPublicDependencies(r12);
            goto L4
        }

        static void validateSymbolName(GenericDescriptor r10) {
            String r11 = r10.getName();
            AnonymousClass1 r12 = null;
            if (r11.length() == 0) goto L28;
            int r13 = 0;
        L6:
            if (r13 >= r11.length()) goto L26;
            char r14 = r11.charAt(r13);
            if ('a' > r14) goto L12;
            if (r14 > 'z') goto L12;
        L25:
            r13 = r13 + 1;
        L12:
            if ('A' > r14) goto L16;
            if (r14 <= 'Z') goto L25;
        L16:
            if (r14 == '_') goto L25;
            if ('0' > r14) goto L24;
            if (r14 > '9') goto L24;
            if (r13 > 0) goto L25;
        L24:
            throw new DescriptorValidationException(r10, Typography.quote + r11 + "\" is not a valid identifier.", r12);
        L26:
            return;
        L28:
            throw new DescriptorValidationException(r10, "Missing name.", r12);
        }

        void addPackage(String r10, FileDescriptor r11) {
            int r12 = r10.lastIndexOf(46);
            if (r12 != (-1)) goto L5;
            String r13 = r10;
        L6:
            GenericDescriptor r14 = this.descriptorsByName.put(r10, new PackageDescriptor(r13, r10, r11));
            if (r14 == null) goto L13;
            this.descriptorsByName.put(r10, r14);
            if ((r14 instanceof PackageDescriptor) == false) goto L12;
            return;
        L12:
            throw new DescriptorValidationException(r11, Typography.quote + r13 + "\" is already defined (as something other than a package) in file \"" + r14.getFile().getName() + "\".", null);
        L13:
            return;
        L5:
            addPackage(r10.substring(0, r12), r11);
            r13 = r10.substring(r12 + 1);
            goto L6
        }

        void addSymbol(GenericDescriptor r10) {
            validateSymbolName(r10);
            String r11 = r10.getFullName();
            GenericDescriptor r12 = this.descriptorsByName.put(r11, r10);
            if (r12 == null) goto L14;
            this.descriptorsByName.put(r11, r12);
            AnonymousClass1 r13 = null;
            if (r10.getFile() != r12.getFile()) goto L13;
            int r14 = r11.lastIndexOf(46);
            if (r14 != (-1)) goto L11;
            throw new DescriptorValidationException(r10, Typography.quote + r11 + "\" is already defined.", r13);
        L11:
            throw new DescriptorValidationException(r10, Typography.quote + r11.substring(r14 + 1) + "\" is already defined in \"" + r11.substring(0, r14) + "\".", r13);
        L13:
            throw new DescriptorValidationException(r10, Typography.quote + r11 + "\" is already defined in file \"" + r12.getFile().getName() + "\".", r13);
        }

        GenericDescriptor findSymbol(String r10) {
            return findSymbol(r10, SearchFilter.ALL_SYMBOLS);
        }

        GenericDescriptor findSymbol(String r10, SearchFilter r11) {
            GenericDescriptor r12 = this.descriptorsByName.get(r10);
            if (r12 != null) goto L5;
        L15:
            Iterator<FileDescriptor> r13 = this.dependencies.iterator();
        L17:
            if (r13.hasNext() == false) goto L31;
            GenericDescriptor r14 = FileDescriptor.access$2200(r13.next()).descriptorsByName.get(r10);
            if (r14 == null) goto L17;
            if (r11 == SearchFilter.ALL_SYMBOLS) goto L30;
            if (r11 != SearchFilter.TYPES_ONLY) goto L27;
            if (isType(r14) == true) goto L30;
        L27:
            if (r11 != SearchFilter.AGGREGATES_ONLY) goto L17;
            if (isAggregate(r14) == false) goto L17;
        L30:
            return r14;
        L31:
            return null;
        L5:
            if (r11 != SearchFilter.ALL_SYMBOLS) goto L7;
        L14:
            return r12;
        L7:
            if (r11 != SearchFilter.TYPES_ONLY) goto L11;
            if (isType(r12) == true) goto L14;
        L11:
            if (r11 != SearchFilter.AGGREGATES_ONLY) goto L15;
            if (isAggregate(r12) == false) goto L15;
            goto L14
        }

        boolean isAggregate(GenericDescriptor r10) {
            if ((r10 instanceof Descriptor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r10 instanceof EnumDescriptor) == true) goto L12;
            if ((r10 instanceof PackageDescriptor) == true) goto L12;
            if ((r10 instanceof ServiceDescriptor) == true) goto L12;
            return false;
        }

        boolean isType(GenericDescriptor r10) {
            if ((r10 instanceof Descriptor) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r10 instanceof EnumDescriptor) == true) goto L8;
            return false;
        }

        GenericDescriptor lookupSymbol(String r10, GenericDescriptor r11, SearchFilter r12) {
            if (r10.startsWith(".") == false) goto L5;
            String r13 = r10.substring(1);
            GenericDescriptor r14 = findSymbol(r13, r12);
        L19:
            if (r14 == null) goto L21;
            return r14;
        L21:
            if (this.allowUnknownDependencies == false) goto L27;
            if (r12 != SearchFilter.TYPES_ONLY) goto L27;
            Descriptors.access$000().warning("The descriptor for message type \"" + r10 + "\" cannot be found and a placeholder is created for it");
            Descriptor r15 = new Descriptor(r13);
            this.dependencies.add(r15.getFile());
            return r15;
        L27:
            throw new DescriptorValidationException(r11, Typography.quote + r10 + "\" is not defined.", null);
        L5:
            int r16 = r10.indexOf(46);
            if (r16 != (-1)) goto L8;
            String r17 = r10;
        L9:
            StringBuilder r18 = new StringBuilder(r11.getFullName());
        L10:
            int r19 = r18.lastIndexOf(".");
            if (r19 == (-1)) goto L12;
            int r20 = r19 + 1;
            r18.setLength(r20);
            r18.append(r17);
            GenericDescriptor r21 = findSymbol(r18.toString(), SearchFilter.AGGREGATES_ONLY);
            if (r21 != null) goto L15;
            r18.setLength(r19);
            goto L10
        L15:
            if (r16 == (-1)) goto L17;
            r18.setLength(r20);
            r18.append(r10);
            r14 = findSymbol(r18.toString(), r12);
        L18:
            r13 = r18.toString();
            goto L19
        L17:
            r14 = r21;
            goto L18
        L12:
            r14 = findSymbol(r10, r12);
            r13 = r10;
            goto L19
        L8:
            r17 = r10.substring(0, r16);
            goto L9
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        private DescriptorValidationException(FileDescriptor r10, String r11) {
            super(r10.getName() + ": " + r11);
            this.name = r10.getName();
            this.proto = r10.toProto();
            this.description = r11;
        }

        /* synthetic */ DescriptorValidationException(FileDescriptor r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private DescriptorValidationException(GenericDescriptor r10, String r11) {
            super(r10.getFullName() + ": " + r11);
            this.name = r10.getFullName();
            this.proto = r10.toProto();
            this.description = r11;
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private DescriptorValidationException(GenericDescriptor r10, String r11, Throwable r12) {
            this(r10, r11);
            initCause(r12);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor r10, String r11, Throwable r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
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

            private UnknownEnumValueReference(int r10, EnumValueDescriptor r11) {
                super(r11);
                this.number = r10;
            }

            /* synthetic */ UnknownEnumValueReference(int r10, EnumValueDescriptor r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            static /* synthetic */ int access$3700(UnknownEnumValueReference r10) {
                return r10.number;
            }
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13) {
            AnonymousClass1 r14 = null;
            super(r14);
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
            int r15 = 0;
            int r16 = 0;
        L10:
            if (r16 >= r10.getValueCount()) goto L12;
            this.values[r16] = new EnumValueDescriptor(r10.getValue(r16), r11, this, r16, null);
            r16 = r16 + 1;
            goto L10
        L12:
            EnumValueDescriptor[] r17 = (EnumValueDescriptor[]) this.values.clone();
            this.valuesSortedByNumber = r17;
            Arrays.sort(r17, EnumValueDescriptor.BY_NUMBER);
            int r18 = 1;
        L14:
            if (r18 >= r10.getValueCount()) goto L19;
            EnumValueDescriptor[] r19 = this.valuesSortedByNumber;
            EnumValueDescriptor r20 = r19[r15];
            EnumValueDescriptor r21 = r19[r18];
            if (r20.getNumber() == r21.getNumber()) goto L18;
            r15 = r15 + 1;
            this.valuesSortedByNumber[r15] = r21;
        L18:
            r18 = r18 + 1;
            goto L14
        L19:
            int r110 = r15 + 1;
            this.distinctNumbers = r110;
            Arrays.fill(this.valuesSortedByNumber, r110, r10.getValueCount(), null);
            FileDescriptor.access$2200(r11).addSymbol(this);
            return;
        L22:
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", r14);
        L5:
            this.parent = r12;
            goto L6
        }

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        static /* synthetic */ void access$1200(EnumDescriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$1900(EnumDescriptor r10, DescriptorProtos.EnumDescriptorProto r11) {
            r10.setProto(r11);
        }

        static /* synthetic */ FileDescriptor access$4300(EnumDescriptor r10) {
            return r10.file;
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            EnumValueDescriptor[] r10 = this.values;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            EnumValueDescriptor.access$4100(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.EnumDescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
            int r11 = 0;
        L3:
            EnumValueDescriptor[] r12 = this.values;
            if (r11 >= r12.length) goto L6;
            EnumValueDescriptor.access$4200(r12[r11], r10.getValue(r11));
            r11 = r11 + 1;
            goto L3
        }

        public EnumValueDescriptor findValueByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r10);
            if ((r11 instanceof EnumValueDescriptor) == true) goto L5;
            return null;
        L5:
            return (EnumValueDescriptor) r11;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int r10) {
            return (EnumValueDescriptor) Descriptors.access$2400(this.valuesSortedByNumber, this.distinctNumbers, EnumValueDescriptor.NUMBER_GETTER, r10);
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public /* bridge */ /* synthetic */ Internal.EnumLite findValueByNumber(int r10) {
            return findValueByNumber(r10);
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(int r10) {
            EnumValueDescriptor r11 = findValueByNumber(r10);
            if (r11 == null) goto L5;
            return r11;
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
            WeakReference<EnumValueDescriptor> r12 = this.unknownValues.get(Integer.valueOf(r10));     // Catch: Throwable -> L20
            AnonymousClass1 r13 = null;
            if (r12 != null) goto L14;
            EnumValueDescriptor r14 = null;
        L15:
            if (r14 != null) goto L17;
            r14 = new EnumValueDescriptor(this, Integer.valueOf(r10), r13);     // Catch: Throwable -> L20
            this.unknownValues.put(Integer.valueOf(r10), new UnknownEnumValueReference(r10, r14, r13));     // Catch: Throwable -> L20
        L17:
            monitor-exit(this);     // Catch: Throwable -> L20
            return r14;
        L14:
            r14 = r12.get();     // Catch: Throwable -> L20
        L9:
            UnknownEnumValueReference r15 = (UnknownEnumValueReference) this.cleanupQueue.poll();     // Catch: Throwable -> L20
            if (r15 == null) goto L11;
            this.unknownValues.remove(Integer.valueOf(UnknownEnumValueReference.access$3700(r15)));     // Catch: Throwable -> L20
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
            DescriptorProtos.EnumOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
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

        public boolean isReservedName(String r10) {
            Internal.checkNotNull(r10);
            Iterator<String> r11 = this.proto.getReservedNameList().iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            if (r11.next().equals(r10) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r10) {
            Iterator<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> r11 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            DescriptorProtos.EnumDescriptorProto.EnumReservedRange r12 = r11.next();
            if (r12.getStart() > r10) goto L4;
            if (r10 > r12.getEnd()) goto L4;
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

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r10, FileDescriptor r11, EnumDescriptor r12, int r13) {
            super(null);
            this.parent = r12;
            this.index = r13;
            this.proto = r10;
            this.type = r12;
            this.fullName = r12.getFullName() + '.' + r10.getName();
            FileDescriptor.access$2200(r11).addSymbol(this);
        }

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r10, FileDescriptor r11, EnumDescriptor r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        private EnumValueDescriptor(EnumDescriptor r10, Integer r11) {
            super(null);
            DescriptorProtos.EnumValueDescriptorProto r12 = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + r10.getName() + "_" + r11).setNumber(r11.intValue()).build();
            this.parent = r10;
            this.index = -1;
            this.proto = r12;
            this.type = r10;
            this.fullName = r10.getFullName() + '.' + r12.getName();
        }

        /* synthetic */ EnumValueDescriptor(EnumDescriptor r10, Integer r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        static /* synthetic */ void access$4100(EnumValueDescriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$4200(EnumValueDescriptor r10, DescriptorProtos.EnumValueDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.EnumValueDescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
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
            DescriptorProtos.EnumValueOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
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

    public static final class FieldDescriptor extends GenericDescriptor implements Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {
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
                BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.FALSE);
                STRING = new JavaType("STRING", 5, "");
                BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
                ENUM = new JavaType("ENUM", 7, null);
                MESSAGE = new JavaType("MESSAGE", 8, null);
                $VALUES = $values();
            }

            private JavaType(String r10, int r11, Object r12) {
                super(r10, r11);
                this.defaultDefault = r12;
            }

            static /* synthetic */ Object access$3600(JavaType r10) {
                return r10.defaultDefault;
            }

            public static JavaType valueOf(String r10) {
                return (JavaType) java.lang.Enum.valueOf(JavaType.class, r10);
            }

            public static JavaType[] values() {
                return (JavaType[]) $VALUES.clone();
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

            private Sensitivity(String r10, int r11) {
                super(r10, r11);
            }

            public static Sensitivity valueOf(String r10) {
                return (Sensitivity) java.lang.Enum.valueOf(Sensitivity.class, r10);
            }

            public static Sensitivity[] values() {
                return (Sensitivity[]) $VALUES.clone();
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
                JavaType r10 = JavaType.LONG;
                INT64 = new Type("INT64", 2, r10);
                UINT64 = new Type("UINT64", 3, r10);
                JavaType r11 = JavaType.INT;
                INT32 = new Type("INT32", 4, r11);
                FIXED64 = new Type("FIXED64", 5, r10);
                FIXED32 = new Type("FIXED32", 6, r11);
                BOOL = new Type("BOOL", 7, JavaType.BOOLEAN);
                STRING = new Type("STRING", 8, JavaType.STRING);
                JavaType r12 = JavaType.MESSAGE;
                GROUP = new Type("GROUP", 9, r12);
                MESSAGE = new Type("MESSAGE", 10, r12);
                BYTES = new Type("BYTES", 11, JavaType.BYTE_STRING);
                UINT32 = new Type("UINT32", 12, r11);
                ENUM = new Type("ENUM", 13, JavaType.ENUM);
                SFIXED32 = new Type("SFIXED32", 14, r11);
                SFIXED64 = new Type("SFIXED64", 15, r10);
                SINT32 = new Type("SINT32", 16, r11);
                SINT64 = new Type("SINT64", 17, r10);
                $VALUES = $values();
                types = values();
            }

            private Type(String r10, int r11, JavaType r12) {
                super(r10, r11);
                this.javaType = r12;
            }

            static /* synthetic */ Type[] access$3400() {
                return types;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type r10) {
                return types[r10.getNumber() - 1];
            }

            public static Type valueOf(String r10) {
                return (Type) java.lang.Enum.valueOf(Type.class, r10);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
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

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, boolean r14) {
            AnonymousClass1 r15 = null;
            super(r15);
            this.sensitivity = Sensitivity.UNKNOWN;
            this.isReportable = false;
            this.parent = r12;
            this.index = r13;
            this.proto = r10;
            this.fullName = Descriptors.access$2600(r11, r12, r10.getName());
            this.file = r11;
            if (r10.hasType() == false) goto L5;
            this.type = Type.valueOf(r10.getType());
        L5:
            this.isProto3Optional = r10.getProto3Optional();
            if (getNumber() <= 0) goto L38;
            boolean r16 = r10.hasExtendee();
            if (r14 == false) goto L21;
            if (r16 == false) goto L20;
            this.containingType = null;
            if (r12 == null) goto L13;
            this.extensionScope = r12;
        L15:
            if (r10.hasOneofIndex() == true) goto L18;
            this.containingOneof = null;
        L33:
            FileDescriptor.access$2200(r11).addSymbol(this);
            return;
        L18:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", r15);
        L13:
            this.extensionScope = null;
            this.parent = r11;
            goto L15
        L20:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", r15);
        L21:
            if (r16 == true) goto L36;
            this.containingType = r12;
            if (r10.hasOneofIndex() == true) goto L25;
            this.containingOneof = null;
        L32:
            this.extensionScope = null;
            goto L33
        L25:
            if (r10.getOneofIndex() < 0) goto L30;
            if (r10.getOneofIndex() >= r12.toProto().getOneofDeclCount()) goto L30;
            OneofDescriptor r17 = r12.getOneofs().get(r10.getOneofIndex());
            this.containingOneof = r17;
            OneofDescriptor.access$2908(r17);
            this.parent = this.containingOneof;
        L30:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + r12.getName(), r15);
        L36:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", r15);
        L38:
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", r15);
        }

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, boolean r14, AnonymousClass1 r15) {
            this(r10, r11, r12, r13, r14);
        }

        static /* synthetic */ void access$1400(FieldDescriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$1700(FieldDescriptor r10) {
            r10.crossLink();
        }

        static /* synthetic */ void access$2100(FieldDescriptor r10, DescriptorProtos.FieldDescriptorProto r11) {
            r10.setProto(r11);
        }

        static /* synthetic */ NumberGetter access$2300() {
            return NUMBER_GETTER;
        }

        static /* synthetic */ boolean access$4900(FieldDescriptor r10) {
            return r10.isProto3Optional;
        }

        private List<Boolean> calculateSensitivityData() {
            Sensitivity r10 = this.sensitivity;
            Sensitivity r11 = Sensitivity.UNKNOWN;
            if (r10 != r11) goto L28;
            monitor-enter(this);
        L25:
            th = move-exception;
            throw th;
        L6:
            if (this.sensitivity != r11) goto L23;
            boolean r12 = this.proto.getOptions().getDebugRedact();     // Catch: Throwable -> L25
            Iterator<Map.Entry<FieldDescriptor, Object>> r13 = this.proto.getOptions().getAllFields().entrySet().iterator();     // Catch: Throwable -> L25
        L9:
            if (r13.hasNext() == false) goto L19;
            Map.Entry<FieldDescriptor, Object> r14 = r13.next();     // Catch: Throwable -> L25
            List<Boolean> r15 = isOptionSensitive(r14.getKey(), r14.getValue());     // Catch: Throwable -> L25
            if (r12 == false) goto L13;
        L16:
            r12 = true;
        L17:
            this.isReportable = r15.get(1).booleanValue();     // Catch: Throwable -> L25
            if (r12 == false) goto L9;
        L13:
            if (r15.get(0).booleanValue() == true) goto L16;
            r12 = false;
        L19:
            if (r12 == false) goto L21;
            Sensitivity r16 = Sensitivity.SENSITIVE;     // Catch: Throwable -> L25
        L22:
            this.sensitivity = r16;     // Catch: Throwable -> L25
            goto L23
        L21:
            r16 = Sensitivity.NOT_SENSITIVE;     // Catch: Throwable -> L25
        L23:
            monitor-exit(this);     // Catch: Throwable -> L25
        L28:
            Boolean[] r17 = new Boolean[2];
            if (this.sensitivity != Sensitivity.SENSITIVE) goto L31;
            boolean r18 = true;
        L32:
            r17[0] = Boolean.valueOf(r18);
            r17[1] = Boolean.valueOf(this.isReportable);
            return Arrays.asList(r17);
        L31:
            r18 = false;
            goto L32
        }

        private void crossLink() {
            AnonymousClass1 r10 = null;
            if (this.proto.hasExtendee() == false) goto L14;
            GenericDescriptor r11 = FileDescriptor.access$2200(this.file).lookupSymbol(this.proto.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if ((r11 instanceof Descriptor) == false) goto L12;
            this.containingType = (Descriptor) r11;
            if (getContainingType().isExtensionNumber(getNumber()) == true) goto L14;
            throw new DescriptorValidationException(this, Typography.quote + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", r10);
        L12:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getExtendee() + "\" is not a message type.", r10);
        L14:
            if (this.proto.hasTypeName() == false) goto L47;
            GenericDescriptor r12 = FileDescriptor.access$2200(this.file).lookupSymbol(this.proto.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (this.proto.hasType() == true) goto L27;
            if ((r12 instanceof Descriptor) == false) goto L22;
            Type r13 = Type.MESSAGE;
        L20:
            this.type = r13;
            goto L27
        L22:
            if ((r12 instanceof EnumDescriptor) == false) goto L25;
            r13 = Type.ENUM;
            goto L20
        L25:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getTypeName() + "\" is not a type.", r10);
        L27:
            if (this.type.getJavaType() != JavaType.MESSAGE) goto L38;
            if ((r12 instanceof Descriptor) == false) goto L36;
            this.messageType = (Descriptor) r12;
            if (this.proto.hasDefaultValue() == false) goto L51;
            throw new DescriptorValidationException(this, "Messages can't have default values.", r10);
        L51:
            if (this.proto.getOptions().getPacked() == false) goto L58;
            if (isPackable() == true) goto L58;
            throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", r10);
        L58:
            if (this.proto.hasDefaultValue() == false) goto L111;
            if (isRepeated() == true) goto L109;
        L105:
            e = move-exception;
            throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + Typography.quote, e, r10);
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
            EnumValueDescriptor r14 = this.enumType.findValueByName(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            this.defaultValue = r14;     // Catch: NumberFormatException -> L105
            if (r14 == null) goto L69;
            return;
        L69:
            throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + Typography.quote, r10);     // Catch: NumberFormatException -> L105
        L77:
            Object r15 = this.proto.getDefaultValue();     // Catch: NumberFormatException -> L105
        L78:
            this.defaultValue = r15;     // Catch: NumberFormatException -> L105
            return;
        L79:
            r15 = Boolean.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            goto L78
        L80:
            r15 = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L81:
            r15 = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L82:
            r15 = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L83:
            r15 = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L105
            goto L78
        L125:
            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());     // Catch: TextFormat.InvalidEscapeSequenceException -> L72 NumberFormatException -> L105
        L131:
            return;
        L72:
            e = move-exception;
            throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, r10);     // Catch: NumberFormatException -> L105
        L130:
            return;
        L76:
            throw new DescriptorValidationException(this, "Message type had default value.", r10);     // Catch: NumberFormatException -> L105
        L85:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L88;
            r15 = Float.valueOf(Float.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L88:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L91;
            r15 = Float.valueOf(Float.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L91:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L93;
            r15 = Float.valueOf(Float.NaN);     // Catch: NumberFormatException -> L105
            goto L78
        L93:
            r15 = Float.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            goto L78
        L95:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L98;
            r15 = Double.valueOf(Double.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L98:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L101;
            r15 = Double.valueOf(Double.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L105
            goto L78
        L101:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L103;
            r15 = Double.valueOf(Double.NaN);     // Catch: NumberFormatException -> L105
            goto L78
        L103:
            r15 = Double.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L105
            goto L78
        L109:
            throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", r10);
        L111:
            if (isRepeated() == false) goto L114;
            Object r16 = Collections.emptyList();
        L113:
            this.defaultValue = r16;
            return;
        L114:
            int r17 = this.type.getJavaType().ordinal();
            if (r17 != 7) goto L117;
            r16 = this.enumType.getValues().get(0);
            goto L113
        L117:
            if (r17 == 8) goto L119;
            r16 = JavaType.access$3600(this.type.getJavaType());
            goto L113
        L119:
            this.defaultValue = null;
            return;
        L36:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getTypeName() + "\" is not a message type.", r10);
        L38:
            if (this.type.getJavaType() != JavaType.ENUM) goto L45;
            if ((r12 instanceof EnumDescriptor) == false) goto L43;
            this.enumType = (EnumDescriptor) r12;
            goto L51
        L43:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getTypeName() + "\" is not an enum type.", r10);
        L45:
            throw new DescriptorValidationException(this, "Field with primitive type has type_name.", r10);
        L47:
            if (this.type.getJavaType() == JavaType.MESSAGE) goto L123;
            if (this.type.getJavaType() != JavaType.ENUM) goto L51;
        L123:
            throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", r10);
        }

        private static String fieldNameToJsonName(String r10) {
            int r11 = r10.length();
            StringBuilder r12 = new StringBuilder(r11);
            int r13 = 0;
            boolean r14 = false;
        L3:
            if (r13 >= r11) goto L17;
            char r15 = r10.charAt(r13);
            if (r15 != '_') goto L7;
            r14 = true;
        L15:
            r13 = r13 + 1;
            goto L3
        L7:
            if (r14 == true) goto L9;
            r12.append(r15);
            goto L15
        L9:
            if ('a' <= r15) goto L11;
        L13:
            r12.append(r15);
            r14 = false;
            goto L15
        L11:
            if (r15 > 'z') goto L13;
            r15 = (char) ((r15 - 'a') + 65);
            goto L13
        L17:
            return r12.toString();
        }

        private List<Boolean> isOptionSensitive(FieldDescriptor r10, Object r11) {
            if (r10.getType() != Type.ENUM) goto L18;
            if (r10.isRepeated() == false) goto L14;
            Iterator r12 = ((List) r11).iterator();
        L8:
            if (r12.hasNext() == false) goto L36;
            if (((EnumValueDescriptor) r12.next()).getOptions().getDebugRedact() == false) goto L8;
            return Arrays.asList(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
        L36:
            Boolean r13 = Boolean.FALSE;
            return Arrays.asList(new Boolean[]{r13, r13});
        L14:
            if (((EnumValueDescriptor) r11).getOptions().getDebugRedact() == false) goto L36;
            return Arrays.asList(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
        L18:
            if (r10.getJavaType() != JavaType.MESSAGE) goto L36;
            if (r10.isRepeated() == false) goto L30;
            Iterator r14 = ((List) r11).iterator();
        L23:
            if (r14.hasNext() == false) goto L36;
            Iterator<Map.Entry<FieldDescriptor, Object>> r15 = ((Message) r14.next()).getAllFields().entrySet().iterator();
        L26:
            if (r15.hasNext() == false) goto L23;
            Map.Entry<FieldDescriptor, Object> r16 = r15.next();
            List<Boolean> r17 = isOptionSensitive(r16.getKey(), r16.getValue());
            if (r17.get(0).booleanValue() == false) goto L26;
            return r17;
        L30:
            Iterator<Map.Entry<FieldDescriptor, Object>> r18 = ((Message) r11).getAllFields().entrySet().iterator();
        L32:
            if (r18.hasNext() == false) goto L36;
            Map.Entry<FieldDescriptor, Object> r19 = r18.next();
            List<Boolean> r20 = isOptionSensitive(r19.getKey(), r19.getValue());
            if (r20.get(0).booleanValue() == false) goto L32;
            return r20;
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.FieldDescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FieldDescriptor r10) {
            if (r10.containingType != this.containingType) goto L7;
            return getNumber() - r10.getNumber();
        L7:
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(FieldDescriptor r10) {
            return compareTo2(r10);
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
            String r10 = this.jsonName;
            if (r10 == null) goto L6;
            return r10;
        L6:
            if (this.proto.hasJsonName() == false) goto L10;
            String r11 = this.proto.getJsonName();
        L8:
            this.jsonName = r11;
            return r11;
        L10:
            r11 = fieldNameToJsonName(this.proto.getName());
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
            DescriptorProtos.FieldOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public OneofDescriptor getRealContainingOneof() {
            OneofDescriptor r10 = this.containingOneof;
            if (r10 != null) goto L5;
        L7:
            return null;
        L5:
            if (r10.isSynthetic() == true) goto L7;
            return this.containingOneof;
        }

        public Type getType() {
            if (this.type != Type.MESSAGE) goto L19;
            Descriptor r10 = this.messageType;
            if (r10 != null) goto L7;
        L8:
            Descriptor r11 = this.containingType;
            if (r11 == null) goto L13;
            if (r11.toProto().getOptions().getMapEntry() == true) goto L19;
        L13:
            if (this.features == null) goto L19;
            if (getFeatures().getMessageEncoding() != DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED) goto L19;
            return Type.GROUP;
        L7:
            if (r10.toProto().getOptions().getMapEntry() == false) goto L8;
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
            DescriptorProtos.FeatureSet.Builder r10 = DescriptorProtos.FeatureSet.newBuilder();
            if (getFile().getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L7;
            return r10.build();
        L7:
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) goto L10;
            r10.setFieldPresence(DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED);
        L10:
            if (this.proto.getType() != DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP) goto L13;
            r10.setMessageEncoding(DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED);
        L13:
            if (getFile().getEdition() != DescriptorProtos.Edition.EDITION_PROTO2) goto L18;
            if (this.proto.getOptions().getPacked() == false) goto L18;
            r10.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.PACKED);
        L18:
            if (getFile().getEdition() != DescriptorProtos.Edition.EDITION_PROTO3) goto L25;
            if (this.proto.getOptions().hasPacked() == false) goto L25;
            if (this.proto.getOptions().getPacked() == true) goto L25;
            r10.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.EXPANDED);
        L25:
            return r10.build();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11) {
            return ((Message.Builder) r10).mergeFrom((Message) r11);
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
            return calculateSensitivityData().get(1).booleanValue();
        }

        public boolean isRequired() {
            if (getFeatures().getFieldPresence() != DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isSensitive() {
            return calculateSensitivityData().get(0).booleanValue();
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
            if (((JavaFeaturesProto.JavaFeatures) getFeatures().getExtension(JavaFeaturesProto.java_)).getLegacyClosedEnum() == false) goto L16;
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
            if (((JavaFeaturesProto.JavaFeatures) getFeatures().getExtension(JavaFeaturesProto.java_)).getUtf8Validation().equals(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY) == false) goto L13;
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
            Descriptor r10 = this.containingType;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.toProto().getOptions().getMessageSetWireFormat() == true) goto L7;
            return;
        L7:
            if (isExtension() == true) goto L9;
            return;
        L9:
            if (isRequired() == false) goto L11;
        L15:
            String r11 = "Extensions of MessageSets may not be required or repeated messages.";
            throw new DescriptorValidationException(this, r11, null);
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
            ExtensionRegistry assignDescriptors(FileDescriptor r10);
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11, DescriptorPool r12, boolean r13) {
            AnonymousClass1 r14 = null;
            super(r14);
            this.pool = r12;
            this.proto = r10;
            this.dependencies = (FileDescriptor[]) r11.clone();
            int r15 = 0;
            this.featuresResolved = false;
            HashMap r16 = new HashMap();
            int r17 = r11.length;
            int r18 = 0;
        L3:
            if (r18 >= r17) goto L5;
            FileDescriptor r19 = r11[r18];
            r16.put(r19.getName(), r19);
            r18 = r18 + 1;
            goto L3
        L5:
            ArrayList r110 = new ArrayList();
            int r20 = 0;
        L7:
            if (r20 >= r10.getPublicDependencyCount()) goto L22;
            int r21 = r10.getPublicDependency(r20);
            if (r21 < 0) goto L21;
            if (r21 >= r10.getDependencyCount()) goto L21;
            String r22 = r10.getDependency(r21);
            FileDescriptor r23 = (FileDescriptor) r16.get(r22);
            if (r23 != null) goto L18;
            if (r13 == true) goto L19;
            throw new DescriptorValidationException(this, "Invalid public dependency: " + r22, r14);
        L19:
            r20 = r20 + 1;
            goto L7
        L18:
            r110.add(r23);
        L21:
            throw new DescriptorValidationException(this, "Invalid public dependency index.", r14);
        L22:
            FileDescriptor[] r111 = new FileDescriptor[r110.size()];
            this.publicDependencies = r111;
            r110.toArray(r111);
            r12.addPackage(getPackage(), this);
            if (r10.getMessageTypeCount() <= 0) goto L25;
            Descriptor[] r112 = new Descriptor[r10.getMessageTypeCount()];
        L26:
            this.messageTypes = r112;
            int r113 = 0;
        L28:
            if (r113 >= r10.getMessageTypeCount()) goto L31;
            this.messageTypes[r113] = new Descriptor(r10.getMessageType(r113), this, null, r113, null);
            r113 = r113 + 1;
            goto L28
        L31:
            if (r10.getEnumTypeCount() <= 0) goto L33;
            EnumDescriptor[] r114 = new EnumDescriptor[r10.getEnumTypeCount()];
        L34:
            this.enumTypes = r114;
            int r115 = 0;
        L36:
            if (r115 >= r10.getEnumTypeCount()) goto L39;
            this.enumTypes[r115] = new EnumDescriptor(r10.getEnumType(r115), this, null, r115, null);
            r115 = r115 + 1;
            goto L36
        L39:
            if (r10.getServiceCount() <= 0) goto L41;
            ServiceDescriptor[] r116 = new ServiceDescriptor[r10.getServiceCount()];
        L42:
            this.services = r116;
            int r117 = 0;
        L44:
            if (r117 >= r10.getServiceCount()) goto L47;
            this.services[r117] = new ServiceDescriptor(r10.getService(r117), this, r117, r14);
            r117 = r117 + 1;
            goto L44
        L47:
            if (r10.getExtensionCount() <= 0) goto L49;
            FieldDescriptor[] r118 = new FieldDescriptor[r10.getExtensionCount()];
        L50:
            this.extensions = r118;
        L52:
            if (r15 >= r10.getExtensionCount()) goto L54;
            this.extensions[r15] = new FieldDescriptor(r10.getExtension(r15), this, null, r15, true, null);
            r15 = r15 + 1;
            goto L52
        L54:
            return;
        L49:
            r118 = Descriptors.access$900();
            goto L50
        L41:
            r116 = Descriptors.access$700();
            goto L42
        L33:
            r114 = Descriptors.access$500();
            goto L34
        L25:
            r112 = Descriptors.access$300();
            goto L26
        }

        FileDescriptor(String r10, Descriptor r11) {
            super(null);
            this.parent = null;
            DescriptorPool r12 = new DescriptorPool(new FileDescriptor[0], true);
            this.pool = r12;
            this.proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(r11.getFullName() + ".placeholder.proto").setPackage(r10).addMessageType(r11.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.featuresResolved = false;
            this.messageTypes = new Descriptor[]{r11};
            this.enumTypes = Descriptors.access$500();
            this.services = Descriptors.access$700();
            this.extensions = Descriptors.access$900();
            r12.addPackage(r10, this);
            r12.addSymbol(r11);
        }

        static /* synthetic */ DescriptorPool access$2200(FileDescriptor r10) {
            return r10.pool;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11) {
            return buildFrom(r10, r11, false);
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11, boolean r12) {
            return buildFrom(r10, r11, r12, false);
        }

        private static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11, boolean r12, boolean r13) {
            FileDescriptor r14 = new FileDescriptor(r10, r11, new DescriptorPool(r11, r12), r12);
            r14.crossLink();
            if (r13 == true) goto L5;
            r14.resolveAllFeaturesInternal();
        L5:
            return r14;
        }

        private void crossLink() {
            Descriptor[] r10 = this.messageTypes;
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            Descriptor.access$1500(r10[r13]);
            r13 = r13 + 1;
            goto L3
        L5:
            ServiceDescriptor[] r14 = this.services;
            int r15 = r14.length;
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L8;
            ServiceDescriptor.access$1600(r14[r16]);
            r16 = r16 + 1;
            goto L6
        L8:
            FieldDescriptor[] r17 = this.extensions;
            int r18 = r17.length;
        L9:
            if (r12 >= r18) goto L11;
            FieldDescriptor.access$1700(r17[r12]);
            r12 = r12 + 1;
            goto L9
        }

        private static FileDescriptor[] findDescriptors(Class<?> r10, String[] r11, String[] r12) {
            ArrayList r13 = new ArrayList();
            int r14 = 0;
        L4:
            if (r14 >= r11.length) goto L10;
            r13.add((FileDescriptor) r10.getClassLoader().loadClass(r11[r14]).getField("descriptor").get(null));     // Catch: Exception -> L7
        L8:
            r14 = r14 + 1;
        L7:
            Descriptors.access$000().warning("Descriptors for \"" + r12[r14] + "\" can not be found.");
            goto L8
        L10:
            return (FileDescriptor[]) r13.toArray(new FileDescriptor[0]);
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] r10, Class<?> r11, String[] r12, String[] r13) {
            return internalBuildGeneratedFileFrom(r10, findDescriptors(r11, r12, r13));
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] r10, FileDescriptor[] r11) {
            DescriptorProtos.FileDescriptorProto r12 = DescriptorProtos.FileDescriptorProto.parseFrom(latin1Cat(r10));     // Catch: InvalidProtocolBufferException -> L10
            return buildFrom(r12, r11, true, true);
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r12.getName() + "\".", e);
        L10:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        public static void internalUpdateFileDescriptor(FileDescriptor r10, ExtensionRegistry r11) {
            r10.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r10.proto.toByteString(), r11));     // Catch: InvalidProtocolBufferException -> L5
            return;
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        private static byte[] latin1Cat(String[] r10) {
            int r11 = 0;
            if (r10.length != 1) goto L7;
            String r12 = r10[0];
        L6:
            return r12.getBytes(Internal.ISO_8859_1);
        L7:
            StringBuilder r13 = new StringBuilder();
            int r14 = r10.length;
        L8:
            if (r11 >= r14) goto L10;
            r13.append(r10[r11]);
            r11 = r11 + 1;
            goto L8
        L10:
            r12 = r13.toString();
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
            Descriptor[] r10 = this.messageTypes;     // Catch: Throwable -> L25
            int r11 = r10.length;     // Catch: Throwable -> L25
            int r12 = 0;
            int r13 = 0;
        L11:
            if (r13 >= r11) goto L13;
            Descriptor.access$1100(r10[r13]);     // Catch: Throwable -> L25
            r13 = r13 + 1;     // Catch: Throwable -> L25
            goto L11
        L13:
            EnumDescriptor[] r14 = this.enumTypes;     // Catch: Throwable -> L25
            int r15 = r14.length;     // Catch: Throwable -> L25
            int r16 = 0;
        L14:
            if (r16 >= r15) goto L16;
            EnumDescriptor.access$1200(r14[r16]);     // Catch: Throwable -> L25
            r16 = r16 + 1;     // Catch: Throwable -> L25
            goto L14
        L16:
            ServiceDescriptor[] r17 = this.services;     // Catch: Throwable -> L25
            int r18 = r17.length;     // Catch: Throwable -> L25
            int r19 = 0;
        L17:
            if (r19 >= r18) goto L19;
            ServiceDescriptor.access$1300(r17[r19]);     // Catch: Throwable -> L25
            r19 = r19 + 1;     // Catch: Throwable -> L25
            goto L17
        L19:
            FieldDescriptor[] r20 = this.extensions;     // Catch: Throwable -> L25
            int r21 = r20.length;     // Catch: Throwable -> L25
        L20:
            if (r12 >= r21) goto L22;
            FieldDescriptor.access$1400(r20[r12]);     // Catch: Throwable -> L25
            r12 = r12 + 1;     // Catch: Throwable -> L25
            goto L20
        L22:
            this.featuresResolved = true;     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
        }

        private synchronized void setProto(DescriptorProtos.FileDescriptorProto r10) {
            monitor-enter(this);
            this.proto = r10;     // Catch: Throwable -> L25
            this.options = null;     // Catch: Throwable -> L25
            resolveFeatures(r10.getOptions().getFeatures());     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            int r11 = 0;
            int r12 = 0;
        L5:
            Descriptor[] r13 = this.messageTypes;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r12 >= r13.length) goto L8;
            Descriptor.access$1800(r13[r12], r10.getMessageType(r12));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r12 = r12 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            goto L5
        L8:
            int r14 = 0;
        L9:
            EnumDescriptor[] r15 = this.enumTypes;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r14 >= r15.length) goto L12;
            EnumDescriptor.access$1900(r15[r14], r10.getEnumType(r14));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r14 = r14 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            goto L9
        L12:
            int r16 = 0;
        L13:
            ServiceDescriptor[] r17 = this.services;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r16 >= r17.length) goto L16;
            ServiceDescriptor.access$2000(r17[r16], r10.getService(r16));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r16 = r16 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
        L16:
            FieldDescriptor[] r18 = this.extensions;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r11 >= r18.length) goto L20;
            FieldDescriptor.access$2100(r18[r11], r10.getExtension(r11));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r11 = r11 + 1;
            goto L16
        L20:
            monitor-exit(this);
            return;
        L22:
            e = move-exception;
            throw new IllegalArgumentException("Invalid features for \"" + r10.getName() + "\".", e);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        public void copyHeadingTo(DescriptorProtos.FileDescriptorProto.Builder r10) {
            r10.setName(getName()).setSyntax(this.proto.getSyntax());
            if (getPackage().isEmpty() == true) goto L6;
            r10.setPackage(getPackage());
        L6:
            if (this.proto.getSyntax().equals("editions") == false) goto L9;
            r10.setEdition(this.proto.getEdition());
        L9:
            if (this.proto.hasOptions() == true) goto L11;
            return;
        L11:
            if (this.proto.getOptions().equals(DescriptorProtos.FileOptions.getDefaultInstance()) == true) goto L15;
            r10.setOptions(this.proto.getOptions());
            return;
        }

        public EnumDescriptor findEnumTypeByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r11 = getPackage();
            if (r11.isEmpty() == true) goto L8;
            r10 = r11 + '.' + r10;
        L8:
            GenericDescriptor r12 = this.pool.findSymbol(r10);
            if ((r12 instanceof EnumDescriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r12.getFile() != this) goto L14;
            return (EnumDescriptor) r12;
        }

        public FieldDescriptor findExtensionByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r11 = getPackage();
            if (r11.isEmpty() == true) goto L8;
            r10 = r11 + '.' + r10;
        L8:
            GenericDescriptor r12 = this.pool.findSymbol(r10);
            if ((r12 instanceof FieldDescriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r12.getFile() != this) goto L14;
            return (FieldDescriptor) r12;
        }

        public Descriptor findMessageTypeByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r11 = getPackage();
            if (r11.isEmpty() == true) goto L8;
            r10 = r11 + '.' + r10;
        L8:
            GenericDescriptor r12 = this.pool.findSymbol(r10);
            if ((r12 instanceof Descriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r12.getFile() != this) goto L14;
            return (Descriptor) r12;
        }

        public ServiceDescriptor findServiceByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r11 = getPackage();
            if (r11.isEmpty() == true) goto L8;
            r10 = r11 + '.' + r10;
        L8:
            GenericDescriptor r12 = this.pool.findSymbol(r10);
            if ((r12 instanceof ServiceDescriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r12.getFile() != this) goto L14;
            return (ServiceDescriptor) r12;
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        DescriptorProtos.Edition getEdition() {
            String r10 = this.proto.getSyntax();
            r10.hashCode();
            if (r10.equals("proto3") == true) goto L11;
            if (r10.equals("editions") == true) goto L9;
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
            DescriptorProtos.FileOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
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
            DescriptorProtos.FeatureSet.Builder r10 = DescriptorProtos.FeatureSet.newBuilder();
            if (getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L7;
            return r10.build();
        L7:
            if (getEdition() != DescriptorProtos.Edition.EDITION_PROTO2) goto L12;
            if (this.proto.getOptions().getJavaStringCheckUtf8() == false) goto L12;
            r10.setExtension(JavaFeaturesProto.java_, JavaFeaturesProto.JavaFeatures.newBuilder().setUtf8Validation(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY).build());
        L12:
            return r10.build();
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

        /* synthetic */ GenericDescriptor(AnonymousClass1 r10) {
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

        void resolveFeatures(DescriptorProtos.FeatureSet r10) {
            if (this.parent != null) goto L5;
        L11:
            Iterator<FieldDescriptor> r11 = r10.getExtensionFields().keySet().iterator();
            boolean r12 = true;
            boolean r13 = false;
        L13:
            if (r11.hasNext() == false) goto L20;
            FieldDescriptor r14 = r11.next();
            int r15 = r14.getNumber();
            GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeaturesProto.JavaFeatures> r16 = JavaFeaturesProto.java_;
            if (r15 != r16.getNumber()) goto L13;
            if (r14 == r16.getDescriptor()) goto L13;
            r13 = true;
            goto L13
        L20:
            if (r10.getUnknownFields().isEmpty() == false) goto L22;
        L24:
            r12 = false;
        L25:
            if (r13 == true) goto L27;
            if (r12 == true) goto L27;
        L29:
            GenericDescriptor r17 = this.parent;
            if (r17 != null) goto L32;
            DescriptorProtos.FeatureSet r18 = Descriptors.getEditionDefaults(getFile().getEdition());
        L33:
            DescriptorProtos.FeatureSet.Builder r19 = r18.toBuilder();
            r19.mergeFrom(inferLegacyProtoFeatures());
            r19.mergeFrom(r10);
            DescriptorProtos.FeatureSet r20 = Descriptors.access$4800(r19.build());
        L9:
            this.features = r20;
            validateFeatures();
            return;
        L32:
            r18 = r17.features;
        L27:
            ExtensionRegistry r21 = ExtensionRegistry.newInstance();
            r21.add(JavaFeaturesProto.java_);
            r10 = DescriptorProtos.FeatureSet.parseFrom(r10.toByteString(), r21);     // Catch: InvalidProtocolBufferException -> L34
        L34:
            e = move-exception;
            throw new DescriptorValidationException(this, "Failed to parse features with Java feature extension registry.", e, null);
        L22:
            if (r10.getUnknownFields().hasField(JavaFeaturesProto.java_.getNumber()) == false) goto L24;
        L5:
            if (r10.equals(DescriptorProtos.FeatureSet.getDefaultInstance()) == false) goto L11;
            if (hasInferredLegacyProtoFeatures() == true) goto L11;
            r20 = this.parent.features;
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

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto r10, FileDescriptor r11, ServiceDescriptor r12, int r13) {
            super(null);
            this.parent = r12;
            this.index = r13;
            this.proto = r10;
            this.file = r11;
            this.service = r12;
            this.fullName = r12.getFullName() + '.' + r10.getName();
            FileDescriptor.access$2200(r11).addSymbol(this);
        }

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto r10, FileDescriptor r11, ServiceDescriptor r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        static /* synthetic */ void access$4500(MethodDescriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$4600(MethodDescriptor r10) {
            r10.crossLink();
        }

        static /* synthetic */ void access$4700(MethodDescriptor r10, DescriptorProtos.MethodDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void crossLink() {
            DescriptorPool r10 = FileDescriptor.access$2200(getFile());
            String r11 = this.proto.getInputType();
            DescriptorPool.SearchFilter r12 = DescriptorPool.SearchFilter.TYPES_ONLY;
            GenericDescriptor r13 = r10.lookupSymbol(r11, this, r12);
            AnonymousClass1 r14 = null;
            if ((r13 instanceof Descriptor) == false) goto L11;
            this.inputType = (Descriptor) r13;
            GenericDescriptor r15 = FileDescriptor.access$2200(getFile()).lookupSymbol(this.proto.getOutputType(), this, r12);
            if ((r15 instanceof Descriptor) == false) goto L9;
            this.outputType = (Descriptor) r15;
            return;
        L9:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getOutputType() + "\" is not a message type.", r14);
        L11:
            throw new DescriptorValidationException(this, Typography.quote + this.proto.getInputType() + "\" is not a message type.", r14);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.MethodDescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
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
            DescriptorProtos.MethodOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
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
        int getNumber(T r10);
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

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13) {
            super(null);
            this.parent = r12;
            this.proto = r10;
            this.fullName = Descriptors.access$2600(r11, r12, r10.getName());
            this.file = r11;
            this.index = r13;
            this.containingType = r12;
            this.fieldCount = 0;
        }

        /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        static /* synthetic */ FieldDescriptor[] access$2800(OneofDescriptor r10) {
            return r10.fields;
        }

        static /* synthetic */ FieldDescriptor[] access$2802(OneofDescriptor r10, FieldDescriptor[] r11) {
            r10.fields = r11;
            return r11;
        }

        static /* synthetic */ int access$2902(OneofDescriptor r10, int r11) {
            r10.fieldCount = r11;
            return r11;
        }

        static /* synthetic */ int access$2908(OneofDescriptor r10) {
            int r11 = r10.fieldCount;
            r10.fieldCount = r11 + 1;
            return r11;
        }

        static /* synthetic */ void access$3200(OneofDescriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$3300(OneofDescriptor r10, DescriptorProtos.OneofDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.OneofDescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public FieldDescriptor getField(int r10) {
            return this.fields[r10];
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
            DescriptorProtos.OneofOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        boolean isSynthetic() {
            FieldDescriptor[] r10 = this.fields;
            if (r10.length == 1) goto L5;
            return false;
        L5:
            if (FieldDescriptor.access$4900(r10[0]) == true) goto L7;
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

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r10, FileDescriptor r11, int r12) {
            super(null);
            this.parent = r11;
            this.index = r12;
            this.proto = r10;
            this.fullName = Descriptors.access$2600(r11, null, r10.getName());
            this.file = r11;
            this.methods = new MethodDescriptor[r10.getMethodCount()];
            int r13 = 0;
        L4:
            if (r13 >= r10.getMethodCount()) goto L6;
            int r14 = r13;
            this.methods[r13] = new MethodDescriptor(r10.getMethod(r13), r11, this, r14, null);
            r13 = r13 + 1;
            goto L4
        L6:
            FileDescriptor.access$2200(r11).addSymbol(this);
        }

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r10, FileDescriptor r11, int r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        static /* synthetic */ void access$1300(ServiceDescriptor r10) {
            r10.resolveAllFeatures();
        }

        static /* synthetic */ void access$1600(ServiceDescriptor r10) {
            r10.crossLink();
        }

        static /* synthetic */ void access$2000(ServiceDescriptor r10, DescriptorProtos.ServiceDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void crossLink() {
            MethodDescriptor[] r10 = this.methods;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            MethodDescriptor.access$4600(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            MethodDescriptor[] r10 = this.methods;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            MethodDescriptor.access$4500(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.ServiceDescriptorProto r10) {
            this.proto = r10;
            this.options = null;
            resolveFeatures(r10.getOptions().getFeatures());
            int r11 = 0;
        L3:
            MethodDescriptor[] r12 = this.methods;
            if (r11 >= r12.length) goto L6;
            MethodDescriptor.access$4700(r12[r11], r10.getMethod(r11));
            r11 = r11 + 1;
            goto L3
        }

        public MethodDescriptor findMethodByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r10);
            if ((r11 instanceof MethodDescriptor) == true) goto L5;
            return null;
        L5:
            return (MethodDescriptor) r11;
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
            DescriptorProtos.ServiceOptions r10 = this.proto.getOptions();
            if (r10.hasFeatures() == false) goto L7;
            r10 = r10.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r10;     // Catch: Throwable -> L13
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

    static /* synthetic */ Object access$2400(Object[] r10, int r11, NumberGetter r12, int r13) {
        return binarySearch(r10, r11, r12, r13);
    }

    static /* synthetic */ OneofDescriptor[] access$2500() {
        return EMPTY_ONEOF_DESCRIPTORS;
    }

    static /* synthetic */ String access$2600(FileDescriptor r10, Descriptor r11, String r12) {
        return computeFullName(r10, r11, r12);
    }

    static /* synthetic */ Descriptor[] access$300() {
        return EMPTY_DESCRIPTORS;
    }

    static /* synthetic */ int[] access$3100() {
        return EMPTY_INT_ARRAY;
    }

    static /* synthetic */ DescriptorProtos.FeatureSet access$4800(DescriptorProtos.FeatureSet r10) {
        return internFeatures(r10);
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

    private static <T> T binarySearch(T[] r10, int r11, NumberGetter<T> r12, int r13) {
        int r14 = r11 - 1;
        int r15 = 0;
    L3:
        if (r15 > r14) goto L10;
        int r16 = (r15 + r14) / 2;
        T r17 = r10[r16];
        int r18 = r12.getNumber(r17);
        if (r13 < r18) goto L6;
        if (r13 <= r18) goto L9;
        r15 = r16 + 1;
        goto L3
    L9:
        return r17;
    L6:
        r14 = r16 - 1;
        goto L3
    L10:
        return null;
    }

    private static String computeFullName(FileDescriptor r10, Descriptor r11, String r12) {
        if (r11 != null) goto L5;
        String r13 = r10.getPackage();
        if (r13.isEmpty() == false) goto L9;
        return r12;
    L9:
        return r13 + '.' + r12;
    L5:
        return r11.getFullName() + '.' + r12;
    }

    static DescriptorProtos.FeatureSet getEditionDefaults(DescriptorProtos.Edition r10) {
        DescriptorProtos.FeatureSetDefaults r11 = getJavaEditionDefaults();
        if (r10.getNumber() < r11.getMinimumEdition().getNumber()) goto L21;
        if (r10.getNumber() > r11.getMaximumEdition().getNumber()) goto L19;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault r12 = null;
        Iterator<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault> r13 = r11.getDefaultsList().iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault r14 = r13.next();
        if (r14.getEdition().getNumber() > r10.getNumber()) goto L13;
        r12 = r14;
    L13:
        if (r12 == null) goto L17;
        return r12.getFixedFeatures().toBuilder().mergeFrom(r12.getOverridableFeatures()).build();
    L17:
        throw new IllegalArgumentException("Edition " + r10 + " does not have a valid default FeatureSet!");
    L19:
        throw new IllegalArgumentException("Edition " + r10 + " is greater than the maximum supported edition " + r11.getMaximumEdition() + "!");
    L21:
        throw new IllegalArgumentException("Edition " + r10 + " is lower than the minimum supported edition " + r11.getMinimumEdition() + "!");
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
        ExtensionRegistry r10 = ExtensionRegistry.newInstance();     // Catch: Exception -> L10 Throwable -> L15
        r10.add(JavaFeaturesProto.java_);     // Catch: Exception -> L10 Throwable -> L15
        setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults.parseFrom(JavaEditionDefaults.PROTOBUF_INTERNAL_JAVA_EDITION_DEFAULTS.getBytes(Internal.ISO_8859_1), r10));     // Catch: Exception -> L10 Throwable -> L15
    L10:
        e = move-exception;
        throw new AssertionError(e);     // Catch: Throwable -> L15
    L19:
        return javaEditionDefaults;
    }

    private static DescriptorProtos.FeatureSet internFeatures(DescriptorProtos.FeatureSet r10) {
        DescriptorProtos.FeatureSet r11 = FEATURE_CACHE.putIfAbsent(Integer.valueOf(r10.hashCode()), r10);
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11;
    }

    static void setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults r10) {
        javaEditionDefaults = r10;
    }
}
