package com.bytedance.android.annie.container.dialog;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b7.b {
    public final /* synthetic */ b7.b a;
    public final /* synthetic */ b7.b b;
    public final /* synthetic */ AnnieDialog c;

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
    public final void onContainerError(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        this.a.onContainerError(r10, r11, r12);
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
    public final void onLoadSuccess(View r10) {
        this.a.onLoadSuccess(r10);
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
    public final void onPrepareComponentEnd() {
        this.a.onPrepareComponentEnd();
    }

    @Override // b7.b
    public final void onPrepareComponentStart() {
        this.a.onPrepareComponentStart();
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

    public a(b7.b r1, AnnieDialog r10) {
        this.b = r1;
        this.c = r10;
        this.a = r1;
    }

    @Override // b7.b
    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        boolean r12 = this.b.onFallback(r10, r11);
        if (r12 == false) goto L12;
        this.c.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L12;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L12:
        if (this.c.getDialog() == null) goto L14;
        this.c.U90(true);
    L14:
        return r12;
    }

    @Override // b7.b
    public final void onLoadStart(View r10, boolean r11) {
        this.b.onLoadStart(r10, r11);
        if (this.c.getDialog() == null) goto L10;
        AnnieDialog r12 = this.c;
        PopupHybridParamVoNew r13 = r12.e;
        if (r13 == null) goto L7;
        boolean r14 = r13.P2();
    L8:
        r12.U90(r14);
        return;
    L7:
        r14 = true;
        goto L8
    }

    @Override // b7.b
    public final void onLoadFail(View r10, String r11, String r12) {
        this.b.onLoadFail(r10, r11, r12);
        if (this.c.getDialog() == null) goto L10;
        AnnieDialog r13 = this.c;
        PopupHybridParamVoNew r14 = r13.e;
        if (r14 == null) goto L7;
        boolean r15 = r14.P2();
    L8:
        r13.U90(r15);
        return;
    L7:
        r15 = true;
        goto L8
    }
}
