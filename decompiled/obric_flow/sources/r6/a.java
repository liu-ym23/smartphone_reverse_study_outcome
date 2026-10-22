package r6;

import ai.j0;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.n;
import com.lynx.react.bridge.Callback;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.indicator.u;
import hn.c;
import hn.f;
import j1.e;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rl.b;
import z.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d, Callback, f, ol.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f21694b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f21695a;

    public /* synthetic */ a(Object r5) {
        this.f21695a = r5;
    }

    @Override // hn.f
    public void a(boolean r5) {
        if (r5 == false) goto L5;
        ((c) this.f21695a).a(0);
        return;
    }

    @Override // ol.d
    public boolean b(String r5) {
        e r10 = (e) this.f21695a;
        if (r5 != null) goto L5;
    L16:
        a1.c r11 = r10.f18225b;
        AtomicInteger r12 = a1.c.f44c;
        r11.b("shouldOverrideUrlLoading url is empty", null);
        return false;
    L5:
        if (r5.length() == 0) goto L16;
        if (StringsKt.P(r5, "http") == false) goto L18;
        return false;
    L18:
        r10.f18225b.a("shouldOverrideUrlLoading http url:".concat(r5));     // Catch: Exception -> L11
        Intent r13 = new Intent("android.intent.action.VIEW", Uri.parse(r5));     // Catch: Exception -> L11
        r13.setFlags(805306368);     // Catch: Exception -> L11
        r10.f18224a.startActivity(r13);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        r10.f18225b.b("shouldOverrideUrlLoading http url:".concat(r5), e);
        return true;
    }

    @Override // ol.d
    public void c(sj.e r5) {
        AtomicInteger r10 = a1.c.f44c;
        ((e) this.f21695a).f18225b.b("onRenderProcessGone: " + r5, null);
    }

    @Override // ol.d
    public b d(b r5) {
        Intrinsics.checkNotNullParameter(r5, "before");
        return r5;
    }

    public String e() {
        String r5 = "0";
        if (TextUtils.isEmpty((String) this.f21695a) == false) goto L5;
    L8:
        i4.a r10 = n.d();
        r10.getClass();
        String r11 = ((ICommonParams) r10.f17503c).getDeviceId();     // Catch: Throwable -> L11
    L12:
        this.f21695a = r11;
        if (TextUtils.isEmpty(r11) == false) goto L15;
    L21:
        com.bytedance.ies.argus.bean.b r12 = com.bytedance.ies.argus.bean.b.a();
        r12.getClass();
        String r13 = cl.a.D(((File) r12.d).getAbsolutePath());     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r13) == true) goto L25;
        r5 = r13;
    L25:
        this.f21695a = r5;
        return r5;
    L15:
        if ("0".equals((String) this.f21695a) == true) goto L21;
        String r14 = (String) this.f21695a;
        this.f21695a = r14;
        com.bytedance.ies.argus.bean.b r15 = com.bytedance.ies.argus.bean.b.a();
        r15.getClass();
        cl.a.u(r14, (File) r15.d, false);     // Catch: Throwable -> L27
    L20:
        return (String) this.f21695a;
    L11:
        r11 = "";
        goto L12
    L5:
        if ("0".equals((String) this.f21695a) == true) goto L8;
        return (String) this.f21695a;
    }

    @Override // ol.d
    public void f(WebView r5, String r10) {
        e r11 = (e) this.f21695a;
        if (r11.f18226c.e == null) goto L10;
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r10, "url");
        String r12 = "onPageFinished ".concat(r10);
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L11;
        r13.i("AppletWidgetContainer", r12);
        return;
    L11:
        return;
    }

    public void g(Class r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        com.bytedance.android.monitorV2.settings.b r11 = new com.bytedance.android.monitorV2.settings.b();
        r11.f3719a = r10;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r11, "provider");
        ConcurrentHashMap r12 = (ConcurrentHashMap) this.f21695a;
        com.bytedance.android.monitorV2.settings.b r13 = (com.bytedance.android.monitorV2.settings.b) r12.get(r5);
        if (r13 != null) goto L5;
    L9:
        r12.put(r5, r11);
        return;
    L5:
        if (r13 != r11) goto L7;
        r13 = null;
    L7:
        if (r13 == null) goto L9;
        r13.f3719a = null;
        goto L9
    }

    public long h() {
        v6.e r10 = (v6.e) this.f21695a;
        r10.b();
        long r5 = r10.f22529c + r10.e;
        r10.b();
        return (r10.f22528b + r10.d) + r5;
    }

    @Override // ol.d
    public void i(String r5, int r10, String r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        r11 = "unknown-source";
    L7:
        a1.c r12 = ((e) this.f21695a).f18225b;
        String r13 = "[console]\"" + r5 + "\", source: " + r11 + '(' + r10 + ')';
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "msg");
        String r14 = "[" + r12.f46b + "] " + r13;
        String r15 = r12.f45a;
        Intrinsics.checkNotNullParameter(r15, "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        a1.a.f43a.d(r15, r14);
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object... r5) {
        Intrinsics.checkNotNullParameter(r5, "args");
        com.bytedance.ies.bullet.core.kit.bridge.Callback r10 = (com.bytedance.ies.bullet.core.kit.bridge.Callback) this.f21695a;
        if (r10 == null) goto L6;
        r10.invoke(new Object[]{r5});
        return;
    }

    @Override // ol.d
    public void j(WebResourceRequest r5, WebResourceError r10) {
        e r11 = (e) this.f21695a;
        Object r12 = null;
        if (r10 != null) goto L5;
    L11:
        if (r5 == null) goto L15;
        Uri r13 = r5.getUrl();
        if (r13 == null) goto L15;
        String r14 = r13.getLastPathSegment();
    L17:
        if (Intrinsics.areEqual(r14, "favicon.ico") == true) goto L36;
        StringBuilder r15 = new StringBuilder("Request: ");
        if (r5 == null) goto L21;
        Uri r16 = r5.getUrl();
    L22:
        r15.append(r16);
        r15.append(", error: ");
        if (r10 == null) goto L25;
        CharSequence r17 = r10.getDescription();
    L26:
        r15.append(r17);
        r15.append(" code: ");
        if (r10 == null) goto L29;
        r12 = Integer.valueOf(r10.getErrorCode());
    L29:
        r15.append(r12);
        String r18 = r15.toString();
        g1.c r19 = r11.f18226c.e;
        if (r19 == null) goto L37;
        if (r10 == null) goto L33;
        int r20 = r10.getErrorCode();
    L34:
        ((com.bytedance.ai.widget.contianer.d) r19).b(r11, false, r20, r18);
        return;
    L33:
        r20 = 403;
        goto L34
    L37:
        return;
    L25:
        r17 = null;
        goto L26
    L21:
        r16 = null;
        goto L22
    L36:
        return;
    L15:
        r14 = null;
        goto L17
    L5:
        if (r10.getErrorCode() != (-1)) goto L11;
        a1.c r21 = r11.f18225b;
        StringBuilder r22 = new StringBuilder("onReceivedError url=");
        if (r5 == null) goto L9;
        r12 = r5.getUrl();
    L9:
        r22.append(r12);
        r22.append(" error=");
        r22.append(r10.getErrorCode());
        r22.append(' ');
        r22.append(r10.getDescription());
        String r23 = r22.toString();
        AtomicInteger r24 = a1.c.f44c;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r23, "msg");
        String r25 = "[" + r21.f46b + "] " + r23;
        String r26 = r21.f45a;
        Intrinsics.checkNotNullParameter(r26, "tag");
        Intrinsics.checkNotNullParameter(r25, "msg");
        a1.a.f43a.w(r26, r25);
    }

    public com.drakeet.multitype.b k(int r5) {
        Object r10 = ((List) this.f21695a).get(r5);
        if (r10 == null) goto L7;
        return (com.drakeet.multitype.b) r10;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.drakeet.multitype.Type<T>");
    }

    public void l(float r10, int r11) {
        OCarouselIndicator r12 = (OCarouselIndicator) this.f21695a;
        int r5 = r12.g();
        u r13 = null;
        if (r5 > 0) goto L6;
        String r14 = Intrinsics.stringPlus("Ignore onPageScrolled because pageCount=", Integer.valueOf(r5));
        Intrinsics.checkNotNullParameter("OnPageChangeHelper", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        Log.i("OnPageChangeHelper", r14);
    L19:
        if (r13 != null) goto L29;
        return;
    L29:
        int r15 = r13.f13509a;     // Catch: Exception -> L23
        int r16 = r13.f13510b;     // Catch: Exception -> L23
        float r17 = r13.f13511c;     // Catch: Exception -> L23
        int r18 = OCarouselIndicator.J;     // Catch: Exception -> L23
        r12.p(r17, r15, r16);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == false) goto L27;
        String r19 = Intrinsics.stringPlus("OIndicator: ", e.getMessage());
        Intrinsics.checkNotNullParameter("OnPageChangeHelper", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Log.i("OnPageChangeHelper", r19);
        return;
    L27:
        Intrinsics.checkNotNullParameter("OnPageChangeHelper", "tag");
        Intrinsics.checkNotNullParameter("抓住了一个Exception并ignore", "msg");
        Log.e("OnPageChangeHelper", "抓住了一个Exception并ignore", e);
        return;
    L6:
        if (r5 != 1) goto L8;
        r13 = new u(0, 0, 0.0f);
        goto L19
    L8:
        int r20 = r5 - 1;
        if (r11 < 0) goto L18;
        if (r11 > r20) goto L18;
        if (r11 == r20) goto L13;
    L15:
        if (r11 != r20) goto L17;
        r13 = new u(r20, r20, 0.0f);
        goto L19
    L17:
        r13 = new u(r11, 1 + r11, r10);
        goto L19
    L13:
        if (r10 <= 0.0f) goto L15;
        r13 = new u(r20, 0, r10);
    L18:
        String r110 = j0.f(r11, r5, "Ignore onPageScrolled because position=", ", pageCount=");
        Intrinsics.checkNotNullParameter("OnPageChangeHelper", "tag");
        Intrinsics.checkNotNullParameter(r110, "msg");
        Log.i("OnPageChangeHelper", r110);
        goto L19
    }

    public void m(boolean r5) {
        v6.e r10 = (v6.e) this.f21695a;
        r10.getClass();
        z6.b.f23409a.b(new com.bytedance.iesgurd.settings.b(3, r5, r10));
    }

    public a(int r5, boolean r10) {
        switch(r5) {
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        this.f21695a = new ArrayDeque();
        return;
    L5:
        this.f21695a = new ConcurrentHashMap();
        return;
    L7:
        this.f21695a = ByteBuffer.allocate(8);
    }

    @Override // ol.d
    public void a(String r5) {
        e r10 = (e) this.f21695a;
        g1.c r11 = r10.f18226c.e;
        if (r11 == null) goto L11;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        com.bytedance.ai.widget.contianer.d r12 = (com.bytedance.ai.widget.contianer.d) r11;
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r5, "url");
        String r13 = "onPageStart ".concat(r5);
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L9;
        r14.i("AppletWidgetContainer", r13);
    L9:
        r12.f3044a.i(WidgetContainer.LifecycleEvent.f3033b);
        return;
    }

    @Override // z.d
    public void a(byte[] r5, Object r10, MessageDigest r11) {
        Long r12 = (Long) r10;
        r11.update(r5);
        ByteBuffer r13 = (ByteBuffer) this.f21695a;
        monitor-enter(r13);
        ((ByteBuffer) this.f21695a).position(0);     // Catch: Throwable -> L7
        r11.update(((ByteBuffer) this.f21695a).putLong(r12.longValue()).array());     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // ol.d
    public void b(int r5, String r10, String r11) {
        e r12 = (e) this.f21695a;
        if (r5 != (-1)) goto L6;
        a1.c r13 = r12.f18225b;
        String r14 = "onReceivedError url=" + r11 + " error=" + r5 + ' ' + r10;
        AtomicInteger r15 = a1.c.f44c;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "msg");
        String r16 = "[" + r13.f46b + "] " + r14;
        String r17 = r13.f45a;
        Intrinsics.checkNotNullParameter(r17, "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        a1.a.f43a.w(r17, r16);
        return;
    L6:
        StringBuilder r18 = new StringBuilder("errorCode: ");
        r18.append(r5);
        r18.append(", description: ");
        r18.append(r10);
        r18.append(", failingUrl: ");
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        r18.append(r11);
        String r19 = r18.toString();
        g1.c r20 = r12.f18226c.e;
        if (r20 == null) goto L13;
        ((com.bytedance.ai.widget.contianer.d) r20).b(r12, false, r5, r19);
        return;
    }
}
