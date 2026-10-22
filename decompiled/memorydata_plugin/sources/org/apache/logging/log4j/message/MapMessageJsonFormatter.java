package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.util.IndexedStringMap;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.q;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
final enum MapMessageJsonFormatter extends Enum<MapMessageJsonFormatter> {
    private static final /* synthetic */ MapMessageJsonFormatter[] $VALUES = null;
    private static final char COLON = ':';
    private static final char COMMA = ',';
    private static final char DQUOTE = '\"';
    private static final char LBRACE = '[';
    private static final char LCURLY = '{';
    public static final int MAX_DEPTH = 0;
    private static final char RBRACE = ']';
    private static final char RCURLY = '}';

    static {
        $VALUES = new MapMessageJsonFormatter[0];
        MAX_DEPTH = readMaxDepth();
    }

    private MapMessageJsonFormatter(String r1, int r2) {
        super(r1, r2);
    }

    static void format(StringBuilder r1, Object r2) {
        format(r1, r2, 0);
    }

    private static void format(StringBuilder r10, Object r11, int r12) {
        if (r12 >= MAX_DEPTH) goto L57;
        if (r11 != null) goto L7;
        r10.append("null");
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, IndexedStringMap.class) == false) goto L10;
        formatIndexedStringMap(r10, (IndexedStringMap) ZeusTransformUtils.preCheckCast(r11, IndexedStringMap.class, "com.obric.memorydata.plugin"), r12);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r11, Map.class) == false) goto L13;
        formatMap(r10, (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin"), r12);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r11, List.class) == false) goto L16;
        formatList(r10, (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), r12);
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == false) goto L19;
        formatCollection(r10, (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin"), r12);
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r11, Number.class) == false) goto L22;
        formatNumber(r10, (Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin"));
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r11, Boolean.class) == false) goto L25;
        formatBoolean(r10, ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L25:
        if (ZeusTransformUtils.instanceOf(r11, q.class) == false) goto L28;
        formatFormattable(r10, (q) ZeusTransformUtils.preCheckCast(r11, q.class, "com.obric.memorydata.plugin"));
        return;
    L28:
        if ((r11 instanceof char[]) == false) goto L31;
        formatCharArray(r10, (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r11, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"));
        return;
    L31:
        if ((r11 instanceof boolean[]) == false) goto L34;
        formatBooleanArray(r10, (boolean[]) ZeusTransformUtils.preCheckCast((boolean[]) ZeusTransformUtils.preCheckCast(r11, boolean[].class, "com.obric.memorydata.plugin"), boolean[].class, "com.obric.memorydata.plugin"));
        return;
    L34:
        if ((r11 instanceof byte[]) == false) goto L37;
        formatByteArray(r10, (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r11, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
        return;
    L37:
        if ((r11 instanceof short[]) == false) goto L40;
        formatShortArray(r10, (short[]) ZeusTransformUtils.preCheckCast((short[]) ZeusTransformUtils.preCheckCast(r11, short[].class, "com.obric.memorydata.plugin"), short[].class, "com.obric.memorydata.plugin"));
        return;
    L40:
        if ((r11 instanceof int[]) == false) goto L43;
        formatIntArray(r10, (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r11, int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin"));
        return;
    L43:
        if ((r11 instanceof long[]) == false) goto L46;
        formatLongArray(r10, (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r11, long[].class, "com.obric.memorydata.plugin"), long[].class, "com.obric.memorydata.plugin"));
        return;
    L46:
        if ((r11 instanceof float[]) == false) goto L49;
        formatFloatArray(r10, (float[]) ZeusTransformUtils.preCheckCast((float[]) ZeusTransformUtils.preCheckCast(r11, float[].class, "com.obric.memorydata.plugin"), float[].class, "com.obric.memorydata.plugin"));
        return;
    L49:
        if ((r11 instanceof double[]) == false) goto L52;
        formatDoubleArray(r10, (double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r11, double[].class, "com.obric.memorydata.plugin"), double[].class, "com.obric.memorydata.plugin"));
        return;
    L52:
        if ((r11 instanceof Object[]) == false) goto L54;
        formatObjectArray(r10, (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r11, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"), r12);
        return;
    L54:
        formatString(r10, r11);
        return;
    L57:
        throw new IllegalArgumentException("maxDepth has been exceeded");
    }

    private static void formatBoolean(StringBuilder r0, boolean r1) {
        r0.append(r1);
    }

    private static void formatBooleanArray(StringBuilder r2, boolean[] r3) {
        r2.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        r2.append(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatByteArray(StringBuilder r2, byte[] r3) {
        r2.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        r2.append(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatCharArray(StringBuilder r4, char[] r5) {
        r4.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L8;
        if (r0 <= 0) goto L7;
        r4.append(COMMA);
    L7:
        char r1 = r5[r0];
        r4.append('\"');
        int r3 = r4.length();
        r4.append(r1);
        r.b(r4, r3);
        r4.append('\"');
        r0 = r0 + 1;
        goto L4
    L8:
        r4.append(RBRACE);
    }

    private static void formatCollection(final StringBuilder r3, Collection<Object> r4, int r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        r3.append(LBRACE);
        final int r7 = r5 + 1;
        final boolean[] r1 = {true};
        r6.forEach(new $$Lambda$MapMessageJsonFormatter$P4M8ctrr3kYbMhNaLKdzR_yZEBc(r1, r3, r7));
        r3.append(RBRACE);
    }

    private static void formatDoubleArray(StringBuilder r3, double[] r4) {
        r3.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L8;
        if (r0 <= 0) goto L7;
        r3.append(COMMA);
    L7:
        r3.append(r4[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r3.append(RBRACE);
    }

    private static void formatFloatArray(StringBuilder r2, float[] r3) {
        r2.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        r2.append(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatFormattable(StringBuilder r2, q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        r2.append('\"');
        int r1 = r2.length();
        r4.formatTo(r2);
        r.b(r2, r1);
        r2.append('\"');
    }

    private static void formatIndexedStringMap(StringBuilder r5, IndexedStringMap r6, int r7) {
        IndexedStringMap r8 = (IndexedStringMap) ZeusTransformUtils.wrapperContextForParams(r6, IndexedStringMap.class, "com.obric.memorydata.plugin");
        r5.append(LCURLY);
        int r9 = r7 + 1;
        int r0 = 0;
    L4:
        if (r0 >= r8.size()) goto L9;
        String r1 = r8.getKeyAt(r0);
        Object r2 = r8.getValueAt(r0);
        if (r0 <= 0) goto L8;
        r5.append(COMMA);
    L8:
        r5.append('\"');
        int r4 = r5.length();
        r5.append(r1);
        r.b(r5, r4);
        r5.append('\"').append(COLON);
        format(r5, r2, r9);
        r0 = r0 + 1;
        goto L4
    L9:
        r5.append(RCURLY);
    }

    private static void formatIntArray(StringBuilder r2, int[] r3) {
        r2.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        r2.append(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatList(StringBuilder r2, List<Object> r3, int r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.append(LBRACE);
        int r6 = r4 + 1;
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        format(r2, r5.get(r0), r6);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatLongArray(StringBuilder r3, long[] r4) {
        r3.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L8;
        if (r0 <= 0) goto L7;
        r3.append(COMMA);
    L7:
        r3.append(r4[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r3.append(RBRACE);
    }

    private static void formatMap(final StringBuilder r3, Map<Object, Object> r4, int r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        r3.append(LCURLY);
        final int r7 = r5 + 1;
        final boolean[] r1 = {true};
        r6.forEach(new $$Lambda$MapMessageJsonFormatter$QRrAtEBUUpsYGoLNqAqdVNiCEd4(r1, r3, r7));
        r3.append(RCURLY);
    }

    private static void formatNumber(StringBuilder r6, Number r7) {
        if (ZeusTransformUtils.instanceOf(r7, BigDecimal.class) == false) goto L6;
        r6.append(((BigDecimal) ZeusTransformUtils.preCheckCast(r7, BigDecimal.class, "com.obric.memorydata.plugin")).toString());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, Double.class) == false) goto L9;
        r6.append(((Double) ZeusTransformUtils.preCheckCast(r7, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L12;
        r6.append(((Float) ZeusTransformUtils.preCheckCast(r7, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r7, Byte.class) == false) goto L14;
    L24:
        long r0 = r7.longValue();
    L25:
        r6.append(r0);
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r7, Short.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == true) goto L24;
        r0 = r7.longValue();
        double r2 = r7.doubleValue();
        if (Double.compare(r0, r2) == 0) goto L25;
        r6.append(r2);
    }

    private static void formatObjectArray(StringBuilder r2, Object[] r3, int r4) {
        r2.append(LBRACE);
        int r5 = r4 + 1;
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        format(r2, r3[r0], r5);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatShortArray(StringBuilder r2, short[] r3) {
        r2.append(LBRACE);
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L8;
        if (r0 <= 0) goto L7;
        r2.append(COMMA);
    L7:
        r2.append(r3[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(RBRACE);
    }

    private static void formatString(StringBuilder r2, Object r3) {
        r2.append('\"');
        int r1 = r2.length();
        r2.append(String.valueOf(r3));
        r.b(r2, r1);
        r2.append('\"');
    }

    static /* synthetic */ void lambda$formatCollection$1(boolean[] r2, StringBuilder r3, int r4, Object r5) {
        if (r2[0] == false) goto L5;
        r2[0] = false;
    L6:
        format(r3, r5, r4);
        return;
    L5:
        r3.append(COMMA);
        goto L6
    }

    static /* synthetic */ void lambda$formatMap$0(boolean[] r2, StringBuilder r3, int r4, Object r5, Object r6) {
        if (r5 == null) goto L10;
        if (r2[0] == false) goto L6;
        r2[0] = false;
    L7:
        r3.append('\"');
        String r7 = String.valueOf(r5);
        int r0 = r3.length();
        r3.append(r7);
        r.b(r3, r0);
        r3.append('\"').append(COLON);
        format(r3, r6, r4);
        return;
    L6:
        r3.append(COMMA);
        goto L7
    L10:
        throw new IllegalArgumentException("null keys are not allowed");
    }

    private static int readMaxDepth() {
        int r0 = PropertiesUtil.a().a("log4j2.mapMessage.jsonFormatter.maxDepth", 8);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("was expecting a positive maxDepth, found: " + r0);
    }

    public static MapMessageJsonFormatter valueOf(String r2) {
        return (MapMessageJsonFormatter) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapMessageJsonFormatter.class, r2), MapMessageJsonFormatter.class, "com.obric.memorydata.plugin");
    }

    public static MapMessageJsonFormatter[] values() {
        return (MapMessageJsonFormatter[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapMessageJsonFormatter[].class, "com.obric.memorydata.plugin");
    }
}
