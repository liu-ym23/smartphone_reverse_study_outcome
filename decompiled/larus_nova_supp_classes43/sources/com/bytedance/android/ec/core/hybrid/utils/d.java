package com.bytedance.android.ec.core.hybrid.utils;

import android.view.View;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements pd.c {
    public d() {
    }

    @Override // pd.c
    public final void onAttachView(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
    }

    @Override // pd.c
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
    }

    @Override // pd.c
    public final void onBeforeGlobalPropsInitialize() {
    }

    @Override // pd.c
    public final void onBeforeInitialPropsInitialize() {
    }

    @Override // pd.c
    public final void onBeforeJsbRegister() {
    }

    @Override // pd.c
    public final void onBeforeLynxEnvInitialize(boolean r1) {
    }

    @Override // pd.c
    public final void onBeforeOpenContainer() {
    }

    @Override // pd.c
    public final void onContainerError(View r1, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
    }

    @Override // pd.c
    public final void onContainerInitEnd() {
    }

    @Override // pd.c
    public final void onContainerInitStart() {
    }

    @Override // pd.c
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
    }

    @Override // pd.c
    public final boolean onFallback(int r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
        return true;
    }

    @Override // pd.c
    public final void onGlobalPropsInitialized() {
    }

    @Override // pd.c
    public final void onInitialPropsInitialized() {
    }

    @Override // pd.c
    public final void onInnerFallback(int r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
    }

    @Override // pd.c
    public final void onJsbRegistered() {
    }

    @Override // pd.c
    public final void onLoadFail(View r1, String r10, String r11) {
    }

    @Override // pd.c
    public final void onLoadStart(View r1, boolean r10) {
    }

    @Override // pd.c
    public final void onLoadSuccess(View r1) {
    }

    @Override // pd.c
    public final void onLynxEnvInitialized() {
    }

    @Override // pd.c
    public final void onPrepareComponentEnd() {
    }

    @Override // pd.c
    public final void onPrepareComponentStart() {
    }

    @Override // pd.c
    public final void onPrepareInitDataEnd() {
    }

    @Override // pd.c
    public final void onPrepareInitDataStart(String r1, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r10, "fallbackUrl");
    }

    @Override // pd.c
    public final void onPrepareTemplateEnd() {
    }

    @Override // pd.c
    public final void onPrepareTemplateStart() {
    }

    @Override // pd.c
    public final void onRelease() {
    }
}
