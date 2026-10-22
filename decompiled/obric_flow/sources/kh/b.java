package kh;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.ai.model.JSWorkerRuntime;
import com.bytedance.ies.bullet.web.pia.f;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.pia.core.metrics.MetricsType;
import com.bytedance.pia.core.plugins.StreamingPlugin;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.pia.core.worker.Worker$Status;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.Intrinsics;
import nh.h;
import oh.e;
import rh.i;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18641c;

    public /* synthetic */ b(int r5, Object r10, Object r11) {
        this.f18639a = r5;
        this.f18640b = r10;
        this.f18641c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 1;
        switch(this.f18639a) {
            case 0: goto L51;
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L41;
            case 5: goto L37;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L21;
            case 9: goto L19;
            case 10: goto L17;
            default: goto L4;
        };
    L4:
        nh.d r10 = (nh.d) this.f18640b;
        r10.getClass();
        Application r11 = zg.b.f23438a;
        r10.e(null);
        e r12 = oh.d.f20576a;
        HashMap r13 = r12.f20577a;
        String r14 = (String) this.f18641c;
        zg.c r15 = (zg.c) r13.get(r14);
        if (r15 != null) goto L7;
        r15 = new zg.c();
    L7:
        f r16 = r15.f;
        if (r16 == null) goto L10;
        r10.e(r16);
    L10:
        ArrayList r17 = zg.b.d;
        r10.h(r17);
        zg.c r18 = (zg.c) r12.f20577a.get(r14);
        if (r18 != null) goto L13;
        r18 = new zg.c();
    L13:
        ArrayList r19 = r18.d;
        if (r19 == r17) goto L66;
        r10.h(r19);
        return;
    L66:
        return;
    L17:
        y2.d.h((y2.d) this.f18640b, (String) this.f18641c);
        return;
    L19:
        JSWorkerRuntime.AppletReceiveMessageFunc r20 = (JSWorkerRuntime.AppletReceiveMessageFunc) ((y2.a) this.f18640b).f23230b.getJavaScriptFunction(JSWorkerRuntime.AppletReceiveMessageFunc.class);
        JavaOnlyMap r21 = (JavaOnlyMap) this.f18641c;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");
        r20.appletReceiveMessage(r21);
        return;
    L21:
        i r22 = (i) this.f18640b;
        com.bytedance.pia.core.utils.a r23 = r22.f21761b;
        Throwable r24 = (Throwable) this.f18641c;
        if (r24 != null) goto L24;
        r23.c("Load resource failed.");
    L25:
        r22.f21769n.terminate();
        return;
    L24:
        r23.c("Load resource failed, error: " + r24.getMessage());
        goto L25
    L27:
        i r25 = (i) this.f18640b;
        r25.getClass();
        r25.a(EventName.f).a();
        r25.f21773r.s.b("NPS");
        String r26 = r25.f21764i.toString();
        JsWorker r27 = r25.f21769n;
        r27.evaluateJavaScript((String) this.f18641c, r26);
        r27.evaluateJavaScript("if(typeof globalThis.__activate==='function'){globalThis.__activate();}");
        r25.f21775u = Worker$Status.f7164c;
        return;
    L29:
        String r28 = (String) this.f18640b;
        ConcurrentHashMap r29 = h.f20259a;     // Catch: Throwable -> L60
        Object r30 = r29.get(r28);     // Catch: Throwable -> L60
        FutureTask r31 = (FutureTask) this.f18641c;
        if (r30 != r31) goto L67;
        r29.remove(r28);     // Catch: Throwable -> L60
        nh.d r32 = (nh.d) r31.get();     // Catch: Throwable -> L60
        if (r32 == null) goto L68;
        r32.release();     // Catch: Throwable -> L60
        return;
    L68:
        return;
    L67:
        return;
    L69:
        return;
    L37:
        View r33 = ((StreamingPlugin) this.f18640b).f20236b.c();
        if ((r33 instanceof WebView) == false) goto L70;
        Intrinsics.checkNotNullParameter("[Streaming] appendChunkByBridge by evaluate JavaScript.", "message");
        j.y("[Streaming] appendChunkByBridge by evaluate JavaScript.", null);
        StringBuilder r34 = new StringBuilder("(function(_){function n(_){if(!window.__PAGE_FINISH__){window.__PIA_DEV__&&console.log(_);var n=document.createRange();n.selectNode(document.body);var e=n.createContextualFragment(_);document.body.appendChild(e)}}window.__pia_chunks__||(window.__pia_chunks__=[]),window.__pia_chunks__.push(_),function _(){if(\"undefined\"!=typeof document&&\"complete\"===document.readyState){if(window.__pia_chunks__)for(var e=0;e<window.__pia_chunks__.length;e++)n(window.__pia_chunks__[e]);window.__pia_chunks__=[]}else setTimeout(_,50)}()})");
        j.r(r34, (String) this.f18641c);
        r34.append(";");
        String r35 = r34.toString();
        Intrinsics.checkNotNullParameter(r35, "script");
        j.o((WebView) r33, r35, null);
        return;
    L70:
        return;
    L41:
        StreamingPlugin r36 = (StreamingPlugin) this.f18640b;
        r36.getClass();
        Intrinsics.checkNotNullParameter("[Streaming] Evaluate render polyfill.", "message");
        j.y("[Streaming] Evaluate render polyfill.", null);
        mh.i r37 = new mh.i(r36, r5);
        WebView r38 = (WebView) this.f18641c;
        j.o(r38, "(function(a){var t=function(e){if(e&&e.data&&\"streaming\"===e.data&&e.ports&&e.ports[0]){window.removeEventListener(\"message\",t);var n=e.ports[0];n.onmessage=function(t){t.data&&\"string\"==typeof t.data&&a(t.data)},n.postMessage(\"streaming_ack\")}};window.addEventListener(\"message\",t)})(function(_){function n(_){if(!window.__PAGE_FINISH__){window.__PIA_DEV__&&console.log(_);var n=document.createRange();n.selectNode(document.body);var e=n.createContextualFragment(_);document.body.appendChild(e)}}window.__pia_chunks__||(window.__pia_chunks__=[]),window.__pia_chunks__.push(_),function _(){if(\"undefined\"!=typeof document&&\"complete\"===document.readyState){if(window.__pia_chunks__)for(var e=0;e<window.__pia_chunks__.length;e++)n(window.__pia_chunks__[e]);window.__pia_chunks__=[]}else setTimeout(_,50)}()});", r37);
        Uri r39 = r36.f20236b.g;
        if (j.a(r38) < 66) goto L71;
        WebMessagePort[] r40 = r38.createWebMessageChannel();
        r40[0].setWebMessageCallback(new hh.b(r36, r40, 2), (Handler) m.f7156b.getValue());
        r38.postWebMessage(new WebMessage("streaming", new WebMessagePort[]{r40[1]}), r39);
        return;
    L71:
        return;
    L45:
        mh.f r41 = (mh.f) this.f18640b;
        r41.getClass();
        ((WebView) this.f18641c).addJavascriptInterface(r41, "pia_props");
        return;
    L47:
        LynxMapView.i((LynxMapView) this.f18640b, (ReadableArray) this.f18641c);
        return;
    L49:
        ((m1.i) this.f18640b).h((j2.b) this.f18641c);
        return;
    L51:
        Iterator r42 = ((c) this.f18640b).f18643c.iterator();
    L53:
        if (r42.hasNext() == false) goto L59;
        if (r42.next() == null) goto L53;
        throw new ClassCastException();
    }

    public /* synthetic */ b(c r5, MetricsType r10, Map r11) {
        this.f18639a = 0;
        this.f18640b = r5;
        this.f18641c = r11;
    }
}
