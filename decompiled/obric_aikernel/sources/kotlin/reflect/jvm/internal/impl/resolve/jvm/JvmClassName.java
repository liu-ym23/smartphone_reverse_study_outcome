package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 3) goto L8;
        if (r10 == 6) goto L8;
        if (r10 == 7) goto L8;
        if (r10 == 8) goto L8;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 3) goto L15;
        if (r10 == 6) goto L15;
        if (r10 == 7) goto L15;
        if (r10 == 8) goto L15;
        int r12 = 3;
    L16:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L19;
            default: goto L18;
        };
    L18:
        r13[0] = "internalName";
    L23:
        if (r10 == 3) goto L31;
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        if (r10 == 8) goto L28;
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
    L32:
        switch(r10) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            default: goto L33;
        };
    L33:
        r13[2] = "byInternalName";
        goto L37
    L34:
        r13[2] = "<init>";
        goto L37
    L35:
        r13[2] = "byFqNameWithoutInnerClasses";
        goto L37
    L36:
        r13[2] = "byClassId";
    L37:
        String r14 = String.format(r11, r13);
        if (r10 == 3) goto L44;
        if (r10 == 6) goto L44;
        if (r10 == 7) goto L44;
        if (r10 == 8) goto L44;
        throw new IllegalArgumentException(r14);
    L44:
        throw new IllegalStateException(r14);
    L28:
        r13[1] = "getInternalName";
        goto L32
    L29:
        r13[1] = "getPackageFqName";
        goto L32
    L30:
        r13[1] = "getFqNameForClassNameWithoutDollars";
        goto L32
    L31:
        r13[1] = "byFqNameWithoutInnerClasses";
        goto L32
    L19:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        goto L23
    L20:
        r13[0] = "fqName";
        goto L23
    L21:
        r13[0] = "classId";
    L15:
        r12 = 2;
    L8:
        r11 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    private JvmClassName(String r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        this.internalName = r10;
    }

    public static JvmClassName byClassId(ClassId r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        FqName r11 = r10.getPackageFqName();
        String r12 = r10.getRelativeClassName().asString().replace('.', Typography.dollar);
        if (r11.isRoot() == false) goto L8;
        return new JvmClassName(r12);
    L8:
        return new JvmClassName(r11.asString().replace('.', '/') + "/" + r12);
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        JvmClassName r11 = new JvmClassName(r10.asString().replace('.', '/'));
        r11.fqName = r10;
        return r11;
    }

    public static JvmClassName byInternalName(String r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new JvmClassName(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (getClass() == r10.getClass()) goto L10;
        return false;
    L10:
        return this.internalName.equals(((JvmClassName) r10).internalName);
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    public String getInternalName() {
        String r10 = this.internalName;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r10;
    }

    public FqName getPackageFqName() {
        int r10 = this.internalName.lastIndexOf("/");
        if (r10 != (-1)) goto L9;
        FqName r11 = FqName.ROOT;
        if (r11 != null) goto L7;
        $$$reportNull$$$0(7);
    L7:
        return r11;
    L9:
        return new FqName(this.internalName.substring(0, r10).replace('/', '.'));
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }
}
