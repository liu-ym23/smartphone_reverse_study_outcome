package org.apache.poi.xssf.usermodel.extensions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.f;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.g;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFCellBorder {
    private final IndexedColorMap _indexedColorMap;
    private ThemesTable _theme;
    private final f border;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide = null;

        static {
            int[] r0 = new int[BorderSide.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide = r0;
            r0[BorderSide.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.DIAGONAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.VERTICAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.HORIZONTAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum BorderSide extends Enum<BorderSide> {
        private static final /* synthetic */ BorderSide[] $VALUES = null;
        public static final BorderSide BOTTOM = null;
        public static final BorderSide DIAGONAL = null;
        public static final BorderSide HORIZONTAL = null;
        public static final BorderSide LEFT = null;
        public static final BorderSide RIGHT = null;
        public static final BorderSide TOP = null;
        public static final BorderSide VERTICAL = null;

        static {
            BorderSide r0 = new BorderSide("TOP", 0);
            TOP = r0;
            BorderSide r1 = new BorderSide("RIGHT", 1);
            RIGHT = r1;
            BorderSide r3 = new BorderSide("BOTTOM", 2);
            BOTTOM = r3;
            BorderSide r5 = new BorderSide("LEFT", 3);
            LEFT = r5;
            BorderSide r7 = new BorderSide("DIAGONAL", 4);
            DIAGONAL = r7;
            BorderSide r9 = new BorderSide("VERTICAL", 5);
            VERTICAL = r9;
            BorderSide r11 = new BorderSide("HORIZONTAL", 6);
            HORIZONTAL = r11;
            $VALUES = new BorderSide[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private BorderSide(String r1, int r2) {
            super(r1, r2);
        }

        public static BorderSide valueOf(String r2) {
            return (BorderSide) ZeusTransformUtils.preCheckCast(Enum.valueOf(BorderSide.class, r2), BorderSide.class, "com.obric.memorydata.plugin");
        }

        public static BorderSide[] values() {
            return (BorderSide[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BorderSide[].class, "com.obric.memorydata.plugin");
        }
    }

    public XSSFCellBorder() {
        this((f) ZeusTransformUtils.preCheckCast(f.f19671a.newInstance(), f.class, "com.obric.memorydata.plugin"), null, null);
    }

    public XSSFCellBorder(f r3) {
        this((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), null, null);
    }

    public XSSFCellBorder(f r3, ThemesTable r4, IndexedColorMap r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        IndexedColorMap r7 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r5, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this.border = r6;
        this._indexedColorMap = r7;
        this._theme = r4;
    }

    public XSSFCellBorder(f r3, IndexedColorMap r4) {
        this((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), null, (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r4, IndexedColorMap.class, "com.obric.memorydata.plugin"));
    }

    private g getBorder(BorderSide r2) {
        return getBorder(r2, false);
    }

    private g getBorder(BorderSide r3, boolean r4) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[r3.ordinal()]) {
            case 1: goto L30;
            case 2: goto L26;
            case 3: goto L22;
            case 4: goto L18;
            case 5: goto L14;
            case 6: goto L10;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        g r5 = this.border.getHorizontal();
        if (r4 == false) goto L35;
        if (r5 == null) goto L37;
        return r5;
    L37:
        return this.border.addNewHorizontal();
    L35:
        return r5;
    L10:
        g r6 = this.border.getVertical();
        if (r4 == false) goto L38;
        if (r6 == null) goto L40;
        return r6;
    L40:
        return this.border.addNewVertical();
    L38:
        return r6;
    L14:
        g r7 = this.border.getDiagonal();
        if (r4 == false) goto L41;
        if (r7 == null) goto L43;
        return r7;
    L43:
        return this.border.addNewDiagonal();
    L41:
        return r7;
    L18:
        g r8 = this.border.getLeft();
        if (r4 == false) goto L44;
        if (r8 == null) goto L46;
        return r8;
    L46:
        return this.border.addNewLeft();
    L44:
        return r8;
    L22:
        g r9 = this.border.getBottom();
        if (r4 == false) goto L47;
        if (r9 == null) goto L49;
        return r9;
    L49:
        return this.border.addNewBottom();
    L47:
        return r9;
    L26:
        g r10 = this.border.getRight();
        if (r4 == false) goto L50;
        if (r10 == null) goto L52;
        return r10;
    L52:
        return this.border.addNewRight();
    L50:
        return r10;
    L30:
        g r11 = this.border.getTop();
        if (r4 == false) goto L53;
        if (r11 == null) goto L34;
        return r11;
    L34:
        return this.border.addNewTop();
    L53:
        return r11;
    L5:
        throw new IllegalArgumentException("No suitable side specified for the border, had " + r3);
    }

    public boolean equals(Object r9) {
        if (ZeusTransformUtils.instanceOf(r9, XSSFCellBorder.class) == true) goto L5;
        return false;
    L5:
        XSSFCellBorder r10 = (XSSFCellBorder) ZeusTransformUtils.preCheckCast(r9, XSSFCellBorder.class, "com.obric.memorydata.plugin");
        BorderSide[] r0 = BorderSide.values();
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L15;
        BorderSide r5 = r0[r3];
        if (Objects.equals(getBorderColor(r5), r10.getBorderColor(r5)) == false) goto L14;
        if (Objects.equals(getBorderStyle(r5), r10.getBorderStyle(r5)) == false) goto L14;
        r3 = r3 + 1;
    L14:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L19;
        return false;
    L19:
        if (this.border.isSetDiagonalUp() == r10.border.isSetDiagonalUp()) goto L21;
    L41:
        return false;
    L21:
        if (this.border.isSetDiagonalDown() != r10.border.isSetDiagonalDown()) goto L41;
        if (this.border.isSetOutline() != r10.border.isSetOutline()) goto L41;
        if (this.border.isSetDiagonalUp() == false) goto L31;
        if (this.border.getDiagonalUp() == r10.border.getDiagonalUp()) goto L31;
        return false;
    L31:
        if (this.border.isSetDiagonalDown() == false) goto L36;
        if (this.border.getDiagonalDown() == r10.border.getDiagonalDown()) goto L36;
        return false;
    L36:
        if (this.border.isSetOutline() == true) goto L38;
    L40:
        return true;
    L38:
        if (this.border.getOutline() == r10.border.getOutline()) goto L40;
        return false;
    L15:
        r2 = true;
        goto L16
    }

    public XSSFColor getBorderColor(BorderSide r2) {
        g r3 = getBorder(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isSetColor() == false) goto L12;
        XSSFColor r4 = XSSFColor.from(r3.getColor(), this._indexedColorMap);
        ThemesTable r1 = this._theme;
        if (r1 == null) goto L9;
        r1.inheritFromThemeAsRequired(r4);
    L9:
        return r4;
    L12:
        return null;
    }

    public BorderStyle getBorderStyle(BorderSide r1) {
        g r0 = getBorder(r1);
        if (r0 != null) goto L5;
        STBorderStyle.Enum r2 = STBorderStyle.c;
    L7:
        return BorderStyle.values()[r2.intValue() - 1];
    L5:
        r2 = r0.getStyle();
        goto L7
    }

    public f getCTBorder() {
        return this.border;
    }

    public int hashCode() {
        return this.border.toString().hashCode();
    }

    public void setThemesTable(ThemesTable r1) {
        this._theme = r1;
    }
}
