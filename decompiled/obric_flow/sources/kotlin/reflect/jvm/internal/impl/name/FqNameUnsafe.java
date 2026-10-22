package kotlin.reflect.jvm.internal.impl.name;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class FqNameUnsafe {
    private static final Name ROOT_NAME = null;
    private static final Pattern SPLIT_BY_DOTS = null;
    private static final Function1<String, Name> STRING_TO_NAME = null;
    private final String fqName;
    private transient FqNameUnsafe parent;
    private transient FqName safe;
    private transient Name shortName;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L3;
            case 16: goto L3;
            case 17: goto L4;
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
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L8;
            default: goto L7;
        };
    L7:
        int r11 = 3;
    L9:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L17;
        switch(r10) {
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L16;
            default: goto L12;
        };
    L12:
        r12[0] = "fqName";
    L18:
        switch(r10) {
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L24;
            case 9: goto L19;
            case 10: goto L23;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L19;
            case 17: goto L20;
            default: goto L19;
        };
    L19:
        r12[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
    L27:
        switch(r10) {
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L31;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L32;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L32;
            default: goto L28;
        };
    L28:
        r12[2] = "<init>";
        goto L32
    L29:
        r12[2] = "topLevel";
        goto L32
    L30:
        r12[2] = "startsWith";
        goto L32
    L31:
        r12[2] = "child";
    L32:
        String r13 = String.format(r5, r12);
        switch(r10) {
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L37;
            case 16: goto L37;
            case 17: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r13);
    L36:
        throw new IllegalStateException(r13);
    L20:
        r12[1] = "toString";
        goto L27
    L21:
        r12[1] = "pathSegments";
        goto L27
    L22:
        r12[1] = "shortNameOrSpecial";
        goto L27
    L23:
        r12[1] = "shortName";
        goto L27
    L24:
        r12[1] = "parent";
        goto L27
    L25:
        r12[1] = "toSafe";
        goto L27
    L26:
        r12[1] = "asString";
        goto L27
    L13:
        r12[0] = "shortName";
        goto L18
    L14:
        r12[0] = "segment";
        goto L18
    L15:
        r12[0] = "name";
        goto L18
    L16:
        r12[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
        goto L18
    L17:
        r12[0] = "safe";
        goto L18
    L8:
        r11 = 2;
        goto L9
    L4:
        r5 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT_NAME = Name.special("<root>");
        SPLIT_BY_DOTS = Pattern.compile("\\.");
        STRING_TO_NAME = new AnonymousClass1();
    }

    public FqNameUnsafe(String r5, FqName r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.fqName = r5;
        this.safe = r10;
    }

    private void compute() {
        int r5 = this.fqName.lastIndexOf(46);
        if (r5 < 0) goto L5;
        this.shortName = Name.guessByFirstCharacter(this.fqName.substring(r5 + 1));
        this.parent = new FqNameUnsafe(this.fqName.substring(0, r5));
        return;
    L5:
        this.shortName = Name.guessByFirstCharacter(this.fqName);
        this.parent = FqName.ROOT.toUnsafe();
    }

    public static FqNameUnsafe topLevel(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return new FqNameUnsafe(r5.asString(), FqName.ROOT.toUnsafe(), r5);
    }

    public String asString() {
        String r5 = this.fqName;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }

    public FqNameUnsafe child(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (isRoot() == false) goto L7;
        String r10 = r5.asString();
    L9:
        return new FqNameUnsafe(r10, this, r5);
    L7:
        r10 = this.fqName + "." + r5.asString();
        goto L9
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FqNameUnsafe) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqNameUnsafe) r5).fqName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isRoot() {
        return this.fqName.isEmpty();
    }

    public boolean isSafe() {
        if (this.safe == null) goto L5;
    L8:
        return true;
    L5:
        if (asString().indexOf(60) < 0) goto L8;
        return false;
    }

    public FqNameUnsafe parent() {
        FqNameUnsafe r5 = this.parent;
        if (r5 == null) goto L8;
        if (r5 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        return r5;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        FqNameUnsafe r10 = this.parent;
        if (r10 != null) goto L12;
        $$$reportNull$$$0(8);
    L12:
        return r10;
    L14:
        throw new IllegalStateException("root");
    }

    public List<Name> pathSegments() {
        if (isRoot() == false) goto L5;
        List<Name> r5 = Collections.emptyList();
    L6:
        if (r5 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r5;
    L5:
        r5 = ArraysKt.map(SPLIT_BY_DOTS.split(this.fqName), STRING_TO_NAME);
        goto L6
    }

    public Name shortName() {
        Name r5 = this.shortName;
        if (r5 == null) goto L8;
        if (r5 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        return r5;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        Name r10 = this.shortName;
        if (r10 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        return r10;
    L14:
        throw new IllegalStateException("root");
    }

    public Name shortNameOrSpecial() {
        if (isRoot() == false) goto L8;
        Name r5 = ROOT_NAME;
        if (r5 != null) goto L7;
        $$$reportNull$$$0(12);
    L7:
        return r5;
    L8:
        Name r10 = shortName();
        if (r10 != null) goto L11;
        $$$reportNull$$$0(13);
    L11:
        return r10;
    }

    public boolean startsWith(Name r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        if (isRoot() == false) goto L7;
        return false;
    L7:
        int r10 = this.fqName.indexOf(46);
        String r11 = r5.asString();
        String r12 = this.fqName;
        if (r10 != (-1)) goto L11;
        r10 = Math.max(r12.length(), r11.length());
    L11:
        return r12.regionMatches(0, r11, 0, r10);
    }

    public FqName toSafe() {
        FqName r5 = this.safe;
        if (r5 == null) goto L7;
        if (r5 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        return r5;
    L7:
        FqName r10 = new FqName(this);
        this.safe = r10;
        return r10;
    }

    public String toString() {
        if (isRoot() == false) goto L5;
        String r5 = ROOT_NAME.asString();
    L6:
        if (r5 != null) goto L8;
        $$$reportNull$$$0(17);
    L8:
        return r5;
    L5:
        r5 = this.fqName;
        goto L6
    }

    public FqNameUnsafe(String r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r5;
    }

    private FqNameUnsafe(String r5, FqNameUnsafe r10, Name r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r5;
        this.parent = r10;
        this.shortName = r11;
    }
}
