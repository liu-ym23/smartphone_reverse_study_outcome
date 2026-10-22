package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
@UsedByReflection("WebView embedders call this to override proxy settings")
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int GET_PROXY_CONFIG_DELAY_MILLIS = 1000;
    private static final String TAG = "ProxyChangeListener";
    private static boolean sEnabled = true;
    private Delegate mDelegate;
    private final Handler mHandler;
    private final Looper mLooper;
    private long mNativePtr;
    private ProxyReceiver mProxyReceiver;
    private BroadcastReceiver mRealProxyReceiver;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.ProxyChangeListener$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Delegate {
        void proxySettingsChanged();
    }

    interface Natives {
        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChanged(long r10, ProxyChangeListener r11);

        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChangedTo(long r10, ProxyChangeListener r11, String r12, int r13, String r14, String[] r15);
    }

    private static class ProxyConfig {
        public static final ProxyConfig DIRECT = null;
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        static {
            DIRECT = new ProxyConfig("", 0, "", new String[0]);
        }

        public ProxyConfig(String r10, int r11, String r12, String[] r13) {
            this.mHost = r10;
            this.mPort = r11;
            this.mPacUrl = r12;
            this.mExclusionList = r13;
        }

        static /* synthetic */ ProxyConfig access$300(ProxyInfo r10) {
            return fromProxyInfo(r10);
        }

        private static ProxyConfig fromProxyInfo(ProxyInfo r10) {
            String r11 = null;
            if (r10 != null) goto L5;
            return null;
        L5:
            String r12 = r10.getHost();
            Uri r13 = r10.getPacFileUrl();
            if (r12 != null) goto L8;
            r12 = "";
        L8:
            int r14 = r10.getPort();
            if (Uri.EMPTY.equals(r13) == true) goto L13;
            r11 = r13.toString();
        L13:
            return new ProxyConfig(r12, r14, r11, r10.getExclusionList());
        }
    }

    @UsedByReflection("WebView embedders call this to override proxy settings")
    private class ProxyReceiver extends BroadcastReceiver {
        final /* synthetic */ ProxyChangeListener this$0;

        private ProxyReceiver(ProxyChangeListener r10) {
            this.this$0 = r10;
        }

        /* synthetic */ ProxyReceiver(ProxyChangeListener r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ void a(ProxyReceiver r10, Intent r11) {
            r10.lambda$onReceive$0(r11);
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r10) {
            ProxyChangeListener.access$200(this.this$0, ProxyChangeListener.access$100(r10));
        }

        @Override // android.content.BroadcastReceiver
        @UsedByReflection("WebView embedders call this to override proxy settings")
        public void onReceive(Context r10, final Intent r11) {
            if (r11.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.access$000(this.this$0).postDelayed(new c(this, r11), 1000);
            return;
        }
    }

    static {
    }

    private ProxyChangeListener() {
        Looper r10 = Looper.myLooper();
        this.mLooper = r10;
        this.mHandler = new Handler(r10);
    }

    public static /* synthetic */ void a(ProxyChangeListener r10, Intent r11) {
        r10.lambda$updateProxyConfigFromConnectivityManager$0(r11);
    }

    static /* synthetic */ Handler access$000(ProxyChangeListener r10) {
        return r10.mHandler;
    }

    static /* synthetic */ ProxyConfig access$100(Intent r10) {
        return extractNewProxy(r10);
    }

    static /* synthetic */ void access$200(ProxyChangeListener r10, ProxyConfig r11) {
        r10.proxySettingsChanged(r11);
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    private static ProxyConfig extractNewProxy(Intent r10) {
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L24;
        return ProxyConfig.access$300((ProxyInfo) r11.get("android.intent.extra.PROXY_INFO"));
    L24:
        Object r13 = r11.get("proxy");     // Catch: Throwable -> L21
        if (r13 != null) goto L13;
        return null;
    L13:
        Class<?> r14 = Class.forName("android.net.ProxyProperties");     // Catch: Throwable -> L21
        Method r15 = r14.getDeclaredMethod("getHost", new Class[0]);     // Catch: Throwable -> L21
        Method r16 = r14.getDeclaredMethod("getPort", new Class[0]);     // Catch: Throwable -> L21
        Method r17 = r14.getDeclaredMethod("getExclusionList", new Class[0]);     // Catch: Throwable -> L21
        String r18 = (String) r15.invoke(r13, new Object[0]);     // Catch: Throwable -> L21
        int r19 = ((Integer) r16.invoke(r13, new Object[0])).intValue();     // Catch: Throwable -> L21
        String[] r20 = ((String) r17.invoke(r13, new Object[0])).split(",");     // Catch: Throwable -> L21
        if (r12 < 19) goto L20;
        String r21 = (String) r14.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(r13, new Object[0]);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r21) == true) goto L20;
        return new ProxyConfig(r18, r19, r21, r20);
    L20:
        return new ProxyConfig(r18, r19, null, r20);
    L21:
        e = move-exception;
        Log.e(TAG, "Using no proxy configuration due to exception:" + e, new Object[0]);
        return null;
    }

    @CalledByNative
    public static String getProperty(String r10) {
        return System.getProperty(r10);
    }

    @RequiresApi(23)
    private ProxyConfig getProxyConfig(Intent r10) {
        ProxyInfo r11 = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getDefaultProxy();
        if (r11 != null) goto L7;
        return ProxyConfig.DIRECT;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if ("localhost".equals(r11.getHost()) == false) goto L15;
        if (r11.getPort() != (-1)) goto L15;
        return extractNewProxy(r10);
    L15:
        return ProxyConfig.access$300(r11);
    }

    private /* synthetic */ void lambda$updateProxyConfigFromConnectivityManager$0(Intent r10) {
        proxySettingsChanged(getProxyConfig(r10));
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private void proxySettingsChanged(ProxyConfig r10) {
        assertOnThread();
        if (sEnabled == true) goto L5;
        return;
    L5:
        Delegate r11 = this.mDelegate;
        if (r11 == null) goto L9;
        r11.proxySettingsChanged();
    L9:
        if (this.mNativePtr != 0) goto L11;
        return;
    L11:
        if (r10 == null) goto L13;
        ProxyChangeListenerJni.get().proxySettingsChangedTo(this.mNativePtr, this, r10.mHost, r10.mPort, r10.mPacUrl, r10.mExclusionList);
        return;
    L13:
        ProxyChangeListenerJni.get().proxySettingsChanged(this.mNativePtr, this);
    }

    private void registerReceiver() {
        assertOnThread();
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver(this, null);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Context r11 = ContextUtils.getApplicationContext();
        BroadcastReceiver r12 = this.mProxyReceiver;
    L6:
        ContextUtils.registerNonExportedBroadcastReceiver(r11, r12, r10);
        return;
    L5:
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        r11 = ContextUtils.getApplicationContext();
        r12 = this.mRealProxyReceiver;
        goto L6
    }

    private void runOnThread(Runnable r10) {
        if (onThread() == false) goto L5;
        r10.run();
        return;
    L5:
        this.mHandler.post(r10);
    }

    public static void setEnabled(boolean r10) {
        sEnabled = r10;
    }

    private void unregisterReceiver() {
        assertOnThread();
        ContextUtils.getApplicationContext().unregisterReceiver(this.mProxyReceiver);
        if (this.mRealProxyReceiver == null) goto L5;
        ContextUtils.getApplicationContext().unregisterReceiver(this.mRealProxyReceiver);
    L5:
        this.mProxyReceiver = null;
        this.mRealProxyReceiver = null;
    }

    public void setDelegateForTesting(Delegate r10) {
        this.mDelegate = r10;
    }

    @CalledByNative
    public void start(long r10) {
        TraceEvent r11 = TraceEvent.scoped("ProxyChangeListener.start");
        assertOnThread();     // Catch: Throwable -> L7
        this.mNativePtr = r10;     // Catch: Throwable -> L7
        registerReceiver();     // Catch: Throwable -> L7
        if (r11 == null) goto L18;
        r11.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (r11 != null) goto L16;
    L13:
        throw th;
    L16:
        r11.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0;
        unregisterReceiver();
    }

    void updateProxyConfigFromConnectivityManager(final Intent r10) {
        this.mHandler.postDelayed(new b(this, r10), 1000);
    }
}
