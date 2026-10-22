package kotlin.reflect.jvm.internal.impl.load.java;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class PropertiesConventionUtilKt {
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        String r11 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r11, "name.asString()");
        if (JvmAbi.isGetterName(r11) == false) goto L7;
        return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(r10));
    L7:
        if (JvmAbi.isSetterName(r11) == false) goto L11;
        return propertyNamesBySetMethodName(r10);
    L11:
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(r10);
    }

    public static final Name propertyNameByGetMethodName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Name r11 = propertyNameFromAccessorMethodName$default(r10, "get", false, null, 12, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return propertyNameFromAccessorMethodName$default(r10, "is", false, null, 8, null);
    }

    public static final Name propertyNameBySetMethodName(Name r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        if (r11 == false) goto L5;
        String r12 = "is";
    L7:
        return propertyNameFromAccessorMethodName$default(r10, "set", false, r12, 4, null);
    L5:
        r12 = null;
        goto L7
    }

    private static final Name propertyNameFromAccessorMethodName(Name r10, String r11, boolean r12, String r13) {
        if (r10.isSpecial() == false) goto L5;
        return null;
    L5:
        String r14 = r10.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(r14, "methodName.identifier");
        boolean r15 = false;
        if (StringsKt.startsWith$default(r14, r11, false, 2, null) == true) goto L9;
        return null;
    L9:
        if (r14.length() != r11.length()) goto L11;
        return null;
    L11:
        char r16 = r14.charAt(r11.length());
        if ('a' <= r16) goto L14;
    L16:
        if (r15 == false) goto L18;
        return null;
    L18:
        if (r13 != null) goto L20;
        if (r12 == true) goto L23;
        return r10;
    L23:
        String r17 = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(r14, r11), true);
        if (Name.isValidIdentifier(r17) == true) goto L27;
        return null;
    L27:
        return Name.identifier(r17);
    L20:
        return Name.identifier(r13 + StringsKt.removePrefix(r14, r11));
    L14:
        if (r16 >= '{') goto L16;
        r15 = true;
        goto L16
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name r10, String r11, boolean r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = true;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        return propertyNameFromAccessorMethodName(r10, r11, r12, r13);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        return CollectionsKt.listOfNotNull(new Name[]{propertyNameBySetMethodName(r10, false), propertyNameBySetMethodName(r10, true)});
    }
}
