package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.hslf.record.FontEmbeddedData;
import org.apache.poi.hslf.record.FontEntityAtom;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFFontInfo implements FontInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BitField FLAGS_EMBED_SUBSETTED = null;
    private static final BitField FLAGS_NO_FONT_SUBSTITUTION = null;
    private static final BitField FLAGS_RENDER_FONTTYPE = null;
    private FontCharset charset;
    private final List<FontEmbeddedData> facets;
    private FontFamily family;
    private FontEntityAtom fontEntityAtom;
    private int index;
    private boolean isSubsetted;
    private boolean isSubstitutable;
    private FontPitch pitch;
    private FontRenderType renderType;
    private String typeface;

    /* JADX INFO: renamed from: org.apache.poi.hslf.usermodel.HSLFFontInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hslf$usermodel$HSLFFontInfo$FontRenderType = null;

        static {
            int[] r0 = new int[FontRenderType.values().length];
            $SwitchMap$org$apache$poi$hslf$usermodel$HSLFFontInfo$FontRenderType = r0;
            r0[FontRenderType.device.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$hslf$usermodel$HSLFFontInfo$FontRenderType[FontRenderType.raster.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$hslf$usermodel$HSLFFontInfo$FontRenderType[FontRenderType.truetype.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum FontRenderType extends Enum<FontRenderType> {
        private static final /* synthetic */ FontRenderType[] $VALUES = null;
        public static final FontRenderType device = null;
        public static final FontRenderType raster = null;
        public static final FontRenderType truetype = null;

        static {
            FontRenderType r0 = new FontRenderType("raster", 0);
            raster = r0;
            FontRenderType r1 = new FontRenderType("device", 1);
            device = r1;
            FontRenderType r3 = new FontRenderType("truetype", 2);
            truetype = r3;
            $VALUES = new FontRenderType[]{r0, r1, r3};
        }

        private FontRenderType(String r1, int r2) {
            super(r1, r2);
        }

        public static FontRenderType valueOf(String r2) {
            return (FontRenderType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontRenderType.class, r2), FontRenderType.class, "com.obric.memorydata.plugin");
        }

        public static FontRenderType[] values() {
            return (FontRenderType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontRenderType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        FLAGS_EMBED_SUBSETTED = BitFieldFactory.getInstance(1);
        FLAGS_RENDER_FONTTYPE = BitFieldFactory.getInstance(7);
        FLAGS_NO_FONT_SUBSTITUTION = BitFieldFactory.getInstance(8);
    }

    public HSLFFontInfo(FontInfo r4) {
        FontInfo r5 = (FontInfo) ZeusTransformUtils.wrapperContextForParams(r4, FontInfo.class, "com.obric.memorydata.plugin");
        this.index = -1;
        this.typeface = "undefined";
        this.charset = FontCharset.ANSI;
        this.renderType = FontRenderType.truetype;
        this.family = FontFamily.FF_SWISS;
        this.pitch = FontPitch.VARIABLE;
        this.isSubstitutable = true;
        this.facets = new ArrayList();
        setTypeface(r5.getTypeface());
        setCharset(r5.getCharset());
        setFamily(r5.getFamily());
        setPitch(r5.getPitch());
        if (ZeusTransformUtils.instanceOf(r5, HSLFFontInfo.class) == false) goto L6;
        HSLFFontInfo r6 = (HSLFFontInfo) ZeusTransformUtils.preCheckCast(r5, HSLFFontInfo.class, "com.obric.memorydata.plugin");
        setRenderType(r6.getRenderType());
        setEmbedSubsetted(r6.isEmbedSubsetted());
        setFontSubstitutable(r6.isFontSubstitutable());
        return;
    }

    public HSLFFontInfo(FontEntityAtom r4) {
        this.index = -1;
        this.typeface = "undefined";
        this.charset = FontCharset.ANSI;
        this.renderType = FontRenderType.truetype;
        this.family = FontFamily.FF_SWISS;
        this.pitch = FontPitch.VARIABLE;
        this.isSubstitutable = true;
        this.facets = new ArrayList();
        this.fontEntityAtom = r4;
        setIndex(r4.getFontIndex());
        setTypeface(r4.getFontName());
        setCharset(FontCharset.valueOf(r4.getCharSet()));
        int r1 = FLAGS_RENDER_FONTTYPE.getValue(r4.getFontType());
        if (r1 != 1) goto L5;
        FontRenderType r2 = FontRenderType.raster;
    L9:
        setRenderType(r2);
        byte r3 = (byte) r4.getPitchAndFamily();
        setPitch(FontPitch.valueOfPitchFamily(r3));
        setFamily(FontFamily.valueOfPitchFamily(r3));
        setEmbedSubsetted(FLAGS_EMBED_SUBSETTED.isSet(r4.getFontFlags()));
        setFontSubstitutable(!FLAGS_NO_FONT_SUBSTITUTION.isSet(r4.getFontType()));
        return;
    L5:
        if (r1 == 2) goto L7;
        r2 = FontRenderType.truetype;
        goto L9
    L7:
        r2 = FontRenderType.device;
        goto L9
    }

    public void addFacet(FontEmbeddedData r1) {
        this.facets.add(r1);
    }

    public FontEntityAtom createRecord() {
        FontEntityAtom r0 = new FontEntityAtom();
        this.fontEntityAtom = r0;
        r0.setFontIndex(getIndex().intValue() << 4);
        r0.setFontName(getTypeface());
        r0.setCharSet(getCharset().getNativeId());
        r0.setFontFlags(isEmbedSubsetted() ? 1 : 0);
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$hslf$usermodel$HSLFFontInfo$FontRenderType[this.renderType.ordinal()];
        int r3 = 1;
        if (r1 == 1) goto L7;
        r3 = 2;
        if (r1 == 2) goto L7;
        int r2 = FLAGS_RENDER_FONTTYPE.setValue(0, 4);
    L8:
        r0.setFontType(FLAGS_NO_FONT_SUBSTITUTION.setBoolean(r2, isFontSubstitutable()));
        r0.setPitchAndFamily(FontPitch.getNativeId(this.pitch, this.family));
        return r0;
    L7:
        r2 = FLAGS_RENDER_FONTTYPE.setValue(0, r3);
        goto L8
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return this.charset;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        return this.family;
    }

    public Integer getIndex() {
        return Integer.valueOf(this.index);
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        return this.pitch;
    }

    public FontRenderType getRenderType() {
        return this.renderType;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return this.typeface;
    }

    public boolean isEmbedSubsetted() {
        return this.isSubsetted;
    }

    public boolean isFontSubstitutable() {
        return this.isSubstitutable;
    }

    public void setCharset(FontCharset r1) {
        if (r1 != null) goto L4;
        r1 = FontCharset.ANSI;
    L4:
        this.charset = r1;
    }

    public void setEmbedSubsetted(boolean r1) {
        this.isSubsetted = r1;
    }

    public void setFamily(FontFamily r1) {
        if (r1 != null) goto L4;
        r1 = FontFamily.FF_SWISS;
    L4:
        this.family = r1;
    }

    public void setFontSubstitutable(boolean r1) {
        this.isSubstitutable = r1;
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    public void setPitch(FontPitch r1) {
        if (r1 != null) goto L4;
        r1 = FontPitch.VARIABLE;
    L4:
        this.pitch = r1;
    }

    public void setRenderType(FontRenderType r1) {
        if (r1 != null) goto L4;
        r1 = FontRenderType.truetype;
    L4:
        this.renderType = r1;
    }

    public void setTypeface(String r2) {
        if (r2 == null) goto L8;
        if (r2.isEmpty() == true) goto L8;
        this.typeface = r2;
        return;
    L8:
        throw new IllegalArgumentException("typeface can't be null nor empty");
    }
}
