package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public Utils() {
    }

    public static int count(String r5, char r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= r5.length()) goto L9;
        if (r5.charAt(r11) != r10) goto L8;
        r12 = r12 + 1;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r12;
    }

    public static String escapeWhitespace(String r5, boolean r10) {
        StringBuilder r11 = new StringBuilder();
        char[] r12 = r5.toCharArray();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L20;
        char r15 = r12[r14];
        if (r15 != ' ') goto L9;
        if (r10 == false) goto L9;
        r11.append(Typography.middleDot);
    L18:
        r14 = r14 + 1;
    L9:
        if (r15 != '\t') goto L12;
        r11.append("\\t");
        goto L18
    L12:
        if (r15 != '\n') goto L15;
        r11.append("\\n");
        goto L18
    L15:
        if (r15 != '\r') goto L17;
        r11.append("\\r");
        goto L18
    L17:
        r11.append(r15);
        goto L18
    L20:
        return r11.toString();
    }

    public static String expandTabs(String r10, int r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        StringBuilder r5 = new StringBuilder();
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r12 >= r10.length()) goto L17;
        char r14 = r10.charAt(r12);
        if (r14 != '\t') goto L11;
        int r15 = r11 - (r13 % r11);
        r13 = r13 + r15;
        r5.append(spaces(r15));
    L15:
        r12 = r12 + 1;
        goto L7
    L11:
        if (r14 == '\n') goto L13;
        r13 = r13 + 1;
        r5.append(r14);
        goto L15
    L13:
        r5.append(r14);
        r13 = 0;
        goto L15
    L17:
        return r5.toString();
    }

    public static <T> String join(Iterator<T> r5, String r10) {
        StringBuilder r11 = new StringBuilder();
    L4:
        if (r5.hasNext() == false) goto L9;
        r11.append(r5.next());
        if (r5.hasNext() == false) goto L4;
        r11.append(r10);
        goto L4
    L9:
        return r11.toString();
    }

    public static String newlines(int r5) {
        return sequence(r5, "\n");
    }

    public static int numNonnull(Object[] r5) {
        int r10 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r11 = r5.length;
        int r12 = 0;
    L6:
        if (r10 >= r11) goto L11;
        if (r5[r10] == null) goto L10;
        r12 = r12 + 1;
    L10:
        r10 = r10 + 1;
        goto L6
    L11:
        return r12;
    }

    public static char[] readFile(String r5) throws IOException {
        return readFile(r5, null);
    }

    public static <T> void removeAllElements(Collection<T> r5, T r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.contains(r10) == false) goto L7;
        r5.remove(r10);
        goto L5
    }

    public static String sequence(int r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 1;
    L3:
        if (r12 > r5) goto L6;
        r11.append(r10);
        r12 = r12 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static String spaces(int r5) {
        return sequence(r5, " ");
    }

    public static char[] toCharArray(IntegerList r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.toCharArray();
    }

    public static Map<String, Integer> toMap(String[] r5) {
        HashMap r10 = new HashMap();
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10.put(r5[r11], Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public static IntervalSet toSet(BitSet r5) {
        IntervalSet r10 = new IntervalSet(new int[0]);
        int r11 = r5.nextSetBit(0);
    L3:
        if (r11 < 0) goto L5;
        r10.add(r11);
        r11 = r5.nextSetBit(r11 + 1);
        goto L3
    L5:
        return r10;
    }

    public static void writeFile(String r5, String r10) throws IOException {
        writeFile(r5, r10, null);
    }

    public static char[] readFile(String r5, String r10) throws IOException {
        int r11 = (int) new File(r5).length();
        FileInputStream r12 = new FileInputStream(r5);
        if (r10 == null) goto L5;
        InputStreamReader r13 = new InputStreamReader(r12, r10);
    L16:
        char[] r14 = new char[r11];     // Catch: Throwable -> L10
        int r15 = r13.read(r14);     // Catch: Throwable -> L10
        if (r15 >= r11) goto L12;
        r14 = Arrays.copyOf(r14, r15);     // Catch: Throwable -> L10
    L12:
        r13.close();
        return r14;
    L10:
        th = move-exception;
        r13.close();
        throw th;
    L5:
        r13 = new InputStreamReader(r12);
        goto L16
    }

    public static void writeFile(String r5, String r10, String r11) throws IOException {
        FileOutputStream r12 = new FileOutputStream(new File(r5));
        if (r11 == null) goto L5;
        OutputStreamWriter r13 = new OutputStreamWriter(r12, r11);
    L12:
        r13.write(r10);     // Catch: Throwable -> L9
        r13.close();
        return;
    L9:
        th = move-exception;
        r13.close();
        throw th;
    L5:
        r13 = new OutputStreamWriter(r12);
        goto L12
    }

    public static <T> String join(T[] r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L4:
        if (r12 >= r5.length) goto L10;
        r11.append(r5[r12]);
        if (r12 >= (r5.length - 1)) goto L8;
        r11.append(r10);
    L8:
        r12 = r12 + 1;
        goto L4
    L10:
        return r11.toString();
    }
}
