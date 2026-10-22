package com.lynx.tasm;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.lynx.base.log.LynxLog;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxFetchModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LynxBackgroundRuntime implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxModuleFactory f9959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSProxy f9960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f9961c;
    public LynxDevtool d;
    public final long e;
    public int f;
    public final Object g;

    public LynxBackgroundRuntime(Context r24, k r25) {
        this.e = 0;
        this.g = new Object();
        this.f9961c = new CopyOnWriteArrayList();
        new HashMap();
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L6;
        LynxLog.b(4, "LynxBackgroundRuntime", "LynxBackgroundRuntime constructor called before LynxEnv init");
        this.f = 8;
        return;
    L6:
        this.f = 0;
        LynxModuleFactory r12 = new LynxModuleFactory(r24);
        this.f9959a = r12;
        nm.b r5 = new nm.b();
        new WeakReference(this);
        r12.c(LynxFetchModule.class, r5, LynxFetchModule.NAME);
        r12.d(r25.d);
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L9;
        LynxDevtool r10 = new LynxDevtool();
        r10.a(null, null);
        this.d = r10;
    L9:
        u r13 = r25.f10894c;
        if (r13 == null) goto L13;
        String r11 = r13.f10966c;
    L12:
        String r14 = r11;
        if (r13 == null) goto L16;
        String[] r16 = r13.d;
    L18:
        if (r13 != null) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == false) goto L25;
        String r17 = r14;
    L26:
        String r26 = r17;
        boolean r18 = r15;
        LynxResourceLoader r19 = new LynxResourceLoader(r25, null, this, r25.f10895h, r25.f);
        if (r13 == null) goto L32;
        LynxWhiteBoard r20 = r13.f;
        if (r20 == null) goto L32;
        long r21 = r20.f10046a;
    L33:
        u r22 = r25.f10894c;
        if (r22 != null) goto L36;
    L39:
        boolean r23 = true;
    L40:
        int r110 = k.a(k.a(k.a(k.a(k.a(k.a(0, 4, false), 8, r23), 32, false), 1, r25.f10892a), 2, r18), 16, false);
        long r27 = nativeCreateBackgroundRuntimeWrapper(r19, r12, 0, r21, r14, r26, r16, r25.f10893b, r110, 0, false);
        this.e = r27;
        JSProxy r28 = new JSProxy(this, r26);
        this.f9960b = r28;
        new com.lynx.tasm.base.c(this, new com.bytedance.ies.bullet.ui.common.e(r27, r28, 1));
        return;
    L36:
        if (r22.f10964a == false) goto L39;
        r23 = false;
    L32:
        r21 = 0;
        goto L33
    L25:
        r17 = "";
        goto L26
    L20:
        if (r13.e == false) goto L22;
        r15 = true;
        goto L23
    L16:
        r16 = null;
        goto L18
    L13:
        r11 = "-1";
        goto L12
    }

    public static /* synthetic */ void b(long r5) {
        nativeDestroyWrapper(r5);
    }

    private native long nativeCreateBackgroundRuntimeWrapper(LynxResourceLoader r5, LynxModuleFactory r10, long r11, long r12, String r13, String r14, String[] r15, String r16, int r17, long r18, boolean r19);

    private native void nativeDestroyRuntime(long r5);

    private static native void nativeDestroyWrapper(long r5);

    private native void nativeEvaluateScript(long r5, String r10, byte[] r11);

    private native void nativeEvaluateTemplateBundle(long r5, String r10, long r11, String r12);

    private native void nativeGetSessionStorageItem(long r5, String r10, PlatformCallBack r11);

    private native void nativeSetPresetData(long r5, boolean r10, long r11);

    private native void nativeSetSessionStorageItem(long r5, String r10, long r11, boolean r12);

    private native double nativeSubscribeSessionStorage(long r5, String r10, PlatformCallBack r11);

    private native void nativeTransitionToFullRuntime(long r5);

    private native void nativeUnsubscribeSessionStorage(long r5, String r10, double r11);

    public final void a() {
        Object r5 = this.g;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f == 0) goto L12;
        LynxLog.b(4, "LynxBackgroundRuntime", "call destroy on invalid state, will be ignored, state: " + this.f);     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.d == null) goto L14;
        this.d = null;     // Catch: Throwable -> L9
    L14:
        nativeDestroyRuntime(this.e);     // Catch: Throwable -> L9
        this.f = 2;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    }

    public final void c(String r5, String r10) {
        Object r11 = this.g;
        monitor-enter(r11);
        monitor-exit(r11);     // Catch: Throwable -> L9
        long r12 = this.e;
        if (r12 == 0) goto L14;
        nativeEvaluateScript(r12, r5, r10.getBytes(Charset.forName("UTF-8")));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.g
    @CalledByNative
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onErrorOccurred(LynxError r5) {
        Iterator r10 = this.f9961c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((j) r10.next()).onReceivedError(r5);
        goto L4
    }

    @CalledByNative
    public void onEvaluateJavaScriptEnd(String r5) {
        Iterator r10 = this.f9961c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((j) r10.next()).onEvaluateJavaScriptEnd(r5);
        goto L4
    }

    @CalledByNative
    public void onModuleMethodInvoked(String r5, String r10, int r11) {
        Iterator r12 = this.f9961c.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((j) r12.next()).onModuleMethodInvoked(r5, r10, r11);
        goto L4
    }
}
