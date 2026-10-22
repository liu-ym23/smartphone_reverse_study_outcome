package androidx.core.net;

import ai.j0;
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

    public static boolean isMailTo(@Nullable String r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.startsWith(MAILTO_SCHEME) == false) goto L6;
        return true;
    }

    @NonNull
    public static MailTo parse(@NonNull String r10) throws ParseException {
        Preconditions.checkNotNull(r10);
        if (isMailTo(r10) == false) goto L30;
        int r5 = r10.indexOf(35);
        if (r5 == (-1)) goto L7;
        r10 = r10.substring(0, r5);
    L7:
        int r11 = r10.indexOf(63);
        if (r11 != (-1)) goto L10;
        String r12 = Uri.decode(r10.substring(7));
        String r13 = null;
    L11:
        MailTo r14 = new MailTo();
        if (r13 == null) goto L24;
        String[] r15 = r13.split("&");
        int r16 = r15.length;
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L24;
        String[] r18 = r15[r17].split("=", 2);
        if (r18.length == 0) goto L23;
        String r19 = Uri.decode(r18[0]).toLowerCase(Locale.ROOT);
        if (r18.length <= 1) goto L21;
        String r20 = Uri.decode(r18[1]);
    L22:
        r14.mHeaders.put(r19, r20);
        goto L23
    L21:
        r20 = null;
    L23:
        r17 = r17 + 1;
    L24:
        String r110 = r14.getTo();
        if (r110 == null) goto L27;
        r12 = j0.D(r12, ", ", r110);
    L27:
        r14.mHeaders.put(TO, r12);
        return r14;
    L10:
        r12 = Uri.decode(r10.substring(7, r11));
        r13 = r10.substring(r11 + 1);
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
        return this.mHeaders.get(TO);
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("mailto:?");
        Iterator<Map.Entry<String, String>> r10 = this.mHeaders.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Map.Entry<String, String> r11 = r10.next();
        r5.append(Uri.encode(r11.getKey()));
        r5.append('=');
        r5.append(Uri.encode(r11.getValue()));
        r5.append(Typography.amp);
        goto L4
    L7:
        return r5.toString();
    }

    public static boolean isMailTo(@Nullable Uri r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (MAILTO.equals(r5.getScheme()) == false) goto L6;
        return true;
    }

    @NonNull
    public static MailTo parse(@NonNull Uri r5) throws ParseException {
        return parse(r5.toString());
    }
}
