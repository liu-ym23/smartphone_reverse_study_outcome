package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: loaded from: classes3.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L8;
        if (r10 == 2) goto L8;
        if (r10 == 3) goto L8;
        if (r10 == 4) goto L8;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 1) goto L14;
        if (r10 == 2) goto L14;
        if (r10 == 3) goto L14;
        if (r10 == 4) goto L14;
        int r11 = 3;
    L15:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L21;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        r12[0] = "name";
    L22:
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L28;
        if (r10 == 3) goto L27;
        if (r10 == 4) goto L27;
        r12[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
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
        r12[2] = "<init>";
        goto L36
    L32:
        r12[2] = "guessByFirstCharacter";
        goto L36
    L33:
        r12[2] = "special";
        goto L36
    L34:
        r12[2] = "isValidIdentifier";
        goto L36
    L35:
        r12[2] = "identifier";
    L36:
        String r13 = String.format(r5, r12);
        if (r10 == 1) goto L43;
        if (r10 == 2) goto L43;
        if (r10 == 3) goto L43;
        if (r10 == 4) goto L43;
        throw new IllegalArgumentException(r13);
    L43:
        throw new IllegalStateException(r13);
    L27:
        r12[1] = "asStringStripSpecialMarkers";
        goto L30
    L28:
        r12[1] = "getIdentifier";
        goto L30
    L29:
        r12[1] = "asString";
    L21:
        r12[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L14:
        r11 = 2;
    L8:
        r5 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    private Name(String r5, boolean r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.name = r5;
        this.special = r10;
    }

    public static Name guessByFirstCharacter(String r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r5.startsWith("<") == false) goto L9;
        return special(r5);
    L9:
        return identifier(r5);
    }

    public static Name identifier(String r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return new Name(r5, false);
    }

    public static boolean isValidIdentifier(String r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        if (r5.isEmpty() == false) goto L7;
    L23:
        return false;
    L7:
        if (r5.startsWith("<") == true) goto L23;
        int r10 = 0;
    L11:
        if (r10 >= r5.length()) goto L21;
        char r11 = r5.charAt(r10);
        if (r11 == '.') goto L20;
        if (r11 == '/') goto L20;
        if (r11 == '\\') goto L20;
        r10 = r10 + 1;
    L20:
        return false;
    L21:
        return true;
    }

    public static Name special(String r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r5.startsWith("<") == false) goto L9;
        return new Name(r5, true);
    L9:
        throw new IllegalArgumentException("special name must start with '<': ".concat(r5));
    }

    public String asString() {
        String r5 = this.name;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r5;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Name r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Name) == true) goto L8;
        return false;
    L8:
        Name r10 = (Name) r5;
        if (this.special == r10.special) goto L12;
        return false;
    L12:
        if (this.name.equals(r10.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getIdentifier() {
        if (this.special == true) goto L9;
        String r5 = asString();
        if (r5 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r5;
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

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Name r5) {
        return this.name.compareTo(r5.name);
    }
}
