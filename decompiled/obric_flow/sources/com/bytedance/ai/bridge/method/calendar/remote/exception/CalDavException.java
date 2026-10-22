package com.bytedance.ai.bridge.method.calendar.remote.exception;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.utils.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mh.e;
import nu.j;
import nu.l;
import okhttp3.Request;
import okhttp3.h0;
import okhttp3.q0;
import okhttp3.s0;
import okhttp3.u0;
import okhttp3.w0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t0.d;
import w1.g;
import x1.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/exception/CalDavException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ljava/io/Serializable;", "mh/e", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class CalDavException extends Exception implements Serializable {
    public /* synthetic */ CalDavException(String r5, Exception r10, s0 r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = null;
    L8:
        this(r5, r10, r11);
    }

    public CalDavException(String r5, Throwable r10, s0 r11) {
        Intrinsics.checkNotNullParameter(r5, "message");
        super(r5, r10);
        CollectionsKt.emptyList();
        if (r11 == null) goto L96;
        Request r12 = r11.f20746b;
        r11.toString();
        r12.toString();     // Catch: Exception -> L17
        q0 r13 = r12.body();     // Catch: Exception -> L17
        if (r13 == null) goto L22;
        h0 r14 = r13.contentType();     // Catch: Exception -> L17
        if (r14 == null) goto L22;
        if (e.l(r14) == false) goto L22;
        j r15 = new j();     // Catch: Exception -> L17
        r13.writeTo(r15);     // Catch: Exception -> L17
        Charset r16 = r14.a(Charsets.UTF_8);     // Catch: Exception -> L17
        if (r16 == null) goto L22;
        String r17 = r16.name();     // Catch: Exception -> L17
        if (r17 == null) goto L22;
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();     // Catch: Exception -> L17
        j.Z(r15, r18);     // Catch: Exception -> L17
        r18.toString(r17);     // Catch: Exception -> L17
    L22:
        w0 r19 = r11.f20748h;
        if (r19 != null) goto L88;
        l r20 = null;
    L30:
        if (r20 == null) goto L78;
        u0 r21 = r11.g();     // Catch: Throwable -> L25 IOException -> L27
        h0 r22 = r21.f20759b;     // Catch: Throwable -> L25 IOException -> L27
        if (r22 != null) goto L34;
    L36:
        if (r19 == null) goto L78;
        h0 r23 = r19.contentType();     // Catch: Throwable -> L53
        if (r23 != null) goto L40;
    L63:
        CloseableKt.closeFinally(r19, null);     // Catch: Throwable -> L25 IOException -> L27
        goto L78
    L40:
        if (ArraysKt.contains(new String[]{"application", MessageIndication.CONTENT_TYPE_TEXT}, r23.f20658b) == true) goto L42;
    L62:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L53
        goto L63
    L42:
        if (Intrinsics.areEqual(r23.f20659c, "xml") == false) goto L62;
        XmlPullParser r25 = b.f22944a.newPullParser();     // Catch: Throwable -> L53 XmlPullParserException -> L55
        r25.setInput(r19.charStream());     // Catch: Throwable -> L53 XmlPullParserException -> L55
        int r26 = r25.getEventType();     // Catch: Throwable -> L53 XmlPullParserException -> L55
    L45:
        if (r26 == 1) goto L62;
        if (r26 != 2) goto L57;
        if (r25.getDepth() != 1) goto L57;
        if (Intrinsics.areEqual(b.a(r25), g.f22685a) == false) goto L57;
        xq.b.a(r25);     // Catch: Throwable -> L53 XmlPullParserException -> L55
        goto L57
    L57:
        r26 = r25.next();     // Catch: Throwable -> L53 XmlPullParserException -> L55
    L55:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CalDavException", "tag");     // Catch: Throwable -> L53
        d r27 = c.f2846a;     // Catch: Throwable -> L53
        if (r27 == null) goto L62;
        r27.w("CalDavException", "Couldn't parse XML response", e);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Throwable -> L25 IOException -> L27
        throw th;     // Catch: Throwable -> L25 IOException -> L27
    L34:
        if (e.l(r22) == false) goto L36;
        r21.string();     // Catch: Throwable -> L25 IOException -> L27
    L78:
        if (r19 == null) goto L98;
    L79:
        r19.close();
        return;
    L98:
        return;
    L88:
        r20 = r19.source();     // Catch: Throwable -> L25 IOException -> L27
    L27:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CalDavException", "tag");     // Catch: Throwable -> L25
        d r28 = c.f2846a;     // Catch: Throwable -> L25
        if (r28 == null) goto L72;
        r28.w("CalDavException", "Couldn't parse HTTP response", e);     // Catch: Throwable -> L25
    L72:
        e.getMessage();     // Catch: Throwable -> L25
        if (r19 != null) goto L79;
        return;
    L25:
        th = move-exception;
        if (r19 == null) goto L77;
        r19.close();
    L77:
        throw th;
    L17:
        e = move-exception;
        Intrinsics.checkNotNullParameter("CalDavException", "tag");
        d r29 = c.f2846a;
        if (r29 == null) goto L21;
        r29.w("CalDavException", "Couldn't read HTTP request", e);
    L21:
        e.getMessage();
        goto L22
    }
}
