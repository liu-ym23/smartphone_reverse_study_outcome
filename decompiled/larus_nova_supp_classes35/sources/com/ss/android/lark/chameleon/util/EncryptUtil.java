package com.ss.android.lark.chameleon.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EncryptUtil {
    public static final String DEFAULT_PATTERN_STR = "((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}";
    private static final String TAG = "EncryptUtil";
    public static final String TOKEN_TIPS = "token is sensitive **** ";
    public static Pattern tokenPattern;

    public EncryptUtil() {
    }

    static {
        tokenPattern = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static void injectTokenPattern(String r2) {
        Log.i(TAG, "inject token pattern");
        tokenPattern = PatternProtector.compile(r2);
    }

    public static String maskAllToken(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return r7;
    L16:
        long r1 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L13
        StringBuffer r3 = new StringBuffer();     // Catch: Throwable -> L13
        Matcher r4 = tokenPattern.matcher(r7);     // Catch: Throwable -> L13
        r4.reset();     // Catch: Throwable -> L13
    L7:
        if (r4.find() == false) goto L9;
        r4.appendReplacement(r3, maskObjToken(r4.group()));     // Catch: Throwable -> L13
        goto L7
    L9:
        r4.appendTail(r3);     // Catch: Throwable -> L13
        String r5 = r3.toString();     // Catch: Throwable -> L13
        if ((SystemClock.elapsedRealtimeNanos() - r1) <= 8000) goto L12;
        Log.e(TAG, "maskAllToken, takes too much time, result msg: " + r5);     // Catch: Throwable -> L13
    L12:
        return r5;
    L13:
        th = move-exception;
        Log.e(TAG, "maskAllToken", th);
        return replaceToken(r7);
    }

    public static String maskObjToken(String r8) {
    L15:
        th = move-exception;
        Log.e(TAG, BuildConfig.FLAVOR, th);
        return BuildConfig.FLAVOR;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L6;
    L14:
        return BuildConfig.FLAVOR;
    L6:
        if (r8.length() < 6) goto L14;
        int r4 = 0;
        String r5 = r8.substring(0, 3);     // Catch: Throwable -> L15
        String r2 = r8.substring(r8.length() - 3);     // Catch: Throwable -> L15
        StringBuilder r6 = new StringBuilder("*");     // Catch: Throwable -> L15
    L10:
        if (r4 >= (r8.length() - 6)) goto L12;
        r6.append("*");     // Catch: Throwable -> L15
        r4 = r4 + 1;     // Catch: Throwable -> L15
        goto L10
    L12:
        return r5 + r6.toString() + r2;
    }

    public static String replaceToken(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return r3;
    L10:
        return tokenPattern.matcher(r3).replaceAll("token is sensitive **** ");
    L7:
        e = move-exception;
        Log.e(TAG, BuildConfig.FLAVOR, e);
        return r3;
    }
}
