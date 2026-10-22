package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019BC\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u0014\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b \u0010!J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\"\u0010#J\u000f\u0010'\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u001fR\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b\u0003\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b\u0005\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b\u0007\u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b\t\u0010#R*\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101R\u0011\u00103\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u0010'\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b'\u0010&¨\u00065"}, d2 = {"Lokhttp3/Request;", "", "Lokhttp3/e0;", "url", "", "method", "Lokhttp3/c0;", "headers", "Lokhttp3/q0;", "body", "", "Ljava/lang/Class;", "tags", "<init>", "(Lokhttp3/e0;Ljava/lang/String;Lokhttp3/c0;Lokhttp3/q0;Ljava/util/Map;)V", "name", "header", "(Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/lang/String;)Ljava/util/List;", "tag", "()Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/n0;", "newBuilder", "()Lokhttp3/n0;", "-deprecated_url", "()Lokhttp3/e0;", "-deprecated_method", "()Ljava/lang/String;", "-deprecated_headers", "()Lokhttp3/c0;", "-deprecated_body", "()Lokhttp3/q0;", "Lokhttp3/h;", "-deprecated_cacheControl", "()Lokhttp3/h;", "cacheControl", "toString", "lazyCacheControl", "Lokhttp3/h;", "Lokhttp3/e0;", "Ljava/lang/String;", "Lokhttp3/c0;", "Lokhttp3/q0;", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "", "isHttps", "()Z", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Request {
    private final q0 body;
    private final c0 headers;
    private h lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final e0 url;

    public Request(e0 r5, String r10, c0 r11, q0 r12, Map<Class<?>, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "headers");
        Intrinsics.checkNotNullParameter(r13, "tags");
        this.url = r5;
        this.method = r10;
        this.headers = r11;
        this.body = r12;
        this.tags = r13;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    @JvmName(name = "-deprecated_body")
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final q0 m1636deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    @JvmName(name = "-deprecated_cacheControl")
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final h m1637deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_headers")
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final c0 m1638deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "method", imports = {}))
    @JvmName(name = "-deprecated_method")
    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m1639deprecated_method() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    @JvmName(name = "-deprecated_url")
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final e0 m1640deprecated_url() {
        return this.url;
    }

    @JvmName(name = "body")
    public final q0 body() {
        return this.body;
    }

    @JvmName(name = "cacheControl")
    public final h cacheControl() {
        h r5 = this.lazyCacheControl;
        if (r5 != null) goto L6;
        h r10 = h.f20647n;
        h r11 = z.i(this.headers);
        this.lazyCacheControl = r11;
        return r11;
    L6:
        return r5;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.headers.b(r5);
    }

    @JvmName(name = "headers")
    public final c0 headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.f20639a;
    }

    @JvmName(name = "method")
    public final String method() {
        return this.method;
    }

    public final n0 newBuilder() {
        Intrinsics.checkNotNullParameter(this, "request");
        n0 r5 = new n0();
        r5.e = new LinkedHashMap();
        r5.f20713a = url();
        r5.f20714b = method();
        r5.d = body();
        if (getTags$okhttp().isEmpty() == false) goto L5;
        Map r10 = new LinkedHashMap();
    L6:
        r5.e = r10;
        r5.f20715c = headers().d();
        return r5;
    L5:
        r10 = MapsKt.toMutableMap(getTags$okhttp());
        goto L6
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Request{method=");
        r5.append(this.method);
        r5.append(", url=");
        r5.append(this.url);
        if (this.headers.size() == 0) goto L16;
        r5.append(", headers=[");
        Iterator r10 = this.headers.iterator();
        int r11 = 0;
    L6:
        if (r10.hasNext() == false) goto L14;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Pair r14 = (Pair) r12;
        String r15 = (String) r14.component1();
        String r16 = (String) r14.component2();
        if (r11 <= 0) goto L13;
        r5.append(", ");
    L13:
        r5.append(r15);
        r5.append(':');
        r5.append(r16);
        r11 = r13;
        goto L6
    L14:
        r5.append(']');
    L16:
        if (this.tags.isEmpty() == true) goto L18;
        r5.append(", tags=");
        r5.append(this.tags);
    L18:
        r5.append('}');
        return r5.toString();
    }

    @JvmName(name = "url")
    public final e0 url() {
        return this.url;
    }

    public final List<String> headers(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return this.headers.f(r5);
    }

    public final <T> T tag(Class<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return r5.cast(this.tags.get(r5));
    }
}
