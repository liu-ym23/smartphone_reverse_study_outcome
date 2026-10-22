package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.builtins;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.WireFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BuiltInsProtoBuf {
    public static final int CLASS_ANNOTATION_FIELD_NUMBER = 150;
    public static final int COMPILE_TIME_VALUE_FIELD_NUMBER = 151;
    public static final int CONSTRUCTOR_ANNOTATION_FIELD_NUMBER = 150;
    public static final int ENUM_ENTRY_ANNOTATION_FIELD_NUMBER = 150;
    public static final int FUNCTION_ANNOTATION_FIELD_NUMBER = 150;
    public static final int PACKAGE_FQ_NAME_FIELD_NUMBER = 151;
    public static final int PARAMETER_ANNOTATION_FIELD_NUMBER = 150;
    public static final int PROPERTY_ANNOTATION_FIELD_NUMBER = 150;
    public static final int PROPERTY_GETTER_ANNOTATION_FIELD_NUMBER = 152;
    public static final int PROPERTY_SETTER_ANNOTATION_FIELD_NUMBER = 153;
    public static final int TYPE_ANNOTATION_FIELD_NUMBER = 150;
    public static final int TYPE_PARAMETER_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = null;

    static {
        packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 151, WireFormat.FieldType.INT32, Integer.class);
        ProtoBuf.Class r5 = ProtoBuf.Class.getDefaultInstance();
        ProtoBuf.Annotation r10 = ProtoBuf.Annotation.getDefaultInstance();
        WireFormat.FieldType r11 = WireFormat.FieldType.MESSAGE;
        classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(r5, r10, null, 150, r11, false, ProtoBuf.Annotation.class);
        constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
        functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
        propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
        propertyGetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 152, r11, false, ProtoBuf.Annotation.class);
        propertySetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 153, r11, false, ProtoBuf.Annotation.class);
        compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), null, 151, r11, ProtoBuf.Annotation.Argument.Value.class);
        enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.EnumEntry.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
        parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.ValueParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r11, false, ProtoBuf.Annotation.class);
    }

    private BuiltInsProtoBuf() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r5) {
        r5.add(packageFqName);
        r5.add(classAnnotation);
        r5.add(constructorAnnotation);
        r5.add(functionAnnotation);
        r5.add(propertyAnnotation);
        r5.add(propertyGetterAnnotation);
        r5.add(propertySetterAnnotation);
        r5.add(compileTimeValue);
        r5.add(enumEntryAnnotation);
        r5.add(parameterAnnotation);
        r5.add(typeAnnotation);
        r5.add(typeParameterAnnotation);
    }
}
