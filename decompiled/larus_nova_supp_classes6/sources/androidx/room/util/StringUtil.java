package androidx.room.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    private StringUtil() {
    }

    public static String joinIntoString(List<Integer> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.size();
        if (r0 != 0) goto L9;
        return "";
    L9:
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L16;
        r1.append(Integer.toString(((Integer) ListProtector.get(r4, r2)).intValue()));
        if (r2 >= (r0 - 1)) goto L14;
        r1.append(",");
    L14:
        r2 = r2 + 1;
        goto L10
    L16:
        return r1.toString();
    }

    public static List<Integer> splitToIntList(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        StringTokenizer r1 = new StringTokenizer(r3, ",");
    L7:
        if (r1.hasMoreElements() == false) goto L12;
        r0.add(Integer.valueOf(CastIntegerProtector.parseInt(r1.nextToken())));     // Catch: NumberFormatException -> L11
        goto L7
    L12:
        return r0;
    }

    public static void appendPlaceholders(StringBuilder r2, int r3) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        r2.append("?");
        if (r0 >= (r3 - 1)) goto L7;
        r2.append(",");
    L7:
        r0 = r0 + 1;
        goto L3
    }
}
