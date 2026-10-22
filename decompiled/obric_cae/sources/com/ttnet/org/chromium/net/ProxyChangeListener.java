package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.BuildConfig;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
@UsedByReflection("WebView embedders call this to override proxy settings")
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ProxyChangeListener";
    private static boolean sEnabled = true;
    private Delegate mDelegate;
    private final Handler mHandler;
    private final Looper mLooper;
    private long mNativePtr;
    private ProxyReceiver mProxyReceiver;
    private BroadcastReceiver mRealProxyReceiver;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.ProxyChangeListener$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface Delegate {
        void proxySettingsChanged();
    }

    public static class ProxyConfig {
        public static final ProxyConfig DIRECT = null;
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        static {
            DIRECT = new ProxyConfig("", 0, "", new String[0]);
        }

        public ProxyConfig(String r8, int r10, String r11, String[] r12) {
            this.mHost = r8;
            this.mPort = r10;
            this.mPacUrl = r11;
            this.mExclusionList = r12;
        }

        public static /* synthetic */ ProxyConfig access$100(ProxyInfo r8) {
            return fromProxyInfo(r8);
        }

        @TargetApi(21)
        private static ProxyConfig fromProxyInfo(ProxyInfo r8) {
            String r10 = null;
            if (r8 != null) goto L5;
            return null;
        L5:
            Uri r11 = r8.getPacFileUrl();
            String r12 = r8.getHost();
            int r13 = r8.getPort();
            if (Uri.EMPTY.equals(r11) == true) goto L10;
            r10 = r11.toString();
        L10:
            return new ProxyConfig(r12, r13, r10, r8.getExclusionList());
        }
    }

    @UsedByReflection("WebView embedders call this to override proxy settings")
    public class ProxyReceiver extends BroadcastReceiver {
        final /* synthetic */ ProxyChangeListener this$0;

        private ProxyReceiver(ProxyChangeListener r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(ProxyReceiver r8, Intent r10) {
            r8.lambda$onReceive$0(r10);
        }

        private ProxyConfig extractNewProxy(Intent r8) {
            Bundle r10 = r8.getExtras();
            if (r10 != null) goto L7;
            return null;
        L7:
            return ProxyConfig.access$100((ProxyInfo) r10.get("android.intent.extra.PROXY_INFO"));
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r8) {
            ProxyChangeListener.access$200(this.this$0, extractNewProxy(r8));
        }

        @Override // android.content.BroadcastReceiver
        @UsedByReflection("WebView embedders call this to override proxy settings")
        public void onReceive(Context r8, final Intent r10) {
            if (r10.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.access$000(this.this$0, new b(this, r10));
            return;
        }

        public /* synthetic */ ProxyReceiver(ProxyChangeListener r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private ProxyChangeListener() {
        Looper r8 = Looper.myLooper();
        this.mLooper = r8;
        this.mHandler = new Handler(r8);
    }

    public static /* synthetic */ void a(ProxyChangeListener r8) {
        r8.lambda$updateProxyConfigFromConnectivityManager$0();
    }

    public static /* synthetic */ void access$000(ProxyChangeListener r8, Runnable r10) {
        r8.runOnThread(r10);
    }

    public static /* synthetic */ void access$200(ProxyChangeListener r8, ProxyConfig r10) {
        r8.proxySettingsChanged(r10);
    }

    private void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON == true) goto L5;
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

    @CalledByNative
    public static String getProperty(String r8) {
        return System.getProperty(r8);
    }

    @TargetApi(23)
    private ProxyConfig getProxyConfig() {
        ProxyInfo r8 = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getDefaultProxy();
        if (r8 != null) goto L6;
        return ProxyConfig.DIRECT;
    L6:
        return ProxyConfig.access$100(r8);
    }

    private /* synthetic */ void lambda$updateProxyConfigFromConnectivityManager$0() {
        proxySettingsChanged(getProxyConfig());
    }

    @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
    private native void nativeProxySettingsChanged(long r8);

    @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
    private native void nativeProxySettingsChangedTo(long r8, String r10, int r11, String r12, String[] r13);

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
        Delegate r8 = this.mDelegate;
        if (r8 == null) goto L8;
        r8.proxySettingsChanged();
    L8:
        long r11 = this.mNativePtr;
        if (r11 != 0) goto L11;
        return;
    L11:
        if (r10 == null) goto L13;
        nativeProxySettingsChangedTo(r11, r10.mHost, r10.mPort, r10.mPacUrl, r10.mExclusionList);
        return;
    L13:
        nativeProxySettingsChanged(r11);
    }

    private void registerReceiver() {
        assertOnThread();
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver(this, null);
        ContextUtils.getApplicationContext().registerReceiver(this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        ContextUtils.getApplicationContext().registerReceiver(this.mRealProxyReceiver, r8);
    }

    private void runOnThread(Runnable r8) {
        if (onThread() == false) goto L5;
        r8.run();
        return;
    L5:
        this.mHandler.post(r8);
    }

    public static void setEnabled(boolean r8) {
        sEnabled = r8;
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

    public void setDelegateForTesting(Delegate r8) {
        this.mDelegate = r8;
    }

    @CalledByNative
    public void start(long r8) {
        assertOnThread();
        this.mNativePtr = r8;
        registerReceiver();
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0;
        unregisterReceiver();
    }

    public void updateProxyConfigFromConnectivityManager() {
        runOnThread(new a(this, 0));
    }
}
