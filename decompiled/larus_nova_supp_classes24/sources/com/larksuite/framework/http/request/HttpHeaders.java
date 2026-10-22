package com.larksuite.framework.http.request;

import android.text.TextUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class HttpHeaders implements Serializable {
    public static final String FORMAT_HTTP_DATA = "EEE, dd MMM y HH:mm:ss 'GMT'";
    public static final TimeZone GMT_TIME_ZONE = null;
    public static final String HEAD_KEY_ACCEPT = "Accept";
    public static final String HEAD_KEY_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEAD_KEY_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEAD_KEY_CACHE_CONTROL = "Cache-Control";
    public static final String HEAD_KEY_CONNECTION = "Connection";
    public static final String HEAD_KEY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEAD_KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEAD_KEY_CONTENT_LENGTH = "Content-Length";
    public static final String HEAD_KEY_CONTENT_RANGE = "Content-Range";
    public static final String HEAD_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEAD_KEY_COOKIE = "Cookie";
    public static final String HEAD_KEY_COOKIE2 = "Cookie2";
    public static final String HEAD_KEY_DATE = "Date";
    public static final String HEAD_KEY_EXPIRES = "Expires";
    public static final String HEAD_KEY_E_TAG = "ETag";
    public static final String HEAD_KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HEAD_KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String HEAD_KEY_LAST_MODIFIED = "Last-Modified";
    public static final String HEAD_KEY_LOCATION = "Location";
    public static final String HEAD_KEY_PRAGMA = "Pragma";
    public static final String HEAD_KEY_RANGE = "Range";
    public static final String HEAD_KEY_RESPONSE_CODE = "ResponseCode";
    public static final String HEAD_KEY_RESPONSE_MESSAGE = "ResponseMessage";
    public static final String HEAD_KEY_SET_COOKIE = "Set-Cookie";
    public static final String HEAD_KEY_SET_COOKIE2 = "Set-Cookie2";
    public static final String HEAD_KEY_USER_AGENT = "User-Agent";
    public static final String HEAD_VALUE_ACCEPT_ENCODING = "gzip, deflate";
    public static final String HEAD_VALUE_CONNECTION_CLOSE = "close";
    public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = "keep-alive";
    public static String a = null;
    public static String b = null;
    private static final long serialVersionUID = 8458647755751403873L;
    public LinkedHashMap<String, String> headersMap;

    public static String getCacheControl(String r0, String r1) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        if (r1 == null) goto L6;
        return r1;
    L6:
        return null;
    }

    static {
        GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");
    }

    public static String getAcceptLanguage() {
        if (TextUtils.isEmpty(a) == false) goto L10;
        Locale r0 = Locale.getDefault();
        String r1 = r0.getLanguage();
        String r2 = r0.getCountry();
        StringBuilder r3 = new StringBuilder(r1);
        if (TextUtils.isEmpty(r2) == true) goto L7;
        r3.append('-');
        r3.append(r2);
        r3.append(',');
        r3.append(r1);
        r3.append(";q=0.8");
    L7:
        String r4 = r3.toString();
        a = r4;
        return r4;
    L10:
        return a;
    }

    public static String getUserAgent() {
        if (TextUtils.isEmpty(b) == false) goto L6;
        b = "Mozilla/5.0 (Linux; U; Android 5.0.2; zh-cn; Redmi Note 3 Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36";
    L6:
        return b;
    }

    public void clear() {
        this.headersMap.clear();
    }

    public Set<String> getNames() {
        return this.headersMap.keySet();
    }

    public boolean isEmpty() {
        LinkedHashMap<String, String> r0 = this.headersMap;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        return false;
    }

    public final String toJSONString() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r1 = this.headersMap.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, String> r2 = r1.next();     // Catch: JSONException -> L8
        r0.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L8
    L11:
        return r0.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String toString() {
        return "HttpHeaders{headersMap=" + this.headersMap + '}';
    }

    public HttpHeaders() {
        this.headersMap = new LinkedHashMap();
    }

    public static String formatMillisToGMT(long r2) {
        Date r0 = new Date(r2);
        SimpleDateFormat r3 = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        r3.setTimeZone(GMT_TIME_ZONE);
        return r3.format(r0);
    }

    public static long getDate(String r2) {
        return parseGMTToMillis(r2);
    L4:
        return 0;
    }

    public static long getExpiration(String r2) {
        return parseGMTToMillis(r2);
    L4:
        return -1;
    }

    public static long getLastModified(String r2) {
        return parseGMTToMillis(r2);
    L4:
        return 0;
    }

    public static long parseGMTToMillis(String r3) throws ParseException {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return 0;
    L6:
        SimpleDateFormat r0 = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        r0.setTimeZone(GMT_TIME_ZONE);
        return r0.parse(r3).getTime();
    }

    public static void setAcceptLanguage(String r0) {
        a = r0;
    }

    public static void setUserAgent(String r0) {
        b = r0;
    }

    public String get(String r2) {
        return this.headersMap.get(r2);
    }

    public void put(HttpHeaders r2) {
        if (r2 == null) goto L9;
        LinkedHashMap<String, String> r0 = r2.headersMap;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isEmpty() == true) goto L11;
        this.headersMap.putAll(r2.headersMap);
        return;
    L11:
        return;
    }

    public String remove(String r2) {
        return this.headersMap.remove(r2);
    }

    public static String getDate(long r0) {
        return formatMillisToGMT(r0);
    }

    public HttpHeaders(String r2, String r3) {
        this.headersMap = new LinkedHashMap();
        put(r2, r3);
    }

    public void put(String r2, String r3) {
        if (r2 == null) goto L6;
        if (r3 == null) goto L7;
        this.headersMap.put(r2, r3);
        return;
    L7:
        return;
    }
}
