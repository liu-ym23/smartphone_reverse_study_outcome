package org.apache.poi.xssf.usermodel;

import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Spliterator;
import kotlin.text.Typography;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.df;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.n;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFSimpleShape extends XSSFShape implements Iterable<XSSFTextParagraph>, TextContainer {
    private static int[] _romanAlphaValues;
    private static String[] _romanChars;
    private final List<XSSFTextParagraph> _paragraphs;
    private final XDDFTextBody _textBody;
    private n ctShape;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFSimpleShape$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit = null;

        static {
            int[] r0 = new int[TextAutofit.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit = r0;
            r0[TextAutofit.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L63:
            $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[TextAutofit.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L51:
            $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[TextAutofit.SHAPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L8:
            int[] r3 = new int[ListAutoNumber.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber = r3;
            r3[ListAutoNumber.ALPHA_LC_PARENT_BOTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L81:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_LC_PARENT_R.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L47:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PARENT_BOTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L65:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PARENT_R.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L79:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_LC_PERIOD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L49:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PERIOD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L69:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PARENT_BOTH.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L75:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PARENT_R.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L57:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PERIOD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L61:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PLAIN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L53:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PARENT_BOTH.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L55:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PARENT_R.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L77:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PARENT_BOTH.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L45:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PARENT_R.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PERIOD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L73:
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PERIOD.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
            return;
        }
    }

    static {
        _romanChars = new String[]{"M", "CM", a.f16161b, "CD", "C", "XC", i.u, "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
        _romanAlphaValues = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    }

    public XSSFSimpleShape(XSSFDrawing r5, n r6) {
        n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.memorydata.plugin");
        this.drawing = r5;
        this.ctShape = r7;
        this._paragraphs = new ArrayList();
        df r8 = r7.getTxBody();
        if (r8 != null) goto L5;
        this._textBody = null;
        return;
    L5:
        this._textBody = new XDDFTextBody(this, r8);
        int r0 = 0;
    L7:
        if (r0 >= r8.sizeOfPArray()) goto L11;
        this._paragraphs.add(new XSSFTextParagraph(r8.getPArray(r0), r7));
        r0 = r0 + 1;
        goto L7
    }

    private String getBulletPrefix(ListAutoNumber r6, int r7) {
        StringBuilder r0 = new StringBuilder();
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[r6.ordinal()]) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L27;
            case 4: goto L27;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L18;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L6;
            case 16: goto L5;
            default: goto L4;
        };
    L4:
        r0.append(Typography.bullet);
    L37:
        r0.append(" ");
        return r0.toString();
    L5:
        String r5 = valueToRoman(r7);
    L24:
        r0.append(r5);
    L25:
        r0.append('.');
        goto L37
    L6:
        String r8 = valueToRoman(r7);
    L23:
        r5 = r8.toLowerCase(Locale.ROOT);
        goto L24
    L15:
        r0.append(r7);
        goto L37
    L16:
        r0.append(r7);
        goto L25
    L21:
        r5 = valueToAlpha(r7);
        goto L24
    L22:
        r8 = valueToAlpha(r7);
        goto L23
    L8:
        if (r6 != ListAutoNumber.ROMAN_UC_PARENT_BOTH) goto L10;
        r0.append('(');
    L10:
        String r9 = valueToRoman(r7);
    L35:
        r0.append(r9);
    L36:
        r0.append(')');
        goto L37
    L12:
        if (r6 != ListAutoNumber.ROMAN_LC_PARENT_BOTH) goto L14;
        r0.append('(');
    L14:
        String r10 = valueToRoman(r7);
    L34:
        r9 = r10.toLowerCase(Locale.ROOT);
        goto L35
    L18:
        if (r6 != ListAutoNumber.ARABIC_PARENT_BOTH) goto L20;
        r0.append('(');
    L20:
        r0.append(r7);
        goto L36
    L27:
        if (r6 != ListAutoNumber.ALPHA_UC_PARENT_BOTH) goto L29;
        r0.append('(');
    L29:
        r9 = valueToAlpha(r7);
        goto L35
    L31:
        if (r6 != ListAutoNumber.ALPHA_LC_PARENT_BOTH) goto L33;
        r0.append('(');
    L33:
        r10 = valueToAlpha(r7);
        goto L34
    }

    private int processAutoNumGroup(int r17, int r18, List<Integer> r19, StringBuilder r20) {
        List<Integer> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        int r6 = r17;
        XSSFTextParagraph r5 = (XSSFTextParagraph) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r6), XSSFTextParagraph.class, "com.obric.memorydata.plugin");
        int r7 = r5.getBulletAutoNumberStart();
        ListAutoNumber r8 = r5.getBulletAutoNumberScheme();
        if (((Integer) ZeusTransformUtils.preCheckCast(r3.get(r18), Integer.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L8;
        if (r7 != 0) goto L6;
        int r9 = 1;
    L7:
        r3.set(r18, Integer.valueOf(r9));
        goto L8
    L6:
        r9 = r7;
    L8:
        int r11 = 0;
    L10:
        if (r11 >= r18) goto L13;
        r20.append('\t');
        r11 = r11 + 1;
        goto L10
    L13:
        if (r5.getText().length() <= 0) goto L15;
        r20.append(getBulletPrefix(r8, ((Integer) ZeusTransformUtils.preCheckCast(r3.get(r18), Integer.class, "com.obric.memorydata.plugin")).intValue()));
        r20.append(r5.getText());
    L15:
        int r12 = r6 + 1;
        if (r12 != this._paragraphs.size()) goto L18;
        XSSFTextParagraph r13 = null;
    L19:
        if (r13 == null) goto L48;
        if (r13.isBullet() == false) goto L48;
        if (r5.isBulletAutoNumber() == false) goto L48;
        if (r13.getLevel() > r18) goto L29;
        if (r13.getLevel() < r18) goto L48;
        ListAutoNumber r14 = r13.getBulletAutoNumberScheme();
        int r10 = r13.getBulletAutoNumberStart();
        if (r14 != r8) goto L48;
        if (r10 != r7) goto L48;
        if (r20.length() <= 0) goto L41;
        r20.append('\n');
    L41:
        int r15 = 0;
    L42:
        if (r15 >= r18) goto L45;
        r20.append('\t');
        r15 = r15 + 1;
        goto L42
    L45:
        if (r13.getText().length() <= 0) goto L47;
        r3.set(r18, Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r3.get(r18), Integer.class, "com.obric.memorydata.plugin")).intValue() + 1));
        r20.append(getBulletPrefix(r14, ((Integer) ZeusTransformUtils.preCheckCast(r3.get(r18), Integer.class, "com.obric.memorydata.plugin")).intValue()));
        r20.append(r13.getText());
    L47:
        r6 = r12;
        goto L15
    L29:
        if (r20.length() <= 0) goto L31;
        r20.append('\n');
    L31:
        r6 = processAutoNumGroup(r12, r13.getLevel(), r3, r20);
    L48:
        r3.set(r18, 0);
        return r6;
    L18:
        r13 = (XSSFTextParagraph) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r12), XSSFTextParagraph.class, "com.obric.memorydata.plugin");
        goto L19
    }

    private String valueToAlpha(int r3) {
        StringBuilder r2 = new StringBuilder();
    L3:
        if (r3 <= 0) goto L5;
        int r0 = (r3 - 1) % 26;
        r2.append((char) (r0 + 65));
        r3 = (r3 - r0) / 26;
        goto L3
    L5:
        r2.reverse();
        return r2.toString();
    }

    private String valueToRoman(int r3) {
        StringBuilder r2 = new StringBuilder();
        int r0 = 0;
    L3:
        if (r3 <= 0) goto L11;
        if (r0 >= _romanChars.length) goto L11;
    L7:
        if (_romanAlphaValues[r0] > r3) goto L9;
        r2.append(_romanChars[r0]);
        r3 = r3 - _romanAlphaValues[r0];
        goto L7
    L9:
        r0 = r0 + 1;
    L11:
        return r2.toString();
    }

    public String getText() {
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList(9);
        int r5 = 0;
    L3:
        if (r5 >= 9) goto L5;
        r1.add(0);
        r5 = r5 + 1;
        goto L3
    L5:
        int r6 = 0;
    L7:
        if (r6 >= this._paragraphs.size()) goto L31;
        if (r0.length() <= 0) goto L11;
        r0.append('\n');
    L11:
        XSSFTextParagraph r7 = (XSSFTextParagraph) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r6), XSSFTextParagraph.class, "com.obric.memorydata.plugin");
        if (r7.isBullet() == true) goto L14;
    L26:
        r0.append(r7.getText());
        int r8 = 0;
    L27:
        if (r8 >= 9) goto L29;
        r1.set(r8, 0);
        r8 = r8 + 1;
    L29:
        r6 = r6 + 1;
        goto L7
    L14:
        if (r7.getText().length() <= 0) goto L26;
        int r9 = Math.min(r7.getLevel(), 8);
        if (r7.isBulletAutoNumber() == false) goto L18;
        r6 = processAutoNumGroup(r6, r9, r1, r0);
        goto L29
    L18:
        int r10 = 0;
    L19:
        if (r10 >= r9) goto L21;
        r0.append('\t');
        r10 = r10 + 1;
        goto L19
    L21:
        String r11 = r7.getBulletCharacter();
        if (r11.length() <= 0) goto L24;
        String r12 = r11 + " ";
    L25:
        r0.append(r12);
        r0.append(r7.getText());
        goto L29
    L24:
        r12 = "- ";
        goto L25
    L31:
        return r0.toString();
    }

    public List<XSSFTextParagraph> getTextParagraphs() {
        return this._paragraphs;
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFTextParagraph> iterator() {
        return this._paragraphs.iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFTextParagraph> spliterator() {
        return this._paragraphs.spliterator();
    }
}
