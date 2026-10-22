package com.obric.aiagent.product.platform.api.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.Window;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J0\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0001H&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "", "takeScreenshot", "Landroid/graphics/Bitmap;", "includePackages", "", "", "excludePackages", "isAutoActionRunning", "", "isAutoImeReady", "focusedWindowIsSecure", "isInputMethodShown", "registerInputMethodListener", "listener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "unregisterInputMethodListener", "takeSurfaceControlScreenshot", "registerWindowGestureListener", "token", "Landroid/os/IBinder;", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "unregisterWindowGestureListener", "setAssistantWindowInKeyguardMode", "window", "Landroid/view/Window;", "showGlobalActions", "context", "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricWindowManager {
    public static final Companion Companion = null;
    public static final int ERROR_ANR = 1;
    public static final int ERROR_CRASH = 2;
    public static final int ERROR_MOVE_DEFAULT_DISPLAY_TASK = 4;
    public static final int ERROR_RELAUNCH = 3;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager$Companion;", "", "<init>", "()V", "ERROR_ANR", "", "ERROR_CRASH", "ERROR_RELAUNCH", "ERROR_MOVE_DEFAULT_DISPLAY_TASK", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int ERROR_ANR = 1;
        public static final int ERROR_CRASH = 2;
        public static final int ERROR_MOVE_DEFAULT_DISPLAY_TASK = 4;
        public static final int ERROR_RELAUNCH = 3;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean focusedWindowIsSecure();

    boolean isAutoActionRunning();

    boolean isAutoImeReady();

    boolean isInputMethodShown();

    boolean registerInputMethodListener(ObricInputMethodListener r1);

    boolean registerWindowGestureListener(IBinder r1, ObricWindowGestureListener r2);

    boolean setAssistantWindowInKeyguardMode(Window r1);

    boolean showGlobalActions(Context r1);

    Bitmap takeScreenshot(List<String> r1, List<String> r2);

    boolean takeSurfaceControlScreenshot(List<String> r1, List<String> r2, Object r3);

    boolean unregisterInputMethodListener(ObricInputMethodListener r1);

    boolean unregisterWindowGestureListener(IBinder r1, ObricWindowGestureListener r2);
}
