package com.byted.cast.sink.api;

import android.app.Application;
import android.content.Context;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.sink.ISourceDeviceInfoListener;
import com.byted.cast.sdk.RTCStatistics;
import com.byted.cast.sink.api.multiple.IMultipleActiveControl;
import com.byted.cast.sink.api.multiple.IMultipleLoader;
import com.byted.cast.sink.api.multiple.IMultipleReverseControl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ByteLinkSink {
    public static final int ENGINE_CAST_ERROR = 501;
    public static final int ENGINE_CONNECT_ERROR = 500;
    public static final int ENGINE_FATAL_ERROR = 502;
    public static final int NSD_SERVER_PORT = 5001;
    public static final String NSD_SERVICE_NAME = "bytelink-cast";
    public static final int RENDER_EGL_SURFACE = 1;
    public static final int RENDER_SURFACE = 0;
    public static final int SYNC_LOW_LATENCY = 0;
    public static final int SYNC_NORMAL = 1;
    private static Map<String, ByteLinkSink> b;
    private com.byted.cast.sink.impl.b a;

    static {
        b = new HashMap();
    }

    private ByteLinkSink(ContextManager.CastContext r10) {
        this.a = new com.byted.cast.sink.impl.b(r10);
    }

    public static ByteLinkSink getInstance(ContextManager.CastContext r10) {
        if (r10 == null) goto L4;
        String r0 = r10.getContextId();
    L6:
        monitor-enter(ByteLinkSink.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (b.containsKey(r0) == false) goto L10;
        ByteLinkSink r11 = b.get(r0);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ByteLinkSink.class);     // Catch: Throwable -> L13
        return r11;
    L10:
        ByteLinkSink r12 = new ByteLinkSink(r10);     // Catch: Throwable -> L13
        b.put(r0, r12);     // Catch: Throwable -> L13
        r11 = r12;
        goto L11
    L4:
        r0 = "bytelink_sink";
        goto L6
    }

    public void destroy() {
        this.a.a();
    }

    public void dumpMediaData(int r10, int r11) {
        this.a.a(r10, r11);
    }

    public IMultipleActiveControl getMultipleActiveControl() {
        return this.a.c();
    }

    public IMultipleLoader getMultipleLoader() {
        return this.a.d();
    }

    public Object getOption(int r10, Object... r11) {
        return this.a.a(r10, r11);
    }

    public ServerInfo getServerInfo() {
        return this.a.e();
    }

    public RTCStatistics getStatistics() {
        return this.a.f();
    }

    public void init(Context r10, String r11) {
        this.a.a(r10, r11);
    }

    public void init(Context r10, String r11, boolean r12) {
        this.a.a(r10, r11, r12);
    }

    public boolean notifyPreempt(boolean r10, ClientInfo r11) {
        return this.a.a(r10, r11);
    }

    public void requestIdrFromSource(String r10) {
        this.a.b(r10);
    }

    public boolean reverseConnect(String r10, int r11) {
        return this.a.a(r10, r11);
    }

    public boolean reverseDisconnect() {
        return this.a.i();
    }

    public boolean reverseInvite(String r10) {
        return this.a.c(r10);
    }

    public void sendMetaData(String r10, String r11) {
        this.a.a(r10, r11);
    }

    public void setAVSyncType(int r10) {
        this.a.a(r10);
    }

    public void setApplication(Application r10) {
        this.a.a(r10);
    }

    public void setAudioDropPolicyByMs(int r10, int r11) {
        this.a.b(r10, r11);
    }

    public void setAudioMaxDelayByMs(int r10) {
        this.a.b(r10);
    }

    public void setLogLevel(int r10) {
        this.a.c(r10);
    }

    public void setMultipleReverseControl(IMultipleReverseControl r10) {
        this.a.a(r10);
    }

    public void setOnLogMonitor(IOnLogMonitor r10) {
        this.a.a(r10);
    }

    public void setOption(int r10, Object... r11) {
        this.a.b(r10, r11);
    }

    public void setPreemptListener(IPreemptListener r10) {
        this.a.a(r10);
    }

    public void setRenderMode(int r10) {
        this.a.d(r10);
    }

    public void setServerListener(IServerListener r10) {
        this.a.a(r10);
    }

    public void setSourceDeviceInfoListener(ISourceDeviceInfoListener r10) {
        this.a.a(r10);
    }

    public void startServer(String r10) {
        this.a.d(r10);
    }

    public void stopServer() {
        this.a.k();
    }
}
