package org.chromium;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.JavaInterceptorCallbackRegistry;
import com.bytedance.frameworks.baselib.network.utils.TTReflectIOException;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e extends TTEventListener {
    public static volatile e b;
    public boolean a;

    public static e a() {
        if (b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onColdStartFinish() {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onColdStartFinish();     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onColdStartFinish");     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onCronetBootSucceed() {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onCronetBootSucceed();     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onCronetBootSucceed");     // Catch: Throwable -> L18
        goto L21
    }

    public e() {
        this.a = false;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTLBDecompressFail() {
        TTRequestCompressManager.setGlobalForbidenCompress();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onClientIPChanged(String r7) {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onClientIPChanged(r7);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onEffectiveConnectionTypeChanged(int r7) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r7);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onEffectiveConnectionTypeChangedOnIOThread(r7);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b(r2).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onNetworkQualityLevelChanged(int r7) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r7);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onNetworkQualityLevelChangedOnIOThread(r7);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b(r2).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r7)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onNetworkQualityTypeChangedV3(int r11) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L24;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r11);
    L24:
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L21
        if (r1 == null) goto L27;
        r1.onEffectiveConnectionTypeChangedOnIOThread(r11);     // Catch: Throwable -> L21
        yx5.a.d("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r11)});     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L12:
        Object r2 = r0.a;     // Catch: Throwable -> L21
        if (r2 == null) goto L29;
        yx5.a.b r3 = yx5.a.b(r2);     // Catch: Throwable -> L21
        Class r7 = Integer.TYPE;     // Catch: Throwable -> L21
        r3.call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{r7}, new Object[]{Integer.valueOf(r11)});     // Catch: Throwable -> L21
        yx5.a.d("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{r7}, new Object[]{Integer.valueOf(r11)});     // Catch: Throwable -> L21
        return;
    L18:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTTNetDetectInfoChanged(String r7) {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r7);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onTTNetDetectInfoChanged(r7);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onUserSpecifiedNetworkEnabled(boolean r7) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r7);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onUserSpecifiedNetworkEnabled(r7);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b(r2).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r7)});     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final Map<String, String> onCallToAddSecurityFactor(String r9, Map<String, String> r10) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L5;
        d.a().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r9);
    L5:
        Map<String, String> r1 = null;
    L17:
        th = move-exception;
        th.printStackTrace();
    L19:
        return r1;
    L7:
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r2 = r0.b;     // Catch: Throwable -> L17
        if (r2 == null) goto L20;
        r1 = r2.onCallToAddSecurityFactor(r9, r10);     // Catch: Throwable -> L17
    L20:
        goto L19
    L12:
        Object r3 = r0.a;     // Catch: Throwable -> L17
        if (r3 == null) goto L20;
        r1 = (Map) yx5.a.b(r3).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r9, r10}).get();     // Catch: Throwable -> L17
        goto L20
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onDropReasonChanged(boolean r8, List<Integer> r9) {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r8 + ", Drop Reason List " + r9);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onDropReasonChanged(r8, r9);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r8), r9});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onMultiNetworkStateChanged(int r8, int r9) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r8 + ", curr state = " + r9);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onMultiNetworkStateChanged(r8, r9);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b r3 = yx5.a.b(r2);     // Catch: Throwable -> L16
        Class r4 = Integer.TYPE;     // Catch: Throwable -> L16
        r3.call("onMultiNetworkStateChanged", new Class[]{r4, r4}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onPublicIPsChanged(List<String> r8, List<String> r9) {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onPublicIPsChanged(r8, r9);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r8, r9});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final String onRequestInterceptorJava(String r1, Map<String, String> r2) {
        return JavaInterceptorCallbackRegistry.onRequestInterceptorJava(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTNCUpdateFailed(String[] r8, String r9) {
        if (this.a == false) goto L29;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L7;
        d.a().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L7:
        if (r8 == null) goto L30;
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        if (r8.length <= 0) goto L25;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L22
        Collections.addAll(r1, r8);     // Catch: Throwable -> L22
        if (NetworkParams.getOptReflection() == false) goto L17;
        ICronetAppProvider r10 = r0.b;     // Catch: Throwable -> L22
        if (r10 == null) goto L25;
        r10.onTNCUpdateFailed(r1, r9);     // Catch: Throwable -> L22
        goto L25
    L17:
        Object r11 = r0.a;     // Catch: Throwable -> L22
        if (r11 == null) goto L25;
        yx5.a.b(r11).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r1, r9});     // Catch: Throwable -> L22
    L25:
        return;
    L30:
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onWiFiToCellStateChanged(int r8, int r9) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onWiFiToCellStateChanged, prev state = " + r8 + ", curr state = " + r9);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onWiFiToCellStateChanged(r8, r9);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b r3 = yx5.a.b(r2);     // Catch: Throwable -> L16
        Class r4 = Integer.TYPE;     // Catch: Throwable -> L16
        r3.call("onWiFiToCellStateChanged", new Class[]{r4, r4}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onNetworkQualityRttAndThroughputNotified(int r9, int r10, int r11) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r9 + ", effectiveTrttMs: " + r10 + ", effectiveRxThroughputKbps: " + r11);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onNetworkQualityRttAndThroughputNotifiedOnIOThread(r9, r10, r11);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b r3 = yx5.a.b(r2);     // Catch: Throwable -> L16
        Class r4 = Integer.TYPE;     // Catch: Throwable -> L16
        r3.call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{r4, r4, r4}, new Object[]{Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onRTTOrThroughputEstimatesComputed(int r9, int r10, int r11) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r9 + ", transportRttMs = " + r10 + ",downstreamThroughputKbps = " + r11);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
        r1.onRTTOrThroughputEstimatesComputedOnIOThread(r9, r10, r11);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r2 = r0.a;     // Catch: Throwable -> L16
        if (r2 == null) goto L22;
        yx5.a.b r3 = yx5.a.b(r2);     // Catch: Throwable -> L16
        Class r4 = Integer.TYPE;     // Catch: Throwable -> L16
        r3.call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{r4, r4, r4}, new Object[]{Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final String onRequestInterceptorToStart(String r6, Map<String, String> r7, List<String> r8) {
        String r1 = null;
        if (NativeRequestInterceptor.a != null) goto L6;
    L34:
        return r1;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "request url:" + r6 + " headers:" + r7.toString() + " domains:" + r8);
    L8:
        NativeRequestInterceptor.c r9 = NativeRequestInterceptor.a.b(r6);
        if (r9 == null) goto L34;
        JSONObject r10 = new JSONObject();
        int r11 = NativeRequestInterceptor.a.a[r9.a.ordinal()];     // Catch: Throwable -> L25
        if (r11 != 1) goto L16;
        r10.put("modified", NativeRequestInterceptor.RequestModified.URL_MODIFIED.getValue());     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(null) == true) goto L36;
        new URI(null);
        r10.put("new_url", null);
    L36:
        goto L31
    L16:
        if (r11 != 2) goto L18;
        r10.put("modified", NativeRequestInterceptor.RequestModified.HEADER_MODIFIED.getValue());     // Catch: Throwable -> L25
        NativeRequestInterceptor.c.a(r10, r9.b);     // Catch: Throwable -> L25
        goto L36
    L18:
        if (r11 != 3) goto L36;
        r10.put("modified", NativeRequestInterceptor.RequestModified.BOTH_MODIFIED.getValue());     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(null) == false) goto L39;
    L24:
        NativeRequestInterceptor.c.a(r10, r9.b);     // Catch: Throwable -> L25
        goto L36
    L39:
        new URI(null);     // Catch: Exception -> L35
        r10.put("new_url", null);     // Catch: Exception -> L35
    L31:
        r1 = r10.toString();
        if (Logger.debug() == false) goto L34;
        Logger.d("NativeRequestInterceptor", "request json:" + r1);
        goto L34
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final String onResponseInterceptorToStart(String r3, Map<String, List<String>> r4, int r5) {
        if (NativeRequestInterceptor.a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "response url:" + r3 + " headers:" + r4.toString() + " code:" + r5);
    L8:
        NativeRequestInterceptor.a.a();
        return null;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onServerConfigUpdated(String r8, String r9, String r10) {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r8);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        r1.onServerConfigEtagChanged(r9);     // Catch: Throwable -> L18
        r0.b.onServerConfigABTestChanged(r10);     // Catch: Throwable -> L18
        r0.b.onServerConfigUpdated(r8);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r2 = r0.a;     // Catch: Throwable -> L18
        if (r2 == null) goto L21;
        yx5.a.b(r2).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r9});     // Catch: Throwable -> L18
        yx5.a.b(r0.a).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L18
        yx5.a.b(r0.a).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTncRequestSucceeded(boolean r9, boolean r10, int r11) {
        c r0 = c.h();
        r0.getClass();
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L14
        if (r1 == null) goto L17;
        r1.onTncRequestSucceeded(r9, r10, r11);     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        Object r2 = r0.a;     // Catch: Throwable -> L14
        if (r2 == null) goto L17;
        yx5.a.b r3 = yx5.a.b(r2);     // Catch: Throwable -> L14
        Class r4 = Boolean.TYPE;     // Catch: Throwable -> L14
        r3.call("onTncRequestSucceeded", new Class[]{r4, r4, Integer.TYPE}, new Object[]{Boolean.valueOf(r9), Boolean.valueOf(r10), Integer.valueOf(r11)}).get();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onPacketLossComputed(int r20, double r21, double r23, double r25, double r27) {
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r4 = r0.b;     // Catch: Throwable -> L17
        if (r4 == null) goto L21;
        r4.onPacketLossComputedOnIOThread(r20, r21, r23, r25, r27);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L12:
        Object r1 = r0.a;     // Catch: Throwable -> L17
        if (r1 == null) goto L23;
        yx5.a.b r2 = yx5.a.b(r1);     // Catch: Throwable -> L17
        Class r5 = Double.TYPE;     // Catch: Throwable -> L17
        r2.call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, r5, r5, r5, r5}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L17
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onStoreIdcChanged(String r13, String r14, String r15, String r16, String r17, String r18) {
        if (this.a == false) goto L25;
        c r0 = c.h();
        r0.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r3 = r0.b;     // Catch: Throwable -> L18
        if (r3 == null) goto L21;
        r3.onStoreIdcChanged(r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r1 = r0.a;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        yx5.a.b(r1).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r13, r14, r15, r16, r17, r18});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTTDnsResolveResult(String r15, String r16, int r17, int r18, int r19, List<String> r20, String r21) {
        c r1 = c.h();
        r1.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r15 + " host: " + r16);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r2 = r1.b;     // Catch: Throwable -> L16
        if (r2 == null) goto L20;
        r2.onTTDnsResolveResult(r15, r16, r17, r18, r19, r20, r21);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r3 = r1.a;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        yx5.a.b r4 = yx5.a.b(r3);     // Catch: Throwable -> L16
        Class r6 = Integer.TYPE;     // Catch: Throwable -> L16
        r4.call("onTTDnsResolveResult", new Class[]{String.class, String.class, r6, r6, r6, List.class, String.class}, new Object[]{r15, r16, Integer.valueOf(r17), Integer.valueOf(r18), Integer.valueOf(r19), r20, r21});     // Catch: Throwable -> L16
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0098 -> B:16:0x009b). Please report as a decompilation issue!!! */
    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onContextInitCompleted(long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41) {
        TTNetInitMetrics r0 = TTNetInitMetrics.g();
        boolean r1 = false;
        r0.c = Process.getThreadPriority(0);
        r0.F = TTCronetInitTimingInfo.sInitThreadStart;
        r0.G = TTCronetInitTimingInfo.sInitThreadEnd;
        r0.H = TTCronetInitTimingInfo.sLoadCronetSoStart;
        r0.I = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        r0.J = TTCronetInitTimingInfo.sNativeInitTimingJson;
        r0.L = TTCronetInitTimingInfo.sABTest;
        r0.K = System.nanoTime();
        r0.N = r11;
        r0.O = r13;
        r0.P = r15;
        r0.M = r17;
        r0.Q = r19;
        r0.R = r21;
        r0.S = r23;
        r0.T = r25;
        r0.U = r27;
        r0.V = r29;
        r0.W = r31;
        r0.X = r33;
        r0.Y = r35;
        r0.Z = r37;
        r0.a0 = r39;
        r0.b0 = r41;
        c r2 = c.h();
        r2.getClass();
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        long r3 = -1;
    L17:
        TTNetInitMetrics r4 = TTNetInitMetrics.g();
        if (r4.d != 0) goto L20;
    L72:
        if (r1 == true) goto L78;
        TTExecutors.getScheduledThreadPool().schedule(new a(r3), 5, TimeUnit.SECONDS);
        TTNetInitMetrics.e0.set(true);
        if (TTNetInitMetrics.d0.isEmpty() == true) goto L86;
        new com.bytedance.frameworks.baselib.network.c().start();
        return;
    L86:
        return;
    L78:
        JSONObject r5 = TTNetInitMetrics.g().b();
        JSONObject r6 = TTNetInitMetrics.g().c(r3);
        TTNetInitMetrics.e0.set(true);
        if (TTNetInitMetrics.d0.isEmpty() == true) goto L82;
        new com.bytedance.frameworks.baselib.network.c().start();
    L82:
        c.h().k(r5.toString(), "ttnet_init");
        c.h().k(r6.toString(), "ttnet_init_v2");
        return;
    L20:
        if (r4.e == 0) goto L72;
        if (r4.f == 0) goto L72;
        if (r4.g == 0) goto L72;
        if (r4.h == 0) goto L72;
        if (r4.i == 0) goto L72;
        if (r4.j == 0) goto L72;
        if (r4.k == 0) goto L72;
        if (r4.l == 0) goto L72;
        if (r4.n == 0) goto L72;
        if (r4.o == 0) goto L72;
        if (r4.p == 0) goto L72;
        if (r4.q == 0) goto L72;
        if (r4.r == 0) goto L72;
        if (r4.s == 0) goto L72;
        if (r4.t == 0) goto L72;
        if (r4.u == 0) goto L72;
        if (r4.v == 0) goto L72;
        if (r4.w == 0) goto L72;
        if (r4.x == 0) goto L72;
        if (r4.y == 0) goto L72;
        if (r4.z == 0) goto L72;
        if (r4.A == 0) goto L72;
        if (r4.B == 0) goto L72;
        if (r4.C == 0) goto L72;
        if (r4.D == 0) goto L72;
        if (r4.E == 0) goto L72;
        r1 = true;
        goto L72
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r7 = r2.b;     // Catch: Throwable -> L14
        if (r7 == null) goto L16;
        r3 = r7.getAppStartTime();     // Catch: Throwable -> L14
        goto L17
    L9:
        Object r8 = r2.a;     // Catch: Throwable -> L14
        if (r8 == null) goto L16;
        r3 = ((Long) yx5.a.b(r8).call("getAppStartTime").get()).longValue();     // Catch: Throwable -> L14
        goto L17
    }
}
