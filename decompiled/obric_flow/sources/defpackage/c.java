package defpackage;

import android.net.Uri;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.service.base.g;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pb.a;
import rb.b;
import xc.d;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static void a(c r10, e r11, ViewGroup r12, com.bytedance.sdk.xbridge.cn.protocol.c r13, b r14, Function2 r15) {
        if (r11 == null) goto L4;
        String r5 = r11.getSessionId();
    L5:
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        String r16 = r5;
        if (r11 == null) goto L15;
        rd.b r17 = r11.e;
        if (r17 == null) goto L15;
        Uri r18 = ((com.bytedance.ies.bullet.service.sdk.b) r17).f6135c;
        if (r18 == null) goto L15;
    L14:
        Uri r19 = r18;
        r10.getClass();
        b(r12, r13, r14, r16, r19, r15);
        return;
    L15:
        r18 = Uri.EMPTY;
        goto L14
    L4:
        r5 = null;
        goto L5
    }

    public static void b(ViewGroup r5, com.bytedance.sdk.xbridge.cn.protocol.c r10, b r11, String r12, Uri r13, Function2 r14) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r11, "providerFactory");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r14, "sendEvent");
        tc.c r15 = tc.c.f22119c;
        a r16 = (a) tc.c.f22119c.a(a.class, "default_bid");
        if (r16 != null) goto L5;
    L7:
        boolean r17 = r10 instanceof com.bytedance.sdk.xbridge.cn.platform.lynx.a;
        com.bytedance.sdk.xbridge.cn.platform.web.b r18 = null;
        if (r17 == false) goto L10;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r19 = (com.bytedance.sdk.xbridge.cn.platform.lynx.a) r10;
    L11:
        if (r19 == null) goto L15;
        if (r19.f7453a == null) goto L15;
    L21:
        b r20 = new b(r5);
        if (r17 == false) goto L24;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r21 = (com.bytedance.sdk.xbridge.cn.platform.lynx.a) r10;
    L26:
        if (r21 == null) goto L29;
        r21.i(kj.c.class, r20);
    L29:
        if ((r10 instanceof com.bytedance.sdk.xbridge.cn.platform.web.b) == false) goto L31;
        r18 = (com.bytedance.sdk.xbridge.cn.platform.web.b) r10;
    L31:
        if (r18 == null) goto L33;
        r18.i(kj.c.class, r20);
    L33:
        r11.getClass();
        Intrinsics.checkNotNullParameter(kj.c.class, "clazz");
        r11.b(kj.c.class, new rb.a(r20));
        ConcurrentHashMap r22 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r23 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r23 == null) goto L40;
        d r24 = (d) r23.a(d.class);
        if (r24 == null) goto L40;
        Boolean r25 = r24.C();
        if (r25 == null) goto L40;
        boolean r26 = r25.booleanValue();
    L42:
        if (r26 == false) goto L45;
        ContainerBidParam r27 = new ContainerBidParam("webcast");
        Intrinsics.checkNotNullParameter(ContainerBidParam.class, "clazz");
        r11.b(ContainerBidParam.class, new rb.a(r27, 0));
    L45:
        if (((Boolean) com.bytedance.android.anniex.lite.utils.a.f3257a.getValue()).booleanValue() == false) goto L48;
        com.bytedance.android.anniex.base.service.c.a(p3.c.class, "webcast");
        return;
    L48:
        Intrinsics.checkNotNullParameter("webcast", "bid");
        Intrinsics.checkNotNullParameter(p3.c.class, "clazz");
        com.bytedance.android.anniex.base.service.c.a(p3.c.class, "webcast");
        if (tc.c.f22119c.a(p3.c.class, "webcast") != null) goto L52;
        return;
    L52:
        throw new ClassCastException();
    L40:
        r26 = true;
        goto L42
    L24:
        r21 = null;
    L15:
        if ((r10 instanceof com.bytedance.sdk.xbridge.cn.platform.web.b) == false) goto L17;
        com.bytedance.sdk.xbridge.cn.platform.web.b r28 = (com.bytedance.sdk.xbridge.cn.platform.web.b) r10;
    L18:
        if (r28 != null) goto L21;
        r5.getContext();
        goto L21
    L17:
        r28 = null;
        goto L18
    L10:
        r19 = null;
        goto L11
    L5:
        if ((r16 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L7;
        com.ivy.ivykit.plugin.impl.jsb.c r29 = (com.ivy.ivykit.plugin.impl.jsb.c) r16;
        Intrinsics.checkNotNullParameter(r11, "providerFactory");
        goto L7
    }

    public final void c(e r10, final WebView r11, com.bytedance.sdk.xbridge.cn.platform.web.b r12, b r13, final g r14) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r13, "providerFactory");
        Intrinsics.checkNotNullParameter(r14, "eventHandler");
        a(this, r10, r11, r12, r13, new WebcastContainerInitializer$initializeWithBulletContextInWeb$1(r14, r11));
    }

    public final void d(e r10, final LynxView r11, com.bytedance.sdk.xbridge.cn.platform.lynx.a r12, b r13, final com.bytedance.ies.bullet.lynx.impl.c r14) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r13, "providerFactory");
        Intrinsics.checkNotNullParameter(r14, "eventHandler");
        a(this, r10, r11, r12, r13, new WebcastContainerInitializer$initializeWithBulletContextInLynx$1(r14, r11));
    }
}
