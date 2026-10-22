package com.obric.aiagent.product.platform.impl.view;

import android.app.IObricInputMethodListener;
import android.app.IObricWindowGestureListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.ObricWindowManager;
import android.view.Window;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J0\u0010\u0013\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¨\u0006!"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/view/CommonObricWindowManager;", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "<init>", "()V", "takeScreenshot", "Landroid/graphics/Bitmap;", "includePackages", "", "", "excludePackages", "isAutoActionRunning", "", "isAutoImeReady", "focusedWindowIsSecure", "isInputMethodShown", "registerInputMethodListener", "listener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "unregisterInputMethodListener", "takeSurfaceControlScreenshot", "", "registerWindowGestureListener", "token", "Landroid/os/IBinder;", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "unregisterWindowGestureListener", "setAssistantWindowInKeyguardMode", "window", "Landroid/view/Window;", "showGlobalActions", "context", "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricWindowManager implements IObricWindowManager {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricWindowManager";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/view/CommonObricWindowManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonObricWindowManager() {
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean focusedWindowIsSecure() {
        return ObricWindowManager.focusedWindowIsSecure();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isAutoActionRunning() {
        return ObricWindowManager.isAutoActionRunning();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isAutoImeReady() {
        return ObricWindowManager.isAutoImeReady();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean isInputMethodShown() {
        return ObricWindowManager.isInputMethodShown();
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean registerInputMethodListener(ObricInputMethodListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricInputMethodListener");
        return ObricWindowManager.registerInputMethodListener((IObricInputMethodListener) ZeusTransformUtils.preCheckCast(r1, IObricInputMethodListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean registerWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "token");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r4 = r3.getObricStub();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.IObricWindowGestureListener");
        return ObricWindowManager.registerWindowGestureListener(r1, (IObricWindowGestureListener) ZeusTransformUtils.preCheckCast(r4, IObricWindowGestureListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean setAssistantWindowInKeyguardMode(Window r1) {
        Intrinsics.checkNotNullParameter(r1, "window");
        return ObricWindowManager.setAssistantWindowInKeyguardMode(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean showGlobalActions(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r6 = r4.getSystemService("window");
        Field r0 = r6.getClass().getDeclaredField("mGlobal");     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        Object r7 = r0.get(r6);     // Catch: Exception -> L5
        Field r1 = r7.getClass().getDeclaredField("sWindowManagerService");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Object r8 = r1.get(r7);     // Catch: Exception -> L5
        Method r2 = r8.getClass().getDeclaredMethod("showGlobalActions", new Class[0]);     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        r2.invoke(r8, new Object[0]);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public Bitmap takeScreenshot(List<String> r2, List<String> r3) {
        return ObricWindowManager.takeScreenshot((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean takeSurfaceControlScreenshot(List<String> r9, List<String> r10, Object r11) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "listener");
        Method[] r1 = ObricWindowManager.class.getMethods();     // Catch: Exception -> L24
        Intrinsics.checkNotNullExpressionValue(r1, "getMethods(...)");     // Catch: Exception -> L24
        Object[] r2 = (Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        int r3 = r2.length;     // Catch: Exception -> L24
        int r4 = 0;
    L4:
        Boolean r5 = null;
        if (r4 >= r3) goto L10;
        Object r6 = r2[r4];     // Catch: Exception -> L24
        if (Intrinsics.areEqual(((Method) ZeusTransformUtils.preCheckCast(r6, Method.class, "com.obric.memorydata.plugin")).getName(), "takeSurfaceControlScreenshot") == true) goto L11;
        r4 = r4 + 1;     // Catch: Exception -> L24
    L11:
        Method r7 = (Method) ZeusTransformUtils.preCheckCast(r6, Method.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (r7 == null) goto L14;
        r7.setAccessible(true);     // Catch: Exception -> L24
    L14:
        if (r7 == null) goto L16;
        Object r13 = r7.invoke(null, new Object[]{r8, r12, r11});     // Catch: Exception -> L24
    L18:
        if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == false) goto L20;
        r5 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
    L20:
        if (r5 == null) goto L29;
        return r5.booleanValue();
    L29:
        return false;
    L16:
        r13 = null;
        goto L18
    L10:
        r6 = null;
    L30:
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean unregisterInputMethodListener(ObricInputMethodListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricInputMethodListener");
        return ObricWindowManager.unregisterInputMethodListener((IObricInputMethodListener) ZeusTransformUtils.preCheckCast(r1, IObricInputMethodListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "token");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r4 = r3.getObricStub();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.IObricWindowGestureListener");
        return ObricWindowManager.unregisterWindowGestureListener(r1, (IObricWindowGestureListener) ZeusTransformUtils.preCheckCast(r4, IObricWindowGestureListener.class, "com.obric.memorydata.plugin"));
    }
}
