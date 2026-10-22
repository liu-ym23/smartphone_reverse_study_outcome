package androidx.core.net;

import ai.j0;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;

/* JADX INFO: loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri r10) {
        String r5 = r10.getScheme();
        String r11 = r10.getSchemeSpecificPart();
        if (r5 != null) goto L5;
    L49:
        StringBuilder r12 = new StringBuilder(64);
        if (r5 == null) goto L52;
        r12.append(r5);
        r12.append(':');
    L52:
        if (r11 == null) goto L55;
        r12.append(r11);
    L55:
        return r12.toString();
    L5:
        if (r5.equalsIgnoreCase("tel") == false) goto L7;
    L33:
        StringBuilder r13 = new StringBuilder(64);
        r13.append(r5);
        r13.append(':');
        if (r11 == null) goto L48;
        int r14 = 0;
    L37:
        if (r14 >= r11.length()) goto L48;
        char r15 = r11.charAt(r14);
        if (r15 == '-') goto L45;
        if (r15 == '@') goto L45;
        if (r15 == '.') goto L45;
        r13.append('x');
    L46:
        r14 = r14 + 1;
    L45:
        r13.append(r15);
    L48:
        return r13.toString();
    L7:
        if (r5.equalsIgnoreCase("sip") == true) goto L33;
        if (r5.equalsIgnoreCase("sms") == true) goto L33;
        if (r5.equalsIgnoreCase("smsto") == true) goto L33;
        if (r5.equalsIgnoreCase("mailto") == true) goto L33;
        if (r5.equalsIgnoreCase("nfc") == true) goto L33;
        if (r5.equalsIgnoreCase("http") == false) goto L20;
    L25:
        StringBuilder r16 = new StringBuilder("//");
        String r17 = "";
        if (r10.getHost() == null) goto L28;
        String r18 = r10.getHost();
    L29:
        r16.append(r18);
        if (r10.getPort() == (-1)) goto L32;
        r17 = ":" + r10.getPort();
    L32:
        r11 = j0.q(r16, r17, "/...");
        goto L49
    L28:
        r18 = "";
        goto L29
    L20:
        if (r5.equalsIgnoreCase(IIvyAIPackageResourceService.SCHEMA) == true) goto L25;
        if (r5.equalsIgnoreCase("ftp") == true) goto L25;
        if (r5.equalsIgnoreCase("rtsp") == false) goto L49;
        goto L25
    }
}
