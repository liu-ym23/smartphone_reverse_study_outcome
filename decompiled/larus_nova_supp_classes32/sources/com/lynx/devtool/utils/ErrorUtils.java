package com.lynx.devtool.utils;

import android.text.TextUtils;
import com.lynx.tasm.LynxError;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ErrorUtils {
    protected static final int CONSOLE_LOG_ERROR = 2;
    private static final int CONSOLE_LOG_INFO = 0;
    private static final int CONSOLE_LOG_VERBOSE = -1;
    protected static final int CONSOLE_LOG_WARNING = 1;

    public ErrorUtils() {
    }

    public static int errorLevelStrToInt(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return 2;
    L5:
        if (r2 != null) goto L7;
        return 2;
    L7:
        if (r2.equalsIgnoreCase(LynxError.LEVEL_WARN) == false) goto L11;
        return 1;
    L11:
        return 2;
    }

    public static String getKeyMessage(LynxError r5) {
        if (r5 != null) goto L4;
        return NameKeys.UnloadStrategy_No_Strategy;
    L4:
        if (r5.isValid() == false) goto L21;
        StringBuilder r0 = new StringBuilder("code: ");
        r0.append(r5.getSubCode());
        r0.append("\nmessage: ");
        r0.append(r5.getSummaryMessage());
        r0.append("\n");
        if (TextUtils.isEmpty(r5.getRootCause()) == true) goto L9;
        r0.append("root_cause: ");
        r0.append(r5.getRootCause());
        r0.append("\n");
    L9:
        Iterator<Map.Entry<String, String>> r2 = r5.getContextInfo().entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r2.next();
        r0.append(r3.getKey());
        r0.append(": ");
        r0.append(r3.getValue());
        r0.append("\n");
        goto L11
    L14:
        if (TextUtils.isEmpty(r5.getFixSuggestion()) == true) goto L17;
        r0.append("fix_suggestion: ");
        r0.append(r5.getFixSuggestion());
    L17:
        return r0.toString();
    L21:
        return NameKeys.UnloadStrategy_No_Strategy;
    }
}
