package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import android.webkit.WebView;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final b a;
    public final String b;
    public int c;
    public long d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final long c;
        public final Function1<WebView, Boolean> d;
        public final Function0<Unit> e;
        public final Function0<Unit> f;
        public final Function0<Unit> g;
        public final Function2<String, JSONObject, Unit> h;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            long r1 = this.c;
            return ((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        }

        public final String toString() {
            return "Config(webViewType=" + this.a + ", maxRecreateCount=" + this.b + ", cooldownMs=" + this.c + ", isCurrentWebView=" + this.d + ", onRenderGone=" + this.e + ", onRecreate=" + this.f + ", onMaxRetryReached=" + this.g + ", onTrackEvent=" + this.h + ')';
        }

        public b(String r2, int r3, Function1 r4, Function0 r5, Function0 r6, Function0 r7, Function2 r8) {
            Intrinsics.checkNotNullParameter(r2, "webViewType");
            Intrinsics.checkNotNullParameter(r4, "isCurrentWebView");
            Intrinsics.checkNotNullParameter(r5, "onRenderGone");
            Intrinsics.checkNotNullParameter(r6, "onRecreate");
            Intrinsics.checkNotNullParameter(r7, "onMaxRetryReached");
            Intrinsics.checkNotNullParameter(r8, "onTrackEvent");
            this.a = r2;
            this.b = r3;
            this.c = MmUploadRetryConfigSetting.MAX_INTERVAL_MS;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    static {
    }

    public final void a() {
        lvb.a.e(this.b, "[onResume] isInBackground=" + this.e + ", needRecreateOnResume=" + this.f + ", currentCount=" + this.c);
        this.e = false;
        if (this.c <= 0) goto L6;
        lvb.a.e(this.b, "[onResume] reset recreate count from " + this.c + " to 0");
        this.c = 0;
    L6:
        if (this.f == false) goto L9;
        this.f = false;
        b();
        return;
    }

    public final void b() {
        this.d = System.currentTimeMillis();
        this.c++;
        lvb.a.e(this.b, "[recreateWebView] start recreate, count=" + this.c);
        this.a.f.invoke();
        lvb.a.e(this.b, "[recreateWebView] recreate completed");
    }

    public e(b r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r3;
        this.b = "MmWebViewRenderGoneHandler_" + r3.a;
        this.e = true;
    }
}
