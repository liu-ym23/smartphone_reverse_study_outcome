package kotlin.reflect.jvm.internal.impl.name;

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
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        int r11 = 3;
    L18:
        Object[] r12 = new Object[r11];
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
        r12[0] = "topLevelFqName";
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
        r12[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
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
        r12[2] = "topLevel";
        goto L47
    L43:
        r12[2] = "fromString";
        goto L47
    L44:
        r12[2] = "startsWith";
        goto L47
    L45:
        r12[2] = "createNestedClassId";
        goto L47
    L46:
        r12[2] = "<init>";
    L47:
        String r13 = String.format(r5, r12);
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
        throw new IllegalArgumentException(r13);
    L55:
        throw new IllegalStateException(r13);
    L35:
        r12[1] = "asFqNameString";
        goto L41
    L36:
        r12[1] = "asString";
        goto L41
    L37:
        r12[1] = "asSingleFqName";
        goto L41
    L38:
        r12[1] = "getShortClassName";
        goto L41
    L39:
        r12[1] = "getRelativeClassName";
        goto L41
    L40:
        r12[1] = "getPackageFqName";
        goto L41
    L21:
        r12[0] = "string";
        goto L29
    L22:
        r12[0] = "segment";
        goto L29
    L23:
        r12[0] = "name";
        goto L29
    L24:
        r12[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        goto L29
    L25:
        r12[0] = "topLevelName";
        goto L29
    L26:
        r12[0] = "relativeClassName";
        goto L29
    L27:
        r12[0] = "packageFqName";
        goto L29
    L59:
        r11 = 2;
        goto L18
    L58:
        r11 = 2;
        goto L18
    L57:
        r11 = 2;
        goto L18
    L56:
        r11 = 2;
        goto L18
    L17:
        r11 = 2;
    L9:
        r5 = "@NotNull method %s.%s must not return null";
        goto L11
    }

    public ClassId(FqName r5, FqName r10, boolean r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(2);
    L6:
        this.packageFqName = r5;
        this.relativeClassName = r10;
        this.local = r11;
    }

    public static ClassId fromString(String r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return fromString(r5, false);
    }

    public static ClassId topLevel(FqName r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new ClassId(r5.parent(), r5.shortName());
    }

    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot() == false) goto L9;
        FqName r5 = this.relativeClassName;
        if (r5 != null) goto L7;
        $$$reportNull$$$0(9);
    L7:
        return r5;
    L9:
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    public String asString() {
        if (this.packageFqName.isRoot() == false) goto L8;
        String r5 = this.relativeClassName.asString();
        if (r5 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r5;
    L8:
        String r10 = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (r10 != null) goto L11;
        $$$reportNull$$$0(14);
    L11:
        return r10;
    }

    public ClassId createNestedClassId(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return new ClassId(getPackageFqName(), this.relativeClassName.child(r5), this.local);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (ClassId.class != r5.getClass()) goto L19;
        ClassId r10 = (ClassId) r5;
        if (this.packageFqName.equals(r10.packageFqName) == false) goto L18;
        if (this.relativeClassName.equals(r10.relativeClassName) == false) goto L18;
        if (this.local != r10.local) goto L18;
        return true;
    L18:
        return false;
    }

    public ClassId getOuterClassId() {
        FqName r5 = this.relativeClassName.parent();
        if (r5.isRoot() == false) goto L6;
        return null;
    L6:
        return new ClassId(getPackageFqName(), r5, this.local);
    }

    public FqName getPackageFqName() {
        FqName r5 = this.packageFqName;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }

    public FqName getRelativeClassName() {
        FqName r5 = this.relativeClassName;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r5;
    }

    public Name getShortClassName() {
        Name r5 = this.relativeClassName.shortName();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r5;
    }

    public int hashCode() {
        int r5 = this.packageFqName.hashCode() * 31;
        int r10 = (this.relativeClassName.hashCode() + r5) * 31;
        return Boolean.valueOf(this.local).hashCode() + r10;
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

    public static ClassId fromString(String r5, boolean r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        int r11 = r5.lastIndexOf("/");
        if (r11 != (-1)) goto L7;
        String r12 = "";
    L9:
        return new ClassId(new FqName(r12), new FqName(r5), r10);
    L7:
        String r13 = r5.substring(0, r11).replace('/', '.');
        r5 = r5.substring(r11 + 1);
        r12 = r13;
        goto L9
    }

    public ClassId(FqName r5, Name r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        this(r5, FqName.topLevel(r10), false);
    }
}
