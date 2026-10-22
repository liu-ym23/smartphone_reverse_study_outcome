package org.apache.poi.hwmf.record;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfText {
    private static final c LOG = null;
    private static int MAX_RECORD_LENGTH;

    /* JADX INFO: renamed from: org.apache.poi.hwmf.record.HwmfText$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment = null;

        static {
            int[] r0 = new int[HwmfTextAlignment.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment = r0;
            r0[HwmfTextAlignment.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment[HwmfTextAlignment.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment[HwmfTextAlignment.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[HwmfTextVerticalAlignment.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment = r3;
            r3[HwmfTextVerticalAlignment.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment[HwmfTextVerticalAlignment.BASELINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment[HwmfTextVerticalAlignment.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static final enum HwmfTextAlignment extends Enum<HwmfTextAlignment> {
        private static final /* synthetic */ HwmfTextAlignment[] $VALUES = null;
        public static final HwmfTextAlignment CENTER = null;
        public static final HwmfTextAlignment LEFT = null;
        public static final HwmfTextAlignment RIGHT = null;

        static {
            HwmfTextAlignment r0 = new HwmfTextAlignment("LEFT", 0);
            LEFT = r0;
            HwmfTextAlignment r1 = new HwmfTextAlignment("RIGHT", 1);
            RIGHT = r1;
            HwmfTextAlignment r3 = new HwmfTextAlignment("CENTER", 2);
            CENTER = r3;
            $VALUES = new HwmfTextAlignment[]{r0, r1, r3};
        }

        private HwmfTextAlignment(String r1, int r2) {
            super(r1, r2);
        }

        public static HwmfTextAlignment valueOf(String r2) {
            return (HwmfTextAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfTextAlignment.class, r2), HwmfTextAlignment.class, "com.obric.memorydata.plugin");
        }

        public static HwmfTextAlignment[] values() {
            return (HwmfTextAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfTextAlignment[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum HwmfTextVerticalAlignment extends Enum<HwmfTextVerticalAlignment> {
        private static final /* synthetic */ HwmfTextVerticalAlignment[] $VALUES = null;
        public static final HwmfTextVerticalAlignment BASELINE = null;
        public static final HwmfTextVerticalAlignment BOTTOM = null;
        public static final HwmfTextVerticalAlignment TOP = null;

        static {
            HwmfTextVerticalAlignment r0 = new HwmfTextVerticalAlignment("TOP", 0);
            TOP = r0;
            HwmfTextVerticalAlignment r1 = new HwmfTextVerticalAlignment("BOTTOM", 1);
            BOTTOM = r1;
            HwmfTextVerticalAlignment r3 = new HwmfTextVerticalAlignment("BASELINE", 2);
            BASELINE = r3;
            $VALUES = new HwmfTextVerticalAlignment[]{r0, r1, r3};
        }

        private HwmfTextVerticalAlignment(String r1, int r2) {
            super(r1, r2);
        }

        public static HwmfTextVerticalAlignment valueOf(String r2) {
            return (HwmfTextVerticalAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfTextVerticalAlignment.class, r2), HwmfTextVerticalAlignment.class, "com.obric.memorydata.plugin");
        }

        public static HwmfTextVerticalAlignment[] values() {
            return (HwmfTextVerticalAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfTextVerticalAlignment[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class WmfCreateFontIndirect implements HwmfRecord {
        protected final HwmfFont font;

        public WmfCreateFontIndirect() {
            this(new HwmfFont());
        }

        public WmfCreateFontIndirect(HwmfFont r1) {
            this.font = r1;
        }

        public HwmfFont getFont() {
            return this.font;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("font", new $$Lambda$fTpjejUJ5eHnsgyaU7_o0Nf3ISU(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.createFontIndirect;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfExtTextOut implements HwmfRecord {
        protected final Rectangle2D bounds;
        protected Supplier<Charset> charsetProvider;
        protected final List<Integer> dx;
        protected final WmfExtTextOutOptions options;
        protected byte[] rawTextBytes;
        protected final Point2D reference;
        protected int stringLength;

        public WmfExtTextOut() {
            this(new WmfExtTextOutOptions());
        }

        public WmfExtTextOut(WmfExtTextOutOptions r2) {
            this.reference = new Point2D.Double();
            this.bounds = new Rectangle2D.Double();
            this.dx = new ArrayList();
            this.charsetProvider = $$Lambda$HwmfText$WmfExtTextOut$0e5BLVBGjCbZ7i27IPiyzVNEuU.INSTANCE;
            this.options = r2;
        }

        private String getGenericText() {
        L8:
            return "";
        L3:
            if (isUnicode() == false) goto L5;
            Charset r0 = StandardCharsets.UTF_16LE;     // Catch: IOException -> L8
        L6:
            return getText(r0);
        L5:
            r0 = (Charset) ZeusTransformUtils.preCheckCast(this.charsetProvider.get(), Charset.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L8
            goto L6
        }

        public static /* synthetic */ String lambda$lB03nXbevw_RN2S0brTL3v0AVD4(WmfExtTextOut r0) {
            return r0.getGenericText();
        }

        static /* synthetic */ Charset lambda$new$0() {
            return LocaleUtil.CHARSET_1252;
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("reference", new $$Lambda$zCpXUhCLxVLK5wz3Jl_QAp9aA8(this), "bounds", new $$Lambda$l_KHZEa6Cc7yqxwGnNfmqhdo(this), "options", new $$Lambda$u0NAjqcvO6SgaoKdyCRE3MmikM(this), IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$HwmfText$WmfExtTextOut$lB03nXbevw_RN2S0brTL3v0AVD4(this), "dx", new $$Lambda$HwmfText$WmfExtTextOut$WCA3i1aS1LsS7tYGcc2mM0xhSYU(this));
        }

        public WmfExtTextOutOptions getOptions() {
            return this.options;
        }

        public Point2D getReference() {
            return this.reference;
        }

        public String getText(Charset r3) {
            if (this.rawTextBytes != null) goto L6;
            return "";
        L6:
            String r0 = new String(this.rawTextBytes, r3);
            return r0.substring(0, Math.min(r0.length(), this.stringLength));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.extTextOut;
        }

        public boolean isUnicode() {
            return false;
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HwmfText$WmfExtTextOut() {
            return this.dx;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfExtTextOutOptions implements GenericRecord {
        private static final BitField ETO_CLIPPED = null;
        private static final BitField ETO_GLYPH_INDEX = null;
        private static final BitField ETO_IGNORELANGUAGE = null;
        private static final BitField ETO_NO_RECT = null;
        private static final BitField ETO_NUMERICSLATIN = null;
        private static final BitField ETO_NUMERICSLOCAL = null;
        private static final BitField ETO_OPAQUE = null;
        private static final BitField ETO_PDY = null;
        private static final BitField ETO_REVERSE_INDEX_MAP = null;
        private static final BitField ETO_RTLREADING = null;
        private static final BitField ETO_SMALL_CHARS = null;
        private static final int[] FLAGS_MASKS = null;
        private static final String[] FLAGS_NAMES = null;
        protected int flags;

        static {
            ETO_OPAQUE = BitFieldFactory.getInstance(2);
            ETO_CLIPPED = BitFieldFactory.getInstance(4);
            ETO_GLYPH_INDEX = BitFieldFactory.getInstance(16);
            ETO_RTLREADING = BitFieldFactory.getInstance(128);
            ETO_NO_RECT = BitFieldFactory.getInstance(256);
            ETO_SMALL_CHARS = BitFieldFactory.getInstance(512);
            ETO_NUMERICSLOCAL = BitFieldFactory.getInstance(1024);
            ETO_NUMERICSLATIN = BitFieldFactory.getInstance(2048);
            ETO_IGNORELANGUAGE = BitFieldFactory.getInstance(4096);
            ETO_PDY = BitFieldFactory.getInstance(8192);
            ETO_REVERSE_INDEX_MAP = BitFieldFactory.getInstance(65536);
            FLAGS_MASKS = new int[]{2, 4, 16, 128, 256, 512, 1024, 2048, 4096, 8192, 65536};
            FLAGS_NAMES = new String[]{"OPAQUE", "CLIPPED", "GLYPH_INDEX", "RTLREADING", "NO_RECT", "SMALL_CHARS", "NUMERICSLOCAL", "NUMERICSLATIN", "IGNORELANGUAGE", "PDY", "REVERSE_INDEX_MAP"};
        }

        public WmfExtTextOutOptions() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$HwmfText$WmfExtTextOutOptions$CHtlmrnewElUyRsJkvdizyafOg(this), FLAGS_MASKS, FLAGS_NAMES));
        }

        public /* synthetic */ Number lambda$getGenericProperties$0$HwmfText$WmfExtTextOutOptions() {
            return Integer.valueOf(this.flags);
        }
    }

    public static class WmfSetTextAlign implements HwmfRecord {
        private static final BitField ALIGN_MASK = null;
        private static final BitField TA_RTLREADING = null;
        private static final BitField TA_UPDATECP = null;
        private static final BitField VALIGN_MASK = null;
        protected int textAlignmentMode;

        static {
            TA_UPDATECP = BitFieldFactory.getInstance(1);
            TA_RTLREADING = BitFieldFactory.getInstance(256);
            ALIGN_MASK = BitFieldFactory.getInstance(6);
            VALIGN_MASK = BitFieldFactory.getInstance(24);
        }

        public WmfSetTextAlign() {
        }

        private HwmfTextAlignment getAlignAsian() {
            int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextVerticalAlignment[getVAlignLatin().ordinal()];
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L9;
            return HwmfTextAlignment.RIGHT;
        L9:
            return HwmfTextAlignment.LEFT;
        L11:
            return HwmfTextAlignment.CENTER;
        }

        private HwmfTextAlignment getAlignLatin() {
            int r1 = ALIGN_MASK.getValue(this.textAlignmentMode);
            if (r1 == 1) goto L11;
            if (r1 == 3) goto L9;
            return HwmfTextAlignment.LEFT;
        L9:
            return HwmfTextAlignment.CENTER;
        L11:
            return HwmfTextAlignment.RIGHT;
        }

        private HwmfTextVerticalAlignment getVAlignAsian() {
            int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$hwmf$record$HwmfText$HwmfTextAlignment[getAlignLatin().ordinal()];
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L9;
            return HwmfTextVerticalAlignment.TOP;
        L9:
            return HwmfTextVerticalAlignment.BOTTOM;
        L11:
            return HwmfTextVerticalAlignment.BASELINE;
        }

        private HwmfTextVerticalAlignment getVAlignLatin() {
            int r1 = VALIGN_MASK.getValue(this.textAlignmentMode);
            if (r1 == 1) goto L11;
            if (r1 == 3) goto L9;
            return HwmfTextVerticalAlignment.TOP;
        L9:
            return HwmfTextVerticalAlignment.BASELINE;
        L11:
            return HwmfTextVerticalAlignment.BOTTOM;
        }

        public static /* synthetic */ HwmfTextAlignment lambda$7R65lzQKWUHQL9k0RhdoEboRPUA(WmfSetTextAlign r0) {
            return r0.getAlignAsian();
        }

        public static /* synthetic */ HwmfTextVerticalAlignment lambda$H4EouSosrGZh_y84BA8oXz2oCIc(WmfSetTextAlign r0) {
            return r0.getVAlignAsian();
        }

        public static /* synthetic */ HwmfTextAlignment lambda$MCB2nrdmFYV6_2aB5mpCFqqPDv8(WmfSetTextAlign r0) {
            return r0.getAlignLatin();
        }

        /* JADX INFO: renamed from: lambda$P06-kJBjkQ87bd8_O9tXFrue_I4, reason: not valid java name */
        public static /* synthetic */ HwmfTextVerticalAlignment m3170lambda$P06kJBjkQ87bd8_O9tXFrue_I4(WmfSetTextAlign r0) {
            return r0.getVAlignLatin();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("align", new $$Lambda$HwmfText$WmfSetTextAlign$MCB2nrdmFYV6_2aB5mpCFqqPDv8(this), "valign", new $$Lambda$HwmfText$WmfSetTextAlign$P06kJBjkQ87bd8_O9tXFrue_I4(this), "alignAsian", new $$Lambda$HwmfText$WmfSetTextAlign$7R65lzQKWUHQL9k0RhdoEboRPUA(this), "valignAsian", new $$Lambda$HwmfText$WmfSetTextAlign$H4EouSosrGZh_y84BA8oXz2oCIc(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setTextAlign;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetTextCharExtra implements HwmfRecord {
        private int charExtra;

        public WmfSetTextCharExtra() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("charExtra", new $$Lambda$HwmfText$WmfSetTextCharExtra$FmPHyKRn_blffp6_rUMWxIyYCuo(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setTextCharExtra;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfText$WmfSetTextCharExtra() {
            return Integer.valueOf(this.charExtra);
        }
    }

    public static class WmfSetTextColor implements HwmfRecord {
        protected final HwmfColorRef colorRef;

        public WmfSetTextColor() {
            this.colorRef = new HwmfColorRef();
        }

        public HwmfColorRef getColorRef() {
            return this.colorRef;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("colorRef", new $$Lambda$ONSZ5s7rGBegC16yc7tB5ktRqY(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setTextColor;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetTextJustification implements HwmfRecord {
        private int breakCount;
        private int breakExtra;

        public WmfSetTextJustification() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("breakCount", new $$Lambda$HwmfText$WmfSetTextJustification$7YQMmVlliOhLo6Sxi0V7eUwTZA(this), "breakExtra", new $$Lambda$HwmfText$WmfSetTextJustification$GNUkEKd4HLMY4d58WiHWlyPiAX4(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setTextJustification;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfText$WmfSetTextJustification() {
            return Integer.valueOf(this.breakCount);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HwmfText$WmfSetTextJustification() {
            return Integer.valueOf(this.breakExtra);
        }
    }

    public static class WmfTextOut implements HwmfRecord {
        protected Supplier<Charset> charsetProvider;
        private byte[] rawTextBytes;
        protected Point2D reference;
        private int stringLength;

        public WmfTextOut() {
            this.reference = new Point2D.Double();
            this.charsetProvider = $$Lambda$HwmfText$WmfTextOut$wHvfXEN1wzfyWwo8RmAnj_U5lw.INSTANCE;
        }

        private byte[] getTextBytes() {
            return IOUtils.safelyClone(this.rawTextBytes, 0, this.stringLength, HwmfText.access$000());
        }

        static /* synthetic */ Charset lambda$new$0() {
            return LocaleUtil.CHARSET_1252;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$HwmfText$WmfTextOut$omVG6LQmA57Nr0XKaE9rghlWppw(this), "reference", new $$Lambda$HwmfText$WmfTextOut$oCJpa9Dp5tAxsygUQugtHH0BiOs(this));
        }

        public String getText(Charset r2) {
            return new String(getTextBytes(), r2);
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.textOut;
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HwmfText$WmfTextOut() {
            return getText((Charset) ZeusTransformUtils.preCheckCast(this.charsetProvider.get(), Charset.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HwmfText$WmfTextOut() {
            return this.reference;
        }
    }

    static {
        LOG = b.a(HwmfText.class);
        MAX_RECORD_LENGTH = 1000000;
    }

    public HwmfText() {
    }

    static /* synthetic */ int access$000() {
        return MAX_RECORD_LENGTH;
    }
}
