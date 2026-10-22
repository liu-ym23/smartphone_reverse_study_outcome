package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.TextRun;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFTextRun implements TextRun {
    private static final c LOG = null;
    private String _runText;
    private HSLFFontInfo[] cachedFontInfo;
    private TextPropCollection characterStyle;
    private HSLFHyperlink link;
    private HSLFTextParagraph parentParagraph;

    /* JADX INFO: renamed from: org.apache.poi.hslf.usermodel.HSLFTextRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = null;

        static {
            int[] r0 = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = r0;
            r0[Placeholder.SLIDE_NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.DATETIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            int[] r2 = new int[FontGroup.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup = r2;
            r2[FontGroup.LATIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.COMPLEX_SCRIPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L28:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.EAST_ASIAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L20:
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.SYMBOL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        LOG = b.a(HSLFTextRun.class);
    }

    public HSLFTextRun(HSLFTextParagraph r4) {
        this._runText = "";
        this.characterStyle = new TextPropCollection(1, TextPropCollection.TextPropType.character);
        this.parentParagraph = r4;
    }

    private FontGroup safeFontGroup(FontGroup r1) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        return FontGroup.getFontGroupFirst(getRawText());
    }

    public TextPropCollection getCharacterStyle() {
        return this.characterStyle;
    }

    public int getLength() {
        return this._runText.length();
    }

    public String getRawText() {
        return this._runText;
    }

    public HSLFTextParagraph getTextParagraph() {
        return this.parentParagraph;
    }

    public void setCharTextPropVal(String r2, Integer r3) {
        getTextParagraph().setPropVal(this.characterStyle, r2, r3);
    }

    public void setCharacterStyle(TextPropCollection r1) {
        TextPropCollection r2 = r1.copy();
        this.characterStyle = r2;
        r2.updateTextSize(this._runText.length());
    }

    public void setFontInfo(FontInfo r4, FontGroup r5) {
        FontInfo r6 = (FontInfo) ZeusTransformUtils.wrapperContextForParams(r4, FontInfo.class, "com.obric.memorydata.plugin");
        FontGroup r7 = safeFontGroup(r5);
        HSLFSheet r0 = this.parentParagraph.getSheet();
        HSLFFontInfo r1 = null;
        Integer r2 = null;
        if (r0 != null) goto L5;
        HSLFSlideShow r3 = null;
    L6:
        if (r0 == null) goto L23;
        if (r3 == null) goto L23;
        int r8 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[r7.ordinal()];
        if (r8 != 2) goto L12;
    L17:
        String r9 = "asian.font.index";
    L18:
        if (r6 == null) goto L20;
        r2 = r3.addFont(r6).getIndex();
    L20:
        setCharTextPropVal("font.index", r2);
        setCharTextPropVal(r9, r2);
        return;
    L12:
        if (r8 == 3) goto L17;
        if (r8 == 4) goto L16;
        r9 = "ansi.font.index";
        goto L18
    L16:
        r9 = "symbol.font.index";
    L23:
        if (this.cachedFontInfo != null) goto L25;
        this.cachedFontInfo = new HSLFFontInfo[FontGroup.values().length];
    L25:
        HSLFFontInfo[] r10 = this.cachedFontInfo;
        int r11 = r7.ordinal();
        if (r6 == null) goto L28;
        r1 = new HSLFFontInfo(r6);
    L28:
        r10[r11] = r1;
        return;
    L5:
        r3 = r0.getSlideShow();
        goto L6
    }

    void setHyperlink(HSLFHyperlink r1) {
        this.link = r1;
    }

    public void setText(String r2) {
        if (r2 == null) goto L10;
        String r3 = HSLFTextParagraph.toInternalString(r2);
        if (r3.equals(this._runText) == true) goto L11;
        this._runText = r3;
        if (HSLFSlideShow.getLoadSavePhase() != HSLFSlideShow.LoadSavePhase.LOADED) goto L12;
        this.parentParagraph.setDirty();
        return;
    L12:
        return;
    L11:
        return;
    L10:
        throw new HSLFException("text must not be null");
    }

    public void updateSheet() {
        if (this.cachedFontInfo == null) goto L10;
        FontGroup[] r0 = FontGroup.values();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        FontGroup r3 = r0[r2];
        setFontInfo(this.cachedFontInfo[r3.ordinal()], r3);
        r2 = r2 + 1;
        goto L5
    L7:
        this.cachedFontInfo = null;
        return;
    }
}
