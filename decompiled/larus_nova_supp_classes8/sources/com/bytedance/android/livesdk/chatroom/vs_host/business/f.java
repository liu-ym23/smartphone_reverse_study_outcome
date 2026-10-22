package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.action.DebugUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.b2;
import com.bytedance.android.livesdk.chatroom.utils.h2;
import com.bytedance.android.livesdk.config.a2;
import com.bytedance.android.livesdk.lifecycle.ILifeCycleAware;
import com.bytedance.android.livesdk.utils.z2;
import com.bytedance.android.livesdkapi.LiveActivityProxy;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements yr1.d, com.bytedance.android.scope.o {
    public f() {
    }

    @Override // yr1.d
    public final boolean isSaas() {
        return false;
    }

    @Override // yr1.d
    public final void n() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.d
    public final String appId() {
        return String.valueOf(jc1.k.n(IHostContext.class).appId());
    }

    @Override // yr1.d
    public final String currentUserId() {
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L10;
        IUser r2 = r1.b();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "0";
    }

    @Override // yr1.d
    public final List<Class<?>> getAllLiveActivity() {
        return jc1.k.n(IHostApp.class).getAllLiveActivity();
    }

    @Override // yr1.d
    public final Activity getTopActivity() {
        IHostApp r0 = jc1.k.f(IHostApp.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTopActivity();
    }

    @Override // yr1.d
    public final boolean o() {
        return a2.a.getValue().booleanValue();
    }

    @Override // yr1.d
    public final boolean d(DataCenter r1) {
        return VSMediaUIConfigHelper.b(r1);
    }

    @Override // yr1.d
    public final void f(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        new LiveActivityProxy(r2);
    }

    @Override // yr1.d
    public final boolean g(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "enterExtra");
        return h2.c(r2);
    }

    @Override // yr1.d
    public final void i(long r4) {
        if (r4 <= 0) goto L5;
        String r5 = String.valueOf(r4);
    L6:
        ILifeCycleAware r6 = jc1.k.f(ILifeCycleAware.class);
        if (r6 == null) goto L12;
        if (r5 != null) goto L10;
        r5 = "unknown";
    L10:
        r6.onEndSession(r5);
        return;
    L12:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // yr1.d
    public final e j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new e(r2);
    }

    @Override // yr1.d
    public final void k(DataCenter r3) {
        com.bytedance.android.livesdk.service.f r0 = TTLiveSDKContext.getHostService();
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.user.f r1 = r0.h();
    L6:
        if (r3 == null) goto L9;
        r3.put("data_user_center", r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // yr1.d
    public final void registerLiveLifeCycleListener(IHostAppMonitorListener r2) {
        IHostApp r0 = jc1.k.f(IHostApp.class);
        if (r0 == null) goto L6;
        r0.registerLiveLifeCycleListener(r2);
        return;
    }

    @Override // yr1.d
    public final void s(FragmentActivity r2) {
        WeakReference r0 = z2.a;
        if (r2 == null) goto L7;
        z2.a = new WeakReference(r2);
        return;
    }

    @Override // yr1.d
    public final void updateAnimatedFrameScheduler(boolean r2) {
        TTLiveSDKContext.getHostService().a.frescoHelper().updateAnimatedFrameScheduler(true);
    }

    @Override // yr1.d
    public final void a(Bundle r1, DataCenter r2) {
        b2.b(r1, r2);
    }

    @Override // yr1.d
    public final DataCenter c(DataCenter r2, long r3) {
        RoomContext.Companion.getClass();
        RoomContext r4 = RoomContext.a.a(r2, r3);
        if (r4 == null) goto L9;
        com.bytedance.live.datacontext.n r5 = r4.getWidgetManager();
        if (r5 == null) goto L9;
        RecyclableWidgetManager r6 = (RecyclableWidgetManager) r5.getValue();
        if (r6 == null) goto L9;
        return ((WidgetManager) r6).dataCenter;
    L9:
        return null;
    }

    @Override // yr1.d
    public final void h(Bundle r1, Bundle r2) {
        b2.a(r1, r2);
    }

    @Override // yr1.d
    public final void q(Context r3, String r4, String r5) {
        if (com.bytedance.android.livesdk.config.b2.a.getValue().booleanValue() == false) goto L7;
        if (r3 == null) goto L8;
        DebugUtils.showDebugInfoDialog(r3, "入口来源参数", "enterFromMerge=" + r4 + " enterMethod=" + r5);
        return;
    L8:
        return;
    }
}
