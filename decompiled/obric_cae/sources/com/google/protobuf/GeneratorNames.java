package com.google.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class GeneratorNames {

    /* JADX INFO: renamed from: com.google.protobuf.GeneratorNames$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaFeaturesProto$JavaFeatures$NestInFileClassFeature$NestInFileClass = null;

        static {
            int[] r8 = new int[JavaFeaturesProto.JavaFeatures.NestInFileClassFeature.NestInFileClass.values().length];
            $SwitchMap$com$google$protobuf$JavaFeaturesProto$JavaFeatures$NestInFileClassFeature$NestInFileClass = r8;
            r8[JavaFeaturesProto.JavaFeatures.NestInFileClassFeature.NestInFileClass.YES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$JavaFeaturesProto$JavaFeatures$NestInFileClassFeature$NestInFileClass[JavaFeaturesProto.JavaFeatures.NestInFileClassFeature.NestInFileClass.NO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$JavaFeaturesProto$JavaFeatures$NestInFileClassFeature$NestInFileClass[JavaFeaturesProto.JavaFeatures.NestInFileClassFeature.NestInFileClass.LEGACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private GeneratorNames() {
    }

    public static String getBytecodeClassName(Descriptors.Descriptor r8) {
        return getClassFullName(getClassNameWithoutPackage(r8), r8.getFile(), !getNestInFileClass(r8));
    }

    private static String getClassFullName(String r8, Descriptors.FileDescriptor r10, boolean r11) {
        StringBuilder r12 = new StringBuilder();
        if (r11 == false) goto L7;
        r12.append(getFileJavaPackage(r10.toProto()));
        if (r12.length() <= 0) goto L11;
        String r13 = ".";
    L10:
        r12.append(r13);
    L11:
        r12.append(r8.replace('.', '$'));
        return r12.toString();
    L7:
        r12.append(joinPackage(getFileJavaPackage(r10.toProto()), getFileClassName(r10)));
        if (r12.length() <= 0) goto L11;
        r13 = "$";
        goto L10
    }

    public static String getClassNameWithoutPackage(Descriptors.Descriptor r8) {
        return stripPackageName(r8.getFullName(), r8.getFile());
    }

    public static String getDefaultFileClassName(DescriptorProtos.FileDescriptorProtoOrBuilder r8, boolean r10) {
        String r11 = r8.getName();
        String r12 = underscoresToCamelCase(stripProto(r11.substring(r11.lastIndexOf(47) + 1)));
        if (r10 == false) goto L6;
        return r12;
    L6:
        return defpackage.a.e(r12, "Proto");
    }

    public static String getDefaultJavaPackage(DescriptorProtos.FileOptions r8, String r10) {
        if (r8.hasJavaPackage() == true) goto L5;
        return r10;
    L5:
        return r8.getJavaPackage();
    }

    public static String getFileClassName(DescriptorProtos.FileDescriptorProtoOrBuilder r8) {
        return getFileClassNameImpl(r8, (JavaFeaturesProto.JavaFeatures) getResolvedFileFeatures(JavaFeaturesProto.java_, r8));
    }

    private static String getFileClassNameImpl(DescriptorProtos.FileDescriptorProtoOrBuilder r8, JavaFeaturesProto.JavaFeatures r10) {
        if (r8.getOptions().hasJavaOuterClassname() == true) goto L5;
        String r11 = getDefaultFileClassName(r8, r10.getUseOldOuterClassnameDefault());
        if (r10.getUseOldOuterClassnameDefault() == true) goto L9;
    L12:
        return r11;
    L9:
        if (hasConflictingClassName(r8, r11) == false) goto L12;
        return defpackage.a.e(r11, "OuterClass");
    L5:
        return r8.getOptions().getJavaOuterClassname();
    }

    public static String getFileJavaPackage(DescriptorProtos.FileDescriptorProtoOrBuilder r8) {
        return getProto2ApiDefaultJavaPackage(r8.getOptions(), r8.getPackage());
    }

    public static boolean getNestInFileClass(Descriptors.Descriptor r8) {
        return getNestInFileClass(r8.getFile(), (JavaFeaturesProto.JavaFeatures) r8.getFeatures().getExtension(JavaFeaturesProto.java_));
    }

    public static String getProto2ApiDefaultJavaPackage(DescriptorProtos.FileOptions r8, String r10) {
        return getDefaultJavaPackage(r8, r10);
    }

    public static String getQualifiedClassName(Descriptors.Descriptor r8) {
        return getQualifiedFromBytecodeClassName(getBytecodeClassName(r8));
    }

    public static String getQualifiedFromBytecodeClassName(String r8) {
        return r8.replace('$', '.');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Message> T getResolvedFileFeatures(GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, T> r8, DescriptorProtos.FileDescriptorProtoOrBuilder r10) {
        if (r10.getSyntax().equals("proto3") == false) goto L6;
        DescriptorProtos.Edition r11 = DescriptorProtos.Edition.EDITION_PROTO3;
    L9:
        DescriptorProtos.FeatureSet r12 = r10.getOptions().getFeatures();
        if (r12.getUnknownFields().hasField(r8.getNumber()) == false) goto L18;
        ExtensionRegistry r13 = ExtensionRegistry.newInstance();
        r13.add(r8);
        r12 = ((DescriptorProtos.FeatureSet.Builder) DescriptorProtos.FeatureSet.newBuilder().mergeFrom(r12.getUnknownFields().toByteString(), r13)).build();     // Catch: InvalidProtocolBufferException -> L14
    L14:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse features", e);
    L18:
        return (T) ((Message) Descriptors.getEditionDefaults(r11).getExtension(r8)).toBuilder().mergeFrom((Message) r12.getExtension(r8)).build();
    L6:
        if (r10.hasEdition() == true) goto L8;
        r11 = DescriptorProtos.Edition.EDITION_PROTO2;
        goto L9
    L8:
        r11 = r10.getEdition();
        goto L9
    }

    private static boolean hasConflictingClassName(DescriptorProtos.DescriptorProto r8, String r10) {
        if (r10.equals(r8.getName()) == false) goto L5;
        return true;
    L5:
        Iterator<DescriptorProtos.EnumDescriptorProto> r11 = r8.getEnumTypeList().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        if (r10.equals(r11.next().getName()) == false) goto L7;
        return true;
    L11:
        Iterator<DescriptorProtos.DescriptorProto> r12 = r8.getNestedTypeList().iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        if (hasConflictingClassName(r12.next(), r10) == false) goto L13;
        return true;
    L17:
        return false;
    }

    public static String joinPackage(String r8, String r10) {
        if (r8.isEmpty() == false) goto L6;
        return r10;
    L6:
        if (r10.isEmpty() == false) goto L9;
        return r8;
    L9:
        return r8 + '.' + r10;
    }

    public static String stripPackageName(String r8, Descriptors.FileDescriptor r10) {
        if (r10.getPackage().isEmpty() == false) goto L6;
        return r8;
    L6:
        return r8.substring(r10.getPackage().length() + 1);
    }

    private static String stripProto(String r8) {
        if (r8.endsWith(".protodevel") == false) goto L8;
        int r10 = r8.length() - 11;
    L6:
        return r8.substring(0, r10);
    L8:
        if (r8.endsWith(".proto") == false) goto L10;
        r10 = r8.length() - 6;
        goto L6
    L10:
        return r8;
    }

    public static String underscoresToCamelCase(String r8) {
        return underscoresToCamelCase(r8, true);
    }

    public static String getBytecodeClassName(Descriptors.EnumDescriptor r8) {
        return getClassFullName(getClassNameWithoutPackage(r8), r8.getFile(), !getNestInFileClass(r8));
    }

    public static String getClassNameWithoutPackage(Descriptors.EnumDescriptor r8) {
        Descriptors.Descriptor r10 = r8.getContainingType();
        if (r10 != null) goto L7;
        return r8.getName();
    L7:
        return joinPackage(getClassNameWithoutPackage(r10), r8.getName());
    }

    public static String getFileClassName(Descriptors.FileDescriptor r8) {
        return getFileClassNameImpl(r8.toProto(), (JavaFeaturesProto.JavaFeatures) r8.getFeatures().getExtension(JavaFeaturesProto.java_));
    }

    public static String getFileJavaPackage(Descriptors.FileDescriptor r8) {
        return getProto2ApiDefaultJavaPackage(r8.getOptions(), r8.getPackage());
    }

    public static boolean getNestInFileClass(Descriptors.EnumDescriptor r8) {
        return getNestInFileClass(r8.getFile(), (JavaFeaturesProto.JavaFeatures) r8.getFeatures().getExtension(JavaFeaturesProto.java_));
    }

    public static String getQualifiedClassName(Descriptors.EnumDescriptor r8) {
        return getQualifiedFromBytecodeClassName(getBytecodeClassName(r8));
    }

    private static boolean hasConflictingClassName(DescriptorProtos.FileDescriptorProtoOrBuilder r8, String r10) {
        Iterator<DescriptorProtos.EnumDescriptorProto> r11 = r8.getEnumTypeList().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r10.equals(r11.next().getName()) == false) goto L4;
        return true;
    L8:
        Iterator<DescriptorProtos.ServiceDescriptorProto> r12 = r8.getServiceList().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        if (r10.equals(r12.next().getName()) == false) goto L10;
        return true;
    L14:
        Iterator<DescriptorProtos.DescriptorProto> r13 = r8.getMessageTypeList().iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        if (hasConflictingClassName(r13.next(), r10) == false) goto L16;
        return true;
    L20:
        return false;
    }

    public static String underscoresToCamelCase(String r8, boolean r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L4:
        if (r12 >= r8.length()) goto L29;
        char r13 = r8.charAt(r12);
        if ('a' > r13) goto L15;
        if (r13 > 'z') goto L15;
        if (r10 == false) goto L12;
        int r14 = r13 - ' ';
    L11:
        r11.append((char) r14);
    L13:
        r10 = false;
    L27:
        r12 = r12 + 1;
    L12:
        r11.append(r13);
    L15:
        if ('A' > r13) goto L22;
        if (r13 > 'Z') goto L22;
        if (r12 != 0) goto L12;
        if (r10 == true) goto L12;
        r14 = r13 + ' ';
    L22:
        if ('0' <= r13) goto L24;
    L26:
        r10 = true;
        goto L27
    L24:
        if (r13 > '9') goto L26;
        r11.append(r13);
        goto L26
    L29:
        return r11.toString();
    }

    public static String getBytecodeClassName(Descriptors.ServiceDescriptor r8) {
        return android.aimedia.a.i(new StringBuilder(), getClassFullName(getClassNameWithoutPackage(r8), r8.getFile(), !getNestInFileClass(r8)), "");
    }

    public static String getClassNameWithoutPackage(Descriptors.ServiceDescriptor r8) {
        return stripPackageName(r8.getFullName(), r8.getFile());
    }

    private static boolean getNestInFileClass(Descriptors.FileDescriptor r8, JavaFeaturesProto.JavaFeatures r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$google$protobuf$JavaFeaturesProto$JavaFeatures$NestInFileClassFeature$NestInFileClass[r10.getNestInFileClass().ordinal()];
        if (r11 != 1) goto L5;
        return true;
    L5:
        if (r11 != 2) goto L7;
        return false;
    L7:
        if (r11 != 3) goto L11;
        return !r8.getOptions().getJavaMultipleFiles();
    L11:
        throw new IllegalArgumentException("Java features are not resolved");
    }

    public static String getQualifiedClassName(Descriptors.ServiceDescriptor r8) {
        return getQualifiedFromBytecodeClassName(getBytecodeClassName(r8));
    }

    private static boolean getNestInFileClass(Descriptors.ServiceDescriptor r8) {
        return getNestInFileClass(r8.getFile(), (JavaFeaturesProto.JavaFeatures) r8.getFeatures().getExtension(JavaFeaturesProto.java_));
    }
}
