package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmAbi {
    public static final JvmAbi INSTANCE = null;

    @JvmField
    public static final ClassId JVM_FIELD_ANNOTATION_CLASS_ID = null;

    @JvmField
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = null;
    private static final ClassId REFLECTION_FACTORY_IMPL = null;
    private static final ClassId REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = null;

    static {
        INSTANCE = new JvmAbi();
        FqName r5 = new FqName("kotlin.jvm.JvmField");
        JVM_FIELD_ANNOTATION_FQ_NAME = r5;
        JVM_FIELD_ANNOTATION_CLASS_ID = ClassId.topLevel(r5);
        REFLECTION_FACTORY_IMPL = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = ClassId.fromString("kotlin/jvm/internal/RepeatableContainer");
    }

    private JvmAbi() {
    }

    @JvmStatic
    public static final String getterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "propertyName");
        if (startsWithIsPrefix(r5) == false) goto L6;
        return r5;
    L6:
        return "get" + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r5);
    }

    @JvmStatic
    public static final boolean isGetterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (StringsKt.P(r5, "get") == false) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.P(r5, "is") == true) goto L8;
        return false;
    }

    @JvmStatic
    public static final boolean isSetterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return StringsKt.P(r5, "set");
    }

    @JvmStatic
    public static final String setterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "propertyName");
        StringBuilder r10 = new StringBuilder("set");
        if (startsWithIsPrefix(r5) == false) goto L5;
        String r11 = r5.substring(2);
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r11 = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r5);
        goto L6
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (StringsKt.P(r5, "is") == true) goto L6;
        return false;
    L6:
        if (r5.length() != 2) goto L8;
        return false;
    L8:
        char r10 = r5.charAt(2);
        if (Intrinsics.compare(97, r10) <= 0) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.compare(r10, 122) > 0) goto L12;
        return false;
    }

    public final ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }
}
