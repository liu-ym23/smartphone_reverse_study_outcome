package com.bytedance.sdk.xbridge.cn.platform.web;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.pia.core.utils.n;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f7418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SSWebView f7419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f7420c;
    public final Handler d;
    public volatile boolean e;
    public final String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AuthUrlSourceType f7421h;

    public e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        this.f7418a = LazyKt.lazy(WebBridgeProtocol$bridgeHandler$2.f7384a);
        this.d = new Handler(Looper.getMainLooper());
        this.f = r5;
        this.f7421h = AuthUrlSourceType.f7446c;
    }

    public final b a() {
        b r5 = this.f7420c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bdxBridge");
        return null;
    }

    public abstract c b(String r5);

    public abstract String c(c r5, JSONObject r10);

    public abstract void d(SSWebView r5);

    public final void e(String r5, n r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        i(r5, r10);
        return;
    L6:
        this.d.post(new com.bytedance.android.anniex.scene.core.i(this, 12, r5, r10));
    }

    public abstract void f(String r5, JSONObject r10);

    public final String g() {
        SSWebView r5 = j();
        if (r5 != null) goto L5;
    L21:
        return null;
    L5:
        if (r5.f5482o == false) goto L21;
        if (this.e == false) goto L9;
    L19:
        ki.a.a("webview已销毁或未初始化，无法获取");
        return "unknown:destroyed or not initialize";
    L9:
        if (this.f7419b == null) goto L19;
        String r10 = r5.getXSafeUrl();
        this.f7421h = r5.getAuthUrlSourceType();
        if (TextUtils.isEmpty(r10) == true) goto L14;
        return r10;
    L14:
        SSWebView r11 = j();
        if (r11 != null) goto L17;
        return null;
    L17:
        return r11.getUrl();
    }

    public final void h(String r5) {
        if (this.e == false) goto L7;
        ki.a.a("webview已销毁，handleJSMessage未执行");
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        k(r5);
        return;
    L10:
        this.d.post(new ab.b(16, this, r5));
    }

    public final void i(String r5, n r10) {
        if (this.e == false) goto L7;
        ki.a.a("webview已销毁，evaluateJavaScriptInternal未执行，url: " + r5);
        return;
    L7:
        if (this.f7419b != null) goto L15;
        ki.a.a("webview对象未初始化，evaluateJavaScriptInternal未执行");
        return;
    L15:
        j().evaluateJavascript(r5, r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        ki.a.a("webview.evaluateJavascript失败：" + th.getMessage());
    }

    public final SSWebView j() {
        SSWebView r5 = this.f7419b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    public final void k(String r5) {
        if (r5 != null) goto L5;
        String r10 = "{}";
    L6:
        c r11 = b(r10);
        com.bytedance.ies.bullet.kit.web.impl.d r12 = new com.bytedance.ies.bullet.kit.web.impl.d(r11, this);
        if (r5 != null) goto L9;
    L20:
        r12.c(((a) this.f7418a.getValue()).c(r11, 0, "invoke msg is empty"));
        return;
    L9:
        if (r5.length() == 0) goto L20;
        if (Intrinsics.areEqual(r5, "{}") == true) goto L20;
        if (Intrinsics.areEqual(a().f7417r, Boolean.TRUE) == false) goto L18;
        a().m(r11, r12);
        return;
    L18:
        a().l(r11, r12);
        return;
    L5:
        r10 = r5;
        goto L6
    }

    public final String l() {
    L6:
        th = move-exception;
        ki.a.a("get url failed: " + th.getMessage());
        return androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("unknown: exception: "));
    L4:
        if (TextUtils.isEmpty(this.g) == true) goto L8;
        ki.a.a("GetWebViewUrlSync: from V1 protocol, " + this.g + ' ');     // Catch: Throwable -> L6
        String r5 = this.g;     // Catch: Throwable -> L6
    L9:
        if (r5 == null) goto L12;
        return r5;
    L12:
        if (this.e == false) goto L14;
        return "unknown:destroyed or not initialize";
    L14:
        if (this.f7419b == null) goto L28;
        SSWebView r10 = j();     // Catch: Throwable -> L6
        if (r10 == null) goto L20;
        return r10.getUrl();
    L20:
        return null;
    L28:
        return "unknown:destroyed or not initialize";
    L8:
        r5 = g();     // Catch: Throwable -> L6
        goto L9
    }

    public void m(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
    }

    public void n(String r5) {
    }
}
