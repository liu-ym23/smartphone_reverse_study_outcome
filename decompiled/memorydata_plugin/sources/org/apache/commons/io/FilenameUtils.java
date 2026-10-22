package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class FilenameUtils {
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final String EXTENSION_SEPARATOR_STR = null;
    private static final Pattern IPV4_PATTERN = null;
    private static final char OTHER_SEPARATOR = 0;
    private static final Pattern REG_NAME_PART_PATTERN = null;
    private static final char SYSTEM_SEPARATOR = 0;

    static {
        EMPTY_STRING_ARRAY = new String[0];
        EXTENSION_SEPARATOR_STR = Character.toString('.');
        SYSTEM_SEPARATOR = File.separatorChar;
        if (isSystemWindows() == false) goto L5;
        char r0 = '/';
    L6:
        OTHER_SEPARATOR = r0;
        IPV4_PATTERN = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        REG_NAME_PART_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]*$");
        return;
    L5:
        r0 = '\\';
        goto L6
    }

    private static int getAdsCriticalOffset(String r2) {
        int r0 = r2.lastIndexOf(SYSTEM_SEPARATOR);
        int r3 = r2.lastIndexOf(OTHER_SEPARATOR);
        if (r0 != (-1)) goto L9;
        if (r3 != (-1)) goto L8;
        return 0;
    L8:
        return r3 + 1;
    L9:
        if (r3 != (-1)) goto L13;
        return r0 + 1;
    L13:
        return Math.max(r0, r3) + 1;
    }

    public static String getExtension(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = indexOfExtension(r2);
        if (r0 != (-1)) goto L10;
        return "";
    L10:
        return r2.substring(r0 + 1);
    }

    public static int indexOfExtension(String r3) {
        if (r3 != null) goto L6;
        return -1;
    L6:
        if (isSystemWindows() == true) goto L8;
    L12:
        int r1 = r3.lastIndexOf(46);
        if (indexOfLastSeparator(r3) <= r1) goto L16;
        return -1;
    L16:
        return r1;
    L8:
        if (r3.indexOf(58, getAdsCriticalOffset(r3)) == (-1)) goto L12;
        throw new IllegalArgumentException("NTFS ADS separator (':') in file name is forbidden.");
    }

    public static int indexOfLastSeparator(String r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return Math.max(r2.lastIndexOf(47), r2.lastIndexOf(92));
    }

    static boolean isSystemWindows() {
        if (SYSTEM_SEPARATOR != '\\') goto L5;
        return true;
    L5:
        return false;
    }

    static String[] splitOnTokens(String r10) {
        if (r10.indexOf(63) == (-1)) goto L5;
    L8:
        char[] r11 = r10.toCharArray();
        ArrayList r1 = new ArrayList();
        StringBuilder r2 = new StringBuilder();
        int r5 = r11.length;
        int r6 = 0;
        char r7 = 0;
    L9:
        if (r6 >= r5) goto L25;
        char r8 = r11[r6];
        if (r8 == '?') goto L16;
        if (r8 == '*') goto L16;
        r2.append(r8);
    L23:
        r6 = r6 + 1;
        r7 = r8;
    L16:
        if (r2.length() == 0) goto L18;
        r1.add(r2.toString());
        r2.setLength(0);
    L18:
        if (r8 != '?') goto L21;
        String r9 = "?";
    L20:
        r1.add(r9);
        goto L23
    L21:
        if (r7 == '*') goto L23;
        r9 = "*";
        goto L20
    L25:
        if (r2.length() == 0) goto L28;
        r1.add(r2.toString());
    L28:
        return (String[]) ZeusTransformUtils.preCheckCast(r1.toArray(EMPTY_STRING_ARRAY), String[].class, "com.obric.memorydata.plugin");
    L5:
        if (r10.indexOf(42) != (-1)) goto L8;
        return new String[]{r10};
    }

    public static boolean wildcardMatch(String r1, String r2) {
        return wildcardMatch(r1, r2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatch(String r8, String r9, IOCase r10) {
        if (r8 != null) goto L7;
        if (r9 != null) goto L7;
        return true;
    L7:
        if (r8 == null) goto L49;
        if (r9 == null) goto L49;
        if (r10 != null) goto L12;
        r10 = IOCase.SENSITIVE;
    L12:
        String[] r11 = splitOnTokens(r9);
        ArrayDeque r2 = new ArrayDeque(r11.length);
        boolean r3 = false;
        int r4 = 0;
        int r5 = 0;
    L14:
        if (r2.isEmpty() == true) goto L17;
        int[] r6 = (int[]) ZeusTransformUtils.preCheckCast(r2.pop(), int[].class, "com.obric.memorydata.plugin");
        r5 = r6[0];
        r4 = r6[1];
        r3 = true;
    L17:
        if (r5 >= r11.length) goto L43;
        if (r11[r5].equals("?") == false) goto L25;
        r4 = r4 + 1;
        if (r4 > r8.length()) goto L43;
    L23:
        r3 = false;
    L41:
        r5 = r5 + 1;
        goto L17
    L25:
        if (r11[r5].equals("*") == true) goto L27;
        if (r3 == false) goto L38;
        r4 = r10.checkIndexOf(r8, r4, r11[r5]);
        if (r4 == (-1)) goto L43;
        int r7 = r10.checkIndexOf(r8, r4 + 1, r11[r5]);
        if (r7 < 0) goto L40;
        r2.push(new int[]{r5, r7});
    L40:
        r4 = r4 + r11[r5].length();
        goto L23
    L38:
        if (r10.checkRegionMatches(r8, r4, r11[r5]) == true) goto L40;
    L27:
        if (r5 != (r11.length - 1)) goto L29;
        r4 = r8.length();
    L29:
        r3 = true;
    L43:
        if (r5 != r11.length) goto L48;
        if (r4 != r8.length()) goto L48;
        return true;
    L48:
        if (r2.isEmpty() == false) goto L14;
    L49:
        return false;
    }
}
