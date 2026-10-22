package com.bytedance.ai.bridge.method.calendar.remote.exception;

import com.bytedance.ai.utils.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p3.i;
import q3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u001dB)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/io/Serializable;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "ex", "", "httpResponse", "Lokhttp3/Response;", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lokhttp3/Response;)V", "request", "getRequest", "()Ljava/lang/String;", "setRequest", "(Ljava/lang/String;)V", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "requestBody", "getRequestBody", "response", "getResponse", "responseBody", "getResponseBody", "", "Lcom/bytedance/ai/bridge/method/calendar/remote/property/Error;", "errors", "getErrors", "()Ljava/util/List;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CalDavException extends Exception implements Serializable {
    public static final a Companion = null;
    public static final int MAX_EXCERPT_SIZE = 10240;
    private List<i> errors;
    private String request;
    private String requestBody;
    private final String response;
    private String responseBody;

    public static final class a {
        public a() {
        }

        public static boolean a(MediaType r10) {
            Intrinsics.checkNotNullParameter(r10, "type");
            if (Intrinsics.areEqual(r10.type(), "text") == false) goto L5;
        L10:
            return true;
        L5:
            if (Intrinsics.areEqual(r10.type(), "application") == true) goto L7;
        L9:
            return false;
        L7:
            if (ArraysKt.contains(new String[]{"html", "xml"}, r10.subtype()) == false) goto L9;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    public CalDavException(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this(r10, null, null, 6, null);
    }

    public CalDavException(String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this(r10, r11, null, 4, null);
    }

    public final List<i> getErrors() {
        return this.errors;
    }

    public final String getRequest() {
        return this.request;
    }

    public final String getRequestBody() {
        return this.requestBody;
    }

    public final String getResponse() {
        return this.response;
    }

    public final String getResponseBody() {
        return this.responseBody;
    }

    public final void setRequest(String r1) {
        this.request = r1;
    }

    public CalDavException(String r10, Throwable r11, Response r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        super(r10, r11);
        this.errors = CollectionsKt.emptyList();
        if (r12 == null) goto L76;
        this.response = r12.toString();
        this.request = r12.request().toString();     // Catch: Exception -> L17
        RequestBody r13 = r12.request().body();     // Catch: Exception -> L17
        if (r13 == null) goto L84;
        MediaType r1 = r13.contentType();     // Catch: Exception -> L17
        if (r1 == null) goto L84;
        Companion.getClass();     // Catch: Exception -> L17
        if (a.a(r1) == false) goto L84;
        Buffer r14 = new Buffer();     // Catch: Exception -> L17
        r13.writeTo(r14);     // Catch: Exception -> L17
        Charset r15 = r1.charset(Charsets.UTF_8);     // Catch: Exception -> L17
        if (r15 == null) goto L84;
        String r16 = r15.name();     // Catch: Exception -> L17
        if (r16 == null) goto L84;
        ByteArrayOutputStream r17 = new ByteArrayOutputStream();     // Catch: Exception -> L17
        r14.writeTo(r17);     // Catch: Exception -> L17
        this.requestBody = r17.toString(r16);     // Catch: Exception -> L17
    L84:
        ResponseBody r18 = r12.body();     // Catch: Throwable -> L29 IOException -> L31
        if (r18 == null) goto L22;
        BufferedSource r19 = r18.source();     // Catch: Throwable -> L29 IOException -> L31
    L23:
        if (r19 == null) goto L65;
        ResponseBody r20 = r12.peekBody(10240);     // Catch: Throwable -> L29 IOException -> L31
        MediaType r21 = r20.contentType();     // Catch: Throwable -> L29 IOException -> L31
        if (r21 == null) goto L33;
        Companion.getClass();     // Catch: Throwable -> L29 IOException -> L31
        if (a.a(r21) == false) goto L33;
        this.responseBody = r20.string();     // Catch: Throwable -> L29 IOException -> L31
    L33:
        ResponseBody r22 = r12.body();     // Catch: Throwable -> L29 IOException -> L31
        if (r22 == null) goto L65;
        MediaType r23 = r22.contentType();     // Catch: Throwable -> L51
        if (r23 != null) goto L38;
    L59:
        CloseableKt.closeFinally(r22, null);     // Catch: Throwable -> L29 IOException -> L31
        goto L65
    L38:
        if (ArraysKt.contains(new String[]{"application", "text"}, r23.type()) == true) goto L40;
    L58:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L51
        goto L59
    L40:
        if (Intrinsics.areEqual(r23.subtype(), "xml") == false) goto L58;
        XmlPullParserFactory r25 = e.a;     // Catch: Throwable -> L51 XmlPullParserException -> L53
        XmlPullParser r26 = e.a.newPullParser();     // Catch: Throwable -> L51 XmlPullParserException -> L53
        r26.setInput(r22.charStream());     // Catch: Throwable -> L51 XmlPullParserException -> L53
        int r27 = r26.getEventType();     // Catch: Throwable -> L51 XmlPullParserException -> L53
    L43:
        if (r27 == 1) goto L58;
        if (r27 != 2) goto L55;
        if (r26.getDepth() != 1) goto L55;
        XmlPullParserFactory r28 = e.a;     // Catch: Throwable -> L51 XmlPullParserException -> L53
        if (Intrinsics.areEqual(e.c(r26), i.a) == false) goto L55;
        this.errors = i.a.a(r26);     // Catch: Throwable -> L51 XmlPullParserException -> L53
        goto L55
    L55:
        r27 = r26.next();     // Catch: Throwable -> L51 XmlPullParserException -> L53
    L53:
        e = move-exception;
        g.a.w("CalDavException", "Couldn't parse XML response", e);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        CloseableKt.closeFinally(r22, th);     // Catch: Throwable -> L29 IOException -> L31
        throw th;     // Catch: Throwable -> L29 IOException -> L31
    L65:
        ResponseBody r29 = r12.body();
        if (r29 == null) goto L92;
    L71:
        r29.close();
        return;
    L92:
        return;
    L22:
        r19 = null;
    L29:
        th = move-exception;
        ResponseBody r30 = r12.body();
        if (r30 == null) goto L75;
        r30.close();
    L75:
        throw th;
    L31:
        e = move-exception;
        g.a.w("CalDavException", "Couldn't parse HTTP response", e);     // Catch: Throwable -> L29
        this.responseBody = "Couldn't read HTTP response: " + e.getMessage();     // Catch: Throwable -> L29
        r29 = r12.body();
        if (r29 != null) goto L71;
        return;
    L17:
        e = move-exception;
        g.a.w("CalDavException", "Couldn't read HTTP request", e);
        this.requestBody = "Couldn't read HTTP request: " + e.getMessage();
        goto L84
    L76:
        this.response = null;
    }

    public /* synthetic */ CalDavException(String r10, Throwable r11, Response r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }
}
