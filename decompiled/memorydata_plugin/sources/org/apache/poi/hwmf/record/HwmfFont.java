package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfFont implements GenericRecord, FontInfo {
    protected FontCharset charSet;
    protected final WmfClipPrecision clipPrecision;
    protected int escapement;
    protected String facename;
    protected double height;
    protected boolean italic;
    protected WmfOutPrecision outPrecision;
    protected int pitchAndFamily;
    protected WmfFontQuality quality;
    protected boolean strikeOut;
    protected boolean underline;
    protected int weight;
    protected int width;

    public static class WmfClipPrecision implements GenericRecord {
        private static final BitField CHARACTER_PRECIS = null;
        private static final BitField DEFAULT_PRECIS = null;
        private static final BitField DFA_DISABLE = null;
        private static final BitField EMBEDDED = null;
        private static final int[] FLAG_MASKS = null;
        private static final String[] FLAG_NAMES = null;
        private static final BitField LH_ANGLES = null;
        private static final BitField STROKE_PRECIS = null;
        private static final BitField TT_ALWAYS = null;
        private int flag;

        static {
            DEFAULT_PRECIS = BitFieldFactory.getInstance(3);
            CHARACTER_PRECIS = BitFieldFactory.getInstance(1);
            STROKE_PRECIS = BitFieldFactory.getInstance(2);
            LH_ANGLES = BitFieldFactory.getInstance(16);
            TT_ALWAYS = BitFieldFactory.getInstance(32);
            DFA_DISABLE = BitFieldFactory.getInstance(64);
            EMBEDDED = BitFieldFactory.getInstance(128);
            FLAG_MASKS = new int[]{1, 2, 16, 32, 64, 128};
            FLAG_NAMES = new String[]{"CHARACTER_PRECIS", "STROKE_PRECIS", "LH_ANGLES", "TT_ALWAYS", "DFA_DISABLE", "EMBEDDED"};
        }

        public WmfClipPrecision() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("isDefaultPrecision", new $$Lambda$LAt72wNKGcOCSK5hT5wtF_j_S1I(this), "flag", GenericRecordUtil.getBitsAsString(new $$Lambda$HwmfFont$WmfClipPrecision$OJHmLsMcfJQU08avam_nE5hkRk(this), FLAG_MASKS, FLAG_NAMES));
        }

        public boolean isDefaultPrecision() {
            return !DEFAULT_PRECIS.isSet(this.flag);
        }

        public /* synthetic */ Number lambda$getGenericProperties$0$HwmfFont$WmfClipPrecision() {
            return Integer.valueOf(this.flag);
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static final enum WmfFontQuality extends Enum<WmfFontQuality> {
        private static final /* synthetic */ WmfFontQuality[] $VALUES = null;
        public static final WmfFontQuality ANTIALIASED_QUALITY = null;
        public static final WmfFontQuality CLEARTYPE_QUALITY = null;
        public static final WmfFontQuality DEFAULT_QUALITY = null;
        public static final WmfFontQuality DRAFT_QUALITY = null;
        public static final WmfFontQuality NONANTIALIASED_QUALITY = null;
        public static final WmfFontQuality PROOF_QUALITY = null;
        int flag;

        static {
            WmfFontQuality r0 = new WmfFontQuality("DEFAULT_QUALITY", 0, 0);
            DEFAULT_QUALITY = r0;
            WmfFontQuality r1 = new WmfFontQuality("DRAFT_QUALITY", 1, 1);
            DRAFT_QUALITY = r1;
            WmfFontQuality r3 = new WmfFontQuality("PROOF_QUALITY", 2, 2);
            PROOF_QUALITY = r3;
            WmfFontQuality r5 = new WmfFontQuality("NONANTIALIASED_QUALITY", 3, 3);
            NONANTIALIASED_QUALITY = r5;
            WmfFontQuality r7 = new WmfFontQuality("ANTIALIASED_QUALITY", 4, 4);
            ANTIALIASED_QUALITY = r7;
            WmfFontQuality r9 = new WmfFontQuality("CLEARTYPE_QUALITY", 5, 5);
            CLEARTYPE_QUALITY = r9;
            $VALUES = new WmfFontQuality[]{r0, r1, r3, r5, r7, r9};
        }

        private WmfFontQuality(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        public static WmfFontQuality valueOf(int r5) {
            WmfFontQuality[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            WmfFontQuality r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static WmfFontQuality valueOf(String r2) {
            return (WmfFontQuality) ZeusTransformUtils.preCheckCast(Enum.valueOf(WmfFontQuality.class, r2), WmfFontQuality.class, "com.obric.memorydata.plugin");
        }

        public static WmfFontQuality[] values() {
            return (WmfFontQuality[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WmfFontQuality[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum WmfOutPrecision extends Enum<WmfOutPrecision> {
        private static final /* synthetic */ WmfOutPrecision[] $VALUES = null;
        public static final WmfOutPrecision OUT_DEFAULT_PRECIS = null;
        public static final WmfOutPrecision OUT_DEVICE_PRECIS = null;
        public static final WmfOutPrecision OUT_OUTLINE_PRECIS = null;
        public static final WmfOutPrecision OUT_PS_ONLY_PRECIS = null;
        public static final WmfOutPrecision OUT_RASTER_PRECIS = null;
        public static final WmfOutPrecision OUT_SCREEN_OUTLINE_PRECIS = null;
        public static final WmfOutPrecision OUT_STRING_PRECIS = null;
        public static final WmfOutPrecision OUT_STROKE_PRECIS = null;
        public static final WmfOutPrecision OUT_TT_ONLY_PRECIS = null;
        public static final WmfOutPrecision OUT_TT_PRECIS = null;
        int flag;

        static {
            WmfOutPrecision r0 = new WmfOutPrecision("OUT_DEFAULT_PRECIS", 0, 0);
            OUT_DEFAULT_PRECIS = r0;
            WmfOutPrecision r1 = new WmfOutPrecision("OUT_STRING_PRECIS", 1, 1);
            OUT_STRING_PRECIS = r1;
            WmfOutPrecision r3 = new WmfOutPrecision("OUT_STROKE_PRECIS", 2, 3);
            OUT_STROKE_PRECIS = r3;
            WmfOutPrecision r5 = new WmfOutPrecision("OUT_TT_PRECIS", 3, 4);
            OUT_TT_PRECIS = r5;
            WmfOutPrecision r8 = new WmfOutPrecision("OUT_DEVICE_PRECIS", 4, 5);
            OUT_DEVICE_PRECIS = r8;
            WmfOutPrecision r10 = new WmfOutPrecision("OUT_RASTER_PRECIS", 5, 6);
            OUT_RASTER_PRECIS = r10;
            WmfOutPrecision r12 = new WmfOutPrecision("OUT_TT_ONLY_PRECIS", 6, 7);
            OUT_TT_ONLY_PRECIS = r12;
            WmfOutPrecision r14 = new WmfOutPrecision("OUT_OUTLINE_PRECIS", 7, 8);
            OUT_OUTLINE_PRECIS = r14;
            WmfOutPrecision r13 = new WmfOutPrecision("OUT_SCREEN_OUTLINE_PRECIS", 8, 9);
            OUT_SCREEN_OUTLINE_PRECIS = r13;
            WmfOutPrecision r15 = new WmfOutPrecision("OUT_PS_ONLY_PRECIS", 9, 10);
            OUT_PS_ONLY_PRECIS = r15;
            $VALUES = new WmfOutPrecision[]{r0, r1, r3, r5, r8, r10, r12, r14, r13, r15};
        }

        private WmfOutPrecision(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        public static WmfOutPrecision valueOf(int r5) {
            WmfOutPrecision[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            WmfOutPrecision r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static WmfOutPrecision valueOf(String r2) {
            return (WmfOutPrecision) ZeusTransformUtils.preCheckCast(Enum.valueOf(WmfOutPrecision.class, r2), WmfOutPrecision.class, "com.obric.memorydata.plugin");
        }

        public static WmfOutPrecision[] values() {
            return (WmfOutPrecision[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WmfOutPrecision[].class, "com.obric.memorydata.plugin");
        }
    }

    public HwmfFont() {
        this.clipPrecision = new WmfClipPrecision();
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return this.charSet;
    }

    public WmfClipPrecision getClipPrecision() {
        return this.clipPrecision;
    }

    public int getEscapement() {
        return this.escapement;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        return FontFamily.valueOf(this.pitchAndFamily & 15);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("height", new $$Lambda$Eo7qIbxk_I78FxgFu95QUnQf9gs(this));
        r0.put("width", new $$Lambda$bOEs5ZrEjrt5GrQFJbTfTSNVbQ(this));
        r0.put("escapment", new $$Lambda$KolCP9evOEqPgXltXHAYczPkKTo(this));
        r0.put("weight", new $$Lambda$97fzV8DrXiRKkIX2FXkiYLS1Vc(this));
        r0.put("italic", new $$Lambda$t3SxCs_CZNAaoEvhgs2vS9k7Y(this));
        r0.put("underline", new $$Lambda$0G8MWQjMMtWZ_NaKvdMugZa88Y0(this));
        r0.put("strikeOut", new $$Lambda$3J_mexwPlOQ2hCMoe6WvaXBpUNw(this));
        r0.put("charset", new $$Lambda$y3rk5qfs3M3UJbBqhgmkApbXlw(this));
        r0.put("outPrecision", new $$Lambda$2LKfS3Ttsz7YSJPMBzF_7B9uEPE(this));
        r0.put("clipPrecision", new $$Lambda$pbWxDwpBGzVlkKP9mRCAjI60_g(this));
        r0.put("quality", new $$Lambda$RSWQ4aGQ_FviETG8zTkHuohZrnY(this));
        r0.put("pitch", new $$Lambda$5FWM4O6X1P6qoUTP18kxbnRKRbw(this));
        r0.put("family", new $$Lambda$YvL97OEubDnZEIRkRY9tYoq5rlI(this));
        r0.put("typeface", new $$Lambda$uBRKLk_ShDVIuWY2gnCGowDGWB4(this));
        return Collections.unmodifiableMap(r0);
    }

    public double getHeight() {
        return this.height;
    }

    public WmfOutPrecision getOutPrecision() {
        return this.outPrecision;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        return FontPitch.valueOf((this.pitchAndFamily >>> 6) & 3);
    }

    public WmfFontQuality getQuality() {
        return this.quality;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return this.facename;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public void initDefaults() {
        this.height = -12.0d;
        this.width = 0;
        this.escapement = 0;
        this.weight = 400;
        this.italic = false;
        this.underline = false;
        this.strikeOut = false;
        this.charSet = FontCharset.ANSI;
        this.outPrecision = WmfOutPrecision.OUT_DEFAULT_PRECIS;
        this.quality = WmfFontQuality.ANTIALIASED_QUALITY;
        this.pitchAndFamily = FontFamily.FF_DONTCARE.getFlag() | (FontPitch.DEFAULT.getNativeId() << 6);
        this.facename = "SansSerif";
    }

    public boolean isItalic() {
        return this.italic;
    }

    public boolean isStrikeOut() {
        return this.strikeOut;
    }

    public boolean isUnderline() {
        return this.underline;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
