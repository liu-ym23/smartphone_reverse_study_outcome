package com.ss.android.lark.chat.utils;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t {
    public static final String a = null;

    static {
        a = UIHelper.getString(2131890743);
        UIHelper.getString(2131890744);
    }

    public static long a() {
        SettingManager r0 = SettingManager.getInstance();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Integer.valueOf(r0.getInt(FileUploadLimitConfig.class)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        Object r3 = null;
    L11:
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L19;
        if (r4.intValue() <= 0) goto L19;
        Log.i("FileSendUtils", "getMaxSendFileSize limit:" + r4);
        return (((long) r4.intValue()) * 1024) * 1024;
    L19:
        if (Result.isFailure-impl(r2) == false) goto L21;
        Log.w("FileSendUtils", "getMaxSendFileSize failed", Result.exceptionOrNull-impl(r2));
        return 107374182400L;
    L21:
        Log.w("FileSendUtils", "getMaxSendFileSize invalid limit:" + r4);
        return 107374182400L;
    L10:
        r3 = r2;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
