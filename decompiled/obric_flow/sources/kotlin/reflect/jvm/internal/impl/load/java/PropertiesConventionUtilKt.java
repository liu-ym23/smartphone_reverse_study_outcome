package kotlin.reflect.jvm.internal.impl.load.java;

import ai.j0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\npropertiesConventionUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 propertiesConventionUtil.kt\norg/jetbrains/kotlin/load/java/PropertiesConventionUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n766#2:103\n857#2,2:104\n*S KotlinDebug\n*F\n+ 1 propertiesConventionUtil.kt\norg/jetbrains/kotlin/load/java/PropertiesConventionUtilKt\n*L\n90#1:103\n90#1:104,2\n*E\n"})
public final class PropertiesConventionUtilKt {
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        String r10 = r5.asString();
        if (JvmAbi.isGetterName(r10) == false) goto L7;
        return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(r5));
    L7:
        if (JvmAbi.isSetterName(r10) == false) goto L11;
        return propertyNamesBySetMethodName(r5);
    L11:
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(r5);
    }

    public static final Name propertyNameByGetMethodName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Name r5 = propertyNameFromAccessorMethodName$default(r10, "get", false, null, 12, null);
        if (r5 == null) goto L5;
        return r5;
    L5:
        return propertyNameFromAccessorMethodName$default(r10, "is", false, null, 8, null);
    }

    public static final Name propertyNameBySetMethodName(Name r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        if (r11 == false) goto L6;
        String r12 = "is";
    L8:
        return propertyNameFromAccessorMethodName$default(r10, "set", false, r12, 4, null);
    L6:
        r12 = null;
        goto L8
    }

    private static final Name propertyNameFromAccessorMethodName(Name r5, String r10, boolean r11, String r12) {
        if (r5.isSpecial() == false) goto L5;
        return null;
    L5:
        String r13 = r5.getIdentifier();
        if (StringsKt.P(r13, r10) == true) goto L9;
        return null;
    L9:
        if (r13.length() != r10.length()) goto L11;
        return null;
    L11:
        char r14 = r13.charAt(r10.length());
        if ('a' <= r14) goto L14;
    L16:
        if (r12 == null) goto L19;
        StringBuilder r15 = j0.u(r12);
        r15.append(StringsKt.A(r13, r10));
        return Name.identifier(r15.toString());
    L19:
        if (r11 == true) goto L21;
        return r5;
    L21:
        String r16 = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.A(r13, r10), true);
        if (Name.isValidIdentifier(r16) == true) goto L25;
        return null;
    L25:
        return Name.identifier(r16);
    L14:
        if (r14 >= '{') goto L16;
        return null;
    }

    public static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name r5, String r10, boolean r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r12 = null;
    L9:
        return propertyNameFromAccessorMethodName(r5, r10, r11, r12);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return CollectionsKt.listOfNotNull(new Name[]{propertyNameBySetMethodName(r5, false), propertyNameBySetMethodName(r5, true)});
    }
}
