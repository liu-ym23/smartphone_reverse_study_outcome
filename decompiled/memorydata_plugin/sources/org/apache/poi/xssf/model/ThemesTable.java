package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.fw;
import org.openxmlformats.schemas.drawingml.x2006.main.h;
import org.openxmlformats.schemas.drawingml.x2006.main.k;

/* JADX INFO: loaded from: classes7.dex */
public class ThemesTable extends POIXMLDocumentPart {
    private IndexedColorMap colorMap;
    private fw theme;

    /* JADX INFO: renamed from: org.apache.poi.xssf.model.ThemesTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement = null;

        static {
            int[] r0 = new int[ThemeElement.values().length];
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement = r0;
            r0[ThemeElement.LT1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.DK1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.LT2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.DK2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT1.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT2.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT3.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT4.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT5.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT6.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.HLINK.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.FOLHLINK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static final enum ThemeElement extends Enum<ThemeElement> {
        private static final /* synthetic */ ThemeElement[] $VALUES = null;
        public static final ThemeElement ACCENT1 = null;
        public static final ThemeElement ACCENT2 = null;
        public static final ThemeElement ACCENT3 = null;
        public static final ThemeElement ACCENT4 = null;
        public static final ThemeElement ACCENT5 = null;
        public static final ThemeElement ACCENT6 = null;
        public static final ThemeElement DK1 = null;
        public static final ThemeElement DK2 = null;
        public static final ThemeElement FOLHLINK = null;
        public static final ThemeElement HLINK = null;
        public static final ThemeElement LT1 = null;
        public static final ThemeElement LT2 = null;
        public static final ThemeElement UNKNOWN = null;
        public final int idx;
        public final String name;

        static {
            ThemeElement r0 = new ThemeElement("LT1", 0, 0, "Lt1");
            LT1 = r0;
            ThemeElement r1 = new ThemeElement("DK1", 1, 1, "Dk1");
            DK1 = r1;
            ThemeElement r3 = new ThemeElement("LT2", 2, 2, "Lt2");
            LT2 = r3;
            ThemeElement r5 = new ThemeElement("DK2", 3, 3, "Dk2");
            DK2 = r5;
            ThemeElement r7 = new ThemeElement("ACCENT1", 4, 4, "Accent1");
            ACCENT1 = r7;
            ThemeElement r9 = new ThemeElement("ACCENT2", 5, 5, "Accent2");
            ACCENT2 = r9;
            ThemeElement r11 = new ThemeElement("ACCENT3", 6, 6, "Accent3");
            ACCENT3 = r11;
            ThemeElement r13 = new ThemeElement("ACCENT4", 7, 7, "Accent4");
            ACCENT4 = r13;
            ThemeElement r12 = new ThemeElement("ACCENT5", 8, 8, "Accent5");
            ACCENT5 = r12;
            ThemeElement r10 = new ThemeElement("ACCENT6", 9, 9, "Accent6");
            ACCENT6 = r10;
            ThemeElement r8 = new ThemeElement("HLINK", 10, 10, "Hlink");
            HLINK = r8;
            ThemeElement r6 = new ThemeElement("FOLHLINK", 11, 11, "FolHlink");
            FOLHLINK = r6;
            ThemeElement r4 = new ThemeElement("UNKNOWN", 12, -1, null);
            UNKNOWN = r4;
            $VALUES = new ThemeElement[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4};
        }

        private ThemeElement(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.idx = r3;
            this.name = r4;
        }

        public static ThemeElement byId(int r1) {
            if (r1 >= values().length) goto L9;
            if (r1 < 0) goto L9;
            return values()[r1];
        L9:
            return UNKNOWN;
        }

        public static ThemeElement valueOf(String r2) {
            return (ThemeElement) ZeusTransformUtils.preCheckCast(Enum.valueOf(ThemeElement.class, r2), ThemeElement.class, "com.obric.memorydata.plugin");
        }

        public static ThemeElement[] values() {
            return (ThemeElement[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ThemeElement[].class, "com.obric.memorydata.plugin");
        }
    }

    public ThemesTable() {
        fw r0 = (fw) ZeusTransformUtils.preCheckCast(fw.f18972a.newInstance(), fw.class, "com.obric.memorydata.plugin");
        this.theme = r0;
        r0.addNewTheme().addNewThemeElements();
    }

    public ThemesTable(PackagePart r2) {
        super(r2);
        InputStream r3 = r2.getInputStream();
        readFrom(r3);     // Catch: Throwable -> L7
        if (r3 == null) goto L22;
        r3.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r3 != null) goto L20;
    L15:
        throw th;
    L20:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        writeTo(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public XSSFColor getThemeColor(int r3) {
        k r0 = this.theme.getTheme().getThemeElements().getClrScheme();
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.byId(r3).ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return null;
    L5:
        h r4 = r0.getFolHlink();
    L18:
        if (r4.isSetSrgbClr() == false) goto L21;
        byte[] r5 = r4.getSrgbClr().getVal();
    L24:
        return new XSSFColor(r5, this.colorMap);
    L21:
        if (r4.isSetSysClr() == false) goto L25;
        r5 = r4.getSysClr().getLastClr();
        goto L24
    L25:
        return null;
    L6:
        r4 = r0.getHlink();
        goto L18
    L7:
        r4 = r0.getAccent6();
        goto L18
    L8:
        r4 = r0.getAccent5();
        goto L18
    L9:
        r4 = r0.getAccent4();
        goto L18
    L10:
        r4 = r0.getAccent3();
        goto L18
    L11:
        r4 = r0.getAccent2();
        goto L18
    L12:
        r4 = r0.getAccent1();
        goto L18
    L13:
        r4 = r0.getDk2();
        goto L18
    L14:
        r4 = r0.getLt2();
        goto L18
    L15:
        r4 = r0.getDk1();
        goto L18
    L16:
        r4 = r0.getLt1();
        goto L18
    }

    public void inheritFromThemeAsRequired(XSSFColor r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getCTColor().isSetTheme() == true) goto L7;
        return;
    L7:
        XSSFColor r1 = getThemeColor(r2.getTheme());
        r2.getCTColor().setRgb(r1.getCTColor().getRgb());
    }

    public void readFrom(InputStream r3) {
        this.theme = (fw) ZeusTransformUtils.preCheckCast(fw.f18972a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fw.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage(), e);
    }

    public void setColorMap(IndexedColorMap r3) {
        this.colorMap = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r3, IndexedColorMap.class, "com.obric.memorydata.plugin");
    }

    public void writeTo(OutputStream r2) {
        this.theme.save(r2, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
