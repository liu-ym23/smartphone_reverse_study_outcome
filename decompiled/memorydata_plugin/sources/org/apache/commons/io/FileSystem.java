package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public final enum FileSystem extends Enum<FileSystem> {
    private static final /* synthetic */ FileSystem[] $VALUES = null;
    public static final FileSystem GENERIC = null;
    private static final boolean IS_OS_LINUX = false;
    private static final boolean IS_OS_MAC = false;
    private static final boolean IS_OS_WINDOWS = false;
    public static final FileSystem LINUX = null;
    public static final FileSystem MAC_OSX = null;
    private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final FileSystem WINDOWS = null;
    private final boolean casePreserving;
    private final boolean caseSensitive;
    private final char[] illegalFileNameChars;
    private final int maxFileNameLength;
    private final int maxPathLength;
    private final String[] reservedFileNames;
    private final boolean supportsDriveLetter;

    static {
        FileSystem r10 = new FileSystem("GENERIC", 0, false, false, Integer.MAX_VALUE, Integer.MAX_VALUE, new char[]{0}, new String[0], false);
        GENERIC = r10;
        FileSystem r0 = new FileSystem("LINUX", 1, true, true, 255, 4096, new char[]{0, '/'}, new String[0], false);
        LINUX = r0;
        FileSystem r2 = new FileSystem("MAC_OSX", 2, true, true, 255, 1024, new char[]{0, '/', ':'}, new String[0], false);
        MAC_OSX = r2;
        FileSystem r4 = new FileSystem("WINDOWS", 3, false, true, 255, 32000, new char[]{0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, Typography.quote, '*', '/', ':', Typography.less, Typography.greater, '?', '\\', '|'}, new String[]{"AUX", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "CON", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9", "NUL", "PRN"}, true);
        WINDOWS = r4;
        $VALUES = new FileSystem[]{r10, r0, r2, r4};
        IS_OS_LINUX = getOsMatchesName("Linux");
        IS_OS_MAC = getOsMatchesName("Mac");
        IS_OS_WINDOWS = getOsMatchesName(OS_NAME_WINDOWS_PREFIX);
    }

    private FileSystem(String r1, int r2, boolean r3, boolean r4, int r5, int r6, char[] r7, String[] r8, boolean r9) {
        super(r1, r2);
        this.maxFileNameLength = r5;
        this.maxPathLength = r6;
        this.illegalFileNameChars = (char[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7, "illegalFileNameChars"), char[].class, "com.obric.memorydata.plugin");
        this.reservedFileNames = (String[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8, "reservedFileNames"), String[].class, "com.obric.memorydata.plugin");
        this.caseSensitive = r3;
        this.casePreserving = r4;
        this.supportsDriveLetter = r9;
    }

    public static FileSystem getCurrent() {
        if (IS_OS_LINUX == false) goto L7;
        return LINUX;
    L7:
        if (IS_OS_MAC == false) goto L11;
        return MAC_OSX;
    L11:
        if (IS_OS_WINDOWS == false) goto L15;
        return WINDOWS;
    L15:
        return GENERIC;
    }

    private static boolean getOsMatchesName(String r1) {
        return isOsNameMatch(getSystemProperty("os.name"), r1);
    }

    private static String getSystemProperty(String r3) {
        return System.getProperty(r3);
    L4:
        System.err.println("Caught a SecurityException reading the system property '" + r3 + "'; the SystemUtils property value will default to null.");
        return null;
    }

    private boolean isIllegalFileNameChar(char r1) {
        if (Arrays.binarySearch(this.illegalFileNameChars, r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isOsNameMatch(String r1, String r2) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.toUpperCase(Locale.ROOT).startsWith(r2.toUpperCase(Locale.ROOT));
    }

    public static FileSystem valueOf(String r2) {
        return (FileSystem) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileSystem.class, r2), FileSystem.class, "com.obric.memorydata.plugin");
    }

    public static FileSystem[] values() {
        return (FileSystem[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileSystem[].class, "com.obric.memorydata.plugin");
    }

    public char[] getIllegalFileNameChars() {
        return (char[]) ZeusTransformUtils.preCheckCast(this.illegalFileNameChars.clone(), char[].class, "com.obric.memorydata.plugin");
    }

    public int getMaxFileNameLength() {
        return this.maxFileNameLength;
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }

    public String[] getReservedFileNames() {
        return (String[]) ZeusTransformUtils.preCheckCast(this.reservedFileNames.clone(), String[].class, "com.obric.memorydata.plugin");
    }

    public boolean isCasePreserving() {
        return this.casePreserving;
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public boolean isLegalFileName(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L21:
        return false;
    L5:
        if (r5.length() == 0) goto L21;
        if (r5.length() > this.maxFileNameLength) goto L21;
        if (isReservedFileName(r5) == false) goto L12;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= r5.length()) goto L19;
        if (isIllegalFileNameChar(r5.charAt(r1)) == true) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public boolean isReservedFileName(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (Arrays.binarySearch(this.reservedFileNames, r4) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean supportsDriveLetter() {
        return this.supportsDriveLetter;
    }

    public String toLegalFileName(String r6, char r7) {
        int r2 = 0;
        if (isIllegalFileNameChar(r7) == false) goto L10;
        Object[] r0 = new Object[3];
        if (r7 != 0) goto L7;
        Object r8 = "\\0";
    L8:
        r0[0] = r8;
        r0[1] = name();
        r0[2] = Arrays.toString(this.illegalFileNameChars);
        throw new IllegalArgumentException(String.format("The replacement character '%s' cannot be one of the %s illegal characters: %s", r0));
    L7:
        r8 = Character.valueOf(r7);
        goto L8
    L10:
        int r1 = r6.length();
        int r3 = this.maxFileNameLength;
        if (r1 <= r3) goto L13;
        r6 = r6.substring(0, r3);
    L13:
        char[] r4 = r6.toCharArray();
        boolean r5 = false;
    L15:
        if (r2 >= r4.length) goto L20;
        if (isIllegalFileNameChar(r4[r2]) == false) goto L19;
        r4[r2] = r7;
        r5 = true;
    L19:
        r2 = r2 + 1;
        goto L15
    L20:
        if (r5 == true) goto L22;
        return r6;
    L22:
        return String.valueOf(r4);
    }
}
