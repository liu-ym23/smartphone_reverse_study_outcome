package com.ss.android.lark.jsruntime.vmsdk.module;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.jsruntime.vmsdk.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\fH\u0007J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VmSdkEventEmitterModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "Lcom/ss/android/lark/jsruntime/vmsdk/Interface/IJSRuntimeDataSender;", "context", "Landroid/content/Context;", "host", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "getHost", "()Ljava/lang/Object;", "listenerCount", "", "worker", "Lcom/bytedance/vmsdk/worker/JsWorker;", "getWorker", "()Lcom/bytedance/vmsdk/worker/JsWorker;", "setWorker", "(Lcom/bytedance/vmsdk/worker/JsWorker;)V", "addListener", "", "eventName", "", "removeListeners", "count", "sendEvent", "data", "map", "", "Companion", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class VmSdkEventEmitterModule extends JSModule implements tnb.b {
    public static final a Companion = null;
    public static final String NAME = "VMEventEmitter";
    private static final String TAG = "VMSDK_VmSdkEventEmitterModule";
    private final Object host;
    private int listenerCount;
    private JsWorker worker;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ VmSdkEventEmitterModule a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(VmSdkEventEmitterModule r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JsWorker r0 = this.a.getWorker();     // Catch: Throwable -> L12
            if (r0 == null) goto L10;
            VmsdkEventEmitter r1 = (VmsdkEventEmitter) r0.getJavaScriptModule(VmsdkEventEmitter.class);     // Catch: Throwable -> L12
            if (r1 == null) goto L10;
            String r2 = this.b;     // Catch: Throwable -> L12
            String r3 = this.c;     // Catch: Throwable -> L12
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            r1.emit(r2, r3);     // Catch: Throwable -> L12
        L17:
            return;
        L10:
            rnb.c.b(VmSdkEventEmitterModule.TAG, "sendEvent: getJavaScriptModule is null");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ VmSdkEventEmitterModule a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map<String, Object> c;

        public c(VmSdkEventEmitterModule r1, String r2, Map<String, ? extends Object> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            JsWorker r0 = this.a.getWorker();
            if (r0 == null) goto L33;
            VmsdkEventEmitter r1 = (VmsdkEventEmitter) r0.getJavaScriptModule(VmsdkEventEmitter.class);
            if (r1 == null) goto L33;
            String r2 = this.b;
            Map<String, Object> r3 = this.c;
            JavaOnlyMap r4 = new JavaOnlyMap();
            Iterator<Map.Entry<String, Object>> r5 = r3.entrySet().iterator();
        L8:
            if (r5.hasNext() == false) goto L30;
            Map.Entry<String, Object> r6 = r5.next();
            String r7 = r6.getKey();
            Object r8 = r6.getValue();
            if ((r8 instanceof Integer) == true) goto L11;
            if ((r8 instanceof String) == true) goto L14;
            if ((r8 instanceof Boolean) == true) goto L17;
            if ((r8 instanceof Double) == true) goto L20;
            if ((r8 instanceof Float) == true) goto L23;
            if ((r8 instanceof Long) == true) goto L26;
            if (r8 != null) goto L8;
            r4.putNull(r7);
            goto L8
        L26:
            r4.putLong(r7, ((Number) r8).longValue());
            goto L8
        L23:
            r4.putDouble(r7, ((Number) r8).floatValue());
            goto L8
        L20:
            r4.putDouble(r7, ((Number) r8).doubleValue());
            goto L8
        L17:
            r4.putBoolean(r7, ((Boolean) r8).booleanValue());
            goto L8
        L14:
            r4.putString(r7, (String) r8);
            goto L8
        L11:
            r4.putInt(r7, ((Number) r8).intValue());
            goto L8
        L30:
            if (r3.size() == r4.size()) goto L32;
            rnb.c.b("VMSDK_VMSDKEngine", "toWritableMap: size not match");
        L32:
            r1.emit(r2, r4);
            return;
        L33:
            rnb.c.b(VmSdkEventEmitterModule.TAG, "sendEvent: getJavaScriptModule is null");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public final Object getHost() {
        return this.host;
    }

    public final JsWorker getWorker() {
        return this.worker;
    }

    @JSMethod
    public final void addListener(String r5) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        rnb.c.c(TAG, "[vmsdk] VMEventEmitter addListener " + r5 + " listenerCount:" + this.listenerCount);
        int r6 = this.listenerCount + 1;
        this.listenerCount = r6;
        if (r6 != 2) goto L15;
        Object r7 = this.host;
        if (r7 != null) goto L7;
        return;
    L7:
        if ((r7 instanceof j) == false) goto L17;
        j r8 = (j) r7;
        Intrinsics.checkNotNullParameter(this, "jsBridge");
        rnb.c.c("VMSDK_VMSDKEngine", "onJSBridgeReady() called with: jsBridge = " + this);
        rnb.c.c("VMSDK_VMSDKEngine", "notifyReadyListener: listeners:" + ((ArrayList) r8.e).size() + " isReady:" + r8.f);
        r8.f = true;
        Iterator r0 = ((ArrayList) r8.e).iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        ((tnb.e) r0.next()).onReady();
        goto L10
    L12:
        this.worker = r8.c;
        return;
    L17:
        return;
    }

    @JSMethod
    public final void removeListeners(int r3) {
        rnb.c.c(TAG, "[vmsdk] VMEventEmitter removeListeners " + r3);
        this.listenerCount = Math.max(this.listenerCount - r3, 0);
    }

    public final void setWorker(JsWorker r1) {
        this.worker = r1;
    }

    public VmSdkEventEmitterModule(Context r1, Object r2) {
        super(r1);
        this.host = r2;
    }

    @Override // tnb.b
    public void sendEvent(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        if (r4 == null) goto L8;
        JsWorker r1 = this.worker;
        if (r1 == null) goto L7;
        r1.postOnJSRunnerDelay(new c(this, r3, r4), 0);
        return;
    L7:
        rnb.c.b(TAG, "sendEvent: worker is null");
        return;
    L8:
        rnb.c.b(TAG, "sendEvent: map is null");
    }

    @Override // tnb.b
    public void sendEvent(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        JsWorker r0 = this.worker;
        if (r0 == null) goto L5;
        r0.postOnJSRunnerDelay(new b(this, r3, r4), 0);
        return;
    L5:
        rnb.c.b(TAG, "sendEvent: worker is null");
    }
}
