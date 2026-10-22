package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SpecialNames {

    @JvmField
    public static final Name ANONYMOUS = null;

    @JvmField
    public static final Name ARRAY = null;

    @JvmField
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT = null;

    @JvmField
    public static final Name DESTRUCT = null;

    @JvmField
    public static final Name IMPLICIT_SET_PARAMETER = null;

    @JvmField
    public static final Name INIT = null;
    public static final SpecialNames INSTANCE = null;

    @JvmField
    public static final Name ITERATOR = null;

    @JvmField
    public static final Name LOCAL = null;

    @JvmField
    public static final Name NO_NAME_PROVIDED = null;

    @JvmField
    public static final Name RECEIVER = null;

    @JvmField
    public static final Name ROOT_PACKAGE = null;

    @JvmField
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME = null;

    @JvmField
    public static final Name THIS = null;

    @JvmField
    public static final Name UNARY = null;

    @JvmField
    public static final Name UNARY_RESULT = null;

    @JvmField
    public static final Name UNDERSCORE_FOR_UNUSED_VAR = null;

    static {
        INSTANCE = new SpecialNames();
        Name r10 = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(r10, "special(\"<no name provided>\")");
        NO_NAME_PROVIDED = r10;
        Name r11 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(r11, "special(\"<root package>\")");
        ROOT_PACKAGE = r11;
        Name r12 = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(r12, "identifier(\"Companion\")");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = r12;
        Name r13 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        SAFE_IDENTIFIER_FOR_NO_NAME = r13;
        Name r14 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(r14, "special(ANONYMOUS_STRING)");
        ANONYMOUS = r14;
        Name r15 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(r15, "special(\"<unary>\")");
        UNARY = r15;
        Name r16 = Name.special("<unary-result>");
        Intrinsics.checkNotNullExpressionValue(r16, "special(\"<unary-result>\")");
        UNARY_RESULT = r16;
        Name r17 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(r17, "special(\"<this>\")");
        THIS = r17;
        Name r18 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(r18, "special(\"<init>\")");
        INIT = r18;
        Name r19 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(r19, "special(\"<iterator>\")");
        ITERATOR = r19;
        Name r20 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(r20, "special(\"<destruct>\")");
        DESTRUCT = r20;
        Name r21 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(r21, "special(\"<local>\")");
        LOCAL = r21;
        Name r22 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(r22, "special(\"<unused var>\")");
        UNDERSCORE_FOR_UNUSED_VAR = r22;
        Name r23 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(r23, "special(\"<set-?>\")");
        IMPLICIT_SET_PARAMETER = r23;
        Name r24 = Name.special("<array>");
        Intrinsics.checkNotNullExpressionValue(r24, "special(\"<array>\")");
        ARRAY = r24;
        Name r25 = Name.special("<receiver>");
        Intrinsics.checkNotNullExpressionValue(r25, "special(\"<receiver>\")");
        RECEIVER = r25;
    }

    private SpecialNames() {
    }

    @JvmStatic
    public static final Name safeIdentifier(Name r10) {
        if (r10 == null) goto L7;
        if (r10.isSpecial() == true) goto L7;
        return r10;
    L7:
        return SAFE_IDENTIFIER_FOR_NO_NAME;
    }

    public final boolean isSafeIdentifier(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        String r11 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r11, "name.asString()");
        if (r11.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L11;
        if (r10.isSpecial() == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r12 = false;
        goto L6
    }
}
