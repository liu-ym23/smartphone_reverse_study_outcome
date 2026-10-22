package androidx.room.jarjarred.org.antlr.v4.gui;

import ai.j0;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PostScriptDocument {
    public static final String DEFAULT_FONT = "CourierNew";
    public static final Map<String, String> POSTSCRIPT_FONT_NAMES = null;
    protected String boundingBox;
    protected int boundingBoxHeight;
    protected int boundingBoxWidth;
    protected boolean closed;
    protected SystemFontMetrics fontMetrics;
    protected String fontName;
    protected int fontSize;
    protected double lineWidth;

    /* JADX INFO: renamed from: ps, reason: collision with root package name */
    protected StringBuilder f642ps;

    static {
        HashMap r5 = new HashMap();
        POSTSCRIPT_FONT_NAMES = r5;
        r5.put("SansSerif.plain", "ArialMT");
        r5.put("SansSerif.bold", "Arial-BoldMT");
        r5.put("SansSerif.italic", "Arial-ItalicMT");
        r5.put("SansSerif.bolditalic", "Arial-BoldItalicMT");
        r5.put("Serif.plain", "TimesNewRomanPSMT");
        r5.put("Serif.bold", "TimesNewRomanPS-BoldMT");
        r5.put("Serif.italic", "TimesNewRomanPS-ItalicMT");
        r5.put("Serif.bolditalic", "TimesNewRomanPS-BoldItalicMT");
        r5.put("Monospaced.plain", "CourierNewPSMT");
        r5.put("Monospaced.bold", "CourierNewPS-BoldMT");
        r5.put("Monospaced.italic", "CourierNewPS-ItalicMT");
        r5.put("Monospaced.bolditalic", "CourierNewPS-BoldItalicMT");
    }

    public PostScriptDocument() {
        this(DEFAULT_FONT, 12);
    }

    public void boundingBox(int r5, int r10) {
        this.boundingBoxWidth = r5;
        this.boundingBoxHeight = r10;
        Locale r11 = Locale.US;
        this.boundingBox = "%%BoundingBox: 0 0 " + this.boundingBoxWidth + " " + this.boundingBoxHeight + "\n";
    }

    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.f642ps.append("%%Trailer\n");
        this.closed = true;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public double getLineHeight() {
        return this.fontMetrics.getLineHeight(this.fontSize);
    }

    public String getPS() {
        close();
        return header() + this.f642ps.toString();
    }

    public double getWidth(char r5) {
        return this.fontMetrics.getWidth(r5, this.fontSize);
    }

    public StringBuilder header() {
        StringBuilder r5 = j0.u("%!PS-Adobe-3.0 EPSF-3.0\n");
        r5.append(this.boundingBox);
        r5.append("\n0.3 setlinewidth\n%% x y w h highlight\n/highlight {\n        4 dict begin\n        /h exch def\n        /w exch def\n        /y exch def\n        /x exch def\n        gsave\n        newpath\n        x y moveto\n        0 h rlineto     % up to left corner\n        w 0 rlineto     % to upper right corner\n        0 h neg rlineto % to lower right corner\n        w neg 0 rlineto % back home to lower left corner\n        closepath\n        .95 .83 .82 setrgbcolor\n        fill\n        grestore\n        end\n} def\n");
        return r5;
    }

    public void highlight(double r5, double r10, double r11, double r12) {
        this.f642ps.append(String.format(Locale.US, "%1.3f %1.3f %1.3f %1.3f highlight\n", new Object[]{Double.valueOf(r5), Double.valueOf(r10), Double.valueOf(r11), Double.valueOf(r12)}));
    }

    public void line(double r5, double r10, double r11, double r12) {
        move(r5, r10);
        lineto(r11, r12);
    }

    public void lineWidth(double r5) {
        this.lineWidth = r5;
        StringBuilder r10 = this.f642ps;
        r10.append(r5);
        r10.append(" setlinewidth\n");
    }

    public void lineto(double r5, double r10) {
        this.f642ps.append(String.format(Locale.US, "%1.3f %1.3f lineto\n", new Object[]{Double.valueOf(r5), Double.valueOf(r10)}));
    }

    public void move(double r5, double r10) {
        this.f642ps.append(String.format(Locale.US, "%1.3f %1.3f moveto\n", new Object[]{Double.valueOf(r5), Double.valueOf(r10)}));
    }

    public void rect(double r14, double r16, double r18, double r20) {
        double r10 = r16 + r20;
        line(r14, r16, r14, r10);
        double r11 = r14 + r18;
        line(r14, r10, r11, r10);
        line(r11, r10, r11, r16);
        line(r11, r16, r14, r16);
    }

    public void setFont(String r5, int r10) {
        SystemFontMetrics r11 = new SystemFontMetrics(r5);
        this.fontMetrics = r11;
        String r12 = r11.getFont().getPSName();
        this.fontName = r12;
        this.fontSize = r10;
        String r13 = POSTSCRIPT_FONT_NAMES.get(r12);
        if (r13 != null) goto L5;
        r13 = this.fontName;
    L5:
        StringBuilder r14 = this.f642ps;
        Locale r15 = Locale.US;
        r14.append("/" + r13 + " findfont " + r10 + " scalefont setfont\n");
    }

    public void stroke() {
        this.f642ps.append("stroke\n");
    }

    public void text(String r10, double r11, double r12) {
        StringBuilder r5 = new StringBuilder();
        char[] r13 = r10.toCharArray();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L12;
        char r16 = r13[r15];
        if (r16 != '(') goto L7;
    L10:
        r5.append('\\');
        r5.append(r16);
    L11:
        r15 = r15 + 1;
        goto L3
    L7:
        if (r16 == ')') goto L10;
        if (r16 == '\\') goto L10;
        r5.append(r16);
        goto L11
    L12:
        String r17 = r5.toString();
        move(r11, r12);
        StringBuilder r18 = this.f642ps;
        Locale r19 = Locale.US;
        r18.append("(" + r17 + ") show\n");
        stroke();
    }

    public PostScriptDocument(String r5, int r10) {
        this.fontSize = 12;
        this.lineWidth = 0.3d;
        this.f642ps = new StringBuilder();
        this.closed = false;
        header();
        setFont(r5, r10);
    }

    public double getWidth(String r5) {
        return this.fontMetrics.getWidth(r5, this.fontSize);
    }
}
