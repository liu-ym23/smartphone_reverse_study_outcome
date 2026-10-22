package n4;

import android.webkit.CookieManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.base.settings.f;
import com.bytedance.ies.bullet.base.settings.m;
import com.bytedance.ies.bullet.forest.o;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.j;
import com.bytedance.ies.bullet.service.base.d;
import com.bytedance.ies.bullet.service.webkit.c;
import com.bytedance.ies.bullet.web.pia.i;
import com.google.gson.Gson;
import com.lynx.tasm.behavior.ui.utils.n;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rb.b;
import wn.h;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SSWebView f20202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f20203c;
    public boolean d;
    public volatile boolean e;
    public final b f;

    public a(String r5, c r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "kitService");
        this.f20201a = r5;
        this.f20203c = new n(r10);
        this.d = true;
        new AtomicBoolean(false);
        ConcurrentHashMap r11 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r12 = (e) yc.a.a(e.class, "default_bid");
        if (r12 == null) goto L9;
        m r13 = (m) r12.a(m.class);
        if (r13 == null) goto L9;
        if (r13.b() == null) goto L9;
    L10:
        Intrinsics.checkNotNullParameter(r10, "webKitService");
        this.f = new b();
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.settings.b.class, "clazz");
        tc.c r14 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r15 = (com.bytedance.ies.bullet.settings.b) tc.c.f22119c.a(com.bytedance.ies.bullet.settings.b.class, r10.f22117a);
        if (r15 == null) goto L14;
        ((d) r15.f6163b.getValue()).getClass();
        return;
    L14:
        return;
    L9:
        new f();
        goto L10
    }

    public final void a(FragmentActivity r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        System.currentTimeMillis();
        if (this.e != true) goto L6;
        return;
    L6:
        if (this.f20202b == null) goto L8;
        SSWebView r11 = this.f20202b;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
    L9:
        if (r11 == null) goto L30;
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r12 = (e) yc.a.a(e.class, "default_bid");
        if (r12 == null) goto L17;
        xc.d r13 = (xc.d) r12.a(xc.d.class);
        if (r13 == null) goto L17;
        Boolean r14 = r13.k();
        if (r14 == null) goto L17;
        boolean r15 = r14.booleanValue();
    L18:
        if (r15 == false) goto L39;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L21
        r11.setFocusable(true);     // Catch: Throwable -> L21
        r11.setFocusableInTouchMode(true);     // Catch: Throwable -> L21
        Object r17 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L39;
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XWebKit", "setFocusable error...message is " + r18.getMessage(), null, 12);
    L21:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L39:
        CookieManager.getInstance().setAcceptThirdPartyCookies(r11, true);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        r15 = true;
    L30:
        Lazy r21 = com.bytedance.ies.bullet.secure.f.f5904c;
        h.e().a(this.f20201a);
        h.e().a(this.f20201a);
        SSWebView r22 = this.f20202b;
        if (r22 == null) goto L35;
        LinkedHashMap r23 = i.f6234a;
        String r24 = this.f20201a;
        String r25 = r22.getSettings().getUserAgentString();
        Intrinsics.checkNotNullParameter(r24, "bid");
        Intrinsics.checkNotNullParameter(r25, "userAgent");
        com.bytedance.ies.bullet.web.pia.d r26 = (com.bytedance.ies.bullet.web.pia.d) i.f6234a.get(r24);
        if (r26 == null) goto L35;
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r26.f6223a = r25;
    L35:
        j r27 = new j();
        com.bytedance.ies.bullet.core.e r28 = new com.bytedance.ies.bullet.core.e();
        r28.C = true;
        r28.f = this.f20201a;
        r27.d(r28, CollectionsKt.emptyList());
        this.e = true;
        System.currentTimeMillis();
        return;
    L8:
        this.f20202b = this.f20203c.l(r10);
        r11 = this.f20202b;
        goto L9
    }

    public final void b(String r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        if (com.bytedance.ies.bullet.core.h.g.f5315a == true) goto L13;
        com.bytedance.ies.bullet.service.base.b.b(8, null, "send event.", "XWebKit");
    L9:
        new JSONObject();
        if (r10 == null) goto L15;
        boolean r11 = r10 instanceof JSONObject;
        return;
    L15:
        return;
    L13:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.service.base.b.b(8, null, "send event: " + r5 + " with " + new Gson().toJson(r10), "XWebKit");     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.p
    public final Pair h(String r5, boolean r10, com.bytedance.ies.bullet.core.e r11, rd.e r12) {
        return o.b(this, r5, r10, r11, r12);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(rd.e r5) {
        return u8.a.j(r5);
    }
}
