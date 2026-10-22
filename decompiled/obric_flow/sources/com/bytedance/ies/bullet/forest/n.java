package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends com.bytedance.ies.bullet.service.sdk.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5412a;

    public /* synthetic */ n(int r5) {
        this.f5412a = r5;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.c
    public final boolean a(com.bytedance.ies.bullet.service.sdk.b r14) {
        String r5 = "";
        int r13 = this.f5412a;
        Intrinsics.checkNotNullParameter(r14, "schemaData");
        switch(r13) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L44;
            case 3: goto L28;
            case 4: goto L25;
            default: goto L4;
        };
    L4:
        LinkedHashMap r15 = r14.f6143o;
        String r10 = (String) r15.get("fallback_url");
        if (r10 == null) goto L24;
        int r11 = StringsKt.q(r10, '#', 0, 6);
        if (r11 != (-1)) goto L9;
        String r12 = r10;
    L10:
        if (r11 == (-1)) goto L13;
        r5 = r10.substring(r11, r10.length());
    L13:
        StringBuilder r16 = new StringBuilder(r12);
        if (StringsKt.f(r12, '?') == true) goto L16;
        r16.append('?');
    L16:
        r16.append("&prev_kit_type=LYNX");
        String r17 = (String) r15.get("url");
        if (r17 == null) goto L23;
        int r18 = StringsKt.q(r17, '?', 0, 6);
        r16.append("&prev_url=");
        if (r18 == (-1)) goto L22;
        r17 = r17.substring(0, r18);
    L22:
        r16.append(Uri.encode(r17));
    L23:
        r16.append(r5);
        r14.b("fallback_url", new vd.a(r16.toString(), 7), true);
        goto L24
    L9:
        r12 = r10.substring(0, r11);
    L24:
        return true;
    L25:
        r14.b("disable_auto_expose", new vd.a(Boolean.TRUE, 0), false);
        return true;
    L44:
        Object r19 = new vd.a(r14, "enable_annie_pro", Boolean.FALSE).f22372b;
        Boolean r20 = Boolean.TRUE;
        if (Intrinsics.areEqual(r19, r20) == false) goto L88;
        r14.b("__x_param_annie_pro", new vd.a(r20, 0), false);
        LinkedHashMap r110 = r14.f6143o;
        String r21 = (String) r110.get("app_id");
        if (r21 == null) goto L88;
        String r22 = (String) r110.get("local_host");
        String r23 = (String) r110.get("start_page");
        if (r22 != null) goto L52;
    L70:
        StringBuilder r24 = new StringBuilder();
        String r25 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/";
        Intrinsics.checkNotNullParameter("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/", SVGRenderEngine.PATH);
        if (StringsKt.isBlank("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/") == false) goto L74;
        r25 = "";
    L77:
        r24.append(r25);
        r24.append(r21);
        if (r23 != null) goto L80;
    L86:
        r24.append(r5);
        String r26 = r24.toString();
    L87:
        Intrinsics.checkNotNullParameter("surl", STGroup.DICT_KEY);
        r110.remove("surl");
        r14.b("url", new vd.a(Uri.parse(r26), 8), true);
        r14.b("bdhm_bid", new vd.a(r21, 7), true);
        r14.b("group", new vd.a(r21, 7), true);
        goto L88
    L80:
        if (StringsKt.isBlank(r23) == true) goto L86;
        if (StringsKt.P(r23, "/") == false) goto L85;
        r5 = r23;
        goto L86
    L85:
        r5 = "/".concat(r23);
        goto L86
    L74:
        if (StringsKt.k("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application/", "/") == true) goto L77;
        r25 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/annie/pro/application//";
        goto L77
    L52:
        if (r22.length() == 0) goto L70;
        StringBuilder r111 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r22, SVGRenderEngine.PATH);
        if (StringsKt.isBlank(r22) == false) goto L58;
        r22 = "";
    L60:
        r111.append(r22);
        if (r23 != null) goto L63;
    L69:
        r111.append(r5);
        r26 = r111.toString();
        goto L87
    L63:
        if (StringsKt.isBlank(r23) == true) goto L69;
        if (StringsKt.P(r23, "/") == false) goto L68;
        r5 = r23;
        goto L69
    L68:
        r5 = "/".concat(r23);
        goto L69
    L58:
        if (StringsKt.k(r22, "/") == false) goto L60;
        r22 = androidx.constraintlayout.motion.widget.a.n(r22, 1, 0);
    L88:
        return true;
    L89:
        r14.b("delay_preload", new vd.a(0, 2), true);
        return true;
    L91:
        LinkedHashMap r112 = r14.f6143o;
        String r27 = null;
        if (Intrinsics.areEqual(r112.get("enable_preload"), "main_ssr") == false) goto L94;
        LinkedHashMap r28 = r112;
    L96:
        if (r28 == null) goto L98;
        r14.b("loader_name", new vd.a("forest", 7), false);
        r14.b("streaming_load", new vd.a(1, 2), false);
        r14.b("enable_preload", new vd.a(JvmProtoBufUtil.DEFAULT_MODULE_NAME, 7), true);
    L98:
        String r29 = (String) r112.get("enable_preload");
        if (r29 != null) goto L102;
        r29 = "disable";
    L102:
        if (Intrinsics.areEqual(r29, "disable") == true) goto L104;
        LinkedHashMap r30 = r112;
    L105:
        if (r30 != null) goto L107;
    L114:
        String r31 = (String) r112.get("enable_preload");
        if (r31 != null) goto L117;
    L127:
        ConcurrentHashMap r32 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r33 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r33 == null) goto L139;
        com.bytedance.ies.bullet.base.settings.d r34 = (com.bytedance.ies.bullet.base.settings.d) r33.a(com.bytedance.ies.bullet.base.settings.d.class);
        if (r34 == null) goto L139;
        if (Intrinsics.areEqual(r112.get("loader_name"), "forest") == false) goto L139;
        String r113 = r34.c();
        if (Intrinsics.areEqual(r113, "concurrent") == false) goto L137;
        r27 = r113;
    L137:
        if (r27 == null) goto L139;
        r14.b("forest_buffer_mode", new vd.a(r27, 7), false);
    L139:
        return true;
    L117:
        if (r31.length() > 0) goto L120;
        r31 = null;
    L120:
        if (r31 == null) goto L127;
        if (Intrinsics.areEqual(r31, "disable") == false) goto L125;
        r31 = null;
    L125:
        if (r31 == null) goto L127;
        r14.b("forest_max_age", new vd.a(5, 2), false);
        goto L127
    L107:
        if (Intrinsics.areEqual(r30.get("append_common_params"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L109;
    L112:
        if (r30 == null) goto L114;
        r14.b("delay_preload", new vd.a(1, 2), false);
        goto L114
    L109:
        if (com.lynx.tasm.utils.k.o((String) r30.get("append_global_props")) == true) goto L112;
        r30 = null;
        goto L112
    L104:
        r30 = null;
        goto L105
    L94:
        r28 = null;
        goto L96
    L28:
        if (Intrinsics.areEqual(r14.d, "http") == false) goto L30;
    L40:
        tc.c r114 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r115 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r115 == null) goto L43;
        com.bytedance.ies.bullet.service.base.d r116 = (com.bytedance.ies.bullet.service.base.d) r115.f6163b.getValue();
    L43:
        return true;
    L30:
        if (Intrinsics.areEqual(r14.d, IIvyAIPackageResourceService.SCHEMA) == true) goto L40;
        String r117 = r14.e;
        if (r117 != null) goto L34;
    L36:
        String r118 = r14.e;
        if (r118 == null) goto L43;
        if (StringsKt.g(r118, "webview") != true) goto L43;
    L34:
        if (StringsKt.g(r117, "reactnative") != true) goto L36;
        goto L36
    }

    @Override // com.bytedance.ies.bullet.service.sdk.c
    public final String b() {
        switch(this.f5412a) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        return "FallbackUrl";
    L6:
        return "DisableAutoExpose";
    L8:
        return "WebStandardInterceptor";
    L10:
        return "AnniePro";
    L12:
        return "AnnieXLiteForestInterceptor";
    L14:
        return "forest";
    }
}
