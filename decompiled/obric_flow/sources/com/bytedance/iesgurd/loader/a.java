package com.bytedance.iesgurd.loader;

import ai.j0;
import android.os.AsyncTask;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.geckox.b;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.p;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.iesgurd.IESGurdResFrom;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.d;
import com.bytedance.iesgurd.e;
import com.bytedance.iesgurd.f;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.UltraUpdateResource;
import com.bytedance.keva.Keva;
import com.bytedance.salamander.anniex.n;
import df.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f6633m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6636c;
    public final long d;
    public long e;
    public UltraUpdateResource f;
    public Pair g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f6640k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1 f6641l;

    static {
        f6633m = new ConcurrentHashMap();
    }

    public a(f r5, Function1 r10) {
        this.f6640k = r5;
        this.f6641l = r10;
        this.f6634a = r5.f6624a;
        this.f6635b = r5.f6625b;
        this.f6636c = r5.f6626c;
        this.d = System.currentTimeMillis();
    }

    public static final void e(a r5, JSONObject r10, e r11) {
        r5.getClass();
        r10.put("tag", GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG);
        r10.put("bundle", r5.f6636c);
        if (r11 == null) goto L11;
        r10.put("offline_error_code", r11.f6619a);
        r10.put("offline_error_message", r11.f6620b);
        int r12 = r11.f6621c;
        if (r12 == 0) goto L7;
        r10.put("cdn_error_code", r12);
    L7:
        String r13 = r11.d;
        if (r13 == null) goto L12;
        r10.put("cdn_error_message", r13);
        return;
    L12:
        return;
    }

    public final d a(boolean r15) {
        String r5 = this.f6640k.e;
        String r10 = this.f6634a;
        if (r5 != null) goto L10;
        r5 = (String) c.d.get(r10);
        if (r5 == null) goto L9;
        if (r5.length() != 0) goto L10;
    L9:
        return new d(new e(99, "accesskey dir not register"), null, 0, null, 30);
    L10:
        Keva r11 = com.bytedance.iesgurd.meta.e.f6649a;
        String r12 = this.f6635b;
        ChannelMeta r13 = com.bytedance.iesgurd.meta.e.a(r10, r12);
        if (r13 == null) goto L13;
        Long r14 = r13.getId();
    L14:
        if (r14 != null) goto L44;
        PrepareMeta r16 = com.bytedance.iesgurd.meta.f.a(r10, r12);
        if (r16 == null) goto L42;
        BlockType r17 = r16.getBlockType();
        if (r17 == null) goto L28;
        int r18 = r17.ordinal();
        if (r18 == 0) goto L40;
        if (r18 == 1) goto L38;
        if (r18 == 2) goto L36;
        if (r18 != 3) goto L28;
        return new d(new e(4, "block by occasion update"), null, 0, null, 30);
    L36:
        return new d(new e(3, "block by low storage"), null, 0, null, 30);
    L38:
        return new d(new e(2, "block by clean blocklist"), null, 0, null, 30);
    L40:
        return new d(new e(1, "block by on demand"), null, 0, null, 30);
    L28:
        if (Intrinsics.areEqual(hf.f.f17318b, r10 + '_' + r12) == false) goto L32;
        return new d(new e(12, "updating"), null, 0, null, 30);
    L32:
        return new d(new e(11, "wait update"), null, 0, null, 30);
    L42:
        return new d(new e(10, "prepare meta not exists"), null, 0, null, 30);
    L44:
        if (r13.getForbidden() == true) goto L46;
        File r19 = new File(r5 + '/' + r10 + '/' + r12 + '/' + r14);
        if (r19.exists() == false) goto L50;
        String r110 = this.f6636c;
        if (r15 == true) goto L54;
    L61:
        File r20 = new File(r19, j0.C("res/", r110));
        if (r20.exists() == false) goto L64;
        com.bytedance.geckox.c r21 = b.f4736a;
        com.bytedance.geckox.utils.d.d(r20);     // Catch: Throwable -> L71
        d r111 = new d(null, IESGurdResFrom.f6588b, r14.longValue(), r20.getAbsolutePath(), 16);
        if (r15 == false) goto L70;
        r111.e = new FileInputStream(r20);
    L70:
        return r111;
    L71:
        com.bytedance.geckox.utils.d.f(r20, r10, r12, r110);
        ConcurrentHashMap r112 = com.bytedance.iesgurd.a.f6593a;
        com.bytedance.iesgurd.a.a(r10, r12);
        return new d(new e(16, "file was broken"), null, 0, null, 30);
    L64:
        return new d(new e(15, "bundle file not exists: " + r14 + '-' + r110), null, 0, null, 30);
    L54:
        if (p.d() == false) goto L61;
        File r22 = new File(r19, td.d.b("res/", p.a(r10, r12, r110)));
        if (r22.exists() == false) goto L61;
        d r113 = new d(null, IESGurdResFrom.f6588b, r14.longValue(), r22.getAbsolutePath(), 16);
        if (r15 == false) goto L60;
        r113.e = new GkFSFileInputStream(r22);
    L60:
        return r113;
    L50:
        return new d(new e(14, "version dir not exists: " + r14), null, 0, null, 30);
    L46:
        return new d(new e(13, "local version is forbidden: " + r14), null, 0, null, 30);
    L13:
        r14 = null;
        goto L14
    }

    public final void b() {
        StringBuilder r5 = new StringBuilder("getData: ");
        f r10 = this.f6640k;
        r5.append(r10);
        GeckoLogger.a(r5.toString());
        String r11 = this.f6634a;
        int r12 = r11.length();
        String r13 = this.f6636c;
        String r14 = this.f6635b;
        if (r12 != 0) goto L6;
    L10:
        d(new d(new e(-1, "invalid params: Forest-" + r11 + '-' + r14 + '-' + r13), null, 0, null, 30));
        return;
    L6:
        if (r14.length() == 0) goto L10;
        if (r13.length() == 0) goto L10;
        final d r15 = a(true);
        e r16 = r15.f6616a;
        if (r16 != null) goto L17;
        f("getData", r15);
        d(r15);
        return;
    L17:
        if (r10.d == false) goto L20;
        r16.f6621c = 1;
        r16.d = "only offline";
        d(r15);
        return;
    L20:
        PrepareMeta r17 = com.bytedance.iesgurd.meta.f.a(r11, r14);
        if (r17 != null) goto L23;
        r16.f6621c = 2;
        r16.d = "prepare meta not exists";
    L43:
        f("getData", r15);
        d(r15);
        return;
    L23:
        PrepareMetaPackage r18 = r17.getFullPackage();
        if (r18 == null) goto L26;
        UltraUpdateResource r19 = r18.getUltraUpdateResource();
    L27:
        if (r19 != null) goto L30;
        r16.f6621c = 3;
        r16.d = "ultra resource is null";
        goto L43
    L30:
        if (r19.getSchema().length() != 0) goto L33;
    L42:
        r16.f6621c = 4;
        r16.d = "ultra resource data error: " + r19;
        goto L43
    L33:
        if (r19.getDomains().isEmpty() == true) goto L42;
        if (r19.getResourcePrefix().length() == 0) goto L42;
        this.f = r19;
        this.e = r17.getVersion();
        boolean r20 = g();
        this.f6638i = r20;
        if (r20 == false) goto L40;
        ((Executor) com.bytedance.geckox.utils.c.d.getValue()).execute(new a6.a(this, 23));
    L40:
        this.f6637h = System.currentTimeMillis();
        Lazy r21 = com.bytedance.geckox.utils.c.f4791a;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new com.bytedance.android.monitorV2.executor.a(1, new ResLoader$getData$2(this, r15)));
        return;
    L26:
        r19 = null;
        goto L27
    }

    public final void c(int r10, d r11) {
        UltraUpdateResource r5 = this.f;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resource");
    L5:
        String r12 = r5.getUrl(r10, this.f6635b, this.f6636c);
        GeckoLogger.a("offline_from_cdn，get url: " + r12);
    L11:
        e = move-exception;
        n r13 = new n(e.getStatusCode(), "CronetIOException: " + e.getMessage(), 2);
        u8.a.i(r12, r13, e.getRequestInfo());
    L20:
        int r14 = r13.f7268b;
        boolean r15 = ArraysKt.contains(new Integer[]{400, 404, 412}, Integer.valueOf(r14));
        String r16 = r13.f7269c;
        if (r15 == true) goto L29;
        UltraUpdateResource r17 = this.f;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("resource");
    L26:
        if (r10 >= (r17.getDomains().size() - 1)) goto L29;
        StringBuilder r18 = com.lynx.tasm.utils.e.b("offline_from_cdn，get url failed: ", r12, ", ");
        r18.append(r14);
        r18.append(", ");
        r18.append(r16);
        GeckoLogger.b(r18.toString());
        this.f6639j++;
        c(r10 + 1, r11);
        return;
    L29:
        StringBuilder r19 = com.lynx.tasm.utils.e.b("offline_from_cdn，all url failed: ", r12, ", ");
        r19.append(r14);
        r19.append(", ");
        r19.append(r16);
        GeckoLogger.b(r19.toString());
        e r20 = r11.f6616a;
        if (r20 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        r20.f6621c = r14;
        r11.f6616a.d = r16;
        if (this.f6638i == false) goto L36;
        ((Executor) com.bytedance.geckox.utils.c.d.getValue()).execute(new com.bytedance.apm.e(this, r11, r12, r13));
    L36:
        d(r11);
        return;
    L13:
        e = move-exception;
        r13 = new n(e.getStatusCode(), "HttpResponseException: " + e.getMessage(), 2);
        u8.a.i(r12, r13, null);
    L9:
        th = move-exception;
        r13 = new n(99, androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("unknownException: ")), 2);
        u8.a.i(r12, r13, null);
        goto L20
    L7:
        if (com.bytedance.ttnet.utils.d.c(ta.d.class, r12) != null) goto L16;
        throw null;     // Catch: Throwable -> L9 CronetIOException -> L11 HttpResponseException -> L13
    L16:
        throw new ClassCastException();     // Catch: Throwable -> L9 CronetIOException -> L11 HttpResponseException -> L13
    }

    public final void d(d r5) {
        GeckoLogger.a("ResLoader excuteCallback: " + this.f6640k + ", " + r5);
        this.f6641l.invoke(r5);
    }

    public final void f(String r5, d r10) {
        if (g() == true) goto L5;
        return;
    L5:
        ((Executor) com.bytedance.geckox.utils.c.d.getValue()).execute(new i(this, r10, r5, 11));
    }

    public final boolean g() {
        String r5 = this.f6634a + '@' + this.f6635b;
        ConcurrentHashMap r10 = f6633m;
        Long r11 = (Long) r10.get(r5);
        long r12 = this.d;
        if (r11 != null) goto L5;
    L8:
        r10.put(r5, Long.valueOf(r12));
        return true;
    L5:
        if ((r12 - r11.longValue()) >= 1000) goto L8;
        return false;
    }
}
