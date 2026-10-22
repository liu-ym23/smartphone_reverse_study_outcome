package com.larus.xbridge.custom;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "flow.openSidebar";
    }

    public j1() {
    }

    public static com.larus.bmhome.a0 e(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        com.larus.bmhome.a0 r0 = (Fragment) r3.next();
        if ((r0 instanceof com.larus.bmhome.a0) == true) goto L8;
        com.larus.bmhome.a0 r1 = e(r0.getChildFragmentManager().getFragments());
        if (r1 == null) goto L4;
        return r1;
    L8:
        return r0;
    L12:
        return null;
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        FragmentActivity r11 = AppHost.a.a().getCurrentActivity();
        com.larus.bmhome.a0 r0 = null;
        if ((r11 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r12 = r11;
    L6:
        if (r12 == null) goto L13;
        FragmentManager r13 = r12.getSupportFragmentManager();
        if (r13 == null) goto L13;
        List r14 = r13.getFragments();
        if (r14 == null) goto L13;
        r0 = e(r14);
    L13:
        if (r0 == null) goto L15;
        FLogger.a.i("FlowOpenSidebarMethod", "[handle] open side bar");
        r0.cs();
    L16:
        XCoreBridgeMethod.onSuccess$default(this, r9, new LinkedHashMap(), null, 4, null);
        return;
    L15:
        FLogger.a.w("FlowOpenSidebarMethod", "[handle] ISideBarFragment not found, ignore");
        goto L16
    L5:
        r12 = null;
        goto L6
    }
}
