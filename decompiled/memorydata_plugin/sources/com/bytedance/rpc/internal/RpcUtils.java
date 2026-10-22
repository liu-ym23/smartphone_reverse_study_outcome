package com.bytedance.rpc.internal;

import com.bytedance.apm6.util.constant.ReportConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RpcUtils {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final byte[] EMPTY_BYTE_ARR = null;
    public static final Object[] EMPTY_OBJ_ARR = null;
    public static final String[] EMPTY_STR_ARR = null;

    static {
        EMPTY_STR_ARR = new String[0];
        EMPTY_OBJ_ARR = new Object[0];
        EMPTY_BYTE_ARR = new byte[0];
    }

    public RpcUtils() {
    }

    public static String buildUrl(String r6, String r7) {
        if (isVisible(r7) == false) goto L22;
        boolean r1 = r6.endsWith("/");
        boolean r2 = r7.startsWith("/");
        boolean r3 = false;
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
        boolean r5 = false;
    L10:
        if (r1 == false) goto L13;
        if (r2 == false) goto L13;
        r3 = true;
    L13:
        if (r5 == false) goto L18;
        if (r3 == true) goto L18;
        StringBuilder r8 = new StringBuilder().append(r6);
    L17:
        return r8.append(r7).toString();
    L18:
        if (r3 == false) goto L20;
        r8 = new StringBuilder().append(r6);
        r7 = r7.substring(1);
        goto L17
    L20:
        if (r5 == true) goto L22;
        r8 = new StringBuilder().append(r6).append("/");
    L9:
        r5 = true;
    L22:
        return r6;
    }

    public static void closeSilently(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public static String composeUrl(String r3, String r4) {
        if (isInvisible(r3) == false) goto L5;
    L21:
        return r4;
    L5:
        if (r4.indexOf("://") > 0) goto L21;
        if (r4 == null) goto L20;
        if (r4.length() <= 0) goto L20;
        int r1 = r4.indexOf(46);
        int r2 = r4.indexOf(47);
        if (r1 <= 0) goto L20;
        if (r1 >= r2) goto L20;
        int r0 = r3.indexOf("://");
        StringBuilder r5 = new StringBuilder();
        if (r0 <= 0) goto L16;
        String r6 = r3.substring(0, r0 + 3);
    L18:
        return r5.append(r6).append(r4).toString();
    L16:
        r6 = ReportConsts.HTTPS;
    L20:
        return buildUrl(r3, r4);
    }

    public static String decode(String r2, String... r3) {
        if (isVisible(r2) == false) goto L10;
        if (r3 != null) goto L13;
    L9:
        r2 = URLDecoder.decode(r2);     // Catch: Exception -> L11
    L12:
        goto L10
    L13:
        if (r3.length < 1) goto L9;
        r2 = URLDecoder.decode(r2, r3[0]);     // Catch: Exception -> L11
    L10:
        return r2;
    }

    public static String[] getBaseUrlAndPath(String r6) {
        int r0 = -1;
        if (r6 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 <= 0) goto L18;
        int r2 = r6.indexOf(47, r1 + 3);
        if (r2 <= 2) goto L12;
        r0 = r6.indexOf(47, r2);
    L12:
        if (r0 <= 0) goto L18;
        if ((r0 + 1) >= r6.length()) goto L18;
        return new String[]{r6.substring(0, r0), r6.substring(r0)};
    L18:
        return new String[]{r6, ""};
    L5:
        r1 = r6.indexOf(58);
        goto L7
    }

    public static Map<String, String> getUrlParams(String r9, String r10) {
        HashMap r0 = new HashMap(8);
        if (r9 != null) goto L5;
    L24:
        return r0;
    L5:
        if (r9.length() <= 2) goto L24;
        int r1 = r9.indexOf("?");
        if (r1 == (-1)) goto L9;
        r9 = r9.substring(r1 + 1);
    L9:
        String[] r11 = r9.split("&");
        if (r11 == null) goto L24;
        if (r11.length <= 0) goto L24;
        if (isInvisible(r10) == false) goto L16;
        r10 = CHARSET_UTF8;
    L16:
        int r2 = r11.length;
        int r5 = 0;
    L17:
        if (r5 >= r2) goto L24;
        String[] r6 = r11[r5].split("=", 2);
        if (r6 == null) goto L23;
        if (r6.length != 2) goto L23;
        r0.put(decode(r6[0], new String[]{r10}), decode(r6[1], new String[]{r10}));
    L23:
        r5 = r5 + 1;
        goto L17
    }

    public static byte[] gzip(byte[] r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (r2.length <= 0) goto L14;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8092);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L8
        r1.close();
        return r0.toByteArray();
    L8:
        th = move-exception;
        r1.close();
        throw th;
    L14:
        return r2;
    }

    public static final boolean isInvisible(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r3 != null) goto L5;
        int r1 = 0;
    L6:
        if (r1 != 0) goto L8;
        r0 = true;
    L8:
        if (r0 == true) goto L13;
    L9:
        r1 = r1 - 1;
        r0 = Character.isWhitespace(r3.charAt(r1));
        if (r0 == false) goto L13;
        if (r1 > 0) goto L9;
    L13:
        return r0;
    L5:
        r1 = r3.length();
        goto L6
    }

    public static boolean isInvisibleOrNull(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (isInvisible(r3) == false) goto L5;
    L8:
        return true;
    L5:
        if ("null".equalsIgnoreCase(r3.toString()) == true) goto L8;
        return false;
    }

    public static boolean isVisible(CharSequence r2) {
        return !isInvisible((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static boolean isVisibleUnNull(CharSequence r2) {
        return !isInvisibleOrNull((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static String replacePathParamsWithQuery(String r12, Map<String, String> r13, boolean r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        String r0 = "";
        if (r12 != null) goto L5;
    L67:
        if (r12 == null) goto L69;
        return r12;
    L69:
        return "";
    L5:
        if (r12.length() <= 3) goto L67;
        if (r15 == null) goto L67;
        if (r15.size() <= 0) goto L67;
        int r3 = 0;
        int r4 = r12.indexOf(123, 0);
        if (r4 < 0) goto L12;
        int r7 = r12.indexOf(125, r4 + 1);
    L13:
        if (r7 <= 0) goto L32;
        StringBuilder r8 = new StringBuilder();
    L15:
        String r9 = r12.substring(r4 + 1, r7);
        if (r14 == false) goto L18;
        Object r10 = r15.remove(r9);
    L19:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        r8.append(r12, r3, r4);
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        r8.append(r11);
        r3 = r7 + 1;
        r4 = r12.indexOf(123, r3);
        if (r4 < 0) goto L25;
        r7 = r12.indexOf(125, r4 + 1);
    L26:
        if (r7 > 0) goto L15;
        if (r3 >= r12.length()) goto L31;
        r8.append(r12.substring(r3));
    L31:
        return r8.toString();
    L25:
        r7 = -1;
        goto L26
    L18:
        r10 = r15.get(r9);
        goto L19
    L32:
        int r2 = r12.indexOf(58, r12.indexOf("://") + 1);
        if (r2 <= 0) goto L35;
        int r16 = r12.indexOf(47, r2 + 1);
    L36:
        if (r2 <= 0) goto L67;
        StringBuilder r17 = new StringBuilder();
        if (r16 <= 0) goto L51;
    L39:
        int r18 = r16;
        int r19 = r3;
        r3 = r18;
        String r20 = r12.substring(r2 + 1, r3);
        if (r14 == false) goto L42;
        Object r21 = r15.remove(r20);
    L43:
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin");
        r17.append(r12, r19, r2);
        if (r22 != null) goto L46;
        r22 = "";
    L46:
        r17.append(r22);
        r2 = r12.indexOf(58, r3);
        if (r2 < 0) goto L49;
        r16 = r12.indexOf(47, r2 + 1);
    L50:
        if (r16 > 0) goto L39;
    L49:
        r16 = -1;
        goto L50
    L42:
        r21 = r15.get(r20);
    L51:
        if (r2 < 0) goto L63;
        if (r16 >= 0) goto L63;
        String r5 = r12.substring(r2 + 1);
        if (r14 == false) goto L56;
        Object r110 = r15.remove(r5);
    L57:
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin");
        r17.append(r12, r3, r2);
        if (r111 == null) goto L61;
        r0 = r111;
    L61:
        r17.append(r0);
    L66:
        return r17.toString();
    L56:
        r110 = r15.get(r5);
    L63:
        if (r3 >= r12.length()) goto L66;
        r17.append(r12.substring(r3));
        goto L66
    L35:
        r16 = -1;
        goto L36
    L12:
        r7 = -1;
        goto L13
    }

    public static byte[] toBytes(InputStream r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[4096];
    L15:
        int r2 = r4.read(r1);     // Catch: Throwable -> L12
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L12
        goto L15
    L9:
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L12
        closeSilently(r0);
        closeSilently(r4);
        return r3;
    L12:
        th = move-exception;
        closeSilently(r0);
        closeSilently(r4);
        throw th;
    }

    public static String toString(InputStream r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[4096];
    L15:
        int r2 = r4.read(r1);     // Catch: Throwable -> L12
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L12
        goto L15
    L9:
        String r6 = r0.toString(r5);     // Catch: Throwable -> L12
        closeSilently(r0);
        closeSilently(r4);
        return r6;
    L12:
        th = move-exception;
        closeSilently(r0);
        closeSilently(r4);
        throw th;
    }
}
