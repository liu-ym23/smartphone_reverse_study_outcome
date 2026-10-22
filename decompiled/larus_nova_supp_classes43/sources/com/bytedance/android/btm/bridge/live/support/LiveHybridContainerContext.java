package com.bytedance.android.btm.bridge.live.support;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.btm.bridge.b;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import o16.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/btm/bridge/live/support/LiveHybridContainerContext;", "Lcom/bytedance/android/btm/bridge/b;", "Lg66/c;", "contextProvider", "Landroid/view/View;", "obtainView", "", "getPageUrl", "getHybridContainerType", "<init>", "()V", "btm-bridge-live-support_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class LiveHybridContainerContext implements b {
    public LiveHybridContainerContext() {
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_btm_bridge_live_support_LiveHybridContainerContext_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r10) {
        View r11 = r10.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    @Override // com.bytedance.android.btm.bridge.b
    public String getHybridContainerType(g66.c r1) {
        if (obtainView(r1) == null) goto L5;
        return "live";
    L5:
        return "unkown";
    }

    @Override // com.bytedance.android.btm.bridge.b
    public String getPageUrl(g66.c r10) {
        CallContext r0 = (CallContext) r10.c(CallContext.class);
        String r1 = null;
        if (r0 == null) goto L5;
        String r11 = r0.b;
    L6:
        if (r11 != null) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == false) goto L18;
        com.bytedance.ies.bullet.service.base.c r13 = (com.bytedance.ies.bullet.service.base.c) r10.c(com.bytedance.ies.bullet.service.base.c.class);
        if (r13 == null) goto L17;
        r1 = r13.a;
    L17:
        return r1;
    L18:
        return r11;
    L8:
        if (r11.length() == 0) goto L11;
        r12 = false;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.android.btm.bridge.b
    public View obtainView(g66.c r10) {
        CallContext r0 = (CallContext) r10.c(CallContext.class);
        if (r0 == null) goto L7;
        View r1 = r0.d;
        if (r1 == null) goto L7;
        return r1;
    L7:
        Context r11 = (Context) r10.c(Context.class);
        if (r11 == null) goto L14;
        Activity r12 = a.a(r11);
        if (r12 == null) goto L14;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L14;
        return INVOKEVIRTUAL_com_bytedance_android_btm_bridge_live_support_LiveHybridContainerContext_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r13);
    L14:
        return null;
    }
}
