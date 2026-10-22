package com.lynx.clay.embedding.engine;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FlutterFunctorView;
import com.lynx.clay.embedding.android.j;
import com.lynx.clay.embedding.engine.accessibility.ClayAccessibilityBridge;
import com.lynx.clay.embedding.engine.devtools.DevtoolsListener;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.embedding.engine.utils.TimingClient;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = null;
    private static boolean initCalled = false;
    private static volatile boolean loadLibraryCalled = false;
    private static String observatoryUri = null;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static volatile float refreshRateFPS = 60.0f;
    private ClayAccessibilityDelegate clayAccessibilityDelegate;
    private ClayPluginContext clayPluginContext;
    private ClipboardManager clipboardManager;
    public DevtoolsListener devtoolsListener;
    private final Set<FlutterEngine.a> engineLifecycleListeners;
    private final Set<s5a.a> flutterContentSizeListeners;
    private FlutterFunctorView flutterFunctorView;
    private final Set<s5a.b> flutterUiDisplayListeners;
    private u5a.b.InterfaceC0113b inputMethodHandler;
    private com.lynx.clay.embedding.android.a.b keyEventResponseHandler;
    private final Looper mainLooper;
    private Long nativeClayViewContextId;
    private Long nativeShellHolderId;
    private PlatformViewsController platformViewsController;
    private j resourceUrlInterceptor;
    private TimingClient timingClient;

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long r1);
    }

    public interface ClayAccessibilityDelegate {
        void updateSemantics(ByteBuffer r1, String[] r2);
    }

    public static /* synthetic */ void a(long r0, ImageDecoder r2, ImageDecoder.ImageInfo r3, ImageDecoder.Source r4) {
        lambda$decodeImage$0(r0, r2, r3, r4);
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private String getClipboardData() {
        return null;
    }

    private native long nativeAttach(FlutterJNI r1, boolean r2, boolean r3);

    private native void nativeCleanForRecycle(long r1);

    private native void nativeCreateDevtoolInstrumentation(long r1);

    private native long nativeCreateGLFunctor(long r1, long r3);

    private native void nativeCreateUIDelegateClay(long r1);

    private native void nativeDeleteSurroundingText(long r1, int r3, int r4);

    private native void nativeDestroy(long r1);

    private native void nativeDestroyGLFunctor(long r1);

    private native void nativeDispatchClaySemanticsAction(long r1, int r3, int r4);

    private native void nativeDispatchKeyDataPacket(long r1, ByteBuffer r3, String r4, int r5);

    private native boolean nativeDispatchPointerDataPacket(long r1, ByteBuffer r3, int r4);

    private native Bitmap nativeGetBitmap(long r1);

    private native int nativeGetGLFunctorQueueSize(long r1);

    private native int nativeGetHitTestResponsiveResult(long r1);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    private native int nativeGetNodeForLocation(long r1, int r3, int r4);

    private native long nativeGetSharedImageSink(long r1);

    private native float[] nativeGetTransformValue(long r1, int r3, float[] r4);

    public static native void nativeImageHeaderCallback(long r0, int r2, int r3);

    public static native void nativeInit(Context r0, String[] r1, String r2, String r3, String r4, long r5);

    private native boolean nativeIsHitTestingTargetNativeView(long r1, int r3, int r4, int r5);

    private native void nativeNotifyFunctorPresent(long r1, long r3);

    private native void nativeNotifyLowMemoryWarning(long r1);

    private native boolean nativeOnDraw(Canvas r1, long r2, boolean r4, boolean r5, int r6, int r7, int r8, int r9);

    private native void nativeOnEnterBackground(long r1);

    private native void nativeOnEnterForeground(long r1);

    private native void nativeOnGetBitmap(long r1);

    public static native void nativeOnVsync(long r0, long r2, long r4);

    private native void nativePerformEditorAction(long r1, int r3);

    public static native void nativePreInitClayTask();

    public static native void nativePrefetchDefaultFontManager();

    private native void nativePrepareForRecycle(long r1);

    private native void nativeRenderSurfaceCreated(long r1, Surface r3);

    private native void nativeRenderSurfaceDestroyed(long r1);

    private native void nativeSendKeyboardEventDataPacket(long r1, ByteBuffer r3, String r4);

    private native void nativeSetClaySemanticsEnabled(long r1, boolean r3);

    private native void nativeSetDefaultFocusRingEnabled(long r1, boolean r3);

    private native void nativeSetEnableFluencyMonitor(long r1, boolean r3);

    private native void nativeSetExposureFrequency(long r1, int r3);

    private native void nativeSetOuterScrollableDirection(long r1, int r3);

    private native void nativeSetPerformanceOverlayEnabled(long r1, boolean r3);

    private native void nativeSetViewOptions(long r1, Map<String, String> r3);

    private native void nativeSetViewportMetrics(long r1, FlutterRenderer.ViewportMetrics r3);

    private native FlutterJNI nativeSpawn(long r1, String r3, String r4);

    private native void nativeSurfaceChanged(long r1, int r3, int r4);

    private native void nativeSurfaceCreated(long r1, Surface r3);

    private native void nativeSurfaceDestroyed(long r1);

    private native void nativeSurfaceWindowChanged(long r1, Surface r3);

    private native void nativeUpdateRefreshRate(float r1);

    public native boolean nativeFlutterTextUtilsIsEmoji(int r1);

    public native boolean nativeFlutterTextUtilsIsEmojiModifier(int r1);

    public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int r1);

    public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int r1);

    public native boolean nativeFlutterTextUtilsIsVariationSelector(int r1);

    public native long nativeGetClayViewContext(long r1);

    public native long nativeGetUIDelegateClay(long r1);

    public void setClipboardData(String r1) {
    }

    public void setResourceUrlInterceptor(j r1) {
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) goto L6;
        return;
    L6:
        throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) goto L6;
        return;
    L6:
        throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
    }

    private void onPreEngineRestart() {
        Iterator<FlutterEngine.a> r0 = this.engineLifecycleListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b();
        goto L4
    }

    public void cleanForRecycle() {
        this.flutterUiDisplayListeners.clear();
        nativeCleanForRecycle(this.nativeShellHolderId.longValue());
    }

    public void destroyGLFunctor() {
        nativeDestroyGLFunctor(this.nativeShellHolderId.longValue());
    }

    public long getFunctorPtr() {
        FlutterFunctorView r0 = this.flutterFunctorView;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getFunctorPtr();
    }

    public int getGLFunctorQueueSize() {
        return nativeGetGLFunctorQueueSize(this.nativeShellHolderId.longValue());
    }

    public int getHitTestResponsiveResult() {
        return nativeGetHitTestResponsiveResult(this.nativeShellHolderId.longValue());
    }

    public long getSharedImageSink() {
        return nativeGetSharedImageSink(this.nativeShellHolderId.longValue());
    }

    public void hideSoftInput() {
        u5a.b.InterfaceC0113b r0 = this.inputMethodHandler;
        if (r0 == null) goto L6;
        u5a.b r1 = ((u5a.b.a) r0).a;
        View r2 = r1.a;
        r1.e = null;
        u5a.b.h.hideSoftInputFromWindow(r2.getApplicationWindowToken(), 0);
        r1.g = false;
        return;
    }

    public boolean isAttached() {
        if (this.nativeShellHolderId == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void postInvalidate() {
        FlutterFunctorView r0 = this.flutterFunctorView;
        if (r0 == null) goto L6;
        r0.postInvalidateOnAnimation();
        return;
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled == false) goto L5;
        c5a.c.d(5, TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
    L5:
        nativePrefetchDefaultFontManager();
        nativePreInitClayTask();
        prefetchDefaultFontManagerCalled = true;
    }

    public void prepareForRecycle() {
        nativePrepareForRecycle(this.nativeShellHolderId.longValue());
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled == true) goto L5;
        return;
    L5:
        nativeUpdateRefreshRate(refreshRateFPS);
    }

    public FlutterJNI() {
        this.clipboardManager = null;
        this.engineLifecycleListeners = new CopyOnWriteArraySet();
        this.flutterUiDisplayListeners = new CopyOnWriteArraySet();
        this.flutterContentSizeListeners = new CopyOnWriteArraySet();
        this.devtoolsListener = null;
        this.timingClient = null;
        this.mainLooper = Looper.getMainLooper();
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() != this.mainLooper) goto L6;
        return;
    L6:
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + ThreadMethodProxy.currentThread().getName());
    }

    public void createDevtoolInstrumentation() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeCreateDevtoolInstrumentation(this.nativeShellHolderId.longValue());
    }

    public void createUIDelegateClay() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeCreateUIDelegateClay(this.nativeShellHolderId.longValue());
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroy(this.nativeShellHolderId.longValue());
        this.nativeShellHolderId = null;
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public long getNativeClayViewContext() {
        if (isAttached() == true) goto L7;
        return 0;
    L7:
        return nativeGetClayViewContext(this.nativeShellHolderId.longValue());
    }

    public long getNativeUIDelegateClayPtr() {
        if (isAttached() == true) goto L7;
        return 0;
    L7:
        return nativeGetUIDelegateClay(this.nativeShellHolderId.longValue());
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onEnterBackground() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeOnEnterBackground(this.nativeShellHolderId.longValue());
    }

    public void onEnterForeground() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeOnEnterForeground(this.nativeShellHolderId.longValue());
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<s5a.b> r0 = this.flutterUiDisplayListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b();
        goto L4
    }

    public void onGetBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeOnGetBitmap(this.nativeShellHolderId.longValue());
    }

    public void onRenderSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeRenderSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<s5a.b> r0 = this.flutterUiDisplayListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a();
        goto L4
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private Object getPlatformViewsController() {
        return this.platformViewsController;
    }

    private Object getPluginContext() {
        return this.clayPluginContext;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_clay_embedding_engine_FlutterJNI_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private static void asyncWaitForVsync(long r1) {
        AsyncWaitForVsyncDelegate r0 = asyncWaitForVsyncDelegate;
        if (r0 == null) goto L7;
        r0.asyncWaitForVsync(r1);
        return;
    L7:
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    public static void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate r0) {
        asyncWaitForVsyncDelegate = r0;
    }

    public void addEngineLifecycleListener(FlutterEngine.a r2) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(r2);
    }

    public void addIsDisplayingFlutterUiListener(s5a.b r2) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(r2);
    }

    public void addRootContentSizeListener(s5a.a r2) {
        ensureRunningOnMainThread();
        this.flutterContentSizeListeners.add(r2);
    }

    public long createGLFunctor(long r3) {
        return nativeCreateGLFunctor(this.nativeShellHolderId.longValue(), r3);
    }

    public void loadLibrary(FlutterLoader.a r4) {
        c5a.c.d(6, TAG, "FlutterJNI loadLibrary");
        if (loadLibraryCalled == false) goto L6;
        c5a.c.d(5, TAG, "FlutterJNI.loadLibrary called more than once");
        return;
    L6:
        if (r4 != null) goto L8;
        INVOKESTATIC_com_lynx_clay_embedding_engine_FlutterJNI_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("clay");
        c5a.c.d(6, TAG, "FlutterJNI load libclay.so by System");
    L9:
        loadLibraryCalled = true;
        return;
    L8:
        r4.a();
        c5a.c.d(6, TAG, "FlutterJNI load libclay.so by ILibraryLoader");
        goto L9
    }

    public void notifyFunctorPresent(long r3) {
        nativeNotifyFunctorPresent(this.nativeShellHolderId.longValue(), r3);
    }

    public void onRenderSurfaceCreated(Surface r3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRenderSurfaceCreated(this.nativeShellHolderId.longValue(), r3);
    }

    public void onSurfaceCreated(Surface r3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), r3);
    }

    public void onSurfaceWindowChanged(Surface r3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), r3);
    }

    public void onTimingSetup(HashMap<String, Long> r2) {
        TimingClient r0 = this.timingClient;
        if (r0 == null) goto L6;
        r0.onTimingSetup(r2);
        return;
    }

    public void performEditorAction(int r3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativePerformEditorAction(this.nativeShellHolderId.longValue(), r3);
    }

    public void removeEngineLifecycleListener(FlutterEngine.a r2) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(r2);
    }

    public void removeIsDisplayingFlutterUiListener(s5a.b r2) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(r2);
    }

    public void removeRootContentSizeListener(s5a.a r2) {
        ensureRunningOnMainThread();
        this.flutterContentSizeListeners.remove(r2);
    }

    public void setClayAccessibilityDelegate(ClayAccessibilityDelegate r2) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        ensureRunningOnMainThread();
        this.clayAccessibilityDelegate = r2;
    }

    public void setClayPluginContext(ClayPluginContext r1) {
        this.clayPluginContext = r1;
    }

    public void setClaySemanticsEnabled(boolean r3) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        ensureRunningOnMainThread();
        nativeSetClaySemanticsEnabled(this.nativeShellHolderId.longValue(), r3);
    }

    public void setClipboardManager(ClipboardManager r1) {
        this.clipboardManager = r1;
    }

    public void setDefaultFocusRingEnabled(boolean r3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetDefaultFocusRingEnabled(this.nativeShellHolderId.longValue(), r3);
    }

    public void setDevtoolsListener(DevtoolsListener r1) {
        this.devtoolsListener = r1;
        createDevtoolInstrumentation();
    }

    public void setEnableFluencyMonitor(boolean r3) {
        nativeSetEnableFluencyMonitor(this.nativeShellHolderId.longValue(), r3);
    }

    public void setEventResponseHandler(com.lynx.clay.embedding.android.a.b r1) {
        this.keyEventResponseHandler = r1;
    }

    public void setFlutterFunctorView(FlutterFunctorView r1) {
        this.flutterFunctorView = r1;
    }

    public void setInputMethodHandler(u5a.b.InterfaceC0113b r1) {
        this.inputMethodHandler = r1;
    }

    public void setOuterScrollableDirection(int r3) {
        nativeSetOuterScrollableDirection(this.nativeShellHolderId.longValue(), r3);
    }

    public void setPerformanceOverlayEnabled(boolean r3) {
        nativeSetPerformanceOverlayEnabled(this.nativeShellHolderId.longValue(), r3);
    }

    public void setPlatformViewsController(PlatformViewsController r1) {
        ensureRunningOnMainThread();
        this.platformViewsController = r1;
    }

    public void setRefreshRateFPS(float r1) {
        refreshRateFPS = r1;
        updateRefreshRate();
    }

    public void setTimingClient(TimingClient r1) {
        this.timingClient = r1;
    }

    public void setViewOptions(Map<String, String> r3) {
        if (isAttached() == false) goto L7;
        if (r3 == null) goto L8;
        nativeSetViewOptions(this.nativeShellHolderId.longValue(), r3);
        return;
    L8:
        return;
    }

    public void setViewportMetrics(FlutterRenderer.ViewportMetrics r3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), r3);
    }

    public void updateRasterCacheInfo(byte[] r3) {
        if (this.devtoolsListener == null) goto L6;
        String r0 = new String(r3, StandardCharsets.UTF_8);
        this.devtoolsListener.updateRasterCacheInfo(r0);
        return;
    }

    private void clayUpdateSemantics(ByteBuffer r2, String[] r3) {
        ensureRunningOnMainThread();
        ClayAccessibilityDelegate r0 = this.clayAccessibilityDelegate;
        if (r0 == null) goto L6;
        r0.updateSemantics(r2, r3);
        return;
    }

    public static Bitmap decodeImage(ByteBuffer r3, final long r4) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        ImageDecoder.Source r5 = ImageDecoder.createSource(r3);
        return ImageDecoder.decodeBitmap(r5, new d(r4));
    L7:
        e = move-exception;
        c5a.c.b(TAG, "Failed to decode image", e);
    L9:
        return null;
    }

    private String inputFilter(String r2, String r3) {
        u5a.b.InterfaceC0113b r0 = this.inputMethodHandler;
        if (r0 == null) goto L10;
        ((u5a.b.a) r0).getClass();
        return r2.replaceAll(r3, NameKeys.UnloadStrategy_No_Strategy);
    L11:
        return r2;
    L10:
        return r2;
    }

    public void deleteSurroundingText(int r3, int r4) {
        nativeDeleteSurroundingText(this.nativeShellHolderId.longValue(), r3, r4);
    }

    public void dispatchClaySemanticsAction(int r3, ClayAccessibilityBridge.Action r4) {
        ensureAttachedToNative();
        nativeDispatchClaySemanticsAction(this.nativeShellHolderId.longValue(), r3, r4.value);
    }

    public boolean dispatchPointerDataPacket(ByteBuffer r3, int r4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), r3, r4);
    }

    public int getNodeForLocation(int r3, int r4) {
        return nativeGetNodeForLocation(this.nativeShellHolderId.longValue(), r3, r4);
    }

    public float[] getTransformValue(int r3, float[] r4) {
        return nativeGetTransformValue(this.nativeShellHolderId.longValue(), r3, r4);
    }

    public void keyResponse(final int r3, final boolean r4) {
        if (Looper.myLooper() == this.mainLooper) goto L5;
        new Handler(this.mainLooper).post(new AnonymousClass1(this, r3, r4));
    L5:
        if (r4 == false) goto L7;
        com.lynx.clay.embedding.android.a.C0033a r5 = (com.lynx.clay.embedding.android.a.C0033a) this.keyEventResponseHandler;
        KeyEvent r6 = r5.a(r3);
        ((ArrayDeque) r5.a).remove(r6);
        return;
    L7:
        com.lynx.clay.embedding.android.a.C0033a r7 = (com.lynx.clay.embedding.android.a.C0033a) this.keyEventResponseHandler;
        KeyEvent r8 = r7.a(r3);
        r7.c.getClass();
        if (u5a.b.h.isAcceptingText() == false) goto L12;
        u5a.a r0 = r7.c.e;
        if (r0 == null) goto L12;
        r0.sendKeyEvent(r8);
        ((ArrayDeque) r7.a).remove(r8);
        return;
    L12:
        View r9 = r7.b;
        if (r9 == null) goto L18;
        r9.getRootView().dispatchKeyEvent(r8);
        return;
    }

    public void onRootContentSizeChanged(int r3, int r4) {
        ensureRunningOnMainThread();
        Iterator<s5a.a> r0 = this.flutterContentSizeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r4);
        goto L4
    }

    public void onSurfaceChanged(int r3, int r4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), r3, r4);
    }

    public void onTimingUpdate(HashMap<String, Long> r2, String r3) {
        TimingClient r0 = this.timingClient;
        if (r0 == null) goto L6;
        r0.onTimingUpdate(r2, r3);
        return;
    }

    public void sendKeyboardEventDataPacket(ByteBuffer r3, String r4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSendKeyboardEventDataPacket(this.nativeShellHolderId.longValue(), r3, r4);
    }

    public String shouldInterceptUrl(String r1, boolean r2) {
        if (r2 == true) goto L4;
        return r1;
    L4:
        return Uri.decode(r1);
    }

    public void showSoftInput(int r2, int r3) {
        u5a.b.InterfaceC0113b r0 = this.inputMethodHandler;
        if (r0 == null) goto L6;
        u5a.b r1 = ((u5a.b.a) r0).a;
        r1.c = r2;
        r1.d = r3;
        View r4 = r1.a;
        r4.requestFocus();
        r1.g = true;
        u5a.b.h.showSoftInput(r4, 0);
        return;
    }

    public FlutterJNI spawn(String r5, String r6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI r7 = nativeSpawn(this.nativeShellHolderId.longValue(), r5, r6);
        Long r8 = r7.nativeShellHolderId;
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L11;
        return r7;
    L11:
        throw new IllegalStateException("Failed to spawn new JNI connected shell from existing shell.");
    L5:
        if (r8.longValue() == 0) goto L7;
        r9 = true;
        goto L8
    }

    private Bitmap createBitmap(int r2, int r3, Canvas r4) {
        if (r4 == null) goto L8;
        r2 = Math.min(r2, r4.getMaximumBitmapWidth());
        r3 = Math.min(r3, r4.getMaximumBitmapHeight());
    L8:
        return Bitmap.createBitmap(r2, r3, Bitmap.Config.ARGB_8888);
    L6:
        c5a.c.d(6, "clay", "Error allocating bitmap");
        return null;
    }

    public void attachToNative(boolean r1, boolean r2, boolean r3) {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.nativeShellHolderId = Long.valueOf(performNativeAttach(this, r1, r2, r3));
        this.nativeClayViewContextId = Long.valueOf(getNativeClayViewContext());
    }

    public void dispatchKeyDataPacket(ByteBuffer r8, String r9, int r10) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchKeyDataPacket(this.nativeShellHolderId.longValue(), r8, r9, r10);
    }

    public boolean isHitTestingTargetNativeView(int r8, int r9, int r10) {
        return nativeIsHitTestingTargetNativeView(this.nativeShellHolderId.longValue(), r8, r9, r10);
    }

    public void onVsync(long r1, long r3, long r5) {
        nativeOnVsync(r1, r3, r5);
    }

    private void drawBitmapIntoCanvas(Bitmap r1, Canvas r2, int r3, int r4) {
        r2.translate(r3, r4);
        r2.drawBitmap(r1, 0.0f, 0.0f, null);
    }

    private static /* synthetic */ void lambda$decodeImage$0(long r0, ImageDecoder r2, ImageDecoder.ImageInfo r3, ImageDecoder.Source r4) {
        r2.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        r2.setAllocator(1);
        Size r5 = r3.getSize();
        nativeImageHeaderCallback(r0, r5.getWidth(), r5.getHeight());
    }

    public long performNativeAttach(FlutterJNI r1, boolean r2, boolean r3, boolean r4) {
        return nativeAttach(r1, r3, r4);
    }

    public void init(Context r4, String[] r5, String r6, String r7, String r8, long r9) {
        if (initCalled == false) goto L5;
        c5a.c.d(5, TAG, "FlutterJNI.init called more than once");
    L5:
        nativeInit(r4, r5, r6, r7, r8, r9);
        initCalled = true;
    }

    public boolean onDraw(Canvas r12, boolean r13, boolean r14, int r15, int r16, int r17, int r18) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeOnDraw(r12, this.nativeShellHolderId.longValue(), r13, r14, r15, r16, r17, r18);
    }
}
