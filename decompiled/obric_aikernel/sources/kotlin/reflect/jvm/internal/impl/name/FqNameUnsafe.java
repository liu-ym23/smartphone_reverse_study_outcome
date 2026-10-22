package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
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
        r13[0] = "fqName";
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
        r13[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
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
        r13[2] = "<init>";
        goto L32
    L29:
        r13[2] = "topLevel";
        goto L32
    L30:
        r13[2] = "startsWith";
        goto L32
    L31:
        r13[2] = "child";
    L32:
        String r14 = String.format(r11, r13);
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
        throw new IllegalArgumentException(r14);
    L36:
        throw new IllegalStateException(r14);
    L20:
        r13[1] = "toString";
        goto L27
    L21:
        r13[1] = "pathSegments";
        goto L27
    L22:
        r13[1] = "shortNameOrSpecial";
        goto L27
    L23:
        r13[1] = "shortName";
        goto L27
    L24:
        r13[1] = "parent";
        goto L27
    L25:
        r13[1] = "toSafe";
        goto L27
    L26:
        r13[1] = "asString";
        goto L27
    L13:
        r13[0] = "shortName";
        goto L18
    L14:
        r13[0] = "segment";
        goto L18
    L15:
        r13[0] = ActivityLifecycle.NAME;
        goto L18
    L16:
        r13[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
        goto L18
    L17:
        r13[0] = "safe";
        goto L18
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT_NAME = Name.special("<root>");
        SPLIT_BY_DOTS = Pattern.compile("\\.");
        STRING_TO_NAME = new AnonymousClass1();
    }

    public FqNameUnsafe(String r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r10;
    }

    FqNameUnsafe(String r10, FqName r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.fqName = r10;
        this.safe = r11;
    }

    private FqNameUnsafe(String r10, FqNameUnsafe r11, Name r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r10;
        this.parent = r11;
        this.shortName = r12;
    }

    private void compute() {
        int r10 = this.fqName.lastIndexOf(46);
        if (r10 < 0) goto L5;
        this.shortName = Name.guessByFirstCharacter(this.fqName.substring(r10 + 1));
        this.parent = new FqNameUnsafe(this.fqName.substring(0, r10));
        return;
    L5:
        this.shortName = Name.guessByFirstCharacter(this.fqName);
        this.parent = FqName.ROOT.toUnsafe();
    }

    public static FqNameUnsafe topLevel(Name r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return new FqNameUnsafe(r10.asString(), FqName.ROOT.toUnsafe(), r10);
    }

    public String asString() {
        String r10 = this.fqName;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r10;
    }

    public FqNameUnsafe child(Name r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (isRoot() == false) goto L7;
        String r11 = r10.asString();
    L9:
        return new FqNameUnsafe(r11, this, r10);
    L7:
        r11 = this.fqName + "." + r10.asString();
        goto L9
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FqNameUnsafe) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqNameUnsafe) r10).fqName) == true) goto L11;
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
        FqNameUnsafe r10 = this.parent;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        return r10;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        FqNameUnsafe r11 = this.parent;
        if (r11 != null) goto L12;
        $$$reportNull$$$0(8);
    L12:
        return r11;
    L14:
        throw new IllegalStateException("root");
    }

    public List<Name> pathSegments() {
        if (isRoot() == false) goto L5;
        List<Name> r10 = Collections.emptyList();
    L6:
        if (r10 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r10;
    L5:
        r10 = ArraysKt.map(SPLIT_BY_DOTS.split(this.fqName), STRING_TO_NAME);
        goto L6
    }

    public Name shortName() {
        Name r10 = this.shortName;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        return r10;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        Name r11 = this.shortName;
        if (r11 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        return r11;
    L14:
        throw new IllegalStateException("root");
    }

    public Name shortNameOrSpecial() {
        if (isRoot() == false) goto L8;
        Name r10 = ROOT_NAME;
        if (r10 != null) goto L7;
        $$$reportNull$$$0(12);
    L7:
        return r10;
    L8:
        Name r11 = shortName();
        if (r11 != null) goto L11;
        $$$reportNull$$$0(13);
    L11:
        return r11;
    }

    public boolean startsWith(Name r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        if (isRoot() == false) goto L7;
        return false;
    L7:
        int r11 = this.fqName.indexOf(46);
        String r12 = this.fqName;
        String r13 = r10.asString();
        if (r11 != (-1)) goto L11;
        r11 = this.fqName.length();
    L11:
        return r12.regionMatches(0, r13, 0, r11);
    }

    public FqName toSafe() {
        FqName r10 = this.safe;
        if (r10 == null) goto L7;
        if (r10 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        return r10;
    L7:
        FqName r11 = new FqName(this);
        this.safe = r11;
        return r11;
    }

    public String toString() {
        if (isRoot() == false) goto L5;
        String r10 = ROOT_NAME.asString();
    L6:
        if (r10 != null) goto L8;
        $$$reportNull$$$0(17);
    L8:
        return r10;
    L5:
        r10 = this.fqName;
        goto L6
    }
}
