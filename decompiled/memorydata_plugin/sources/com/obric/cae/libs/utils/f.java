package com.obric.cae.libs.utils;

import android.text.TextUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        String[] r1 = r4.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (r1.length == 6) goto L10;
        return r4;
    L10:
        return r1[0] + ParameterizedMessage.ERROR_MSG_SEPARATOR + r1[1] + ParameterizedMessage.ERROR_MSG_SEPARATOR + r1[2] + ":**:**:" + r1[5];
    }
}
