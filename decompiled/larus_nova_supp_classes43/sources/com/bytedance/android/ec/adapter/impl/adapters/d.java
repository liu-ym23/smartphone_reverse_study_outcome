package com.bytedance.android.ec.adapter.impl.adapters;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.impl.converter.i;
import com.bytedance.android.ec.adapter.impl.converter.k;
import com.bytedance.android.ec.adapter.impl.converter.l;
import com.bytedance.android.ec.adapter.impl.converter.m;
import com.bytedance.android.ec.adapter.impl.converter.n;
import com.bytedance.android.ec.adapter.impl.utils.RoomStateExtensionsKt;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements ISaasLiveRoomController {
    public final rd.a a;

    public static final class a {
    }

    static {
    }

    public final String businessType() {
        this.a.businessType();
        return "ECLiveRoomControllerAdapter";
    }

    public final void onRoomVisible() {
        this.a.onRoomVisible();
    }

    public final void onActivityCreated() {
        ISaasLiveRoomController.DefaultImpls.onActivityCreated(this);
        this.a.onActivityCreated();
    }

    public final void onCreate() {
        ISaasLiveRoomController.DefaultImpls.onCreate(this);
        this.a.onCreate();
    }

    public final void onDestroy() {
        ISaasLiveRoomController.DefaultImpls.onDestroy(this);
        this.a.onDestroy();
    }

    public final void onDestroyView() {
        ISaasLiveRoomController.DefaultImpls.onDestroyView(this);
        this.a.onDestroyView();
    }

    public final void onEnterRoomPrepared() {
        ISaasLiveRoomController.DefaultImpls.onEnterRoomPrepared(this);
        this.a.onEnterRoomPrepared();
    }

    public final void onExitRoom() {
        ISaasLiveRoomController.DefaultImpls.onExitRoom(this);
        this.a.onExitRoom();
        Iterator<T> r0 = com.bytedance.android.ec.adapter.impl.converter.c.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).clear();
        goto L4
    }

    public final void onStart() {
        ISaasLiveRoomController.DefaultImpls.onStart(this);
        this.a.onStart();
    }

    public final void onStop() {
        ISaasLiveRoomController.DefaultImpls.onStop(this);
        this.a.onStop();
    }

    public final void onWidgetLoadFinished() {
        ISaasLiveRoomController.DefaultImpls.onWidgetLoadFinished(this);
        this.a.onWidgetLoadFinished();
    }

    public final void onFirstFrame() {
        ISaasLiveRoomController.DefaultImpls.onFirstFrame(this);
    }

    public final void onP0WidgetLoadFinished() {
        ISaasLiveRoomController.DefaultImpls.onP0WidgetLoadFinished(this);
    }

    public d(rd.a r10) {
        Intrinsics.checkNotNullParameter(r10, "realController");
        this.a = r10;
    }

    public final void onContextAttached(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a.onContextAttached(r10);
        Integer r1 = ue.b.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        if (ue.b.a == null) goto L6;
        return;
    L6:
        if ((r10.getApplicationContext() instanceof Application) == false) goto L15;
        ue.b.a = Integer.valueOf(r10.hashCode());
        Context r11 = r10.getApplicationContext();
        if (r11 == null) goto L13;
        ((Application) r11).registerActivityLifecycleCallbacks(new ue.a());
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "functionHandler");
        rd.a r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2EC");
        r0.f(k.b.a(r10));
    }

    public final void onMessageHandlerAttached(ILiveRoomMessageHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "messageHandler");
        rd.a r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2EC");
        r0.d(l.b.a(r10));
    }

    public final void onRoomEventHubAttached(IRoomEventHub r10) {
        Intrinsics.checkNotNullParameter(r10, "eventHub");
        ISaasLiveRoomController.DefaultImpls.onRoomEventHubAttached(this, r10);
        rd.a r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2EC");
        r0.e(m.b.a(r10));
    }

    public final void onRoomStatusChanged(IRoomState r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        rd.a r0 = this.a;
        com.bytedance.android.ec.adapter.api.state.a r11 = RoomStateExtensionsKt.a(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r0.a(r11);
    }

    public final void onSpecificViewAttached(String r10) {
        Intrinsics.checkNotNullParameter(r10, "viewClassName");
        ISaasLiveRoomController.DefaultImpls.onSpecificViewAttached(this, r10);
    }

    public final void onSpecificWidgetLoadFinished(String r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetClassName");
        ISaasLiveRoomController.DefaultImpls.onSpecificWidgetLoadFinished(this, r10);
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L5;
        Boolean r11 = (Boolean) r1.getLiveSettingsValue("ecom_live_specific_widget_load_fix", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L10;
        this.a.onSpecificWidgetLoadFinished(r10);
        return;
    L10:
        if (Intrinsics.areEqual(r10, com.bytedance.android.ec.core.event.a.VALUE_VIRTUAL_PRODUCT) == false) goto L14;
        this.a.onSpecificWidgetLoadFinished(r10);
        return;
    L14:
        return;
    L5:
        r11 = null;
        goto L7
    }

    public final void onUserStatusChanged(UserState r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        ISaasLiveRoomController.DefaultImpls.onUserStatusChanged(this, r10);
    }

    public final void onVideoEventHubAttached(IVideoEventHub r10) {
        Intrinsics.checkNotNullParameter(r10, "eventHub");
        ISaasLiveRoomController.DefaultImpls.onVideoEventHubAttached(this, r10);
    }

    public final void onViewHandlerAttached(ILiveRoomViewHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "handler");
        rd.a r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2EC");
        r0.b(n.b.a(r10));
    }

    public final void onLiveFinished(Context r10, IRoomState r11) {
        ISaasLiveRoomController.DefaultImpls.onLiveFinished(this, r10, r11);
        this.a.c(r10, RoomStateExtensionsKt.a(r11));
    }

    public final void onSpecificBehaviorLoad(String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "behaviorClassName");
        this.a.onSpecificBehaviorLoad(r10, r11, r12, "");
    }

    public final void onSpecificBehaviorUnload(String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "behaviorClassName");
        this.a.onSpecificBehaviorUnload(r10, r11, r12);
    }

    public final void onSpecificBehaviorLoad(String r10, boolean r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r13, "extraData");
        this.a.onSpecificBehaviorLoad(r10, r11, r12, r13);
    }
}
