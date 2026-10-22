package d4;

import android.content.Context;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.bridge.method.net.core.IHostNetworkRuntimeApi;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.http.RequestContext;
import d3.a0;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements w {
    public final Object a;
    public final Map<c, Map<String, i>> b;
    public final Map<c, Map<String, e>> c;

    public static final class a {
    }

    /* JADX INFO: renamed from: d4.b$b, reason: collision with other inner class name */
    public final class C0150b extends FilterOutputStream {
        public final long a;
        public final AtomicLong b;
        public final Function2<Long, Long, Unit> c;

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(int r10) {
            ((FilterOutputStream) this).out.write(r10);
            long r0 = this.b.addAndGet(1);
            this.c.invoke(Long.valueOf(r0), Long.valueOf(this.a));
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "b");
            ((FilterOutputStream) this).out.write(r10, r11, r12);
            this.c.invoke(Long.valueOf(this.b.addAndGet(r12)), Long.valueOf(this.a));
        }

        public C0150b(OutputStream r10, long r11, AtomicLong r12, Function2 r13) {
            Intrinsics.checkNotNullParameter(r10, "out");
            Intrinsics.checkNotNullParameter(r12, "uploadedBytes");
            Intrinsics.checkNotNullParameter(r13, "onProgress");
            super(r10);
            this.a = r11;
            this.b = r12;
            this.c = r13;
        }
    }

    public static final class c {
        public static final /* synthetic */ int c = 0;
        public final String a;
        public final String b;

        public static final class a {
            public static c a(e3.d r10) {
                Intrinsics.checkNotNullParameter(r10, "bridgeContext");
                a0 r11 = r10.getContainerContext();
                if (r11 != null) goto L6;
                return null;
            L6:
                String r1 = r11.getAppletId();
                if (r1 != null) goto L10;
                r1 = "";
            L10:
                return new c(r1, r11.getContainerId());
            }
        }

        static {
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OwnerKey(appletId=" + this.a + ", containerId=" + this.b + ')';
        }

        public c(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "appletId");
            Intrinsics.checkNotNullParameter(r11, "containerId");
            this.a = r10;
            this.b = r11;
        }
    }

    public final class d implements TypedOutput {
        public final TypedOutput a;
        public final Function2<Long, Long, Unit> b;
        public final AtomicLong c;

        public final String md5Stub() {
            return null;
        }

        public final String fileName() {
            return this.a.fileName();
        }

        public final long length() {
            return this.a.length();
        }

        public final String mimeType() {
            return this.a.mimeType();
        }

        public final void writeTo(OutputStream r11) {
            Intrinsics.checkNotNullParameter(r11, "out");
            this.c.set(0);
            this.a.writeTo(new C0150b(r11, length(), this.c, this.b));
            long r10 = length();
            if (r10 < 0) goto L6;
            this.b.invoke(Long.valueOf(r10), Long.valueOf(r10));
            return;
        }

        public d(b r1, MultipartTypedOutput r10, d4.a r11) {
            Intrinsics.checkNotNullParameter(r10, "delegate");
            Intrinsics.checkNotNullParameter(r11, "onProgress");
            this.a = r10;
            this.b = r11;
            this.c = new AtomicLong(0);
        }
    }

    public static final class e {
        public volatile boolean a;

        public e() {
        }
    }

    public static final class f {
        public final e a;
        public final String b;

        public f() {
            this(null, null, 3);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof f) == true) goto L8;
            return false;
        L8:
            f r11 = (f) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            e r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.b;
            if (r12 == null) goto L11;
            r1 = r12.hashCode();
        L11:
            return r11 + r1;
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadPreparationResult(preparation=" + this.a + ", errorMessage=" + this.b + ')';
        }

        public f(e r10, String r11, int r12) {
            if ((r12 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r12 & 2) == 0) goto L8;
            r11 = null;
        L8:
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class g {
        public final int a;
        public final Map<String, String> b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof g) == true) goto L8;
            return false;
        L8:
            g r11 = (g) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "UploadResponse(statusCode=" + this.a + ", header=" + this.b + ", data=" + this.c + ')';
        }

        public g(int r10, Map<String, String> r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "header");
            Intrinsics.checkNotNullParameter(r12, "data");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class h {
        public final g a;
        public final String b;
        public final Integer c;
        public final Map<String, String> d;

        public h() {
            this(null, null, null, 15);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof h) == true) goto L8;
            return false;
        L8:
            h r11 = (h) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            g r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.b;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            Integer r15 = this.c;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            Map<String, String> r18 = this.d;
            if (r18 == null) goto L19;
            r1 = r18.hashCode();
        L19:
            return r17 + r1;
        L13:
            r16 = r15.hashCode();
            goto L14
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadResult(response=" + this.a + ", errorMessage=" + this.b + ", statusCode=" + this.c + ", header=" + this.d + ')';
        }

        public h(g r10, String r11, Integer r12, int r13) {
            if ((r13 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = null;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = null;
        L11:
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = null;
        }
    }

    public final class i {
        public final c a;
        public final Call<TypedInput> b;
        public volatile boolean c;

        public final void a() {
            this.c = true;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            if (this.b.isCanceled() == true) goto L6;
            this.b.cancel();     // Catch: Throwable -> L8
        L6:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        public i(String r10, c r11, Call r12) {
            Intrinsics.checkNotNullParameter(r10, "uploadTaskId");
            Intrinsics.checkNotNullParameter(r11, "ownerKey");
            Intrinsics.checkNotNullParameter(r12, "call");
            this.a = r11;
            this.b = r12;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        Object r10 = this.a;
        monitor-enter(r10);
        Collection r11 = ((LinkedHashMap) this.b).values();     // Catch: Throwable -> L23
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L23
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L23
    L6:
        if (r13.hasNext() == false) goto L8;
        CollectionsKt.addAll(r12, ((Map) r13.next()).values());     // Catch: Throwable -> L23
        goto L6
    L8:
        ((LinkedHashMap) this.b).clear();     // Catch: Throwable -> L23
        r0.element = r12;     // Catch: Throwable -> L23
        Collection r14 = ((LinkedHashMap) this.c).values();     // Catch: Throwable -> L23
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L23
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L23
    L10:
        if (r16.hasNext() == false) goto L12;
        CollectionsKt.addAll(r15, ((Map) r16.next()).values());     // Catch: Throwable -> L23
        goto L10
    L12:
        ((LinkedHashMap) this.c).clear();     // Catch: Throwable -> L23
        r1.element = r15;     // Catch: Throwable -> L23
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r10);
        Iterator r18 = r15.iterator();
    L16:
        if (r18.hasNext() == false) goto L18;
        ((e) r18.next()).a = true;
        goto L16
    L18:
        Iterator r19 = ((Iterable) r0.element).iterator();
    L20:
        if (r19.hasNext() == false) goto L22;
        ((i) r19.next()).a();
        goto L20
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public b() {
        this.a = new Object();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public static String e(TypedInput r10) {
        Object r0 = "";
        if (r10 != null) goto L27;
        return "";
    L27:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        InputStream r11 = r10.in();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L10
        String r12 = new String(ByteStreamsKt.readBytes(r11), Charsets.UTF_8);     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L15
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r13) == true) goto L22;
        r0 = r13;
    L22:
        return (String) r0;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final void b(e3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        int r0 = c.c;
        c r11 = c.a.a(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        Object r1 = this.a;
        monitor-enter(r1);
        Map<String, i> r12 = this.b.remove(r11);     // Catch: Throwable -> L32
        if (r12 == null) goto L13;
        Collection<i> r13 = r12.values();     // Catch: Throwable -> L32
        if (r13 == null) goto L13;
        List r14 = CollectionsKt.toList(r13);     // Catch: Throwable -> L32
        if (r14 == null) goto L13;
    L14:
        Map<String, e> r15 = this.c.remove(r11);     // Catch: Throwable -> L32
        if (r15 == null) goto L20;
        Collection<e> r16 = r15.values();     // Catch: Throwable -> L32
        if (r16 == null) goto L20;
        List r17 = CollectionsKt.toList(r16);     // Catch: Throwable -> L32
        if (r17 == null) goto L20;
    L21:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r1);
        Iterator r19 = r17.iterator();
    L25:
        if (r19.hasNext() == false) goto L27;
        ((e) r19.next()).a = true;
        goto L25
    L27:
        Iterator r20 = r14.iterator();
    L29:
        if (r20.hasNext() == false) goto L31;
        ((i) r20.next()).a();
        goto L29
    L31:
        return;
    L20:
        r17 = CollectionsKt.emptyList();     // Catch: Throwable -> L32
    L13:
        r14 = CollectionsKt.emptyList();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final void c(e3.d r10, String r11, e r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "uploadTaskId");
        Intrinsics.checkNotNullParameter(r12, "preparation");
        int r0 = c.c;
        c r13 = c.a.a(r10);
        if (r13 != null) goto L5;
        return;
    L5:
        Object r1 = this.a;
        monitor-enter(r1);
        Map r14 = (Map) ((LinkedHashMap) this.c).get(r13);     // Catch: Throwable -> L19
        if (r14 != null) goto L12;
        monitor-exit(r1);
        return;
    L12:
        if (r14.get(r11) != r12) goto L16;
        r14.remove(r11);     // Catch: Throwable -> L19
        if (r14.isEmpty() == false) goto L16;
        this.c.remove(r13);     // Catch: Throwable -> L19
    L16:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r1);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void f(String r10, c r11, i r12) {
        Object r0 = this.a;
        monitor-enter(r0);
        i(r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final i i(String r10, c r11, i r12) {
        Map r0 = (Map) ((LinkedHashMap) this.b).get(r11);
        if (r0 != null) goto L5;
        return null;
    L5:
        i r13 = (i) r0.get(r10);
        if (r13 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r13.a, r11) == true) goto L11;
        return null;
    L11:
        if (r12 == null) goto L14;
        if (r13 == r12) goto L14;
        return null;
    L14:
        r0.remove(r10);
        if (r0.isEmpty() == false) goto L17;
        this.b.remove(r11);
    L17:
        return r13;
    }

    public final void j(e3.d r10, String r11, Map<String, String> r12) {
        Lazy r0 = com.bytedance.ai.applet.base.gson.e.a;
        r10.a("uploadFileHeadersReceived", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("uploadTaskId", r11), TuplesKt.to("uploadTaskID", r11), TuplesKt.to("header", r12)})));
    }

    public final void k(e3.d r10, String r11, long r12, long r14) {
        if (r14 <= 0) goto L5;
        int r1 = (int) RangesKt.coerceIn((((long) 100) * r12) / r14, 0, 100);
    L6:
        Lazy r0 = com.bytedance.ai.applet.base.gson.e.a;
        r10.a("uploadFileProgressUpdate", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("uploadTaskId", r11), TuplesKt.to("uploadTaskID", r11), TuplesKt.to("progress", Integer.valueOf(r1)), TuplesKt.to("totalBytesSent", Long.valueOf(r12)), TuplesKt.to("totalBytesExpectedToSend", Long.valueOf(r14))})));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [d4.a] */
    public final h l(final e3.d r25, final String r26, String r27, File r28, String r29, Map<String, String> r30, Map<String, String> r31, long r32, IHostNetworkDepend r34, e r35) {
        Intrinsics.checkNotNullParameter(r25, "bridgeContext");
        Intrinsics.checkNotNullParameter(r26, "uploadTaskId");
        Intrinsics.checkNotNullParameter(r27, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r28, "file");
        Intrinsics.checkNotNullParameter(r29, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r30, "header");
        Intrinsics.checkNotNullParameter(r31, "formData");
        Intrinsics.checkNotNullParameter(r34, "hostNetworkDepend");
        Intrinsics.checkNotNullParameter(r35, "preparation");
        int r0 = c.c;
        c r10 = c.a.a(r25);
        if (r10 != null) goto L7;
        return new h(null, "uploadFile:fail bridge context is unavailable", null, 13);
    L7:
        if (r35.a == true) goto L9;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        String r11 = new URI(r27).getScheme();     // Catch: Throwable -> L16
        if (r11 == null) goto L13;
        String r12 = r11.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L16
    L14:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r13) == false) goto L21;
        r13 = null;
    L21:
        String r14 = (String) r13;
        if (Intrinsics.areEqual(r14, "http") == false) goto L24;
    L27:
        MultipartTypedOutput r15 = new MultipartTypedOutput();
        Iterator<Map.Entry<String, String>> r16 = r31.entrySet().iterator();
    L29:
        if (r16.hasNext() == false) goto L31;
        Map.Entry<String, String> r17 = r16.next();
        r15.addPart(r17.getKey(), new TypedByteArray("text/plain; charset=UTF-8", r17.getValue().getBytes(Charsets.UTF_8), new String[0]));
        r16 = r16;
        r10 = r10;
        goto L29
    L31:
        c r18 = r10;
        String r19 = URLConnection.guessContentTypeFromName(r28.getName());
        if (r19 != null) goto L34;
        r19 = "application/octet-stream";
    L34:
        r15.addPart(r29, new TypedFile(r19, r28));
        if (r15.length() != 0) goto L38;
        k(r25, r26, 0, 0);
    L38:
        d r20 = new d(this, r15, new d4.a(this, r25, r26));
        LinkedHashMap r21 = new LinkedHashMap();
        android.util.Pair r22 = UrlUtils.parseUrl(new UrlBuilder(r27).build(), r21);
        String r23 = (String) r22.first;
        String r24 = (String) r22.second;
        String r33 = r20.mimeType();
        ArrayList r36 = new ArrayList();
        Iterator<Map.Entry<String, String>> r37 = r30.entrySet().iterator();
    L40:
        if (r37.hasNext() == false) goto L57;
        Map.Entry<String, String> r38 = r37.next();
        String r110 = r38.getKey();
        String r39 = r38.getValue();
        String r111 = StringsKt.trim(r110).toString();
        String r112 = r111.toLowerCase(Locale.ROOT);
        if ((!StringsKt.isBlank(r111)) == true) goto L44;
    L55:
        Iterator<Map.Entry<String, String>> r210 = r37;
    L56:
        r37 = r210;
        goto L40
    L44:
        if (r39.length() <= 0) goto L46;
        boolean r113 = true;
    L47:
        if (r113 == false) goto L55;
        r210 = r37;
        if (Intrinsics.areEqual(r112, "referer") == true) goto L56;
        if (Intrinsics.areEqual(r112, "user-agent") == true) goto L56;
        if (Intrinsics.areEqual(r112, "content-type") == true) goto L56;
        r36.add(new Header(r111, r39));
        goto L56
    L46:
        r113 = false;
        goto L47
    L57:
        r36.add(new Header("Content-Type", r33));
        RequestContext r40 = new RequestContext();
        if (r32 <= 0) goto L60;
        ((BaseRequestContext) r40).timeout_connect = r32;
        ((BaseRequestContext) r40).timeout_read = r32;
        ((BaseRequestContext) r40).timeout_write = r32;
    L60:
        ((BaseRequestContext) r40).force_handle_response = true;
        Boolean r114 = Boolean.FALSE;
        Map<String, ? extends Object> r41 = MapsKt.mapOf(new Pair[]{TuplesKt.to("isCustomizedCookie", r114), TuplesKt.to("needAddCommonParams", r114)});
        Intrinsics.checkNotNull(r23);
        IAppletRetrofit r42 = r34.createRetrofit(r23, false, r41);
        if (r42 == null) goto L65;
        IHostNetworkRuntimeApi r43 = (IHostNetworkRuntimeApi) r42.create(IHostNetworkRuntimeApi.class);
        if (r43 == null) goto L65;
        Call<TypedInput> r44 = r43.post(false, -1, r24, r21, r36, r20, r40);
    L66:
        if (r44 == null) goto L68;
        i r45 = new i(r26, r18, r44);
        Object r46 = this.a;
        monitor-enter(r46);
    L134:
        th = move-exception;
        throw th;
    L73:
        if (r35.a == false) goto L77;
        h r47 = new h(null, "uploadFile:fail abort", null, 13);     // Catch: Throwable -> L134
        monitor-exit(r46);
        return r47;
    L77:
        Map r48 = (Map) ((LinkedHashMap) this.b).get(r18);     // Catch: Throwable -> L134
        if (r48 == null) goto L82;
        boolean r115 = true;
        if (r48.containsKey(r26) != true) goto L82;
    L83:
        if (r115 == false) goto L87;
        h r49 = new h(null, "uploadFile:fail uploadTaskId already exists", null, 13);     // Catch: Throwable -> L134
        monitor-exit(r46);
        return r49;
    L87:
        Map r50 = (Map) ((LinkedHashMap) this.c).get(r18);     // Catch: Throwable -> L134
        if (r50 == null) goto L90;
        e r116 = (e) r50.get(r26);     // Catch: Throwable -> L134
    L91:
        if (r116 != r35) goto L95;
        r50.remove(r26);     // Catch: Throwable -> L134
        if (r50.isEmpty() == false) goto L95;
        this.c.remove(r18);     // Catch: Throwable -> L134
    L95:
        Map<String, i> r51 = (Map) ((LinkedHashMap) this.b).get(r18);     // Catch: Throwable -> L134
        if (r51 != null) goto L98;
        r51 = new LinkedHashMap();     // Catch: Throwable -> L134
    L98:
        r51.put(r26, r45);     // Catch: Throwable -> L134
        this.b.put(r18, r51);     // Catch: Throwable -> L134
        Unit r52 = Unit.INSTANCE;     // Catch: Throwable -> L134
        monitor-exit(r46);
        SsResponse r53 = r44.execute();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        LinkedHashMap r54 = new LinkedHashMap();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        Iterator r117 = r53.headers().iterator();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
    L103:
        if (r117.hasNext() == false) goto L108;
        Header r118 = (Header) r117.next();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        String r119 = r118.getName();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        String r120 = r118.getValue();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        if (r120 != null) goto L107;
        r120 = "";
    L107:
        r54.put(r119, r120);     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        goto L103
    L108:
        j(r25, r26, r54);     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        int r121 = r53.code();     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        String r122 = b4.e.a((TypedInput) r53.body());     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
        if (r122 != null) goto L111;
        r122 = e((TypedInput) r53.body());     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
    L111:
        h r55 = new h(new g(r121, r54, r122), null, null, 14);     // Catch: Throwable -> L113 NetworkNotAvailabeException -> L124 HttpResponseException -> L128
    L130:
        f(r26, r18, r45);
        return r55;
    L126:
        th = move-exception;
        f(r26, r18, r45);
        throw th;
    L128:
        e = move-exception;
        int r56 = e.getStatusCode();     // Catch: Throwable -> L126
        r55 = new h(null, "Upload failed, httpCode: " + r56 + ", message: " + e.getMessage(), Integer.valueOf(r56), 9);     // Catch: Throwable -> L126
    L124:
        e = move-exception;
        r55 = new h(null, "Upload failed, httpCode: -1001, message: " + e.getMessage(), -1001, 9);     // Catch: Throwable -> L126
    L113:
        th = move-exception;
        if (r44.isCanceled() == false) goto L117;
    L122:
        String r57 = "uploadFile:fail abort";
    L123:
        com.bytedance.ai.utils.g.a.e("AppletUploadFileManager", "upload failed taskId:" + r26, th);     // Catch: Throwable -> L126
        r55 = new h(null, r57, null, 13);     // Catch: Throwable -> L126
        goto L130
    L117:
        if (r45.c == true) goto L122;
        r57 = th.getMessage();     // Catch: Throwable -> L126
        if (r57 != null) goto L123;
        r57 = "uploadFile failed";
        goto L123
    L90:
        r116 = null;
    L82:
        r115 = false;
        goto L83
    L68:
        return new h(null, "call is null", null, 13);
    L65:
        r44 = null;
        goto L66
    L24:
        if (Intrinsics.areEqual(r14, "https") == true) goto L27;
        return new h(null, "uploadFile:fail url is invalid", null, 13);
    L13:
        r12 = null;
    L16:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L9:
        return new h(null, "uploadFile:fail abort", null, 13);
    }
}
