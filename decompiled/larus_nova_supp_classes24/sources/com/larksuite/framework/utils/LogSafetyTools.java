package com.larksuite.framework.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LogSafetyTools {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LogSafetyTools$REGEX_DOC_TOKEN$2.INSTANCE);
    }

    @JvmStatic
    public static final String a(String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
        return r4;
    L9:
        return ((Regex) a.getValue()).replace(r4, "DOC_URL_TOKEN");
    L5:
        if (StringsKt.contains$default(r4, "http", false, 2, null) != true) goto L7;
        r0 = true;
        goto L7
    }
}
