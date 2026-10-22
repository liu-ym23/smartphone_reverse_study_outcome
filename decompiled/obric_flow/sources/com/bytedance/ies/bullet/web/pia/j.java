package com.bytedance.ies.bullet.web.pia;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.setting.Settings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nh.b f6235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f6236b;

    public j(nh.b r5) {
        Intrinsics.checkNotNullParameter(r5, "innerLifeCycle");
        this.f6235a = r5;
        this.f6236b = new s();
    }

    public final WebResourceResponse a(WebResourceRequest r17) {
        Intrinsics.checkNotNullParameter(r17, "request");
        Uri r5 = r17.getUrl();
        nh.b r10 = this.f6235a;
        nh.d r11 = (nh.d) r10.f;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.pia.core.utils.j.z(r5) == true) goto L8;
        return null;
    L8:
        if (r5.getBooleanQueryParameter("__pia_manifest__", false) == false) goto L11;
    L20:
        LinkedHashMap r12 = i.f6234a;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        ym.j r13 = new ym.j(r17);
        Intrinsics.checkNotNullParameter("[Runtime] start onBeforeLoadResource.", "message");
        com.bytedance.pia.core.utils.j.y("[Runtime] start onBeforeLoadResource.", null);
        if (com.bytedance.pia.core.utils.j.z(r17.getUrl()) == true) goto L24;
        dh.f r14 = null;
    L71:
        if (r14 == null) goto L74;
        LinkedHashMap r15 = i.f6234a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        return new WebResourceResponse(r14.e(), r14.d(), r14.getData());
    L74:
        nh.d r16 = (nh.d) r10.f;
        if (r16 != null) goto L77;
    L79:
        dh.f r18 = null;
    L93:
        if (r18 == null) goto L117;
        LinkedHashMap r19 = i.f6234a;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        return new WebResourceResponse(r18.e(), r18.d(), r18.getData());
    L117:
        return null;
    L77:
        if (r16.C.get() == false) goto L80;
        Intrinsics.checkNotNullParameter("[Runtime] call onAfterLoadResource after release.", "message");
        com.bytedance.pia.core.utils.j.x("[Runtime] call onAfterLoadResource after release.", null);
        goto L79
    L80:
        Iterator r20 = r16.f20248t.iterator();
        r18 = null;
    L82:
        if (r20.hasNext() == false) goto L93;
        nh.c r21 = (nh.c) r20.next();
        dh.f r110 = r21.b(r13, r18);     // Catch: Throwable -> L91
        if (r110 == r18) goto L90;
        com.bytedance.pia.core.utils.j.A("[Runtime] " + r21.c() + " edited resource response, url=" + r17.getUrl());     // Catch: Throwable -> L88
    L88:
        th = th;
        r18 = r110;
    L92:
        String r22 = "[Runtime] " + r21.c() + " error:";
        Intrinsics.checkNotNullParameter(r22, "message");
        com.bytedance.pia.core.utils.j.w(4, r22, th);
    L90:
        r18 = r110;
    L91:
        th = th;
        goto L92
    L24:
        if (r10.f20235c == true) goto L45;
        if (((nh.d) r10.f) == null) goto L45;
        if (r17.isForMainFrame() == false) goto L45;
        if (r17.getUrl() == null) goto L45;
        String r23 = r17.getUrl().toString();
        if (TextUtils.isEmpty(r23) == false) goto L34;
    L33:
        String r24 = null;
    L42:
        if (r24 == null) goto L45;
        r10.c();
        r10.f = r10.b(r17.getUrl().toString());
        goto L45
    L34:
        Lazy r111 = Settings.B;
        if (com.lynx.tasm.p.a().r() == false) goto L37;
    L41:
        r24 = com.bytedance.pia.core.utils.j.k(Uri.parse(r23), null);
        goto L42
    L37:
        if (r23.contains("__pia_manifest__") == true) goto L41;
        if (r23.contains("_pia_") == true) goto L41;
    L45:
        if (((nh.d) r10.f) == null) goto L69;
        long r112 = System.currentTimeMillis();
        nh.d r25 = (nh.d) r10.f;
        if (r25.C.get() == false) goto L49;
        Intrinsics.checkNotNullParameter("[Runtime] call onBeforeLoadResource after release.", "message");
        com.bytedance.pia.core.utils.j.x("[Runtime] call onBeforeLoadResource after release.", null);
    L59:
        r14 = null;
    L60:
        if (r14 != null) goto L62;
    L70:
        Intrinsics.checkNotNullParameter("[Runtime] end onBeforeLoadResource.", "message");
        com.bytedance.pia.core.utils.j.y("[Runtime] end onBeforeLoadResource.", null);
        goto L71
    L62:
        if (r17.isForMainFrame() == false) goto L70;
        nh.d r26 = (nh.d) r10.f;
        if (r26 == null) goto L66;
        r26.f20246q.a("intercept_html.start", r112);
    L66:
        nh.d r27 = (nh.d) r10.f;
        if (r27 == null) goto L70;
        r27.f20246q.a("intercept_html.end", System.currentTimeMillis());
        goto L70
    L49:
        Iterator r28 = r25.f20248t.iterator();
    L51:
        if (r28.hasNext() == false) goto L59;
        nh.c r29 = (nh.c) r28.next();
        r14 = r29.a(r13);     // Catch: Throwable -> L57
        if (r14 == null) goto L51;
        com.bytedance.pia.core.utils.j.A("[Runtime] " + r29.c() + " intercepted resource loading, url=" + r17.getUrl());     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        String r30 = "[Runtime] " + r29.c() + " error:";
        Intrinsics.checkNotNullParameter(r30, "message");
        com.bytedance.pia.core.utils.j.w(4, r30, th);
        goto L51
    L69:
        r14 = null;
        goto L70
    L11:
        if (r5.getBooleanQueryParameter("_pia_", false) == true) goto L20;
        Lazy r31 = Settings.B;
        if (com.lynx.tasm.p.a().r() == false) goto L119;
        String r32 = r5.getHost();
        Uri r33 = r11.g;
        if (TextUtils.equals(r32, r33.getHost()) == true) goto L19;
        return null;
    L19:
        if (TextUtils.equals(r5.getPath(), r33.getPath()) == true) goto L20;
        return null;
    L119:
        return null;
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        nh.b r10 = this.f6235a;
        r10.getClass();
        Intrinsics.checkNotNullParameter("[Runtime] start loadUrl", "message");
        Uri r11 = null;
        com.bytedance.pia.core.utils.j.y("[Runtime] start loadUrl", null);
        if (r5 == null) goto L6;
        r11 = Uri.parse(r5);
    L6:
        if (com.bytedance.pia.core.utils.j.z(r11) == false) goto L11;
        r10.f20235c = true;
        r10.c();
        nh.d r12 = r10.b(r5);
        r10.f = r12;
        if (r12 == null) goto L11;
        r12.s.b("NLS");
    L11:
        s r13 = this.f6236b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "url");
        if (StringsKt.P(r5, "javascript") == false) goto L15;
        r13.a(r5);
        return;
    }
}
