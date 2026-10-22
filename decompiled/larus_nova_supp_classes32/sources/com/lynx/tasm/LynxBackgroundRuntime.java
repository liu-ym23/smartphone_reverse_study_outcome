package com.lynx.tasm;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxFetchModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBackgroundRuntime implements i {
    public final q a;
    public final LynxModuleFactory b;
    public final JSProxy c;
    public final CopyOnWriteArrayList<p> d;
    public LynxDevtool e;
    public final long f;
    public long g;
    public int h;
    public final Object i;
    private LynxResourceLoader mResourceLoader;

    public class a implements com.lynx.jsbridge.b {
        public final WeakReference<Context> a;
        public final /* synthetic */ Context b;

        @Override // com.lynx.jsbridge.b
        public final void b() {
        }

        @Override // com.lynx.jsbridge.b
        public final WeakReference a() {
            return this.a;
        }

        public a(Context r2) {
            this.b = r2;
            this.a = new WeakReference(this.b);
        }
    }

    public static class b implements Runnable {
        public long a;
        public final JSProxy b;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.a == 0) goto L10;
            LLog.w("LynxBackgroundRuntime", "destory wrapper " + this.a);     // Catch: Throwable -> L7
            LynxBackgroundRuntime.a(this.a);     // Catch: Throwable -> L7
            this.a = 0;     // Catch: Throwable -> L7
            this.b.f();     // Catch: Throwable -> L7
            return;
        }

        public b(long r1, JSProxy r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    private native long nativeCreateBackgroundRuntimeWrapper(LynxResourceLoader r1, LynxModuleFactory r2, long r3, long r5, String r7, String r8, String[] r9, String r10, int r11, long r12, boolean r14);

    private native void nativeDestroyRuntime(long r1);

    private static native void nativeDestroyWrapper(long r0);

    private native void nativeEvaluateScript(long r1, String r3, byte[] r4);

    private native void nativeEvaluateTemplateBundle(long r1, String r3, long r4, String r6);

    private native int nativeGetRuntimeId(long r1);

    private native void nativeGetSessionStorageItem(long r1, String r3, PlatformCallBack r4);

    private native void nativeSetPresetData(long r1, boolean r3, long r4);

    private native void nativeSetSessionStorageItem(long r1, String r3, long r4, boolean r6);

    private native double nativeSubscribeSessionStorage(long r1, String r3, PlatformCallBack r4);

    private native void nativeTransitionToFullRuntime(long r1);

    private native void nativeUnsubscribeSessionStorage(long r1, String r3, double r4);

    public final void b() {
        Object r1 = this.i;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.h == 0) goto L9;
        LLog.e("LynxBackgroundRuntime", "call destroy on invalid state, will be ignored, state: " + this.h);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L9:
        LynxDevtool r0 = this.e;     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        r0.destroy();     // Catch: Throwable -> L15
        this.e = null;     // Catch: Throwable -> L15
    L12:
        nativeDestroyRuntime(this.f);     // Catch: Throwable -> L15
        this.h = 2;     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
    }

    public final int e() {
        long r0 = this.f;
        if (r0 != 0) goto L7;
        return -1;
    L7:
        return nativeGetRuntimeId(r0);
    }

    public static /* synthetic */ void a(long r0) {
        nativeDestroyWrapper(r0);
    }

    @Override // com.lynx.tasm.i
    public void onErrorOccurred(final LynxError r2) {
        UIThreadUtils.runOnUiThread(new o(this, r2));
    }

    public void onEvaluateJavaScriptEnd(final String r2) {
        UIThreadUtils.runOnUiThread(new m(this, r2));
    }

    public final void c(String r9, String r10) {
        Object r0 = this.i;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.h != 0) goto L9;
        LynxDevtool r1 = this.e;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.attachToDebugBridge(r9);     // Catch: Throwable -> L14
        this.e.onLoadFromURL(r9, NameKeys.UnloadStrategy_No_Strategy, null, null, null);     // Catch: Throwable -> L14
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L14
        long r2 = this.f;
        if (r2 == 0) goto L19;
        nativeEvaluateScript(r2, r9, r10.getBytes(Charset.forName("UTF-8")));
        return;
    }

    public final void f(String r3, JavaOnlyArray r4) {
        LLog.i("LynxBackgroundRuntime", "LynxContext sendGlobalEvent " + r3 + " with this: " + toString());
        JSProxy r0 = this.c;
        r0.getClass();
        JavaOnlyArray r1 = new JavaOnlyArray();
        r1.pushString(r3);
        r1.pushArray(r4);
        r0.b("GlobalEventEmitter", "emit", r1);
    }

    public LynxBackgroundRuntime(Context r22, q r23, boolean r24) {
        this.f = 0;
        this.g = 0;
        this.i = new Object();
        this.d = new CopyOnWriteArrayList();
        new HashMap();
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L6;
        LLog.e("LynxBackgroundRuntime", "LynxBackgroundRuntime constructor called before LynxEnv init");
        this.h = 8;
        return;
    L6:
        this.h = 0;
        this.a = r23;
        LynxModuleFactory r7 = new LynxModuleFactory();
        this.b = r7;
        z5a.b r1 = new z5a.b();
        r1.b = new WeakReference(this);
        r7.c(LynxFetchModule.NAME, LynxFetchModule.class, r1);
        r7.a(r23.d);
        r7.f = r23.m;
        r7.c = new com.lynx.jsbridge.a(new a(r22));
        boolean r2 = LynxEnv.inst().isLynxDebugEnabled();
        boolean r3 = true;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 == false) goto L20;
        this.e = new LynxDevtool(r22, r24);
        LynxGroup r0 = r23.c;
        if (r0 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L17;
        if (r0 == null) goto L17;
        String r6 = r0.getJSGroupThreadNameOrDefault();
    L18:
        this.g = this.e.onBackgroundRuntimeCreated(r6);
    L17:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L18
    L11:
        if (r0.enableJSGroupThread() == false) goto L13;
        r5 = true;
    L20:
        LynxGroup r8 = r23.c;
        if (r8 == null) goto L23;
        String r9 = r8.getID();
    L24:
        String r10 = r9;
        if (r8 == null) goto L27;
        String[] r11 = r8.getPreloadJSPaths();
    L28:
        String[] r12 = r11;
        if (r8 != null) goto L31;
    L33:
        r3 = false;
    L34:
        if (r3 == false) goto L37;
        if (r8 == null) goto L37;
        r4 = r8.getJSGroupThreadNameOrDefault();
    L37:
        String r13 = r4;
        this.mResourceLoader = new LynxResourceLoader(r23, null, this, r23.j, r23.h);
        if (r8 != null) goto L40;
        long r16 = 0;
    L41:
        int r14 = r23.a(false);
        TemplateData r15 = r23.g;
        if (r15 == null) goto L44;
        long r18 = r15.getNativePtr();
    L45:
        long r17 = r16;
        long r19 = nativeCreateBackgroundRuntimeWrapper(this.mResourceLoader, r7, this.g, r17, r10, r13, r12, r23.b, r14, r18, r24);
        this.f = r19;
        this.g = 0;
        TemplateData r20 = r23.f;
        if (r20 == null) goto L48;
        nativeSetPresetData(r19, r20.isReadOnly(), r20.getNativePtr());
    L48:
        JSProxy r21 = new JSProxy(this, r13);
        this.c = r21;
        new com.lynx.tasm.base.c(this, new b(r19, r21));
        return;
    L44:
        r18 = 0;
        goto L45
    L40:
        r16 = r8.getWhiteBoardPtr();
        goto L41
    L31:
        if (r8.enableJSGroupThread() == false) goto L33;
    L27:
        r11 = null;
        goto L28
    L23:
        r9 = LynxGroup.SINGNLE_GROUP;
        goto L24
    }

    public final void d(String r9, TemplateBundle r10, String r11) {
        Object r0 = this.i;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.h != 0) goto L9;
        LynxDevtool r1 = this.e;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.attachToDebugBridge(r9);     // Catch: Throwable -> L16
        this.e.onLoadFromURL(r9, NameKeys.UnloadStrategy_No_Strategy, null, null, null);     // Catch: Throwable -> L16
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (this.f != 0) goto L13;
        return;
    L13:
        if (r10.i() == false) goto L22;
        nativeEvaluateTemplateBundle(this.f, r9, r10.a, r11);
        return;
    }

    public void onModuleMethodInvoked(final String r2, final String r3, final int r4) {
        UIThreadUtils.runOnUiThread(new n(this, r2, r3, r4));
    }
}
