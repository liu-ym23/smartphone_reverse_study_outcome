package com.tom_roush.fontbox.type1;

import android.util.Log;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f16033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Token f16034b;
    private int c;

    c(byte[] r2) {
        this.c = 0;
        this.f16033a = ByteBuffer.wrap(r2);
        this.f16034b = a(null);
    }

    private Token a(int r2) {
        this.f16033a.get();     // Catch: BufferUnderflowException -> L4
        byte[] r3 = new byte[r2];     // Catch: BufferUnderflowException -> L4
        this.f16033a.get(r3);     // Catch: BufferUnderflowException -> L4
        return new Token(r3, Token.j);
    L5:
        throw new IOException("Premature end of buffer reached");
    }

    private Token a(Token r5) {
    L2:
        boolean r0 = false;
    L4:
        if (this.f16033a.hasRemaining() == false) goto L82;
        char r1 = c();
        if (r1 == '%') goto L7;
        if (r1 == '(') goto L11;
        if (r1 == ')') goto L81;
        if (r1 == '[') goto L17;
        if (r1 == '{') goto L21;
        if (r1 == ']') goto L25;
        if (r1 == '}') goto L29;
        if (r1 == '/') goto L32;
        if (r1 == '<') goto L41;
        if (r1 == '>') goto L49;
        if (Character.isWhitespace(r1) == false) goto L57;
    L56:
        r0 = true;
        goto L4
    L57:
        if (r1 != 0) goto L59;
        Log.w("PdfBox-Android", "NULL byte in font, skipped");
        goto L56
    L59:
        ByteBuffer r2 = this.f16033a;
        r2.position(r2.position() - 1);
        Token r3 = d();
        if (r3 == null) goto L62;
        return r3;
    L62:
        String r4 = e();
        if (r4 == null) goto L79;
        if (r4.equals("RD") == false) goto L67;
    L71:
        if (r5 == null) goto L77;
        if (r5.b() != Token.e) goto L77;
        return a(r5.c());
    L77:
        throw new IOException("expected INTEGER before -| or RD");
    L67:
        if (r4.equals("-|") == true) goto L71;
        return new Token(r4, Token.f16029b);
    L79:
        throw new DamagedFontException("Could not read token at position " + this.f16033a.position());
    L49:
        if (c() == r1) goto L51;
        ByteBuffer r6 = this.f16033a;
        r6.position(r6.position() - 1);
        return new Token(r1, Token.f16029b);
    L51:
        return new Token(">>", Token.l);
    L41:
        if (c() == r1) goto L43;
        ByteBuffer r7 = this.f16033a;
        r7.position(r7.position() - 1);
        return new Token(r1, Token.f16029b);
    L43:
        return new Token("<<", Token.k);
    L32:
        String r8 = e();
        if (r8 == null) goto L37;
        return new Token(r8, Token.c);
    L37:
        throw new DamagedFontException("Could not read token at position " + this.f16033a.position());
    L29:
        return new Token(r1, Token.i);
    L25:
        return new Token(r1, Token.g);
    L21:
        return new Token(r1, Token.h);
    L17:
        return new Token(r1, Token.f);
    L81:
        throw new IOException("unexpected closing parenthesis");
    L11:
        return g();
    L7:
        f();
        goto L4
    L82:
        if (r0 == true) goto L2;
        return null;
    }

    private char c() {
        return (char) this.f16033a.get();
    L6:
        throw new IOException("Premature end of buffer reached");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:26:0x007b). Please report as a decompilation issue!!! */
    private Token d() {
        this.f16033a.mark();
        StringBuilder r0 = new StringBuilder();
        char r1 = c();
        boolean r4 = false;
        if (r1 == '+') goto L5;
        if (r1 == '-') goto L5;
    L7:
        if (Character.isDigit(r1) == false) goto L10;
        r0.append(r1);
        r1 = c();
        r4 = true;
        goto L7
    L10:
        if (r1 != '.') goto L14;
        r0.append(r1);
        r1 = c();
    L12:
        char r5 = r1;
        StringBuilder r2 = null;
    L25:
        if (Character.isDigit(r5) == false) goto L27;
    L26:
        r0.append(r5);
        r5 = c();
    L32:
        if (Character.isDigit(r5) == true) goto L26;
        if (r5 == 'E') goto L36;
        if (r5 == 'e') goto L36;
    L45:
        ByteBuffer r10 = this.f16033a;
        r10.position(r10.position() - 1);
        if (r2 == null) goto L54;
        return new Token(Integer.toString(Integer.parseInt(r0.toString(), Integer.parseInt(r2.toString()))), Token.e);
    L50:
        e = move-exception;
        throw new IOException("Invalid number '" + r0.toString() + "'", e);
    L54:
        return new Token(r0.toString(), Token.d);
    L36:
        r0.append(r5);
        char r6 = c();
        if (r6 != '-') goto L40;
        r0.append(r6);
        r6 = c();
    L40:
        if (Character.isDigit(r6) == true) goto L41;
    L29:
        this.f16033a.reset();
        return null;
    L41:
        r0.append(r6);
    L42:
        char r3 = c();
        if (Character.isDigit(r3) == false) goto L45;
        r0.append(r3);
        goto L42
    L27:
        if (r5 == 'e') goto L32;
        if (r5 == 'E') goto L32;
    L14:
        if (r1 != '#') goto L17;
        StringBuilder r7 = new StringBuilder();
        r5 = c();
        r2 = r0;
        r0 = r7;
        goto L25
    L17:
        if (r0.length() == 0) goto L29;
        if (r4 == false) goto L29;
        if (r1 == 'e') goto L12;
        if (r1 == 'E') goto L12;
        ByteBuffer r11 = this.f16033a;
        r11.position(r11.position() - 1);
        return new Token(r0.toString(), Token.e);
    L5:
        r0.append(r1);
        r1 = c();
        goto L7
    }

    private String e() {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (this.f16033a.hasRemaining() == false) goto L31;
        this.f16033a.mark();
        char r1 = c();
        if (Character.isWhitespace(r1) == true) goto L29;
        if (r1 == '(') goto L29;
        if (r1 == ')') goto L29;
        if (r1 == '<') goto L29;
        if (r1 == '>') goto L29;
        if (r1 == '[') goto L29;
        if (r1 == ']') goto L29;
        if (r1 == '{') goto L29;
        if (r1 == '}') goto L29;
        if (r1 == '/') goto L29;
        if (r1 == '%') goto L29;
        r0.append(r1);
    L29:
        this.f16033a.reset();
    L31:
        if (r0.length() != 0) goto L35;
        return null;
    L35:
        return r0.toString();
    }

    private String f() {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (this.f16033a.hasRemaining() == false) goto L12;
        char r1 = c();
        if (r1 == '\r') goto L12;
        if (r1 == '\n') goto L12;
        r0.append(r1);
    L12:
        return r0.toString();
    }

    private Token g() {
        StringBuilder r0 = new StringBuilder();
    L4:
        if (this.f16033a.hasRemaining() == false) goto L52;
        char r1 = c();
        if (r1 == '\n') goto L51;
        if (r1 == '\r') goto L51;
        if (r1 != '\\') goto L11;
        char r2 = c();
        if (r2 == '(') goto L42;
        if (r2 == ')') goto L41;
        if (r2 != '\\') goto L25;
        r0.append('\\');
    L44:
        if (Character.isDigit(r2) == false) goto L4;
        r0.append((char) Integer.parseInt(String.valueOf(new char[]{r2, c(), c()}), 8));     // Catch: NumberFormatException -> L48
    L48:
        e = move-exception;
        throw new IOException(e);
    L25:
        if (r2 != 'b') goto L27;
        r0.append('\b');
        goto L44
    L27:
        if (r2 != 'f') goto L29;
        char r3 = '\f';
    L38:
        r0.append(r3);
        goto L44
    L29:
        if (r2 != 'n') goto L31;
    L36:
        r0.append("\n");
        goto L44
    L31:
        if (r2 == 'r') goto L36;
        if (r2 != 't') goto L44;
        r3 = '\t';
        goto L38
    L41:
        r0.append(')');
        goto L44
    L42:
        r0.append('(');
        goto L44
    L11:
        if (r1 != '(') goto L12;
        this.c++;
        r0.append('(');
        goto L4
    L12:
        if (r1 != ')') goto L13;
        if (this.c == 0) goto L17;
        r0.append(')');
        this.c--;
        goto L4
    L17:
        return new Token(r0.toString(), Token.f16028a);
    L13:
        r0.append(r1);
    L51:
        r0.append("\n");
        goto L4
    L52:
        return null;
    }

    public Token a() {
        Token r0 = this.f16034b;
        this.f16034b = a(r0);
        return r0;
    }

    public boolean a(Token.Kind r1) {
        Token r0 = this.f16034b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() != r1) goto L7;
        return true;
    }

    public Token b() {
        return this.f16034b;
    }
}
