package fi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f16902a = null;

    static {
        f16902a = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    public static String a(String r5) {
        Matcher r10 = f16902a.matcher(r5);
        if (r10.find() == true) goto L5;
        return "UTF-8";
    L5:
        return r10.group(1).replaceAll("[\"\\\\]", "");
    }
}
