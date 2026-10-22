package com.bytedance.pia.core.worker.binding;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.utils.a;
import com.bytedance.pia.core.utils.j;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.b;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import nh.d;
import org.json.JSONObject;
import rh.c;
import rh.i;

/* JADX INFO: loaded from: classes2.dex */
public class BaseModule extends JSModule {
    public static final String NAME = "BaseModule";
    private static final String ON_BRIDGE_MESSAGE = "globalThis.__PIA_NATIVE__.onWorkerBridgeMessage();";
    private static final String ON_MESSAGE = "globalThis.__PIA_NATIVE__.onWorkerMessage();";
    public static final String PROPS_BUSINESS = "businessProps";
    private static final String PROPS_SETTINGS = "settings";
    private final ConcurrentLinkedQueue<JavaOnlyMap> localBridgeMessages;
    private final ConcurrentLinkedQueue<JavaOnlyMap> localMessages;
    private final a remoteBridgeMessages;
    private final a remoteMessages;
    private final i worker;

    public BaseModule(Context r5, Object r10) {
        super(r5, r10);
        this.remoteMessages = new a();
        this.localMessages = new ConcurrentLinkedQueue();
        this.remoteBridgeMessages = new a();
        this.localBridgeMessages = new ConcurrentLinkedQueue();
        this.worker = (i) r10;
    }

    public static /* synthetic */ void a(Callback r5, String r10) {
        lambda$importScriptsAsync$1(r5, r10);
    }

    public static /* synthetic */ void b(Callback r5, String r10) {
        lambda$importScriptsAsync$0(r5, r10);
    }

    private static /* synthetic */ void lambda$importScriptsAsync$0(Callback r5, String r10) {
        if (r5 == null) goto L5;
        r5.invoke(new Object[]{r10});
        return;
    }

    private static /* synthetic */ void lambda$importScriptsAsync$1(Callback r5, String r10) {
        if (r5 == null) goto L5;
        r5.invoke(new Object[]{r10});
        return;
    }

    @b
    public WritableMap getBridgeMessage() {
        return this.localBridgeMessages.poll();
    }

    @b
    public WritableMap getGlobalProps() {
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put(PROPS_SETTINGS, new JavaOnlyMap());
        Map r10 = this.worker.f21771p;
        if (r10 == null) goto L6;
        r5.put(PROPS_BUSINESS, j.e(com.bytedance.pia.core.utils.i.a().toJsonTree(r10).getAsJsonObject()));
        return r5;
    L6:
        r5.put(PROPS_BUSINESS, new JavaOnlyMap());
        return r5;
    }

    @b
    public String getHref() {
        return this.worker.f21766k.toString();
    }

    @b
    public WritableMap getMessage() {
        return this.localMessages.poll();
    }

    @b
    public String getUserAgent() {
        return this.worker.f21768m;
    }

    @b
    public String getWorkerName() {
        return this.worker.g;
    }

    @b
    public void importScriptsAsync(final String r10, Callback r11, Callback r12) {
        final i r13 = this.worker;
        final sh.a r5 = new sh.a(r11, 0);
        sh.a r14 = new sh.a(r12, 1);
        r13.getClass();
        final long r15 = System.currentTimeMillis();
        final n0 r16 = new n0(r13, r14);
        fh.a r17 = new c(r13, r15, r5, r10, r16);
        boolean r18 = TextUtils.isEmpty(r10);
        d r19 = r13.f21773r;
        if (r18 == false) goto L5;
        r19.f20239j.b(-2, "worker", "script url is empty.");
        r16.accept(new RuntimeException("invalid url"));
    L5:
        Uri r20 = Uri.parse(r10);
        if (j.z(r20) == true) goto L8;
        r19.f20239j.b(-2, "worker", r20.toString());
        r16.accept(new RuntimeException("invalid url"));
    L8:
        androidx.core.view.inputmethod.a r21 = new androidx.core.view.inputmethod.a(r20, 14);
        r13.f21767l.a(r21, r17, r16);
    }

    @b
    public void log(String r5, int r10) {
        if (r10 != 0) goto L5;
        String r11 = this.worker.f21763h + r5;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r11, "message");     // Catch: Throwable -> L11
        j.q(r11, null);     // Catch: Throwable -> L11
    L17:
        this.worker.f21773r.g("event-on-worker-log", new Object[]{r5, Integer.valueOf(r10)});     // Catch: Throwable -> L11
        return;
    L5:
        if (r10 != 1) goto L7;
        j.A(this.worker.f21763h + r5);     // Catch: Throwable -> L11
        goto L17
    L7:
        if (r10 != 2) goto L9;
        String r12 = this.worker.f21763h + r5;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r12, "message");     // Catch: Throwable -> L11
        j.C(r12, null);     // Catch: Throwable -> L11
        goto L17
    L9:
        if (r10 == 3) goto L13;
        String r13 = this.worker.f21763h + r5;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r13, "message");     // Catch: Throwable -> L11
        j.B(r13);     // Catch: Throwable -> L11
        goto L17
    L13:
        j.s(this.worker.f21763h + r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Intrinsics.checkNotNullParameter("Worker invoke log error:", "message");
        j.C("Worker invoke log error:", th);
    }

    @b
    public void postBridgeMessage(ReadableMap r5) {
        if (r5 == null) goto L5;
        this.remoteBridgeMessages.c(r5);
        return;
    }

    @b
    public void postMessage(ReadableMap r5) {
        if (r5 == null) goto L6;
        this.remoteMessages.c(r5);
        return;
    L6:
        throw new NullPointerException("message can not be null!");
    }

    public void sendWorkerBridgeMessage(JavaOnlyMap r5) {
        this.localBridgeMessages.offer(r5);
        this.worker.f(ON_BRIDGE_MESSAGE);
    }

    public void sendWorkerMessage(JavaOnlyMap r5) {
        this.localMessages.offer(r5);
        this.worker.f(ON_MESSAGE);
    }

    public void setBridgeMessageHandle(fh.a r5) {
        this.remoteBridgeMessages.b(r5);
    }

    public void setMessageHandle(fh.a r5) {
        this.remoteMessages.b(r5);
    }

    @b
    public void terminate() {
        this.worker.b(null);
    }

    @b
    public void terminateWithResult(ReadableMap r5) {
        if (r5 != null) goto L5;
        this.worker.b(null);
        return;
    L5:
        this.worker.b(j.g(r5));
    }

    @b
    public void trace(String r10) {
        if (r10 != null) goto L17;
        return;
    L17:
        JSONObject r5 = new JSONObject(r10);     // Catch: Throwable -> L16
        Iterator<String> r11 = r5.keys();     // Catch: Throwable -> L16
    L5:
        if (r11.hasNext() == false) goto L29;
        String r12 = r11.next();     // Catch: Throwable -> L16
        Object r13 = r5.opt(r12);     // Catch: Throwable -> L16
        if (r13 == null) goto L5;
        if ((r13 instanceof Number) == true) goto L12;
        this.worker.f21773r.f20246q.f18645b.a(r12, r13);     // Catch: Throwable -> L16
        goto L5
    L12:
        this.worker.f21773r.f20246q.a(r12, ((Long) r13).longValue());     // Catch: Throwable -> L16
        goto L5
    L29:
        return;
    }
}
