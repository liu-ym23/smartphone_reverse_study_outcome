package kg;

import android.view.View;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import ti.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements pd.c {
    public final e a;

    @Override // pd.c
    public final void onBeforeGlobalPropsInitialize() {
        this.a.onBeforeGlobalPropsInitialize();
    }

    @Override // pd.c
    public final void onBeforeInitialPropsInitialize() {
        this.a.onBeforeInitialPropsInitialize();
    }

    @Override // pd.c
    public final void onBeforeJsbRegister() {
        this.a.onBeforeJsbRegister();
    }

    @Override // pd.c
    public final void onBeforeOpenContainer() {
        this.a.onBeforeOpenContainer();
    }

    @Override // pd.c
    public final void onContainerInitEnd() {
        this.a.onContainerInitEnd();
    }

    @Override // pd.c
    public final void onContainerInitStart() {
        this.a.onContainerInitStart();
    }

    @Override // pd.c
    public final void onGlobalPropsInitialized() {
        this.a.onGlobalPropsInitialized();
    }

    @Override // pd.c
    public final void onInitialPropsInitialized() {
        this.a.onInitialPropsInitialized();
    }

    @Override // pd.c
    public final void onJsbRegistered() {
        this.a.onJsbRegistered();
    }

    @Override // pd.c
    public final void onLynxEnvInitialized() {
        this.a.onLynxEnvInitialized();
    }

    @Override // pd.c
    public final void onPrepareComponentEnd() {
        this.a.onPrepareComponentEnd();
    }

    @Override // pd.c
    public final void onPrepareComponentStart() {
        this.a.onPrepareComponentStart();
    }

    @Override // pd.c
    public final void onPrepareInitDataEnd() {
        this.a.onPrepareInitDataEnd();
    }

    @Override // pd.c
    public final void onPrepareTemplateEnd() {
        this.a.onPrepareTemplateEnd();
    }

    @Override // pd.c
    public final void onPrepareTemplateStart() {
        this.a.onPrepareTemplateStart();
    }

    @Override // pd.c
    public final void onRelease() {
        this.a.onRelease();
    }

    public c(e r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        this.a = r10;
    }

    @Override // pd.c
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        this.a.onBeforeCreateRenderData(r10);
    }

    @Override // pd.c
    public final void onBeforeLynxEnvInitialize(boolean r10) {
        this.a.onBeforeLynxEnvInitialize(r10);
    }

    @Override // pd.c
    public final void onLoadSuccess(View r10) {
        this.a.onLoadSuccess(r10);
    }

    @Override // pd.c
    public final void onAttachView(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        this.a.onAttachView(r10, r11);
    }

    @Override // pd.c
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        this.a.onCreateRenderData(r10, r11);
    }

    @Override // pd.c
    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        this.a.onFallback(r10, r11);
        return false;
    }

    @Override // pd.c
    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        this.a.onInnerFallback(r10, r11);
    }

    @Override // pd.c
    public final void onLoadStart(View r10, boolean r11) {
        this.a.onLoadStart(r10, r11);
    }

    @Override // pd.c
    public final void onContainerError(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        this.a.onContainerError(r10, r11, r12);
    }

    @Override // pd.c
    public final void onLoadFail(View r10, String r11, String r12) {
        this.a.onLoadFail(r10, r11, r12);
    }

    @Override // pd.c
    public final void onPrepareInitDataStart(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "fallbackUrl");
        this.a.onPrepareInitDataStart(r10, r11, r12);
    }
}
