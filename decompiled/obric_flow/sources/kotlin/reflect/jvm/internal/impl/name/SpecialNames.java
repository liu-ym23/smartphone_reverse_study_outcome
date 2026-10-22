package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSpecialNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialNames.kt\norg/jetbrains/kotlin/name/SpecialNames\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
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
    public static final Name ENUM_GET_ENTRIES = null;

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
        NO_NAME_PROVIDED = Name.special("<no name provided>");
        ROOT_PACKAGE = Name.special("<root package>");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = Name.identifier("Companion");
        SAFE_IDENTIFIER_FOR_NO_NAME = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        ANONYMOUS = Name.special("<anonymous>");
        UNARY = Name.special("<unary>");
        UNARY_RESULT = Name.special("<unary-result>");
        THIS = Name.special("<this>");
        INIT = Name.special("<init>");
        ITERATOR = Name.special("<iterator>");
        DESTRUCT = Name.special("<destruct>");
        LOCAL = Name.special("<local>");
        UNDERSCORE_FOR_UNUSED_VAR = Name.special("<unused var>");
        IMPLICIT_SET_PARAMETER = Name.special("<set-?>");
        ARRAY = Name.special("<array>");
        RECEIVER = Name.special("<receiver>");
        ENUM_GET_ENTRIES = Name.special("<get-entries>");
    }

    private SpecialNames() {
    }

    @JvmStatic
    public static final Name safeIdentifier(Name r5) {
        if (r5 == null) goto L7;
        if (r5.isSpecial() == true) goto L7;
        return r5;
    L7:
        return SAFE_IDENTIFIER_FOR_NO_NAME;
    }

    public final boolean isSafeIdentifier(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (r5.asString().length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r5.isSpecial() == true) goto L7;
        return true;
    }
}
