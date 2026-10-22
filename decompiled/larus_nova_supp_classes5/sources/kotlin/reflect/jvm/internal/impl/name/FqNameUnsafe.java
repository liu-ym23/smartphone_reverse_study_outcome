package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FqNameUnsafe {
    private static final Name ROOT_NAME = null;
    private static final Pattern SPLIT_BY_DOTS = null;
    private static final Function1<String, Name> STRING_TO_NAME = null;
    private final String fqName;
    private transient FqNameUnsafe parent;
    private transient FqName safe;
    private transient Name shortName;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        switch(r8) {
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
            case 17: goto L3;
            case 18: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r8) {
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
            case 17: goto L7;
            case 18: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        if (r8 == 1) goto L18;
        switch(r8) {
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L17;
            case 11: goto L17;
            case 12: goto L17;
            case 13: goto L17;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L17;
            default: goto L12;
        };
    L12:
        r3[0] = "fqName";
    L19:
        switch(r8) {
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L25;
            case 9: goto L20;
            case 10: goto L24;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L20;
            case 17: goto L20;
            case 18: goto L21;
            default: goto L20;
        };
    L20:
        r3[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
    L28:
        switch(r8) {
            case 4: goto L33;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L33;
            case 13: goto L33;
            case 14: goto L33;
            case 15: goto L31;
            case 16: goto L31;
            case 17: goto L30;
            case 18: goto L33;
            default: goto L29;
        };
    L29:
        r3[2] = "<init>";
        goto L33
    L30:
        r3[2] = "topLevel";
        goto L33
    L31:
        r3[2] = "startsWith";
        goto L33
    L32:
        r3[2] = "child";
    L33:
        String r1 = String.format(r0, r3);
        switch(r8) {
            case 4: goto L37;
            case 5: goto L37;
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L38;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L37;
            case 14: goto L37;
            case 15: goto L38;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L37;
            default: goto L38;
        };
    L38:
        throw new IllegalArgumentException(r1);
    L37:
        throw new IllegalStateException(r1);
    L21:
        r3[1] = "toString";
        goto L28
    L22:
        r3[1] = "pathSegments";
        goto L28
    L23:
        r3[1] = "shortNameOrSpecial";
        goto L28
    L24:
        r3[1] = "shortName";
        goto L28
    L25:
        r3[1] = "parent";
        goto L28
    L26:
        r3[1] = "toSafe";
        goto L28
    L27:
        r3[1] = "asString";
        goto L28
    L13:
        r3[0] = "shortName";
        goto L19
    L14:
        r3[0] = IInteractionStateService.WAKE_UP_SOURCE_OTHER;
        goto L19
    L15:
        r3[0] = "segment";
        goto L19
    L16:
        r3[0] = DBDefinition.NAME;
        goto L19
    L17:
        r3[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
        goto L19
    L18:
        r3[0] = "safe";
        goto L19
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT_NAME = Name.special("<root>");
        SPLIT_BY_DOTS = PatternProtector.compile("\\.");
        STRING_TO_NAME = new AnonymousClass1();
    }

    private void compute() {
        int r0 = this.fqName.lastIndexOf(46);
        if (r0 < 0) goto L5;
        this.shortName = Name.guessByFirstCharacter(this.fqName.substring(r0 + 1));
        this.parent = new FqNameUnsafe(this.fqName.substring(0, r0));
        return;
    L5:
        this.shortName = Name.guessByFirstCharacter(this.fqName);
        this.parent = FqName.ROOT.toUnsafe();
    }

    public String asString() {
        String r0 = this.fqName;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r0;
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
        FqNameUnsafe r0 = this.parent;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        return r0;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        FqNameUnsafe r1 = this.parent;
        if (r1 != null) goto L12;
        $$$reportNull$$$0(8);
    L12:
        return r1;
    L14:
        throw new IllegalStateException("root");
    }

    public Name shortName() {
        Name r0 = this.shortName;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        return r0;
    L8:
        if (isRoot() == true) goto L14;
        compute();
        Name r1 = this.shortName;
        if (r1 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        return r1;
    L14:
        throw new IllegalStateException("root");
    }

    public FqName toSafe() {
        FqName r0 = this.safe;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        return r0;
    L7:
        FqName r1 = new FqName(this);
        this.safe = r1;
        return r1;
    }

    public List<Name> pathSegments() {
        if (isRoot() == false) goto L5;
        List<Name> r0 = Collections.emptyList();
    L6:
        if (r0 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r0;
    L5:
        r0 = ArraysKt.map(SPLIT_BY_DOTS.split(this.fqName), STRING_TO_NAME);
        goto L6
    }

    public Name shortNameOrSpecial() {
        if (isRoot() == false) goto L8;
        Name r0 = ROOT_NAME;
        if (r0 != null) goto L7;
        $$$reportNull$$$0(12);
    L7:
        return r0;
    L8:
        Name r1 = shortName();
        if (r1 != null) goto L11;
        $$$reportNull$$$0(13);
    L11:
        return r1;
    }

    public String toString() {
        if (isRoot() == false) goto L5;
        String r0 = ROOT_NAME.asString();
    L6:
        if (r0 != null) goto L8;
        $$$reportNull$$$0(18);
    L8:
        return r0;
    L5:
        r0 = this.fqName;
        goto L6
    }

    public FqNameUnsafe(String r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r2;
    }

    public static FqNameUnsafe topLevel(Name r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return new FqNameUnsafe(r3.asString(), FqName.ROOT.toUnsafe(), r3);
    }

    public FqNameUnsafe child(Name r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        if (isRoot() == false) goto L7;
        String r0 = r3.asString();
    L9:
        return new FqNameUnsafe(r0, this, r3);
    L7:
        r0 = this.fqName + "." + r3.asString();
        goto L9
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof FqNameUnsafe) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqNameUnsafe) r4).fqName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean startsWith(Name r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        if (isRoot() == false) goto L7;
        return false;
    L7:
        int r0 = this.fqName.indexOf(46);
        if (r0 != (-1)) goto L10;
        r0 = this.fqName.length();
    L10:
        String r5 = r4.asString();
        if (r0 == r5.length()) goto L13;
        return false;
    L13:
        if (this.fqName.regionMatches(0, r5, 0, r0) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public FqNameUnsafe(String r2, FqName r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.fqName = r2;
        this.safe = r3;
    }

    private FqNameUnsafe(String r2, FqNameUnsafe r3, Name r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r2;
        this.parent = r3;
        this.shortName = r4;
    }
}
