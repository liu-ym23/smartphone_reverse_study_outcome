package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class FqName {
    public static final FqName ROOT = null;
    private final FqNameUnsafe fqName;
    private transient FqName parent;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L3;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        int r11 = 3;
    L9:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L12;
            default: goto L11;
        };
    L11:
        r12[0] = "names";
    L18:
        switch(r10) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L19;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            default: goto L19;
        };
    L19:
        r12[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
    L26:
        switch(r10) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L31;
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L30;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L29;
            case 13: goto L28;
            default: goto L27;
        };
    L27:
        r12[2] = "fromSegments";
        goto L32
    L28:
        r12[2] = "topLevel";
        goto L32
    L29:
        r12[2] = "startsWith";
        goto L32
    L30:
        r12[2] = "child";
        goto L32
    L31:
        r12[2] = "<init>";
    L32:
        String r13 = String.format(r5, r12);
        switch(r10) {
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r13);
    L36:
        throw new IllegalStateException(r13);
    L20:
        r12[1] = "pathSegments";
        goto L26
    L21:
        r12[1] = "shortNameOrSpecial";
        goto L26
    L22:
        r12[1] = "shortName";
        goto L26
    L23:
        r12[1] = "parent";
        goto L26
    L24:
        r12[1] = "toUnsafe";
        goto L26
    L25:
        r12[1] = "asString";
        goto L26
    L12:
        r12[0] = "shortName";
        goto L18
    L13:
        r12[0] = "segment";
        goto L18
    L14:
        r12[0] = "name";
        goto L18
    L15:
        r12[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
        goto L18
    L16:
        r12[0] = "fqName";
        goto L18
    L8:
        r11 = 2;
        goto L9
    L4:
        r5 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT = new FqName("");
    }

    public FqName(String r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        this.fqName = new FqNameUnsafe(r5, this);
    }

    public static FqName topLevel(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return new FqName(FqNameUnsafe.topLevel(r5));
    }

    public String asString() {
        String r5 = this.fqName.asString();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }

    public FqName child(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return new FqName(this.fqName.child(r5), this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FqName) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqName) r5).fqName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isRoot() {
        return this.fqName.isRoot();
    }

    public FqName parent() {
        FqName r5 = this.parent;
        if (r5 == null) goto L8;
        if (r5 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        return r5;
    L8:
        if (isRoot() == true) goto L12;
        FqName r10 = new FqName(this.fqName.parent());
        this.parent = r10;
        return r10;
    L12:
        throw new IllegalStateException("root");
    }

    public List<Name> pathSegments() {
        List<Name> r5 = this.fqName.pathSegments();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r5;
    }

    public Name shortName() {
        Name r5 = this.fqName.shortName();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r5;
    }

    public Name shortNameOrSpecial() {
        Name r5 = this.fqName.shortNameOrSpecial();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r5;
    }

    public boolean startsWith(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return this.fqName.startsWith(r5);
    }

    public String toString() {
        return this.fqName.toString();
    }

    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe r5 = this.fqName;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }

    public FqName(FqNameUnsafe r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r5;
    }

    private FqName(FqNameUnsafe r5, FqName r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r5;
        this.parent = r10;
    }
}
