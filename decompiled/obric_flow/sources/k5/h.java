package k5;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo$BidConfig;
import com.bytedance.android.monitorV2.l;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f18618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f18619b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f18620c = null;

    static {
        f18618a = CollectionsKt.arrayListOf(new String[]{"jsb_bid", "regex_bid", "config_bid"});
        f18619b = CollectionsKt.arrayListOf(new String[]{"[?&]bd_hybrid_monitor_bid=([^&#]+)", "[?&]bdhm_bid=([^&#]+)"});
        f18620c = CollectionsKt.arrayListOf(new String[]{"[?&]bdhm_pid=([^&#]+)"});
    }

    public static String a(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L7;
        return f(r5);
    L7:
        if ((r5 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L14;
        com.bytedance.android.monitorV2.event.b r10 = (com.bytedance.android.monitorV2.event.b) r5;
        if (TextUtils.isEmpty(r10.f3553m.f22948b) == true) goto L13;
        return r10.f3553m.f22948b;
    L13:
        return f(r5);
    L14:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String b(LinkedList r12, ArrayList r13) {
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = "";
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L47;
        String r10 = (String) r14.next();
        Iterator r11 = r13.iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        String r15 = (String) r11.next();
        if (StringsKt.isBlank(r10) == true) goto L7;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L30
        Matcher r17 = Pattern.compile(r15).matcher(r10);     // Catch: Throwable -> L30
        if (r17.find() == false) goto L37;
        String r18 = r17.group(1);     // Catch: Throwable -> L30
        if (r18 == null) goto L34;
        int r19 = r18.length() - 1;     // Catch: Throwable -> L30
        int r20 = 0;
        boolean r21 = false;
    L15:
        if (r20 > r19) goto L32;
        if (r21 == true) goto L18;
        int r110 = r20;
    L20:
        if (Intrinsics.compare(r18.charAt(r110), 32) > 0) goto L22;
        boolean r111 = true;
    L23:
        if (r21 == false) goto L24;
        if (r111 == false) goto L32;
        r19 = r19 - 1;     // Catch: Throwable -> L30
        goto L15
    L24:
        if (r111 == false) goto L25;
        r20 = r20 + 1;     // Catch: Throwable -> L30
        goto L15
    L25:
        r21 = true;
        goto L15
    L22:
        r111 = false;
        goto L23
    L18:
        r110 = r19;
    L32:
        String r22 = r18.subSequence(r20, r19 + 1).toString();     // Catch: Throwable -> L30
        T r23 = r22;
        if (r22 == null) goto L34;
    L35:
        r5.element = r23;     // Catch: Throwable -> L30
    L34:
        r23 = "";
    L37:
        if (StringsKt.isBlank((CharSequence) r5.element) == true) goto L40;
        return (String) r5.element;
    L40:
        Object r24 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L43:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);
        if (r25 == null) goto L7;
        d5.b.d("ReportDataUtils", "match error", r25);
    L30:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L43
    L47:
        return (String) r5.element;
    }

    public static JSONObject c(com.bytedance.android.monitorV2.event.a r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        JSONObject r5 = new JSONObject();
        String r11 = a(r10);
        Intrinsics.checkNotNullParameter(r11, "bid");
        BidInfo$BidConfig r12 = com.bytedance.android.monitorV2.h.e().a().a().f(r11);
        JSONObject r13 = new JSONObject();
        Object r14 = r10.e.get("config_bid");
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        r10.f.s("bid_source", r10.f3562j);
        qo.a.t("event_type", r10.f3557a, r5);
        qo.a.t("full_link_id", r10.f3559c, r5);
        x4.h r15 = r10.f;
        r15.getClass();
        JSONObject r16 = new JSONObject();
        r15.m(r16);
        qo.a.j(r16, "nativeBase", r5);
        qo.a.j(r13, "bid_info", r16);
        qo.a.t("bid", r11, r13);
        qo.a.t("setting_bid", r12.bid, r13);
        qo.a.k("hit_sample", r12.hitSample, r13);
        qo.a.k("setting_id", r12.settingId, r13);
        qo.a.j(r14, "config_bid", r13);
        t4.a r17 = r10.f3550m;
        if (r17 == null) goto L8;
        qo.a.j(r17.s(), "nativeInfo", r5);
    L8:
        JSONObject r18 = r10.f3552o;
        if (r18 == null) goto L11;
        qo.a.j(r18, "jsInfo", r5);
    L11:
        JSONObject r19 = r10.g;
        if (r19 == null) goto L14;
        qo.a.j(r19, "jsBase", r5);
    L14:
        x4.a r20 = r10.f3560h;
        if (r20 == null) goto L17;
        JSONObject r21 = new JSONObject();
        r20.m(r21);
        qo.a.j(r21, "containerBase", r5);
    L17:
        x4.a r22 = r10.f3551n;
        if (r22 == null) goto L20;
        JSONObject r23 = new JSONObject();
        r22.m(r23);
        qo.a.j(r23, "containerInfo", r5);
    L20:
        LinkedHashMap r110 = r10.f3563k;
        if (r110 == null) goto L23;
        qo.a.j(new JSONObject(r110), "extra", r5);
    L23:
        return r5;
    }

    public static JSONObject d(com.bytedance.android.monitorV2.event.b r11) {
        Intrinsics.checkNotNullParameter(r11, "customEvent");
        String r5 = a(r11);
        x4.c r10 = r11.f3553m;
        r10.f22948b = r5;
        Intrinsics.checkNotNullParameter(r5, "bid");
        BidInfo$BidConfig r12 = com.bytedance.android.monitorV2.h.e().a().a().f(r5);
        JSONObject r13 = new JSONObject();
        Object r14 = r11.e.get("config_bid");
        String r15 = "";
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        r11.f.s("bid_source", r11.f3562j);
        JSONObject r16 = new JSONObject();
        qo.a.t("full_link_id", r11.f3559c, r16);
        qo.a.j(r13, "bid_info", r16);
        qo.a.t("bid", r5, r13);
        qo.a.t("setting_bid", r12.bid, r13);
        qo.a.k("hit_sample", r12.hitSample, r13);
        qo.a.k("setting_id", r12.settingId, r13);
        qo.a.j(r14, "config_bid", r13);
        qo.a.e(r10.f22953k, "can_sample", r13);
        JSONObject r17 = r10.d;
        if (r17 == null) goto L8;
        qo.a.j(r17, "client_category", r16);
    L8:
        JSONObject r18 = r10.e;
        if (r18 == null) goto L11;
        qo.a.j(r18, "client_metric", r16);
    L11:
        JSONObject r19 = r10.f;
        if (r19 == null) goto L14;
        qo.a.t("event_name", r10.f22949c, r19);
        qo.a.t(WsConstants.KEY_SDK_VERSION, "9.0.0", r10.f);
        qo.a.j(r10.f, "client_extra", r16);
    L14:
        JSONObject r20 = r10.g;
        if (r20 == null) goto L17;
        qo.a.j(r20, "client_timing", r16);
    L17:
        x4.h r21 = r11.f;
        r21.getClass();
        JSONObject r22 = new JSONObject();
        r21.m(r22);
        qo.a.j(r22, "nativeBase", r16);
        x4.a r23 = r11.f3560h;
        if (r23 == null) goto L20;
        JSONObject r24 = new JSONObject();
        r23.m(r24);
        qo.a.j(r24, "containerBase", r16);
    L20:
        JSONObject r110 = r11.g;
        if (r110 == null) goto L23;
        qo.a.j(r110, "jsBase", r16);
    L23:
        String r111 = r10.f22947a;
        qo.a.t("url", r111, r16);
        if (r111 == null) goto L39;
        Pattern r25 = k.f18621a;
        Uri r26 = Uri.parse(r111);     // Catch: Throwable -> L47
        if (r26 == null) goto L31;
        String r27 = r26.getHost();     // Catch: Throwable -> L47
        if (r27 == null) goto L31;
    L32:
        qo.a.t("host", r27, r16);
        Pattern r28 = k.f18621a;
        Uri r112 = Uri.parse(r111);     // Catch: Throwable -> L46
        if (r112 == null) goto L38;
        String r113 = r112.getPath();     // Catch: Throwable -> L46
        if (r113 == null) goto L38;
        r15 = r113;
    L38:
        qo.a.t(SVGRenderEngine.PATH, r15, r16);
    L31:
        r27 = "";
    L39:
        qo.a.t("ev_type", "custom", r16);
        JSONObject r114 = r10.f22950h;
        if (r114 != null) goto L42;
    L44:
        qo.a.m(r16, r10.f22950h);
        return r16;
    L42:
        if (r114.has("virtual_aid") == false) goto L44;
        r114.remove("virtual_aid");
        goto L44
    }

    public static JSONObject e(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L7;
        return c((com.bytedance.android.monitorV2.event.a) r5);
    L7:
        if ((r5 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L11;
        return d((com.bytedance.android.monitorV2.event.b) r5);
    L11:
        return new JSONObject();
    }

    public static String f(com.bytedance.android.monitorV2.event.d r10) {
        LinkedHashMap r5 = r10.e;
        Iterator r11 = f18618a.iterator();
    L3:
        String r12 = "";
        if (r11.hasNext() == false) goto L23;
        String r13 = (String) r11.next();
        Object r14 = r5.get(r13);
        if ((r14 instanceof String) == false) goto L3;
        if (StringsKt.isBlank((CharSequence) r14) == true) goto L3;
        if (Intrinsics.areEqual("regex_bid", r13) == false) goto L20;
        LinkedHashMap r15 = r10.f3563k;
        String r16 = null;
        if (r15 == null) goto L14;
        Object r17 = r15.get("regex_source");
    L16:
        if ((r17 instanceof String) == false) goto L18;
        r16 = (String) r17;
    L18:
        if (r16 == null) goto L21;
        r12 = r16;
    L21:
        r10.f.s("bid_source", r12);
        return (String) r14;
    L14:
        r17 = null;
        goto L16
    L20:
        r12 = r13;
        goto L21
    L23:
        r10.f.s("bid_source", "default_bid");
        return "";
    }

    public static void g(com.bytedance.android.monitorV2.event.d r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r10, "event");
        String r5 = "";
        if ((r10 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L9;
        String r11 = r10.f.f22973a;
        if (r11 == null) goto L12;
    L7:
        r5 = r11;
    L12:
        x4.a r12 = r10.f3560h;
        if (r12 == null) goto L15;
        JSONObject r13 = new JSONObject();
        r12.m(r13);
    L16:
        String r14 = qo.a.p("schema", r13);
        LinkedHashMap r15 = r10.e;
        LinkedList r16 = new LinkedList();
        r16.add(r5);
        r16.add(r14);
        String r17 = b(r16, f18619b);
        r10.c("regex_source", "regex_param_bid");
        if (StringsKt.isBlank(r17) == true) goto L19;
    L21:
        d5.b.f("ReportDataUtils", "regexMatcher: " + r17);
        r15.put("regex_bid", r17);
        if (StringsKt.isBlank(qo.a.p(LynxMonitorService.KEY_PID, r10.g)) == true) goto L25;
        return;
    L25:
        if (r10.g != null) goto L27;
        r10.g = new JSONObject();
    L27:
        LinkedList r18 = new LinkedList();
        r18.add(r5);
        r18.add(r14);
        String r19 = b(r18, f18620c);
        if (StringsKt.isBlank(r19) == true) goto L33;
        JSONObject r20 = r10.g;
        if (r20 == null) goto L34;
        r20.put(LynxMonitorService.KEY_PID, r19);
        return;
    L34:
        return;
    L33:
        return;
    L19:
        if (StringsKt.isBlank(r5) == true) goto L21;
        com.bytedance.android.monitorV2.k r21 = l.f3607a;
        r17 = l.a(r5, com.bytedance.android.monitorV2.h.e().a().b());
        r10.c("regex_source", "regex_list_bid");
        goto L21
    L15:
        r13 = null;
        goto L16
    L9:
        if ((r10 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L12;
        r11 = ((com.bytedance.android.monitorV2.event.b) r10).f3553m.f22947a;
        if (r11 != null) goto L7;
        goto L7
    }
}
