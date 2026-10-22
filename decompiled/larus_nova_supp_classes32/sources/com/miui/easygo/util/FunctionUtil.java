package com.miui.easygo.util;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.miui.easygo.sdk.module.EasyGoServer;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class FunctionUtil extends DatabaseUtil {
    private static final String TAG = "FunctionUtil";

    public FunctionUtil() {
    }

    public static boolean isAidlSupport(EasyGoServer r5) {
        String r6 = r5.getServiceVersion();
        if (BaseUtil.isNullOrEmpty(new String[]{r6}) == false) goto L18;
        return false;
    L18:
        String[] r7 = r6.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L12 NumberFormatException -> L15
        String[] r0 = "1.0".split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L12 NumberFormatException -> L15
        if (r7.length == 2) goto L8;
        return false;
    L8:
        if (CastIntegerProtector.parseUnsignedInt(r7[0]) <= CastIntegerProtector.parseUnsignedInt(r0[0])) goto L11;
        return false;
    L11:
        return true;
    L15:
        e = move-exception;
        e.getMessage();
        return false;
    L12:
        e = move-exception;
        e.getMessage();
        return false;
    }

    public static boolean isLibSupprt(String r5) {
        if (BaseUtil.isNullOrEmpty(new String[]{r5}) == false) goto L24;
        return false;
    L24:
        String[] r6 = r5.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        String[] r0 = EasyGoConstant.LIB_SUPPORT_AAR_VERSION.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        if (r6.length != 3) goto L8;
        int r2 = CastIntegerProtector.parseUnsignedInt(r0[0]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        int r1 = CastIntegerProtector.parseUnsignedInt(r0[1]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        int r4 = CastIntegerProtector.parseUnsignedInt(r6[0]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        int r7 = CastIntegerProtector.parseUnsignedInt(r6[1]);     // Catch: PatternSyntaxException -> L18 NumberFormatException -> L21
        if (r4 > r2) goto L12;
        if (r4 != r2) goto L17;
        if (r7 <= r1) goto L17;
        return false;
    L17:
        return true;
    L12:
        return false;
    L8:
        return false;
    L21:
        e = move-exception;
        e.getMessage();
        return false;
    L18:
        e = move-exception;
        e.getMessage();
        return false;
    }

    public static EasyGoServer getFunctionInfo(Context r0, String r1) {
        return DatabaseUtil.queryServerInfo(r0, r1);
    }
}
