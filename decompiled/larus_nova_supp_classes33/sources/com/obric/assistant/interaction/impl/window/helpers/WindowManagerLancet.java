package com.obric.assistant.interaction.impl.window.helpers;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.obric.memorydata.sdk.entity.search.SearchError;
import me.ele.lancet.base.Origin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class WindowManagerLancet {
    private static final String TAG = "WindowManagerLancet";

    public WindowManagerLancet() {
    }

    public static boolean isApplicationWindow(ViewGroup.LayoutParams r3) {
        if ((r3 instanceof WindowManager.LayoutParams) == true) goto L6;
        FLogger.a.w(TAG, "Skip child window binding: params are not WindowManager.LayoutParams");
        return false;
    L6:
        int r4 = ((WindowManager.LayoutParams) r3).type;
        if (r4 >= 1) goto L9;
        return false;
    L9:
        if (r4 > 99) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean bindApplicationWindowToParentIfNeeded(IBinder r1, ViewGroup.LayoutParams r2) {
        if (r1 != null) goto L4;
    L8:
        FLogger.a.w(TAG, "Skip child window binding: parent token is null or not an application window");
        return false;
    L4:
        if (isApplicationWindow(r2) == false) goto L8;
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) r2;
        r3.token = r1;
        r3.type = SearchError.ERR_UNKNOWN;
        return true;
    }

    public static boolean bindToAssistantWindowIfNeeded(View r7, ViewGroup.LayoutParams r8) {
        if (r7 != null) goto L7;
        FLogger.a.w(TAG, "Skip child window binding: view is null");
        return false;
    L7:
        if (ChatWindowServiceDelegate.b.d(r7.getContext()) == true) goto L10;
        return false;
    L10:
        if ((r8 instanceof WindowManager.LayoutParams) == true) goto L13;
        FLogger.a.w(TAG, "Skip child window binding: params are not WindowManager.LayoutParams, view=".concat(r7.getClass().getName()));
        return false;
    L13:
        WindowManager.LayoutParams r2 = (WindowManager.LayoutParams) r8;
        int r3 = r2.type;
        if (isApplicationWindow(r8) == true) goto L17;
        FLogger.a.i(TAG, "Skip child window binding: not an application window, type=" + r3 + ", view=" + r7.getClass().getName());
        return false;
    L17:
        IBinder r4 = WindowHost.INSTANCE.getChildWindowParentToken();
        if (r4 != null) goto L21;
        FLogger.a.w(TAG, "Skip child window binding: assistant Window token is unavailable, type=" + r3 + ", view=" + r7.getClass().getName());
        return false;
    L21:
        boolean r9 = bindApplicationWindowToParentIfNeeded(r4, r8);
        FLogger.a.i(TAG, "Application window bound as assistant child window, originalType=" + r3 + ", targetType=" + r2.type + ", view=" + r7.getClass().getName());
        return r9;
    }

    public void addView(View r1, ViewGroup.LayoutParams r2) {
        bindToAssistantWindowIfNeeded(r1, r2);
        Origin.callVoid();
    }
}
