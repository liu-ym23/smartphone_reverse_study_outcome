package com.bytedance.android.annie.container.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements b7.b {
    public final /* synthetic */ b7.b a;
    public final /* synthetic */ b7.b b;
    public final /* synthetic */ AnnieFragment c;

    @Override // b7.b
    public final void onAttachView(View r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        this.a.onAttachView(r10, r11, r12);
    }

    @Override // b7.b
    public final void onAttachedToWindow(String r10) {
        this.a.onAttachedToWindow(r10);
    }

    @Override // b7.b
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        this.a.onBeforeCreateRenderData(r10);
    }

    @Override // b7.b
    public final void onBeforeGlobalPropsInitialize() {
        this.a.onBeforeGlobalPropsInitialize();
    }

    @Override // b7.b
    public final void onBeforeInitialPropsInitialize() {
        this.a.onBeforeInitialPropsInitialize();
    }

    @Override // b7.b
    public final void onBeforeJsbRegister() {
        this.a.onBeforeJsbRegister();
    }

    @Override // b7.b
    public final void onBeforeLoadRequest(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "resType");
        Intrinsics.checkNotNullParameter(r12, "type");
        this.a.onBeforeLoadRequest(r10, r11, r12, r13);
    }

    @Override // b7.b
    public final void onBeforeLynxEnvInitialize(boolean r10) {
        this.a.onBeforeLynxEnvInitialize(r10);
    }

    @Override // b7.b
    public final void onBeforeOpenContainer() {
        this.a.onBeforeOpenContainer();
    }

    @Override // b7.b
    public final void onCardLoadStart() {
        this.a.onCardLoadStart();
    }

    @Override // b7.b
    public final void onContainerInitEnd() {
        this.a.onContainerInitEnd();
    }

    @Override // b7.b
    public final void onContainerInitStart() {
        this.a.onContainerInitStart();
    }

    @Override // b7.b
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        this.a.onCreateRenderData(r10, r11);
    }

    @Override // b7.b
    public final void onEngineLoadEnd() {
        this.a.onEngineLoadEnd();
    }

    @Override // b7.b
    public final void onEngineLoadStart() {
        this.a.onEngineLoadStart();
    }

    @Override // b7.b
    public final void onGlobalPropsInitialized() {
        this.a.onGlobalPropsInitialized();
    }

    @Override // b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        this.a.onInit(r10);
    }

    @Override // b7.b
    public final void onInitialPropsInitialized() {
        this.a.onInitialPropsInitialized();
    }

    @Override // b7.b
    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        this.a.onInnerFallback(r10, r11);
    }

    @Override // b7.b
    public final void onJsbRegistered() {
        this.a.onJsbRegistered();
    }

    @Override // b7.b
    public final void onLoadFail(View r10, String r11, String r12) {
        this.a.onLoadFail(r10, r11, r12);
    }

    @Override // b7.b
    public final void onLoadStart(View r10, boolean r11) {
        this.a.onLoadStart(r10, r11);
    }

    @Override // b7.b
    public final void onLynxEnvInitialized() {
        this.a.onLynxEnvInitialized();
    }

    @Override // b7.b
    public final void onLynxFirstScreen() {
        this.a.onLynxFirstScreen();
    }

    @Override // b7.b
    public final void onPrepareInitDataEnd() {
        this.a.onPrepareInitDataEnd();
    }

    @Override // b7.b
    public final void onPrepareInitDataStart(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "fallbackUrl");
        this.a.onPrepareInitDataStart(r10, r11, r12);
    }

    @Override // b7.b
    public final void onPrepareTemplateEnd(boolean r10) {
        this.a.onPrepareTemplateEnd(r10);
    }

    @Override // b7.b
    public final void onPrepareTemplateEnd(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "resFrom");
        this.a.onPrepareTemplateEnd(r10, r11);
    }

    @Override // b7.b
    public final void onPrepareTemplateStart() {
        this.a.onPrepareTemplateStart();
    }

    @Override // b7.b
    public final void onRelease() {
        this.a.onRelease();
    }

    @Override // b7.b
    public final void onPrepareComponentEnd() {
        this.b.onPrepareComponentEnd();
        AnnieFragmentManager.d(this.c.containerId(), this.c);
    }

    @Override // b7.b
    public final void onPrepareComponentStart() {
        this.b.onPrepareComponentStart();
        AnnieFragmentManager.f(this.c.containerId(), null, 6);
    }

    @Override // b7.b
    public final void onLoadSuccess(View r10) {
        this.b.onLoadSuccess(r10);
        AnnieFragment r11 = this.c;
        int r0 = AnnieFragment.H1;
        r11.ea0();
    }

    public d(b7.b r1, AnnieFragment r10) {
        this.b = r1;
        this.c = r10;
        this.a = r1;
    }

    @Override // b7.b
    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        boolean r0 = this.b.onFallback(r10, r11);
        if (r0 == false) goto L5;
    L16:
        com.bytedance.android.annie.param.a r1 = this.c.f;
        if (r1 == null) goto L21;
        x8.b r12 = r1.d;
        if (r12 == null) goto L21;
        r12.e("AnnieFragment", "onFallback: errorCode=" + r10 + ", errorMessage=" + r11 + ", isFallback=" + r0);
    L21:
        return r0;
    L5:
        if (AnnieConfigSettingKeys.TRY_FIX_BG_COLOR_ON_RELOAD.a().booleanValue() == true) goto L9;
        View r13 = this.c.h;
        if (r13 == null) goto L9;
        r13.setBackgroundColor(ColorProtector.parseColor(IHostContextDepend.SKIN_TYPE_WHITE));
    L9:
        v7.b r14 = this.c.w;
        if (r14 == null) goto L12;
        r14.c();
    L12:
        FrameLayout r15 = (FrameLayout) this.c.S90(2131374651);
        if (r15 == null) goto L16;
        r15.setVisibility(8);
        goto L16
    }

    @Override // b7.b
    public final void onContainerError(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        if (r11 != 500) goto L5;
        this.c.close();
    L5:
        this.b.onContainerError(r10, r11, r12);
    }
}
