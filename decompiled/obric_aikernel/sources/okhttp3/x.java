package okhttp3;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Request.kt\nokhttp3/Request\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,335:1\n1864#2,3:336\n*S KotlinDebug\n*F\n+ 1 Request.kt\nokhttp3/Request\n*L\n122#1:336,3\n*E\n"})
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f12117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f12118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f12120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f12121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, Object> f12122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f12123g;

    @SourceDebugExtension({"SMAP\nRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Request.kt\nokhttp3/Request$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1#2:336\n*E\n"})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private s f12124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private r.a f12126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private y f12127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<Class<?>, Object> f12128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private s f12129f;

        public a() {
            this.f12128e = new LinkedHashMap();
            this.f12125b = "GET";
            this.f12126c = new r.a();
        }

        public a(x r10) {
            Intrinsics.checkNotNullParameter(r10, "request");
            this.f12128e = new LinkedHashMap();
            this.f12124a = r10.l();
            this.f12125b = r10.g();
            this.f12127d = r10.a();
            if (r10.c().isEmpty() == false) goto L5;
            Map<Class<?>, Object> r11 = new LinkedHashMap();
        L6:
            this.f12128e = r11;
            this.f12126c = r10.e().e();
            this.f12129f = r10.i();
            return;
        L5:
            r11 = MapsKt.toMutableMap(r10.c());
            goto L6
        }

        public a a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            this.f12126c.a(r10, r11);
            return this;
        }

        public x b() {
            s r10 = this.f12124a;
            if (r10 == null) goto L7;
            return new x(r10, this.f12129f, this.f12125b, this.f12126c.e(), this.f12127d, hc.e.U(this.f12128e));
        L7:
            throw new IllegalStateException("url == null".toString());
        }

        public a c() {
            return f("GET", null);
        }

        public a d(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            this.f12126c.h(r10, r11);
            return this;
        }

        public a e(r r10) {
            Intrinsics.checkNotNullParameter(r10, "headers");
            this.f12126c = r10.e();
            return this;
        }

        public a f(String r10, y r11) {
            Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
            if (r10.length() <= 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L21;
            if (r11 != null) goto L15;
            if ((true ^ kc.f.d(r10)) == false) goto L13;
        L16:
            this.f12125b = r10;
            this.f12127d = r11;
            return this;
        L13:
            throw new IllegalArgumentException(("method " + r10 + " must have a request body.").toString());
        L15:
            if (kc.f.a(r10) == true) goto L16;
            throw new IllegalArgumentException(("method " + r10 + " must not have a request body.").toString());
        L21:
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        L5:
            r12 = false;
            goto L6
        }

        public a g(y r10) {
            Intrinsics.checkNotNullParameter(r10, "body");
            return f(CloudConfig.REQUEST_TYPE_POST, r10);
        }

        public a h(String r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            this.f12126c.g(r10);
            return this;
        }

        public <T> a i(Class<? super T> r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            if (r11 != null) goto L6;
            this.f12128e.remove(r10);
        L9:
            return this;
        L6:
            if (this.f12128e.isEmpty() == false) goto L8;
            this.f12128e = new LinkedHashMap();
        L8:
            Map<Class<?>, Object> r12 = this.f12128e;
            T r13 = r10.cast(r11);
            Intrinsics.checkNotNull(r13);
            r12.put(r10, r13);
            goto L9
        }

        public a j(Object r10) {
            return i(Object.class, r10);
        }

        public a k(String r10) {
            Intrinsics.checkNotNullParameter(r10, "url");
            if (StringsKt.startsWith(r10, "ws:", true) == false) goto L7;
            StringBuilder r11 = new StringBuilder();
            r11.append("http:");
            int r12 = 3;
        L5:
            String r13 = r10.substring(r12);
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
            r11.append(r13);
            r10 = r11.toString();
        L10:
            return l(s.f12025k.d(r10));
        L7:
            if (StringsKt.startsWith(r10, "wss:", true) == false) goto L10;
            r11 = new StringBuilder();
            r11.append("https:");
            r12 = 4;
            goto L5
        }

        public a l(s r10) {
            Intrinsics.checkNotNullParameter(r10, "url");
            this.f12124a = r10;
            return this;
        }
    }

    public x(s r10, s r11, String r12, r r13, y r14, Map<Class<?>, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r12, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r13, "headers");
        Intrinsics.checkNotNullParameter(r15, "tags");
        this.f12117a = r10;
        this.f12118b = r11;
        this.f12119c = r12;
        this.f12120d = r13;
        this.f12121e = r14;
        this.f12122f = r15;
    }

    @JvmName(name = "body")
    public final y a() {
        return this.f12121e;
    }

    @JvmName(name = "cacheControl")
    public final d b() {
        d r10 = this.f12123g;
        if (r10 != null) goto L6;
        d r11 = d.f11688n.b(this.f12120d);
        this.f12123g = r11;
        return r11;
    L6:
        return r10;
    }

    public final Map<Class<?>, Object> c() {
        return this.f12122f;
    }

    public final String d(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.f12120d.b(r10);
    }

    @JvmName(name = "headers")
    public final r e() {
        return this.f12120d;
    }

    public final boolean f() {
        return this.f12117a.i();
    }

    @JvmName(name = EnsureReportData.METHOD)
    public final String g() {
        return this.f12119c;
    }

    public final a h() {
        return new a(this);
    }

    @JvmName(name = "originUrl")
    public final s i() {
        return this.f12118b;
    }

    public final Object j() {
        return k(Object.class);
    }

    public final <T> T k(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        return r10.cast(this.f12122f.get(r10));
    }

    @JvmName(name = "url")
    public final s l() {
        return this.f12117a;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Request{method=");
        r10.append(this.f12119c);
        r10.append(", url=");
        r10.append(this.f12117a);
        if (this.f12120d.size() == 0) goto L16;
        r10.append(", headers=[");
        int r11 = 0;
        Iterator<Pair<? extends String, ? extends String>> r12 = this.f12120d.iterator();
    L6:
        if (r12.hasNext() == false) goto L14;
        Pair<? extends String, ? extends String> r13 = r12.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Pair<? extends String, ? extends String> r15 = r13;
        String r16 = r15.component1();
        String r17 = r15.component2();
        if (r11 <= 0) goto L13;
        r10.append(", ");
    L13:
        r10.append(r16);
        r10.append(':');
        r10.append(r17);
        r11 = r14;
        goto L6
    L14:
        r10.append(']');
    L16:
        if ((!this.f12122f.isEmpty()) == false) goto L18;
        r10.append(", tags=");
        r10.append(this.f12122f);
    L18:
        r10.append('}');
        String r18 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    }
}
