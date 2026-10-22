package keb;

import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static String a(Locale r3, b r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r5 = r3.getLanguage() + '-' + r3.getCountry();
        switch(r5.hashCode()) {
            case 95406413: goto L73;
            case 96598594: goto L69;
            case 96747053: goto L65;
            case 97640813: goto L61;
            case 99994381: goto L57;
            case 100471053: goto L53;
            case 100828572: goto L49;
            case 102169200: goto L45;
            case 104135475: goto L41;
            case 106935481: goto L37;
            case 108812813: goto L33;
            case 109706289: goto L29;
            case 110272621: goto L25;
            case 112149522: goto L21;
            case 115813226: goto L17;
            case 115813378: goto L13;
            case 115813762: goto L9;
            default: goto L93;
        };
    L93:
        return null;
    L9:
        if (r5.equals("zh-TW") == true) goto L77;
        return null;
    L77:
        return r4.q();
    L13:
        if (r5.equals("zh-HK") == true) goto L78;
        return null;
    L78:
        return r4.p();
    L17:
        if (r5.equals("zh-CN") == true) goto L79;
        return null;
    L79:
        return r4.o();
    L21:
        if (r5.equals("vi-VN") == true) goto L80;
        return null;
    L80:
        return r4.n();
    L25:
        if (r5.equals("th-TH") == true) goto L81;
        return null;
    L81:
        return r4.m();
    L29:
        if (r5.equals("st-JO") == true) goto L82;
        return null;
    L82:
        return r4.l();
    L33:
        if (r5.equals("ru-RU") == true) goto L83;
        return null;
    L83:
        return r4.k();
    L37:
        if (r5.equals("pt-BR") == true) goto L84;
        return null;
    L84:
        return r4.j();
    L41:
        if (r5.equals("ms-MY") == true) goto L85;
        return null;
    L85:
        return r4.i();
    L45:
        if (r5.equals("ko-KR") == true) goto L86;
        return null;
    L86:
        return r4.h();
    L49:
        if (r5.equals("ja-JP") == true) goto L87;
        return null;
    L87:
        return r4.g();
    L53:
        if (r5.equals("it-IT") == true) goto L88;
        return null;
    L88:
        return r4.f();
    L57:
        if (r5.equals("id-ID") == true) goto L89;
        return null;
    L89:
        return r4.e();
    L61:
        if (r5.equals("fr-FR") == true) goto L90;
        return null;
    L90:
        return r4.d();
    L65:
        if (r5.equals("es-ES") == true) goto L91;
        return null;
    L91:
        return r4.c();
    L69:
        if (r5.equals("en-US") == true) goto L92;
        return null;
    L92:
        return r4.b();
    L73:
        if (r5.equals("de-DE") == true) goto L76;
        return null;
    L76:
        return r4.a();
    }
}
