package u7b;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Pattern a = null;
    public static final Pattern b = null;
    public static final Pattern c = null;
    public static final C0308a d = null;

    /* JADX INFO: renamed from: u7b.a$a, reason: collision with other inner class name */
    public class C0308a {
        public C0308a() {
        }

        public final void a(String r3, StringBuilder r4) {
            if (r3.charAt(0) != '\\') goto L5;
            r4.append(r3, 1, r3.length());
            return;
        L5:
            r4.append(b.a(r3));
        }
    }

    static {
        a = PatternProtector.compile("[\\\\&]");
        b = PatternProtector.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
        PatternProtector.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        c = PatternProtector.compile("[ \t\r\n]+");
        d = new C0308a();
    }

    public static String a(String r1) {
        String r2 = r1.trim();
        Locale r0 = Locale.ROOT;
        String r3 = r2.toLowerCase(r0).toUpperCase(r0);
        return c.matcher(r3).replaceAll(" ");
    }

    public static String b(String r5) {
        if (a.matcher(r5).find() == false) goto L17;
        Pattern r0 = b;
        C0308a r1 = d;
        Matcher r2 = r0.matcher(r5);
        if (r2.find() == false) goto L18;
        StringBuilder r3 = new StringBuilder(r5.length() + 16);
        int r4 = 0;
    L8:
        r3.append(r5, r4, r2.start());
        r1.a(r2.group(), r3);
        r4 = r2.end();
        if (r2.find() == true) goto L8;
        if (r4 == r5.length()) goto L14;
        r3.append(r5, r4, r5.length());
    L14:
        return r3.toString();
    L18:
        return r5;
    L17:
        return r5;
    }
}
