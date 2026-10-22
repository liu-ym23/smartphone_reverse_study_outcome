package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders;

    private MailTo() {
        this.mHeaders = new HashMap();
    }

    public static boolean isMailTo(@Nullable Uri r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (MAILTO.equals(r10.getScheme()) == false) goto L6;
        return true;
    }

    public static boolean isMailTo(@Nullable String r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.startsWith(MAILTO_SCHEME) == false) goto L6;
        return true;
    }

    @NonNull
    public static MailTo parse(@NonNull Uri r10) {
        return parse(r10.toString());
    }

    @NonNull
    public static MailTo parse(@NonNull String r10) {
        Preconditions.checkNotNull(r10);
        if (isMailTo(r10) == false) goto L30;
        int r11 = r10.indexOf(35);
        if (r11 == (-1)) goto L7;
        r10 = r10.substring(0, r11);
    L7:
        int r12 = r10.indexOf(63);
        if (r12 != (-1)) goto L10;
        String r13 = Uri.decode(r10.substring(7));
        String r14 = null;
    L11:
        MailTo r15 = new MailTo();
        if (r14 == null) goto L24;
        String[] r16 = r14.split("&");
        int r17 = r16.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L24;
        String[] r19 = r16[r18].split("=", 2);
        if (r19.length == 0) goto L23;
        String r20 = Uri.decode(r19[0]).toLowerCase(Locale.ROOT);
        if (r19.length <= 1) goto L21;
        String r21 = Uri.decode(r19[1]);
    L22:
        r15.mHeaders.put(r20, r21);
        goto L23
    L21:
        r21 = null;
    L23:
        r18 = r18 + 1;
    L24:
        String r110 = r15.getTo();
        if (r110 == null) goto L27;
        r13 = r13 + ", " + r110;
    L27:
        r15.mHeaders.put("to", r13);
        return r15;
    L10:
        r13 = Uri.decode(r10.substring(7, r12));
        r14 = r10.substring(r12 + 1);
        goto L11
    L30:
        throw new ParseException("Not a mailto scheme");
    }

    @Nullable
    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @Nullable
    public String getBody() {
        return this.mHeaders.get(BODY);
    }

    @Nullable
    public String getCc() {
        return this.mHeaders.get(CC);
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Nullable
    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    @Nullable
    public String getTo() {
        return this.mHeaders.get("to");
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder(MAILTO_SCHEME);
        r10.append('?');
        Iterator<Map.Entry<String, String>> r11 = this.mHeaders.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<String, String> r12 = r11.next();
        r10.append(Uri.encode(r12.getKey()));
        r10.append('=');
        r10.append(Uri.encode(r12.getValue()));
        r10.append(Typography.amp);
        goto L4
    L7:
        return r10.toString();
    }
}
