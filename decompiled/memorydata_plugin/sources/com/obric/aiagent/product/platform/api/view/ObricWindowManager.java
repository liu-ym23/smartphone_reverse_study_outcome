package com.obric.aiagent.product.platform.api.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.Window;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import com.obric.aiagent.product.platform.impl.view.AssistantWindowManagerImpl;
import com.obric.aiagent.product.platform.impl.view.CommonObricWindowManager;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/ObricWindowManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricWindowManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricWindowManager";
    private static IObricWindowManager instance;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0017J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u000f\u001a\u00020\rH\u0017J\b\u0010\u0010\u001a\u00020\rH\u0017J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J0\u0010\u0015\u001a\u00020\r2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0016H\u0017J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001aH\u0017J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001aH\u0017J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/ObricWindowManager$Companion;", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "<init>", "()V", "TAG", "", "instance", "takeScreenshot", "Landroid/graphics/Bitmap;", "includePackages", "", "excludePackages", "isAutoActionRunning", "", "isAutoImeReady", "focusedWindowIsSecure", "isInputMethodShown", "registerInputMethodListener", "listener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "unregisterInputMethodListener", "takeSurfaceControlScreenshot", "", "registerWindowGestureListener", "token", "Landroid/os/IBinder;", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "unregisterWindowGestureListener", "setAssistantWindowInKeyguardMode", "window", "Landroid/view/Window;", "showGlobalActions", "context", "Landroid/content/Context;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricWindowManager {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean focusedWindowIsSecure() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.focusedWindowIsSecure();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean isAutoActionRunning() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isAutoActionRunning();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean isAutoImeReady() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isAutoImeReady();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean isInputMethodShown() {
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isInputMethodShown();
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean registerInputMethodListener(ObricInputMethodListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerInputMethodListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean registerWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "token");
            Intrinsics.checkNotNullParameter(r3, "listener");
            IObricWindowManager r4 = ObricWindowManager.access$getInstance$cp();
            if (r4 != null) goto L7;
            return false;
        L7:
            return r4.registerWindowGestureListener(r1, r3);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean setAssistantWindowInKeyguardMode(Window r1) {
            Intrinsics.checkNotNullParameter(r1, "window");
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.setAssistantWindowInKeyguardMode(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        public boolean showGlobalActions(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            IObricWindowManager r3 = ObricWindowManager.access$getInstance$cp();
            if (r3 != null) goto L7;
            return false;
        L7:
            return r3.showGlobalActions(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public Bitmap takeScreenshot(List<String> r2, List<String> r3) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            IObricWindowManager r5 = ObricWindowManager.access$getInstance$cp();
            if (r5 == null) goto L6;
            Bitmap r6 = r5.takeScreenshot(r1, r4);
            if (r6 == null) goto L6;
            return r6;
        L6:
            return null;
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean takeSurfaceControlScreenshot(List<String> r2, List<String> r3, Object r4) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "listener");
            IObricWindowManager r6 = ObricWindowManager.access$getInstance$cp();
            if (r6 != null) goto L7;
            return false;
        L7:
            return r6.takeSurfaceControlScreenshot(r1, r5, r4);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean unregisterInputMethodListener(ObricInputMethodListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricWindowManager r0 = ObricWindowManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterInputMethodListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
        @JvmStatic
        public boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "token");
            Intrinsics.checkNotNullParameter(r3, "listener");
            IObricWindowManager r4 = ObricWindowManager.access$getInstance$cp();
            if (r4 != null) goto L7;
            return false;
        L7:
            return r4.unregisterWindowGestureListener(r1, r3);
        }
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        d.f5954a.b(TAG, "bind ObricWindowManager failed", th);
    L11:
        instance = (IObricWindowManager) ZeusTransformUtils.preCheckCast(f.a().a(IObricWindowManager.class, false), IObricWindowManager.class, "com.obric.memorydata.plugin");
        d.f5954a.b(TAG, "ObricWindowManager instance: " + instance);
        return;
    L4:
        if (a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L9
        Class<IObricWindowManager> r3 = IObricWindowManager.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricWindowManager$FdJJLiNZOD06vFDmyq1vH0tB2gM.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L9
        goto L11
    L7:
        r2 = f.a();     // Catch: Throwable -> L9
        r3 = IObricWindowManager.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricWindowManager$zb62gnAaIIr_DQWPAefECU5VRyo.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        goto L6
    }

    public ObricWindowManager() {
    }

    private static final Object _init_$lambda$0() {
        return new AssistantWindowManagerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricWindowManager();
    }

    public static final /* synthetic */ IObricWindowManager access$getInstance$cp() {
        return instance;
    }

    @JvmStatic
    public static boolean focusedWindowIsSecure() {
        return Companion.focusedWindowIsSecure();
    }

    @JvmStatic
    public static boolean isAutoActionRunning() {
        return Companion.isAutoActionRunning();
    }

    @JvmStatic
    public static boolean isAutoImeReady() {
        return Companion.isAutoImeReady();
    }

    @JvmStatic
    public static boolean isInputMethodShown() {
        return Companion.isInputMethodShown();
    }

    public static /* synthetic */ Object lambda$FdJJLiNZOD06vFDmyq1vH0tB2gM() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ Object lambda$zb62gnAaIIr_DQWPAefECU5VRyo() {
        return _init_$lambda$1();
    }

    @JvmStatic
    public static boolean registerInputMethodListener(ObricInputMethodListener r1) {
        return Companion.registerInputMethodListener(r1);
    }

    @JvmStatic
    public static boolean registerWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        return Companion.registerWindowGestureListener(r4, r3);
    }

    @JvmStatic
    public static boolean setAssistantWindowInKeyguardMode(Window r1) {
        return Companion.setAssistantWindowInKeyguardMode(r1);
    }

    @JvmStatic
    public static Bitmap takeScreenshot(List<String> r2, List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return Companion.takeScreenshot(r4, r5);
    }

    @JvmStatic
    public static boolean takeSurfaceControlScreenshot(List<String> r2, List<String> r3, Object r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return Companion.takeSurfaceControlScreenshot(r5, r6, r4);
    }

    @JvmStatic
    public static boolean unregisterInputMethodListener(ObricInputMethodListener r1) {
        return Companion.unregisterInputMethodListener(r1);
    }

    @JvmStatic
    public static boolean unregisterWindowGestureListener(IBinder r2, ObricWindowGestureListener r3) {
        IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        return Companion.unregisterWindowGestureListener(r4, r3);
    }
}
