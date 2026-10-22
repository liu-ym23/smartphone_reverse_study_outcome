package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final enum IOCase extends Enum<IOCase> {
    private static final /* synthetic */ IOCase[] $VALUES = null;
    public static final IOCase INSENSITIVE = null;
    public static final IOCase SENSITIVE = null;
    public static final IOCase SYSTEM = null;
    private static final long serialVersionUID = -6343169151696340687L;
    private final String name;
    private final transient boolean sensitive;

    static {
        IOCase r0 = new IOCase("SENSITIVE", 0, "Sensitive", true);
        SENSITIVE = r0;
        IOCase r1 = new IOCase("INSENSITIVE", 1, "Insensitive", false);
        INSENSITIVE = r1;
        IOCase r3 = new IOCase("SYSTEM", 2, "System", !FilenameUtils.isSystemWindows());
        SYSTEM = r3;
        $VALUES = new IOCase[]{r0, r1, r3};
    }

    private IOCase(String r1, int r2, String r3, boolean r4) {
        super(r1, r2);
        this.name = r3;
        this.sensitive = r4;
    }

    public static IOCase forName(String r5) {
        IOCase[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        IOCase r3 = r0[r2];
        if (r3.getName().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Invalid IOCase name: " + r5);
    }

    public static boolean isCaseSensitive(IOCase r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isCaseSensitive() == true) goto L6;
        return true;
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public static IOCase valueOf(String r2) {
        return (IOCase) ZeusTransformUtils.preCheckCast(Enum.valueOf(IOCase.class, r2), IOCase.class, "com.obric.memorydata.plugin");
    }

    public static IOCase[] values() {
        return (IOCase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IOCase[].class, "com.obric.memorydata.plugin");
    }

    public int checkCompareTo(String r2, String r3) {
        Objects.requireNonNull(r2, "str1");
        Objects.requireNonNull(r3, "str2");
        if (this.sensitive == false) goto L6;
        return r2.compareTo(r3);
    L6:
        return r2.compareToIgnoreCase(r3);
    }

    public boolean checkEndsWith(String r7, String r8) {
        if (r7 == null) goto L7;
        if (r8 == null) goto L9;
        int r5 = r8.length();
        return r7.regionMatches(!this.sensitive, r7.length() - r5, r8, 0, r5);
    L9:
        return false;
    L7:
        return false;
    }

    public boolean checkEquals(String r2, String r3) {
        Objects.requireNonNull(r2, "str1");
        Objects.requireNonNull(r3, "str2");
        if (this.sensitive == false) goto L6;
        return r2.equals(r3);
    L6:
        return r2.equalsIgnoreCase(r3);
    }

    public int checkIndexOf(String r3, int r4, String r5) {
        int r0 = r3.length() - r5.length();
        if (r0 < r4) goto L9;
    L4:
        if (r4 > r0) goto L13;
        if (checkRegionMatches(r3, r4, r5) == true) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return r4;
    L13:
        return -1;
    L9:
        return -1;
    }

    public boolean checkRegionMatches(String r7, int r8, String r9) {
        return r7.regionMatches(!this.sensitive, r8, r9, 0, r9.length());
    }

    public boolean checkStartsWith(String r8, String r9) {
        if (r8 == null) goto L8;
        if (r9 == null) goto L8;
        if (r8.regionMatches(!this.sensitive, 0, r9, 0, r9.length()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.sensitive;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
