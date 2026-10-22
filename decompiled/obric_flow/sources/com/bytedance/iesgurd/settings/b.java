package com.bytedance.iesgurd.settings;

import ai.g0;
import ai.h0;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import bb.f;
import com.bytedance.android.monitorV2.i;
import com.bytedance.geckox.AppSettingsManager$IGeckoAppSettings;
import com.bytedance.geckox.l;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.g;
import com.google.common.reflect.w;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.j;
import com.obric.common.oui.R$color;
import com.obric.oui.lisitem.OListItemGeneral;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kn.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6691c;

    public /* synthetic */ b(int r5, boolean r10, Object r11) {
        this.f6689a = r5;
        this.f6691c = r11;
        this.f6690b = r10;
    }

    public void a() {
        HttpRequest r5 = (HttpRequest) this.f6691c;
        String r10 = r5.f9925a;
        String r11 = r5.f9926b;
        JavaOnlyMap r12 = r5.d;
        if (r11 == null) goto L57;
        JavaOnlyMap r13 = r5.e;
        r13.getBoolean("needCommonParams", true);
        ReadableMap r14 = r13.getMap(LynxResourceModule.PARAMS_KEY, new JavaOnlyMap());
        int r15 = r13.getInt("priorityLevel", 1);
        Pair r16 = com.bytedance.frameworks.baselib.network.http.util.c.c(r11, e.d(r14));     // Catch: IOException -> L54
        String r17 = r12.getString("Content-Type");
        if (((HttpRequest) this.f6691c).f9927c == null) goto L10;
        if (r17 != null) goto L12;
        TextUtils.isEmpty(null);
    L12:
        HashMap r18 = e.d(r12);
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.entrySet().iterator();
    L14:
        if (r20.hasNext() == false) goto L18;
        Map.Entry r21 = (Map.Entry) r20.next();
        if (r21.getValue() == null) goto L14;
        r19.add(new bi.c((String) r21.getKey(), (String) r21.getValue()));
        goto L14
    L18:
        vj.b r22 = new vj.b();
        r22.isCustomizedCookie = ((HttpRequest) this.f6691c).d.containsKey("Cookie");
        String r23 = (String) r16.first;
        t9.a r24 = new t9.a();
        g0 r25 = new g0(0);
        r25.g(r23);
        r25.g = new h.a(3);
        r25.d(new wa.a(1));
        r25.f210b = r24;
        h0 r26 = r25.e();
        String r27 = (String) r16.second;
        if (r10.equalsIgnoreCase("GET") == false) goto L36;
        if (this.f6690b == true) goto L33;
        if (r15 == 0) goto L31;
        if (r15 == 2) goto L29;
        if (r15 != 3) goto L27;
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L27:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L29:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L31:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L33:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L36:
        if (r10.equalsIgnoreCase("POST") == false) goto L53;
        if (this.f6690b == true) goto L50;
        if (r15 == 0) goto L48;
        if (r15 == 2) goto L46;
        if (r15 != 3) goto L44;
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L44:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L46:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L48:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L50:
        r26.b(dg.a.class).getClass();
        throw new ClassCastException();
    L53:
        throw new IllegalArgumentException("Unsupported HTTP Method.");
    L10:
        if (r17 != null) goto L12;
        TextUtils.isEmpty(null);
    L55:
        throw new IllegalArgumentException("Unsupported HTTP url. url is not valid.");
    L57:
        throw new IllegalArgumentException("Unsupported HTTP url. url is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 3;
        int r10 = 1;
        int r11 = 0;
        Object[] r12 = 0;
        Object[] r13 = 0;
        switch(this.f6689a) {
            case 0: goto L28;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            default: goto L4;
        };
    L4:
        long r14 = System.currentTimeMillis();
        z4.b r15 = (z4.b) this.f6691c;
        if (r15.e != null) goto L7;
        r15.c(r15.f);
    L7:
        a5.d r16 = ((z4.b) this.f6691c).e.a();
        if (r16 == null) goto L10;
        ((z4.b) this.f6691c).f23392a = r16;
        f8.b.b();
        d5.b.c("HybridSettingRequestService", ((z4.b) this.f6691c).f23392a.f107b.toString());
        d5.b.f("HybridSettingRequestService_update", "monitor setting update succeeded");
        z4.b r17 = (z4.b) this.f6691c;
        r17.b(r17.f23392a.d);
    L11:
        ((z4.b) this.f6691c).getClass();
        a5.d r18 = ((z4.b) this.f6691c).e.c();
        if (r18 == null) goto L14;
        ((z4.b) this.f6691c).f23392a = r18;
    L14:
        f8.b.h();
        if (this.f6690b == false) goto L17;
        HashMap r19 = new HashMap();
        r19.put("setting_id", String.valueOf(((z4.b) this.f6691c).f23392a.e));
        i.b(r19, null, "startup_init");
    L17:
        d5.b.c("HybridSettingRequestService", "_loopUpdate JsonOptConfig.isJsonOptEnable(): false");
        d5.b.c("HybridSettingRequestService", "_loopUpdate cost: " + (System.currentTimeMillis() - r14));
        return;
    L10:
        d5.b.e("HybridSettingRequestService_update", "monitor setting update failed");
        ((z4.b) this.f6691c).b(600);
        goto L11
    L19:
        ((v6.e) this.f6691c).b();
        ((v6.e) this.f6691c).getClass();
        return;
    L21:
        a();
        throw null;
    L23:
        boolean r20 = this.f6690b;
        OListItemGeneral r21 = (OListItemGeneral) this.f6691c;
        if (r20 == false) goto L26;
        int r22 = r21.getMClContent().getLeft();
        int r23 = com.lynx.tasm.utils.a.C(r21, 0.6d);
        int r24 = r21.getResources().getColor(R$color.oui_line_2);
        com.obric.oui.common.style.i r25 = r21.f13532b;
        r25.f12493l = r22;
        r25.f12494m = 0;
        r25.f12495n = r24;
        r25.f12492k = r23;
        r25.v();
        return;
    L26:
        int r26 = r21.getMClContent().getLeft();
        int r27 = R$color.oui_line_2;
        com.obric.oui.common.style.i r28 = r21.f13532b;
        r28.f12493l = r26;
        r28.f12494m = 0;
        r28.f12495n = r27;
        r28.f12492k = 0;
        r28.v();
        return;
    L28:
        AtomicBoolean r29 = d.f;
        boolean r30 = r29.get();
        ReqType r31 = (ReqType) this.f6691c;
        if (r30 == false) goto L31;
        GeckoLogger.a("settings is syncing, return, next fetch type is " + r31);
        d.f6696i = r31;
        return;
    L31:
        r29.set(true);
        CopyOnWriteArrayList r32 = GeckoLogger.f4756a;
        ReportNode r33 = ReportNode.SYNC_GLOBAL_SETTING;
        StringBuilder r34 = new StringBuilder("settings start, retry: ");
        boolean r35 = this.f6690b;
        r34.append(r35);
        r34.append(", reqType: ");
        r34.append(r31);
        GeckoLogger.a(r33, r34.toString());
        d.f6695h = r31;
        ff.a r36 = new ff.a();
        ReqType r37 = ReqType.NORMAL;
        r36.f = r37;
        d.g = r36;
        d.a().e = r35;
        if (r31 != r37) goto L35;
        df.c.f16648a.set(true);
    L35:
        if (d.e.compareAndSet(false, true) == false) goto L133;
        CopyOnWriteArraySet r38 = df.e.f16654a;
        com.bytedance.geckox.c r39 = com.bytedance.geckox.b.f4736a;
        AppSettingsManager$IGeckoAppSettings r40 = r39.a();
        if (r40 == null) goto L39;
        r39.f4742c = Boolean.valueOf(r40.isRegisterBySPI());
    L39:
        GeckoLogger.a("getRegisterBySPI: " + ((Boolean) r39.f4742c));
        boolean r41 = ((Boolean) r39.f4742c).booleanValue();
        CopyOnWriteArrayList r42 = df.e.f16656c;
        if (r41 == false) goto L52;
        GeckoLogger.a("register by spi");
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L46
        Iterator r44 = ServiceLoader.load(IGeckoRegister.class, Looper.getMainLooper().getThread().getContextClassLoader()).iterator();     // Catch: Throwable -> L46
    L44:
        if (r44.hasNext() == false) goto L48;
        r42.add((IGeckoRegister) r44.next());     // Catch: Throwable -> L46
        goto L44
    L48:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L52:
        if (r42.isEmpty() == true) goto L68;
        StringBuilder r46 = new StringBuilder();
        StringBuilder r47 = new StringBuilder();
        Iterator r48 = r42.iterator();
    L56:
        if (r48.hasNext() == false) goto L62;
        IGeckoRegister r49 = (IGeckoRegister) r48.next();
        String r110 = r49.getClass().getName();
        if (df.e.f16654a.contains(r110) == false) goto L60;
        r46.append(r110.concat(";"));
    L61:
        df.e.a(r49, false);
        goto L56
    L60:
        r47.append(r110.concat(";"));
        goto L61
    L62:
        EventSubType r50 = EventSubType.f6599b;
        String r51 = r47.toString();
        String r52 = r46.toString();
        JSONObject r53 = new JSONObject();
        r53.put("sub_type", r50.f6615a);
        if (r51 == null) goto L65;
        r53.put("err_msg", r51);
    L65:
        if (r52 == null) goto L67;
        r53.put("extra", r52);
    L67:
        j.g("geckosdk_event_message", r53);
    L68:
        GlobalConfigSettings r54 = d.f6692a;
        if (r54 == null) goto L133;
        GlobalConfigSettings.SettingsConfig r55 = r54.getSettingsConfig();
        if (r55 == null) goto L133;
        if (r55.getPollingInterval() <= 0) goto L133;
        long r111 = r55.getPollingInterval() * ((long) 1000);
        we.a r56 = bb.c.f895a;
        ((w) r56.f22857a).e(new f(r10), r111, r111);
    L133:
        d.b(r31, r35);     // Catch: Throwable -> L78
    L86:
        if (r31 != ReqType.NORMAL) goto L88;
        ConcurrentHashMap r57 = va.b.f22564a;
        com.bytedance.geckox.c r58 = com.bytedance.geckox.b.f4736a;
        va.b.d.e(new f(r5), 2000, 120000);
        new w("upload_online_stats", 1).e(new f(r11), 0, 300000);
        ((Handler) com.bytedance.geckox.utils.c.f4792b.getValue()).postDelayed(bb.e.f900c, 120000);
    L88:
        d.f.set(false);
        ReqType r59 = d.f6696i;
        ReqType r60 = ReqType.REGISTER_LATE;
        if (r59 != r60) goto L91;
        GeckoLogger.a("sync global settings with REGISTER_LATE");
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new b(r13 == true ? 1 : 0, r12 == true ? 1 : 0, r60));
    L91:
        d.f6696i = null;
        AtomicBoolean r61 = gf.a.f17088a;
        if (l.b() == true) goto L94;
        GeckoLogger.a("coldStart update failed, gecko disable");
    L98:
        GlobalConfigSettings r62 = d.f6692a;
        if (r62 == null) goto L141;
        GlobalConfigSettings.ReqMeta r63 = r62.getReqMeta();
        if (r63 == null) goto L142;
        AtomicBoolean r64 = gf.b.f17090a;
        int r65 = r63.getPollingInterval();
        GeckoLogger.a("loop update by settings: " + r65);
        int r66 = gf.b.f17091b;
        AtomicBoolean r67 = gf.b.f17090a;
        if (r66 == r65) goto L112;
        if (r67.get() == false) goto L110;
        GeckoLogger.a("loop stop: " + gf.b.f17091b);
        r67.set(false);
        bb.b r68 = (bb.b) ((w) bb.c.f895a.f22857a).f9377c;
        if (r68 == null) goto L110;
        r68.removeMessages(3);
    L110:
        gf.b.f17091b = r65;
    L112:
        if (l.b() == true) goto L114;
    L118:
        Object[] r69 = false;
    L119:
        if (r69 == true) goto L121;
    L123:
        if (r69 == false) goto L125;
        return;
    L125:
        if (r67.get() == false) goto L145;
        GeckoLogger.a("loop stop: " + gf.b.f17091b);
        r67.set(false);
        bb.b r70 = (bb.b) ((w) bb.c.f895a.f22857a).f9377c;
        if (r70 == null) goto L146;
        r70.removeMessages(3);
        return;
    L146:
        return;
    L145:
        return;
    L121:
        if (r67.get() == true) goto L123;
        GeckoLogger.a("loop start: " + gf.b.f17091b);
        r67.set(true);
        long r71 = ((long) gf.b.f17091b) * 1000;
        we.a r72 = bb.c.f895a;
        ((w) r72.f22857a).e(new f(2), r71, r71);
        return;
    L114:
        if (gf.b.f17091b <= 0) goto L118;
        if (gf.b.f17092c == false) goto L118;
        r69 = true;
        goto L119
    L142:
        return;
    L141:
        return;
    L94:
        AtomicBoolean r73 = gf.a.f17088a;
        if (r73.get() == true) goto L98;
        GeckoLogger.a("coldStart update");
        r73.set(true);
        RequestBodyUpdate r74 = new RequestBodyUpdate(ReqType.QUEUE);
        r74.initCustom();
        gf.a.f17089b.set(true);
        new g(r74).e();
    L78:
        th = move-exception;
        d.a().f16895c = th.getMessage();
        d.a().a();
        GeckoLogger.a("sync global settings exception:" + th.getMessage());
        l9.g r75 = d.d;
        if (r75 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mExponentialBackoffRetry");
    L83:
        if (((AtomicBoolean) r75.e).compareAndSet(false, true) == false) goto L86;
        r75.c();
        goto L86
    }

    public b(OListItemGeneral r5, boolean r10, OListItemGeneral r11) {
        this.f6689a = 1;
        this.f6690b = r10;
        this.f6691c = r11;
    }

    public b(HttpRequest r5, boolean r10) {
        this.f6689a = 2;
        this.f6691c = r5;
        new AtomicBoolean(false);
        this.f6690b = r10;
    }
}
