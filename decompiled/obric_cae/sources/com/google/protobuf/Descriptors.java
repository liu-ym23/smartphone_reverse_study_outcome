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
import java.util.function.ToIntFunction;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public final class Descriptors {
    private static final Descriptor[] EMPTY_DESCRIPTORS = null;
    private static final EnumDescriptor[] EMPTY_ENUM_DESCRIPTORS = null;
    private static final FieldDescriptor[] EMPTY_FIELD_DESCRIPTORS = null;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final OneofDescriptor[] EMPTY_ONEOF_DESCRIPTORS = null;
    private static final ServiceDescriptor[] EMPTY_SERVICE_DESCRIPTORS = null;
    private static final ConcurrentHashMap<DescriptorProtos.FeatureSet, DescriptorProtos.FeatureSet> FEATURE_CACHE = null;
    private static volatile DescriptorProtos.FeatureSetDefaults javaEditionDefaults;
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.Descriptors$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Descriptor extends GenericDescriptor {
        private final EnumDescriptor[] enumTypes;
        private final int[] extensionRangeLowerBounds;
        private final int[] extensionRangeUpperBounds;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FieldDescriptor[] fieldsSortedByNumber;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private final OneofDescriptor[] oneofs;
        private volatile DescriptorProtos.MessageOptions options;
        private final GenericDescriptor parent;
        private final boolean placeholder;
        private DescriptorProtos.DescriptorProto proto;
        private final int realOneofCount;

        private Descriptor(DescriptorProtos.DescriptorProto r11, FileDescriptor r12, Descriptor r13, int r14) {
            AnonymousClass1 r8 = null;
            super(r8);
            if (r13 != null) goto L5;
            this.parent = r12;
        L6:
            this.index = r14;
            this.proto = r11;
            this.fullName = Descriptors.access$2600(r12, r13, r11.getName());
            if (r11.getOneofDeclCount() <= 0) goto L9;
            OneofDescriptor[] r15 = new OneofDescriptor[r11.getOneofDeclCount()];
        L10:
            this.oneofs = r15;
            int r16 = 0;
            int r17 = 0;
        L12:
            if (r17 >= r11.getOneofDeclCount()) goto L15;
            this.oneofs[r17] = new OneofDescriptor(r11.getOneofDecl(r17), this, r17, r8);
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
            OneofDescriptor r10 = this.oneofs[r117];
            OneofDescriptor.access$2802(r10, new FieldDescriptor[r10.getFieldCount()]);
            OneofDescriptor.access$2902(this.oneofs[r117], 0);
            r117 = r117 + 1;
            goto L52
        L54:
            int r118 = 0;
        L56:
            if (r118 >= r11.getFieldCount()) goto L61;
            OneofDescriptor r20 = this.fields[r118].getContainingOneof();
            if (r20 == null) goto L60;
            OneofDescriptor.access$2800(r20)[OneofDescriptor.access$2908(r20)] = this.fields[r118];
        L60:
            r118 = r118 + 1;
            goto L56
        L61:
            OneofDescriptor[] r119 = this.oneofs;
            int r21 = r119.length;
            int r22 = 0;
            int r23 = 0;
        L62:
            if (r22 >= r21) goto L70;
            if (r119[r22].isSynthetic() == false) goto L66;
            r23 = r23 + 1;
        L67:
            r22 = r22 + 1;
            goto L62
        L66:
            if (r23 <= 0) goto L67;
            throw new DescriptorValidationException(this, "Synthetic oneofs must come last.", r8);
        L70:
            this.realOneofCount = this.oneofs.length - r23;
            this.placeholder = false;
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

        public static /* synthetic */ void access$1100(Descriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$1500(Descriptor r8) {
            r8.crossLink();
        }

        public static /* synthetic */ void access$1800(Descriptor r8, DescriptorProtos.DescriptorProto r10) {
            r8.setProto(r10);
        }

        private void crossLink() {
            Descriptor[] r8 = this.nestedTypes;
            int r10 = r8.length;
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            r8[r12].crossLink();
            r12 = r12 + 1;
            goto L3
        L5:
            FieldDescriptor[] r13 = this.fields;
            int r14 = r13.length;
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L8;
            FieldDescriptor.access$1700(r13[r15]);
            r15 = r15 + 1;
            goto L6
        L8:
            Arrays.sort(this.fieldsSortedByNumber);
            validateNoDuplicateFieldNumbers();
            FieldDescriptor[] r16 = this.extensions;
            int r17 = r16.length;
        L9:
            if (r11 >= r17) goto L11;
            FieldDescriptor.access$1700(r16[r11]);
            r11 = r11 + 1;
            goto L9
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            Descriptor[] r8 = this.nestedTypes;
            int r10 = r8.length;
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            r8[r12].resolveAllFeatures();
            r12 = r12 + 1;
            goto L3
        L5:
            EnumDescriptor[] r13 = this.enumTypes;
            int r14 = r13.length;
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L8;
            EnumDescriptor.access$1200(r13[r15]);
            r15 = r15 + 1;
            goto L6
        L8:
            OneofDescriptor[] r16 = this.oneofs;
            int r17 = r16.length;
            int r18 = 0;
        L9:
            if (r18 >= r17) goto L11;
            OneofDescriptor.access$3200(r16[r18]);
            r18 = r18 + 1;
            goto L9
        L11:
            FieldDescriptor[] r19 = this.fields;
            int r20 = r19.length;
            int r21 = 0;
        L12:
            if (r21 >= r20) goto L14;
            FieldDescriptor.access$1400(r19[r21]);
            r21 = r21 + 1;
            goto L12
        L14:
            FieldDescriptor[] r22 = this.extensions;
            int r23 = r22.length;
        L15:
            if (r11 >= r23) goto L17;
            FieldDescriptor.access$1400(r22[r11]);
            r11 = r11 + 1;
            goto L15
        }

        private void setProto(DescriptorProtos.DescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
            int r10 = 0;
            int r11 = 0;
        L3:
            Descriptor[] r12 = this.nestedTypes;
            if (r11 >= r12.length) goto L6;
            r12[r11].setProto(r8.getNestedType(r11));
            r11 = r11 + 1;
            goto L3
        L6:
            int r13 = 0;
        L7:
            OneofDescriptor[] r14 = this.oneofs;
            if (r13 >= r14.length) goto L10;
            OneofDescriptor.access$3300(r14[r13], r8.getOneofDecl(r13));
            r13 = r13 + 1;
            goto L7
        L10:
            int r15 = 0;
        L11:
            EnumDescriptor[] r16 = this.enumTypes;
            if (r15 >= r16.length) goto L14;
            EnumDescriptor.access$1900(r16[r15], r8.getEnumType(r15));
            r15 = r15 + 1;
            goto L11
        L14:
            int r17 = 0;
        L15:
            FieldDescriptor[] r18 = this.fields;
            if (r17 >= r18.length) goto L18;
            FieldDescriptor.access$2100(r18[r17], r8.getField(r17));
            r17 = r17 + 1;
        L18:
            FieldDescriptor[] r19 = this.extensions;
            if (r10 >= r19.length) goto L21;
            FieldDescriptor.access$2100(r19[r10], r8.getExtension(r10));
            r10 = r10 + 1;
            goto L18
        }

        private void validateNoDuplicateFieldNumbers() {
            int r8 = 0;
        L3:
            int r10 = r8 + 1;
            FieldDescriptor[] r11 = this.fieldsSortedByNumber;
            if (r10 >= r11.length) goto L10;
            FieldDescriptor r12 = r11[r8];
            FieldDescriptor r13 = r11[r10];
            if (r12.getNumber() == r13.getNumber()) goto L9;
            r8 = r10;
            goto L3
        L9:
            throw new DescriptorValidationException(r13, "Field number " + r13.getNumber() + " has already been used in \"" + r13.getContainingType().getFullName() + "\" by field \"" + r12.getName() + "\".", null);
        }

        public EnumDescriptor findEnumTypeByName(String r8) {
            GenericDescriptor r10 = FileDescriptor.access$2200(getFile()).findSymbol(this.fullName + '.' + r8);
            if ((r10 instanceof EnumDescriptor) == true) goto L5;
            return null;
        L5:
            return (EnumDescriptor) r10;
        }

        public FieldDescriptor findFieldByName(String r8) {
            GenericDescriptor r10 = FileDescriptor.access$2200(getFile()).findSymbol(this.fullName + '.' + r8);
            if ((r10 instanceof FieldDescriptor) == true) goto L5;
            return null;
        L5:
            return (FieldDescriptor) r10;
        }

        public FieldDescriptor findFieldByNumber(int r8) {
            FieldDescriptor[] r10 = this.fieldsSortedByNumber;
            return (FieldDescriptor) Descriptors.access$2400(r10, r10.length, FieldDescriptor.access$2300(), r8);
        }

        public Descriptor findNestedTypeByName(String r8) {
            GenericDescriptor r10 = FileDescriptor.access$2200(getFile()).findSymbol(this.fullName + '.' + r8);
            if ((r10 instanceof Descriptor) == true) goto L5;
            return null;
        L5:
            return (Descriptor) r10;
        }

        public Descriptor getContainingType() {
            GenericDescriptor r8 = this.parent;
            if ((r8 instanceof Descriptor) == true) goto L5;
            return null;
        L5:
            return (Descriptor) r8;
        }

        public EnumDescriptor getEnumType(int r8) {
            return this.enumTypes[r8];
        }

        public int getEnumTypeCount() {
            return this.enumTypes.length;
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public FieldDescriptor getExtension(int r8) {
            return this.extensions[r8];
        }

        public int getExtensionCount() {
            return this.extensions.length;
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public FieldDescriptor getField(int r8) {
            return this.fields[r8];
        }

        public int getFieldCount() {
            return this.fields.length;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.parent.getFile();
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

        public Descriptor getNestedType(int r8) {
            return this.nestedTypes[r8];
        }

        public int getNestedTypeCount() {
            return this.nestedTypes.length;
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public OneofDescriptor getOneof(int r8) {
            return this.oneofs[r8];
        }

        public int getOneofCount() {
            return this.oneofs.length;
        }

        public List<OneofDescriptor> getOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs));
        }

        public DescriptorProtos.MessageOptions getOptions() {
            if (this.options != null) goto L17;
            DescriptorProtos.MessageOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.parent;
        }

        public OneofDescriptor getRealOneof(int r8) {
            if (r8 >= this.realOneofCount) goto L7;
            return this.oneofs[r8];
        L7:
            throw new ArrayIndexOutOfBoundsException(r8);
        }

        public int getRealOneofCount() {
            return this.realOneofCount;
        }

        public List<OneofDescriptor> getRealOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs).subList(0, this.realOneofCount));
        }

        public boolean isExtendable() {
            return !this.proto.getExtensionRangeList().isEmpty();
        }

        public boolean isExtensionNumber(int r8) {
            int r10 = Arrays.binarySearch(this.extensionRangeLowerBounds, r8);
            if (r10 >= 0) goto L5;
            r10 = (~r10) - 1;
        L5:
            if (r10 >= 0) goto L7;
        L9:
            return false;
        L7:
            if (r8 >= this.extensionRangeUpperBounds[r10]) goto L9;
            return true;
        }

        public boolean isPlaceholder() {
            return this.placeholder;
        }

        public boolean isReservedName(String r8) {
            Internal.checkNotNull(r8);
            Iterator<String> r10 = this.proto.getReservedNameList().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (r10.next().equals(r8) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r8) {
            Iterator<DescriptorProtos.DescriptorProto.ReservedRange> r10 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r10.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ReservedRange r11 = r10.next();
            if (r11.getStart() > r8) goto L4;
            if (r8 >= r11.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }

        public /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto r8, FileDescriptor r10, Descriptor r11, int r12, AnonymousClass1 r13) {
            this(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public Descriptor(String r8) {
            super(null);
            int r10 = r8.lastIndexOf(46);
            if (r10 == (-1)) goto L5;
            String r11 = r8.substring(r10 + 1);
            String r12 = r8.substring(0, r10);
        L6:
            this.index = 0;
            this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(r11).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
            this.fullName = r8;
            this.nestedTypes = Descriptors.access$300();
            this.enumTypes = Descriptors.access$500();
            this.fields = Descriptors.access$900();
            this.fieldsSortedByNumber = Descriptors.access$900();
            this.extensions = Descriptors.access$900();
            this.oneofs = Descriptors.access$2500();
            this.realOneofCount = 0;
            this.parent = new FileDescriptor(r12, this);
            this.extensionRangeLowerBounds = new int[]{1};
            this.extensionRangeUpperBounds = new int[]{536870912};
            this.placeholder = true;
            return;
        L5:
            r12 = "";
            r11 = r8;
            goto L6
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        private DescriptorValidationException(FileDescriptor r8, String r10) {
            super(r8.getName() + ": " + r10);
            this.name = r8.getName();
            this.proto = r8.toProto();
            this.description = r10;
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

        public /* synthetic */ DescriptorValidationException(FileDescriptor r8, String r10, AnonymousClass1 r11) {
            this(r8, r10);
        }

        private DescriptorValidationException(GenericDescriptor r8, String r10) {
            super(r8.getFullName() + ": " + r10);
            this.name = r8.getFullName();
            this.proto = r8.toProto();
            this.description = r10;
        }

        public /* synthetic */ DescriptorValidationException(GenericDescriptor r8, String r10, AnonymousClass1 r11) {
            this(r8, r10);
        }

        private DescriptorValidationException(GenericDescriptor r8, String r10, Throwable r11) {
            this(r8, r10);
            initCause(r11);
        }

        public /* synthetic */ DescriptorValidationException(GenericDescriptor r8, String r10, Throwable r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }
    }

    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
        private ReferenceQueue<EnumValueDescriptor> cleanupQueue;
        private final int distinctNumbers;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.EnumOptions options;
        private final GenericDescriptor parent;
        private DescriptorProtos.EnumDescriptorProto proto;
        private Map<Integer, WeakReference<EnumValueDescriptor>> unknownValues;
        private final EnumValueDescriptor[] values;
        private final EnumValueDescriptor[] valuesSortedByNumber;

        public static class UnknownEnumValueReference extends WeakReference<EnumValueDescriptor> {
            private final int number;

            private UnknownEnumValueReference(int r8, EnumValueDescriptor r10) {
                super(r10);
                this.number = r8;
            }

            public static /* synthetic */ int access$4000(UnknownEnumValueReference r8) {
                return r8.number;
            }

            public /* synthetic */ UnknownEnumValueReference(int r8, EnumValueDescriptor r10, AnonymousClass1 r11) {
                this(r8, r10);
            }
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto r8, FileDescriptor r10, Descriptor r11, int r12) {
            AnonymousClass1 r13 = null;
            super(r13);
            this.unknownValues = null;
            this.cleanupQueue = null;
            if (r11 != null) goto L5;
            this.parent = r10;
        L6:
            this.index = r12;
            this.proto = r8;
            this.fullName = Descriptors.access$2600(r10, r11, r8.getName());
            if (r8.getValueCount() == 0) goto L22;
            this.values = new EnumValueDescriptor[r8.getValueCount()];
            int r14 = 0;
            int r15 = 0;
        L10:
            if (r15 >= r8.getValueCount()) goto L12;
            this.values[r15] = new EnumValueDescriptor(r8.getValue(r15), this, r15, r13);
            r15 = r15 + 1;
            goto L10
        L12:
            EnumValueDescriptor[] r16 = (EnumValueDescriptor[]) this.values.clone();
            this.valuesSortedByNumber = r16;
            Arrays.sort(r16, EnumValueDescriptor.BY_NUMBER);
            int r17 = 1;
        L14:
            if (r17 >= r8.getValueCount()) goto L19;
            EnumValueDescriptor[] r18 = this.valuesSortedByNumber;
            EnumValueDescriptor r19 = r18[r14];
            EnumValueDescriptor r20 = r18[r17];
            if (r19.getNumber() == r20.getNumber()) goto L18;
            r14 = r14 + 1;
            this.valuesSortedByNumber[r14] = r20;
        L18:
            r17 = r17 + 1;
            goto L14
        L19:
            int r21 = r14 + 1;
            this.distinctNumbers = r21;
            Arrays.fill(this.valuesSortedByNumber, r21, r8.getValueCount(), null);
            FileDescriptor.access$2200(r10).addSymbol(this);
            return;
        L22:
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", r13);
        L5:
            this.parent = r11;
            goto L6
        }

        public static /* synthetic */ void access$1200(EnumDescriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$1900(EnumDescriptor r8, DescriptorProtos.EnumDescriptorProto r10) {
            r8.setProto(r10);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            EnumValueDescriptor[] r8 = this.values;
            int r10 = r8.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            EnumValueDescriptor.access$4400(r8[r11]);
            r11 = r11 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.EnumDescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
            int r10 = 0;
        L3:
            EnumValueDescriptor[] r11 = this.values;
            if (r10 >= r11.length) goto L6;
            EnumValueDescriptor.access$4500(r11[r10], r8.getValue(r10));
            r10 = r10 + 1;
            goto L3
        }

        public EnumValueDescriptor findValueByName(String r8) {
            GenericDescriptor r10 = FileDescriptor.access$2200(getFile()).findSymbol(this.fullName + '.' + r8);
            if ((r10 instanceof EnumValueDescriptor) == true) goto L5;
            return null;
        L5:
            return (EnumValueDescriptor) r10;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int r8) {
            return (EnumValueDescriptor) Descriptors.access$2400(this.valuesSortedByNumber, this.distinctNumbers, EnumValueDescriptor.NUMBER_GETTER, r8);
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(int r8) {
            EnumValueDescriptor r10 = findValueByNumber(r8);
            if (r10 == null) goto L5;
            return r10;
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
            WeakReference<EnumValueDescriptor> r11 = this.unknownValues.get(Integer.valueOf(r8));     // Catch: Throwable -> L20
            AnonymousClass1 r12 = null;
            if (r11 != null) goto L14;
            EnumValueDescriptor r13 = null;
        L15:
            if (r13 != null) goto L17;
            r13 = new EnumValueDescriptor(this, Integer.valueOf(r8), r12);     // Catch: Throwable -> L20
            this.unknownValues.put(Integer.valueOf(r8), new UnknownEnumValueReference(r8, r13, r12));     // Catch: Throwable -> L20
        L17:
            monitor-exit(this);     // Catch: Throwable -> L20
            return r13;
        L14:
            r13 = r11.get();     // Catch: Throwable -> L20
        L9:
            UnknownEnumValueReference r14 = (UnknownEnumValueReference) this.cleanupQueue.poll();     // Catch: Throwable -> L20
            if (r14 == null) goto L11;
            this.unknownValues.remove(Integer.valueOf(UnknownEnumValueReference.access$4000(r14)));     // Catch: Throwable -> L20
            goto L9
        }

        public Descriptor getContainingType() {
            GenericDescriptor r8 = this.parent;
            if ((r8 instanceof Descriptor) == true) goto L5;
            return null;
        L5:
            return (Descriptor) r8;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.parent.getFile();
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
            DescriptorProtos.EnumOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.parent;
        }

        public int getUnknownEnumValueDescriptorCount() {
            return this.unknownValues.size();
        }

        public EnumValueDescriptor getValue(int r8) {
            return this.values[r8];
        }

        public int getValueCount() {
            return this.values.length;
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

        public boolean isPlaceholder() {
            return false;
        }

        public boolean isReservedName(String r8) {
            Internal.checkNotNull(r8);
            Iterator<String> r10 = this.proto.getReservedNameList().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (r10.next().equals(r8) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r8) {
            Iterator<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> r10 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r10.hasNext() == false) goto L11;
            DescriptorProtos.EnumDescriptorProto.EnumReservedRange r11 = r10.next();
            if (r11.getStart() > r8) goto L4;
            if (r8 > r11.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }

        public /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto r8, FileDescriptor r10, Descriptor r11, int r12, AnonymousClass1 r13) {
            this(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public /* bridge */ /* synthetic */ Internal.EnumLite findValueByNumber(int r8) {
            return findValueByNumber(r8);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
        static final Comparator<EnumValueDescriptor> BY_NUMBER = null;
        static final ToIntFunction<EnumValueDescriptor> NUMBER_GETTER = null;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.EnumValueOptions options;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        static {
            BY_NUMBER = new AnonymousClass1();
            NUMBER_GETTER = new a(0);
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r8, EnumDescriptor r10, int r11) {
            super(null);
            this.index = r11;
            this.proto = r8;
            this.type = r10;
            this.fullName = r10.getFullName() + '.' + r8.getName();
            FileDescriptor.access$2200(r10.getFile()).addSymbol(this);
        }

        public static /* synthetic */ void access$4400(EnumValueDescriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$4500(EnumValueDescriptor r8, DescriptorProtos.EnumValueDescriptorProto r10) {
            r8.setProto(r10);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.EnumValueDescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.type.getFile();
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
            DescriptorProtos.EnumValueOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.type;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        public String toString() {
            return this.proto.getName();
        }

        public /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r8, EnumDescriptor r10, int r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        private EnumValueDescriptor(EnumDescriptor r8, Integer r10) {
            super(null);
            DescriptorProtos.EnumValueDescriptorProto r11 = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + r8.getName() + "_" + r10).setNumber(r10.intValue()).build();
            this.index = -1;
            this.proto = r11;
            this.type = r8;
            this.fullName = r8.getFullName() + '.' + r11.getName();
        }

        public /* synthetic */ EnumValueDescriptor(EnumDescriptor r8, Integer r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    public static final class FieldDescriptor extends GenericDescriptor implements Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {
        private static final ToIntFunction<FieldDescriptor> NUMBER_GETTER = null;
        private static final WireFormat.FieldType[] table = null;
        private OneofDescriptor containingOneof;
        private Descriptor containingType;
        private Object defaultValue;
        private final Descriptor extensionScope;
        private final String fullName;
        private final int index;
        private final boolean isProto3Optional;
        private String jsonName;
        private volatile DescriptorProtos.FieldOptions options;
        private final GenericDescriptor parent;
        private DescriptorProtos.FieldDescriptorProto proto;
        private volatile RedactionState redactionState;
        private Type type;
        private GenericDescriptor typeDescriptor;

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

            private JavaType(String r8, int r10, Object r11) {
                super(r8, r10);
                this.defaultDefault = r11;
            }

            public static /* synthetic */ Object access$3900(JavaType r8) {
                return r8.defaultDefault;
            }

            public static JavaType valueOf(String r8) {
                return (JavaType) java.lang.Enum.valueOf(JavaType.class, r8);
            }

            public static JavaType[] values() {
                return (JavaType[]) $VALUES.clone();
            }
        }

        public static final class RedactionState {
            private static final RedactionState FALSE_FALSE = null;
            private static final RedactionState FALSE_TRUE = null;
            private static final RedactionState TRUE_FALSE = null;
            private static final RedactionState TRUE_TRUE = null;
            final boolean redact;
            final boolean report;

            static {
                FALSE_FALSE = new RedactionState(false, false);
                FALSE_TRUE = new RedactionState(false, true);
                TRUE_FALSE = new RedactionState(true, false);
                TRUE_TRUE = new RedactionState(true, true);
            }

            private RedactionState(boolean r8, boolean r10) {
                this.redact = r8;
                this.report = r10;
            }

            public static /* synthetic */ RedactionState access$3500(boolean r8, boolean r10) {
                return of(r8, r10);
            }

            public static /* synthetic */ RedactionState access$3600(boolean r8) {
                return of(r8);
            }

            public static /* synthetic */ RedactionState access$3700(RedactionState r8, RedactionState r10) {
                return combine(r8, r10);
            }

            private static RedactionState combine(RedactionState r8, RedactionState r10) {
                if (r8.redact == false) goto L5;
            L8:
                boolean r11 = true;
            L10:
                return of(r11, r10.report);
            L5:
                if (r10.redact == true) goto L8;
                r11 = false;
                goto L10
            }

            private static RedactionState of(boolean r8) {
                return of(r8, false);
            }

            private static RedactionState of(boolean r8, boolean r10) {
                if (r8 == false) goto L7;
                if (r10 == false) goto L6;
                return TRUE_TRUE;
            L6:
                return TRUE_FALSE;
            L7:
                if (r10 == false) goto L10;
                return FALSE_TRUE;
            L10:
                return FALSE_FALSE;
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
                JavaType r8 = JavaType.LONG;
                INT64 = new Type("INT64", 2, r8);
                UINT64 = new Type("UINT64", 3, r8);
                JavaType r10 = JavaType.INT;
                INT32 = new Type("INT32", 4, r10);
                FIXED64 = new Type("FIXED64", 5, r8);
                FIXED32 = new Type("FIXED32", 6, r10);
                BOOL = new Type("BOOL", 7, JavaType.BOOLEAN);
                STRING = new Type("STRING", 8, JavaType.STRING);
                JavaType r11 = JavaType.MESSAGE;
                GROUP = new Type("GROUP", 9, r11);
                MESSAGE = new Type("MESSAGE", 10, r11);
                BYTES = new Type("BYTES", 11, JavaType.BYTE_STRING);
                UINT32 = new Type("UINT32", 12, r10);
                ENUM = new Type("ENUM", 13, JavaType.ENUM);
                SFIXED32 = new Type("SFIXED32", 14, r10);
                SFIXED64 = new Type("SFIXED64", 15, r8);
                SINT32 = new Type("SINT32", 16, r10);
                SINT64 = new Type("SINT64", 17, r8);
                $VALUES = $values();
                types = values();
            }

            private Type(String r8, int r10, JavaType r11) {
                super(r8, r10);
                this.javaType = r11;
            }

            public static /* synthetic */ Type[] access$3400() {
                return types;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type r8) {
                return types[r8.getNumber() - 1];
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

            public static Type valueOf(String r8) {
                return (Type) java.lang.Enum.valueOf(Type.class, r8);
            }
        }

        static {
            NUMBER_GETTER = new b();
            table = WireFormat.FieldType.values();
            if (Type.access$3400().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) goto L6;
            return;
        L6:
            throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto r8, FileDescriptor r10, Descriptor r11, int r12, boolean r13) {
            AnonymousClass1 r14 = null;
            super(r14);
            this.index = r12;
            this.proto = r8;
            this.fullName = Descriptors.access$2600(r10, r11, r8.getName());
            if (r8.hasType() == false) goto L5;
            this.type = Type.valueOf(r8.getType());
        L5:
            this.isProto3Optional = r8.getProto3Optional();
            if (getNumber() <= 0) goto L38;
            boolean r15 = r8.hasExtendee();
            if (r13 == false) goto L21;
            if (r15 == false) goto L20;
            this.containingType = null;
            if (r11 == null) goto L13;
            this.extensionScope = r11;
            GenericDescriptor r16 = r11;
        L14:
            this.parent = r16;
            if (r8.hasOneofIndex() == true) goto L18;
            this.containingOneof = null;
        L33:
            FileDescriptor.access$2200(r10).addSymbol(this);
            return;
        L18:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", r14);
        L13:
            this.extensionScope = null;
            r16 = (GenericDescriptor) Internal.checkNotNull(r10);
            goto L14
        L20:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", r14);
        L21:
            if (r15 == true) goto L36;
            this.containingType = r11;
            if (r8.hasOneofIndex() == true) goto L25;
            this.containingOneof = null;
            Object r17 = Internal.checkNotNull(r11);
        L32:
            this.parent = (GenericDescriptor) r17;
            this.extensionScope = null;
            goto L33
        L25:
            if (r8.getOneofIndex() < 0) goto L30;
            if (r8.getOneofIndex() >= r11.toProto().getOneofDeclCount()) goto L30;
            OneofDescriptor r18 = r11.getOneofs().get(r8.getOneofIndex());
            this.containingOneof = r18;
            OneofDescriptor.access$2908(r18);
            r17 = Internal.checkNotNull(this.containingOneof);
        L30:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + r11.getName(), r14);
        L36:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", r14);
        L38:
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", r14);
        }

        public static /* synthetic */ void access$1400(FieldDescriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$1700(FieldDescriptor r8) {
            r8.crossLink();
        }

        public static /* synthetic */ void access$2100(FieldDescriptor r8, DescriptorProtos.FieldDescriptorProto r10) {
            r8.setProto(r10);
        }

        public static /* synthetic */ ToIntFunction access$2300() {
            return NUMBER_GETTER;
        }

        public static /* synthetic */ boolean access$5200(FieldDescriptor r8) {
            return r8.isProto3Optional;
        }

        private void crossLink() {
            AnonymousClass1 r8 = null;
            if (this.proto.hasExtendee() == false) goto L14;
            GenericDescriptor r10 = FileDescriptor.access$2200(getFile()).lookupSymbol(this.proto.getExtendee(), this, FileDescriptorTables.SearchFilter.TYPES_ONLY);
            if ((r10 instanceof Descriptor) == false) goto L12;
            this.containingType = (Descriptor) r10;
            if (getContainingType().isExtensionNumber(getNumber()) == true) goto L14;
            throw new DescriptorValidationException(this, "\"" + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", r8);
        L12:
            throw new DescriptorValidationException(this, "\"" + this.proto.getExtendee() + "\" is not a message type.", r8);
        L14:
            if (this.proto.hasTypeName() == false) goto L47;
            GenericDescriptor r11 = FileDescriptor.access$2200(getFile()).lookupSymbol(this.proto.getTypeName(), this, FileDescriptorTables.SearchFilter.TYPES_ONLY);
            if (this.proto.hasType() == true) goto L27;
            if ((r11 instanceof Descriptor) == false) goto L22;
            Type r12 = Type.MESSAGE;
        L20:
            this.type = r12;
            goto L27
        L22:
            if ((r11 instanceof EnumDescriptor) == false) goto L25;
            r12 = Type.ENUM;
            goto L20
        L25:
            throw new DescriptorValidationException(this, "\"" + this.proto.getTypeName() + "\" is not a type.", r8);
        L27:
            if (this.type.getJavaType() != JavaType.MESSAGE) goto L38;
            if ((r11 instanceof Descriptor) == false) goto L36;
            this.typeDescriptor = r11;
            if (this.proto.hasDefaultValue() == false) goto L51;
            throw new DescriptorValidationException(this, "Messages can't have default values.", r8);
        L51:
            if (this.proto.getOptions().getPacked() == false) goto L58;
            if (isPackable() == true) goto L58;
            throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", r8);
        L58:
            if (this.proto.hasDefaultValue() == false) goto L112;
            if (isRepeated() == true) goto L110;
        L106:
            e = move-exception;
            throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + '\"', e, r8);
        L64:
            switch(this.type.ordinal()) {
                case 0: goto L96;
                case 1: goto L86;
                case 2: goto L84;
                case 3: goto L83;
                case 4: goto L82;
                case 5: goto L83;
                case 6: goto L81;
                case 7: goto L80;
                case 8: goto L78;
                case 9: goto L77;
                case 10: goto L77;
                case 11: goto L125;
                case 12: goto L81;
                case 13: goto L66;
                case 14: goto L82;
                case 15: goto L84;
                case 16: goto L82;
                case 17: goto L84;
                default: goto L131;
            };
        L66:
            EnumValueDescriptor r13 = getEnumType().findValueByName(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L106
            this.defaultValue = r13;     // Catch: NumberFormatException -> L106
            if (r13 == null) goto L70;
            return;
        L70:
            throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + '\"', r8);     // Catch: NumberFormatException -> L106
        L78:
            Object r14 = this.proto.getDefaultValue();     // Catch: NumberFormatException -> L106
        L79:
            this.defaultValue = r14;     // Catch: NumberFormatException -> L106
            return;
        L80:
            r14 = Boolean.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L106
            goto L79
        L81:
            r14 = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L106
            goto L79
        L82:
            r14 = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L106
            goto L79
        L83:
            r14 = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L106
            goto L79
        L84:
            r14 = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L106
            goto L79
        L125:
            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());     // Catch: TextFormat.InvalidEscapeSequenceException -> L73 NumberFormatException -> L106
        L132:
            return;
        L73:
            e = move-exception;
            throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, r8);     // Catch: NumberFormatException -> L106
        L131:
            return;
        L77:
            throw new DescriptorValidationException(this, "Message type had default value.", r8);     // Catch: NumberFormatException -> L106
        L86:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L89;
            r14 = Float.valueOf(Float.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L106
            goto L79
        L89:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L92;
            r14 = Float.valueOf(Float.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L106
            goto L79
        L92:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L94;
            r14 = Float.valueOf(Float.NaN);     // Catch: NumberFormatException -> L106
            goto L79
        L94:
            r14 = Float.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L106
            goto L79
        L96:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L99;
            r14 = Double.valueOf(Double.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L106
            goto L79
        L99:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L102;
            r14 = Double.valueOf(Double.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L106
            goto L79
        L102:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L104;
            r14 = Double.valueOf(Double.NaN);     // Catch: NumberFormatException -> L106
            goto L79
        L104:
            r14 = Double.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L106
            goto L79
        L110:
            throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", r8);
        L112:
            if (isRepeated() == false) goto L115;
            Object r15 = Collections.emptyList();
        L114:
            this.defaultValue = r15;
            return;
        L115:
            int r16 = this.type.getJavaType().ordinal();
            if (r16 != 7) goto L118;
            r15 = getEnumType().getValue(0);
            goto L114
        L118:
            if (r16 == 8) goto L120;
            r15 = JavaType.access$3900(this.type.getJavaType());
            goto L114
        L120:
            this.defaultValue = null;
            return;
        L36:
            throw new DescriptorValidationException(this, "\"" + this.proto.getTypeName() + "\" is not a message type.", r8);
        L38:
            if (this.type.getJavaType() != JavaType.ENUM) goto L45;
            if ((r11 instanceof EnumDescriptor) == false) goto L43;
            this.typeDescriptor = r11;
            goto L51
        L43:
            throw new DescriptorValidationException(this, "\"" + this.proto.getTypeName() + "\" is not an enum type.", r8);
        L45:
            throw new DescriptorValidationException(this, "Field with primitive type has type_name.", r8);
        L47:
            if (this.type.getJavaType() == JavaType.MESSAGE) goto L124;
            if (this.type.getJavaType() != JavaType.ENUM) goto L51;
        L124:
            throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", r8);
        }

        private static String fieldNameToJsonName(String r8) {
            int r10 = r8.length();
            StringBuilder r11 = new StringBuilder(r10);
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r12 >= r10) goto L17;
            char r14 = r8.charAt(r12);
            if (r14 != '_') goto L7;
            r13 = true;
        L15:
            r12 = r12 + 1;
            goto L3
        L7:
            if (r13 == true) goto L9;
            r11.append(r14);
            goto L15
        L9:
            if ('a' <= r14) goto L11;
        L13:
            r11.append(r14);
            r13 = false;
            goto L15
        L11:
            if (r14 > 'z') goto L13;
            r14 = (char) ((r14 - 'a') + 65);
            goto L13
        L17:
            return r11.toString();
        }

        private static RedactionState isOptionSensitive(FieldDescriptor r8, Object r10) {
            if (r8.getType() != Type.ENUM) goto L18;
            if (r8.isRepeated() == false) goto L14;
            Iterator r11 = ((List) r10).iterator();
        L8:
            if (r11.hasNext() == false) goto L37;
            if (((EnumValueDescriptor) r11.next()).getOptions().getDebugRedact() == false) goto L8;
            return RedactionState.access$3500(true, false);
        L37:
            return RedactionState.access$3600(false);
        L14:
            if (((EnumValueDescriptor) r10).getOptions().getDebugRedact() == false) goto L37;
            return RedactionState.access$3500(true, false);
        L18:
            if (r8.getJavaType() != JavaType.MESSAGE) goto L37;
            if (r8.isRepeated() == false) goto L30;
            Iterator r12 = ((List) r10).iterator();
        L23:
            if (r12.hasNext() == false) goto L37;
            Iterator<Map.Entry<FieldDescriptor, Object>> r13 = ((Message) r12.next()).getAllFields().entrySet().iterator();
        L26:
            if (r13.hasNext() == false) goto L23;
            Map.Entry<FieldDescriptor, Object> r14 = r13.next();
            RedactionState r15 = isOptionSensitive(r14.getKey(), r14.getValue());
            if (r15.redact == false) goto L26;
            return r15;
        L30:
            Iterator<Map.Entry<FieldDescriptor, Object>> r16 = ((Message) r10).getAllFields().entrySet().iterator();
        L32:
            if (r16.hasNext() == false) goto L37;
            Map.Entry<FieldDescriptor, Object> r17 = r16.next();
            RedactionState r18 = isOptionSensitive(r17.getKey(), r17.getValue());
            if (r18.redact == false) goto L32;
            return r18;
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.FieldDescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FieldDescriptor r8) {
            if (r8.containingType != this.containingType) goto L7;
            return getNumber() - r8.getNumber();
        L7:
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
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
            return (EnumDescriptor) this.typeDescriptor;
        L7:
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[]{this.fullName}));
        }

        public Descriptor getExtensionScope() {
            if (isExtension() == false) goto L7;
            return this.extensionScope;
        L7:
            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[]{this.fullName}));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.parent.getFile();
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
            String r8 = this.jsonName;
            if (r8 == null) goto L6;
            return r8;
        L6:
            if (this.proto.hasJsonName() == false) goto L10;
            String r10 = this.proto.getJsonName();
        L8:
            this.jsonName = r10;
            return r10;
        L10:
            r10 = fieldNameToJsonName(this.proto.getName());
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
            return (Descriptor) this.typeDescriptor;
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
            DescriptorProtos.FieldOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.parent;
        }

        public OneofDescriptor getRealContainingOneof() {
            OneofDescriptor r8 = this.containingOneof;
            if (r8 != null) goto L5;
        L7:
            return null;
        L5:
            if (r8.isSynthetic() == true) goto L7;
            return this.containingOneof;
        }

        public RedactionState getRedactionState() {
            RedactionState r8 = this.redactionState;
            if (r8 != null) goto L18;
            monitor-enter(this);
            r8 = this.redactionState;     // Catch: Throwable -> L15
            if (r8 != null) goto L13;
            DescriptorProtos.FieldOptions r10 = getOptions();     // Catch: Throwable -> L15
            RedactionState r11 = RedactionState.access$3600(r10.getDebugRedact());     // Catch: Throwable -> L15
            Iterator<Map.Entry<FieldDescriptor, Object>> r12 = r10.getAllFields().entrySet().iterator();     // Catch: Throwable -> L15
        L9:
            if (r12.hasNext() == false) goto L12;
            Map.Entry<FieldDescriptor, Object> r13 = r12.next();     // Catch: Throwable -> L15
            r11 = RedactionState.access$3700(r11, isOptionSensitive(r13.getKey(), r13.getValue()));     // Catch: Throwable -> L15
            if (r11.redact == false) goto L9;
        L12:
            this.redactionState = r11;     // Catch: Throwable -> L15
            r8 = r11;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L18:
            return r8;
        }

        public Type getType() {
            if (this.type != Type.MESSAGE) goto L19;
            GenericDescriptor r8 = this.typeDescriptor;
            if (r8 != null) goto L7;
        L8:
            Descriptor r10 = this.containingType;
            if (r10 == null) goto L13;
            if (r10.toProto().getOptions().getMapEntry() == true) goto L19;
        L13:
            if (this.features == null) goto L19;
            if (getFeatures().getMessageEncoding() != DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED) goto L19;
            return Type.GROUP;
        L7:
            if (((Descriptor) r8).toProto().getOptions().getMapEntry() == false) goto L8;
        L19:
            return this.type;
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        public boolean hasOptionalKeyword() {
            if (this.isProto3Optional == false) goto L5;
        L14:
            return true;
        L5:
            if (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO2) goto L7;
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
        public DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            if (getFile().getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L7;
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        L7:
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) goto L9;
            DescriptorProtos.FeatureSet.Builder r8 = DescriptorProtos.FeatureSet.newBuilder();
            r8.setFieldPresence(DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED);
        L11:
            if (this.proto.getType() != DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP) goto L16;
            if (r8 != null) goto L14;
            r8 = DescriptorProtos.FeatureSet.newBuilder();
        L14:
            r8.setMessageEncoding(DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED);
        L16:
            if (getFile().getEdition() != DescriptorProtos.Edition.EDITION_PROTO2) goto L23;
            if (this.proto.getOptions().getPacked() == false) goto L23;
            if (r8 != null) goto L21;
            r8 = DescriptorProtos.FeatureSet.newBuilder();
        L21:
            r8.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.PACKED);
        L23:
            if (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO3) goto L25;
        L31:
            if (r8 == null) goto L34;
            return r8.build();
        L34:
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        L25:
            if (this.proto.getOptions().hasPacked() == false) goto L31;
            if (this.proto.getOptions().getPacked() == true) goto L31;
            if (r8 != null) goto L30;
            r8 = DescriptorProtos.FeatureSet.newBuilder();
        L30:
            r8.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.EXPANDED);
            goto L31
        L9:
            r8 = null;
            goto L11
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public void internalMergeFrom(Object r8, Object r10) {
            ((Message.Builder) r8).mergeFrom((Message) r10);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean internalMessageIsImmutable(Object r8) {
            return r8 instanceof MessageLite;
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public boolean isGroupLike() {
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

        public boolean isRequired() {
            if (getFeatures().getFieldPresence() != DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean legacyEnumFieldTreatedAsClosed() {
            if (getFile().getDependencies().isEmpty() == false) goto L12;
            if (getType() != Type.ENUM) goto L10;
            if (getEnumType().isClosed() == false) goto L10;
            return true;
        L10:
            return false;
        L12:
            if (getType() != Type.ENUM) goto L19;
            if (((JavaFeaturesProto.JavaFeatures) getFeatures().getExtension(JavaFeaturesProto.java_)).getLegacyClosedEnum() == false) goto L16;
            return true;
        L16:
            if (getEnumType().isClosed() == false) goto L19;
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

        public String toString() {
            return getFullName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public void validateFeatures() {
            Descriptor r8 = this.containingType;
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.toProto().getOptions().getMessageSetWireFormat() == true) goto L7;
            return;
        L7:
            if (isExtension() == true) goto L9;
            return;
        L9:
            if (isRequired() == true) goto L16;
            if (isRepeated() == true) goto L16;
            if (getType() != Type.MESSAGE) goto L16;
            return;
        L16:
            throw new DescriptorValidationException(this, "Extensions of MessageSets may not be required or repeated messages.", null);
        }

        public /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto r8, FileDescriptor r10, Descriptor r11, int r12, boolean r13, AnonymousClass1 r14) {
            this(r8, r10, r11, r12, r13);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(FieldDescriptor r8) {
            return compareTo2(r8);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public /* bridge */ /* synthetic */ Internal.EnumLiteMap getEnumType() {
            return getEnumType();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    public static final class FileDescriptor extends GenericDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private volatile boolean featuresResolved;
        private final Descriptor[] messageTypes;
        private volatile DescriptorProtos.FileOptions options;
        private final boolean placeholder;
        private DescriptorProtos.FileDescriptorProto proto;
        private final FileDescriptor[] publicDependencies;
        private final ServiceDescriptor[] services;
        private final FileDescriptorTables tables;

        @Deprecated
        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor r8);
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11, FileDescriptorTables r12, boolean r13) {
            AnonymousClass1 r8 = null;
            super(r8);
            this.tables = r12;
            this.proto = r10;
            this.dependencies = (FileDescriptor[]) r11.clone();
            int r14 = 0;
            this.featuresResolved = false;
            HashMap r15 = new HashMap();
            int r16 = r11.length;
            int r17 = 0;
        L3:
            if (r17 >= r16) goto L5;
            FileDescriptor r18 = r11[r17];
            r15.put(r18.getName(), r18);
            r17 = r17 + 1;
            goto L3
        L5:
            ArrayList r19 = new ArrayList();
            int r20 = 0;
        L7:
            if (r20 >= r10.getPublicDependencyCount()) goto L22;
            int r21 = r10.getPublicDependency(r20);
            if (r21 < 0) goto L21;
            if (r21 >= r10.getDependencyCount()) goto L21;
            String r22 = r10.getDependency(r21);
            FileDescriptor r23 = (FileDescriptor) r15.get(r22);
            if (r23 != null) goto L18;
            if (r13 == true) goto L19;
            throw new DescriptorValidationException(this, defpackage.b.c("Invalid public dependency: ", r22), r8);
        L19:
            r20 = r20 + 1;
            goto L7
        L18:
            r19.add(r23);
        L21:
            throw new DescriptorValidationException(this, "Invalid public dependency index.", r8);
        L22:
            FileDescriptor[] r110 = new FileDescriptor[r19.size()];
            this.publicDependencies = r110;
            r19.toArray(r110);
            this.placeholder = false;
            r12.addPackage(getPackage(), this);
            if (r10.getMessageTypeCount() <= 0) goto L25;
            Descriptor[] r111 = new Descriptor[r10.getMessageTypeCount()];
        L26:
            this.messageTypes = r111;
            int r112 = 0;
        L28:
            if (r112 >= r10.getMessageTypeCount()) goto L31;
            this.messageTypes[r112] = new Descriptor(r10.getMessageType(r112), this, null, r112, null);
            r112 = r112 + 1;
            goto L28
        L31:
            if (r10.getEnumTypeCount() <= 0) goto L33;
            EnumDescriptor[] r113 = new EnumDescriptor[r10.getEnumTypeCount()];
        L34:
            this.enumTypes = r113;
            int r114 = 0;
        L36:
            if (r114 >= r10.getEnumTypeCount()) goto L39;
            this.enumTypes[r114] = new EnumDescriptor(r10.getEnumType(r114), this, null, r114, null);
            r114 = r114 + 1;
            goto L36
        L39:
            if (r10.getServiceCount() <= 0) goto L41;
            ServiceDescriptor[] r115 = new ServiceDescriptor[r10.getServiceCount()];
        L42:
            this.services = r115;
            int r116 = 0;
        L44:
            if (r116 >= r10.getServiceCount()) goto L47;
            this.services[r116] = new ServiceDescriptor(r10.getService(r116), this, r116, r8);
            r116 = r116 + 1;
            goto L44
        L47:
            if (r10.getExtensionCount() <= 0) goto L49;
            FieldDescriptor[] r117 = new FieldDescriptor[r10.getExtensionCount()];
        L50:
            this.extensions = r117;
        L52:
            if (r14 >= r10.getExtensionCount()) goto L54;
            this.extensions[r14] = new FieldDescriptor(r10.getExtension(r14), this, null, r14, true, null);
            r14 = r14 + 1;
            goto L52
        L54:
            return;
        L49:
            r117 = Descriptors.access$900();
            goto L50
        L41:
            r115 = Descriptors.access$700();
            goto L42
        L33:
            r113 = Descriptors.access$500();
            goto L34
        L25:
            r111 = Descriptors.access$300();
            goto L26
        }

        public static /* synthetic */ FileDescriptorTables access$2200(FileDescriptor r8) {
            return r8.tables;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r8, FileDescriptor[] r10) {
            return buildFrom(r8, r10, false);
        }

        private void crossLink() {
            Descriptor[] r8 = this.messageTypes;
            int r10 = r8.length;
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            Descriptor.access$1500(r8[r12]);
            r12 = r12 + 1;
            goto L3
        L5:
            ServiceDescriptor[] r13 = this.services;
            int r14 = r13.length;
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L8;
            ServiceDescriptor.access$1600(r13[r15]);
            r15 = r15 + 1;
            goto L6
        L8:
            FieldDescriptor[] r16 = this.extensions;
            int r17 = r16.length;
        L9:
            if (r11 >= r17) goto L11;
            FieldDescriptor.access$1700(r16[r11]);
            r11 = r11 + 1;
            goto L9
        }

        private static FileDescriptor[] findDescriptors(Class<?> r8, String[] r10, String[] r11) {
            ArrayList r12 = new ArrayList();
            int r13 = 0;
        L4:
            if (r13 >= r10.length) goto L10;
            r12.add((FileDescriptor) r8.getClassLoader().loadClass(r10[r13]).getField("descriptor").get(null));     // Catch: Exception -> L7
        L8:
            r13 = r13 + 1;
        L7:
            Descriptors.access$000().warning("Descriptors for \"" + r11[r13] + "\" can not be found.");
            goto L8
        L10:
            return (FileDescriptor[]) r12.toArray(new FileDescriptor[0]);
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] r8, Class<?> r10, String[] r11, String[] r12) {
            return internalBuildGeneratedFileFrom(r8, findDescriptors(r10, r11, r12));
        }

        public static void internalUpdateFileDescriptor(FileDescriptor r8, ExtensionRegistry r10) {
            r8.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r8.proto.toByteString(), r10));     // Catch: InvalidProtocolBufferException -> L5
            return;
        L5:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        private static byte[] latin1Cat(String[] r8) {
            int r10 = 0;
            if (r8.length != 1) goto L7;
            String r11 = r8[0];
        L6:
            return r11.getBytes(Internal.ISO_8859_1);
        L7:
            StringBuilder r12 = new StringBuilder();
            int r13 = r8.length;
        L8:
            if (r10 >= r13) goto L10;
            r12.append(r8[r10]);
            r10 = r10 + 1;
            goto L8
        L10:
            r11 = r12.toString();
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
            Descriptor[] r8 = this.messageTypes;     // Catch: Throwable -> L25
            int r10 = r8.length;     // Catch: Throwable -> L25
            int r11 = 0;
            int r12 = 0;
        L11:
            if (r12 >= r10) goto L13;
            Descriptor.access$1100(r8[r12]);     // Catch: Throwable -> L25
            r12 = r12 + 1;     // Catch: Throwable -> L25
            goto L11
        L13:
            EnumDescriptor[] r13 = this.enumTypes;     // Catch: Throwable -> L25
            int r14 = r13.length;     // Catch: Throwable -> L25
            int r15 = 0;
        L14:
            if (r15 >= r14) goto L16;
            EnumDescriptor.access$1200(r13[r15]);     // Catch: Throwable -> L25
            r15 = r15 + 1;     // Catch: Throwable -> L25
            goto L14
        L16:
            ServiceDescriptor[] r16 = this.services;     // Catch: Throwable -> L25
            int r17 = r16.length;     // Catch: Throwable -> L25
            int r18 = 0;
        L17:
            if (r18 >= r17) goto L19;
            ServiceDescriptor.access$1300(r16[r18]);     // Catch: Throwable -> L25
            r18 = r18 + 1;     // Catch: Throwable -> L25
            goto L17
        L19:
            FieldDescriptor[] r19 = this.extensions;     // Catch: Throwable -> L25
            int r20 = r19.length;     // Catch: Throwable -> L25
        L20:
            if (r11 >= r20) goto L22;
            FieldDescriptor.access$1400(r19[r11]);     // Catch: Throwable -> L25
            r11 = r11 + 1;     // Catch: Throwable -> L25
            goto L20
        L22:
            this.featuresResolved = true;     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
        }

        private synchronized void setProto(DescriptorProtos.FileDescriptorProto r8) {
            monitor-enter(this);
            this.proto = r8;     // Catch: Throwable -> L25
            this.options = null;     // Catch: Throwable -> L25
            resolveFeatures(r8.getOptions().getFeatures());     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            int r10 = 0;
            int r11 = 0;
        L5:
            Descriptor[] r12 = this.messageTypes;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r11 >= r12.length) goto L8;
            Descriptor.access$1800(r12[r11], r8.getMessageType(r11));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r11 = r11 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            goto L5
        L8:
            int r13 = 0;
        L9:
            EnumDescriptor[] r14 = this.enumTypes;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r13 >= r14.length) goto L12;
            EnumDescriptor.access$1900(r14[r13], r8.getEnumType(r13));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r13 = r13 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            goto L9
        L12:
            int r15 = 0;
        L13:
            ServiceDescriptor[] r16 = this.services;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r15 >= r16.length) goto L16;
            ServiceDescriptor.access$2000(r16[r15], r8.getService(r15));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r15 = r15 + 1;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
        L16:
            FieldDescriptor[] r17 = this.extensions;     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            if (r10 >= r17.length) goto L20;
            FieldDescriptor.access$2100(r17[r10], r8.getExtension(r10));     // Catch: DescriptorValidationException -> L22 Throwable -> L25
            r10 = r10 + 1;
            goto L16
        L20:
            monitor-exit(this);
            return;
        L22:
            e = move-exception;
            throw new IllegalArgumentException("Invalid features for \"" + r8.getName() + "\".", e);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        public void copyHeadingTo(DescriptorProtos.FileDescriptorProto.Builder r8) {
            r8.setName(getName()).setSyntax(this.proto.getSyntax());
            if (getPackage().isEmpty() == true) goto L6;
            r8.setPackage(getPackage());
        L6:
            if (this.proto.getSyntax().equals("editions") == false) goto L9;
            r8.setEdition(this.proto.getEdition());
        L9:
            if (this.proto.hasOptions() == true) goto L11;
            return;
        L11:
            if (this.proto.getOptions().equals(DescriptorProtos.FileOptions.getDefaultInstance()) == true) goto L15;
            r8.setOptions(this.proto.getOptions());
            return;
        }

        public EnumDescriptor findEnumTypeByName(String r8) {
            if (r8.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r10 = getPackage();
            if (r10.isEmpty() == true) goto L8;
            r8 = r10 + '.' + r8;
        L8:
            GenericDescriptor r11 = this.tables.findSymbol(r8);
            if ((r11 instanceof EnumDescriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r11.getFile() != this) goto L14;
            return (EnumDescriptor) r11;
        }

        public FieldDescriptor findExtensionByName(String r8) {
            if (r8.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r10 = getPackage();
            if (r10.isEmpty() == true) goto L8;
            r8 = r10 + '.' + r8;
        L8:
            GenericDescriptor r11 = this.tables.findSymbol(r8);
            if ((r11 instanceof FieldDescriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r11.getFile() != this) goto L14;
            return (FieldDescriptor) r11;
        }

        public Descriptor findMessageTypeByName(String r8) {
            if (r8.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r10 = getPackage();
            if (r10.isEmpty() == true) goto L8;
            r8 = r10 + '.' + r8;
        L8:
            GenericDescriptor r11 = this.tables.findSymbol(r8);
            if ((r11 instanceof Descriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r11.getFile() != this) goto L14;
            return (Descriptor) r11;
        }

        public ServiceDescriptor findServiceByName(String r8) {
            if (r8.indexOf(46) == (-1)) goto L5;
            return null;
        L5:
            String r10 = getPackage();
            if (r10.isEmpty() == true) goto L8;
            r8 = r10 + '.' + r8;
        L8:
            GenericDescriptor r11 = this.tables.findSymbol(r8);
            if ((r11 instanceof ServiceDescriptor) == true) goto L11;
        L14:
            return null;
        L11:
            if (r11.getFile() != this) goto L14;
            return (ServiceDescriptor) r11;
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public DescriptorProtos.Edition getEdition() {
            String r8 = this.proto.getSyntax();
            r8.getClass();
            if (r8.equals("proto3") == true) goto L11;
            if (r8.equals("editions") == true) goto L9;
            return DescriptorProtos.Edition.EDITION_PROTO2;
        L9:
            return this.proto.getEdition();
        L11:
            return DescriptorProtos.Edition.EDITION_PROTO3;
        }

        public EnumDescriptor getEnumType(int r8) {
            return this.enumTypes[r8];
        }

        public int getEnumTypeCount() {
            return this.enumTypes.length;
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public FieldDescriptor getExtension(int r8) {
            return this.extensions[r8];
        }

        public int getExtensionCount() {
            return this.extensions.length;
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

        public Descriptor getMessageType(int r8) {
            return this.messageTypes[r8];
        }

        public int getMessageTypeCount() {
            return this.messageTypes.length;
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
            DescriptorProtos.FileOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return null;
        }

        public List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        public ServiceDescriptor getService(int r8) {
            return this.services[r8];
        }

        public int getServiceCount() {
            return this.services.length;
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            if (getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber()) goto L7;
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        L7:
            if (getEdition() == DescriptorProtos.Edition.EDITION_PROTO2) goto L9;
        L11:
            DescriptorProtos.FeatureSet.Builder r8 = null;
        L12:
            if (r8 == null) goto L15;
            return r8.build();
        L15:
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        L9:
            if (this.proto.getOptions().getJavaStringCheckUtf8() == false) goto L11;
            r8 = DescriptorProtos.FeatureSet.newBuilder();
            r8.setExtension(JavaFeaturesProto.java_, JavaFeaturesProto.JavaFeatures.newBuilder().setUtf8Validation(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY).build());
            goto L12
        }

        public boolean isPlaceholder() {
            return this.placeholder;
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

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r8, FileDescriptor[] r10, boolean r11) {
            return buildFrom(r8, r10, r11, false);
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] r8, FileDescriptor[] r10) {
            DescriptorProtos.FileDescriptorProto r11 = DescriptorProtos.FileDescriptorProto.parseFrom(latin1Cat(r8));     // Catch: InvalidProtocolBufferException -> L10
            return buildFrom(r11, r10, true, true);
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r11.getName() + "\".", e);
        L10:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        private static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r8, FileDescriptor[] r10, boolean r11, boolean r12) {
            FileDescriptor r13 = new FileDescriptor(r8, r10, new FileDescriptorTables(r10, r11), r11);
            r13.crossLink();
            if (r12 == true) goto L5;
            r13.resolveAllFeaturesInternal();
        L5:
            return r13;
        }

        @Deprecated
        public static void internalBuildGeneratedFileFrom(String[] r8, FileDescriptor[] r10, InternalDescriptorAssigner r11) {
            DescriptorProtos.FileDescriptorProto r12 = DescriptorProtos.FileDescriptorProto.parseFrom(latin1Cat(r8));     // Catch: InvalidProtocolBufferException -> L14
            if (r11.assignDescriptors(buildFrom(r12, r10, true)) != null) goto L10;
            return;
        L10:
            throw new RuntimeException("assignDescriptors must return null");
        L11:
            e = move-exception;
            throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r12.getName() + "\".", e);
        L14:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        public FileDescriptor(String r8, Descriptor r10) {
            super(null);
            FileDescriptorTables r11 = new FileDescriptorTables(new FileDescriptor[0], true);
            this.tables = r11;
            this.proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(r10.getFullName() + ".placeholder.proto").setPackage(r8).addMessageType(r10.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.featuresResolved = false;
            this.messageTypes = new Descriptor[]{r10};
            this.enumTypes = Descriptors.access$500();
            this.services = Descriptors.access$700();
            this.extensions = Descriptors.access$900();
            this.placeholder = true;
            r11.addPackage(r8, this);
            r11.addSymbol(r10);
        }
    }

    public static final class FileDescriptorTables {
        private final boolean allowUnknownDependencies;
        private final Set<FileDescriptor> dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName;

        public static final class PackageDescriptor extends GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            public PackageDescriptor(String r8, String r10, FileDescriptor r11) {
                super(null);
                this.file = r11;
                this.fullName = r10;
                this.name = r8;
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
            public GenericDescriptor getParent() {
                return this.file;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }
        }

        public static final enum SearchFilter extends java.lang.Enum<SearchFilter> {
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

            private SearchFilter(String r8, int r10) {
                super(r8, r10);
            }

            public static SearchFilter valueOf(String r8) {
                return (SearchFilter) java.lang.Enum.valueOf(SearchFilter.class, r8);
            }

            public static SearchFilter[] values() {
                return (SearchFilter[]) $VALUES.clone();
            }
        }

        public FileDescriptorTables(FileDescriptor[] r8, boolean r10) {
            this.descriptorsByName = new HashMap();
            this.dependencies = Collections.newSetFromMap(new IdentityHashMap(r8.length));
            this.allowUnknownDependencies = r10;
            int r11 = r8.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            FileDescriptor r13 = r8[r12];
            this.dependencies.add(r13);
            importPublicDependencies(r13);
            r12 = r12 + 1;
            goto L3
        L5:
            Iterator<FileDescriptor> r14 = this.dependencies.iterator();
        L7:
            if (r14.hasNext() == false) goto L14;
            FileDescriptor r15 = r14.next();
            addPackage(r15.getPackage(), r15);     // Catch: DescriptorValidationException -> L11
        L11:
            e = move-exception;
            throw new AssertionError(e);
        }

        private void importPublicDependencies(FileDescriptor r8) {
            Iterator<FileDescriptor> r10 = r8.getPublicDependencies().iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            FileDescriptor r11 = r10.next();
            if (this.dependencies.add(r11) == false) goto L4;
            importPublicDependencies(r11);
            goto L4
        }

        public static void validateSymbolName(GenericDescriptor r8) {
            String r10 = r8.getName();
            AnonymousClass1 r11 = null;
            if (r10.length() == 0) goto L28;
            int r12 = 0;
        L6:
            if (r12 >= r10.length()) goto L26;
            char r13 = r10.charAt(r12);
            if ('a' > r13) goto L12;
            if (r13 > 'z') goto L12;
        L25:
            r12 = r12 + 1;
        L12:
            if ('A' > r13) goto L16;
            if (r13 <= 'Z') goto L25;
        L16:
            if (r13 == '_') goto L25;
            if ('0' > r13) goto L24;
            if (r13 > '9') goto L24;
            if (r12 > 0) goto L25;
        L24:
            throw new DescriptorValidationException(r8, defpackage.b.d("\"", r10, "\" is not a valid identifier."), r11);
        L26:
            return;
        L28:
            throw new DescriptorValidationException(r8, "Missing name.", r11);
        }

        public void addPackage(String r8, FileDescriptor r10) {
            int r11 = r8.lastIndexOf(46);
            if (r11 != (-1)) goto L5;
            String r12 = r8;
        L6:
            GenericDescriptor r13 = this.descriptorsByName.put(r8, new PackageDescriptor(r12, r8, r10));
            if (r13 == null) goto L13;
            this.descriptorsByName.put(r8, r13);
            if ((r13 instanceof PackageDescriptor) == true) goto L14;
            StringBuilder r14 = defpackage.b.h("\"", r12, "\" is already defined (as something other than a package) in file \"");
            r14.append(r13.getFile().getName());
            r14.append("\".");
            throw new DescriptorValidationException(r10, r14.toString(), null);
        L14:
            return;
        L13:
            return;
        L5:
            addPackage(r8.substring(0, r11), r10);
            r12 = r8.substring(r11 + 1);
            goto L6
        }

        public void addSymbol(GenericDescriptor r8) {
            validateSymbolName(r8);
            String r10 = r8.getFullName();
            GenericDescriptor r11 = this.descriptorsByName.put(r10, r8);
            if (r11 == null) goto L14;
            this.descriptorsByName.put(r10, r11);
            AnonymousClass1 r12 = null;
            if (r8.getFile() != r11.getFile()) goto L12;
            int r13 = r10.lastIndexOf(46);
            if (r13 != (-1)) goto L11;
            throw new DescriptorValidationException(r8, defpackage.b.d("\"", r10, "\" is already defined."), r12);
        L11:
            throw new DescriptorValidationException(r8, "\"" + r10.substring(r13 + 1) + "\" is already defined in \"" + r10.substring(0, r13) + "\".", r12);
        L12:
            StringBuilder r14 = defpackage.b.h("\"", r10, "\" is already defined in file \"");
            r14.append(r11.getFile().getName());
            r14.append("\".");
            throw new DescriptorValidationException(r8, r14.toString(), r12);
        }

        public GenericDescriptor findSymbol(String r8) {
            return findSymbol(r8, SearchFilter.ALL_SYMBOLS);
        }

        public boolean isAggregate(GenericDescriptor r8) {
            if ((r8 instanceof Descriptor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r8 instanceof EnumDescriptor) == true) goto L12;
            if ((r8 instanceof PackageDescriptor) == true) goto L12;
            if ((r8 instanceof ServiceDescriptor) == true) goto L12;
            return false;
        }

        public boolean isType(GenericDescriptor r8) {
            if ((r8 instanceof Descriptor) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r8 instanceof EnumDescriptor) == true) goto L8;
            return false;
        }

        public GenericDescriptor lookupSymbol(String r10, GenericDescriptor r11, SearchFilter r12) {
            if (r10.startsWith(".") == false) goto L5;
            String r8 = r10.substring(1);
            GenericDescriptor r13 = findSymbol(r8, r12);
        L19:
            if (r13 == null) goto L21;
            return r13;
        L21:
            if (this.allowUnknownDependencies == false) goto L27;
            if (r12 != SearchFilter.TYPES_ONLY) goto L27;
            Descriptors.access$000().warning("The descriptor for message type \"" + r10 + "\" cannot be found and a placeholder is created for it");
            Descriptor r14 = new Descriptor(r8);
            this.dependencies.add(r14.getFile());
            return r14;
        L27:
            throw new DescriptorValidationException(r11, defpackage.b.d("\"", r10, "\" is not defined."), null);
        L5:
            int r15 = r10.indexOf(46);
            if (r15 != (-1)) goto L8;
            String r16 = r10;
        L9:
            StringBuilder r17 = new StringBuilder(r11.getFullName());
        L10:
            int r18 = r17.lastIndexOf(".");
            if (r18 == (-1)) goto L12;
            int r19 = r18 + 1;
            r17.setLength(r19);
            r17.append(r16);
            GenericDescriptor r20 = findSymbol(r17.toString(), SearchFilter.AGGREGATES_ONLY);
            if (r20 != null) goto L15;
            r17.setLength(r18);
            goto L10
        L15:
            if (r15 == (-1)) goto L17;
            r17.setLength(r19);
            r17.append(r10);
            r13 = findSymbol(r17.toString(), r12);
        L18:
            r8 = r17.toString();
            goto L19
        L17:
            r13 = r20;
            goto L18
        L12:
            r13 = findSymbol(r10, r12);
            r8 = r10;
            goto L19
        L8:
            r16 = r10.substring(0, r15);
            goto L9
        }

        public GenericDescriptor findSymbol(String r8, SearchFilter r10) {
            GenericDescriptor r11 = this.descriptorsByName.get(r8);
            if (r11 != null) goto L5;
        L15:
            Iterator<FileDescriptor> r12 = this.dependencies.iterator();
        L17:
            if (r12.hasNext() == false) goto L31;
            GenericDescriptor r13 = FileDescriptor.access$2200(r12.next()).descriptorsByName.get(r8);
            if (r13 == null) goto L17;
            if (r10 == SearchFilter.ALL_SYMBOLS) goto L30;
            if (r10 != SearchFilter.TYPES_ONLY) goto L27;
            if (isType(r13) == true) goto L30;
        L27:
            if (r10 != SearchFilter.AGGREGATES_ONLY) goto L17;
            if (isAggregate(r13) == false) goto L17;
        L30:
            return r13;
        L31:
            return null;
        L5:
            if (r10 != SearchFilter.ALL_SYMBOLS) goto L7;
        L14:
            return r11;
        L7:
            if (r10 != SearchFilter.TYPES_ONLY) goto L11;
            if (isType(r11) == true) goto L14;
        L11:
            if (r10 != SearchFilter.AGGREGATES_ONLY) goto L15;
            if (isAggregate(r11) == false) goto L15;
            goto L14
        }
    }

    public static abstract class GenericDescriptor {
        volatile DescriptorProtos.FeatureSet features;

        private GenericDescriptor() {
        }

        public /* synthetic */ GenericDescriptor(AnonymousClass1 r8) {
            this();
        }

        public DescriptorProtos.FeatureSet getFeatures() {
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

        public abstract GenericDescriptor getParent();

        public DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        }

        public void resolveFeatures(DescriptorProtos.FeatureSet r11) {
            GenericDescriptor r8 = getParent();
            AnonymousClass1 r10 = null;
            if (r8 != null) goto L5;
        L11:
            DescriptorProtos.FeatureSet r12 = null;
        L12:
            Iterator<FieldDescriptor> r13 = r11.getExtensionFields().keySet().iterator();
        L13:
            boolean r14 = true;
            if (r13.hasNext() == false) goto L20;
            FieldDescriptor r15 = r13.next();
            int r16 = r15.getNumber();
            GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeaturesProto.JavaFeatures> r17 = JavaFeaturesProto.java_;
            if (r16 != r17.getNumber()) goto L13;
            if (r15 == r17.getDescriptor()) goto L13;
            boolean r18 = true;
        L22:
            if (r11.getUnknownFields().isEmpty() == false) goto L24;
        L26:
            r14 = false;
        L27:
            if (r18 == true) goto L29;
            if (r14 == true) goto L29;
        L31:
            if (r8 != null) goto L33;
            DescriptorProtos.FeatureSet r19 = Descriptors.getEditionDefaults(getFile().getEdition());
        L34:
            DescriptorProtos.FeatureSet.Builder r20 = r19.toBuilder();
            if (r12 != null) goto L37;
            r12 = inferLegacyProtoFeatures();
        L37:
            r20.mergeFrom(r12);
            r20.mergeFrom(r11);
            DescriptorProtos.FeatureSet r110 = Descriptors.access$5100(r20.build());
        L9:
            this.features = r110;
            validateFeatures();
            return;
        L33:
            r19 = r8.features;
        L29:
            ExtensionRegistry r21 = ExtensionRegistry.newInstance();
            r21.add(JavaFeaturesProto.java_);
            r11 = DescriptorProtos.FeatureSet.parseFrom(r11.toByteString(), r21);     // Catch: InvalidProtocolBufferException -> L38
        L38:
            e = move-exception;
            throw new DescriptorValidationException(this, "Failed to parse features with Java feature extension registry.", e, r10);
        L24:
            if (r11.getUnknownFields().hasField(JavaFeaturesProto.java_.getNumber()) == false) goto L26;
        L20:
            r18 = false;
            goto L22
        L5:
            if (r11.equals(DescriptorProtos.FeatureSet.getDefaultInstance()) == false) goto L11;
            r12 = inferLegacyProtoFeatures();
            if (r12.equals(DescriptorProtos.FeatureSet.getDefaultInstance()) == false) goto L12;
            r110 = r8.features;
            goto L9
        }

        public abstract Message toProto();

        public void validateFeatures() {
        }
    }

    public static final class MethodDescriptor extends GenericDescriptor {
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private volatile DescriptorProtos.MethodOptions options;
        private Descriptor outputType;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto r8, ServiceDescriptor r10, int r11) {
            super(null);
            this.index = r11;
            this.proto = r8;
            this.service = r10;
            this.fullName = r10.getFullName() + '.' + r8.getName();
            FileDescriptor.access$2200(ServiceDescriptor.access$5000(r10)).addSymbol(this);
        }

        public static /* synthetic */ void access$4700(MethodDescriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$4800(MethodDescriptor r8) {
            r8.crossLink();
        }

        public static /* synthetic */ void access$4900(MethodDescriptor r8, DescriptorProtos.MethodDescriptorProto r10) {
            r8.setProto(r10);
        }

        private void crossLink() {
            FileDescriptorTables r8 = FileDescriptor.access$2200(getFile());
            String r10 = this.proto.getInputType();
            FileDescriptorTables.SearchFilter r11 = FileDescriptorTables.SearchFilter.TYPES_ONLY;
            GenericDescriptor r12 = r8.lookupSymbol(r10, this, r11);
            AnonymousClass1 r13 = null;
            if ((r12 instanceof Descriptor) == false) goto L11;
            this.inputType = (Descriptor) r12;
            GenericDescriptor r14 = FileDescriptor.access$2200(getFile()).lookupSymbol(this.proto.getOutputType(), this, r11);
            if ((r14 instanceof Descriptor) == false) goto L9;
            this.outputType = (Descriptor) r14;
            return;
        L9:
            throw new DescriptorValidationException(this, "\"" + this.proto.getOutputType() + "\" is not a message type.", r13);
        L11:
            throw new DescriptorValidationException(this, "\"" + this.proto.getInputType() + "\" is not a message type.", r13);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.MethodDescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return ServiceDescriptor.access$5000(this.service);
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
            DescriptorProtos.MethodOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.service;
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

        public /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto r8, ServiceDescriptor r10, int r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }
    }

    public static final class OneofDescriptor extends GenericDescriptor {
        private final Descriptor containingType;
        private int fieldCount;
        private FieldDescriptor[] fields;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.OneofOptions options;
        private DescriptorProtos.OneofDescriptorProto proto;

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto r8, Descriptor r10, int r11) {
            super(null);
            this.proto = r8;
            this.fullName = Descriptors.access$2600(null, r10, r8.getName());
            this.index = r11;
            this.containingType = r10;
            this.fieldCount = 0;
        }

        public static /* synthetic */ FieldDescriptor[] access$2800(OneofDescriptor r8) {
            return r8.fields;
        }

        public static /* synthetic */ FieldDescriptor[] access$2802(OneofDescriptor r8, FieldDescriptor[] r10) {
            r8.fields = r10;
            return r10;
        }

        public static /* synthetic */ int access$2902(OneofDescriptor r8, int r10) {
            r8.fieldCount = r10;
            return r10;
        }

        public static /* synthetic */ int access$2908(OneofDescriptor r8) {
            int r10 = r8.fieldCount;
            r8.fieldCount = r10 + 1;
            return r10;
        }

        public static /* synthetic */ void access$3200(OneofDescriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$3300(OneofDescriptor r8, DescriptorProtos.OneofDescriptorProto r10) {
            r8.setProto(r10);
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
        }

        private void setProto(DescriptorProtos.OneofDescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public FieldDescriptor getField(int r8) {
            return this.fields[r8];
        }

        public int getFieldCount() {
            return this.fieldCount;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.containingType.getFile();
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
            DescriptorProtos.OneofOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.containingType;
        }

        public boolean isSynthetic() {
            FieldDescriptor[] r8 = this.fields;
            if (r8.length == 1) goto L5;
            return false;
        L5:
            if (FieldDescriptor.access$5200(r8[0]) == true) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.OneofDescriptorProto toProto() {
            return this.proto;
        }

        public /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto r8, Descriptor r10, int r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
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

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r8, FileDescriptor r10, int r11) {
            AnonymousClass1 r12 = null;
            super(r12);
            this.index = r11;
            this.proto = r8;
            this.fullName = Descriptors.access$2600(r10, null, r8.getName());
            this.file = r10;
            this.methods = new MethodDescriptor[r8.getMethodCount()];
            int r13 = 0;
        L4:
            if (r13 >= r8.getMethodCount()) goto L6;
            this.methods[r13] = new MethodDescriptor(r8.getMethod(r13), this, r13, r12);
            r13 = r13 + 1;
            goto L4
        L6:
            FileDescriptor.access$2200(r10).addSymbol(this);
        }

        public static /* synthetic */ void access$1300(ServiceDescriptor r8) {
            r8.resolveAllFeatures();
        }

        public static /* synthetic */ void access$1600(ServiceDescriptor r8) {
            r8.crossLink();
        }

        public static /* synthetic */ void access$2000(ServiceDescriptor r8, DescriptorProtos.ServiceDescriptorProto r10) {
            r8.setProto(r10);
        }

        public static /* synthetic */ FileDescriptor access$5000(ServiceDescriptor r8) {
            return r8.file;
        }

        private void crossLink() {
            MethodDescriptor[] r8 = this.methods;
            int r10 = r8.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            MethodDescriptor.access$4800(r8[r11]);
            r11 = r11 + 1;
            goto L3
        }

        private void resolveAllFeatures() {
            resolveFeatures(this.proto.getOptions().getFeatures());
            MethodDescriptor[] r8 = this.methods;
            int r10 = r8.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            MethodDescriptor.access$4700(r8[r11]);
            r11 = r11 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.ServiceDescriptorProto r8) {
            this.proto = r8;
            this.options = null;
            resolveFeatures(r8.getOptions().getFeatures());
            int r10 = 0;
        L3:
            MethodDescriptor[] r11 = this.methods;
            if (r10 >= r11.length) goto L6;
            MethodDescriptor.access$4900(r11[r10], r8.getMethod(r10));
            r10 = r10 + 1;
            goto L3
        }

        public MethodDescriptor findMethodByName(String r8) {
            GenericDescriptor r10 = FileDescriptor.access$2200(this.file).findSymbol(this.fullName + '.' + r8);
            if ((r10 instanceof MethodDescriptor) == true) goto L5;
            return null;
        L5:
            return (MethodDescriptor) r10;
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

        public MethodDescriptor getMethod(int r8) {
            return this.methods[r8];
        }

        public int getMethodCount() {
            return this.methods.length;
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
            DescriptorProtos.ServiceOptions r8 = this.proto.getOptions();
            if (r8.hasFeatures() == false) goto L7;
            r8 = r8.toBuilder().clearFeatures().build();
        L7:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.options != null) goto L11;
            this.options = r8;     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.options;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public GenericDescriptor getParent() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }

        public /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r8, FileDescriptor r10, int r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
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

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    public static /* synthetic */ Object access$2400(Object[] r8, int r10, ToIntFunction r11, int r12) {
        return binarySearch(r8, r10, r11, r12);
    }

    public static /* synthetic */ OneofDescriptor[] access$2500() {
        return EMPTY_ONEOF_DESCRIPTORS;
    }

    public static /* synthetic */ String access$2600(FileDescriptor r8, Descriptor r10, String r11) {
        return computeFullName(r8, r10, r11);
    }

    public static /* synthetic */ Descriptor[] access$300() {
        return EMPTY_DESCRIPTORS;
    }

    public static /* synthetic */ int[] access$3100() {
        return EMPTY_INT_ARRAY;
    }

    public static /* synthetic */ EnumDescriptor[] access$500() {
        return EMPTY_ENUM_DESCRIPTORS;
    }

    public static /* synthetic */ DescriptorProtos.FeatureSet access$5100(DescriptorProtos.FeatureSet r8) {
        return internFeatures(r8);
    }

    public static /* synthetic */ ServiceDescriptor[] access$700() {
        return EMPTY_SERVICE_DESCRIPTORS;
    }

    public static /* synthetic */ FieldDescriptor[] access$900() {
        return EMPTY_FIELD_DESCRIPTORS;
    }

    private static <T> T binarySearch(T[] r8, int r10, ToIntFunction<T> r11, int r12) {
        int r13 = r10 - 1;
        int r14 = 0;
    L3:
        if (r14 > r13) goto L10;
        int r15 = (r14 + r13) / 2;
        T r16 = r8[r15];
        int r17 = r11.applyAsInt(r16);
        if (r12 < r17) goto L6;
        if (r12 <= r17) goto L9;
        r14 = r15 + 1;
        goto L3
    L9:
        return r16;
    L6:
        r13 = r15 - 1;
        goto L3
    L10:
        return null;
    }

    private static String computeFullName(FileDescriptor r8, Descriptor r10, String r11) {
        if (r10 != null) goto L5;
        String r12 = r8.getPackage();
        if (r12.isEmpty() == false) goto L9;
        return r11;
    L9:
        return r12 + '.' + r11;
    L5:
        return r10.getFullName() + '.' + r11;
    }

    public static DescriptorProtos.FeatureSet getEditionDefaults(DescriptorProtos.Edition r8) {
        DescriptorProtos.FeatureSetDefaults r10 = getJavaEditionDefaults();
        if (r8.getNumber() < r10.getMinimumEdition().getNumber()) goto L24;
        if (r8.getNumber() > r10.getMaximumEdition().getNumber()) goto L7;
    L11:
        Iterator<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault> r11 = r10.getDefaultsList().iterator();
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault r12 = null;
    L13:
        if (r11.hasNext() == false) goto L18;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault r13 = r11.next();
        if (r13.getEdition().getNumber() > r8.getNumber()) goto L18;
        r12 = r13;
    L18:
        if (r12 == null) goto L22;
        return r12.getFixedFeatures().toBuilder().mergeFrom(r12.getOverridableFeatures()).build();
    L22:
        throw new IllegalArgumentException("Edition " + r8 + " does not have a valid default FeatureSet!");
    L7:
        if (r8 == DescriptorProtos.Edition.EDITION_UNSTABLE) goto L11;
        throw new IllegalArgumentException("Edition " + r8 + " is greater than the maximum supported edition " + r10.getMaximumEdition() + "!");
    L24:
        throw new IllegalArgumentException("Edition " + r8 + " is lower than the minimum supported edition " + r10.getMinimumEdition() + "!");
    }

    public static DescriptorProtos.FeatureSetDefaults getJavaEditionDefaults() {
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
        ExtensionRegistry r8 = ExtensionRegistry.newInstance();     // Catch: Exception -> L10 Throwable -> L15
        r8.add(JavaFeaturesProto.java_);     // Catch: Exception -> L10 Throwable -> L15
        setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults.parseFrom(JavaEditionDefaults.PROTOBUF_INTERNAL_JAVA_EDITION_DEFAULTS.getBytes(Internal.ISO_8859_1), r8));     // Catch: Exception -> L10 Throwable -> L15
    L10:
        e = move-exception;
        throw new AssertionError(e);     // Catch: Throwable -> L15
    L19:
        return javaEditionDefaults;
    }

    private static DescriptorProtos.FeatureSet internFeatures(DescriptorProtos.FeatureSet r8) {
        DescriptorProtos.FeatureSet r10 = FEATURE_CACHE.putIfAbsent(r8, r8);
        if (r10 != null) goto L5;
        return r8;
    L5:
        return r10;
    }

    public static void setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults r8) {
        javaEditionDefaults = r8;
    }
}
