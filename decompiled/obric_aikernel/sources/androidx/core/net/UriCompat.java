package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri r10) {
        String r11 = r10.getScheme();
        String r12 = r10.getSchemeSpecificPart();
        if (r11 != null) goto L5;
    L48:
        StringBuilder r13 = new StringBuilder(64);
        if (r11 == null) goto L51;
        r13.append(r11);
        r13.append(':');
    L51:
        if (r12 == null) goto L54;
        r13.append(r12);
    L54:
        return r13.toString();
    L5:
        if (r11.equalsIgnoreCase("tel") == false) goto L7;
    L33:
        StringBuilder r14 = new StringBuilder(64);
        r14.append(r11);
        r14.append(':');
        if (r12 == null) goto L47;
        int r15 = 0;
    L37:
        if (r15 >= r12.length()) goto L47;
        char r16 = r12.charAt(r15);
        if (r16 == '-') goto L45;
        if (r16 == '@') goto L45;
        if (r16 == '.') goto L45;
        r16 = 'x';
    L45:
        r14.append(r16);
        r15 = r15 + 1;
    L47:
        return r14.toString();
    L7:
        if (r11.equalsIgnoreCase("sip") == true) goto L33;
        if (r11.equalsIgnoreCase("sms") == true) goto L33;
        if (r11.equalsIgnoreCase("smsto") == true) goto L33;
        if (r11.equalsIgnoreCase("mailto") == true) goto L33;
        if (r11.equalsIgnoreCase("nfc") == true) goto L33;
        if (r11.equalsIgnoreCase("http") == false) goto L20;
    L25:
        StringBuilder r17 = new StringBuilder();
        r17.append("//");
        String r18 = "";
        if (r10.getHost() == null) goto L28;
        String r19 = r10.getHost();
    L29:
        r17.append(r19);
        if (r10.getPort() == (-1)) goto L32;
        r18 = ":" + r10.getPort();
    L32:
        r17.append(r18);
        r17.append("/...");
        r12 = r17.toString();
        goto L48
    L28:
        r19 = "";
        goto L29
    L20:
        if (r11.equalsIgnoreCase("https") == true) goto L25;
        if (r11.equalsIgnoreCase("ftp") == true) goto L25;
        if (r11.equalsIgnoreCase("rtsp") == false) goto L48;
        goto L25
    }
}
