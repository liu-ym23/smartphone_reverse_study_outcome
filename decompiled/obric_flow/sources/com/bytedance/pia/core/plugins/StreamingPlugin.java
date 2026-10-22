package com.bytedance.pia.core.plugins;

import ai.j0;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.a;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.b;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.lynx.tasm.p;
import dh.f;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import nh.d;
import rh.g;
import rh.i;

/* JADX INFO: loaded from: classes2.dex */
public class StreamingPlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f7049c;
    public final CountDownLatch d;
    public volatile String e;
    public volatile boolean f;
    public volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference f7050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f7051i;

    public static class Module extends JSModule {
        private static final String CHUNK_END_MARK = "<!-- chunk end -->";
        public static final String NAME = "StreamingModule";
        private String chunkCache;
        private final StreamingPlugin plugin;

        public Module(Context r5, Object r10) {
            super(r5, r10);
            this.chunkCache = "";
            this.plugin = (StreamingPlugin) r10;
        }

        @b
        public void appendBody(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L5;
            return;
        L5:
            int r5 = r10.lastIndexOf(CHUNK_END_MARK);
            if (r5 != (-1)) goto L9;
            this.chunkCache = j0.q(new StringBuilder(), this.chunkCache, r10);
            return;
        L9:
            StreamingPlugin r11 = this.plugin;
            String r12 = this.chunkCache + r10.substring(0, r5);
            monitor-enter(r11);
        L18:
            th = move-exception;
            throw th;
        L12:
            if (r11.g == false) goto L16;
            monitor-exit(r11);
        L22:
            this.chunkCache = r10.substring(r5 + 18);
            return;
        L16:
            if (r11.f == false) goto L20;
            r11.f7051i.c(r12);     // Catch: Throwable -> L18
        L21:
            monitor-exit(r11);     // Catch: Throwable -> L18
            goto L22
        L20:
            r11.e += r12;     // Catch: Throwable -> L18
            r11.d.countDown();     // Catch: Throwable -> L18
            goto L21
        }

        @b
        public void appendHeaders(ReadableMap r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            HashMap r5 = new HashMap();
            ReadableMapKeySetIterator r11 = r10.keySetIterator();
        L6:
            if (r11.hasNextKey() == false) goto L10;
            String r12 = r11.nextKey();
            if (r10.getType(r12) != ReadableType.String) goto L6;
            r5.put(r12, r10.getString(r12));
            goto L6
        L10:
            StreamingPlugin r13 = this.plugin;
            monitor-enter(r13);
        L19:
            th = move-exception;
            throw th;
        L13:
            if (r13.g == false) goto L17;
            monitor-exit(r13);
            return;
        L17:
            if (r13.f == false) goto L21;
            Intrinsics.checkNotNullParameter("[Streaming] Can't append headers after responded!", "message");     // Catch: Throwable -> L19
            j.x("[Streaming] Can't append headers after responded!", null);     // Catch: Throwable -> L19
        L22:
            monitor-exit(r13);     // Catch: Throwable -> L19
            return;
        L21:
            r13.f7049c.putAll(r5);     // Catch: Throwable -> L19
            goto L22
        }

        @b
        public void finish() {
        }
    }

    public StreamingPlugin(d r5) {
        super(r5);
        this.f7049c = new HashMap();
        this.d = new CountDownLatch(1);
        this.e = "";
        this.f = false;
        this.g = false;
        this.f7050h = new AtomicReference(null);
        this.f7051i = new a();
    }

    @Override // nh.c
    public final f a(ym.j r10) {
        if (((WebResourceRequest) r10.f23302a).isForMainFrame() == false) goto L47;
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (this.g == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return null;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(this.e) == true) goto L53;
        boolean r11 = false;
    L27:
        if (TextUtils.isEmpty(this.e) == true) goto L38;
        if (r11 == true) goto L38;
        monitor-enter(this);
        this.f = true;     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        return new mh.j(this.e, this.f7049c);
    L35:
        th = move-exception;
        throw th;
    L38:
        monitor-enter(this);
        this.g = true;     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L42
        return null;
    L42:
        th = move-exception;
        throw th;
    L53:
        CountDownLatch r12 = this.d;     // Catch: Throwable -> L16
        Lazy r5 = Settings.B;     // Catch: Throwable -> L16
        r11 = !r12.await(p.a().k(), TimeUnit.SECONDS);
    L16:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Streaming] intercept html failed, error:", "message");
        j.x("[Streaming] intercept html failed, error:", th);
        monitor-enter(this);
        this.g = true;     // Catch: Throwable -> L22
        return null;
    L22:
        th = move-exception;
        throw th;
    L47:
        return null;
    }

    @Override // nh.c
    public final String c() {
        return "streaming";
    }

    @Override // nh.c
    public final void f() {
        rh.f r5 = new rh.f();
        d r10 = this.f20236b;
        r5.f21749c = r10;
        r5.f21750h = "streaming";
        r5.f21747a = r10.g.toString();
        r5.f21748b = r10.d.b();
        r5.f21751i = r10.f20244o;
        g r11 = r5.a();
        if (r11 == null) goto L12;
        i r12 = new i(r11);     // Catch: Throwable -> L7
        r12.c(new mh.i(this, 0));     // Catch: Throwable -> L7
        r12.f21770o.b(Module.class, this, Module.NAME);     // Catch: Throwable -> L7
        r12.h();     // Catch: Throwable -> L7
        r10.b(r12, "streaming-worker");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Streaming] create streaming worker error:", "message");
        j.x("[Streaming] create streaming worker error:", th);
        return;
    }

    @Override // nh.c
    public final void g() {
        View r5 = this.f20236b.c();
        if ((r5 instanceof WebView) == true) goto L5;
        return;
    L5:
        m.a(new kh.b(4, this, (WebView) r5));
    }

    @Override // nh.c, fh.c
    public final void release() {
        this.d.countDown();
    }
}
