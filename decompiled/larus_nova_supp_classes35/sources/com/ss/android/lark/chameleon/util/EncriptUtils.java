package com.ss.android.lark.chameleon.util;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EncriptUtils {
    public static final String DEFAULT_PATTERN_STR = "((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}";
    private static final char[] HEX_CHARS = null;
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA1 = "SHA-1";
    private static final String TAG = "EncriptUtils";
    public static final String URL_PARAM = "url";
    private static SecretKey sSecretKey = null;
    public static Pattern tokenPattern = null;
    public static final String tokenTips = "token is sensitive **** ";

    public EncriptUtils() {
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        tokenPattern = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static boolean check(String r3) {
        if (r3 != null) goto L10;
        return false;
    L10:
        return tokenPattern.matcher(r3).find();
    L7:
        e = move-exception;
        Log.e(TAG, e.getMessage(), e);
        return false;
    }

    public static String getHostOrParam(String r3) {
        Uri r0 = UriProtector.parse(r3);
        String r1 = UriProtector.getQueryParameter(r0, "url");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r0 = UriProtector.parse(r1);
    L6:
        if (r0.getHost() != null) goto L8;
        return r3;
    L8:
        return r0.getHost();
    }

    public static String getRandomString(int r5) {
        Random r0 = new Random();
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        r1.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(r0.nextInt(62)));
        r2 = r2 + 1;
        goto L3
    L6:
        return r1.toString();
    }

    public static String handleEncription(Object r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        String r4 = r3.toString();
        if (BuildConfig.FLAVOR.equals(r4) == false) goto L16;
        return r4;
    L16:
        Matcher r0 = tokenPattern.matcher(r4);     // Catch: Exception -> L13
    L10:
        if (r0.find() == false) goto L15;
        String r1 = r0.group();     // Catch: Exception -> L13
        r4 = r4.replaceAll(r1, handleEncription(r1));     // Catch: Exception -> L13
    L15:
        return r4;
    L13:
        e = move-exception;
        Log.e(TAG, "handleEncription exception:" + e);
        goto L15
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
        Log.e(TAG, th.getMessage(), th);
        return BuildConfig.FLAVOR;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L6;
    L14:
        return BuildConfig.FLAVOR;
    L6:
        if (r8.length() < 6) goto L14;
        int r4 = 0;
        String r5 = r8.substring(0, 3);     // Catch: Throwable -> L15
        String r2 = r8.substring(r8.length() - 3, r8.length());     // Catch: Throwable -> L15
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
        Log.e(TAG, e.getMessage(), e);
        return r3;
    }

    public static String replaceUrl(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        Uri r3 = UriProtector.parse(r2);
        return r3.getHost() + replaceToken(r3.getPath());
    L6:
        return BuildConfig.FLAVOR;
    }

    private static String toHexString(byte[] r2) {
        if (r2 == null) goto L6;
        return toHexString(r2, 0, r2.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    public static String transformMD5(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return null;
    L14:
        MessageDigest r0 = MessageDigest.getInstance(KEY_MD5);     // Catch: Exception -> L11
        r0.update(r5.getBytes());     // Catch: Exception -> L11
        byte[] r6 = r0.digest();     // Catch: Exception -> L11
        String r1 = BuildConfig.FLAVOR;
        int r2 = 0;
    L7:
        if (r2 >= r6.length) goto L10;
        r1 = r1 + Integer.toHexString((r6[r2] & 255) | (-256)).substring(6);     // Catch: Exception -> L11
        r2 = r2 + 1;
        goto L7
    L10:
        return r1;
    L11:
        e = move-exception;
        Log.e(TAG, "transformMD5 ", e);
        return null;
    }

    public static String transformSHA1(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        byte[] r6 = r5.getBytes();
        MessageDigest r0 = MessageDigest.getInstance(KEY_SHA1);     // Catch: Exception -> L13
        r0.update(r6);     // Catch: Exception -> L13
        byte[] r7 = r0.digest();     // Catch: Exception -> L13
        String r1 = BuildConfig.FLAVOR;
        int r2 = 0;
    L9:
        if (r2 >= r7.length) goto L12;
        r1 = r1 + Integer.toHexString((r7[r2] & 255) | (-256)).substring(6);     // Catch: Exception -> L13
        r2 = r2 + 1;
        goto L9
    L12:
        return r1;
    L13:
        e = move-exception;
        Log.e(TAG, "transformSHA1 ", e);
        return null;
    }

    public static String handleEncription(String r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        if (BuildConfig.FLAVOR.equals(r2) == false) goto L9;
        return r2;
    L9:
        return transformSHA1("08a441" + transformMD5(r2.concat("42b91e")));
    }

    private static String toHexString(byte[] r9, int r10, int r11) {
        if (r9 == null) goto L14;
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & 255;
        int r6 = r4 + 1;
        char[] r7 = HEX_CHARS;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }
}
