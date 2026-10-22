package kotlin.reflect.jvm.internal.impl.name;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SpecialNames {
    public static final Name ANONYMOUS = null;
    public static final FqName ANONYMOUS_FQ_NAME = null;
    public static final Name ARRAY = null;
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT = null;
    public static final Name DESTRUCT = null;
    public static final Name ENUM_GET_ENTRIES = null;
    public static final Name IMPLICIT_SET_PARAMETER = null;
    public static final Name INIT = null;
    public static final SpecialNames INSTANCE = null;
    public static final Name ITERATOR = null;
    public static final Name LOCAL = null;
    public static final Name NO_NAME_PROVIDED = null;
    public static final Name RECEIVER = null;
    public static final Name ROOT_PACKAGE = null;
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME = null;
    public static final Name THIS = null;
    public static final Name UNARY = null;
    public static final Name UNDERSCORE_FOR_UNUSED_VAR = null;

    private SpecialNames() {
    }

    static {
        INSTANCE = new SpecialNames();
        NO_NAME_PROVIDED = Name.special("<no name provided>");
        ROOT_PACKAGE = Name.special("<root package>");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = Name.identifier("Companion");
        SAFE_IDENTIFIER_FOR_NO_NAME = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        ANONYMOUS = Name.special("<anonymous>");
        ANONYMOUS_FQ_NAME = FqName.topLevel(Name.special("<anonymous>"));
        UNARY = Name.special("<unary>");
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

    @JvmStatic
    public static final Name safeIdentifier(Name r1) {
        if (r1 == null) goto L7;
        if (r1.isSpecial() == true) goto L7;
        return r1;
    L7:
        return SAFE_IDENTIFIER_FOR_NO_NAME;
    }

    public final boolean isSafeIdentifier(Name r4) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        if (r4.asString().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (r4.isSpecial() == true) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
