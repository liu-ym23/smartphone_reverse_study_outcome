package androidx.room.jarjarred.org.stringtemplate.v4;

import java.net.URLEncoder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class StringRenderer implements AttributeRenderer {
    public StringRenderer() {
    }

    public static String escapeHTML(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        StringBuilder r5 = new StringBuilder(r10.length());
        int r11 = r10.length();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L38;
        char r13 = r10.charAt(r12);
        if (r13 != '\t') goto L10;
    L35:
        r5.append(r13);
    L36:
        r12 = r12 + 1;
        goto L6
    L10:
        if (r13 == '\n') goto L35;
        if (r13 == '\r') goto L35;
        if (r13 != '&') goto L16;
        r5.append("&amp;");
        goto L36
    L16:
        if (r13 != '<') goto L18;
        r5.append("&lt;");
        goto L36
    L18:
        if (r13 == '>') goto L32;
        boolean r14 = true;
        if (r13 >= ' ') goto L22;
        boolean r15 = true;
    L24:
        if (r13 > '~') goto L27;
        r14 = false;
    L27:
        if (r15 == true) goto L31;
        if (r14 == true) goto L31;
        r5.append(r13);
    L31:
        r5.append("&#");
        r5.append(r13);
        r5.append(";");
        goto L36
    L22:
        r15 = false;
        goto L24
    L32:
        r5.append("&gt;");
        goto L36
    L38:
        return r5.toString();
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.AttributeRenderer
    public String toString(Object r5, String r10, Locale r11) {
        String r12 = (String) r5;
        if (r10 != null) goto L6;
        return r12;
    L6:
        if (r10.equals("upper") == false) goto L10;
        return r12.toUpperCase(r11);
    L10:
        if (r10.equals("lower") == false) goto L14;
        return r12.toLowerCase(r11);
    L14:
        if (r10.equals("cap") == false) goto L20;
        if (r12.length() > 0) goto L18;
        return r12;
    L18:
        return Character.toUpperCase(r12.charAt(0)) + r12.substring(1);
    L20:
        if (r10.equals("url-encode") == false) goto L24;
        return URLEncoder.encode(r12, "UTF-8");
    L24:
        if (r10.equals("xml-encode") == false) goto L28;
        return escapeHTML(r12);
    L28:
        return String.format(r11, r10, new Object[]{r12});
    }
}
