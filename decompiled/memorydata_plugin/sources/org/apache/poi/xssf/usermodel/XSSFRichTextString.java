package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.q;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ac;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.by;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dw;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dx;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.eb;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFRichTextString implements RichTextString {
    private static final Pattern utfPtrn = null;
    private eb st;
    private StylesTable styles;

    static {
        utfPtrn = Pattern.compile("_x([0-9A-Fa-f]{4})_");
    }

    public XSSFRichTextString() {
        this.st = (eb) ZeusTransformUtils.preCheckCast(eb.f19623a.newInstance(), eb.class, "com.obric.memorydata.plugin");
    }

    public XSSFRichTextString(String r4) {
        eb r0 = (eb) ZeusTransformUtils.preCheckCast(eb.f19623a.newInstance(), eb.class, "com.obric.memorydata.plugin");
        this.st = r0;
        r0.setT(r4);
        preserveSpaces(this.st.xgetT());
    }

    public XSSFRichTextString(eb r3) {
        this.st = (eb) ZeusTransformUtils.wrapperContextForParams(r3, eb.class, "com.obric.memorydata.plugin");
    }

    public static void preserveSpaces(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        String r0 = r4.getStringValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L30;
        char r1 = r0.charAt(0);
        char r2 = r0.charAt(r0.length() - 1);
        if (Character.isWhitespace(r1) == false) goto L9;
    L10:
        XmlCursor r5 = r4.newCursor();
        r5.toNextToken();     // Catch: Throwable -> L14
        r5.insertAttributeWithValue(new QName("http://www.w3.org/XML/1998/namespace", "space"), "preserve");     // Catch: Throwable -> L14
        if (r5 == null) goto L32;
        r5.close();
        return;
    L32:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r5 != null) goto L24;
    L22:
        throw th;
    L24:
        r5.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L9:
        if (Character.isWhitespace(r2) == true) goto L10;
        return;
    }

    private void setRunAttributes(by r5, dx r6) {
        by r4 = (by) ZeusTransformUtils.wrapperContextForParams(r5, by.class, "com.obric.memorydata.plugin");
        dx r7 = (dx) ZeusTransformUtils.wrapperContextForParams(r6, dx.class, "com.obric.memorydata.plugin");
        if (r4.sizeOfBArray() <= 0) goto L6;
        r7.addNewB().setVal(r4.getBArray(0).getVal());
    L6:
        if (r4.sizeOfUArray() <= 0) goto L9;
        r7.addNewU().setVal(r4.getUArray(0).getVal());
    L9:
        if (r4.sizeOfIArray() <= 0) goto L12;
        r7.addNewI().setVal(r4.getIArray(0).getVal());
    L12:
        if (r4.sizeOfColorArray() <= 0) goto L29;
        ac r8 = r4.getColorArray(0);
        ac r1 = r7.addNewColor();
        if (r8.isSetAuto() == false) goto L17;
        r1.setAuto(r8.getAuto());
    L17:
        if (r8.isSetIndexed() == false) goto L20;
        r1.setIndexed(r8.getIndexed());
    L20:
        if (r8.isSetRgb() == false) goto L23;
        r1.setRgb(r8.getRgb());
    L23:
        if (r8.isSetTheme() == false) goto L26;
        r1.setTheme(r8.getTheme());
    L26:
        if (r8.isSetTint() == false) goto L29;
        r1.setTint(r8.getTint());
    L29:
        if (r4.sizeOfSzArray() <= 0) goto L32;
        r7.addNewSz().setVal(r4.getSzArray(0).getVal());
    L32:
        if (r4.sizeOfNameArray() <= 0) goto L35;
        r7.addNewRFont().setVal(r4.getNameArray(0).getVal());
    L35:
        if (r4.sizeOfFamilyArray() <= 0) goto L38;
        r7.addNewFamily().setVal(r4.getFamilyArray(0).getVal());
    L38:
        if (r4.sizeOfSchemeArray() <= 0) goto L41;
        r7.addNewScheme().setVal(r4.getSchemeArray(0).getVal());
    L41:
        if (r4.sizeOfCharsetArray() <= 0) goto L44;
        r7.addNewCharset().setVal(r4.getCharsetArray(0).getVal());
    L44:
        if (r4.sizeOfCondenseArray() <= 0) goto L47;
        r7.addNewCondense().setVal(r4.getCondenseArray(0).getVal());
    L47:
        if (r4.sizeOfExtendArray() <= 0) goto L50;
        r7.addNewExtend().setVal(r4.getExtendArray(0).getVal());
    L50:
        if (r4.sizeOfVertAlignArray() <= 0) goto L53;
        r7.addNewVertAlign().setVal(r4.getVertAlignArray(0).getVal());
    L53:
        if (r4.sizeOfOutlineArray() <= 0) goto L56;
        r7.addNewOutline().setVal(r4.getOutlineArray(0).getVal());
    L56:
        if (r4.sizeOfShadowArray() <= 0) goto L59;
        r7.addNewShadow().setVal(r4.getShadowArray(0).getVal());
    L59:
        if (r4.sizeOfStrikeArray() <= 0) goto L62;
        r7.addNewStrike().setVal(r4.getStrikeArray(0).getVal());
        return;
    }

    static String utfDecode(String r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        if (r5.contains("_x") == false) goto L21;
        StringBuilder r0 = new StringBuilder();
        Matcher r1 = utfPtrn.matcher(r5);
        int r2 = 0;
    L8:
        if (r1.find() == false) goto L13;
        int r3 = r1.start();
        if (r3 <= r2) goto L12;
        r0.append(r5, r2, r3);
    L12:
        r0.append((char) Integer.decode("0x" + r1.group(1)).intValue());
        r2 = r1.end();
        goto L8
    L13:
        if (r2 != 0) goto L15;
        return r5;
    L15:
        r0.append(r5.substring(r2));
        return r0.toString();
    L21:
        return r5;
    }

    public eb getCTRst() {
        return this.st;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        if (this.st.sizeOfRArray() != 0) goto L7;
        String r4 = this.st.getT();
    L6:
        return utfDecode(r4);
    L7:
        StringBuilder r0 = new StringBuilder();
        dw[] r5 = this.st.getRArray();
        int r1 = r5.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L10;
        r0.append(r5[r2].getT());
        r2 = r2 + 1;
        goto L8
    L10:
        r4 = r0.toString();
        goto L6
    }

    public void setStylesTableReference(StylesTable r7) {
        this.styles = r7;
        if (this.st.sizeOfRArray() <= 0) goto L14;
        dw[] r8 = this.st.getRArray();
        int r0 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L20;
        dx r3 = r8[r2].getRPr();
        if (r3 == null) goto L13;
        if (r3.sizeOfRFontArray() <= 0) goto L13;
        String r4 = r3.getRFontArray(0).getVal();
        if (r4.startsWith("#") == false) goto L13;
        XSSFFont r5 = this.styles.getFontAt(Integer.parseInt(r4.substring(1)));
        r3.removeRFont(0);
        setRunAttributes(r5.getCTFont(), r3);
    L13:
        r2 = r2 + 1;
        goto L5
    L20:
        return;
    }

    public String toString() {
        String r0 = getString();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
