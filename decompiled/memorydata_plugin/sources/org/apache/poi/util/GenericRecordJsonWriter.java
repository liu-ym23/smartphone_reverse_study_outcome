package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.PackedColorModel;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public class GenericRecordJsonWriter implements Closeable {
    private static final Pattern ESC_CHARS = null;
    private static final String NL = null;
    private static final String TABS = null;
    private static final List<Map.Entry<Class<?>, GenericRecordHandler>> handler = null;
    protected final AppendableWriter aw;
    protected int childIndex;
    protected final PrintWriter fw;
    protected int indent;
    protected boolean withComments;

    static class AppendableWriter extends Writer {
        private final Appendable appender;
        private String holdBack;
        private final Writer writer;

        AppendableWriter(Appendable r3) {
            Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
            super(r4);
            this.appender = r4;
            this.writer = null;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
            Object r0 = this.appender;
            if (r0 != null) goto L7;
            r0 = this.writer;
        L7:
            if (ZeusTransformUtils.instanceOf(r0, Closeable.class) == false) goto L10;
            ((Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin")).close();
            return;
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            Object r0 = this.appender;
            if (r0 != null) goto L7;
            r0 = this.writer;
        L7:
            if (ZeusTransformUtils.instanceOf(r0, Flushable.class) == false) goto L10;
            ((Flushable) ZeusTransformUtils.preCheckCast(r0, Flushable.class, "com.obric.memorydata.plugin")).flush();
            return;
        }

        void setHoldBack(String r1) {
            this.holdBack = r1;
        }

        @Override // java.io.Writer
        public void write(char[] r3, int r4, int r5) {
            String r0 = this.holdBack;
            if (r0 == null) goto L11;
            Appendable r1 = this.appender;
            if (r1 == null) goto L7;
            r1.append(r0);
        L10:
            this.holdBack = null;
            goto L11
        L7:
            Writer r2 = this.writer;
            if (r2 == null) goto L10;
            r2.write(r0);
        L11:
            Appendable r6 = this.appender;
            if (r6 == null) goto L14;
            r6.append(String.valueOf(r3), r4, r5);
            return;
        L14:
            Writer r7 = this.writer;
            if (r7 == null) goto L19;
            r7.write(r3, r4, r5);
            return;
        }
    }

    @FunctionalInterface
    protected interface GenericRecordHandler {
        boolean print(GenericRecordJsonWriter r1, String r2, Object r3);
    }

    static {
        ESC_CHARS = Pattern.compile("[\"\\p{Cntrl}\\\\]");
        NL = System.getProperty("line.separator");
        handler = new ArrayList();
        char[] r0 = new char[255];
        Arrays.fill(r0, '\t');
        TABS = new String(r0);
        handler(String.class, $$Lambda$CvTu9prmqMaGIxg5ULZ7e2UIDhM.INSTANCE);
        handler(Number.class, $$Lambda$k8kObtk1Vib1eRFeOrkASkjLNJ0.INSTANCE);
        handler(Boolean.class, $$Lambda$SUITXhQXPjSmcuXQSRM0PJYCoKo.INSTANCE);
        handler(List.class, $$Lambda$gV0UWuyYBW6ATb44npp_gNAHM.INSTANCE);
        handler(GenericRecord.class, $$Lambda$py9ZG9S0NNMwlhAch7GRq0M7u8.INSTANCE);
        handler(GenericRecordUtil.AnnotatedFlag.class, $$Lambda$ILp48gUnxGfgVfUMg9BrZzr0.INSTANCE);
        handler(byte[].class, $$Lambda$WcwkqMMQKAEG97PlaPTHDvuuqI.INSTANCE);
        handler(Point2D.class, $$Lambda$jETf1f8FBfxeRiJE3n4A1rFdSTA.INSTANCE);
        handler(Dimension2D.class, $$Lambda$Tg1KlIp4VUzrXIHKjxgDQKIeDXY.INSTANCE);
        handler(Rectangle2D.class, $$Lambda$LhffuuyhPqT4Eu25alhmniuntRs.INSTANCE);
        handler(Path2D.class, $$Lambda$f3Ut4qgIPaluyGH9l_8Zb0SRG0.INSTANCE);
        handler(AffineTransform.class, $$Lambda$vhMUGOgsxCmUS1CvZelE7T8J9VI.INSTANCE);
        handler(Color.class, $$Lambda$GhbCr3oLWYoeZHNquotAbs6aFTY.INSTANCE);
        handler(BufferedImage.class, $$Lambda$f4qwbSnVBzmVW1V9FBO9O9TMP0.INSTANCE);
        handler(Array.class, $$Lambda$uCS81hL2cQ8jCp8Gsq0bu12c4.INSTANCE);
        handler(Object.class, $$Lambda$CvTu9prmqMaGIxg5ULZ7e2UIDhM.INSTANCE);
    }

    public GenericRecordJsonWriter(Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        this.indent = 0;
        this.withComments = true;
        this.childIndex = 0;
        AppendableWriter r0 = new AppendableWriter(r4);
        this.aw = r0;
        this.fw = new PrintWriter(r0);
    }

    private static void handler(Class<?> r2, GenericRecordHandler r3) {
        GenericRecordHandler r4 = (GenericRecordHandler) ZeusTransformUtils.wrapperContextForParams(r3, GenericRecordHandler.class, "com.obric.memorydata.plugin");
        handler.add(new AbstractMap.SimpleEntry(r2, r4));
    }

    static /* synthetic */ boolean lambda$writeValue$2(Object r2, Map.Entry r3) {
        return matchInstanceOrArray((Class) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Class.class, "com.obric.memorydata.plugin"), r2);
    }

    public static String marshal(GenericRecord r2) {
        return marshal((GenericRecord) ZeusTransformUtils.wrapperContextForParams(r2, GenericRecord.class, "com.obric.memorydata.plugin"), true);
    }

    public static String marshal(GenericRecord r2, boolean r3) {
        GenericRecord r4 = (GenericRecord) ZeusTransformUtils.wrapperContextForParams(r2, GenericRecord.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        GenericRecordJsonWriter r1 = new GenericRecordJsonWriter(r0);     // Catch: IOException -> L15
        r1.setWithComments(r3);     // Catch: Throwable -> L7
        r1.write(r4);     // Catch: Throwable -> L7
        String r5 = r0.toString();     // Catch: Throwable -> L7
        r1.close();     // Catch: IOException -> L15
        return r5;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L15
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L15
    L15:
        return "{}";
    }

    public static boolean matchInstanceOrArray(Class<?> r1, Object r2) {
        if (ZeusTransformUtils.instanceOf(r1, r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (Array.class.equals(r1) == true) goto L7;
    L9:
        return false;
    L7:
        if (r2.getClass().isArray() == false) goto L9;
        goto L9
    }

    static String trimHex(long r4, int r6) {
        String r5 = Long.toHexString(r4);
        int r7 = r5.length();
        return "0000000000000000".substring(0, Math.max(0, r6 - r7)) + r5.substring(Math.max(0, r7 - r6), r7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.fw.close();
    }

    public /* synthetic */ void lambda$printList$3$GenericRecordJsonWriter(Object r2) {
        writeValue(null, r2);
        this.childIndex++;
    }

    public /* synthetic */ boolean lambda$writeChildren$1$GenericRecordJsonWriter(GenericRecord r3) {
        if (writeValue(null, (GenericRecord) ZeusTransformUtils.wrapperContextForParams(r3, GenericRecord.class, "com.obric.memorydata.plugin")) == false) goto L7;
        int r4 = this.childIndex + 1;
        this.childIndex = r4;
        if (r4 <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    public /* synthetic */ boolean lambda$writeProperties$0$GenericRecordJsonWriter(Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        return writeProp((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), (Supplier) ZeusTransformUtils.preCheckCast(r5.getValue(), Supplier.class, "com.obric.memorydata.plugin"));
    }

    public boolean printAffineTransform(String r3, Object r4) {
        printName(r3);
        AffineTransform r5 = (AffineTransform) ZeusTransformUtils.preCheckCast(r4, AffineTransform.class, "com.obric.memorydata.plugin");
        this.fw.write("{ \"scaleX\": " + r5.getScaleX() + ", \"shearX\": " + r5.getShearX() + ", \"transX\": " + r5.getTranslateX() + ", \"scaleY\": " + r5.getScaleY() + ", \"shearY\": " + r5.getShearY() + ", \"transY\": " + r5.getTranslateY() + " }");
        return true;
    }

    public boolean printAnnotatedFlag(String r4, Object r5) {
        printName(r4);
        GenericRecordUtil.AnnotatedFlag r6 = (GenericRecordUtil.AnnotatedFlag) ZeusTransformUtils.preCheckCast(r5, GenericRecordUtil.AnnotatedFlag.class, "com.obric.memorydata.plugin");
        this.fw.print(((Number) ZeusTransformUtils.preCheckCast(r6.getValue().get(), Number.class, "com.obric.memorydata.plugin")).longValue());
        if (this.withComments == false) goto L7;
        this.fw.write(" /* ");
        this.fw.write(r6.getDescription());
        this.fw.write(" */ ");
        return true;
    L7:
        return true;
    }

    public boolean printArray(String r5, Object r6) {
        printName(r5);
        this.fw.write("[");
        int r7 = Array.getLength(r6);
        int r0 = this.childIndex;
        int r1 = 0;
    L3:
        this.childIndex = r1;
        int r2 = this.childIndex;
        if (r2 >= r7) goto L6;
        writeValue(null, Array.get(r6, r2));
        r1 = this.childIndex + 1;
        goto L3
    L6:
        this.childIndex = r0;
        this.fw.write(tabs() + "\t]");
        return true;
    }

    public boolean printBoolean(String r2, Object r3) {
        printName(r2);
        this.fw.write(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).toString());
        return true;
    }

    public boolean printBytes(String r5, Object r6) {
        printName(r5);
        this.fw.write(34);
        this.fw.write(Base64.getEncoder().encodeToString((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
        this.fw.write(34);
        return true;
    }

    public boolean printColor(String r3, Object r4) {
        printName(r3);
        int r5 = ((Color) ZeusTransformUtils.preCheckCast(r4, Color.class, "com.obric.memorydata.plugin")).getRGB();
        this.fw.print(r5);
        if (this.withComments == false) goto L7;
        this.fw.write(" /* 0x");
        this.fw.write(trimHex(r5, 8));
        this.fw.write(" */");
        return true;
    L7:
        return true;
    }

    public boolean printDimension(String r3, Object r4) {
        printName(r3);
        Dimension2D r5 = (Dimension2D) ZeusTransformUtils.preCheckCast(r4, Dimension2D.class, "com.obric.memorydata.plugin");
        this.fw.write("{ \"width\": " + r5.getWidth() + ", \"height\": " + r5.getHeight() + " }");
        return true;
    }

    public boolean printGenericRecord(String r3, Object r4) {
        printName(r3);
        this.indent++;
        write((GenericRecord) ZeusTransformUtils.preCheckCast(r4, GenericRecord.class, "com.obric.memorydata.plugin"));
        this.indent--;
        return true;
    }

    public boolean printImage(String r17, Object r18) {
        BufferedImage r0 = (BufferedImage) ZeusTransformUtils.preCheckCast(r18, BufferedImage.class, "com.obric.memorydata.plugin");
        String[] r1 = {"XYZ", "Lab", "Luv", "YCbCr", "Yxy", "RGB", "GRAY", "HSV", "HLS", "CMYK", "Unknown", "CMY", "Unknown"};
        String[] r2 = {"CUSTOM", "INT_RGB", "INT_ARGB", "INT_ARGB_PRE", "INT_BGR", "3BYTE_BGR", "4BYTE_ABGR", "4BYTE_ABGR_PRE", "USHORT_565_RGB", "USHORT_555_RGB", "BYTE_GRAY", "USHORT_GRAY", "BYTE_BINARY", "BYTE_INDEXED"};
        printName(r17);
        ColorModel r3 = r0.getColorModel();
        if (ZeusTransformUtils.instanceOf(r3, IndexColorModel.class) == false) goto L7;
        String r4 = "indexed";
    L16:
        this.fw.write("{ \"width\": " + r0.getWidth() + ", \"height\": " + r0.getHeight() + ", \"type\": \"" + r2[r0.getType()] + "\", \"colormodel\": \"" + r4 + "\", \"pixelBits\": " + r3.getPixelSize() + ", \"numComponents\": " + r3.getNumComponents() + ", \"colorSpace\": \"" + r1[Math.min(r3.getColorSpace().getType(), 12)] + "\", \"transparency\": " + r3.getTransparency() + ", \"alpha\": " + r3.hasAlpha() + "}");
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ComponentColorModel.class) == false) goto L10;
        r4 = "component";
        goto L16
    L10:
        if (ZeusTransformUtils.instanceOf(r3, DirectColorModel.class) == false) goto L13;
        r4 = "direct";
        goto L16
    L13:
        if (ZeusTransformUtils.instanceOf(r3, PackedColorModel.class) == false) goto L15;
        r4 = "packed";
        goto L16
    L15:
        r4 = "unknown";
        goto L16
    }

    public boolean printList(String r3, Object r4) {
        printName(r3);
        this.fw.println("[");
        int r5 = this.childIndex;
        this.childIndex = 0;
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).forEach(new $$Lambda$GenericRecordJsonWriter$fWsxj9TFUE7id2p3HW1jh_S2wY(this));
        this.childIndex = r5;
        this.fw.write(tabs() + "\t]");
        return true;
    }

    public void printName(String r3) {
        PrintWriter r2 = this.fw;
        if (r3 == null) goto L5;
        String r4 = "\"" + r3 + "\": ";
    L6:
        r2.print(r4);
        return;
    L5:
        r4 = "";
        goto L6
    }

    public boolean printNull(String r1, Object r2) {
        printName(r1);
        this.fw.write("null");
        return true;
    }

    public boolean printNumber(String r7, Object r8) {
        Number r0 = (Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin");
        printName(r7);
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L7;
        this.fw.print(r0.floatValue());
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L10;
        this.fw.print(r0.doubleValue());
        return true;
    L10:
        this.fw.print(r0.longValue());
        if (ZeusTransformUtils.instanceOf(r0, Byte.class) == false) goto L14;
        int r9 = 2;
    L23:
        long r2 = r0.longValue();
        if (this.withComments == false) goto L31;
        if (r9 <= 0) goto L31;
        if (r2 >= 0) goto L29;
    L30:
        this.fw.write(" /* 0x");
        this.fw.write(trimHex(r2, r9));
        this.fw.write(" */");
        goto L31
    L29:
        if (r2 > 9) goto L30;
    L31:
        return true;
    L14:
        if (ZeusTransformUtils.instanceOf(r0, Short.class) == false) goto L17;
        r9 = 4;
        goto L23
    L17:
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == false) goto L20;
        r9 = 8;
        goto L23
    L20:
        if (ZeusTransformUtils.instanceOf(r0, Long.class) == false) goto L22;
        r9 = 16;
        goto L23
    L22:
        r9 = -1;
        goto L23
    }

    public boolean printObject(String r8, Object r9) {
        printName(r8);
        this.fw.write(34);
        String r10 = r9.toString();
        Matcher r11 = ESC_CHARS.matcher(r10);
        int r2 = 0;
    L3:
        byte r4 = 1;
        if (r11.find() == false) goto L46;
        this.fw.append(r10, r2, r11.start());
        String r3 = r11.group();
        r3.hashCode();
        switch(r3.hashCode()) {
            case 8: goto L32;
            case 9: goto L29;
            case 10: goto L25;
            case 12: goto L21;
            case 13: goto L17;
            case 34: goto L13;
            case 92: goto L9;
            default: goto L7;
        };
    L7:
        r4 = -1;
    L35:
        switch(r4) {
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            default: goto L36;
        };
    L36:
        this.fw.write("\\\\u");
        this.fw.write(trimHex(r3.charAt(0), 4));
    L45:
        r2 = r11.end();
        goto L3
    L37:
        PrintWriter r5 = this.fw;
        String r6 = "\\\\\\\\";
    L42:
        r5.write(r6);
        goto L45
    L38:
        r5 = this.fw;
        r6 = "\\\\\"";
        goto L42
    L39:
        r5 = this.fw;
        r6 = "\\\\r";
        goto L42
    L40:
        r5 = this.fw;
        r6 = "\\\\f";
        goto L42
    L41:
        r5 = this.fw;
        r6 = "\\\\n";
        goto L42
    L43:
        r5 = this.fw;
        r6 = "\\\\t";
        goto L42
    L44:
        r5 = this.fw;
        r6 = "\\\\b";
        goto L42
    L9:
        if (r3.equals("\\") == false) goto L51;
        r4 = 6;
        goto L35
    L51:
        r4 = -1;
        goto L35
    L13:
        if (r3.equals("\"") == false) goto L52;
        r4 = 5;
        goto L35
    L52:
        r4 = -1;
        goto L35
    L17:
        if (r3.equals("\r") == false) goto L53;
        r4 = 4;
        goto L35
    L53:
        r4 = -1;
        goto L35
    L21:
        if (r3.equals("\f") == false) goto L54;
        r4 = 3;
        goto L35
    L54:
        r4 = -1;
        goto L35
    L25:
        if (r3.equals("\n") == false) goto L55;
        r4 = 2;
        goto L35
    L55:
        r4 = -1;
        goto L35
    L29:
        if (r3.equals("\t") == true) goto L35;
        r4 = -1;
        goto L35
    L32:
        if (r3.equals("\b") == false) goto L57;
        r4 = 0;
        goto L35
    L57:
        r4 = -1;
        goto L35
    L46:
        this.fw.append(r10, r2, r10.length());
        this.fw.write(34);
        return true;
    }

    public boolean printPath(String r14, Object r15) {
        printName(r14);
        PathIterator r16 = ((Path2D) ZeusTransformUtils.preCheckCast(r15, Path2D.class, "com.obric.memorydata.plugin")).getPathIterator(null);
        double[] r17 = new double[6];
        this.fw.write("[");
        this.indent += 2;
        String r0 = tabs();
        this.indent -= 2;
        boolean r4 = false;
    L4:
        if (r16.isDone() == true) goto L26;
        PrintWriter r5 = this.fw;
        if (r4 == false) goto L8;
        String r6 = ", ";
    L9:
        r5.println(r6);
        this.fw.print(r0);
        int r7 = r16.currentSegment(r17);
        this.fw.append("{ \"type\": ");
        if (r7 == 0) goto L22;
        if (r7 != 1) goto L13;
        PrintWriter r8 = this.fw;
        StringBuilder r9 = new StringBuilder().append("\"lineto\", \"x\": ").append(r17[0]).append(", \"y\": ");
        double r10 = r17[1];
    L23:
        String r11 = r9.append(r10).toString();
    L24:
        r8.write(r11);
    L25:
        this.fw.append(" }");
        r16.next();
        r4 = true;
        goto L4
    L13:
        if (r7 != 2) goto L15;
        r8 = this.fw;
        r9 = new StringBuilder().append("\"quad\", \"x1\": ").append(r17[0]).append(", \"y1\": ").append(r17[1]).append(", \"x2\": ").append(r17[2]).append(", \"y2\": ");
        r10 = r17[3];
        goto L23
    L15:
        if (r7 == 3) goto L19;
        if (r7 != 4) goto L25;
        r8 = this.fw;
        r11 = "\"close\"";
        goto L24
    L19:
        r8 = this.fw;
        r9 = new StringBuilder().append("\"cubic\", \"x1\": ").append(r17[0]).append(", \"y1\": ").append(r17[1]).append(", \"x2\": ").append(r17[2]).append(", \"y2\": ").append(r17[3]).append(", \"x3\": ").append(r17[4]).append(", \"y3\": ");
        r10 = r17[5];
        goto L23
    L22:
        r8 = this.fw;
        r9 = new StringBuilder().append("\"move\", \"x\": ").append(r17[0]).append(", \"y\": ");
        r10 = r17[1];
        goto L23
    L8:
        r6 = "";
        goto L9
    L26:
        this.fw.write("]");
        return true;
    }

    public boolean printPoint(String r3, Object r4) {
        printName(r3);
        Point2D r5 = (Point2D) ZeusTransformUtils.preCheckCast(r4, Point2D.class, "com.obric.memorydata.plugin");
        this.fw.write("{ \"x\": " + r5.getX() + ", \"y\": " + r5.getY() + " }");
        return true;
    }

    public boolean printRectangle(String r3, Object r4) {
        printName(r3);
        Rectangle2D r5 = (Rectangle2D) ZeusTransformUtils.preCheckCast(r4, Rectangle2D.class, "com.obric.memorydata.plugin");
        this.fw.write("{ \"x\": " + r5.getX() + ", \"y\": " + r5.getY() + ", \"width\": " + r5.getWidth() + ", \"height\": " + r5.getHeight() + " }");
        return true;
    }

    public void setWithComments(boolean r1) {
        this.withComments = r1;
    }

    public String tabs() {
        String r0 = TABS;
        return r0.substring(0, Math.min(this.indent, r0.length()));
    }

    public void write(GenericRecord r5) {
        GenericRecord r6 = (GenericRecord) ZeusTransformUtils.wrapperContextForParams(r5, GenericRecord.class, "com.obric.memorydata.plugin");
        String r0 = tabs();
        Enum<?> r1 = r6.getGenericRecordType();
        if (r1 == null) goto L5;
        String r2 = r1.name();
    L6:
        this.fw.append(r0);
        this.fw.append("{");
        if (this.withComments == false) goto L12;
        this.fw.append("   /* ");
        this.fw.append(r2);
        if (this.childIndex <= 0) goto L11;
        this.fw.append(" - index: ");
        this.fw.print(this.childIndex);
    L11:
        this.fw.append(" */");
    L12:
        this.fw.println();
        boolean r3 = writeProperties(r6);
        this.fw.println();
        writeChildren(r6, r3);
        this.fw.append(r0);
        this.fw.append("}");
        return;
    L5:
        r2 = r6.getClass().getSimpleName();
        goto L6
    }

    public boolean writeChildren(GenericRecord r6, boolean r7) {
        List<? extends GenericRecord> r8 = ((GenericRecord) ZeusTransformUtils.wrapperContextForParams(r6, GenericRecord.class, "com.obric.memorydata.plugin")).getGenericChildren();
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.isEmpty() == true) goto L20;
        this.indent++;
        AppendableWriter r1 = this.aw;
        StringBuilder r3 = new StringBuilder().append(tabs());
        if (r7 == false) goto L10;
        String r9 = ", ";
    L11:
        r1.setHoldBack(r3.append(r9).append("\"children\": [").append(NL).toString());
        int r10 = this.childIndex;
        this.childIndex = 0;
        long r4 = r8.stream().filter(new $$Lambda$GenericRecordJsonWriter$lNOkyM8v88cpaDvO2NfD7wHwI(this)).count();
        this.childIndex = r10;
        this.aw.setHoldBack(null);
        if (r4 <= 0) goto L14;
        this.fw.println();
        this.fw.println(tabs() + "]");
    L14:
        this.indent--;
        if (r4 > 0) goto L17;
        return false;
    L17:
        return true;
    L10:
        r9 = "";
        goto L11
    L20:
        return false;
    }

    public boolean writeProp(String r5, Supplier<?> r6) {
        Supplier r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r6, Supplier.class, "com.obric.memorydata.plugin");
        if (this.childIndex <= 0) goto L5;
        boolean r0 = true;
    L6:
        AppendableWriter r2 = this.aw;
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder().append(NL).append(tabs());
        String r3 = "\t, ";
    L10:
        r2.setHoldBack(r1.append(r3).toString());
        int r4 = this.childIndex;
        this.childIndex = 0;
        boolean r8 = writeValue(r5, r7.get());
        this.childIndex = r4 + (r8 ? 1 : 0);
        this.aw.setHoldBack(null);
        return r8;
    L9:
        r1 = new StringBuilder().append(tabs());
        r3 = "\t  ";
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public boolean writeProperties(GenericRecord r5) {
        Map<String, Supplier<?>> r6 = ((GenericRecord) ZeusTransformUtils.wrapperContextForParams(r5, GenericRecord.class, "com.obric.memorydata.plugin")).getGenericProperties();
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r6.isEmpty() == true) goto L13;
        int r1 = this.childIndex;
        this.childIndex = 0;
        long r2 = r6.entrySet().stream().filter(new $$Lambda$GenericRecordJsonWriter$1GXdYNM1PgoyQzRhdPpsK3q2sI0(this)).count();
        this.childIndex = r1;
        if (r2 <= 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public boolean writeValue(String r5, final Object r6) {
        if (this.childIndex <= 0) goto L6;
        this.aw.setHoldBack(",");
    L6:
        if (r6 != null) goto L8;
        GenericRecordHandler r1 = $$Lambda$l5m_OR9U9TyU6qyqfnTx5_tiNh0.INSTANCE;
    L9:
        if (r1 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        this.aw.setHoldBack(null);
        return r7;
    L11:
        if (r1.print(this, r5, r6) == false) goto L13;
        r7 = true;
        goto L14
    L8:
        r1 = (GenericRecordHandler) ZeusTransformUtils.preCheckCast(handler.stream().filter(new $$Lambda$GenericRecordJsonWriter$ZjcpaMSrojtY6TSMwmbXdcALg(r6)).findFirst().map($$Lambda$x9zrsCdlvEwC5WbyaeA4HfAJ43g.INSTANCE).orElse(null), GenericRecordHandler.class, "com.obric.memorydata.plugin");
        goto L9
    }
}
