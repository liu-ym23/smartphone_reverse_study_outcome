package org.apache.poi.ss.formula.function;

import com.bytedance.apm6.fd.config.FdConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
final class FunctionMetadataReader {
    private static final String[] DIGIT_ENDING_FUNCTION_NAMES = null;
    private static final Set<String> DIGIT_ENDING_FUNCTION_NAMES_SET = null;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static int MAX_RECORD_LENGTH = 100000;
    private static final Pattern SPACE_DELIM_PATTERN = null;
    private static final Pattern TAB_DELIM_PATTERN = null;

    static {
        TAB_DELIM_PATTERN = Pattern.compile("\t");
        SPACE_DELIM_PATTERN = Pattern.compile(" ");
        EMPTY_BYTE_ARRAY = new byte[0];
        String[] r0 = {"LOG10", "ATAN2", "DAYS360", "SUMXMY2", "SUMX2MY2", "SUMX2PY2", "A1.R1C1"};
        DIGIT_ENDING_FUNCTION_NAMES = r0;
        DIGIT_ENDING_FUNCTION_NAMES_SET = new HashSet(Arrays.asList(r0));
    }

    FunctionMetadataReader() {
    }

    public static FunctionMetadataRegistry createRegistry() {
        FunctionDataBuilder r0 = new FunctionDataBuilder(FdConfig.DEFAULT_FD_COUNT_THRESHOLD);
        readResourceFile(r0, "functionMetadata.txt");
        return r0.build();
    }

    public static FunctionMetadataRegistry createRegistryCetab() {
        FunctionDataBuilder r0 = new FunctionDataBuilder(FdConfig.DEFAULT_FD_COUNT_THRESHOLD);
        readResourceFile(r0, "functionMetadataCetab.txt");
        return r0.build();
    }

    private static boolean isDash(String r3) {
        if (r3.length() == 1) goto L5;
        return false;
    L5:
        if (r3.charAt(0) == '-') goto L7;
        return false;
    L7:
        return true;
    }

    private static int parseInt(String r3) {
        return Integer.parseInt(r3);
    L5:
        throw new RuntimeException("Value '" + r3 + "' could not be parsed as an integer");
    }

    private static byte parseOperandTypeCode(String r4) {
        if (r4.length() != 1) goto L18;
        char r1 = r4.charAt(0);
        if (r1 != 'A') goto L7;
        return 64;
    L7:
        if (r1 != 'R') goto L9;
        return 0;
    L9:
        if (r1 != 'V') goto L13;
        return 32;
    L13:
        throw new IllegalArgumentException("Unexpected operand type code '" + r4 + "' (" + r4.charAt(0) + ")");
    L18:
        throw new RuntimeException("Bad operand type code format '" + r4 + "' expected single char");
    }

    private static byte[] parseOperandTypeCodes(String r4) {
        if (r4.length() >= 1) goto L7;
        return EMPTY_BYTE_ARRAY;
    L7:
        if (isDash(r4) == true) goto L9;
        String[] r5 = SPACE_DELIM_PATTERN.split(r4);
        int r0 = r5.length;
        if ("...".equals(r5[r0 - 1]) == false) goto L13;
        r0 = r0 - 1;
    L13:
        byte[] r1 = IOUtils.safelyAllocate(r0, MAX_RECORD_LENGTH);
        int r2 = 0;
    L14:
        if (r2 >= r0) goto L16;
        r1[r2] = parseOperandTypeCode(r5[r2]);
        r2 = r2 + 1;
        goto L14
    L16:
        return r1;
    L9:
        return EMPTY_BYTE_ARRAY;
    }

    private static byte parseReturnTypeCode(String r1) {
        if (r1.length() != 0) goto L7;
        return 0;
    L7:
        return parseOperandTypeCode(r1);
    }

    private static void processLine(FunctionDataBuilder r10, String r11) {
        String[] r0 = TAB_DELIM_PATTERN.split(r11, -2);
        if (r0.length != 8) goto L11;
        int r3 = parseInt(r0[0]);
        String r4 = r0[1];
        int r5 = parseInt(r0[2]);
        int r6 = parseInt(r0[3]);
        byte r7 = parseReturnTypeCode(r0[4]);
        byte[] r8 = parseOperandTypeCodes(r0[5]);
        if (r0[7].length() <= 0) goto L7;
        boolean r9 = true;
    L8:
        validateFunctionName(r4);
        r10.add(r3, r4, r5, r6, r7, r8, r9);
        return;
    L7:
        r9 = false;
        goto L8
    L11:
        throw new RuntimeException("Bad line format '" + r11 + "' - expected 8 data fields delimited by tab, but had " + r0.length + ": " + Arrays.toString(r0));
    }

    private static void readResourceFile(FunctionDataBuilder r5, String r6) {
        InputStream r0 = FunctionMetadataReader.class.getResourceAsStream(r6);     // Catch: IOException -> L41
        if (r0 == null) goto L32;
        BufferedReader r7 = new BufferedReader(new InputStreamReader(r0, StandardCharsets.UTF_8));     // Catch: Throwable -> L29
    L46:
        String r1 = r7.readLine();     // Catch: Throwable -> L21
        if (r1 == null) goto L7;
        if (r1.length() < 1) goto L46;
        if (r1.charAt(0) == '#') goto L46;
        if (r1.trim().length() < 1) goto L46;
        processLine(r5, r1);     // Catch: Throwable -> L21
    L7:
        r7.close();     // Catch: Throwable -> L29
        if (r0 == null) goto L67;
        r0.close();     // Catch: IOException -> L41
        return;
    L67:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
        goto L28
    L32:
        throw new RuntimeException("resource '" + r6 + "' not found");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (r0 != null) goto L50;
    L40:
        throw th;     // Catch: IOException -> L41
    L50:
        r0.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L41
    L41:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void validateFunctionName(String r3) {
        int r0 = r3.length() - 1;
        if (Character.isDigit(r3.charAt(r0)) == true) goto L5;
        return;
    L5:
        if (r0 < 0) goto L11;
        if (Character.isDigit(r3.charAt(r0)) == false) goto L11;
        r0 = r0 - 1;
    L11:
        if (DIGIT_ENDING_FUNCTION_NAMES_SET.contains(r3) == false) goto L14;
        return;
    L14:
        throw new RuntimeException("Invalid function name '" + r3 + "' (is footnote number incorrectly appended)");
    }
}
