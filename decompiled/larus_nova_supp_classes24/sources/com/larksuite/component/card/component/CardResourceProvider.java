package com.larksuite.component.card.component;

import android.webkit.URLUtil;
import androidx.collection.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.component.card.component.res.LynxResourceFetcher;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import d8a.k;
import java.io.IOException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardResourceProvider extends k<Object, byte[]> {
    public final Lazy<LynxResourceFetcher> a;

    public static final class a {
    }

    public static final class b implements Callback {
        public final /* synthetic */ LynxResourceCallback<byte[]> a;

        public final void onFailure(Call r2, IOException r3) {
            Intrinsics.checkNotNullParameter(r2, "call");
            Intrinsics.checkNotNullParameter(r3, "e");
        }

        public b(LynxResourceCallback<byte[]> r1) {
            this.a = r1;
        }

        public final void onResponse(Call r2, Response r3) {
            Intrinsics.checkNotNullParameter(r2, "call");
            Intrinsics.checkNotNullParameter(r3, "response");
            if (r3.isSuccessful() == false) goto L10;
            LynxResourceCallback<byte[]> r4 = this.a;
            ResponseBody r5 = r3.body();
            if (r5 == null) goto L7;
            byte[] r6 = r5.bytes();
        L8:
            r4.onResponse(LynxResourceResponse.success(r6));
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CardResourceProvider a;
        public final /* synthetic */ LynxResourceRequest<Object> b;
        public final /* synthetic */ LynxResourceCallback<byte[]> c;

        public c(CardResourceProvider r1, LynxResourceRequest<Object> r2, LynxResourceCallback<byte[]> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (idb.f.a().isCurrentEnable("openplatform.universalcard.js_fetch") == false) goto L35;
            LynxResourceFetcher r0 = (LynxResourceFetcher) this.a.a.getValue();
            String r1 = this.b.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "path");
            OPTrace r2 = gyb.a.a();
            int r3 = UniversalCardMonitorUtils.a;
            Intrinsics.checkNotNullParameter(r1, "path");
            Intrinsics.checkNotNullParameter(r2, "trace");
            fyb.e r4 = com.larksuite.component.card.monitor.b.a;
            com.larksuite.component.card.monitor.b.c.a(ncb.c.o).addCategoryValue("js_path", r1).tracing(r2).flush();
            long r5 = System.currentTimeMillis();
            Log.i("LynxResourceFetcher", "fetch res ".concat(r1));
            LruCache<String, byte[]> r6 = LynxResourceFetcher.a;
            LynxResourceFetcher.a.a(r1);
            Unit r7 = Unit.INSTANCE;
            monitor-enter(r7);     // Catch: Throwable -> L32
            Object r8 = null;
            byte[] r9 = LynxResourceFetcher.a(r1);     // Catch: Throwable -> L20 Exception -> L22
            if (r9 == null) goto L10;
            UniversalCardMonitorUtils.d(r1, r5, "local", r2);     // Catch: Throwable -> L20
            r8 = r9;
        L18:
            monitor-exit(r7);     // Catch: Throwable -> L32
        L26:
            LynxResourceFetcher.a.b(r1);
            if (r8 == null) goto L29;
            this.c.onResponse(LynxResourceResponse.success(r8));
            Log.i("CardResourceProvider", "load lynx js from fetcher");
            return;
        L29:
            CardResourceProvider.b(this.a, this.b, this.c, true);
            return;
        L10:
            Log.i("LynxResourceFetcher", "fetch remote ".concat(r1));     // Catch: Throwable -> L20
            Object r10 = LynxResourceFetcher.b(r1);     // Catch: Throwable -> L20
            if (Result.isSuccess-impl(r10) == false) goto L17;
            UniversalCardMonitorUtils.d(r1, r5, "remote", r2);     // Catch: Throwable -> L20
            if (Result.isFailure-impl(r10) == true) goto L16;
            r8 = r10;
        L16:
            r8 = (byte[]) r8;     // Catch: Throwable -> L20
            goto L18
        L17:
            UniversalCardMonitorUtils.c(r1, r5, Result.exceptionOrNull-impl(r10), r2);     // Catch: Throwable -> L20
            goto L18
        L22:
            e = move-exception;
            Log.e("LynxResourceFetcher", e);     // Catch: Throwable -> L20
            LruCache<String, byte[]> r11 = LynxResourceFetcher.a;
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            LruCache<String, byte[]> r12 = LynxResourceFetcher.a;
            LynxResourceFetcher.a.b(r1);
            throw th;
        L35:
            CardResourceProvider.b(this.a, this.b, this.c, false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public CardResourceProvider() {
        this.a = LazyKt.lazy(CardResourceProvider$resourceFetcher$1.INSTANCE);
    }

    public final void cancel(LynxResourceRequest<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        super.cancel(r2);
    }

    public final void c(LynxResourceRequest<Object> r3, LynxResourceCallback<byte[]> r4) {
        if (URLUtil.isNetworkUrl(r3.a) == true) goto L5;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(this, r3, r4));
        return;
    L5:
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L9;
        new OkHttpClient.Builder().build().newCall(new Request.Builder().url(r3.a).build()).enqueue(new b(r4));
        return;
    }

    public final void request(LynxResourceRequest<Object> r2, LynxResourceCallback<byte[]> r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "callback");
        c(r2, r3);
    }

    public final void request(LynxResourceRequest<Object> r1, LynxResourceCallback<byte[]> r2, LynxContext r3) {
        Intrinsics.checkNotNullParameter(r1, "request");
        Intrinsics.checkNotNullParameter(r2, "callback");
        c(r1, r2);
    }

    public static final void b(CardResourceProvider r2, LynxResourceRequest r3, LynxResourceCallback r4, boolean r5) {
        r2.getClass();
        UniversalCardRuntimeJsLoader.b r1 = new UniversalCardRuntimeJsLoader().a();     // Catch: Exception -> L16
        if (r1 == null) goto L8;
        Map<String, String> r6 = r1.b;     // Catch: Exception -> L16
        if (r6 == null) goto L8;
        String r7 = r6.get(r3.a);     // Catch: Exception -> L16
    L9:
        Log.i("CardResourceProvider", "loadJsFile url: " + r7 + ", file " + r7);     // Catch: Exception -> L16
        if (r7 == null) goto L21;
        if (r5 == false) goto L13;
        byte[] r8 = VFSFiles.b.i(r7).readBytes();     // Catch: Exception -> L16
    L14:
        r4.onResponse(LynxResourceResponse.success(r8));     // Catch: Exception -> L16
        return;
    L13:
        r8 = Okio.buffer(Okio.source(new PolarisFileWrapper(r7))).readByteArray();     // Catch: Exception -> L16
        goto L14
    L21:
        return;
    L8:
        r7 = null;
    L16:
        e = move-exception;
        Log.e("CardResourceProvider", e);
    }
}
