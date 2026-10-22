package com.bytedance.forest.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.ui.image.f0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    public String A;
    public final com.bytedance.forest.utils.d B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f4431c;
    public volatile WebResourceResponse d;
    public com.bytedance.forest.pollyfill.d e;
    public Map f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f4432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference f4433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile transient SoftReference f4435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4438n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4439o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4440p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Request f4441q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f4442r;
    public final c s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4443t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ResourceFrom f4444u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ResourceFrom f4445v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4446w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4447x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4448y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f4449z;

    public w(Request r5, boolean r10, c r11, String r12, ResourceFrom r13, ResourceFrom r14, boolean r15, boolean r16, boolean r17, long r18, String r19, com.bytedance.forest.utils.d r110) {
        this.f4441q = r5;
        this.f4442r = r10;
        this.s = r11;
        this.f4443t = r12;
        this.f4444u = r13;
        this.f4445v = r14;
        this.f4446w = r15;
        this.f4447x = r16;
        this.f4448y = r17;
        this.f4449z = r18;
        this.A = r19;
        this.B = r110;
        this.f4431c = new ConcurrentHashMap();
    }

    public final WebResourceResponse a(String r10) {
        InputStream r5 = l();
        if (r5 == null) goto L24;
        List r11 = com.bytedance.forest.utils.k.f4646a;
        String r12 = f();
        String r13 = e();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        if (r10 == null) goto L21;
        File r15 = new File(r10);     // Catch: Throwable -> L12
        if (r15.exists() == true) goto L10;
    L14:
        r15 = null;
    L15:
        if (r15 == null) goto L21;
        if (r12 != null) goto L20;
        r12 = com.bytedance.forest.utils.k.c(com.bytedance.forest.utils.k.d(r10, true));     // Catch: Throwable -> L12
    L20:
        return com.bytedance.forest.utils.k.a(r12, r13, r5, r10, null);
    L10:
        if (r15.isDirectory() == true) goto L14;
    L21:
        Result.m124constructorimpl(null);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L24:
        return null;
    }

    public final com.bytedance.forest.pollyfill.l b() {
        com.bytedance.forest.pollyfill.d r5 = this.e;
        if (r5 == null) goto L15;
        int r10 = r5.f4526a;
        if (r10 == 304) goto L7;
        return r5;
    L7:
        Map r11 = this.f;
        if (r11 == null) goto L12;
        Map r12 = MapsKt.toMutableMap(r11);
        if (r12 == null) goto L12;
    L11:
        Map r13 = r12;
        com.bytedance.forest.pollyfill.c r14 = r5.d;
        return new v(r10, r5.f4527b, r13, r14, r5.e);
    L12:
        r12 = new LinkedHashMap();
        goto L11
    L15:
        return null;
    }

    public final String c(ResourceFrom r5) {
        if (r5 == null) goto L34;
        int r10 = r5.ordinal();
        if (r10 == 0) goto L25;
        if (r10 != 1) goto L9;
        return "builtin";
    L9:
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L14;
        return "unknown";
    L14:
        return LynxMonitorService.KEY_MEMORY;
    L17:
        if (this.f4446w == false) goto L20;
        return "cdn_cache";
    L20:
        return "cdn";
    L25:
        if (this.f4440p == false) goto L29;
        return "gecko_offline_cdn";
    L29:
        if (this.f4446w == false) goto L32;
        return "gecko";
    L32:
        return "gecko_update";
    L34:
        return "unknown";
    }

    public final void d(final p r19) {
        if (r19 != null) goto L10;
        p r5 = this.f4432h;
        if (r5 == null) goto L7;
        this.f4433i = new WeakReference(r5);
    L7:
        this.f4432h = null;
        return;
    L10:
        if (this.f4432h != r19) goto L12;
        return;
    L12:
        com.bytedance.forest.utils.h r10 = this.f4441q.getForest().getMemoryManager$forest_release().b(this.f4441q.getCacheKey$forest_release(), this.f4441q.isPreload());
        if (r10 == null) goto L15;
        p r11 = r10.f4625a;
    L17:
        if (r11 == this.f4432h) goto L31;
        com.bytedance.forest.utils.d.c(this.B, 4, "setInMemoryBuffer", null, null, new Response$setInMemoryBuffer$2(this), 24);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L22
        p r13 = this.f4432h;     // Catch: Throwable -> L22
        if (r13 == null) goto L24;
        r13.close();     // Catch: Throwable -> L22
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L25:
        Object r15 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L22
    L28:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L31;
        com.bytedance.forest.utils.d.c(this.B, 6, "setInMemoryBuffer", r16, null, new Response$setInMemoryBuffer$$inlined$onFailure$lambda$1(this), 20);
        goto L31
    L24:
        r14 = null;
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L31:
        com.bytedance.forest.utils.d.c(this.B, 4, "setInMemoryBuffer", null, null, new Response$setInMemoryBuffer$5(this, r19), 24);
        this.f4432h = r19;
        this.f4433i = null;
        return;
    L15:
        r11 = null;
        goto L17
    }

    public final String e() {
        if (this.f4442r == true) goto L5;
        return null;
    L5:
        return this.f4434j;
    }

    public final String f() {
        if (this.f4442r == false) goto L15;
        String r5 = this.g;
        if (r5 != null) goto L7;
    L8:
        String r10 = com.bytedance.forest.utils.k.c(g());
        if (r10 != null) goto L12;
        r10 = "unknown";
    L12:
        this.g = r10;
    L14:
        return this.g;
    L7:
        if (r5.length() != 0) goto L14;
    L15:
        return null;
    }

    public final String g() {
        String r5 = this.f4443t;
        if (r5 == null) goto L11;
        String r10 = com.bytedance.forest.utils.k.d(r5, true);
        if (r10 != null) goto L7;
    L10:
        return r10;
    L7:
        if (StringsKt.g(r10, CDNFetcher.DIR_NAME) != true) goto L10;
        return com.bytedance.forest.utils.k.d(this.f4441q.getOriginUrl(), false);
    L11:
        List r11 = com.bytedance.forest.utils.k.f4646a;
        return com.bytedance.forest.utils.k.d(this.f4441q.getOriginUrl(), false);
    }

    public final CloseableReference h() {
        SoftReference r5 = this.f4435k;
        if (r5 != null) goto L5;
        return null;
    L5:
        return (CloseableReference) r5.get();
    }

    public final p i() {
        p r5 = this.f4432h;
        if (r5 == null) goto L5;
        return r5;
    L5:
        WeakReference r10 = this.f4433i;
        if (r10 != null) goto L8;
        return null;
    L8:
        return (p) r10.get();
    }

    public void j() {
        p r5 = i();     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.tryLoadToMemory$forest_release(this);     // Catch: Throwable -> L6
    L8:
        if (r5 != null) goto L10;
    L11:
        this.f4442r = false;     // Catch: Throwable -> L6
        c r10 = this.s;     // Catch: Throwable -> L6
        ErrorInfo$Type r11 = ErrorInfo$Type.f4309a;     // Catch: Throwable -> L6
        String r12 = "fetch succeeded but IO failed, cache cleared, inMemoryBuffer=" + this.f4432h;     // Catch: Throwable -> L6
        r10.getClass();     // Catch: Throwable -> L6
        r10.f4360a += r10.a(r11, 4, r12);     // Catch: Throwable -> L6
        return;
    L10:
        if (r5.isCacheClear$forest_release() == true) goto L11;
        return;
    L6:
        th = move-exception;
        this.f4442r = false;
        c r13 = this.s;
        r13.getClass();
        r13.f4360a += r13.a(ErrorInfo$Type.f4309a, 4, "fetch succeeded but IO failed, occurred by " + th);
    }

    public byte[] k() {
        if (this.f4442r == true) goto L5;
        return null;
    L5:
        p r5 = i();
        if (r5 == null) goto L11;
        byte[] r10 = r5.provideBytes();
        if (r10 == null) goto L11;
        return r10;
    L11:
        if (this.f4444u != ResourceFrom.d) goto L13;
    L16:
        com.bytedance.forest.utils.h r11 = this.f4441q.getForest().getMemoryManager$forest_release().b(this.f4441q.getCacheKey$forest_release(), this.f4441q.getEnableRequestReuse());
        if (r11 == null) goto L26;
        p r12 = r11.f4625a;
        if (r12 == null) goto L26;
        this.f4432h = r12;
        byte[] r13 = r12.provideBytes();
        if (r13 == null) goto L26;
        if (this.f4441q.getEnableRequestReuse() == false) goto L25;
        this.f4436l = true;
    L25:
        return r13;
    L26:
        p r14 = i();
        if (r14 == null) goto L31;
        this.f4432h = r14;
        byte[] r15 = r14.provideBytes();
        if (r15 == null) goto L31;
        return r15;
    L31:
        p r16 = i();
        if (r16 == null) goto L44;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L38
        r16.tryLoadToMemory$forest_release(this);     // Catch: Throwable -> L38
        byte[] r18 = r16.provideBytes();     // Catch: Throwable -> L38
        if (r18 == null) goto L36;
        return r18;
    L36:
        Object r19 = Result.m124constructorimpl(null);     // Catch: Throwable -> L38
    L40:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 == null) goto L44;
        com.bytedance.forest.utils.d.b(this.B, 6, "provideBytes", "error occurred when provide bytes from buffer", true, r20, null, 32);
    L38:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L44:
        if (this.f4442r == true) goto L47;
        return null;
    L47:
        if (this.f4444u != ResourceFrom.d) goto L49;
        f0.g(112, null, "resource from memory but call loadAsBytes", null);
        c r22 = this.s;
        ErrorInfo$Type r23 = ErrorInfo$Type.f4310b;
        r22.getClass();
        r22.f4360a += r22.a(r23, 2, "resource from memory but call loadAsBytes");
        this.f4444u = this.f4445v;
    L49:
        Forest r24 = this.f4441q.getForest();
        InputStream r25 = l();
        if (r25 != null) goto L70;
        byte[] r26 = null;
    L66:
        if (r26 != null) goto L80;
        r24.getMemoryManager$forest_release().a(this.f4441q.getCacheKey$forest_release());
        return null;
    L80:
        return r26;
    L70:
        r26 = ByteStreamsKt.readBytes(r25);     // Catch: Throwable -> L56
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L59:
        CloseableKt.closeFinally(r25, null);
    L54:
        th = th;
    L74:
        f0.g(112, null, "error occurs when read data", th);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        CloseableKt.closeFinally(r25, th);
        throw th;
    L56:
        th = th;
        r26 = null;
        goto L74
    L13:
        if (this.f4441q.getEnableRequestReuse() == true) goto L16;
        if (this.f4441q.getEnableMemoryCache() == false) goto L31;
        goto L16
    }

    public synchronized InputStream l() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f4442r == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Forest r5 = this.f4441q.getForest();     // Catch: Throwable -> L15
        p r10 = i();     // Catch: Throwable -> L15
        if (r10 == null) goto L21;
        byte[] r11 = r10.provideBytes();     // Catch: Throwable -> L15
        if (r11 == null) goto L17;
        ByteArrayInputStream r12 = new ByteArrayInputStream(r11);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r12;
    L17:
        InputStream r13 = r10.provideInputStream(this);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r13;
    L21:
        if (this.f4441q.getEnableMemoryCache() == false) goto L23;
    L24:
        com.bytedance.forest.utils.h r14 = r5.getMemoryManager$forest_release().b(this.f4441q.getCacheKey$forest_release(), this.f4441q.getEnableRequestReuse());     // Catch: Throwable -> L15
        if (r14 == null) goto L33;
        p r15 = r14.f4625a;     // Catch: Throwable -> L15
        if (r15 == null) goto L33;
        InputStream r16 = r15.provideInputStream(this);     // Catch: Throwable -> L15
        if (r16 == null) goto L33;
        this.f4432h = r15;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r16;
    L33:
        r5.getMemoryManager$forest_release().a(this.f4441q.getCacheKey$forest_release());     // Catch: Throwable -> L15
        String r17 = this.f4443t;     // Catch: Throwable -> L15
        if (r17 != null) goto L57;
    L51:
        this.f4432h = null;     // Catch: Throwable -> L15
        com.bytedance.forest.utils.d.b(this.B, 6, "provideInputStream", "fetch succeeded but IO failed", true, null, null, 48);     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L57:
    L42:
        e = move-exception;
        com.bytedance.forest.utils.d.b(this.B, 6, "provideInputStream", "error occurs when getting input stream from response, file: ".concat(r17), true, e, null, 32);     // Catch: Throwable -> L15
        goto L51
    L36:
        if (this.f4444u != ResourceFrom.f4339b) goto L47;
        Uri r18 = Uri.parse(r17);     // Catch: Throwable -> L15 Exception -> L42
        if (Intrinsics.areEqual(r18.getScheme(), "file") == false) goto L44;
        FileInputStream r19 = new FileInputStream(new File(r18.getPath()));     // Catch: Throwable -> L15 Exception -> L42
        monitor-exit(this);
        return r19;
    L44:
        InputStream r20 = Forest.Companion.getApp().getAssets().open(StringsKt.A(r18.getPath(), "/"));     // Catch: Throwable -> L15 Exception -> L42
        monitor-exit(this);
        return r20;
    L47:
        FileInputStream r21 = new FileInputStream(new File(r17));     // Catch: Throwable -> L15 Exception -> L42
        monitor-exit(this);
        return r21;
    L23:
        if (this.f4441q.getEnableRequestReuse() == false) goto L33;
        goto L24
    }

    public final WebResourceResponse m() {
        WebResourceResponse r5 = null;
        if (this.f4442r == false) goto L35;
        WebResourceResponse r10 = this.d;
        if (r10 == null) goto L8;
        r5 = r10;
        goto L35
    L8:
        ResourceFrom r11 = this.f4444u;
        if (r11 == null) goto L35;
        int r12 = r11.ordinal();
        if (r12 != 0) goto L14;
    L34:
        r5 = a(this.f4443t);
        goto L35
    L14:
        if (r12 != 1) goto L16;
        Uri r13 = Uri.parse(this.f4443t);
        if (Intrinsics.areEqual(r13.getScheme(), "file") == false) goto L23;
        r5 = a(r13.getPath());
        goto L35
    L23:
        List r14 = com.bytedance.forest.utils.k.f4646a;
        AssetManager r15 = Forest.Companion.getApp().getAssets();
        String r16 = StringsKt.A(r13.getPath(), "/");
        if (r15 == null) goto L35;
        if (r16 == null) goto L35;
        if (r16.length() == 0) goto L35;
        String r17 = com.bytedance.forest.utils.k.c(com.bytedance.forest.utils.k.d(r16, true));
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        r5 = com.bytedance.forest.utils.k.a(r17, "", r15.open(r16), r16, null);
        goto L35
    L16:
        if (r12 == 2) goto L34;
        if (r12 == 3) goto L34;
    L35:
        if (r5 != null) goto L45;
    L44:
        return r5;
    L45:
    L39:
        th = move-exception;
        com.bytedance.forest.utils.d.b(this.B, 6, "provideWebResourceResponse", androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("error occur cause by ")), false, null, null, 56);
        goto L44
    L37:
        if (r5.getResponseHeaders() != null) goto L41;
        r5.setResponseHeaders(new LinkedHashMap());     // Catch: Throwable -> L39
    L41:
        Map<String, String> r18 = r5.getResponseHeaders();     // Catch: Throwable -> L39
        r18.put("forest_res_load_start", String.valueOf(this.f4431c.get("res_load_start")));     // Catch: Throwable -> L39
        r18.put("forest_res_load_finish", String.valueOf(this.f4431c.get("res_load_finish")));     // Catch: Throwable -> L39
        r18.put("forest_res_from", c(this.f4444u));     // Catch: Throwable -> L39
        return r5;
    }

    public final String n() {
        return super.toString();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L6
        r5.append(super.toString());     // Catch: Throwable -> L6
        r5.append("(request=");     // Catch: Throwable -> L6
        r5.append(this.f4441q);     // Catch: Throwable -> L6
        r5.append(", isSucceed=");     // Catch: Throwable -> L6
        r5.append(this.f4442r);     // Catch: Throwable -> L6
        r5.append(", errorInfo=");     // Catch: Throwable -> L6
        r5.append(this.s);     // Catch: Throwable -> L6
        r5.append(", filePath=");     // Catch: Throwable -> L6
        r5.append(this.f4443t);     // Catch: Throwable -> L6
        r5.append(", from=");     // Catch: Throwable -> L6
        r5.append(this.f4444u);     // Catch: Throwable -> L6
        r5.append(", originFrom=");     // Catch: Throwable -> L6
        r5.append(this.f4445v);     // Catch: Throwable -> L6
        r5.append(", isCache=");     // Catch: Throwable -> L6
        r5.append(this.f4446w);     // Catch: Throwable -> L6
        r5.append(", version=");     // Catch: Throwable -> L6
        r5.append(this.f4449z);     // Catch: Throwable -> L6
        r5.append(", successFetcher=");     // Catch: Throwable -> L6
        r5.append(this.A);     // Catch: Throwable -> L6
        r5.append(", isCanceled=");     // Catch: Throwable -> L6
        r5.append(this.f4429a);     // Catch: Throwable -> L6
        r5.append(", isRedirection=");     // Catch: Throwable -> L6
        r5.append(this.f4448y);     // Catch: Throwable -> L6
        r5.append(", isNegotiation=");     // Catch: Throwable -> L6
        r5.append(this.f4447x);     // Catch: Throwable -> L6
        r5.append(", httpCode=");     // Catch: Throwable -> L6
        com.bytedance.forest.pollyfill.d r10 = this.e;     // Catch: Throwable -> L6
        p r11 = null;
        if (r10 == null) goto L8;
        Integer r12 = Integer.valueOf(r10.f4526a);     // Catch: Throwable -> L6
    L9:
        r5.append(r12);     // Catch: Throwable -> L6
        r5.append(", webResourceResponse=");     // Catch: Throwable -> L6
        r5.append(this.d);     // Catch: Throwable -> L6
        r5.append("(data=");     // Catch: Throwable -> L6
        WebResourceResponse r13 = this.d;     // Catch: Throwable -> L6
        if (r13 == null) goto L12;
        InputStream r14 = r13.getData();     // Catch: Throwable -> L6
    L13:
        r5.append(r14);     // Catch: Throwable -> L6
        r5.append(", size=");     // Catch: Throwable -> L6
        WebResourceResponse r15 = this.d;     // Catch: Throwable -> L20
        if (r15 == null) goto L22;
        InputStream r16 = r15.getData();     // Catch: Throwable -> L20
        if (r16 == null) goto L22;
        Object r17 = Integer.valueOf(r16.available());     // Catch: Throwable -> L20
    L24:
        r5.append(r17);     // Catch: Throwable -> L6
        r5.append("), image=");     // Catch: Throwable -> L6
        r5.append(h());     // Catch: Throwable -> L6
        r5.append(", inMemoryBuffer=");     // Catch: Throwable -> L6
        r5.append(this.f4432h);     // Catch: Throwable -> L6
        r5.append(", weakReferredBuffer=(");     // Catch: Throwable -> L6
        r5.append(this.f4433i);     // Catch: Throwable -> L6
        r5.append(", ");     // Catch: Throwable -> L6
        WeakReference r18 = this.f4433i;     // Catch: Throwable -> L6
        if (r18 == null) goto L27;
        r11 = (p) r18.get();     // Catch: Throwable -> L6
    L27:
        r5.append(r11);     // Catch: Throwable -> L6
        r5.append("), dataType=");     // Catch: Throwable -> L6
        r5.append(f());     // Catch: Throwable -> L6
        r5.append(", charset=");     // Catch: Throwable -> L6
        r5.append(e());     // Catch: Throwable -> L6
        r5.append(", isPreloaded=");     // Catch: Throwable -> L6
        r5.append(this.f4436l);     // Catch: Throwable -> L6
        r5.append(", isRequestReused=");     // Catch: Throwable -> L6
        r5.append(this.f4437m);     // Catch: Throwable -> L6
        r5.append(", isStreamLoaded=");     // Catch: Throwable -> L6
        r5.append(this.f4438n);     // Catch: Throwable -> L6
        r5.append(')');     // Catch: Throwable -> L6
        return r5.toString();
    L22:
        r17 = null;
    L20:
        th = move-exception;
        r17 = th.getMessage();     // Catch: Throwable -> L6
        goto L24
    L12:
        r14 = null;
        goto L13
    L8:
        r12 = null;
    L6:
        th = move-exception;
        com.bytedance.forest.utils.d.b(this.B, 6, "resp", "Response toString error", true, th, null, 32);
        return super.toString();
    }

    public w(Request r15, com.bytedance.forest.utils.d r16) {
        c r5 = new c();
        r5.f4364i = "";
        r5.f4365j = "";
        r5.f4366k = "";
        r5.f4367l = "";
        r5.f4368m = "";
        r5.f4369n = "";
        r5.f = "";
        r5.f4363h = "";
        this(r15, false, r5, null, null, null, false, false, false, 0, "", r16);
    }

    public w(w r17, com.bytedance.forest.utils.d r18) {
        Request r5 = new Request(r17.f4441q);
        boolean r10 = r17.f4442r;
        c r11 = r17.s;
        String r12 = r17.f4443t;
        ResourceFrom r13 = r17.f4444u;
        ResourceFrom r14 = r17.f4445v;
        boolean r15 = r17.f4446w;
        boolean r16 = r17.f4447x;
        boolean r19 = r17.f4448y;
        long r110 = r17.f4449z;
        String r111 = r17.A;
        if (r18 == null) goto L5;
        com.bytedance.forest.utils.d r112 = r18;
    L6:
        this(r5, r10, r11, r12, r13, r14, r15, r16, r19, r110, r111, r112);
        this.f4429a = r17.f4429a;
        this.f4430b = r17.f4430b;
        this.f4431c.putAll(r17.f4431c);
        this.d = r17.d;
        this.e = r17.e;
        this.f = r17.f;
        this.g = r17.f();
        this.f4432h = r17.f4432h;
        this.f4433i = r17.f4433i;
        this.f4434j = r17.e();
        this.f4435k = r17.f4435k;
        this.f4436l = r17.f4436l;
        this.f4437m = r17.f4437m;
        this.f4439o = r17.f4439o;
        this.f4440p = r17.f4440p;
        return;
    L5:
        r112 = r17.B;
        goto L6
    }
}
