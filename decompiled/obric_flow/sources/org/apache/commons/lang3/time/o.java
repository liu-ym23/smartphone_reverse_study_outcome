package org.apache.commons.lang3.time;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f20980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeZone f20981b = null;

    static {
        f20980a = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
        f20981b = new GmtTimeZone(false, 0, 0);
    }

    public static TimeZone a(String r10) {
        boolean r5 = "Z".equals(r10);
        TimeZone r11 = f20981b;
        if (r5 == false) goto L5;
    L29:
        return r11;
    L5:
        if ("UTC".equals(r10) == true) goto L29;
        Matcher r12 = f20980a.matcher(r10);
        if (r12.matches() == false) goto L27;
        String r13 = r12.group(2);
        boolean r14 = false;
        if (r13 == null) goto L12;
        int r15 = Integer.parseInt(r13);
    L13:
        String r16 = r12.group(4);
        if (r16 == null) goto L16;
        int r17 = Integer.parseInt(r16);
    L17:
        if (r15 != 0) goto L20;
        if (r17 != 0) goto L20;
        return r11;
    L20:
        String r18 = r12.group(1);
        if (r18 == null) goto L26;
        if (r18.charAt(0) != '-') goto L26;
        r14 = true;
    L26:
        return new GmtTimeZone(r14, r15, r17);
    L16:
        r17 = 0;
        goto L17
    L12:
        r15 = 0;
        goto L13
    L27:
        return null;
    }
}
