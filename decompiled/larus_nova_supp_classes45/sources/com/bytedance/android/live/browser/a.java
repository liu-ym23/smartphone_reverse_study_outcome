package com.bytedance.android.live.browser;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTraceSchemaMonitor;
import com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends b7.a {
    public final IExternalAnnieLifecycle a;

    public final void onBeforeGlobalPropsInitialize() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeGlobalPropsInitialize();
        return;
    }

    public final void onBeforeInitialPropsInitialize() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeInitialPropsInitialize();
        return;
    }

    public final void onBeforeJsbRegister() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeJsbRegister();
        return;
    }

    public final void onBeforeOpenContainer() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeOpenContainer();
        return;
    }

    public final void onContainerInitEnd() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onContainerInitEnd();
        return;
    }

    public final void onContainerInitStart() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onContainerInitStart();
        return;
    }

    public final void onGlobalPropsInitialized() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onGlobalPropsInitialized();
        return;
    }

    public final void onInitialPropsInitialized() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onInitialPropsInitialized();
        return;
    }

    public final void onJsbRegistered() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onJsbRegistered();
        return;
    }

    public final void onLynxEnvInitialized() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onLynxEnvInitialized();
        return;
    }

    public final void onPrepareComponentEnd() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPrepareComponentEnd();
        return;
    }

    public final void onPrepareComponentStart() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPrepareComponentStart();
        return;
    }

    public final void onPrepareInitDataEnd() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPrepareInitDataEnd();
        return;
    }

    public final void onPrepareTemplateStart() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPrepareTemplateStart();
        return;
    }

    public final void onRelease() {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L5;
        r0.onRelease();
    L5:
        y50.i.m("annie", null, null, "AnnieLifecycleProxy.onRelease()", 0, null, null, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
    }

    public a(IExternalAnnieLifecycle r1) {
        this.a = r1;
    }

    public final void onBeforeCreateRenderData(View r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridView");
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeCreateRenderData(r2);
        return;
    }

    public final void onBeforeLynxEnvInitialize(boolean r2) {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onBeforeLynxEnvInitialize(r2);
        return;
    }

    public final void onLoadSuccess(View r17) {
        IExternalAnnieLifecycle r1 = this.a;
        if (r1 == null) goto L5;
        r1.onLoadSuccess(r17);
    L5:
        BaseMonitor.MonitorEventModule r2 = BaseMonitor.MonitorEventModule.HYBRID;
        LiveTraceSchemaMonitor.Status r3 = LiveTraceSchemaMonitor.Status.SUCCESS;
        JSONObject r7 = new JSONObject();
        r7.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.ANNIE);
        Unit r4 = Unit.INSTANCE;
        LiveTraceSchemaMonitor.l(r2, r3, "Annie页面加载成功", "", "AnnieLifecycleProxy", r7);
        y50.i.m("annie", null, null, "AnnieLifecycleProxy.onLoadSuccess()", 0, null, null, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
    }

    public final void onPrepareTemplateEnd(boolean r1) {
        IExternalAnnieLifecycle r2 = this.a;
        if (r2 == null) goto L6;
        r2.onPrepareTemplateEnd();
        return;
    }

    public final void onCreateRenderData(View r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "hybridView");
        Intrinsics.checkNotNullParameter(r3, "stateKeys");
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L6;
        r0.onCreateRenderData(r2, r3);
        return;
    }

    public final boolean onFallback(int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        BaseMonitor.MonitorEventModule r2 = BaseMonitor.MonitorEventModule.HYBRID;
        LiveTraceSchemaMonitor.Status r3 = LiveTraceSchemaMonitor.Status.HYBRID_ANNIE_LOAD_FAIL;
        JSONObject r7 = new JSONObject();
        r7.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.ANNIE);
        Unit r1 = Unit.INSTANCE;
        LiveTraceSchemaMonitor.l(r2, r3, "Annie页面加载失败：onFallback", "", "AnnieLifecycleProxy", r7);
        JSONObject r8 = new JSONObject();
        r8.put("errorCode", r11);
        y50.i.m("annie", null, null, "AnnieLifecycleProxy.onFallback()", 1, r12, r8, 6);
        IExternalAnnieLifecycle r4 = this.a;
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.onFallback(r11, r12);
    }

    public final void onInnerFallback(int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L5;
        r0.onInnerFallback(r11, r12);
    L5:
        JSONObject r7 = new JSONObject();
        r7.put("errorCode", r11);
        Unit r13 = Unit.INSTANCE;
        y50.i.m("annie", null, null, "AnnieLifecycleProxy#onInnerFallback()", 1, r12, r7, 6);
    }

    public final void onLoadStart(View r11, boolean r12) {
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLoadStart(r11, r12);
    L5:
        y50.i.m("annie", null, null, "AnnieLifecycleProxy.onLoadStart()", 0, null, null, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
    }

    public final void onAttachView(View r1, IHybridComponent.HybridType r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "hybridType");
        IExternalAnnieLifecycle r4 = this.a;
        if (r4 == null) goto L6;
        r4.onAttachView(r1, r2.getHybridName());
        return;
    }

    public final void onContainerError(View r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "errorMessage");
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L5;
        r0.onContainerError(r11, r12, r13);
    L5:
        JSONObject r7 = new JSONObject();
        r7.put("errorCode", r12);
        Unit r14 = Unit.INSTANCE;
        y50.i.m("annie", null, null, "AnnieLifecycleProxy.onFallback()", 1, r13, r7, 6);
    }

    public final void onLoadFail(View r11, String r12, String r13) {
        String r4 = "";
        if (r13 != null) goto L5;
        String r5 = "";
    L6:
        JSONObject r7 = new JSONObject();
        if (r12 == null) goto L10;
        r4 = r12;
    L10:
        r7.put(LiveSlardarConstants.EXTRA_KEY_URL, r4);
        Unit r6 = Unit.INSTANCE;
        y50.i.m("annie", null, null, "AnnieLifecycleProxy.onLoadFail()", 1, r5, r7, 6);
        IExternalAnnieLifecycle r0 = this.a;
        if (r0 == null) goto L14;
        r0.onLoadFail(r11, r12, r13);
        return;
    L14:
        return;
    L5:
        r5 = r13;
        goto L6
    }

    public final void onPrepareInitDataStart(String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "scheme");
        Intrinsics.checkNotNullParameter(r12, "fallbackUrl");
        IExternalAnnieLifecycle r1 = this.a;
        if (r1 == null) goto L5;
        r1.onPrepareInitDataStart(r11, r12, r13);
    L5:
        JSONObject r8 = new JSONObject();
        r8.put("fallbackUrl", r12);
        r8.put("isFallback", r13);
        Unit r14 = Unit.INSTANCE;
        y50.i.m("annie", r11, null, "AnnieLifecycleProxy.onPrepareInitDataStart()", r13 ? 1 : 0, null, r8, 36);
    }
}
