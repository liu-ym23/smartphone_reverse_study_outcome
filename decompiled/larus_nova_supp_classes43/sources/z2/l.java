package z2;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.webview.EmbedWebViewService$registerBackPressedInterception$callback$1;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d3.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final /* synthetic */ int n = 0;
    public final Context a;
    public final String b;
    public final d c;
    public c d;
    public WebView e;
    public w f;
    public final q g;
    public View h;
    public WebChromeClient.CustomViewCallback i;
    public int j;
    public int k;
    public Integer l;
    public EmbedWebViewService$registerBackPressedInterception$callback$1 m;

    public static final class a {
    }

    static {
    }

    public final void c() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        Activity r1 = f();
        if (r1 == null) goto L10;
        Window r10 = r1.getWindow();
        if (r10 == null) goto L10;
        View r11 = a(r10);
    L12:
        if ((r11 instanceof ViewGroup) == false) goto L14;
        ViewGroup r12 = (ViewGroup) r11;
    L15:
        if (r12 == null) goto L17;
        r12.removeView(r0);
    L17:
        this.h = null;
        WebChromeClient.CustomViewCallback r13 = this.i;
        if (r13 == null) goto L20;
        r13.onCustomViewHidden();
    L20:
        this.i = null;
        if (r1 == null) goto L27;
        Integer r14 = this.l;
        if (r14 == null) goto L25;
        int r15 = r14.intValue();
    L26:
        r1.setRequestedOrientation(r15);
        goto L27
    L25:
        r15 = 3;
    L27:
        this.l = null;
        WebView r16 = this.e;
        if (r16 == null) goto L31;
        r16.postDelayed(new h(this), 100);
        return;
    L31:
        return;
    L14:
        r12 = null;
    L10:
        r11 = null;
        goto L12
    }

    public final void e() {
        String r0 = Uri.encode(this.a.getString(2131894085));
        WebView r1 = this.e;
        if (r1 == null) goto L6;
        r1.loadDataWithBaseURL("about:blank?message=" + r0, "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"utf-8\">\n<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\">\n<style>\n*{margin:0;padding:0}\nhtml,body{width:100%;height:100%;background:#fff;color:#1f2329}\n@media(prefers-color-scheme:dark){\nhtml,body{background:#1a1a1a;color:rgba(255,255,255,0.9)}\nsvg{opacity:0.9}\n}\nbody{display:flex;align-items:center;justify-content:center}\n.container{display:flex;flex-direction:column;align-items:center}\n.container svg{width:40px;height:40px}\n.container p{margin-top:16px;font-size:17px;text-align:center}\n</style>\n</head>\n<body>\n<div class=\"container\">\n<svg width=\"40\" height=\"40\" viewBox=\"0 0 40 40\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M20.0002 0.833374C30.5856 0.833374 39.1668 9.41458 39.1668 20C39.1668 30.5855 30.5856 39.1667 20.0002 39.1667C9.41471 39.1667 0.833496 30.5855 0.833496 20C0.833496 9.41458 9.41471 0.833374 20.0002 0.833374ZM20.0002 4.16671C11.2557 4.16671 4.16683 11.2555 4.16683 20C4.16683 28.7445 11.2557 35.8334 20.0002 35.8334C28.7447 35.8334 35.8335 28.7445 35.8335 20C35.8335 11.2555 28.7447 4.16671 20.0002 4.16671ZM20.0002 25.1302C21.2888 25.1302 22.3341 26.1756 22.3341 27.4642C22.3338 28.7526 21.2886 29.7966 20.0002 29.7966C18.7118 29.7965 17.6682 28.7525 17.6678 27.4642C17.6678 26.1756 18.7116 25.1303 20.0002 25.1302ZM20.0002 10.2019C21.262 10.2019 22.2697 11.2909 22.2153 12.5961L21.8117 20.6081C21.7695 21.6121 20.9708 22.4034 20.0002 22.4034C19.0296 22.4033 18.2309 21.6121 18.1886 20.6081L17.785 12.5961C17.7306 11.2909 18.7384 10.2019 20.0002 10.2019Z\" fill=\"url(#paint0_linear_9585_15597)\"/><path d=\"M39.1668 20C39.1668 9.5799 30.8516 1.1015 20.4946 0.839233L20.0002 0.833374C9.41471 0.833374 0.833496 9.41458 0.833496 20L0.839355 20.4945C1.09746 30.687 9.3129 38.9022 19.5054 39.1605L20.0002 39.1667C30.4202 39.1665 38.8984 30.8513 39.1606 20.4945L39.1668 20ZM35.3335 20.0004C35.3335 11.5321 28.4687 4.66656 20.0005 4.66638C11.5321 4.66638 4.6665 11.532 4.6665 20.0004C4.66668 28.4686 11.5322 35.3334 20.0005 35.3334L20.0002 35.8334L19.5913 35.8285C11.1715 35.6151 4.38561 28.8284 4.17236 20.4086L4.16683 20C4.16683 11.2555 11.2557 4.16671 20.0002 4.16671L20.4087 4.17224C28.9644 4.38893 35.8335 11.3921 35.8335 20L35.8286 20.4086C35.6119 28.9642 28.6079 35.8332 20.0002 35.8334L20.0005 35.3334C28.4686 35.3332 35.3333 28.4685 35.3335 20.0004ZM22.3341 27.4642C22.3341 26.2561 21.4154 25.2615 20.2388 25.142L20.0002 25.1302C18.7116 25.1303 17.6678 26.1756 17.6678 27.4642L17.6802 27.7025C17.7918 28.8003 18.6635 29.6728 19.7612 29.7845L20.0002 29.7966C21.208 29.7964 22.202 28.8788 22.3218 27.7025L22.3341 27.4642ZM20.0005 9.70154C21.5635 9.70173 22.7806 11.045 22.7153 12.6166L22.7144 12.6185L22.311 20.6302C22.2576 21.8861 21.2536 22.9035 20.0005 22.9037C18.7473 22.9036 17.7424 21.8862 17.689 20.6302L17.2856 12.6185V12.6166C17.2203 11.0449 18.4373 9.70154 20.0005 9.70154ZM20.0002 10.2019C18.7384 10.2019 17.7306 11.2909 17.785 12.5961L18.1886 20.6081C18.2282 21.5495 18.933 22.3034 19.8208 22.3939L20.0002 22.4034C20.9708 22.4034 21.7695 21.6121 21.8117 20.6081L22.2153 12.5961C22.2663 11.3725 21.3839 10.3388 20.2339 10.2142L20.0002 10.2019ZM22.8345 27.4642C22.834 29.0288 21.5646 30.2961 20.0005 30.2963C18.4359 30.2962 17.1679 29.0285 17.1675 27.4642C17.1675 25.8999 18.4354 24.6304 20.0005 24.6302C21.5651 24.6304 22.8345 25.8995 22.8345 27.4642ZM39.6665 20.0004C39.6663 30.8617 30.8618 39.6662 20.0005 39.6664C9.139 39.6664 0.333672 30.8618 0.333496 20.0004C0.333496 9.13877 9.13889 0.333374 20.0005 0.333374C30.8619 0.33355 39.6665 9.13888 39.6665 20.0004Z\" fill=\"url(#paint1_linear_9585_15597)\"/><defs><linearGradient id=\"paint0_linear_9585_15597\" x1=\"20.0001\" y1=\"-6.44021\" x2=\"20.0001\" y2=\"46.4396\" gradientUnits=\"userSpaceOnUse\"><stop stop-color=\"#B1B1B1\"/><stop offset=\"0.971154\" stop-color=\"#B1B1B1\" stop-opacity=\"0.3\"/></linearGradient><linearGradient id=\"paint1_linear_9585_15597\" x1=\"20.0001\" y1=\"-6.44021\" x2=\"20.0001\" y2=\"46.4396\" gradientUnits=\"userSpaceOnUse\"><stop stop-color=\"#B1B1B1\"/><stop offset=\"0.971154\" stop-color=\"#B1B1B1\" stop-opacity=\"0.3\"/></linearGradient></defs></svg>\n<p id=\"msg\"></p>\n</div>\n<script>\n(function(){\nvar p = new URLSearchParams(window.location.search);\nvar m = p.get('message');\nif (m) document.getElementById('msg').textContent = m;\n})();\n</script>\n</body>\n</html>", "text/html", "utf-8", null);
        return;
    }

    public final Activity f() {
        Context r0 = this.a;
    L4:
        if (r0 == null) goto L16;
        if ((r0 instanceof Activity) == true) goto L8;
        if ((r0 instanceof ContextWrapper) == false) goto L12;
        ContextWrapper r1 = (ContextWrapper) r0;
    L13:
        if (r1 != null) goto L14;
        r0 = null;
        goto L4
    L14:
        r0 = r1.getBaseContext();
        goto L4
    L12:
        r1 = null;
        goto L13
    L8:
        return (Activity) r0;
    L16:
        return null;
    }

    public static View a(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static void b(PermissionRequest r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(102606);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r19 = r16;
        int r110 = r14;
        f06.d r20 = r17.preInvoke(102606, "android/webkit/PermissionRequest", "deny", r18, r10, "void", r11);     // Catch: Exception -> L21
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L21
    L17:
        if (r20.a == false) goto L19;
        return;
    L19:
        r18.deny();
        return;
    L14:
        r16 = r19 + 1;
        r14 = r110;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public final boolean d(String r12) {
        d r0 = this.c;
        if (r0 != null) goto L84;
        return true;
    L84:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl(Boolean.valueOf(r0.a()));     // Catch: Throwable -> L7
    L9:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r11) == false) goto L13;
        r11 = r13;
    L13:
        if (((Boolean) r11).booleanValue() == false) goto L16;
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("ai_bridge", "[EmbedWebViewService] domain verify bypassed (debug), url:".concat(o.a(r12)), null);
        return true;
    L16:
        String r14 = this.g.getAppletId();
        Boolean r15 = r0.g(r14);
        if (r15 != null) goto L19;
        com.bytedance.ai.applet.base.log.b r16 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] webview blocked: no policy, appKey:" + r14 + ", url:" + o.a(r12), null);
        return false;
    L19:
        if (r15.booleanValue() == true) goto L21;
        return true;
    L21:
        Uri r17 = UriProtector.parse(r12);
        if (r17 != null) goto L24;
        return false;
    L24:
        String r18 = r17.getScheme();
        if (r18 == null) goto L81;
        Locale r19 = Locale.ROOT;
        String r20 = r18.toLowerCase(r19);
        if (r20 == null) goto L81;
        if (Intrinsics.areEqual(r20, "about") == false) goto L32;
    L80:
        return true;
    L32:
        if (Intrinsics.areEqual(r20, "blob") == true) goto L80;
        if (Intrinsics.areEqual(r20, "https") == true) goto L37;
        return false;
    L37:
        Set<String> r21 = r0.f(r14);
        Set<String> r22 = r21;
        if (r22 != null) goto L40;
    L43:
        boolean r23 = true;
    L44:
        if (r23 == false) goto L47;
        com.bytedance.ai.applet.base.log.b r24 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] webview blocked: whitelist empty, appKey:" + r14 + ", url:" + o.a(r12), null);
        return false;
    L47:
        String r110 = r17.getHost();
        if (r110 == null) goto L79;
        String r111 = r110.toLowerCase(r19);
        if (r111 == null) goto L79;
        int r25 = r17.getPort();
        if (r25 <= 0) goto L55;
        r111 = r111 + ':' + r25;
    L55:
        Set<String> r26 = r21;
        if ((r26 instanceof Collection) == true) goto L58;
    L60:
        Iterator<T> r27 = r26.iterator();
    L62:
        if (r27.hasNext() == false) goto L77;
        Uri r28 = UriProtector.parse((String) r27.next());
        if (r28 == null) goto L74;
        String r29 = r28.getHost();
        if (r29 == null) goto L74;
        String r30 = r29.toLowerCase(Locale.ROOT);
        if (r30 == null) goto L74;
        int r31 = r28.getPort();
        if (r31 <= 0) goto L73;
        r30 = r30 + ':' + r31;
    L73:
        boolean r32 = Intrinsics.areEqual(r111, r30);
    L75:
        if (r32 == false) goto L62;
        return true;
    L74:
        r32 = false;
    L77:
        return false;
    L58:
        if (r26.isEmpty() == false) goto L60;
    L79:
        return false;
    L40:
        if (r22.isEmpty() == true) goto L43;
        r23 = false;
    L81:
        return false;
    L7:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [z2.k] */
    public l(Context r10, String r11, a3.a r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "hostAppName");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.g = new q(new k(this));
    }
}
