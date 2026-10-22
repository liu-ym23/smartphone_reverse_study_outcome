package kotlin.reflect.jvm.internal.impl.load.java;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
        FqName r10 = new FqName("kotlin.jvm.JvmField");
        JVM_FIELD_ANNOTATION_FQ_NAME = r10;
        ClassId r11 = ClassId.topLevel(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "topLevel(JVM_FIELD_ANNOTATION_FQ_NAME)");
        JVM_FIELD_ANNOTATION_CLASS_ID = r11;
        ClassId r12 = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        Intrinsics.checkNotNullExpressionValue(r12, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        REFLECTION_FACTORY_IMPL = r12;
        ClassId r13 = ClassId.fromString("kotlin/jvm/internal/RepeatableContainer");
        Intrinsics.checkNotNullExpressionValue(r13, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = r13;
    }

    private JvmAbi() {
    }

    @JvmStatic
    public static final String getterName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "propertyName");
        if (startsWithIsPrefix(r10) == false) goto L6;
        return r10;
    L6:
        return "get" + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r10);
    }

    @JvmStatic
    public static final boolean isGetterName(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        if (StringsKt.startsWith$default(r10, "get", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.startsWith$default(r10, "is", false, 2, null) == true) goto L6;
        return false;
    }

    @JvmStatic
    public static final boolean isSetterName(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return StringsKt.startsWith$default(r10, "set", false, 2, null);
    }

    @JvmStatic
    public static final String setterName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "propertyName");
        StringBuilder r11 = new StringBuilder();
        r11.append("set");
        if (startsWithIsPrefix(r10) == false) goto L5;
        String r12 = r10.substring(2);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");
    L6:
        r11.append(r12);
        return r11.toString();
    L5:
        r12 = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r10);
        goto L6
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        if (StringsKt.startsWith$default(r10, "is", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (r10.length() != 2) goto L8;
        return false;
    L8:
        char r11 = r10.charAt(2);
        if (Intrinsics.compare(97, r11) <= 0) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.compare(r11, 122) > 0) goto L12;
        return false;
    }

    public final ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }
}
