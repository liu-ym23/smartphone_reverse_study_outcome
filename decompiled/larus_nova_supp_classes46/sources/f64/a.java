package f64;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements XmlSerializer {
    public static final String[] h = null;
    public final char[] a;
    public int b;
    public Writer c;
    public OutputStream d;
    public CharsetEncoder e;
    public final ByteBuffer f;
    public boolean g;

    static {
        h = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    }

    public final void d() throws IOException {
        int r0 = this.f.position();
        if (r0 <= 0) goto L6;
        this.f.flip();
        this.d.write(this.f.array(), 0, r0);
        this.f.clear();
        return;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void flush() throws IOException {
        int r0 = this.b;
        if (r0 > 0) goto L5;
        return;
    L5:
        if (this.d == null) goto L15;
        CharBuffer r1 = CharBuffer.wrap(this.a, 0, r0);
        CoderResult r2 = this.e.encode(r1, this.f, true);
    L8:
        if (r2.isError() == true) goto L14;
        if (r2.isOverflow() == false) goto L12;
        d();
        r2 = this.e.encode(r1, this.f, true);
        goto L8
    L12:
        d();
        this.d.flush();
    L16:
        this.b = 0;
        return;
    L14:
        throw new IOException(r2.toString());
    L15:
        this.c.write(this.a, 0, r0);
        this.c.flush();
        goto L16
    }

    public a() {
        this.a = new char[8192];
        this.f = ByteBuffer.allocate(8192);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public final void a(char r3) throws IOException {
        int r0 = this.b;
        if (r0 < 8191) goto L5;
        flush();
        r0 = this.b;
    L5:
        this.a[r0] = r3;
        this.b = r0 + 1;
    }

    public final void c(String r9) throws IOException {
        int r0 = r9.length();
        String[] r1 = h;
        char r2 = (char) r1.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L14;
        char r6 = r9.charAt(r4);
        if (r6 >= r2) goto L13;
        String r7 = r1[r6];
        if (r7 == null) goto L13;
        if (r5 >= r4) goto L12;
        b(r9, r5, r4 - r5);
    L12:
        r5 = r4 + 1;
        b(r7, 0, r7.length());
    L13:
        r4 = r4 + 1;
        goto L3
    L14:
        if (r5 >= r4) goto L21;
        b(r9, r5, r4 - r5);
        return;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(Writer r1) throws IOException, IllegalArgumentException, IllegalStateException {
        this.c = r1;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer text(String r4) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.g == false) goto L5;
        b(">", 0, 1);
        this.g = false;
    L5:
        c(r4);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer endTag(String r4, String r5) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.g == false) goto L5;
        b(" />\n", 0, 4);
    L9:
        this.g = false;
        return this;
    L5:
        b("</", 0, 2);
        if (r4 == null) goto L8;
        b(r4, 0, r4.length());
        a(':');
    L8:
        b(r5, 0, r5.length());
        b(">\n", 0, 2);
        goto L9
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setFeature(String r1, boolean r2) throws IllegalArgumentException, IllegalStateException {
        if (r1.equals("http://xmlpull.org/v1/doc/features.html#indent-output") == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setOutput(OutputStream r2, String r3) throws IOException, IllegalArgumentException, IllegalStateException {
        if (r2 == null) goto L13;
        this.e = Charset.forName(r3).newEncoder();     // Catch: UnsupportedCharsetException -> L6 IllegalCharsetNameException -> L9
        this.d = r2;
        return;
    L9:
        e = move-exception;
        throw ((UnsupportedEncodingException) new UnsupportedEncodingException(r3).initCause(e));
    L6:
        e = move-exception;
        throw ((UnsupportedEncodingException) new UnsupportedEncodingException(r3).initCause(e));
    L13:
        throw new IllegalArgumentException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void setPrefix(String r1, String r2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final void startDocument(String r2, Boolean r3) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder r4 = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        if (r3.booleanValue() == false) goto L5;
        String r5 = "yes";
    L6:
        r4.append(r5);
        r4.append("' ?>\n");
        String r6 = r4.toString();
        b(r6, 0, r6.length());
        return;
    L5:
        r5 = "no";
        goto L6
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer startTag(String r4, String r5) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.g == false) goto L5;
        b(">\n", 0, 2);
    L5:
        a('<');
        if (r4 == null) goto L8;
        b(r4, 0, r4.length());
        a(':');
    L8:
        b(r5, 0, r5.length());
        this.g = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public final XmlSerializer attribute(String r3, String r4, String r5) throws IOException, IllegalArgumentException, IllegalStateException {
        a(' ');
        if (r3 == null) goto L5;
        b(r3, 0, r3.length());
        a(':');
    L5:
        b(r4, 0, r4.length());
        b("=\"", 0, 2);
        c(r5);
        a('\"');
        return this;
    }

    public final void b(String r4, int r5, int r6) throws IOException {
        if (r6 <= 8192) goto L12;
        int r7 = r6 + r5;
    L5:
        if (r5 >= r7) goto L11;
        int r1 = r5 + 8192;
        if (r1 >= r7) goto L9;
        int r2 = 8192;
    L10:
        b(r4, r5, r2);
        r5 = r1;
        goto L5
    L9:
        r2 = r7 - r5;
        goto L10
    L11:
        return;
    L12:
        int r3 = this.b;
        if ((r3 + r6) <= 8192) goto L15;
        flush();
        r3 = this.b;
    L15:
        r4.getChars(r5, r5 + r6, this.a, r3);
        this.b = r3 + r6;
    }
}
