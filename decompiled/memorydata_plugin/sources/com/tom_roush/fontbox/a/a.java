package com.tom_roush.fontbox.a;

import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f15885a;

    public a(InputStream r1) {
        this.f15885a = r1;
    }

    private f a() {
        f r0 = new f();
        String r1 = h();
        if ("KP".equals(r1) == false) goto L8;
        r0.a(h());
        String r2 = h();
    L5:
        r0.b(r2);
        r0.a(f());
    L6:
        r0.b(f());
    L16:
        return r0;
    L8:
        if ("KPH".equals(r1) == false) goto L11;
        r0.a(a(h()));
        r2 = a(h());
        goto L5
    L11:
        if ("KPX".equals(r1) == false) goto L14;
        r0.a(h());
        r0.b(h());
        r0.a(f());
        r0.b(0.0f);
        goto L16
    L14:
        if ("KPY".equals(r1) == false) goto L18;
        r0.a(h());
        r0.b(h());
        r0.a(0.0f);
        goto L6
    L18:
        throw new IOException("Error expected kern pair command actual='" + r1 + "'");
    }

    private String a(String r5) {
        if (r5.length() < 2) goto L22;
        int r4 = 0;
        if (r5.charAt(0) != '<') goto L20;
        if (r5.charAt(r5.length() - 1) != '>') goto L20;
        String r6 = r5.substring(1, r5.length() - 1);
        byte[] r0 = new byte[r6.length() / 2];
    L10:
        if (r4 >= r6.length()) goto L18;
        r0[r4 / 2] = (byte) Integer.parseInt(Character.toString(r6.charAt(r4)) + r6.charAt(r4 + 1), 16);     // Catch: NumberFormatException -> L14
        r4 = r4 + 2;
    L14:
        e = move-exception;
        throw new IOException("Error parsing AFM file:" + e);
    L18:
        return new String(r0, com.tom_roush.fontbox.g.b.f16026a);
    L20:
        throw new IOException("String should be enclosed by angle brackets '" + r5 + "'");
    L22:
        throw new IOException("Error: Expected hex string of length >= 2 not='" + r5);
    }

    private void a(e r7) {
    L2:
        String r0 = h();
        if (r0.equals("EndKernData") == true) goto L46;
        int r2 = 0;
        if ("StartTrackKern".equals(r0) == true) goto L6;
        if ("StartKernPairs".equals(r0) == true) goto L16;
        if ("StartKernPairs0".equals(r0) == true) goto L26;
        if ("StartKernPairs1".equals(r0) == false) goto L45;
        int r1 = e();
    L37:
        if (r2 >= r1) goto L39;
        r7.c(a());
        r2 = r2 + 1;
        goto L37
    L39:
        String r3 = h();
        if (r3.equals("EndKernPairs") == true) goto L2;
        throw new IOException("Error: Expected 'EndKernPairs' actual '" + r3 + "'");
    L45:
        throw new IOException("Unknown kerning data type '" + r0 + "'");
    L26:
        int r4 = e();
    L27:
        if (r2 >= r4) goto L29;
        r7.b(a());
        r2 = r2 + 1;
        goto L27
    L29:
        String r5 = h();
        if (r5.equals("EndKernPairs") == true) goto L2;
        throw new IOException("Error: Expected 'EndKernPairs' actual '" + r5 + "'");
    L16:
        int r6 = e();
    L17:
        if (r2 >= r6) goto L19;
        r7.a(a());
        r2 = r2 + 1;
        goto L17
    L19:
        String r8 = h();
        if (r8.equals("EndKernPairs") == true) goto L2;
        throw new IOException("Error: Expected 'EndKernPairs' actual '" + r8 + "'");
    L6:
        int r9 = e();
    L7:
        if (r2 >= r9) goto L9;
        h r10 = new h();
        r10.a(e());
        r10.d(f());
        r10.c(f());
        r10.b(f());
        r10.a(f());
        r7.a(r10);
        r2 = r2 + 1;
        goto L7
    L9:
        String r11 = h();
        if (r11.equals("EndTrackKern") == true) goto L2;
        throw new IOException("Error: Expected 'EndTrackKern' actual '" + r11 + "'");
    }

    private void a(StringTokenizer r3) {
        if (r3.hasMoreTokens() == false) goto L10;
        String r2 = r3.nextToken();
        if (";".equals(r2) == false) goto L8;
        return;
    L8:
        throw new IOException("Error: Expected semicolon in stream actual='" + r2 + "'");
    L10:
        throw new IOException("CharMetrics is missing a semicolon after a command");
    }

    private boolean a(int r1) {
        if (r1 != 13) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 10) goto L8;
        return false;
    }

    private c b() {
        c r1 = new c();
        StringTokenizer r2 = new StringTokenizer(g(), " ;");
        String r9 = r2.nextToken();
        if (r9.equals("CC") == false) goto L23;
        r1.a(r2.nextToken());
        int r10 = Integer.parseInt(r2.nextToken());     // Catch: NumberFormatException -> L19
        int r3 = 0;
    L7:
        if (r3 >= r10) goto L18;
        d r5 = new d();
        String r6 = r2.nextToken();
        if (r6.equals("PCC") == false) goto L17;
        String r7 = r2.nextToken();
        int r8 = Integer.parseInt(r2.nextToken());     // Catch: NumberFormatException -> L13
        int r11 = Integer.parseInt(r2.nextToken());     // Catch: NumberFormatException -> L13
        r5.a(r7);     // Catch: NumberFormatException -> L13
        r5.a(r8);     // Catch: NumberFormatException -> L13
        r5.b(r11);     // Catch: NumberFormatException -> L13
        r1.a(r5);     // Catch: NumberFormatException -> L13
        r3 = r3 + 1;
    L13:
        e = move-exception;
        throw new IOException("Error parsing AFM document:" + e);
    L17:
        throw new IOException("Expected 'PCC' actual='" + r6 + "'");
    L18:
        return r1;
    L19:
        e = move-exception;
        throw new IOException("Error parsing AFM document:" + e);
    L23:
        throw new IOException("Expected 'CC' actual='" + r9 + "'");
    }

    private e b(boolean r9) {
        e r0 = new e();
        String r1 = h();
        if ("StartFontMetrics".equals(r1) == false) goto L120;
        r0.a(f());
        boolean r4 = false;
    L5:
        String r5 = h();
        if ("EndFontMetrics".equals(r5) == true) goto L118;
        if ("FontName".equals(r5) == true) goto L9;
        if ("FullName".equals(r5) == true) goto L12;
        if ("FamilyName".equals(r5) == true) goto L15;
        if ("Weight".equals(r5) == true) goto L18;
        if ("FontBBox".equals(r5) == true) goto L21;
        if ("Version".equals(r5) == true) goto L24;
        if ("Notice".equals(r5) == true) goto L27;
        if ("EncodingScheme".equals(r5) == true) goto L30;
        if ("MappingScheme".equals(r5) == true) goto L33;
        if ("EscChar".equals(r5) == true) goto L36;
        if ("CharacterSet".equals(r5) == true) goto L39;
        if ("Characters".equals(r5) == true) goto L42;
        if ("IsBaseFont".equals(r5) == true) goto L45;
        if ("VVector".equals(r5) == true) goto L48;
        if ("IsFixedV".equals(r5) == true) goto L51;
        if ("CapHeight".equals(r5) == true) goto L54;
        if ("XHeight".equals(r5) == true) goto L57;
        if ("Ascender".equals(r5) == true) goto L60;
        if ("Descender".equals(r5) == true) goto L63;
        if ("StdHW".equals(r5) == true) goto L66;
        if ("StdVW".equals(r5) == true) goto L69;
        if ("Comment".equals(r5) == true) goto L72;
        if ("UnderlinePosition".equals(r5) == true) goto L75;
        if ("UnderlineThickness".equals(r5) == true) goto L78;
        if ("ItalicAngle".equals(r5) == true) goto L81;
        if ("CharWidth".equals(r5) == true) goto L84;
        if ("IsFixedPitch".equals(r5) == true) goto L87;
        if ("StartCharMetrics".equals(r5) == true) goto L90;
        if (r9 == true) goto L109;
        if ("StartComposites".equals(r5) == false) goto L109;
        int r6 = e();
        int r7 = 0;
    L102:
        if (r7 >= r6) goto L104;
        r0.a(b());
        r7 = r7 + 1;
        goto L102
    L104:
        String r8 = h();
        if (r8.equals("EndComposites") == true) goto L5;
        throw new IOException("Error: Expected 'EndComposites' actual '" + r8 + "'");
    L109:
        if (r9 == true) goto L113;
        if ("StartKernData".equals(r5) == false) goto L113;
        a(r0);
    L113:
        if (r9 == false) goto L117;
        if (r4 == true) goto L118;
    L117:
        throw new IOException("Unknown AFM key '" + r5 + "'");
    L90:
        int r10 = e();
        ArrayList r11 = new ArrayList(r10);
        int r12 = 0;
    L91:
        if (r12 >= r10) goto L93;
        r11.add(c());
        r12 = r12 + 1;
        goto L91
    L93:
        String r13 = h();
        if (r13.equals("EndCharMetrics") == false) goto L97;
        r0.a(r11);
        r4 = true;
        goto L5
    L97:
        throw new IOException("Error: Expected 'EndCharMetrics' actual '" + r13 + "'");
    L87:
        r0.c(d());
        goto L5
    L84:
        r0.b(new float[]{f(), f()});
        goto L5
    L81:
        r0.h(f());
        goto L5
    L78:
        r0.g(f());
        goto L5
    L75:
        r0.f(f());
        goto L5
    L72:
        r0.b(g());
        goto L5
    L69:
        r0.j(f());
        goto L5
    L66:
        r0.i(f());
        goto L5
    L63:
        r0.e(f());
        goto L5
    L60:
        r0.d(f());
        goto L5
    L57:
        r0.c(f());
        goto L5
    L54:
        r0.b(f());
        goto L5
    L51:
        r0.b(d());
        goto L5
    L48:
        r0.a(new float[]{f(), f()});
        goto L5
    L45:
        r0.a(d());
        goto L5
    L42:
        r0.c(e());
        goto L5
    L39:
        r0.i(g());
        goto L5
    L36:
        r0.b(e());
        goto L5
    L33:
        r0.a(e());
        goto L5
    L30:
        r0.h(g());
        goto L5
    L27:
        r0.g(g());
        goto L5
    L24:
        r0.j(g());
        goto L5
    L21:
        com.tom_roush.fontbox.g.a r14 = new com.tom_roush.fontbox.g.a();
        r14.a(f());
        r14.b(f());
        r14.c(f());
        r14.d(f());
        r0.a(r14);
        goto L5
    L18:
        r0.f(g());
        goto L5
    L15:
        r0.e(g());
        goto L5
    L12:
        r0.d(g());
        goto L5
    L9:
        r0.c(g());
    L118:
        return r0;
    L120:
        throw new IOException("Error: The AFM file should start with StartFontMetrics and not '" + r1 + "'");
    }

    private boolean b(int r1) {
        if (r1 != 32) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 9) goto L12;
        if (r1 == 13) goto L12;
        if (r1 == 10) goto L12;
        return false;
    }

    private b c() {
        b r0 = new b();
        StringTokenizer r2 = new StringTokenizer(g());
    L57:
    L54:
        e = move-exception;
        throw new IOException("Error: Corrupt AFM document:" + e);
    L4:
        if (r2.hasMoreTokens() == false) goto L53;
        String r1 = r2.nextToken();     // Catch: NumberFormatException -> L54
        if (r1.equals("C") == false) goto L10;
        r0.a(Integer.parseInt(r2.nextToken()));     // Catch: NumberFormatException -> L54
    L8:
        a(r2);     // Catch: NumberFormatException -> L54
        goto L57
    L10:
        if (r1.equals("CH") == false) goto L13;
        r0.a(Integer.parseInt(r2.nextToken(), 16));     // Catch: NumberFormatException -> L54
        goto L8
    L13:
        if (r1.equals("WX") == false) goto L16;
        r0.e(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        goto L8
    L16:
        if (r1.equals("W0X") == false) goto L19;
        r0.a(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        goto L8
    L19:
        if (r1.equals("W1X") == false) goto L22;
        r0.c(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        goto L8
    L22:
        if (r1.equals("WY") == false) goto L25;
        r0.f(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        goto L8
    L25:
        if (r1.equals("W0Y") == false) goto L28;
        r0.b(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        goto L8
    L28:
        if (r1.equals("W1Y") == false) goto L31;
        r0.d(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        goto L8
    L31:
        if (r1.equals(ExifInterface.LONGITUDE_WEST) == false) goto L34;
        r0.b(new float[]{Float.parseFloat(r2.nextToken()), Float.parseFloat(r2.nextToken())});     // Catch: NumberFormatException -> L54
        goto L8
    L34:
        if (r1.equals("W0") == false) goto L37;
        r0.c(new float[]{Float.parseFloat(r2.nextToken()), Float.parseFloat(r2.nextToken())});     // Catch: NumberFormatException -> L54
        goto L8
    L37:
        if (r1.equals("W1") == false) goto L40;
        r0.d(new float[]{Float.parseFloat(r2.nextToken()), Float.parseFloat(r2.nextToken())});     // Catch: NumberFormatException -> L54
        goto L8
    L40:
        if (r1.equals("VV") == false) goto L43;
        r0.a(new float[]{Float.parseFloat(r2.nextToken()), Float.parseFloat(r2.nextToken())});     // Catch: NumberFormatException -> L54
        goto L8
    L43:
        if (r1.equals("N") == false) goto L46;
        r0.a(r2.nextToken());     // Catch: NumberFormatException -> L54
        goto L8
    L46:
        if (r1.equals("B") == false) goto L49;
        com.tom_roush.fontbox.g.a r3 = new com.tom_roush.fontbox.g.a();     // Catch: NumberFormatException -> L54
        r3.a(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        r3.b(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        r3.c(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        r3.d(Float.parseFloat(r2.nextToken()));     // Catch: NumberFormatException -> L54
        r0.a(r3);     // Catch: NumberFormatException -> L54
        goto L8
    L49:
        if (r1.equals(i.u) == false) goto L52;
        g r4 = new g();     // Catch: NumberFormatException -> L54
        r4.b(r2.nextToken());     // Catch: NumberFormatException -> L54
        r4.a(r2.nextToken());     // Catch: NumberFormatException -> L54
        r0.a(r4);     // Catch: NumberFormatException -> L54
        goto L8
    L52:
        throw new IOException("Unknown CharMetrics command '" + r1 + "'");     // Catch: NumberFormatException -> L54
    L53:
        return r0;
    }

    private boolean d() {
        return Boolean.parseBoolean(h());
    }

    private int e() {
        return Integer.parseInt(h());
    L5:
        e = move-exception;
        throw new IOException("Error parsing AFM document:" + e);
    }

    private float f() {
        return Float.parseFloat(h());
    }

    private String g() {
        StringBuilder r0 = new StringBuilder(60);
    L3:
        int r1 = this.f15885a.read();
        if (b(r1) == true) goto L3;
    L6:
        r0.append((char) r1);
        r1 = this.f15885a.read();
        if (r1 == (-1)) goto L12;
        if (a(r1) == false) goto L6;
    L12:
        return r0.toString();
    }

    private String h() {
        StringBuilder r0 = new StringBuilder(24);
    L3:
        int r1 = this.f15885a.read();
        if (b(r1) == true) goto L3;
    L6:
        r0.append((char) r1);
        r1 = this.f15885a.read();
        if (r1 == (-1)) goto L12;
        if (b(r1) == false) goto L6;
    L12:
        return r0.toString();
    }

    public e a(boolean r1) {
        return b(r1);
    }
}
