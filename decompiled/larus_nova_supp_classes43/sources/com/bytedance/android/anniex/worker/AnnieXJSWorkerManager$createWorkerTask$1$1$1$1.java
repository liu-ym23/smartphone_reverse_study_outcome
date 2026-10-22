package com.bytedance.android.anniex.worker;

import android.app.Application;
import android.content.Context;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "isSuccess", "", "jsBundle", "", MessageIndication.MESSAGE_TYPE_MSG, "version", "md5", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXJSWorkerManager$createWorkerTask$1$1$1$1 extends Lambda implements Function5<Boolean, String, String, String, String, Unit> {
    final /* synthetic */ Application $context;
    final /* synthetic */ String $resUrl;
    final /* synthetic */ AnnieXJSWorkerManager this$0;

    public AnnieXJSWorkerManager$createWorkerTask$1$1$1$1(String r1, AnnieXJSWorkerManager r10, Application r11) {
        this.$resUrl = r1;
        this.this$0 = r10;
        this.$context = r11;
        super(5);
    }

    public final void invoke(boolean r11, String r12, String r13, String r14, String r15) {
        s26.d r0 = s26.d.c;
        r r1 = s26.d.c.c(r.class);
        if (r1 == null) goto L14;
        c1 r10 = new c1("anniex_worker_fetch_js", null, null, null, null, 254);
        String r16 = this.$resUrl;
        JSONObject r17 = new JSONObject();
        r17.put("res_url", r16);
        r17.put(com.bytedance.android.ec.core.event.a.KEY_IS_SUCCESS, r11);
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        r17.put(MessageIndication.MESSAGE_TYPE_MSG, r13);
        if (r14 != null) goto L10;
        r14 = "";
    L10:
        r17.put("version", r14);
        if (r15 != null) goto L13;
        r15 = "";
    L13:
        r17.put("md5", r15);
        r10.d = r17;
        r1.S(r10);
    L14:
        if (r11 == false) goto L54;
        if (r12 == null) goto L55;
        AnnieXJSWorkerManager r18 = this.this$0;
        Application r19 = this.$context;
        AnnieXJSWorkerManager r110 = AnnieXJSWorkerManager.a;
        r18.getClass();
        final c r111 = new c(r19);
        AnnieXJSWorkerManager.c = r111;
        JSModuleManager r112 = new JSModuleManager(r111.a);
        com.bytedance.vmsdk.worker.a.a r113 = new com.bytedance.vmsdk.worker.a.a();
        r113.a = JsWorker.EngineType.QUICKJS;
        r113.f = r112;
        r113.b = "annieX";
        JsWorker r114 = new JsWorker(new com.bytedance.vmsdk.worker.a(r113));
        r114.setOnMessageCallback(new AnnieXJSWorker$startWorker$1$1(r111));
        r114.setOnErrorCallback(new AnnieXJSWorker$startWorker$1$2(r111));
        r111.b = r114;
        JSWorkerBDXBridge r115 = new JSWorkerBDXBridge(r111.a, UUID.randomUUID().toString());
        r115.r(r115.m);
        k16.b r116 = s26.d.c.d("default_bid", k16.b.class);
        boolean r20 = false;
        if (r116 == null) goto L34;
        m16.b r21 = new m16.b();
        r111.c = r21;
        r21.d(Context.class, r115.getContext());
        m16.b r22 = r111.c;
        if (r22 == null) goto L21;
        r22.d(e.class, new e(0));
    L21:
        m16.b r23 = r111.c;
        if (r23 == null) goto L24;
        r23.d(IDLXBridgeMethod.b.class, new a(r115));
    L24:
        m16.b r24 = r111.c;
        if (r24 == null) goto L27;
        r24.d(XBridgeMethod.b.class, new b(r115));
    L27:
        m16.b r25 = r111.c;
        if (r25 != null) goto L30;
        r25 = new m16.b();
    L30:
        Iterator r117 = r116.L(r25).iterator();
    L32:
        if (r117.hasNext() == false) goto L34;
        r115.d((MethodFinder) r117.next());
    L34:
        Intrinsics.checkNotNullParameter(r111, "jsWorker");
        r115.k = r111;
        r112.b("bridge", AnnieXJSWorkerXBridgeModule.class, new AnnieXJSWorkerXBridgeModule.a(r115));
        s26.d r118 = s26.d.c;
        m0 r119 = s26.d.c.c(m0.class);
        if (r119 == null) goto L37;
        r119.a0();
    L37:
        c r120 = AnnieXJSWorkerManager.c;
        if (r120 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("annieXJSWorker");
        r120 = null;
    L40:
        r120.getClass();
        Intrinsics.checkNotNullParameter(r12, "jsBundle");
        if (r12.length() != 0) goto L43;
        r20 = true;
    L43:
        if (r20 == false) goto L45;
        HybridLogger.i("AnnieXJSWorker", "js is empty", null, 12);
    L48:
        r r121 = s26.d.c.c(r.class);
        if (r121 == null) goto L51;
        c1 r122 = new c1("create_anniex_worker_success", null, null, null, null, 254);
        JSONObject r123 = new JSONObject();
        r123.put("res_url", null);
        r122.d = r123;
        r121.S(r122);
    L51:
        AnnieXJSWorkerManager.b = true;
        return;
    L45:
        JsWorker r124 = r120.b;
        if (r124 == null) goto L48;
        r124.evaluateJavaScript(r12);
        goto L48
    L55:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14) {
        invoke(((Boolean) r10).booleanValue(), (String) r11, (String) r12, (String) r13, (String) r14);
        return Unit.INSTANCE;
    }
}
