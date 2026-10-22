package gc;

import android.net.Uri;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f17080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f17081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ wc.e f17082c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public c(a0 r5, g r10, wc.e r11, long r12, long r13) {
        this.f17080a = r5;
        this.f17081b = r10;
        this.f17082c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ArrayList r5 = e.f17086a;
        a0 r10 = this.f17080a;
        g r11 = this.f17081b;
        e.a(r10, r11);
        if (r10.g == false) goto L102;
        if (d.e(r11) == false) goto L7;
        LinkedHashMap r12 = new LinkedHashMap();
    L8:
        wc.e r13 = this.f17082c;
        a r14 = r13.f22834m;
        int r15 = r11.f22839h.length();
        Uri r16 = r10.f5932a;
        if (r15 <= 0) goto L11;
        String r17 = r11.f22839h;
    L15:
        if (r17.length() != 0) goto L17;
        r17 = k.i(r16);
    L17:
        JSONObject r18 = com.lynx.tasm.utils.d.k("res_url", r17);
        if (r12 == null) goto L20;
        r12.put("res_full_src", r17);
    L20:
        r18.put("res_from", r10.a());
        if (r12 == null) goto L23;
        r12.put("res_from", r10.a());
    L23:
        long r19 = r10.f;
        r18.put("res_version", String.valueOf(r19));
        r18.put("res_state", "success");
        if (Intrinsics.areEqual(r11.f22840i, "template") == false) goto L27;
        r18.put("res_tag", "template");
    L30:
        r18.put("preload", "0");
        r18.put("preload_high_priority", "0");
        if (r11.f22845n == false) goto L33;
        Object r20 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L34:
        r18.put("res_remote", r20);
        r18.put("res_message", "fetch success");
        String r21 = r10.f5933b;
        if (r21 == null) goto L46;
        String r110 = FilesKt.getExtension(new File(r21));
        Object r111 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        Locale r112 = Locale.ROOT;
        if (r110 == null) goto L45;
        String r113 = r110.toLowerCase(r112);
        r18.put("res_type", r113);
        if (r12 == null) goto L41;
        Object r114 = r12.put("res_type", r113);
    L42:
        if (r114 != null) goto L49;
    L47:
        r18.put("res_type", "unknown");
    L49:
        if (r10.f5940m == false) goto L51;
        Object r115 = r111;
    L52:
        r18.put("res_memory", r115);
        r18.put("preload_fail_message", r10.f5944q);
        r18.put("gecko_fail_message", r10.f5938k);
        r18.put("buildIn_fail_message", r10.f5941n);
        r18.put("cdn_fail_message", r10.f5942o);
        r18.put("memory_fail_message", "");
        if (Intrinsics.areEqual(r10.a(), "gecko") == false) goto L55;
    L58:
        r18.put("gecko_sdk_version", "");
        r18.put(WsConstants.KEY_APP_ID, r13.f22828c);
        r18.put("package_id", String.valueOf(r19));
        boolean r22 = k.o(r11.f);
        fc.a r23 = r10.f5936i;
        if (r22 == false) goto L61;
        String r24 = r11.f;
    L66:
        r18.put(LynxMonitorService.KEY_CHANNEL, r24);
        if (k.o(r11.f22838c) == false) goto L69;
        String r25 = r11.g;
    L74:
        r18.put("bundle", r25);
    L75:
        ug.d r26 = r10.f5949w;
        r26.f = r18;
        d.a(r18, r10);
        JSONObject r27 = new JSONObject();
        r27.put("res_duration", this.d);
        if (k.o(r21) == false) goto L81;
        Intrinsics.checkNotNull(r21);
        double r116 = k.a(new File(r21));
        r27.put("res_size", r116);
        if (r12 == null) goto L81;
        r12.put("res_size", Double.valueOf(r116));
    L81:
        if (Intrinsics.areEqual(r10.a(), "gecko") == false) goto L83;
    L84:
        long r117 = r10.f5937j;
        r27.put("read_duration", this.e - r117);
    L85:
        r26.d = r27;
        JSONObject r28 = new JSONObject();
        r28.put("res_channel", r11.f);
        r28.put("res_config", r11.toString());
        r26.g = r28;
        r26.e = Boolean.valueOf(e.b(r16.toString(), r13));
        Unit r29 = Unit.INSTANCE;
        r14.e(r11, r26);
        if (d.e(r11) == false) goto L102;
        com.bytedance.android.monitorV2.webview.k r30 = com.bytedance.android.monitorV2.webview.k.d;
        String r31 = r11.f22853w;
        if (r31 != null) goto L90;
        r31 = "";
    L90:
        String r32 = r11.f22854x;
        if (r32 != null) goto L93;
        String r33 = r8;
    L94:
        if (r12 == null) goto L99;
        Object r34 = r12.get("res_full_src");
        if (r34 == null) goto L98;
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type kotlin.String");
        r12.put("res_format_src", k.i(Uri.parse((String) r34)));
    L98:
        r12.put("request_method", "GET");
        LinkedHashMap r35 = r12;
    L100:
        r30.o("anniex_ssp_res_loader_info", r31, r33, r35);
        goto L102
    L99:
        r35 = null;
        goto L100
    L93:
        r33 = r32;
        goto L94
    L83:
        if (Intrinsics.areEqual(r10.a(), "geckoUpdate") == false) goto L85;
    L69:
        if (r23 != null) goto L71;
    L73:
        r25 = null;
        goto L74
    L71:
        if (r23.f16890c == false) goto L73;
        r25 = r23.f16889b;
        goto L74
    L61:
        if (r23 != null) goto L63;
    L65:
        r24 = null;
        goto L66
    L63:
        if (r23.f16890c == false) goto L65;
        r24 = r23.f16888a;
        goto L66
    L55:
        if (Intrinsics.areEqual(r10.a(), "geckoUpdate") == false) goto L75;
    L51:
        r115 = "0";
        goto L52
    L41:
        r114 = null;
        goto L42
    L45:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L46:
        r111 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        goto L47
    L33:
        r20 = "0";
        goto L34
    L27:
        if (Intrinsics.areEqual(r11.f22840i, "web") == false) goto L29;
        r18.put("res_tag", "web");
        goto L30
    L29:
        r18.put("res_tag", "sub_resource");
        goto L30
    L11:
        r17 = i.c(r16);
        if (r17 != null) goto L15;
        r17 = "";
        goto L15
    L7:
        r12 = null;
    L102:
        return Unit.INSTANCE;
    }
}
