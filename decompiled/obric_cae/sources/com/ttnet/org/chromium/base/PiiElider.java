package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import android.util.Patterns;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class PiiElider {
    private static final String[] APP_NAMESPACE = null;
    private static final String CONSOLE_ELISION = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";
    private static final Pattern CONSOLE_MSG = null;
    private static final Pattern DOMAIN_NAME = null;
    private static final String EMAIL_ELISION = "XXX@EMAIL.ELIDED";
    private static final String GOOD_GTLD_CHAR = "a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GTLD = "[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String HOST_NAME = "([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final Pattern IP_ADDRESS = null;
    private static final String IP_ELISION = "1.2.3.4";
    private static final String IRI = "[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}";
    private static final Pattern LIKELY_EXCEPTION_LOG = null;
    private static final Pattern MAC_ADDRESS = null;
    private static final String MAC_ELISION = "01:23:45:67:89:AB";
    private static final String[] SYSTEM_NAMESPACE = null;
    private static final String URL_ELISION = "HTTP://WEBADDRESS.ELIDED";
    private static final Pattern WEB_URL = null;

    static {
        Pattern r8 = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
        IP_ADDRESS = r8;
        Pattern r10 = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + r8 + ")");
        DOMAIN_NAME = r10;
        LIKELY_EXCEPTION_LOG = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
        WEB_URL = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + r10 + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        MAC_ADDRESS = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        CONSOLE_MSG = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        APP_NAMESPACE = new String[]{"org.chromium.", "com.google."};
        SYSTEM_NAMESPACE = new String[]{"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", "android.text", "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public PiiElider() {
    }

    public static String elideConsole(String r8) {
        return CONSOLE_MSG.matcher(r8).replaceAll(CONSOLE_ELISION);
    }

    public static String elideEmail(String r8) {
        return Patterns.EMAIL_ADDRESS.matcher(r8).replaceAll(EMAIL_ELISION);
    }

    public static String elideIp(String r8) {
        return Patterns.IP_ADDRESS.matcher(r8).replaceAll(IP_ELISION);
    }

    public static String elideMac(String r8) {
        return MAC_ADDRESS.matcher(r8).replaceAll(MAC_ELISION);
    }

    public static String elideUrl(String r8) {
        if (LIKELY_EXCEPTION_LOG.matcher(r8).find() == false) goto L5;
        return r8;
    L5:
        StringBuilder r10 = new StringBuilder(r8);
        Matcher r11 = WEB_URL.matcher(r10);
        int r12 = 0;
    L7:
        if (r11.find(r12) == false) goto L15;
        int r13 = r11.start();
        int r14 = r11.end();
        String r15 = r10.substring(r13, r14);
        if (likelyToBeAppNamespace(r15) == true) goto L13;
        if (likelyToBeSystemNamespace(r15) == true) goto L13;
        r10.replace(r13, r14, URL_ELISION);
        r12 = r13 + 24;
        r11 = WEB_URL.matcher(r10);
    L13:
        r12 = r14;
        goto L7
    L15:
        return r10.toString();
    }

    private static boolean likelyToBeAppNamespace(String r8) {
        String[] r10 = APP_NAMESPACE;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r8.startsWith(r10[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean likelyToBeSystemNamespace(String r8) {
        String[] r10 = SYSTEM_NAMESPACE;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r8.startsWith(r10[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @UsedByReflection("jni_android.cc")
    public static String sanitizeStacktrace(String r8) {
        String[] r10 = r8.split("\\n");
        r10[0] = elideUrl(r10[0]);
        int r11 = 1;
    L4:
        if (r11 >= r10.length) goto L10;
        if (r10[r11].startsWith("Caused by:") == false) goto L8;
        r10[r11] = elideUrl(r10[r11]);
    L8:
        r11 = r11 + 1;
        goto L4
    L10:
        return TextUtils.join("\n", r10);
    }
}
