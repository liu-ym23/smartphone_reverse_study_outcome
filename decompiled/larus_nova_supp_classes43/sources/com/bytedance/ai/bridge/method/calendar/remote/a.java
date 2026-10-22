package com.bytedance.ai.bridge.method.calendar.remote;

import android.net.Uri;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavConflictException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavForbiddenException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavHttpException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavNotFoundException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavPreconditionFailedException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavServiceUnavailableException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavUnauthorizedException;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import n3.j;
import o3.l;
import o3.n;
import o3.o;
import o3.p;
import o3.q;
import o3.r;
import o3.s;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import p3.i;
import p3.t;
import p3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final SimpleDateFormat c = null;
    public static final MediaType d = null;
    public final OkHttpClient a;
    public HttpUrl b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.calendar.remote.a$a, reason: collision with other inner class name */
    public static final class C0022a {
    }

    static {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = r0;
        d = MediaType.parse("application/xml; charset=utf-8");
    }

    public final Response b(Function0<Response> r12) {
        int r1 = 1;
        Response r10 = null;
    L4:
        if (r1 >= 6) goto L32;
        r10 = (Response) r12.invoke();
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        Response r11 = null;
    L10:
        if (r11.isRedirect() == false) goto L32;
        String r13 = r10.header("Location");     // Catch: Throwable -> L27
        if (r13 == null) goto L14;
        HttpUrl r14 = this.b.resolve(r13);     // Catch: Throwable -> L27
    L15:
        if (r14 == null) goto L26;
        g.a.e("CalDavClient", "Redirected, new location = " + r14);     // Catch: Throwable -> L27
        if (this.b.isHttps() == true) goto L19;
    L23:
        this.b = r14;     // Catch: Throwable -> L27
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r10, null);
        r1 = r1 + 1;
        goto L4
    L19:
        if (r14.isHttps() == true) goto L23;
        throw new CalDavException("Received redirect from HTTPS to HTTP", null, null, 6, null);     // Catch: Throwable -> L27
    L26:
        throw new CalDavException("Redirected without new Location", null, null, 6, null);     // Catch: Throwable -> L27
    L14:
        r14 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L8:
        r11 = r10;
    L32:
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    L35:
        return r10;
    }

    public a(OkHttpClient r10, HttpUrl r11) {
        Intrinsics.checkNotNullParameter(r10, "httpClient");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        this.a = r10;
        if ((!r10.followRedirects()) == false) goto L7;
        this.b = r11;
        return;
    L7:
        throw new IllegalArgumentException("httpClient must not follow redirects automatically".toString());
    }

    public final void c(final List r10, Function2 r11) {
        Intrinsics.checkNotNullParameter(r10, "urls");
        Intrinsics.checkNotNullParameter(r11, "callback");
        XmlPullParserFactory r0 = q3.e.a;
        final XmlSerializer r1 = q3.e.a.newSerializer();
        final StringWriter r12 = new StringWriter();
        r1.setOutput(r12);
        r1.startDocument("UTF-8", null);
        r1.setPrefix("", "DAV:");
        r1.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        q3.e.a(r1, b.m, new o3.a(r10, r1));
        r1.endDocument();
        Response r13 = b(new l(this, r12));
        e(r13, r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r13, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }

    public final List<Property> d(Reader r10, Function2<? super CalDavResponse, ? super CalDavResponse.HrefRelation, Unit> r11) {
        ArrayList r0 = new ArrayList();
        XmlPullParserFactory r1 = q3.e.a;
        XmlPullParser r12 = q3.e.a.newPullParser();
        r12.setInput(r10);     // Catch: XmlPullParserException -> L17 EOFException -> L20
        int r13 = r12.getEventType();     // Catch: XmlPullParserException -> L17 EOFException -> L20
    L5:
        if (r13 == 1) goto L16;
        if (r13 != 2) goto L14;
        if (r12.getDepth() != 1) goto L14;
        XmlPullParserFactory r14 = q3.e.a;     // Catch: XmlPullParserException -> L17 EOFException -> L20
        if (Intrinsics.areEqual(q3.e.c(r12), b.b) == false) goto L14;
        f(r12, this, r11, r0);     // Catch: XmlPullParserException -> L17 EOFException -> L20
        return r0;
    L14:
        r13 = r12.next();     // Catch: XmlPullParserException -> L17 EOFException -> L20
        goto L5
    L16:
        throw new CalDavException("Multi-Status response didn't contain multistatus XML element", null, null, 6, null);     // Catch: XmlPullParserException -> L17 EOFException -> L20
    L20:
        e = move-exception;
        throw new CalDavException("Incomplete multistatus XML element", e, null, 4, null);
    L17:
        e = move-exception;
        throw new CalDavException("Couldn't parse multistatus XML element", e, null, 4, null);
    }

    public final List<Property> e(Response r13, Function2<? super CalDavResponse, ? super CalDavResponse.HrefRelation, Unit> r14) {
        int r0 = q3.a.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        int r1 = r13.code();
        if ((r1 / 100) != 2) goto L38;
        if (r13.code() != 207) goto L36;
        if (r13.body() == null) goto L34;
        ResponseBody r10 = r13.body();
        if (r10 == null) goto L21;
        MediaType r11 = r10.contentType();
        if (r11 == null) goto L21;
        if (Intrinsics.areEqual(r11.type(), "application") == true) goto L17;
        if (Intrinsics.areEqual(r11.type(), "text") == true) goto L17;
    L20:
        throw new CalDavException("Received non-XML 207 Multi-Status", null, r13, 2, null);
    L17:
        if (Intrinsics.areEqual(r11.subtype(), "xml") == false) goto L20;
    L22:
        ResponseBody r15 = r13.body();
        if (r15 == null) goto L32;
        List<Property> r16 = d(r15.charStream(), r14);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r15, null);
        return r16;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L32:
        return CollectionsKt.emptyList();
    L21:
        g.a.w("CalDavClient", "Received 207 Multi-Status without Content-Type, assuming XML");
        goto L22
    L34:
        throw new CalDavException("Received 207 Multi-Status without body", null, r13, 2, null);
    L36:
        throw new CalDavException("Expected 207 Multi-Status, got " + r13.code() + ' ' + r13.message(), null, r13, 2, null);
    L38:
        if (r1 == 401) goto L56;
        if (r1 == 409) goto L67;
        if (r1 == 412) goto L66;
        if (r1 == 503) goto L65;
        if (r1 == 403) goto L64;
        if (r1 == 404) goto L63;
        throw new CalDavHttpException(r13);
    L63:
        throw new CalDavNotFoundException(r13);
    L64:
        throw new CalDavForbiddenException(r13);
    L65:
        throw new CalDavServiceUnavailableException(r13);
    L66:
        throw new CalDavPreconditionFailedException(r13);
    L67:
        throw new CalDavConflictException(r13);
    L56:
        throw new CalDavUnauthorizedException(r13);
    }

    public final void a(final Date r10, final Date r11, n3.d r12) {
        Intrinsics.checkNotNullParameter("VEVENT", "component");
        Intrinsics.checkNotNullParameter(r12, "callback");
        XmlPullParserFactory r0 = q3.e.a;
        XmlSerializer r1 = q3.e.a.newSerializer();
        final StringWriter r13 = new StringWriter();
        r1.setOutput(r13);
        r1.startDocument("UTF-8", null);
        r1.setPrefix("", "DAV:");
        r1.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        q3.e.a(r1, b.l, new p(r10, r11));
        r1.endDocument();
        Response r14 = b(new q(this, r13));
        e(r14, r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public final void g(final int r10, final Property.NodeInfo[] r11, Function2<? super CalDavResponse, ? super CalDavResponse.HrefRelation, Unit> r12) throws IOException, CalDavHttpException, CalDavException {
        Intrinsics.checkNotNullParameter(r11, "reqProp");
        Intrinsics.checkNotNullParameter(r12, "callback");
        XmlPullParserFactory r0 = q3.e.a;
        XmlSerializer r1 = q3.e.a.newSerializer();
        final StringWriter r13 = new StringWriter();
        r1.setOutput(r13);
        r1.setPrefix("", "DAV:");
        r1.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        r1.setPrefix("CARD", "urn:ietf:params:xml:ns:carddav");
        r1.startDocument("UTF-8", null);
        q3.e.a(r1, b.e, new r(r11));
        r1.endDocument();
        Response r14 = b(new s(this, r13, r10));
        e(r14, r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public final List h(final String r10, final Property.NodeInfo[] r11, j r12) {
        Intrinsics.checkNotNullParameter(r11, "properties");
        Intrinsics.checkNotNullParameter(r12, "callback");
        XmlPullParserFactory r0 = q3.e.a;
        XmlSerializer r1 = q3.e.a.newSerializer();
        final StringWriter r13 = new StringWriter();
        r1.setOutput(r13);
        r1.startDocument("UTF-8", null);
        r1.setPrefix("", "DAV:");
        q3.e.a(r1, b.h, new n(r10, r11));
        r1.endDocument();
        Response r14 = b(new o(this, r13));
        List<Property> r15 = e(r14, r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return r15;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public static final void f(XmlPullParser r25, a r26, Function2 r27, List r28) {
        int r10 = r25.getDepth();
        int r0 = r25.getEventType();
    L3:
        int r11 = 3;
        if (r0 == 3) goto L6;
    L9:
        int r12 = 2;
        if (r0 != 2) goto L169;
        if (r25.getDepth() != (r10 + 1)) goto L169;
        XmlPullParserFactory r1 = q3.e.a;
        Property.NodeInfo r13 = q3.e.c(r25);
        if (Intrinsics.areEqual(r13, b.a) == false) goto L162;
        int r14 = CalDavResponse.h;
        HttpUrl r15 = r26.b;
        Intrinsics.checkNotNullParameter(r25, "parser");
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        Intrinsics.checkNotNullParameter(r27, "callback");
        int r16 = r25.getDepth();
        ArrayList r17 = new ArrayList();
        int r18 = r25.getEventType();
        evc.j r19 = null;
        List r110 = null;
        HttpUrl r111 = null;
        HttpUrl r112 = null;
    L17:
        if (r18 == r11) goto L19;
    L79:
        if (r18 == r12) goto L81;
    L102:
        int r113 = r10;
    L161:
        r18 = r25.next();
        r27 = r27;
        r10 = r113;
        r11 = 3;
        r12 = 2;
        r25 = r25;
        goto L17
    L81:
        if (r25.getDepth() != (r16 + 1)) goto L102;
        XmlPullParserFactory r20 = q3.e.a;
        Property.NodeInfo r21 = q3.e.c(r25);
        if (Intrinsics.areEqual(r21, b.g) == false) goto L97;
        String r22 = r25.nextText();
        Intrinsics.checkNotNull(r22);
        if (StringsKt.startsWith$default(r22, "/", false, r12, null) == true) goto L95;
        Intrinsics.checkNotNull(r22);
        int r23 = StringsKt.indexOf$default(r22, ':', 0, false, 6, null);
        if (r23 == (-1)) goto L95;
        Intrinsics.checkNotNull(r22);     // Catch: IndexOutOfBoundsException -> L91
        if (Intrinsics.areEqual(r22.substring(r23, r23 + 3), "://") == false) goto L92;
        boolean r114 = true;
    L93:
        if (r114 == true) goto L95;
        r22 = "./" + r22;
    L92:
        r114 = false;
    L95:
        r112 = r15.resolve(r22);
        goto L102
    L97:
        if (Intrinsics.areEqual(r21, b.c) == false) goto L104;
        evc.j r24 = evc.j.a(r25.nextText());     // Catch: ProtocolException -> L100
    L101:
        r19 = r24;
    L100:
        g.a.w("CalDavClient", "Invalid status line, treating as HTTP error 500");
        r24 = new evc.j(Protocol.HTTP_1_1, 500, "Invalid status line");
        goto L101
    L104:
        if (Intrinsics.areEqual(r21, c.d) == false) goto L155;
        Intrinsics.checkNotNullParameter(r25, "parser");
        int r29 = r25.getDepth();
        LinkedList r30 = new LinkedList();
        int r31 = r25.getEventType();
        int r32 = 3;
        evc.j r115 = null;
    L106:
        if (r31 != r32) goto L115;
        if (r25.getDepth() != r29) goto L115;
        if (r115 != null) goto L113;
        r115 = c.e;
    L113:
        r17.add(new c(r30, r115));
    L115:
        if (r31 != 2) goto L153;
        if (r25.getDepth() != (r29 + 1)) goto L153;
        XmlPullParserFactory r33 = q3.e.a;
        Property.NodeInfo r34 = q3.e.c(r25);
        if (Intrinsics.areEqual(r34, b.f) == false) goto L146;
        Property.a.getClass();
        Intrinsics.checkNotNullParameter(r25, "parser");
        int r35 = r25.getDepth();
        LinkedList r36 = new LinkedList();
        int r37 = r25.getEventType();
    L122:
        if (r37 != 3) goto L128;
        if (r25.getDepth() != r35) goto L128;
        r30.addAll(r36);
    L128:
        if (r37 == 2) goto L130;
    L144:
        int r210 = r35;
        r30 = r30;
    L145:
        r37 = r25.next();
        r25 = r25;
        r35 = r210;
        r30 = r30;
        goto L122
    L130:
        if (r25.getDepth() != (r35 + 1)) goto L144;
        r25.getDepth();
        r210 = r35;
        Property.NodeInfo r38 = new Property.NodeInfo(r25.getNamespace(), r25.getName());
        d r39 = d.a;
        Intrinsics.checkNotNullParameter(r38, "nodeInfo");
        Intrinsics.checkNotNullParameter(r25, "parser");
        e r40 = (e) ((LinkedHashMap) d.b).get(r38);     // Catch: XmlPullParserException -> L137
        if (r40 == null) goto L139;
        r30 = r30;
        Property r41 = r40.a(r25);     // Catch: XmlPullParserException -> L137
    L140:
        r25.getDepth();
        if (r41 == null) goto L143;
        r36.add(r41);
        goto L145
    L143:
        g.a.d("CalDavClient", "Ignoring unknown property " + r38);
    L139:
        r41 = null;
    L137:
        e = move-exception;
        g.a.w("CalDavClient", "Couldn't parse " + r38, e);
        goto L139
    L146:
        r10 = r10;
        r29 = r29;
        LinkedList r211 = r30;
        if (Intrinsics.areEqual(r34, b.c) == false) goto L154;
        evc.j r42 = evc.j.a(r25.nextText());     // Catch: ProtocolException -> L150
    L151:
        r115 = r42;
    L150:
        r42 = c.f;
    L154:
        r31 = r25.next();
        r32 = 3;
        r25 = r25;
        r29 = r29;
        r10 = r10;
        r30 = r211;
    L153:
        r211 = r30;
        goto L154
    L155:
        r113 = r10;
        if (Intrinsics.areEqual(r21, i.a) == false) goto L159;
        r110 = i.a.a(r25);
        goto L161
    L159:
        if (Intrinsics.areEqual(r21, b.d) == false) goto L161;
        r111 = HttpUrl.parse(r25.nextText());
        goto L161
    L19:
        if (r25.getDepth() != r16) goto L79;
        if (r112 == null) goto L78;
        ArrayList r43 = new ArrayList();
        Iterator r44 = r17.iterator();
    L24:
        if (r44.hasNext() == false) goto L31;
        Object r45 = r44.next();
        if ((((c) r45).b.b / 100) != r12) goto L28;
        boolean r46 = true;
    L29:
        if (r46 == false) goto L24;
        r43.add(r45);
        goto L24
    L28:
        r46 = false;
        goto L29
    L31:
        ArrayList r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator r48 = r43.iterator();
    L33:
        if (r48.hasNext() == false) goto L35;
        r47.add(((c) r48.next()).a);
        goto L33
    L35:
        t r49 = (t) CollectionsKt.firstOrNull(CollectionsKt.filterIsInstance(r47, t.class));
        if (r49 != null) goto L38;
    L40:
        HttpUrl r50 = r112;
    L41:
        HttpUrl r51 = q3.c.b(r50);
        HttpUrl r52 = q3.c.b(r15);
        Intrinsics.checkNotNullParameter(r51, "url1");
        Intrinsics.checkNotNullParameter(r52, "url2");
        if (Intrinsics.areEqual(r51, r52) == false) goto L44;
        boolean r53 = true;
    L48:
        if (r53 == false) goto L51;
        CalDavResponse.HrefRelation r54 = CalDavResponse.HrefRelation.SELF;
    L77:
        r27.invoke(new CalDavResponse(r15, r50, r19, r17, r110, r111), r54);
        goto L169
    L51:
        if (Intrinsics.areEqual(r15.scheme(), r50.scheme()) == true) goto L53;
    L76:
        r54 = CalDavResponse.HrefRelation.OTHER;
        goto L77
    L53:
        if (Intrinsics.areEqual(r15.host(), r50.host()) == false) goto L76;
        if (r15.port() != r50.port()) goto L76;
        List r55 = r15.pathSegments();
        List r56 = r50.pathSegments();
        int r57 = r55.size();
        int r58 = r57 - 1;
        if (Intrinsics.areEqual(ListProtector.get(r55, r58), "") == false) goto L59;
        r57 = r58;
    L59:
        CalDavResponse.HrefRelation r59 = CalDavResponse.HrefRelation.OTHER;
        if (r56.size() <= r57) goto L75;
        Collection r60 = RangesKt.until(0, r57);
        if ((r60 instanceof Collection) == true) goto L64;
    L66:
        IntIterator r61 = r60.iterator();
    L68:
        if (r61.hasNext() == false) goto L72;
        int r116 = r61.nextInt();
        if ((!Intrinsics.areEqual(ListProtector.get(r55, r116), ListProtector.get(r56, r116))) == false) goto L68;
        boolean r117 = false;
    L73:
        if (r117 == false) goto L75;
        r54 = CalDavResponse.HrefRelation.MEMBER;
    L72:
        r117 = true;
        goto L73
    L64:
        if (r60.isEmpty() == false) goto L66;
    L75:
        r54 = r59;
        goto L77
    L44:
        HttpUrl.a r62 = r51.newBuilder();
        r62.h = null;
        Uri r63 = UriProtector.parse(r62.b().toString());
        HttpUrl.a r64 = r52.newBuilder();
        r64.h = null;
        Uri r65 = UriProtector.parse(r64.b().toString());
        r53 = Intrinsics.areEqual(new URI(r63.getScheme(), r63.getSchemeSpecificPart(), r63.getFragment()), new URI(r65.getScheme(), r65.getSchemeSpecificPart(), r65.getFragment()));     // Catch: URISyntaxException -> L47
    L47:
        r53 = false;
        goto L48
    L38:
        if (r49.b.contains(t.d) == false) goto L40;
        r50 = q3.c.a(r112);
        goto L41
    L78:
        g.a.w("CalDavClient", "Ignoring XML response element without valid href");
        goto L169
    L162:
        int r118 = r10;
        if (Intrinsics.areEqual(r13, x.c) == false) goto L170;
        String r66 = q3.e.d(r25);
        if (r66 == null) goto L170;
        r28.add(new x(r66));
    L170:
        r0 = r25.next();
        r10 = r118;
    L169:
        r118 = r10;
        goto L170
    L6:
        if (r25.getDepth() != r10) goto L9;
    }
}
