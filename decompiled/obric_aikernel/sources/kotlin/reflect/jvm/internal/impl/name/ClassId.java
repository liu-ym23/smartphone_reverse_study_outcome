package kotlin.reflect.jvm.internal.impl.name;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 5) goto L9;
        if (r10 == 6) goto L9;
        if (r10 == 7) goto L9;
        if (r10 == 9) goto L9;
        switch(r10) {
            case 13: goto L9;
            case 14: goto L9;
            case 15: goto L9;
            case 16: goto L9;
            default: goto L8;
        };
    L8:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L11:
        if (r10 == 5) goto L17;
        if (r10 == 6) goto L56;
        if (r10 == 7) goto L57;
        if (r10 == 9) goto L58;
        switch(r10) {
            case 13: goto L59;
            case 14: goto L59;
            case 15: goto L59;
            case 16: goto L59;
            default: goto L16;
        };
    L16:
        int r12 = 3;
    L18:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L24;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L21;
            case 13: goto L24;
            case 14: goto L24;
            case 15: goto L24;
            case 16: goto L24;
            default: goto L20;
        };
    L20:
        r13[0] = "topLevelFqName";
    L29:
        if (r10 == 5) goto L40;
        if (r10 == 6) goto L39;
        if (r10 == 7) goto L38;
        if (r10 == 9) goto L37;
        switch(r10) {
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L35;
            default: goto L34;
        };
    L34:
        r13[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
    L41:
        switch(r10) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L47;
            case 6: goto L47;
            case 7: goto L47;
            case 8: goto L45;
            case 9: goto L47;
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L47;
            case 16: goto L47;
            default: goto L42;
        };
    L42:
        r13[2] = "topLevel";
        goto L47
    L43:
        r13[2] = "fromString";
        goto L47
    L44:
        r13[2] = "startsWith";
        goto L47
    L45:
        r13[2] = "createNestedClassId";
        goto L47
    L46:
        r13[2] = "<init>";
    L47:
        String r14 = String.format(r11, r13);
        if (r10 == 5) goto L55;
        if (r10 == 6) goto L55;
        if (r10 == 7) goto L55;
        if (r10 == 9) goto L55;
        switch(r10) {
            case 13: goto L55;
            case 14: goto L55;
            case 15: goto L55;
            case 16: goto L55;
            default: goto L60;
        };
    L60:
        throw new IllegalArgumentException(r14);
    L55:
        throw new IllegalStateException(r14);
    L35:
        r13[1] = "asFqNameString";
        goto L41
    L36:
        r13[1] = "asString";
        goto L41
    L37:
        r13[1] = "asSingleFqName";
        goto L41
    L38:
        r13[1] = "getShortClassName";
        goto L41
    L39:
        r13[1] = "getRelativeClassName";
        goto L41
    L40:
        r13[1] = "getPackageFqName";
        goto L41
    L21:
        r13[0] = TypedValues.Custom.S_STRING;
        goto L29
    L22:
        r13[0] = "segment";
        goto L29
    L23:
        r13[0] = ActivityLifecycle.NAME;
        goto L29
    L24:
        r13[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        goto L29
    L25:
        r13[0] = "topLevelName";
        goto L29
    L26:
        r13[0] = "relativeClassName";
        goto L29
    L27:
        r13[0] = "packageFqName";
        goto L29
    L59:
        r12 = 2;
        goto L18
    L58:
        r12 = 2;
        goto L18
    L57:
        r12 = 2;
        goto L18
    L56:
        r12 = 2;
        goto L18
    L17:
        r12 = 2;
    L9:
        r11 = "@NotNull method %s.%s must not return null";
        goto L11
    }

    static {
    }

    public ClassId(FqName r10, FqName r11, boolean r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(2);
    L6:
        this.packageFqName = r10;
        this.relativeClassName = r11;
        this.local = r12;
    }

    public ClassId(FqName r10, Name r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        this(r10, FqName.topLevel(r11), false);
    }

    public static ClassId fromString(String r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return fromString(r10, false);
    }

    public static ClassId fromString(String r10, boolean r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        int r12 = r10.lastIndexOf("/");
        if (r12 != (-1)) goto L7;
        String r13 = "";
    L9:
        return new ClassId(new FqName(r13), new FqName(r10), r11);
    L7:
        String r14 = r10.substring(0, r12).replace('/', '.');
        r10 = r10.substring(r12 + 1);
        r13 = r14;
        goto L9
    }

    public static ClassId topLevel(FqName r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new ClassId(r10.parent(), r10.shortName());
    }

    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot() == false) goto L9;
        FqName r10 = this.relativeClassName;
        if (r10 != null) goto L7;
        $$$reportNull$$$0(9);
    L7:
        return r10;
    L9:
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    public String asString() {
        if (this.packageFqName.isRoot() == false) goto L8;
        String r10 = this.relativeClassName.asString();
        if (r10 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r10;
    L8:
        String r11 = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (r11 != null) goto L11;
        $$$reportNull$$$0(14);
    L11:
        return r11;
    }

    public ClassId createNestedClassId(Name r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return new ClassId(getPackageFqName(), this.relativeClassName.child(r10), this.local);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L19:
        return false;
    L8:
        if (ClassId.class != r10.getClass()) goto L19;
        ClassId r11 = (ClassId) r10;
        if (this.packageFqName.equals(r11.packageFqName) == false) goto L18;
        if (this.relativeClassName.equals(r11.relativeClassName) == false) goto L18;
        if (this.local != r11.local) goto L18;
        return true;
    L18:
        return false;
    }

    public ClassId getOuterClassId() {
        FqName r10 = this.relativeClassName.parent();
        if (r10.isRoot() == false) goto L6;
        return null;
    L6:
        return new ClassId(getPackageFqName(), r10, this.local);
    }

    public FqName getPackageFqName() {
        FqName r10 = this.packageFqName;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r10;
    }

    public FqName getRelativeClassName() {
        FqName r10 = this.relativeClassName;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r10;
    }

    public Name getShortClassName() {
        Name r10 = this.relativeClassName.shortName();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r10;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public boolean isLocal() {
        return this.local;
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return "/" + asString();
    L6:
        return asString();
    }
}
