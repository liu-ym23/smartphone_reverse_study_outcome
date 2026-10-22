package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 3) goto L7;
        if (r9 == 5) goto L7;
        switch(r9) {
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            default: goto L6;
        };
    L6:
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 3) goto L13;
        if (r9 == 5) goto L13;
        switch(r9) {
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            default: goto L12;
        };
    L12:
        int r4 = 3;
    L14:
        Object[] r5 = new Object[r4];
        switch(r9) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            default: goto L16;
        };
    L16:
        r5[0] = "internalName";
    L21:
        if (r9 == 3) goto L29;
        if (r9 == 5) goto L28;
        switch(r9) {
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            default: goto L24;
        };
    L24:
        r5[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
    L30:
        switch(r9) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L36;
            case 4: goto L33;
            case 5: goto L36;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            default: goto L31;
        };
    L31:
        r5[2] = "byInternalName";
        goto L36
    L32:
        r5[2] = "<init>";
        goto L36
    L33:
        r5[2] = "byFqNameWithoutInnerClasses";
        goto L36
    L34:
        r5[2] = "internalNameByClassId";
        goto L36
    L35:
        r5[2] = "byClassId";
    L36:
        String r3 = String.format(r2, r5);
        if (r9 == 3) goto L42;
        if (r9 == 5) goto L42;
        switch(r9) {
            case 8: goto L42;
            case 9: goto L42;
            case 10: goto L42;
            default: goto L43;
        };
    L43:
        throw new IllegalArgumentException(r3);
    L42:
        throw new IllegalStateException(r3);
    L25:
        r5[1] = "getInternalName";
        goto L30
    L26:
        r5[1] = "getPackageFqName";
        goto L30
    L27:
        r5[1] = "getFqNameForClassNameWithoutDollars";
        goto L30
    L28:
        r5[1] = "byFqNameWithoutInnerClasses";
        goto L30
    L29:
        r5[1] = "internalNameByClassId";
        goto L30
    L17:
        r5[0] = "fqName";
        goto L21
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        goto L21
    L19:
        r5[0] = "classId";
    L13:
        r4 = 2;
    L7:
        r2 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    public String getInternalName() {
        String r0 = this.internalName;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r0;
    }

    public FqName getPackageFqName() {
        int r0 = this.internalName.lastIndexOf("/");
        if (r0 != (-1)) goto L9;
        FqName r1 = FqName.ROOT;
        if (r1 != null) goto L7;
        $$$reportNull$$$0(9);
    L7:
        return r1;
    L9:
        return new FqName(this.internalName.substring(0, r0).replace('/', '.'));
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }

    private JvmClassName(String r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.internalName = r2;
    }

    public static JvmClassName byClassId(ClassId r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return new JvmClassName(internalNameByClassId(r1));
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName r4) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        JvmClassName r0 = new JvmClassName(r4.asString().replace('.', '/'));
        r0.fqName = r4;
        return r0;
    }

    public static JvmClassName byInternalName(String r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new JvmClassName(r1);
    }

    public static String internalNameByClassId(ClassId r4) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        FqName r0 = r4.getPackageFqName();
        String r5 = r4.getRelativeClassName().asString().replace('.', '$');
        if (r0.isRoot() == true) goto L8;
        r5 = r0.asString().replace('.', '/') + "/" + r5;
    L8:
        if (r5 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        return r5;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return this.internalName.equals(((JvmClassName) r3).internalName);
    }
}
