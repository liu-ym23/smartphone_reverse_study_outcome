package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.crash.tracker.ActivityLifecycle;

/* JADX INFO: loaded from: classes3.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L8;
        if (r10 == 2) goto L8;
        if (r10 == 3) goto L8;
        if (r10 == 4) goto L8;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 1) goto L14;
        if (r10 == 2) goto L14;
        if (r10 == 3) goto L14;
        if (r10 == 4) goto L14;
        int r12 = 3;
    L15:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L21;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        r13[0] = ActivityLifecycle.NAME;
    L22:
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L28;
        if (r10 == 3) goto L27;
        if (r10 == 4) goto L27;
        r13[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L30:
        switch(r10) {
            case 1: goto L36;
            case 2: goto L36;
            case 3: goto L36;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L31;
        };
    L31:
        r13[2] = "<init>";
        goto L36
    L32:
        r13[2] = "guessByFirstCharacter";
        goto L36
    L33:
        r13[2] = "special";
        goto L36
    L34:
        r13[2] = "isValidIdentifier";
        goto L36
    L35:
        r13[2] = "identifier";
    L36:
        String r14 = String.format(r11, r13);
        if (r10 == 1) goto L43;
        if (r10 == 2) goto L43;
        if (r10 == 3) goto L43;
        if (r10 == 4) goto L43;
        throw new IllegalArgumentException(r14);
    L43:
        throw new IllegalStateException(r14);
    L27:
        r13[1] = "asStringStripSpecialMarkers";
        goto L30
    L28:
        r13[1] = "getIdentifier";
        goto L30
    L29:
        r13[1] = "asString";
    L21:
        r13[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L14:
        r12 = 2;
    L8:
        r11 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    private Name(String r10, boolean r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.name = r10;
        this.special = r11;
    }

    public static Name guessByFirstCharacter(String r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r10.startsWith("<") == false) goto L9;
        return special(r10);
    L9:
        return identifier(r10);
    }

    public static Name identifier(String r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return new Name(r10, false);
    }

    public static boolean isValidIdentifier(String r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        if (r10.isEmpty() == false) goto L7;
    L23:
        return false;
    L7:
        if (r10.startsWith("<") == true) goto L23;
        int r11 = 0;
    L11:
        if (r11 >= r10.length()) goto L21;
        char r12 = r10.charAt(r11);
        if (r12 == '.') goto L20;
        if (r12 == '/') goto L20;
        if (r12 == '\\') goto L20;
        r11 = r11 + 1;
    L20:
        return false;
    L21:
        return true;
    }

    public static Name special(String r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r10.startsWith("<") == false) goto L9;
        return new Name(r10, true);
    L9:
        throw new IllegalArgumentException("special name must start with '<': " + r10);
    }

    public String asString() {
        String r10 = this.name;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r10;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Name r10) {
        return compareTo2(r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Name r10) {
        return this.name.compareTo(r10.name);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Name) == true) goto L8;
        return false;
    L8:
        Name r11 = (Name) r10;
        if (this.special == r11.special) goto L12;
        return false;
    L12:
        if (this.name.equals(r11.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getIdentifier() {
        if (this.special == true) goto L9;
        String r10 = asString();
        if (r10 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r10;
    L9:
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }
}
